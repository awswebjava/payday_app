package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secuser_bc extends GXWebPanel implements IGxSilentTrn
{
   public secuser_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secuser_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secuser_bc.class ));
   }

   public secuser_bc( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1M55( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1M55( ) ;
      standaloneModal( ) ;
      addRow1M55( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e111M2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z67SecUserId = A67SecUserId ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_1M0( )
   {
      beforeValidate1M55( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1M55( ) ;
         }
         else
         {
            checkExtendedTable1M55( ) ;
            if ( AnyError == 0 )
            {
               zm1M55( 14) ;
               zm1M55( 15) ;
               zm1M55( 16) ;
               zm1M55( 17) ;
               zm1M55( 18) ;
            }
            closeExtendedTableCursors1M55( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e121M2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV15WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV15WWPContext = GXv_SdtWWPContext1[0] ;
      AV9IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser_Insert", GXv_boolean3) ;
         secuser_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser_Update", GXv_boolean3) ;
         secuser_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser_Delete", GXv_boolean3) ;
         secuser_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV34Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV34Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV35GXV1 = 1 ;
         while ( AV35GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV19TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV35GXV1));
            if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CliCod") == 0 )
            {
               AV18Insert_CliCod = (int)(GXutil.lval( AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SecUserPaiCod") == 0 )
            {
               AV29Insert_SecUserPaiCod = (short)(GXutil.lval( AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "RolId") == 0 )
            {
               AV30Insert_RolId = (byte)(GXutil.lval( AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PerfilId") == 0 )
            {
               AV31Insert_PerfilId = (byte)(GXutil.lval( AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "MenuVerId") == 0 )
            {
               AV32Insert_MenuVerId = GXutil.lval( AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
            }
            AV35GXV1 = (int)(AV35GXV1+1) ;
         }
      }
   }

   public void e111M2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
   }

   public void zm1M55( int GX_JID )
   {
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         Z68SecUserName = A68SecUserName ;
         Z356SecUserPassword = A356SecUserPassword ;
         Z357SecUserEmpNom = A357SecUserEmpNom ;
         Z364SecUsuActivo = A364SecUsuActivo ;
         Z359SecUserPerName = A359SecUserPerName ;
         Z360SecUserPerLastName = A360SecUserPerLastName ;
         Z358SecUserEmpCuit = A358SecUserEmpCuit ;
         Z531SecUserTipEmpl = A531SecUserTipEmpl ;
         Z2388SecUserSal = A2388SecUserSal ;
         Z3CliCod = A3CliCod ;
         Z1923RolId = A1923RolId ;
         Z1925PerfilId = A1925PerfilId ;
         Z1928MenuVerId = A1928MenuVerId ;
         Z69SecUserPaiCod = A69SecUserPaiCod ;
      }
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 15 ) || ( GX_JID == 0 ) )
      {
         Z1924RolNombre = A1924RolNombre ;
      }
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 17 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 18 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -12 )
      {
         Z67SecUserId = A67SecUserId ;
         Z68SecUserName = A68SecUserName ;
         Z356SecUserPassword = A356SecUserPassword ;
         Z357SecUserEmpNom = A357SecUserEmpNom ;
         Z364SecUsuActivo = A364SecUsuActivo ;
         Z359SecUserPerName = A359SecUserPerName ;
         Z360SecUserPerLastName = A360SecUserPerLastName ;
         Z358SecUserEmpCuit = A358SecUserEmpCuit ;
         Z531SecUserTipEmpl = A531SecUserTipEmpl ;
         Z2388SecUserSal = A2388SecUserSal ;
         Z3CliCod = A3CliCod ;
         Z1923RolId = A1923RolId ;
         Z1925PerfilId = A1925PerfilId ;
         Z1928MenuVerId = A1928MenuVerId ;
         Z69SecUserPaiCod = A69SecUserPaiCod ;
         Z1924RolNombre = A1924RolNombre ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int4 = AV26session_CliCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
         secuser_bc.this.GXt_int4 = GXv_int5[0] ;
         AV26session_CliCod = GXt_int4 ;
      }
      GXt_boolean2 = AV28SecUsuActivo ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.getusuactivodefault(remoteHandle, context).execute( GXv_boolean3) ;
      secuser_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV28SecUsuActivo = GXt_boolean2 ;
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         A364SecUsuActivo = AV28SecUsuActivo ;
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 ) && ! (0==AV26session_CliCod) )
      {
         A3CliCod = AV26session_CliCod ;
         n3CliCod = false ;
      }
   }

   public void load1M55( )
   {
      /* Using cursor BC001M9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A67SecUserId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound55 = (short)(1) ;
         A68SecUserName = BC001M9_A68SecUserName[0] ;
         A356SecUserPassword = BC001M9_A356SecUserPassword[0] ;
         A357SecUserEmpNom = BC001M9_A357SecUserEmpNom[0] ;
         A364SecUsuActivo = BC001M9_A364SecUsuActivo[0] ;
         A359SecUserPerName = BC001M9_A359SecUserPerName[0] ;
         A360SecUserPerLastName = BC001M9_A360SecUserPerLastName[0] ;
         A358SecUserEmpCuit = BC001M9_A358SecUserEmpCuit[0] ;
         A531SecUserTipEmpl = BC001M9_A531SecUserTipEmpl[0] ;
         A1924RolNombre = BC001M9_A1924RolNombre[0] ;
         A2388SecUserSal = BC001M9_A2388SecUserSal[0] ;
         A3CliCod = BC001M9_A3CliCod[0] ;
         n3CliCod = BC001M9_n3CliCod[0] ;
         A1923RolId = BC001M9_A1923RolId[0] ;
         n1923RolId = BC001M9_n1923RolId[0] ;
         A1925PerfilId = BC001M9_A1925PerfilId[0] ;
         n1925PerfilId = BC001M9_n1925PerfilId[0] ;
         A1928MenuVerId = BC001M9_A1928MenuVerId[0] ;
         n1928MenuVerId = BC001M9_n1928MenuVerId[0] ;
         A69SecUserPaiCod = BC001M9_A69SecUserPaiCod[0] ;
         n69SecUserPaiCod = BC001M9_n69SecUserPaiCod[0] ;
         zm1M55( -12) ;
      }
      pr_default.close(7);
      onLoadActions1M55( ) ;
   }

   public void onLoadActions1M55( )
   {
      AV34Pgmname = "WWPBaseObjects.SecUser_BC" ;
   }

   public void checkExtendedTable1M55( )
   {
      nIsDirty_55 = (short)(0) ;
      standaloneModal( ) ;
      AV34Pgmname = "WWPBaseObjects.SecUser_BC" ;
      /* Using cursor BC001M10 */
      pr_default.execute(8, new Object[] {A68SecUserName, Short.valueOf(A67SecUserId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Usuario", "")}), 1, "");
         AnyError = (short)(1) ;
      }
      pr_default.close(8);
      if ( ! ( GxRegex.IsMatch(A68SecUserName,"(?:[a-z0-9!#$%&'*+/=?^_{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])") ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "Debe ser una dirección de correo válida", ""), httpContext.getMessage( "Usuario", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( (GXutil.strcmp("", A68SecUserName)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Name", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC001M11 */
      pr_default.execute(9, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(9) == 101) )
      {
         if ( ! ( (0==A3CliCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(9);
      if ( (GXutil.strcmp("", A357SecUserEmpNom)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Razón Social", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( (GXutil.strcmp("", A359SecUserPerName)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nombre", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( (GXutil.strcmp("", A360SecUserPerLastName)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Apellido", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC001M12 */
      pr_default.execute(10, new Object[] {Boolean.valueOf(n69SecUserPaiCod), Short.valueOf(A69SecUserPaiCod)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         if ( ! ( (0==A69SecUserPaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "User Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECUSERPAICOD");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(10);
      /* Using cursor BC001M13 */
      pr_default.execute(11, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         if ( ! ( (0==A1923RolId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "RolUsuario", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ROLID");
            AnyError = (short)(1) ;
         }
      }
      A1924RolNombre = BC001M13_A1924RolNombre[0] ;
      pr_default.close(11);
      /* Using cursor BC001M14 */
      pr_default.execute(12, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (0==A1923RolId) || (0==A1925PerfilId) || (0==A1928MenuVerId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "MenuVersiones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MENUVERID");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(12);
      /* Using cursor BC001M15 */
      pr_default.execute(13, new Object[] {Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         if ( ! ( (0==A1925PerfilId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Perfil", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERFILID");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(13);
   }

   public void closeExtendedTableCursors1M55( )
   {
      pr_default.close(9);
      pr_default.close(10);
      pr_default.close(11);
      pr_default.close(12);
      pr_default.close(13);
   }

   public void enableDisable( )
   {
   }

   public void getKey1M55( )
   {
      /* Using cursor BC001M16 */
      pr_default.execute(14, new Object[] {Short.valueOf(A67SecUserId)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound55 = (short)(1) ;
      }
      else
      {
         RcdFound55 = (short)(0) ;
      }
      pr_default.close(14);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC001M17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A67SecUserId)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         zm1M55( 12) ;
         RcdFound55 = (short)(1) ;
         A67SecUserId = BC001M17_A67SecUserId[0] ;
         A68SecUserName = BC001M17_A68SecUserName[0] ;
         A356SecUserPassword = BC001M17_A356SecUserPassword[0] ;
         A357SecUserEmpNom = BC001M17_A357SecUserEmpNom[0] ;
         A364SecUsuActivo = BC001M17_A364SecUsuActivo[0] ;
         A359SecUserPerName = BC001M17_A359SecUserPerName[0] ;
         A360SecUserPerLastName = BC001M17_A360SecUserPerLastName[0] ;
         A358SecUserEmpCuit = BC001M17_A358SecUserEmpCuit[0] ;
         A531SecUserTipEmpl = BC001M17_A531SecUserTipEmpl[0] ;
         A2388SecUserSal = BC001M17_A2388SecUserSal[0] ;
         A3CliCod = BC001M17_A3CliCod[0] ;
         n3CliCod = BC001M17_n3CliCod[0] ;
         A1923RolId = BC001M17_A1923RolId[0] ;
         n1923RolId = BC001M17_n1923RolId[0] ;
         A1925PerfilId = BC001M17_A1925PerfilId[0] ;
         n1925PerfilId = BC001M17_n1925PerfilId[0] ;
         A1928MenuVerId = BC001M17_A1928MenuVerId[0] ;
         n1928MenuVerId = BC001M17_n1928MenuVerId[0] ;
         A69SecUserPaiCod = BC001M17_A69SecUserPaiCod[0] ;
         n69SecUserPaiCod = BC001M17_n69SecUserPaiCod[0] ;
         Z67SecUserId = A67SecUserId ;
         sMode55 = Gx_mode ;
         Gx_mode = "DSP" ;
         load1M55( ) ;
         if ( AnyError == 1 )
         {
            RcdFound55 = (short)(0) ;
            initializeNonKey1M55( ) ;
         }
         Gx_mode = sMode55 ;
      }
      else
      {
         RcdFound55 = (short)(0) ;
         initializeNonKey1M55( ) ;
         sMode55 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode55 ;
      }
      pr_default.close(15);
   }

   public void getEqualNoModal( )
   {
      getKey1M55( ) ;
      if ( RcdFound55 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_1M0( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency1M55( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001M18 */
         pr_default.execute(16, new Object[] {Short.valueOf(A67SecUserId)});
         if ( (pr_default.getStatus(16) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecUser"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(16) == 101) || ( GXutil.strcmp(Z68SecUserName, BC001M18_A68SecUserName[0]) != 0 ) || ( GXutil.strcmp(Z356SecUserPassword, BC001M18_A356SecUserPassword[0]) != 0 ) || ( GXutil.strcmp(Z357SecUserEmpNom, BC001M18_A357SecUserEmpNom[0]) != 0 ) || ( Z364SecUsuActivo != BC001M18_A364SecUsuActivo[0] ) || ( GXutil.strcmp(Z359SecUserPerName, BC001M18_A359SecUserPerName[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z360SecUserPerLastName, BC001M18_A360SecUserPerLastName[0]) != 0 ) || ( Z358SecUserEmpCuit != BC001M18_A358SecUserEmpCuit[0] ) || ( GXutil.strcmp(Z531SecUserTipEmpl, BC001M18_A531SecUserTipEmpl[0]) != 0 ) || ( GXutil.strcmp(Z2388SecUserSal, BC001M18_A2388SecUserSal[0]) != 0 ) || ( Z3CliCod != BC001M18_A3CliCod[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1923RolId != BC001M18_A1923RolId[0] ) || ( Z1925PerfilId != BC001M18_A1925PerfilId[0] ) || ( Z1928MenuVerId != BC001M18_A1928MenuVerId[0] ) || ( Z69SecUserPaiCod != BC001M18_A69SecUserPaiCod[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"SecUser"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1M55( )
   {
      beforeValidate1M55( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1M55( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1M55( 0) ;
         checkOptimisticConcurrency1M55( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1M55( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1M55( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001M19 */
                  pr_default.execute(17, new Object[] {A68SecUserName, A356SecUserPassword, A357SecUserEmpNom, Boolean.valueOf(A364SecUsuActivo), A359SecUserPerName, A360SecUserPerLastName, Long.valueOf(A358SecUserEmpCuit), A531SecUserTipEmpl, A2388SecUserSal, Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod), Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), Boolean.valueOf(n69SecUserPaiCod), Short.valueOf(A69SecUserPaiCod)});
                  /* Retrieving last key number assigned */
                  /* Using cursor BC001M20 */
                  pr_default.execute(18);
                  A67SecUserId = BC001M20_A67SecUserId[0] ;
                  pr_default.close(18);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load1M55( ) ;
         }
         endLevel1M55( ) ;
      }
      closeExtendedTableCursors1M55( ) ;
   }

   public void update1M55( )
   {
      beforeValidate1M55( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1M55( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1M55( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1M55( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1M55( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001M21 */
                  pr_default.execute(19, new Object[] {A68SecUserName, A356SecUserPassword, A357SecUserEmpNom, Boolean.valueOf(A364SecUsuActivo), A359SecUserPerName, A360SecUserPerLastName, Long.valueOf(A358SecUserEmpCuit), A531SecUserTipEmpl, A2388SecUserSal, Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod), Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), Boolean.valueOf(n69SecUserPaiCod), Short.valueOf(A69SecUserPaiCod), Short.valueOf(A67SecUserId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
                  if ( (pr_default.getStatus(19) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecUser"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1M55( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel1M55( ) ;
      }
      closeExtendedTableCursors1M55( ) ;
   }

   public void deferredUpdate1M55( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1M55( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1M55( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1M55( ) ;
         afterConfirm1M55( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1M55( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001M22 */
               pr_default.execute(20, new Object[] {Short.valueOf(A67SecUserId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode55 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1M55( ) ;
      Gx_mode = sMode55 ;
   }

   public void onDeleteControls1M55( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV34Pgmname = "WWPBaseObjects.SecUser_BC" ;
         /* Using cursor BC001M23 */
         pr_default.execute(21, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId)});
         A1924RolNombre = BC001M23_A1924RolNombre[0] ;
         pr_default.close(21);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC001M24 */
         pr_default.execute(22, new Object[] {Short.valueOf(A67SecUserId)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Sec User Role", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
      }
   }

   public void endLevel1M55( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(16);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1M55( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart1M55( )
   {
      /* Scan By routine */
      /* Using cursor BC001M25 */
      pr_default.execute(23, new Object[] {Short.valueOf(A67SecUserId)});
      RcdFound55 = (short)(0) ;
      if ( (pr_default.getStatus(23) != 101) )
      {
         RcdFound55 = (short)(1) ;
         A67SecUserId = BC001M25_A67SecUserId[0] ;
         A68SecUserName = BC001M25_A68SecUserName[0] ;
         A356SecUserPassword = BC001M25_A356SecUserPassword[0] ;
         A357SecUserEmpNom = BC001M25_A357SecUserEmpNom[0] ;
         A364SecUsuActivo = BC001M25_A364SecUsuActivo[0] ;
         A359SecUserPerName = BC001M25_A359SecUserPerName[0] ;
         A360SecUserPerLastName = BC001M25_A360SecUserPerLastName[0] ;
         A358SecUserEmpCuit = BC001M25_A358SecUserEmpCuit[0] ;
         A531SecUserTipEmpl = BC001M25_A531SecUserTipEmpl[0] ;
         A1924RolNombre = BC001M25_A1924RolNombre[0] ;
         A2388SecUserSal = BC001M25_A2388SecUserSal[0] ;
         A3CliCod = BC001M25_A3CliCod[0] ;
         n3CliCod = BC001M25_n3CliCod[0] ;
         A1923RolId = BC001M25_A1923RolId[0] ;
         n1923RolId = BC001M25_n1923RolId[0] ;
         A1925PerfilId = BC001M25_A1925PerfilId[0] ;
         n1925PerfilId = BC001M25_n1925PerfilId[0] ;
         A1928MenuVerId = BC001M25_A1928MenuVerId[0] ;
         n1928MenuVerId = BC001M25_n1928MenuVerId[0] ;
         A69SecUserPaiCod = BC001M25_A69SecUserPaiCod[0] ;
         n69SecUserPaiCod = BC001M25_n69SecUserPaiCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1M55( )
   {
      /* Scan next routine */
      pr_default.readNext(23);
      RcdFound55 = (short)(0) ;
      scanKeyLoad1M55( ) ;
   }

   public void scanKeyLoad1M55( )
   {
      sMode55 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(23) != 101) )
      {
         RcdFound55 = (short)(1) ;
         A67SecUserId = BC001M25_A67SecUserId[0] ;
         A68SecUserName = BC001M25_A68SecUserName[0] ;
         A356SecUserPassword = BC001M25_A356SecUserPassword[0] ;
         A357SecUserEmpNom = BC001M25_A357SecUserEmpNom[0] ;
         A364SecUsuActivo = BC001M25_A364SecUsuActivo[0] ;
         A359SecUserPerName = BC001M25_A359SecUserPerName[0] ;
         A360SecUserPerLastName = BC001M25_A360SecUserPerLastName[0] ;
         A358SecUserEmpCuit = BC001M25_A358SecUserEmpCuit[0] ;
         A531SecUserTipEmpl = BC001M25_A531SecUserTipEmpl[0] ;
         A1924RolNombre = BC001M25_A1924RolNombre[0] ;
         A2388SecUserSal = BC001M25_A2388SecUserSal[0] ;
         A3CliCod = BC001M25_A3CliCod[0] ;
         n3CliCod = BC001M25_n3CliCod[0] ;
         A1923RolId = BC001M25_A1923RolId[0] ;
         n1923RolId = BC001M25_n1923RolId[0] ;
         A1925PerfilId = BC001M25_A1925PerfilId[0] ;
         n1925PerfilId = BC001M25_n1925PerfilId[0] ;
         A1928MenuVerId = BC001M25_A1928MenuVerId[0] ;
         n1928MenuVerId = BC001M25_n1928MenuVerId[0] ;
         A69SecUserPaiCod = BC001M25_A69SecUserPaiCod[0] ;
         n69SecUserPaiCod = BC001M25_n69SecUserPaiCod[0] ;
      }
      Gx_mode = sMode55 ;
   }

   public void scanKeyEnd1M55( )
   {
      pr_default.close(23);
   }

   public void afterConfirm1M55( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1M55( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1M55( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1M55( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1M55( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1M55( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1M55( )
   {
   }

   public void send_integrity_lvl_hashes1M55( )
   {
   }

   public void addRow1M55( )
   {
      VarsToRow55( bcwwpbaseobjects_SecUser) ;
   }

   public void readRow1M55( )
   {
      RowToVars55( bcwwpbaseobjects_SecUser, 1) ;
   }

   public void initializeNonKey1M55( )
   {
      A68SecUserName = "" ;
      A356SecUserPassword = "" ;
      A3CliCod = 0 ;
      n3CliCod = false ;
      A357SecUserEmpNom = "" ;
      A364SecUsuActivo = false ;
      A359SecUserPerName = "" ;
      A360SecUserPerLastName = "" ;
      A358SecUserEmpCuit = 0 ;
      A531SecUserTipEmpl = "" ;
      A69SecUserPaiCod = (short)(0) ;
      n69SecUserPaiCod = false ;
      A1923RolId = (byte)(0) ;
      n1923RolId = false ;
      A1925PerfilId = (byte)(0) ;
      n1925PerfilId = false ;
      A1928MenuVerId = 0 ;
      n1928MenuVerId = false ;
      A1924RolNombre = "" ;
      A2388SecUserSal = "" ;
      Z68SecUserName = "" ;
      Z356SecUserPassword = "" ;
      Z357SecUserEmpNom = "" ;
      Z364SecUsuActivo = false ;
      Z359SecUserPerName = "" ;
      Z360SecUserPerLastName = "" ;
      Z358SecUserEmpCuit = 0 ;
      Z531SecUserTipEmpl = "" ;
      Z2388SecUserSal = "" ;
      Z3CliCod = 0 ;
      Z1923RolId = (byte)(0) ;
      Z1925PerfilId = (byte)(0) ;
      Z1928MenuVerId = 0 ;
      Z69SecUserPaiCod = (short)(0) ;
   }

   public void initAll1M55( )
   {
      A67SecUserId = (short)(0) ;
      initializeNonKey1M55( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow55( web.wwpbaseobjects.SdtSecUser obj55 )
   {
      obj55.setgxTv_SdtSecUser_Mode( Gx_mode );
      obj55.setgxTv_SdtSecUser_Secusername( A68SecUserName );
      obj55.setgxTv_SdtSecUser_Secuserpassword( A356SecUserPassword );
      obj55.setgxTv_SdtSecUser_Clicod( A3CliCod );
      obj55.setgxTv_SdtSecUser_Secuserempnom( A357SecUserEmpNom );
      obj55.setgxTv_SdtSecUser_Secusuactivo( A364SecUsuActivo );
      obj55.setgxTv_SdtSecUser_Secuserpername( A359SecUserPerName );
      obj55.setgxTv_SdtSecUser_Secuserperlastname( A360SecUserPerLastName );
      obj55.setgxTv_SdtSecUser_Secuserempcuit( A358SecUserEmpCuit );
      obj55.setgxTv_SdtSecUser_Secusertipempl( A531SecUserTipEmpl );
      obj55.setgxTv_SdtSecUser_Secuserpaicod( A69SecUserPaiCod );
      obj55.setgxTv_SdtSecUser_Rolid( A1923RolId );
      obj55.setgxTv_SdtSecUser_Perfilid( A1925PerfilId );
      obj55.setgxTv_SdtSecUser_Menuverid( A1928MenuVerId );
      obj55.setgxTv_SdtSecUser_Rolnombre( A1924RolNombre );
      obj55.setgxTv_SdtSecUser_Secusersal( A2388SecUserSal );
      obj55.setgxTv_SdtSecUser_Secuserid( A67SecUserId );
      obj55.setgxTv_SdtSecUser_Secuserid_Z( Z67SecUserId );
      obj55.setgxTv_SdtSecUser_Secusername_Z( Z68SecUserName );
      obj55.setgxTv_SdtSecUser_Secuserpassword_Z( Z356SecUserPassword );
      obj55.setgxTv_SdtSecUser_Clicod_Z( Z3CliCod );
      obj55.setgxTv_SdtSecUser_Secuserempnom_Z( Z357SecUserEmpNom );
      obj55.setgxTv_SdtSecUser_Secusuactivo_Z( Z364SecUsuActivo );
      obj55.setgxTv_SdtSecUser_Secuserpername_Z( Z359SecUserPerName );
      obj55.setgxTv_SdtSecUser_Secuserperlastname_Z( Z360SecUserPerLastName );
      obj55.setgxTv_SdtSecUser_Secuserempcuit_Z( Z358SecUserEmpCuit );
      obj55.setgxTv_SdtSecUser_Secusertipempl_Z( Z531SecUserTipEmpl );
      obj55.setgxTv_SdtSecUser_Secuserpaicod_Z( Z69SecUserPaiCod );
      obj55.setgxTv_SdtSecUser_Rolid_Z( Z1923RolId );
      obj55.setgxTv_SdtSecUser_Perfilid_Z( Z1925PerfilId );
      obj55.setgxTv_SdtSecUser_Menuverid_Z( Z1928MenuVerId );
      obj55.setgxTv_SdtSecUser_Rolnombre_Z( Z1924RolNombre );
      obj55.setgxTv_SdtSecUser_Secusersal_Z( Z2388SecUserSal );
      obj55.setgxTv_SdtSecUser_Clicod_N( (byte)((byte)((n3CliCod)?1:0)) );
      obj55.setgxTv_SdtSecUser_Secuserpaicod_N( (byte)((byte)((n69SecUserPaiCod)?1:0)) );
      obj55.setgxTv_SdtSecUser_Rolid_N( (byte)((byte)((n1923RolId)?1:0)) );
      obj55.setgxTv_SdtSecUser_Perfilid_N( (byte)((byte)((n1925PerfilId)?1:0)) );
      obj55.setgxTv_SdtSecUser_Menuverid_N( (byte)((byte)((n1928MenuVerId)?1:0)) );
      obj55.setgxTv_SdtSecUser_Mode( Gx_mode );
   }

   public void KeyVarsToRow55( web.wwpbaseobjects.SdtSecUser obj55 )
   {
      obj55.setgxTv_SdtSecUser_Secuserid( A67SecUserId );
   }

   public void RowToVars55( web.wwpbaseobjects.SdtSecUser obj55 ,
                            int forceLoad )
   {
      Gx_mode = obj55.getgxTv_SdtSecUser_Mode() ;
      A68SecUserName = obj55.getgxTv_SdtSecUser_Secusername() ;
      A356SecUserPassword = obj55.getgxTv_SdtSecUser_Secuserpassword() ;
      A3CliCod = obj55.getgxTv_SdtSecUser_Clicod() ;
      n3CliCod = false ;
      A357SecUserEmpNom = obj55.getgxTv_SdtSecUser_Secuserempnom() ;
      A364SecUsuActivo = obj55.getgxTv_SdtSecUser_Secusuactivo() ;
      A359SecUserPerName = obj55.getgxTv_SdtSecUser_Secuserpername() ;
      A360SecUserPerLastName = obj55.getgxTv_SdtSecUser_Secuserperlastname() ;
      A358SecUserEmpCuit = obj55.getgxTv_SdtSecUser_Secuserempcuit() ;
      A531SecUserTipEmpl = obj55.getgxTv_SdtSecUser_Secusertipempl() ;
      A69SecUserPaiCod = obj55.getgxTv_SdtSecUser_Secuserpaicod() ;
      n69SecUserPaiCod = false ;
      A1923RolId = obj55.getgxTv_SdtSecUser_Rolid() ;
      n1923RolId = false ;
      A1925PerfilId = obj55.getgxTv_SdtSecUser_Perfilid() ;
      n1925PerfilId = false ;
      A1928MenuVerId = obj55.getgxTv_SdtSecUser_Menuverid() ;
      n1928MenuVerId = false ;
      A1924RolNombre = obj55.getgxTv_SdtSecUser_Rolnombre() ;
      A2388SecUserSal = obj55.getgxTv_SdtSecUser_Secusersal() ;
      A67SecUserId = obj55.getgxTv_SdtSecUser_Secuserid() ;
      Z67SecUserId = obj55.getgxTv_SdtSecUser_Secuserid_Z() ;
      Z68SecUserName = obj55.getgxTv_SdtSecUser_Secusername_Z() ;
      Z356SecUserPassword = obj55.getgxTv_SdtSecUser_Secuserpassword_Z() ;
      Z3CliCod = obj55.getgxTv_SdtSecUser_Clicod_Z() ;
      Z357SecUserEmpNom = obj55.getgxTv_SdtSecUser_Secuserempnom_Z() ;
      Z364SecUsuActivo = obj55.getgxTv_SdtSecUser_Secusuactivo_Z() ;
      Z359SecUserPerName = obj55.getgxTv_SdtSecUser_Secuserpername_Z() ;
      Z360SecUserPerLastName = obj55.getgxTv_SdtSecUser_Secuserperlastname_Z() ;
      Z358SecUserEmpCuit = obj55.getgxTv_SdtSecUser_Secuserempcuit_Z() ;
      Z531SecUserTipEmpl = obj55.getgxTv_SdtSecUser_Secusertipempl_Z() ;
      Z69SecUserPaiCod = obj55.getgxTv_SdtSecUser_Secuserpaicod_Z() ;
      Z1923RolId = obj55.getgxTv_SdtSecUser_Rolid_Z() ;
      Z1925PerfilId = obj55.getgxTv_SdtSecUser_Perfilid_Z() ;
      Z1928MenuVerId = obj55.getgxTv_SdtSecUser_Menuverid_Z() ;
      Z1924RolNombre = obj55.getgxTv_SdtSecUser_Rolnombre_Z() ;
      Z2388SecUserSal = obj55.getgxTv_SdtSecUser_Secusersal_Z() ;
      n3CliCod = (boolean)((obj55.getgxTv_SdtSecUser_Clicod_N()==0)?false:true) ;
      n69SecUserPaiCod = (boolean)((obj55.getgxTv_SdtSecUser_Secuserpaicod_N()==0)?false:true) ;
      n1923RolId = (boolean)((obj55.getgxTv_SdtSecUser_Rolid_N()==0)?false:true) ;
      n1925PerfilId = (boolean)((obj55.getgxTv_SdtSecUser_Perfilid_N()==0)?false:true) ;
      n1928MenuVerId = (boolean)((obj55.getgxTv_SdtSecUser_Menuverid_N()==0)?false:true) ;
      Gx_mode = obj55.getgxTv_SdtSecUser_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A67SecUserId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1M55( ) ;
      scanKeyStart1M55( ) ;
      if ( RcdFound55 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z67SecUserId = A67SecUserId ;
      }
      zm1M55( -12) ;
      onLoadActions1M55( ) ;
      addRow1M55( ) ;
      scanKeyEnd1M55( ) ;
      if ( RcdFound55 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars55( bcwwpbaseobjects_SecUser, 0) ;
      scanKeyStart1M55( ) ;
      if ( RcdFound55 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z67SecUserId = A67SecUserId ;
      }
      zm1M55( -12) ;
      onLoadActions1M55( ) ;
      addRow1M55( ) ;
      scanKeyEnd1M55( ) ;
      if ( RcdFound55 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1M55( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1M55( ) ;
      }
      else
      {
         if ( RcdFound55 == 1 )
         {
            if ( A67SecUserId != Z67SecUserId )
            {
               A67SecUserId = Z67SecUserId ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update1M55( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( A67SecUserId != Z67SecUserId )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert1M55( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert1M55( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars55( bcwwpbaseobjects_SecUser, 1) ;
      saveImpl( ) ;
      VarsToRow55( bcwwpbaseobjects_SecUser) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars55( bcwwpbaseobjects_SecUser, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1M55( ) ;
      afterTrn( ) ;
      VarsToRow55( bcwwpbaseobjects_SecUser) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         web.wwpbaseobjects.SdtSecUser auxBC = new web.wwpbaseobjects.SdtSecUser( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A67SecUserId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_SecUser);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars55( bcwwpbaseobjects_SecUser, 1) ;
      updateImpl( ) ;
      VarsToRow55( bcwwpbaseobjects_SecUser) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars55( bcwwpbaseobjects_SecUser, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1M55( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow55( bcwwpbaseobjects_SecUser) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars55( bcwwpbaseobjects_SecUser, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1M55( ) ;
      if ( RcdFound55 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A67SecUserId != Z67SecUserId )
         {
            A67SecUserId = Z67SecUserId ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( A67SecUserId != Z67SecUserId )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secuser_bc");
      VarsToRow55( bcwwpbaseobjects_SecUser) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcwwpbaseobjects_SecUser.getgxTv_SdtSecUser_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_SecUser.setgxTv_SdtSecUser_Mode( Gx_mode );
   }

   public void SetSDT( web.wwpbaseobjects.SdtSecUser sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_SecUser )
      {
         bcwwpbaseobjects_SecUser = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_SecUser.getgxTv_SdtSecUser_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_SecUser.setgxTv_SdtSecUser_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow55( bcwwpbaseobjects_SecUser) ;
         }
         else
         {
            RowToVars55( bcwwpbaseobjects_SecUser, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_SecUser.getgxTv_SdtSecUser_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_SecUser.setgxTv_SdtSecUser_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars55( bcwwpbaseobjects_SecUser, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtSecUser getSecUser_BC( )
   {
      return bcwwpbaseobjects_SecUser ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV15WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV34Pgmname = "" ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV19TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z68SecUserName = "" ;
      A68SecUserName = "" ;
      Z356SecUserPassword = "" ;
      A356SecUserPassword = "" ;
      Z357SecUserEmpNom = "" ;
      A357SecUserEmpNom = "" ;
      Z359SecUserPerName = "" ;
      A359SecUserPerName = "" ;
      Z360SecUserPerLastName = "" ;
      A360SecUserPerLastName = "" ;
      Z531SecUserTipEmpl = "" ;
      A531SecUserTipEmpl = "" ;
      Z2388SecUserSal = "" ;
      A2388SecUserSal = "" ;
      Z1924RolNombre = "" ;
      A1924RolNombre = "" ;
      GXv_int5 = new int[1] ;
      GXv_boolean3 = new boolean[1] ;
      BC001M9_A67SecUserId = new short[1] ;
      BC001M9_A68SecUserName = new String[] {""} ;
      BC001M9_A356SecUserPassword = new String[] {""} ;
      BC001M9_A357SecUserEmpNom = new String[] {""} ;
      BC001M9_A364SecUsuActivo = new boolean[] {false} ;
      BC001M9_A359SecUserPerName = new String[] {""} ;
      BC001M9_A360SecUserPerLastName = new String[] {""} ;
      BC001M9_A358SecUserEmpCuit = new long[1] ;
      BC001M9_A531SecUserTipEmpl = new String[] {""} ;
      BC001M9_A1924RolNombre = new String[] {""} ;
      BC001M9_A2388SecUserSal = new String[] {""} ;
      BC001M9_A3CliCod = new int[1] ;
      BC001M9_n3CliCod = new boolean[] {false} ;
      BC001M9_A1923RolId = new byte[1] ;
      BC001M9_n1923RolId = new boolean[] {false} ;
      BC001M9_A1925PerfilId = new byte[1] ;
      BC001M9_n1925PerfilId = new boolean[] {false} ;
      BC001M9_A1928MenuVerId = new long[1] ;
      BC001M9_n1928MenuVerId = new boolean[] {false} ;
      BC001M9_A69SecUserPaiCod = new short[1] ;
      BC001M9_n69SecUserPaiCod = new boolean[] {false} ;
      BC001M10_A68SecUserName = new String[] {""} ;
      BC001M11_A3CliCod = new int[1] ;
      BC001M11_n3CliCod = new boolean[] {false} ;
      BC001M12_A69SecUserPaiCod = new short[1] ;
      BC001M12_n69SecUserPaiCod = new boolean[] {false} ;
      BC001M13_A1924RolNombre = new String[] {""} ;
      BC001M14_A1923RolId = new byte[1] ;
      BC001M14_n1923RolId = new boolean[] {false} ;
      BC001M15_A1925PerfilId = new byte[1] ;
      BC001M15_n1925PerfilId = new boolean[] {false} ;
      BC001M16_A67SecUserId = new short[1] ;
      BC001M17_A67SecUserId = new short[1] ;
      BC001M17_A68SecUserName = new String[] {""} ;
      BC001M17_A356SecUserPassword = new String[] {""} ;
      BC001M17_A357SecUserEmpNom = new String[] {""} ;
      BC001M17_A364SecUsuActivo = new boolean[] {false} ;
      BC001M17_A359SecUserPerName = new String[] {""} ;
      BC001M17_A360SecUserPerLastName = new String[] {""} ;
      BC001M17_A358SecUserEmpCuit = new long[1] ;
      BC001M17_A531SecUserTipEmpl = new String[] {""} ;
      BC001M17_A2388SecUserSal = new String[] {""} ;
      BC001M17_A3CliCod = new int[1] ;
      BC001M17_n3CliCod = new boolean[] {false} ;
      BC001M17_A1923RolId = new byte[1] ;
      BC001M17_n1923RolId = new boolean[] {false} ;
      BC001M17_A1925PerfilId = new byte[1] ;
      BC001M17_n1925PerfilId = new boolean[] {false} ;
      BC001M17_A1928MenuVerId = new long[1] ;
      BC001M17_n1928MenuVerId = new boolean[] {false} ;
      BC001M17_A69SecUserPaiCod = new short[1] ;
      BC001M17_n69SecUserPaiCod = new boolean[] {false} ;
      sMode55 = "" ;
      BC001M18_A67SecUserId = new short[1] ;
      BC001M18_A68SecUserName = new String[] {""} ;
      BC001M18_A356SecUserPassword = new String[] {""} ;
      BC001M18_A357SecUserEmpNom = new String[] {""} ;
      BC001M18_A364SecUsuActivo = new boolean[] {false} ;
      BC001M18_A359SecUserPerName = new String[] {""} ;
      BC001M18_A360SecUserPerLastName = new String[] {""} ;
      BC001M18_A358SecUserEmpCuit = new long[1] ;
      BC001M18_A531SecUserTipEmpl = new String[] {""} ;
      BC001M18_A2388SecUserSal = new String[] {""} ;
      BC001M18_A3CliCod = new int[1] ;
      BC001M18_n3CliCod = new boolean[] {false} ;
      BC001M18_A1923RolId = new byte[1] ;
      BC001M18_n1923RolId = new boolean[] {false} ;
      BC001M18_A1925PerfilId = new byte[1] ;
      BC001M18_n1925PerfilId = new boolean[] {false} ;
      BC001M18_A1928MenuVerId = new long[1] ;
      BC001M18_n1928MenuVerId = new boolean[] {false} ;
      BC001M18_A69SecUserPaiCod = new short[1] ;
      BC001M18_n69SecUserPaiCod = new boolean[] {false} ;
      BC001M20_A67SecUserId = new short[1] ;
      BC001M23_A1924RolNombre = new String[] {""} ;
      BC001M24_A67SecUserId = new short[1] ;
      BC001M24_A65SecRoleId = new short[1] ;
      BC001M25_A67SecUserId = new short[1] ;
      BC001M25_A68SecUserName = new String[] {""} ;
      BC001M25_A356SecUserPassword = new String[] {""} ;
      BC001M25_A357SecUserEmpNom = new String[] {""} ;
      BC001M25_A364SecUsuActivo = new boolean[] {false} ;
      BC001M25_A359SecUserPerName = new String[] {""} ;
      BC001M25_A360SecUserPerLastName = new String[] {""} ;
      BC001M25_A358SecUserEmpCuit = new long[1] ;
      BC001M25_A531SecUserTipEmpl = new String[] {""} ;
      BC001M25_A1924RolNombre = new String[] {""} ;
      BC001M25_A2388SecUserSal = new String[] {""} ;
      BC001M25_A3CliCod = new int[1] ;
      BC001M25_n3CliCod = new boolean[] {false} ;
      BC001M25_A1923RolId = new byte[1] ;
      BC001M25_n1923RolId = new boolean[] {false} ;
      BC001M25_A1925PerfilId = new byte[1] ;
      BC001M25_n1925PerfilId = new boolean[] {false} ;
      BC001M25_A1928MenuVerId = new long[1] ;
      BC001M25_n1928MenuVerId = new boolean[] {false} ;
      BC001M25_A69SecUserPaiCod = new short[1] ;
      BC001M25_n69SecUserPaiCod = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secuser_bc__default(),
         new Object[] {
             new Object[] {
            BC001M2_A67SecUserId, BC001M2_A68SecUserName, BC001M2_A356SecUserPassword, BC001M2_A357SecUserEmpNom, BC001M2_A364SecUsuActivo, BC001M2_A359SecUserPerName, BC001M2_A360SecUserPerLastName, BC001M2_A358SecUserEmpCuit, BC001M2_A531SecUserTipEmpl, BC001M2_A2388SecUserSal,
            BC001M2_A3CliCod, BC001M2_n3CliCod, BC001M2_A1923RolId, BC001M2_n1923RolId, BC001M2_A1925PerfilId, BC001M2_n1925PerfilId, BC001M2_A1928MenuVerId, BC001M2_n1928MenuVerId, BC001M2_A69SecUserPaiCod, BC001M2_n69SecUserPaiCod
            }
            , new Object[] {
            BC001M3_A67SecUserId, BC001M3_A68SecUserName, BC001M3_A356SecUserPassword, BC001M3_A357SecUserEmpNom, BC001M3_A364SecUsuActivo, BC001M3_A359SecUserPerName, BC001M3_A360SecUserPerLastName, BC001M3_A358SecUserEmpCuit, BC001M3_A531SecUserTipEmpl, BC001M3_A2388SecUserSal,
            BC001M3_A3CliCod, BC001M3_n3CliCod, BC001M3_A1923RolId, BC001M3_n1923RolId, BC001M3_A1925PerfilId, BC001M3_n1925PerfilId, BC001M3_A1928MenuVerId, BC001M3_n1928MenuVerId, BC001M3_A69SecUserPaiCod, BC001M3_n69SecUserPaiCod
            }
            , new Object[] {
            BC001M4_A3CliCod
            }
            , new Object[] {
            BC001M5_A1924RolNombre
            }
            , new Object[] {
            BC001M6_A1925PerfilId
            }
            , new Object[] {
            BC001M7_A1923RolId
            }
            , new Object[] {
            BC001M8_A69SecUserPaiCod
            }
            , new Object[] {
            BC001M9_A67SecUserId, BC001M9_A68SecUserName, BC001M9_A356SecUserPassword, BC001M9_A357SecUserEmpNom, BC001M9_A364SecUsuActivo, BC001M9_A359SecUserPerName, BC001M9_A360SecUserPerLastName, BC001M9_A358SecUserEmpCuit, BC001M9_A531SecUserTipEmpl, BC001M9_A1924RolNombre,
            BC001M9_A2388SecUserSal, BC001M9_A3CliCod, BC001M9_n3CliCod, BC001M9_A1923RolId, BC001M9_n1923RolId, BC001M9_A1925PerfilId, BC001M9_n1925PerfilId, BC001M9_A1928MenuVerId, BC001M9_n1928MenuVerId, BC001M9_A69SecUserPaiCod,
            BC001M9_n69SecUserPaiCod
            }
            , new Object[] {
            BC001M10_A68SecUserName
            }
            , new Object[] {
            BC001M11_A3CliCod
            }
            , new Object[] {
            BC001M12_A69SecUserPaiCod
            }
            , new Object[] {
            BC001M13_A1924RolNombre
            }
            , new Object[] {
            BC001M14_A1923RolId
            }
            , new Object[] {
            BC001M15_A1925PerfilId
            }
            , new Object[] {
            BC001M16_A67SecUserId
            }
            , new Object[] {
            BC001M17_A67SecUserId, BC001M17_A68SecUserName, BC001M17_A356SecUserPassword, BC001M17_A357SecUserEmpNom, BC001M17_A364SecUsuActivo, BC001M17_A359SecUserPerName, BC001M17_A360SecUserPerLastName, BC001M17_A358SecUserEmpCuit, BC001M17_A531SecUserTipEmpl, BC001M17_A2388SecUserSal,
            BC001M17_A3CliCod, BC001M17_n3CliCod, BC001M17_A1923RolId, BC001M17_n1923RolId, BC001M17_A1925PerfilId, BC001M17_n1925PerfilId, BC001M17_A1928MenuVerId, BC001M17_n1928MenuVerId, BC001M17_A69SecUserPaiCod, BC001M17_n69SecUserPaiCod
            }
            , new Object[] {
            BC001M18_A67SecUserId, BC001M18_A68SecUserName, BC001M18_A356SecUserPassword, BC001M18_A357SecUserEmpNom, BC001M18_A364SecUsuActivo, BC001M18_A359SecUserPerName, BC001M18_A360SecUserPerLastName, BC001M18_A358SecUserEmpCuit, BC001M18_A531SecUserTipEmpl, BC001M18_A2388SecUserSal,
            BC001M18_A3CliCod, BC001M18_n3CliCod, BC001M18_A1923RolId, BC001M18_n1923RolId, BC001M18_A1925PerfilId, BC001M18_n1925PerfilId, BC001M18_A1928MenuVerId, BC001M18_n1928MenuVerId, BC001M18_A69SecUserPaiCod, BC001M18_n69SecUserPaiCod
            }
            , new Object[] {
            }
            , new Object[] {
            BC001M20_A67SecUserId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001M23_A1924RolNombre
            }
            , new Object[] {
            BC001M24_A67SecUserId, BC001M24_A65SecRoleId
            }
            , new Object[] {
            BC001M25_A67SecUserId, BC001M25_A68SecUserName, BC001M25_A356SecUserPassword, BC001M25_A357SecUserEmpNom, BC001M25_A364SecUsuActivo, BC001M25_A359SecUserPerName, BC001M25_A360SecUserPerLastName, BC001M25_A358SecUserEmpCuit, BC001M25_A531SecUserTipEmpl, BC001M25_A1924RolNombre,
            BC001M25_A2388SecUserSal, BC001M25_A3CliCod, BC001M25_n3CliCod, BC001M25_A1923RolId, BC001M25_n1923RolId, BC001M25_A1925PerfilId, BC001M25_n1925PerfilId, BC001M25_A1928MenuVerId, BC001M25_n1928MenuVerId, BC001M25_A69SecUserPaiCod,
            BC001M25_n69SecUserPaiCod
            }
         }
      );
      AV34Pgmname = "WWPBaseObjects.SecUser_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e121M2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte AV30Insert_RolId ;
   private byte AV31Insert_PerfilId ;
   private byte Z1923RolId ;
   private byte A1923RolId ;
   private byte Z1925PerfilId ;
   private byte A1925PerfilId ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z67SecUserId ;
   private short A67SecUserId ;
   private short AV29Insert_SecUserPaiCod ;
   private short Z69SecUserPaiCod ;
   private short A69SecUserPaiCod ;
   private short RcdFound55 ;
   private short nIsDirty_55 ;
   private int trnEnded ;
   private int AV35GXV1 ;
   private int AV18Insert_CliCod ;
   private int GX_JID ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int AV26session_CliCod ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private long AV32Insert_MenuVerId ;
   private long Z358SecUserEmpCuit ;
   private long A358SecUserEmpCuit ;
   private long Z1928MenuVerId ;
   private long A1928MenuVerId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV34Pgmname ;
   private String Z531SecUserTipEmpl ;
   private String A531SecUserTipEmpl ;
   private String sMode55 ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean Z364SecUsuActivo ;
   private boolean A364SecUsuActivo ;
   private boolean AV28SecUsuActivo ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n3CliCod ;
   private boolean n1923RolId ;
   private boolean n1925PerfilId ;
   private boolean n1928MenuVerId ;
   private boolean n69SecUserPaiCod ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z68SecUserName ;
   private String A68SecUserName ;
   private String Z356SecUserPassword ;
   private String A356SecUserPassword ;
   private String Z357SecUserEmpNom ;
   private String A357SecUserEmpNom ;
   private String Z359SecUserPerName ;
   private String A359SecUserPerName ;
   private String Z360SecUserPerLastName ;
   private String A360SecUserPerLastName ;
   private String Z2388SecUserSal ;
   private String A2388SecUserSal ;
   private String Z1924RolNombre ;
   private String A1924RolNombre ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private web.wwpbaseobjects.SdtSecUser bcwwpbaseobjects_SecUser ;
   private IDataStoreProvider pr_default ;
   private short[] BC001M9_A67SecUserId ;
   private String[] BC001M9_A68SecUserName ;
   private String[] BC001M9_A356SecUserPassword ;
   private String[] BC001M9_A357SecUserEmpNom ;
   private boolean[] BC001M9_A364SecUsuActivo ;
   private String[] BC001M9_A359SecUserPerName ;
   private String[] BC001M9_A360SecUserPerLastName ;
   private long[] BC001M9_A358SecUserEmpCuit ;
   private String[] BC001M9_A531SecUserTipEmpl ;
   private String[] BC001M9_A1924RolNombre ;
   private String[] BC001M9_A2388SecUserSal ;
   private int[] BC001M9_A3CliCod ;
   private boolean[] BC001M9_n3CliCod ;
   private byte[] BC001M9_A1923RolId ;
   private boolean[] BC001M9_n1923RolId ;
   private byte[] BC001M9_A1925PerfilId ;
   private boolean[] BC001M9_n1925PerfilId ;
   private long[] BC001M9_A1928MenuVerId ;
   private boolean[] BC001M9_n1928MenuVerId ;
   private short[] BC001M9_A69SecUserPaiCod ;
   private boolean[] BC001M9_n69SecUserPaiCod ;
   private String[] BC001M10_A68SecUserName ;
   private int[] BC001M11_A3CliCod ;
   private boolean[] BC001M11_n3CliCod ;
   private short[] BC001M12_A69SecUserPaiCod ;
   private boolean[] BC001M12_n69SecUserPaiCod ;
   private String[] BC001M13_A1924RolNombre ;
   private byte[] BC001M14_A1923RolId ;
   private boolean[] BC001M14_n1923RolId ;
   private byte[] BC001M15_A1925PerfilId ;
   private boolean[] BC001M15_n1925PerfilId ;
   private short[] BC001M16_A67SecUserId ;
   private short[] BC001M17_A67SecUserId ;
   private String[] BC001M17_A68SecUserName ;
   private String[] BC001M17_A356SecUserPassword ;
   private String[] BC001M17_A357SecUserEmpNom ;
   private boolean[] BC001M17_A364SecUsuActivo ;
   private String[] BC001M17_A359SecUserPerName ;
   private String[] BC001M17_A360SecUserPerLastName ;
   private long[] BC001M17_A358SecUserEmpCuit ;
   private String[] BC001M17_A531SecUserTipEmpl ;
   private String[] BC001M17_A2388SecUserSal ;
   private int[] BC001M17_A3CliCod ;
   private boolean[] BC001M17_n3CliCod ;
   private byte[] BC001M17_A1923RolId ;
   private boolean[] BC001M17_n1923RolId ;
   private byte[] BC001M17_A1925PerfilId ;
   private boolean[] BC001M17_n1925PerfilId ;
   private long[] BC001M17_A1928MenuVerId ;
   private boolean[] BC001M17_n1928MenuVerId ;
   private short[] BC001M17_A69SecUserPaiCod ;
   private boolean[] BC001M17_n69SecUserPaiCod ;
   private short[] BC001M18_A67SecUserId ;
   private String[] BC001M18_A68SecUserName ;
   private String[] BC001M18_A356SecUserPassword ;
   private String[] BC001M18_A357SecUserEmpNom ;
   private boolean[] BC001M18_A364SecUsuActivo ;
   private String[] BC001M18_A359SecUserPerName ;
   private String[] BC001M18_A360SecUserPerLastName ;
   private long[] BC001M18_A358SecUserEmpCuit ;
   private String[] BC001M18_A531SecUserTipEmpl ;
   private String[] BC001M18_A2388SecUserSal ;
   private int[] BC001M18_A3CliCod ;
   private boolean[] BC001M18_n3CliCod ;
   private byte[] BC001M18_A1923RolId ;
   private boolean[] BC001M18_n1923RolId ;
   private byte[] BC001M18_A1925PerfilId ;
   private boolean[] BC001M18_n1925PerfilId ;
   private long[] BC001M18_A1928MenuVerId ;
   private boolean[] BC001M18_n1928MenuVerId ;
   private short[] BC001M18_A69SecUserPaiCod ;
   private boolean[] BC001M18_n69SecUserPaiCod ;
   private short[] BC001M20_A67SecUserId ;
   private String[] BC001M23_A1924RolNombre ;
   private short[] BC001M24_A67SecUserId ;
   private short[] BC001M24_A65SecRoleId ;
   private short[] BC001M25_A67SecUserId ;
   private String[] BC001M25_A68SecUserName ;
   private String[] BC001M25_A356SecUserPassword ;
   private String[] BC001M25_A357SecUserEmpNom ;
   private boolean[] BC001M25_A364SecUsuActivo ;
   private String[] BC001M25_A359SecUserPerName ;
   private String[] BC001M25_A360SecUserPerLastName ;
   private long[] BC001M25_A358SecUserEmpCuit ;
   private String[] BC001M25_A531SecUserTipEmpl ;
   private String[] BC001M25_A1924RolNombre ;
   private String[] BC001M25_A2388SecUserSal ;
   private int[] BC001M25_A3CliCod ;
   private boolean[] BC001M25_n3CliCod ;
   private byte[] BC001M25_A1923RolId ;
   private boolean[] BC001M25_n1923RolId ;
   private byte[] BC001M25_A1925PerfilId ;
   private boolean[] BC001M25_n1925PerfilId ;
   private long[] BC001M25_A1928MenuVerId ;
   private boolean[] BC001M25_n1928MenuVerId ;
   private short[] BC001M25_A69SecUserPaiCod ;
   private boolean[] BC001M25_n69SecUserPaiCod ;
   private short[] BC001M2_A67SecUserId ;
   private String[] BC001M2_A68SecUserName ;
   private String[] BC001M2_A356SecUserPassword ;
   private String[] BC001M2_A357SecUserEmpNom ;
   private boolean[] BC001M2_A364SecUsuActivo ;
   private String[] BC001M2_A359SecUserPerName ;
   private String[] BC001M2_A360SecUserPerLastName ;
   private long[] BC001M2_A358SecUserEmpCuit ;
   private String[] BC001M2_A531SecUserTipEmpl ;
   private String[] BC001M2_A2388SecUserSal ;
   private int[] BC001M2_A3CliCod ;
   private byte[] BC001M2_A1923RolId ;
   private byte[] BC001M2_A1925PerfilId ;
   private long[] BC001M2_A1928MenuVerId ;
   private short[] BC001M2_A69SecUserPaiCod ;
   private short[] BC001M3_A67SecUserId ;
   private String[] BC001M3_A68SecUserName ;
   private String[] BC001M3_A356SecUserPassword ;
   private String[] BC001M3_A357SecUserEmpNom ;
   private boolean[] BC001M3_A364SecUsuActivo ;
   private String[] BC001M3_A359SecUserPerName ;
   private String[] BC001M3_A360SecUserPerLastName ;
   private long[] BC001M3_A358SecUserEmpCuit ;
   private String[] BC001M3_A531SecUserTipEmpl ;
   private String[] BC001M3_A2388SecUserSal ;
   private int[] BC001M3_A3CliCod ;
   private byte[] BC001M3_A1923RolId ;
   private byte[] BC001M3_A1925PerfilId ;
   private long[] BC001M3_A1928MenuVerId ;
   private short[] BC001M3_A69SecUserPaiCod ;
   private int[] BC001M4_A3CliCod ;
   private String[] BC001M5_A1924RolNombre ;
   private byte[] BC001M6_A1925PerfilId ;
   private byte[] BC001M7_A1923RolId ;
   private short[] BC001M8_A69SecUserPaiCod ;
   private boolean[] BC001M2_n3CliCod ;
   private boolean[] BC001M2_n1923RolId ;
   private boolean[] BC001M2_n1925PerfilId ;
   private boolean[] BC001M2_n1928MenuVerId ;
   private boolean[] BC001M2_n69SecUserPaiCod ;
   private boolean[] BC001M3_n3CliCod ;
   private boolean[] BC001M3_n1923RolId ;
   private boolean[] BC001M3_n1925PerfilId ;
   private boolean[] BC001M3_n1928MenuVerId ;
   private boolean[] BC001M3_n69SecUserPaiCod ;
   private web.wwpbaseobjects.SdtWWPContext AV15WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV19TrnContextAtt ;
}

final  class secuser_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC001M2", "SELECT SecUserId, SecUserName, SecUserPassword, SecUserEmpNom, SecUsuActivo, SecUserPerName, SecUserPerLastName, SecUserEmpCuit, SecUserTipEmpl, SecUserSal, CliCod, RolId, PerfilId, MenuVerId, SecUserPaiCod FROM SecUser WHERE SecUserId = ?  FOR UPDATE OF SecUser",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M3", "SELECT SecUserId, SecUserName, SecUserPassword, SecUserEmpNom, SecUsuActivo, SecUserPerName, SecUserPerLastName, SecUserEmpCuit, SecUserTipEmpl, SecUserSal, CliCod, RolId, PerfilId, MenuVerId, SecUserPaiCod FROM SecUser WHERE SecUserId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M4", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M5", "SELECT RolNombre FROM RolUsuario WHERE RolId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M6", "SELECT PerfilId FROM Perfil WHERE PerfilId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M7", "SELECT RolId FROM MenuVersiones WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M8", "SELECT PaiCod AS SecUserPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M9", "SELECT TM1.SecUserId, TM1.SecUserName, TM1.SecUserPassword, TM1.SecUserEmpNom, TM1.SecUsuActivo, TM1.SecUserPerName, TM1.SecUserPerLastName, TM1.SecUserEmpCuit, TM1.SecUserTipEmpl, T2.RolNombre, TM1.SecUserSal, TM1.CliCod, TM1.RolId, TM1.PerfilId, TM1.MenuVerId, TM1.SecUserPaiCod AS SecUserPaiCod FROM (SecUser TM1 LEFT JOIN RolUsuario T2 ON T2.RolId = TM1.RolId) WHERE TM1.SecUserId = ? ORDER BY TM1.SecUserId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M10", "SELECT SecUserName FROM SecUser WHERE (SecUserName = ?) AND (Not ( SecUserId = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M11", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M12", "SELECT PaiCod AS SecUserPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M13", "SELECT RolNombre FROM RolUsuario WHERE RolId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M14", "SELECT RolId FROM MenuVersiones WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M15", "SELECT PerfilId FROM Perfil WHERE PerfilId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M16", "SELECT SecUserId FROM SecUser WHERE SecUserId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M17", "SELECT SecUserId, SecUserName, SecUserPassword, SecUserEmpNom, SecUsuActivo, SecUserPerName, SecUserPerLastName, SecUserEmpCuit, SecUserTipEmpl, SecUserSal, CliCod, RolId, PerfilId, MenuVerId, SecUserPaiCod FROM SecUser WHERE SecUserId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M18", "SELECT SecUserId, SecUserName, SecUserPassword, SecUserEmpNom, SecUsuActivo, SecUserPerName, SecUserPerLastName, SecUserEmpCuit, SecUserTipEmpl, SecUserSal, CliCod, RolId, PerfilId, MenuVerId, SecUserPaiCod FROM SecUser WHERE SecUserId = ?  FOR UPDATE OF SecUser",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001M19", "SAVEPOINT gxupdate;INSERT INTO SecUser(SecUserName, SecUserPassword, SecUserEmpNom, SecUsuActivo, SecUserPerName, SecUserPerLastName, SecUserEmpCuit, SecUserTipEmpl, SecUserSal, CliCod, RolId, PerfilId, MenuVerId, SecUserPaiCod, SecParAct) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001M20", "SELECT currval('SecUserId') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001M21", "SAVEPOINT gxupdate;UPDATE SecUser SET SecUserName=?, SecUserPassword=?, SecUserEmpNom=?, SecUsuActivo=?, SecUserPerName=?, SecUserPerLastName=?, SecUserEmpCuit=?, SecUserTipEmpl=?, SecUserSal=?, CliCod=?, RolId=?, PerfilId=?, MenuVerId=?, SecUserPaiCod=?  WHERE SecUserId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001M22", "SAVEPOINT gxupdate;DELETE FROM SecUser  WHERE SecUserId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001M23", "SELECT RolNombre FROM RolUsuario WHERE RolId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001M24", "SELECT SecUserId, SecRoleId FROM SecUserRole WHERE SecUserId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001M25", "SELECT TM1.SecUserId, TM1.SecUserName, TM1.SecUserPassword, TM1.SecUserEmpNom, TM1.SecUsuActivo, TM1.SecUserPerName, TM1.SecUserPerLastName, TM1.SecUserEmpCuit, TM1.SecUserTipEmpl, T2.RolNombre, TM1.SecUserSal, TM1.CliCod, TM1.RolId, TM1.PerfilId, TM1.MenuVerId, TM1.SecUserPaiCod AS SecUserPaiCod FROM (SecUser TM1 LEFT JOIN RolUsuario T2 ON T2.RolId = TM1.RolId) WHERE TM1.SecUserId = ? ORDER BY TM1.SecUserId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(12);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((byte[]) buf[14])[0] = rslt.getByte(13);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((long[]) buf[16])[0] = rslt.getLong(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((short[]) buf[18])[0] = rslt.getShort(15);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(12);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((byte[]) buf[14])[0] = rslt.getByte(13);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((long[]) buf[16])[0] = rslt.getLong(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((short[]) buf[18])[0] = rslt.getShort(15);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 5 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((byte[]) buf[13])[0] = rslt.getByte(13);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((byte[]) buf[15])[0] = rslt.getByte(14);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((long[]) buf[17])[0] = rslt.getLong(15);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((short[]) buf[19])[0] = rslt.getShort(16);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 12 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 13 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(12);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((byte[]) buf[14])[0] = rslt.getByte(13);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((long[]) buf[16])[0] = rslt.getLong(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((short[]) buf[18])[0] = rslt.getShort(15);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(12);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((byte[]) buf[14])[0] = rslt.getByte(13);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((long[]) buf[16])[0] = rslt.getLong(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((short[]) buf[18])[0] = rslt.getShort(15);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 22 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 23 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((byte[]) buf[13])[0] = rslt.getByte(13);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((byte[]) buf[15])[0] = rslt.getByte(14);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((long[]) buf[17])[0] = rslt.getLong(15);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((short[]) buf[19])[0] = rslt.getShort(16);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setLong(7, ((Number) parms[6]).longValue());
               stmt.setString(8, (String)parms[7], 4);
               stmt.setVarchar(9, (String)parms[8], 40, false);
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(10, ((Number) parms[10]).intValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(11, ((Number) parms[12]).byteValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(12, ((Number) parms[14]).byteValue());
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(13, ((Number) parms[16]).longValue());
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(14, ((Number) parms[18]).shortValue());
               }
               return;
            case 19 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setLong(7, ((Number) parms[6]).longValue());
               stmt.setString(8, (String)parms[7], 4);
               stmt.setVarchar(9, (String)parms[8], 40, false);
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(10, ((Number) parms[10]).intValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(11, ((Number) parms[12]).byteValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(12, ((Number) parms[14]).byteValue());
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(13, ((Number) parms[16]).longValue());
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(14, ((Number) parms[18]).shortValue());
               }
               stmt.setShort(15, ((Number) parms[19]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 21 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 23 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

