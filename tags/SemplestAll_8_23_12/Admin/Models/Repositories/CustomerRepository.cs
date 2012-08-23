using System.Linq;
using Semplest.SharedResources.Encryption;
using Semplest.SharedResources.Services;
using SemplestModel;
using System;

namespace Semplest.Admin.Models.Repositories
{
    public class CustomerRepository : ICustomerRepository
    {

        public void AddCustomer(CustomerAccountWithEmployeeModel m)
        {
            try
            {
                SemplestModel.Semplest dbcontext = new SemplestModel.Semplest();
                //BillType bt = dbcontext.BillTypes.First(p => p.BillType1 == "Flat Fee"); // --- feees --- !!!
                //revisit 
                ProductGroupCycleType pgct = dbcontext.ProductGroupCycleTypes.First(p => p.ProductGroupCycleType1 == "Product Group Cycle 30");

                var c = new Customer
                            { 
                                Name = m.CustomerAccount.Customer,
                                BillTypeFK = m.SelectedBillTypeID,
                                ProductGroupCycleType = pgct,
                                 PercentOfMedia=m.CustomerAccount.PercentMedia,
                                 ServiceFee= m.CustomerAccount.ServiceFee,
                                  InternalCustomerId= m.CustomerAccount.internalID,
                                PromotionFeeAmount = m.CustomerAccount.PromotionFeeAmount,
                                CreditLimit=m.CustomerAccount.CreditLimit,
                                PromotionFeeOverride=m.CustomerAccount.PromotionFeeOverride,
                                CreatedDate = DateTime.Now 
                            };

                dbcontext.Customers.Add(c);

                var u = new User
                            {
                                Customer = c,
                                Email = m.CustomerAccount.Email,
                                FirstName = m.CustomerAccount.FirstName,
                                LastName = m.CustomerAccount.LastName,
                                MiddleInitial = m.CustomerAccount.MiddleInitial,
                                IsActive = m.CustomerAccount.isActive,
                                CreatedDate = DateTime.Now
                            };
                dbcontext.Users.Add(u);

                var r = dbcontext.Roles.First(p => p.RolePK == m.SelectedRoleID);
                var ura = new UserRolesAssociation { Role = r, User = u };
                dbcontext.UserRolesAssociations.Add(ura);
                AesEncyrption ae = AesEncyrption.getInstance();
                var encryptedPassword = ae.EncryptString(m.CustomerAccount.UserPassword);
                var cr = new Credential
                             { 
                                 User = u,
                                 UsersFK = u.UserPK,
                                 Username = m.CustomerAccount.UserID,
                                 Password = encryptedPassword
                             };
                dbcontext.Credentials.Add(cr);
                PhoneType pt = dbcontext.PhoneTypes.First(p => p.PhoneType1 == "Business"); // --- phone types --- !!!!
                var ph = new Phone {Phone1 = m.CustomerAccount.Phone, PhoneType = pt};
                dbcontext.Phones.Add(ph);
                var cpa = new CustomerPhoneAssociation {Customer = c, Phone = ph};
                dbcontext.CustomerPhoneAssociations.Add(cpa);
                var sc = dbcontext.StateCodes.First(p => p.StateAbbrPK == m.SelectedStateID);
                var at = dbcontext.AddressTypes.First(p => p.AddressType1 == "H"); // --- address types --- !!!
                var a = new Address
                            {
                                Address1 = m.CustomerAccount.Address1,
                                Address2 = m.CustomerAccount.Address2,
                                City = m.CustomerAccount.City,
                                ZipCode = m.CustomerAccount.Zip,
                                StateCode = sc
                            };
                dbcontext.Addresses.Add(a);
                var caa = new CustomerAddressAssociation {Address = a, Customer = c, AddressType = at};
                dbcontext.CustomerAddressAssociations.Add(caa);
                var cn = new CustomerNote {Customer = c, Note = m.CustomerAccount.CustomerNote};
                dbcontext.CustomerNotes.Add(cn);
                //don't add if not assigned
                if (m.SelectedRepID != -1)
                {
                    var addrep = new EmployeeCustomerAssociation { Customer = c, EmployeeFK = m.SelectedRepID };
                    dbcontext.EmployeeCustomerAssociations.Add(addrep);
                }
                //don't add if not assigned
                if (m.SelectedSalesPersonID != -1)
                {
                    var addsales = new EmployeeCustomerAssociation { Customer = c, EmployeeFK = m.SelectedSalesPersonID };
                    dbcontext.EmployeeCustomerAssociations.Add(addsales);
                }
                CustomerHierarchy ch = null;
                if (m.SelectedParentID == -1) //set parent
                {
                    ch = new CustomerHierarchy {CustomerFK = c.CustomerPK, CustomerParentFK = null};
                    dbcontext.CustomerHierarchies.Add(ch);
                }
                else if (m.SelectedParentID == 0) //set self -- single user
                {
                    ch = new CustomerHierarchy {CustomerFK = c.CustomerPK, CustomerParentFK = c.CustomerPK};
                    dbcontext.CustomerHierarchies.Add(ch);
                }
                else //assign a parent
                {
                    ch = new CustomerHierarchy {CustomerFK = c.CustomerPK, CustomerParentFK = m.SelectedParentID};
                    dbcontext.CustomerHierarchies.Add(ch);
                }
                dbcontext.SaveChanges();

                SendAccountActivationEmail(u.UserPK);

            }
            catch (Exception ex)
            {
                Semplest.SharedResources.Helpers.ExceptionHelper.LogException(ex);
            }
        }

        public bool DoesUserExit(string userId)
        {
            var dbcontext = new SemplestModel.Semplest();
            //check if userid has been taken by other users
            return  (from c in dbcontext.Credentials
                           where c.Username.Equals(userId)
                           select c).Any();
        }

        private bool SendAccountActivationEmail(int userId)
        {
            var scw = new ServiceClientWrapper();
            return scw.SendAccountActivationEmail(userId);
        }

        public bool ValidateAccountActivationToken(string token)
        {
            var scw = new ServiceClientWrapper();
            return scw.ValidateAccountActivationToken(token);
        }



    }
}