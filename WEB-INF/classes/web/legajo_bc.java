package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajo_bc extends GXWebPanel implements IGxSilentTrn
{
   public legajo_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajo_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_bc.class ));
   }

   public legajo_bc( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0P23( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0P23( ) ;
      standaloneModal( ) ;
      addRow0P23( ) ;
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
         e110P2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
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

   public void confirm_0P0( )
   {
      beforeValidate0P23( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0P23( ) ;
         }
         else
         {
            checkExtendedTable0P23( ) ;
            if ( AnyError == 0 )
            {
               zm0P23( 33) ;
               zm0P23( 34) ;
               zm0P23( 35) ;
               zm0P23( 36) ;
               zm0P23( 37) ;
               zm0P23( 38) ;
               zm0P23( 39) ;
               zm0P23( 40) ;
               zm0P23( 41) ;
               zm0P23( 42) ;
               zm0P23( 43) ;
               zm0P23( 44) ;
               zm0P23( 45) ;
               zm0P23( 46) ;
               zm0P23( 47) ;
               zm0P23( 48) ;
               zm0P23( 49) ;
               zm0P23( 50) ;
               zm0P23( 51) ;
               zm0P23( 52) ;
               zm0P23( 53) ;
               zm0P23( 54) ;
               zm0P23( 55) ;
               zm0P23( 56) ;
            }
            closeExtendedTableCursors0P23( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode23 = Gx_mode ;
         confirm_0P129( ) ;
         if ( AnyError == 0 )
         {
            confirm_0P24( ) ;
            if ( AnyError == 0 )
            {
               confirm_0P170( ) ;
               if ( AnyError == 0 )
               {
                  confirm_0P276( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Restore parent mode. */
                     Gx_mode = sMode23 ;
                     IsConfirmed = (short)(1) ;
                  }
               }
            }
         }
         /* Restore parent mode. */
         Gx_mode = sMode23 ;
      }
   }

   public void confirm_0P276( )
   {
      nGXsfl_276_idx = 0 ;
      while ( nGXsfl_276_idx < bcLegajo.getgxTv_SdtLegajo_Propiedades().size() )
      {
         readRow0P276( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound276 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_276 != 0 ) )
         {
            getKey0P276( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound276 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0P276( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0P276( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0P276( 66) ;
                     }
                     closeExtendedTableCursors0P276( ) ;
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
               if ( RcdFound276 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0P276( ) ;
                     load0P276( ) ;
                     beforeValidate0P276( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0P276( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_276 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0P276( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0P276( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0P276( 66) ;
                           }
                           closeExtendedTableCursors0P276( ) ;
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
            VarsToRow276( ((web.SdtLegajo_Propiedades)bcLegajo.getgxTv_SdtLegajo_Propiedades().elementAt(-1+nGXsfl_276_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0P170( )
   {
      nGXsfl_170_idx = 0 ;
      while ( nGXsfl_170_idx < bcLegajo.getgxTv_SdtLegajo_Tipos_de_trabajo().size() )
      {
         readRow0P170( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound170 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_170 != 0 ) )
         {
            getKey0P170( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound170 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0P170( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0P170( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0P170( 64) ;
                     }
                     closeExtendedTableCursors0P170( ) ;
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
               if ( RcdFound170 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0P170( ) ;
                     load0P170( ) ;
                     beforeValidate0P170( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0P170( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_170 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0P170( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0P170( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0P170( 64) ;
                           }
                           closeExtendedTableCursors0P170( ) ;
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
            VarsToRow170( ((web.SdtLegajo_tipos_de_trabajo)bcLegajo.getgxTv_SdtLegajo_Tipos_de_trabajo().elementAt(-1+nGXsfl_170_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0P24( )
   {
      nGXsfl_24_idx = 0 ;
      while ( nGXsfl_24_idx < bcLegajo.getgxTv_SdtLegajo_Familia().size() )
      {
         readRow0P24( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound24 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_24 != 0 ) )
         {
            getKey0P24( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound24 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0P24( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0P24( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0P24( 61) ;
                        zm0P24( 62) ;
                     }
                     closeExtendedTableCursors0P24( ) ;
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
               if ( RcdFound24 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0P24( ) ;
                     load0P24( ) ;
                     beforeValidate0P24( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0P24( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_24 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0P24( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0P24( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0P24( 61) ;
                              zm0P24( 62) ;
                           }
                           closeExtendedTableCursors0P24( ) ;
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
            VarsToRow24( ((web.SdtLegajo_Familia)bcLegajo.getgxTv_SdtLegajo_Familia().elementAt(-1+nGXsfl_24_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0P292( )
   {
      nGXsfl_292_idx = 0 ;
      while ( nGXsfl_292_idx < ((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx)).getgxTv_SdtLegajo_Salario_Conceptos().size() )
      {
         readRow0P292( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound292 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_292 != 0 ) )
         {
            getKey0P292( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound292 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0P292( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0P292( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0P292( 59) ;
                     }
                     closeExtendedTableCursors0P292( ) ;
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
               if ( RcdFound292 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0P292( ) ;
                     load0P292( ) ;
                     beforeValidate0P292( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0P292( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_292 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0P292( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0P292( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0P292( 59) ;
                           }
                           closeExtendedTableCursors0P292( ) ;
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
            VarsToRow292( ((web.SdtLegajo_Salario_Conceptos)((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx)).getgxTv_SdtLegajo_Salario_Conceptos().elementAt(-1+nGXsfl_292_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0P129( )
   {
      nGXsfl_129_idx = 0 ;
      while ( nGXsfl_129_idx < bcLegajo.getgxTv_SdtLegajo_Salario().size() )
      {
         readRow0P129( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound129 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_129 != 0 ) )
         {
            getKey0P129( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound129 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0P129( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0P129( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors0P129( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Save parent mode. */
                        sMode129 = Gx_mode ;
                        confirm_0P292( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Restore parent mode. */
                           Gx_mode = sMode129 ;
                           IsConfirmed = (short)(1) ;
                        }
                        /* Restore parent mode. */
                        Gx_mode = sMode129 ;
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
               if ( RcdFound129 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0P129( ) ;
                     load0P129( ) ;
                     beforeValidate0P129( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0P129( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_129 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0P129( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0P129( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors0P129( ) ;
                           if ( AnyError == 0 )
                           {
                              /* Save parent mode. */
                              sMode129 = Gx_mode ;
                              confirm_0P292( ) ;
                              if ( AnyError == 0 )
                              {
                                 /* Restore parent mode. */
                                 Gx_mode = sMode129 ;
                                 IsConfirmed = (short)(1) ;
                              }
                              /* Restore parent mode. */
                              Gx_mode = sMode129 ;
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
            VarsToRow129( ((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e120P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.msgdebug(remoteHandle, context).execute( AV141Pgmname, httpContext.getMessage( "empcod ", "")+GXutil.trim( GXutil.str( AV7EmpCod, 4, 0))) ;
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      AV92IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV92IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajo_Insert", GXv_boolean3) ;
         legajo_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV92IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV92IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajo_Update", GXv_boolean3) ;
         legajo_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV92IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV92IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajo_Delete", GXv_boolean3) ;
         legajo_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV92IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV92IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV141Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(40);
         pr_default.close(39);
         pr_default.close(38);
         pr_default.close(37);
         pr_default.close(36);
         pr_default.close(35);
         pr_default.close(34);
         pr_default.close(33);
         pr_default.close(32);
         pr_default.close(31);
         pr_default.close(30);
         pr_default.close(29);
         pr_default.close(28);
         pr_default.close(27);
         pr_default.close(26);
         pr_default.close(25);
         pr_default.close(24);
         pr_default.close(23);
         pr_default.close(22);
         pr_default.close(21);
         pr_default.close(20);
         pr_default.close(19);
         pr_default.close(18);
         pr_default.close(17);
         pr_default.close(16);
         pr_default.close(14);
         pr_default.close(12);
         pr_default.close(11);
         pr_default.close(9);
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV141Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV142GXV1 = 1 ;
         while ( AV142GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV33TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV142GXV1));
            if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegSexo") == 0 )
            {
               AV125Insert_LegSexo = (byte)(GXutil.lval( AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegEstadoCivil") == 0 )
            {
               AV130Insert_LegEstadoCivil = (short)(GXutil.lval( AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegNacionCod") == 0 )
            {
               AV12Insert_LegNacionCod = (short)(GXutil.lval( AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegPaiCod") == 0 )
            {
               AV13Insert_LegPaiCod = (short)(GXutil.lval( AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegProvCod") == 0 )
            {
               AV14Insert_LegProvCod = (short)(GXutil.lval( AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegLocCod") == 0 )
            {
               AV15Insert_LegLocCod = (short)(GXutil.lval( AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegMegCodigo") == 0 )
            {
               AV120Insert_LegMegCodigo = AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegSecCodigo") == 0 )
            {
               AV119Insert_LegSecCodigo = AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegLpgCodigo") == 0 )
            {
               AV114Insert_LegLpgCodigo = AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegBanCod") == 0 )
            {
               AV115Insert_LegBanCod = AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegSinCod") == 0 )
            {
               AV106Insert_LegSinCod = AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegOsoCod") == 0 )
            {
               AV116Insert_LegOsoCod = AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegActCodigo") == 0 )
            {
               AV25Insert_LegActCodigo = AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "MprCod") == 0 )
            {
               AV26Insert_MprCod = AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ZonCod") == 0 )
            {
               AV28Insert_ZonCod = AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CondiCodigo") == 0 )
            {
               AV30Insert_CondiCodigo = (short)(GXutil.lval( AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SinieCodigo") == 0 )
            {
               AV31Insert_SinieCodigo = AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegPuesCodigo") == 0 )
            {
               AV117Insert_LegPuesCodigo = AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegSucCodigo") == 0 )
            {
               AV118Insert_LegSucCodigo = AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegSitRevEgreso") == 0 )
            {
               AV122Insert_LegSitRevEgreso = (short)(GXutil.lval( AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegActClasNro") == 0 )
            {
               AV135Insert_LegActClasNro = (int)(GXutil.lval( AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegPueAfiCod") == 0 )
            {
               AV136Insert_LegPueAfiCod = AV33TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            AV142GXV1 = (int)(AV142GXV1+1) ;
         }
      }
   }

   public void e110P2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void e130P2( )
   {
      /* 'Cancel' Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
   }

   public void zm0P23( int GX_JID )
   {
      if ( ( GX_JID == 32 ) || ( GX_JID == 0 ) )
      {
         Z237LegConvenio = A237LegConvenio ;
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z591LegNomApe = A591LegNomApe ;
         Z247LegFecUltMod = A247LegFecUltMod ;
         Z230LegApellido = A230LegApellido ;
         Z251LegNombre = A251LegNombre ;
         Z266LegTipDoc = A266LegTipDoc ;
         Z257LegNumDoc = A257LegNumDoc ;
         Z246LegFecNac = A246LegFecNac ;
         Z239LegCUIL = A239LegCUIL ;
         Z241LegDiscapacidad = A241LegDiscapacidad ;
         Z242LegDomici = A242LegDomici ;
         Z479LegEmail = A479LegEmail ;
         Z236LegCodPos = A236LegCodPos ;
         Z265LegTelefono = A265LegTelefono ;
         Z245LegFecIngreso = A245LegFecIngreso ;
         Z244LegFecEgreso = A244LegFecEgreso ;
         Z939LegCatCodigo = A939LegCatCodigo ;
         Z2215LegCatPueCod = A2215LegCatPueCod ;
         Z235LegClase = A235LegClase ;
         Z248LegFormaPago = A248LegFormaPago ;
         Z231LegBanSuc = A231LegBanSuc ;
         Z232LegBanTipCuen = A232LegBanTipCuen ;
         Z238LegCuentaBanc = A238LegCuentaBanc ;
         Z253LegLicInicio = A253LegLicInicio ;
         Z252LegLicFinal = A252LegLicFinal ;
         Z234LegCBU = A234LegCBU ;
         Z262LegSCVO = A262LegSCVO ;
         Z228LegActivo = A228LegActivo ;
         Z264LegSueldoFuera = A264LegSueldoFuera ;
         Z93LegId = A93LegId ;
         Z937LegConveCodigo = A937LegConveCodigo ;
         Z630LegFecImportacion = A630LegFecImportacion ;
         Z877LegAgenReten = A877LegAgenReten ;
         Z879LegContinua = A879LegContinua ;
         Z942LegRecalcLiq = A942LegRecalcLiq ;
         Z1016LegJubilado = A1016LegJubilado ;
         Z1023LegHorasDia = A1023LegHorasDia ;
         Z1268LegHorasSem = A1268LegHorasSem ;
         Z1245LegTrabLun = A1245LegTrabLun ;
         Z1246LegTrabMar = A1246LegTrabMar ;
         Z1247LegTrabMie = A1247LegTrabMie ;
         Z1248LegTrabJue = A1248LegTrabJue ;
         Z1249LegTrabVie = A1249LegTrabVie ;
         Z1250LegTrabSa = A1250LegTrabSa ;
         Z1251LegTrabDo = A1251LegTrabDo ;
         Z1523LegVacPend = A1523LegVacPend ;
         Z1531LegFecPreAviso = A1531LegFecPreAviso ;
         Z1576LegConveVersionCli = A1576LegConveVersionCli ;
         Z1759LegPromDias = A1759LegPromDias ;
         Z1804LegTitulo = A1804LegTitulo ;
         Z1818LegEstado = A1818LegEstado ;
         Z2267LegIncompleto = A2267LegIncompleto ;
         Z2309LegLiqApo = A2309LegLiqApo ;
         Z2404LegModTra = A2404LegModTra ;
         Z2417LegTipoTarifa = A2417LegTipoTarifa ;
         Z1582LegBanCod = A1582LegBanCod ;
         Z1581LegLpgCodigo = A1581LegLpgCodigo ;
         Z1583LegMegCodigo = A1583LegMegCodigo ;
         Z1580LegOsoCod = A1580LegOsoCod ;
         Z1579LegSecCodigo = A1579LegSecCodigo ;
         Z1577LegSucCodigo = A1577LegSucCodigo ;
         Z1578LegPuesCodigo = A1578LegPuesCodigo ;
         Z18MprCod = A18MprCod ;
         Z20ZonCod = A20ZonCod ;
         Z17CondiCodigo = A17CondiCodigo ;
         Z19SinieCodigo = A19SinieCodigo ;
         Z263LegSexo = A263LegSexo ;
         Z243LegEstadoCivil = A243LegEstadoCivil ;
         Z22LegPaiCod = A22LegPaiCod ;
         Z23LegProvCod = A23LegProvCod ;
         Z24LegLocCod = A24LegLocCod ;
         Z21LegNacionCod = A21LegNacionCod ;
         Z910LegSinCod = A910LegSinCod ;
         Z2182LegActClasNro = A2182LegActClasNro ;
         Z15LegActCodigo = A15LegActCodigo ;
         Z1603LegSitRevEgreso = A1603LegSitRevEgreso ;
         Z2181LegPueAfiCod = A2181LegPueAfiCod ;
         Z1235LegReligion = A1235LegReligion ;
         Z1236LegOrigen = A1236LegOrigen ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 33 ) || ( GX_JID == 0 ) )
      {
         Z2224LegBanDes = A2224LegBanDes ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 34 ) || ( GX_JID == 0 ) )
      {
         Z291LpgDescri = A291LpgDescri ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 35 ) || ( GX_JID == 0 ) )
      {
         Z300MegDescrip = A300MegDescrip ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 36 ) || ( GX_JID == 0 ) )
      {
         Z2225LegOsoDes = A2225LegOsoDes ;
         Z2226LegOsoAfipCod = A2226LegOsoAfipCod ;
         Z392OsoSigla = A392OsoSigla ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 37 ) || ( GX_JID == 0 ) )
      {
         Z329SecDescrip = A329SecDescrip ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 38 ) || ( GX_JID == 0 ) )
      {
         Z1965EmpOsoCod = A1965EmpOsoCod ;
         Z2EmpNom = A2EmpNom ;
         Z45TipEmpleCod = A45TipEmpleCod ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 39 ) || ( GX_JID == 0 ) )
      {
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 40 ) || ( GX_JID == 0 ) )
      {
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 41 ) || ( GX_JID == 0 ) )
      {
         Z684MprDescripSinAc = A684MprDescripSinAc ;
         Z303MprDescrip = A303MprDescrip ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 42 ) || ( GX_JID == 0 ) )
      {
         Z678ZonDescripSinAc = A678ZonDescripSinAc ;
         Z342ZonDescrip = A342ZonDescrip ;
         Z343ZonPorcReduc = A343ZonPorcReduc ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 43 ) || ( GX_JID == 0 ) )
      {
         Z686CondiDescriSinAc = A686CondiDescriSinAc ;
         Z144CondiDescri = A144CondiDescri ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 44 ) || ( GX_JID == 0 ) )
      {
         Z688SinieDescriSinAc = A688SinieDescriSinAc ;
         Z333SinieDescri = A333SinieDescri ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 45 ) || ( GX_JID == 0 ) )
      {
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 46 ) || ( GX_JID == 0 ) )
      {
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 47 ) || ( GX_JID == 0 ) )
      {
         Z258LegPaiNom = A258LegPaiNom ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 48 ) || ( GX_JID == 0 ) )
      {
         Z260LegProvNom = A260LegProvNom ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 49 ) || ( GX_JID == 0 ) )
      {
         Z255LegLocNom = A255LegLocNom ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 50 ) || ( GX_JID == 0 ) )
      {
         Z256LegNacionalidad = A256LegNacionalidad ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 51 ) || ( GX_JID == 0 ) )
      {
         Z331SinDescrip = A331SinDescrip ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 52 ) || ( GX_JID == 0 ) )
      {
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 53 ) || ( GX_JID == 0 ) )
      {
         Z227LegActDescri = A227LegActDescri ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 54 ) || ( GX_JID == 0 ) )
      {
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 55 ) || ( GX_JID == 0 ) )
      {
         Z233LegBasico = A233LegBasico ;
      }
      if ( ( GX_JID == 56 ) || ( GX_JID == 0 ) )
      {
         Z307OsoDescrip = A307OsoDescrip ;
         Z306OsoC3992 = A306OsoC3992 ;
         Z233LegBasico = A233LegBasico ;
      }
      if ( GX_JID == -32 )
      {
         Z19SinieCodigo = A19SinieCodigo ;
         Z263LegSexo = A263LegSexo ;
         Z243LegEstadoCivil = A243LegEstadoCivil ;
         Z22LegPaiCod = A22LegPaiCod ;
         Z23LegProvCod = A23LegProvCod ;
         Z24LegLocCod = A24LegLocCod ;
         Z21LegNacionCod = A21LegNacionCod ;
         Z910LegSinCod = A910LegSinCod ;
         Z2182LegActClasNro = A2182LegActClasNro ;
         Z15LegActCodigo = A15LegActCodigo ;
         Z1603LegSitRevEgreso = A1603LegSitRevEgreso ;
         Z2181LegPueAfiCod = A2181LegPueAfiCod ;
         Z1235LegReligion = A1235LegReligion ;
         Z1236LegOrigen = A1236LegOrigen ;
         Z237LegConvenio = A237LegConvenio ;
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z591LegNomApe = A591LegNomApe ;
         Z6LegNumero = A6LegNumero ;
         Z247LegFecUltMod = A247LegFecUltMod ;
         Z230LegApellido = A230LegApellido ;
         Z251LegNombre = A251LegNombre ;
         Z249LegFoto = A249LegFoto ;
         Z266LegTipDoc = A266LegTipDoc ;
         Z257LegNumDoc = A257LegNumDoc ;
         Z246LegFecNac = A246LegFecNac ;
         Z239LegCUIL = A239LegCUIL ;
         Z241LegDiscapacidad = A241LegDiscapacidad ;
         Z242LegDomici = A242LegDomici ;
         Z479LegEmail = A479LegEmail ;
         Z236LegCodPos = A236LegCodPos ;
         Z265LegTelefono = A265LegTelefono ;
         Z245LegFecIngreso = A245LegFecIngreso ;
         Z244LegFecEgreso = A244LegFecEgreso ;
         Z939LegCatCodigo = A939LegCatCodigo ;
         Z2215LegCatPueCod = A2215LegCatPueCod ;
         Z235LegClase = A235LegClase ;
         Z248LegFormaPago = A248LegFormaPago ;
         Z231LegBanSuc = A231LegBanSuc ;
         Z232LegBanTipCuen = A232LegBanTipCuen ;
         Z238LegCuentaBanc = A238LegCuentaBanc ;
         Z253LegLicInicio = A253LegLicInicio ;
         Z252LegLicFinal = A252LegLicFinal ;
         Z234LegCBU = A234LegCBU ;
         Z262LegSCVO = A262LegSCVO ;
         Z228LegActivo = A228LegActivo ;
         Z264LegSueldoFuera = A264LegSueldoFuera ;
         Z93LegId = A93LegId ;
         Z937LegConveCodigo = A937LegConveCodigo ;
         Z515LegObs = A515LegObs ;
         Z630LegFecImportacion = A630LegFecImportacion ;
         Z877LegAgenReten = A877LegAgenReten ;
         Z879LegContinua = A879LegContinua ;
         Z942LegRecalcLiq = A942LegRecalcLiq ;
         Z1016LegJubilado = A1016LegJubilado ;
         Z1023LegHorasDia = A1023LegHorasDia ;
         Z1268LegHorasSem = A1268LegHorasSem ;
         Z1245LegTrabLun = A1245LegTrabLun ;
         Z1246LegTrabMar = A1246LegTrabMar ;
         Z1247LegTrabMie = A1247LegTrabMie ;
         Z1248LegTrabJue = A1248LegTrabJue ;
         Z1249LegTrabVie = A1249LegTrabVie ;
         Z1250LegTrabSa = A1250LegTrabSa ;
         Z1251LegTrabDo = A1251LegTrabDo ;
         Z1523LegVacPend = A1523LegVacPend ;
         Z1531LegFecPreAviso = A1531LegFecPreAviso ;
         Z1576LegConveVersionCli = A1576LegConveVersionCli ;
         Z1759LegPromDias = A1759LegPromDias ;
         Z1804LegTitulo = A1804LegTitulo ;
         Z1818LegEstado = A1818LegEstado ;
         Z2263LegMigrWarn = A2263LegMigrWarn ;
         Z2267LegIncompleto = A2267LegIncompleto ;
         Z2309LegLiqApo = A2309LegLiqApo ;
         Z2404LegModTra = A2404LegModTra ;
         Z2417LegTipoTarifa = A2417LegTipoTarifa ;
         Z1031LegFotoExt = A1031LegFotoExt ;
         Z1030LegFotoNom = A1030LegFotoNom ;
         Z3CliCod = A3CliCod ;
         Z1582LegBanCod = A1582LegBanCod ;
         Z1581LegLpgCodigo = A1581LegLpgCodigo ;
         Z1583LegMegCodigo = A1583LegMegCodigo ;
         Z1580LegOsoCod = A1580LegOsoCod ;
         Z1579LegSecCodigo = A1579LegSecCodigo ;
         Z1EmpCod = A1EmpCod ;
         Z1577LegSucCodigo = A1577LegSucCodigo ;
         Z1578LegPuesCodigo = A1578LegPuesCodigo ;
         Z18MprCod = A18MprCod ;
         Z20ZonCod = A20ZonCod ;
         Z17CondiCodigo = A17CondiCodigo ;
         Z45TipEmpleCod = A45TipEmpleCod ;
         Z1965EmpOsoCod = A1965EmpOsoCod ;
         Z2EmpNom = A2EmpNom ;
         Z307OsoDescrip = A307OsoDescrip ;
         Z306OsoC3992 = A306OsoC3992 ;
         Z256LegNacionalidad = A256LegNacionalidad ;
         Z258LegPaiNom = A258LegPaiNom ;
         Z260LegProvNom = A260LegProvNom ;
         Z255LegLocNom = A255LegLocNom ;
         Z300MegDescrip = A300MegDescrip ;
         Z329SecDescrip = A329SecDescrip ;
         Z291LpgDescri = A291LpgDescri ;
         Z2224LegBanDes = A2224LegBanDes ;
         Z331SinDescrip = A331SinDescrip ;
         Z2225LegOsoDes = A2225LegOsoDes ;
         Z2226LegOsoAfipCod = A2226LegOsoAfipCod ;
         Z392OsoSigla = A392OsoSigla ;
         Z227LegActDescri = A227LegActDescri ;
         Z684MprDescripSinAc = A684MprDescripSinAc ;
         Z303MprDescrip = A303MprDescrip ;
         Z678ZonDescripSinAc = A678ZonDescripSinAc ;
         Z342ZonDescrip = A342ZonDescrip ;
         Z343ZonPorcReduc = A343ZonPorcReduc ;
         Z686CondiDescriSinAc = A686CondiDescriSinAc ;
         Z144CondiDescri = A144CondiDescri ;
         Z688SinieDescriSinAc = A688SinieDescriSinAc ;
         Z333SinieDescri = A333SinieDescri ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isUpd( )  )
      {
         A247LegFecUltMod = GXutil.serverDate( context, remoteHandle, pr_default) ;
      }
      if ( isIns( )  && (0==A248LegFormaPago) && ( Gx_BScreen == 0 ) )
      {
         A248LegFormaPago = (byte)(3) ;
      }
      if ( isIns( )  && (false==A262LegSCVO) && ( Gx_BScreen == 0 ) )
      {
         A262LegSCVO = true ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A879LegContinua)==0) && ( Gx_BScreen == 0 ) )
      {
         A879LegContinua = "" ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0P23( )
   {
      /* Using cursor BC000P43 */
      pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(41) != 101) )
      {
         RcdFound23 = (short)(1) ;
         A19SinieCodigo = BC000P43_A19SinieCodigo[0] ;
         n19SinieCodigo = BC000P43_n19SinieCodigo[0] ;
         A263LegSexo = BC000P43_A263LegSexo[0] ;
         n263LegSexo = BC000P43_n263LegSexo[0] ;
         A243LegEstadoCivil = BC000P43_A243LegEstadoCivil[0] ;
         n243LegEstadoCivil = BC000P43_n243LegEstadoCivil[0] ;
         A22LegPaiCod = BC000P43_A22LegPaiCod[0] ;
         n22LegPaiCod = BC000P43_n22LegPaiCod[0] ;
         A23LegProvCod = BC000P43_A23LegProvCod[0] ;
         n23LegProvCod = BC000P43_n23LegProvCod[0] ;
         A24LegLocCod = BC000P43_A24LegLocCod[0] ;
         n24LegLocCod = BC000P43_n24LegLocCod[0] ;
         A21LegNacionCod = BC000P43_A21LegNacionCod[0] ;
         n21LegNacionCod = BC000P43_n21LegNacionCod[0] ;
         A910LegSinCod = BC000P43_A910LegSinCod[0] ;
         n910LegSinCod = BC000P43_n910LegSinCod[0] ;
         A2182LegActClasNro = BC000P43_A2182LegActClasNro[0] ;
         n2182LegActClasNro = BC000P43_n2182LegActClasNro[0] ;
         A15LegActCodigo = BC000P43_A15LegActCodigo[0] ;
         n15LegActCodigo = BC000P43_n15LegActCodigo[0] ;
         A1603LegSitRevEgreso = BC000P43_A1603LegSitRevEgreso[0] ;
         n1603LegSitRevEgreso = BC000P43_n1603LegSitRevEgreso[0] ;
         A2181LegPueAfiCod = BC000P43_A2181LegPueAfiCod[0] ;
         n2181LegPueAfiCod = BC000P43_n2181LegPueAfiCod[0] ;
         A45TipEmpleCod = BC000P43_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC000P43_n45TipEmpleCod[0] ;
         A1235LegReligion = BC000P43_A1235LegReligion[0] ;
         n1235LegReligion = BC000P43_n1235LegReligion[0] ;
         A1236LegOrigen = BC000P43_A1236LegOrigen[0] ;
         n1236LegOrigen = BC000P43_n1236LegOrigen[0] ;
         A1965EmpOsoCod = BC000P43_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC000P43_n1965EmpOsoCod[0] ;
         A237LegConvenio = BC000P43_A237LegConvenio[0] ;
         A688SinieDescriSinAc = BC000P43_A688SinieDescriSinAc[0] ;
         A686CondiDescriSinAc = BC000P43_A686CondiDescriSinAc[0] ;
         A678ZonDescripSinAc = BC000P43_A678ZonDescripSinAc[0] ;
         A684MprDescripSinAc = BC000P43_A684MprDescripSinAc[0] ;
         A250LegIdNomApe = BC000P43_A250LegIdNomApe[0] ;
         A591LegNomApe = BC000P43_A591LegNomApe[0] ;
         A247LegFecUltMod = BC000P43_A247LegFecUltMod[0] ;
         A2EmpNom = BC000P43_A2EmpNom[0] ;
         A230LegApellido = BC000P43_A230LegApellido[0] ;
         A251LegNombre = BC000P43_A251LegNombre[0] ;
         A249LegFoto = BC000P43_A249LegFoto[0] ;
         n249LegFoto = BC000P43_n249LegFoto[0] ;
         A266LegTipDoc = BC000P43_A266LegTipDoc[0] ;
         A257LegNumDoc = BC000P43_A257LegNumDoc[0] ;
         A246LegFecNac = BC000P43_A246LegFecNac[0] ;
         A256LegNacionalidad = BC000P43_A256LegNacionalidad[0] ;
         A239LegCUIL = BC000P43_A239LegCUIL[0] ;
         A241LegDiscapacidad = BC000P43_A241LegDiscapacidad[0] ;
         A242LegDomici = BC000P43_A242LegDomici[0] ;
         A479LegEmail = BC000P43_A479LegEmail[0] ;
         A236LegCodPos = BC000P43_A236LegCodPos[0] ;
         A258LegPaiNom = BC000P43_A258LegPaiNom[0] ;
         A260LegProvNom = BC000P43_A260LegProvNom[0] ;
         A255LegLocNom = BC000P43_A255LegLocNom[0] ;
         A265LegTelefono = BC000P43_A265LegTelefono[0] ;
         n265LegTelefono = BC000P43_n265LegTelefono[0] ;
         A245LegFecIngreso = BC000P43_A245LegFecIngreso[0] ;
         A244LegFecEgreso = BC000P43_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC000P43_n244LegFecEgreso[0] ;
         A300MegDescrip = BC000P43_A300MegDescrip[0] ;
         n300MegDescrip = BC000P43_n300MegDescrip[0] ;
         A939LegCatCodigo = BC000P43_A939LegCatCodigo[0] ;
         n939LegCatCodigo = BC000P43_n939LegCatCodigo[0] ;
         A2215LegCatPueCod = BC000P43_A2215LegCatPueCod[0] ;
         n2215LegCatPueCod = BC000P43_n2215LegCatPueCod[0] ;
         A329SecDescrip = BC000P43_A329SecDescrip[0] ;
         n329SecDescrip = BC000P43_n329SecDescrip[0] ;
         A291LpgDescri = BC000P43_A291LpgDescri[0] ;
         n291LpgDescri = BC000P43_n291LpgDescri[0] ;
         A235LegClase = BC000P43_A235LegClase[0] ;
         A248LegFormaPago = BC000P43_A248LegFormaPago[0] ;
         A2224LegBanDes = BC000P43_A2224LegBanDes[0] ;
         A231LegBanSuc = BC000P43_A231LegBanSuc[0] ;
         n231LegBanSuc = BC000P43_n231LegBanSuc[0] ;
         A232LegBanTipCuen = BC000P43_A232LegBanTipCuen[0] ;
         n232LegBanTipCuen = BC000P43_n232LegBanTipCuen[0] ;
         A331SinDescrip = BC000P43_A331SinDescrip[0] ;
         n331SinDescrip = BC000P43_n331SinDescrip[0] ;
         A2225LegOsoDes = BC000P43_A2225LegOsoDes[0] ;
         A2226LegOsoAfipCod = BC000P43_A2226LegOsoAfipCod[0] ;
         n2226LegOsoAfipCod = BC000P43_n2226LegOsoAfipCod[0] ;
         A307OsoDescrip = BC000P43_A307OsoDescrip[0] ;
         n307OsoDescrip = BC000P43_n307OsoDescrip[0] ;
         A227LegActDescri = BC000P43_A227LegActDescri[0] ;
         A303MprDescrip = BC000P43_A303MprDescrip[0] ;
         A238LegCuentaBanc = BC000P43_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = BC000P43_n238LegCuentaBanc[0] ;
         A253LegLicInicio = BC000P43_A253LegLicInicio[0] ;
         n253LegLicInicio = BC000P43_n253LegLicInicio[0] ;
         A252LegLicFinal = BC000P43_A252LegLicFinal[0] ;
         n252LegLicFinal = BC000P43_n252LegLicFinal[0] ;
         A342ZonDescrip = BC000P43_A342ZonDescrip[0] ;
         A343ZonPorcReduc = BC000P43_A343ZonPorcReduc[0] ;
         A234LegCBU = BC000P43_A234LegCBU[0] ;
         n234LegCBU = BC000P43_n234LegCBU[0] ;
         A262LegSCVO = BC000P43_A262LegSCVO[0] ;
         A144CondiDescri = BC000P43_A144CondiDescri[0] ;
         A333SinieDescri = BC000P43_A333SinieDescri[0] ;
         A228LegActivo = BC000P43_A228LegActivo[0] ;
         A264LegSueldoFuera = BC000P43_A264LegSueldoFuera[0] ;
         A93LegId = BC000P43_A93LegId[0] ;
         n93LegId = BC000P43_n93LegId[0] ;
         A937LegConveCodigo = BC000P43_A937LegConveCodigo[0] ;
         n937LegConveCodigo = BC000P43_n937LegConveCodigo[0] ;
         A306OsoC3992 = BC000P43_A306OsoC3992[0] ;
         n306OsoC3992 = BC000P43_n306OsoC3992[0] ;
         A515LegObs = BC000P43_A515LegObs[0] ;
         A630LegFecImportacion = BC000P43_A630LegFecImportacion[0] ;
         A877LegAgenReten = BC000P43_A877LegAgenReten[0] ;
         A879LegContinua = BC000P43_A879LegContinua[0] ;
         A942LegRecalcLiq = BC000P43_A942LegRecalcLiq[0] ;
         A1016LegJubilado = BC000P43_A1016LegJubilado[0] ;
         A1023LegHorasDia = BC000P43_A1023LegHorasDia[0] ;
         A1268LegHorasSem = BC000P43_A1268LegHorasSem[0] ;
         A1245LegTrabLun = BC000P43_A1245LegTrabLun[0] ;
         A1246LegTrabMar = BC000P43_A1246LegTrabMar[0] ;
         A1247LegTrabMie = BC000P43_A1247LegTrabMie[0] ;
         A1248LegTrabJue = BC000P43_A1248LegTrabJue[0] ;
         A1249LegTrabVie = BC000P43_A1249LegTrabVie[0] ;
         A1250LegTrabSa = BC000P43_A1250LegTrabSa[0] ;
         A1251LegTrabDo = BC000P43_A1251LegTrabDo[0] ;
         A1523LegVacPend = BC000P43_A1523LegVacPend[0] ;
         A1531LegFecPreAviso = BC000P43_A1531LegFecPreAviso[0] ;
         A1576LegConveVersionCli = BC000P43_A1576LegConveVersionCli[0] ;
         n1576LegConveVersionCli = BC000P43_n1576LegConveVersionCli[0] ;
         A1759LegPromDias = BC000P43_A1759LegPromDias[0] ;
         A1804LegTitulo = BC000P43_A1804LegTitulo[0] ;
         A1818LegEstado = BC000P43_A1818LegEstado[0] ;
         A2263LegMigrWarn = BC000P43_A2263LegMigrWarn[0] ;
         n2263LegMigrWarn = BC000P43_n2263LegMigrWarn[0] ;
         A2267LegIncompleto = BC000P43_A2267LegIncompleto[0] ;
         A2309LegLiqApo = BC000P43_A2309LegLiqApo[0] ;
         A2404LegModTra = BC000P43_A2404LegModTra[0] ;
         A2417LegTipoTarifa = BC000P43_A2417LegTipoTarifa[0] ;
         A1031LegFotoExt = BC000P43_A1031LegFotoExt[0] ;
         A249LegFoto_Filetype = A1031LegFotoExt ;
         A1030LegFotoNom = BC000P43_A1030LegFotoNom[0] ;
         A249LegFoto_Filename = A1030LegFotoNom ;
         A392OsoSigla = BC000P43_A392OsoSigla[0] ;
         n392OsoSigla = BC000P43_n392OsoSigla[0] ;
         A1582LegBanCod = BC000P43_A1582LegBanCod[0] ;
         n1582LegBanCod = BC000P43_n1582LegBanCod[0] ;
         A1581LegLpgCodigo = BC000P43_A1581LegLpgCodigo[0] ;
         n1581LegLpgCodigo = BC000P43_n1581LegLpgCodigo[0] ;
         A1583LegMegCodigo = BC000P43_A1583LegMegCodigo[0] ;
         n1583LegMegCodigo = BC000P43_n1583LegMegCodigo[0] ;
         A1580LegOsoCod = BC000P43_A1580LegOsoCod[0] ;
         n1580LegOsoCod = BC000P43_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = BC000P43_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = BC000P43_n1579LegSecCodigo[0] ;
         A1577LegSucCodigo = BC000P43_A1577LegSucCodigo[0] ;
         n1577LegSucCodigo = BC000P43_n1577LegSucCodigo[0] ;
         A1578LegPuesCodigo = BC000P43_A1578LegPuesCodigo[0] ;
         n1578LegPuesCodigo = BC000P43_n1578LegPuesCodigo[0] ;
         A18MprCod = BC000P43_A18MprCod[0] ;
         n18MprCod = BC000P43_n18MprCod[0] ;
         A20ZonCod = BC000P43_A20ZonCod[0] ;
         n20ZonCod = BC000P43_n20ZonCod[0] ;
         A17CondiCodigo = BC000P43_A17CondiCodigo[0] ;
         n17CondiCodigo = BC000P43_n17CondiCodigo[0] ;
         zm0P23( -32) ;
      }
      pr_default.close(41);
      onLoadActions0P23( ) ;
   }

   public void onLoadActions0P23( )
   {
      AV141Pgmname = "Legajo_BC" ;
      GXt_char4 = A677LpgDescriSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A291LpgDescri, GXv_char5) ;
      legajo_bc.this.GXt_char4 = GXv_char5[0] ;
      A677LpgDescriSinAc = GXt_char4 ;
      GXt_char4 = A675SecDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char5) ;
      legajo_bc.this.GXt_char4 = GXv_char5[0] ;
      A675SecDescripSinAc = GXt_char4 ;
      GXt_char4 = A681OsoDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char5) ;
      legajo_bc.this.GXt_char4 = GXv_char5[0] ;
      A681OsoDescripSinAc = GXt_char4 ;
      if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && (GXutil.strcmp("", A306OsoC3992)==0) )
      {
         A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
         {
            A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
         }
         else
         {
            if ( (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
            {
               A555OsoSiglaYDesc = GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
            }
            else
            {
               A555OsoSiglaYDesc = A307OsoDescrip ;
            }
         }
      }
      A591LegNomApe = GXutil.trim( A230LegApellido) + ", " + GXutil.trim( A251LegNombre) ;
      A250LegIdNomApe = GXutil.trim( A93LegId) + " - " + GXutil.trim( A230LegApellido) + ", " + GXutil.trim( A251LegNombre) ;
      AV104LegSexo = A263LegSexo ;
      GXt_char4 = A680SinDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A331SinDescrip, GXv_char5) ;
      legajo_bc.this.GXt_char4 = GXv_char5[0] ;
      A680SinDescripSinAc = GXt_char4 ;
      if ( ! (GXutil.strcmp("", A937LegConveCodigo)==0) )
      {
         A237LegConvenio = true ;
      }
      else
      {
         A237LegConvenio = false ;
      }
   }

   public void checkExtendedTable0P23( )
   {
      nIsDirty_23 = (short)(0) ;
      standaloneModal( ) ;
      AV141Pgmname = "Legajo_BC" ;
      /* Using cursor BC000P44 */
      pr_default.execute(42, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1582LegBanCod), A1582LegBanCod});
      if ( (pr_default.getStatus(42) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1582LegBanCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Banco", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGBANCOD");
            AnyError = (short)(1) ;
         }
      }
      A2224LegBanDes = BC000P44_A2224LegBanDes[0] ;
      pr_default.close(42);
      /* Using cursor BC000P45 */
      pr_default.execute(43, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1581LegLpgCodigo), A1581LegLpgCodigo});
      if ( (pr_default.getStatus(43) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1581LegLpgCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Lugar Pago", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGLPGCODIGO");
            AnyError = (short)(1) ;
         }
      }
      A291LpgDescri = BC000P45_A291LpgDescri[0] ;
      n291LpgDescri = BC000P45_n291LpgDescri[0] ;
      pr_default.close(43);
      nIsDirty_23 = (short)(1) ;
      GXt_char4 = A677LpgDescriSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A291LpgDescri, GXv_char5) ;
      legajo_bc.this.GXt_char4 = GXv_char5[0] ;
      A677LpgDescriSinAc = GXt_char4 ;
      /* Using cursor BC000P46 */
      pr_default.execute(44, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1583LegMegCodigo), A1583LegMegCodigo});
      if ( (pr_default.getStatus(44) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1583LegMegCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Motivo Egreso", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGMEGCODIGO");
            AnyError = (short)(1) ;
         }
      }
      A300MegDescrip = BC000P46_A300MegDescrip[0] ;
      n300MegDescrip = BC000P46_n300MegDescrip[0] ;
      pr_default.close(44);
      /* Using cursor BC000P47 */
      pr_default.execute(45, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1580LegOsoCod), A1580LegOsoCod});
      if ( (pr_default.getStatus(45) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1580LegOsoCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Obra Social", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGOSOCOD");
            AnyError = (short)(1) ;
         }
      }
      A2225LegOsoDes = BC000P47_A2225LegOsoDes[0] ;
      A2226LegOsoAfipCod = BC000P47_A2226LegOsoAfipCod[0] ;
      n2226LegOsoAfipCod = BC000P47_n2226LegOsoAfipCod[0] ;
      A392OsoSigla = BC000P47_A392OsoSigla[0] ;
      n392OsoSigla = BC000P47_n392OsoSigla[0] ;
      pr_default.close(45);
      /* Using cursor BC000P48 */
      pr_default.execute(46, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo});
      if ( (pr_default.getStatus(46) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1579LegSecCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Seccion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSECCODIGO");
            AnyError = (short)(1) ;
         }
      }
      A329SecDescrip = BC000P48_A329SecDescrip[0] ;
      n329SecDescrip = BC000P48_n329SecDescrip[0] ;
      pr_default.close(46);
      nIsDirty_23 = (short)(1) ;
      GXt_char4 = A675SecDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char5) ;
      legajo_bc.this.GXt_char4 = GXv_char5[0] ;
      A675SecDescripSinAc = GXt_char4 ;
      /* Using cursor BC000P49 */
      pr_default.execute(47, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo, Boolean.valueOf(n1578LegPuesCodigo), A1578LegPuesCodigo});
      if ( (pr_default.getStatus(47) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1579LegSecCodigo)==0) || (GXutil.strcmp("", A1578LegPuesCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Puesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGPUESCODIGO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(47);
      /* Using cursor BC000P50 */
      pr_default.execute(48, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(48) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
      }
      A45TipEmpleCod = BC000P50_A45TipEmpleCod[0] ;
      n45TipEmpleCod = BC000P50_n45TipEmpleCod[0] ;
      A1965EmpOsoCod = BC000P50_A1965EmpOsoCod[0] ;
      n1965EmpOsoCod = BC000P50_n1965EmpOsoCod[0] ;
      A2EmpNom = BC000P50_A2EmpNom[0] ;
      pr_default.close(48);
      /* Using cursor BC000P51 */
      pr_default.execute(49, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod});
      if ( (pr_default.getStatus(49) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1965EmpOsoCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Obra Social", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPOSOCOD");
            AnyError = (short)(1) ;
         }
      }
      A307OsoDescrip = BC000P51_A307OsoDescrip[0] ;
      n307OsoDescrip = BC000P51_n307OsoDescrip[0] ;
      A306OsoC3992 = BC000P51_A306OsoC3992[0] ;
      n306OsoC3992 = BC000P51_n306OsoC3992[0] ;
      pr_default.close(49);
      nIsDirty_23 = (short)(1) ;
      GXt_char4 = A681OsoDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char5) ;
      legajo_bc.this.GXt_char4 = GXv_char5[0] ;
      A681OsoDescripSinAc = GXt_char4 ;
      if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && (GXutil.strcmp("", A306OsoC3992)==0) )
      {
         nIsDirty_23 = (short)(1) ;
         A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
         {
            nIsDirty_23 = (short)(1) ;
            A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
         }
         else
         {
            if ( (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
            {
               nIsDirty_23 = (short)(1) ;
               A555OsoSiglaYDesc = GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
            }
            else
            {
               nIsDirty_23 = (short)(1) ;
               A555OsoSiglaYDesc = A307OsoDescrip ;
            }
         }
      }
      /* Using cursor BC000P52 */
      pr_default.execute(50, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1577LegSucCodigo), A1577LegSucCodigo});
      if ( (pr_default.getStatus(50) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (GXutil.strcmp("", A1577LegSucCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Sucursal", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSUCCODIGO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(50);
      nIsDirty_23 = (short)(1) ;
      A591LegNomApe = GXutil.trim( A230LegApellido) + ", " + GXutil.trim( A251LegNombre) ;
      nIsDirty_23 = (short)(1) ;
      A250LegIdNomApe = GXutil.trim( A93LegId) + " - " + GXutil.trim( A230LegApellido) + ", " + GXutil.trim( A251LegNombre) ;
      if ( ! ( ( A266LegTipDoc == 0 ) || ( A266LegTipDoc == 1 ) || ( A266LegTipDoc == 2 ) || ( A266LegTipDoc == 3 ) || ( A266LegTipDoc == 4 ) || ( A266LegTipDoc == 5 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de Documento", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      GXt_dtime6 = GXutil.resetTime( A246LegFecNac );
      GXt_dtime7 = GXutil.resetTime( A245LegFecIngreso );
      if ( ( GXutil.age( GXt_dtime6, GXt_dtime7) < 16 ) && ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A246LegFecNac)) && ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A245LegFecIngreso)) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La edad no puede ser menor a 16 (a la fecha de ingreso)", ""), 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000P53 */
      pr_default.execute(51, new Object[] {Boolean.valueOf(n263LegSexo), Byte.valueOf(A263LegSexo)});
      if ( (pr_default.getStatus(51) == 101) )
      {
         if ( ! ( (0==A263LegSexo) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Sexo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSEXO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(51);
      AV104LegSexo = A263LegSexo ;
      /* Using cursor BC000P54 */
      pr_default.execute(52, new Object[] {Boolean.valueOf(n243LegEstadoCivil), Short.valueOf(A243LegEstadoCivil)});
      if ( (pr_default.getStatus(52) == 101) )
      {
         if ( ! ( (0==A243LegEstadoCivil) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Estado Civil", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGESTADOCIVIL");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(52);
      /* Using cursor BC000P55 */
      pr_default.execute(53, new Object[] {Boolean.valueOf(n21LegNacionCod), Short.valueOf(A21LegNacionCod)});
      if ( (pr_default.getStatus(53) == 101) )
      {
         if ( ! ( (0==A21LegNacionCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Nacionalidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNACIONCOD");
            AnyError = (short)(1) ;
         }
      }
      A256LegNacionalidad = BC000P55_A256LegNacionalidad[0] ;
      pr_default.close(53);
      /* Using cursor BC000P56 */
      pr_default.execute(54, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod)});
      if ( (pr_default.getStatus(54) == 101) )
      {
         if ( ! ( (0==A22LegPaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Domicilio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGPAICOD");
            AnyError = (short)(1) ;
         }
      }
      A258LegPaiNom = BC000P56_A258LegPaiNom[0] ;
      pr_default.close(54);
      /* Using cursor BC000P57 */
      pr_default.execute(55, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod)});
      if ( (pr_default.getStatus(55) == 101) )
      {
         if ( ! ( (0==A22LegPaiCod) || (0==A23LegProvCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Domicilio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGPROVCOD");
            AnyError = (short)(1) ;
         }
      }
      A260LegProvNom = BC000P57_A260LegProvNom[0] ;
      pr_default.close(55);
      /* Using cursor BC000P58 */
      pr_default.execute(56, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod), Boolean.valueOf(n24LegLocCod), Short.valueOf(A24LegLocCod)});
      if ( (pr_default.getStatus(56) == 101) )
      {
         if ( ! ( (0==A22LegPaiCod) || (0==A23LegProvCod) || (0==A24LegLocCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Domicilio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGLOCCOD");
            AnyError = (short)(1) ;
         }
      }
      A255LegLocNom = BC000P58_A255LegLocNom[0] ;
      pr_default.close(56);
      /* Using cursor BC000P59 */
      pr_default.execute(57, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n910LegSinCod), A910LegSinCod});
      if ( (pr_default.getStatus(57) == 101) )
      {
         if ( ! ( (0==A22LegPaiCod) || (GXutil.strcmp("", A910LegSinCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Sindicato", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSINCOD");
            AnyError = (short)(1) ;
         }
      }
      A331SinDescrip = BC000P59_A331SinDescrip[0] ;
      n331SinDescrip = BC000P59_n331SinDescrip[0] ;
      pr_default.close(57);
      nIsDirty_23 = (short)(1) ;
      GXt_char4 = A680SinDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A331SinDescrip, GXv_char5) ;
      legajo_bc.this.GXt_char4 = GXv_char5[0] ;
      A680SinDescripSinAc = GXt_char4 ;
      /* Using cursor BC000P60 */
      pr_default.execute(58, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n2182LegActClasNro), Integer.valueOf(A2182LegActClasNro)});
      if ( (pr_default.getStatus(58) == 101) )
      {
         if ( ! ( (0==A22LegPaiCod) || (0==A2182LegActClasNro) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Act Lab Clasificada", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGACTCLASNRO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(58);
      if ( ! ( ( A235LegClase == 1 ) || ( A235LegClase == 2 ) || ( A235LegClase == 3 ) || ( A235LegClase == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Clase", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A248LegFormaPago == 1 ) || ( A248LegFormaPago == 2 ) || ( A248LegFormaPago == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Forma Pago", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A232LegBanTipCuen, "CA") == 0 ) || ( GXutil.strcmp(A232LegBanTipCuen, "CC") == 0 ) || (GXutil.strcmp("", A232LegBanTipCuen)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de Cuenta", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000P61 */
      pr_default.execute(59, new Object[] {Boolean.valueOf(n15LegActCodigo), A15LegActCodigo});
      if ( (pr_default.getStatus(59) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A15LegActCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Actividad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGACTCODIGO");
            AnyError = (short)(1) ;
         }
      }
      A227LegActDescri = BC000P61_A227LegActDescri[0] ;
      pr_default.close(59);
      /* Using cursor BC000P62 */
      pr_default.execute(60, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
      if ( (pr_default.getStatus(60) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A18MprCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Modalidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MPRCOD");
            AnyError = (short)(1) ;
         }
      }
      A684MprDescripSinAc = BC000P62_A684MprDescripSinAc[0] ;
      A303MprDescrip = BC000P62_A303MprDescrip[0] ;
      pr_default.close(60);
      /* Using cursor BC000P63 */
      pr_default.execute(61, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
      if ( (pr_default.getStatus(61) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A20ZonCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Zona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ZONCOD");
            AnyError = (short)(1) ;
         }
      }
      A678ZonDescripSinAc = BC000P63_A678ZonDescripSinAc[0] ;
      A342ZonDescrip = BC000P63_A342ZonDescrip[0] ;
      A343ZonPorcReduc = BC000P63_A343ZonPorcReduc[0] ;
      pr_default.close(61);
      /* Using cursor BC000P64 */
      pr_default.execute(62, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
      if ( (pr_default.getStatus(62) == 101) )
      {
         if ( ! ( (0==A17CondiCodigo) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condicion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONDICODIGO");
            AnyError = (short)(1) ;
         }
      }
      A686CondiDescriSinAc = BC000P64_A686CondiDescriSinAc[0] ;
      A144CondiDescri = BC000P64_A144CondiDescri[0] ;
      pr_default.close(62);
      /* Using cursor BC000P65 */
      pr_default.execute(63, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
      if ( (pr_default.getStatus(63) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A19SinieCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Siniestrado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SINIECODIGO");
            AnyError = (short)(1) ;
         }
      }
      A688SinieDescriSinAc = BC000P65_A688SinieDescriSinAc[0] ;
      A333SinieDescri = BC000P65_A333SinieDescri[0] ;
      pr_default.close(63);
      if ( ! (GXutil.strcmp("", A937LegConveCodigo)==0) )
      {
         nIsDirty_23 = (short)(1) ;
         A237LegConvenio = true ;
      }
      else
      {
         nIsDirty_23 = (short)(1) ;
         A237LegConvenio = false ;
      }
      if ( ! ( ( GXutil.strcmp(A879LegContinua, "SI") == 0 ) || ( GXutil.strcmp(A879LegContinua, "NO") == 0 ) || ( GXutil.strcmp(A879LegContinua, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Al cesar relación laboral, continúa con otro empleador.", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000P66 */
      pr_default.execute(64, new Object[] {Boolean.valueOf(n1603LegSitRevEgreso), Short.valueOf(A1603LegSitRevEgreso)});
      if ( (pr_default.getStatus(64) == 101) )
      {
         if ( ! ( (0==A1603LegSitRevEgreso) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Situacion Revista Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSITREVEGRESO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(64);
      if ( ! ( ( A1818LegEstado == 1 ) || ( A1818LegEstado == 2 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Estado", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000P67 */
      pr_default.execute(65, new Object[] {Boolean.valueOf(n2181LegPueAfiCod), A2181LegPueAfiCod});
      if ( (pr_default.getStatus(65) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A2181LegPueAfiCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo Puesto Afip", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGPUEAFICOD");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(65);
      if ( ! ( ( GXutil.strcmp(A2404LegModTra, "E") == 0 ) || ( GXutil.strcmp(A2404LegModTra, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Relación", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A2417LegTipoTarifa, "H") == 0 ) || ( GXutil.strcmp(A2417LegTipoTarifa, "P") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de tarifa", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0P23( )
   {
      pr_default.close(42);
      pr_default.close(43);
      pr_default.close(44);
      pr_default.close(45);
      pr_default.close(46);
      pr_default.close(47);
      pr_default.close(48);
      pr_default.close(49);
      pr_default.close(50);
      pr_default.close(51);
      pr_default.close(52);
      pr_default.close(53);
      pr_default.close(54);
      pr_default.close(55);
      pr_default.close(56);
      pr_default.close(57);
      pr_default.close(58);
      pr_default.close(59);
      pr_default.close(60);
      pr_default.close(61);
      pr_default.close(62);
      pr_default.close(63);
      pr_default.close(64);
      pr_default.close(65);
   }

   public void enableDisable( )
   {
   }

   public void getKey0P23( )
   {
      /* Using cursor BC000P68 */
      pr_default.execute(66, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(66) != 101) )
      {
         RcdFound23 = (short)(1) ;
      }
      else
      {
         RcdFound23 = (short)(0) ;
      }
      pr_default.close(66);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000P69 */
      pr_default.execute(67, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(67) != 101) )
      {
         zm0P23( 32) ;
         RcdFound23 = (short)(1) ;
         A19SinieCodigo = BC000P69_A19SinieCodigo[0] ;
         n19SinieCodigo = BC000P69_n19SinieCodigo[0] ;
         A263LegSexo = BC000P69_A263LegSexo[0] ;
         n263LegSexo = BC000P69_n263LegSexo[0] ;
         A243LegEstadoCivil = BC000P69_A243LegEstadoCivil[0] ;
         n243LegEstadoCivil = BC000P69_n243LegEstadoCivil[0] ;
         A22LegPaiCod = BC000P69_A22LegPaiCod[0] ;
         n22LegPaiCod = BC000P69_n22LegPaiCod[0] ;
         A23LegProvCod = BC000P69_A23LegProvCod[0] ;
         n23LegProvCod = BC000P69_n23LegProvCod[0] ;
         A24LegLocCod = BC000P69_A24LegLocCod[0] ;
         n24LegLocCod = BC000P69_n24LegLocCod[0] ;
         A21LegNacionCod = BC000P69_A21LegNacionCod[0] ;
         n21LegNacionCod = BC000P69_n21LegNacionCod[0] ;
         A910LegSinCod = BC000P69_A910LegSinCod[0] ;
         n910LegSinCod = BC000P69_n910LegSinCod[0] ;
         A2182LegActClasNro = BC000P69_A2182LegActClasNro[0] ;
         n2182LegActClasNro = BC000P69_n2182LegActClasNro[0] ;
         A15LegActCodigo = BC000P69_A15LegActCodigo[0] ;
         n15LegActCodigo = BC000P69_n15LegActCodigo[0] ;
         A1603LegSitRevEgreso = BC000P69_A1603LegSitRevEgreso[0] ;
         n1603LegSitRevEgreso = BC000P69_n1603LegSitRevEgreso[0] ;
         A2181LegPueAfiCod = BC000P69_A2181LegPueAfiCod[0] ;
         n2181LegPueAfiCod = BC000P69_n2181LegPueAfiCod[0] ;
         A1235LegReligion = BC000P69_A1235LegReligion[0] ;
         n1235LegReligion = BC000P69_n1235LegReligion[0] ;
         A1236LegOrigen = BC000P69_A1236LegOrigen[0] ;
         n1236LegOrigen = BC000P69_n1236LegOrigen[0] ;
         A237LegConvenio = BC000P69_A237LegConvenio[0] ;
         A250LegIdNomApe = BC000P69_A250LegIdNomApe[0] ;
         A591LegNomApe = BC000P69_A591LegNomApe[0] ;
         A6LegNumero = BC000P69_A6LegNumero[0] ;
         A247LegFecUltMod = BC000P69_A247LegFecUltMod[0] ;
         A230LegApellido = BC000P69_A230LegApellido[0] ;
         A251LegNombre = BC000P69_A251LegNombre[0] ;
         A249LegFoto = BC000P69_A249LegFoto[0] ;
         n249LegFoto = BC000P69_n249LegFoto[0] ;
         A266LegTipDoc = BC000P69_A266LegTipDoc[0] ;
         A257LegNumDoc = BC000P69_A257LegNumDoc[0] ;
         A246LegFecNac = BC000P69_A246LegFecNac[0] ;
         A239LegCUIL = BC000P69_A239LegCUIL[0] ;
         A241LegDiscapacidad = BC000P69_A241LegDiscapacidad[0] ;
         A242LegDomici = BC000P69_A242LegDomici[0] ;
         A479LegEmail = BC000P69_A479LegEmail[0] ;
         A236LegCodPos = BC000P69_A236LegCodPos[0] ;
         A265LegTelefono = BC000P69_A265LegTelefono[0] ;
         n265LegTelefono = BC000P69_n265LegTelefono[0] ;
         A245LegFecIngreso = BC000P69_A245LegFecIngreso[0] ;
         A244LegFecEgreso = BC000P69_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC000P69_n244LegFecEgreso[0] ;
         A939LegCatCodigo = BC000P69_A939LegCatCodigo[0] ;
         n939LegCatCodigo = BC000P69_n939LegCatCodigo[0] ;
         A2215LegCatPueCod = BC000P69_A2215LegCatPueCod[0] ;
         n2215LegCatPueCod = BC000P69_n2215LegCatPueCod[0] ;
         A235LegClase = BC000P69_A235LegClase[0] ;
         A248LegFormaPago = BC000P69_A248LegFormaPago[0] ;
         A231LegBanSuc = BC000P69_A231LegBanSuc[0] ;
         n231LegBanSuc = BC000P69_n231LegBanSuc[0] ;
         A232LegBanTipCuen = BC000P69_A232LegBanTipCuen[0] ;
         n232LegBanTipCuen = BC000P69_n232LegBanTipCuen[0] ;
         A238LegCuentaBanc = BC000P69_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = BC000P69_n238LegCuentaBanc[0] ;
         A253LegLicInicio = BC000P69_A253LegLicInicio[0] ;
         n253LegLicInicio = BC000P69_n253LegLicInicio[0] ;
         A252LegLicFinal = BC000P69_A252LegLicFinal[0] ;
         n252LegLicFinal = BC000P69_n252LegLicFinal[0] ;
         A234LegCBU = BC000P69_A234LegCBU[0] ;
         n234LegCBU = BC000P69_n234LegCBU[0] ;
         A262LegSCVO = BC000P69_A262LegSCVO[0] ;
         A228LegActivo = BC000P69_A228LegActivo[0] ;
         A264LegSueldoFuera = BC000P69_A264LegSueldoFuera[0] ;
         A93LegId = BC000P69_A93LegId[0] ;
         n93LegId = BC000P69_n93LegId[0] ;
         A937LegConveCodigo = BC000P69_A937LegConveCodigo[0] ;
         n937LegConveCodigo = BC000P69_n937LegConveCodigo[0] ;
         A515LegObs = BC000P69_A515LegObs[0] ;
         A630LegFecImportacion = BC000P69_A630LegFecImportacion[0] ;
         A877LegAgenReten = BC000P69_A877LegAgenReten[0] ;
         A879LegContinua = BC000P69_A879LegContinua[0] ;
         A942LegRecalcLiq = BC000P69_A942LegRecalcLiq[0] ;
         A1016LegJubilado = BC000P69_A1016LegJubilado[0] ;
         A1023LegHorasDia = BC000P69_A1023LegHorasDia[0] ;
         A1268LegHorasSem = BC000P69_A1268LegHorasSem[0] ;
         A1245LegTrabLun = BC000P69_A1245LegTrabLun[0] ;
         A1246LegTrabMar = BC000P69_A1246LegTrabMar[0] ;
         A1247LegTrabMie = BC000P69_A1247LegTrabMie[0] ;
         A1248LegTrabJue = BC000P69_A1248LegTrabJue[0] ;
         A1249LegTrabVie = BC000P69_A1249LegTrabVie[0] ;
         A1250LegTrabSa = BC000P69_A1250LegTrabSa[0] ;
         A1251LegTrabDo = BC000P69_A1251LegTrabDo[0] ;
         A1523LegVacPend = BC000P69_A1523LegVacPend[0] ;
         A1531LegFecPreAviso = BC000P69_A1531LegFecPreAviso[0] ;
         A1576LegConveVersionCli = BC000P69_A1576LegConveVersionCli[0] ;
         n1576LegConveVersionCli = BC000P69_n1576LegConveVersionCli[0] ;
         A1759LegPromDias = BC000P69_A1759LegPromDias[0] ;
         A1804LegTitulo = BC000P69_A1804LegTitulo[0] ;
         A1818LegEstado = BC000P69_A1818LegEstado[0] ;
         A2263LegMigrWarn = BC000P69_A2263LegMigrWarn[0] ;
         n2263LegMigrWarn = BC000P69_n2263LegMigrWarn[0] ;
         A2267LegIncompleto = BC000P69_A2267LegIncompleto[0] ;
         A2309LegLiqApo = BC000P69_A2309LegLiqApo[0] ;
         A2404LegModTra = BC000P69_A2404LegModTra[0] ;
         A2417LegTipoTarifa = BC000P69_A2417LegTipoTarifa[0] ;
         A1031LegFotoExt = BC000P69_A1031LegFotoExt[0] ;
         A249LegFoto_Filetype = A1031LegFotoExt ;
         A1030LegFotoNom = BC000P69_A1030LegFotoNom[0] ;
         A249LegFoto_Filename = A1030LegFotoNom ;
         A3CliCod = BC000P69_A3CliCod[0] ;
         A1582LegBanCod = BC000P69_A1582LegBanCod[0] ;
         n1582LegBanCod = BC000P69_n1582LegBanCod[0] ;
         A1581LegLpgCodigo = BC000P69_A1581LegLpgCodigo[0] ;
         n1581LegLpgCodigo = BC000P69_n1581LegLpgCodigo[0] ;
         A1583LegMegCodigo = BC000P69_A1583LegMegCodigo[0] ;
         n1583LegMegCodigo = BC000P69_n1583LegMegCodigo[0] ;
         A1580LegOsoCod = BC000P69_A1580LegOsoCod[0] ;
         n1580LegOsoCod = BC000P69_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = BC000P69_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = BC000P69_n1579LegSecCodigo[0] ;
         A1EmpCod = BC000P69_A1EmpCod[0] ;
         A1577LegSucCodigo = BC000P69_A1577LegSucCodigo[0] ;
         n1577LegSucCodigo = BC000P69_n1577LegSucCodigo[0] ;
         A1578LegPuesCodigo = BC000P69_A1578LegPuesCodigo[0] ;
         n1578LegPuesCodigo = BC000P69_n1578LegPuesCodigo[0] ;
         A18MprCod = BC000P69_A18MprCod[0] ;
         n18MprCod = BC000P69_n18MprCod[0] ;
         A20ZonCod = BC000P69_A20ZonCod[0] ;
         n20ZonCod = BC000P69_n20ZonCod[0] ;
         A17CondiCodigo = BC000P69_A17CondiCodigo[0] ;
         n17CondiCodigo = BC000P69_n17CondiCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         sMode23 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0P23( ) ;
         if ( AnyError == 1 )
         {
            RcdFound23 = (short)(0) ;
            initializeNonKey0P23( ) ;
         }
         Gx_mode = sMode23 ;
      }
      else
      {
         RcdFound23 = (short)(0) ;
         initializeNonKey0P23( ) ;
         sMode23 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode23 ;
      }
      pr_default.close(67);
   }

   public void getEqualNoModal( )
   {
      getKey0P23( ) ;
      if ( RcdFound23 == 0 )
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
      confirm_0P0( ) ;
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

   public void checkOptimisticConcurrency0P23( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000P70 */
         pr_default.execute(68, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(68) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Legajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(68) == 101) || ( Z237LegConvenio != BC000P70_A237LegConvenio[0] ) || ( GXutil.strcmp(Z250LegIdNomApe, BC000P70_A250LegIdNomApe[0]) != 0 ) || ( GXutil.strcmp(Z591LegNomApe, BC000P70_A591LegNomApe[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z247LegFecUltMod), GXutil.resetTime(BC000P70_A247LegFecUltMod[0])) ) || ( GXutil.strcmp(Z230LegApellido, BC000P70_A230LegApellido[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z251LegNombre, BC000P70_A251LegNombre[0]) != 0 ) || ( Z266LegTipDoc != BC000P70_A266LegTipDoc[0] ) || ( GXutil.strcmp(Z257LegNumDoc, BC000P70_A257LegNumDoc[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z246LegFecNac), GXutil.resetTime(BC000P70_A246LegFecNac[0])) ) || ( Z239LegCUIL != BC000P70_A239LegCUIL[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z241LegDiscapacidad != BC000P70_A241LegDiscapacidad[0] ) || ( GXutil.strcmp(Z242LegDomici, BC000P70_A242LegDomici[0]) != 0 ) || ( GXutil.strcmp(Z479LegEmail, BC000P70_A479LegEmail[0]) != 0 ) || ( GXutil.strcmp(Z236LegCodPos, BC000P70_A236LegCodPos[0]) != 0 ) || ( GXutil.strcmp(Z265LegTelefono, BC000P70_A265LegTelefono[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z245LegFecIngreso), GXutil.resetTime(BC000P70_A245LegFecIngreso[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z244LegFecEgreso), GXutil.resetTime(BC000P70_A244LegFecEgreso[0])) ) || ( GXutil.strcmp(Z939LegCatCodigo, BC000P70_A939LegCatCodigo[0]) != 0 ) || ( Z2215LegCatPueCod != BC000P70_A2215LegCatPueCod[0] ) || ( Z235LegClase != BC000P70_A235LegClase[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z248LegFormaPago != BC000P70_A248LegFormaPago[0] ) || ( GXutil.strcmp(Z231LegBanSuc, BC000P70_A231LegBanSuc[0]) != 0 ) || ( GXutil.strcmp(Z232LegBanTipCuen, BC000P70_A232LegBanTipCuen[0]) != 0 ) || ( GXutil.strcmp(Z238LegCuentaBanc, BC000P70_A238LegCuentaBanc[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z253LegLicInicio), GXutil.resetTime(BC000P70_A253LegLicInicio[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z252LegLicFinal), GXutil.resetTime(BC000P70_A252LegLicFinal[0])) ) || ( GXutil.strcmp(Z234LegCBU, BC000P70_A234LegCBU[0]) != 0 ) || ( Z262LegSCVO != BC000P70_A262LegSCVO[0] ) || ( Z228LegActivo != BC000P70_A228LegActivo[0] ) || ( DecimalUtil.compareTo(Z264LegSueldoFuera, BC000P70_A264LegSueldoFuera[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z93LegId, BC000P70_A93LegId[0]) != 0 ) || ( GXutil.strcmp(Z937LegConveCodigo, BC000P70_A937LegConveCodigo[0]) != 0 ) || !( GXutil.dateCompare(Z630LegFecImportacion, BC000P70_A630LegFecImportacion[0]) ) || ( Z877LegAgenReten != BC000P70_A877LegAgenReten[0] ) || ( GXutil.strcmp(Z879LegContinua, BC000P70_A879LegContinua[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z942LegRecalcLiq != BC000P70_A942LegRecalcLiq[0] ) || ( Z1016LegJubilado != BC000P70_A1016LegJubilado[0] ) || ( DecimalUtil.compareTo(Z1023LegHorasDia, BC000P70_A1023LegHorasDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1268LegHorasSem, BC000P70_A1268LegHorasSem[0]) != 0 ) || ( Z1245LegTrabLun != BC000P70_A1245LegTrabLun[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1246LegTrabMar != BC000P70_A1246LegTrabMar[0] ) || ( Z1247LegTrabMie != BC000P70_A1247LegTrabMie[0] ) || ( Z1248LegTrabJue != BC000P70_A1248LegTrabJue[0] ) || ( Z1249LegTrabVie != BC000P70_A1249LegTrabVie[0] ) || ( Z1250LegTrabSa != BC000P70_A1250LegTrabSa[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1251LegTrabDo != BC000P70_A1251LegTrabDo[0] ) || ( Z1523LegVacPend != BC000P70_A1523LegVacPend[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z1531LegFecPreAviso), GXutil.resetTime(BC000P70_A1531LegFecPreAviso[0])) ) || ( Z1576LegConveVersionCli != BC000P70_A1576LegConveVersionCli[0] ) || ( GXutil.strcmp(Z1759LegPromDias, BC000P70_A1759LegPromDias[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1804LegTitulo, BC000P70_A1804LegTitulo[0]) != 0 ) || ( Z1818LegEstado != BC000P70_A1818LegEstado[0] ) || ( Z2267LegIncompleto != BC000P70_A2267LegIncompleto[0] ) || ( Z2309LegLiqApo != BC000P70_A2309LegLiqApo[0] ) || ( GXutil.strcmp(Z2404LegModTra, BC000P70_A2404LegModTra[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2417LegTipoTarifa, BC000P70_A2417LegTipoTarifa[0]) != 0 ) || ( GXutil.strcmp(Z1582LegBanCod, BC000P70_A1582LegBanCod[0]) != 0 ) || ( GXutil.strcmp(Z1581LegLpgCodigo, BC000P70_A1581LegLpgCodigo[0]) != 0 ) || ( GXutil.strcmp(Z1583LegMegCodigo, BC000P70_A1583LegMegCodigo[0]) != 0 ) || ( GXutil.strcmp(Z1580LegOsoCod, BC000P70_A1580LegOsoCod[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1579LegSecCodigo, BC000P70_A1579LegSecCodigo[0]) != 0 ) || ( GXutil.strcmp(Z1577LegSucCodigo, BC000P70_A1577LegSucCodigo[0]) != 0 ) || ( GXutil.strcmp(Z1578LegPuesCodigo, BC000P70_A1578LegPuesCodigo[0]) != 0 ) || ( GXutil.strcmp(Z18MprCod, BC000P70_A18MprCod[0]) != 0 ) || ( GXutil.strcmp(Z20ZonCod, BC000P70_A20ZonCod[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z17CondiCodigo != BC000P70_A17CondiCodigo[0] ) || ( GXutil.strcmp(Z19SinieCodigo, BC000P70_A19SinieCodigo[0]) != 0 ) || ( Z263LegSexo != BC000P70_A263LegSexo[0] ) || ( Z243LegEstadoCivil != BC000P70_A243LegEstadoCivil[0] ) || ( Z22LegPaiCod != BC000P70_A22LegPaiCod[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z23LegProvCod != BC000P70_A23LegProvCod[0] ) || ( Z24LegLocCod != BC000P70_A24LegLocCod[0] ) || ( Z21LegNacionCod != BC000P70_A21LegNacionCod[0] ) || ( GXutil.strcmp(Z910LegSinCod, BC000P70_A910LegSinCod[0]) != 0 ) || ( Z2182LegActClasNro != BC000P70_A2182LegActClasNro[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z15LegActCodigo, BC000P70_A15LegActCodigo[0]) != 0 ) || ( Z1603LegSitRevEgreso != BC000P70_A1603LegSitRevEgreso[0] ) || ( GXutil.strcmp(Z2181LegPueAfiCod, BC000P70_A2181LegPueAfiCod[0]) != 0 ) || ( GXutil.strcmp(Z1235LegReligion, BC000P70_A1235LegReligion[0]) != 0 ) || ( GXutil.strcmp(Z1236LegOrigen, BC000P70_A1236LegOrigen[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Legajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0P23( )
   {
      beforeValidate0P23( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P23( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0P23( 0) ;
         checkOptimisticConcurrency0P23( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P23( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0P23( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000P71 */
                  pr_default.execute(69, new Object[] {Boolean.valueOf(A237LegConvenio), A250LegIdNomApe, A591LegNomApe, Integer.valueOf(A6LegNumero), A247LegFecUltMod, A230LegApellido, A251LegNombre, Boolean.valueOf(n249LegFoto), A249LegFoto, Byte.valueOf(A266LegTipDoc), A257LegNumDoc, A246LegFecNac, Long.valueOf(A239LegCUIL), Byte.valueOf(A241LegDiscapacidad), A242LegDomici, A479LegEmail, A236LegCodPos, Boolean.valueOf(n265LegTelefono), A265LegTelefono, A245LegFecIngreso, Boolean.valueOf(n244LegFecEgreso), A244LegFecEgreso, Boolean.valueOf(n939LegCatCodigo), A939LegCatCodigo, Boolean.valueOf(n2215LegCatPueCod), Integer.valueOf(A2215LegCatPueCod), Byte.valueOf(A235LegClase), Byte.valueOf(A248LegFormaPago), Boolean.valueOf(n231LegBanSuc), A231LegBanSuc, Boolean.valueOf(n232LegBanTipCuen), A232LegBanTipCuen, Boolean.valueOf(n238LegCuentaBanc), A238LegCuentaBanc, Boolean.valueOf(n253LegLicInicio), A253LegLicInicio, Boolean.valueOf(n252LegLicFinal), A252LegLicFinal, Boolean.valueOf(n234LegCBU), A234LegCBU, Boolean.valueOf(A262LegSCVO), Boolean.valueOf(A228LegActivo), A264LegSueldoFuera, Boolean.valueOf(n93LegId), A93LegId, Boolean.valueOf(n937LegConveCodigo), A937LegConveCodigo, A515LegObs, A630LegFecImportacion, Boolean.valueOf(A877LegAgenReten), A879LegContinua, Boolean.valueOf(A942LegRecalcLiq), Boolean.valueOf(A1016LegJubilado), A1023LegHorasDia, A1268LegHorasSem, Boolean.valueOf(A1245LegTrabLun), Boolean.valueOf(A1246LegTrabMar), Boolean.valueOf(A1247LegTrabMie), Boolean.valueOf(A1248LegTrabJue), Boolean.valueOf(A1249LegTrabVie), Boolean.valueOf(A1250LegTrabSa), Boolean.valueOf(A1251LegTrabDo), Short.valueOf(A1523LegVacPend), A1531LegFecPreAviso, Boolean.valueOf(n1576LegConveVersionCli), Integer.valueOf(A1576LegConveVersionCli), A1759LegPromDias, A1804LegTitulo, Byte.valueOf(A1818LegEstado), Boolean.valueOf(n2263LegMigrWarn), A2263LegMigrWarn, Boolean.valueOf(A2267LegIncompleto), Boolean.valueOf(A2309LegLiqApo), A2404LegModTra, A2417LegTipoTarifa, A1031LegFotoExt, A1030LegFotoNom, Integer.valueOf(A3CliCod), Boolean.valueOf(n1582LegBanCod), A1582LegBanCod, Boolean.valueOf(n1581LegLpgCodigo), A1581LegLpgCodigo, Boolean.valueOf(n1583LegMegCodigo), A1583LegMegCodigo, Boolean.valueOf(n1580LegOsoCod), A1580LegOsoCod, Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo, Short.valueOf(A1EmpCod), Boolean.valueOf(n1577LegSucCodigo), A1577LegSucCodigo, Boolean.valueOf(n1578LegPuesCodigo), A1578LegPuesCodigo, Boolean.valueOf(n18MprCod), A18MprCod, Boolean.valueOf(n20ZonCod), A20ZonCod, Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo), Boolean.valueOf(n19SinieCodigo), A19SinieCodigo, Boolean.valueOf(n263LegSexo), Byte.valueOf(A263LegSexo), Boolean.valueOf(n243LegEstadoCivil), Short.valueOf(A243LegEstadoCivil), Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod), Boolean.valueOf(n24LegLocCod), Short.valueOf(A24LegLocCod), Boolean.valueOf(n21LegNacionCod), Short.valueOf(A21LegNacionCod), Boolean.valueOf(n910LegSinCod), A910LegSinCod, Boolean.valueOf(n2182LegActClasNro), Integer.valueOf(A2182LegActClasNro), Boolean.valueOf(n15LegActCodigo), A15LegActCodigo, Boolean.valueOf(n1603LegSitRevEgreso), Short.valueOf(A1603LegSitRevEgreso), Boolean.valueOf(n2181LegPueAfiCod),
                  A2181LegPueAfiCod, Boolean.valueOf(n1235LegReligion), A1235LegReligion, Boolean.valueOf(n1236LegOrigen), A1236LegOrigen});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
                  if ( (pr_default.getStatus(69) == 1) )
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
                        processLevel0P23( ) ;
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
            load0P23( ) ;
         }
         endLevel0P23( ) ;
      }
      closeExtendedTableCursors0P23( ) ;
   }

   public void update0P23( )
   {
      beforeValidate0P23( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P23( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P23( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P23( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0P23( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000P72 */
                  pr_default.execute(70, new Object[] {Boolean.valueOf(A237LegConvenio), A250LegIdNomApe, A591LegNomApe, A247LegFecUltMod, A230LegApellido, A251LegNombre, Byte.valueOf(A266LegTipDoc), A257LegNumDoc, A246LegFecNac, Long.valueOf(A239LegCUIL), Byte.valueOf(A241LegDiscapacidad), A242LegDomici, A479LegEmail, A236LegCodPos, Boolean.valueOf(n265LegTelefono), A265LegTelefono, A245LegFecIngreso, Boolean.valueOf(n244LegFecEgreso), A244LegFecEgreso, Boolean.valueOf(n939LegCatCodigo), A939LegCatCodigo, Boolean.valueOf(n2215LegCatPueCod), Integer.valueOf(A2215LegCatPueCod), Byte.valueOf(A235LegClase), Byte.valueOf(A248LegFormaPago), Boolean.valueOf(n231LegBanSuc), A231LegBanSuc, Boolean.valueOf(n232LegBanTipCuen), A232LegBanTipCuen, Boolean.valueOf(n238LegCuentaBanc), A238LegCuentaBanc, Boolean.valueOf(n253LegLicInicio), A253LegLicInicio, Boolean.valueOf(n252LegLicFinal), A252LegLicFinal, Boolean.valueOf(n234LegCBU), A234LegCBU, Boolean.valueOf(A262LegSCVO), Boolean.valueOf(A228LegActivo), A264LegSueldoFuera, Boolean.valueOf(n93LegId), A93LegId, Boolean.valueOf(n937LegConveCodigo), A937LegConveCodigo, A515LegObs, A630LegFecImportacion, Boolean.valueOf(A877LegAgenReten), A879LegContinua, Boolean.valueOf(A942LegRecalcLiq), Boolean.valueOf(A1016LegJubilado), A1023LegHorasDia, A1268LegHorasSem, Boolean.valueOf(A1245LegTrabLun), Boolean.valueOf(A1246LegTrabMar), Boolean.valueOf(A1247LegTrabMie), Boolean.valueOf(A1248LegTrabJue), Boolean.valueOf(A1249LegTrabVie), Boolean.valueOf(A1250LegTrabSa), Boolean.valueOf(A1251LegTrabDo), Short.valueOf(A1523LegVacPend), A1531LegFecPreAviso, Boolean.valueOf(n1576LegConveVersionCli), Integer.valueOf(A1576LegConveVersionCli), A1759LegPromDias, A1804LegTitulo, Byte.valueOf(A1818LegEstado), Boolean.valueOf(n2263LegMigrWarn), A2263LegMigrWarn, Boolean.valueOf(A2267LegIncompleto), Boolean.valueOf(A2309LegLiqApo), A2404LegModTra, A2417LegTipoTarifa, A1031LegFotoExt, A1030LegFotoNom, Boolean.valueOf(n1582LegBanCod), A1582LegBanCod, Boolean.valueOf(n1581LegLpgCodigo), A1581LegLpgCodigo, Boolean.valueOf(n1583LegMegCodigo), A1583LegMegCodigo, Boolean.valueOf(n1580LegOsoCod), A1580LegOsoCod, Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo, Boolean.valueOf(n1577LegSucCodigo), A1577LegSucCodigo, Boolean.valueOf(n1578LegPuesCodigo), A1578LegPuesCodigo, Boolean.valueOf(n18MprCod), A18MprCod, Boolean.valueOf(n20ZonCod), A20ZonCod, Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo), Boolean.valueOf(n19SinieCodigo), A19SinieCodigo, Boolean.valueOf(n263LegSexo), Byte.valueOf(A263LegSexo), Boolean.valueOf(n243LegEstadoCivil), Short.valueOf(A243LegEstadoCivil), Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod), Boolean.valueOf(n24LegLocCod), Short.valueOf(A24LegLocCod), Boolean.valueOf(n21LegNacionCod), Short.valueOf(A21LegNacionCod), Boolean.valueOf(n910LegSinCod), A910LegSinCod, Boolean.valueOf(n2182LegActClasNro), Integer.valueOf(A2182LegActClasNro), Boolean.valueOf(n15LegActCodigo), A15LegActCodigo, Boolean.valueOf(n1603LegSitRevEgreso), Short.valueOf(A1603LegSitRevEgreso), Boolean.valueOf(n2181LegPueAfiCod), A2181LegPueAfiCod, Boolean.valueOf(n1235LegReligion), A1235LegReligion, Boolean.valueOf(n1236LegOrigen), A1236LegOrigen,
                  Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
                  if ( (pr_default.getStatus(70) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Legajo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0P23( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0P23( ) ;
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
         endLevel0P23( ) ;
      }
      closeExtendedTableCursors0P23( ) ;
   }

   public void deferredUpdate0P23( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC000P73 */
         pr_default.execute(71, new Object[] {Boolean.valueOf(n249LegFoto), A249LegFoto, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0P23( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P23( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0P23( ) ;
         afterConfirm0P23( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0P23( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart0P276( ) ;
               while ( RcdFound276 != 0 )
               {
                  getByPrimaryKey0P276( ) ;
                  delete0P276( ) ;
                  scanKeyNext0P276( ) ;
               }
               scanKeyEnd0P276( ) ;
               scanKeyStart0P170( ) ;
               while ( RcdFound170 != 0 )
               {
                  getByPrimaryKey0P170( ) ;
                  delete0P170( ) ;
                  scanKeyNext0P170( ) ;
               }
               scanKeyEnd0P170( ) ;
               scanKeyStart0P24( ) ;
               while ( RcdFound24 != 0 )
               {
                  getByPrimaryKey0P24( ) ;
                  delete0P24( ) ;
                  scanKeyNext0P24( ) ;
               }
               scanKeyEnd0P24( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000P74 */
                  pr_default.execute(72, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
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
      sMode23 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0P23( ) ;
      Gx_mode = sMode23 ;
   }

   public void onDeleteControls0P23( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV141Pgmname = "Legajo_BC" ;
         /* Using cursor BC000P75 */
         pr_default.execute(73, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         A1965EmpOsoCod = BC000P75_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC000P75_n1965EmpOsoCod[0] ;
         A2EmpNom = BC000P75_A2EmpNom[0] ;
         A45TipEmpleCod = BC000P75_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC000P75_n45TipEmpleCod[0] ;
         pr_default.close(73);
         /* Using cursor BC000P76 */
         pr_default.execute(74, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod});
         A307OsoDescrip = BC000P76_A307OsoDescrip[0] ;
         n307OsoDescrip = BC000P76_n307OsoDescrip[0] ;
         A306OsoC3992 = BC000P76_A306OsoC3992[0] ;
         n306OsoC3992 = BC000P76_n306OsoC3992[0] ;
         pr_default.close(74);
         GXt_char4 = A681OsoDescripSinAc ;
         GXv_char5[0] = GXt_char4 ;
         new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char5) ;
         legajo_bc.this.GXt_char4 = GXv_char5[0] ;
         A681OsoDescripSinAc = GXt_char4 ;
         AV104LegSexo = A263LegSexo ;
         /* Using cursor BC000P77 */
         pr_default.execute(75, new Object[] {Boolean.valueOf(n21LegNacionCod), Short.valueOf(A21LegNacionCod)});
         A256LegNacionalidad = BC000P77_A256LegNacionalidad[0] ;
         pr_default.close(75);
         /* Using cursor BC000P78 */
         pr_default.execute(76, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod)});
         A258LegPaiNom = BC000P78_A258LegPaiNom[0] ;
         pr_default.close(76);
         /* Using cursor BC000P79 */
         pr_default.execute(77, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod)});
         A260LegProvNom = BC000P79_A260LegProvNom[0] ;
         pr_default.close(77);
         /* Using cursor BC000P80 */
         pr_default.execute(78, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod), Boolean.valueOf(n24LegLocCod), Short.valueOf(A24LegLocCod)});
         A255LegLocNom = BC000P80_A255LegLocNom[0] ;
         pr_default.close(78);
         /* Using cursor BC000P81 */
         pr_default.execute(79, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1583LegMegCodigo), A1583LegMegCodigo});
         A300MegDescrip = BC000P81_A300MegDescrip[0] ;
         n300MegDescrip = BC000P81_n300MegDescrip[0] ;
         pr_default.close(79);
         /* Using cursor BC000P82 */
         pr_default.execute(80, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo});
         A329SecDescrip = BC000P82_A329SecDescrip[0] ;
         n329SecDescrip = BC000P82_n329SecDescrip[0] ;
         pr_default.close(80);
         GXt_char4 = A675SecDescripSinAc ;
         GXv_char5[0] = GXt_char4 ;
         new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char5) ;
         legajo_bc.this.GXt_char4 = GXv_char5[0] ;
         A675SecDescripSinAc = GXt_char4 ;
         /* Using cursor BC000P83 */
         pr_default.execute(81, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1581LegLpgCodigo), A1581LegLpgCodigo});
         A291LpgDescri = BC000P83_A291LpgDescri[0] ;
         n291LpgDescri = BC000P83_n291LpgDescri[0] ;
         pr_default.close(81);
         GXt_char4 = A677LpgDescriSinAc ;
         GXv_char5[0] = GXt_char4 ;
         new web.sacaracentos2(remoteHandle, context).execute( A291LpgDescri, GXv_char5) ;
         legajo_bc.this.GXt_char4 = GXv_char5[0] ;
         A677LpgDescriSinAc = GXt_char4 ;
         /* Using cursor BC000P84 */
         pr_default.execute(82, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1582LegBanCod), A1582LegBanCod});
         A2224LegBanDes = BC000P84_A2224LegBanDes[0] ;
         pr_default.close(82);
         /* Using cursor BC000P85 */
         pr_default.execute(83, new Object[] {Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n910LegSinCod), A910LegSinCod});
         A331SinDescrip = BC000P85_A331SinDescrip[0] ;
         n331SinDescrip = BC000P85_n331SinDescrip[0] ;
         pr_default.close(83);
         GXt_char4 = A680SinDescripSinAc ;
         GXv_char5[0] = GXt_char4 ;
         new web.sacaracentos2(remoteHandle, context).execute( A331SinDescrip, GXv_char5) ;
         legajo_bc.this.GXt_char4 = GXv_char5[0] ;
         A680SinDescripSinAc = GXt_char4 ;
         /* Using cursor BC000P86 */
         pr_default.execute(84, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1580LegOsoCod), A1580LegOsoCod});
         A2225LegOsoDes = BC000P86_A2225LegOsoDes[0] ;
         A2226LegOsoAfipCod = BC000P86_A2226LegOsoAfipCod[0] ;
         n2226LegOsoAfipCod = BC000P86_n2226LegOsoAfipCod[0] ;
         A392OsoSigla = BC000P86_A392OsoSigla[0] ;
         n392OsoSigla = BC000P86_n392OsoSigla[0] ;
         pr_default.close(84);
         if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && (GXutil.strcmp("", A306OsoC3992)==0) )
         {
            A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) ;
         }
         else
         {
            if ( ! (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
            {
               A555OsoSiglaYDesc = GXutil.trim( A392OsoSigla) + " " + GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
            }
            else
            {
               if ( (GXutil.strcmp("", A392OsoSigla)==0) && ! (GXutil.strcmp("", A306OsoC3992)==0) )
               {
                  A555OsoSiglaYDesc = GXutil.trim( A307OsoDescrip) + httpContext.getMessage( " (Cod. ", "") + GXutil.trim( A306OsoC3992) + ")" ;
               }
               else
               {
                  A555OsoSiglaYDesc = A307OsoDescrip ;
               }
            }
         }
         /* Using cursor BC000P87 */
         pr_default.execute(85, new Object[] {Boolean.valueOf(n15LegActCodigo), A15LegActCodigo});
         A227LegActDescri = BC000P87_A227LegActDescri[0] ;
         pr_default.close(85);
         /* Using cursor BC000P88 */
         pr_default.execute(86, new Object[] {Boolean.valueOf(n18MprCod), A18MprCod});
         A684MprDescripSinAc = BC000P88_A684MprDescripSinAc[0] ;
         A303MprDescrip = BC000P88_A303MprDescrip[0] ;
         pr_default.close(86);
         /* Using cursor BC000P89 */
         pr_default.execute(87, new Object[] {Boolean.valueOf(n20ZonCod), A20ZonCod});
         A678ZonDescripSinAc = BC000P89_A678ZonDescripSinAc[0] ;
         A342ZonDescrip = BC000P89_A342ZonDescrip[0] ;
         A343ZonPorcReduc = BC000P89_A343ZonPorcReduc[0] ;
         pr_default.close(87);
         /* Using cursor BC000P90 */
         pr_default.execute(88, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
         A686CondiDescriSinAc = BC000P90_A686CondiDescriSinAc[0] ;
         A144CondiDescri = BC000P90_A144CondiDescri[0] ;
         pr_default.close(88);
         /* Using cursor BC000P91 */
         pr_default.execute(89, new Object[] {Boolean.valueOf(n19SinieCodigo), A19SinieCodigo});
         A688SinieDescriSinAc = BC000P91_A688SinieDescriSinAc[0] ;
         A333SinieDescri = BC000P91_A333SinieDescri[0] ;
         pr_default.close(89);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000P92 */
         pr_default.execute(90, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(90) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_cuenta_licencias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(90);
         /* Using cursor BC000P93 */
         pr_default.execute(91, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(91) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_permanencia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(91);
         /* Using cursor BC000P94 */
         pr_default.execute(92, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(92) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LegPreliqCab", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(92);
         /* Using cursor BC000P95 */
         pr_default.execute(93, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(93) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Obligacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(93);
         /* Using cursor BC000P96 */
         pr_default.execute(94, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(94) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Sueldos por fecha", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(94);
         /* Using cursor BC000P97 */
         pr_default.execute(95, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(95) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 Leg Remu", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(95);
         /* Using cursor BC000P98 */
         pr_default.execute(96, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(96) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 Leg Ded Gen", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(96);
         /* Using cursor BC000P99 */
         pr_default.execute(97, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(97) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 Leg", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(97);
         /* Using cursor BC000P100 */
         pr_default.execute(98, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(98) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 LDed Per", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(98);
         /* Using cursor BC000P101 */
         pr_default.execute(99, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(99) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 LCalculo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(99);
         /* Using cursor BC000P102 */
         pr_default.execute(100, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(100) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_dedducciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(100);
         /* Using cursor BC000P103 */
         pr_default.execute(101, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(101) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Centros de Costo de Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(101);
         /* Using cursor BC000P104 */
         pr_default.execute(102, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(102) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo Licencias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(102);
         /* Using cursor BC000P105 */
         pr_default.execute(103, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(103) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(103);
         /* Using cursor BC000P106 */
         pr_default.execute(104, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(104) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Agenda de Novedades", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(104);
      }
   }

   public void processNestedLevel0P129( )
   {
      nGXsfl_129_idx = 0 ;
      while ( nGXsfl_129_idx < bcLegajo.getgxTv_SdtLegajo_Salario().size() )
      {
         readRow0P129( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound129 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_129 != 0 ) )
         {
            standaloneNotModal0P129( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0P129( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0P129( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0P129( ) ;
               }
            }
         }
         KeyVarsToRow129( ((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_129_idx = 0 ;
         while ( nGXsfl_129_idx < bcLegajo.getgxTv_SdtLegajo_Salario().size() )
         {
            readRow0P129( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound129 == 0 )
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
               bcLegajo.getgxTv_SdtLegajo_Salario().removeElement(nGXsfl_129_idx);
               nGXsfl_129_idx = (int)(nGXsfl_129_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0P129( ) ;
               VarsToRow129( ((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0P129( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_129 = (short)(0) ;
      nIsMod_129 = (short)(0) ;
      Gxremove129 = (byte)(0) ;
   }

   public void processNestedLevel0P24( )
   {
      nGXsfl_24_idx = 0 ;
      while ( nGXsfl_24_idx < bcLegajo.getgxTv_SdtLegajo_Familia().size() )
      {
         readRow0P24( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound24 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_24 != 0 ) )
         {
            standaloneNotModal0P24( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0P24( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0P24( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0P24( ) ;
               }
            }
         }
         KeyVarsToRow24( ((web.SdtLegajo_Familia)bcLegajo.getgxTv_SdtLegajo_Familia().elementAt(-1+nGXsfl_24_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_24_idx = 0 ;
         while ( nGXsfl_24_idx < bcLegajo.getgxTv_SdtLegajo_Familia().size() )
         {
            readRow0P24( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound24 == 0 )
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
               bcLegajo.getgxTv_SdtLegajo_Familia().removeElement(nGXsfl_24_idx);
               nGXsfl_24_idx = (int)(nGXsfl_24_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0P24( ) ;
               VarsToRow24( ((web.SdtLegajo_Familia)bcLegajo.getgxTv_SdtLegajo_Familia().elementAt(-1+nGXsfl_24_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0P24( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_24 = (short)(0) ;
      nIsMod_24 = (short)(0) ;
      Gxremove24 = (byte)(0) ;
   }

   public void processNestedLevel0P170( )
   {
      nGXsfl_170_idx = 0 ;
      while ( nGXsfl_170_idx < bcLegajo.getgxTv_SdtLegajo_Tipos_de_trabajo().size() )
      {
         readRow0P170( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound170 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_170 != 0 ) )
         {
            standaloneNotModal0P170( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0P170( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0P170( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0P170( ) ;
               }
            }
         }
         KeyVarsToRow170( ((web.SdtLegajo_tipos_de_trabajo)bcLegajo.getgxTv_SdtLegajo_Tipos_de_trabajo().elementAt(-1+nGXsfl_170_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_170_idx = 0 ;
         while ( nGXsfl_170_idx < bcLegajo.getgxTv_SdtLegajo_Tipos_de_trabajo().size() )
         {
            readRow0P170( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound170 == 0 )
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
               bcLegajo.getgxTv_SdtLegajo_Tipos_de_trabajo().removeElement(nGXsfl_170_idx);
               nGXsfl_170_idx = (int)(nGXsfl_170_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0P170( ) ;
               VarsToRow170( ((web.SdtLegajo_tipos_de_trabajo)bcLegajo.getgxTv_SdtLegajo_Tipos_de_trabajo().elementAt(-1+nGXsfl_170_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0P170( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_170 = (short)(0) ;
      nIsMod_170 = (short)(0) ;
      Gxremove170 = (byte)(0) ;
   }

   public void processNestedLevel0P276( )
   {
      nGXsfl_276_idx = 0 ;
      while ( nGXsfl_276_idx < bcLegajo.getgxTv_SdtLegajo_Propiedades().size() )
      {
         readRow0P276( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound276 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_276 != 0 ) )
         {
            standaloneNotModal0P276( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0P276( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0P276( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0P276( ) ;
               }
            }
         }
         KeyVarsToRow276( ((web.SdtLegajo_Propiedades)bcLegajo.getgxTv_SdtLegajo_Propiedades().elementAt(-1+nGXsfl_276_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_276_idx = 0 ;
         while ( nGXsfl_276_idx < bcLegajo.getgxTv_SdtLegajo_Propiedades().size() )
         {
            readRow0P276( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound276 == 0 )
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
               bcLegajo.getgxTv_SdtLegajo_Propiedades().removeElement(nGXsfl_276_idx);
               nGXsfl_276_idx = (int)(nGXsfl_276_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0P276( ) ;
               VarsToRow276( ((web.SdtLegajo_Propiedades)bcLegajo.getgxTv_SdtLegajo_Propiedades().elementAt(-1+nGXsfl_276_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0P276( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_276 = (short)(0) ;
      nIsMod_276 = (short)(0) ;
      Gxremove276 = (byte)(0) ;
   }

   public void processLevel0P23( )
   {
      /* Save parent mode. */
      sMode23 = Gx_mode ;
      processNestedLevel0P129( ) ;
      processNestedLevel0P24( ) ;
      processNestedLevel0P170( ) ;
      processNestedLevel0P276( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode23 ;
      /* ' Update level parameters */
   }

   public void endLevel0P23( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(68);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0P23( ) ;
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

   public void scanKeyStart0P23( )
   {
      /* Scan By routine */
      /* Using cursor BC000P107 */
      pr_default.execute(105, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      RcdFound23 = (short)(0) ;
      if ( (pr_default.getStatus(105) != 101) )
      {
         RcdFound23 = (short)(1) ;
         A19SinieCodigo = BC000P107_A19SinieCodigo[0] ;
         n19SinieCodigo = BC000P107_n19SinieCodigo[0] ;
         A263LegSexo = BC000P107_A263LegSexo[0] ;
         n263LegSexo = BC000P107_n263LegSexo[0] ;
         A243LegEstadoCivil = BC000P107_A243LegEstadoCivil[0] ;
         n243LegEstadoCivil = BC000P107_n243LegEstadoCivil[0] ;
         A22LegPaiCod = BC000P107_A22LegPaiCod[0] ;
         n22LegPaiCod = BC000P107_n22LegPaiCod[0] ;
         A23LegProvCod = BC000P107_A23LegProvCod[0] ;
         n23LegProvCod = BC000P107_n23LegProvCod[0] ;
         A24LegLocCod = BC000P107_A24LegLocCod[0] ;
         n24LegLocCod = BC000P107_n24LegLocCod[0] ;
         A21LegNacionCod = BC000P107_A21LegNacionCod[0] ;
         n21LegNacionCod = BC000P107_n21LegNacionCod[0] ;
         A910LegSinCod = BC000P107_A910LegSinCod[0] ;
         n910LegSinCod = BC000P107_n910LegSinCod[0] ;
         A2182LegActClasNro = BC000P107_A2182LegActClasNro[0] ;
         n2182LegActClasNro = BC000P107_n2182LegActClasNro[0] ;
         A15LegActCodigo = BC000P107_A15LegActCodigo[0] ;
         n15LegActCodigo = BC000P107_n15LegActCodigo[0] ;
         A1603LegSitRevEgreso = BC000P107_A1603LegSitRevEgreso[0] ;
         n1603LegSitRevEgreso = BC000P107_n1603LegSitRevEgreso[0] ;
         A2181LegPueAfiCod = BC000P107_A2181LegPueAfiCod[0] ;
         n2181LegPueAfiCod = BC000P107_n2181LegPueAfiCod[0] ;
         A45TipEmpleCod = BC000P107_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC000P107_n45TipEmpleCod[0] ;
         A1235LegReligion = BC000P107_A1235LegReligion[0] ;
         n1235LegReligion = BC000P107_n1235LegReligion[0] ;
         A1236LegOrigen = BC000P107_A1236LegOrigen[0] ;
         n1236LegOrigen = BC000P107_n1236LegOrigen[0] ;
         A1965EmpOsoCod = BC000P107_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC000P107_n1965EmpOsoCod[0] ;
         A237LegConvenio = BC000P107_A237LegConvenio[0] ;
         A688SinieDescriSinAc = BC000P107_A688SinieDescriSinAc[0] ;
         A686CondiDescriSinAc = BC000P107_A686CondiDescriSinAc[0] ;
         A678ZonDescripSinAc = BC000P107_A678ZonDescripSinAc[0] ;
         A684MprDescripSinAc = BC000P107_A684MprDescripSinAc[0] ;
         A250LegIdNomApe = BC000P107_A250LegIdNomApe[0] ;
         A591LegNomApe = BC000P107_A591LegNomApe[0] ;
         A6LegNumero = BC000P107_A6LegNumero[0] ;
         A247LegFecUltMod = BC000P107_A247LegFecUltMod[0] ;
         A2EmpNom = BC000P107_A2EmpNom[0] ;
         A230LegApellido = BC000P107_A230LegApellido[0] ;
         A251LegNombre = BC000P107_A251LegNombre[0] ;
         A249LegFoto = BC000P107_A249LegFoto[0] ;
         n249LegFoto = BC000P107_n249LegFoto[0] ;
         A266LegTipDoc = BC000P107_A266LegTipDoc[0] ;
         A257LegNumDoc = BC000P107_A257LegNumDoc[0] ;
         A246LegFecNac = BC000P107_A246LegFecNac[0] ;
         A256LegNacionalidad = BC000P107_A256LegNacionalidad[0] ;
         A239LegCUIL = BC000P107_A239LegCUIL[0] ;
         A241LegDiscapacidad = BC000P107_A241LegDiscapacidad[0] ;
         A242LegDomici = BC000P107_A242LegDomici[0] ;
         A479LegEmail = BC000P107_A479LegEmail[0] ;
         A236LegCodPos = BC000P107_A236LegCodPos[0] ;
         A258LegPaiNom = BC000P107_A258LegPaiNom[0] ;
         A260LegProvNom = BC000P107_A260LegProvNom[0] ;
         A255LegLocNom = BC000P107_A255LegLocNom[0] ;
         A265LegTelefono = BC000P107_A265LegTelefono[0] ;
         n265LegTelefono = BC000P107_n265LegTelefono[0] ;
         A245LegFecIngreso = BC000P107_A245LegFecIngreso[0] ;
         A244LegFecEgreso = BC000P107_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC000P107_n244LegFecEgreso[0] ;
         A300MegDescrip = BC000P107_A300MegDescrip[0] ;
         n300MegDescrip = BC000P107_n300MegDescrip[0] ;
         A939LegCatCodigo = BC000P107_A939LegCatCodigo[0] ;
         n939LegCatCodigo = BC000P107_n939LegCatCodigo[0] ;
         A2215LegCatPueCod = BC000P107_A2215LegCatPueCod[0] ;
         n2215LegCatPueCod = BC000P107_n2215LegCatPueCod[0] ;
         A329SecDescrip = BC000P107_A329SecDescrip[0] ;
         n329SecDescrip = BC000P107_n329SecDescrip[0] ;
         A291LpgDescri = BC000P107_A291LpgDescri[0] ;
         n291LpgDescri = BC000P107_n291LpgDescri[0] ;
         A235LegClase = BC000P107_A235LegClase[0] ;
         A248LegFormaPago = BC000P107_A248LegFormaPago[0] ;
         A2224LegBanDes = BC000P107_A2224LegBanDes[0] ;
         A231LegBanSuc = BC000P107_A231LegBanSuc[0] ;
         n231LegBanSuc = BC000P107_n231LegBanSuc[0] ;
         A232LegBanTipCuen = BC000P107_A232LegBanTipCuen[0] ;
         n232LegBanTipCuen = BC000P107_n232LegBanTipCuen[0] ;
         A331SinDescrip = BC000P107_A331SinDescrip[0] ;
         n331SinDescrip = BC000P107_n331SinDescrip[0] ;
         A2225LegOsoDes = BC000P107_A2225LegOsoDes[0] ;
         A2226LegOsoAfipCod = BC000P107_A2226LegOsoAfipCod[0] ;
         n2226LegOsoAfipCod = BC000P107_n2226LegOsoAfipCod[0] ;
         A307OsoDescrip = BC000P107_A307OsoDescrip[0] ;
         n307OsoDescrip = BC000P107_n307OsoDescrip[0] ;
         A227LegActDescri = BC000P107_A227LegActDescri[0] ;
         A303MprDescrip = BC000P107_A303MprDescrip[0] ;
         A238LegCuentaBanc = BC000P107_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = BC000P107_n238LegCuentaBanc[0] ;
         A253LegLicInicio = BC000P107_A253LegLicInicio[0] ;
         n253LegLicInicio = BC000P107_n253LegLicInicio[0] ;
         A252LegLicFinal = BC000P107_A252LegLicFinal[0] ;
         n252LegLicFinal = BC000P107_n252LegLicFinal[0] ;
         A342ZonDescrip = BC000P107_A342ZonDescrip[0] ;
         A343ZonPorcReduc = BC000P107_A343ZonPorcReduc[0] ;
         A234LegCBU = BC000P107_A234LegCBU[0] ;
         n234LegCBU = BC000P107_n234LegCBU[0] ;
         A262LegSCVO = BC000P107_A262LegSCVO[0] ;
         A144CondiDescri = BC000P107_A144CondiDescri[0] ;
         A333SinieDescri = BC000P107_A333SinieDescri[0] ;
         A228LegActivo = BC000P107_A228LegActivo[0] ;
         A264LegSueldoFuera = BC000P107_A264LegSueldoFuera[0] ;
         A93LegId = BC000P107_A93LegId[0] ;
         n93LegId = BC000P107_n93LegId[0] ;
         A937LegConveCodigo = BC000P107_A937LegConveCodigo[0] ;
         n937LegConveCodigo = BC000P107_n937LegConveCodigo[0] ;
         A306OsoC3992 = BC000P107_A306OsoC3992[0] ;
         n306OsoC3992 = BC000P107_n306OsoC3992[0] ;
         A515LegObs = BC000P107_A515LegObs[0] ;
         A630LegFecImportacion = BC000P107_A630LegFecImportacion[0] ;
         A877LegAgenReten = BC000P107_A877LegAgenReten[0] ;
         A879LegContinua = BC000P107_A879LegContinua[0] ;
         A942LegRecalcLiq = BC000P107_A942LegRecalcLiq[0] ;
         A1016LegJubilado = BC000P107_A1016LegJubilado[0] ;
         A1023LegHorasDia = BC000P107_A1023LegHorasDia[0] ;
         A1268LegHorasSem = BC000P107_A1268LegHorasSem[0] ;
         A1245LegTrabLun = BC000P107_A1245LegTrabLun[0] ;
         A1246LegTrabMar = BC000P107_A1246LegTrabMar[0] ;
         A1247LegTrabMie = BC000P107_A1247LegTrabMie[0] ;
         A1248LegTrabJue = BC000P107_A1248LegTrabJue[0] ;
         A1249LegTrabVie = BC000P107_A1249LegTrabVie[0] ;
         A1250LegTrabSa = BC000P107_A1250LegTrabSa[0] ;
         A1251LegTrabDo = BC000P107_A1251LegTrabDo[0] ;
         A1523LegVacPend = BC000P107_A1523LegVacPend[0] ;
         A1531LegFecPreAviso = BC000P107_A1531LegFecPreAviso[0] ;
         A1576LegConveVersionCli = BC000P107_A1576LegConveVersionCli[0] ;
         n1576LegConveVersionCli = BC000P107_n1576LegConveVersionCli[0] ;
         A1759LegPromDias = BC000P107_A1759LegPromDias[0] ;
         A1804LegTitulo = BC000P107_A1804LegTitulo[0] ;
         A1818LegEstado = BC000P107_A1818LegEstado[0] ;
         A2263LegMigrWarn = BC000P107_A2263LegMigrWarn[0] ;
         n2263LegMigrWarn = BC000P107_n2263LegMigrWarn[0] ;
         A2267LegIncompleto = BC000P107_A2267LegIncompleto[0] ;
         A2309LegLiqApo = BC000P107_A2309LegLiqApo[0] ;
         A2404LegModTra = BC000P107_A2404LegModTra[0] ;
         A2417LegTipoTarifa = BC000P107_A2417LegTipoTarifa[0] ;
         A1031LegFotoExt = BC000P107_A1031LegFotoExt[0] ;
         A249LegFoto_Filetype = A1031LegFotoExt ;
         A1030LegFotoNom = BC000P107_A1030LegFotoNom[0] ;
         A249LegFoto_Filename = A1030LegFotoNom ;
         A392OsoSigla = BC000P107_A392OsoSigla[0] ;
         n392OsoSigla = BC000P107_n392OsoSigla[0] ;
         A3CliCod = BC000P107_A3CliCod[0] ;
         A1582LegBanCod = BC000P107_A1582LegBanCod[0] ;
         n1582LegBanCod = BC000P107_n1582LegBanCod[0] ;
         A1581LegLpgCodigo = BC000P107_A1581LegLpgCodigo[0] ;
         n1581LegLpgCodigo = BC000P107_n1581LegLpgCodigo[0] ;
         A1583LegMegCodigo = BC000P107_A1583LegMegCodigo[0] ;
         n1583LegMegCodigo = BC000P107_n1583LegMegCodigo[0] ;
         A1580LegOsoCod = BC000P107_A1580LegOsoCod[0] ;
         n1580LegOsoCod = BC000P107_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = BC000P107_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = BC000P107_n1579LegSecCodigo[0] ;
         A1EmpCod = BC000P107_A1EmpCod[0] ;
         A1577LegSucCodigo = BC000P107_A1577LegSucCodigo[0] ;
         n1577LegSucCodigo = BC000P107_n1577LegSucCodigo[0] ;
         A1578LegPuesCodigo = BC000P107_A1578LegPuesCodigo[0] ;
         n1578LegPuesCodigo = BC000P107_n1578LegPuesCodigo[0] ;
         A18MprCod = BC000P107_A18MprCod[0] ;
         n18MprCod = BC000P107_n18MprCod[0] ;
         A20ZonCod = BC000P107_A20ZonCod[0] ;
         n20ZonCod = BC000P107_n20ZonCod[0] ;
         A17CondiCodigo = BC000P107_A17CondiCodigo[0] ;
         n17CondiCodigo = BC000P107_n17CondiCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0P23( )
   {
      /* Scan next routine */
      pr_default.readNext(105);
      RcdFound23 = (short)(0) ;
      scanKeyLoad0P23( ) ;
   }

   public void scanKeyLoad0P23( )
   {
      sMode23 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(105) != 101) )
      {
         RcdFound23 = (short)(1) ;
         A19SinieCodigo = BC000P107_A19SinieCodigo[0] ;
         n19SinieCodigo = BC000P107_n19SinieCodigo[0] ;
         A263LegSexo = BC000P107_A263LegSexo[0] ;
         n263LegSexo = BC000P107_n263LegSexo[0] ;
         A243LegEstadoCivil = BC000P107_A243LegEstadoCivil[0] ;
         n243LegEstadoCivil = BC000P107_n243LegEstadoCivil[0] ;
         A22LegPaiCod = BC000P107_A22LegPaiCod[0] ;
         n22LegPaiCod = BC000P107_n22LegPaiCod[0] ;
         A23LegProvCod = BC000P107_A23LegProvCod[0] ;
         n23LegProvCod = BC000P107_n23LegProvCod[0] ;
         A24LegLocCod = BC000P107_A24LegLocCod[0] ;
         n24LegLocCod = BC000P107_n24LegLocCod[0] ;
         A21LegNacionCod = BC000P107_A21LegNacionCod[0] ;
         n21LegNacionCod = BC000P107_n21LegNacionCod[0] ;
         A910LegSinCod = BC000P107_A910LegSinCod[0] ;
         n910LegSinCod = BC000P107_n910LegSinCod[0] ;
         A2182LegActClasNro = BC000P107_A2182LegActClasNro[0] ;
         n2182LegActClasNro = BC000P107_n2182LegActClasNro[0] ;
         A15LegActCodigo = BC000P107_A15LegActCodigo[0] ;
         n15LegActCodigo = BC000P107_n15LegActCodigo[0] ;
         A1603LegSitRevEgreso = BC000P107_A1603LegSitRevEgreso[0] ;
         n1603LegSitRevEgreso = BC000P107_n1603LegSitRevEgreso[0] ;
         A2181LegPueAfiCod = BC000P107_A2181LegPueAfiCod[0] ;
         n2181LegPueAfiCod = BC000P107_n2181LegPueAfiCod[0] ;
         A45TipEmpleCod = BC000P107_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC000P107_n45TipEmpleCod[0] ;
         A1235LegReligion = BC000P107_A1235LegReligion[0] ;
         n1235LegReligion = BC000P107_n1235LegReligion[0] ;
         A1236LegOrigen = BC000P107_A1236LegOrigen[0] ;
         n1236LegOrigen = BC000P107_n1236LegOrigen[0] ;
         A1965EmpOsoCod = BC000P107_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC000P107_n1965EmpOsoCod[0] ;
         A237LegConvenio = BC000P107_A237LegConvenio[0] ;
         A688SinieDescriSinAc = BC000P107_A688SinieDescriSinAc[0] ;
         A686CondiDescriSinAc = BC000P107_A686CondiDescriSinAc[0] ;
         A678ZonDescripSinAc = BC000P107_A678ZonDescripSinAc[0] ;
         A684MprDescripSinAc = BC000P107_A684MprDescripSinAc[0] ;
         A250LegIdNomApe = BC000P107_A250LegIdNomApe[0] ;
         A591LegNomApe = BC000P107_A591LegNomApe[0] ;
         A6LegNumero = BC000P107_A6LegNumero[0] ;
         A247LegFecUltMod = BC000P107_A247LegFecUltMod[0] ;
         A2EmpNom = BC000P107_A2EmpNom[0] ;
         A230LegApellido = BC000P107_A230LegApellido[0] ;
         A251LegNombre = BC000P107_A251LegNombre[0] ;
         A249LegFoto = BC000P107_A249LegFoto[0] ;
         n249LegFoto = BC000P107_n249LegFoto[0] ;
         A266LegTipDoc = BC000P107_A266LegTipDoc[0] ;
         A257LegNumDoc = BC000P107_A257LegNumDoc[0] ;
         A246LegFecNac = BC000P107_A246LegFecNac[0] ;
         A256LegNacionalidad = BC000P107_A256LegNacionalidad[0] ;
         A239LegCUIL = BC000P107_A239LegCUIL[0] ;
         A241LegDiscapacidad = BC000P107_A241LegDiscapacidad[0] ;
         A242LegDomici = BC000P107_A242LegDomici[0] ;
         A479LegEmail = BC000P107_A479LegEmail[0] ;
         A236LegCodPos = BC000P107_A236LegCodPos[0] ;
         A258LegPaiNom = BC000P107_A258LegPaiNom[0] ;
         A260LegProvNom = BC000P107_A260LegProvNom[0] ;
         A255LegLocNom = BC000P107_A255LegLocNom[0] ;
         A265LegTelefono = BC000P107_A265LegTelefono[0] ;
         n265LegTelefono = BC000P107_n265LegTelefono[0] ;
         A245LegFecIngreso = BC000P107_A245LegFecIngreso[0] ;
         A244LegFecEgreso = BC000P107_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC000P107_n244LegFecEgreso[0] ;
         A300MegDescrip = BC000P107_A300MegDescrip[0] ;
         n300MegDescrip = BC000P107_n300MegDescrip[0] ;
         A939LegCatCodigo = BC000P107_A939LegCatCodigo[0] ;
         n939LegCatCodigo = BC000P107_n939LegCatCodigo[0] ;
         A2215LegCatPueCod = BC000P107_A2215LegCatPueCod[0] ;
         n2215LegCatPueCod = BC000P107_n2215LegCatPueCod[0] ;
         A329SecDescrip = BC000P107_A329SecDescrip[0] ;
         n329SecDescrip = BC000P107_n329SecDescrip[0] ;
         A291LpgDescri = BC000P107_A291LpgDescri[0] ;
         n291LpgDescri = BC000P107_n291LpgDescri[0] ;
         A235LegClase = BC000P107_A235LegClase[0] ;
         A248LegFormaPago = BC000P107_A248LegFormaPago[0] ;
         A2224LegBanDes = BC000P107_A2224LegBanDes[0] ;
         A231LegBanSuc = BC000P107_A231LegBanSuc[0] ;
         n231LegBanSuc = BC000P107_n231LegBanSuc[0] ;
         A232LegBanTipCuen = BC000P107_A232LegBanTipCuen[0] ;
         n232LegBanTipCuen = BC000P107_n232LegBanTipCuen[0] ;
         A331SinDescrip = BC000P107_A331SinDescrip[0] ;
         n331SinDescrip = BC000P107_n331SinDescrip[0] ;
         A2225LegOsoDes = BC000P107_A2225LegOsoDes[0] ;
         A2226LegOsoAfipCod = BC000P107_A2226LegOsoAfipCod[0] ;
         n2226LegOsoAfipCod = BC000P107_n2226LegOsoAfipCod[0] ;
         A307OsoDescrip = BC000P107_A307OsoDescrip[0] ;
         n307OsoDescrip = BC000P107_n307OsoDescrip[0] ;
         A227LegActDescri = BC000P107_A227LegActDescri[0] ;
         A303MprDescrip = BC000P107_A303MprDescrip[0] ;
         A238LegCuentaBanc = BC000P107_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = BC000P107_n238LegCuentaBanc[0] ;
         A253LegLicInicio = BC000P107_A253LegLicInicio[0] ;
         n253LegLicInicio = BC000P107_n253LegLicInicio[0] ;
         A252LegLicFinal = BC000P107_A252LegLicFinal[0] ;
         n252LegLicFinal = BC000P107_n252LegLicFinal[0] ;
         A342ZonDescrip = BC000P107_A342ZonDescrip[0] ;
         A343ZonPorcReduc = BC000P107_A343ZonPorcReduc[0] ;
         A234LegCBU = BC000P107_A234LegCBU[0] ;
         n234LegCBU = BC000P107_n234LegCBU[0] ;
         A262LegSCVO = BC000P107_A262LegSCVO[0] ;
         A144CondiDescri = BC000P107_A144CondiDescri[0] ;
         A333SinieDescri = BC000P107_A333SinieDescri[0] ;
         A228LegActivo = BC000P107_A228LegActivo[0] ;
         A264LegSueldoFuera = BC000P107_A264LegSueldoFuera[0] ;
         A93LegId = BC000P107_A93LegId[0] ;
         n93LegId = BC000P107_n93LegId[0] ;
         A937LegConveCodigo = BC000P107_A937LegConveCodigo[0] ;
         n937LegConveCodigo = BC000P107_n937LegConveCodigo[0] ;
         A306OsoC3992 = BC000P107_A306OsoC3992[0] ;
         n306OsoC3992 = BC000P107_n306OsoC3992[0] ;
         A515LegObs = BC000P107_A515LegObs[0] ;
         A630LegFecImportacion = BC000P107_A630LegFecImportacion[0] ;
         A877LegAgenReten = BC000P107_A877LegAgenReten[0] ;
         A879LegContinua = BC000P107_A879LegContinua[0] ;
         A942LegRecalcLiq = BC000P107_A942LegRecalcLiq[0] ;
         A1016LegJubilado = BC000P107_A1016LegJubilado[0] ;
         A1023LegHorasDia = BC000P107_A1023LegHorasDia[0] ;
         A1268LegHorasSem = BC000P107_A1268LegHorasSem[0] ;
         A1245LegTrabLun = BC000P107_A1245LegTrabLun[0] ;
         A1246LegTrabMar = BC000P107_A1246LegTrabMar[0] ;
         A1247LegTrabMie = BC000P107_A1247LegTrabMie[0] ;
         A1248LegTrabJue = BC000P107_A1248LegTrabJue[0] ;
         A1249LegTrabVie = BC000P107_A1249LegTrabVie[0] ;
         A1250LegTrabSa = BC000P107_A1250LegTrabSa[0] ;
         A1251LegTrabDo = BC000P107_A1251LegTrabDo[0] ;
         A1523LegVacPend = BC000P107_A1523LegVacPend[0] ;
         A1531LegFecPreAviso = BC000P107_A1531LegFecPreAviso[0] ;
         A1576LegConveVersionCli = BC000P107_A1576LegConveVersionCli[0] ;
         n1576LegConveVersionCli = BC000P107_n1576LegConveVersionCli[0] ;
         A1759LegPromDias = BC000P107_A1759LegPromDias[0] ;
         A1804LegTitulo = BC000P107_A1804LegTitulo[0] ;
         A1818LegEstado = BC000P107_A1818LegEstado[0] ;
         A2263LegMigrWarn = BC000P107_A2263LegMigrWarn[0] ;
         n2263LegMigrWarn = BC000P107_n2263LegMigrWarn[0] ;
         A2267LegIncompleto = BC000P107_A2267LegIncompleto[0] ;
         A2309LegLiqApo = BC000P107_A2309LegLiqApo[0] ;
         A2404LegModTra = BC000P107_A2404LegModTra[0] ;
         A2417LegTipoTarifa = BC000P107_A2417LegTipoTarifa[0] ;
         A1031LegFotoExt = BC000P107_A1031LegFotoExt[0] ;
         A249LegFoto_Filetype = A1031LegFotoExt ;
         A1030LegFotoNom = BC000P107_A1030LegFotoNom[0] ;
         A249LegFoto_Filename = A1030LegFotoNom ;
         A392OsoSigla = BC000P107_A392OsoSigla[0] ;
         n392OsoSigla = BC000P107_n392OsoSigla[0] ;
         A3CliCod = BC000P107_A3CliCod[0] ;
         A1582LegBanCod = BC000P107_A1582LegBanCod[0] ;
         n1582LegBanCod = BC000P107_n1582LegBanCod[0] ;
         A1581LegLpgCodigo = BC000P107_A1581LegLpgCodigo[0] ;
         n1581LegLpgCodigo = BC000P107_n1581LegLpgCodigo[0] ;
         A1583LegMegCodigo = BC000P107_A1583LegMegCodigo[0] ;
         n1583LegMegCodigo = BC000P107_n1583LegMegCodigo[0] ;
         A1580LegOsoCod = BC000P107_A1580LegOsoCod[0] ;
         n1580LegOsoCod = BC000P107_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = BC000P107_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = BC000P107_n1579LegSecCodigo[0] ;
         A1EmpCod = BC000P107_A1EmpCod[0] ;
         A1577LegSucCodigo = BC000P107_A1577LegSucCodigo[0] ;
         n1577LegSucCodigo = BC000P107_n1577LegSucCodigo[0] ;
         A1578LegPuesCodigo = BC000P107_A1578LegPuesCodigo[0] ;
         n1578LegPuesCodigo = BC000P107_n1578LegPuesCodigo[0] ;
         A18MprCod = BC000P107_A18MprCod[0] ;
         n18MprCod = BC000P107_n18MprCod[0] ;
         A20ZonCod = BC000P107_A20ZonCod[0] ;
         n20ZonCod = BC000P107_n20ZonCod[0] ;
         A17CondiCodigo = BC000P107_A17CondiCodigo[0] ;
         n17CondiCodigo = BC000P107_n17CondiCodigo[0] ;
      }
      Gx_mode = sMode23 ;
   }

   public void scanKeyEnd0P23( )
   {
      pr_default.close(105);
   }

   public void afterConfirm0P23( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0P23( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0P23( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0P23( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0P23( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0P23( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0P23( )
   {
   }

   public void zm0P129( int GX_JID )
   {
      if ( ( GX_JID == 57 ) || ( GX_JID == 0 ) )
      {
         Z1136LegSuelFecha = A1136LegSuelFecha ;
         Z1137LegSuelImporte = A1137LegSuelImporte ;
         Z2344LegSuelTipo = A2344LegSuelTipo ;
         Z2347LegSuelCalc = A2347LegSuelCalc ;
      }
      if ( GX_JID == -57 )
      {
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1135LegSuelSec = A1135LegSuelSec ;
         Z1136LegSuelFecha = A1136LegSuelFecha ;
         Z1137LegSuelImporte = A1137LegSuelImporte ;
         Z2344LegSuelTipo = A2344LegSuelTipo ;
         Z2347LegSuelCalc = A2347LegSuelCalc ;
         Z2348LegSuelLog = A2348LegSuelLog ;
      }
   }

   public void standaloneNotModal0P129( )
   {
   }

   public void standaloneModal0P129( )
   {
   }

   public void load0P129( )
   {
      /* Using cursor BC000P108 */
      pr_default.execute(106, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
      if ( (pr_default.getStatus(106) != 101) )
      {
         RcdFound129 = (short)(1) ;
         A1136LegSuelFecha = BC000P108_A1136LegSuelFecha[0] ;
         A1137LegSuelImporte = BC000P108_A1137LegSuelImporte[0] ;
         A2344LegSuelTipo = BC000P108_A2344LegSuelTipo[0] ;
         n2344LegSuelTipo = BC000P108_n2344LegSuelTipo[0] ;
         A2347LegSuelCalc = BC000P108_A2347LegSuelCalc[0] ;
         A2348LegSuelLog = BC000P108_A2348LegSuelLog[0] ;
         zm0P129( -57) ;
      }
      pr_default.close(106);
      onLoadActions0P129( ) ;
   }

   public void onLoadActions0P129( )
   {
   }

   public void checkExtendedTable0P129( )
   {
      nIsDirty_129 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0P129( ) ;
      Gx_BScreen = (byte)(0) ;
      if ( ! ( ( GXutil.strcmp(A2344LegSuelTipo, "Bruto") == 0 ) || ( GXutil.strcmp(A2344LegSuelTipo, "Neto") == 0 ) || ( GXutil.strcmp(A2344LegSuelTipo, "GrossingUp") == 0 ) || (GXutil.strcmp("", A2344LegSuelTipo)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0P129( )
   {
   }

   public void enableDisable0P129( )
   {
   }

   public void getKey0P129( )
   {
      /* Using cursor BC000P109 */
      pr_default.execute(107, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
      if ( (pr_default.getStatus(107) != 101) )
      {
         RcdFound129 = (short)(1) ;
      }
      else
      {
         RcdFound129 = (short)(0) ;
      }
      pr_default.close(107);
   }

   public void getByPrimaryKey0P129( )
   {
      /* Using cursor BC000P110 */
      pr_default.execute(108, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
      if ( (pr_default.getStatus(108) != 101) )
      {
         zm0P129( 57) ;
         RcdFound129 = (short)(1) ;
         initializeNonKey0P129( ) ;
         A1135LegSuelSec = BC000P110_A1135LegSuelSec[0] ;
         A1136LegSuelFecha = BC000P110_A1136LegSuelFecha[0] ;
         A1137LegSuelImporte = BC000P110_A1137LegSuelImporte[0] ;
         A2344LegSuelTipo = BC000P110_A2344LegSuelTipo[0] ;
         n2344LegSuelTipo = BC000P110_n2344LegSuelTipo[0] ;
         A2347LegSuelCalc = BC000P110_A2347LegSuelCalc[0] ;
         A2348LegSuelLog = BC000P110_A2348LegSuelLog[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1135LegSuelSec = A1135LegSuelSec ;
         sMode129 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0P129( ) ;
         load0P129( ) ;
         Gx_mode = sMode129 ;
      }
      else
      {
         RcdFound129 = (short)(0) ;
         initializeNonKey0P129( ) ;
         sMode129 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0P129( ) ;
         Gx_mode = sMode129 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0P129( ) ;
      }
      pr_default.close(108);
   }

   public void checkOptimisticConcurrency0P129( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000P111 */
         pr_default.execute(109, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
         if ( (pr_default.getStatus(109) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_sueldos"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(109) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z1136LegSuelFecha), GXutil.resetTime(BC000P111_A1136LegSuelFecha[0])) ) || ( DecimalUtil.compareTo(Z1137LegSuelImporte, BC000P111_A1137LegSuelImporte[0]) != 0 ) || ( GXutil.strcmp(Z2344LegSuelTipo, BC000P111_A2344LegSuelTipo[0]) != 0 ) || ( DecimalUtil.compareTo(Z2347LegSuelCalc, BC000P111_A2347LegSuelCalc[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"legajo_sueldos"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0P129( )
   {
      beforeValidate0P129( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P129( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0P129( 0) ;
         checkOptimisticConcurrency0P129( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P129( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0P129( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000P112 */
                  pr_default.execute(110, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec), A1136LegSuelFecha, A1137LegSuelImporte, Boolean.valueOf(n2344LegSuelTipo), A2344LegSuelTipo, A2347LegSuelCalc, A2348LegSuelLog});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_sueldos");
                  if ( (pr_default.getStatus(110) == 1) )
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
                        processLevel0P129( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
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
            load0P129( ) ;
         }
         endLevel0P129( ) ;
      }
      closeExtendedTableCursors0P129( ) ;
   }

   public void update0P129( )
   {
      beforeValidate0P129( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P129( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P129( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P129( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0P129( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000P113 */
                  pr_default.execute(111, new Object[] {A1136LegSuelFecha, A1137LegSuelImporte, Boolean.valueOf(n2344LegSuelTipo), A2344LegSuelTipo, A2347LegSuelCalc, A2348LegSuelLog, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_sueldos");
                  if ( (pr_default.getStatus(111) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_sueldos"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0P129( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0P129( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0P129( ) ;
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
         endLevel0P129( ) ;
      }
      closeExtendedTableCursors0P129( ) ;
   }

   public void deferredUpdate0P129( )
   {
   }

   public void delete0P129( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0P129( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P129( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0P129( ) ;
         afterConfirm0P129( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0P129( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart0P292( ) ;
               while ( RcdFound292 != 0 )
               {
                  getByPrimaryKey0P292( ) ;
                  delete0P292( ) ;
                  scanKeyNext0P292( ) ;
               }
               scanKeyEnd0P292( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000P114 */
                  pr_default.execute(112, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_sueldos");
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
      }
      sMode129 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0P129( ) ;
      Gx_mode = sMode129 ;
   }

   public void onDeleteControls0P129( )
   {
      standaloneModal0P129( ) ;
      /* No delete mode formulas found. */
   }

   public void processNestedLevel0P292( )
   {
      nGXsfl_292_idx = 0 ;
      while ( nGXsfl_292_idx < ((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx)).getgxTv_SdtLegajo_Salario_Conceptos().size() )
      {
         readRow0P292( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound292 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_292 != 0 ) )
         {
            standaloneNotModal0P292( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0P292( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0P292( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0P292( ) ;
               }
            }
         }
         KeyVarsToRow292( ((web.SdtLegajo_Salario_Conceptos)((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx)).getgxTv_SdtLegajo_Salario_Conceptos().elementAt(-1+nGXsfl_292_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_292_idx = 0 ;
         while ( nGXsfl_292_idx < ((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx)).getgxTv_SdtLegajo_Salario_Conceptos().size() )
         {
            readRow0P292( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound292 == 0 )
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
               ((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx)).getgxTv_SdtLegajo_Salario_Conceptos().removeElement(nGXsfl_292_idx);
               nGXsfl_292_idx = (int)(nGXsfl_292_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0P292( ) ;
               VarsToRow292( ((web.SdtLegajo_Salario_Conceptos)((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx)).getgxTv_SdtLegajo_Salario_Conceptos().elementAt(-1+nGXsfl_292_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0P292( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_292 = (short)(0) ;
      nIsMod_292 = (short)(0) ;
      Gxremove292 = (byte)(0) ;
   }

   public void processLevel0P129( )
   {
      /* Save parent mode. */
      sMode129 = Gx_mode ;
      processNestedLevel0P292( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode129 ;
      /* ' Update level parameters */
   }

   public void endLevel0P129( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(109);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0P129( )
   {
      /* Scan By routine */
      /* Using cursor BC000P115 */
      pr_default.execute(113, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      RcdFound129 = (short)(0) ;
      if ( (pr_default.getStatus(113) != 101) )
      {
         RcdFound129 = (short)(1) ;
         A1135LegSuelSec = BC000P115_A1135LegSuelSec[0] ;
         A1136LegSuelFecha = BC000P115_A1136LegSuelFecha[0] ;
         A1137LegSuelImporte = BC000P115_A1137LegSuelImporte[0] ;
         A2344LegSuelTipo = BC000P115_A2344LegSuelTipo[0] ;
         n2344LegSuelTipo = BC000P115_n2344LegSuelTipo[0] ;
         A2347LegSuelCalc = BC000P115_A2347LegSuelCalc[0] ;
         A2348LegSuelLog = BC000P115_A2348LegSuelLog[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0P129( )
   {
      /* Scan next routine */
      pr_default.readNext(113);
      RcdFound129 = (short)(0) ;
      scanKeyLoad0P129( ) ;
   }

   public void scanKeyLoad0P129( )
   {
      sMode129 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(113) != 101) )
      {
         RcdFound129 = (short)(1) ;
         A1135LegSuelSec = BC000P115_A1135LegSuelSec[0] ;
         A1136LegSuelFecha = BC000P115_A1136LegSuelFecha[0] ;
         A1137LegSuelImporte = BC000P115_A1137LegSuelImporte[0] ;
         A2344LegSuelTipo = BC000P115_A2344LegSuelTipo[0] ;
         n2344LegSuelTipo = BC000P115_n2344LegSuelTipo[0] ;
         A2347LegSuelCalc = BC000P115_A2347LegSuelCalc[0] ;
         A2348LegSuelLog = BC000P115_A2348LegSuelLog[0] ;
      }
      Gx_mode = sMode129 ;
   }

   public void scanKeyEnd0P129( )
   {
      pr_default.close(113);
   }

   public void afterConfirm0P129( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0P129( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0P129( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0P129( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0P129( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0P129( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0P129( )
   {
   }

   public void zm0P292( int GX_JID )
   {
      if ( ( GX_JID == 58 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 59 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -58 )
      {
         Z3CliCod = A3CliCod ;
         Z2349LegSuelConcepto = A2349LegSuelConcepto ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1135LegSuelSec = A1135LegSuelSec ;
      }
   }

   public void standaloneNotModal0P292( )
   {
   }

   public void standaloneModal0P292( )
   {
   }

   public void load0P292( )
   {
      /* Using cursor BC000P116 */
      pr_default.execute(114, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec), A2349LegSuelConcepto});
      if ( (pr_default.getStatus(114) != 101) )
      {
         RcdFound292 = (short)(1) ;
         zm0P292( -58) ;
      }
      pr_default.close(114);
      onLoadActions0P292( ) ;
   }

   public void onLoadActions0P292( )
   {
   }

   public void checkExtendedTable0P292( )
   {
      nIsDirty_292 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0P292( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000P117 */
      pr_default.execute(115, new Object[] {Integer.valueOf(A3CliCod), A2349LegSuelConcepto});
      if ( (pr_default.getStatus(115) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Sueldo Legajo Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGSUELCONCEPTO");
         AnyError = (short)(1) ;
      }
      pr_default.close(115);
   }

   public void closeExtendedTableCursors0P292( )
   {
      pr_default.close(115);
   }

   public void enableDisable0P292( )
   {
   }

   public void getKey0P292( )
   {
      /* Using cursor BC000P118 */
      pr_default.execute(116, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec), A2349LegSuelConcepto});
      if ( (pr_default.getStatus(116) != 101) )
      {
         RcdFound292 = (short)(1) ;
      }
      else
      {
         RcdFound292 = (short)(0) ;
      }
      pr_default.close(116);
   }

   public void getByPrimaryKey0P292( )
   {
      /* Using cursor BC000P119 */
      pr_default.execute(117, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec), A2349LegSuelConcepto});
      if ( (pr_default.getStatus(117) != 101) )
      {
         zm0P292( 58) ;
         RcdFound292 = (short)(1) ;
         initializeNonKey0P292( ) ;
         A2349LegSuelConcepto = BC000P119_A2349LegSuelConcepto[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1135LegSuelSec = A1135LegSuelSec ;
         Z2349LegSuelConcepto = A2349LegSuelConcepto ;
         sMode292 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0P292( ) ;
         load0P292( ) ;
         Gx_mode = sMode292 ;
      }
      else
      {
         RcdFound292 = (short)(0) ;
         initializeNonKey0P292( ) ;
         sMode292 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0P292( ) ;
         Gx_mode = sMode292 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0P292( ) ;
      }
      pr_default.close(117);
   }

   public void checkOptimisticConcurrency0P292( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000P120 */
         pr_default.execute(118, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec), A2349LegSuelConcepto});
         if ( (pr_default.getStatus(118) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Legajo_sueldosConceptos"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(118) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Legajo_sueldosConceptos"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0P292( )
   {
      beforeValidate0P292( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P292( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0P292( 0) ;
         checkOptimisticConcurrency0P292( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P292( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0P292( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000P121 */
                  pr_default.execute(119, new Object[] {Integer.valueOf(A3CliCod), A2349LegSuelConcepto, Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo_sueldosConceptos");
                  if ( (pr_default.getStatus(119) == 1) )
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
            load0P292( ) ;
         }
         endLevel0P292( ) ;
      }
      closeExtendedTableCursors0P292( ) ;
   }

   public void update0P292( )
   {
      beforeValidate0P292( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P292( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P292( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P292( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0P292( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table Legajo_sueldosConceptos */
                  deferredUpdate0P292( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0P292( ) ;
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
         endLevel0P292( ) ;
      }
      closeExtendedTableCursors0P292( ) ;
   }

   public void deferredUpdate0P292( )
   {
   }

   public void delete0P292( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0P292( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P292( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0P292( ) ;
         afterConfirm0P292( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0P292( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000P122 */
               pr_default.execute(120, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec), A2349LegSuelConcepto});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo_sueldosConceptos");
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
      sMode292 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0P292( ) ;
      Gx_mode = sMode292 ;
   }

   public void onDeleteControls0P292( )
   {
      standaloneModal0P292( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0P292( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(118);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0P292( )
   {
      /* Scan By routine */
      /* Using cursor BC000P123 */
      pr_default.execute(121, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
      RcdFound292 = (short)(0) ;
      if ( (pr_default.getStatus(121) != 101) )
      {
         RcdFound292 = (short)(1) ;
         A2349LegSuelConcepto = BC000P123_A2349LegSuelConcepto[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0P292( )
   {
      /* Scan next routine */
      pr_default.readNext(121);
      RcdFound292 = (short)(0) ;
      scanKeyLoad0P292( ) ;
   }

   public void scanKeyLoad0P292( )
   {
      sMode292 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(121) != 101) )
      {
         RcdFound292 = (short)(1) ;
         A2349LegSuelConcepto = BC000P123_A2349LegSuelConcepto[0] ;
      }
      Gx_mode = sMode292 ;
   }

   public void scanKeyEnd0P292( )
   {
      pr_default.close(121);
   }

   public void afterConfirm0P292( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0P292( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0P292( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0P292( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0P292( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0P292( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0P292( )
   {
   }

   public void send_integrity_lvl_hashes0P292( )
   {
   }

   public void send_integrity_lvl_hashes0P129( )
   {
   }

   public void zm0P24( int GX_JID )
   {
      if ( ( GX_JID == 60 ) || ( GX_JID == 0 ) )
      {
         Z220FamTomaDeducImpGan = A220FamTomaDeducImpGan ;
         Z2090FamNomApe = A2090FamNomApe ;
         Z209FamFecNac = A209FamFecNac ;
         Z205FamDiscap = A205FamDiscap ;
         Z750FamNroDoc = A750FamNroDoc ;
         Z890FamAdherente = A890FamAdherente ;
         Z30ParCod = A30ParCod ;
         Z1547GuarCod = A1547GuarCod ;
      }
      if ( ( GX_JID == 61 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 62 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -60 )
      {
         Z6LegNumero = A6LegNumero ;
         Z29LegOrden = A29LegOrden ;
         Z220FamTomaDeducImpGan = A220FamTomaDeducImpGan ;
         Z2090FamNomApe = A2090FamNomApe ;
         Z209FamFecNac = A209FamFecNac ;
         Z205FamDiscap = A205FamDiscap ;
         Z750FamNroDoc = A750FamNroDoc ;
         Z890FamAdherente = A890FamAdherente ;
         Z3CliCod = A3CliCod ;
         Z30ParCod = A30ParCod ;
         Z1EmpCod = A1EmpCod ;
         Z1547GuarCod = A1547GuarCod ;
      }
   }

   public void standaloneNotModal0P24( )
   {
   }

   public void standaloneModal0P24( )
   {
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A220FamTomaDeducImpGan)==0) && ( Gx_BScreen == 0 ) )
      {
         A220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0P24( )
   {
      /* Using cursor BC000P124 */
      pr_default.execute(122, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
      if ( (pr_default.getStatus(122) != 101) )
      {
         RcdFound24 = (short)(1) ;
         A220FamTomaDeducImpGan = BC000P124_A220FamTomaDeducImpGan[0] ;
         A2090FamNomApe = BC000P124_A2090FamNomApe[0] ;
         A209FamFecNac = BC000P124_A209FamFecNac[0] ;
         n209FamFecNac = BC000P124_n209FamFecNac[0] ;
         A205FamDiscap = BC000P124_A205FamDiscap[0] ;
         n205FamDiscap = BC000P124_n205FamDiscap[0] ;
         A750FamNroDoc = BC000P124_A750FamNroDoc[0] ;
         A890FamAdherente = BC000P124_A890FamAdherente[0] ;
         A30ParCod = BC000P124_A30ParCod[0] ;
         A1547GuarCod = BC000P124_A1547GuarCod[0] ;
         n1547GuarCod = BC000P124_n1547GuarCod[0] ;
         zm0P24( -60) ;
      }
      pr_default.close(122);
      onLoadActions0P24( ) ;
   }

   public void onLoadActions0P24( )
   {
   }

   public void checkExtendedTable0P24( )
   {
      nIsDirty_24 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0P24( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000P125 */
      pr_default.execute(123, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
      if ( (pr_default.getStatus(123) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Parentesco", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PARCOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(123);
      /* Using cursor BC000P126 */
      pr_default.execute(124, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1547GuarCod), Short.valueOf(A1547GuarCod)});
      if ( (pr_default.getStatus(124) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A1547GuarCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Guarderias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "GUARCOD");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(124);
      if ( ! ( ( A220FamTomaDeducImpGan.doubleValue() == 1 ) || ( DecimalUtil.compareTo(A220FamTomaDeducImpGan, DecimalUtil.stringToDec("0.5")) == 0 ) || ( A220FamTomaDeducImpGan.doubleValue() == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Deduce ganancias", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0P24( )
   {
      pr_default.close(123);
      pr_default.close(124);
   }

   public void enableDisable0P24( )
   {
   }

   public void getKey0P24( )
   {
      /* Using cursor BC000P127 */
      pr_default.execute(125, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
      if ( (pr_default.getStatus(125) != 101) )
      {
         RcdFound24 = (short)(1) ;
      }
      else
      {
         RcdFound24 = (short)(0) ;
      }
      pr_default.close(125);
   }

   public void getByPrimaryKey0P24( )
   {
      /* Using cursor BC000P128 */
      pr_default.execute(126, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
      if ( (pr_default.getStatus(126) != 101) )
      {
         zm0P24( 60) ;
         RcdFound24 = (short)(1) ;
         initializeNonKey0P24( ) ;
         A29LegOrden = BC000P128_A29LegOrden[0] ;
         A220FamTomaDeducImpGan = BC000P128_A220FamTomaDeducImpGan[0] ;
         A2090FamNomApe = BC000P128_A2090FamNomApe[0] ;
         A209FamFecNac = BC000P128_A209FamFecNac[0] ;
         n209FamFecNac = BC000P128_n209FamFecNac[0] ;
         A205FamDiscap = BC000P128_A205FamDiscap[0] ;
         n205FamDiscap = BC000P128_n205FamDiscap[0] ;
         A750FamNroDoc = BC000P128_A750FamNroDoc[0] ;
         A890FamAdherente = BC000P128_A890FamAdherente[0] ;
         A30ParCod = BC000P128_A30ParCod[0] ;
         A1547GuarCod = BC000P128_A1547GuarCod[0] ;
         n1547GuarCod = BC000P128_n1547GuarCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z29LegOrden = A29LegOrden ;
         sMode24 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0P24( ) ;
         load0P24( ) ;
         Gx_mode = sMode24 ;
      }
      else
      {
         RcdFound24 = (short)(0) ;
         initializeNonKey0P24( ) ;
         sMode24 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0P24( ) ;
         Gx_mode = sMode24 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0P24( ) ;
      }
      pr_default.close(126);
   }

   public void checkOptimisticConcurrency0P24( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000P129 */
         pr_default.execute(127, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
         if ( (pr_default.getStatus(127) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoFamilia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(127) == 101) || ( DecimalUtil.compareTo(Z220FamTomaDeducImpGan, BC000P129_A220FamTomaDeducImpGan[0]) != 0 ) || ( GXutil.strcmp(Z2090FamNomApe, BC000P129_A2090FamNomApe[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z209FamFecNac), GXutil.resetTime(BC000P129_A209FamFecNac[0])) ) || ( Z205FamDiscap != BC000P129_A205FamDiscap[0] ) || ( GXutil.strcmp(Z750FamNroDoc, BC000P129_A750FamNroDoc[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z890FamAdherente != BC000P129_A890FamAdherente[0] ) || ( GXutil.strcmp(Z30ParCod, BC000P129_A30ParCod[0]) != 0 ) || ( Z1547GuarCod != BC000P129_A1547GuarCod[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LegajoFamilia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0P24( )
   {
      beforeValidate0P24( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P24( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0P24( 0) ;
         checkOptimisticConcurrency0P24( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P24( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0P24( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000P130 */
                  pr_default.execute(128, new Object[] {Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden), A220FamTomaDeducImpGan, A2090FamNomApe, Boolean.valueOf(n209FamFecNac), A209FamFecNac, Boolean.valueOf(n205FamDiscap), Boolean.valueOf(A205FamDiscap), A750FamNroDoc, Boolean.valueOf(A890FamAdherente), Integer.valueOf(A3CliCod), A30ParCod, Short.valueOf(A1EmpCod), Boolean.valueOf(n1547GuarCod), Short.valueOf(A1547GuarCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoFamilia");
                  if ( (pr_default.getStatus(128) == 1) )
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
            load0P24( ) ;
         }
         endLevel0P24( ) ;
      }
      closeExtendedTableCursors0P24( ) ;
   }

   public void update0P24( )
   {
      beforeValidate0P24( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P24( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P24( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P24( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0P24( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000P131 */
                  pr_default.execute(129, new Object[] {A220FamTomaDeducImpGan, A2090FamNomApe, Boolean.valueOf(n209FamFecNac), A209FamFecNac, Boolean.valueOf(n205FamDiscap), Boolean.valueOf(A205FamDiscap), A750FamNroDoc, Boolean.valueOf(A890FamAdherente), A30ParCod, Boolean.valueOf(n1547GuarCod), Short.valueOf(A1547GuarCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoFamilia");
                  if ( (pr_default.getStatus(129) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoFamilia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0P24( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0P24( ) ;
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
         endLevel0P24( ) ;
      }
      closeExtendedTableCursors0P24( ) ;
   }

   public void deferredUpdate0P24( )
   {
   }

   public void delete0P24( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0P24( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P24( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0P24( ) ;
         afterConfirm0P24( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0P24( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000P132 */
               pr_default.execute(130, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoFamilia");
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
      sMode24 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0P24( ) ;
      Gx_mode = sMode24 ;
   }

   public void onDeleteControls0P24( )
   {
      standaloneModal0P24( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0P24( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(127);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0P24( )
   {
      /* Scan By routine */
      /* Using cursor BC000P133 */
      pr_default.execute(131, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      RcdFound24 = (short)(0) ;
      if ( (pr_default.getStatus(131) != 101) )
      {
         RcdFound24 = (short)(1) ;
         A29LegOrden = BC000P133_A29LegOrden[0] ;
         A220FamTomaDeducImpGan = BC000P133_A220FamTomaDeducImpGan[0] ;
         A2090FamNomApe = BC000P133_A2090FamNomApe[0] ;
         A209FamFecNac = BC000P133_A209FamFecNac[0] ;
         n209FamFecNac = BC000P133_n209FamFecNac[0] ;
         A205FamDiscap = BC000P133_A205FamDiscap[0] ;
         n205FamDiscap = BC000P133_n205FamDiscap[0] ;
         A750FamNroDoc = BC000P133_A750FamNroDoc[0] ;
         A890FamAdherente = BC000P133_A890FamAdherente[0] ;
         A30ParCod = BC000P133_A30ParCod[0] ;
         A1547GuarCod = BC000P133_A1547GuarCod[0] ;
         n1547GuarCod = BC000P133_n1547GuarCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0P24( )
   {
      /* Scan next routine */
      pr_default.readNext(131);
      RcdFound24 = (short)(0) ;
      scanKeyLoad0P24( ) ;
   }

   public void scanKeyLoad0P24( )
   {
      sMode24 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(131) != 101) )
      {
         RcdFound24 = (short)(1) ;
         A29LegOrden = BC000P133_A29LegOrden[0] ;
         A220FamTomaDeducImpGan = BC000P133_A220FamTomaDeducImpGan[0] ;
         A2090FamNomApe = BC000P133_A2090FamNomApe[0] ;
         A209FamFecNac = BC000P133_A209FamFecNac[0] ;
         n209FamFecNac = BC000P133_n209FamFecNac[0] ;
         A205FamDiscap = BC000P133_A205FamDiscap[0] ;
         n205FamDiscap = BC000P133_n205FamDiscap[0] ;
         A750FamNroDoc = BC000P133_A750FamNroDoc[0] ;
         A890FamAdherente = BC000P133_A890FamAdherente[0] ;
         A30ParCod = BC000P133_A30ParCod[0] ;
         A1547GuarCod = BC000P133_A1547GuarCod[0] ;
         n1547GuarCod = BC000P133_n1547GuarCod[0] ;
      }
      Gx_mode = sMode24 ;
   }

   public void scanKeyEnd0P24( )
   {
      pr_default.close(131);
   }

   public void afterConfirm0P24( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0P24( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0P24( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0P24( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0P24( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0P24( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0P24( )
   {
   }

   public void send_integrity_lvl_hashes0P24( )
   {
   }

   public void zm0P170( int GX_JID )
   {
      if ( ( GX_JID == 63 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 64 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -63 )
      {
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1319LegTipoTra = A1319LegTipoTra ;
      }
   }

   public void standaloneNotModal0P170( )
   {
   }

   public void standaloneModal0P170( )
   {
   }

   public void load0P170( )
   {
      /* Using cursor BC000P134 */
      pr_default.execute(132, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A1319LegTipoTra});
      if ( (pr_default.getStatus(132) != 101) )
      {
         RcdFound170 = (short)(1) ;
         zm0P170( -63) ;
      }
      pr_default.close(132);
      onLoadActions0P170( ) ;
   }

   public void onLoadActions0P170( )
   {
   }

   public void checkExtendedTable0P170( )
   {
      nIsDirty_170 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0P170( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000P135 */
      pr_default.execute(133, new Object[] {A1319LegTipoTra});
      if ( (pr_default.getStatus(133) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Trabajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGTIPOTRA");
         AnyError = (short)(1) ;
      }
      pr_default.close(133);
      if ( ! ( ( GXutil.strcmp(A1319LegTipoTra, "diurno") == 0 ) || ( GXutil.strcmp(A1319LegTipoTra, "nocturno") == 0 ) || ( GXutil.strcmp(A1319LegTipoTra, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0P170( )
   {
      pr_default.close(133);
   }

   public void enableDisable0P170( )
   {
   }

   public void getKey0P170( )
   {
      /* Using cursor BC000P136 */
      pr_default.execute(134, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A1319LegTipoTra});
      if ( (pr_default.getStatus(134) != 101) )
      {
         RcdFound170 = (short)(1) ;
      }
      else
      {
         RcdFound170 = (short)(0) ;
      }
      pr_default.close(134);
   }

   public void getByPrimaryKey0P170( )
   {
      /* Using cursor BC000P137 */
      pr_default.execute(135, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A1319LegTipoTra});
      if ( (pr_default.getStatus(135) != 101) )
      {
         zm0P170( 63) ;
         RcdFound170 = (short)(1) ;
         initializeNonKey0P170( ) ;
         A1319LegTipoTra = BC000P137_A1319LegTipoTra[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1319LegTipoTra = A1319LegTipoTra ;
         sMode170 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0P170( ) ;
         load0P170( ) ;
         Gx_mode = sMode170 ;
      }
      else
      {
         RcdFound170 = (short)(0) ;
         initializeNonKey0P170( ) ;
         sMode170 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0P170( ) ;
         Gx_mode = sMode170 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0P170( ) ;
      }
      pr_default.close(135);
   }

   public void checkOptimisticConcurrency0P170( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000P138 */
         pr_default.execute(136, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A1319LegTipoTra});
         if ( (pr_default.getStatus(136) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Legajotipos_de_trabajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(136) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Legajotipos_de_trabajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0P170( )
   {
      beforeValidate0P170( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P170( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0P170( 0) ;
         checkOptimisticConcurrency0P170( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P170( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0P170( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000P139 */
                  pr_default.execute(137, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A1319LegTipoTra});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajotipos_de_trabajo");
                  if ( (pr_default.getStatus(137) == 1) )
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
            load0P170( ) ;
         }
         endLevel0P170( ) ;
      }
      closeExtendedTableCursors0P170( ) ;
   }

   public void update0P170( )
   {
      beforeValidate0P170( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P170( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P170( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P170( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0P170( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table Legajotipos_de_trabajo */
                  deferredUpdate0P170( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0P170( ) ;
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
         endLevel0P170( ) ;
      }
      closeExtendedTableCursors0P170( ) ;
   }

   public void deferredUpdate0P170( )
   {
   }

   public void delete0P170( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0P170( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P170( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0P170( ) ;
         afterConfirm0P170( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0P170( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000P140 */
               pr_default.execute(138, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A1319LegTipoTra});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajotipos_de_trabajo");
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
      sMode170 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0P170( ) ;
      Gx_mode = sMode170 ;
   }

   public void onDeleteControls0P170( )
   {
      standaloneModal0P170( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0P170( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(136);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0P170( )
   {
      /* Scan By routine */
      /* Using cursor BC000P141 */
      pr_default.execute(139, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      RcdFound170 = (short)(0) ;
      if ( (pr_default.getStatus(139) != 101) )
      {
         RcdFound170 = (short)(1) ;
         A1319LegTipoTra = BC000P141_A1319LegTipoTra[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0P170( )
   {
      /* Scan next routine */
      pr_default.readNext(139);
      RcdFound170 = (short)(0) ;
      scanKeyLoad0P170( ) ;
   }

   public void scanKeyLoad0P170( )
   {
      sMode170 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(139) != 101) )
      {
         RcdFound170 = (short)(1) ;
         A1319LegTipoTra = BC000P141_A1319LegTipoTra[0] ;
      }
      Gx_mode = sMode170 ;
   }

   public void scanKeyEnd0P170( )
   {
      pr_default.close(139);
   }

   public void afterConfirm0P170( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0P170( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0P170( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0P170( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0P170( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0P170( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0P170( )
   {
   }

   public void send_integrity_lvl_hashes0P170( )
   {
   }

   public void zm0P276( int GX_JID )
   {
      if ( ( GX_JID == 65 ) || ( GX_JID == 0 ) )
      {
         Z2233LegPropValNum = A2233LegPropValNum ;
         Z2234LegPropValBool = A2234LegPropValBool ;
         Z2235LegPropValStr = A2235LegPropValStr ;
         Z2236LegPropValDate = A2236LegPropValDate ;
      }
      if ( ( GX_JID == 66 ) || ( GX_JID == 0 ) )
      {
         Z2231LegPropDes = A2231LegPropDes ;
         Z2232LegPropTD = A2232LegPropTD ;
      }
      if ( GX_JID == -65 )
      {
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z2233LegPropValNum = A2233LegPropValNum ;
         Z2234LegPropValBool = A2234LegPropValBool ;
         Z2235LegPropValStr = A2235LegPropValStr ;
         Z2236LegPropValDate = A2236LegPropValDate ;
         Z2230LegPropCod = A2230LegPropCod ;
         Z2231LegPropDes = A2231LegPropDes ;
         Z2232LegPropTD = A2232LegPropTD ;
      }
   }

   public void standaloneNotModal0P276( )
   {
   }

   public void standaloneModal0P276( )
   {
   }

   public void load0P276( )
   {
      /* Using cursor BC000P142 */
      pr_default.execute(140, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2230LegPropCod});
      if ( (pr_default.getStatus(140) != 101) )
      {
         RcdFound276 = (short)(1) ;
         A2231LegPropDes = BC000P142_A2231LegPropDes[0] ;
         A2232LegPropTD = BC000P142_A2232LegPropTD[0] ;
         A2233LegPropValNum = BC000P142_A2233LegPropValNum[0] ;
         A2234LegPropValBool = BC000P142_A2234LegPropValBool[0] ;
         A2235LegPropValStr = BC000P142_A2235LegPropValStr[0] ;
         A2236LegPropValDate = BC000P142_A2236LegPropValDate[0] ;
         zm0P276( -65) ;
      }
      pr_default.close(140);
      onLoadActions0P276( ) ;
   }

   public void onLoadActions0P276( )
   {
   }

   public void checkExtendedTable0P276( )
   {
      nIsDirty_276 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0P276( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000P143 */
      pr_default.execute(141, new Object[] {A2230LegPropCod});
      if ( (pr_default.getStatus(141) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Propiedades Adi Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGPROPCOD");
         AnyError = (short)(1) ;
      }
      A2231LegPropDes = BC000P143_A2231LegPropDes[0] ;
      A2232LegPropTD = BC000P143_A2232LegPropTD[0] ;
      pr_default.close(141);
   }

   public void closeExtendedTableCursors0P276( )
   {
      pr_default.close(141);
   }

   public void enableDisable0P276( )
   {
   }

   public void getKey0P276( )
   {
      /* Using cursor BC000P144 */
      pr_default.execute(142, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2230LegPropCod});
      if ( (pr_default.getStatus(142) != 101) )
      {
         RcdFound276 = (short)(1) ;
      }
      else
      {
         RcdFound276 = (short)(0) ;
      }
      pr_default.close(142);
   }

   public void getByPrimaryKey0P276( )
   {
      /* Using cursor BC000P145 */
      pr_default.execute(143, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2230LegPropCod});
      if ( (pr_default.getStatus(143) != 101) )
      {
         zm0P276( 65) ;
         RcdFound276 = (short)(1) ;
         initializeNonKey0P276( ) ;
         A2233LegPropValNum = BC000P145_A2233LegPropValNum[0] ;
         A2234LegPropValBool = BC000P145_A2234LegPropValBool[0] ;
         A2235LegPropValStr = BC000P145_A2235LegPropValStr[0] ;
         A2236LegPropValDate = BC000P145_A2236LegPropValDate[0] ;
         A2230LegPropCod = BC000P145_A2230LegPropCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z2230LegPropCod = A2230LegPropCod ;
         sMode276 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0P276( ) ;
         load0P276( ) ;
         Gx_mode = sMode276 ;
      }
      else
      {
         RcdFound276 = (short)(0) ;
         initializeNonKey0P276( ) ;
         sMode276 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0P276( ) ;
         Gx_mode = sMode276 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0P276( ) ;
      }
      pr_default.close(143);
   }

   public void checkOptimisticConcurrency0P276( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000P146 */
         pr_default.execute(144, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2230LegPropCod});
         if ( (pr_default.getStatus(144) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoPropiedades"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(144) == 101) || ( DecimalUtil.compareTo(Z2233LegPropValNum, BC000P146_A2233LegPropValNum[0]) != 0 ) || ( Z2234LegPropValBool != BC000P146_A2234LegPropValBool[0] ) || ( GXutil.strcmp(Z2235LegPropValStr, BC000P146_A2235LegPropValStr[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z2236LegPropValDate), GXutil.resetTime(BC000P146_A2236LegPropValDate[0])) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LegajoPropiedades"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0P276( )
   {
      beforeValidate0P276( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P276( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0P276( 0) ;
         checkOptimisticConcurrency0P276( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P276( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0P276( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000P147 */
                  pr_default.execute(145, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2233LegPropValNum, Boolean.valueOf(A2234LegPropValBool), A2235LegPropValStr, A2236LegPropValDate, A2230LegPropCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoPropiedades");
                  if ( (pr_default.getStatus(145) == 1) )
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
            load0P276( ) ;
         }
         endLevel0P276( ) ;
      }
      closeExtendedTableCursors0P276( ) ;
   }

   public void update0P276( )
   {
      beforeValidate0P276( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P276( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P276( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P276( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0P276( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000P148 */
                  pr_default.execute(146, new Object[] {A2233LegPropValNum, Boolean.valueOf(A2234LegPropValBool), A2235LegPropValStr, A2236LegPropValDate, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2230LegPropCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoPropiedades");
                  if ( (pr_default.getStatus(146) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoPropiedades"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0P276( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0P276( ) ;
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
         endLevel0P276( ) ;
      }
      closeExtendedTableCursors0P276( ) ;
   }

   public void deferredUpdate0P276( )
   {
   }

   public void delete0P276( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0P276( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P276( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0P276( ) ;
         afterConfirm0P276( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0P276( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000P149 */
               pr_default.execute(147, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2230LegPropCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoPropiedades");
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
      sMode276 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0P276( ) ;
      Gx_mode = sMode276 ;
   }

   public void onDeleteControls0P276( )
   {
      standaloneModal0P276( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000P150 */
         pr_default.execute(148, new Object[] {A2230LegPropCod});
         A2231LegPropDes = BC000P150_A2231LegPropDes[0] ;
         A2232LegPropTD = BC000P150_A2232LegPropTD[0] ;
         pr_default.close(148);
      }
   }

   public void endLevel0P276( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(144);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0P276( )
   {
      /* Scan By routine */
      /* Using cursor BC000P151 */
      pr_default.execute(149, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      RcdFound276 = (short)(0) ;
      if ( (pr_default.getStatus(149) != 101) )
      {
         RcdFound276 = (short)(1) ;
         A2231LegPropDes = BC000P151_A2231LegPropDes[0] ;
         A2232LegPropTD = BC000P151_A2232LegPropTD[0] ;
         A2233LegPropValNum = BC000P151_A2233LegPropValNum[0] ;
         A2234LegPropValBool = BC000P151_A2234LegPropValBool[0] ;
         A2235LegPropValStr = BC000P151_A2235LegPropValStr[0] ;
         A2236LegPropValDate = BC000P151_A2236LegPropValDate[0] ;
         A2230LegPropCod = BC000P151_A2230LegPropCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0P276( )
   {
      /* Scan next routine */
      pr_default.readNext(149);
      RcdFound276 = (short)(0) ;
      scanKeyLoad0P276( ) ;
   }

   public void scanKeyLoad0P276( )
   {
      sMode276 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(149) != 101) )
      {
         RcdFound276 = (short)(1) ;
         A2231LegPropDes = BC000P151_A2231LegPropDes[0] ;
         A2232LegPropTD = BC000P151_A2232LegPropTD[0] ;
         A2233LegPropValNum = BC000P151_A2233LegPropValNum[0] ;
         A2234LegPropValBool = BC000P151_A2234LegPropValBool[0] ;
         A2235LegPropValStr = BC000P151_A2235LegPropValStr[0] ;
         A2236LegPropValDate = BC000P151_A2236LegPropValDate[0] ;
         A2230LegPropCod = BC000P151_A2230LegPropCod[0] ;
      }
      Gx_mode = sMode276 ;
   }

   public void scanKeyEnd0P276( )
   {
      pr_default.close(149);
   }

   public void afterConfirm0P276( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0P276( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0P276( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0P276( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0P276( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0P276( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0P276( )
   {
   }

   public void send_integrity_lvl_hashes0P276( )
   {
   }

   public void send_integrity_lvl_hashes0P23( )
   {
   }

   public void addRow0P23( )
   {
      VarsToRow23( bcLegajo) ;
   }

   public void readRow0P23( )
   {
      RowToVars23( bcLegajo, 1) ;
   }

   public void addRow0P129( )
   {
      web.SdtLegajo_Salario obj129;
      obj129 = new web.SdtLegajo_Salario(remoteHandle);
      VarsToRow129( obj129) ;
      bcLegajo.getgxTv_SdtLegajo_Salario().add(obj129, 0);
      obj129.setgxTv_SdtLegajo_Salario_Mode( "UPD" );
      obj129.setgxTv_SdtLegajo_Salario_Modified( (short)(0) );
   }

   public void readRow0P129( )
   {
      nGXsfl_129_idx = (int)(nGXsfl_129_idx+1) ;
      RowToVars129( ((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx)), 1) ;
   }

   public void addRow0P292( )
   {
      web.SdtLegajo_Salario_Conceptos obj292;
      obj292 = new web.SdtLegajo_Salario_Conceptos(remoteHandle);
      VarsToRow292( obj292) ;
      ((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx)).getgxTv_SdtLegajo_Salario_Conceptos().add(obj292, 0);
      obj292.setgxTv_SdtLegajo_Salario_Conceptos_Mode( "UPD" );
      obj292.setgxTv_SdtLegajo_Salario_Conceptos_Modified( (short)(0) );
   }

   public void readRow0P292( )
   {
      nGXsfl_292_idx = (int)(nGXsfl_292_idx+1) ;
      RowToVars292( ((web.SdtLegajo_Salario_Conceptos)((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx)).getgxTv_SdtLegajo_Salario_Conceptos().elementAt(-1+nGXsfl_292_idx)), 1) ;
   }

   public void addRow0P24( )
   {
      web.SdtLegajo_Familia obj24;
      obj24 = new web.SdtLegajo_Familia(remoteHandle);
      VarsToRow24( obj24) ;
      bcLegajo.getgxTv_SdtLegajo_Familia().add(obj24, 0);
      obj24.setgxTv_SdtLegajo_Familia_Mode( "UPD" );
      obj24.setgxTv_SdtLegajo_Familia_Modified( (short)(0) );
   }

   public void readRow0P24( )
   {
      nGXsfl_24_idx = (int)(nGXsfl_24_idx+1) ;
      RowToVars24( ((web.SdtLegajo_Familia)bcLegajo.getgxTv_SdtLegajo_Familia().elementAt(-1+nGXsfl_24_idx)), 1) ;
   }

   public void addRow0P170( )
   {
      web.SdtLegajo_tipos_de_trabajo obj170;
      obj170 = new web.SdtLegajo_tipos_de_trabajo(remoteHandle);
      VarsToRow170( obj170) ;
      bcLegajo.getgxTv_SdtLegajo_Tipos_de_trabajo().add(obj170, 0);
      obj170.setgxTv_SdtLegajo_tipos_de_trabajo_Mode( "UPD" );
      obj170.setgxTv_SdtLegajo_tipos_de_trabajo_Modified( (short)(0) );
   }

   public void readRow0P170( )
   {
      nGXsfl_170_idx = (int)(nGXsfl_170_idx+1) ;
      RowToVars170( ((web.SdtLegajo_tipos_de_trabajo)bcLegajo.getgxTv_SdtLegajo_Tipos_de_trabajo().elementAt(-1+nGXsfl_170_idx)), 1) ;
   }

   public void addRow0P276( )
   {
      web.SdtLegajo_Propiedades obj276;
      obj276 = new web.SdtLegajo_Propiedades(remoteHandle);
      VarsToRow276( obj276) ;
      bcLegajo.getgxTv_SdtLegajo_Propiedades().add(obj276, 0);
      obj276.setgxTv_SdtLegajo_Propiedades_Mode( "UPD" );
      obj276.setgxTv_SdtLegajo_Propiedades_Modified( (short)(0) );
   }

   public void readRow0P276( )
   {
      nGXsfl_276_idx = (int)(nGXsfl_276_idx+1) ;
      RowToVars276( ((web.SdtLegajo_Propiedades)bcLegajo.getgxTv_SdtLegajo_Propiedades().elementAt(-1+nGXsfl_276_idx)), 1) ;
   }

   public void initializeNonKey0P23( )
   {
      A1965EmpOsoCod = "" ;
      n1965EmpOsoCod = false ;
      A247LegFecUltMod = GXutil.nullDate() ;
      AV104LegSexo = (byte)(0) ;
      A237LegConvenio = false ;
      A688SinieDescriSinAc = "" ;
      A686CondiDescriSinAc = "" ;
      A678ZonDescripSinAc = "" ;
      A684MprDescripSinAc = "" ;
      A555OsoSiglaYDesc = "" ;
      A681OsoDescripSinAc = "" ;
      A680SinDescripSinAc = "" ;
      A677LpgDescriSinAc = "" ;
      A675SecDescripSinAc = "" ;
      A233LegBasico = DecimalUtil.ZERO ;
      A250LegIdNomApe = "" ;
      A591LegNomApe = "" ;
      A2EmpNom = "" ;
      A230LegApellido = "" ;
      A251LegNombre = "" ;
      A249LegFoto = "" ;
      n249LegFoto = false ;
      A266LegTipDoc = (byte)(0) ;
      A257LegNumDoc = "" ;
      A246LegFecNac = GXutil.nullDate() ;
      A263LegSexo = (byte)(0) ;
      n263LegSexo = false ;
      A243LegEstadoCivil = (short)(0) ;
      n243LegEstadoCivil = false ;
      A21LegNacionCod = (short)(0) ;
      n21LegNacionCod = false ;
      A256LegNacionalidad = "" ;
      A239LegCUIL = 0 ;
      A241LegDiscapacidad = (byte)(0) ;
      A242LegDomici = "" ;
      A479LegEmail = "" ;
      A236LegCodPos = "" ;
      A22LegPaiCod = (short)(0) ;
      n22LegPaiCod = false ;
      A258LegPaiNom = "" ;
      A23LegProvCod = (short)(0) ;
      n23LegProvCod = false ;
      A260LegProvNom = "" ;
      A24LegLocCod = (short)(0) ;
      n24LegLocCod = false ;
      A255LegLocNom = "" ;
      A265LegTelefono = "" ;
      n265LegTelefono = false ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A244LegFecEgreso = GXutil.nullDate() ;
      n244LegFecEgreso = false ;
      A1583LegMegCodigo = "" ;
      n1583LegMegCodigo = false ;
      A300MegDescrip = "" ;
      n300MegDescrip = false ;
      A939LegCatCodigo = "" ;
      n939LegCatCodigo = false ;
      A2215LegCatPueCod = 0 ;
      n2215LegCatPueCod = false ;
      A1579LegSecCodigo = "" ;
      n1579LegSecCodigo = false ;
      A329SecDescrip = "" ;
      n329SecDescrip = false ;
      A1581LegLpgCodigo = "" ;
      n1581LegLpgCodigo = false ;
      A291LpgDescri = "" ;
      n291LpgDescri = false ;
      A235LegClase = (byte)(0) ;
      A1582LegBanCod = "" ;
      n1582LegBanCod = false ;
      A2224LegBanDes = "" ;
      A231LegBanSuc = "" ;
      n231LegBanSuc = false ;
      A232LegBanTipCuen = "" ;
      n232LegBanTipCuen = false ;
      A910LegSinCod = "" ;
      n910LegSinCod = false ;
      A331SinDescrip = "" ;
      n331SinDescrip = false ;
      A1580LegOsoCod = "" ;
      n1580LegOsoCod = false ;
      A2225LegOsoDes = "" ;
      A2226LegOsoAfipCod = "" ;
      n2226LegOsoAfipCod = false ;
      A307OsoDescrip = "" ;
      n307OsoDescrip = false ;
      A15LegActCodigo = "" ;
      n15LegActCodigo = false ;
      A227LegActDescri = "" ;
      A18MprCod = "" ;
      n18MprCod = false ;
      A303MprDescrip = "" ;
      A238LegCuentaBanc = "" ;
      n238LegCuentaBanc = false ;
      A253LegLicInicio = GXutil.nullDate() ;
      n253LegLicInicio = false ;
      A252LegLicFinal = GXutil.nullDate() ;
      n252LegLicFinal = false ;
      A20ZonCod = "" ;
      n20ZonCod = false ;
      A342ZonDescrip = "" ;
      A343ZonPorcReduc = DecimalUtil.ZERO ;
      A234LegCBU = "" ;
      n234LegCBU = false ;
      A17CondiCodigo = (short)(0) ;
      n17CondiCodigo = false ;
      A144CondiDescri = "" ;
      A19SinieCodigo = "" ;
      n19SinieCodigo = false ;
      A333SinieDescri = "" ;
      A228LegActivo = false ;
      A264LegSueldoFuera = DecimalUtil.ZERO ;
      A93LegId = "" ;
      n93LegId = false ;
      A937LegConveCodigo = "" ;
      n937LegConveCodigo = false ;
      A45TipEmpleCod = "" ;
      n45TipEmpleCod = false ;
      A306OsoC3992 = "" ;
      n306OsoC3992 = false ;
      A515LegObs = "" ;
      A630LegFecImportacion = GXutil.resetTime( GXutil.nullDate() );
      A877LegAgenReten = false ;
      A942LegRecalcLiq = false ;
      A1016LegJubilado = false ;
      A1023LegHorasDia = DecimalUtil.ZERO ;
      A1268LegHorasSem = DecimalUtil.ZERO ;
      A1235LegReligion = "" ;
      n1235LegReligion = false ;
      A1236LegOrigen = "" ;
      n1236LegOrigen = false ;
      A1578LegPuesCodigo = "" ;
      n1578LegPuesCodigo = false ;
      A1577LegSucCodigo = "" ;
      n1577LegSucCodigo = false ;
      A1245LegTrabLun = false ;
      A1246LegTrabMar = false ;
      A1247LegTrabMie = false ;
      A1248LegTrabJue = false ;
      A1249LegTrabVie = false ;
      A1250LegTrabSa = false ;
      A1251LegTrabDo = false ;
      A1523LegVacPend = (short)(0) ;
      A1531LegFecPreAviso = GXutil.nullDate() ;
      A1576LegConveVersionCli = 0 ;
      n1576LegConveVersionCli = false ;
      A1603LegSitRevEgreso = (short)(0) ;
      n1603LegSitRevEgreso = false ;
      A1759LegPromDias = "" ;
      A1804LegTitulo = "" ;
      A1818LegEstado = (byte)(0) ;
      A2182LegActClasNro = 0 ;
      n2182LegActClasNro = false ;
      A2181LegPueAfiCod = "" ;
      n2181LegPueAfiCod = false ;
      A2263LegMigrWarn = "" ;
      n2263LegMigrWarn = false ;
      A2267LegIncompleto = false ;
      A2309LegLiqApo = false ;
      A2404LegModTra = "" ;
      A2417LegTipoTarifa = "" ;
      A1031LegFotoExt = "" ;
      A1030LegFotoNom = "" ;
      A392OsoSigla = "" ;
      n392OsoSigla = false ;
      A248LegFormaPago = (byte)(3) ;
      A262LegSCVO = true ;
      A879LegContinua = "" ;
      Z237LegConvenio = false ;
      Z250LegIdNomApe = "" ;
      Z591LegNomApe = "" ;
      Z247LegFecUltMod = GXutil.nullDate() ;
      Z230LegApellido = "" ;
      Z251LegNombre = "" ;
      Z266LegTipDoc = (byte)(0) ;
      Z257LegNumDoc = "" ;
      Z246LegFecNac = GXutil.nullDate() ;
      Z239LegCUIL = 0 ;
      Z241LegDiscapacidad = (byte)(0) ;
      Z242LegDomici = "" ;
      Z479LegEmail = "" ;
      Z236LegCodPos = "" ;
      Z265LegTelefono = "" ;
      Z245LegFecIngreso = GXutil.nullDate() ;
      Z244LegFecEgreso = GXutil.nullDate() ;
      Z939LegCatCodigo = "" ;
      Z2215LegCatPueCod = 0 ;
      Z235LegClase = (byte)(0) ;
      Z248LegFormaPago = (byte)(0) ;
      Z231LegBanSuc = "" ;
      Z232LegBanTipCuen = "" ;
      Z238LegCuentaBanc = "" ;
      Z253LegLicInicio = GXutil.nullDate() ;
      Z252LegLicFinal = GXutil.nullDate() ;
      Z234LegCBU = "" ;
      Z262LegSCVO = false ;
      Z228LegActivo = false ;
      Z264LegSueldoFuera = DecimalUtil.ZERO ;
      Z93LegId = "" ;
      Z937LegConveCodigo = "" ;
      Z630LegFecImportacion = GXutil.resetTime( GXutil.nullDate() );
      Z877LegAgenReten = false ;
      Z879LegContinua = "" ;
      Z942LegRecalcLiq = false ;
      Z1016LegJubilado = false ;
      Z1023LegHorasDia = DecimalUtil.ZERO ;
      Z1268LegHorasSem = DecimalUtil.ZERO ;
      Z1245LegTrabLun = false ;
      Z1246LegTrabMar = false ;
      Z1247LegTrabMie = false ;
      Z1248LegTrabJue = false ;
      Z1249LegTrabVie = false ;
      Z1250LegTrabSa = false ;
      Z1251LegTrabDo = false ;
      Z1523LegVacPend = (short)(0) ;
      Z1531LegFecPreAviso = GXutil.nullDate() ;
      Z1576LegConveVersionCli = 0 ;
      Z1759LegPromDias = "" ;
      Z1804LegTitulo = "" ;
      Z1818LegEstado = (byte)(0) ;
      Z2267LegIncompleto = false ;
      Z2309LegLiqApo = false ;
      Z2404LegModTra = "" ;
      Z2417LegTipoTarifa = "" ;
      Z1582LegBanCod = "" ;
      Z1581LegLpgCodigo = "" ;
      Z1583LegMegCodigo = "" ;
      Z1580LegOsoCod = "" ;
      Z1579LegSecCodigo = "" ;
      Z1577LegSucCodigo = "" ;
      Z1578LegPuesCodigo = "" ;
      Z18MprCod = "" ;
      Z20ZonCod = "" ;
      Z17CondiCodigo = (short)(0) ;
      Z19SinieCodigo = "" ;
      Z263LegSexo = (byte)(0) ;
      Z243LegEstadoCivil = (short)(0) ;
      Z22LegPaiCod = (short)(0) ;
      Z23LegProvCod = (short)(0) ;
      Z24LegLocCod = (short)(0) ;
      Z21LegNacionCod = (short)(0) ;
      Z910LegSinCod = "" ;
      Z2182LegActClasNro = 0 ;
      Z15LegActCodigo = "" ;
      Z1603LegSitRevEgreso = (short)(0) ;
      Z2181LegPueAfiCod = "" ;
      Z1235LegReligion = "" ;
      Z1236LegOrigen = "" ;
   }

   public void initAll0P23( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A6LegNumero = 0 ;
      initializeNonKey0P23( ) ;
   }

   public void standaloneModalInsert( )
   {
      A248LegFormaPago = i248LegFormaPago ;
      A262LegSCVO = i262LegSCVO ;
      A879LegContinua = i879LegContinua ;
   }

   public void initializeNonKey0P129( )
   {
      AV91CliCod = 0 ;
      AV8LegNumero = 0 ;
      A1136LegSuelFecha = GXutil.nullDate() ;
      A1137LegSuelImporte = DecimalUtil.ZERO ;
      A2344LegSuelTipo = "" ;
      n2344LegSuelTipo = false ;
      A2347LegSuelCalc = DecimalUtil.ZERO ;
      A2348LegSuelLog = "" ;
      Z1136LegSuelFecha = GXutil.nullDate() ;
      Z1137LegSuelImporte = DecimalUtil.ZERO ;
      Z2344LegSuelTipo = "" ;
      Z2347LegSuelCalc = DecimalUtil.ZERO ;
   }

   public void initAll0P129( )
   {
      A1135LegSuelSec = (short)(0) ;
      initializeNonKey0P129( ) ;
   }

   public void standaloneModalInsert0P129( )
   {
   }

   public void initializeNonKey0P292( )
   {
   }

   public void initAll0P292( )
   {
      A2349LegSuelConcepto = "" ;
      initializeNonKey0P292( ) ;
   }

   public void standaloneModalInsert0P292( )
   {
   }

   public void initializeNonKey0P24( )
   {
      AV91CliCod = 0 ;
      AV8LegNumero = 0 ;
      A2090FamNomApe = "" ;
      A30ParCod = "" ;
      A209FamFecNac = GXutil.nullDate() ;
      n209FamFecNac = false ;
      A205FamDiscap = false ;
      n205FamDiscap = false ;
      A750FamNroDoc = "" ;
      A890FamAdherente = false ;
      A1547GuarCod = (short)(0) ;
      n1547GuarCod = false ;
      A220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
      Z220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      Z2090FamNomApe = "" ;
      Z209FamFecNac = GXutil.nullDate() ;
      Z205FamDiscap = false ;
      Z750FamNroDoc = "" ;
      Z890FamAdherente = false ;
      Z30ParCod = "" ;
      Z1547GuarCod = (short)(0) ;
   }

   public void initAll0P24( )
   {
      A29LegOrden = (short)(0) ;
      initializeNonKey0P24( ) ;
   }

   public void standaloneModalInsert0P24( )
   {
      A220FamTomaDeducImpGan = i220FamTomaDeducImpGan ;
   }

   public void initializeNonKey0P170( )
   {
      A1292TipoTraId = "" ;
   }

   public void initAll0P170( )
   {
      A1319LegTipoTra = "" ;
      initializeNonKey0P170( ) ;
   }

   public void standaloneModalInsert0P170( )
   {
   }

   public void initializeNonKey0P276( )
   {
      A2231LegPropDes = "" ;
      A2232LegPropTD = "" ;
      A2233LegPropValNum = DecimalUtil.ZERO ;
      A2234LegPropValBool = false ;
      A2235LegPropValStr = "" ;
      A2236LegPropValDate = GXutil.nullDate() ;
      Z2233LegPropValNum = DecimalUtil.ZERO ;
      Z2234LegPropValBool = false ;
      Z2235LegPropValStr = "" ;
      Z2236LegPropValDate = GXutil.nullDate() ;
   }

   public void initAll0P276( )
   {
      A2230LegPropCod = "" ;
      initializeNonKey0P276( ) ;
   }

   public void standaloneModalInsert0P276( )
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

   public void VarsToRow23( web.SdtLegajo obj23 )
   {
      obj23.setgxTv_SdtLegajo_Mode( Gx_mode );
      obj23.setgxTv_SdtLegajo_Legfecultmod( A247LegFecUltMod );
      obj23.setgxTv_SdtLegajo_Legconvenio( A237LegConvenio );
      obj23.setgxTv_SdtLegajo_Legbasico( A233LegBasico );
      obj23.setgxTv_SdtLegajo_Legidnomape( A250LegIdNomApe );
      obj23.setgxTv_SdtLegajo_Legnomape( A591LegNomApe );
      obj23.setgxTv_SdtLegajo_Empnom( A2EmpNom );
      obj23.setgxTv_SdtLegajo_Legapellido( A230LegApellido );
      obj23.setgxTv_SdtLegajo_Legnombre( A251LegNombre );
      obj23.setgxTv_SdtLegajo_Legfoto( A249LegFoto );
      obj23.setgxTv_SdtLegajo_Legtipdoc( A266LegTipDoc );
      obj23.setgxTv_SdtLegajo_Legnumdoc( A257LegNumDoc );
      obj23.setgxTv_SdtLegajo_Legfecnac( A246LegFecNac );
      obj23.setgxTv_SdtLegajo_Legsexo( A263LegSexo );
      obj23.setgxTv_SdtLegajo_Legestadocivil( A243LegEstadoCivil );
      obj23.setgxTv_SdtLegajo_Legnacioncod( A21LegNacionCod );
      obj23.setgxTv_SdtLegajo_Legnacionalidad( A256LegNacionalidad );
      obj23.setgxTv_SdtLegajo_Legcuil( A239LegCUIL );
      obj23.setgxTv_SdtLegajo_Legdiscapacidad( A241LegDiscapacidad );
      obj23.setgxTv_SdtLegajo_Legdomici( A242LegDomici );
      obj23.setgxTv_SdtLegajo_Legemail( A479LegEmail );
      obj23.setgxTv_SdtLegajo_Legcodpos( A236LegCodPos );
      obj23.setgxTv_SdtLegajo_Legpaicod( A22LegPaiCod );
      obj23.setgxTv_SdtLegajo_Legpainom( A258LegPaiNom );
      obj23.setgxTv_SdtLegajo_Legprovcod( A23LegProvCod );
      obj23.setgxTv_SdtLegajo_Legprovnom( A260LegProvNom );
      obj23.setgxTv_SdtLegajo_Legloccod( A24LegLocCod );
      obj23.setgxTv_SdtLegajo_Leglocnom( A255LegLocNom );
      obj23.setgxTv_SdtLegajo_Legtelefono( A265LegTelefono );
      obj23.setgxTv_SdtLegajo_Legfecingreso( A245LegFecIngreso );
      obj23.setgxTv_SdtLegajo_Legfecegreso( A244LegFecEgreso );
      obj23.setgxTv_SdtLegajo_Legmegcodigo( A1583LegMegCodigo );
      obj23.setgxTv_SdtLegajo_Megdescrip( A300MegDescrip );
      obj23.setgxTv_SdtLegajo_Legcatcodigo( A939LegCatCodigo );
      obj23.setgxTv_SdtLegajo_Legcatpuecod( A2215LegCatPueCod );
      obj23.setgxTv_SdtLegajo_Legseccodigo( A1579LegSecCodigo );
      obj23.setgxTv_SdtLegajo_Secdescrip( A329SecDescrip );
      obj23.setgxTv_SdtLegajo_Leglpgcodigo( A1581LegLpgCodigo );
      obj23.setgxTv_SdtLegajo_Lpgdescri( A291LpgDescri );
      obj23.setgxTv_SdtLegajo_Legclase( A235LegClase );
      obj23.setgxTv_SdtLegajo_Legbancod( A1582LegBanCod );
      obj23.setgxTv_SdtLegajo_Legbandes( A2224LegBanDes );
      obj23.setgxTv_SdtLegajo_Legbansuc( A231LegBanSuc );
      obj23.setgxTv_SdtLegajo_Legbantipcuen( A232LegBanTipCuen );
      obj23.setgxTv_SdtLegajo_Legsincod( A910LegSinCod );
      obj23.setgxTv_SdtLegajo_Sindescrip( A331SinDescrip );
      obj23.setgxTv_SdtLegajo_Legosocod( A1580LegOsoCod );
      obj23.setgxTv_SdtLegajo_Legosodes( A2225LegOsoDes );
      obj23.setgxTv_SdtLegajo_Legosoafipcod( A2226LegOsoAfipCod );
      obj23.setgxTv_SdtLegajo_Osodescrip( A307OsoDescrip );
      obj23.setgxTv_SdtLegajo_Legactcodigo( A15LegActCodigo );
      obj23.setgxTv_SdtLegajo_Legactdescri( A227LegActDescri );
      obj23.setgxTv_SdtLegajo_Mprcod( A18MprCod );
      obj23.setgxTv_SdtLegajo_Mprdescrip( A303MprDescrip );
      obj23.setgxTv_SdtLegajo_Legcuentabanc( A238LegCuentaBanc );
      obj23.setgxTv_SdtLegajo_Leglicinicio( A253LegLicInicio );
      obj23.setgxTv_SdtLegajo_Leglicfinal( A252LegLicFinal );
      obj23.setgxTv_SdtLegajo_Zoncod( A20ZonCod );
      obj23.setgxTv_SdtLegajo_Zondescrip( A342ZonDescrip );
      obj23.setgxTv_SdtLegajo_Zonporcreduc( A343ZonPorcReduc );
      obj23.setgxTv_SdtLegajo_Legcbu( A234LegCBU );
      obj23.setgxTv_SdtLegajo_Condicodigo( A17CondiCodigo );
      obj23.setgxTv_SdtLegajo_Condidescri( A144CondiDescri );
      obj23.setgxTv_SdtLegajo_Siniecodigo( A19SinieCodigo );
      obj23.setgxTv_SdtLegajo_Siniedescri( A333SinieDescri );
      obj23.setgxTv_SdtLegajo_Legactivo( A228LegActivo );
      obj23.setgxTv_SdtLegajo_Legsueldofuera( A264LegSueldoFuera );
      obj23.setgxTv_SdtLegajo_Legid( A93LegId );
      obj23.setgxTv_SdtLegajo_Legconvecodigo( A937LegConveCodigo );
      obj23.setgxTv_SdtLegajo_Tipemplecod( A45TipEmpleCod );
      obj23.setgxTv_SdtLegajo_Osoc3992( A306OsoC3992 );
      obj23.setgxTv_SdtLegajo_Legobs( A515LegObs );
      obj23.setgxTv_SdtLegajo_Legfecimportacion( A630LegFecImportacion );
      obj23.setgxTv_SdtLegajo_Legagenreten( A877LegAgenReten );
      obj23.setgxTv_SdtLegajo_Legrecalcliq( A942LegRecalcLiq );
      obj23.setgxTv_SdtLegajo_Legjubilado( A1016LegJubilado );
      obj23.setgxTv_SdtLegajo_Leghorasdia( A1023LegHorasDia );
      obj23.setgxTv_SdtLegajo_Leghorassem( A1268LegHorasSem );
      obj23.setgxTv_SdtLegajo_Legreligion( A1235LegReligion );
      obj23.setgxTv_SdtLegajo_Legorigen( A1236LegOrigen );
      obj23.setgxTv_SdtLegajo_Legpuescodigo( A1578LegPuesCodigo );
      obj23.setgxTv_SdtLegajo_Legsuccodigo( A1577LegSucCodigo );
      obj23.setgxTv_SdtLegajo_Legtrablun( A1245LegTrabLun );
      obj23.setgxTv_SdtLegajo_Legtrabmar( A1246LegTrabMar );
      obj23.setgxTv_SdtLegajo_Legtrabmie( A1247LegTrabMie );
      obj23.setgxTv_SdtLegajo_Legtrabjue( A1248LegTrabJue );
      obj23.setgxTv_SdtLegajo_Legtrabvie( A1249LegTrabVie );
      obj23.setgxTv_SdtLegajo_Legtrabsa( A1250LegTrabSa );
      obj23.setgxTv_SdtLegajo_Legtrabdo( A1251LegTrabDo );
      obj23.setgxTv_SdtLegajo_Legvacpend( A1523LegVacPend );
      obj23.setgxTv_SdtLegajo_Legfecpreaviso( A1531LegFecPreAviso );
      obj23.setgxTv_SdtLegajo_Legconveversioncli( A1576LegConveVersionCli );
      obj23.setgxTv_SdtLegajo_Legsitrevegreso( A1603LegSitRevEgreso );
      obj23.setgxTv_SdtLegajo_Legpromdias( A1759LegPromDias );
      obj23.setgxTv_SdtLegajo_Legtitulo( A1804LegTitulo );
      obj23.setgxTv_SdtLegajo_Legestado( A1818LegEstado );
      obj23.setgxTv_SdtLegajo_Legactclasnro( A2182LegActClasNro );
      obj23.setgxTv_SdtLegajo_Legpueaficod( A2181LegPueAfiCod );
      obj23.setgxTv_SdtLegajo_Legmigrwarn( A2263LegMigrWarn );
      obj23.setgxTv_SdtLegajo_Legincompleto( A2267LegIncompleto );
      obj23.setgxTv_SdtLegajo_Legliqapo( A2309LegLiqApo );
      obj23.setgxTv_SdtLegajo_Legmodtra( A2404LegModTra );
      obj23.setgxTv_SdtLegajo_Legtipotarifa( A2417LegTipoTarifa );
      obj23.setgxTv_SdtLegajo_Legfotoext( A1031LegFotoExt );
      obj23.setgxTv_SdtLegajo_Legfotonom( A1030LegFotoNom );
      obj23.setgxTv_SdtLegajo_Legformapago( A248LegFormaPago );
      obj23.setgxTv_SdtLegajo_Legscvo( A262LegSCVO );
      obj23.setgxTv_SdtLegajo_Legcontinua( A879LegContinua );
      obj23.setgxTv_SdtLegajo_Clicod( A3CliCod );
      obj23.setgxTv_SdtLegajo_Empcod( A1EmpCod );
      obj23.setgxTv_SdtLegajo_Legnumero( A6LegNumero );
      obj23.setgxTv_SdtLegajo_Clicod_Z( Z3CliCod );
      obj23.setgxTv_SdtLegajo_Empcod_Z( Z1EmpCod );
      obj23.setgxTv_SdtLegajo_Empnom_Z( Z2EmpNom );
      obj23.setgxTv_SdtLegajo_Legnumero_Z( Z6LegNumero );
      obj23.setgxTv_SdtLegajo_Legapellido_Z( Z230LegApellido );
      obj23.setgxTv_SdtLegajo_Legnombre_Z( Z251LegNombre );
      obj23.setgxTv_SdtLegajo_Legfotonom_Z( Z1030LegFotoNom );
      obj23.setgxTv_SdtLegajo_Legfotoext_Z( Z1031LegFotoExt );
      obj23.setgxTv_SdtLegajo_Legtipdoc_Z( Z266LegTipDoc );
      obj23.setgxTv_SdtLegajo_Legnumdoc_Z( Z257LegNumDoc );
      obj23.setgxTv_SdtLegajo_Legfecnac_Z( Z246LegFecNac );
      obj23.setgxTv_SdtLegajo_Legsexo_Z( Z263LegSexo );
      obj23.setgxTv_SdtLegajo_Legestadocivil_Z( Z243LegEstadoCivil );
      obj23.setgxTv_SdtLegajo_Legnacioncod_Z( Z21LegNacionCod );
      obj23.setgxTv_SdtLegajo_Legnacionalidad_Z( Z256LegNacionalidad );
      obj23.setgxTv_SdtLegajo_Legcuil_Z( Z239LegCUIL );
      obj23.setgxTv_SdtLegajo_Legdiscapacidad_Z( Z241LegDiscapacidad );
      obj23.setgxTv_SdtLegajo_Legdomici_Z( Z242LegDomici );
      obj23.setgxTv_SdtLegajo_Legemail_Z( Z479LegEmail );
      obj23.setgxTv_SdtLegajo_Legcodpos_Z( Z236LegCodPos );
      obj23.setgxTv_SdtLegajo_Legpaicod_Z( Z22LegPaiCod );
      obj23.setgxTv_SdtLegajo_Legpainom_Z( Z258LegPaiNom );
      obj23.setgxTv_SdtLegajo_Legprovcod_Z( Z23LegProvCod );
      obj23.setgxTv_SdtLegajo_Legprovnom_Z( Z260LegProvNom );
      obj23.setgxTv_SdtLegajo_Legloccod_Z( Z24LegLocCod );
      obj23.setgxTv_SdtLegajo_Leglocnom_Z( Z255LegLocNom );
      obj23.setgxTv_SdtLegajo_Legtelefono_Z( Z265LegTelefono );
      obj23.setgxTv_SdtLegajo_Legfecingreso_Z( Z245LegFecIngreso );
      obj23.setgxTv_SdtLegajo_Legfecegreso_Z( Z244LegFecEgreso );
      obj23.setgxTv_SdtLegajo_Legmegcodigo_Z( Z1583LegMegCodigo );
      obj23.setgxTv_SdtLegajo_Megdescrip_Z( Z300MegDescrip );
      obj23.setgxTv_SdtLegajo_Legcatcodigo_Z( Z939LegCatCodigo );
      obj23.setgxTv_SdtLegajo_Legcatpuecod_Z( Z2215LegCatPueCod );
      obj23.setgxTv_SdtLegajo_Legseccodigo_Z( Z1579LegSecCodigo );
      obj23.setgxTv_SdtLegajo_Secdescrip_Z( Z329SecDescrip );
      obj23.setgxTv_SdtLegajo_Leglpgcodigo_Z( Z1581LegLpgCodigo );
      obj23.setgxTv_SdtLegajo_Lpgdescri_Z( Z291LpgDescri );
      obj23.setgxTv_SdtLegajo_Legclase_Z( Z235LegClase );
      obj23.setgxTv_SdtLegajo_Legbasico_Z( Z233LegBasico );
      obj23.setgxTv_SdtLegajo_Legformapago_Z( Z248LegFormaPago );
      obj23.setgxTv_SdtLegajo_Legbancod_Z( Z1582LegBanCod );
      obj23.setgxTv_SdtLegajo_Legbandes_Z( Z2224LegBanDes );
      obj23.setgxTv_SdtLegajo_Legbansuc_Z( Z231LegBanSuc );
      obj23.setgxTv_SdtLegajo_Legbantipcuen_Z( Z232LegBanTipCuen );
      obj23.setgxTv_SdtLegajo_Legsincod_Z( Z910LegSinCod );
      obj23.setgxTv_SdtLegajo_Sindescrip_Z( Z331SinDescrip );
      obj23.setgxTv_SdtLegajo_Legosocod_Z( Z1580LegOsoCod );
      obj23.setgxTv_SdtLegajo_Legosodes_Z( Z2225LegOsoDes );
      obj23.setgxTv_SdtLegajo_Legosoafipcod_Z( Z2226LegOsoAfipCod );
      obj23.setgxTv_SdtLegajo_Osodescrip_Z( Z307OsoDescrip );
      obj23.setgxTv_SdtLegajo_Legactcodigo_Z( Z15LegActCodigo );
      obj23.setgxTv_SdtLegajo_Legactdescri_Z( Z227LegActDescri );
      obj23.setgxTv_SdtLegajo_Mprcod_Z( Z18MprCod );
      obj23.setgxTv_SdtLegajo_Mprdescrip_Z( Z303MprDescrip );
      obj23.setgxTv_SdtLegajo_Legfecultmod_Z( Z247LegFecUltMod );
      obj23.setgxTv_SdtLegajo_Legcuentabanc_Z( Z238LegCuentaBanc );
      obj23.setgxTv_SdtLegajo_Leglicinicio_Z( Z253LegLicInicio );
      obj23.setgxTv_SdtLegajo_Leglicfinal_Z( Z252LegLicFinal );
      obj23.setgxTv_SdtLegajo_Zoncod_Z( Z20ZonCod );
      obj23.setgxTv_SdtLegajo_Zondescrip_Z( Z342ZonDescrip );
      obj23.setgxTv_SdtLegajo_Zonporcreduc_Z( Z343ZonPorcReduc );
      obj23.setgxTv_SdtLegajo_Legcbu_Z( Z234LegCBU );
      obj23.setgxTv_SdtLegajo_Legconvenio_Z( Z237LegConvenio );
      obj23.setgxTv_SdtLegajo_Legscvo_Z( Z262LegSCVO );
      obj23.setgxTv_SdtLegajo_Condicodigo_Z( Z17CondiCodigo );
      obj23.setgxTv_SdtLegajo_Condidescri_Z( Z144CondiDescri );
      obj23.setgxTv_SdtLegajo_Siniecodigo_Z( Z19SinieCodigo );
      obj23.setgxTv_SdtLegajo_Siniedescri_Z( Z333SinieDescri );
      obj23.setgxTv_SdtLegajo_Legactivo_Z( Z228LegActivo );
      obj23.setgxTv_SdtLegajo_Legsueldofuera_Z( Z264LegSueldoFuera );
      obj23.setgxTv_SdtLegajo_Legid_Z( Z93LegId );
      obj23.setgxTv_SdtLegajo_Legconvecodigo_Z( Z937LegConveCodigo );
      obj23.setgxTv_SdtLegajo_Legidnomape_Z( Z250LegIdNomApe );
      obj23.setgxTv_SdtLegajo_Tipemplecod_Z( Z45TipEmpleCod );
      obj23.setgxTv_SdtLegajo_Osoc3992_Z( Z306OsoC3992 );
      obj23.setgxTv_SdtLegajo_Legnomape_Z( Z591LegNomApe );
      obj23.setgxTv_SdtLegajo_Legfecimportacion_Z( Z630LegFecImportacion );
      obj23.setgxTv_SdtLegajo_Legagenreten_Z( Z877LegAgenReten );
      obj23.setgxTv_SdtLegajo_Legcontinua_Z( Z879LegContinua );
      obj23.setgxTv_SdtLegajo_Legrecalcliq_Z( Z942LegRecalcLiq );
      obj23.setgxTv_SdtLegajo_Legjubilado_Z( Z1016LegJubilado );
      obj23.setgxTv_SdtLegajo_Leghorasdia_Z( Z1023LegHorasDia );
      obj23.setgxTv_SdtLegajo_Leghorassem_Z( Z1268LegHorasSem );
      obj23.setgxTv_SdtLegajo_Legreligion_Z( Z1235LegReligion );
      obj23.setgxTv_SdtLegajo_Legorigen_Z( Z1236LegOrigen );
      obj23.setgxTv_SdtLegajo_Legpuescodigo_Z( Z1578LegPuesCodigo );
      obj23.setgxTv_SdtLegajo_Legsuccodigo_Z( Z1577LegSucCodigo );
      obj23.setgxTv_SdtLegajo_Legtrablun_Z( Z1245LegTrabLun );
      obj23.setgxTv_SdtLegajo_Legtrabmar_Z( Z1246LegTrabMar );
      obj23.setgxTv_SdtLegajo_Legtrabmie_Z( Z1247LegTrabMie );
      obj23.setgxTv_SdtLegajo_Legtrabjue_Z( Z1248LegTrabJue );
      obj23.setgxTv_SdtLegajo_Legtrabvie_Z( Z1249LegTrabVie );
      obj23.setgxTv_SdtLegajo_Legtrabsa_Z( Z1250LegTrabSa );
      obj23.setgxTv_SdtLegajo_Legtrabdo_Z( Z1251LegTrabDo );
      obj23.setgxTv_SdtLegajo_Legvacpend_Z( Z1523LegVacPend );
      obj23.setgxTv_SdtLegajo_Legfecpreaviso_Z( Z1531LegFecPreAviso );
      obj23.setgxTv_SdtLegajo_Legconveversioncli_Z( Z1576LegConveVersionCli );
      obj23.setgxTv_SdtLegajo_Legsitrevegreso_Z( Z1603LegSitRevEgreso );
      obj23.setgxTv_SdtLegajo_Legpromdias_Z( Z1759LegPromDias );
      obj23.setgxTv_SdtLegajo_Legtitulo_Z( Z1804LegTitulo );
      obj23.setgxTv_SdtLegajo_Legestado_Z( Z1818LegEstado );
      obj23.setgxTv_SdtLegajo_Legactclasnro_Z( Z2182LegActClasNro );
      obj23.setgxTv_SdtLegajo_Legpueaficod_Z( Z2181LegPueAfiCod );
      obj23.setgxTv_SdtLegajo_Legincompleto_Z( Z2267LegIncompleto );
      obj23.setgxTv_SdtLegajo_Legliqapo_Z( Z2309LegLiqApo );
      obj23.setgxTv_SdtLegajo_Legmodtra_Z( Z2404LegModTra );
      obj23.setgxTv_SdtLegajo_Legtipotarifa_Z( Z2417LegTipoTarifa );
      obj23.setgxTv_SdtLegajo_Legfoto_N( (byte)((byte)((n249LegFoto)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legsexo_N( (byte)((byte)((n263LegSexo)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legestadocivil_N( (byte)((byte)((n243LegEstadoCivil)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legnacioncod_N( (byte)((byte)((n21LegNacionCod)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legpaicod_N( (byte)((byte)((n22LegPaiCod)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legprovcod_N( (byte)((byte)((n23LegProvCod)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legloccod_N( (byte)((byte)((n24LegLocCod)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legtelefono_N( (byte)((byte)((n265LegTelefono)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legfecegreso_N( (byte)((byte)((n244LegFecEgreso)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legmegcodigo_N( (byte)((byte)((n1583LegMegCodigo)?1:0)) );
      obj23.setgxTv_SdtLegajo_Megdescrip_N( (byte)((byte)((n300MegDescrip)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legcatcodigo_N( (byte)((byte)((n939LegCatCodigo)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legcatpuecod_N( (byte)((byte)((n2215LegCatPueCod)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legseccodigo_N( (byte)((byte)((n1579LegSecCodigo)?1:0)) );
      obj23.setgxTv_SdtLegajo_Secdescrip_N( (byte)((byte)((n329SecDescrip)?1:0)) );
      obj23.setgxTv_SdtLegajo_Leglpgcodigo_N( (byte)((byte)((n1581LegLpgCodigo)?1:0)) );
      obj23.setgxTv_SdtLegajo_Lpgdescri_N( (byte)((byte)((n291LpgDescri)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legbancod_N( (byte)((byte)((n1582LegBanCod)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legbansuc_N( (byte)((byte)((n231LegBanSuc)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legbantipcuen_N( (byte)((byte)((n232LegBanTipCuen)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legsincod_N( (byte)((byte)((n910LegSinCod)?1:0)) );
      obj23.setgxTv_SdtLegajo_Sindescrip_N( (byte)((byte)((n331SinDescrip)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legosocod_N( (byte)((byte)((n1580LegOsoCod)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legosoafipcod_N( (byte)((byte)((n2226LegOsoAfipCod)?1:0)) );
      obj23.setgxTv_SdtLegajo_Osodescrip_N( (byte)((byte)((n307OsoDescrip)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legactcodigo_N( (byte)((byte)((n15LegActCodigo)?1:0)) );
      obj23.setgxTv_SdtLegajo_Mprcod_N( (byte)((byte)((n18MprCod)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legcuentabanc_N( (byte)((byte)((n238LegCuentaBanc)?1:0)) );
      obj23.setgxTv_SdtLegajo_Leglicinicio_N( (byte)((byte)((n253LegLicInicio)?1:0)) );
      obj23.setgxTv_SdtLegajo_Leglicfinal_N( (byte)((byte)((n252LegLicFinal)?1:0)) );
      obj23.setgxTv_SdtLegajo_Zoncod_N( (byte)((byte)((n20ZonCod)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legcbu_N( (byte)((byte)((n234LegCBU)?1:0)) );
      obj23.setgxTv_SdtLegajo_Condicodigo_N( (byte)((byte)((n17CondiCodigo)?1:0)) );
      obj23.setgxTv_SdtLegajo_Siniecodigo_N( (byte)((byte)((n19SinieCodigo)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legid_N( (byte)((byte)((n93LegId)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legconvecodigo_N( (byte)((byte)((n937LegConveCodigo)?1:0)) );
      obj23.setgxTv_SdtLegajo_Tipemplecod_N( (byte)((byte)((n45TipEmpleCod)?1:0)) );
      obj23.setgxTv_SdtLegajo_Osoc3992_N( (byte)((byte)((n306OsoC3992)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legreligion_N( (byte)((byte)((n1235LegReligion)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legorigen_N( (byte)((byte)((n1236LegOrigen)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legpuescodigo_N( (byte)((byte)((n1578LegPuesCodigo)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legsuccodigo_N( (byte)((byte)((n1577LegSucCodigo)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legconveversioncli_N( (byte)((byte)((n1576LegConveVersionCli)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legsitrevegreso_N( (byte)((byte)((n1603LegSitRevEgreso)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legactclasnro_N( (byte)((byte)((n2182LegActClasNro)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legpueaficod_N( (byte)((byte)((n2181LegPueAfiCod)?1:0)) );
      obj23.setgxTv_SdtLegajo_Legmigrwarn_N( (byte)((byte)((n2263LegMigrWarn)?1:0)) );
      obj23.setgxTv_SdtLegajo_Mode( Gx_mode );
   }

   public void KeyVarsToRow23( web.SdtLegajo obj23 )
   {
      obj23.setgxTv_SdtLegajo_Clicod( A3CliCod );
      obj23.setgxTv_SdtLegajo_Empcod( A1EmpCod );
      obj23.setgxTv_SdtLegajo_Legnumero( A6LegNumero );
   }

   public void RowToVars23( web.SdtLegajo obj23 ,
                            int forceLoad )
   {
      Gx_mode = obj23.getgxTv_SdtLegajo_Mode() ;
      A247LegFecUltMod = obj23.getgxTv_SdtLegajo_Legfecultmod() ;
      A237LegConvenio = obj23.getgxTv_SdtLegajo_Legconvenio() ;
      if ( forceLoad == 1 )
      {
         A233LegBasico = obj23.getgxTv_SdtLegajo_Legbasico() ;
      }
      A250LegIdNomApe = obj23.getgxTv_SdtLegajo_Legidnomape() ;
      A591LegNomApe = obj23.getgxTv_SdtLegajo_Legnomape() ;
      A2EmpNom = obj23.getgxTv_SdtLegajo_Empnom() ;
      A230LegApellido = obj23.getgxTv_SdtLegajo_Legapellido() ;
      A251LegNombre = obj23.getgxTv_SdtLegajo_Legnombre() ;
      A249LegFoto = obj23.getgxTv_SdtLegajo_Legfoto() ;
      n249LegFoto = false ;
      A266LegTipDoc = obj23.getgxTv_SdtLegajo_Legtipdoc() ;
      A257LegNumDoc = obj23.getgxTv_SdtLegajo_Legnumdoc() ;
      A246LegFecNac = obj23.getgxTv_SdtLegajo_Legfecnac() ;
      A263LegSexo = obj23.getgxTv_SdtLegajo_Legsexo() ;
      n263LegSexo = false ;
      A243LegEstadoCivil = obj23.getgxTv_SdtLegajo_Legestadocivil() ;
      n243LegEstadoCivil = false ;
      A21LegNacionCod = obj23.getgxTv_SdtLegajo_Legnacioncod() ;
      n21LegNacionCod = false ;
      A256LegNacionalidad = obj23.getgxTv_SdtLegajo_Legnacionalidad() ;
      A239LegCUIL = obj23.getgxTv_SdtLegajo_Legcuil() ;
      A241LegDiscapacidad = obj23.getgxTv_SdtLegajo_Legdiscapacidad() ;
      A242LegDomici = obj23.getgxTv_SdtLegajo_Legdomici() ;
      A479LegEmail = obj23.getgxTv_SdtLegajo_Legemail() ;
      A236LegCodPos = obj23.getgxTv_SdtLegajo_Legcodpos() ;
      A22LegPaiCod = obj23.getgxTv_SdtLegajo_Legpaicod() ;
      n22LegPaiCod = false ;
      A258LegPaiNom = obj23.getgxTv_SdtLegajo_Legpainom() ;
      A23LegProvCod = obj23.getgxTv_SdtLegajo_Legprovcod() ;
      n23LegProvCod = false ;
      A260LegProvNom = obj23.getgxTv_SdtLegajo_Legprovnom() ;
      A24LegLocCod = obj23.getgxTv_SdtLegajo_Legloccod() ;
      n24LegLocCod = false ;
      A255LegLocNom = obj23.getgxTv_SdtLegajo_Leglocnom() ;
      A265LegTelefono = obj23.getgxTv_SdtLegajo_Legtelefono() ;
      n265LegTelefono = false ;
      A245LegFecIngreso = obj23.getgxTv_SdtLegajo_Legfecingreso() ;
      A244LegFecEgreso = obj23.getgxTv_SdtLegajo_Legfecegreso() ;
      n244LegFecEgreso = false ;
      A1583LegMegCodigo = obj23.getgxTv_SdtLegajo_Legmegcodigo() ;
      n1583LegMegCodigo = false ;
      A300MegDescrip = obj23.getgxTv_SdtLegajo_Megdescrip() ;
      n300MegDescrip = false ;
      A939LegCatCodigo = obj23.getgxTv_SdtLegajo_Legcatcodigo() ;
      n939LegCatCodigo = false ;
      A2215LegCatPueCod = obj23.getgxTv_SdtLegajo_Legcatpuecod() ;
      n2215LegCatPueCod = false ;
      A1579LegSecCodigo = obj23.getgxTv_SdtLegajo_Legseccodigo() ;
      n1579LegSecCodigo = false ;
      A329SecDescrip = obj23.getgxTv_SdtLegajo_Secdescrip() ;
      n329SecDescrip = false ;
      A1581LegLpgCodigo = obj23.getgxTv_SdtLegajo_Leglpgcodigo() ;
      n1581LegLpgCodigo = false ;
      A291LpgDescri = obj23.getgxTv_SdtLegajo_Lpgdescri() ;
      n291LpgDescri = false ;
      A235LegClase = obj23.getgxTv_SdtLegajo_Legclase() ;
      A1582LegBanCod = obj23.getgxTv_SdtLegajo_Legbancod() ;
      n1582LegBanCod = false ;
      A2224LegBanDes = obj23.getgxTv_SdtLegajo_Legbandes() ;
      A231LegBanSuc = obj23.getgxTv_SdtLegajo_Legbansuc() ;
      n231LegBanSuc = false ;
      A232LegBanTipCuen = obj23.getgxTv_SdtLegajo_Legbantipcuen() ;
      n232LegBanTipCuen = false ;
      A910LegSinCod = obj23.getgxTv_SdtLegajo_Legsincod() ;
      n910LegSinCod = false ;
      A331SinDescrip = obj23.getgxTv_SdtLegajo_Sindescrip() ;
      n331SinDescrip = false ;
      A1580LegOsoCod = obj23.getgxTv_SdtLegajo_Legosocod() ;
      n1580LegOsoCod = false ;
      A2225LegOsoDes = obj23.getgxTv_SdtLegajo_Legosodes() ;
      A2226LegOsoAfipCod = obj23.getgxTv_SdtLegajo_Legosoafipcod() ;
      n2226LegOsoAfipCod = false ;
      A307OsoDescrip = obj23.getgxTv_SdtLegajo_Osodescrip() ;
      n307OsoDescrip = false ;
      A15LegActCodigo = obj23.getgxTv_SdtLegajo_Legactcodigo() ;
      n15LegActCodigo = false ;
      A227LegActDescri = obj23.getgxTv_SdtLegajo_Legactdescri() ;
      A18MprCod = obj23.getgxTv_SdtLegajo_Mprcod() ;
      n18MprCod = false ;
      A303MprDescrip = obj23.getgxTv_SdtLegajo_Mprdescrip() ;
      A238LegCuentaBanc = obj23.getgxTv_SdtLegajo_Legcuentabanc() ;
      n238LegCuentaBanc = false ;
      A253LegLicInicio = obj23.getgxTv_SdtLegajo_Leglicinicio() ;
      n253LegLicInicio = false ;
      A252LegLicFinal = obj23.getgxTv_SdtLegajo_Leglicfinal() ;
      n252LegLicFinal = false ;
      A20ZonCod = obj23.getgxTv_SdtLegajo_Zoncod() ;
      n20ZonCod = false ;
      A342ZonDescrip = obj23.getgxTv_SdtLegajo_Zondescrip() ;
      A343ZonPorcReduc = obj23.getgxTv_SdtLegajo_Zonporcreduc() ;
      A234LegCBU = obj23.getgxTv_SdtLegajo_Legcbu() ;
      n234LegCBU = false ;
      A17CondiCodigo = obj23.getgxTv_SdtLegajo_Condicodigo() ;
      n17CondiCodigo = false ;
      A144CondiDescri = obj23.getgxTv_SdtLegajo_Condidescri() ;
      A19SinieCodigo = obj23.getgxTv_SdtLegajo_Siniecodigo() ;
      n19SinieCodigo = false ;
      A333SinieDescri = obj23.getgxTv_SdtLegajo_Siniedescri() ;
      A228LegActivo = obj23.getgxTv_SdtLegajo_Legactivo() ;
      A264LegSueldoFuera = obj23.getgxTv_SdtLegajo_Legsueldofuera() ;
      A93LegId = obj23.getgxTv_SdtLegajo_Legid() ;
      n93LegId = false ;
      A937LegConveCodigo = obj23.getgxTv_SdtLegajo_Legconvecodigo() ;
      n937LegConveCodigo = false ;
      A45TipEmpleCod = obj23.getgxTv_SdtLegajo_Tipemplecod() ;
      n45TipEmpleCod = false ;
      A306OsoC3992 = obj23.getgxTv_SdtLegajo_Osoc3992() ;
      n306OsoC3992 = false ;
      A515LegObs = obj23.getgxTv_SdtLegajo_Legobs() ;
      A630LegFecImportacion = obj23.getgxTv_SdtLegajo_Legfecimportacion() ;
      A877LegAgenReten = obj23.getgxTv_SdtLegajo_Legagenreten() ;
      A942LegRecalcLiq = obj23.getgxTv_SdtLegajo_Legrecalcliq() ;
      A1016LegJubilado = obj23.getgxTv_SdtLegajo_Legjubilado() ;
      A1023LegHorasDia = obj23.getgxTv_SdtLegajo_Leghorasdia() ;
      A1268LegHorasSem = obj23.getgxTv_SdtLegajo_Leghorassem() ;
      A1235LegReligion = obj23.getgxTv_SdtLegajo_Legreligion() ;
      n1235LegReligion = false ;
      A1236LegOrigen = obj23.getgxTv_SdtLegajo_Legorigen() ;
      n1236LegOrigen = false ;
      A1578LegPuesCodigo = obj23.getgxTv_SdtLegajo_Legpuescodigo() ;
      n1578LegPuesCodigo = false ;
      A1577LegSucCodigo = obj23.getgxTv_SdtLegajo_Legsuccodigo() ;
      n1577LegSucCodigo = false ;
      A1245LegTrabLun = obj23.getgxTv_SdtLegajo_Legtrablun() ;
      A1246LegTrabMar = obj23.getgxTv_SdtLegajo_Legtrabmar() ;
      A1247LegTrabMie = obj23.getgxTv_SdtLegajo_Legtrabmie() ;
      A1248LegTrabJue = obj23.getgxTv_SdtLegajo_Legtrabjue() ;
      A1249LegTrabVie = obj23.getgxTv_SdtLegajo_Legtrabvie() ;
      A1250LegTrabSa = obj23.getgxTv_SdtLegajo_Legtrabsa() ;
      A1251LegTrabDo = obj23.getgxTv_SdtLegajo_Legtrabdo() ;
      A1523LegVacPend = obj23.getgxTv_SdtLegajo_Legvacpend() ;
      A1531LegFecPreAviso = obj23.getgxTv_SdtLegajo_Legfecpreaviso() ;
      A1576LegConveVersionCli = obj23.getgxTv_SdtLegajo_Legconveversioncli() ;
      n1576LegConveVersionCli = false ;
      A1603LegSitRevEgreso = obj23.getgxTv_SdtLegajo_Legsitrevegreso() ;
      n1603LegSitRevEgreso = false ;
      A1759LegPromDias = obj23.getgxTv_SdtLegajo_Legpromdias() ;
      A1804LegTitulo = obj23.getgxTv_SdtLegajo_Legtitulo() ;
      A1818LegEstado = obj23.getgxTv_SdtLegajo_Legestado() ;
      A2182LegActClasNro = obj23.getgxTv_SdtLegajo_Legactclasnro() ;
      n2182LegActClasNro = false ;
      A2181LegPueAfiCod = obj23.getgxTv_SdtLegajo_Legpueaficod() ;
      n2181LegPueAfiCod = false ;
      A2263LegMigrWarn = obj23.getgxTv_SdtLegajo_Legmigrwarn() ;
      n2263LegMigrWarn = false ;
      A2267LegIncompleto = obj23.getgxTv_SdtLegajo_Legincompleto() ;
      A2309LegLiqApo = obj23.getgxTv_SdtLegajo_Legliqapo() ;
      A2404LegModTra = obj23.getgxTv_SdtLegajo_Legmodtra() ;
      A2417LegTipoTarifa = obj23.getgxTv_SdtLegajo_Legtipotarifa() ;
      A1031LegFotoExt = ((GXutil.strcmp("", obj23.getgxTv_SdtLegajo_Legfotoext())==0) ? com.genexus.util.GXFile.getgxFileext( A249LegFoto) : obj23.getgxTv_SdtLegajo_Legfotoext()) ;
      A1030LegFotoNom = ((GXutil.strcmp("", obj23.getgxTv_SdtLegajo_Legfotonom())==0) ? com.genexus.util.GXFile.getgxFilename( A249LegFoto) : obj23.getgxTv_SdtLegajo_Legfotonom()) ;
      A248LegFormaPago = obj23.getgxTv_SdtLegajo_Legformapago() ;
      A262LegSCVO = obj23.getgxTv_SdtLegajo_Legscvo() ;
      A879LegContinua = obj23.getgxTv_SdtLegajo_Legcontinua() ;
      A3CliCod = obj23.getgxTv_SdtLegajo_Clicod() ;
      A1EmpCod = obj23.getgxTv_SdtLegajo_Empcod() ;
      if ( forceLoad == 1 )
      {
         A6LegNumero = obj23.getgxTv_SdtLegajo_Legnumero() ;
      }
      Z3CliCod = obj23.getgxTv_SdtLegajo_Clicod_Z() ;
      Z1EmpCod = obj23.getgxTv_SdtLegajo_Empcod_Z() ;
      Z2EmpNom = obj23.getgxTv_SdtLegajo_Empnom_Z() ;
      Z6LegNumero = obj23.getgxTv_SdtLegajo_Legnumero_Z() ;
      Z230LegApellido = obj23.getgxTv_SdtLegajo_Legapellido_Z() ;
      Z251LegNombre = obj23.getgxTv_SdtLegajo_Legnombre_Z() ;
      Z1030LegFotoNom = obj23.getgxTv_SdtLegajo_Legfotonom_Z() ;
      Z1031LegFotoExt = obj23.getgxTv_SdtLegajo_Legfotoext_Z() ;
      Z266LegTipDoc = obj23.getgxTv_SdtLegajo_Legtipdoc_Z() ;
      Z257LegNumDoc = obj23.getgxTv_SdtLegajo_Legnumdoc_Z() ;
      Z246LegFecNac = obj23.getgxTv_SdtLegajo_Legfecnac_Z() ;
      Z263LegSexo = obj23.getgxTv_SdtLegajo_Legsexo_Z() ;
      Z243LegEstadoCivil = obj23.getgxTv_SdtLegajo_Legestadocivil_Z() ;
      Z21LegNacionCod = obj23.getgxTv_SdtLegajo_Legnacioncod_Z() ;
      Z256LegNacionalidad = obj23.getgxTv_SdtLegajo_Legnacionalidad_Z() ;
      Z239LegCUIL = obj23.getgxTv_SdtLegajo_Legcuil_Z() ;
      Z241LegDiscapacidad = obj23.getgxTv_SdtLegajo_Legdiscapacidad_Z() ;
      Z242LegDomici = obj23.getgxTv_SdtLegajo_Legdomici_Z() ;
      Z479LegEmail = obj23.getgxTv_SdtLegajo_Legemail_Z() ;
      Z236LegCodPos = obj23.getgxTv_SdtLegajo_Legcodpos_Z() ;
      Z22LegPaiCod = obj23.getgxTv_SdtLegajo_Legpaicod_Z() ;
      Z258LegPaiNom = obj23.getgxTv_SdtLegajo_Legpainom_Z() ;
      Z23LegProvCod = obj23.getgxTv_SdtLegajo_Legprovcod_Z() ;
      Z260LegProvNom = obj23.getgxTv_SdtLegajo_Legprovnom_Z() ;
      Z24LegLocCod = obj23.getgxTv_SdtLegajo_Legloccod_Z() ;
      Z255LegLocNom = obj23.getgxTv_SdtLegajo_Leglocnom_Z() ;
      Z265LegTelefono = obj23.getgxTv_SdtLegajo_Legtelefono_Z() ;
      Z245LegFecIngreso = obj23.getgxTv_SdtLegajo_Legfecingreso_Z() ;
      Z244LegFecEgreso = obj23.getgxTv_SdtLegajo_Legfecegreso_Z() ;
      Z1583LegMegCodigo = obj23.getgxTv_SdtLegajo_Legmegcodigo_Z() ;
      Z300MegDescrip = obj23.getgxTv_SdtLegajo_Megdescrip_Z() ;
      Z939LegCatCodigo = obj23.getgxTv_SdtLegajo_Legcatcodigo_Z() ;
      Z2215LegCatPueCod = obj23.getgxTv_SdtLegajo_Legcatpuecod_Z() ;
      Z1579LegSecCodigo = obj23.getgxTv_SdtLegajo_Legseccodigo_Z() ;
      Z329SecDescrip = obj23.getgxTv_SdtLegajo_Secdescrip_Z() ;
      Z1581LegLpgCodigo = obj23.getgxTv_SdtLegajo_Leglpgcodigo_Z() ;
      Z291LpgDescri = obj23.getgxTv_SdtLegajo_Lpgdescri_Z() ;
      Z235LegClase = obj23.getgxTv_SdtLegajo_Legclase_Z() ;
      Z233LegBasico = obj23.getgxTv_SdtLegajo_Legbasico_Z() ;
      Z248LegFormaPago = obj23.getgxTv_SdtLegajo_Legformapago_Z() ;
      Z1582LegBanCod = obj23.getgxTv_SdtLegajo_Legbancod_Z() ;
      Z2224LegBanDes = obj23.getgxTv_SdtLegajo_Legbandes_Z() ;
      Z231LegBanSuc = obj23.getgxTv_SdtLegajo_Legbansuc_Z() ;
      Z232LegBanTipCuen = obj23.getgxTv_SdtLegajo_Legbantipcuen_Z() ;
      Z910LegSinCod = obj23.getgxTv_SdtLegajo_Legsincod_Z() ;
      Z331SinDescrip = obj23.getgxTv_SdtLegajo_Sindescrip_Z() ;
      Z1580LegOsoCod = obj23.getgxTv_SdtLegajo_Legosocod_Z() ;
      Z2225LegOsoDes = obj23.getgxTv_SdtLegajo_Legosodes_Z() ;
      Z2226LegOsoAfipCod = obj23.getgxTv_SdtLegajo_Legosoafipcod_Z() ;
      Z307OsoDescrip = obj23.getgxTv_SdtLegajo_Osodescrip_Z() ;
      Z15LegActCodigo = obj23.getgxTv_SdtLegajo_Legactcodigo_Z() ;
      Z227LegActDescri = obj23.getgxTv_SdtLegajo_Legactdescri_Z() ;
      Z18MprCod = obj23.getgxTv_SdtLegajo_Mprcod_Z() ;
      Z303MprDescrip = obj23.getgxTv_SdtLegajo_Mprdescrip_Z() ;
      Z247LegFecUltMod = obj23.getgxTv_SdtLegajo_Legfecultmod_Z() ;
      Z238LegCuentaBanc = obj23.getgxTv_SdtLegajo_Legcuentabanc_Z() ;
      Z253LegLicInicio = obj23.getgxTv_SdtLegajo_Leglicinicio_Z() ;
      Z252LegLicFinal = obj23.getgxTv_SdtLegajo_Leglicfinal_Z() ;
      Z20ZonCod = obj23.getgxTv_SdtLegajo_Zoncod_Z() ;
      Z342ZonDescrip = obj23.getgxTv_SdtLegajo_Zondescrip_Z() ;
      Z343ZonPorcReduc = obj23.getgxTv_SdtLegajo_Zonporcreduc_Z() ;
      Z234LegCBU = obj23.getgxTv_SdtLegajo_Legcbu_Z() ;
      Z237LegConvenio = obj23.getgxTv_SdtLegajo_Legconvenio_Z() ;
      Z262LegSCVO = obj23.getgxTv_SdtLegajo_Legscvo_Z() ;
      Z17CondiCodigo = obj23.getgxTv_SdtLegajo_Condicodigo_Z() ;
      Z144CondiDescri = obj23.getgxTv_SdtLegajo_Condidescri_Z() ;
      Z19SinieCodigo = obj23.getgxTv_SdtLegajo_Siniecodigo_Z() ;
      Z333SinieDescri = obj23.getgxTv_SdtLegajo_Siniedescri_Z() ;
      Z228LegActivo = obj23.getgxTv_SdtLegajo_Legactivo_Z() ;
      Z264LegSueldoFuera = obj23.getgxTv_SdtLegajo_Legsueldofuera_Z() ;
      Z93LegId = obj23.getgxTv_SdtLegajo_Legid_Z() ;
      Z937LegConveCodigo = obj23.getgxTv_SdtLegajo_Legconvecodigo_Z() ;
      Z250LegIdNomApe = obj23.getgxTv_SdtLegajo_Legidnomape_Z() ;
      Z45TipEmpleCod = obj23.getgxTv_SdtLegajo_Tipemplecod_Z() ;
      Z306OsoC3992 = obj23.getgxTv_SdtLegajo_Osoc3992_Z() ;
      Z591LegNomApe = obj23.getgxTv_SdtLegajo_Legnomape_Z() ;
      Z630LegFecImportacion = obj23.getgxTv_SdtLegajo_Legfecimportacion_Z() ;
      Z877LegAgenReten = obj23.getgxTv_SdtLegajo_Legagenreten_Z() ;
      Z879LegContinua = obj23.getgxTv_SdtLegajo_Legcontinua_Z() ;
      Z942LegRecalcLiq = obj23.getgxTv_SdtLegajo_Legrecalcliq_Z() ;
      Z1016LegJubilado = obj23.getgxTv_SdtLegajo_Legjubilado_Z() ;
      Z1023LegHorasDia = obj23.getgxTv_SdtLegajo_Leghorasdia_Z() ;
      Z1268LegHorasSem = obj23.getgxTv_SdtLegajo_Leghorassem_Z() ;
      Z1235LegReligion = obj23.getgxTv_SdtLegajo_Legreligion_Z() ;
      Z1236LegOrigen = obj23.getgxTv_SdtLegajo_Legorigen_Z() ;
      Z1578LegPuesCodigo = obj23.getgxTv_SdtLegajo_Legpuescodigo_Z() ;
      Z1577LegSucCodigo = obj23.getgxTv_SdtLegajo_Legsuccodigo_Z() ;
      Z1245LegTrabLun = obj23.getgxTv_SdtLegajo_Legtrablun_Z() ;
      Z1246LegTrabMar = obj23.getgxTv_SdtLegajo_Legtrabmar_Z() ;
      Z1247LegTrabMie = obj23.getgxTv_SdtLegajo_Legtrabmie_Z() ;
      Z1248LegTrabJue = obj23.getgxTv_SdtLegajo_Legtrabjue_Z() ;
      Z1249LegTrabVie = obj23.getgxTv_SdtLegajo_Legtrabvie_Z() ;
      Z1250LegTrabSa = obj23.getgxTv_SdtLegajo_Legtrabsa_Z() ;
      Z1251LegTrabDo = obj23.getgxTv_SdtLegajo_Legtrabdo_Z() ;
      Z1523LegVacPend = obj23.getgxTv_SdtLegajo_Legvacpend_Z() ;
      Z1531LegFecPreAviso = obj23.getgxTv_SdtLegajo_Legfecpreaviso_Z() ;
      Z1576LegConveVersionCli = obj23.getgxTv_SdtLegajo_Legconveversioncli_Z() ;
      Z1603LegSitRevEgreso = obj23.getgxTv_SdtLegajo_Legsitrevegreso_Z() ;
      Z1759LegPromDias = obj23.getgxTv_SdtLegajo_Legpromdias_Z() ;
      Z1804LegTitulo = obj23.getgxTv_SdtLegajo_Legtitulo_Z() ;
      Z1818LegEstado = obj23.getgxTv_SdtLegajo_Legestado_Z() ;
      Z2182LegActClasNro = obj23.getgxTv_SdtLegajo_Legactclasnro_Z() ;
      Z2181LegPueAfiCod = obj23.getgxTv_SdtLegajo_Legpueaficod_Z() ;
      Z2267LegIncompleto = obj23.getgxTv_SdtLegajo_Legincompleto_Z() ;
      Z2309LegLiqApo = obj23.getgxTv_SdtLegajo_Legliqapo_Z() ;
      Z2404LegModTra = obj23.getgxTv_SdtLegajo_Legmodtra_Z() ;
      Z2417LegTipoTarifa = obj23.getgxTv_SdtLegajo_Legtipotarifa_Z() ;
      n249LegFoto = (boolean)((obj23.getgxTv_SdtLegajo_Legfoto_N()==0)?false:true) ;
      n263LegSexo = (boolean)((obj23.getgxTv_SdtLegajo_Legsexo_N()==0)?false:true) ;
      n243LegEstadoCivil = (boolean)((obj23.getgxTv_SdtLegajo_Legestadocivil_N()==0)?false:true) ;
      n21LegNacionCod = (boolean)((obj23.getgxTv_SdtLegajo_Legnacioncod_N()==0)?false:true) ;
      n22LegPaiCod = (boolean)((obj23.getgxTv_SdtLegajo_Legpaicod_N()==0)?false:true) ;
      n23LegProvCod = (boolean)((obj23.getgxTv_SdtLegajo_Legprovcod_N()==0)?false:true) ;
      n24LegLocCod = (boolean)((obj23.getgxTv_SdtLegajo_Legloccod_N()==0)?false:true) ;
      n265LegTelefono = (boolean)((obj23.getgxTv_SdtLegajo_Legtelefono_N()==0)?false:true) ;
      n244LegFecEgreso = (boolean)((obj23.getgxTv_SdtLegajo_Legfecegreso_N()==0)?false:true) ;
      n1583LegMegCodigo = (boolean)((obj23.getgxTv_SdtLegajo_Legmegcodigo_N()==0)?false:true) ;
      n300MegDescrip = (boolean)((obj23.getgxTv_SdtLegajo_Megdescrip_N()==0)?false:true) ;
      n939LegCatCodigo = (boolean)((obj23.getgxTv_SdtLegajo_Legcatcodigo_N()==0)?false:true) ;
      n2215LegCatPueCod = (boolean)((obj23.getgxTv_SdtLegajo_Legcatpuecod_N()==0)?false:true) ;
      n1579LegSecCodigo = (boolean)((obj23.getgxTv_SdtLegajo_Legseccodigo_N()==0)?false:true) ;
      n329SecDescrip = (boolean)((obj23.getgxTv_SdtLegajo_Secdescrip_N()==0)?false:true) ;
      n1581LegLpgCodigo = (boolean)((obj23.getgxTv_SdtLegajo_Leglpgcodigo_N()==0)?false:true) ;
      n291LpgDescri = (boolean)((obj23.getgxTv_SdtLegajo_Lpgdescri_N()==0)?false:true) ;
      n1582LegBanCod = (boolean)((obj23.getgxTv_SdtLegajo_Legbancod_N()==0)?false:true) ;
      n231LegBanSuc = (boolean)((obj23.getgxTv_SdtLegajo_Legbansuc_N()==0)?false:true) ;
      n232LegBanTipCuen = (boolean)((obj23.getgxTv_SdtLegajo_Legbantipcuen_N()==0)?false:true) ;
      n910LegSinCod = (boolean)((obj23.getgxTv_SdtLegajo_Legsincod_N()==0)?false:true) ;
      n331SinDescrip = (boolean)((obj23.getgxTv_SdtLegajo_Sindescrip_N()==0)?false:true) ;
      n1580LegOsoCod = (boolean)((obj23.getgxTv_SdtLegajo_Legosocod_N()==0)?false:true) ;
      n2226LegOsoAfipCod = (boolean)((obj23.getgxTv_SdtLegajo_Legosoafipcod_N()==0)?false:true) ;
      n307OsoDescrip = (boolean)((obj23.getgxTv_SdtLegajo_Osodescrip_N()==0)?false:true) ;
      n15LegActCodigo = (boolean)((obj23.getgxTv_SdtLegajo_Legactcodigo_N()==0)?false:true) ;
      n18MprCod = (boolean)((obj23.getgxTv_SdtLegajo_Mprcod_N()==0)?false:true) ;
      n238LegCuentaBanc = (boolean)((obj23.getgxTv_SdtLegajo_Legcuentabanc_N()==0)?false:true) ;
      n253LegLicInicio = (boolean)((obj23.getgxTv_SdtLegajo_Leglicinicio_N()==0)?false:true) ;
      n252LegLicFinal = (boolean)((obj23.getgxTv_SdtLegajo_Leglicfinal_N()==0)?false:true) ;
      n20ZonCod = (boolean)((obj23.getgxTv_SdtLegajo_Zoncod_N()==0)?false:true) ;
      n234LegCBU = (boolean)((obj23.getgxTv_SdtLegajo_Legcbu_N()==0)?false:true) ;
      n17CondiCodigo = (boolean)((obj23.getgxTv_SdtLegajo_Condicodigo_N()==0)?false:true) ;
      n19SinieCodigo = (boolean)((obj23.getgxTv_SdtLegajo_Siniecodigo_N()==0)?false:true) ;
      n93LegId = (boolean)((obj23.getgxTv_SdtLegajo_Legid_N()==0)?false:true) ;
      n937LegConveCodigo = (boolean)((obj23.getgxTv_SdtLegajo_Legconvecodigo_N()==0)?false:true) ;
      n45TipEmpleCod = (boolean)((obj23.getgxTv_SdtLegajo_Tipemplecod_N()==0)?false:true) ;
      n306OsoC3992 = (boolean)((obj23.getgxTv_SdtLegajo_Osoc3992_N()==0)?false:true) ;
      n1235LegReligion = (boolean)((obj23.getgxTv_SdtLegajo_Legreligion_N()==0)?false:true) ;
      n1236LegOrigen = (boolean)((obj23.getgxTv_SdtLegajo_Legorigen_N()==0)?false:true) ;
      n1578LegPuesCodigo = (boolean)((obj23.getgxTv_SdtLegajo_Legpuescodigo_N()==0)?false:true) ;
      n1577LegSucCodigo = (boolean)((obj23.getgxTv_SdtLegajo_Legsuccodigo_N()==0)?false:true) ;
      n1576LegConveVersionCli = (boolean)((obj23.getgxTv_SdtLegajo_Legconveversioncli_N()==0)?false:true) ;
      n1603LegSitRevEgreso = (boolean)((obj23.getgxTv_SdtLegajo_Legsitrevegreso_N()==0)?false:true) ;
      n2182LegActClasNro = (boolean)((obj23.getgxTv_SdtLegajo_Legactclasnro_N()==0)?false:true) ;
      n2181LegPueAfiCod = (boolean)((obj23.getgxTv_SdtLegajo_Legpueaficod_N()==0)?false:true) ;
      n2263LegMigrWarn = (boolean)((obj23.getgxTv_SdtLegajo_Legmigrwarn_N()==0)?false:true) ;
      Gx_mode = obj23.getgxTv_SdtLegajo_Mode() ;
   }

   public void VarsToRow129( web.SdtLegajo_Salario obj129 )
   {
      obj129.setgxTv_SdtLegajo_Salario_Mode( Gx_mode );
      obj129.setgxTv_SdtLegajo_Salario_Legsuelfecha( A1136LegSuelFecha );
      obj129.setgxTv_SdtLegajo_Salario_Legsuelimporte( A1137LegSuelImporte );
      obj129.setgxTv_SdtLegajo_Salario_Legsueltipo( A2344LegSuelTipo );
      obj129.setgxTv_SdtLegajo_Salario_Legsuelcalc( A2347LegSuelCalc );
      obj129.setgxTv_SdtLegajo_Salario_Legsuellog( A2348LegSuelLog );
      obj129.setgxTv_SdtLegajo_Salario_Legsuelsec( A1135LegSuelSec );
      obj129.setgxTv_SdtLegajo_Salario_Legsuelsec_Z( Z1135LegSuelSec );
      obj129.setgxTv_SdtLegajo_Salario_Legsuelfecha_Z( Z1136LegSuelFecha );
      obj129.setgxTv_SdtLegajo_Salario_Legsuelimporte_Z( Z1137LegSuelImporte );
      obj129.setgxTv_SdtLegajo_Salario_Legsueltipo_Z( Z2344LegSuelTipo );
      obj129.setgxTv_SdtLegajo_Salario_Legsuelcalc_Z( Z2347LegSuelCalc );
      obj129.setgxTv_SdtLegajo_Salario_Legsueltipo_N( (byte)((byte)((n2344LegSuelTipo)?1:0)) );
      obj129.setgxTv_SdtLegajo_Salario_Modified( nIsMod_129 );
   }

   public void KeyVarsToRow129( web.SdtLegajo_Salario obj129 )
   {
      obj129.setgxTv_SdtLegajo_Salario_Legsuelsec( A1135LegSuelSec );
   }

   public void RowToVars129( web.SdtLegajo_Salario obj129 ,
                             int forceLoad )
   {
      Gx_mode = obj129.getgxTv_SdtLegajo_Salario_Mode() ;
      A1136LegSuelFecha = obj129.getgxTv_SdtLegajo_Salario_Legsuelfecha() ;
      A1137LegSuelImporte = obj129.getgxTv_SdtLegajo_Salario_Legsuelimporte() ;
      A2344LegSuelTipo = obj129.getgxTv_SdtLegajo_Salario_Legsueltipo() ;
      n2344LegSuelTipo = false ;
      A2347LegSuelCalc = obj129.getgxTv_SdtLegajo_Salario_Legsuelcalc() ;
      A2348LegSuelLog = obj129.getgxTv_SdtLegajo_Salario_Legsuellog() ;
      A1135LegSuelSec = obj129.getgxTv_SdtLegajo_Salario_Legsuelsec() ;
      Z1135LegSuelSec = obj129.getgxTv_SdtLegajo_Salario_Legsuelsec_Z() ;
      Z1136LegSuelFecha = obj129.getgxTv_SdtLegajo_Salario_Legsuelfecha_Z() ;
      Z1137LegSuelImporte = obj129.getgxTv_SdtLegajo_Salario_Legsuelimporte_Z() ;
      Z2344LegSuelTipo = obj129.getgxTv_SdtLegajo_Salario_Legsueltipo_Z() ;
      Z2347LegSuelCalc = obj129.getgxTv_SdtLegajo_Salario_Legsuelcalc_Z() ;
      n2344LegSuelTipo = (boolean)((obj129.getgxTv_SdtLegajo_Salario_Legsueltipo_N()==0)?false:true) ;
      nIsMod_129 = obj129.getgxTv_SdtLegajo_Salario_Modified() ;
   }

   public void VarsToRow292( web.SdtLegajo_Salario_Conceptos obj292 )
   {
      obj292.setgxTv_SdtLegajo_Salario_Conceptos_Mode( Gx_mode );
      obj292.setgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto( A2349LegSuelConcepto );
      obj292.setgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z( Z2349LegSuelConcepto );
      obj292.setgxTv_SdtLegajo_Salario_Conceptos_Modified( nIsMod_292 );
   }

   public void KeyVarsToRow292( web.SdtLegajo_Salario_Conceptos obj292 )
   {
      obj292.setgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto( A2349LegSuelConcepto );
   }

   public void RowToVars292( web.SdtLegajo_Salario_Conceptos obj292 ,
                             int forceLoad )
   {
      Gx_mode = obj292.getgxTv_SdtLegajo_Salario_Conceptos_Mode() ;
      A2349LegSuelConcepto = obj292.getgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto() ;
      Z2349LegSuelConcepto = obj292.getgxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z() ;
      nIsMod_292 = obj292.getgxTv_SdtLegajo_Salario_Conceptos_Modified() ;
   }

   public void VarsToRow24( web.SdtLegajo_Familia obj24 )
   {
      obj24.setgxTv_SdtLegajo_Familia_Mode( Gx_mode );
      obj24.setgxTv_SdtLegajo_Familia_Famnomape( A2090FamNomApe );
      obj24.setgxTv_SdtLegajo_Familia_Parcod( A30ParCod );
      obj24.setgxTv_SdtLegajo_Familia_Famfecnac( A209FamFecNac );
      obj24.setgxTv_SdtLegajo_Familia_Famdiscap( A205FamDiscap );
      obj24.setgxTv_SdtLegajo_Familia_Famnrodoc( A750FamNroDoc );
      obj24.setgxTv_SdtLegajo_Familia_Famadherente( A890FamAdherente );
      obj24.setgxTv_SdtLegajo_Familia_Guarcod( A1547GuarCod );
      obj24.setgxTv_SdtLegajo_Familia_Famtomadeducimpgan( A220FamTomaDeducImpGan );
      obj24.setgxTv_SdtLegajo_Familia_Legorden( A29LegOrden );
      obj24.setgxTv_SdtLegajo_Familia_Legorden_Z( Z29LegOrden );
      obj24.setgxTv_SdtLegajo_Familia_Famnomape_Z( Z2090FamNomApe );
      obj24.setgxTv_SdtLegajo_Familia_Parcod_Z( Z30ParCod );
      obj24.setgxTv_SdtLegajo_Familia_Famfecnac_Z( Z209FamFecNac );
      obj24.setgxTv_SdtLegajo_Familia_Famdiscap_Z( Z205FamDiscap );
      obj24.setgxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z( Z220FamTomaDeducImpGan );
      obj24.setgxTv_SdtLegajo_Familia_Famnrodoc_Z( Z750FamNroDoc );
      obj24.setgxTv_SdtLegajo_Familia_Famadherente_Z( Z890FamAdherente );
      obj24.setgxTv_SdtLegajo_Familia_Guarcod_Z( Z1547GuarCod );
      obj24.setgxTv_SdtLegajo_Familia_Famfecnac_N( (byte)((byte)((n209FamFecNac)?1:0)) );
      obj24.setgxTv_SdtLegajo_Familia_Famdiscap_N( (byte)((byte)((n205FamDiscap)?1:0)) );
      obj24.setgxTv_SdtLegajo_Familia_Guarcod_N( (byte)((byte)((n1547GuarCod)?1:0)) );
      obj24.setgxTv_SdtLegajo_Familia_Modified( nIsMod_24 );
   }

   public void KeyVarsToRow24( web.SdtLegajo_Familia obj24 )
   {
      obj24.setgxTv_SdtLegajo_Familia_Legorden( A29LegOrden );
   }

   public void RowToVars24( web.SdtLegajo_Familia obj24 ,
                            int forceLoad )
   {
      Gx_mode = obj24.getgxTv_SdtLegajo_Familia_Mode() ;
      A2090FamNomApe = obj24.getgxTv_SdtLegajo_Familia_Famnomape() ;
      A30ParCod = obj24.getgxTv_SdtLegajo_Familia_Parcod() ;
      A209FamFecNac = obj24.getgxTv_SdtLegajo_Familia_Famfecnac() ;
      n209FamFecNac = false ;
      A205FamDiscap = obj24.getgxTv_SdtLegajo_Familia_Famdiscap() ;
      n205FamDiscap = false ;
      A750FamNroDoc = obj24.getgxTv_SdtLegajo_Familia_Famnrodoc() ;
      A890FamAdherente = obj24.getgxTv_SdtLegajo_Familia_Famadherente() ;
      A1547GuarCod = obj24.getgxTv_SdtLegajo_Familia_Guarcod() ;
      n1547GuarCod = false ;
      A220FamTomaDeducImpGan = obj24.getgxTv_SdtLegajo_Familia_Famtomadeducimpgan() ;
      A29LegOrden = obj24.getgxTv_SdtLegajo_Familia_Legorden() ;
      Z29LegOrden = obj24.getgxTv_SdtLegajo_Familia_Legorden_Z() ;
      Z2090FamNomApe = obj24.getgxTv_SdtLegajo_Familia_Famnomape_Z() ;
      Z30ParCod = obj24.getgxTv_SdtLegajo_Familia_Parcod_Z() ;
      Z209FamFecNac = obj24.getgxTv_SdtLegajo_Familia_Famfecnac_Z() ;
      Z205FamDiscap = obj24.getgxTv_SdtLegajo_Familia_Famdiscap_Z() ;
      Z220FamTomaDeducImpGan = obj24.getgxTv_SdtLegajo_Familia_Famtomadeducimpgan_Z() ;
      Z750FamNroDoc = obj24.getgxTv_SdtLegajo_Familia_Famnrodoc_Z() ;
      Z890FamAdherente = obj24.getgxTv_SdtLegajo_Familia_Famadherente_Z() ;
      Z1547GuarCod = obj24.getgxTv_SdtLegajo_Familia_Guarcod_Z() ;
      n209FamFecNac = (boolean)((obj24.getgxTv_SdtLegajo_Familia_Famfecnac_N()==0)?false:true) ;
      n205FamDiscap = (boolean)((obj24.getgxTv_SdtLegajo_Familia_Famdiscap_N()==0)?false:true) ;
      n1547GuarCod = (boolean)((obj24.getgxTv_SdtLegajo_Familia_Guarcod_N()==0)?false:true) ;
      nIsMod_24 = obj24.getgxTv_SdtLegajo_Familia_Modified() ;
   }

   public void VarsToRow170( web.SdtLegajo_tipos_de_trabajo obj170 )
   {
      obj170.setgxTv_SdtLegajo_tipos_de_trabajo_Mode( Gx_mode );
      obj170.setgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra( A1319LegTipoTra );
      obj170.setgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z( Z1319LegTipoTra );
      obj170.setgxTv_SdtLegajo_tipos_de_trabajo_Modified( nIsMod_170 );
   }

   public void KeyVarsToRow170( web.SdtLegajo_tipos_de_trabajo obj170 )
   {
      obj170.setgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra( A1319LegTipoTra );
   }

   public void RowToVars170( web.SdtLegajo_tipos_de_trabajo obj170 ,
                             int forceLoad )
   {
      Gx_mode = obj170.getgxTv_SdtLegajo_tipos_de_trabajo_Mode() ;
      A1319LegTipoTra = obj170.getgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra() ;
      Z1319LegTipoTra = obj170.getgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z() ;
      nIsMod_170 = obj170.getgxTv_SdtLegajo_tipos_de_trabajo_Modified() ;
   }

   public void VarsToRow276( web.SdtLegajo_Propiedades obj276 )
   {
      obj276.setgxTv_SdtLegajo_Propiedades_Mode( Gx_mode );
      obj276.setgxTv_SdtLegajo_Propiedades_Legpropdes( A2231LegPropDes );
      obj276.setgxTv_SdtLegajo_Propiedades_Legproptd( A2232LegPropTD );
      obj276.setgxTv_SdtLegajo_Propiedades_Legpropvalnum( A2233LegPropValNum );
      obj276.setgxTv_SdtLegajo_Propiedades_Legpropvalbool( A2234LegPropValBool );
      obj276.setgxTv_SdtLegajo_Propiedades_Legpropvalstr( A2235LegPropValStr );
      obj276.setgxTv_SdtLegajo_Propiedades_Legpropvaldate( A2236LegPropValDate );
      obj276.setgxTv_SdtLegajo_Propiedades_Legpropcod( A2230LegPropCod );
      obj276.setgxTv_SdtLegajo_Propiedades_Legpropcod_Z( Z2230LegPropCod );
      obj276.setgxTv_SdtLegajo_Propiedades_Legpropdes_Z( Z2231LegPropDes );
      obj276.setgxTv_SdtLegajo_Propiedades_Legproptd_Z( Z2232LegPropTD );
      obj276.setgxTv_SdtLegajo_Propiedades_Legpropvalnum_Z( Z2233LegPropValNum );
      obj276.setgxTv_SdtLegajo_Propiedades_Legpropvalbool_Z( Z2234LegPropValBool );
      obj276.setgxTv_SdtLegajo_Propiedades_Legpropvalstr_Z( Z2235LegPropValStr );
      obj276.setgxTv_SdtLegajo_Propiedades_Legpropvaldate_Z( Z2236LegPropValDate );
      obj276.setgxTv_SdtLegajo_Propiedades_Modified( nIsMod_276 );
   }

   public void KeyVarsToRow276( web.SdtLegajo_Propiedades obj276 )
   {
      obj276.setgxTv_SdtLegajo_Propiedades_Legpropcod( A2230LegPropCod );
   }

   public void RowToVars276( web.SdtLegajo_Propiedades obj276 ,
                             int forceLoad )
   {
      Gx_mode = obj276.getgxTv_SdtLegajo_Propiedades_Mode() ;
      A2231LegPropDes = obj276.getgxTv_SdtLegajo_Propiedades_Legpropdes() ;
      A2232LegPropTD = obj276.getgxTv_SdtLegajo_Propiedades_Legproptd() ;
      A2233LegPropValNum = obj276.getgxTv_SdtLegajo_Propiedades_Legpropvalnum() ;
      A2234LegPropValBool = obj276.getgxTv_SdtLegajo_Propiedades_Legpropvalbool() ;
      A2235LegPropValStr = obj276.getgxTv_SdtLegajo_Propiedades_Legpropvalstr() ;
      A2236LegPropValDate = obj276.getgxTv_SdtLegajo_Propiedades_Legpropvaldate() ;
      A2230LegPropCod = obj276.getgxTv_SdtLegajo_Propiedades_Legpropcod() ;
      Z2230LegPropCod = obj276.getgxTv_SdtLegajo_Propiedades_Legpropcod_Z() ;
      Z2231LegPropDes = obj276.getgxTv_SdtLegajo_Propiedades_Legpropdes_Z() ;
      Z2232LegPropTD = obj276.getgxTv_SdtLegajo_Propiedades_Legproptd_Z() ;
      Z2233LegPropValNum = obj276.getgxTv_SdtLegajo_Propiedades_Legpropvalnum_Z() ;
      Z2234LegPropValBool = obj276.getgxTv_SdtLegajo_Propiedades_Legpropvalbool_Z() ;
      Z2235LegPropValStr = obj276.getgxTv_SdtLegajo_Propiedades_Legpropvalstr_Z() ;
      Z2236LegPropValDate = obj276.getgxTv_SdtLegajo_Propiedades_Legpropvaldate_Z() ;
      nIsMod_276 = obj276.getgxTv_SdtLegajo_Propiedades_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A6LegNumero = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0P23( ) ;
      scanKeyStart0P23( ) ;
      if ( RcdFound23 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000P152 */
         pr_default.execute(150, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(150) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         A45TipEmpleCod = BC000P152_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC000P152_n45TipEmpleCod[0] ;
         A1965EmpOsoCod = BC000P152_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC000P152_n1965EmpOsoCod[0] ;
         A2EmpNom = BC000P152_A2EmpNom[0] ;
         pr_default.close(150);
         /* Using cursor BC000P153 */
         pr_default.execute(151, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod});
         if ( (pr_default.getStatus(151) == 101) )
         {
            if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1965EmpOsoCod)==0) ) )
            {
               httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Obra Social", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPOSOCOD");
               AnyError = (short)(1) ;
            }
         }
         A307OsoDescrip = BC000P153_A307OsoDescrip[0] ;
         n307OsoDescrip = BC000P153_n307OsoDescrip[0] ;
         A306OsoC3992 = BC000P153_A306OsoC3992[0] ;
         n306OsoC3992 = BC000P153_n306OsoC3992[0] ;
         pr_default.close(151);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
      }
      zm0P23( -32) ;
      onLoadActions0P23( ) ;
      addRow0P23( ) ;
      bcLegajo.getgxTv_SdtLegajo_Salario().clearCollection();
      if ( RcdFound23 == 1 )
      {
         scanKeyStart0P129( ) ;
         nGXsfl_129_idx = 1 ;
         while ( RcdFound129 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z1135LegSuelSec = A1135LegSuelSec ;
            zm0P129( -57) ;
            onLoadActions0P129( ) ;
            nRcdExists_129 = (short)(1) ;
            nIsMod_129 = (short)(0) ;
            addRow0P129( ) ;
            ((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx)).getgxTv_SdtLegajo_Salario_Conceptos().clearCollection();
            if ( RcdFound129 == 1 )
            {
               scanKeyStart0P292( ) ;
               nGXsfl_292_idx = 1 ;
               while ( RcdFound292 != 0 )
               {
                  Z3CliCod = A3CliCod ;
                  Z1EmpCod = A1EmpCod ;
                  Z6LegNumero = A6LegNumero ;
                  Z1135LegSuelSec = A1135LegSuelSec ;
                  Z2349LegSuelConcepto = A2349LegSuelConcepto ;
                  zm0P292( -58) ;
                  onLoadActions0P292( ) ;
                  nRcdExists_292 = (short)(1) ;
                  nIsMod_292 = (short)(0) ;
                  addRow0P292( ) ;
                  nGXsfl_292_idx = (int)(nGXsfl_292_idx+1) ;
                  scanKeyNext0P292( ) ;
               }
               scanKeyEnd0P292( ) ;
            }
            nGXsfl_129_idx = (int)(nGXsfl_129_idx+1) ;
            scanKeyNext0P129( ) ;
         }
         scanKeyEnd0P129( ) ;
      }
      bcLegajo.getgxTv_SdtLegajo_Familia().clearCollection();
      if ( RcdFound23 == 1 )
      {
         scanKeyStart0P24( ) ;
         nGXsfl_24_idx = 1 ;
         while ( RcdFound24 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z29LegOrden = A29LegOrden ;
            zm0P24( -60) ;
            onLoadActions0P24( ) ;
            nRcdExists_24 = (short)(1) ;
            nIsMod_24 = (short)(0) ;
            addRow0P24( ) ;
            nGXsfl_24_idx = (int)(nGXsfl_24_idx+1) ;
            scanKeyNext0P24( ) ;
         }
         scanKeyEnd0P24( ) ;
      }
      bcLegajo.getgxTv_SdtLegajo_Tipos_de_trabajo().clearCollection();
      if ( RcdFound23 == 1 )
      {
         scanKeyStart0P170( ) ;
         nGXsfl_170_idx = 1 ;
         while ( RcdFound170 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z1319LegTipoTra = A1319LegTipoTra ;
            zm0P170( -63) ;
            onLoadActions0P170( ) ;
            nRcdExists_170 = (short)(1) ;
            nIsMod_170 = (short)(0) ;
            addRow0P170( ) ;
            nGXsfl_170_idx = (int)(nGXsfl_170_idx+1) ;
            scanKeyNext0P170( ) ;
         }
         scanKeyEnd0P170( ) ;
      }
      bcLegajo.getgxTv_SdtLegajo_Propiedades().clearCollection();
      if ( RcdFound23 == 1 )
      {
         scanKeyStart0P276( ) ;
         nGXsfl_276_idx = 1 ;
         while ( RcdFound276 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z2230LegPropCod = A2230LegPropCod ;
            zm0P276( -65) ;
            onLoadActions0P276( ) ;
            nRcdExists_276 = (short)(1) ;
            nIsMod_276 = (short)(0) ;
            addRow0P276( ) ;
            nGXsfl_276_idx = (int)(nGXsfl_276_idx+1) ;
            scanKeyNext0P276( ) ;
         }
         scanKeyEnd0P276( ) ;
      }
      scanKeyEnd0P23( ) ;
      if ( RcdFound23 == 0 )
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
      RowToVars23( bcLegajo, 0) ;
      scanKeyStart0P23( ) ;
      if ( RcdFound23 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000P154 */
         pr_default.execute(152, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(152) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         A45TipEmpleCod = BC000P154_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC000P154_n45TipEmpleCod[0] ;
         A1965EmpOsoCod = BC000P154_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC000P154_n1965EmpOsoCod[0] ;
         A2EmpNom = BC000P154_A2EmpNom[0] ;
         pr_default.close(152);
         /* Using cursor BC000P155 */
         pr_default.execute(153, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod});
         if ( (pr_default.getStatus(153) == 101) )
         {
            if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1965EmpOsoCod)==0) ) )
            {
               httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Obra Social", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPOSOCOD");
               AnyError = (short)(1) ;
            }
         }
         A307OsoDescrip = BC000P155_A307OsoDescrip[0] ;
         n307OsoDescrip = BC000P155_n307OsoDescrip[0] ;
         A306OsoC3992 = BC000P155_A306OsoC3992[0] ;
         n306OsoC3992 = BC000P155_n306OsoC3992[0] ;
         pr_default.close(153);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
      }
      zm0P23( -32) ;
      onLoadActions0P23( ) ;
      addRow0P23( ) ;
      bcLegajo.getgxTv_SdtLegajo_Salario().clearCollection();
      if ( RcdFound23 == 1 )
      {
         scanKeyStart0P129( ) ;
         nGXsfl_129_idx = 1 ;
         while ( RcdFound129 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z1135LegSuelSec = A1135LegSuelSec ;
            zm0P129( -57) ;
            onLoadActions0P129( ) ;
            nRcdExists_129 = (short)(1) ;
            nIsMod_129 = (short)(0) ;
            addRow0P129( ) ;
            ((web.SdtLegajo_Salario)bcLegajo.getgxTv_SdtLegajo_Salario().elementAt(-1+nGXsfl_129_idx)).getgxTv_SdtLegajo_Salario_Conceptos().clearCollection();
            if ( RcdFound129 == 1 )
            {
               scanKeyStart0P292( ) ;
               nGXsfl_292_idx = 1 ;
               while ( RcdFound292 != 0 )
               {
                  Z3CliCod = A3CliCod ;
                  Z1EmpCod = A1EmpCod ;
                  Z6LegNumero = A6LegNumero ;
                  Z1135LegSuelSec = A1135LegSuelSec ;
                  Z2349LegSuelConcepto = A2349LegSuelConcepto ;
                  zm0P292( -58) ;
                  onLoadActions0P292( ) ;
                  nRcdExists_292 = (short)(1) ;
                  nIsMod_292 = (short)(0) ;
                  addRow0P292( ) ;
                  nGXsfl_292_idx = (int)(nGXsfl_292_idx+1) ;
                  scanKeyNext0P292( ) ;
               }
               scanKeyEnd0P292( ) ;
            }
            nGXsfl_129_idx = (int)(nGXsfl_129_idx+1) ;
            scanKeyNext0P129( ) ;
         }
         scanKeyEnd0P129( ) ;
      }
      bcLegajo.getgxTv_SdtLegajo_Familia().clearCollection();
      if ( RcdFound23 == 1 )
      {
         scanKeyStart0P24( ) ;
         nGXsfl_24_idx = 1 ;
         while ( RcdFound24 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z29LegOrden = A29LegOrden ;
            zm0P24( -60) ;
            onLoadActions0P24( ) ;
            nRcdExists_24 = (short)(1) ;
            nIsMod_24 = (short)(0) ;
            addRow0P24( ) ;
            nGXsfl_24_idx = (int)(nGXsfl_24_idx+1) ;
            scanKeyNext0P24( ) ;
         }
         scanKeyEnd0P24( ) ;
      }
      bcLegajo.getgxTv_SdtLegajo_Tipos_de_trabajo().clearCollection();
      if ( RcdFound23 == 1 )
      {
         scanKeyStart0P170( ) ;
         nGXsfl_170_idx = 1 ;
         while ( RcdFound170 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z1319LegTipoTra = A1319LegTipoTra ;
            zm0P170( -63) ;
            onLoadActions0P170( ) ;
            nRcdExists_170 = (short)(1) ;
            nIsMod_170 = (short)(0) ;
            addRow0P170( ) ;
            nGXsfl_170_idx = (int)(nGXsfl_170_idx+1) ;
            scanKeyNext0P170( ) ;
         }
         scanKeyEnd0P170( ) ;
      }
      bcLegajo.getgxTv_SdtLegajo_Propiedades().clearCollection();
      if ( RcdFound23 == 1 )
      {
         scanKeyStart0P276( ) ;
         nGXsfl_276_idx = 1 ;
         while ( RcdFound276 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z2230LegPropCod = A2230LegPropCod ;
            zm0P276( -65) ;
            onLoadActions0P276( ) ;
            nRcdExists_276 = (short)(1) ;
            nIsMod_276 = (short)(0) ;
            addRow0P276( ) ;
            nGXsfl_276_idx = (int)(nGXsfl_276_idx+1) ;
            scanKeyNext0P276( ) ;
         }
         scanKeyEnd0P276( ) ;
      }
      scanKeyEnd0P23( ) ;
      if ( RcdFound23 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0P23( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0P23( ) ;
      }
      else
      {
         if ( RcdFound23 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A6LegNumero = Z6LegNumero ;
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
               update0P23( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) )
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
                     insert0P23( ) ;
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
                     insert0P23( ) ;
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
      RowToVars23( bcLegajo, 1) ;
      saveImpl( ) ;
      VarsToRow23( bcLegajo) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars23( bcLegajo, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0P23( ) ;
      afterTrn( ) ;
      VarsToRow23( bcLegajo) ;
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
         web.SdtLegajo auxBC = new web.SdtLegajo( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A6LegNumero);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcLegajo);
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
      RowToVars23( bcLegajo, 1) ;
      updateImpl( ) ;
      VarsToRow23( bcLegajo) ;
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
      RowToVars23( bcLegajo, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0P23( ) ;
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
      VarsToRow23( bcLegajo) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars23( bcLegajo, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0P23( ) ;
      if ( RcdFound23 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A6LegNumero = Z6LegNumero ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "legajo_bc");
      VarsToRow23( bcLegajo) ;
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
      Gx_mode = bcLegajo.getgxTv_SdtLegajo_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcLegajo.setgxTv_SdtLegajo_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtLegajo sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcLegajo )
      {
         bcLegajo = sdt ;
         if ( GXutil.strcmp(bcLegajo.getgxTv_SdtLegajo_Mode(), "") == 0 )
         {
            bcLegajo.setgxTv_SdtLegajo_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow23( bcLegajo) ;
         }
         else
         {
            RowToVars23( bcLegajo, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcLegajo.getgxTv_SdtLegajo_Mode(), "") == 0 )
         {
            bcLegajo.setgxTv_SdtLegajo_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars23( bcLegajo, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtLegajo getLegajo_BC( )
   {
      return bcLegajo ;
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
      sMode23 = "" ;
      sMode129 = "" ;
      AV141Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV33TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV120Insert_LegMegCodigo = "" ;
      AV119Insert_LegSecCodigo = "" ;
      AV114Insert_LegLpgCodigo = "" ;
      AV115Insert_LegBanCod = "" ;
      AV106Insert_LegSinCod = "" ;
      AV116Insert_LegOsoCod = "" ;
      AV25Insert_LegActCodigo = "" ;
      AV26Insert_MprCod = "" ;
      AV28Insert_ZonCod = "" ;
      AV31Insert_SinieCodigo = "" ;
      AV117Insert_LegPuesCodigo = "" ;
      AV118Insert_LegSucCodigo = "" ;
      AV136Insert_LegPueAfiCod = "" ;
      Z250LegIdNomApe = "" ;
      A250LegIdNomApe = "" ;
      Z591LegNomApe = "" ;
      A591LegNomApe = "" ;
      Z247LegFecUltMod = GXutil.nullDate() ;
      A247LegFecUltMod = GXutil.nullDate() ;
      Z230LegApellido = "" ;
      A230LegApellido = "" ;
      Z251LegNombre = "" ;
      A251LegNombre = "" ;
      Z257LegNumDoc = "" ;
      A257LegNumDoc = "" ;
      Z246LegFecNac = GXutil.nullDate() ;
      A246LegFecNac = GXutil.nullDate() ;
      Z242LegDomici = "" ;
      A242LegDomici = "" ;
      Z479LegEmail = "" ;
      A479LegEmail = "" ;
      Z236LegCodPos = "" ;
      A236LegCodPos = "" ;
      Z265LegTelefono = "" ;
      A265LegTelefono = "" ;
      Z245LegFecIngreso = GXutil.nullDate() ;
      A245LegFecIngreso = GXutil.nullDate() ;
      Z244LegFecEgreso = GXutil.nullDate() ;
      A244LegFecEgreso = GXutil.nullDate() ;
      Z939LegCatCodigo = "" ;
      A939LegCatCodigo = "" ;
      Z231LegBanSuc = "" ;
      A231LegBanSuc = "" ;
      Z232LegBanTipCuen = "" ;
      A232LegBanTipCuen = "" ;
      Z238LegCuentaBanc = "" ;
      A238LegCuentaBanc = "" ;
      Z253LegLicInicio = GXutil.nullDate() ;
      A253LegLicInicio = GXutil.nullDate() ;
      Z252LegLicFinal = GXutil.nullDate() ;
      A252LegLicFinal = GXutil.nullDate() ;
      Z234LegCBU = "" ;
      A234LegCBU = "" ;
      Z264LegSueldoFuera = DecimalUtil.ZERO ;
      A264LegSueldoFuera = DecimalUtil.ZERO ;
      Z93LegId = "" ;
      A93LegId = "" ;
      Z937LegConveCodigo = "" ;
      A937LegConveCodigo = "" ;
      Z630LegFecImportacion = GXutil.resetTime( GXutil.nullDate() );
      A630LegFecImportacion = GXutil.resetTime( GXutil.nullDate() );
      Z879LegContinua = "" ;
      A879LegContinua = "" ;
      Z1023LegHorasDia = DecimalUtil.ZERO ;
      A1023LegHorasDia = DecimalUtil.ZERO ;
      Z1268LegHorasSem = DecimalUtil.ZERO ;
      A1268LegHorasSem = DecimalUtil.ZERO ;
      Z1531LegFecPreAviso = GXutil.nullDate() ;
      A1531LegFecPreAviso = GXutil.nullDate() ;
      Z1759LegPromDias = "" ;
      A1759LegPromDias = "" ;
      Z1804LegTitulo = "" ;
      A1804LegTitulo = "" ;
      Z2404LegModTra = "" ;
      A2404LegModTra = "" ;
      Z2417LegTipoTarifa = "" ;
      A2417LegTipoTarifa = "" ;
      Z1582LegBanCod = "" ;
      A1582LegBanCod = "" ;
      Z1581LegLpgCodigo = "" ;
      A1581LegLpgCodigo = "" ;
      Z1583LegMegCodigo = "" ;
      A1583LegMegCodigo = "" ;
      Z1580LegOsoCod = "" ;
      A1580LegOsoCod = "" ;
      Z1579LegSecCodigo = "" ;
      A1579LegSecCodigo = "" ;
      Z1577LegSucCodigo = "" ;
      A1577LegSucCodigo = "" ;
      Z1578LegPuesCodigo = "" ;
      A1578LegPuesCodigo = "" ;
      Z18MprCod = "" ;
      A18MprCod = "" ;
      Z20ZonCod = "" ;
      A20ZonCod = "" ;
      Z19SinieCodigo = "" ;
      A19SinieCodigo = "" ;
      Z910LegSinCod = "" ;
      A910LegSinCod = "" ;
      Z15LegActCodigo = "" ;
      A15LegActCodigo = "" ;
      Z2181LegPueAfiCod = "" ;
      A2181LegPueAfiCod = "" ;
      Z1235LegReligion = "" ;
      A1235LegReligion = "" ;
      Z1236LegOrigen = "" ;
      A1236LegOrigen = "" ;
      Z233LegBasico = DecimalUtil.ZERO ;
      A233LegBasico = DecimalUtil.ZERO ;
      Z2224LegBanDes = "" ;
      A2224LegBanDes = "" ;
      Z291LpgDescri = "" ;
      A291LpgDescri = "" ;
      Z300MegDescrip = "" ;
      A300MegDescrip = "" ;
      Z2225LegOsoDes = "" ;
      A2225LegOsoDes = "" ;
      Z2226LegOsoAfipCod = "" ;
      A2226LegOsoAfipCod = "" ;
      Z392OsoSigla = "" ;
      A392OsoSigla = "" ;
      Z329SecDescrip = "" ;
      A329SecDescrip = "" ;
      Z1965EmpOsoCod = "" ;
      A1965EmpOsoCod = "" ;
      Z2EmpNom = "" ;
      A2EmpNom = "" ;
      Z45TipEmpleCod = "" ;
      A45TipEmpleCod = "" ;
      Z684MprDescripSinAc = "" ;
      A684MprDescripSinAc = "" ;
      Z303MprDescrip = "" ;
      A303MprDescrip = "" ;
      Z678ZonDescripSinAc = "" ;
      A678ZonDescripSinAc = "" ;
      Z342ZonDescrip = "" ;
      A342ZonDescrip = "" ;
      Z343ZonPorcReduc = DecimalUtil.ZERO ;
      A343ZonPorcReduc = DecimalUtil.ZERO ;
      Z686CondiDescriSinAc = "" ;
      A686CondiDescriSinAc = "" ;
      Z144CondiDescri = "" ;
      A144CondiDescri = "" ;
      Z688SinieDescriSinAc = "" ;
      A688SinieDescriSinAc = "" ;
      Z333SinieDescri = "" ;
      A333SinieDescri = "" ;
      Z258LegPaiNom = "" ;
      A258LegPaiNom = "" ;
      Z260LegProvNom = "" ;
      A260LegProvNom = "" ;
      Z255LegLocNom = "" ;
      A255LegLocNom = "" ;
      Z256LegNacionalidad = "" ;
      A256LegNacionalidad = "" ;
      Z331SinDescrip = "" ;
      A331SinDescrip = "" ;
      Z227LegActDescri = "" ;
      A227LegActDescri = "" ;
      Z307OsoDescrip = "" ;
      A307OsoDescrip = "" ;
      Z306OsoC3992 = "" ;
      A306OsoC3992 = "" ;
      Z249LegFoto = "" ;
      A249LegFoto = "" ;
      Z515LegObs = "" ;
      A515LegObs = "" ;
      Z2263LegMigrWarn = "" ;
      A2263LegMigrWarn = "" ;
      Z1031LegFotoExt = "" ;
      A1031LegFotoExt = "" ;
      Z1030LegFotoNom = "" ;
      A1030LegFotoNom = "" ;
      BC000P43_A19SinieCodigo = new String[] {""} ;
      BC000P43_n19SinieCodigo = new boolean[] {false} ;
      BC000P43_A263LegSexo = new byte[1] ;
      BC000P43_n263LegSexo = new boolean[] {false} ;
      BC000P43_A243LegEstadoCivil = new short[1] ;
      BC000P43_n243LegEstadoCivil = new boolean[] {false} ;
      BC000P43_A22LegPaiCod = new short[1] ;
      BC000P43_n22LegPaiCod = new boolean[] {false} ;
      BC000P43_A23LegProvCod = new short[1] ;
      BC000P43_n23LegProvCod = new boolean[] {false} ;
      BC000P43_A24LegLocCod = new short[1] ;
      BC000P43_n24LegLocCod = new boolean[] {false} ;
      BC000P43_A21LegNacionCod = new short[1] ;
      BC000P43_n21LegNacionCod = new boolean[] {false} ;
      BC000P43_A910LegSinCod = new String[] {""} ;
      BC000P43_n910LegSinCod = new boolean[] {false} ;
      BC000P43_A2182LegActClasNro = new int[1] ;
      BC000P43_n2182LegActClasNro = new boolean[] {false} ;
      BC000P43_A15LegActCodigo = new String[] {""} ;
      BC000P43_n15LegActCodigo = new boolean[] {false} ;
      BC000P43_A1603LegSitRevEgreso = new short[1] ;
      BC000P43_n1603LegSitRevEgreso = new boolean[] {false} ;
      BC000P43_A2181LegPueAfiCod = new String[] {""} ;
      BC000P43_n2181LegPueAfiCod = new boolean[] {false} ;
      BC000P43_A45TipEmpleCod = new String[] {""} ;
      BC000P43_n45TipEmpleCod = new boolean[] {false} ;
      BC000P43_A1235LegReligion = new String[] {""} ;
      BC000P43_n1235LegReligion = new boolean[] {false} ;
      BC000P43_A1236LegOrigen = new String[] {""} ;
      BC000P43_n1236LegOrigen = new boolean[] {false} ;
      BC000P43_A1965EmpOsoCod = new String[] {""} ;
      BC000P43_n1965EmpOsoCod = new boolean[] {false} ;
      BC000P43_A237LegConvenio = new boolean[] {false} ;
      BC000P43_A688SinieDescriSinAc = new String[] {""} ;
      BC000P43_A686CondiDescriSinAc = new String[] {""} ;
      BC000P43_A678ZonDescripSinAc = new String[] {""} ;
      BC000P43_A684MprDescripSinAc = new String[] {""} ;
      BC000P43_A250LegIdNomApe = new String[] {""} ;
      BC000P43_A591LegNomApe = new String[] {""} ;
      BC000P43_A6LegNumero = new int[1] ;
      BC000P43_A247LegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P43_A2EmpNom = new String[] {""} ;
      BC000P43_A230LegApellido = new String[] {""} ;
      BC000P43_A251LegNombre = new String[] {""} ;
      BC000P43_A249LegFoto = new String[] {""} ;
      BC000P43_n249LegFoto = new boolean[] {false} ;
      BC000P43_A266LegTipDoc = new byte[1] ;
      BC000P43_A257LegNumDoc = new String[] {""} ;
      BC000P43_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P43_A256LegNacionalidad = new String[] {""} ;
      BC000P43_A239LegCUIL = new long[1] ;
      BC000P43_A241LegDiscapacidad = new byte[1] ;
      BC000P43_A242LegDomici = new String[] {""} ;
      BC000P43_A479LegEmail = new String[] {""} ;
      BC000P43_A236LegCodPos = new String[] {""} ;
      BC000P43_A258LegPaiNom = new String[] {""} ;
      BC000P43_A260LegProvNom = new String[] {""} ;
      BC000P43_A255LegLocNom = new String[] {""} ;
      BC000P43_A265LegTelefono = new String[] {""} ;
      BC000P43_n265LegTelefono = new boolean[] {false} ;
      BC000P43_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P43_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P43_n244LegFecEgreso = new boolean[] {false} ;
      BC000P43_A300MegDescrip = new String[] {""} ;
      BC000P43_n300MegDescrip = new boolean[] {false} ;
      BC000P43_A939LegCatCodigo = new String[] {""} ;
      BC000P43_n939LegCatCodigo = new boolean[] {false} ;
      BC000P43_A2215LegCatPueCod = new int[1] ;
      BC000P43_n2215LegCatPueCod = new boolean[] {false} ;
      BC000P43_A329SecDescrip = new String[] {""} ;
      BC000P43_n329SecDescrip = new boolean[] {false} ;
      BC000P43_A291LpgDescri = new String[] {""} ;
      BC000P43_n291LpgDescri = new boolean[] {false} ;
      BC000P43_A235LegClase = new byte[1] ;
      BC000P43_A248LegFormaPago = new byte[1] ;
      BC000P43_A2224LegBanDes = new String[] {""} ;
      BC000P43_A231LegBanSuc = new String[] {""} ;
      BC000P43_n231LegBanSuc = new boolean[] {false} ;
      BC000P43_A232LegBanTipCuen = new String[] {""} ;
      BC000P43_n232LegBanTipCuen = new boolean[] {false} ;
      BC000P43_A331SinDescrip = new String[] {""} ;
      BC000P43_n331SinDescrip = new boolean[] {false} ;
      BC000P43_A2225LegOsoDes = new String[] {""} ;
      BC000P43_A2226LegOsoAfipCod = new String[] {""} ;
      BC000P43_n2226LegOsoAfipCod = new boolean[] {false} ;
      BC000P43_A307OsoDescrip = new String[] {""} ;
      BC000P43_n307OsoDescrip = new boolean[] {false} ;
      BC000P43_A227LegActDescri = new String[] {""} ;
      BC000P43_A303MprDescrip = new String[] {""} ;
      BC000P43_A238LegCuentaBanc = new String[] {""} ;
      BC000P43_n238LegCuentaBanc = new boolean[] {false} ;
      BC000P43_A253LegLicInicio = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P43_n253LegLicInicio = new boolean[] {false} ;
      BC000P43_A252LegLicFinal = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P43_n252LegLicFinal = new boolean[] {false} ;
      BC000P43_A342ZonDescrip = new String[] {""} ;
      BC000P43_A343ZonPorcReduc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P43_A234LegCBU = new String[] {""} ;
      BC000P43_n234LegCBU = new boolean[] {false} ;
      BC000P43_A262LegSCVO = new boolean[] {false} ;
      BC000P43_A144CondiDescri = new String[] {""} ;
      BC000P43_A333SinieDescri = new String[] {""} ;
      BC000P43_A228LegActivo = new boolean[] {false} ;
      BC000P43_A264LegSueldoFuera = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P43_A93LegId = new String[] {""} ;
      BC000P43_n93LegId = new boolean[] {false} ;
      BC000P43_A937LegConveCodigo = new String[] {""} ;
      BC000P43_n937LegConveCodigo = new boolean[] {false} ;
      BC000P43_A306OsoC3992 = new String[] {""} ;
      BC000P43_n306OsoC3992 = new boolean[] {false} ;
      BC000P43_A515LegObs = new String[] {""} ;
      BC000P43_A630LegFecImportacion = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P43_A877LegAgenReten = new boolean[] {false} ;
      BC000P43_A879LegContinua = new String[] {""} ;
      BC000P43_A942LegRecalcLiq = new boolean[] {false} ;
      BC000P43_A1016LegJubilado = new boolean[] {false} ;
      BC000P43_A1023LegHorasDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P43_A1268LegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P43_A1245LegTrabLun = new boolean[] {false} ;
      BC000P43_A1246LegTrabMar = new boolean[] {false} ;
      BC000P43_A1247LegTrabMie = new boolean[] {false} ;
      BC000P43_A1248LegTrabJue = new boolean[] {false} ;
      BC000P43_A1249LegTrabVie = new boolean[] {false} ;
      BC000P43_A1250LegTrabSa = new boolean[] {false} ;
      BC000P43_A1251LegTrabDo = new boolean[] {false} ;
      BC000P43_A1523LegVacPend = new short[1] ;
      BC000P43_A1531LegFecPreAviso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P43_A1576LegConveVersionCli = new int[1] ;
      BC000P43_n1576LegConveVersionCli = new boolean[] {false} ;
      BC000P43_A1759LegPromDias = new String[] {""} ;
      BC000P43_A1804LegTitulo = new String[] {""} ;
      BC000P43_A1818LegEstado = new byte[1] ;
      BC000P43_A2263LegMigrWarn = new String[] {""} ;
      BC000P43_n2263LegMigrWarn = new boolean[] {false} ;
      BC000P43_A2267LegIncompleto = new boolean[] {false} ;
      BC000P43_A2309LegLiqApo = new boolean[] {false} ;
      BC000P43_A2404LegModTra = new String[] {""} ;
      BC000P43_A2417LegTipoTarifa = new String[] {""} ;
      BC000P43_A1031LegFotoExt = new String[] {""} ;
      BC000P43_A1030LegFotoNom = new String[] {""} ;
      BC000P43_A392OsoSigla = new String[] {""} ;
      BC000P43_n392OsoSigla = new boolean[] {false} ;
      BC000P43_A3CliCod = new int[1] ;
      BC000P43_A1582LegBanCod = new String[] {""} ;
      BC000P43_n1582LegBanCod = new boolean[] {false} ;
      BC000P43_A1581LegLpgCodigo = new String[] {""} ;
      BC000P43_n1581LegLpgCodigo = new boolean[] {false} ;
      BC000P43_A1583LegMegCodigo = new String[] {""} ;
      BC000P43_n1583LegMegCodigo = new boolean[] {false} ;
      BC000P43_A1580LegOsoCod = new String[] {""} ;
      BC000P43_n1580LegOsoCod = new boolean[] {false} ;
      BC000P43_A1579LegSecCodigo = new String[] {""} ;
      BC000P43_n1579LegSecCodigo = new boolean[] {false} ;
      BC000P43_A1EmpCod = new short[1] ;
      BC000P43_A1577LegSucCodigo = new String[] {""} ;
      BC000P43_n1577LegSucCodigo = new boolean[] {false} ;
      BC000P43_A1578LegPuesCodigo = new String[] {""} ;
      BC000P43_n1578LegPuesCodigo = new boolean[] {false} ;
      BC000P43_A18MprCod = new String[] {""} ;
      BC000P43_n18MprCod = new boolean[] {false} ;
      BC000P43_A20ZonCod = new String[] {""} ;
      BC000P43_n20ZonCod = new boolean[] {false} ;
      BC000P43_A17CondiCodigo = new short[1] ;
      BC000P43_n17CondiCodigo = new boolean[] {false} ;
      A249LegFoto_Filetype = "" ;
      A249LegFoto_Filename = "" ;
      A677LpgDescriSinAc = "" ;
      A675SecDescripSinAc = "" ;
      A681OsoDescripSinAc = "" ;
      A555OsoSiglaYDesc = "" ;
      A680SinDescripSinAc = "" ;
      BC000P44_A2224LegBanDes = new String[] {""} ;
      BC000P45_A291LpgDescri = new String[] {""} ;
      BC000P45_n291LpgDescri = new boolean[] {false} ;
      BC000P46_A300MegDescrip = new String[] {""} ;
      BC000P46_n300MegDescrip = new boolean[] {false} ;
      BC000P47_A2225LegOsoDes = new String[] {""} ;
      BC000P47_A2226LegOsoAfipCod = new String[] {""} ;
      BC000P47_n2226LegOsoAfipCod = new boolean[] {false} ;
      BC000P47_A392OsoSigla = new String[] {""} ;
      BC000P47_n392OsoSigla = new boolean[] {false} ;
      BC000P48_A329SecDescrip = new String[] {""} ;
      BC000P48_n329SecDescrip = new boolean[] {false} ;
      BC000P49_A3CliCod = new int[1] ;
      BC000P50_A45TipEmpleCod = new String[] {""} ;
      BC000P50_n45TipEmpleCod = new boolean[] {false} ;
      BC000P50_A1965EmpOsoCod = new String[] {""} ;
      BC000P50_n1965EmpOsoCod = new boolean[] {false} ;
      BC000P50_A2EmpNom = new String[] {""} ;
      BC000P51_A307OsoDescrip = new String[] {""} ;
      BC000P51_n307OsoDescrip = new boolean[] {false} ;
      BC000P51_A306OsoC3992 = new String[] {""} ;
      BC000P51_n306OsoC3992 = new boolean[] {false} ;
      BC000P52_A3CliCod = new int[1] ;
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime7 = GXutil.resetTime( GXutil.nullDate() );
      BC000P53_A263LegSexo = new byte[1] ;
      BC000P53_n263LegSexo = new boolean[] {false} ;
      BC000P54_A243LegEstadoCivil = new short[1] ;
      BC000P54_n243LegEstadoCivil = new boolean[] {false} ;
      BC000P55_A256LegNacionalidad = new String[] {""} ;
      BC000P56_A258LegPaiNom = new String[] {""} ;
      BC000P57_A260LegProvNom = new String[] {""} ;
      BC000P58_A255LegLocNom = new String[] {""} ;
      BC000P59_A331SinDescrip = new String[] {""} ;
      BC000P59_n331SinDescrip = new boolean[] {false} ;
      BC000P60_A22LegPaiCod = new short[1] ;
      BC000P60_n22LegPaiCod = new boolean[] {false} ;
      BC000P61_A227LegActDescri = new String[] {""} ;
      BC000P62_A684MprDescripSinAc = new String[] {""} ;
      BC000P62_A303MprDescrip = new String[] {""} ;
      BC000P63_A678ZonDescripSinAc = new String[] {""} ;
      BC000P63_A342ZonDescrip = new String[] {""} ;
      BC000P63_A343ZonPorcReduc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P64_A686CondiDescriSinAc = new String[] {""} ;
      BC000P64_A144CondiDescri = new String[] {""} ;
      BC000P65_A688SinieDescriSinAc = new String[] {""} ;
      BC000P65_A333SinieDescri = new String[] {""} ;
      BC000P66_A1603LegSitRevEgreso = new short[1] ;
      BC000P66_n1603LegSitRevEgreso = new boolean[] {false} ;
      BC000P67_A2181LegPueAfiCod = new String[] {""} ;
      BC000P67_n2181LegPueAfiCod = new boolean[] {false} ;
      BC000P68_A3CliCod = new int[1] ;
      BC000P68_A1EmpCod = new short[1] ;
      BC000P68_A6LegNumero = new int[1] ;
      BC000P69_A19SinieCodigo = new String[] {""} ;
      BC000P69_n19SinieCodigo = new boolean[] {false} ;
      BC000P69_A263LegSexo = new byte[1] ;
      BC000P69_n263LegSexo = new boolean[] {false} ;
      BC000P69_A243LegEstadoCivil = new short[1] ;
      BC000P69_n243LegEstadoCivil = new boolean[] {false} ;
      BC000P69_A22LegPaiCod = new short[1] ;
      BC000P69_n22LegPaiCod = new boolean[] {false} ;
      BC000P69_A23LegProvCod = new short[1] ;
      BC000P69_n23LegProvCod = new boolean[] {false} ;
      BC000P69_A24LegLocCod = new short[1] ;
      BC000P69_n24LegLocCod = new boolean[] {false} ;
      BC000P69_A21LegNacionCod = new short[1] ;
      BC000P69_n21LegNacionCod = new boolean[] {false} ;
      BC000P69_A910LegSinCod = new String[] {""} ;
      BC000P69_n910LegSinCod = new boolean[] {false} ;
      BC000P69_A2182LegActClasNro = new int[1] ;
      BC000P69_n2182LegActClasNro = new boolean[] {false} ;
      BC000P69_A15LegActCodigo = new String[] {""} ;
      BC000P69_n15LegActCodigo = new boolean[] {false} ;
      BC000P69_A1603LegSitRevEgreso = new short[1] ;
      BC000P69_n1603LegSitRevEgreso = new boolean[] {false} ;
      BC000P69_A2181LegPueAfiCod = new String[] {""} ;
      BC000P69_n2181LegPueAfiCod = new boolean[] {false} ;
      BC000P69_A1235LegReligion = new String[] {""} ;
      BC000P69_n1235LegReligion = new boolean[] {false} ;
      BC000P69_A1236LegOrigen = new String[] {""} ;
      BC000P69_n1236LegOrigen = new boolean[] {false} ;
      BC000P69_A237LegConvenio = new boolean[] {false} ;
      BC000P69_A250LegIdNomApe = new String[] {""} ;
      BC000P69_A591LegNomApe = new String[] {""} ;
      BC000P69_A6LegNumero = new int[1] ;
      BC000P69_A247LegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P69_A230LegApellido = new String[] {""} ;
      BC000P69_A251LegNombre = new String[] {""} ;
      BC000P69_A249LegFoto = new String[] {""} ;
      BC000P69_n249LegFoto = new boolean[] {false} ;
      BC000P69_A266LegTipDoc = new byte[1] ;
      BC000P69_A257LegNumDoc = new String[] {""} ;
      BC000P69_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P69_A239LegCUIL = new long[1] ;
      BC000P69_A241LegDiscapacidad = new byte[1] ;
      BC000P69_A242LegDomici = new String[] {""} ;
      BC000P69_A479LegEmail = new String[] {""} ;
      BC000P69_A236LegCodPos = new String[] {""} ;
      BC000P69_A265LegTelefono = new String[] {""} ;
      BC000P69_n265LegTelefono = new boolean[] {false} ;
      BC000P69_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P69_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P69_n244LegFecEgreso = new boolean[] {false} ;
      BC000P69_A939LegCatCodigo = new String[] {""} ;
      BC000P69_n939LegCatCodigo = new boolean[] {false} ;
      BC000P69_A2215LegCatPueCod = new int[1] ;
      BC000P69_n2215LegCatPueCod = new boolean[] {false} ;
      BC000P69_A235LegClase = new byte[1] ;
      BC000P69_A248LegFormaPago = new byte[1] ;
      BC000P69_A231LegBanSuc = new String[] {""} ;
      BC000P69_n231LegBanSuc = new boolean[] {false} ;
      BC000P69_A232LegBanTipCuen = new String[] {""} ;
      BC000P69_n232LegBanTipCuen = new boolean[] {false} ;
      BC000P69_A238LegCuentaBanc = new String[] {""} ;
      BC000P69_n238LegCuentaBanc = new boolean[] {false} ;
      BC000P69_A253LegLicInicio = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P69_n253LegLicInicio = new boolean[] {false} ;
      BC000P69_A252LegLicFinal = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P69_n252LegLicFinal = new boolean[] {false} ;
      BC000P69_A234LegCBU = new String[] {""} ;
      BC000P69_n234LegCBU = new boolean[] {false} ;
      BC000P69_A262LegSCVO = new boolean[] {false} ;
      BC000P69_A228LegActivo = new boolean[] {false} ;
      BC000P69_A264LegSueldoFuera = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P69_A93LegId = new String[] {""} ;
      BC000P69_n93LegId = new boolean[] {false} ;
      BC000P69_A937LegConveCodigo = new String[] {""} ;
      BC000P69_n937LegConveCodigo = new boolean[] {false} ;
      BC000P69_A515LegObs = new String[] {""} ;
      BC000P69_A630LegFecImportacion = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P69_A877LegAgenReten = new boolean[] {false} ;
      BC000P69_A879LegContinua = new String[] {""} ;
      BC000P69_A942LegRecalcLiq = new boolean[] {false} ;
      BC000P69_A1016LegJubilado = new boolean[] {false} ;
      BC000P69_A1023LegHorasDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P69_A1268LegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P69_A1245LegTrabLun = new boolean[] {false} ;
      BC000P69_A1246LegTrabMar = new boolean[] {false} ;
      BC000P69_A1247LegTrabMie = new boolean[] {false} ;
      BC000P69_A1248LegTrabJue = new boolean[] {false} ;
      BC000P69_A1249LegTrabVie = new boolean[] {false} ;
      BC000P69_A1250LegTrabSa = new boolean[] {false} ;
      BC000P69_A1251LegTrabDo = new boolean[] {false} ;
      BC000P69_A1523LegVacPend = new short[1] ;
      BC000P69_A1531LegFecPreAviso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P69_A1576LegConveVersionCli = new int[1] ;
      BC000P69_n1576LegConveVersionCli = new boolean[] {false} ;
      BC000P69_A1759LegPromDias = new String[] {""} ;
      BC000P69_A1804LegTitulo = new String[] {""} ;
      BC000P69_A1818LegEstado = new byte[1] ;
      BC000P69_A2263LegMigrWarn = new String[] {""} ;
      BC000P69_n2263LegMigrWarn = new boolean[] {false} ;
      BC000P69_A2267LegIncompleto = new boolean[] {false} ;
      BC000P69_A2309LegLiqApo = new boolean[] {false} ;
      BC000P69_A2404LegModTra = new String[] {""} ;
      BC000P69_A2417LegTipoTarifa = new String[] {""} ;
      BC000P69_A1031LegFotoExt = new String[] {""} ;
      BC000P69_A1030LegFotoNom = new String[] {""} ;
      BC000P69_A3CliCod = new int[1] ;
      BC000P69_A1582LegBanCod = new String[] {""} ;
      BC000P69_n1582LegBanCod = new boolean[] {false} ;
      BC000P69_A1581LegLpgCodigo = new String[] {""} ;
      BC000P69_n1581LegLpgCodigo = new boolean[] {false} ;
      BC000P69_A1583LegMegCodigo = new String[] {""} ;
      BC000P69_n1583LegMegCodigo = new boolean[] {false} ;
      BC000P69_A1580LegOsoCod = new String[] {""} ;
      BC000P69_n1580LegOsoCod = new boolean[] {false} ;
      BC000P69_A1579LegSecCodigo = new String[] {""} ;
      BC000P69_n1579LegSecCodigo = new boolean[] {false} ;
      BC000P69_A1EmpCod = new short[1] ;
      BC000P69_A1577LegSucCodigo = new String[] {""} ;
      BC000P69_n1577LegSucCodigo = new boolean[] {false} ;
      BC000P69_A1578LegPuesCodigo = new String[] {""} ;
      BC000P69_n1578LegPuesCodigo = new boolean[] {false} ;
      BC000P69_A18MprCod = new String[] {""} ;
      BC000P69_n18MprCod = new boolean[] {false} ;
      BC000P69_A20ZonCod = new String[] {""} ;
      BC000P69_n20ZonCod = new boolean[] {false} ;
      BC000P69_A17CondiCodigo = new short[1] ;
      BC000P69_n17CondiCodigo = new boolean[] {false} ;
      BC000P70_A19SinieCodigo = new String[] {""} ;
      BC000P70_n19SinieCodigo = new boolean[] {false} ;
      BC000P70_A263LegSexo = new byte[1] ;
      BC000P70_n263LegSexo = new boolean[] {false} ;
      BC000P70_A243LegEstadoCivil = new short[1] ;
      BC000P70_n243LegEstadoCivil = new boolean[] {false} ;
      BC000P70_A22LegPaiCod = new short[1] ;
      BC000P70_n22LegPaiCod = new boolean[] {false} ;
      BC000P70_A23LegProvCod = new short[1] ;
      BC000P70_n23LegProvCod = new boolean[] {false} ;
      BC000P70_A24LegLocCod = new short[1] ;
      BC000P70_n24LegLocCod = new boolean[] {false} ;
      BC000P70_A21LegNacionCod = new short[1] ;
      BC000P70_n21LegNacionCod = new boolean[] {false} ;
      BC000P70_A910LegSinCod = new String[] {""} ;
      BC000P70_n910LegSinCod = new boolean[] {false} ;
      BC000P70_A2182LegActClasNro = new int[1] ;
      BC000P70_n2182LegActClasNro = new boolean[] {false} ;
      BC000P70_A15LegActCodigo = new String[] {""} ;
      BC000P70_n15LegActCodigo = new boolean[] {false} ;
      BC000P70_A1603LegSitRevEgreso = new short[1] ;
      BC000P70_n1603LegSitRevEgreso = new boolean[] {false} ;
      BC000P70_A2181LegPueAfiCod = new String[] {""} ;
      BC000P70_n2181LegPueAfiCod = new boolean[] {false} ;
      BC000P70_A1235LegReligion = new String[] {""} ;
      BC000P70_n1235LegReligion = new boolean[] {false} ;
      BC000P70_A1236LegOrigen = new String[] {""} ;
      BC000P70_n1236LegOrigen = new boolean[] {false} ;
      BC000P70_A237LegConvenio = new boolean[] {false} ;
      BC000P70_A250LegIdNomApe = new String[] {""} ;
      BC000P70_A591LegNomApe = new String[] {""} ;
      BC000P70_A6LegNumero = new int[1] ;
      BC000P70_A247LegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P70_A230LegApellido = new String[] {""} ;
      BC000P70_A251LegNombre = new String[] {""} ;
      BC000P70_A249LegFoto = new String[] {""} ;
      BC000P70_n249LegFoto = new boolean[] {false} ;
      BC000P70_A266LegTipDoc = new byte[1] ;
      BC000P70_A257LegNumDoc = new String[] {""} ;
      BC000P70_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P70_A239LegCUIL = new long[1] ;
      BC000P70_A241LegDiscapacidad = new byte[1] ;
      BC000P70_A242LegDomici = new String[] {""} ;
      BC000P70_A479LegEmail = new String[] {""} ;
      BC000P70_A236LegCodPos = new String[] {""} ;
      BC000P70_A265LegTelefono = new String[] {""} ;
      BC000P70_n265LegTelefono = new boolean[] {false} ;
      BC000P70_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P70_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P70_n244LegFecEgreso = new boolean[] {false} ;
      BC000P70_A939LegCatCodigo = new String[] {""} ;
      BC000P70_n939LegCatCodigo = new boolean[] {false} ;
      BC000P70_A2215LegCatPueCod = new int[1] ;
      BC000P70_n2215LegCatPueCod = new boolean[] {false} ;
      BC000P70_A235LegClase = new byte[1] ;
      BC000P70_A248LegFormaPago = new byte[1] ;
      BC000P70_A231LegBanSuc = new String[] {""} ;
      BC000P70_n231LegBanSuc = new boolean[] {false} ;
      BC000P70_A232LegBanTipCuen = new String[] {""} ;
      BC000P70_n232LegBanTipCuen = new boolean[] {false} ;
      BC000P70_A238LegCuentaBanc = new String[] {""} ;
      BC000P70_n238LegCuentaBanc = new boolean[] {false} ;
      BC000P70_A253LegLicInicio = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P70_n253LegLicInicio = new boolean[] {false} ;
      BC000P70_A252LegLicFinal = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P70_n252LegLicFinal = new boolean[] {false} ;
      BC000P70_A234LegCBU = new String[] {""} ;
      BC000P70_n234LegCBU = new boolean[] {false} ;
      BC000P70_A262LegSCVO = new boolean[] {false} ;
      BC000P70_A228LegActivo = new boolean[] {false} ;
      BC000P70_A264LegSueldoFuera = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P70_A93LegId = new String[] {""} ;
      BC000P70_n93LegId = new boolean[] {false} ;
      BC000P70_A937LegConveCodigo = new String[] {""} ;
      BC000P70_n937LegConveCodigo = new boolean[] {false} ;
      BC000P70_A515LegObs = new String[] {""} ;
      BC000P70_A630LegFecImportacion = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P70_A877LegAgenReten = new boolean[] {false} ;
      BC000P70_A879LegContinua = new String[] {""} ;
      BC000P70_A942LegRecalcLiq = new boolean[] {false} ;
      BC000P70_A1016LegJubilado = new boolean[] {false} ;
      BC000P70_A1023LegHorasDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P70_A1268LegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P70_A1245LegTrabLun = new boolean[] {false} ;
      BC000P70_A1246LegTrabMar = new boolean[] {false} ;
      BC000P70_A1247LegTrabMie = new boolean[] {false} ;
      BC000P70_A1248LegTrabJue = new boolean[] {false} ;
      BC000P70_A1249LegTrabVie = new boolean[] {false} ;
      BC000P70_A1250LegTrabSa = new boolean[] {false} ;
      BC000P70_A1251LegTrabDo = new boolean[] {false} ;
      BC000P70_A1523LegVacPend = new short[1] ;
      BC000P70_A1531LegFecPreAviso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P70_A1576LegConveVersionCli = new int[1] ;
      BC000P70_n1576LegConveVersionCli = new boolean[] {false} ;
      BC000P70_A1759LegPromDias = new String[] {""} ;
      BC000P70_A1804LegTitulo = new String[] {""} ;
      BC000P70_A1818LegEstado = new byte[1] ;
      BC000P70_A2263LegMigrWarn = new String[] {""} ;
      BC000P70_n2263LegMigrWarn = new boolean[] {false} ;
      BC000P70_A2267LegIncompleto = new boolean[] {false} ;
      BC000P70_A2309LegLiqApo = new boolean[] {false} ;
      BC000P70_A2404LegModTra = new String[] {""} ;
      BC000P70_A2417LegTipoTarifa = new String[] {""} ;
      BC000P70_A1031LegFotoExt = new String[] {""} ;
      BC000P70_A1030LegFotoNom = new String[] {""} ;
      BC000P70_A3CliCod = new int[1] ;
      BC000P70_A1582LegBanCod = new String[] {""} ;
      BC000P70_n1582LegBanCod = new boolean[] {false} ;
      BC000P70_A1581LegLpgCodigo = new String[] {""} ;
      BC000P70_n1581LegLpgCodigo = new boolean[] {false} ;
      BC000P70_A1583LegMegCodigo = new String[] {""} ;
      BC000P70_n1583LegMegCodigo = new boolean[] {false} ;
      BC000P70_A1580LegOsoCod = new String[] {""} ;
      BC000P70_n1580LegOsoCod = new boolean[] {false} ;
      BC000P70_A1579LegSecCodigo = new String[] {""} ;
      BC000P70_n1579LegSecCodigo = new boolean[] {false} ;
      BC000P70_A1EmpCod = new short[1] ;
      BC000P70_A1577LegSucCodigo = new String[] {""} ;
      BC000P70_n1577LegSucCodigo = new boolean[] {false} ;
      BC000P70_A1578LegPuesCodigo = new String[] {""} ;
      BC000P70_n1578LegPuesCodigo = new boolean[] {false} ;
      BC000P70_A18MprCod = new String[] {""} ;
      BC000P70_n18MprCod = new boolean[] {false} ;
      BC000P70_A20ZonCod = new String[] {""} ;
      BC000P70_n20ZonCod = new boolean[] {false} ;
      BC000P70_A17CondiCodigo = new short[1] ;
      BC000P70_n17CondiCodigo = new boolean[] {false} ;
      BC000P75_A1965EmpOsoCod = new String[] {""} ;
      BC000P75_n1965EmpOsoCod = new boolean[] {false} ;
      BC000P75_A2EmpNom = new String[] {""} ;
      BC000P75_A45TipEmpleCod = new String[] {""} ;
      BC000P75_n45TipEmpleCod = new boolean[] {false} ;
      BC000P76_A307OsoDescrip = new String[] {""} ;
      BC000P76_n307OsoDescrip = new boolean[] {false} ;
      BC000P76_A306OsoC3992 = new String[] {""} ;
      BC000P76_n306OsoC3992 = new boolean[] {false} ;
      BC000P77_A256LegNacionalidad = new String[] {""} ;
      BC000P78_A258LegPaiNom = new String[] {""} ;
      BC000P79_A260LegProvNom = new String[] {""} ;
      BC000P80_A255LegLocNom = new String[] {""} ;
      BC000P81_A300MegDescrip = new String[] {""} ;
      BC000P81_n300MegDescrip = new boolean[] {false} ;
      BC000P82_A329SecDescrip = new String[] {""} ;
      BC000P82_n329SecDescrip = new boolean[] {false} ;
      BC000P83_A291LpgDescri = new String[] {""} ;
      BC000P83_n291LpgDescri = new boolean[] {false} ;
      BC000P84_A2224LegBanDes = new String[] {""} ;
      BC000P85_A331SinDescrip = new String[] {""} ;
      BC000P85_n331SinDescrip = new boolean[] {false} ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      BC000P86_A2225LegOsoDes = new String[] {""} ;
      BC000P86_A2226LegOsoAfipCod = new String[] {""} ;
      BC000P86_n2226LegOsoAfipCod = new boolean[] {false} ;
      BC000P86_A392OsoSigla = new String[] {""} ;
      BC000P86_n392OsoSigla = new boolean[] {false} ;
      BC000P87_A227LegActDescri = new String[] {""} ;
      BC000P88_A684MprDescripSinAc = new String[] {""} ;
      BC000P88_A303MprDescrip = new String[] {""} ;
      BC000P89_A678ZonDescripSinAc = new String[] {""} ;
      BC000P89_A342ZonDescrip = new String[] {""} ;
      BC000P89_A343ZonPorcReduc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P90_A686CondiDescriSinAc = new String[] {""} ;
      BC000P90_A144CondiDescri = new String[] {""} ;
      BC000P91_A688SinieDescriSinAc = new String[] {""} ;
      BC000P91_A333SinieDescri = new String[] {""} ;
      BC000P92_A3CliCod = new int[1] ;
      BC000P92_A1EmpCod = new short[1] ;
      BC000P92_A6LegNumero = new int[1] ;
      BC000P92_A2243LegCuenLicTpo = new String[] {""} ;
      BC000P92_A2266LegCuenAnio = new short[1] ;
      BC000P93_A3CliCod = new int[1] ;
      BC000P93_A1EmpCod = new short[1] ;
      BC000P93_A6LegNumero = new int[1] ;
      BC000P93_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P94_A3CliCod = new int[1] ;
      BC000P94_A1EmpCod = new short[1] ;
      BC000P94_A6LegNumero = new int[1] ;
      BC000P94_A1829PreliqTLiqCod = new String[] {""} ;
      BC000P94_A1830PreliqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P95_A3CliCod = new int[1] ;
      BC000P95_A1EmpCod = new short[1] ;
      BC000P95_A6LegNumero = new int[1] ;
      BC000P95_A1172OblSecuencial = new short[1] ;
      BC000P96_A3CliCod = new int[1] ;
      BC000P96_A1EmpCod = new short[1] ;
      BC000P96_A6LegNumero = new int[1] ;
      BC000P96_A1135LegSuelSec = new short[1] ;
      BC000P97_A3CliCod = new int[1] ;
      BC000P97_A1EmpCod = new short[1] ;
      BC000P97_A784F1357CTipoPre = new byte[1] ;
      BC000P97_A777F1357CPer = new String[] {""} ;
      BC000P97_A778F1357CSec = new byte[1] ;
      BC000P97_A6LegNumero = new int[1] ;
      BC000P97_A797F1357LRTipReg = new String[] {""} ;
      BC000P98_A3CliCod = new int[1] ;
      BC000P98_A1EmpCod = new short[1] ;
      BC000P98_A784F1357CTipoPre = new byte[1] ;
      BC000P98_A777F1357CPer = new String[] {""} ;
      BC000P98_A778F1357CSec = new byte[1] ;
      BC000P98_A6LegNumero = new int[1] ;
      BC000P98_A863F1357LDGTipReg = new String[] {""} ;
      BC000P99_A3CliCod = new int[1] ;
      BC000P99_A1EmpCod = new short[1] ;
      BC000P99_A784F1357CTipoPre = new byte[1] ;
      BC000P99_A777F1357CPer = new String[] {""} ;
      BC000P99_A778F1357CSec = new byte[1] ;
      BC000P99_A6LegNumero = new int[1] ;
      BC000P99_A786F1357LTipoReg = new String[] {""} ;
      BC000P100_A3CliCod = new int[1] ;
      BC000P100_A1EmpCod = new short[1] ;
      BC000P100_A784F1357CTipoPre = new byte[1] ;
      BC000P100_A777F1357CPer = new String[] {""} ;
      BC000P100_A778F1357CSec = new byte[1] ;
      BC000P100_A6LegNumero = new int[1] ;
      BC000P100_A862F1357LDPTipReg = new String[] {""} ;
      BC000P101_A3CliCod = new int[1] ;
      BC000P101_A1EmpCod = new short[1] ;
      BC000P101_A784F1357CTipoPre = new byte[1] ;
      BC000P101_A777F1357CPer = new String[] {""} ;
      BC000P101_A778F1357CSec = new byte[1] ;
      BC000P101_A6LegNumero = new int[1] ;
      BC000P101_A861F1357LCTipReg = new String[] {""} ;
      BC000P102_A3CliCod = new int[1] ;
      BC000P102_A1EmpCod = new short[1] ;
      BC000P102_A6LegNumero = new int[1] ;
      BC000P102_A83LegDedSec = new int[1] ;
      BC000P103_A3CliCod = new int[1] ;
      BC000P103_A1EmpCod = new short[1] ;
      BC000P103_A6LegNumero = new int[1] ;
      BC000P103_A77CenCodigo = new short[1] ;
      BC000P104_A3CliCod = new int[1] ;
      BC000P104_A1EmpCod = new short[1] ;
      BC000P104_A6LegNumero = new int[1] ;
      BC000P104_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P105_A3CliCod = new int[1] ;
      BC000P105_A1EmpCod = new short[1] ;
      BC000P105_A31LiqNro = new int[1] ;
      BC000P105_A6LegNumero = new int[1] ;
      BC000P106_A3CliCod = new int[1] ;
      BC000P106_A1EmpCod = new short[1] ;
      BC000P106_A6LegNumero = new int[1] ;
      BC000P106_A25AgeOrden = new short[1] ;
      BC000P107_A19SinieCodigo = new String[] {""} ;
      BC000P107_n19SinieCodigo = new boolean[] {false} ;
      BC000P107_A263LegSexo = new byte[1] ;
      BC000P107_n263LegSexo = new boolean[] {false} ;
      BC000P107_A243LegEstadoCivil = new short[1] ;
      BC000P107_n243LegEstadoCivil = new boolean[] {false} ;
      BC000P107_A22LegPaiCod = new short[1] ;
      BC000P107_n22LegPaiCod = new boolean[] {false} ;
      BC000P107_A23LegProvCod = new short[1] ;
      BC000P107_n23LegProvCod = new boolean[] {false} ;
      BC000P107_A24LegLocCod = new short[1] ;
      BC000P107_n24LegLocCod = new boolean[] {false} ;
      BC000P107_A21LegNacionCod = new short[1] ;
      BC000P107_n21LegNacionCod = new boolean[] {false} ;
      BC000P107_A910LegSinCod = new String[] {""} ;
      BC000P107_n910LegSinCod = new boolean[] {false} ;
      BC000P107_A2182LegActClasNro = new int[1] ;
      BC000P107_n2182LegActClasNro = new boolean[] {false} ;
      BC000P107_A15LegActCodigo = new String[] {""} ;
      BC000P107_n15LegActCodigo = new boolean[] {false} ;
      BC000P107_A1603LegSitRevEgreso = new short[1] ;
      BC000P107_n1603LegSitRevEgreso = new boolean[] {false} ;
      BC000P107_A2181LegPueAfiCod = new String[] {""} ;
      BC000P107_n2181LegPueAfiCod = new boolean[] {false} ;
      BC000P107_A45TipEmpleCod = new String[] {""} ;
      BC000P107_n45TipEmpleCod = new boolean[] {false} ;
      BC000P107_A1235LegReligion = new String[] {""} ;
      BC000P107_n1235LegReligion = new boolean[] {false} ;
      BC000P107_A1236LegOrigen = new String[] {""} ;
      BC000P107_n1236LegOrigen = new boolean[] {false} ;
      BC000P107_A1965EmpOsoCod = new String[] {""} ;
      BC000P107_n1965EmpOsoCod = new boolean[] {false} ;
      BC000P107_A237LegConvenio = new boolean[] {false} ;
      BC000P107_A688SinieDescriSinAc = new String[] {""} ;
      BC000P107_A686CondiDescriSinAc = new String[] {""} ;
      BC000P107_A678ZonDescripSinAc = new String[] {""} ;
      BC000P107_A684MprDescripSinAc = new String[] {""} ;
      BC000P107_A250LegIdNomApe = new String[] {""} ;
      BC000P107_A591LegNomApe = new String[] {""} ;
      BC000P107_A6LegNumero = new int[1] ;
      BC000P107_A247LegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P107_A2EmpNom = new String[] {""} ;
      BC000P107_A230LegApellido = new String[] {""} ;
      BC000P107_A251LegNombre = new String[] {""} ;
      BC000P107_A249LegFoto = new String[] {""} ;
      BC000P107_n249LegFoto = new boolean[] {false} ;
      BC000P107_A266LegTipDoc = new byte[1] ;
      BC000P107_A257LegNumDoc = new String[] {""} ;
      BC000P107_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P107_A256LegNacionalidad = new String[] {""} ;
      BC000P107_A239LegCUIL = new long[1] ;
      BC000P107_A241LegDiscapacidad = new byte[1] ;
      BC000P107_A242LegDomici = new String[] {""} ;
      BC000P107_A479LegEmail = new String[] {""} ;
      BC000P107_A236LegCodPos = new String[] {""} ;
      BC000P107_A258LegPaiNom = new String[] {""} ;
      BC000P107_A260LegProvNom = new String[] {""} ;
      BC000P107_A255LegLocNom = new String[] {""} ;
      BC000P107_A265LegTelefono = new String[] {""} ;
      BC000P107_n265LegTelefono = new boolean[] {false} ;
      BC000P107_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P107_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P107_n244LegFecEgreso = new boolean[] {false} ;
      BC000P107_A300MegDescrip = new String[] {""} ;
      BC000P107_n300MegDescrip = new boolean[] {false} ;
      BC000P107_A939LegCatCodigo = new String[] {""} ;
      BC000P107_n939LegCatCodigo = new boolean[] {false} ;
      BC000P107_A2215LegCatPueCod = new int[1] ;
      BC000P107_n2215LegCatPueCod = new boolean[] {false} ;
      BC000P107_A329SecDescrip = new String[] {""} ;
      BC000P107_n329SecDescrip = new boolean[] {false} ;
      BC000P107_A291LpgDescri = new String[] {""} ;
      BC000P107_n291LpgDescri = new boolean[] {false} ;
      BC000P107_A235LegClase = new byte[1] ;
      BC000P107_A248LegFormaPago = new byte[1] ;
      BC000P107_A2224LegBanDes = new String[] {""} ;
      BC000P107_A231LegBanSuc = new String[] {""} ;
      BC000P107_n231LegBanSuc = new boolean[] {false} ;
      BC000P107_A232LegBanTipCuen = new String[] {""} ;
      BC000P107_n232LegBanTipCuen = new boolean[] {false} ;
      BC000P107_A331SinDescrip = new String[] {""} ;
      BC000P107_n331SinDescrip = new boolean[] {false} ;
      BC000P107_A2225LegOsoDes = new String[] {""} ;
      BC000P107_A2226LegOsoAfipCod = new String[] {""} ;
      BC000P107_n2226LegOsoAfipCod = new boolean[] {false} ;
      BC000P107_A307OsoDescrip = new String[] {""} ;
      BC000P107_n307OsoDescrip = new boolean[] {false} ;
      BC000P107_A227LegActDescri = new String[] {""} ;
      BC000P107_A303MprDescrip = new String[] {""} ;
      BC000P107_A238LegCuentaBanc = new String[] {""} ;
      BC000P107_n238LegCuentaBanc = new boolean[] {false} ;
      BC000P107_A253LegLicInicio = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P107_n253LegLicInicio = new boolean[] {false} ;
      BC000P107_A252LegLicFinal = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P107_n252LegLicFinal = new boolean[] {false} ;
      BC000P107_A342ZonDescrip = new String[] {""} ;
      BC000P107_A343ZonPorcReduc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P107_A234LegCBU = new String[] {""} ;
      BC000P107_n234LegCBU = new boolean[] {false} ;
      BC000P107_A262LegSCVO = new boolean[] {false} ;
      BC000P107_A144CondiDescri = new String[] {""} ;
      BC000P107_A333SinieDescri = new String[] {""} ;
      BC000P107_A228LegActivo = new boolean[] {false} ;
      BC000P107_A264LegSueldoFuera = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P107_A93LegId = new String[] {""} ;
      BC000P107_n93LegId = new boolean[] {false} ;
      BC000P107_A937LegConveCodigo = new String[] {""} ;
      BC000P107_n937LegConveCodigo = new boolean[] {false} ;
      BC000P107_A306OsoC3992 = new String[] {""} ;
      BC000P107_n306OsoC3992 = new boolean[] {false} ;
      BC000P107_A515LegObs = new String[] {""} ;
      BC000P107_A630LegFecImportacion = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P107_A877LegAgenReten = new boolean[] {false} ;
      BC000P107_A879LegContinua = new String[] {""} ;
      BC000P107_A942LegRecalcLiq = new boolean[] {false} ;
      BC000P107_A1016LegJubilado = new boolean[] {false} ;
      BC000P107_A1023LegHorasDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P107_A1268LegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P107_A1245LegTrabLun = new boolean[] {false} ;
      BC000P107_A1246LegTrabMar = new boolean[] {false} ;
      BC000P107_A1247LegTrabMie = new boolean[] {false} ;
      BC000P107_A1248LegTrabJue = new boolean[] {false} ;
      BC000P107_A1249LegTrabVie = new boolean[] {false} ;
      BC000P107_A1250LegTrabSa = new boolean[] {false} ;
      BC000P107_A1251LegTrabDo = new boolean[] {false} ;
      BC000P107_A1523LegVacPend = new short[1] ;
      BC000P107_A1531LegFecPreAviso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P107_A1576LegConveVersionCli = new int[1] ;
      BC000P107_n1576LegConveVersionCli = new boolean[] {false} ;
      BC000P107_A1759LegPromDias = new String[] {""} ;
      BC000P107_A1804LegTitulo = new String[] {""} ;
      BC000P107_A1818LegEstado = new byte[1] ;
      BC000P107_A2263LegMigrWarn = new String[] {""} ;
      BC000P107_n2263LegMigrWarn = new boolean[] {false} ;
      BC000P107_A2267LegIncompleto = new boolean[] {false} ;
      BC000P107_A2309LegLiqApo = new boolean[] {false} ;
      BC000P107_A2404LegModTra = new String[] {""} ;
      BC000P107_A2417LegTipoTarifa = new String[] {""} ;
      BC000P107_A1031LegFotoExt = new String[] {""} ;
      BC000P107_A1030LegFotoNom = new String[] {""} ;
      BC000P107_A392OsoSigla = new String[] {""} ;
      BC000P107_n392OsoSigla = new boolean[] {false} ;
      BC000P107_A3CliCod = new int[1] ;
      BC000P107_A1582LegBanCod = new String[] {""} ;
      BC000P107_n1582LegBanCod = new boolean[] {false} ;
      BC000P107_A1581LegLpgCodigo = new String[] {""} ;
      BC000P107_n1581LegLpgCodigo = new boolean[] {false} ;
      BC000P107_A1583LegMegCodigo = new String[] {""} ;
      BC000P107_n1583LegMegCodigo = new boolean[] {false} ;
      BC000P107_A1580LegOsoCod = new String[] {""} ;
      BC000P107_n1580LegOsoCod = new boolean[] {false} ;
      BC000P107_A1579LegSecCodigo = new String[] {""} ;
      BC000P107_n1579LegSecCodigo = new boolean[] {false} ;
      BC000P107_A1EmpCod = new short[1] ;
      BC000P107_A1577LegSucCodigo = new String[] {""} ;
      BC000P107_n1577LegSucCodigo = new boolean[] {false} ;
      BC000P107_A1578LegPuesCodigo = new String[] {""} ;
      BC000P107_n1578LegPuesCodigo = new boolean[] {false} ;
      BC000P107_A18MprCod = new String[] {""} ;
      BC000P107_n18MprCod = new boolean[] {false} ;
      BC000P107_A20ZonCod = new String[] {""} ;
      BC000P107_n20ZonCod = new boolean[] {false} ;
      BC000P107_A17CondiCodigo = new short[1] ;
      BC000P107_n17CondiCodigo = new boolean[] {false} ;
      Z1136LegSuelFecha = GXutil.nullDate() ;
      A1136LegSuelFecha = GXutil.nullDate() ;
      Z1137LegSuelImporte = DecimalUtil.ZERO ;
      A1137LegSuelImporte = DecimalUtil.ZERO ;
      Z2344LegSuelTipo = "" ;
      A2344LegSuelTipo = "" ;
      Z2347LegSuelCalc = DecimalUtil.ZERO ;
      A2347LegSuelCalc = DecimalUtil.ZERO ;
      Z2348LegSuelLog = "" ;
      A2348LegSuelLog = "" ;
      BC000P108_A3CliCod = new int[1] ;
      BC000P108_A1EmpCod = new short[1] ;
      BC000P108_A6LegNumero = new int[1] ;
      BC000P108_A1135LegSuelSec = new short[1] ;
      BC000P108_A1136LegSuelFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P108_A1137LegSuelImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P108_A2344LegSuelTipo = new String[] {""} ;
      BC000P108_n2344LegSuelTipo = new boolean[] {false} ;
      BC000P108_A2347LegSuelCalc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P108_A2348LegSuelLog = new String[] {""} ;
      BC000P109_A3CliCod = new int[1] ;
      BC000P109_A1EmpCod = new short[1] ;
      BC000P109_A6LegNumero = new int[1] ;
      BC000P109_A1135LegSuelSec = new short[1] ;
      BC000P110_A3CliCod = new int[1] ;
      BC000P110_A1EmpCod = new short[1] ;
      BC000P110_A6LegNumero = new int[1] ;
      BC000P110_A1135LegSuelSec = new short[1] ;
      BC000P110_A1136LegSuelFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P110_A1137LegSuelImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P110_A2344LegSuelTipo = new String[] {""} ;
      BC000P110_n2344LegSuelTipo = new boolean[] {false} ;
      BC000P110_A2347LegSuelCalc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P110_A2348LegSuelLog = new String[] {""} ;
      BC000P111_A3CliCod = new int[1] ;
      BC000P111_A1EmpCod = new short[1] ;
      BC000P111_A6LegNumero = new int[1] ;
      BC000P111_A1135LegSuelSec = new short[1] ;
      BC000P111_A1136LegSuelFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P111_A1137LegSuelImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P111_A2344LegSuelTipo = new String[] {""} ;
      BC000P111_n2344LegSuelTipo = new boolean[] {false} ;
      BC000P111_A2347LegSuelCalc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P111_A2348LegSuelLog = new String[] {""} ;
      BC000P115_A3CliCod = new int[1] ;
      BC000P115_A1EmpCod = new short[1] ;
      BC000P115_A6LegNumero = new int[1] ;
      BC000P115_A1135LegSuelSec = new short[1] ;
      BC000P115_A1136LegSuelFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P115_A1137LegSuelImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P115_A2344LegSuelTipo = new String[] {""} ;
      BC000P115_n2344LegSuelTipo = new boolean[] {false} ;
      BC000P115_A2347LegSuelCalc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P115_A2348LegSuelLog = new String[] {""} ;
      Z2349LegSuelConcepto = "" ;
      A2349LegSuelConcepto = "" ;
      BC000P116_A3CliCod = new int[1] ;
      BC000P116_A2349LegSuelConcepto = new String[] {""} ;
      BC000P116_A1EmpCod = new short[1] ;
      BC000P116_A6LegNumero = new int[1] ;
      BC000P116_A1135LegSuelSec = new short[1] ;
      BC000P117_A3CliCod = new int[1] ;
      BC000P118_A3CliCod = new int[1] ;
      BC000P118_A1EmpCod = new short[1] ;
      BC000P118_A6LegNumero = new int[1] ;
      BC000P118_A1135LegSuelSec = new short[1] ;
      BC000P118_A2349LegSuelConcepto = new String[] {""} ;
      BC000P119_A3CliCod = new int[1] ;
      BC000P119_A2349LegSuelConcepto = new String[] {""} ;
      BC000P119_A1EmpCod = new short[1] ;
      BC000P119_A6LegNumero = new int[1] ;
      BC000P119_A1135LegSuelSec = new short[1] ;
      sMode292 = "" ;
      BC000P120_A3CliCod = new int[1] ;
      BC000P120_A2349LegSuelConcepto = new String[] {""} ;
      BC000P120_A1EmpCod = new short[1] ;
      BC000P120_A6LegNumero = new int[1] ;
      BC000P120_A1135LegSuelSec = new short[1] ;
      BC000P123_A3CliCod = new int[1] ;
      BC000P123_A2349LegSuelConcepto = new String[] {""} ;
      BC000P123_A1EmpCod = new short[1] ;
      BC000P123_A6LegNumero = new int[1] ;
      BC000P123_A1135LegSuelSec = new short[1] ;
      Z220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      A220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      Z2090FamNomApe = "" ;
      A2090FamNomApe = "" ;
      Z209FamFecNac = GXutil.nullDate() ;
      A209FamFecNac = GXutil.nullDate() ;
      Z750FamNroDoc = "" ;
      A750FamNroDoc = "" ;
      Z30ParCod = "" ;
      A30ParCod = "" ;
      BC000P124_A6LegNumero = new int[1] ;
      BC000P124_A29LegOrden = new short[1] ;
      BC000P124_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P124_A2090FamNomApe = new String[] {""} ;
      BC000P124_A209FamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P124_n209FamFecNac = new boolean[] {false} ;
      BC000P124_A205FamDiscap = new boolean[] {false} ;
      BC000P124_n205FamDiscap = new boolean[] {false} ;
      BC000P124_A750FamNroDoc = new String[] {""} ;
      BC000P124_A890FamAdherente = new boolean[] {false} ;
      BC000P124_A3CliCod = new int[1] ;
      BC000P124_A30ParCod = new String[] {""} ;
      BC000P124_A1EmpCod = new short[1] ;
      BC000P124_A1547GuarCod = new short[1] ;
      BC000P124_n1547GuarCod = new boolean[] {false} ;
      BC000P125_A3CliCod = new int[1] ;
      BC000P126_A3CliCod = new int[1] ;
      BC000P127_A3CliCod = new int[1] ;
      BC000P127_A1EmpCod = new short[1] ;
      BC000P127_A6LegNumero = new int[1] ;
      BC000P127_A29LegOrden = new short[1] ;
      BC000P128_A6LegNumero = new int[1] ;
      BC000P128_A29LegOrden = new short[1] ;
      BC000P128_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P128_A2090FamNomApe = new String[] {""} ;
      BC000P128_A209FamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P128_n209FamFecNac = new boolean[] {false} ;
      BC000P128_A205FamDiscap = new boolean[] {false} ;
      BC000P128_n205FamDiscap = new boolean[] {false} ;
      BC000P128_A750FamNroDoc = new String[] {""} ;
      BC000P128_A890FamAdherente = new boolean[] {false} ;
      BC000P128_A3CliCod = new int[1] ;
      BC000P128_A30ParCod = new String[] {""} ;
      BC000P128_A1EmpCod = new short[1] ;
      BC000P128_A1547GuarCod = new short[1] ;
      BC000P128_n1547GuarCod = new boolean[] {false} ;
      sMode24 = "" ;
      BC000P129_A6LegNumero = new int[1] ;
      BC000P129_A29LegOrden = new short[1] ;
      BC000P129_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P129_A2090FamNomApe = new String[] {""} ;
      BC000P129_A209FamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P129_n209FamFecNac = new boolean[] {false} ;
      BC000P129_A205FamDiscap = new boolean[] {false} ;
      BC000P129_n205FamDiscap = new boolean[] {false} ;
      BC000P129_A750FamNroDoc = new String[] {""} ;
      BC000P129_A890FamAdherente = new boolean[] {false} ;
      BC000P129_A3CliCod = new int[1] ;
      BC000P129_A30ParCod = new String[] {""} ;
      BC000P129_A1EmpCod = new short[1] ;
      BC000P129_A1547GuarCod = new short[1] ;
      BC000P129_n1547GuarCod = new boolean[] {false} ;
      BC000P133_A6LegNumero = new int[1] ;
      BC000P133_A29LegOrden = new short[1] ;
      BC000P133_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P133_A2090FamNomApe = new String[] {""} ;
      BC000P133_A209FamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P133_n209FamFecNac = new boolean[] {false} ;
      BC000P133_A205FamDiscap = new boolean[] {false} ;
      BC000P133_n205FamDiscap = new boolean[] {false} ;
      BC000P133_A750FamNroDoc = new String[] {""} ;
      BC000P133_A890FamAdherente = new boolean[] {false} ;
      BC000P133_A3CliCod = new int[1] ;
      BC000P133_A30ParCod = new String[] {""} ;
      BC000P133_A1EmpCod = new short[1] ;
      BC000P133_A1547GuarCod = new short[1] ;
      BC000P133_n1547GuarCod = new boolean[] {false} ;
      Z1319LegTipoTra = "" ;
      A1319LegTipoTra = "" ;
      BC000P134_A3CliCod = new int[1] ;
      BC000P134_A1EmpCod = new short[1] ;
      BC000P134_A6LegNumero = new int[1] ;
      BC000P134_A1319LegTipoTra = new String[] {""} ;
      BC000P135_A1292TipoTraId = new String[] {""} ;
      BC000P136_A3CliCod = new int[1] ;
      BC000P136_A1EmpCod = new short[1] ;
      BC000P136_A6LegNumero = new int[1] ;
      BC000P136_A1319LegTipoTra = new String[] {""} ;
      BC000P137_A3CliCod = new int[1] ;
      BC000P137_A1EmpCod = new short[1] ;
      BC000P137_A6LegNumero = new int[1] ;
      BC000P137_A1319LegTipoTra = new String[] {""} ;
      sMode170 = "" ;
      BC000P138_A3CliCod = new int[1] ;
      BC000P138_A1EmpCod = new short[1] ;
      BC000P138_A6LegNumero = new int[1] ;
      BC000P138_A1319LegTipoTra = new String[] {""} ;
      BC000P141_A3CliCod = new int[1] ;
      BC000P141_A1EmpCod = new short[1] ;
      BC000P141_A6LegNumero = new int[1] ;
      BC000P141_A1319LegTipoTra = new String[] {""} ;
      Z2233LegPropValNum = DecimalUtil.ZERO ;
      A2233LegPropValNum = DecimalUtil.ZERO ;
      Z2235LegPropValStr = "" ;
      A2235LegPropValStr = "" ;
      Z2236LegPropValDate = GXutil.nullDate() ;
      A2236LegPropValDate = GXutil.nullDate() ;
      Z2231LegPropDes = "" ;
      A2231LegPropDes = "" ;
      Z2232LegPropTD = "" ;
      A2232LegPropTD = "" ;
      Z2230LegPropCod = "" ;
      A2230LegPropCod = "" ;
      BC000P142_A3CliCod = new int[1] ;
      BC000P142_A1EmpCod = new short[1] ;
      BC000P142_A6LegNumero = new int[1] ;
      BC000P142_A2231LegPropDes = new String[] {""} ;
      BC000P142_A2232LegPropTD = new String[] {""} ;
      BC000P142_A2233LegPropValNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P142_A2234LegPropValBool = new boolean[] {false} ;
      BC000P142_A2235LegPropValStr = new String[] {""} ;
      BC000P142_A2236LegPropValDate = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P142_A2230LegPropCod = new String[] {""} ;
      BC000P143_A2231LegPropDes = new String[] {""} ;
      BC000P143_A2232LegPropTD = new String[] {""} ;
      BC000P144_A3CliCod = new int[1] ;
      BC000P144_A1EmpCod = new short[1] ;
      BC000P144_A6LegNumero = new int[1] ;
      BC000P144_A2230LegPropCod = new String[] {""} ;
      BC000P145_A3CliCod = new int[1] ;
      BC000P145_A1EmpCod = new short[1] ;
      BC000P145_A6LegNumero = new int[1] ;
      BC000P145_A2233LegPropValNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P145_A2234LegPropValBool = new boolean[] {false} ;
      BC000P145_A2235LegPropValStr = new String[] {""} ;
      BC000P145_A2236LegPropValDate = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P145_A2230LegPropCod = new String[] {""} ;
      sMode276 = "" ;
      BC000P146_A3CliCod = new int[1] ;
      BC000P146_A1EmpCod = new short[1] ;
      BC000P146_A6LegNumero = new int[1] ;
      BC000P146_A2233LegPropValNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P146_A2234LegPropValBool = new boolean[] {false} ;
      BC000P146_A2235LegPropValStr = new String[] {""} ;
      BC000P146_A2236LegPropValDate = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P146_A2230LegPropCod = new String[] {""} ;
      BC000P150_A2231LegPropDes = new String[] {""} ;
      BC000P150_A2232LegPropTD = new String[] {""} ;
      BC000P151_A3CliCod = new int[1] ;
      BC000P151_A1EmpCod = new short[1] ;
      BC000P151_A6LegNumero = new int[1] ;
      BC000P151_A2231LegPropDes = new String[] {""} ;
      BC000P151_A2232LegPropTD = new String[] {""} ;
      BC000P151_A2233LegPropValNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000P151_A2234LegPropValBool = new boolean[] {false} ;
      BC000P151_A2235LegPropValStr = new String[] {""} ;
      BC000P151_A2236LegPropValDate = new java.util.Date[] {GXutil.nullDate()} ;
      BC000P151_A2230LegPropCod = new String[] {""} ;
      i879LegContinua = "" ;
      i220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      A1292TipoTraId = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000P152_A45TipEmpleCod = new String[] {""} ;
      BC000P152_n45TipEmpleCod = new boolean[] {false} ;
      BC000P152_A1965EmpOsoCod = new String[] {""} ;
      BC000P152_n1965EmpOsoCod = new boolean[] {false} ;
      BC000P152_A2EmpNom = new String[] {""} ;
      BC000P153_A307OsoDescrip = new String[] {""} ;
      BC000P153_n307OsoDescrip = new boolean[] {false} ;
      BC000P153_A306OsoC3992 = new String[] {""} ;
      BC000P153_n306OsoC3992 = new boolean[] {false} ;
      BC000P154_A45TipEmpleCod = new String[] {""} ;
      BC000P154_n45TipEmpleCod = new boolean[] {false} ;
      BC000P154_A1965EmpOsoCod = new String[] {""} ;
      BC000P154_n1965EmpOsoCod = new boolean[] {false} ;
      BC000P154_A2EmpNom = new String[] {""} ;
      BC000P155_A307OsoDescrip = new String[] {""} ;
      BC000P155_n307OsoDescrip = new boolean[] {false} ;
      BC000P155_A306OsoC3992 = new String[] {""} ;
      BC000P155_n306OsoC3992 = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_bc__default(),
         new Object[] {
             new Object[] {
            BC000P2_A3CliCod, BC000P2_A1EmpCod, BC000P2_A6LegNumero, BC000P2_A2233LegPropValNum, BC000P2_A2234LegPropValBool, BC000P2_A2235LegPropValStr, BC000P2_A2236LegPropValDate, BC000P2_A2230LegPropCod
            }
            , new Object[] {
            BC000P3_A3CliCod, BC000P3_A1EmpCod, BC000P3_A6LegNumero, BC000P3_A2233LegPropValNum, BC000P3_A2234LegPropValBool, BC000P3_A2235LegPropValStr, BC000P3_A2236LegPropValDate, BC000P3_A2230LegPropCod
            }
            , new Object[] {
            BC000P4_A2231LegPropDes, BC000P4_A2232LegPropTD
            }
            , new Object[] {
            BC000P5_A3CliCod, BC000P5_A1EmpCod, BC000P5_A6LegNumero, BC000P5_A1319LegTipoTra
            }
            , new Object[] {
            BC000P6_A3CliCod, BC000P6_A1EmpCod, BC000P6_A6LegNumero, BC000P6_A1319LegTipoTra
            }
            , new Object[] {
            BC000P7_A1292TipoTraId
            }
            , new Object[] {
            BC000P8_A6LegNumero, BC000P8_A29LegOrden, BC000P8_A220FamTomaDeducImpGan, BC000P8_A2090FamNomApe, BC000P8_A209FamFecNac, BC000P8_n209FamFecNac, BC000P8_A205FamDiscap, BC000P8_n205FamDiscap, BC000P8_A750FamNroDoc, BC000P8_A890FamAdherente,
            BC000P8_A3CliCod, BC000P8_A30ParCod, BC000P8_A1EmpCod, BC000P8_A1547GuarCod, BC000P8_n1547GuarCod
            }
            , new Object[] {
            BC000P9_A6LegNumero, BC000P9_A29LegOrden, BC000P9_A220FamTomaDeducImpGan, BC000P9_A2090FamNomApe, BC000P9_A209FamFecNac, BC000P9_n209FamFecNac, BC000P9_A205FamDiscap, BC000P9_n205FamDiscap, BC000P9_A750FamNroDoc, BC000P9_A890FamAdherente,
            BC000P9_A3CliCod, BC000P9_A30ParCod, BC000P9_A1EmpCod, BC000P9_A1547GuarCod, BC000P9_n1547GuarCod
            }
            , new Object[] {
            BC000P10_A3CliCod
            }
            , new Object[] {
            BC000P11_A3CliCod
            }
            , new Object[] {
            BC000P12_A3CliCod, BC000P12_A2349LegSuelConcepto, BC000P12_A1EmpCod, BC000P12_A6LegNumero, BC000P12_A1135LegSuelSec
            }
            , new Object[] {
            BC000P13_A3CliCod, BC000P13_A2349LegSuelConcepto, BC000P13_A1EmpCod, BC000P13_A6LegNumero, BC000P13_A1135LegSuelSec
            }
            , new Object[] {
            BC000P14_A3CliCod
            }
            , new Object[] {
            BC000P15_A3CliCod, BC000P15_A1EmpCod, BC000P15_A6LegNumero, BC000P15_A1135LegSuelSec, BC000P15_A1136LegSuelFecha, BC000P15_A1137LegSuelImporte, BC000P15_A2344LegSuelTipo, BC000P15_n2344LegSuelTipo, BC000P15_A2347LegSuelCalc, BC000P15_A2348LegSuelLog
            }
            , new Object[] {
            BC000P16_A3CliCod, BC000P16_A1EmpCod, BC000P16_A6LegNumero, BC000P16_A1135LegSuelSec, BC000P16_A1136LegSuelFecha, BC000P16_A1137LegSuelImporte, BC000P16_A2344LegSuelTipo, BC000P16_n2344LegSuelTipo, BC000P16_A2347LegSuelCalc, BC000P16_A2348LegSuelLog
            }
            , new Object[] {
            BC000P17_A19SinieCodigo, BC000P17_n19SinieCodigo, BC000P17_A263LegSexo, BC000P17_n263LegSexo, BC000P17_A243LegEstadoCivil, BC000P17_n243LegEstadoCivil, BC000P17_A22LegPaiCod, BC000P17_n22LegPaiCod, BC000P17_A23LegProvCod, BC000P17_n23LegProvCod,
            BC000P17_A24LegLocCod, BC000P17_n24LegLocCod, BC000P17_A21LegNacionCod, BC000P17_n21LegNacionCod, BC000P17_A910LegSinCod, BC000P17_n910LegSinCod, BC000P17_A2182LegActClasNro, BC000P17_n2182LegActClasNro, BC000P17_A15LegActCodigo, BC000P17_n15LegActCodigo,
            BC000P17_A1603LegSitRevEgreso, BC000P17_n1603LegSitRevEgreso, BC000P17_A2181LegPueAfiCod, BC000P17_n2181LegPueAfiCod, BC000P17_A1235LegReligion, BC000P17_n1235LegReligion, BC000P17_A1236LegOrigen, BC000P17_n1236LegOrigen, BC000P17_A237LegConvenio, BC000P17_A250LegIdNomApe,
            BC000P17_A591LegNomApe, BC000P17_A6LegNumero, BC000P17_A247LegFecUltMod, BC000P17_A230LegApellido, BC000P17_A251LegNombre, BC000P17_A249LegFoto, BC000P17_n249LegFoto, BC000P17_A266LegTipDoc, BC000P17_A257LegNumDoc, BC000P17_A246LegFecNac,
            BC000P17_A239LegCUIL, BC000P17_A241LegDiscapacidad, BC000P17_A242LegDomici, BC000P17_A479LegEmail, BC000P17_A236LegCodPos, BC000P17_A265LegTelefono, BC000P17_n265LegTelefono, BC000P17_A245LegFecIngreso, BC000P17_A244LegFecEgreso, BC000P17_n244LegFecEgreso,
            BC000P17_A939LegCatCodigo, BC000P17_n939LegCatCodigo, BC000P17_A2215LegCatPueCod, BC000P17_n2215LegCatPueCod, BC000P17_A235LegClase, BC000P17_A248LegFormaPago, BC000P17_A231LegBanSuc, BC000P17_n231LegBanSuc, BC000P17_A232LegBanTipCuen, BC000P17_n232LegBanTipCuen,
            BC000P17_A238LegCuentaBanc, BC000P17_n238LegCuentaBanc, BC000P17_A253LegLicInicio, BC000P17_n253LegLicInicio, BC000P17_A252LegLicFinal, BC000P17_n252LegLicFinal, BC000P17_A234LegCBU, BC000P17_n234LegCBU, BC000P17_A262LegSCVO, BC000P17_A228LegActivo,
            BC000P17_A264LegSueldoFuera, BC000P17_A93LegId, BC000P17_n93LegId, BC000P17_A937LegConveCodigo, BC000P17_n937LegConveCodigo, BC000P17_A515LegObs, BC000P17_A630LegFecImportacion, BC000P17_A877LegAgenReten, BC000P17_A879LegContinua, BC000P17_A942LegRecalcLiq,
            BC000P17_A1016LegJubilado, BC000P17_A1023LegHorasDia, BC000P17_A1268LegHorasSem, BC000P17_A1245LegTrabLun, BC000P17_A1246LegTrabMar, BC000P17_A1247LegTrabMie, BC000P17_A1248LegTrabJue, BC000P17_A1249LegTrabVie, BC000P17_A1250LegTrabSa, BC000P17_A1251LegTrabDo,
            BC000P17_A1523LegVacPend, BC000P17_A1531LegFecPreAviso, BC000P17_A1576LegConveVersionCli, BC000P17_n1576LegConveVersionCli, BC000P17_A1759LegPromDias, BC000P17_A1804LegTitulo, BC000P17_A1818LegEstado, BC000P17_A2263LegMigrWarn, BC000P17_n2263LegMigrWarn, BC000P17_A2267LegIncompleto,
            BC000P17_A2309LegLiqApo, BC000P17_A2404LegModTra, BC000P17_A2417LegTipoTarifa, BC000P17_A1031LegFotoExt, BC000P17_A1030LegFotoNom, BC000P17_A3CliCod, BC000P17_A1582LegBanCod, BC000P17_n1582LegBanCod, BC000P17_A1581LegLpgCodigo, BC000P17_n1581LegLpgCodigo,
            BC000P17_A1583LegMegCodigo, BC000P17_n1583LegMegCodigo, BC000P17_A1580LegOsoCod, BC000P17_n1580LegOsoCod, BC000P17_A1579LegSecCodigo, BC000P17_n1579LegSecCodigo, BC000P17_A1EmpCod, BC000P17_A1577LegSucCodigo, BC000P17_n1577LegSucCodigo, BC000P17_A1578LegPuesCodigo,
            BC000P17_n1578LegPuesCodigo, BC000P17_A18MprCod, BC000P17_n18MprCod, BC000P17_A20ZonCod, BC000P17_n20ZonCod, BC000P17_A17CondiCodigo, BC000P17_n17CondiCodigo
            }
            , new Object[] {
            BC000P18_A19SinieCodigo, BC000P18_n19SinieCodigo, BC000P18_A263LegSexo, BC000P18_n263LegSexo, BC000P18_A243LegEstadoCivil, BC000P18_n243LegEstadoCivil, BC000P18_A22LegPaiCod, BC000P18_n22LegPaiCod, BC000P18_A23LegProvCod, BC000P18_n23LegProvCod,
            BC000P18_A24LegLocCod, BC000P18_n24LegLocCod, BC000P18_A21LegNacionCod, BC000P18_n21LegNacionCod, BC000P18_A910LegSinCod, BC000P18_n910LegSinCod, BC000P18_A2182LegActClasNro, BC000P18_n2182LegActClasNro, BC000P18_A15LegActCodigo, BC000P18_n15LegActCodigo,
            BC000P18_A1603LegSitRevEgreso, BC000P18_n1603LegSitRevEgreso, BC000P18_A2181LegPueAfiCod, BC000P18_n2181LegPueAfiCod, BC000P18_A1235LegReligion, BC000P18_n1235LegReligion, BC000P18_A1236LegOrigen, BC000P18_n1236LegOrigen, BC000P18_A237LegConvenio, BC000P18_A250LegIdNomApe,
            BC000P18_A591LegNomApe, BC000P18_A6LegNumero, BC000P18_A247LegFecUltMod, BC000P18_A230LegApellido, BC000P18_A251LegNombre, BC000P18_A249LegFoto, BC000P18_n249LegFoto, BC000P18_A266LegTipDoc, BC000P18_A257LegNumDoc, BC000P18_A246LegFecNac,
            BC000P18_A239LegCUIL, BC000P18_A241LegDiscapacidad, BC000P18_A242LegDomici, BC000P18_A479LegEmail, BC000P18_A236LegCodPos, BC000P18_A265LegTelefono, BC000P18_n265LegTelefono, BC000P18_A245LegFecIngreso, BC000P18_A244LegFecEgreso, BC000P18_n244LegFecEgreso,
            BC000P18_A939LegCatCodigo, BC000P18_n939LegCatCodigo, BC000P18_A2215LegCatPueCod, BC000P18_n2215LegCatPueCod, BC000P18_A235LegClase, BC000P18_A248LegFormaPago, BC000P18_A231LegBanSuc, BC000P18_n231LegBanSuc, BC000P18_A232LegBanTipCuen, BC000P18_n232LegBanTipCuen,
            BC000P18_A238LegCuentaBanc, BC000P18_n238LegCuentaBanc, BC000P18_A253LegLicInicio, BC000P18_n253LegLicInicio, BC000P18_A252LegLicFinal, BC000P18_n252LegLicFinal, BC000P18_A234LegCBU, BC000P18_n234LegCBU, BC000P18_A262LegSCVO, BC000P18_A228LegActivo,
            BC000P18_A264LegSueldoFuera, BC000P18_A93LegId, BC000P18_n93LegId, BC000P18_A937LegConveCodigo, BC000P18_n937LegConveCodigo, BC000P18_A515LegObs, BC000P18_A630LegFecImportacion, BC000P18_A877LegAgenReten, BC000P18_A879LegContinua, BC000P18_A942LegRecalcLiq,
            BC000P18_A1016LegJubilado, BC000P18_A1023LegHorasDia, BC000P18_A1268LegHorasSem, BC000P18_A1245LegTrabLun, BC000P18_A1246LegTrabMar, BC000P18_A1247LegTrabMie, BC000P18_A1248LegTrabJue, BC000P18_A1249LegTrabVie, BC000P18_A1250LegTrabSa, BC000P18_A1251LegTrabDo,
            BC000P18_A1523LegVacPend, BC000P18_A1531LegFecPreAviso, BC000P18_A1576LegConveVersionCli, BC000P18_n1576LegConveVersionCli, BC000P18_A1759LegPromDias, BC000P18_A1804LegTitulo, BC000P18_A1818LegEstado, BC000P18_A2263LegMigrWarn, BC000P18_n2263LegMigrWarn, BC000P18_A2267LegIncompleto,
            BC000P18_A2309LegLiqApo, BC000P18_A2404LegModTra, BC000P18_A2417LegTipoTarifa, BC000P18_A1031LegFotoExt, BC000P18_A1030LegFotoNom, BC000P18_A3CliCod, BC000P18_A1582LegBanCod, BC000P18_n1582LegBanCod, BC000P18_A1581LegLpgCodigo, BC000P18_n1581LegLpgCodigo,
            BC000P18_A1583LegMegCodigo, BC000P18_n1583LegMegCodigo, BC000P18_A1580LegOsoCod, BC000P18_n1580LegOsoCod, BC000P18_A1579LegSecCodigo, BC000P18_n1579LegSecCodigo, BC000P18_A1EmpCod, BC000P18_A1577LegSucCodigo, BC000P18_n1577LegSucCodigo, BC000P18_A1578LegPuesCodigo,
            BC000P18_n1578LegPuesCodigo, BC000P18_A18MprCod, BC000P18_n18MprCod, BC000P18_A20ZonCod, BC000P18_n20ZonCod, BC000P18_A17CondiCodigo, BC000P18_n17CondiCodigo
            }
            , new Object[] {
            BC000P19_A2224LegBanDes
            }
            , new Object[] {
            BC000P20_A291LpgDescri, BC000P20_n291LpgDescri
            }
            , new Object[] {
            BC000P21_A300MegDescrip, BC000P21_n300MegDescrip
            }
            , new Object[] {
            BC000P22_A2225LegOsoDes, BC000P22_A2226LegOsoAfipCod, BC000P22_n2226LegOsoAfipCod, BC000P22_A392OsoSigla, BC000P22_n392OsoSigla
            }
            , new Object[] {
            BC000P23_A329SecDescrip, BC000P23_n329SecDescrip
            }
            , new Object[] {
            BC000P24_A45TipEmpleCod, BC000P24_n45TipEmpleCod, BC000P24_A1965EmpOsoCod, BC000P24_n1965EmpOsoCod, BC000P24_A2EmpNom
            }
            , new Object[] {
            BC000P25_A3CliCod
            }
            , new Object[] {
            BC000P26_A3CliCod
            }
            , new Object[] {
            BC000P27_A684MprDescripSinAc, BC000P27_A303MprDescrip
            }
            , new Object[] {
            BC000P28_A678ZonDescripSinAc, BC000P28_A342ZonDescrip, BC000P28_A343ZonPorcReduc
            }
            , new Object[] {
            BC000P29_A686CondiDescriSinAc, BC000P29_A144CondiDescri
            }
            , new Object[] {
            BC000P30_A688SinieDescriSinAc, BC000P30_A333SinieDescri
            }
            , new Object[] {
            BC000P31_A263LegSexo
            }
            , new Object[] {
            BC000P32_A243LegEstadoCivil
            }
            , new Object[] {
            BC000P33_A258LegPaiNom
            }
            , new Object[] {
            BC000P34_A260LegProvNom
            }
            , new Object[] {
            BC000P35_A255LegLocNom
            }
            , new Object[] {
            BC000P36_A256LegNacionalidad
            }
            , new Object[] {
            BC000P37_A331SinDescrip, BC000P37_n331SinDescrip
            }
            , new Object[] {
            BC000P38_A22LegPaiCod
            }
            , new Object[] {
            BC000P39_A227LegActDescri
            }
            , new Object[] {
            BC000P40_A1603LegSitRevEgreso
            }
            , new Object[] {
            BC000P41_A2181LegPueAfiCod
            }
            , new Object[] {
            BC000P42_A307OsoDescrip, BC000P42_n307OsoDescrip, BC000P42_A306OsoC3992, BC000P42_n306OsoC3992
            }
            , new Object[] {
            BC000P43_A19SinieCodigo, BC000P43_n19SinieCodigo, BC000P43_A263LegSexo, BC000P43_n263LegSexo, BC000P43_A243LegEstadoCivil, BC000P43_n243LegEstadoCivil, BC000P43_A22LegPaiCod, BC000P43_n22LegPaiCod, BC000P43_A23LegProvCod, BC000P43_n23LegProvCod,
            BC000P43_A24LegLocCod, BC000P43_n24LegLocCod, BC000P43_A21LegNacionCod, BC000P43_n21LegNacionCod, BC000P43_A910LegSinCod, BC000P43_n910LegSinCod, BC000P43_A2182LegActClasNro, BC000P43_n2182LegActClasNro, BC000P43_A15LegActCodigo, BC000P43_n15LegActCodigo,
            BC000P43_A1603LegSitRevEgreso, BC000P43_n1603LegSitRevEgreso, BC000P43_A2181LegPueAfiCod, BC000P43_n2181LegPueAfiCod, BC000P43_A45TipEmpleCod, BC000P43_n45TipEmpleCod, BC000P43_A1235LegReligion, BC000P43_n1235LegReligion, BC000P43_A1236LegOrigen, BC000P43_n1236LegOrigen,
            BC000P43_A1965EmpOsoCod, BC000P43_n1965EmpOsoCod, BC000P43_A237LegConvenio, BC000P43_A688SinieDescriSinAc, BC000P43_A686CondiDescriSinAc, BC000P43_A678ZonDescripSinAc, BC000P43_A684MprDescripSinAc, BC000P43_A250LegIdNomApe, BC000P43_A591LegNomApe, BC000P43_A6LegNumero,
            BC000P43_A247LegFecUltMod, BC000P43_A2EmpNom, BC000P43_A230LegApellido, BC000P43_A251LegNombre, BC000P43_A249LegFoto, BC000P43_n249LegFoto, BC000P43_A266LegTipDoc, BC000P43_A257LegNumDoc, BC000P43_A246LegFecNac, BC000P43_A256LegNacionalidad,
            BC000P43_A239LegCUIL, BC000P43_A241LegDiscapacidad, BC000P43_A242LegDomici, BC000P43_A479LegEmail, BC000P43_A236LegCodPos, BC000P43_A258LegPaiNom, BC000P43_A260LegProvNom, BC000P43_A255LegLocNom, BC000P43_A265LegTelefono, BC000P43_n265LegTelefono,
            BC000P43_A245LegFecIngreso, BC000P43_A244LegFecEgreso, BC000P43_n244LegFecEgreso, BC000P43_A300MegDescrip, BC000P43_n300MegDescrip, BC000P43_A939LegCatCodigo, BC000P43_n939LegCatCodigo, BC000P43_A2215LegCatPueCod, BC000P43_n2215LegCatPueCod, BC000P43_A329SecDescrip,
            BC000P43_n329SecDescrip, BC000P43_A291LpgDescri, BC000P43_n291LpgDescri, BC000P43_A235LegClase, BC000P43_A248LegFormaPago, BC000P43_A2224LegBanDes, BC000P43_A231LegBanSuc, BC000P43_n231LegBanSuc, BC000P43_A232LegBanTipCuen, BC000P43_n232LegBanTipCuen,
            BC000P43_A331SinDescrip, BC000P43_n331SinDescrip, BC000P43_A2225LegOsoDes, BC000P43_A2226LegOsoAfipCod, BC000P43_n2226LegOsoAfipCod, BC000P43_A307OsoDescrip, BC000P43_n307OsoDescrip, BC000P43_A227LegActDescri, BC000P43_A303MprDescrip, BC000P43_A238LegCuentaBanc,
            BC000P43_n238LegCuentaBanc, BC000P43_A253LegLicInicio, BC000P43_n253LegLicInicio, BC000P43_A252LegLicFinal, BC000P43_n252LegLicFinal, BC000P43_A342ZonDescrip, BC000P43_A343ZonPorcReduc, BC000P43_A234LegCBU, BC000P43_n234LegCBU, BC000P43_A262LegSCVO,
            BC000P43_A144CondiDescri, BC000P43_A333SinieDescri, BC000P43_A228LegActivo, BC000P43_A264LegSueldoFuera, BC000P43_A93LegId, BC000P43_n93LegId, BC000P43_A937LegConveCodigo, BC000P43_n937LegConveCodigo, BC000P43_A306OsoC3992, BC000P43_n306OsoC3992,
            BC000P43_A515LegObs, BC000P43_A630LegFecImportacion, BC000P43_A877LegAgenReten, BC000P43_A879LegContinua, BC000P43_A942LegRecalcLiq, BC000P43_A1016LegJubilado, BC000P43_A1023LegHorasDia, BC000P43_A1268LegHorasSem, BC000P43_A1245LegTrabLun, BC000P43_A1246LegTrabMar,
            BC000P43_A1247LegTrabMie, BC000P43_A1248LegTrabJue, BC000P43_A1249LegTrabVie, BC000P43_A1250LegTrabSa, BC000P43_A1251LegTrabDo, BC000P43_A1523LegVacPend, BC000P43_A1531LegFecPreAviso, BC000P43_A1576LegConveVersionCli, BC000P43_n1576LegConveVersionCli, BC000P43_A1759LegPromDias,
            BC000P43_A1804LegTitulo, BC000P43_A1818LegEstado, BC000P43_A2263LegMigrWarn, BC000P43_n2263LegMigrWarn, BC000P43_A2267LegIncompleto, BC000P43_A2309LegLiqApo, BC000P43_A2404LegModTra, BC000P43_A2417LegTipoTarifa, BC000P43_A1031LegFotoExt, BC000P43_A1030LegFotoNom,
            BC000P43_A392OsoSigla, BC000P43_n392OsoSigla, BC000P43_A3CliCod, BC000P43_A1582LegBanCod, BC000P43_n1582LegBanCod, BC000P43_A1581LegLpgCodigo, BC000P43_n1581LegLpgCodigo, BC000P43_A1583LegMegCodigo, BC000P43_n1583LegMegCodigo, BC000P43_A1580LegOsoCod,
            BC000P43_n1580LegOsoCod, BC000P43_A1579LegSecCodigo, BC000P43_n1579LegSecCodigo, BC000P43_A1EmpCod, BC000P43_A1577LegSucCodigo, BC000P43_n1577LegSucCodigo, BC000P43_A1578LegPuesCodigo, BC000P43_n1578LegPuesCodigo, BC000P43_A18MprCod, BC000P43_n18MprCod,
            BC000P43_A20ZonCod, BC000P43_n20ZonCod, BC000P43_A17CondiCodigo, BC000P43_n17CondiCodigo
            }
            , new Object[] {
            BC000P44_A2224LegBanDes
            }
            , new Object[] {
            BC000P45_A291LpgDescri, BC000P45_n291LpgDescri
            }
            , new Object[] {
            BC000P46_A300MegDescrip, BC000P46_n300MegDescrip
            }
            , new Object[] {
            BC000P47_A2225LegOsoDes, BC000P47_A2226LegOsoAfipCod, BC000P47_n2226LegOsoAfipCod, BC000P47_A392OsoSigla, BC000P47_n392OsoSigla
            }
            , new Object[] {
            BC000P48_A329SecDescrip, BC000P48_n329SecDescrip
            }
            , new Object[] {
            BC000P49_A3CliCod
            }
            , new Object[] {
            BC000P50_A45TipEmpleCod, BC000P50_n45TipEmpleCod, BC000P50_A1965EmpOsoCod, BC000P50_n1965EmpOsoCod, BC000P50_A2EmpNom
            }
            , new Object[] {
            BC000P51_A307OsoDescrip, BC000P51_n307OsoDescrip, BC000P51_A306OsoC3992, BC000P51_n306OsoC3992
            }
            , new Object[] {
            BC000P52_A3CliCod
            }
            , new Object[] {
            BC000P53_A263LegSexo
            }
            , new Object[] {
            BC000P54_A243LegEstadoCivil
            }
            , new Object[] {
            BC000P55_A256LegNacionalidad
            }
            , new Object[] {
            BC000P56_A258LegPaiNom
            }
            , new Object[] {
            BC000P57_A260LegProvNom
            }
            , new Object[] {
            BC000P58_A255LegLocNom
            }
            , new Object[] {
            BC000P59_A331SinDescrip, BC000P59_n331SinDescrip
            }
            , new Object[] {
            BC000P60_A22LegPaiCod
            }
            , new Object[] {
            BC000P61_A227LegActDescri
            }
            , new Object[] {
            BC000P62_A684MprDescripSinAc, BC000P62_A303MprDescrip
            }
            , new Object[] {
            BC000P63_A678ZonDescripSinAc, BC000P63_A342ZonDescrip, BC000P63_A343ZonPorcReduc
            }
            , new Object[] {
            BC000P64_A686CondiDescriSinAc, BC000P64_A144CondiDescri
            }
            , new Object[] {
            BC000P65_A688SinieDescriSinAc, BC000P65_A333SinieDescri
            }
            , new Object[] {
            BC000P66_A1603LegSitRevEgreso
            }
            , new Object[] {
            BC000P67_A2181LegPueAfiCod
            }
            , new Object[] {
            BC000P68_A3CliCod, BC000P68_A1EmpCod, BC000P68_A6LegNumero
            }
            , new Object[] {
            BC000P69_A19SinieCodigo, BC000P69_n19SinieCodigo, BC000P69_A263LegSexo, BC000P69_n263LegSexo, BC000P69_A243LegEstadoCivil, BC000P69_n243LegEstadoCivil, BC000P69_A22LegPaiCod, BC000P69_n22LegPaiCod, BC000P69_A23LegProvCod, BC000P69_n23LegProvCod,
            BC000P69_A24LegLocCod, BC000P69_n24LegLocCod, BC000P69_A21LegNacionCod, BC000P69_n21LegNacionCod, BC000P69_A910LegSinCod, BC000P69_n910LegSinCod, BC000P69_A2182LegActClasNro, BC000P69_n2182LegActClasNro, BC000P69_A15LegActCodigo, BC000P69_n15LegActCodigo,
            BC000P69_A1603LegSitRevEgreso, BC000P69_n1603LegSitRevEgreso, BC000P69_A2181LegPueAfiCod, BC000P69_n2181LegPueAfiCod, BC000P69_A1235LegReligion, BC000P69_n1235LegReligion, BC000P69_A1236LegOrigen, BC000P69_n1236LegOrigen, BC000P69_A237LegConvenio, BC000P69_A250LegIdNomApe,
            BC000P69_A591LegNomApe, BC000P69_A6LegNumero, BC000P69_A247LegFecUltMod, BC000P69_A230LegApellido, BC000P69_A251LegNombre, BC000P69_A249LegFoto, BC000P69_n249LegFoto, BC000P69_A266LegTipDoc, BC000P69_A257LegNumDoc, BC000P69_A246LegFecNac,
            BC000P69_A239LegCUIL, BC000P69_A241LegDiscapacidad, BC000P69_A242LegDomici, BC000P69_A479LegEmail, BC000P69_A236LegCodPos, BC000P69_A265LegTelefono, BC000P69_n265LegTelefono, BC000P69_A245LegFecIngreso, BC000P69_A244LegFecEgreso, BC000P69_n244LegFecEgreso,
            BC000P69_A939LegCatCodigo, BC000P69_n939LegCatCodigo, BC000P69_A2215LegCatPueCod, BC000P69_n2215LegCatPueCod, BC000P69_A235LegClase, BC000P69_A248LegFormaPago, BC000P69_A231LegBanSuc, BC000P69_n231LegBanSuc, BC000P69_A232LegBanTipCuen, BC000P69_n232LegBanTipCuen,
            BC000P69_A238LegCuentaBanc, BC000P69_n238LegCuentaBanc, BC000P69_A253LegLicInicio, BC000P69_n253LegLicInicio, BC000P69_A252LegLicFinal, BC000P69_n252LegLicFinal, BC000P69_A234LegCBU, BC000P69_n234LegCBU, BC000P69_A262LegSCVO, BC000P69_A228LegActivo,
            BC000P69_A264LegSueldoFuera, BC000P69_A93LegId, BC000P69_n93LegId, BC000P69_A937LegConveCodigo, BC000P69_n937LegConveCodigo, BC000P69_A515LegObs, BC000P69_A630LegFecImportacion, BC000P69_A877LegAgenReten, BC000P69_A879LegContinua, BC000P69_A942LegRecalcLiq,
            BC000P69_A1016LegJubilado, BC000P69_A1023LegHorasDia, BC000P69_A1268LegHorasSem, BC000P69_A1245LegTrabLun, BC000P69_A1246LegTrabMar, BC000P69_A1247LegTrabMie, BC000P69_A1248LegTrabJue, BC000P69_A1249LegTrabVie, BC000P69_A1250LegTrabSa, BC000P69_A1251LegTrabDo,
            BC000P69_A1523LegVacPend, BC000P69_A1531LegFecPreAviso, BC000P69_A1576LegConveVersionCli, BC000P69_n1576LegConveVersionCli, BC000P69_A1759LegPromDias, BC000P69_A1804LegTitulo, BC000P69_A1818LegEstado, BC000P69_A2263LegMigrWarn, BC000P69_n2263LegMigrWarn, BC000P69_A2267LegIncompleto,
            BC000P69_A2309LegLiqApo, BC000P69_A2404LegModTra, BC000P69_A2417LegTipoTarifa, BC000P69_A1031LegFotoExt, BC000P69_A1030LegFotoNom, BC000P69_A3CliCod, BC000P69_A1582LegBanCod, BC000P69_n1582LegBanCod, BC000P69_A1581LegLpgCodigo, BC000P69_n1581LegLpgCodigo,
            BC000P69_A1583LegMegCodigo, BC000P69_n1583LegMegCodigo, BC000P69_A1580LegOsoCod, BC000P69_n1580LegOsoCod, BC000P69_A1579LegSecCodigo, BC000P69_n1579LegSecCodigo, BC000P69_A1EmpCod, BC000P69_A1577LegSucCodigo, BC000P69_n1577LegSucCodigo, BC000P69_A1578LegPuesCodigo,
            BC000P69_n1578LegPuesCodigo, BC000P69_A18MprCod, BC000P69_n18MprCod, BC000P69_A20ZonCod, BC000P69_n20ZonCod, BC000P69_A17CondiCodigo, BC000P69_n17CondiCodigo
            }
            , new Object[] {
            BC000P70_A19SinieCodigo, BC000P70_n19SinieCodigo, BC000P70_A263LegSexo, BC000P70_n263LegSexo, BC000P70_A243LegEstadoCivil, BC000P70_n243LegEstadoCivil, BC000P70_A22LegPaiCod, BC000P70_n22LegPaiCod, BC000P70_A23LegProvCod, BC000P70_n23LegProvCod,
            BC000P70_A24LegLocCod, BC000P70_n24LegLocCod, BC000P70_A21LegNacionCod, BC000P70_n21LegNacionCod, BC000P70_A910LegSinCod, BC000P70_n910LegSinCod, BC000P70_A2182LegActClasNro, BC000P70_n2182LegActClasNro, BC000P70_A15LegActCodigo, BC000P70_n15LegActCodigo,
            BC000P70_A1603LegSitRevEgreso, BC000P70_n1603LegSitRevEgreso, BC000P70_A2181LegPueAfiCod, BC000P70_n2181LegPueAfiCod, BC000P70_A1235LegReligion, BC000P70_n1235LegReligion, BC000P70_A1236LegOrigen, BC000P70_n1236LegOrigen, BC000P70_A237LegConvenio, BC000P70_A250LegIdNomApe,
            BC000P70_A591LegNomApe, BC000P70_A6LegNumero, BC000P70_A247LegFecUltMod, BC000P70_A230LegApellido, BC000P70_A251LegNombre, BC000P70_A249LegFoto, BC000P70_n249LegFoto, BC000P70_A266LegTipDoc, BC000P70_A257LegNumDoc, BC000P70_A246LegFecNac,
            BC000P70_A239LegCUIL, BC000P70_A241LegDiscapacidad, BC000P70_A242LegDomici, BC000P70_A479LegEmail, BC000P70_A236LegCodPos, BC000P70_A265LegTelefono, BC000P70_n265LegTelefono, BC000P70_A245LegFecIngreso, BC000P70_A244LegFecEgreso, BC000P70_n244LegFecEgreso,
            BC000P70_A939LegCatCodigo, BC000P70_n939LegCatCodigo, BC000P70_A2215LegCatPueCod, BC000P70_n2215LegCatPueCod, BC000P70_A235LegClase, BC000P70_A248LegFormaPago, BC000P70_A231LegBanSuc, BC000P70_n231LegBanSuc, BC000P70_A232LegBanTipCuen, BC000P70_n232LegBanTipCuen,
            BC000P70_A238LegCuentaBanc, BC000P70_n238LegCuentaBanc, BC000P70_A253LegLicInicio, BC000P70_n253LegLicInicio, BC000P70_A252LegLicFinal, BC000P70_n252LegLicFinal, BC000P70_A234LegCBU, BC000P70_n234LegCBU, BC000P70_A262LegSCVO, BC000P70_A228LegActivo,
            BC000P70_A264LegSueldoFuera, BC000P70_A93LegId, BC000P70_n93LegId, BC000P70_A937LegConveCodigo, BC000P70_n937LegConveCodigo, BC000P70_A515LegObs, BC000P70_A630LegFecImportacion, BC000P70_A877LegAgenReten, BC000P70_A879LegContinua, BC000P70_A942LegRecalcLiq,
            BC000P70_A1016LegJubilado, BC000P70_A1023LegHorasDia, BC000P70_A1268LegHorasSem, BC000P70_A1245LegTrabLun, BC000P70_A1246LegTrabMar, BC000P70_A1247LegTrabMie, BC000P70_A1248LegTrabJue, BC000P70_A1249LegTrabVie, BC000P70_A1250LegTrabSa, BC000P70_A1251LegTrabDo,
            BC000P70_A1523LegVacPend, BC000P70_A1531LegFecPreAviso, BC000P70_A1576LegConveVersionCli, BC000P70_n1576LegConveVersionCli, BC000P70_A1759LegPromDias, BC000P70_A1804LegTitulo, BC000P70_A1818LegEstado, BC000P70_A2263LegMigrWarn, BC000P70_n2263LegMigrWarn, BC000P70_A2267LegIncompleto,
            BC000P70_A2309LegLiqApo, BC000P70_A2404LegModTra, BC000P70_A2417LegTipoTarifa, BC000P70_A1031LegFotoExt, BC000P70_A1030LegFotoNom, BC000P70_A3CliCod, BC000P70_A1582LegBanCod, BC000P70_n1582LegBanCod, BC000P70_A1581LegLpgCodigo, BC000P70_n1581LegLpgCodigo,
            BC000P70_A1583LegMegCodigo, BC000P70_n1583LegMegCodigo, BC000P70_A1580LegOsoCod, BC000P70_n1580LegOsoCod, BC000P70_A1579LegSecCodigo, BC000P70_n1579LegSecCodigo, BC000P70_A1EmpCod, BC000P70_A1577LegSucCodigo, BC000P70_n1577LegSucCodigo, BC000P70_A1578LegPuesCodigo,
            BC000P70_n1578LegPuesCodigo, BC000P70_A18MprCod, BC000P70_n18MprCod, BC000P70_A20ZonCod, BC000P70_n20ZonCod, BC000P70_A17CondiCodigo, BC000P70_n17CondiCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000P75_A1965EmpOsoCod, BC000P75_n1965EmpOsoCod, BC000P75_A2EmpNom, BC000P75_A45TipEmpleCod, BC000P75_n45TipEmpleCod
            }
            , new Object[] {
            BC000P76_A307OsoDescrip, BC000P76_n307OsoDescrip, BC000P76_A306OsoC3992, BC000P76_n306OsoC3992
            }
            , new Object[] {
            BC000P77_A256LegNacionalidad
            }
            , new Object[] {
            BC000P78_A258LegPaiNom
            }
            , new Object[] {
            BC000P79_A260LegProvNom
            }
            , new Object[] {
            BC000P80_A255LegLocNom
            }
            , new Object[] {
            BC000P81_A300MegDescrip, BC000P81_n300MegDescrip
            }
            , new Object[] {
            BC000P82_A329SecDescrip, BC000P82_n329SecDescrip
            }
            , new Object[] {
            BC000P83_A291LpgDescri, BC000P83_n291LpgDescri
            }
            , new Object[] {
            BC000P84_A2224LegBanDes
            }
            , new Object[] {
            BC000P85_A331SinDescrip, BC000P85_n331SinDescrip
            }
            , new Object[] {
            BC000P86_A2225LegOsoDes, BC000P86_A2226LegOsoAfipCod, BC000P86_n2226LegOsoAfipCod, BC000P86_A392OsoSigla, BC000P86_n392OsoSigla
            }
            , new Object[] {
            BC000P87_A227LegActDescri
            }
            , new Object[] {
            BC000P88_A684MprDescripSinAc, BC000P88_A303MprDescrip
            }
            , new Object[] {
            BC000P89_A678ZonDescripSinAc, BC000P89_A342ZonDescrip, BC000P89_A343ZonPorcReduc
            }
            , new Object[] {
            BC000P90_A686CondiDescriSinAc, BC000P90_A144CondiDescri
            }
            , new Object[] {
            BC000P91_A688SinieDescriSinAc, BC000P91_A333SinieDescri
            }
            , new Object[] {
            BC000P92_A3CliCod, BC000P92_A1EmpCod, BC000P92_A6LegNumero, BC000P92_A2243LegCuenLicTpo, BC000P92_A2266LegCuenAnio
            }
            , new Object[] {
            BC000P93_A3CliCod, BC000P93_A1EmpCod, BC000P93_A6LegNumero, BC000P93_A2253LegHisFecIng
            }
            , new Object[] {
            BC000P94_A3CliCod, BC000P94_A1EmpCod, BC000P94_A6LegNumero, BC000P94_A1829PreliqTLiqCod, BC000P94_A1830PreliqPeriodo
            }
            , new Object[] {
            BC000P95_A3CliCod, BC000P95_A1EmpCod, BC000P95_A6LegNumero, BC000P95_A1172OblSecuencial
            }
            , new Object[] {
            BC000P96_A3CliCod, BC000P96_A1EmpCod, BC000P96_A6LegNumero, BC000P96_A1135LegSuelSec
            }
            , new Object[] {
            BC000P97_A3CliCod, BC000P97_A1EmpCod, BC000P97_A784F1357CTipoPre, BC000P97_A777F1357CPer, BC000P97_A778F1357CSec, BC000P97_A6LegNumero, BC000P97_A797F1357LRTipReg
            }
            , new Object[] {
            BC000P98_A3CliCod, BC000P98_A1EmpCod, BC000P98_A784F1357CTipoPre, BC000P98_A777F1357CPer, BC000P98_A778F1357CSec, BC000P98_A6LegNumero, BC000P98_A863F1357LDGTipReg
            }
            , new Object[] {
            BC000P99_A3CliCod, BC000P99_A1EmpCod, BC000P99_A784F1357CTipoPre, BC000P99_A777F1357CPer, BC000P99_A778F1357CSec, BC000P99_A6LegNumero, BC000P99_A786F1357LTipoReg
            }
            , new Object[] {
            BC000P100_A3CliCod, BC000P100_A1EmpCod, BC000P100_A784F1357CTipoPre, BC000P100_A777F1357CPer, BC000P100_A778F1357CSec, BC000P100_A6LegNumero, BC000P100_A862F1357LDPTipReg
            }
            , new Object[] {
            BC000P101_A3CliCod, BC000P101_A1EmpCod, BC000P101_A784F1357CTipoPre, BC000P101_A777F1357CPer, BC000P101_A778F1357CSec, BC000P101_A6LegNumero, BC000P101_A861F1357LCTipReg
            }
            , new Object[] {
            BC000P102_A3CliCod, BC000P102_A1EmpCod, BC000P102_A6LegNumero, BC000P102_A83LegDedSec
            }
            , new Object[] {
            BC000P103_A3CliCod, BC000P103_A1EmpCod, BC000P103_A6LegNumero, BC000P103_A77CenCodigo
            }
            , new Object[] {
            BC000P104_A3CliCod, BC000P104_A1EmpCod, BC000P104_A6LegNumero, BC000P104_A76LegLicenIni
            }
            , new Object[] {
            BC000P105_A3CliCod, BC000P105_A1EmpCod, BC000P105_A31LiqNro, BC000P105_A6LegNumero
            }
            , new Object[] {
            BC000P106_A3CliCod, BC000P106_A1EmpCod, BC000P106_A6LegNumero, BC000P106_A25AgeOrden
            }
            , new Object[] {
            BC000P107_A19SinieCodigo, BC000P107_n19SinieCodigo, BC000P107_A263LegSexo, BC000P107_n263LegSexo, BC000P107_A243LegEstadoCivil, BC000P107_n243LegEstadoCivil, BC000P107_A22LegPaiCod, BC000P107_n22LegPaiCod, BC000P107_A23LegProvCod, BC000P107_n23LegProvCod,
            BC000P107_A24LegLocCod, BC000P107_n24LegLocCod, BC000P107_A21LegNacionCod, BC000P107_n21LegNacionCod, BC000P107_A910LegSinCod, BC000P107_n910LegSinCod, BC000P107_A2182LegActClasNro, BC000P107_n2182LegActClasNro, BC000P107_A15LegActCodigo, BC000P107_n15LegActCodigo,
            BC000P107_A1603LegSitRevEgreso, BC000P107_n1603LegSitRevEgreso, BC000P107_A2181LegPueAfiCod, BC000P107_n2181LegPueAfiCod, BC000P107_A45TipEmpleCod, BC000P107_n45TipEmpleCod, BC000P107_A1235LegReligion, BC000P107_n1235LegReligion, BC000P107_A1236LegOrigen, BC000P107_n1236LegOrigen,
            BC000P107_A1965EmpOsoCod, BC000P107_n1965EmpOsoCod, BC000P107_A237LegConvenio, BC000P107_A688SinieDescriSinAc, BC000P107_A686CondiDescriSinAc, BC000P107_A678ZonDescripSinAc, BC000P107_A684MprDescripSinAc, BC000P107_A250LegIdNomApe, BC000P107_A591LegNomApe, BC000P107_A6LegNumero,
            BC000P107_A247LegFecUltMod, BC000P107_A2EmpNom, BC000P107_A230LegApellido, BC000P107_A251LegNombre, BC000P107_A249LegFoto, BC000P107_n249LegFoto, BC000P107_A266LegTipDoc, BC000P107_A257LegNumDoc, BC000P107_A246LegFecNac, BC000P107_A256LegNacionalidad,
            BC000P107_A239LegCUIL, BC000P107_A241LegDiscapacidad, BC000P107_A242LegDomici, BC000P107_A479LegEmail, BC000P107_A236LegCodPos, BC000P107_A258LegPaiNom, BC000P107_A260LegProvNom, BC000P107_A255LegLocNom, BC000P107_A265LegTelefono, BC000P107_n265LegTelefono,
            BC000P107_A245LegFecIngreso, BC000P107_A244LegFecEgreso, BC000P107_n244LegFecEgreso, BC000P107_A300MegDescrip, BC000P107_n300MegDescrip, BC000P107_A939LegCatCodigo, BC000P107_n939LegCatCodigo, BC000P107_A2215LegCatPueCod, BC000P107_n2215LegCatPueCod, BC000P107_A329SecDescrip,
            BC000P107_n329SecDescrip, BC000P107_A291LpgDescri, BC000P107_n291LpgDescri, BC000P107_A235LegClase, BC000P107_A248LegFormaPago, BC000P107_A2224LegBanDes, BC000P107_A231LegBanSuc, BC000P107_n231LegBanSuc, BC000P107_A232LegBanTipCuen, BC000P107_n232LegBanTipCuen,
            BC000P107_A331SinDescrip, BC000P107_n331SinDescrip, BC000P107_A2225LegOsoDes, BC000P107_A2226LegOsoAfipCod, BC000P107_n2226LegOsoAfipCod, BC000P107_A307OsoDescrip, BC000P107_n307OsoDescrip, BC000P107_A227LegActDescri, BC000P107_A303MprDescrip, BC000P107_A238LegCuentaBanc,
            BC000P107_n238LegCuentaBanc, BC000P107_A253LegLicInicio, BC000P107_n253LegLicInicio, BC000P107_A252LegLicFinal, BC000P107_n252LegLicFinal, BC000P107_A342ZonDescrip, BC000P107_A343ZonPorcReduc, BC000P107_A234LegCBU, BC000P107_n234LegCBU, BC000P107_A262LegSCVO,
            BC000P107_A144CondiDescri, BC000P107_A333SinieDescri, BC000P107_A228LegActivo, BC000P107_A264LegSueldoFuera, BC000P107_A93LegId, BC000P107_n93LegId, BC000P107_A937LegConveCodigo, BC000P107_n937LegConveCodigo, BC000P107_A306OsoC3992, BC000P107_n306OsoC3992,
            BC000P107_A515LegObs, BC000P107_A630LegFecImportacion, BC000P107_A877LegAgenReten, BC000P107_A879LegContinua, BC000P107_A942LegRecalcLiq, BC000P107_A1016LegJubilado, BC000P107_A1023LegHorasDia, BC000P107_A1268LegHorasSem, BC000P107_A1245LegTrabLun, BC000P107_A1246LegTrabMar,
            BC000P107_A1247LegTrabMie, BC000P107_A1248LegTrabJue, BC000P107_A1249LegTrabVie, BC000P107_A1250LegTrabSa, BC000P107_A1251LegTrabDo, BC000P107_A1523LegVacPend, BC000P107_A1531LegFecPreAviso, BC000P107_A1576LegConveVersionCli, BC000P107_n1576LegConveVersionCli, BC000P107_A1759LegPromDias,
            BC000P107_A1804LegTitulo, BC000P107_A1818LegEstado, BC000P107_A2263LegMigrWarn, BC000P107_n2263LegMigrWarn, BC000P107_A2267LegIncompleto, BC000P107_A2309LegLiqApo, BC000P107_A2404LegModTra, BC000P107_A2417LegTipoTarifa, BC000P107_A1031LegFotoExt, BC000P107_A1030LegFotoNom,
            BC000P107_A392OsoSigla, BC000P107_n392OsoSigla, BC000P107_A3CliCod, BC000P107_A1582LegBanCod, BC000P107_n1582LegBanCod, BC000P107_A1581LegLpgCodigo, BC000P107_n1581LegLpgCodigo, BC000P107_A1583LegMegCodigo, BC000P107_n1583LegMegCodigo, BC000P107_A1580LegOsoCod,
            BC000P107_n1580LegOsoCod, BC000P107_A1579LegSecCodigo, BC000P107_n1579LegSecCodigo, BC000P107_A1EmpCod, BC000P107_A1577LegSucCodigo, BC000P107_n1577LegSucCodigo, BC000P107_A1578LegPuesCodigo, BC000P107_n1578LegPuesCodigo, BC000P107_A18MprCod, BC000P107_n18MprCod,
            BC000P107_A20ZonCod, BC000P107_n20ZonCod, BC000P107_A17CondiCodigo, BC000P107_n17CondiCodigo
            }
            , new Object[] {
            BC000P108_A3CliCod, BC000P108_A1EmpCod, BC000P108_A6LegNumero, BC000P108_A1135LegSuelSec, BC000P108_A1136LegSuelFecha, BC000P108_A1137LegSuelImporte, BC000P108_A2344LegSuelTipo, BC000P108_n2344LegSuelTipo, BC000P108_A2347LegSuelCalc, BC000P108_A2348LegSuelLog
            }
            , new Object[] {
            BC000P109_A3CliCod, BC000P109_A1EmpCod, BC000P109_A6LegNumero, BC000P109_A1135LegSuelSec
            }
            , new Object[] {
            BC000P110_A3CliCod, BC000P110_A1EmpCod, BC000P110_A6LegNumero, BC000P110_A1135LegSuelSec, BC000P110_A1136LegSuelFecha, BC000P110_A1137LegSuelImporte, BC000P110_A2344LegSuelTipo, BC000P110_n2344LegSuelTipo, BC000P110_A2347LegSuelCalc, BC000P110_A2348LegSuelLog
            }
            , new Object[] {
            BC000P111_A3CliCod, BC000P111_A1EmpCod, BC000P111_A6LegNumero, BC000P111_A1135LegSuelSec, BC000P111_A1136LegSuelFecha, BC000P111_A1137LegSuelImporte, BC000P111_A2344LegSuelTipo, BC000P111_n2344LegSuelTipo, BC000P111_A2347LegSuelCalc, BC000P111_A2348LegSuelLog
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000P115_A3CliCod, BC000P115_A1EmpCod, BC000P115_A6LegNumero, BC000P115_A1135LegSuelSec, BC000P115_A1136LegSuelFecha, BC000P115_A1137LegSuelImporte, BC000P115_A2344LegSuelTipo, BC000P115_n2344LegSuelTipo, BC000P115_A2347LegSuelCalc, BC000P115_A2348LegSuelLog
            }
            , new Object[] {
            BC000P116_A3CliCod, BC000P116_A2349LegSuelConcepto, BC000P116_A1EmpCod, BC000P116_A6LegNumero, BC000P116_A1135LegSuelSec
            }
            , new Object[] {
            BC000P117_A3CliCod
            }
            , new Object[] {
            BC000P118_A3CliCod, BC000P118_A1EmpCod, BC000P118_A6LegNumero, BC000P118_A1135LegSuelSec, BC000P118_A2349LegSuelConcepto
            }
            , new Object[] {
            BC000P119_A3CliCod, BC000P119_A2349LegSuelConcepto, BC000P119_A1EmpCod, BC000P119_A6LegNumero, BC000P119_A1135LegSuelSec
            }
            , new Object[] {
            BC000P120_A3CliCod, BC000P120_A2349LegSuelConcepto, BC000P120_A1EmpCod, BC000P120_A6LegNumero, BC000P120_A1135LegSuelSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000P123_A3CliCod, BC000P123_A2349LegSuelConcepto, BC000P123_A1EmpCod, BC000P123_A6LegNumero, BC000P123_A1135LegSuelSec
            }
            , new Object[] {
            BC000P124_A6LegNumero, BC000P124_A29LegOrden, BC000P124_A220FamTomaDeducImpGan, BC000P124_A2090FamNomApe, BC000P124_A209FamFecNac, BC000P124_n209FamFecNac, BC000P124_A205FamDiscap, BC000P124_n205FamDiscap, BC000P124_A750FamNroDoc, BC000P124_A890FamAdherente,
            BC000P124_A3CliCod, BC000P124_A30ParCod, BC000P124_A1EmpCod, BC000P124_A1547GuarCod, BC000P124_n1547GuarCod
            }
            , new Object[] {
            BC000P125_A3CliCod
            }
            , new Object[] {
            BC000P126_A3CliCod
            }
            , new Object[] {
            BC000P127_A3CliCod, BC000P127_A1EmpCod, BC000P127_A6LegNumero, BC000P127_A29LegOrden
            }
            , new Object[] {
            BC000P128_A6LegNumero, BC000P128_A29LegOrden, BC000P128_A220FamTomaDeducImpGan, BC000P128_A2090FamNomApe, BC000P128_A209FamFecNac, BC000P128_n209FamFecNac, BC000P128_A205FamDiscap, BC000P128_n205FamDiscap, BC000P128_A750FamNroDoc, BC000P128_A890FamAdherente,
            BC000P128_A3CliCod, BC000P128_A30ParCod, BC000P128_A1EmpCod, BC000P128_A1547GuarCod, BC000P128_n1547GuarCod
            }
            , new Object[] {
            BC000P129_A6LegNumero, BC000P129_A29LegOrden, BC000P129_A220FamTomaDeducImpGan, BC000P129_A2090FamNomApe, BC000P129_A209FamFecNac, BC000P129_n209FamFecNac, BC000P129_A205FamDiscap, BC000P129_n205FamDiscap, BC000P129_A750FamNroDoc, BC000P129_A890FamAdherente,
            BC000P129_A3CliCod, BC000P129_A30ParCod, BC000P129_A1EmpCod, BC000P129_A1547GuarCod, BC000P129_n1547GuarCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000P133_A6LegNumero, BC000P133_A29LegOrden, BC000P133_A220FamTomaDeducImpGan, BC000P133_A2090FamNomApe, BC000P133_A209FamFecNac, BC000P133_n209FamFecNac, BC000P133_A205FamDiscap, BC000P133_n205FamDiscap, BC000P133_A750FamNroDoc, BC000P133_A890FamAdherente,
            BC000P133_A3CliCod, BC000P133_A30ParCod, BC000P133_A1EmpCod, BC000P133_A1547GuarCod, BC000P133_n1547GuarCod
            }
            , new Object[] {
            BC000P134_A3CliCod, BC000P134_A1EmpCod, BC000P134_A6LegNumero, BC000P134_A1319LegTipoTra
            }
            , new Object[] {
            BC000P135_A1292TipoTraId
            }
            , new Object[] {
            BC000P136_A3CliCod, BC000P136_A1EmpCod, BC000P136_A6LegNumero, BC000P136_A1319LegTipoTra
            }
            , new Object[] {
            BC000P137_A3CliCod, BC000P137_A1EmpCod, BC000P137_A6LegNumero, BC000P137_A1319LegTipoTra
            }
            , new Object[] {
            BC000P138_A3CliCod, BC000P138_A1EmpCod, BC000P138_A6LegNumero, BC000P138_A1319LegTipoTra
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000P141_A3CliCod, BC000P141_A1EmpCod, BC000P141_A6LegNumero, BC000P141_A1319LegTipoTra
            }
            , new Object[] {
            BC000P142_A3CliCod, BC000P142_A1EmpCod, BC000P142_A6LegNumero, BC000P142_A2231LegPropDes, BC000P142_A2232LegPropTD, BC000P142_A2233LegPropValNum, BC000P142_A2234LegPropValBool, BC000P142_A2235LegPropValStr, BC000P142_A2236LegPropValDate, BC000P142_A2230LegPropCod
            }
            , new Object[] {
            BC000P143_A2231LegPropDes, BC000P143_A2232LegPropTD
            }
            , new Object[] {
            BC000P144_A3CliCod, BC000P144_A1EmpCod, BC000P144_A6LegNumero, BC000P144_A2230LegPropCod
            }
            , new Object[] {
            BC000P145_A3CliCod, BC000P145_A1EmpCod, BC000P145_A6LegNumero, BC000P145_A2233LegPropValNum, BC000P145_A2234LegPropValBool, BC000P145_A2235LegPropValStr, BC000P145_A2236LegPropValDate, BC000P145_A2230LegPropCod
            }
            , new Object[] {
            BC000P146_A3CliCod, BC000P146_A1EmpCod, BC000P146_A6LegNumero, BC000P146_A2233LegPropValNum, BC000P146_A2234LegPropValBool, BC000P146_A2235LegPropValStr, BC000P146_A2236LegPropValDate, BC000P146_A2230LegPropCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000P150_A2231LegPropDes, BC000P150_A2232LegPropTD
            }
            , new Object[] {
            BC000P151_A3CliCod, BC000P151_A1EmpCod, BC000P151_A6LegNumero, BC000P151_A2231LegPropDes, BC000P151_A2232LegPropTD, BC000P151_A2233LegPropValNum, BC000P151_A2234LegPropValBool, BC000P151_A2235LegPropValStr, BC000P151_A2236LegPropValDate, BC000P151_A2230LegPropCod
            }
            , new Object[] {
            BC000P152_A45TipEmpleCod, BC000P152_n45TipEmpleCod, BC000P152_A1965EmpOsoCod, BC000P152_n1965EmpOsoCod, BC000P152_A2EmpNom
            }
            , new Object[] {
            BC000P153_A307OsoDescrip, BC000P153_n307OsoDescrip, BC000P153_A306OsoC3992, BC000P153_n306OsoC3992
            }
            , new Object[] {
            BC000P154_A45TipEmpleCod, BC000P154_n45TipEmpleCod, BC000P154_A1965EmpOsoCod, BC000P154_n1965EmpOsoCod, BC000P154_A2EmpNom
            }
            , new Object[] {
            BC000P155_A307OsoDescrip, BC000P155_n307OsoDescrip, BC000P155_A306OsoC3992, BC000P155_n306OsoC3992
            }
         }
      );
      AV141Pgmname = "Legajo_BC" ;
      Z220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
      A220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
      i220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
      Z879LegContinua = "" ;
      A879LegContinua = "" ;
      i879LegContinua = "" ;
      Z262LegSCVO = true ;
      A262LegSCVO = true ;
      i262LegSCVO = true ;
      Z248LegFormaPago = (byte)(3) ;
      A248LegFormaPago = (byte)(3) ;
      i248LegFormaPago = (byte)(3) ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120P2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte AV125Insert_LegSexo ;
   private byte Z266LegTipDoc ;
   private byte A266LegTipDoc ;
   private byte Z241LegDiscapacidad ;
   private byte A241LegDiscapacidad ;
   private byte Z235LegClase ;
   private byte A235LegClase ;
   private byte Z248LegFormaPago ;
   private byte A248LegFormaPago ;
   private byte Z1818LegEstado ;
   private byte A1818LegEstado ;
   private byte Z263LegSexo ;
   private byte A263LegSexo ;
   private byte Gx_BScreen ;
   private byte AV104LegSexo ;
   private byte Gxremove129 ;
   private byte Gxremove24 ;
   private byte Gxremove170 ;
   private byte Gxremove276 ;
   private byte Gxremove292 ;
   private byte i248LegFormaPago ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short nIsMod_276 ;
   private short RcdFound276 ;
   private short nIsMod_170 ;
   private short RcdFound170 ;
   private short nIsMod_24 ;
   private short RcdFound24 ;
   private short nIsMod_292 ;
   private short RcdFound292 ;
   private short nIsMod_129 ;
   private short RcdFound129 ;
   private short AV7EmpCod ;
   private short AV130Insert_LegEstadoCivil ;
   private short AV12Insert_LegNacionCod ;
   private short AV13Insert_LegPaiCod ;
   private short AV14Insert_LegProvCod ;
   private short AV15Insert_LegLocCod ;
   private short AV30Insert_CondiCodigo ;
   private short AV122Insert_LegSitRevEgreso ;
   private short Z1523LegVacPend ;
   private short A1523LegVacPend ;
   private short Z17CondiCodigo ;
   private short A17CondiCodigo ;
   private short Z243LegEstadoCivil ;
   private short A243LegEstadoCivil ;
   private short Z22LegPaiCod ;
   private short A22LegPaiCod ;
   private short Z23LegProvCod ;
   private short A23LegProvCod ;
   private short Z24LegLocCod ;
   private short A24LegLocCod ;
   private short Z21LegNacionCod ;
   private short A21LegNacionCod ;
   private short Z1603LegSitRevEgreso ;
   private short A1603LegSitRevEgreso ;
   private short RcdFound23 ;
   private short nIsDirty_23 ;
   private short nRcdExists_129 ;
   private short nRcdExists_24 ;
   private short nRcdExists_170 ;
   private short nRcdExists_276 ;
   private short Z1135LegSuelSec ;
   private short A1135LegSuelSec ;
   private short nIsDirty_129 ;
   private short nRcdExists_292 ;
   private short nIsDirty_292 ;
   private short Z1547GuarCod ;
   private short A1547GuarCod ;
   private short Z29LegOrden ;
   private short A29LegOrden ;
   private short nIsDirty_24 ;
   private short nIsDirty_170 ;
   private short nIsDirty_276 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int Z6LegNumero ;
   private int A6LegNumero ;
   private int nGXsfl_276_idx=1 ;
   private int nGXsfl_170_idx=1 ;
   private int nGXsfl_24_idx=1 ;
   private int nGXsfl_292_idx=1 ;
   private int nGXsfl_129_idx=1 ;
   private int AV142GXV1 ;
   private int AV135Insert_LegActClasNro ;
   private int GX_JID ;
   private int Z2215LegCatPueCod ;
   private int A2215LegCatPueCod ;
   private int Z1576LegConveVersionCli ;
   private int A1576LegConveVersionCli ;
   private int Z2182LegActClasNro ;
   private int A2182LegActClasNro ;
   private int AV91CliCod ;
   private int AV8LegNumero ;
   private long Z239LegCUIL ;
   private long A239LegCUIL ;
   private java.math.BigDecimal Z264LegSueldoFuera ;
   private java.math.BigDecimal A264LegSueldoFuera ;
   private java.math.BigDecimal Z1023LegHorasDia ;
   private java.math.BigDecimal A1023LegHorasDia ;
   private java.math.BigDecimal Z1268LegHorasSem ;
   private java.math.BigDecimal A1268LegHorasSem ;
   private java.math.BigDecimal Z233LegBasico ;
   private java.math.BigDecimal A233LegBasico ;
   private java.math.BigDecimal Z343ZonPorcReduc ;
   private java.math.BigDecimal A343ZonPorcReduc ;
   private java.math.BigDecimal Z1137LegSuelImporte ;
   private java.math.BigDecimal A1137LegSuelImporte ;
   private java.math.BigDecimal Z2347LegSuelCalc ;
   private java.math.BigDecimal A2347LegSuelCalc ;
   private java.math.BigDecimal Z220FamTomaDeducImpGan ;
   private java.math.BigDecimal A220FamTomaDeducImpGan ;
   private java.math.BigDecimal Z2233LegPropValNum ;
   private java.math.BigDecimal A2233LegPropValNum ;
   private java.math.BigDecimal i220FamTomaDeducImpGan ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode23 ;
   private String sMode129 ;
   private String AV141Pgmname ;
   private String AV120Insert_LegMegCodigo ;
   private String AV119Insert_LegSecCodigo ;
   private String AV114Insert_LegLpgCodigo ;
   private String AV115Insert_LegBanCod ;
   private String AV106Insert_LegSinCod ;
   private String AV116Insert_LegOsoCod ;
   private String AV25Insert_LegActCodigo ;
   private String AV26Insert_MprCod ;
   private String AV28Insert_ZonCod ;
   private String AV31Insert_SinieCodigo ;
   private String AV117Insert_LegPuesCodigo ;
   private String AV118Insert_LegSucCodigo ;
   private String AV136Insert_LegPueAfiCod ;
   private String Z236LegCodPos ;
   private String A236LegCodPos ;
   private String Z939LegCatCodigo ;
   private String A939LegCatCodigo ;
   private String Z232LegBanTipCuen ;
   private String A232LegBanTipCuen ;
   private String Z93LegId ;
   private String A93LegId ;
   private String Z937LegConveCodigo ;
   private String A937LegConveCodigo ;
   private String Z879LegContinua ;
   private String A879LegContinua ;
   private String Z1804LegTitulo ;
   private String A1804LegTitulo ;
   private String Z2404LegModTra ;
   private String A2404LegModTra ;
   private String Z2417LegTipoTarifa ;
   private String A2417LegTipoTarifa ;
   private String Z1582LegBanCod ;
   private String A1582LegBanCod ;
   private String Z1581LegLpgCodigo ;
   private String A1581LegLpgCodigo ;
   private String Z1583LegMegCodigo ;
   private String A1583LegMegCodigo ;
   private String Z1580LegOsoCod ;
   private String A1580LegOsoCod ;
   private String Z1579LegSecCodigo ;
   private String A1579LegSecCodigo ;
   private String Z1577LegSucCodigo ;
   private String A1577LegSucCodigo ;
   private String Z1578LegPuesCodigo ;
   private String A1578LegPuesCodigo ;
   private String Z18MprCod ;
   private String A18MprCod ;
   private String Z20ZonCod ;
   private String A20ZonCod ;
   private String Z19SinieCodigo ;
   private String A19SinieCodigo ;
   private String Z910LegSinCod ;
   private String A910LegSinCod ;
   private String Z15LegActCodigo ;
   private String A15LegActCodigo ;
   private String Z2181LegPueAfiCod ;
   private String A2181LegPueAfiCod ;
   private String Z1235LegReligion ;
   private String A1235LegReligion ;
   private String Z1236LegOrigen ;
   private String A1236LegOrigen ;
   private String Z2226LegOsoAfipCod ;
   private String A2226LegOsoAfipCod ;
   private String Z392OsoSigla ;
   private String A392OsoSigla ;
   private String Z1965EmpOsoCod ;
   private String A1965EmpOsoCod ;
   private String Z45TipEmpleCod ;
   private String A45TipEmpleCod ;
   private String Z306OsoC3992 ;
   private String A306OsoC3992 ;
   private String Z1031LegFotoExt ;
   private String A1031LegFotoExt ;
   private String A249LegFoto_Filetype ;
   private String A249LegFoto_Filename ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String Z2344LegSuelTipo ;
   private String A2344LegSuelTipo ;
   private String Z2349LegSuelConcepto ;
   private String A2349LegSuelConcepto ;
   private String sMode292 ;
   private String Z750FamNroDoc ;
   private String A750FamNroDoc ;
   private String Z30ParCod ;
   private String A30ParCod ;
   private String sMode24 ;
   private String Z1319LegTipoTra ;
   private String A1319LegTipoTra ;
   private String sMode170 ;
   private String Z2232LegPropTD ;
   private String A2232LegPropTD ;
   private String Z2230LegPropCod ;
   private String A2230LegPropCod ;
   private String sMode276 ;
   private String i879LegContinua ;
   private String A1292TipoTraId ;
   private java.util.Date Z630LegFecImportacion ;
   private java.util.Date A630LegFecImportacion ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date GXt_dtime7 ;
   private java.util.Date Z247LegFecUltMod ;
   private java.util.Date A247LegFecUltMod ;
   private java.util.Date Z246LegFecNac ;
   private java.util.Date A246LegFecNac ;
   private java.util.Date Z245LegFecIngreso ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date Z244LegFecEgreso ;
   private java.util.Date A244LegFecEgreso ;
   private java.util.Date Z253LegLicInicio ;
   private java.util.Date A253LegLicInicio ;
   private java.util.Date Z252LegLicFinal ;
   private java.util.Date A252LegLicFinal ;
   private java.util.Date Z1531LegFecPreAviso ;
   private java.util.Date A1531LegFecPreAviso ;
   private java.util.Date Z1136LegSuelFecha ;
   private java.util.Date A1136LegSuelFecha ;
   private java.util.Date Z209FamFecNac ;
   private java.util.Date A209FamFecNac ;
   private java.util.Date Z2236LegPropValDate ;
   private java.util.Date A2236LegPropValDate ;
   private boolean returnInSub ;
   private boolean AV92IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z237LegConvenio ;
   private boolean A237LegConvenio ;
   private boolean Z262LegSCVO ;
   private boolean A262LegSCVO ;
   private boolean Z228LegActivo ;
   private boolean A228LegActivo ;
   private boolean Z877LegAgenReten ;
   private boolean A877LegAgenReten ;
   private boolean Z942LegRecalcLiq ;
   private boolean A942LegRecalcLiq ;
   private boolean Z1016LegJubilado ;
   private boolean A1016LegJubilado ;
   private boolean Z1245LegTrabLun ;
   private boolean A1245LegTrabLun ;
   private boolean Z1246LegTrabMar ;
   private boolean A1246LegTrabMar ;
   private boolean Z1247LegTrabMie ;
   private boolean A1247LegTrabMie ;
   private boolean Z1248LegTrabJue ;
   private boolean A1248LegTrabJue ;
   private boolean Z1249LegTrabVie ;
   private boolean A1249LegTrabVie ;
   private boolean Z1250LegTrabSa ;
   private boolean A1250LegTrabSa ;
   private boolean Z1251LegTrabDo ;
   private boolean A1251LegTrabDo ;
   private boolean Z2267LegIncompleto ;
   private boolean A2267LegIncompleto ;
   private boolean Z2309LegLiqApo ;
   private boolean A2309LegLiqApo ;
   private boolean n19SinieCodigo ;
   private boolean n263LegSexo ;
   private boolean n243LegEstadoCivil ;
   private boolean n22LegPaiCod ;
   private boolean n23LegProvCod ;
   private boolean n24LegLocCod ;
   private boolean n21LegNacionCod ;
   private boolean n910LegSinCod ;
   private boolean n2182LegActClasNro ;
   private boolean n15LegActCodigo ;
   private boolean n1603LegSitRevEgreso ;
   private boolean n2181LegPueAfiCod ;
   private boolean n45TipEmpleCod ;
   private boolean n1235LegReligion ;
   private boolean n1236LegOrigen ;
   private boolean n1965EmpOsoCod ;
   private boolean n249LegFoto ;
   private boolean n265LegTelefono ;
   private boolean n244LegFecEgreso ;
   private boolean n300MegDescrip ;
   private boolean n939LegCatCodigo ;
   private boolean n2215LegCatPueCod ;
   private boolean n329SecDescrip ;
   private boolean n291LpgDescri ;
   private boolean n231LegBanSuc ;
   private boolean n232LegBanTipCuen ;
   private boolean n331SinDescrip ;
   private boolean n2226LegOsoAfipCod ;
   private boolean n307OsoDescrip ;
   private boolean n238LegCuentaBanc ;
   private boolean n253LegLicInicio ;
   private boolean n252LegLicFinal ;
   private boolean n234LegCBU ;
   private boolean n93LegId ;
   private boolean n937LegConveCodigo ;
   private boolean n306OsoC3992 ;
   private boolean n1576LegConveVersionCli ;
   private boolean n2263LegMigrWarn ;
   private boolean n392OsoSigla ;
   private boolean n1582LegBanCod ;
   private boolean n1581LegLpgCodigo ;
   private boolean n1583LegMegCodigo ;
   private boolean n1580LegOsoCod ;
   private boolean n1579LegSecCodigo ;
   private boolean n1577LegSucCodigo ;
   private boolean n1578LegPuesCodigo ;
   private boolean n18MprCod ;
   private boolean n20ZonCod ;
   private boolean n17CondiCodigo ;
   private boolean Gx_longc ;
   private boolean n2344LegSuelTipo ;
   private boolean Z205FamDiscap ;
   private boolean A205FamDiscap ;
   private boolean Z890FamAdherente ;
   private boolean A890FamAdherente ;
   private boolean n209FamFecNac ;
   private boolean n205FamDiscap ;
   private boolean n1547GuarCod ;
   private boolean Z2234LegPropValBool ;
   private boolean A2234LegPropValBool ;
   private boolean i262LegSCVO ;
   private boolean mustCommit ;
   private String Z515LegObs ;
   private String A515LegObs ;
   private String Z2263LegMigrWarn ;
   private String A2263LegMigrWarn ;
   private String Z2348LegSuelLog ;
   private String A2348LegSuelLog ;
   private String Z249LegFoto ;
   private String A249LegFoto ;
   private String Z250LegIdNomApe ;
   private String A250LegIdNomApe ;
   private String Z591LegNomApe ;
   private String A591LegNomApe ;
   private String Z230LegApellido ;
   private String A230LegApellido ;
   private String Z251LegNombre ;
   private String A251LegNombre ;
   private String Z257LegNumDoc ;
   private String A257LegNumDoc ;
   private String Z242LegDomici ;
   private String A242LegDomici ;
   private String Z479LegEmail ;
   private String A479LegEmail ;
   private String Z265LegTelefono ;
   private String A265LegTelefono ;
   private String Z231LegBanSuc ;
   private String A231LegBanSuc ;
   private String Z238LegCuentaBanc ;
   private String A238LegCuentaBanc ;
   private String Z234LegCBU ;
   private String A234LegCBU ;
   private String Z1759LegPromDias ;
   private String A1759LegPromDias ;
   private String Z2224LegBanDes ;
   private String A2224LegBanDes ;
   private String Z291LpgDescri ;
   private String A291LpgDescri ;
   private String Z300MegDescrip ;
   private String A300MegDescrip ;
   private String Z2225LegOsoDes ;
   private String A2225LegOsoDes ;
   private String Z329SecDescrip ;
   private String A329SecDescrip ;
   private String Z2EmpNom ;
   private String A2EmpNom ;
   private String Z684MprDescripSinAc ;
   private String A684MprDescripSinAc ;
   private String Z303MprDescrip ;
   private String A303MprDescrip ;
   private String Z678ZonDescripSinAc ;
   private String A678ZonDescripSinAc ;
   private String Z342ZonDescrip ;
   private String A342ZonDescrip ;
   private String Z686CondiDescriSinAc ;
   private String A686CondiDescriSinAc ;
   private String Z144CondiDescri ;
   private String A144CondiDescri ;
   private String Z688SinieDescriSinAc ;
   private String A688SinieDescriSinAc ;
   private String Z333SinieDescri ;
   private String A333SinieDescri ;
   private String Z258LegPaiNom ;
   private String A258LegPaiNom ;
   private String Z260LegProvNom ;
   private String A260LegProvNom ;
   private String Z255LegLocNom ;
   private String A255LegLocNom ;
   private String Z256LegNacionalidad ;
   private String A256LegNacionalidad ;
   private String Z331SinDescrip ;
   private String A331SinDescrip ;
   private String Z227LegActDescri ;
   private String A227LegActDescri ;
   private String Z307OsoDescrip ;
   private String A307OsoDescrip ;
   private String Z1030LegFotoNom ;
   private String A1030LegFotoNom ;
   private String A677LpgDescriSinAc ;
   private String A675SecDescripSinAc ;
   private String A681OsoDescripSinAc ;
   private String A555OsoSiglaYDesc ;
   private String A680SinDescripSinAc ;
   private String Z2090FamNomApe ;
   private String A2090FamNomApe ;
   private String Z2235LegPropValStr ;
   private String A2235LegPropValStr ;
   private String Z2231LegPropDes ;
   private String A2231LegPropDes ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private web.SdtLegajo bcLegajo ;
   private IDataStoreProvider pr_default ;
   private String[] BC000P43_A19SinieCodigo ;
   private boolean[] BC000P43_n19SinieCodigo ;
   private byte[] BC000P43_A263LegSexo ;
   private boolean[] BC000P43_n263LegSexo ;
   private short[] BC000P43_A243LegEstadoCivil ;
   private boolean[] BC000P43_n243LegEstadoCivil ;
   private short[] BC000P43_A22LegPaiCod ;
   private boolean[] BC000P43_n22LegPaiCod ;
   private short[] BC000P43_A23LegProvCod ;
   private boolean[] BC000P43_n23LegProvCod ;
   private short[] BC000P43_A24LegLocCod ;
   private boolean[] BC000P43_n24LegLocCod ;
   private short[] BC000P43_A21LegNacionCod ;
   private boolean[] BC000P43_n21LegNacionCod ;
   private String[] BC000P43_A910LegSinCod ;
   private boolean[] BC000P43_n910LegSinCod ;
   private int[] BC000P43_A2182LegActClasNro ;
   private boolean[] BC000P43_n2182LegActClasNro ;
   private String[] BC000P43_A15LegActCodigo ;
   private boolean[] BC000P43_n15LegActCodigo ;
   private short[] BC000P43_A1603LegSitRevEgreso ;
   private boolean[] BC000P43_n1603LegSitRevEgreso ;
   private String[] BC000P43_A2181LegPueAfiCod ;
   private boolean[] BC000P43_n2181LegPueAfiCod ;
   private String[] BC000P43_A45TipEmpleCod ;
   private boolean[] BC000P43_n45TipEmpleCod ;
   private String[] BC000P43_A1235LegReligion ;
   private boolean[] BC000P43_n1235LegReligion ;
   private String[] BC000P43_A1236LegOrigen ;
   private boolean[] BC000P43_n1236LegOrigen ;
   private String[] BC000P43_A1965EmpOsoCod ;
   private boolean[] BC000P43_n1965EmpOsoCod ;
   private boolean[] BC000P43_A237LegConvenio ;
   private String[] BC000P43_A688SinieDescriSinAc ;
   private String[] BC000P43_A686CondiDescriSinAc ;
   private String[] BC000P43_A678ZonDescripSinAc ;
   private String[] BC000P43_A684MprDescripSinAc ;
   private String[] BC000P43_A250LegIdNomApe ;
   private String[] BC000P43_A591LegNomApe ;
   private int[] BC000P43_A6LegNumero ;
   private java.util.Date[] BC000P43_A247LegFecUltMod ;
   private String[] BC000P43_A2EmpNom ;
   private String[] BC000P43_A230LegApellido ;
   private String[] BC000P43_A251LegNombre ;
   private String[] BC000P43_A249LegFoto ;
   private boolean[] BC000P43_n249LegFoto ;
   private byte[] BC000P43_A266LegTipDoc ;
   private String[] BC000P43_A257LegNumDoc ;
   private java.util.Date[] BC000P43_A246LegFecNac ;
   private String[] BC000P43_A256LegNacionalidad ;
   private long[] BC000P43_A239LegCUIL ;
   private byte[] BC000P43_A241LegDiscapacidad ;
   private String[] BC000P43_A242LegDomici ;
   private String[] BC000P43_A479LegEmail ;
   private String[] BC000P43_A236LegCodPos ;
   private String[] BC000P43_A258LegPaiNom ;
   private String[] BC000P43_A260LegProvNom ;
   private String[] BC000P43_A255LegLocNom ;
   private String[] BC000P43_A265LegTelefono ;
   private boolean[] BC000P43_n265LegTelefono ;
   private java.util.Date[] BC000P43_A245LegFecIngreso ;
   private java.util.Date[] BC000P43_A244LegFecEgreso ;
   private boolean[] BC000P43_n244LegFecEgreso ;
   private String[] BC000P43_A300MegDescrip ;
   private boolean[] BC000P43_n300MegDescrip ;
   private String[] BC000P43_A939LegCatCodigo ;
   private boolean[] BC000P43_n939LegCatCodigo ;
   private int[] BC000P43_A2215LegCatPueCod ;
   private boolean[] BC000P43_n2215LegCatPueCod ;
   private String[] BC000P43_A329SecDescrip ;
   private boolean[] BC000P43_n329SecDescrip ;
   private String[] BC000P43_A291LpgDescri ;
   private boolean[] BC000P43_n291LpgDescri ;
   private byte[] BC000P43_A235LegClase ;
   private byte[] BC000P43_A248LegFormaPago ;
   private String[] BC000P43_A2224LegBanDes ;
   private String[] BC000P43_A231LegBanSuc ;
   private boolean[] BC000P43_n231LegBanSuc ;
   private String[] BC000P43_A232LegBanTipCuen ;
   private boolean[] BC000P43_n232LegBanTipCuen ;
   private String[] BC000P43_A331SinDescrip ;
   private boolean[] BC000P43_n331SinDescrip ;
   private String[] BC000P43_A2225LegOsoDes ;
   private String[] BC000P43_A2226LegOsoAfipCod ;
   private boolean[] BC000P43_n2226LegOsoAfipCod ;
   private String[] BC000P43_A307OsoDescrip ;
   private boolean[] BC000P43_n307OsoDescrip ;
   private String[] BC000P43_A227LegActDescri ;
   private String[] BC000P43_A303MprDescrip ;
   private String[] BC000P43_A238LegCuentaBanc ;
   private boolean[] BC000P43_n238LegCuentaBanc ;
   private java.util.Date[] BC000P43_A253LegLicInicio ;
   private boolean[] BC000P43_n253LegLicInicio ;
   private java.util.Date[] BC000P43_A252LegLicFinal ;
   private boolean[] BC000P43_n252LegLicFinal ;
   private String[] BC000P43_A342ZonDescrip ;
   private java.math.BigDecimal[] BC000P43_A343ZonPorcReduc ;
   private String[] BC000P43_A234LegCBU ;
   private boolean[] BC000P43_n234LegCBU ;
   private boolean[] BC000P43_A262LegSCVO ;
   private String[] BC000P43_A144CondiDescri ;
   private String[] BC000P43_A333SinieDescri ;
   private boolean[] BC000P43_A228LegActivo ;
   private java.math.BigDecimal[] BC000P43_A264LegSueldoFuera ;
   private String[] BC000P43_A93LegId ;
   private boolean[] BC000P43_n93LegId ;
   private String[] BC000P43_A937LegConveCodigo ;
   private boolean[] BC000P43_n937LegConveCodigo ;
   private String[] BC000P43_A306OsoC3992 ;
   private boolean[] BC000P43_n306OsoC3992 ;
   private String[] BC000P43_A515LegObs ;
   private java.util.Date[] BC000P43_A630LegFecImportacion ;
   private boolean[] BC000P43_A877LegAgenReten ;
   private String[] BC000P43_A879LegContinua ;
   private boolean[] BC000P43_A942LegRecalcLiq ;
   private boolean[] BC000P43_A1016LegJubilado ;
   private java.math.BigDecimal[] BC000P43_A1023LegHorasDia ;
   private java.math.BigDecimal[] BC000P43_A1268LegHorasSem ;
   private boolean[] BC000P43_A1245LegTrabLun ;
   private boolean[] BC000P43_A1246LegTrabMar ;
   private boolean[] BC000P43_A1247LegTrabMie ;
   private boolean[] BC000P43_A1248LegTrabJue ;
   private boolean[] BC000P43_A1249LegTrabVie ;
   private boolean[] BC000P43_A1250LegTrabSa ;
   private boolean[] BC000P43_A1251LegTrabDo ;
   private short[] BC000P43_A1523LegVacPend ;
   private java.util.Date[] BC000P43_A1531LegFecPreAviso ;
   private int[] BC000P43_A1576LegConveVersionCli ;
   private boolean[] BC000P43_n1576LegConveVersionCli ;
   private String[] BC000P43_A1759LegPromDias ;
   private String[] BC000P43_A1804LegTitulo ;
   private byte[] BC000P43_A1818LegEstado ;
   private String[] BC000P43_A2263LegMigrWarn ;
   private boolean[] BC000P43_n2263LegMigrWarn ;
   private boolean[] BC000P43_A2267LegIncompleto ;
   private boolean[] BC000P43_A2309LegLiqApo ;
   private String[] BC000P43_A2404LegModTra ;
   private String[] BC000P43_A2417LegTipoTarifa ;
   private String[] BC000P43_A1031LegFotoExt ;
   private String[] BC000P43_A1030LegFotoNom ;
   private String[] BC000P43_A392OsoSigla ;
   private boolean[] BC000P43_n392OsoSigla ;
   private int[] BC000P43_A3CliCod ;
   private String[] BC000P43_A1582LegBanCod ;
   private boolean[] BC000P43_n1582LegBanCod ;
   private String[] BC000P43_A1581LegLpgCodigo ;
   private boolean[] BC000P43_n1581LegLpgCodigo ;
   private String[] BC000P43_A1583LegMegCodigo ;
   private boolean[] BC000P43_n1583LegMegCodigo ;
   private String[] BC000P43_A1580LegOsoCod ;
   private boolean[] BC000P43_n1580LegOsoCod ;
   private String[] BC000P43_A1579LegSecCodigo ;
   private boolean[] BC000P43_n1579LegSecCodigo ;
   private short[] BC000P43_A1EmpCod ;
   private String[] BC000P43_A1577LegSucCodigo ;
   private boolean[] BC000P43_n1577LegSucCodigo ;
   private String[] BC000P43_A1578LegPuesCodigo ;
   private boolean[] BC000P43_n1578LegPuesCodigo ;
   private String[] BC000P43_A18MprCod ;
   private boolean[] BC000P43_n18MprCod ;
   private String[] BC000P43_A20ZonCod ;
   private boolean[] BC000P43_n20ZonCod ;
   private short[] BC000P43_A17CondiCodigo ;
   private boolean[] BC000P43_n17CondiCodigo ;
   private String[] BC000P44_A2224LegBanDes ;
   private String[] BC000P45_A291LpgDescri ;
   private boolean[] BC000P45_n291LpgDescri ;
   private String[] BC000P46_A300MegDescrip ;
   private boolean[] BC000P46_n300MegDescrip ;
   private String[] BC000P47_A2225LegOsoDes ;
   private String[] BC000P47_A2226LegOsoAfipCod ;
   private boolean[] BC000P47_n2226LegOsoAfipCod ;
   private String[] BC000P47_A392OsoSigla ;
   private boolean[] BC000P47_n392OsoSigla ;
   private String[] BC000P48_A329SecDescrip ;
   private boolean[] BC000P48_n329SecDescrip ;
   private int[] BC000P49_A3CliCod ;
   private String[] BC000P50_A45TipEmpleCod ;
   private boolean[] BC000P50_n45TipEmpleCod ;
   private String[] BC000P50_A1965EmpOsoCod ;
   private boolean[] BC000P50_n1965EmpOsoCod ;
   private String[] BC000P50_A2EmpNom ;
   private String[] BC000P51_A307OsoDescrip ;
   private boolean[] BC000P51_n307OsoDescrip ;
   private String[] BC000P51_A306OsoC3992 ;
   private boolean[] BC000P51_n306OsoC3992 ;
   private int[] BC000P52_A3CliCod ;
   private byte[] BC000P53_A263LegSexo ;
   private boolean[] BC000P53_n263LegSexo ;
   private short[] BC000P54_A243LegEstadoCivil ;
   private boolean[] BC000P54_n243LegEstadoCivil ;
   private String[] BC000P55_A256LegNacionalidad ;
   private String[] BC000P56_A258LegPaiNom ;
   private String[] BC000P57_A260LegProvNom ;
   private String[] BC000P58_A255LegLocNom ;
   private String[] BC000P59_A331SinDescrip ;
   private boolean[] BC000P59_n331SinDescrip ;
   private short[] BC000P60_A22LegPaiCod ;
   private boolean[] BC000P60_n22LegPaiCod ;
   private String[] BC000P61_A227LegActDescri ;
   private String[] BC000P62_A684MprDescripSinAc ;
   private String[] BC000P62_A303MprDescrip ;
   private String[] BC000P63_A678ZonDescripSinAc ;
   private String[] BC000P63_A342ZonDescrip ;
   private java.math.BigDecimal[] BC000P63_A343ZonPorcReduc ;
   private String[] BC000P64_A686CondiDescriSinAc ;
   private String[] BC000P64_A144CondiDescri ;
   private String[] BC000P65_A688SinieDescriSinAc ;
   private String[] BC000P65_A333SinieDescri ;
   private short[] BC000P66_A1603LegSitRevEgreso ;
   private boolean[] BC000P66_n1603LegSitRevEgreso ;
   private String[] BC000P67_A2181LegPueAfiCod ;
   private boolean[] BC000P67_n2181LegPueAfiCod ;
   private int[] BC000P68_A3CliCod ;
   private short[] BC000P68_A1EmpCod ;
   private int[] BC000P68_A6LegNumero ;
   private String[] BC000P69_A19SinieCodigo ;
   private boolean[] BC000P69_n19SinieCodigo ;
   private byte[] BC000P69_A263LegSexo ;
   private boolean[] BC000P69_n263LegSexo ;
   private short[] BC000P69_A243LegEstadoCivil ;
   private boolean[] BC000P69_n243LegEstadoCivil ;
   private short[] BC000P69_A22LegPaiCod ;
   private boolean[] BC000P69_n22LegPaiCod ;
   private short[] BC000P69_A23LegProvCod ;
   private boolean[] BC000P69_n23LegProvCod ;
   private short[] BC000P69_A24LegLocCod ;
   private boolean[] BC000P69_n24LegLocCod ;
   private short[] BC000P69_A21LegNacionCod ;
   private boolean[] BC000P69_n21LegNacionCod ;
   private String[] BC000P69_A910LegSinCod ;
   private boolean[] BC000P69_n910LegSinCod ;
   private int[] BC000P69_A2182LegActClasNro ;
   private boolean[] BC000P69_n2182LegActClasNro ;
   private String[] BC000P69_A15LegActCodigo ;
   private boolean[] BC000P69_n15LegActCodigo ;
   private short[] BC000P69_A1603LegSitRevEgreso ;
   private boolean[] BC000P69_n1603LegSitRevEgreso ;
   private String[] BC000P69_A2181LegPueAfiCod ;
   private boolean[] BC000P69_n2181LegPueAfiCod ;
   private String[] BC000P69_A1235LegReligion ;
   private boolean[] BC000P69_n1235LegReligion ;
   private String[] BC000P69_A1236LegOrigen ;
   private boolean[] BC000P69_n1236LegOrigen ;
   private boolean[] BC000P69_A237LegConvenio ;
   private String[] BC000P69_A250LegIdNomApe ;
   private String[] BC000P69_A591LegNomApe ;
   private int[] BC000P69_A6LegNumero ;
   private java.util.Date[] BC000P69_A247LegFecUltMod ;
   private String[] BC000P69_A230LegApellido ;
   private String[] BC000P69_A251LegNombre ;
   private String[] BC000P69_A249LegFoto ;
   private boolean[] BC000P69_n249LegFoto ;
   private byte[] BC000P69_A266LegTipDoc ;
   private String[] BC000P69_A257LegNumDoc ;
   private java.util.Date[] BC000P69_A246LegFecNac ;
   private long[] BC000P69_A239LegCUIL ;
   private byte[] BC000P69_A241LegDiscapacidad ;
   private String[] BC000P69_A242LegDomici ;
   private String[] BC000P69_A479LegEmail ;
   private String[] BC000P69_A236LegCodPos ;
   private String[] BC000P69_A265LegTelefono ;
   private boolean[] BC000P69_n265LegTelefono ;
   private java.util.Date[] BC000P69_A245LegFecIngreso ;
   private java.util.Date[] BC000P69_A244LegFecEgreso ;
   private boolean[] BC000P69_n244LegFecEgreso ;
   private String[] BC000P69_A939LegCatCodigo ;
   private boolean[] BC000P69_n939LegCatCodigo ;
   private int[] BC000P69_A2215LegCatPueCod ;
   private boolean[] BC000P69_n2215LegCatPueCod ;
   private byte[] BC000P69_A235LegClase ;
   private byte[] BC000P69_A248LegFormaPago ;
   private String[] BC000P69_A231LegBanSuc ;
   private boolean[] BC000P69_n231LegBanSuc ;
   private String[] BC000P69_A232LegBanTipCuen ;
   private boolean[] BC000P69_n232LegBanTipCuen ;
   private String[] BC000P69_A238LegCuentaBanc ;
   private boolean[] BC000P69_n238LegCuentaBanc ;
   private java.util.Date[] BC000P69_A253LegLicInicio ;
   private boolean[] BC000P69_n253LegLicInicio ;
   private java.util.Date[] BC000P69_A252LegLicFinal ;
   private boolean[] BC000P69_n252LegLicFinal ;
   private String[] BC000P69_A234LegCBU ;
   private boolean[] BC000P69_n234LegCBU ;
   private boolean[] BC000P69_A262LegSCVO ;
   private boolean[] BC000P69_A228LegActivo ;
   private java.math.BigDecimal[] BC000P69_A264LegSueldoFuera ;
   private String[] BC000P69_A93LegId ;
   private boolean[] BC000P69_n93LegId ;
   private String[] BC000P69_A937LegConveCodigo ;
   private boolean[] BC000P69_n937LegConveCodigo ;
   private String[] BC000P69_A515LegObs ;
   private java.util.Date[] BC000P69_A630LegFecImportacion ;
   private boolean[] BC000P69_A877LegAgenReten ;
   private String[] BC000P69_A879LegContinua ;
   private boolean[] BC000P69_A942LegRecalcLiq ;
   private boolean[] BC000P69_A1016LegJubilado ;
   private java.math.BigDecimal[] BC000P69_A1023LegHorasDia ;
   private java.math.BigDecimal[] BC000P69_A1268LegHorasSem ;
   private boolean[] BC000P69_A1245LegTrabLun ;
   private boolean[] BC000P69_A1246LegTrabMar ;
   private boolean[] BC000P69_A1247LegTrabMie ;
   private boolean[] BC000P69_A1248LegTrabJue ;
   private boolean[] BC000P69_A1249LegTrabVie ;
   private boolean[] BC000P69_A1250LegTrabSa ;
   private boolean[] BC000P69_A1251LegTrabDo ;
   private short[] BC000P69_A1523LegVacPend ;
   private java.util.Date[] BC000P69_A1531LegFecPreAviso ;
   private int[] BC000P69_A1576LegConveVersionCli ;
   private boolean[] BC000P69_n1576LegConveVersionCli ;
   private String[] BC000P69_A1759LegPromDias ;
   private String[] BC000P69_A1804LegTitulo ;
   private byte[] BC000P69_A1818LegEstado ;
   private String[] BC000P69_A2263LegMigrWarn ;
   private boolean[] BC000P69_n2263LegMigrWarn ;
   private boolean[] BC000P69_A2267LegIncompleto ;
   private boolean[] BC000P69_A2309LegLiqApo ;
   private String[] BC000P69_A2404LegModTra ;
   private String[] BC000P69_A2417LegTipoTarifa ;
   private String[] BC000P69_A1031LegFotoExt ;
   private String[] BC000P69_A1030LegFotoNom ;
   private int[] BC000P69_A3CliCod ;
   private String[] BC000P69_A1582LegBanCod ;
   private boolean[] BC000P69_n1582LegBanCod ;
   private String[] BC000P69_A1581LegLpgCodigo ;
   private boolean[] BC000P69_n1581LegLpgCodigo ;
   private String[] BC000P69_A1583LegMegCodigo ;
   private boolean[] BC000P69_n1583LegMegCodigo ;
   private String[] BC000P69_A1580LegOsoCod ;
   private boolean[] BC000P69_n1580LegOsoCod ;
   private String[] BC000P69_A1579LegSecCodigo ;
   private boolean[] BC000P69_n1579LegSecCodigo ;
   private short[] BC000P69_A1EmpCod ;
   private String[] BC000P69_A1577LegSucCodigo ;
   private boolean[] BC000P69_n1577LegSucCodigo ;
   private String[] BC000P69_A1578LegPuesCodigo ;
   private boolean[] BC000P69_n1578LegPuesCodigo ;
   private String[] BC000P69_A18MprCod ;
   private boolean[] BC000P69_n18MprCod ;
   private String[] BC000P69_A20ZonCod ;
   private boolean[] BC000P69_n20ZonCod ;
   private short[] BC000P69_A17CondiCodigo ;
   private boolean[] BC000P69_n17CondiCodigo ;
   private String[] BC000P70_A19SinieCodigo ;
   private boolean[] BC000P70_n19SinieCodigo ;
   private byte[] BC000P70_A263LegSexo ;
   private boolean[] BC000P70_n263LegSexo ;
   private short[] BC000P70_A243LegEstadoCivil ;
   private boolean[] BC000P70_n243LegEstadoCivil ;
   private short[] BC000P70_A22LegPaiCod ;
   private boolean[] BC000P70_n22LegPaiCod ;
   private short[] BC000P70_A23LegProvCod ;
   private boolean[] BC000P70_n23LegProvCod ;
   private short[] BC000P70_A24LegLocCod ;
   private boolean[] BC000P70_n24LegLocCod ;
   private short[] BC000P70_A21LegNacionCod ;
   private boolean[] BC000P70_n21LegNacionCod ;
   private String[] BC000P70_A910LegSinCod ;
   private boolean[] BC000P70_n910LegSinCod ;
   private int[] BC000P70_A2182LegActClasNro ;
   private boolean[] BC000P70_n2182LegActClasNro ;
   private String[] BC000P70_A15LegActCodigo ;
   private boolean[] BC000P70_n15LegActCodigo ;
   private short[] BC000P70_A1603LegSitRevEgreso ;
   private boolean[] BC000P70_n1603LegSitRevEgreso ;
   private String[] BC000P70_A2181LegPueAfiCod ;
   private boolean[] BC000P70_n2181LegPueAfiCod ;
   private String[] BC000P70_A1235LegReligion ;
   private boolean[] BC000P70_n1235LegReligion ;
   private String[] BC000P70_A1236LegOrigen ;
   private boolean[] BC000P70_n1236LegOrigen ;
   private boolean[] BC000P70_A237LegConvenio ;
   private String[] BC000P70_A250LegIdNomApe ;
   private String[] BC000P70_A591LegNomApe ;
   private int[] BC000P70_A6LegNumero ;
   private java.util.Date[] BC000P70_A247LegFecUltMod ;
   private String[] BC000P70_A230LegApellido ;
   private String[] BC000P70_A251LegNombre ;
   private String[] BC000P70_A249LegFoto ;
   private boolean[] BC000P70_n249LegFoto ;
   private byte[] BC000P70_A266LegTipDoc ;
   private String[] BC000P70_A257LegNumDoc ;
   private java.util.Date[] BC000P70_A246LegFecNac ;
   private long[] BC000P70_A239LegCUIL ;
   private byte[] BC000P70_A241LegDiscapacidad ;
   private String[] BC000P70_A242LegDomici ;
   private String[] BC000P70_A479LegEmail ;
   private String[] BC000P70_A236LegCodPos ;
   private String[] BC000P70_A265LegTelefono ;
   private boolean[] BC000P70_n265LegTelefono ;
   private java.util.Date[] BC000P70_A245LegFecIngreso ;
   private java.util.Date[] BC000P70_A244LegFecEgreso ;
   private boolean[] BC000P70_n244LegFecEgreso ;
   private String[] BC000P70_A939LegCatCodigo ;
   private boolean[] BC000P70_n939LegCatCodigo ;
   private int[] BC000P70_A2215LegCatPueCod ;
   private boolean[] BC000P70_n2215LegCatPueCod ;
   private byte[] BC000P70_A235LegClase ;
   private byte[] BC000P70_A248LegFormaPago ;
   private String[] BC000P70_A231LegBanSuc ;
   private boolean[] BC000P70_n231LegBanSuc ;
   private String[] BC000P70_A232LegBanTipCuen ;
   private boolean[] BC000P70_n232LegBanTipCuen ;
   private String[] BC000P70_A238LegCuentaBanc ;
   private boolean[] BC000P70_n238LegCuentaBanc ;
   private java.util.Date[] BC000P70_A253LegLicInicio ;
   private boolean[] BC000P70_n253LegLicInicio ;
   private java.util.Date[] BC000P70_A252LegLicFinal ;
   private boolean[] BC000P70_n252LegLicFinal ;
   private String[] BC000P70_A234LegCBU ;
   private boolean[] BC000P70_n234LegCBU ;
   private boolean[] BC000P70_A262LegSCVO ;
   private boolean[] BC000P70_A228LegActivo ;
   private java.math.BigDecimal[] BC000P70_A264LegSueldoFuera ;
   private String[] BC000P70_A93LegId ;
   private boolean[] BC000P70_n93LegId ;
   private String[] BC000P70_A937LegConveCodigo ;
   private boolean[] BC000P70_n937LegConveCodigo ;
   private String[] BC000P70_A515LegObs ;
   private java.util.Date[] BC000P70_A630LegFecImportacion ;
   private boolean[] BC000P70_A877LegAgenReten ;
   private String[] BC000P70_A879LegContinua ;
   private boolean[] BC000P70_A942LegRecalcLiq ;
   private boolean[] BC000P70_A1016LegJubilado ;
   private java.math.BigDecimal[] BC000P70_A1023LegHorasDia ;
   private java.math.BigDecimal[] BC000P70_A1268LegHorasSem ;
   private boolean[] BC000P70_A1245LegTrabLun ;
   private boolean[] BC000P70_A1246LegTrabMar ;
   private boolean[] BC000P70_A1247LegTrabMie ;
   private boolean[] BC000P70_A1248LegTrabJue ;
   private boolean[] BC000P70_A1249LegTrabVie ;
   private boolean[] BC000P70_A1250LegTrabSa ;
   private boolean[] BC000P70_A1251LegTrabDo ;
   private short[] BC000P70_A1523LegVacPend ;
   private java.util.Date[] BC000P70_A1531LegFecPreAviso ;
   private int[] BC000P70_A1576LegConveVersionCli ;
   private boolean[] BC000P70_n1576LegConveVersionCli ;
   private String[] BC000P70_A1759LegPromDias ;
   private String[] BC000P70_A1804LegTitulo ;
   private byte[] BC000P70_A1818LegEstado ;
   private String[] BC000P70_A2263LegMigrWarn ;
   private boolean[] BC000P70_n2263LegMigrWarn ;
   private boolean[] BC000P70_A2267LegIncompleto ;
   private boolean[] BC000P70_A2309LegLiqApo ;
   private String[] BC000P70_A2404LegModTra ;
   private String[] BC000P70_A2417LegTipoTarifa ;
   private String[] BC000P70_A1031LegFotoExt ;
   private String[] BC000P70_A1030LegFotoNom ;
   private int[] BC000P70_A3CliCod ;
   private String[] BC000P70_A1582LegBanCod ;
   private boolean[] BC000P70_n1582LegBanCod ;
   private String[] BC000P70_A1581LegLpgCodigo ;
   private boolean[] BC000P70_n1581LegLpgCodigo ;
   private String[] BC000P70_A1583LegMegCodigo ;
   private boolean[] BC000P70_n1583LegMegCodigo ;
   private String[] BC000P70_A1580LegOsoCod ;
   private boolean[] BC000P70_n1580LegOsoCod ;
   private String[] BC000P70_A1579LegSecCodigo ;
   private boolean[] BC000P70_n1579LegSecCodigo ;
   private short[] BC000P70_A1EmpCod ;
   private String[] BC000P70_A1577LegSucCodigo ;
   private boolean[] BC000P70_n1577LegSucCodigo ;
   private String[] BC000P70_A1578LegPuesCodigo ;
   private boolean[] BC000P70_n1578LegPuesCodigo ;
   private String[] BC000P70_A18MprCod ;
   private boolean[] BC000P70_n18MprCod ;
   private String[] BC000P70_A20ZonCod ;
   private boolean[] BC000P70_n20ZonCod ;
   private short[] BC000P70_A17CondiCodigo ;
   private boolean[] BC000P70_n17CondiCodigo ;
   private String[] BC000P75_A1965EmpOsoCod ;
   private boolean[] BC000P75_n1965EmpOsoCod ;
   private String[] BC000P75_A2EmpNom ;
   private String[] BC000P75_A45TipEmpleCod ;
   private boolean[] BC000P75_n45TipEmpleCod ;
   private String[] BC000P76_A307OsoDescrip ;
   private boolean[] BC000P76_n307OsoDescrip ;
   private String[] BC000P76_A306OsoC3992 ;
   private boolean[] BC000P76_n306OsoC3992 ;
   private String[] BC000P77_A256LegNacionalidad ;
   private String[] BC000P78_A258LegPaiNom ;
   private String[] BC000P79_A260LegProvNom ;
   private String[] BC000P80_A255LegLocNom ;
   private String[] BC000P81_A300MegDescrip ;
   private boolean[] BC000P81_n300MegDescrip ;
   private String[] BC000P82_A329SecDescrip ;
   private boolean[] BC000P82_n329SecDescrip ;
   private String[] BC000P83_A291LpgDescri ;
   private boolean[] BC000P83_n291LpgDescri ;
   private String[] BC000P84_A2224LegBanDes ;
   private String[] BC000P85_A331SinDescrip ;
   private boolean[] BC000P85_n331SinDescrip ;
   private String[] BC000P86_A2225LegOsoDes ;
   private String[] BC000P86_A2226LegOsoAfipCod ;
   private boolean[] BC000P86_n2226LegOsoAfipCod ;
   private String[] BC000P86_A392OsoSigla ;
   private boolean[] BC000P86_n392OsoSigla ;
   private String[] BC000P87_A227LegActDescri ;
   private String[] BC000P88_A684MprDescripSinAc ;
   private String[] BC000P88_A303MprDescrip ;
   private String[] BC000P89_A678ZonDescripSinAc ;
   private String[] BC000P89_A342ZonDescrip ;
   private java.math.BigDecimal[] BC000P89_A343ZonPorcReduc ;
   private String[] BC000P90_A686CondiDescriSinAc ;
   private String[] BC000P90_A144CondiDescri ;
   private String[] BC000P91_A688SinieDescriSinAc ;
   private String[] BC000P91_A333SinieDescri ;
   private int[] BC000P92_A3CliCod ;
   private short[] BC000P92_A1EmpCod ;
   private int[] BC000P92_A6LegNumero ;
   private String[] BC000P92_A2243LegCuenLicTpo ;
   private short[] BC000P92_A2266LegCuenAnio ;
   private int[] BC000P93_A3CliCod ;
   private short[] BC000P93_A1EmpCod ;
   private int[] BC000P93_A6LegNumero ;
   private java.util.Date[] BC000P93_A2253LegHisFecIng ;
   private int[] BC000P94_A3CliCod ;
   private short[] BC000P94_A1EmpCod ;
   private int[] BC000P94_A6LegNumero ;
   private String[] BC000P94_A1829PreliqTLiqCod ;
   private java.util.Date[] BC000P94_A1830PreliqPeriodo ;
   private int[] BC000P95_A3CliCod ;
   private short[] BC000P95_A1EmpCod ;
   private int[] BC000P95_A6LegNumero ;
   private short[] BC000P95_A1172OblSecuencial ;
   private int[] BC000P96_A3CliCod ;
   private short[] BC000P96_A1EmpCod ;
   private int[] BC000P96_A6LegNumero ;
   private short[] BC000P96_A1135LegSuelSec ;
   private int[] BC000P97_A3CliCod ;
   private short[] BC000P97_A1EmpCod ;
   private byte[] BC000P97_A784F1357CTipoPre ;
   private String[] BC000P97_A777F1357CPer ;
   private byte[] BC000P97_A778F1357CSec ;
   private int[] BC000P97_A6LegNumero ;
   private String[] BC000P97_A797F1357LRTipReg ;
   private int[] BC000P98_A3CliCod ;
   private short[] BC000P98_A1EmpCod ;
   private byte[] BC000P98_A784F1357CTipoPre ;
   private String[] BC000P98_A777F1357CPer ;
   private byte[] BC000P98_A778F1357CSec ;
   private int[] BC000P98_A6LegNumero ;
   private String[] BC000P98_A863F1357LDGTipReg ;
   private int[] BC000P99_A3CliCod ;
   private short[] BC000P99_A1EmpCod ;
   private byte[] BC000P99_A784F1357CTipoPre ;
   private String[] BC000P99_A777F1357CPer ;
   private byte[] BC000P99_A778F1357CSec ;
   private int[] BC000P99_A6LegNumero ;
   private String[] BC000P99_A786F1357LTipoReg ;
   private int[] BC000P100_A3CliCod ;
   private short[] BC000P100_A1EmpCod ;
   private byte[] BC000P100_A784F1357CTipoPre ;
   private String[] BC000P100_A777F1357CPer ;
   private byte[] BC000P100_A778F1357CSec ;
   private int[] BC000P100_A6LegNumero ;
   private String[] BC000P100_A862F1357LDPTipReg ;
   private int[] BC000P101_A3CliCod ;
   private short[] BC000P101_A1EmpCod ;
   private byte[] BC000P101_A784F1357CTipoPre ;
   private String[] BC000P101_A777F1357CPer ;
   private byte[] BC000P101_A778F1357CSec ;
   private int[] BC000P101_A6LegNumero ;
   private String[] BC000P101_A861F1357LCTipReg ;
   private int[] BC000P102_A3CliCod ;
   private short[] BC000P102_A1EmpCod ;
   private int[] BC000P102_A6LegNumero ;
   private int[] BC000P102_A83LegDedSec ;
   private int[] BC000P103_A3CliCod ;
   private short[] BC000P103_A1EmpCod ;
   private int[] BC000P103_A6LegNumero ;
   private short[] BC000P103_A77CenCodigo ;
   private int[] BC000P104_A3CliCod ;
   private short[] BC000P104_A1EmpCod ;
   private int[] BC000P104_A6LegNumero ;
   private java.util.Date[] BC000P104_A76LegLicenIni ;
   private int[] BC000P105_A3CliCod ;
   private short[] BC000P105_A1EmpCod ;
   private int[] BC000P105_A31LiqNro ;
   private int[] BC000P105_A6LegNumero ;
   private int[] BC000P106_A3CliCod ;
   private short[] BC000P106_A1EmpCod ;
   private int[] BC000P106_A6LegNumero ;
   private short[] BC000P106_A25AgeOrden ;
   private String[] BC000P107_A19SinieCodigo ;
   private boolean[] BC000P107_n19SinieCodigo ;
   private byte[] BC000P107_A263LegSexo ;
   private boolean[] BC000P107_n263LegSexo ;
   private short[] BC000P107_A243LegEstadoCivil ;
   private boolean[] BC000P107_n243LegEstadoCivil ;
   private short[] BC000P107_A22LegPaiCod ;
   private boolean[] BC000P107_n22LegPaiCod ;
   private short[] BC000P107_A23LegProvCod ;
   private boolean[] BC000P107_n23LegProvCod ;
   private short[] BC000P107_A24LegLocCod ;
   private boolean[] BC000P107_n24LegLocCod ;
   private short[] BC000P107_A21LegNacionCod ;
   private boolean[] BC000P107_n21LegNacionCod ;
   private String[] BC000P107_A910LegSinCod ;
   private boolean[] BC000P107_n910LegSinCod ;
   private int[] BC000P107_A2182LegActClasNro ;
   private boolean[] BC000P107_n2182LegActClasNro ;
   private String[] BC000P107_A15LegActCodigo ;
   private boolean[] BC000P107_n15LegActCodigo ;
   private short[] BC000P107_A1603LegSitRevEgreso ;
   private boolean[] BC000P107_n1603LegSitRevEgreso ;
   private String[] BC000P107_A2181LegPueAfiCod ;
   private boolean[] BC000P107_n2181LegPueAfiCod ;
   private String[] BC000P107_A45TipEmpleCod ;
   private boolean[] BC000P107_n45TipEmpleCod ;
   private String[] BC000P107_A1235LegReligion ;
   private boolean[] BC000P107_n1235LegReligion ;
   private String[] BC000P107_A1236LegOrigen ;
   private boolean[] BC000P107_n1236LegOrigen ;
   private String[] BC000P107_A1965EmpOsoCod ;
   private boolean[] BC000P107_n1965EmpOsoCod ;
   private boolean[] BC000P107_A237LegConvenio ;
   private String[] BC000P107_A688SinieDescriSinAc ;
   private String[] BC000P107_A686CondiDescriSinAc ;
   private String[] BC000P107_A678ZonDescripSinAc ;
   private String[] BC000P107_A684MprDescripSinAc ;
   private String[] BC000P107_A250LegIdNomApe ;
   private String[] BC000P107_A591LegNomApe ;
   private int[] BC000P107_A6LegNumero ;
   private java.util.Date[] BC000P107_A247LegFecUltMod ;
   private String[] BC000P107_A2EmpNom ;
   private String[] BC000P107_A230LegApellido ;
   private String[] BC000P107_A251LegNombre ;
   private String[] BC000P107_A249LegFoto ;
   private boolean[] BC000P107_n249LegFoto ;
   private byte[] BC000P107_A266LegTipDoc ;
   private String[] BC000P107_A257LegNumDoc ;
   private java.util.Date[] BC000P107_A246LegFecNac ;
   private String[] BC000P107_A256LegNacionalidad ;
   private long[] BC000P107_A239LegCUIL ;
   private byte[] BC000P107_A241LegDiscapacidad ;
   private String[] BC000P107_A242LegDomici ;
   private String[] BC000P107_A479LegEmail ;
   private String[] BC000P107_A236LegCodPos ;
   private String[] BC000P107_A258LegPaiNom ;
   private String[] BC000P107_A260LegProvNom ;
   private String[] BC000P107_A255LegLocNom ;
   private String[] BC000P107_A265LegTelefono ;
   private boolean[] BC000P107_n265LegTelefono ;
   private java.util.Date[] BC000P107_A245LegFecIngreso ;
   private java.util.Date[] BC000P107_A244LegFecEgreso ;
   private boolean[] BC000P107_n244LegFecEgreso ;
   private String[] BC000P107_A300MegDescrip ;
   private boolean[] BC000P107_n300MegDescrip ;
   private String[] BC000P107_A939LegCatCodigo ;
   private boolean[] BC000P107_n939LegCatCodigo ;
   private int[] BC000P107_A2215LegCatPueCod ;
   private boolean[] BC000P107_n2215LegCatPueCod ;
   private String[] BC000P107_A329SecDescrip ;
   private boolean[] BC000P107_n329SecDescrip ;
   private String[] BC000P107_A291LpgDescri ;
   private boolean[] BC000P107_n291LpgDescri ;
   private byte[] BC000P107_A235LegClase ;
   private byte[] BC000P107_A248LegFormaPago ;
   private String[] BC000P107_A2224LegBanDes ;
   private String[] BC000P107_A231LegBanSuc ;
   private boolean[] BC000P107_n231LegBanSuc ;
   private String[] BC000P107_A232LegBanTipCuen ;
   private boolean[] BC000P107_n232LegBanTipCuen ;
   private String[] BC000P107_A331SinDescrip ;
   private boolean[] BC000P107_n331SinDescrip ;
   private String[] BC000P107_A2225LegOsoDes ;
   private String[] BC000P107_A2226LegOsoAfipCod ;
   private boolean[] BC000P107_n2226LegOsoAfipCod ;
   private String[] BC000P107_A307OsoDescrip ;
   private boolean[] BC000P107_n307OsoDescrip ;
   private String[] BC000P107_A227LegActDescri ;
   private String[] BC000P107_A303MprDescrip ;
   private String[] BC000P107_A238LegCuentaBanc ;
   private boolean[] BC000P107_n238LegCuentaBanc ;
   private java.util.Date[] BC000P107_A253LegLicInicio ;
   private boolean[] BC000P107_n253LegLicInicio ;
   private java.util.Date[] BC000P107_A252LegLicFinal ;
   private boolean[] BC000P107_n252LegLicFinal ;
   private String[] BC000P107_A342ZonDescrip ;
   private java.math.BigDecimal[] BC000P107_A343ZonPorcReduc ;
   private String[] BC000P107_A234LegCBU ;
   private boolean[] BC000P107_n234LegCBU ;
   private boolean[] BC000P107_A262LegSCVO ;
   private String[] BC000P107_A144CondiDescri ;
   private String[] BC000P107_A333SinieDescri ;
   private boolean[] BC000P107_A228LegActivo ;
   private java.math.BigDecimal[] BC000P107_A264LegSueldoFuera ;
   private String[] BC000P107_A93LegId ;
   private boolean[] BC000P107_n93LegId ;
   private String[] BC000P107_A937LegConveCodigo ;
   private boolean[] BC000P107_n937LegConveCodigo ;
   private String[] BC000P107_A306OsoC3992 ;
   private boolean[] BC000P107_n306OsoC3992 ;
   private String[] BC000P107_A515LegObs ;
   private java.util.Date[] BC000P107_A630LegFecImportacion ;
   private boolean[] BC000P107_A877LegAgenReten ;
   private String[] BC000P107_A879LegContinua ;
   private boolean[] BC000P107_A942LegRecalcLiq ;
   private boolean[] BC000P107_A1016LegJubilado ;
   private java.math.BigDecimal[] BC000P107_A1023LegHorasDia ;
   private java.math.BigDecimal[] BC000P107_A1268LegHorasSem ;
   private boolean[] BC000P107_A1245LegTrabLun ;
   private boolean[] BC000P107_A1246LegTrabMar ;
   private boolean[] BC000P107_A1247LegTrabMie ;
   private boolean[] BC000P107_A1248LegTrabJue ;
   private boolean[] BC000P107_A1249LegTrabVie ;
   private boolean[] BC000P107_A1250LegTrabSa ;
   private boolean[] BC000P107_A1251LegTrabDo ;
   private short[] BC000P107_A1523LegVacPend ;
   private java.util.Date[] BC000P107_A1531LegFecPreAviso ;
   private int[] BC000P107_A1576LegConveVersionCli ;
   private boolean[] BC000P107_n1576LegConveVersionCli ;
   private String[] BC000P107_A1759LegPromDias ;
   private String[] BC000P107_A1804LegTitulo ;
   private byte[] BC000P107_A1818LegEstado ;
   private String[] BC000P107_A2263LegMigrWarn ;
   private boolean[] BC000P107_n2263LegMigrWarn ;
   private boolean[] BC000P107_A2267LegIncompleto ;
   private boolean[] BC000P107_A2309LegLiqApo ;
   private String[] BC000P107_A2404LegModTra ;
   private String[] BC000P107_A2417LegTipoTarifa ;
   private String[] BC000P107_A1031LegFotoExt ;
   private String[] BC000P107_A1030LegFotoNom ;
   private String[] BC000P107_A392OsoSigla ;
   private boolean[] BC000P107_n392OsoSigla ;
   private int[] BC000P107_A3CliCod ;
   private String[] BC000P107_A1582LegBanCod ;
   private boolean[] BC000P107_n1582LegBanCod ;
   private String[] BC000P107_A1581LegLpgCodigo ;
   private boolean[] BC000P107_n1581LegLpgCodigo ;
   private String[] BC000P107_A1583LegMegCodigo ;
   private boolean[] BC000P107_n1583LegMegCodigo ;
   private String[] BC000P107_A1580LegOsoCod ;
   private boolean[] BC000P107_n1580LegOsoCod ;
   private String[] BC000P107_A1579LegSecCodigo ;
   private boolean[] BC000P107_n1579LegSecCodigo ;
   private short[] BC000P107_A1EmpCod ;
   private String[] BC000P107_A1577LegSucCodigo ;
   private boolean[] BC000P107_n1577LegSucCodigo ;
   private String[] BC000P107_A1578LegPuesCodigo ;
   private boolean[] BC000P107_n1578LegPuesCodigo ;
   private String[] BC000P107_A18MprCod ;
   private boolean[] BC000P107_n18MprCod ;
   private String[] BC000P107_A20ZonCod ;
   private boolean[] BC000P107_n20ZonCod ;
   private short[] BC000P107_A17CondiCodigo ;
   private boolean[] BC000P107_n17CondiCodigo ;
   private int[] BC000P108_A3CliCod ;
   private short[] BC000P108_A1EmpCod ;
   private int[] BC000P108_A6LegNumero ;
   private short[] BC000P108_A1135LegSuelSec ;
   private java.util.Date[] BC000P108_A1136LegSuelFecha ;
   private java.math.BigDecimal[] BC000P108_A1137LegSuelImporte ;
   private String[] BC000P108_A2344LegSuelTipo ;
   private boolean[] BC000P108_n2344LegSuelTipo ;
   private java.math.BigDecimal[] BC000P108_A2347LegSuelCalc ;
   private String[] BC000P108_A2348LegSuelLog ;
   private int[] BC000P109_A3CliCod ;
   private short[] BC000P109_A1EmpCod ;
   private int[] BC000P109_A6LegNumero ;
   private short[] BC000P109_A1135LegSuelSec ;
   private int[] BC000P110_A3CliCod ;
   private short[] BC000P110_A1EmpCod ;
   private int[] BC000P110_A6LegNumero ;
   private short[] BC000P110_A1135LegSuelSec ;
   private java.util.Date[] BC000P110_A1136LegSuelFecha ;
   private java.math.BigDecimal[] BC000P110_A1137LegSuelImporte ;
   private String[] BC000P110_A2344LegSuelTipo ;
   private boolean[] BC000P110_n2344LegSuelTipo ;
   private java.math.BigDecimal[] BC000P110_A2347LegSuelCalc ;
   private String[] BC000P110_A2348LegSuelLog ;
   private int[] BC000P111_A3CliCod ;
   private short[] BC000P111_A1EmpCod ;
   private int[] BC000P111_A6LegNumero ;
   private short[] BC000P111_A1135LegSuelSec ;
   private java.util.Date[] BC000P111_A1136LegSuelFecha ;
   private java.math.BigDecimal[] BC000P111_A1137LegSuelImporte ;
   private String[] BC000P111_A2344LegSuelTipo ;
   private boolean[] BC000P111_n2344LegSuelTipo ;
   private java.math.BigDecimal[] BC000P111_A2347LegSuelCalc ;
   private String[] BC000P111_A2348LegSuelLog ;
   private int[] BC000P115_A3CliCod ;
   private short[] BC000P115_A1EmpCod ;
   private int[] BC000P115_A6LegNumero ;
   private short[] BC000P115_A1135LegSuelSec ;
   private java.util.Date[] BC000P115_A1136LegSuelFecha ;
   private java.math.BigDecimal[] BC000P115_A1137LegSuelImporte ;
   private String[] BC000P115_A2344LegSuelTipo ;
   private boolean[] BC000P115_n2344LegSuelTipo ;
   private java.math.BigDecimal[] BC000P115_A2347LegSuelCalc ;
   private String[] BC000P115_A2348LegSuelLog ;
   private int[] BC000P116_A3CliCod ;
   private String[] BC000P116_A2349LegSuelConcepto ;
   private short[] BC000P116_A1EmpCod ;
   private int[] BC000P116_A6LegNumero ;
   private short[] BC000P116_A1135LegSuelSec ;
   private int[] BC000P117_A3CliCod ;
   private int[] BC000P118_A3CliCod ;
   private short[] BC000P118_A1EmpCod ;
   private int[] BC000P118_A6LegNumero ;
   private short[] BC000P118_A1135LegSuelSec ;
   private String[] BC000P118_A2349LegSuelConcepto ;
   private int[] BC000P119_A3CliCod ;
   private String[] BC000P119_A2349LegSuelConcepto ;
   private short[] BC000P119_A1EmpCod ;
   private int[] BC000P119_A6LegNumero ;
   private short[] BC000P119_A1135LegSuelSec ;
   private int[] BC000P120_A3CliCod ;
   private String[] BC000P120_A2349LegSuelConcepto ;
   private short[] BC000P120_A1EmpCod ;
   private int[] BC000P120_A6LegNumero ;
   private short[] BC000P120_A1135LegSuelSec ;
   private int[] BC000P123_A3CliCod ;
   private String[] BC000P123_A2349LegSuelConcepto ;
   private short[] BC000P123_A1EmpCod ;
   private int[] BC000P123_A6LegNumero ;
   private short[] BC000P123_A1135LegSuelSec ;
   private int[] BC000P124_A6LegNumero ;
   private short[] BC000P124_A29LegOrden ;
   private java.math.BigDecimal[] BC000P124_A220FamTomaDeducImpGan ;
   private String[] BC000P124_A2090FamNomApe ;
   private java.util.Date[] BC000P124_A209FamFecNac ;
   private boolean[] BC000P124_n209FamFecNac ;
   private boolean[] BC000P124_A205FamDiscap ;
   private boolean[] BC000P124_n205FamDiscap ;
   private String[] BC000P124_A750FamNroDoc ;
   private boolean[] BC000P124_A890FamAdherente ;
   private int[] BC000P124_A3CliCod ;
   private String[] BC000P124_A30ParCod ;
   private short[] BC000P124_A1EmpCod ;
   private short[] BC000P124_A1547GuarCod ;
   private boolean[] BC000P124_n1547GuarCod ;
   private int[] BC000P125_A3CliCod ;
   private int[] BC000P126_A3CliCod ;
   private int[] BC000P127_A3CliCod ;
   private short[] BC000P127_A1EmpCod ;
   private int[] BC000P127_A6LegNumero ;
   private short[] BC000P127_A29LegOrden ;
   private int[] BC000P128_A6LegNumero ;
   private short[] BC000P128_A29LegOrden ;
   private java.math.BigDecimal[] BC000P128_A220FamTomaDeducImpGan ;
   private String[] BC000P128_A2090FamNomApe ;
   private java.util.Date[] BC000P128_A209FamFecNac ;
   private boolean[] BC000P128_n209FamFecNac ;
   private boolean[] BC000P128_A205FamDiscap ;
   private boolean[] BC000P128_n205FamDiscap ;
   private String[] BC000P128_A750FamNroDoc ;
   private boolean[] BC000P128_A890FamAdherente ;
   private int[] BC000P128_A3CliCod ;
   private String[] BC000P128_A30ParCod ;
   private short[] BC000P128_A1EmpCod ;
   private short[] BC000P128_A1547GuarCod ;
   private boolean[] BC000P128_n1547GuarCod ;
   private int[] BC000P129_A6LegNumero ;
   private short[] BC000P129_A29LegOrden ;
   private java.math.BigDecimal[] BC000P129_A220FamTomaDeducImpGan ;
   private String[] BC000P129_A2090FamNomApe ;
   private java.util.Date[] BC000P129_A209FamFecNac ;
   private boolean[] BC000P129_n209FamFecNac ;
   private boolean[] BC000P129_A205FamDiscap ;
   private boolean[] BC000P129_n205FamDiscap ;
   private String[] BC000P129_A750FamNroDoc ;
   private boolean[] BC000P129_A890FamAdherente ;
   private int[] BC000P129_A3CliCod ;
   private String[] BC000P129_A30ParCod ;
   private short[] BC000P129_A1EmpCod ;
   private short[] BC000P129_A1547GuarCod ;
   private boolean[] BC000P129_n1547GuarCod ;
   private int[] BC000P133_A6LegNumero ;
   private short[] BC000P133_A29LegOrden ;
   private java.math.BigDecimal[] BC000P133_A220FamTomaDeducImpGan ;
   private String[] BC000P133_A2090FamNomApe ;
   private java.util.Date[] BC000P133_A209FamFecNac ;
   private boolean[] BC000P133_n209FamFecNac ;
   private boolean[] BC000P133_A205FamDiscap ;
   private boolean[] BC000P133_n205FamDiscap ;
   private String[] BC000P133_A750FamNroDoc ;
   private boolean[] BC000P133_A890FamAdherente ;
   private int[] BC000P133_A3CliCod ;
   private String[] BC000P133_A30ParCod ;
   private short[] BC000P133_A1EmpCod ;
   private short[] BC000P133_A1547GuarCod ;
   private boolean[] BC000P133_n1547GuarCod ;
   private int[] BC000P134_A3CliCod ;
   private short[] BC000P134_A1EmpCod ;
   private int[] BC000P134_A6LegNumero ;
   private String[] BC000P134_A1319LegTipoTra ;
   private String[] BC000P135_A1292TipoTraId ;
   private int[] BC000P136_A3CliCod ;
   private short[] BC000P136_A1EmpCod ;
   private int[] BC000P136_A6LegNumero ;
   private String[] BC000P136_A1319LegTipoTra ;
   private int[] BC000P137_A3CliCod ;
   private short[] BC000P137_A1EmpCod ;
   private int[] BC000P137_A6LegNumero ;
   private String[] BC000P137_A1319LegTipoTra ;
   private int[] BC000P138_A3CliCod ;
   private short[] BC000P138_A1EmpCod ;
   private int[] BC000P138_A6LegNumero ;
   private String[] BC000P138_A1319LegTipoTra ;
   private int[] BC000P141_A3CliCod ;
   private short[] BC000P141_A1EmpCod ;
   private int[] BC000P141_A6LegNumero ;
   private String[] BC000P141_A1319LegTipoTra ;
   private int[] BC000P142_A3CliCod ;
   private short[] BC000P142_A1EmpCod ;
   private int[] BC000P142_A6LegNumero ;
   private String[] BC000P142_A2231LegPropDes ;
   private String[] BC000P142_A2232LegPropTD ;
   private java.math.BigDecimal[] BC000P142_A2233LegPropValNum ;
   private boolean[] BC000P142_A2234LegPropValBool ;
   private String[] BC000P142_A2235LegPropValStr ;
   private java.util.Date[] BC000P142_A2236LegPropValDate ;
   private String[] BC000P142_A2230LegPropCod ;
   private String[] BC000P143_A2231LegPropDes ;
   private String[] BC000P143_A2232LegPropTD ;
   private int[] BC000P144_A3CliCod ;
   private short[] BC000P144_A1EmpCod ;
   private int[] BC000P144_A6LegNumero ;
   private String[] BC000P144_A2230LegPropCod ;
   private int[] BC000P145_A3CliCod ;
   private short[] BC000P145_A1EmpCod ;
   private int[] BC000P145_A6LegNumero ;
   private java.math.BigDecimal[] BC000P145_A2233LegPropValNum ;
   private boolean[] BC000P145_A2234LegPropValBool ;
   private String[] BC000P145_A2235LegPropValStr ;
   private java.util.Date[] BC000P145_A2236LegPropValDate ;
   private String[] BC000P145_A2230LegPropCod ;
   private int[] BC000P146_A3CliCod ;
   private short[] BC000P146_A1EmpCod ;
   private int[] BC000P146_A6LegNumero ;
   private java.math.BigDecimal[] BC000P146_A2233LegPropValNum ;
   private boolean[] BC000P146_A2234LegPropValBool ;
   private String[] BC000P146_A2235LegPropValStr ;
   private java.util.Date[] BC000P146_A2236LegPropValDate ;
   private String[] BC000P146_A2230LegPropCod ;
   private String[] BC000P150_A2231LegPropDes ;
   private String[] BC000P150_A2232LegPropTD ;
   private int[] BC000P151_A3CliCod ;
   private short[] BC000P151_A1EmpCod ;
   private int[] BC000P151_A6LegNumero ;
   private String[] BC000P151_A2231LegPropDes ;
   private String[] BC000P151_A2232LegPropTD ;
   private java.math.BigDecimal[] BC000P151_A2233LegPropValNum ;
   private boolean[] BC000P151_A2234LegPropValBool ;
   private String[] BC000P151_A2235LegPropValStr ;
   private java.util.Date[] BC000P151_A2236LegPropValDate ;
   private String[] BC000P151_A2230LegPropCod ;
   private String[] BC000P152_A45TipEmpleCod ;
   private boolean[] BC000P152_n45TipEmpleCod ;
   private String[] BC000P152_A1965EmpOsoCod ;
   private boolean[] BC000P152_n1965EmpOsoCod ;
   private String[] BC000P152_A2EmpNom ;
   private String[] BC000P153_A307OsoDescrip ;
   private boolean[] BC000P153_n307OsoDescrip ;
   private String[] BC000P153_A306OsoC3992 ;
   private boolean[] BC000P153_n306OsoC3992 ;
   private String[] BC000P154_A45TipEmpleCod ;
   private boolean[] BC000P154_n45TipEmpleCod ;
   private String[] BC000P154_A1965EmpOsoCod ;
   private boolean[] BC000P154_n1965EmpOsoCod ;
   private String[] BC000P154_A2EmpNom ;
   private String[] BC000P155_A307OsoDescrip ;
   private boolean[] BC000P155_n307OsoDescrip ;
   private String[] BC000P155_A306OsoC3992 ;
   private boolean[] BC000P155_n306OsoC3992 ;
   private int[] BC000P2_A3CliCod ;
   private short[] BC000P2_A1EmpCod ;
   private int[] BC000P2_A6LegNumero ;
   private java.math.BigDecimal[] BC000P2_A2233LegPropValNum ;
   private boolean[] BC000P2_A2234LegPropValBool ;
   private String[] BC000P2_A2235LegPropValStr ;
   private java.util.Date[] BC000P2_A2236LegPropValDate ;
   private String[] BC000P2_A2230LegPropCod ;
   private int[] BC000P3_A3CliCod ;
   private short[] BC000P3_A1EmpCod ;
   private int[] BC000P3_A6LegNumero ;
   private java.math.BigDecimal[] BC000P3_A2233LegPropValNum ;
   private boolean[] BC000P3_A2234LegPropValBool ;
   private String[] BC000P3_A2235LegPropValStr ;
   private java.util.Date[] BC000P3_A2236LegPropValDate ;
   private String[] BC000P3_A2230LegPropCod ;
   private String[] BC000P4_A2231LegPropDes ;
   private String[] BC000P4_A2232LegPropTD ;
   private int[] BC000P5_A3CliCod ;
   private short[] BC000P5_A1EmpCod ;
   private int[] BC000P5_A6LegNumero ;
   private String[] BC000P5_A1319LegTipoTra ;
   private int[] BC000P6_A3CliCod ;
   private short[] BC000P6_A1EmpCod ;
   private int[] BC000P6_A6LegNumero ;
   private String[] BC000P6_A1319LegTipoTra ;
   private String[] BC000P7_A1292TipoTraId ;
   private int[] BC000P8_A6LegNumero ;
   private short[] BC000P8_A29LegOrden ;
   private java.math.BigDecimal[] BC000P8_A220FamTomaDeducImpGan ;
   private String[] BC000P8_A2090FamNomApe ;
   private java.util.Date[] BC000P8_A209FamFecNac ;
   private boolean[] BC000P8_A205FamDiscap ;
   private String[] BC000P8_A750FamNroDoc ;
   private boolean[] BC000P8_A890FamAdherente ;
   private int[] BC000P8_A3CliCod ;
   private String[] BC000P8_A30ParCod ;
   private short[] BC000P8_A1EmpCod ;
   private short[] BC000P8_A1547GuarCod ;
   private int[] BC000P9_A6LegNumero ;
   private short[] BC000P9_A29LegOrden ;
   private java.math.BigDecimal[] BC000P9_A220FamTomaDeducImpGan ;
   private String[] BC000P9_A2090FamNomApe ;
   private java.util.Date[] BC000P9_A209FamFecNac ;
   private boolean[] BC000P9_A205FamDiscap ;
   private String[] BC000P9_A750FamNroDoc ;
   private boolean[] BC000P9_A890FamAdherente ;
   private int[] BC000P9_A3CliCod ;
   private String[] BC000P9_A30ParCod ;
   private short[] BC000P9_A1EmpCod ;
   private short[] BC000P9_A1547GuarCod ;
   private int[] BC000P10_A3CliCod ;
   private int[] BC000P11_A3CliCod ;
   private int[] BC000P12_A3CliCod ;
   private String[] BC000P12_A2349LegSuelConcepto ;
   private short[] BC000P12_A1EmpCod ;
   private int[] BC000P12_A6LegNumero ;
   private short[] BC000P12_A1135LegSuelSec ;
   private int[] BC000P13_A3CliCod ;
   private String[] BC000P13_A2349LegSuelConcepto ;
   private short[] BC000P13_A1EmpCod ;
   private int[] BC000P13_A6LegNumero ;
   private short[] BC000P13_A1135LegSuelSec ;
   private int[] BC000P14_A3CliCod ;
   private int[] BC000P15_A3CliCod ;
   private short[] BC000P15_A1EmpCod ;
   private int[] BC000P15_A6LegNumero ;
   private short[] BC000P15_A1135LegSuelSec ;
   private java.util.Date[] BC000P15_A1136LegSuelFecha ;
   private java.math.BigDecimal[] BC000P15_A1137LegSuelImporte ;
   private String[] BC000P15_A2344LegSuelTipo ;
   private java.math.BigDecimal[] BC000P15_A2347LegSuelCalc ;
   private String[] BC000P15_A2348LegSuelLog ;
   private int[] BC000P16_A3CliCod ;
   private short[] BC000P16_A1EmpCod ;
   private int[] BC000P16_A6LegNumero ;
   private short[] BC000P16_A1135LegSuelSec ;
   private java.util.Date[] BC000P16_A1136LegSuelFecha ;
   private java.math.BigDecimal[] BC000P16_A1137LegSuelImporte ;
   private String[] BC000P16_A2344LegSuelTipo ;
   private java.math.BigDecimal[] BC000P16_A2347LegSuelCalc ;
   private String[] BC000P16_A2348LegSuelLog ;
   private String[] BC000P17_A19SinieCodigo ;
   private byte[] BC000P17_A263LegSexo ;
   private short[] BC000P17_A243LegEstadoCivil ;
   private short[] BC000P17_A22LegPaiCod ;
   private short[] BC000P17_A23LegProvCod ;
   private short[] BC000P17_A24LegLocCod ;
   private short[] BC000P17_A21LegNacionCod ;
   private String[] BC000P17_A910LegSinCod ;
   private int[] BC000P17_A2182LegActClasNro ;
   private String[] BC000P17_A15LegActCodigo ;
   private short[] BC000P17_A1603LegSitRevEgreso ;
   private String[] BC000P17_A2181LegPueAfiCod ;
   private String[] BC000P17_A1235LegReligion ;
   private String[] BC000P17_A1236LegOrigen ;
   private boolean[] BC000P17_A237LegConvenio ;
   private String[] BC000P17_A250LegIdNomApe ;
   private String[] BC000P17_A591LegNomApe ;
   private int[] BC000P17_A6LegNumero ;
   private java.util.Date[] BC000P17_A247LegFecUltMod ;
   private String[] BC000P17_A230LegApellido ;
   private String[] BC000P17_A251LegNombre ;
   private String[] BC000P17_A249LegFoto ;
   private byte[] BC000P17_A266LegTipDoc ;
   private String[] BC000P17_A257LegNumDoc ;
   private java.util.Date[] BC000P17_A246LegFecNac ;
   private long[] BC000P17_A239LegCUIL ;
   private byte[] BC000P17_A241LegDiscapacidad ;
   private String[] BC000P17_A242LegDomici ;
   private String[] BC000P17_A479LegEmail ;
   private String[] BC000P17_A236LegCodPos ;
   private String[] BC000P17_A265LegTelefono ;
   private java.util.Date[] BC000P17_A245LegFecIngreso ;
   private java.util.Date[] BC000P17_A244LegFecEgreso ;
   private String[] BC000P17_A939LegCatCodigo ;
   private int[] BC000P17_A2215LegCatPueCod ;
   private byte[] BC000P17_A235LegClase ;
   private byte[] BC000P17_A248LegFormaPago ;
   private String[] BC000P17_A231LegBanSuc ;
   private String[] BC000P17_A232LegBanTipCuen ;
   private String[] BC000P17_A238LegCuentaBanc ;
   private java.util.Date[] BC000P17_A253LegLicInicio ;
   private java.util.Date[] BC000P17_A252LegLicFinal ;
   private String[] BC000P17_A234LegCBU ;
   private boolean[] BC000P17_A262LegSCVO ;
   private boolean[] BC000P17_A228LegActivo ;
   private java.math.BigDecimal[] BC000P17_A264LegSueldoFuera ;
   private String[] BC000P17_A93LegId ;
   private String[] BC000P17_A937LegConveCodigo ;
   private String[] BC000P17_A515LegObs ;
   private java.util.Date[] BC000P17_A630LegFecImportacion ;
   private boolean[] BC000P17_A877LegAgenReten ;
   private String[] BC000P17_A879LegContinua ;
   private boolean[] BC000P17_A942LegRecalcLiq ;
   private boolean[] BC000P17_A1016LegJubilado ;
   private java.math.BigDecimal[] BC000P17_A1023LegHorasDia ;
   private java.math.BigDecimal[] BC000P17_A1268LegHorasSem ;
   private boolean[] BC000P17_A1245LegTrabLun ;
   private boolean[] BC000P17_A1246LegTrabMar ;
   private boolean[] BC000P17_A1247LegTrabMie ;
   private boolean[] BC000P17_A1248LegTrabJue ;
   private boolean[] BC000P17_A1249LegTrabVie ;
   private boolean[] BC000P17_A1250LegTrabSa ;
   private boolean[] BC000P17_A1251LegTrabDo ;
   private short[] BC000P17_A1523LegVacPend ;
   private java.util.Date[] BC000P17_A1531LegFecPreAviso ;
   private int[] BC000P17_A1576LegConveVersionCli ;
   private String[] BC000P17_A1759LegPromDias ;
   private String[] BC000P17_A1804LegTitulo ;
   private byte[] BC000P17_A1818LegEstado ;
   private String[] BC000P17_A2263LegMigrWarn ;
   private boolean[] BC000P17_A2267LegIncompleto ;
   private boolean[] BC000P17_A2309LegLiqApo ;
   private String[] BC000P17_A2404LegModTra ;
   private String[] BC000P17_A2417LegTipoTarifa ;
   private String[] BC000P17_A1031LegFotoExt ;
   private String[] BC000P17_A1030LegFotoNom ;
   private int[] BC000P17_A3CliCod ;
   private String[] BC000P17_A1582LegBanCod ;
   private String[] BC000P17_A1581LegLpgCodigo ;
   private String[] BC000P17_A1583LegMegCodigo ;
   private String[] BC000P17_A1580LegOsoCod ;
   private String[] BC000P17_A1579LegSecCodigo ;
   private short[] BC000P17_A1EmpCod ;
   private String[] BC000P17_A1577LegSucCodigo ;
   private String[] BC000P17_A1578LegPuesCodigo ;
   private String[] BC000P17_A18MprCod ;
   private String[] BC000P17_A20ZonCod ;
   private short[] BC000P17_A17CondiCodigo ;
   private String[] BC000P18_A19SinieCodigo ;
   private byte[] BC000P18_A263LegSexo ;
   private short[] BC000P18_A243LegEstadoCivil ;
   private short[] BC000P18_A22LegPaiCod ;
   private short[] BC000P18_A23LegProvCod ;
   private short[] BC000P18_A24LegLocCod ;
   private short[] BC000P18_A21LegNacionCod ;
   private String[] BC000P18_A910LegSinCod ;
   private int[] BC000P18_A2182LegActClasNro ;
   private String[] BC000P18_A15LegActCodigo ;
   private short[] BC000P18_A1603LegSitRevEgreso ;
   private String[] BC000P18_A2181LegPueAfiCod ;
   private String[] BC000P18_A1235LegReligion ;
   private String[] BC000P18_A1236LegOrigen ;
   private boolean[] BC000P18_A237LegConvenio ;
   private String[] BC000P18_A250LegIdNomApe ;
   private String[] BC000P18_A591LegNomApe ;
   private int[] BC000P18_A6LegNumero ;
   private java.util.Date[] BC000P18_A247LegFecUltMod ;
   private String[] BC000P18_A230LegApellido ;
   private String[] BC000P18_A251LegNombre ;
   private String[] BC000P18_A249LegFoto ;
   private byte[] BC000P18_A266LegTipDoc ;
   private String[] BC000P18_A257LegNumDoc ;
   private java.util.Date[] BC000P18_A246LegFecNac ;
   private long[] BC000P18_A239LegCUIL ;
   private byte[] BC000P18_A241LegDiscapacidad ;
   private String[] BC000P18_A242LegDomici ;
   private String[] BC000P18_A479LegEmail ;
   private String[] BC000P18_A236LegCodPos ;
   private String[] BC000P18_A265LegTelefono ;
   private java.util.Date[] BC000P18_A245LegFecIngreso ;
   private java.util.Date[] BC000P18_A244LegFecEgreso ;
   private String[] BC000P18_A939LegCatCodigo ;
   private int[] BC000P18_A2215LegCatPueCod ;
   private byte[] BC000P18_A235LegClase ;
   private byte[] BC000P18_A248LegFormaPago ;
   private String[] BC000P18_A231LegBanSuc ;
   private String[] BC000P18_A232LegBanTipCuen ;
   private String[] BC000P18_A238LegCuentaBanc ;
   private java.util.Date[] BC000P18_A253LegLicInicio ;
   private java.util.Date[] BC000P18_A252LegLicFinal ;
   private String[] BC000P18_A234LegCBU ;
   private boolean[] BC000P18_A262LegSCVO ;
   private boolean[] BC000P18_A228LegActivo ;
   private java.math.BigDecimal[] BC000P18_A264LegSueldoFuera ;
   private String[] BC000P18_A93LegId ;
   private String[] BC000P18_A937LegConveCodigo ;
   private String[] BC000P18_A515LegObs ;
   private java.util.Date[] BC000P18_A630LegFecImportacion ;
   private boolean[] BC000P18_A877LegAgenReten ;
   private String[] BC000P18_A879LegContinua ;
   private boolean[] BC000P18_A942LegRecalcLiq ;
   private boolean[] BC000P18_A1016LegJubilado ;
   private java.math.BigDecimal[] BC000P18_A1023LegHorasDia ;
   private java.math.BigDecimal[] BC000P18_A1268LegHorasSem ;
   private boolean[] BC000P18_A1245LegTrabLun ;
   private boolean[] BC000P18_A1246LegTrabMar ;
   private boolean[] BC000P18_A1247LegTrabMie ;
   private boolean[] BC000P18_A1248LegTrabJue ;
   private boolean[] BC000P18_A1249LegTrabVie ;
   private boolean[] BC000P18_A1250LegTrabSa ;
   private boolean[] BC000P18_A1251LegTrabDo ;
   private short[] BC000P18_A1523LegVacPend ;
   private java.util.Date[] BC000P18_A1531LegFecPreAviso ;
   private int[] BC000P18_A1576LegConveVersionCli ;
   private String[] BC000P18_A1759LegPromDias ;
   private String[] BC000P18_A1804LegTitulo ;
   private byte[] BC000P18_A1818LegEstado ;
   private String[] BC000P18_A2263LegMigrWarn ;
   private boolean[] BC000P18_A2267LegIncompleto ;
   private boolean[] BC000P18_A2309LegLiqApo ;
   private String[] BC000P18_A2404LegModTra ;
   private String[] BC000P18_A2417LegTipoTarifa ;
   private String[] BC000P18_A1031LegFotoExt ;
   private String[] BC000P18_A1030LegFotoNom ;
   private int[] BC000P18_A3CliCod ;
   private String[] BC000P18_A1582LegBanCod ;
   private String[] BC000P18_A1581LegLpgCodigo ;
   private String[] BC000P18_A1583LegMegCodigo ;
   private String[] BC000P18_A1580LegOsoCod ;
   private String[] BC000P18_A1579LegSecCodigo ;
   private short[] BC000P18_A1EmpCod ;
   private String[] BC000P18_A1577LegSucCodigo ;
   private String[] BC000P18_A1578LegPuesCodigo ;
   private String[] BC000P18_A18MprCod ;
   private String[] BC000P18_A20ZonCod ;
   private short[] BC000P18_A17CondiCodigo ;
   private String[] BC000P19_A2224LegBanDes ;
   private String[] BC000P20_A291LpgDescri ;
   private String[] BC000P21_A300MegDescrip ;
   private String[] BC000P22_A2225LegOsoDes ;
   private String[] BC000P22_A2226LegOsoAfipCod ;
   private String[] BC000P22_A392OsoSigla ;
   private String[] BC000P23_A329SecDescrip ;
   private String[] BC000P24_A45TipEmpleCod ;
   private String[] BC000P24_A1965EmpOsoCod ;
   private String[] BC000P24_A2EmpNom ;
   private int[] BC000P25_A3CliCod ;
   private int[] BC000P26_A3CliCod ;
   private String[] BC000P27_A684MprDescripSinAc ;
   private String[] BC000P27_A303MprDescrip ;
   private String[] BC000P28_A678ZonDescripSinAc ;
   private String[] BC000P28_A342ZonDescrip ;
   private java.math.BigDecimal[] BC000P28_A343ZonPorcReduc ;
   private String[] BC000P29_A686CondiDescriSinAc ;
   private String[] BC000P29_A144CondiDescri ;
   private String[] BC000P30_A688SinieDescriSinAc ;
   private String[] BC000P30_A333SinieDescri ;
   private byte[] BC000P31_A263LegSexo ;
   private short[] BC000P32_A243LegEstadoCivil ;
   private String[] BC000P33_A258LegPaiNom ;
   private String[] BC000P34_A260LegProvNom ;
   private String[] BC000P35_A255LegLocNom ;
   private String[] BC000P36_A256LegNacionalidad ;
   private String[] BC000P37_A331SinDescrip ;
   private short[] BC000P38_A22LegPaiCod ;
   private String[] BC000P39_A227LegActDescri ;
   private short[] BC000P40_A1603LegSitRevEgreso ;
   private String[] BC000P41_A2181LegPueAfiCod ;
   private String[] BC000P42_A307OsoDescrip ;
   private String[] BC000P42_A306OsoC3992 ;
   private boolean[] BC000P8_n209FamFecNac ;
   private boolean[] BC000P8_n205FamDiscap ;
   private boolean[] BC000P8_n1547GuarCod ;
   private boolean[] BC000P9_n209FamFecNac ;
   private boolean[] BC000P9_n205FamDiscap ;
   private boolean[] BC000P9_n1547GuarCod ;
   private boolean[] BC000P15_n2344LegSuelTipo ;
   private boolean[] BC000P16_n2344LegSuelTipo ;
   private boolean[] BC000P17_n19SinieCodigo ;
   private boolean[] BC000P17_n263LegSexo ;
   private boolean[] BC000P17_n243LegEstadoCivil ;
   private boolean[] BC000P17_n22LegPaiCod ;
   private boolean[] BC000P17_n23LegProvCod ;
   private boolean[] BC000P17_n24LegLocCod ;
   private boolean[] BC000P17_n21LegNacionCod ;
   private boolean[] BC000P17_n910LegSinCod ;
   private boolean[] BC000P17_n2182LegActClasNro ;
   private boolean[] BC000P17_n15LegActCodigo ;
   private boolean[] BC000P17_n1603LegSitRevEgreso ;
   private boolean[] BC000P17_n2181LegPueAfiCod ;
   private boolean[] BC000P17_n1235LegReligion ;
   private boolean[] BC000P17_n1236LegOrigen ;
   private boolean[] BC000P17_n249LegFoto ;
   private boolean[] BC000P17_n265LegTelefono ;
   private boolean[] BC000P17_n244LegFecEgreso ;
   private boolean[] BC000P17_n939LegCatCodigo ;
   private boolean[] BC000P17_n2215LegCatPueCod ;
   private boolean[] BC000P17_n231LegBanSuc ;
   private boolean[] BC000P17_n232LegBanTipCuen ;
   private boolean[] BC000P17_n238LegCuentaBanc ;
   private boolean[] BC000P17_n253LegLicInicio ;
   private boolean[] BC000P17_n252LegLicFinal ;
   private boolean[] BC000P17_n234LegCBU ;
   private boolean[] BC000P17_n93LegId ;
   private boolean[] BC000P17_n937LegConveCodigo ;
   private boolean[] BC000P17_n1576LegConveVersionCli ;
   private boolean[] BC000P17_n2263LegMigrWarn ;
   private boolean[] BC000P17_n1582LegBanCod ;
   private boolean[] BC000P17_n1581LegLpgCodigo ;
   private boolean[] BC000P17_n1583LegMegCodigo ;
   private boolean[] BC000P17_n1580LegOsoCod ;
   private boolean[] BC000P17_n1579LegSecCodigo ;
   private boolean[] BC000P17_n1577LegSucCodigo ;
   private boolean[] BC000P17_n1578LegPuesCodigo ;
   private boolean[] BC000P17_n18MprCod ;
   private boolean[] BC000P17_n20ZonCod ;
   private boolean[] BC000P17_n17CondiCodigo ;
   private boolean[] BC000P18_n19SinieCodigo ;
   private boolean[] BC000P18_n263LegSexo ;
   private boolean[] BC000P18_n243LegEstadoCivil ;
   private boolean[] BC000P18_n22LegPaiCod ;
   private boolean[] BC000P18_n23LegProvCod ;
   private boolean[] BC000P18_n24LegLocCod ;
   private boolean[] BC000P18_n21LegNacionCod ;
   private boolean[] BC000P18_n910LegSinCod ;
   private boolean[] BC000P18_n2182LegActClasNro ;
   private boolean[] BC000P18_n15LegActCodigo ;
   private boolean[] BC000P18_n1603LegSitRevEgreso ;
   private boolean[] BC000P18_n2181LegPueAfiCod ;
   private boolean[] BC000P18_n1235LegReligion ;
   private boolean[] BC000P18_n1236LegOrigen ;
   private boolean[] BC000P18_n249LegFoto ;
   private boolean[] BC000P18_n265LegTelefono ;
   private boolean[] BC000P18_n244LegFecEgreso ;
   private boolean[] BC000P18_n939LegCatCodigo ;
   private boolean[] BC000P18_n2215LegCatPueCod ;
   private boolean[] BC000P18_n231LegBanSuc ;
   private boolean[] BC000P18_n232LegBanTipCuen ;
   private boolean[] BC000P18_n238LegCuentaBanc ;
   private boolean[] BC000P18_n253LegLicInicio ;
   private boolean[] BC000P18_n252LegLicFinal ;
   private boolean[] BC000P18_n234LegCBU ;
   private boolean[] BC000P18_n93LegId ;
   private boolean[] BC000P18_n937LegConveCodigo ;
   private boolean[] BC000P18_n1576LegConveVersionCli ;
   private boolean[] BC000P18_n2263LegMigrWarn ;
   private boolean[] BC000P18_n1582LegBanCod ;
   private boolean[] BC000P18_n1581LegLpgCodigo ;
   private boolean[] BC000P18_n1583LegMegCodigo ;
   private boolean[] BC000P18_n1580LegOsoCod ;
   private boolean[] BC000P18_n1579LegSecCodigo ;
   private boolean[] BC000P18_n1577LegSucCodigo ;
   private boolean[] BC000P18_n1578LegPuesCodigo ;
   private boolean[] BC000P18_n18MprCod ;
   private boolean[] BC000P18_n20ZonCod ;
   private boolean[] BC000P18_n17CondiCodigo ;
   private boolean[] BC000P20_n291LpgDescri ;
   private boolean[] BC000P21_n300MegDescrip ;
   private boolean[] BC000P22_n2226LegOsoAfipCod ;
   private boolean[] BC000P22_n392OsoSigla ;
   private boolean[] BC000P23_n329SecDescrip ;
   private boolean[] BC000P24_n45TipEmpleCod ;
   private boolean[] BC000P24_n1965EmpOsoCod ;
   private boolean[] BC000P37_n331SinDescrip ;
   private boolean[] BC000P42_n307OsoDescrip ;
   private boolean[] BC000P42_n306OsoC3992 ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV33TrnContextAtt ;
}

final  class legajo_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000P2", "SELECT CliCod, EmpCod, LegNumero, LegPropValNum, LegPropValBool, LegPropValStr, LegPropValDate, LegPropCod FROM LegajoPropiedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegPropCod = ?  FOR UPDATE OF LegajoPropiedades",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P3", "SELECT CliCod, EmpCod, LegNumero, LegPropValNum, LegPropValBool, LegPropValStr, LegPropValDate, LegPropCod FROM LegajoPropiedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegPropCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P4", "SELECT propDesc AS LegPropDes, propTipoDato AS LegPropTD FROM propiedades_adicionales WHERE propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P5", "SELECT CliCod, EmpCod, LegNumero, LegTipoTra FROM Legajotipos_de_trabajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegTipoTra = ?  FOR UPDATE OF Legajotipos_de_trabajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P6", "SELECT CliCod, EmpCod, LegNumero, LegTipoTra FROM Legajotipos_de_trabajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegTipoTra = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P7", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P8", "SELECT LegNumero, LegOrden, FamTomaDeducImpGan, FamNomApe, FamFecNac, FamDiscap, FamNroDoc, FamAdherente, CliCod, ParCod, EmpCod, GuarCod FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ?  FOR UPDATE OF LegajoFamilia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P9", "SELECT LegNumero, LegOrden, FamTomaDeducImpGan, FamNomApe, FamFecNac, FamDiscap, FamNroDoc, FamAdherente, CliCod, ParCod, EmpCod, GuarCod FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P10", "SELECT CliCod FROM Parentesco WHERE CliCod = ? AND ParCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P11", "SELECT CliCod FROM EmpresaGuarderias WHERE CliCod = ? AND EmpCod = ? AND GuarCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P12", "SELECT CliCod, LegSuelConcepto, EmpCod, LegNumero, LegSuelSec FROM Legajo_sueldosConceptos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ? AND LegSuelConcepto = ?  FOR UPDATE OF Legajo_sueldosConceptos",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P13", "SELECT CliCod, LegSuelConcepto, EmpCod, LegNumero, LegSuelSec FROM Legajo_sueldosConceptos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ? AND LegSuelConcepto = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P14", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P15", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelFecha, LegSuelImporte, LegSuelTipo, LegSuelCalc, LegSuelLog FROM legajo_sueldos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ?  FOR UPDATE OF legajo_sueldos",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P16", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelFecha, LegSuelImporte, LegSuelTipo, LegSuelCalc, LegSuelLog FROM legajo_sueldos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P17", "SELECT SinieCodigo, LegSexo, LegEstadoCivil, LegPaiCod, LegProvCod, LegLocCod, LegNacionCod, LegSinCod, LegActClasNro, LegActCodigo, LegSitRevEgreso, LegPueAfiCod, LegReligion, LegOrigen, LegConvenio, LegIdNomApe, LegNomApe, LegNumero, LegFecUltMod, LegApellido, LegNombre, LegFoto, LegTipDoc, LegNumDoc, LegFecNac, LegCUIL, LegDiscapacidad, LegDomici, LegEmail, LegCodPos, LegTelefono, LegFecIngreso, LegFecEgreso, LegCatCodigo, LegCatPueCod, LegClase, LegFormaPago, LegBanSuc, LegBanTipCuen, LegCuentaBanc, LegLicInicio, LegLicFinal, LegCBU, LegSCVO, LegActivo, LegSueldoFuera, LegId, LegConveCodigo, LegObs, LegFecImportacion, LegAgenReten, LegContinua, LegRecalcLiq, LegJubilado, LegHorasDia, LegHorasSem, LegTrabLun, LegTrabMar, LegTrabMie, LegTrabJue, LegTrabVie, LegTrabSa, LegTrabDo, LegVacPend, LegFecPreAviso, LegConveVersionCli, LegPromDias, LegTitulo, LegEstado, LegMigrWarn, LegIncompleto, LegLiqApo, LegModTra, LegTipoTarifa, LegFotoExt, LegFotoNom, CliCod, LegBanCod, LegLpgCodigo, LegMegCodigo, LegOsoCod, LegSecCodigo, EmpCod, LegSucCodigo, LegPuesCodigo, MprCod, ZonCod, CondiCodigo FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  FOR UPDATE OF Legajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P18", "SELECT SinieCodigo, LegSexo, LegEstadoCivil, LegPaiCod, LegProvCod, LegLocCod, LegNacionCod, LegSinCod, LegActClasNro, LegActCodigo, LegSitRevEgreso, LegPueAfiCod, LegReligion, LegOrigen, LegConvenio, LegIdNomApe, LegNomApe, LegNumero, LegFecUltMod, LegApellido, LegNombre, LegFoto, LegTipDoc, LegNumDoc, LegFecNac, LegCUIL, LegDiscapacidad, LegDomici, LegEmail, LegCodPos, LegTelefono, LegFecIngreso, LegFecEgreso, LegCatCodigo, LegCatPueCod, LegClase, LegFormaPago, LegBanSuc, LegBanTipCuen, LegCuentaBanc, LegLicInicio, LegLicFinal, LegCBU, LegSCVO, LegActivo, LegSueldoFuera, LegId, LegConveCodigo, LegObs, LegFecImportacion, LegAgenReten, LegContinua, LegRecalcLiq, LegJubilado, LegHorasDia, LegHorasSem, LegTrabLun, LegTrabMar, LegTrabMie, LegTrabJue, LegTrabVie, LegTrabSa, LegTrabDo, LegVacPend, LegFecPreAviso, LegConveVersionCli, LegPromDias, LegTitulo, LegEstado, LegMigrWarn, LegIncompleto, LegLiqApo, LegModTra, LegTipoTarifa, LegFotoExt, LegFotoNom, CliCod, LegBanCod, LegLpgCodigo, LegMegCodigo, LegOsoCod, LegSecCodigo, EmpCod, LegSucCodigo, LegPuesCodigo, MprCod, ZonCod, CondiCodigo FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P19", "SELECT BanDescrip AS LegBanDes FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P20", "SELECT LpgDescri FROM LugardePago WHERE CliCod = ? AND LpgCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P21", "SELECT MegDescrip FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P22", "SELECT OsoDescrip AS LegOsoDes, OsoC3992 AS LegOsoAfipCod, OsoSigla FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P23", "SELECT SecDescrip FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P24", "SELECT TipEmpleCod, EmpOsoCod, EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P25", "SELECT CliCod FROM Sucursal WHERE CliCod = ? AND EmpCod = ? AND SucCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P26", "SELECT CliCod FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P27", "SELECT MprDescripSinAc, MprDescrip FROM ModalidadAFIP WHERE MprCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P28", "SELECT ZonDescripSinAc, ZonDescrip, ZonPorcReduc FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P29", "SELECT CondiDescriSinAc, CondiDescri FROM CondicionAFIP WHERE CondiCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P30", "SELECT SinieDescriSinAc, SinieDescri FROM Siniestrado WHERE SinieCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P31", "SELECT SexoId AS LegSexo FROM Sexos WHERE SexoId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P32", "SELECT EstaCivilCod AS LegEstadoCivil FROM Estados_civiles WHERE EstaCivilCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P33", "SELECT PaiNom AS LegPaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P34", "SELECT ProvNom AS LegProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P35", "SELECT LocNom AS LegLocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P36", "SELECT PaiNom AS LegNacionalidad FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P37", "SELECT SinDescrip FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P38", "SELECT PaiCod AS LegPaiCod FROM ActividadLaboralClasificada WHERE PaiCod = ? AND ActLabNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P39", "SELECT ActDescrip AS LegActDescri FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P40", "SELECT SitRevCodigo AS LegSitRevEgreso FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P41", "SELECT PueAfipCod AS LegPueAfiCod FROM PuestoAfip WHERE PueAfipCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P42", "SELECT OsoDescrip, OsoC3992 FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P43", "SELECT TM1.SinieCodigo, TM1.LegSexo AS LegSexo, TM1.LegEstadoCivil AS LegEstadoCivil, TM1.LegPaiCod AS LegPaiCod, TM1.LegProvCod AS LegProvCod, TM1.LegLocCod AS LegLocCod, TM1.LegNacionCod AS LegNacionCod, TM1.LegSinCod AS LegSinCod, TM1.LegActClasNro AS LegActClasNro, TM1.LegActCodigo AS LegActCodigo, TM1.LegSitRevEgreso AS LegSitRevEgreso, TM1.LegPueAfiCod AS LegPueAfiCod, T2.TipEmpleCod, TM1.LegReligion, TM1.LegOrigen, T2.EmpOsoCod AS EmpOsoCod, TM1.LegConvenio, T18.SinieDescriSinAc, T17.CondiDescriSinAc, T16.ZonDescripSinAc, T15.MprDescripSinAc, TM1.LegIdNomApe, TM1.LegNomApe, TM1.LegNumero, TM1.LegFecUltMod, T2.EmpNom, TM1.LegApellido, TM1.LegNombre, TM1.LegFoto, TM1.LegTipDoc, TM1.LegNumDoc, TM1.LegFecNac, T4.PaiNom AS LegNacionalidad, TM1.LegCUIL, TM1.LegDiscapacidad, TM1.LegDomici, TM1.LegEmail, TM1.LegCodPos, T5.PaiNom AS LegPaiNom, T6.ProvNom AS LegProvNom, T7.LocNom AS LegLocNom, TM1.LegTelefono, TM1.LegFecIngreso, TM1.LegFecEgreso, T8.MegDescrip, TM1.LegCatCodigo, TM1.LegCatPueCod, T9.SecDescrip, T10.LpgDescri, TM1.LegClase, TM1.LegFormaPago, T11.BanDescrip AS LegBanDes, TM1.LegBanSuc, TM1.LegBanTipCuen, T12.SinDescrip, T13.OsoDescrip AS LegOsoDes, T13.OsoC3992 AS LegOsoAfipCod, T3.OsoDescrip, T14.ActDescrip AS LegActDescri, T15.MprDescrip, TM1.LegCuentaBanc, TM1.LegLicInicio, TM1.LegLicFinal, T16.ZonDescrip, T16.ZonPorcReduc, TM1.LegCBU, TM1.LegSCVO, T17.CondiDescri, T18.SinieDescri, TM1.LegActivo, TM1.LegSueldoFuera, TM1.LegId, TM1.LegConveCodigo, T3.OsoC3992, TM1.LegObs, TM1.LegFecImportacion, TM1.LegAgenReten, TM1.LegContinua, TM1.LegRecalcLiq, TM1.LegJubilado, TM1.LegHorasDia, TM1.LegHorasSem, TM1.LegTrabLun, TM1.LegTrabMar, TM1.LegTrabMie, TM1.LegTrabJue, TM1.LegTrabVie, TM1.LegTrabSa, TM1.LegTrabDo, TM1.LegVacPend, TM1.LegFecPreAviso, TM1.LegConveVersionCli, TM1.LegPromDias, TM1.LegTitulo, TM1.LegEstado, TM1.LegMigrWarn, TM1.LegIncompleto, TM1.LegLiqApo, TM1.LegModTra, TM1.LegTipoTarifa, TM1.LegFotoExt, TM1.LegFotoNom, T13.OsoSigla, TM1.CliCod, TM1.LegBanCod AS LegBanCod, TM1.LegLpgCodigo AS LegLpgCodigo, TM1.LegMegCodigo AS LegMegCodigo, TM1.LegOsoCod AS LegOsoCod, TM1.LegSecCodigo AS LegSecCodigo, TM1.EmpCod, TM1.LegSucCodigo AS LegSucCodigo, TM1.LegPuesCodigo AS LegPuesCodigo, TM1.MprCod, TM1.ZonCod, TM1.CondiCodigo FROM (((((((((((((((((Legajo TM1 INNER JOIN Empresa T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod) LEFT JOIN ObraSocial T3 ON T3.CliCod = TM1.CliCod AND T3.OsoCod = T2.EmpOsoCod) LEFT JOIN Pais T4 ON T4.PaiCod = TM1.LegNacionCod) LEFT JOIN Pais T5 ON T5.PaiCod = TM1.LegPaiCod) LEFT JOIN Provincia T6 ON T6.PaiCod = TM1.LegPaiCod AND T6.ProvCod = TM1.LegProvCod) LEFT JOIN Localidad T7 ON T7.PaiCod = TM1.LegPaiCod AND T7.ProvCod = TM1.LegProvCod AND T7.LocCod = TM1.LegLocCod) LEFT JOIN MotivoEgreso T8 ON T8.CliCod = TM1.CliCod AND T8.MegCodigo = TM1.LegMegCodigo) LEFT JOIN Seccion T9 ON T9.CliCod = TM1.CliCod AND T9.SecCodigo = TM1.LegSecCodigo) LEFT JOIN LugardePago T10 ON T10.CliCod = TM1.CliCod AND T10.LpgCodigo = TM1.LegLpgCodigo) LEFT JOIN Banco T11 ON T11.CliCod = TM1.CliCod AND T11.BanCod = TM1.LegBanCod) LEFT JOIN Sindicato T12 ON T12.PaiCod = TM1.LegPaiCod AND T12.SinCod = TM1.LegSinCod) LEFT JOIN ObraSocial T13 ON T13.CliCod = TM1.CliCod AND T13.OsoCod = TM1.LegOsoCod) LEFT JOIN Actividad T14 ON T14.ActCodigo = TM1.LegActCodigo) LEFT JOIN ModalidadAFIP T15 ON T15.MprCod = TM1.MprCod) LEFT JOIN Zona T16 ON T16.ZonCod = TM1.ZonCod) LEFT JOIN CondicionAFIP T17 ON T17.CondiCodigo = TM1.CondiCodigo) LEFT JOIN Siniestrado T18 ON T18.SinieCodigo = TM1.SinieCodigo) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P44", "SELECT BanDescrip AS LegBanDes FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P45", "SELECT LpgDescri FROM LugardePago WHERE CliCod = ? AND LpgCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P46", "SELECT MegDescrip FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P47", "SELECT OsoDescrip AS LegOsoDes, OsoC3992 AS LegOsoAfipCod, OsoSigla FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P48", "SELECT SecDescrip FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P49", "SELECT CliCod FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P50", "SELECT TipEmpleCod, EmpOsoCod, EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P51", "SELECT OsoDescrip, OsoC3992 FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P52", "SELECT CliCod FROM Sucursal WHERE CliCod = ? AND EmpCod = ? AND SucCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P53", "SELECT SexoId AS LegSexo FROM Sexos WHERE SexoId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P54", "SELECT EstaCivilCod AS LegEstadoCivil FROM Estados_civiles WHERE EstaCivilCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P55", "SELECT PaiNom AS LegNacionalidad FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P56", "SELECT PaiNom AS LegPaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P57", "SELECT ProvNom AS LegProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P58", "SELECT LocNom AS LegLocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P59", "SELECT SinDescrip FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P60", "SELECT PaiCod AS LegPaiCod FROM ActividadLaboralClasificada WHERE PaiCod = ? AND ActLabNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P61", "SELECT ActDescrip AS LegActDescri FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P62", "SELECT MprDescripSinAc, MprDescrip FROM ModalidadAFIP WHERE MprCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P63", "SELECT ZonDescripSinAc, ZonDescrip, ZonPorcReduc FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P64", "SELECT CondiDescriSinAc, CondiDescri FROM CondicionAFIP WHERE CondiCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P65", "SELECT SinieDescriSinAc, SinieDescri FROM Siniestrado WHERE SinieCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P66", "SELECT SitRevCodigo AS LegSitRevEgreso FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P67", "SELECT PueAfipCod AS LegPueAfiCod FROM PuestoAfip WHERE PueAfipCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P68", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P69", "SELECT SinieCodigo, LegSexo, LegEstadoCivil, LegPaiCod, LegProvCod, LegLocCod, LegNacionCod, LegSinCod, LegActClasNro, LegActCodigo, LegSitRevEgreso, LegPueAfiCod, LegReligion, LegOrigen, LegConvenio, LegIdNomApe, LegNomApe, LegNumero, LegFecUltMod, LegApellido, LegNombre, LegFoto, LegTipDoc, LegNumDoc, LegFecNac, LegCUIL, LegDiscapacidad, LegDomici, LegEmail, LegCodPos, LegTelefono, LegFecIngreso, LegFecEgreso, LegCatCodigo, LegCatPueCod, LegClase, LegFormaPago, LegBanSuc, LegBanTipCuen, LegCuentaBanc, LegLicInicio, LegLicFinal, LegCBU, LegSCVO, LegActivo, LegSueldoFuera, LegId, LegConveCodigo, LegObs, LegFecImportacion, LegAgenReten, LegContinua, LegRecalcLiq, LegJubilado, LegHorasDia, LegHorasSem, LegTrabLun, LegTrabMar, LegTrabMie, LegTrabJue, LegTrabVie, LegTrabSa, LegTrabDo, LegVacPend, LegFecPreAviso, LegConveVersionCli, LegPromDias, LegTitulo, LegEstado, LegMigrWarn, LegIncompleto, LegLiqApo, LegModTra, LegTipoTarifa, LegFotoExt, LegFotoNom, CliCod, LegBanCod, LegLpgCodigo, LegMegCodigo, LegOsoCod, LegSecCodigo, EmpCod, LegSucCodigo, LegPuesCodigo, MprCod, ZonCod, CondiCodigo FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P70", "SELECT SinieCodigo, LegSexo, LegEstadoCivil, LegPaiCod, LegProvCod, LegLocCod, LegNacionCod, LegSinCod, LegActClasNro, LegActCodigo, LegSitRevEgreso, LegPueAfiCod, LegReligion, LegOrigen, LegConvenio, LegIdNomApe, LegNomApe, LegNumero, LegFecUltMod, LegApellido, LegNombre, LegFoto, LegTipDoc, LegNumDoc, LegFecNac, LegCUIL, LegDiscapacidad, LegDomici, LegEmail, LegCodPos, LegTelefono, LegFecIngreso, LegFecEgreso, LegCatCodigo, LegCatPueCod, LegClase, LegFormaPago, LegBanSuc, LegBanTipCuen, LegCuentaBanc, LegLicInicio, LegLicFinal, LegCBU, LegSCVO, LegActivo, LegSueldoFuera, LegId, LegConveCodigo, LegObs, LegFecImportacion, LegAgenReten, LegContinua, LegRecalcLiq, LegJubilado, LegHorasDia, LegHorasSem, LegTrabLun, LegTrabMar, LegTrabMie, LegTrabJue, LegTrabVie, LegTrabSa, LegTrabDo, LegVacPend, LegFecPreAviso, LegConveVersionCli, LegPromDias, LegTitulo, LegEstado, LegMigrWarn, LegIncompleto, LegLiqApo, LegModTra, LegTipoTarifa, LegFotoExt, LegFotoNom, CliCod, LegBanCod, LegLpgCodigo, LegMegCodigo, LegOsoCod, LegSecCodigo, EmpCod, LegSucCodigo, LegPuesCodigo, MprCod, ZonCod, CondiCodigo FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  FOR UPDATE OF Legajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000P71", "SAVEPOINT gxupdate;INSERT INTO Legajo(LegConvenio, LegIdNomApe, LegNomApe, LegNumero, LegFecUltMod, LegApellido, LegNombre, LegFoto, LegTipDoc, LegNumDoc, LegFecNac, LegCUIL, LegDiscapacidad, LegDomici, LegEmail, LegCodPos, LegTelefono, LegFecIngreso, LegFecEgreso, LegCatCodigo, LegCatPueCod, LegClase, LegFormaPago, LegBanSuc, LegBanTipCuen, LegCuentaBanc, LegLicInicio, LegLicFinal, LegCBU, LegSCVO, LegActivo, LegSueldoFuera, LegId, LegConveCodigo, LegObs, LegFecImportacion, LegAgenReten, LegContinua, LegRecalcLiq, LegJubilado, LegHorasDia, LegHorasSem, LegTrabLun, LegTrabMar, LegTrabMie, LegTrabJue, LegTrabVie, LegTrabSa, LegTrabDo, LegVacPend, LegFecPreAviso, LegConveVersionCli, LegPromDias, LegTitulo, LegEstado, LegMigrWarn, LegIncompleto, LegLiqApo, LegModTra, LegTipoTarifa, LegFotoExt, LegFotoNom, CliCod, LegBanCod, LegLpgCodigo, LegMegCodigo, LegOsoCod, LegSecCodigo, EmpCod, LegSucCodigo, LegPuesCodigo, MprCod, ZonCod, CondiCodigo, SinieCodigo, LegSexo, LegEstadoCivil, LegPaiCod, LegProvCod, LegLocCod, LegNacionCod, LegSinCod, LegActClasNro, LegActCodigo, LegSitRevEgreso, LegPueAfiCod, LegReligion, LegOrigen) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000P72", "SAVEPOINT gxupdate;UPDATE Legajo SET LegConvenio=?, LegIdNomApe=?, LegNomApe=?, LegFecUltMod=?, LegApellido=?, LegNombre=?, LegTipDoc=?, LegNumDoc=?, LegFecNac=?, LegCUIL=?, LegDiscapacidad=?, LegDomici=?, LegEmail=?, LegCodPos=?, LegTelefono=?, LegFecIngreso=?, LegFecEgreso=?, LegCatCodigo=?, LegCatPueCod=?, LegClase=?, LegFormaPago=?, LegBanSuc=?, LegBanTipCuen=?, LegCuentaBanc=?, LegLicInicio=?, LegLicFinal=?, LegCBU=?, LegSCVO=?, LegActivo=?, LegSueldoFuera=?, LegId=?, LegConveCodigo=?, LegObs=?, LegFecImportacion=?, LegAgenReten=?, LegContinua=?, LegRecalcLiq=?, LegJubilado=?, LegHorasDia=?, LegHorasSem=?, LegTrabLun=?, LegTrabMar=?, LegTrabMie=?, LegTrabJue=?, LegTrabVie=?, LegTrabSa=?, LegTrabDo=?, LegVacPend=?, LegFecPreAviso=?, LegConveVersionCli=?, LegPromDias=?, LegTitulo=?, LegEstado=?, LegMigrWarn=?, LegIncompleto=?, LegLiqApo=?, LegModTra=?, LegTipoTarifa=?, LegFotoExt=?, LegFotoNom=?, LegBanCod=?, LegLpgCodigo=?, LegMegCodigo=?, LegOsoCod=?, LegSecCodigo=?, LegSucCodigo=?, LegPuesCodigo=?, MprCod=?, ZonCod=?, CondiCodigo=?, SinieCodigo=?, LegSexo=?, LegEstadoCivil=?, LegPaiCod=?, LegProvCod=?, LegLocCod=?, LegNacionCod=?, LegSinCod=?, LegActClasNro=?, LegActCodigo=?, LegSitRevEgreso=?, LegPueAfiCod=?, LegReligion=?, LegOrigen=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000P73", "SAVEPOINT gxupdate;UPDATE Legajo SET LegFoto=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000P74", "SAVEPOINT gxupdate;DELETE FROM Legajo  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000P75", "SELECT EmpOsoCod, EmpNom, TipEmpleCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P76", "SELECT OsoDescrip, OsoC3992 FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P77", "SELECT PaiNom AS LegNacionalidad FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P78", "SELECT PaiNom AS LegPaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P79", "SELECT ProvNom AS LegProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P80", "SELECT LocNom AS LegLocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P81", "SELECT MegDescrip FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P82", "SELECT SecDescrip FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P83", "SELECT LpgDescri FROM LugardePago WHERE CliCod = ? AND LpgCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P84", "SELECT BanDescrip AS LegBanDes FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P85", "SELECT SinDescrip FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P86", "SELECT OsoDescrip AS LegOsoDes, OsoC3992 AS LegOsoAfipCod, OsoSigla FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P87", "SELECT ActDescrip AS LegActDescri FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P88", "SELECT MprDescripSinAc, MprDescrip FROM ModalidadAFIP WHERE MprCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P89", "SELECT ZonDescripSinAc, ZonDescrip, ZonPorcReduc FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P90", "SELECT CondiDescriSinAc, CondiDescri FROM CondicionAFIP WHERE CondiCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P91", "SELECT SinieDescriSinAc, SinieDescri FROM Siniestrado WHERE SinieCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P92", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio FROM legajo_cuenta_licencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P93", "SELECT CliCod, EmpCod, LegNumero, LegHisFecIng FROM legajo_permanencia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P94", "SELECT CliCod, EmpCod, LegNumero, PreliqTLiqCod, PreliqPeriodo FROM LegPreliqCab WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P95", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P96", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec FROM legajo_sueldos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P97", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LRTipReg FROM F1357LegRemun WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P98", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDGTipReg FROM F1357LegDedGen WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P99", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LTipoReg FROM F1357Leg WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P100", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDPTipReg FROM F1357LDedPer WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P101", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LCTipReg FROM F1357LCalculo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P102", "SELECT CliCod, EmpCod, LegNumero, LegDedSec FROM legajo_deducciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P103", "SELECT CliCod, EmpCod, LegNumero, CenCodigo FROM LegajoCC WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P104", "SELECT CliCod, EmpCod, LegNumero, LegLicenIni FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P105", "SELECT CliCod, EmpCod, LiqNro, LegNumero FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P106", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000P107", "SELECT TM1.SinieCodigo, TM1.LegSexo AS LegSexo, TM1.LegEstadoCivil AS LegEstadoCivil, TM1.LegPaiCod AS LegPaiCod, TM1.LegProvCod AS LegProvCod, TM1.LegLocCod AS LegLocCod, TM1.LegNacionCod AS LegNacionCod, TM1.LegSinCod AS LegSinCod, TM1.LegActClasNro AS LegActClasNro, TM1.LegActCodigo AS LegActCodigo, TM1.LegSitRevEgreso AS LegSitRevEgreso, TM1.LegPueAfiCod AS LegPueAfiCod, T2.TipEmpleCod, TM1.LegReligion, TM1.LegOrigen, T2.EmpOsoCod AS EmpOsoCod, TM1.LegConvenio, T18.SinieDescriSinAc, T17.CondiDescriSinAc, T16.ZonDescripSinAc, T15.MprDescripSinAc, TM1.LegIdNomApe, TM1.LegNomApe, TM1.LegNumero, TM1.LegFecUltMod, T2.EmpNom, TM1.LegApellido, TM1.LegNombre, TM1.LegFoto, TM1.LegTipDoc, TM1.LegNumDoc, TM1.LegFecNac, T4.PaiNom AS LegNacionalidad, TM1.LegCUIL, TM1.LegDiscapacidad, TM1.LegDomici, TM1.LegEmail, TM1.LegCodPos, T5.PaiNom AS LegPaiNom, T6.ProvNom AS LegProvNom, T7.LocNom AS LegLocNom, TM1.LegTelefono, TM1.LegFecIngreso, TM1.LegFecEgreso, T8.MegDescrip, TM1.LegCatCodigo, TM1.LegCatPueCod, T9.SecDescrip, T10.LpgDescri, TM1.LegClase, TM1.LegFormaPago, T11.BanDescrip AS LegBanDes, TM1.LegBanSuc, TM1.LegBanTipCuen, T12.SinDescrip, T13.OsoDescrip AS LegOsoDes, T13.OsoC3992 AS LegOsoAfipCod, T3.OsoDescrip, T14.ActDescrip AS LegActDescri, T15.MprDescrip, TM1.LegCuentaBanc, TM1.LegLicInicio, TM1.LegLicFinal, T16.ZonDescrip, T16.ZonPorcReduc, TM1.LegCBU, TM1.LegSCVO, T17.CondiDescri, T18.SinieDescri, TM1.LegActivo, TM1.LegSueldoFuera, TM1.LegId, TM1.LegConveCodigo, T3.OsoC3992, TM1.LegObs, TM1.LegFecImportacion, TM1.LegAgenReten, TM1.LegContinua, TM1.LegRecalcLiq, TM1.LegJubilado, TM1.LegHorasDia, TM1.LegHorasSem, TM1.LegTrabLun, TM1.LegTrabMar, TM1.LegTrabMie, TM1.LegTrabJue, TM1.LegTrabVie, TM1.LegTrabSa, TM1.LegTrabDo, TM1.LegVacPend, TM1.LegFecPreAviso, TM1.LegConveVersionCli, TM1.LegPromDias, TM1.LegTitulo, TM1.LegEstado, TM1.LegMigrWarn, TM1.LegIncompleto, TM1.LegLiqApo, TM1.LegModTra, TM1.LegTipoTarifa, TM1.LegFotoExt, TM1.LegFotoNom, T13.OsoSigla, TM1.CliCod, TM1.LegBanCod AS LegBanCod, TM1.LegLpgCodigo AS LegLpgCodigo, TM1.LegMegCodigo AS LegMegCodigo, TM1.LegOsoCod AS LegOsoCod, TM1.LegSecCodigo AS LegSecCodigo, TM1.EmpCod, TM1.LegSucCodigo AS LegSucCodigo, TM1.LegPuesCodigo AS LegPuesCodigo, TM1.MprCod, TM1.ZonCod, TM1.CondiCodigo FROM (((((((((((((((((Legajo TM1 INNER JOIN Empresa T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod) LEFT JOIN ObraSocial T3 ON T3.CliCod = TM1.CliCod AND T3.OsoCod = T2.EmpOsoCod) LEFT JOIN Pais T4 ON T4.PaiCod = TM1.LegNacionCod) LEFT JOIN Pais T5 ON T5.PaiCod = TM1.LegPaiCod) LEFT JOIN Provincia T6 ON T6.PaiCod = TM1.LegPaiCod AND T6.ProvCod = TM1.LegProvCod) LEFT JOIN Localidad T7 ON T7.PaiCod = TM1.LegPaiCod AND T7.ProvCod = TM1.LegProvCod AND T7.LocCod = TM1.LegLocCod) LEFT JOIN MotivoEgreso T8 ON T8.CliCod = TM1.CliCod AND T8.MegCodigo = TM1.LegMegCodigo) LEFT JOIN Seccion T9 ON T9.CliCod = TM1.CliCod AND T9.SecCodigo = TM1.LegSecCodigo) LEFT JOIN LugardePago T10 ON T10.CliCod = TM1.CliCod AND T10.LpgCodigo = TM1.LegLpgCodigo) LEFT JOIN Banco T11 ON T11.CliCod = TM1.CliCod AND T11.BanCod = TM1.LegBanCod) LEFT JOIN Sindicato T12 ON T12.PaiCod = TM1.LegPaiCod AND T12.SinCod = TM1.LegSinCod) LEFT JOIN ObraSocial T13 ON T13.CliCod = TM1.CliCod AND T13.OsoCod = TM1.LegOsoCod) LEFT JOIN Actividad T14 ON T14.ActCodigo = TM1.LegActCodigo) LEFT JOIN ModalidadAFIP T15 ON T15.MprCod = TM1.MprCod) LEFT JOIN Zona T16 ON T16.ZonCod = TM1.ZonCod) LEFT JOIN CondicionAFIP T17 ON T17.CondiCodigo = TM1.CondiCodigo) LEFT JOIN Siniestrado T18 ON T18.SinieCodigo = TM1.SinieCodigo) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P108", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelFecha, LegSuelImporte, LegSuelTipo, LegSuelCalc, LegSuelLog FROM legajo_sueldos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegSuelSec = ? ORDER BY CliCod, EmpCod, LegNumero, LegSuelSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P109", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec FROM legajo_sueldos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P110", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelFecha, LegSuelImporte, LegSuelTipo, LegSuelCalc, LegSuelLog FROM legajo_sueldos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P111", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelFecha, LegSuelImporte, LegSuelTipo, LegSuelCalc, LegSuelLog FROM legajo_sueldos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ?  FOR UPDATE OF legajo_sueldos",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000P112", "SAVEPOINT gxupdate;INSERT INTO legajo_sueldos(CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelFecha, LegSuelImporte, LegSuelTipo, LegSuelCalc, LegSuelLog, LegSuelBasica, LegSuelCalCom, LegSuelVto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE, FALSE, DATE '00010101');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000P113", "SAVEPOINT gxupdate;UPDATE legajo_sueldos SET LegSuelFecha=?, LegSuelImporte=?, LegSuelTipo=?, LegSuelCalc=?, LegSuelLog=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000P114", "SAVEPOINT gxupdate;DELETE FROM legajo_sueldos  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000P115", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelFecha, LegSuelImporte, LegSuelTipo, LegSuelCalc, LegSuelLog FROM legajo_sueldos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero, LegSuelSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P116", "SELECT CliCod, LegSuelConcepto, EmpCod, LegNumero, LegSuelSec FROM Legajo_sueldosConceptos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegSuelSec = ? and LegSuelConcepto = ( ?) ORDER BY CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelConcepto ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P117", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P118", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelConcepto FROM Legajo_sueldosConceptos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ? AND LegSuelConcepto = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P119", "SELECT CliCod, LegSuelConcepto, EmpCod, LegNumero, LegSuelSec FROM Legajo_sueldosConceptos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ? AND LegSuelConcepto = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P120", "SELECT CliCod, LegSuelConcepto, EmpCod, LegNumero, LegSuelSec FROM Legajo_sueldosConceptos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ? AND LegSuelConcepto = ?  FOR UPDATE OF Legajo_sueldosConceptos",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000P121", "SAVEPOINT gxupdate;INSERT INTO Legajo_sueldosConceptos(CliCod, LegSuelConcepto, EmpCod, LegNumero, LegSuelSec, LegSuelConSec, LegSuelConCnt, LegSuelConValU, LegSuelConImp, LegSuelConFor, LegSuelConOrdE, LegSuelLiqDLog) VALUES(?, ?, ?, ?, ?, 0, 0, 0, 0, '', 0, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000P122", "SAVEPOINT gxupdate;DELETE FROM Legajo_sueldosConceptos  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ? AND LegSuelConcepto = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000P123", "SELECT CliCod, LegSuelConcepto, EmpCod, LegNumero, LegSuelSec FROM Legajo_sueldosConceptos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegSuelSec = ? ORDER BY CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelConcepto ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P124", "SELECT LegNumero, LegOrden, FamTomaDeducImpGan, FamNomApe, FamFecNac, FamDiscap, FamNroDoc, FamAdherente, CliCod, ParCod, EmpCod, GuarCod FROM LegajoFamilia WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegOrden = ? ORDER BY CliCod, EmpCod, LegNumero, LegOrden ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P125", "SELECT CliCod FROM Parentesco WHERE CliCod = ? AND ParCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P126", "SELECT CliCod FROM EmpresaGuarderias WHERE CliCod = ? AND EmpCod = ? AND GuarCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P127", "SELECT CliCod, EmpCod, LegNumero, LegOrden FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P128", "SELECT LegNumero, LegOrden, FamTomaDeducImpGan, FamNomApe, FamFecNac, FamDiscap, FamNroDoc, FamAdherente, CliCod, ParCod, EmpCod, GuarCod FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P129", "SELECT LegNumero, LegOrden, FamTomaDeducImpGan, FamNomApe, FamFecNac, FamDiscap, FamNroDoc, FamAdherente, CliCod, ParCod, EmpCod, GuarCod FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ?  FOR UPDATE OF LegajoFamilia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000P130", "SAVEPOINT gxupdate;INSERT INTO LegajoFamilia(LegNumero, LegOrden, FamTomaDeducImpGan, FamNomApe, FamFecNac, FamDiscap, FamNroDoc, FamAdherente, CliCod, ParCod, EmpCod, GuarCod, FamApellido, FamNombres, FamAsigFam, FamMesDesde, FamMesHasta) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', '', FALSE, 0, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000P131", "SAVEPOINT gxupdate;UPDATE LegajoFamilia SET FamTomaDeducImpGan=?, FamNomApe=?, FamFecNac=?, FamDiscap=?, FamNroDoc=?, FamAdherente=?, ParCod=?, GuarCod=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000P132", "SAVEPOINT gxupdate;DELETE FROM LegajoFamilia  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000P133", "SELECT LegNumero, LegOrden, FamTomaDeducImpGan, FamNomApe, FamFecNac, FamDiscap, FamNroDoc, FamAdherente, CliCod, ParCod, EmpCod, GuarCod FROM LegajoFamilia WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero, LegOrden ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P134", "SELECT CliCod, EmpCod, LegNumero, LegTipoTra FROM Legajotipos_de_trabajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegTipoTra = ( ?) ORDER BY CliCod, EmpCod, LegNumero, LegTipoTra ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P135", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P136", "SELECT CliCod, EmpCod, LegNumero, LegTipoTra FROM Legajotipos_de_trabajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegTipoTra = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P137", "SELECT CliCod, EmpCod, LegNumero, LegTipoTra FROM Legajotipos_de_trabajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegTipoTra = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P138", "SELECT CliCod, EmpCod, LegNumero, LegTipoTra FROM Legajotipos_de_trabajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegTipoTra = ?  FOR UPDATE OF Legajotipos_de_trabajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000P139", "SAVEPOINT gxupdate;INSERT INTO Legajotipos_de_trabajo(CliCod, EmpCod, LegNumero, LegTipoTra) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000P140", "SAVEPOINT gxupdate;DELETE FROM Legajotipos_de_trabajo  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegTipoTra = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000P141", "SELECT CliCod, EmpCod, LegNumero, LegTipoTra FROM Legajotipos_de_trabajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero, LegTipoTra ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P142", "SELECT T1.CliCod, T1.EmpCod, T1.LegNumero, T2.propDesc AS LegPropDes, T2.propTipoDato AS LegPropTD, T1.LegPropValNum, T1.LegPropValBool, T1.LegPropValStr, T1.LegPropValDate, T1.LegPropCod AS LegPropCod FROM (LegajoPropiedades T1 INNER JOIN propiedades_adicionales T2 ON T2.propCod = T1.LegPropCod) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.LegPropCod = ( ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegPropCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P143", "SELECT propDesc AS LegPropDes, propTipoDato AS LegPropTD FROM propiedades_adicionales WHERE propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P144", "SELECT CliCod, EmpCod, LegNumero, LegPropCod FROM LegajoPropiedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegPropCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P145", "SELECT CliCod, EmpCod, LegNumero, LegPropValNum, LegPropValBool, LegPropValStr, LegPropValDate, LegPropCod FROM LegajoPropiedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegPropCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P146", "SELECT CliCod, EmpCod, LegNumero, LegPropValNum, LegPropValBool, LegPropValStr, LegPropValDate, LegPropCod FROM LegajoPropiedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegPropCod = ?  FOR UPDATE OF LegajoPropiedades",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000P147", "SAVEPOINT gxupdate;INSERT INTO LegajoPropiedades(CliCod, EmpCod, LegNumero, LegPropValNum, LegPropValBool, LegPropValStr, LegPropValDate, LegPropCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000P148", "SAVEPOINT gxupdate;UPDATE LegajoPropiedades SET LegPropValNum=?, LegPropValBool=?, LegPropValStr=?, LegPropValDate=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegPropCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000P149", "SAVEPOINT gxupdate;DELETE FROM LegajoPropiedades  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegPropCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000P150", "SELECT propDesc AS LegPropDes, propTipoDato AS LegPropTD FROM propiedades_adicionales WHERE propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P151", "SELECT T1.CliCod, T1.EmpCod, T1.LegNumero, T2.propDesc AS LegPropDes, T2.propTipoDato AS LegPropTD, T1.LegPropValNum, T1.LegPropValBool, T1.LegPropValStr, T1.LegPropValDate, T1.LegPropCod AS LegPropCod FROM (LegajoPropiedades T1 INNER JOIN propiedades_adicionales T2 ON T2.propCod = T1.LegPropCod) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegPropCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P152", "SELECT TipEmpleCod, EmpOsoCod, EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P153", "SELECT OsoDescrip, OsoC3992 FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P154", "SELECT TipEmpleCod, EmpOsoCod, EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000P155", "SELECT OsoDescrip, OsoC3992 FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 20);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 20);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(4);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(5);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((short[]) buf[10])[0] = rslt.getShort(6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((short[]) buf[12])[0] = rslt.getShort(7);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(9);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(10, 8);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((short[]) buf[20])[0] = rslt.getShort(11);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(12, 4);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((boolean[]) buf[28])[0] = rslt.getBoolean(15);
               ((String[]) buf[29])[0] = rslt.getVarchar(16);
               ((String[]) buf[30])[0] = rslt.getVarchar(17);
               ((int[]) buf[31])[0] = rslt.getInt(18);
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDate(19);
               ((String[]) buf[33])[0] = rslt.getVarchar(20);
               ((String[]) buf[34])[0] = rslt.getVarchar(21);
               ((String[]) buf[35])[0] = rslt.getBLOBFile(22, rslt.getString(75, 20), rslt.getVarchar(76));
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((byte[]) buf[37])[0] = rslt.getByte(23);
               ((String[]) buf[38])[0] = rslt.getVarchar(24);
               ((java.util.Date[]) buf[39])[0] = rslt.getGXDate(25);
               ((long[]) buf[40])[0] = rslt.getLong(26);
               ((byte[]) buf[41])[0] = rslt.getByte(27);
               ((String[]) buf[42])[0] = rslt.getVarchar(28);
               ((String[]) buf[43])[0] = rslt.getVarchar(29);
               ((String[]) buf[44])[0] = rslt.getString(30, 20);
               ((String[]) buf[45])[0] = rslt.getVarchar(31);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[47])[0] = rslt.getGXDate(32);
               ((java.util.Date[]) buf[48])[0] = rslt.getGXDate(33);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((String[]) buf[50])[0] = rslt.getString(34, 40);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((int[]) buf[52])[0] = rslt.getInt(35);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((byte[]) buf[54])[0] = rslt.getByte(36);
               ((byte[]) buf[55])[0] = rslt.getByte(37);
               ((String[]) buf[56])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((String[]) buf[58])[0] = rslt.getString(39, 20);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((String[]) buf[60])[0] = rslt.getVarchar(40);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[62])[0] = rslt.getGXDate(41);
               ((boolean[]) buf[63])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[64])[0] = rslt.getGXDate(42);
               ((boolean[]) buf[65])[0] = rslt.wasNull();
               ((String[]) buf[66])[0] = rslt.getVarchar(43);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((boolean[]) buf[68])[0] = rslt.getBoolean(44);
               ((boolean[]) buf[69])[0] = rslt.getBoolean(45);
               ((java.math.BigDecimal[]) buf[70])[0] = rslt.getBigDecimal(46,2);
               ((String[]) buf[71])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[72])[0] = rslt.wasNull();
               ((String[]) buf[73])[0] = rslt.getString(48, 20);
               ((boolean[]) buf[74])[0] = rslt.wasNull();
               ((String[]) buf[75])[0] = rslt.getLongVarchar(49);
               ((java.util.Date[]) buf[76])[0] = rslt.getGXDateTime(50);
               ((boolean[]) buf[77])[0] = rslt.getBoolean(51);
               ((String[]) buf[78])[0] = rslt.getString(52, 2);
               ((boolean[]) buf[79])[0] = rslt.getBoolean(53);
               ((boolean[]) buf[80])[0] = rslt.getBoolean(54);
               ((java.math.BigDecimal[]) buf[81])[0] = rslt.getBigDecimal(55,1);
               ((java.math.BigDecimal[]) buf[82])[0] = rslt.getBigDecimal(56,1);
               ((boolean[]) buf[83])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[84])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[85])[0] = rslt.getBoolean(59);
               ((boolean[]) buf[86])[0] = rslt.getBoolean(60);
               ((boolean[]) buf[87])[0] = rslt.getBoolean(61);
               ((boolean[]) buf[88])[0] = rslt.getBoolean(62);
               ((boolean[]) buf[89])[0] = rslt.getBoolean(63);
               ((short[]) buf[90])[0] = rslt.getShort(64);
               ((java.util.Date[]) buf[91])[0] = rslt.getGXDate(65);
               ((int[]) buf[92])[0] = rslt.getInt(66);
               ((boolean[]) buf[93])[0] = rslt.wasNull();
               ((String[]) buf[94])[0] = rslt.getVarchar(67);
               ((String[]) buf[95])[0] = rslt.getString(68, 20);
               ((byte[]) buf[96])[0] = rslt.getByte(69);
               ((String[]) buf[97])[0] = rslt.getLongVarchar(70);
               ((boolean[]) buf[98])[0] = rslt.wasNull();
               ((boolean[]) buf[99])[0] = rslt.getBoolean(71);
               ((boolean[]) buf[100])[0] = rslt.getBoolean(72);
               ((String[]) buf[101])[0] = rslt.getString(73, 1);
               ((String[]) buf[102])[0] = rslt.getString(74, 1);
               ((String[]) buf[103])[0] = rslt.getString(75, 20);
               ((String[]) buf[104])[0] = rslt.getVarchar(76);
               ((int[]) buf[105])[0] = rslt.getInt(77);
               ((String[]) buf[106])[0] = rslt.getString(78, 6);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(79, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getString(80, 20);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((String[]) buf[112])[0] = rslt.getString(81, 20);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(82, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((short[]) buf[116])[0] = rslt.getShort(83);
               ((String[]) buf[117])[0] = rslt.getString(84, 20);
               ((boolean[]) buf[118])[0] = rslt.wasNull();
               ((String[]) buf[119])[0] = rslt.getString(85, 20);
               ((boolean[]) buf[120])[0] = rslt.wasNull();
               ((String[]) buf[121])[0] = rslt.getString(86, 20);
               ((boolean[]) buf[122])[0] = rslt.wasNull();
               ((String[]) buf[123])[0] = rslt.getString(87, 20);
               ((boolean[]) buf[124])[0] = rslt.wasNull();
               ((short[]) buf[125])[0] = rslt.getShort(88);
               ((boolean[]) buf[126])[0] = rslt.wasNull();
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(4);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(5);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((short[]) buf[10])[0] = rslt.getShort(6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((short[]) buf[12])[0] = rslt.getShort(7);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(9);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(10, 8);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((short[]) buf[20])[0] = rslt.getShort(11);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(12, 4);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((boolean[]) buf[28])[0] = rslt.getBoolean(15);
               ((String[]) buf[29])[0] = rslt.getVarchar(16);
               ((String[]) buf[30])[0] = rslt.getVarchar(17);
               ((int[]) buf[31])[0] = rslt.getInt(18);
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDate(19);
               ((String[]) buf[33])[0] = rslt.getVarchar(20);
               ((String[]) buf[34])[0] = rslt.getVarchar(21);
               ((String[]) buf[35])[0] = rslt.getBLOBFile(22, rslt.getString(75, 20), rslt.getVarchar(76));
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((byte[]) buf[37])[0] = rslt.getByte(23);
               ((String[]) buf[38])[0] = rslt.getVarchar(24);
               ((java.util.Date[]) buf[39])[0] = rslt.getGXDate(25);
               ((long[]) buf[40])[0] = rslt.getLong(26);
               ((byte[]) buf[41])[0] = rslt.getByte(27);
               ((String[]) buf[42])[0] = rslt.getVarchar(28);
               ((String[]) buf[43])[0] = rslt.getVarchar(29);
               ((String[]) buf[44])[0] = rslt.getString(30, 20);
               ((String[]) buf[45])[0] = rslt.getVarchar(31);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[47])[0] = rslt.getGXDate(32);
               ((java.util.Date[]) buf[48])[0] = rslt.getGXDate(33);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((String[]) buf[50])[0] = rslt.getString(34, 40);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((int[]) buf[52])[0] = rslt.getInt(35);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((byte[]) buf[54])[0] = rslt.getByte(36);
               ((byte[]) buf[55])[0] = rslt.getByte(37);
               ((String[]) buf[56])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((String[]) buf[58])[0] = rslt.getString(39, 20);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((String[]) buf[60])[0] = rslt.getVarchar(40);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[62])[0] = rslt.getGXDate(41);
               ((boolean[]) buf[63])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[64])[0] = rslt.getGXDate(42);
               ((boolean[]) buf[65])[0] = rslt.wasNull();
               ((String[]) buf[66])[0] = rslt.getVarchar(43);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((boolean[]) buf[68])[0] = rslt.getBoolean(44);
               ((boolean[]) buf[69])[0] = rslt.getBoolean(45);
               ((java.math.BigDecimal[]) buf[70])[0] = rslt.getBigDecimal(46,2);
               ((String[]) buf[71])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[72])[0] = rslt.wasNull();
               ((String[]) buf[73])[0] = rslt.getString(48, 20);
               ((boolean[]) buf[74])[0] = rslt.wasNull();
               ((String[]) buf[75])[0] = rslt.getLongVarchar(49);
               ((java.util.Date[]) buf[76])[0] = rslt.getGXDateTime(50);
               ((boolean[]) buf[77])[0] = rslt.getBoolean(51);
               ((String[]) buf[78])[0] = rslt.getString(52, 2);
               ((boolean[]) buf[79])[0] = rslt.getBoolean(53);
               ((boolean[]) buf[80])[0] = rslt.getBoolean(54);
               ((java.math.BigDecimal[]) buf[81])[0] = rslt.getBigDecimal(55,1);
               ((java.math.BigDecimal[]) buf[82])[0] = rslt.getBigDecimal(56,1);
               ((boolean[]) buf[83])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[84])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[85])[0] = rslt.getBoolean(59);
               ((boolean[]) buf[86])[0] = rslt.getBoolean(60);
               ((boolean[]) buf[87])[0] = rslt.getBoolean(61);
               ((boolean[]) buf[88])[0] = rslt.getBoolean(62);
               ((boolean[]) buf[89])[0] = rslt.getBoolean(63);
               ((short[]) buf[90])[0] = rslt.getShort(64);
               ((java.util.Date[]) buf[91])[0] = rslt.getGXDate(65);
               ((int[]) buf[92])[0] = rslt.getInt(66);
               ((boolean[]) buf[93])[0] = rslt.wasNull();
               ((String[]) buf[94])[0] = rslt.getVarchar(67);
               ((String[]) buf[95])[0] = rslt.getString(68, 20);
               ((byte[]) buf[96])[0] = rslt.getByte(69);
               ((String[]) buf[97])[0] = rslt.getLongVarchar(70);
               ((boolean[]) buf[98])[0] = rslt.wasNull();
               ((boolean[]) buf[99])[0] = rslt.getBoolean(71);
               ((boolean[]) buf[100])[0] = rslt.getBoolean(72);
               ((String[]) buf[101])[0] = rslt.getString(73, 1);
               ((String[]) buf[102])[0] = rslt.getString(74, 1);
               ((String[]) buf[103])[0] = rslt.getString(75, 20);
               ((String[]) buf[104])[0] = rslt.getVarchar(76);
               ((int[]) buf[105])[0] = rslt.getInt(77);
               ((String[]) buf[106])[0] = rslt.getString(78, 6);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(79, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getString(80, 20);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((String[]) buf[112])[0] = rslt.getString(81, 20);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(82, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((short[]) buf[116])[0] = rslt.getShort(83);
               ((String[]) buf[117])[0] = rslt.getString(84, 20);
               ((boolean[]) buf[118])[0] = rslt.wasNull();
               ((String[]) buf[119])[0] = rslt.getString(85, 20);
               ((boolean[]) buf[120])[0] = rslt.wasNull();
               ((String[]) buf[121])[0] = rslt.getString(86, 20);
               ((boolean[]) buf[122])[0] = rslt.wasNull();
               ((String[]) buf[123])[0] = rslt.getString(87, 20);
               ((boolean[]) buf[124])[0] = rslt.wasNull();
               ((short[]) buf[125])[0] = rslt.getShort(88);
               ((boolean[]) buf[126])[0] = rslt.wasNull();
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 22 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 26 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 28 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 29 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 31 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 32 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 33 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 34 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 35 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 36 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 37 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 38 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 39 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 40 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 41 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(4);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(5);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((short[]) buf[10])[0] = rslt.getShort(6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((short[]) buf[12])[0] = rslt.getShort(7);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(9);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(10, 8);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((short[]) buf[20])[0] = rslt.getShort(11);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(12, 4);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(13, 4);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((boolean[]) buf[32])[0] = rslt.getBoolean(17);
               ((String[]) buf[33])[0] = rslt.getVarchar(18);
               ((String[]) buf[34])[0] = rslt.getVarchar(19);
               ((String[]) buf[35])[0] = rslt.getVarchar(20);
               ((String[]) buf[36])[0] = rslt.getVarchar(21);
               ((String[]) buf[37])[0] = rslt.getVarchar(22);
               ((String[]) buf[38])[0] = rslt.getVarchar(23);
               ((int[]) buf[39])[0] = rslt.getInt(24);
               ((java.util.Date[]) buf[40])[0] = rslt.getGXDate(25);
               ((String[]) buf[41])[0] = rslt.getVarchar(26);
               ((String[]) buf[42])[0] = rslt.getVarchar(27);
               ((String[]) buf[43])[0] = rslt.getVarchar(28);
               ((String[]) buf[44])[0] = rslt.getBLOBFile(29, rslt.getString(101, 20), rslt.getVarchar(102));
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((byte[]) buf[46])[0] = rslt.getByte(30);
               ((String[]) buf[47])[0] = rslt.getVarchar(31);
               ((java.util.Date[]) buf[48])[0] = rslt.getGXDate(32);
               ((String[]) buf[49])[0] = rslt.getVarchar(33);
               ((long[]) buf[50])[0] = rslt.getLong(34);
               ((byte[]) buf[51])[0] = rslt.getByte(35);
               ((String[]) buf[52])[0] = rslt.getVarchar(36);
               ((String[]) buf[53])[0] = rslt.getVarchar(37);
               ((String[]) buf[54])[0] = rslt.getString(38, 20);
               ((String[]) buf[55])[0] = rslt.getVarchar(39);
               ((String[]) buf[56])[0] = rslt.getVarchar(40);
               ((String[]) buf[57])[0] = rslt.getVarchar(41);
               ((String[]) buf[58])[0] = rslt.getVarchar(42);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[60])[0] = rslt.getGXDate(43);
               ((java.util.Date[]) buf[61])[0] = rslt.getGXDate(44);
               ((boolean[]) buf[62])[0] = rslt.wasNull();
               ((String[]) buf[63])[0] = rslt.getVarchar(45);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((String[]) buf[65])[0] = rslt.getString(46, 40);
               ((boolean[]) buf[66])[0] = rslt.wasNull();
               ((int[]) buf[67])[0] = rslt.getInt(47);
               ((boolean[]) buf[68])[0] = rslt.wasNull();
               ((String[]) buf[69])[0] = rslt.getVarchar(48);
               ((boolean[]) buf[70])[0] = rslt.wasNull();
               ((String[]) buf[71])[0] = rslt.getVarchar(49);
               ((boolean[]) buf[72])[0] = rslt.wasNull();
               ((byte[]) buf[73])[0] = rslt.getByte(50);
               ((byte[]) buf[74])[0] = rslt.getByte(51);
               ((String[]) buf[75])[0] = rslt.getVarchar(52);
               ((String[]) buf[76])[0] = rslt.getVarchar(53);
               ((boolean[]) buf[77])[0] = rslt.wasNull();
               ((String[]) buf[78])[0] = rslt.getString(54, 20);
               ((boolean[]) buf[79])[0] = rslt.wasNull();
               ((String[]) buf[80])[0] = rslt.getVarchar(55);
               ((boolean[]) buf[81])[0] = rslt.wasNull();
               ((String[]) buf[82])[0] = rslt.getVarchar(56);
               ((String[]) buf[83])[0] = rslt.getString(57, 20);
               ((boolean[]) buf[84])[0] = rslt.wasNull();
               ((String[]) buf[85])[0] = rslt.getVarchar(58);
               ((boolean[]) buf[86])[0] = rslt.wasNull();
               ((String[]) buf[87])[0] = rslt.getVarchar(59);
               ((String[]) buf[88])[0] = rslt.getVarchar(60);
               ((String[]) buf[89])[0] = rslt.getVarchar(61);
               ((boolean[]) buf[90])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[91])[0] = rslt.getGXDate(62);
               ((boolean[]) buf[92])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[93])[0] = rslt.getGXDate(63);
               ((boolean[]) buf[94])[0] = rslt.wasNull();
               ((String[]) buf[95])[0] = rslt.getVarchar(64);
               ((java.math.BigDecimal[]) buf[96])[0] = rslt.getBigDecimal(65,2);
               ((String[]) buf[97])[0] = rslt.getVarchar(66);
               ((boolean[]) buf[98])[0] = rslt.wasNull();
               ((boolean[]) buf[99])[0] = rslt.getBoolean(67);
               ((String[]) buf[100])[0] = rslt.getVarchar(68);
               ((String[]) buf[101])[0] = rslt.getVarchar(69);
               ((boolean[]) buf[102])[0] = rslt.getBoolean(70);
               ((java.math.BigDecimal[]) buf[103])[0] = rslt.getBigDecimal(71,2);
               ((String[]) buf[104])[0] = rslt.getString(72, 20);
               ((boolean[]) buf[105])[0] = rslt.wasNull();
               ((String[]) buf[106])[0] = rslt.getString(73, 20);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(74, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getLongVarchar(75);
               ((java.util.Date[]) buf[111])[0] = rslt.getGXDateTime(76);
               ((boolean[]) buf[112])[0] = rslt.getBoolean(77);
               ((String[]) buf[113])[0] = rslt.getString(78, 2);
               ((boolean[]) buf[114])[0] = rslt.getBoolean(79);
               ((boolean[]) buf[115])[0] = rslt.getBoolean(80);
               ((java.math.BigDecimal[]) buf[116])[0] = rslt.getBigDecimal(81,1);
               ((java.math.BigDecimal[]) buf[117])[0] = rslt.getBigDecimal(82,1);
               ((boolean[]) buf[118])[0] = rslt.getBoolean(83);
               ((boolean[]) buf[119])[0] = rslt.getBoolean(84);
               ((boolean[]) buf[120])[0] = rslt.getBoolean(85);
               ((boolean[]) buf[121])[0] = rslt.getBoolean(86);
               ((boolean[]) buf[122])[0] = rslt.getBoolean(87);
               ((boolean[]) buf[123])[0] = rslt.getBoolean(88);
               ((boolean[]) buf[124])[0] = rslt.getBoolean(89);
               ((short[]) buf[125])[0] = rslt.getShort(90);
               ((java.util.Date[]) buf[126])[0] = rslt.getGXDate(91);
               ((int[]) buf[127])[0] = rslt.getInt(92);
               ((boolean[]) buf[128])[0] = rslt.wasNull();
               ((String[]) buf[129])[0] = rslt.getVarchar(93);
               ((String[]) buf[130])[0] = rslt.getString(94, 20);
               ((byte[]) buf[131])[0] = rslt.getByte(95);
               ((String[]) buf[132])[0] = rslt.getLongVarchar(96);
               ((boolean[]) buf[133])[0] = rslt.wasNull();
               ((boolean[]) buf[134])[0] = rslt.getBoolean(97);
               ((boolean[]) buf[135])[0] = rslt.getBoolean(98);
               ((String[]) buf[136])[0] = rslt.getString(99, 1);
               ((String[]) buf[137])[0] = rslt.getString(100, 1);
               ((String[]) buf[138])[0] = rslt.getString(101, 20);
               ((String[]) buf[139])[0] = rslt.getVarchar(102);
               ((String[]) buf[140])[0] = rslt.getString(103, 20);
               ((boolean[]) buf[141])[0] = rslt.wasNull();
               ((int[]) buf[142])[0] = rslt.getInt(104);
               ((String[]) buf[143])[0] = rslt.getString(105, 6);
               ((boolean[]) buf[144])[0] = rslt.wasNull();
               ((String[]) buf[145])[0] = rslt.getString(106, 20);
               ((boolean[]) buf[146])[0] = rslt.wasNull();
               ((String[]) buf[147])[0] = rslt.getString(107, 20);
               ((boolean[]) buf[148])[0] = rslt.wasNull();
               ((String[]) buf[149])[0] = rslt.getString(108, 20);
               ((boolean[]) buf[150])[0] = rslt.wasNull();
               ((String[]) buf[151])[0] = rslt.getString(109, 20);
               ((boolean[]) buf[152])[0] = rslt.wasNull();
               ((short[]) buf[153])[0] = rslt.getShort(110);
               ((String[]) buf[154])[0] = rslt.getString(111, 20);
               ((boolean[]) buf[155])[0] = rslt.wasNull();
               ((String[]) buf[156])[0] = rslt.getString(112, 20);
               ((boolean[]) buf[157])[0] = rslt.wasNull();
               ((String[]) buf[158])[0] = rslt.getString(113, 20);
               ((boolean[]) buf[159])[0] = rslt.wasNull();
               ((String[]) buf[160])[0] = rslt.getString(114, 20);
               ((boolean[]) buf[161])[0] = rslt.wasNull();
               ((short[]) buf[162])[0] = rslt.getShort(115);
               ((boolean[]) buf[163])[0] = rslt.wasNull();
               return;
            case 42 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 43 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 44 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 45 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 46 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 47 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 48 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               return;
            case 49 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 50 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 51 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 52 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 53 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 54 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 55 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 56 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 57 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 58 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 59 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
      }
      getresults60( cursor, rslt, buf) ;
   }

   public void getresults60( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 61 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 62 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 63 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 64 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 65 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 66 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 67 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(4);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(5);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((short[]) buf[10])[0] = rslt.getShort(6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((short[]) buf[12])[0] = rslt.getShort(7);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(9);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(10, 8);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((short[]) buf[20])[0] = rslt.getShort(11);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(12, 4);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((boolean[]) buf[28])[0] = rslt.getBoolean(15);
               ((String[]) buf[29])[0] = rslt.getVarchar(16);
               ((String[]) buf[30])[0] = rslt.getVarchar(17);
               ((int[]) buf[31])[0] = rslt.getInt(18);
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDate(19);
               ((String[]) buf[33])[0] = rslt.getVarchar(20);
               ((String[]) buf[34])[0] = rslt.getVarchar(21);
               ((String[]) buf[35])[0] = rslt.getBLOBFile(22, rslt.getString(75, 20), rslt.getVarchar(76));
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((byte[]) buf[37])[0] = rslt.getByte(23);
               ((String[]) buf[38])[0] = rslt.getVarchar(24);
               ((java.util.Date[]) buf[39])[0] = rslt.getGXDate(25);
               ((long[]) buf[40])[0] = rslt.getLong(26);
               ((byte[]) buf[41])[0] = rslt.getByte(27);
               ((String[]) buf[42])[0] = rslt.getVarchar(28);
               ((String[]) buf[43])[0] = rslt.getVarchar(29);
               ((String[]) buf[44])[0] = rslt.getString(30, 20);
               ((String[]) buf[45])[0] = rslt.getVarchar(31);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[47])[0] = rslt.getGXDate(32);
               ((java.util.Date[]) buf[48])[0] = rslt.getGXDate(33);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((String[]) buf[50])[0] = rslt.getString(34, 40);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((int[]) buf[52])[0] = rslt.getInt(35);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((byte[]) buf[54])[0] = rslt.getByte(36);
               ((byte[]) buf[55])[0] = rslt.getByte(37);
               ((String[]) buf[56])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((String[]) buf[58])[0] = rslt.getString(39, 20);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((String[]) buf[60])[0] = rslt.getVarchar(40);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[62])[0] = rslt.getGXDate(41);
               ((boolean[]) buf[63])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[64])[0] = rslt.getGXDate(42);
               ((boolean[]) buf[65])[0] = rslt.wasNull();
               ((String[]) buf[66])[0] = rslt.getVarchar(43);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((boolean[]) buf[68])[0] = rslt.getBoolean(44);
               ((boolean[]) buf[69])[0] = rslt.getBoolean(45);
               ((java.math.BigDecimal[]) buf[70])[0] = rslt.getBigDecimal(46,2);
               ((String[]) buf[71])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[72])[0] = rslt.wasNull();
               ((String[]) buf[73])[0] = rslt.getString(48, 20);
               ((boolean[]) buf[74])[0] = rslt.wasNull();
               ((String[]) buf[75])[0] = rslt.getLongVarchar(49);
               ((java.util.Date[]) buf[76])[0] = rslt.getGXDateTime(50);
               ((boolean[]) buf[77])[0] = rslt.getBoolean(51);
               ((String[]) buf[78])[0] = rslt.getString(52, 2);
               ((boolean[]) buf[79])[0] = rslt.getBoolean(53);
               ((boolean[]) buf[80])[0] = rslt.getBoolean(54);
               ((java.math.BigDecimal[]) buf[81])[0] = rslt.getBigDecimal(55,1);
               ((java.math.BigDecimal[]) buf[82])[0] = rslt.getBigDecimal(56,1);
               ((boolean[]) buf[83])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[84])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[85])[0] = rslt.getBoolean(59);
               ((boolean[]) buf[86])[0] = rslt.getBoolean(60);
               ((boolean[]) buf[87])[0] = rslt.getBoolean(61);
               ((boolean[]) buf[88])[0] = rslt.getBoolean(62);
               ((boolean[]) buf[89])[0] = rslt.getBoolean(63);
               ((short[]) buf[90])[0] = rslt.getShort(64);
               ((java.util.Date[]) buf[91])[0] = rslt.getGXDate(65);
               ((int[]) buf[92])[0] = rslt.getInt(66);
               ((boolean[]) buf[93])[0] = rslt.wasNull();
               ((String[]) buf[94])[0] = rslt.getVarchar(67);
               ((String[]) buf[95])[0] = rslt.getString(68, 20);
               ((byte[]) buf[96])[0] = rslt.getByte(69);
               ((String[]) buf[97])[0] = rslt.getLongVarchar(70);
               ((boolean[]) buf[98])[0] = rslt.wasNull();
               ((boolean[]) buf[99])[0] = rslt.getBoolean(71);
               ((boolean[]) buf[100])[0] = rslt.getBoolean(72);
               ((String[]) buf[101])[0] = rslt.getString(73, 1);
               ((String[]) buf[102])[0] = rslt.getString(74, 1);
               ((String[]) buf[103])[0] = rslt.getString(75, 20);
               ((String[]) buf[104])[0] = rslt.getVarchar(76);
               ((int[]) buf[105])[0] = rslt.getInt(77);
               ((String[]) buf[106])[0] = rslt.getString(78, 6);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(79, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getString(80, 20);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((String[]) buf[112])[0] = rslt.getString(81, 20);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(82, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((short[]) buf[116])[0] = rslt.getShort(83);
               ((String[]) buf[117])[0] = rslt.getString(84, 20);
               ((boolean[]) buf[118])[0] = rslt.wasNull();
               ((String[]) buf[119])[0] = rslt.getString(85, 20);
               ((boolean[]) buf[120])[0] = rslt.wasNull();
               ((String[]) buf[121])[0] = rslt.getString(86, 20);
               ((boolean[]) buf[122])[0] = rslt.wasNull();
               ((String[]) buf[123])[0] = rslt.getString(87, 20);
               ((boolean[]) buf[124])[0] = rslt.wasNull();
               ((short[]) buf[125])[0] = rslt.getShort(88);
               ((boolean[]) buf[126])[0] = rslt.wasNull();
               return;
            case 68 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(4);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(5);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((short[]) buf[10])[0] = rslt.getShort(6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((short[]) buf[12])[0] = rslt.getShort(7);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(9);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(10, 8);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((short[]) buf[20])[0] = rslt.getShort(11);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(12, 4);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((boolean[]) buf[28])[0] = rslt.getBoolean(15);
               ((String[]) buf[29])[0] = rslt.getVarchar(16);
               ((String[]) buf[30])[0] = rslt.getVarchar(17);
               ((int[]) buf[31])[0] = rslt.getInt(18);
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDate(19);
               ((String[]) buf[33])[0] = rslt.getVarchar(20);
               ((String[]) buf[34])[0] = rslt.getVarchar(21);
               ((String[]) buf[35])[0] = rslt.getBLOBFile(22, rslt.getString(75, 20), rslt.getVarchar(76));
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((byte[]) buf[37])[0] = rslt.getByte(23);
               ((String[]) buf[38])[0] = rslt.getVarchar(24);
               ((java.util.Date[]) buf[39])[0] = rslt.getGXDate(25);
               ((long[]) buf[40])[0] = rslt.getLong(26);
               ((byte[]) buf[41])[0] = rslt.getByte(27);
               ((String[]) buf[42])[0] = rslt.getVarchar(28);
               ((String[]) buf[43])[0] = rslt.getVarchar(29);
               ((String[]) buf[44])[0] = rslt.getString(30, 20);
               ((String[]) buf[45])[0] = rslt.getVarchar(31);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[47])[0] = rslt.getGXDate(32);
               ((java.util.Date[]) buf[48])[0] = rslt.getGXDate(33);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((String[]) buf[50])[0] = rslt.getString(34, 40);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((int[]) buf[52])[0] = rslt.getInt(35);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((byte[]) buf[54])[0] = rslt.getByte(36);
               ((byte[]) buf[55])[0] = rslt.getByte(37);
               ((String[]) buf[56])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((String[]) buf[58])[0] = rslt.getString(39, 20);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((String[]) buf[60])[0] = rslt.getVarchar(40);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[62])[0] = rslt.getGXDate(41);
               ((boolean[]) buf[63])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[64])[0] = rslt.getGXDate(42);
               ((boolean[]) buf[65])[0] = rslt.wasNull();
               ((String[]) buf[66])[0] = rslt.getVarchar(43);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((boolean[]) buf[68])[0] = rslt.getBoolean(44);
               ((boolean[]) buf[69])[0] = rslt.getBoolean(45);
               ((java.math.BigDecimal[]) buf[70])[0] = rslt.getBigDecimal(46,2);
               ((String[]) buf[71])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[72])[0] = rslt.wasNull();
               ((String[]) buf[73])[0] = rslt.getString(48, 20);
               ((boolean[]) buf[74])[0] = rslt.wasNull();
               ((String[]) buf[75])[0] = rslt.getLongVarchar(49);
               ((java.util.Date[]) buf[76])[0] = rslt.getGXDateTime(50);
               ((boolean[]) buf[77])[0] = rslt.getBoolean(51);
               ((String[]) buf[78])[0] = rslt.getString(52, 2);
               ((boolean[]) buf[79])[0] = rslt.getBoolean(53);
               ((boolean[]) buf[80])[0] = rslt.getBoolean(54);
               ((java.math.BigDecimal[]) buf[81])[0] = rslt.getBigDecimal(55,1);
               ((java.math.BigDecimal[]) buf[82])[0] = rslt.getBigDecimal(56,1);
               ((boolean[]) buf[83])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[84])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[85])[0] = rslt.getBoolean(59);
               ((boolean[]) buf[86])[0] = rslt.getBoolean(60);
               ((boolean[]) buf[87])[0] = rslt.getBoolean(61);
               ((boolean[]) buf[88])[0] = rslt.getBoolean(62);
               ((boolean[]) buf[89])[0] = rslt.getBoolean(63);
               ((short[]) buf[90])[0] = rslt.getShort(64);
               ((java.util.Date[]) buf[91])[0] = rslt.getGXDate(65);
               ((int[]) buf[92])[0] = rslt.getInt(66);
               ((boolean[]) buf[93])[0] = rslt.wasNull();
               ((String[]) buf[94])[0] = rslt.getVarchar(67);
               ((String[]) buf[95])[0] = rslt.getString(68, 20);
               ((byte[]) buf[96])[0] = rslt.getByte(69);
               ((String[]) buf[97])[0] = rslt.getLongVarchar(70);
               ((boolean[]) buf[98])[0] = rslt.wasNull();
               ((boolean[]) buf[99])[0] = rslt.getBoolean(71);
               ((boolean[]) buf[100])[0] = rslt.getBoolean(72);
               ((String[]) buf[101])[0] = rslt.getString(73, 1);
               ((String[]) buf[102])[0] = rslt.getString(74, 1);
               ((String[]) buf[103])[0] = rslt.getString(75, 20);
               ((String[]) buf[104])[0] = rslt.getVarchar(76);
               ((int[]) buf[105])[0] = rslt.getInt(77);
               ((String[]) buf[106])[0] = rslt.getString(78, 6);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(79, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getString(80, 20);
               ((boolean[]) buf[111])[0] = rslt.wasNull();
               ((String[]) buf[112])[0] = rslt.getString(81, 20);
               ((boolean[]) buf[113])[0] = rslt.wasNull();
               ((String[]) buf[114])[0] = rslt.getString(82, 20);
               ((boolean[]) buf[115])[0] = rslt.wasNull();
               ((short[]) buf[116])[0] = rslt.getShort(83);
               ((String[]) buf[117])[0] = rslt.getString(84, 20);
               ((boolean[]) buf[118])[0] = rslt.wasNull();
               ((String[]) buf[119])[0] = rslt.getString(85, 20);
               ((boolean[]) buf[120])[0] = rslt.wasNull();
               ((String[]) buf[121])[0] = rslt.getString(86, 20);
               ((boolean[]) buf[122])[0] = rslt.wasNull();
               ((String[]) buf[123])[0] = rslt.getString(87, 20);
               ((boolean[]) buf[124])[0] = rslt.wasNull();
               ((short[]) buf[125])[0] = rslt.getShort(88);
               ((boolean[]) buf[126])[0] = rslt.wasNull();
               return;
            case 73 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 74 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 75 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 76 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 77 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 78 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 79 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 80 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 81 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 82 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 83 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 84 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 85 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 86 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 87 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 88 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 89 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
      }
      getresults90( cursor, rslt, buf) ;
   }

   public void getresults90( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 90 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 91 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 92 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 93 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 94 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 95 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 96 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 97 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 98 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 99 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 100 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 101 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 102 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 103 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 104 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 105 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(4);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(5);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((short[]) buf[10])[0] = rslt.getShort(6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((short[]) buf[12])[0] = rslt.getShort(7);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(9);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(10, 8);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((short[]) buf[20])[0] = rslt.getShort(11);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(12, 4);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(13, 4);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((boolean[]) buf[32])[0] = rslt.getBoolean(17);
               ((String[]) buf[33])[0] = rslt.getVarchar(18);
               ((String[]) buf[34])[0] = rslt.getVarchar(19);
               ((String[]) buf[35])[0] = rslt.getVarchar(20);
               ((String[]) buf[36])[0] = rslt.getVarchar(21);
               ((String[]) buf[37])[0] = rslt.getVarchar(22);
               ((String[]) buf[38])[0] = rslt.getVarchar(23);
               ((int[]) buf[39])[0] = rslt.getInt(24);
               ((java.util.Date[]) buf[40])[0] = rslt.getGXDate(25);
               ((String[]) buf[41])[0] = rslt.getVarchar(26);
               ((String[]) buf[42])[0] = rslt.getVarchar(27);
               ((String[]) buf[43])[0] = rslt.getVarchar(28);
               ((String[]) buf[44])[0] = rslt.getBLOBFile(29, rslt.getString(101, 20), rslt.getVarchar(102));
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((byte[]) buf[46])[0] = rslt.getByte(30);
               ((String[]) buf[47])[0] = rslt.getVarchar(31);
               ((java.util.Date[]) buf[48])[0] = rslt.getGXDate(32);
               ((String[]) buf[49])[0] = rslt.getVarchar(33);
               ((long[]) buf[50])[0] = rslt.getLong(34);
               ((byte[]) buf[51])[0] = rslt.getByte(35);
               ((String[]) buf[52])[0] = rslt.getVarchar(36);
               ((String[]) buf[53])[0] = rslt.getVarchar(37);
               ((String[]) buf[54])[0] = rslt.getString(38, 20);
               ((String[]) buf[55])[0] = rslt.getVarchar(39);
               ((String[]) buf[56])[0] = rslt.getVarchar(40);
               ((String[]) buf[57])[0] = rslt.getVarchar(41);
               ((String[]) buf[58])[0] = rslt.getVarchar(42);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[60])[0] = rslt.getGXDate(43);
               ((java.util.Date[]) buf[61])[0] = rslt.getGXDate(44);
               ((boolean[]) buf[62])[0] = rslt.wasNull();
               ((String[]) buf[63])[0] = rslt.getVarchar(45);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((String[]) buf[65])[0] = rslt.getString(46, 40);
               ((boolean[]) buf[66])[0] = rslt.wasNull();
               ((int[]) buf[67])[0] = rslt.getInt(47);
               ((boolean[]) buf[68])[0] = rslt.wasNull();
               ((String[]) buf[69])[0] = rslt.getVarchar(48);
               ((boolean[]) buf[70])[0] = rslt.wasNull();
               ((String[]) buf[71])[0] = rslt.getVarchar(49);
               ((boolean[]) buf[72])[0] = rslt.wasNull();
               ((byte[]) buf[73])[0] = rslt.getByte(50);
               ((byte[]) buf[74])[0] = rslt.getByte(51);
               ((String[]) buf[75])[0] = rslt.getVarchar(52);
               ((String[]) buf[76])[0] = rslt.getVarchar(53);
               ((boolean[]) buf[77])[0] = rslt.wasNull();
               ((String[]) buf[78])[0] = rslt.getString(54, 20);
               ((boolean[]) buf[79])[0] = rslt.wasNull();
               ((String[]) buf[80])[0] = rslt.getVarchar(55);
               ((boolean[]) buf[81])[0] = rslt.wasNull();
               ((String[]) buf[82])[0] = rslt.getVarchar(56);
               ((String[]) buf[83])[0] = rslt.getString(57, 20);
               ((boolean[]) buf[84])[0] = rslt.wasNull();
               ((String[]) buf[85])[0] = rslt.getVarchar(58);
               ((boolean[]) buf[86])[0] = rslt.wasNull();
               ((String[]) buf[87])[0] = rslt.getVarchar(59);
               ((String[]) buf[88])[0] = rslt.getVarchar(60);
               ((String[]) buf[89])[0] = rslt.getVarchar(61);
               ((boolean[]) buf[90])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[91])[0] = rslt.getGXDate(62);
               ((boolean[]) buf[92])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[93])[0] = rslt.getGXDate(63);
               ((boolean[]) buf[94])[0] = rslt.wasNull();
               ((String[]) buf[95])[0] = rslt.getVarchar(64);
               ((java.math.BigDecimal[]) buf[96])[0] = rslt.getBigDecimal(65,2);
               ((String[]) buf[97])[0] = rslt.getVarchar(66);
               ((boolean[]) buf[98])[0] = rslt.wasNull();
               ((boolean[]) buf[99])[0] = rslt.getBoolean(67);
               ((String[]) buf[100])[0] = rslt.getVarchar(68);
               ((String[]) buf[101])[0] = rslt.getVarchar(69);
               ((boolean[]) buf[102])[0] = rslt.getBoolean(70);
               ((java.math.BigDecimal[]) buf[103])[0] = rslt.getBigDecimal(71,2);
               ((String[]) buf[104])[0] = rslt.getString(72, 20);
               ((boolean[]) buf[105])[0] = rslt.wasNull();
               ((String[]) buf[106])[0] = rslt.getString(73, 20);
               ((boolean[]) buf[107])[0] = rslt.wasNull();
               ((String[]) buf[108])[0] = rslt.getString(74, 20);
               ((boolean[]) buf[109])[0] = rslt.wasNull();
               ((String[]) buf[110])[0] = rslt.getLongVarchar(75);
               ((java.util.Date[]) buf[111])[0] = rslt.getGXDateTime(76);
               ((boolean[]) buf[112])[0] = rslt.getBoolean(77);
               ((String[]) buf[113])[0] = rslt.getString(78, 2);
               ((boolean[]) buf[114])[0] = rslt.getBoolean(79);
               ((boolean[]) buf[115])[0] = rslt.getBoolean(80);
               ((java.math.BigDecimal[]) buf[116])[0] = rslt.getBigDecimal(81,1);
               ((java.math.BigDecimal[]) buf[117])[0] = rslt.getBigDecimal(82,1);
               ((boolean[]) buf[118])[0] = rslt.getBoolean(83);
               ((boolean[]) buf[119])[0] = rslt.getBoolean(84);
               ((boolean[]) buf[120])[0] = rslt.getBoolean(85);
               ((boolean[]) buf[121])[0] = rslt.getBoolean(86);
               ((boolean[]) buf[122])[0] = rslt.getBoolean(87);
               ((boolean[]) buf[123])[0] = rslt.getBoolean(88);
               ((boolean[]) buf[124])[0] = rslt.getBoolean(89);
               ((short[]) buf[125])[0] = rslt.getShort(90);
               ((java.util.Date[]) buf[126])[0] = rslt.getGXDate(91);
               ((int[]) buf[127])[0] = rslt.getInt(92);
               ((boolean[]) buf[128])[0] = rslt.wasNull();
               ((String[]) buf[129])[0] = rslt.getVarchar(93);
               ((String[]) buf[130])[0] = rslt.getString(94, 20);
               ((byte[]) buf[131])[0] = rslt.getByte(95);
               ((String[]) buf[132])[0] = rslt.getLongVarchar(96);
               ((boolean[]) buf[133])[0] = rslt.wasNull();
               ((boolean[]) buf[134])[0] = rslt.getBoolean(97);
               ((boolean[]) buf[135])[0] = rslt.getBoolean(98);
               ((String[]) buf[136])[0] = rslt.getString(99, 1);
               ((String[]) buf[137])[0] = rslt.getString(100, 1);
               ((String[]) buf[138])[0] = rslt.getString(101, 20);
               ((String[]) buf[139])[0] = rslt.getVarchar(102);
               ((String[]) buf[140])[0] = rslt.getString(103, 20);
               ((boolean[]) buf[141])[0] = rslt.wasNull();
               ((int[]) buf[142])[0] = rslt.getInt(104);
               ((String[]) buf[143])[0] = rslt.getString(105, 6);
               ((boolean[]) buf[144])[0] = rslt.wasNull();
               ((String[]) buf[145])[0] = rslt.getString(106, 20);
               ((boolean[]) buf[146])[0] = rslt.wasNull();
               ((String[]) buf[147])[0] = rslt.getString(107, 20);
               ((boolean[]) buf[148])[0] = rslt.wasNull();
               ((String[]) buf[149])[0] = rslt.getString(108, 20);
               ((boolean[]) buf[150])[0] = rslt.wasNull();
               ((String[]) buf[151])[0] = rslt.getString(109, 20);
               ((boolean[]) buf[152])[0] = rslt.wasNull();
               ((short[]) buf[153])[0] = rslt.getShort(110);
               ((String[]) buf[154])[0] = rslt.getString(111, 20);
               ((boolean[]) buf[155])[0] = rslt.wasNull();
               ((String[]) buf[156])[0] = rslt.getString(112, 20);
               ((boolean[]) buf[157])[0] = rslt.wasNull();
               ((String[]) buf[158])[0] = rslt.getString(113, 20);
               ((boolean[]) buf[159])[0] = rslt.wasNull();
               ((String[]) buf[160])[0] = rslt.getString(114, 20);
               ((boolean[]) buf[161])[0] = rslt.wasNull();
               ((short[]) buf[162])[0] = rslt.getShort(115);
               ((boolean[]) buf[163])[0] = rslt.wasNull();
               return;
            case 106 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               return;
            case 107 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 108 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               return;
            case 109 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               return;
            case 113 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               return;
            case 114 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 115 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 116 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 117 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 118 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 121 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 122 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 20);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               return;
            case 123 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 124 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 125 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 126 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 20);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               return;
            case 127 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 20);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               return;
            case 131 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 20);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               return;
            case 132 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 133 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 134 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 135 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 136 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 139 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 140 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               return;
            case 141 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 142 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 143 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 144 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 148 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 149 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               return;
      }
      getresults150( cursor, rslt, buf) ;
   }

   public void getresults150( int cursor ,
                              IFieldGetter rslt ,
                              Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 150 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               return;
            case 151 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 152 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               return;
            case 153 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 6);
               }
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               return;
            case 25 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 26 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 27 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 28 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 29 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 31 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 32 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 33 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 34 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 35 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 20);
               }
               return;
            case 36 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[3]).intValue());
               }
               return;
            case 37 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 38 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 39 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 42 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 6);
               }
               return;
            case 43 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 44 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 45 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 46 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 47 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               return;
            case 48 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 49 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 50 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               return;
            case 51 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 52 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 53 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 54 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 55 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 56 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 57 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 20);
               }
               return;
            case 58 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[3]).intValue());
               }
               return;
            case 59 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
      }
      setparameters60( cursor, stmt, parms) ;
   }

   public void setparameters60( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 61 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 62 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 63 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 64 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 65 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 66 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 67 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 68 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 69 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setVarchar(6, (String)parms[5], 30, false);
               stmt.setVarchar(7, (String)parms[6], 30, false);
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(8, (String)parms[8]);
               }
               stmt.setByte(9, ((Number) parms[9]).byteValue());
               stmt.setVarchar(10, (String)parms[10], 20, false);
               stmt.setDate(11, (java.util.Date)parms[11]);
               stmt.setLong(12, ((Number) parms[12]).longValue());
               stmt.setByte(13, ((Number) parms[13]).byteValue());
               stmt.setVarchar(14, (String)parms[14], 4000, false);
               stmt.setVarchar(15, (String)parms[15], 100, false);
               stmt.setString(16, (String)parms[16], 20);
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(17, (String)parms[18], 30);
               }
               stmt.setDate(18, (java.util.Date)parms[19]);
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.DATE );
               }
               else
               {
                  stmt.setDate(19, (java.util.Date)parms[21]);
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(20, (String)parms[23], 40);
               }
               if ( ((Boolean) parms[24]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(21, ((Number) parms[25]).intValue());
               }
               stmt.setByte(22, ((Number) parms[26]).byteValue());
               stmt.setByte(23, ((Number) parms[27]).byteValue());
               if ( ((Boolean) parms[28]).booleanValue() )
               {
                  stmt.setNull( 24 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(24, (String)parms[29], 30);
               }
               if ( ((Boolean) parms[30]).booleanValue() )
               {
                  stmt.setNull( 25 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(25, (String)parms[31], 20);
               }
               if ( ((Boolean) parms[32]).booleanValue() )
               {
                  stmt.setNull( 26 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(26, (String)parms[33], 20);
               }
               if ( ((Boolean) parms[34]).booleanValue() )
               {
                  stmt.setNull( 27 , Types.DATE );
               }
               else
               {
                  stmt.setDate(27, (java.util.Date)parms[35]);
               }
               if ( ((Boolean) parms[36]).booleanValue() )
               {
                  stmt.setNull( 28 , Types.DATE );
               }
               else
               {
                  stmt.setDate(28, (java.util.Date)parms[37]);
               }
               if ( ((Boolean) parms[38]).booleanValue() )
               {
                  stmt.setNull( 29 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(29, (String)parms[39], 22);
               }
               stmt.setBoolean(30, ((Boolean) parms[40]).booleanValue());
               stmt.setBoolean(31, ((Boolean) parms[41]).booleanValue());
               stmt.setBigDecimal(32, (java.math.BigDecimal)parms[42], 2);
               if ( ((Boolean) parms[43]).booleanValue() )
               {
                  stmt.setNull( 33 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(33, (String)parms[44], 20);
               }
               if ( ((Boolean) parms[45]).booleanValue() )
               {
                  stmt.setNull( 34 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(34, (String)parms[46], 20);
               }
               stmt.setNLongVarchar(35, (String)parms[47], false);
               stmt.setDateTime(36, (java.util.Date)parms[48], false);
               stmt.setBoolean(37, ((Boolean) parms[49]).booleanValue());
               stmt.setString(38, (String)parms[50], 2);
               stmt.setBoolean(39, ((Boolean) parms[51]).booleanValue());
               stmt.setBoolean(40, ((Boolean) parms[52]).booleanValue());
               stmt.setBigDecimal(41, (java.math.BigDecimal)parms[53], 1);
               stmt.setBigDecimal(42, (java.math.BigDecimal)parms[54], 1);
               stmt.setBoolean(43, ((Boolean) parms[55]).booleanValue());
               stmt.setBoolean(44, ((Boolean) parms[56]).booleanValue());
               stmt.setBoolean(45, ((Boolean) parms[57]).booleanValue());
               stmt.setBoolean(46, ((Boolean) parms[58]).booleanValue());
               stmt.setBoolean(47, ((Boolean) parms[59]).booleanValue());
               stmt.setBoolean(48, ((Boolean) parms[60]).booleanValue());
               stmt.setBoolean(49, ((Boolean) parms[61]).booleanValue());
               stmt.setShort(50, ((Number) parms[62]).shortValue());
               stmt.setDate(51, (java.util.Date)parms[63]);
               if ( ((Boolean) parms[64]).booleanValue() )
               {
                  stmt.setNull( 52 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(52, ((Number) parms[65]).intValue());
               }
               stmt.setVarchar(53, (String)parms[66], 4000, false);
               stmt.setString(54, (String)parms[67], 20);
               stmt.setByte(55, ((Number) parms[68]).byteValue());
               if ( ((Boolean) parms[69]).booleanValue() )
               {
                  stmt.setNull( 56 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(56, (String)parms[70]);
               }
               stmt.setBoolean(57, ((Boolean) parms[71]).booleanValue());
               stmt.setBoolean(58, ((Boolean) parms[72]).booleanValue());
               stmt.setString(59, (String)parms[73], 1);
               stmt.setString(60, (String)parms[74], 1);
               stmt.setString(61, (String)parms[75], 20);
               stmt.setVarchar(62, (String)parms[76], 1000, false);
               stmt.setInt(63, ((Number) parms[77]).intValue());
               if ( ((Boolean) parms[78]).booleanValue() )
               {
                  stmt.setNull( 64 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(64, (String)parms[79], 6);
               }
               if ( ((Boolean) parms[80]).booleanValue() )
               {
                  stmt.setNull( 65 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(65, (String)parms[81], 20);
               }
               if ( ((Boolean) parms[82]).booleanValue() )
               {
                  stmt.setNull( 66 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(66, (String)parms[83], 20);
               }
               if ( ((Boolean) parms[84]).booleanValue() )
               {
                  stmt.setNull( 67 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(67, (String)parms[85], 20);
               }
               if ( ((Boolean) parms[86]).booleanValue() )
               {
                  stmt.setNull( 68 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(68, (String)parms[87], 20);
               }
               stmt.setShort(69, ((Number) parms[88]).shortValue());
               if ( ((Boolean) parms[89]).booleanValue() )
               {
                  stmt.setNull( 70 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(70, (String)parms[90], 20);
               }
               if ( ((Boolean) parms[91]).booleanValue() )
               {
                  stmt.setNull( 71 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(71, (String)parms[92], 20);
               }
               if ( ((Boolean) parms[93]).booleanValue() )
               {
                  stmt.setNull( 72 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(72, (String)parms[94], 20);
               }
               if ( ((Boolean) parms[95]).booleanValue() )
               {
                  stmt.setNull( 73 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(73, (String)parms[96], 20);
               }
               if ( ((Boolean) parms[97]).booleanValue() )
               {
                  stmt.setNull( 74 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(74, ((Number) parms[98]).shortValue());
               }
               if ( ((Boolean) parms[99]).booleanValue() )
               {
                  stmt.setNull( 75 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(75, (String)parms[100], 4);
               }
               if ( ((Boolean) parms[101]).booleanValue() )
               {
                  stmt.setNull( 76 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(76, ((Number) parms[102]).byteValue());
               }
               if ( ((Boolean) parms[103]).booleanValue() )
               {
                  stmt.setNull( 77 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(77, ((Number) parms[104]).shortValue());
               }
               if ( ((Boolean) parms[105]).booleanValue() )
               {
                  stmt.setNull( 78 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(78, ((Number) parms[106]).shortValue());
               }
               if ( ((Boolean) parms[107]).booleanValue() )
               {
                  stmt.setNull( 79 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(79, ((Number) parms[108]).shortValue());
               }
               if ( ((Boolean) parms[109]).booleanValue() )
               {
                  stmt.setNull( 80 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(80, ((Number) parms[110]).shortValue());
               }
               if ( ((Boolean) parms[111]).booleanValue() )
               {
                  stmt.setNull( 81 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(81, ((Number) parms[112]).shortValue());
               }
               if ( ((Boolean) parms[113]).booleanValue() )
               {
                  stmt.setNull( 82 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(82, (String)parms[114], 20);
               }
               if ( ((Boolean) parms[115]).booleanValue() )
               {
                  stmt.setNull( 83 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(83, ((Number) parms[116]).intValue());
               }
               if ( ((Boolean) parms[117]).booleanValue() )
               {
                  stmt.setNull( 84 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(84, (String)parms[118], 8);
               }
               if ( ((Boolean) parms[119]).booleanValue() )
               {
                  stmt.setNull( 85 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(85, ((Number) parms[120]).shortValue());
               }
               if ( ((Boolean) parms[121]).booleanValue() )
               {
                  stmt.setNull( 86 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(86, (String)parms[122], 4);
               }
               if ( ((Boolean) parms[123]).booleanValue() )
               {
                  stmt.setNull( 87 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(87, (String)parms[124], 20);
               }
               if ( ((Boolean) parms[125]).booleanValue() )
               {
                  stmt.setNull( 88 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(88, (String)parms[126], 20);
               }
               return;
            case 70 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setVarchar(5, (String)parms[4], 30, false);
               stmt.setVarchar(6, (String)parms[5], 30, false);
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setVarchar(8, (String)parms[7], 20, false);
               stmt.setDate(9, (java.util.Date)parms[8]);
               stmt.setLong(10, ((Number) parms[9]).longValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setVarchar(12, (String)parms[11], 4000, false);
               stmt.setVarchar(13, (String)parms[12], 100, false);
               stmt.setString(14, (String)parms[13], 20);
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(15, (String)parms[15], 30);
               }
               stmt.setDate(16, (java.util.Date)parms[16]);
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.DATE );
               }
               else
               {
                  stmt.setDate(17, (java.util.Date)parms[18]);
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(18, (String)parms[20], 40);
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(19, ((Number) parms[22]).intValue());
               }
               stmt.setByte(20, ((Number) parms[23]).byteValue());
               stmt.setByte(21, ((Number) parms[24]).byteValue());
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 22 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(22, (String)parms[26], 30);
               }
               if ( ((Boolean) parms[27]).booleanValue() )
               {
                  stmt.setNull( 23 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(23, (String)parms[28], 20);
               }
               if ( ((Boolean) parms[29]).booleanValue() )
               {
                  stmt.setNull( 24 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(24, (String)parms[30], 20);
               }
               if ( ((Boolean) parms[31]).booleanValue() )
               {
                  stmt.setNull( 25 , Types.DATE );
               }
               else
               {
                  stmt.setDate(25, (java.util.Date)parms[32]);
               }
               if ( ((Boolean) parms[33]).booleanValue() )
               {
                  stmt.setNull( 26 , Types.DATE );
               }
               else
               {
                  stmt.setDate(26, (java.util.Date)parms[34]);
               }
               if ( ((Boolean) parms[35]).booleanValue() )
               {
                  stmt.setNull( 27 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(27, (String)parms[36], 22);
               }
               stmt.setBoolean(28, ((Boolean) parms[37]).booleanValue());
               stmt.setBoolean(29, ((Boolean) parms[38]).booleanValue());
               stmt.setBigDecimal(30, (java.math.BigDecimal)parms[39], 2);
               if ( ((Boolean) parms[40]).booleanValue() )
               {
                  stmt.setNull( 31 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(31, (String)parms[41], 20);
               }
               if ( ((Boolean) parms[42]).booleanValue() )
               {
                  stmt.setNull( 32 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(32, (String)parms[43], 20);
               }
               stmt.setNLongVarchar(33, (String)parms[44], false);
               stmt.setDateTime(34, (java.util.Date)parms[45], false);
               stmt.setBoolean(35, ((Boolean) parms[46]).booleanValue());
               stmt.setString(36, (String)parms[47], 2);
               stmt.setBoolean(37, ((Boolean) parms[48]).booleanValue());
               stmt.setBoolean(38, ((Boolean) parms[49]).booleanValue());
               stmt.setBigDecimal(39, (java.math.BigDecimal)parms[50], 1);
               stmt.setBigDecimal(40, (java.math.BigDecimal)parms[51], 1);
               stmt.setBoolean(41, ((Boolean) parms[52]).booleanValue());
               stmt.setBoolean(42, ((Boolean) parms[53]).booleanValue());
               stmt.setBoolean(43, ((Boolean) parms[54]).booleanValue());
               stmt.setBoolean(44, ((Boolean) parms[55]).booleanValue());
               stmt.setBoolean(45, ((Boolean) parms[56]).booleanValue());
               stmt.setBoolean(46, ((Boolean) parms[57]).booleanValue());
               stmt.setBoolean(47, ((Boolean) parms[58]).booleanValue());
               stmt.setShort(48, ((Number) parms[59]).shortValue());
               stmt.setDate(49, (java.util.Date)parms[60]);
               if ( ((Boolean) parms[61]).booleanValue() )
               {
                  stmt.setNull( 50 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(50, ((Number) parms[62]).intValue());
               }
               stmt.setVarchar(51, (String)parms[63], 4000, false);
               stmt.setString(52, (String)parms[64], 20);
               stmt.setByte(53, ((Number) parms[65]).byteValue());
               if ( ((Boolean) parms[66]).booleanValue() )
               {
                  stmt.setNull( 54 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(54, (String)parms[67]);
               }
               stmt.setBoolean(55, ((Boolean) parms[68]).booleanValue());
               stmt.setBoolean(56, ((Boolean) parms[69]).booleanValue());
               stmt.setString(57, (String)parms[70], 1);
               stmt.setString(58, (String)parms[71], 1);
               stmt.setString(59, (String)parms[72], 20);
               stmt.setVarchar(60, (String)parms[73], 1000, false);
               if ( ((Boolean) parms[74]).booleanValue() )
               {
                  stmt.setNull( 61 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(61, (String)parms[75], 6);
               }
               if ( ((Boolean) parms[76]).booleanValue() )
               {
                  stmt.setNull( 62 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(62, (String)parms[77], 20);
               }
               if ( ((Boolean) parms[78]).booleanValue() )
               {
                  stmt.setNull( 63 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(63, (String)parms[79], 20);
               }
               if ( ((Boolean) parms[80]).booleanValue() )
               {
                  stmt.setNull( 64 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(64, (String)parms[81], 20);
               }
               if ( ((Boolean) parms[82]).booleanValue() )
               {
                  stmt.setNull( 65 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(65, (String)parms[83], 20);
               }
               if ( ((Boolean) parms[84]).booleanValue() )
               {
                  stmt.setNull( 66 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(66, (String)parms[85], 20);
               }
               if ( ((Boolean) parms[86]).booleanValue() )
               {
                  stmt.setNull( 67 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(67, (String)parms[87], 20);
               }
               if ( ((Boolean) parms[88]).booleanValue() )
               {
                  stmt.setNull( 68 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(68, (String)parms[89], 20);
               }
               if ( ((Boolean) parms[90]).booleanValue() )
               {
                  stmt.setNull( 69 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(69, (String)parms[91], 20);
               }
               if ( ((Boolean) parms[92]).booleanValue() )
               {
                  stmt.setNull( 70 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(70, ((Number) parms[93]).shortValue());
               }
               if ( ((Boolean) parms[94]).booleanValue() )
               {
                  stmt.setNull( 71 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(71, (String)parms[95], 4);
               }
               if ( ((Boolean) parms[96]).booleanValue() )
               {
                  stmt.setNull( 72 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(72, ((Number) parms[97]).byteValue());
               }
               if ( ((Boolean) parms[98]).booleanValue() )
               {
                  stmt.setNull( 73 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(73, ((Number) parms[99]).shortValue());
               }
               if ( ((Boolean) parms[100]).booleanValue() )
               {
                  stmt.setNull( 74 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(74, ((Number) parms[101]).shortValue());
               }
               if ( ((Boolean) parms[102]).booleanValue() )
               {
                  stmt.setNull( 75 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(75, ((Number) parms[103]).shortValue());
               }
               if ( ((Boolean) parms[104]).booleanValue() )
               {
                  stmt.setNull( 76 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(76, ((Number) parms[105]).shortValue());
               }
               if ( ((Boolean) parms[106]).booleanValue() )
               {
                  stmt.setNull( 77 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(77, ((Number) parms[107]).shortValue());
               }
               if ( ((Boolean) parms[108]).booleanValue() )
               {
                  stmt.setNull( 78 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(78, (String)parms[109], 20);
               }
               if ( ((Boolean) parms[110]).booleanValue() )
               {
                  stmt.setNull( 79 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(79, ((Number) parms[111]).intValue());
               }
               if ( ((Boolean) parms[112]).booleanValue() )
               {
                  stmt.setNull( 80 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(80, (String)parms[113], 8);
               }
               if ( ((Boolean) parms[114]).booleanValue() )
               {
                  stmt.setNull( 81 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(81, ((Number) parms[115]).shortValue());
               }
               if ( ((Boolean) parms[116]).booleanValue() )
               {
                  stmt.setNull( 82 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(82, (String)parms[117], 4);
               }
               if ( ((Boolean) parms[118]).booleanValue() )
               {
                  stmt.setNull( 83 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(83, (String)parms[119], 20);
               }
               if ( ((Boolean) parms[120]).booleanValue() )
               {
                  stmt.setNull( 84 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(84, (String)parms[121], 20);
               }
               stmt.setInt(85, ((Number) parms[122]).intValue());
               stmt.setShort(86, ((Number) parms[123]).shortValue());
               stmt.setInt(87, ((Number) parms[124]).intValue());
               return;
            case 71 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(1, (String)parms[1]);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setShort(3, ((Number) parms[3]).shortValue());
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
            case 72 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 73 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 74 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 75 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 76 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 77 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 78 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 79 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 80 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 81 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 82 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 6);
               }
               return;
            case 83 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 20);
               }
               return;
            case 84 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 85 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 86 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 87 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 88 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 89 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
      }
      setparameters90( cursor, stmt, parms) ;
   }

   public void setparameters90( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 90 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 91 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 92 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 93 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 94 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 95 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 96 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 97 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 98 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 99 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 100 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 101 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 102 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 103 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 104 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 105 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 106 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 107 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 108 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 109 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 110 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[7], 20);
               }
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 2);
               stmt.setNLongVarchar(9, (String)parms[9], false);
               return;
            case 111 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[4], 2);
               stmt.setNLongVarchar(5, (String)parms[5], false);
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setShort(7, ((Number) parms[7]).shortValue());
               stmt.setInt(8, ((Number) parms[8]).intValue());
               stmt.setShort(9, ((Number) parms[9]).shortValue());
               return;
            case 112 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 113 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 114 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 115 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 116 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 117 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 118 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 119 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
      }
      setparameters120( cursor, stmt, parms) ;
   }

   public void setparameters120( int cursor ,
                                 IFieldSetter stmt ,
                                 Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 120 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 121 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 122 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 123 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 124 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               return;
            case 125 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 126 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 127 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 128 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               stmt.setVarchar(4, (String)parms[3], 40, false);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.DATE );
               }
               else
               {
                  stmt.setDate(5, (java.util.Date)parms[5]);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(6, ((Boolean) parms[7]).booleanValue());
               }
               stmt.setString(7, (String)parms[8], 20);
               stmt.setBoolean(8, ((Boolean) parms[9]).booleanValue());
               stmt.setInt(9, ((Number) parms[10]).intValue());
               stmt.setString(10, (String)parms[11], 20);
               stmt.setShort(11, ((Number) parms[12]).shortValue());
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(12, ((Number) parms[14]).shortValue());
               }
               return;
            case 129 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 40, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.DATE );
               }
               else
               {
                  stmt.setDate(3, (java.util.Date)parms[3]);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[5]).booleanValue());
               }
               stmt.setString(5, (String)parms[6], 20);
               stmt.setBoolean(6, ((Boolean) parms[7]).booleanValue());
               stmt.setString(7, (String)parms[8], 20);
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(8, ((Number) parms[10]).shortValue());
               }
               stmt.setInt(9, ((Number) parms[11]).intValue());
               stmt.setShort(10, ((Number) parms[12]).shortValue());
               stmt.setInt(11, ((Number) parms[13]).intValue());
               stmt.setShort(12, ((Number) parms[14]).shortValue());
               return;
            case 130 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 131 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 132 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 133 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 134 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 135 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 136 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 137 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 138 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 139 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 140 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 141 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 142 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 143 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 144 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 145 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 146 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 147 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 148 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 149 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
      setparameters150( cursor, stmt, parms) ;
   }

   public void setparameters150( int cursor ,
                                 IFieldSetter stmt ,
                                 Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 150 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 151 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 152 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 153 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
      }
   }

}

