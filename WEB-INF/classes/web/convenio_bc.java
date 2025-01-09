package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class convenio_bc extends GXWebPanel implements IGxSilentTrn
{
   public convenio_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public convenio_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_bc.class ));
   }

   public convenio_bc( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0E106( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0E106( ) ;
      standaloneModal( ) ;
      addRow0E106( ) ;
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
         e110E2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z46PaiCod = A46PaiCod ;
            Z9ConveCodigo = A9ConveCodigo ;
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

   public void confirm_0E0( )
   {
      beforeValidate0E106( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0E106( ) ;
         }
         else
         {
            checkExtendedTable0E106( ) ;
            if ( AnyError == 0 )
            {
               zm0E106( 11) ;
               zm0E106( 12) ;
            }
            closeExtendedTableCursors0E106( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode106 = Gx_mode ;
         confirm_0E275( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode106 ;
            IsConfirmed = (short)(1) ;
         }
         /* Restore parent mode. */
         Gx_mode = sMode106 ;
      }
   }

   public void confirm_0E275( )
   {
      nGXsfl_275_idx = 0 ;
      while ( nGXsfl_275_idx < bcConvenio.getgxTv_SdtConvenio_Propiedadesadicionales().size() )
      {
         readRow0E275( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound275 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_275 != 0 ) )
         {
            getKey0E275( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound275 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0E275( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0E275( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0E275( 14) ;
                     }
                     closeExtendedTableCursors0E275( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                  AnyError = (short)(1) ;
               }
            }
            else
            {
               if ( RcdFound275 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0E275( ) ;
                     load0E275( ) ;
                     beforeValidate0E275( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0E275( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_275 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0E275( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0E275( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0E275( 14) ;
                           }
                           closeExtendedTableCursors0E275( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( ! isDlt( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
            VarsToRow275( ((web.SdtConvenio_PropiedadesAdicionales)bcConvenio.getgxTv_SdtConvenio_Propiedadesadicionales().elementAt(-1+nGXsfl_275_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e120E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      AV10IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_Insert", GXv_boolean3) ;
         convenio_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_Update", GXv_boolean3) ;
         convenio_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_Delete", GXv_boolean3) ;
         convenio_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV26Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV12TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV26Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV27GXV1 = 1 ;
         while ( AV27GXV1 <= AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV15TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV27GXV1));
            if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConveSinCod") == 0 )
            {
               AV18Insert_ConveSinCod = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            AV27GXV1 = (int)(AV27GXV1+1) ;
         }
      }
   }

   public void e110E2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0E106( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         Z687ConveDescriSinAc = A687ConveDescriSinAc ;
         Z160ConveDescri = A160ConveDescri ;
         Z161ConveHabilitada = A161ConveHabilitada ;
         Z1915ConvBusGoogle = A1915ConvBusGoogle ;
         Z1916ConvBusWeb = A1916ConvBusWeb ;
         Z1917ConvBaseURL = A1917ConvBaseURL ;
         Z1918ConvScrapTipo = A1918ConvScrapTipo ;
         Z1919ConvScrapTDoc = A1919ConvScrapTDoc ;
         Z2131ConveEscFrecAct = A2131ConveEscFrecAct ;
         Z2428ConveEsquemaEs = A2428ConveEsquemaEs ;
         Z935ConveSinCod = A935ConveSinCod ;
      }
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         Z936ConveSinDesc = A936ConveSinDesc ;
      }
      if ( GX_JID == -10 )
      {
         Z687ConveDescriSinAc = A687ConveDescriSinAc ;
         Z9ConveCodigo = A9ConveCodigo ;
         Z160ConveDescri = A160ConveDescri ;
         Z161ConveHabilitada = A161ConveHabilitada ;
         Z1915ConvBusGoogle = A1915ConvBusGoogle ;
         Z1916ConvBusWeb = A1916ConvBusWeb ;
         Z1917ConvBaseURL = A1917ConvBaseURL ;
         Z1918ConvScrapTipo = A1918ConvScrapTipo ;
         Z1919ConvScrapTDoc = A1919ConvScrapTDoc ;
         Z2131ConveEscFrecAct = A2131ConveEscFrecAct ;
         Z2428ConveEsquemaEs = A2428ConveEsquemaEs ;
         Z46PaiCod = A46PaiCod ;
         Z935ConveSinCod = A935ConveSinCod ;
         Z936ConveSinDesc = A936ConveSinDesc ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (false==A161ConveHabilitada) && ( Gx_BScreen == 0 ) )
      {
         A161ConveHabilitada = true ;
      }
   }

   public void load0E106( )
   {
      /* Using cursor BC000E9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound106 = (short)(1) ;
         A687ConveDescriSinAc = BC000E9_A687ConveDescriSinAc[0] ;
         A160ConveDescri = BC000E9_A160ConveDescri[0] ;
         A161ConveHabilitada = BC000E9_A161ConveHabilitada[0] ;
         A936ConveSinDesc = BC000E9_A936ConveSinDesc[0] ;
         A1915ConvBusGoogle = BC000E9_A1915ConvBusGoogle[0] ;
         n1915ConvBusGoogle = BC000E9_n1915ConvBusGoogle[0] ;
         A1916ConvBusWeb = BC000E9_A1916ConvBusWeb[0] ;
         n1916ConvBusWeb = BC000E9_n1916ConvBusWeb[0] ;
         A1917ConvBaseURL = BC000E9_A1917ConvBaseURL[0] ;
         n1917ConvBaseURL = BC000E9_n1917ConvBaseURL[0] ;
         A1918ConvScrapTipo = BC000E9_A1918ConvScrapTipo[0] ;
         n1918ConvScrapTipo = BC000E9_n1918ConvScrapTipo[0] ;
         A1919ConvScrapTDoc = BC000E9_A1919ConvScrapTDoc[0] ;
         n1919ConvScrapTDoc = BC000E9_n1919ConvScrapTDoc[0] ;
         A2131ConveEscFrecAct = BC000E9_A2131ConveEscFrecAct[0] ;
         A2428ConveEsquemaEs = BC000E9_A2428ConveEsquemaEs[0] ;
         A935ConveSinCod = BC000E9_A935ConveSinCod[0] ;
         n935ConveSinCod = BC000E9_n935ConveSinCod[0] ;
         zm0E106( -10) ;
      }
      pr_default.close(7);
      onLoadActions0E106( ) ;
   }

   public void onLoadActions0E106( )
   {
      AV26Pgmname = "Convenio_BC" ;
      GXt_char4 = A687ConveDescriSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A160ConveDescri, GXv_char5) ;
      convenio_bc.this.GXt_char4 = GXv_char5[0] ;
      A687ConveDescriSinAc = GXt_char4 ;
   }

   public void checkExtendedTable0E106( )
   {
      nIsDirty_106 = (short)(0) ;
      standaloneModal( ) ;
      AV26Pgmname = "Convenio_BC" ;
      /* Using cursor BC000E10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(8);
      /* Using cursor BC000E11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n935ConveSinCod), A935ConveSinCod});
      if ( (pr_default.getStatus(9) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (GXutil.strcmp("", A935ConveSinCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Sindicato Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVESINCOD");
            AnyError = (short)(1) ;
         }
      }
      A936ConveSinDesc = BC000E11_A936ConveSinDesc[0] ;
      pr_default.close(9);
      if ( (GXutil.strcmp("", A9ConveCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Convenio", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      nIsDirty_106 = (short)(1) ;
      GXt_char4 = A687ConveDescriSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A160ConveDescri, GXv_char5) ;
      convenio_bc.this.GXt_char4 = GXv_char5[0] ;
      A687ConveDescriSinAc = GXt_char4 ;
      if ( (GXutil.strcmp("", A160ConveDescri)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Convenio", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A1917ConvBaseURL,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") || (GXutil.strcmp("", A1917ConvBaseURL)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXM_DoesNotMatchRegExp", ""), httpContext.getMessage( "Conv Base URL", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1918ConvScrapTipo, "Tabla") == 0 ) || ( GXutil.strcmp(A1918ConvScrapTipo, "Texto") == 0 ) || ( GXutil.strcmp(A1918ConvScrapTipo, "Imagen") == 0 ) || (GXutil.strcmp("", A1918ConvScrapTipo)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Conv Scrap Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1919ConvScrapTDoc, "HTML") == 0 ) || ( GXutil.strcmp(A1919ConvScrapTDoc, "PDF") == 0 ) || (GXutil.strcmp("", A1919ConvScrapTDoc)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Conv Scrap TDoc", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0E106( )
   {
      pr_default.close(8);
      pr_default.close(9);
   }

   public void enableDisable( )
   {
   }

   public void getKey0E106( )
   {
      /* Using cursor BC000E12 */
      pr_default.execute(10, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound106 = (short)(1) ;
      }
      else
      {
         RcdFound106 = (short)(0) ;
      }
      pr_default.close(10);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000E13 */
      pr_default.execute(11, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
      if ( (pr_default.getStatus(11) != 101) )
      {
         zm0E106( 10) ;
         RcdFound106 = (short)(1) ;
         A687ConveDescriSinAc = BC000E13_A687ConveDescriSinAc[0] ;
         A9ConveCodigo = BC000E13_A9ConveCodigo[0] ;
         A160ConveDescri = BC000E13_A160ConveDescri[0] ;
         A161ConveHabilitada = BC000E13_A161ConveHabilitada[0] ;
         A1915ConvBusGoogle = BC000E13_A1915ConvBusGoogle[0] ;
         n1915ConvBusGoogle = BC000E13_n1915ConvBusGoogle[0] ;
         A1916ConvBusWeb = BC000E13_A1916ConvBusWeb[0] ;
         n1916ConvBusWeb = BC000E13_n1916ConvBusWeb[0] ;
         A1917ConvBaseURL = BC000E13_A1917ConvBaseURL[0] ;
         n1917ConvBaseURL = BC000E13_n1917ConvBaseURL[0] ;
         A1918ConvScrapTipo = BC000E13_A1918ConvScrapTipo[0] ;
         n1918ConvScrapTipo = BC000E13_n1918ConvScrapTipo[0] ;
         A1919ConvScrapTDoc = BC000E13_A1919ConvScrapTDoc[0] ;
         n1919ConvScrapTDoc = BC000E13_n1919ConvScrapTDoc[0] ;
         A2131ConveEscFrecAct = BC000E13_A2131ConveEscFrecAct[0] ;
         A2428ConveEsquemaEs = BC000E13_A2428ConveEsquemaEs[0] ;
         A46PaiCod = BC000E13_A46PaiCod[0] ;
         A935ConveSinCod = BC000E13_A935ConveSinCod[0] ;
         n935ConveSinCod = BC000E13_n935ConveSinCod[0] ;
         Z46PaiCod = A46PaiCod ;
         Z9ConveCodigo = A9ConveCodigo ;
         sMode106 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0E106( ) ;
         if ( AnyError == 1 )
         {
            RcdFound106 = (short)(0) ;
            initializeNonKey0E106( ) ;
         }
         Gx_mode = sMode106 ;
      }
      else
      {
         RcdFound106 = (short)(0) ;
         initializeNonKey0E106( ) ;
         sMode106 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode106 ;
      }
      pr_default.close(11);
   }

   public void getEqualNoModal( )
   {
      getKey0E106( ) ;
      if ( RcdFound106 == 0 )
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
      confirm_0E0( ) ;
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

   public void checkOptimisticConcurrency0E106( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000E14 */
         pr_default.execute(12, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(12) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Convenio"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(12) == 101) || ( GXutil.strcmp(Z687ConveDescriSinAc, BC000E14_A687ConveDescriSinAc[0]) != 0 ) || ( GXutil.strcmp(Z160ConveDescri, BC000E14_A160ConveDescri[0]) != 0 ) || ( Z161ConveHabilitada != BC000E14_A161ConveHabilitada[0] ) || ( GXutil.strcmp(Z1915ConvBusGoogle, BC000E14_A1915ConvBusGoogle[0]) != 0 ) || ( GXutil.strcmp(Z1916ConvBusWeb, BC000E14_A1916ConvBusWeb[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1917ConvBaseURL, BC000E14_A1917ConvBaseURL[0]) != 0 ) || ( GXutil.strcmp(Z1918ConvScrapTipo, BC000E14_A1918ConvScrapTipo[0]) != 0 ) || ( GXutil.strcmp(Z1919ConvScrapTDoc, BC000E14_A1919ConvScrapTDoc[0]) != 0 ) || ( Z2131ConveEscFrecAct != BC000E14_A2131ConveEscFrecAct[0] ) || ( Z2428ConveEsquemaEs != BC000E14_A2428ConveEsquemaEs[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z935ConveSinCod, BC000E14_A935ConveSinCod[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Convenio"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0E106( )
   {
      beforeValidate0E106( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0E106( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0E106( 0) ;
         checkOptimisticConcurrency0E106( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0E106( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0E106( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000E15 */
                  pr_default.execute(13, new Object[] {A687ConveDescriSinAc, A9ConveCodigo, A160ConveDescri, Boolean.valueOf(A161ConveHabilitada), Boolean.valueOf(n1915ConvBusGoogle), A1915ConvBusGoogle, Boolean.valueOf(n1916ConvBusWeb), A1916ConvBusWeb, Boolean.valueOf(n1917ConvBaseURL), A1917ConvBaseURL, Boolean.valueOf(n1918ConvScrapTipo), A1918ConvScrapTipo, Boolean.valueOf(n1919ConvScrapTDoc), A1919ConvScrapTDoc, Short.valueOf(A2131ConveEscFrecAct), Boolean.valueOf(A2428ConveEsquemaEs), Short.valueOf(A46PaiCod), Boolean.valueOf(n935ConveSinCod), A935ConveSinCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio");
                  if ( (pr_default.getStatus(13) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0E106( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                        }
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
            load0E106( ) ;
         }
         endLevel0E106( ) ;
      }
      closeExtendedTableCursors0E106( ) ;
   }

   public void update0E106( )
   {
      beforeValidate0E106( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0E106( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0E106( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0E106( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0E106( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000E16 */
                  pr_default.execute(14, new Object[] {A687ConveDescriSinAc, A160ConveDescri, Boolean.valueOf(A161ConveHabilitada), Boolean.valueOf(n1915ConvBusGoogle), A1915ConvBusGoogle, Boolean.valueOf(n1916ConvBusWeb), A1916ConvBusWeb, Boolean.valueOf(n1917ConvBaseURL), A1917ConvBaseURL, Boolean.valueOf(n1918ConvScrapTipo), A1918ConvScrapTipo, Boolean.valueOf(n1919ConvScrapTDoc), A1919ConvScrapTDoc, Short.valueOf(A2131ConveEscFrecAct), Boolean.valueOf(A2428ConveEsquemaEs), Boolean.valueOf(n935ConveSinCod), A935ConveSinCod, Short.valueOf(A46PaiCod), A9ConveCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio");
                  if ( (pr_default.getStatus(14) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Convenio"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0E106( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0E106( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
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
         }
         endLevel0E106( ) ;
      }
      closeExtendedTableCursors0E106( ) ;
   }

   public void deferredUpdate0E106( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0E106( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0E106( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0E106( ) ;
         afterConfirm0E106( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0E106( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart0E275( ) ;
               while ( RcdFound275 != 0 )
               {
                  getByPrimaryKey0E275( ) ;
                  delete0E275( ) ;
                  scanKeyNext0E275( ) ;
               }
               scanKeyEnd0E275( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000E17 */
                  pr_default.execute(15, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio");
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
      }
      sMode106 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0E106( ) ;
      Gx_mode = sMode106 ;
   }

   public void onDeleteControls0E106( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV26Pgmname = "Convenio_BC" ;
         /* Using cursor BC000E18 */
         pr_default.execute(16, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n935ConveSinCod), A935ConveSinCod});
         A936ConveSinDesc = BC000E18_A936ConveSinDesc[0] ;
         pr_default.close(16);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000E19 */
         pr_default.execute(17, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
         /* Using cursor BC000E20 */
         pr_default.execute(18, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(18) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente Convenios", "")+" ("+httpContext.getMessage( "Cliente Conve Versiones", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
         /* Using cursor BC000E21 */
         pr_default.execute(19, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(19) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente Convenios", "")+" ("+httpContext.getMessage( "Cliente Conve Versiones", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(19);
         /* Using cursor BC000E22 */
         pr_default.execute(20, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(20) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(20);
         /* Using cursor BC000E23 */
         pr_default.execute(21, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "feriado", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
         /* Using cursor BC000E24 */
         pr_default.execute(22, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Dias de vacaciones por antiguedad", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
      }
   }

   public void processNestedLevel0E275( )
   {
      nGXsfl_275_idx = 0 ;
      while ( nGXsfl_275_idx < bcConvenio.getgxTv_SdtConvenio_Propiedadesadicionales().size() )
      {
         readRow0E275( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound275 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_275 != 0 ) )
         {
            standaloneNotModal0E275( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0E275( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0E275( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0E275( ) ;
               }
            }
         }
         KeyVarsToRow275( ((web.SdtConvenio_PropiedadesAdicionales)bcConvenio.getgxTv_SdtConvenio_Propiedadesadicionales().elementAt(-1+nGXsfl_275_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_275_idx = 0 ;
         while ( nGXsfl_275_idx < bcConvenio.getgxTv_SdtConvenio_Propiedadesadicionales().size() )
         {
            readRow0E275( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound275 == 0 )
               {
                  Gx_mode = "INS" ;
               }
               else
               {
                  Gx_mode = "UPD" ;
               }
            }
            /* Update SDT row */
            if ( isDlt( ) )
            {
               bcConvenio.getgxTv_SdtConvenio_Propiedadesadicionales().removeElement(nGXsfl_275_idx);
               nGXsfl_275_idx = (int)(nGXsfl_275_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0E275( ) ;
               VarsToRow275( ((web.SdtConvenio_PropiedadesAdicionales)bcConvenio.getgxTv_SdtConvenio_Propiedadesadicionales().elementAt(-1+nGXsfl_275_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0E275( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_275 = (short)(0) ;
      nIsMod_275 = (short)(0) ;
      Gxremove275 = (byte)(0) ;
   }

   public void processLevel0E106( )
   {
      /* Save parent mode. */
      sMode106 = Gx_mode ;
      processNestedLevel0E275( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode106 ;
      /* ' Update level parameters */
   }

   public void endLevel0E106( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(12);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0E106( ) ;
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

   public void scanKeyStart0E106( )
   {
      /* Scan By routine */
      /* Using cursor BC000E25 */
      pr_default.execute(23, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
      RcdFound106 = (short)(0) ;
      if ( (pr_default.getStatus(23) != 101) )
      {
         RcdFound106 = (short)(1) ;
         A687ConveDescriSinAc = BC000E25_A687ConveDescriSinAc[0] ;
         A9ConveCodigo = BC000E25_A9ConveCodigo[0] ;
         A160ConveDescri = BC000E25_A160ConveDescri[0] ;
         A161ConveHabilitada = BC000E25_A161ConveHabilitada[0] ;
         A936ConveSinDesc = BC000E25_A936ConveSinDesc[0] ;
         A1915ConvBusGoogle = BC000E25_A1915ConvBusGoogle[0] ;
         n1915ConvBusGoogle = BC000E25_n1915ConvBusGoogle[0] ;
         A1916ConvBusWeb = BC000E25_A1916ConvBusWeb[0] ;
         n1916ConvBusWeb = BC000E25_n1916ConvBusWeb[0] ;
         A1917ConvBaseURL = BC000E25_A1917ConvBaseURL[0] ;
         n1917ConvBaseURL = BC000E25_n1917ConvBaseURL[0] ;
         A1918ConvScrapTipo = BC000E25_A1918ConvScrapTipo[0] ;
         n1918ConvScrapTipo = BC000E25_n1918ConvScrapTipo[0] ;
         A1919ConvScrapTDoc = BC000E25_A1919ConvScrapTDoc[0] ;
         n1919ConvScrapTDoc = BC000E25_n1919ConvScrapTDoc[0] ;
         A2131ConveEscFrecAct = BC000E25_A2131ConveEscFrecAct[0] ;
         A2428ConveEsquemaEs = BC000E25_A2428ConveEsquemaEs[0] ;
         A46PaiCod = BC000E25_A46PaiCod[0] ;
         A935ConveSinCod = BC000E25_A935ConveSinCod[0] ;
         n935ConveSinCod = BC000E25_n935ConveSinCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0E106( )
   {
      /* Scan next routine */
      pr_default.readNext(23);
      RcdFound106 = (short)(0) ;
      scanKeyLoad0E106( ) ;
   }

   public void scanKeyLoad0E106( )
   {
      sMode106 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(23) != 101) )
      {
         RcdFound106 = (short)(1) ;
         A687ConveDescriSinAc = BC000E25_A687ConveDescriSinAc[0] ;
         A9ConveCodigo = BC000E25_A9ConveCodigo[0] ;
         A160ConveDescri = BC000E25_A160ConveDescri[0] ;
         A161ConveHabilitada = BC000E25_A161ConveHabilitada[0] ;
         A936ConveSinDesc = BC000E25_A936ConveSinDesc[0] ;
         A1915ConvBusGoogle = BC000E25_A1915ConvBusGoogle[0] ;
         n1915ConvBusGoogle = BC000E25_n1915ConvBusGoogle[0] ;
         A1916ConvBusWeb = BC000E25_A1916ConvBusWeb[0] ;
         n1916ConvBusWeb = BC000E25_n1916ConvBusWeb[0] ;
         A1917ConvBaseURL = BC000E25_A1917ConvBaseURL[0] ;
         n1917ConvBaseURL = BC000E25_n1917ConvBaseURL[0] ;
         A1918ConvScrapTipo = BC000E25_A1918ConvScrapTipo[0] ;
         n1918ConvScrapTipo = BC000E25_n1918ConvScrapTipo[0] ;
         A1919ConvScrapTDoc = BC000E25_A1919ConvScrapTDoc[0] ;
         n1919ConvScrapTDoc = BC000E25_n1919ConvScrapTDoc[0] ;
         A2131ConveEscFrecAct = BC000E25_A2131ConveEscFrecAct[0] ;
         A2428ConveEsquemaEs = BC000E25_A2428ConveEsquemaEs[0] ;
         A46PaiCod = BC000E25_A46PaiCod[0] ;
         A935ConveSinCod = BC000E25_A935ConveSinCod[0] ;
         n935ConveSinCod = BC000E25_n935ConveSinCod[0] ;
      }
      Gx_mode = sMode106 ;
   }

   public void scanKeyEnd0E106( )
   {
      pr_default.close(23);
   }

   public void afterConfirm0E106( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0E106( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0E106( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0E106( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0E106( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0E106( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0E106( )
   {
   }

   public void zm0E275( int GX_JID )
   {
      if ( ( GX_JID == 13 ) || ( GX_JID == 0 ) )
      {
         Z2262ConvePropPredet = A2262ConvePropPredet ;
      }
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         Z2228propDesc = A2228propDesc ;
         Z2229propTipoDato = A2229propTipoDato ;
      }
      if ( GX_JID == -13 )
      {
         Z46PaiCod = A46PaiCod ;
         Z9ConveCodigo = A9ConveCodigo ;
         Z2262ConvePropPredet = A2262ConvePropPredet ;
         Z2227propCod = A2227propCod ;
         Z2228propDesc = A2228propDesc ;
         Z2229propTipoDato = A2229propTipoDato ;
      }
   }

   public void standaloneNotModal0E275( )
   {
   }

   public void standaloneModal0E275( )
   {
   }

   public void load0E275( )
   {
      /* Using cursor BC000E26 */
      pr_default.execute(24, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A2227propCod});
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound275 = (short)(1) ;
         A2228propDesc = BC000E26_A2228propDesc[0] ;
         A2229propTipoDato = BC000E26_A2229propTipoDato[0] ;
         A2262ConvePropPredet = BC000E26_A2262ConvePropPredet[0] ;
         zm0E275( -13) ;
      }
      pr_default.close(24);
      onLoadActions0E275( ) ;
   }

   public void onLoadActions0E275( )
   {
   }

   public void checkExtendedTable0E275( )
   {
      nIsDirty_275 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0E275( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000E27 */
      pr_default.execute(25, new Object[] {A2227propCod});
      if ( (pr_default.getStatus(25) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "propiedades_adicionales", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROPCOD");
         AnyError = (short)(1) ;
      }
      A2228propDesc = BC000E27_A2228propDesc[0] ;
      A2229propTipoDato = BC000E27_A2229propTipoDato[0] ;
      pr_default.close(25);
   }

   public void closeExtendedTableCursors0E275( )
   {
      pr_default.close(25);
   }

   public void enableDisable0E275( )
   {
   }

   public void getKey0E275( )
   {
      /* Using cursor BC000E28 */
      pr_default.execute(26, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A2227propCod});
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound275 = (short)(1) ;
      }
      else
      {
         RcdFound275 = (short)(0) ;
      }
      pr_default.close(26);
   }

   public void getByPrimaryKey0E275( )
   {
      /* Using cursor BC000E29 */
      pr_default.execute(27, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A2227propCod});
      if ( (pr_default.getStatus(27) != 101) )
      {
         zm0E275( 13) ;
         RcdFound275 = (short)(1) ;
         initializeNonKey0E275( ) ;
         A2262ConvePropPredet = BC000E29_A2262ConvePropPredet[0] ;
         A2227propCod = BC000E29_A2227propCod[0] ;
         Z46PaiCod = A46PaiCod ;
         Z9ConveCodigo = A9ConveCodigo ;
         Z2227propCod = A2227propCod ;
         sMode275 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0E275( ) ;
         Gx_mode = sMode275 ;
      }
      else
      {
         RcdFound275 = (short)(0) ;
         initializeNonKey0E275( ) ;
         sMode275 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0E275( ) ;
         Gx_mode = sMode275 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0E275( ) ;
      }
      pr_default.close(27);
   }

   public void checkOptimisticConcurrency0E275( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000E30 */
         pr_default.execute(28, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A2227propCod});
         if ( (pr_default.getStatus(28) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConvenioPropiedadesAdicionales"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(28) == 101) || ( GXutil.strcmp(Z2262ConvePropPredet, BC000E30_A2262ConvePropPredet[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ConvenioPropiedadesAdicionales"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0E275( )
   {
      beforeValidate0E275( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0E275( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0E275( 0) ;
         checkOptimisticConcurrency0E275( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0E275( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0E275( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000E31 */
                  pr_default.execute(29, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A2262ConvePropPredet, A2227propCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConvenioPropiedadesAdicionales");
                  if ( (pr_default.getStatus(29) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
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
            load0E275( ) ;
         }
         endLevel0E275( ) ;
      }
      closeExtendedTableCursors0E275( ) ;
   }

   public void update0E275( )
   {
      beforeValidate0E275( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0E275( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0E275( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0E275( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0E275( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000E32 */
                  pr_default.execute(30, new Object[] {A2262ConvePropPredet, Short.valueOf(A46PaiCod), A9ConveCodigo, A2227propCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConvenioPropiedadesAdicionales");
                  if ( (pr_default.getStatus(30) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConvenioPropiedadesAdicionales"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0E275( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0E275( ) ;
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
         endLevel0E275( ) ;
      }
      closeExtendedTableCursors0E275( ) ;
   }

   public void deferredUpdate0E275( )
   {
   }

   public void delete0E275( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0E275( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0E275( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0E275( ) ;
         afterConfirm0E275( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0E275( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000E33 */
               pr_default.execute(31, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A2227propCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConvenioPropiedadesAdicionales");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode275 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0E275( ) ;
      Gx_mode = sMode275 ;
   }

   public void onDeleteControls0E275( )
   {
      standaloneModal0E275( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000E34 */
         pr_default.execute(32, new Object[] {A2227propCod});
         A2228propDesc = BC000E34_A2228propDesc[0] ;
         A2229propTipoDato = BC000E34_A2229propTipoDato[0] ;
         pr_default.close(32);
      }
   }

   public void endLevel0E275( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(28);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0E275( )
   {
      /* Scan By routine */
      /* Using cursor BC000E35 */
      pr_default.execute(33, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
      RcdFound275 = (short)(0) ;
      if ( (pr_default.getStatus(33) != 101) )
      {
         RcdFound275 = (short)(1) ;
         A2228propDesc = BC000E35_A2228propDesc[0] ;
         A2229propTipoDato = BC000E35_A2229propTipoDato[0] ;
         A2262ConvePropPredet = BC000E35_A2262ConvePropPredet[0] ;
         A2227propCod = BC000E35_A2227propCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0E275( )
   {
      /* Scan next routine */
      pr_default.readNext(33);
      RcdFound275 = (short)(0) ;
      scanKeyLoad0E275( ) ;
   }

   public void scanKeyLoad0E275( )
   {
      sMode275 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(33) != 101) )
      {
         RcdFound275 = (short)(1) ;
         A2228propDesc = BC000E35_A2228propDesc[0] ;
         A2229propTipoDato = BC000E35_A2229propTipoDato[0] ;
         A2262ConvePropPredet = BC000E35_A2262ConvePropPredet[0] ;
         A2227propCod = BC000E35_A2227propCod[0] ;
      }
      Gx_mode = sMode275 ;
   }

   public void scanKeyEnd0E275( )
   {
      pr_default.close(33);
   }

   public void afterConfirm0E275( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0E275( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0E275( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0E275( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0E275( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0E275( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0E275( )
   {
   }

   public void send_integrity_lvl_hashes0E275( )
   {
   }

   public void send_integrity_lvl_hashes0E106( )
   {
   }

   public void addRow0E106( )
   {
      VarsToRow106( bcConvenio) ;
   }

   public void readRow0E106( )
   {
      RowToVars106( bcConvenio, 1) ;
   }

   public void addRow0E275( )
   {
      web.SdtConvenio_PropiedadesAdicionales obj275;
      obj275 = new web.SdtConvenio_PropiedadesAdicionales(remoteHandle);
      VarsToRow275( obj275) ;
      bcConvenio.getgxTv_SdtConvenio_Propiedadesadicionales().add(obj275, 0);
      obj275.setgxTv_SdtConvenio_PropiedadesAdicionales_Mode( "UPD" );
      obj275.setgxTv_SdtConvenio_PropiedadesAdicionales_Modified( (short)(0) );
   }

   public void readRow0E275( )
   {
      nGXsfl_275_idx = (int)(nGXsfl_275_idx+1) ;
      RowToVars275( ((web.SdtConvenio_PropiedadesAdicionales)bcConvenio.getgxTv_SdtConvenio_Propiedadesadicionales().elementAt(-1+nGXsfl_275_idx)), 1) ;
   }

   public void initializeNonKey0E106( )
   {
      A687ConveDescriSinAc = "" ;
      A160ConveDescri = "" ;
      A935ConveSinCod = "" ;
      n935ConveSinCod = false ;
      A936ConveSinDesc = "" ;
      A1915ConvBusGoogle = "" ;
      n1915ConvBusGoogle = false ;
      A1916ConvBusWeb = "" ;
      n1916ConvBusWeb = false ;
      A1917ConvBaseURL = "" ;
      n1917ConvBaseURL = false ;
      A1918ConvScrapTipo = "" ;
      n1918ConvScrapTipo = false ;
      A1919ConvScrapTDoc = "" ;
      n1919ConvScrapTDoc = false ;
      A2131ConveEscFrecAct = (short)(0) ;
      A2428ConveEsquemaEs = false ;
      A161ConveHabilitada = true ;
      Z687ConveDescriSinAc = "" ;
      Z160ConveDescri = "" ;
      Z161ConveHabilitada = false ;
      Z1915ConvBusGoogle = "" ;
      Z1916ConvBusWeb = "" ;
      Z1917ConvBaseURL = "" ;
      Z1918ConvScrapTipo = "" ;
      Z1919ConvScrapTDoc = "" ;
      Z2131ConveEscFrecAct = (short)(0) ;
      Z2428ConveEsquemaEs = false ;
      Z935ConveSinCod = "" ;
   }

   public void initAll0E106( )
   {
      A46PaiCod = (short)(0) ;
      A9ConveCodigo = "" ;
      initializeNonKey0E106( ) ;
   }

   public void standaloneModalInsert( )
   {
      A161ConveHabilitada = i161ConveHabilitada ;
   }

   public void initializeNonKey0E275( )
   {
      A2228propDesc = "" ;
      A2229propTipoDato = "" ;
      A2262ConvePropPredet = "" ;
      Z2262ConvePropPredet = "" ;
   }

   public void initAll0E275( )
   {
      A2227propCod = "" ;
      initializeNonKey0E275( ) ;
   }

   public void standaloneModalInsert0E275( )
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

   public void VarsToRow106( web.SdtConvenio obj106 )
   {
      obj106.setgxTv_SdtConvenio_Mode( Gx_mode );
      obj106.setgxTv_SdtConvenio_Convedescrisinac( A687ConveDescriSinAc );
      obj106.setgxTv_SdtConvenio_Convedescri( A160ConveDescri );
      obj106.setgxTv_SdtConvenio_Convesincod( A935ConveSinCod );
      obj106.setgxTv_SdtConvenio_Convesindesc( A936ConveSinDesc );
      obj106.setgxTv_SdtConvenio_Convbusgoogle( A1915ConvBusGoogle );
      obj106.setgxTv_SdtConvenio_Convbusweb( A1916ConvBusWeb );
      obj106.setgxTv_SdtConvenio_Convbaseurl( A1917ConvBaseURL );
      obj106.setgxTv_SdtConvenio_Convscraptipo( A1918ConvScrapTipo );
      obj106.setgxTv_SdtConvenio_Convscraptdoc( A1919ConvScrapTDoc );
      obj106.setgxTv_SdtConvenio_Conveescfrecact( A2131ConveEscFrecAct );
      obj106.setgxTv_SdtConvenio_Conveesquemaes( A2428ConveEsquemaEs );
      obj106.setgxTv_SdtConvenio_Convehabilitada( A161ConveHabilitada );
      obj106.setgxTv_SdtConvenio_Paicod( A46PaiCod );
      obj106.setgxTv_SdtConvenio_Convecodigo( A9ConveCodigo );
      obj106.setgxTv_SdtConvenio_Paicod_Z( Z46PaiCod );
      obj106.setgxTv_SdtConvenio_Convecodigo_Z( Z9ConveCodigo );
      obj106.setgxTv_SdtConvenio_Convedescri_Z( Z160ConveDescri );
      obj106.setgxTv_SdtConvenio_Convehabilitada_Z( Z161ConveHabilitada );
      obj106.setgxTv_SdtConvenio_Convedescrisinac_Z( Z687ConveDescriSinAc );
      obj106.setgxTv_SdtConvenio_Convesincod_Z( Z935ConveSinCod );
      obj106.setgxTv_SdtConvenio_Convesindesc_Z( Z936ConveSinDesc );
      obj106.setgxTv_SdtConvenio_Convbusgoogle_Z( Z1915ConvBusGoogle );
      obj106.setgxTv_SdtConvenio_Convbusweb_Z( Z1916ConvBusWeb );
      obj106.setgxTv_SdtConvenio_Convbaseurl_Z( Z1917ConvBaseURL );
      obj106.setgxTv_SdtConvenio_Convscraptipo_Z( Z1918ConvScrapTipo );
      obj106.setgxTv_SdtConvenio_Convscraptdoc_Z( Z1919ConvScrapTDoc );
      obj106.setgxTv_SdtConvenio_Conveescfrecact_Z( Z2131ConveEscFrecAct );
      obj106.setgxTv_SdtConvenio_Conveesquemaes_Z( Z2428ConveEsquemaEs );
      obj106.setgxTv_SdtConvenio_Convesincod_N( (byte)((byte)((n935ConveSinCod)?1:0)) );
      obj106.setgxTv_SdtConvenio_Convbusgoogle_N( (byte)((byte)((n1915ConvBusGoogle)?1:0)) );
      obj106.setgxTv_SdtConvenio_Convbusweb_N( (byte)((byte)((n1916ConvBusWeb)?1:0)) );
      obj106.setgxTv_SdtConvenio_Convbaseurl_N( (byte)((byte)((n1917ConvBaseURL)?1:0)) );
      obj106.setgxTv_SdtConvenio_Convscraptipo_N( (byte)((byte)((n1918ConvScrapTipo)?1:0)) );
      obj106.setgxTv_SdtConvenio_Convscraptdoc_N( (byte)((byte)((n1919ConvScrapTDoc)?1:0)) );
      obj106.setgxTv_SdtConvenio_Mode( Gx_mode );
   }

   public void KeyVarsToRow106( web.SdtConvenio obj106 )
   {
      obj106.setgxTv_SdtConvenio_Paicod( A46PaiCod );
      obj106.setgxTv_SdtConvenio_Convecodigo( A9ConveCodigo );
   }

   public void RowToVars106( web.SdtConvenio obj106 ,
                             int forceLoad )
   {
      Gx_mode = obj106.getgxTv_SdtConvenio_Mode() ;
      A687ConveDescriSinAc = obj106.getgxTv_SdtConvenio_Convedescrisinac() ;
      A160ConveDescri = obj106.getgxTv_SdtConvenio_Convedescri() ;
      A935ConveSinCod = obj106.getgxTv_SdtConvenio_Convesincod() ;
      n935ConveSinCod = false ;
      A936ConveSinDesc = obj106.getgxTv_SdtConvenio_Convesindesc() ;
      A1915ConvBusGoogle = obj106.getgxTv_SdtConvenio_Convbusgoogle() ;
      n1915ConvBusGoogle = false ;
      A1916ConvBusWeb = obj106.getgxTv_SdtConvenio_Convbusweb() ;
      n1916ConvBusWeb = false ;
      A1917ConvBaseURL = obj106.getgxTv_SdtConvenio_Convbaseurl() ;
      n1917ConvBaseURL = false ;
      A1918ConvScrapTipo = obj106.getgxTv_SdtConvenio_Convscraptipo() ;
      n1918ConvScrapTipo = false ;
      A1919ConvScrapTDoc = obj106.getgxTv_SdtConvenio_Convscraptdoc() ;
      n1919ConvScrapTDoc = false ;
      A2131ConveEscFrecAct = obj106.getgxTv_SdtConvenio_Conveescfrecact() ;
      A2428ConveEsquemaEs = obj106.getgxTv_SdtConvenio_Conveesquemaes() ;
      A161ConveHabilitada = obj106.getgxTv_SdtConvenio_Convehabilitada() ;
      A46PaiCod = obj106.getgxTv_SdtConvenio_Paicod() ;
      A9ConveCodigo = obj106.getgxTv_SdtConvenio_Convecodigo() ;
      Z46PaiCod = obj106.getgxTv_SdtConvenio_Paicod_Z() ;
      Z9ConveCodigo = obj106.getgxTv_SdtConvenio_Convecodigo_Z() ;
      Z160ConveDescri = obj106.getgxTv_SdtConvenio_Convedescri_Z() ;
      Z161ConveHabilitada = obj106.getgxTv_SdtConvenio_Convehabilitada_Z() ;
      Z687ConveDescriSinAc = obj106.getgxTv_SdtConvenio_Convedescrisinac_Z() ;
      Z935ConveSinCod = obj106.getgxTv_SdtConvenio_Convesincod_Z() ;
      Z936ConveSinDesc = obj106.getgxTv_SdtConvenio_Convesindesc_Z() ;
      Z1915ConvBusGoogle = obj106.getgxTv_SdtConvenio_Convbusgoogle_Z() ;
      Z1916ConvBusWeb = obj106.getgxTv_SdtConvenio_Convbusweb_Z() ;
      Z1917ConvBaseURL = obj106.getgxTv_SdtConvenio_Convbaseurl_Z() ;
      Z1918ConvScrapTipo = obj106.getgxTv_SdtConvenio_Convscraptipo_Z() ;
      Z1919ConvScrapTDoc = obj106.getgxTv_SdtConvenio_Convscraptdoc_Z() ;
      Z2131ConveEscFrecAct = obj106.getgxTv_SdtConvenio_Conveescfrecact_Z() ;
      Z2428ConveEsquemaEs = obj106.getgxTv_SdtConvenio_Conveesquemaes_Z() ;
      n935ConveSinCod = (boolean)((obj106.getgxTv_SdtConvenio_Convesincod_N()==0)?false:true) ;
      n1915ConvBusGoogle = (boolean)((obj106.getgxTv_SdtConvenio_Convbusgoogle_N()==0)?false:true) ;
      n1916ConvBusWeb = (boolean)((obj106.getgxTv_SdtConvenio_Convbusweb_N()==0)?false:true) ;
      n1917ConvBaseURL = (boolean)((obj106.getgxTv_SdtConvenio_Convbaseurl_N()==0)?false:true) ;
      n1918ConvScrapTipo = (boolean)((obj106.getgxTv_SdtConvenio_Convscraptipo_N()==0)?false:true) ;
      n1919ConvScrapTDoc = (boolean)((obj106.getgxTv_SdtConvenio_Convscraptdoc_N()==0)?false:true) ;
      Gx_mode = obj106.getgxTv_SdtConvenio_Mode() ;
   }

   public void VarsToRow275( web.SdtConvenio_PropiedadesAdicionales obj275 )
   {
      obj275.setgxTv_SdtConvenio_PropiedadesAdicionales_Mode( Gx_mode );
      obj275.setgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc( A2228propDesc );
      obj275.setgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato( A2229propTipoDato );
      obj275.setgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet( A2262ConvePropPredet );
      obj275.setgxTv_SdtConvenio_PropiedadesAdicionales_Propcod( A2227propCod );
      obj275.setgxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z( Z2227propCod );
      obj275.setgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z( Z2228propDesc );
      obj275.setgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z( Z2229propTipoDato );
      obj275.setgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z( Z2262ConvePropPredet );
      obj275.setgxTv_SdtConvenio_PropiedadesAdicionales_Modified( nIsMod_275 );
   }

   public void KeyVarsToRow275( web.SdtConvenio_PropiedadesAdicionales obj275 )
   {
      obj275.setgxTv_SdtConvenio_PropiedadesAdicionales_Propcod( A2227propCod );
   }

   public void RowToVars275( web.SdtConvenio_PropiedadesAdicionales obj275 ,
                             int forceLoad )
   {
      Gx_mode = obj275.getgxTv_SdtConvenio_PropiedadesAdicionales_Mode() ;
      A2228propDesc = obj275.getgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc() ;
      A2229propTipoDato = obj275.getgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato() ;
      A2262ConvePropPredet = obj275.getgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet() ;
      A2227propCod = obj275.getgxTv_SdtConvenio_PropiedadesAdicionales_Propcod() ;
      Z2227propCod = obj275.getgxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z() ;
      Z2228propDesc = obj275.getgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z() ;
      Z2229propTipoDato = obj275.getgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z() ;
      Z2262ConvePropPredet = obj275.getgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z() ;
      nIsMod_275 = obj275.getgxTv_SdtConvenio_PropiedadesAdicionales_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      A9ConveCodigo = (String)getParm(obj,1) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0E106( ) ;
      scanKeyStart0E106( ) ;
      if ( RcdFound106 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000E36 */
         pr_default.execute(34, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(34) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z46PaiCod = A46PaiCod ;
         Z9ConveCodigo = A9ConveCodigo ;
      }
      zm0E106( -10) ;
      onLoadActions0E106( ) ;
      addRow0E106( ) ;
      bcConvenio.getgxTv_SdtConvenio_Propiedadesadicionales().clearCollection();
      if ( RcdFound106 == 1 )
      {
         scanKeyStart0E275( ) ;
         nGXsfl_275_idx = 1 ;
         while ( RcdFound275 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z9ConveCodigo = A9ConveCodigo ;
            Z2227propCod = A2227propCod ;
            zm0E275( -13) ;
            onLoadActions0E275( ) ;
            nRcdExists_275 = (short)(1) ;
            nIsMod_275 = (short)(0) ;
            addRow0E275( ) ;
            nGXsfl_275_idx = (int)(nGXsfl_275_idx+1) ;
            scanKeyNext0E275( ) ;
         }
         scanKeyEnd0E275( ) ;
      }
      scanKeyEnd0E106( ) ;
      if ( RcdFound106 == 0 )
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
      RowToVars106( bcConvenio, 0) ;
      scanKeyStart0E106( ) ;
      if ( RcdFound106 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000E37 */
         pr_default.execute(35, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(35) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z46PaiCod = A46PaiCod ;
         Z9ConveCodigo = A9ConveCodigo ;
      }
      zm0E106( -10) ;
      onLoadActions0E106( ) ;
      addRow0E106( ) ;
      bcConvenio.getgxTv_SdtConvenio_Propiedadesadicionales().clearCollection();
      if ( RcdFound106 == 1 )
      {
         scanKeyStart0E275( ) ;
         nGXsfl_275_idx = 1 ;
         while ( RcdFound275 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z9ConveCodigo = A9ConveCodigo ;
            Z2227propCod = A2227propCod ;
            zm0E275( -13) ;
            onLoadActions0E275( ) ;
            nRcdExists_275 = (short)(1) ;
            nIsMod_275 = (short)(0) ;
            addRow0E275( ) ;
            nGXsfl_275_idx = (int)(nGXsfl_275_idx+1) ;
            scanKeyNext0E275( ) ;
         }
         scanKeyEnd0E275( ) ;
      }
      scanKeyEnd0E106( ) ;
      if ( RcdFound106 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0E106( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0E106( ) ;
      }
      else
      {
         if ( RcdFound106 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A9ConveCodigo, Z9ConveCodigo) != 0 ) )
            {
               A46PaiCod = Z46PaiCod ;
               A9ConveCodigo = Z9ConveCodigo ;
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
               update0E106( ) ;
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
               if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A9ConveCodigo, Z9ConveCodigo) != 0 ) )
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
                     insert0E106( ) ;
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
                     insert0E106( ) ;
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
      RowToVars106( bcConvenio, 1) ;
      saveImpl( ) ;
      VarsToRow106( bcConvenio) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars106( bcConvenio, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0E106( ) ;
      afterTrn( ) ;
      VarsToRow106( bcConvenio) ;
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
         web.SdtConvenio auxBC = new web.SdtConvenio( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A46PaiCod, A9ConveCodigo);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcConvenio);
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
      RowToVars106( bcConvenio, 1) ;
      updateImpl( ) ;
      VarsToRow106( bcConvenio) ;
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
      RowToVars106( bcConvenio, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0E106( ) ;
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
      VarsToRow106( bcConvenio) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars106( bcConvenio, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0E106( ) ;
      if ( RcdFound106 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A9ConveCodigo, Z9ConveCodigo) != 0 ) )
         {
            A46PaiCod = Z46PaiCod ;
            A9ConveCodigo = Z9ConveCodigo ;
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
         if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A9ConveCodigo, Z9ConveCodigo) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "convenio_bc");
      VarsToRow106( bcConvenio) ;
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
      Gx_mode = bcConvenio.getgxTv_SdtConvenio_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcConvenio.setgxTv_SdtConvenio_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtConvenio sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcConvenio )
      {
         bcConvenio = sdt ;
         if ( GXutil.strcmp(bcConvenio.getgxTv_SdtConvenio_Mode(), "") == 0 )
         {
            bcConvenio.setgxTv_SdtConvenio_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow106( bcConvenio) ;
         }
         else
         {
            RowToVars106( bcConvenio, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcConvenio.getgxTv_SdtConvenio_Mode(), "") == 0 )
         {
            bcConvenio.setgxTv_SdtConvenio_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars106( bcConvenio, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtConvenio getConvenio_BC( )
   {
      return bcConvenio ;
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
      Z9ConveCodigo = "" ;
      A9ConveCodigo = "" ;
      sMode106 = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV26Pgmname = "" ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      AV15TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV18Insert_ConveSinCod = "" ;
      Z687ConveDescriSinAc = "" ;
      A687ConveDescriSinAc = "" ;
      Z160ConveDescri = "" ;
      A160ConveDescri = "" ;
      Z1915ConvBusGoogle = "" ;
      A1915ConvBusGoogle = "" ;
      Z1916ConvBusWeb = "" ;
      A1916ConvBusWeb = "" ;
      Z1917ConvBaseURL = "" ;
      A1917ConvBaseURL = "" ;
      Z1918ConvScrapTipo = "" ;
      A1918ConvScrapTipo = "" ;
      Z1919ConvScrapTDoc = "" ;
      A1919ConvScrapTDoc = "" ;
      Z935ConveSinCod = "" ;
      A935ConveSinCod = "" ;
      Z936ConveSinDesc = "" ;
      A936ConveSinDesc = "" ;
      BC000E9_A687ConveDescriSinAc = new String[] {""} ;
      BC000E9_A9ConveCodigo = new String[] {""} ;
      BC000E9_A160ConveDescri = new String[] {""} ;
      BC000E9_A161ConveHabilitada = new boolean[] {false} ;
      BC000E9_A936ConveSinDesc = new String[] {""} ;
      BC000E9_A1915ConvBusGoogle = new String[] {""} ;
      BC000E9_n1915ConvBusGoogle = new boolean[] {false} ;
      BC000E9_A1916ConvBusWeb = new String[] {""} ;
      BC000E9_n1916ConvBusWeb = new boolean[] {false} ;
      BC000E9_A1917ConvBaseURL = new String[] {""} ;
      BC000E9_n1917ConvBaseURL = new boolean[] {false} ;
      BC000E9_A1918ConvScrapTipo = new String[] {""} ;
      BC000E9_n1918ConvScrapTipo = new boolean[] {false} ;
      BC000E9_A1919ConvScrapTDoc = new String[] {""} ;
      BC000E9_n1919ConvScrapTDoc = new boolean[] {false} ;
      BC000E9_A2131ConveEscFrecAct = new short[1] ;
      BC000E9_A2428ConveEsquemaEs = new boolean[] {false} ;
      BC000E9_A46PaiCod = new short[1] ;
      BC000E9_A935ConveSinCod = new String[] {""} ;
      BC000E9_n935ConveSinCod = new boolean[] {false} ;
      BC000E10_A46PaiCod = new short[1] ;
      BC000E11_A936ConveSinDesc = new String[] {""} ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      BC000E12_A46PaiCod = new short[1] ;
      BC000E12_A9ConveCodigo = new String[] {""} ;
      BC000E13_A687ConveDescriSinAc = new String[] {""} ;
      BC000E13_A9ConveCodigo = new String[] {""} ;
      BC000E13_A160ConveDescri = new String[] {""} ;
      BC000E13_A161ConveHabilitada = new boolean[] {false} ;
      BC000E13_A1915ConvBusGoogle = new String[] {""} ;
      BC000E13_n1915ConvBusGoogle = new boolean[] {false} ;
      BC000E13_A1916ConvBusWeb = new String[] {""} ;
      BC000E13_n1916ConvBusWeb = new boolean[] {false} ;
      BC000E13_A1917ConvBaseURL = new String[] {""} ;
      BC000E13_n1917ConvBaseURL = new boolean[] {false} ;
      BC000E13_A1918ConvScrapTipo = new String[] {""} ;
      BC000E13_n1918ConvScrapTipo = new boolean[] {false} ;
      BC000E13_A1919ConvScrapTDoc = new String[] {""} ;
      BC000E13_n1919ConvScrapTDoc = new boolean[] {false} ;
      BC000E13_A2131ConveEscFrecAct = new short[1] ;
      BC000E13_A2428ConveEsquemaEs = new boolean[] {false} ;
      BC000E13_A46PaiCod = new short[1] ;
      BC000E13_A935ConveSinCod = new String[] {""} ;
      BC000E13_n935ConveSinCod = new boolean[] {false} ;
      BC000E14_A687ConveDescriSinAc = new String[] {""} ;
      BC000E14_A9ConveCodigo = new String[] {""} ;
      BC000E14_A160ConveDescri = new String[] {""} ;
      BC000E14_A161ConveHabilitada = new boolean[] {false} ;
      BC000E14_A1915ConvBusGoogle = new String[] {""} ;
      BC000E14_n1915ConvBusGoogle = new boolean[] {false} ;
      BC000E14_A1916ConvBusWeb = new String[] {""} ;
      BC000E14_n1916ConvBusWeb = new boolean[] {false} ;
      BC000E14_A1917ConvBaseURL = new String[] {""} ;
      BC000E14_n1917ConvBaseURL = new boolean[] {false} ;
      BC000E14_A1918ConvScrapTipo = new String[] {""} ;
      BC000E14_n1918ConvScrapTipo = new boolean[] {false} ;
      BC000E14_A1919ConvScrapTDoc = new String[] {""} ;
      BC000E14_n1919ConvScrapTDoc = new boolean[] {false} ;
      BC000E14_A2131ConveEscFrecAct = new short[1] ;
      BC000E14_A2428ConveEsquemaEs = new boolean[] {false} ;
      BC000E14_A46PaiCod = new short[1] ;
      BC000E14_A935ConveSinCod = new String[] {""} ;
      BC000E14_n935ConveSinCod = new boolean[] {false} ;
      BC000E18_A936ConveSinDesc = new String[] {""} ;
      BC000E19_A3CliCod = new int[1] ;
      BC000E19_A26ConCodigo = new String[] {""} ;
      BC000E20_A3CliCod = new int[1] ;
      BC000E20_A1564CliPaiConve = new short[1] ;
      BC000E20_A1565CliConvenio = new String[] {""} ;
      BC000E21_A3CliCod = new int[1] ;
      BC000E21_A1564CliPaiConve = new short[1] ;
      BC000E21_A1565CliConvenio = new String[] {""} ;
      BC000E22_A3CliCod = new int[1] ;
      BC000E22_A1EmpCod = new short[1] ;
      BC000E22_A1562EmpConvePai = new short[1] ;
      BC000E22_A1561EmpConveCod = new String[] {""} ;
      BC000E23_A46PaiCod = new short[1] ;
      BC000E23_A1223FerId = new String[] {""} ;
      BC000E24_A46PaiCod = new short[1] ;
      BC000E24_A9ConveCodigo = new String[] {""} ;
      BC000E24_A1048ConveVacDesdeAnti = new byte[1] ;
      BC000E25_A687ConveDescriSinAc = new String[] {""} ;
      BC000E25_A9ConveCodigo = new String[] {""} ;
      BC000E25_A160ConveDescri = new String[] {""} ;
      BC000E25_A161ConveHabilitada = new boolean[] {false} ;
      BC000E25_A936ConveSinDesc = new String[] {""} ;
      BC000E25_A1915ConvBusGoogle = new String[] {""} ;
      BC000E25_n1915ConvBusGoogle = new boolean[] {false} ;
      BC000E25_A1916ConvBusWeb = new String[] {""} ;
      BC000E25_n1916ConvBusWeb = new boolean[] {false} ;
      BC000E25_A1917ConvBaseURL = new String[] {""} ;
      BC000E25_n1917ConvBaseURL = new boolean[] {false} ;
      BC000E25_A1918ConvScrapTipo = new String[] {""} ;
      BC000E25_n1918ConvScrapTipo = new boolean[] {false} ;
      BC000E25_A1919ConvScrapTDoc = new String[] {""} ;
      BC000E25_n1919ConvScrapTDoc = new boolean[] {false} ;
      BC000E25_A2131ConveEscFrecAct = new short[1] ;
      BC000E25_A2428ConveEsquemaEs = new boolean[] {false} ;
      BC000E25_A46PaiCod = new short[1] ;
      BC000E25_A935ConveSinCod = new String[] {""} ;
      BC000E25_n935ConveSinCod = new boolean[] {false} ;
      Z2262ConvePropPredet = "" ;
      A2262ConvePropPredet = "" ;
      Z2228propDesc = "" ;
      A2228propDesc = "" ;
      Z2229propTipoDato = "" ;
      A2229propTipoDato = "" ;
      Z2227propCod = "" ;
      A2227propCod = "" ;
      BC000E26_A46PaiCod = new short[1] ;
      BC000E26_A9ConveCodigo = new String[] {""} ;
      BC000E26_A2228propDesc = new String[] {""} ;
      BC000E26_A2229propTipoDato = new String[] {""} ;
      BC000E26_A2262ConvePropPredet = new String[] {""} ;
      BC000E26_A2227propCod = new String[] {""} ;
      BC000E27_A2228propDesc = new String[] {""} ;
      BC000E27_A2229propTipoDato = new String[] {""} ;
      BC000E28_A46PaiCod = new short[1] ;
      BC000E28_A9ConveCodigo = new String[] {""} ;
      BC000E28_A2227propCod = new String[] {""} ;
      BC000E29_A46PaiCod = new short[1] ;
      BC000E29_A9ConveCodigo = new String[] {""} ;
      BC000E29_A2262ConvePropPredet = new String[] {""} ;
      BC000E29_A2227propCod = new String[] {""} ;
      sMode275 = "" ;
      BC000E30_A46PaiCod = new short[1] ;
      BC000E30_A9ConveCodigo = new String[] {""} ;
      BC000E30_A2262ConvePropPredet = new String[] {""} ;
      BC000E30_A2227propCod = new String[] {""} ;
      BC000E34_A2228propDesc = new String[] {""} ;
      BC000E34_A2229propTipoDato = new String[] {""} ;
      BC000E35_A46PaiCod = new short[1] ;
      BC000E35_A9ConveCodigo = new String[] {""} ;
      BC000E35_A2228propDesc = new String[] {""} ;
      BC000E35_A2229propTipoDato = new String[] {""} ;
      BC000E35_A2262ConvePropPredet = new String[] {""} ;
      BC000E35_A2227propCod = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000E36_A46PaiCod = new short[1] ;
      BC000E37_A46PaiCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_bc__default(),
         new Object[] {
             new Object[] {
            BC000E2_A46PaiCod, BC000E2_A9ConveCodigo, BC000E2_A2262ConvePropPredet, BC000E2_A2227propCod
            }
            , new Object[] {
            BC000E3_A46PaiCod, BC000E3_A9ConveCodigo, BC000E3_A2262ConvePropPredet, BC000E3_A2227propCod
            }
            , new Object[] {
            BC000E4_A2228propDesc, BC000E4_A2229propTipoDato
            }
            , new Object[] {
            BC000E5_A687ConveDescriSinAc, BC000E5_A9ConveCodigo, BC000E5_A160ConveDescri, BC000E5_A161ConveHabilitada, BC000E5_A1915ConvBusGoogle, BC000E5_n1915ConvBusGoogle, BC000E5_A1916ConvBusWeb, BC000E5_n1916ConvBusWeb, BC000E5_A1917ConvBaseURL, BC000E5_n1917ConvBaseURL,
            BC000E5_A1918ConvScrapTipo, BC000E5_n1918ConvScrapTipo, BC000E5_A1919ConvScrapTDoc, BC000E5_n1919ConvScrapTDoc, BC000E5_A2131ConveEscFrecAct, BC000E5_A2428ConveEsquemaEs, BC000E5_A46PaiCod, BC000E5_A935ConveSinCod, BC000E5_n935ConveSinCod
            }
            , new Object[] {
            BC000E6_A687ConveDescriSinAc, BC000E6_A9ConveCodigo, BC000E6_A160ConveDescri, BC000E6_A161ConveHabilitada, BC000E6_A1915ConvBusGoogle, BC000E6_n1915ConvBusGoogle, BC000E6_A1916ConvBusWeb, BC000E6_n1916ConvBusWeb, BC000E6_A1917ConvBaseURL, BC000E6_n1917ConvBaseURL,
            BC000E6_A1918ConvScrapTipo, BC000E6_n1918ConvScrapTipo, BC000E6_A1919ConvScrapTDoc, BC000E6_n1919ConvScrapTDoc, BC000E6_A2131ConveEscFrecAct, BC000E6_A2428ConveEsquemaEs, BC000E6_A46PaiCod, BC000E6_A935ConveSinCod, BC000E6_n935ConveSinCod
            }
            , new Object[] {
            BC000E7_A46PaiCod
            }
            , new Object[] {
            BC000E8_A936ConveSinDesc
            }
            , new Object[] {
            BC000E9_A687ConveDescriSinAc, BC000E9_A9ConveCodigo, BC000E9_A160ConveDescri, BC000E9_A161ConveHabilitada, BC000E9_A936ConveSinDesc, BC000E9_A1915ConvBusGoogle, BC000E9_n1915ConvBusGoogle, BC000E9_A1916ConvBusWeb, BC000E9_n1916ConvBusWeb, BC000E9_A1917ConvBaseURL,
            BC000E9_n1917ConvBaseURL, BC000E9_A1918ConvScrapTipo, BC000E9_n1918ConvScrapTipo, BC000E9_A1919ConvScrapTDoc, BC000E9_n1919ConvScrapTDoc, BC000E9_A2131ConveEscFrecAct, BC000E9_A2428ConveEsquemaEs, BC000E9_A46PaiCod, BC000E9_A935ConveSinCod, BC000E9_n935ConveSinCod
            }
            , new Object[] {
            BC000E10_A46PaiCod
            }
            , new Object[] {
            BC000E11_A936ConveSinDesc
            }
            , new Object[] {
            BC000E12_A46PaiCod, BC000E12_A9ConveCodigo
            }
            , new Object[] {
            BC000E13_A687ConveDescriSinAc, BC000E13_A9ConveCodigo, BC000E13_A160ConveDescri, BC000E13_A161ConveHabilitada, BC000E13_A1915ConvBusGoogle, BC000E13_n1915ConvBusGoogle, BC000E13_A1916ConvBusWeb, BC000E13_n1916ConvBusWeb, BC000E13_A1917ConvBaseURL, BC000E13_n1917ConvBaseURL,
            BC000E13_A1918ConvScrapTipo, BC000E13_n1918ConvScrapTipo, BC000E13_A1919ConvScrapTDoc, BC000E13_n1919ConvScrapTDoc, BC000E13_A2131ConveEscFrecAct, BC000E13_A2428ConveEsquemaEs, BC000E13_A46PaiCod, BC000E13_A935ConveSinCod, BC000E13_n935ConveSinCod
            }
            , new Object[] {
            BC000E14_A687ConveDescriSinAc, BC000E14_A9ConveCodigo, BC000E14_A160ConveDescri, BC000E14_A161ConveHabilitada, BC000E14_A1915ConvBusGoogle, BC000E14_n1915ConvBusGoogle, BC000E14_A1916ConvBusWeb, BC000E14_n1916ConvBusWeb, BC000E14_A1917ConvBaseURL, BC000E14_n1917ConvBaseURL,
            BC000E14_A1918ConvScrapTipo, BC000E14_n1918ConvScrapTipo, BC000E14_A1919ConvScrapTDoc, BC000E14_n1919ConvScrapTDoc, BC000E14_A2131ConveEscFrecAct, BC000E14_A2428ConveEsquemaEs, BC000E14_A46PaiCod, BC000E14_A935ConveSinCod, BC000E14_n935ConveSinCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000E18_A936ConveSinDesc
            }
            , new Object[] {
            BC000E19_A3CliCod, BC000E19_A26ConCodigo
            }
            , new Object[] {
            BC000E20_A3CliCod, BC000E20_A1564CliPaiConve, BC000E20_A1565CliConvenio
            }
            , new Object[] {
            BC000E21_A3CliCod, BC000E21_A1564CliPaiConve, BC000E21_A1565CliConvenio
            }
            , new Object[] {
            BC000E22_A3CliCod, BC000E22_A1EmpCod, BC000E22_A1562EmpConvePai, BC000E22_A1561EmpConveCod
            }
            , new Object[] {
            BC000E23_A46PaiCod, BC000E23_A1223FerId
            }
            , new Object[] {
            BC000E24_A46PaiCod, BC000E24_A9ConveCodigo, BC000E24_A1048ConveVacDesdeAnti
            }
            , new Object[] {
            BC000E25_A687ConveDescriSinAc, BC000E25_A9ConveCodigo, BC000E25_A160ConveDescri, BC000E25_A161ConveHabilitada, BC000E25_A936ConveSinDesc, BC000E25_A1915ConvBusGoogle, BC000E25_n1915ConvBusGoogle, BC000E25_A1916ConvBusWeb, BC000E25_n1916ConvBusWeb, BC000E25_A1917ConvBaseURL,
            BC000E25_n1917ConvBaseURL, BC000E25_A1918ConvScrapTipo, BC000E25_n1918ConvScrapTipo, BC000E25_A1919ConvScrapTDoc, BC000E25_n1919ConvScrapTDoc, BC000E25_A2131ConveEscFrecAct, BC000E25_A2428ConveEsquemaEs, BC000E25_A46PaiCod, BC000E25_A935ConveSinCod, BC000E25_n935ConveSinCod
            }
            , new Object[] {
            BC000E26_A46PaiCod, BC000E26_A9ConveCodigo, BC000E26_A2228propDesc, BC000E26_A2229propTipoDato, BC000E26_A2262ConvePropPredet, BC000E26_A2227propCod
            }
            , new Object[] {
            BC000E27_A2228propDesc, BC000E27_A2229propTipoDato
            }
            , new Object[] {
            BC000E28_A46PaiCod, BC000E28_A9ConveCodigo, BC000E28_A2227propCod
            }
            , new Object[] {
            BC000E29_A46PaiCod, BC000E29_A9ConveCodigo, BC000E29_A2262ConvePropPredet, BC000E29_A2227propCod
            }
            , new Object[] {
            BC000E30_A46PaiCod, BC000E30_A9ConveCodigo, BC000E30_A2262ConvePropPredet, BC000E30_A2227propCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000E34_A2228propDesc, BC000E34_A2229propTipoDato
            }
            , new Object[] {
            BC000E35_A46PaiCod, BC000E35_A9ConveCodigo, BC000E35_A2228propDesc, BC000E35_A2229propTipoDato, BC000E35_A2262ConvePropPredet, BC000E35_A2227propCod
            }
            , new Object[] {
            BC000E36_A46PaiCod
            }
            , new Object[] {
            BC000E37_A46PaiCod
            }
         }
      );
      AV26Pgmname = "Convenio_BC" ;
      Z161ConveHabilitada = true ;
      A161ConveHabilitada = true ;
      i161ConveHabilitada = true ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120E2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte Gxremove275 ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z46PaiCod ;
   private short A46PaiCod ;
   private short nIsMod_275 ;
   private short RcdFound275 ;
   private short Z2131ConveEscFrecAct ;
   private short A2131ConveEscFrecAct ;
   private short RcdFound106 ;
   private short nIsDirty_106 ;
   private short nRcdExists_275 ;
   private short nIsDirty_275 ;
   private int trnEnded ;
   private int nGXsfl_275_idx=1 ;
   private int AV27GXV1 ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z9ConveCodigo ;
   private String A9ConveCodigo ;
   private String sMode106 ;
   private String AV26Pgmname ;
   private String AV18Insert_ConveSinCod ;
   private String Z1918ConvScrapTipo ;
   private String A1918ConvScrapTipo ;
   private String Z1919ConvScrapTDoc ;
   private String A1919ConvScrapTDoc ;
   private String Z935ConveSinCod ;
   private String A935ConveSinCod ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String Z2262ConvePropPredet ;
   private String A2262ConvePropPredet ;
   private String Z2229propTipoDato ;
   private String A2229propTipoDato ;
   private String Z2227propCod ;
   private String A2227propCod ;
   private String sMode275 ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z161ConveHabilitada ;
   private boolean A161ConveHabilitada ;
   private boolean Z2428ConveEsquemaEs ;
   private boolean A2428ConveEsquemaEs ;
   private boolean n1915ConvBusGoogle ;
   private boolean n1916ConvBusWeb ;
   private boolean n1917ConvBaseURL ;
   private boolean n1918ConvScrapTipo ;
   private boolean n1919ConvScrapTDoc ;
   private boolean n935ConveSinCod ;
   private boolean Gx_longc ;
   private boolean i161ConveHabilitada ;
   private boolean mustCommit ;
   private String Z687ConveDescriSinAc ;
   private String A687ConveDescriSinAc ;
   private String Z160ConveDescri ;
   private String A160ConveDescri ;
   private String Z1915ConvBusGoogle ;
   private String A1915ConvBusGoogle ;
   private String Z1916ConvBusWeb ;
   private String A1916ConvBusWeb ;
   private String Z1917ConvBaseURL ;
   private String A1917ConvBaseURL ;
   private String Z936ConveSinDesc ;
   private String A936ConveSinDesc ;
   private String Z2228propDesc ;
   private String A2228propDesc ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private web.SdtConvenio bcConvenio ;
   private IDataStoreProvider pr_default ;
   private String[] BC000E9_A687ConveDescriSinAc ;
   private String[] BC000E9_A9ConveCodigo ;
   private String[] BC000E9_A160ConveDescri ;
   private boolean[] BC000E9_A161ConveHabilitada ;
   private String[] BC000E9_A936ConveSinDesc ;
   private String[] BC000E9_A1915ConvBusGoogle ;
   private boolean[] BC000E9_n1915ConvBusGoogle ;
   private String[] BC000E9_A1916ConvBusWeb ;
   private boolean[] BC000E9_n1916ConvBusWeb ;
   private String[] BC000E9_A1917ConvBaseURL ;
   private boolean[] BC000E9_n1917ConvBaseURL ;
   private String[] BC000E9_A1918ConvScrapTipo ;
   private boolean[] BC000E9_n1918ConvScrapTipo ;
   private String[] BC000E9_A1919ConvScrapTDoc ;
   private boolean[] BC000E9_n1919ConvScrapTDoc ;
   private short[] BC000E9_A2131ConveEscFrecAct ;
   private boolean[] BC000E9_A2428ConveEsquemaEs ;
   private short[] BC000E9_A46PaiCod ;
   private String[] BC000E9_A935ConveSinCod ;
   private boolean[] BC000E9_n935ConveSinCod ;
   private short[] BC000E10_A46PaiCod ;
   private String[] BC000E11_A936ConveSinDesc ;
   private short[] BC000E12_A46PaiCod ;
   private String[] BC000E12_A9ConveCodigo ;
   private String[] BC000E13_A687ConveDescriSinAc ;
   private String[] BC000E13_A9ConveCodigo ;
   private String[] BC000E13_A160ConveDescri ;
   private boolean[] BC000E13_A161ConveHabilitada ;
   private String[] BC000E13_A1915ConvBusGoogle ;
   private boolean[] BC000E13_n1915ConvBusGoogle ;
   private String[] BC000E13_A1916ConvBusWeb ;
   private boolean[] BC000E13_n1916ConvBusWeb ;
   private String[] BC000E13_A1917ConvBaseURL ;
   private boolean[] BC000E13_n1917ConvBaseURL ;
   private String[] BC000E13_A1918ConvScrapTipo ;
   private boolean[] BC000E13_n1918ConvScrapTipo ;
   private String[] BC000E13_A1919ConvScrapTDoc ;
   private boolean[] BC000E13_n1919ConvScrapTDoc ;
   private short[] BC000E13_A2131ConveEscFrecAct ;
   private boolean[] BC000E13_A2428ConveEsquemaEs ;
   private short[] BC000E13_A46PaiCod ;
   private String[] BC000E13_A935ConveSinCod ;
   private boolean[] BC000E13_n935ConveSinCod ;
   private String[] BC000E14_A687ConveDescriSinAc ;
   private String[] BC000E14_A9ConveCodigo ;
   private String[] BC000E14_A160ConveDescri ;
   private boolean[] BC000E14_A161ConveHabilitada ;
   private String[] BC000E14_A1915ConvBusGoogle ;
   private boolean[] BC000E14_n1915ConvBusGoogle ;
   private String[] BC000E14_A1916ConvBusWeb ;
   private boolean[] BC000E14_n1916ConvBusWeb ;
   private String[] BC000E14_A1917ConvBaseURL ;
   private boolean[] BC000E14_n1917ConvBaseURL ;
   private String[] BC000E14_A1918ConvScrapTipo ;
   private boolean[] BC000E14_n1918ConvScrapTipo ;
   private String[] BC000E14_A1919ConvScrapTDoc ;
   private boolean[] BC000E14_n1919ConvScrapTDoc ;
   private short[] BC000E14_A2131ConveEscFrecAct ;
   private boolean[] BC000E14_A2428ConveEsquemaEs ;
   private short[] BC000E14_A46PaiCod ;
   private String[] BC000E14_A935ConveSinCod ;
   private boolean[] BC000E14_n935ConveSinCod ;
   private String[] BC000E18_A936ConveSinDesc ;
   private int[] BC000E19_A3CliCod ;
   private String[] BC000E19_A26ConCodigo ;
   private int[] BC000E20_A3CliCod ;
   private short[] BC000E20_A1564CliPaiConve ;
   private String[] BC000E20_A1565CliConvenio ;
   private int[] BC000E21_A3CliCod ;
   private short[] BC000E21_A1564CliPaiConve ;
   private String[] BC000E21_A1565CliConvenio ;
   private int[] BC000E22_A3CliCod ;
   private short[] BC000E22_A1EmpCod ;
   private short[] BC000E22_A1562EmpConvePai ;
   private String[] BC000E22_A1561EmpConveCod ;
   private short[] BC000E23_A46PaiCod ;
   private String[] BC000E23_A1223FerId ;
   private short[] BC000E24_A46PaiCod ;
   private String[] BC000E24_A9ConveCodigo ;
   private byte[] BC000E24_A1048ConveVacDesdeAnti ;
   private String[] BC000E25_A687ConveDescriSinAc ;
   private String[] BC000E25_A9ConveCodigo ;
   private String[] BC000E25_A160ConveDescri ;
   private boolean[] BC000E25_A161ConveHabilitada ;
   private String[] BC000E25_A936ConveSinDesc ;
   private String[] BC000E25_A1915ConvBusGoogle ;
   private boolean[] BC000E25_n1915ConvBusGoogle ;
   private String[] BC000E25_A1916ConvBusWeb ;
   private boolean[] BC000E25_n1916ConvBusWeb ;
   private String[] BC000E25_A1917ConvBaseURL ;
   private boolean[] BC000E25_n1917ConvBaseURL ;
   private String[] BC000E25_A1918ConvScrapTipo ;
   private boolean[] BC000E25_n1918ConvScrapTipo ;
   private String[] BC000E25_A1919ConvScrapTDoc ;
   private boolean[] BC000E25_n1919ConvScrapTDoc ;
   private short[] BC000E25_A2131ConveEscFrecAct ;
   private boolean[] BC000E25_A2428ConveEsquemaEs ;
   private short[] BC000E25_A46PaiCod ;
   private String[] BC000E25_A935ConveSinCod ;
   private boolean[] BC000E25_n935ConveSinCod ;
   private short[] BC000E26_A46PaiCod ;
   private String[] BC000E26_A9ConveCodigo ;
   private String[] BC000E26_A2228propDesc ;
   private String[] BC000E26_A2229propTipoDato ;
   private String[] BC000E26_A2262ConvePropPredet ;
   private String[] BC000E26_A2227propCod ;
   private String[] BC000E27_A2228propDesc ;
   private String[] BC000E27_A2229propTipoDato ;
   private short[] BC000E28_A46PaiCod ;
   private String[] BC000E28_A9ConveCodigo ;
   private String[] BC000E28_A2227propCod ;
   private short[] BC000E29_A46PaiCod ;
   private String[] BC000E29_A9ConveCodigo ;
   private String[] BC000E29_A2262ConvePropPredet ;
   private String[] BC000E29_A2227propCod ;
   private short[] BC000E30_A46PaiCod ;
   private String[] BC000E30_A9ConveCodigo ;
   private String[] BC000E30_A2262ConvePropPredet ;
   private String[] BC000E30_A2227propCod ;
   private String[] BC000E34_A2228propDesc ;
   private String[] BC000E34_A2229propTipoDato ;
   private short[] BC000E35_A46PaiCod ;
   private String[] BC000E35_A9ConveCodigo ;
   private String[] BC000E35_A2228propDesc ;
   private String[] BC000E35_A2229propTipoDato ;
   private String[] BC000E35_A2262ConvePropPredet ;
   private String[] BC000E35_A2227propCod ;
   private short[] BC000E36_A46PaiCod ;
   private short[] BC000E37_A46PaiCod ;
   private short[] BC000E2_A46PaiCod ;
   private String[] BC000E2_A9ConveCodigo ;
   private String[] BC000E2_A2262ConvePropPredet ;
   private String[] BC000E2_A2227propCod ;
   private short[] BC000E3_A46PaiCod ;
   private String[] BC000E3_A9ConveCodigo ;
   private String[] BC000E3_A2262ConvePropPredet ;
   private String[] BC000E3_A2227propCod ;
   private String[] BC000E4_A2228propDesc ;
   private String[] BC000E4_A2229propTipoDato ;
   private String[] BC000E5_A687ConveDescriSinAc ;
   private String[] BC000E5_A9ConveCodigo ;
   private String[] BC000E5_A160ConveDescri ;
   private boolean[] BC000E5_A161ConveHabilitada ;
   private String[] BC000E5_A1915ConvBusGoogle ;
   private String[] BC000E5_A1916ConvBusWeb ;
   private String[] BC000E5_A1917ConvBaseURL ;
   private String[] BC000E5_A1918ConvScrapTipo ;
   private String[] BC000E5_A1919ConvScrapTDoc ;
   private short[] BC000E5_A2131ConveEscFrecAct ;
   private boolean[] BC000E5_A2428ConveEsquemaEs ;
   private short[] BC000E5_A46PaiCod ;
   private String[] BC000E5_A935ConveSinCod ;
   private String[] BC000E6_A687ConveDescriSinAc ;
   private String[] BC000E6_A9ConveCodigo ;
   private String[] BC000E6_A160ConveDescri ;
   private boolean[] BC000E6_A161ConveHabilitada ;
   private String[] BC000E6_A1915ConvBusGoogle ;
   private String[] BC000E6_A1916ConvBusWeb ;
   private String[] BC000E6_A1917ConvBaseURL ;
   private String[] BC000E6_A1918ConvScrapTipo ;
   private String[] BC000E6_A1919ConvScrapTDoc ;
   private short[] BC000E6_A2131ConveEscFrecAct ;
   private boolean[] BC000E6_A2428ConveEsquemaEs ;
   private short[] BC000E6_A46PaiCod ;
   private String[] BC000E6_A935ConveSinCod ;
   private short[] BC000E7_A46PaiCod ;
   private String[] BC000E8_A936ConveSinDesc ;
   private boolean[] BC000E5_n1915ConvBusGoogle ;
   private boolean[] BC000E5_n1916ConvBusWeb ;
   private boolean[] BC000E5_n1917ConvBaseURL ;
   private boolean[] BC000E5_n1918ConvScrapTipo ;
   private boolean[] BC000E5_n1919ConvScrapTDoc ;
   private boolean[] BC000E5_n935ConveSinCod ;
   private boolean[] BC000E6_n1915ConvBusGoogle ;
   private boolean[] BC000E6_n1916ConvBusWeb ;
   private boolean[] BC000E6_n1917ConvBaseURL ;
   private boolean[] BC000E6_n1918ConvScrapTipo ;
   private boolean[] BC000E6_n1919ConvScrapTDoc ;
   private boolean[] BC000E6_n935ConveSinCod ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV15TrnContextAtt ;
}

final  class convenio_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000E2", "SELECT PaiCod, ConveCodigo, ConvePropPredet, propCod FROM ConvenioPropiedadesAdicionales WHERE PaiCod = ? AND ConveCodigo = ? AND propCod = ?  FOR UPDATE OF ConvenioPropiedadesAdicionales",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E3", "SELECT PaiCod, ConveCodigo, ConvePropPredet, propCod FROM ConvenioPropiedadesAdicionales WHERE PaiCod = ? AND ConveCodigo = ? AND propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E4", "SELECT propDesc, propTipoDato FROM propiedades_adicionales WHERE propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E5", "SELECT ConveDescriSinAc, ConveCodigo, ConveDescri, ConveHabilitada, ConvBusGoogle, ConvBusWeb, ConvBaseURL, ConvScrapTipo, ConvScrapTDoc, ConveEscFrecAct, ConveEsquemaEs, PaiCod, ConveSinCod FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ?  FOR UPDATE OF Convenio",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E6", "SELECT ConveDescriSinAc, ConveCodigo, ConveDescri, ConveHabilitada, ConvBusGoogle, ConvBusWeb, ConvBaseURL, ConvScrapTipo, ConvScrapTDoc, ConveEscFrecAct, ConveEsquemaEs, PaiCod, ConveSinCod FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E7", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E8", "SELECT SinDescrip AS ConveSinDesc FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E9", "SELECT TM1.ConveDescriSinAc, TM1.ConveCodigo, TM1.ConveDescri, TM1.ConveHabilitada, T2.SinDescrip AS ConveSinDesc, TM1.ConvBusGoogle, TM1.ConvBusWeb, TM1.ConvBaseURL, TM1.ConvScrapTipo, TM1.ConvScrapTDoc, TM1.ConveEscFrecAct, TM1.ConveEsquemaEs, TM1.PaiCod, TM1.ConveSinCod AS ConveSinCod FROM (Convenio TM1 LEFT JOIN Sindicato T2 ON T2.PaiCod = TM1.PaiCod AND T2.SinCod = TM1.ConveSinCod) WHERE TM1.PaiCod = ? and TM1.ConveCodigo = ( ?) ORDER BY TM1.PaiCod, TM1.ConveCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E10", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E11", "SELECT SinDescrip AS ConveSinDesc FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E12", "SELECT PaiCod, ConveCodigo FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E13", "SELECT ConveDescriSinAc, ConveCodigo, ConveDescri, ConveHabilitada, ConvBusGoogle, ConvBusWeb, ConvBaseURL, ConvScrapTipo, ConvScrapTDoc, ConveEscFrecAct, ConveEsquemaEs, PaiCod, ConveSinCod FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E14", "SELECT ConveDescriSinAc, ConveCodigo, ConveDescri, ConveHabilitada, ConvBusGoogle, ConvBusWeb, ConvBaseURL, ConvScrapTipo, ConvScrapTDoc, ConveEscFrecAct, ConveEsquemaEs, PaiCod, ConveSinCod FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ?  FOR UPDATE OF Convenio",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000E15", "SAVEPOINT gxupdate;INSERT INTO Convenio(ConveDescriSinAc, ConveCodigo, ConveDescri, ConveHabilitada, ConvBusGoogle, ConvBusWeb, ConvBaseURL, ConvScrapTipo, ConvScrapTDoc, ConveEscFrecAct, ConveEsquemaEs, PaiCod, ConveSinCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000E16", "SAVEPOINT gxupdate;UPDATE Convenio SET ConveDescriSinAc=?, ConveDescri=?, ConveHabilitada=?, ConvBusGoogle=?, ConvBusWeb=?, ConvBaseURL=?, ConvScrapTipo=?, ConvScrapTDoc=?, ConveEscFrecAct=?, ConveEsquemaEs=?, ConveSinCod=?  WHERE PaiCod = ? AND ConveCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000E17", "SAVEPOINT gxupdate;DELETE FROM Convenio  WHERE PaiCod = ? AND ConveCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000E18", "SELECT SinDescrip AS ConveSinDesc FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E19", "SELECT CliCod, ConCodigo FROM Concepto WHERE ConceptoPais = ? AND ConceptoConveCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000E20", "SELECT CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000E21", "SELECT CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000E22", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE EmpConvePai = ? AND EmpConveCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000E23", "SELECT PaiCod, FerId FROM feriado WHERE PaiCod = ? AND FeriadoConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000E24", "SELECT PaiCod, ConveCodigo, ConveVacDesdeAnti FROM ConveVacaciones WHERE PaiCod = ? AND ConveCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000E25", "SELECT TM1.ConveDescriSinAc, TM1.ConveCodigo, TM1.ConveDescri, TM1.ConveHabilitada, T2.SinDescrip AS ConveSinDesc, TM1.ConvBusGoogle, TM1.ConvBusWeb, TM1.ConvBaseURL, TM1.ConvScrapTipo, TM1.ConvScrapTDoc, TM1.ConveEscFrecAct, TM1.ConveEsquemaEs, TM1.PaiCod, TM1.ConveSinCod AS ConveSinCod FROM (Convenio TM1 LEFT JOIN Sindicato T2 ON T2.PaiCod = TM1.PaiCod AND T2.SinCod = TM1.ConveSinCod) WHERE TM1.PaiCod = ? and TM1.ConveCodigo = ( ?) ORDER BY TM1.PaiCod, TM1.ConveCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E26", "SELECT T1.PaiCod, T1.ConveCodigo, T2.propDesc, T2.propTipoDato, T1.ConvePropPredet, T1.propCod FROM (ConvenioPropiedadesAdicionales T1 INNER JOIN propiedades_adicionales T2 ON T2.propCod = T1.propCod) WHERE T1.PaiCod = ? and T1.ConveCodigo = ( ?) and T1.propCod = ( ?) ORDER BY T1.PaiCod, T1.ConveCodigo, T1.propCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E27", "SELECT propDesc, propTipoDato FROM propiedades_adicionales WHERE propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E28", "SELECT PaiCod, ConveCodigo, propCod FROM ConvenioPropiedadesAdicionales WHERE PaiCod = ? AND ConveCodigo = ? AND propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E29", "SELECT PaiCod, ConveCodigo, ConvePropPredet, propCod FROM ConvenioPropiedadesAdicionales WHERE PaiCod = ? AND ConveCodigo = ? AND propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E30", "SELECT PaiCod, ConveCodigo, ConvePropPredet, propCod FROM ConvenioPropiedadesAdicionales WHERE PaiCod = ? AND ConveCodigo = ? AND propCod = ?  FOR UPDATE OF ConvenioPropiedadesAdicionales",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000E31", "SAVEPOINT gxupdate;INSERT INTO ConvenioPropiedadesAdicionales(PaiCod, ConveCodigo, ConvePropPredet, propCod) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000E32", "SAVEPOINT gxupdate;UPDATE ConvenioPropiedadesAdicionales SET ConvePropPredet=?  WHERE PaiCod = ? AND ConveCodigo = ? AND propCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000E33", "SAVEPOINT gxupdate;DELETE FROM ConvenioPropiedadesAdicionales  WHERE PaiCod = ? AND ConveCodigo = ? AND propCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000E34", "SELECT propDesc, propTipoDato FROM propiedades_adicionales WHERE propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E35", "SELECT T1.PaiCod, T1.ConveCodigo, T2.propDesc, T2.propTipoDato, T1.ConvePropPredet, T1.propCod FROM (ConvenioPropiedadesAdicionales T1 INNER JOIN propiedades_adicionales T2 ON T2.propCod = T1.propCod) WHERE T1.PaiCod = ? and T1.ConveCodigo = ( ?) ORDER BY T1.PaiCod, T1.ConveCodigo, T1.propCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E36", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E37", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((short[]) buf[14])[0] = rslt.getShort(10);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(11);
               ((short[]) buf[16])[0] = rslt.getShort(12);
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((short[]) buf[14])[0] = rslt.getShort(10);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(11);
               ((short[]) buf[16])[0] = rslt.getShort(12);
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(12);
               ((short[]) buf[17])[0] = rslt.getShort(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((short[]) buf[14])[0] = rslt.getShort(10);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(11);
               ((short[]) buf[16])[0] = rslt.getShort(12);
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((short[]) buf[14])[0] = rslt.getShort(10);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(11);
               ((short[]) buf[16])[0] = rslt.getShort(12);
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 21 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 22 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(12);
               ((short[]) buf[17])[0] = rslt.getShort(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 24 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 26 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 27 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 28 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 32 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 33 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 34 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 35 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[5], 100);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(6, (String)parms[7], 100);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(7, (String)parms[9], 1000);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[11], 20);
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[13], 20);
               }
               stmt.setShort(10, ((Number) parms[14]).shortValue());
               stmt.setBoolean(11, ((Boolean) parms[15]).booleanValue());
               stmt.setShort(12, ((Number) parms[16]).shortValue());
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(13, (String)parms[18], 20);
               }
               return;
            case 14 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(4, (String)parms[4], 100);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[6], 100);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(6, (String)parms[8], 1000);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[10], 20);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[12], 20);
               }
               stmt.setShort(9, ((Number) parms[13]).shortValue());
               stmt.setBoolean(10, ((Boolean) parms[14]).booleanValue());
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[16], 20);
               }
               stmt.setShort(12, ((Number) parms[17]).shortValue());
               stmt.setString(13, (String)parms[18], 20);
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 23 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 24 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 25 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 26 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 27 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 28 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 29 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 31 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 32 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 33 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 34 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 35 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

