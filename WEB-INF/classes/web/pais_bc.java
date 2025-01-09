package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pais_bc extends GXWebPanel implements IGxSilentTrn
{
   public pais_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pais_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pais_bc.class ));
   }

   public pais_bc( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1538( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1538( ) ;
      standaloneModal( ) ;
      addRow1538( ) ;
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
         e11152 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z46PaiCod = A46PaiCod ;
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

   public void confirm_150( )
   {
      beforeValidate1538( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1538( ) ;
         }
         else
         {
            checkExtendedTable1538( ) ;
            if ( AnyError == 0 )
            {
               zm1538( 22) ;
            }
            closeExtendedTableCursors1538( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode38 = Gx_mode ;
         confirm_15196( ) ;
         if ( AnyError == 0 )
         {
            confirm_15183( ) ;
            if ( AnyError == 0 )
            {
               confirm_15168( ) ;
               if ( AnyError == 0 )
               {
                  confirm_15167( ) ;
                  if ( AnyError == 0 )
                  {
                     confirm_15169( ) ;
                     if ( AnyError == 0 )
                     {
                        confirm_15155( ) ;
                        if ( AnyError == 0 )
                        {
                           confirm_15164( ) ;
                           if ( AnyError == 0 )
                           {
                              confirm_15240( ) ;
                              if ( AnyError == 0 )
                              {
                                 /* Restore parent mode. */
                                 Gx_mode = sMode38 ;
                                 IsConfirmed = (short)(1) ;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
         /* Restore parent mode. */
         Gx_mode = sMode38 ;
      }
   }

   public void confirm_15240( )
   {
      nGXsfl_240_idx = 0 ;
      while ( nGXsfl_240_idx < bcPais.getgxTv_SdtPais_Vacaciones().size() )
      {
         readRow15240( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound240 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_240 != 0 ) )
         {
            getKey15240( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound240 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate15240( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable15240( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors15240( ) ;
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
               if ( RcdFound240 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey15240( ) ;
                     load15240( ) ;
                     beforeValidate15240( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls15240( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_240 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate15240( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable15240( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors15240( ) ;
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
            VarsToRow240( ((web.SdtPais_Vacaciones)bcPais.getgxTv_SdtPais_Vacaciones().elementAt(-1+nGXsfl_240_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_15164( )
   {
      nGXsfl_164_idx = 0 ;
      while ( nGXsfl_164_idx < bcPais.getgxTv_SdtPais_Horasextras_pordia().size() )
      {
         readRow15164( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound164 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_164 != 0 ) )
         {
            getKey15164( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound164 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate15164( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable15164( ) ;
                     if ( AnyError == 0 )
                     {
                        zm15164( 37) ;
                     }
                     closeExtendedTableCursors15164( ) ;
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
               if ( RcdFound164 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey15164( ) ;
                     load15164( ) ;
                     beforeValidate15164( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls15164( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_164 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate15164( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable15164( ) ;
                           if ( AnyError == 0 )
                           {
                              zm15164( 37) ;
                           }
                           closeExtendedTableCursors15164( ) ;
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
            VarsToRow164( ((web.SdtPais_horasextras_pordia)bcPais.getgxTv_SdtPais_Horasextras_pordia().elementAt(-1+nGXsfl_164_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_15155( )
   {
      nGXsfl_155_idx = 0 ;
      while ( nGXsfl_155_idx < bcPais.getgxTv_SdtPais_Tipo_trabajo().size() )
      {
         readRow15155( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound155 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_155 != 0 ) )
         {
            getKey15155( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound155 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate15155( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable15155( ) ;
                     if ( AnyError == 0 )
                     {
                        zm15155( 35) ;
                     }
                     closeExtendedTableCursors15155( ) ;
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
               if ( RcdFound155 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey15155( ) ;
                     load15155( ) ;
                     beforeValidate15155( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls15155( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_155 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate15155( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable15155( ) ;
                           if ( AnyError == 0 )
                           {
                              zm15155( 35) ;
                           }
                           closeExtendedTableCursors15155( ) ;
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
            VarsToRow155( ((web.SdtPais_tipo_trabajo)bcPais.getgxTv_SdtPais_Tipo_trabajo().elementAt(-1+nGXsfl_155_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_15169( )
   {
      nGXsfl_169_idx = 0 ;
      while ( nGXsfl_169_idx < bcPais.getgxTv_SdtPais_Promedio_horanormal_mensualizados().size() )
      {
         readRow15169( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound169 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_169 != 0 ) )
         {
            getKey15169( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound169 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate15169( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable15169( ) ;
                     if ( AnyError == 0 )
                     {
                        zm15169( 33) ;
                     }
                     closeExtendedTableCursors15169( ) ;
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
               if ( RcdFound169 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey15169( ) ;
                     load15169( ) ;
                     beforeValidate15169( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls15169( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_169 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate15169( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable15169( ) ;
                           if ( AnyError == 0 )
                           {
                              zm15169( 33) ;
                           }
                           closeExtendedTableCursors15169( ) ;
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
            VarsToRow169( ((web.SdtPais_promedio_horanormal_mensualizados)bcPais.getgxTv_SdtPais_Promedio_horanormal_mensualizados().elementAt(-1+nGXsfl_169_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_15167( )
   {
      nGXsfl_167_idx = 0 ;
      while ( nGXsfl_167_idx < bcPais.getgxTv_SdtPais_Conceptos_horanormal_mensualizados().size() )
      {
         readRow15167( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound167 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_167 != 0 ) )
         {
            getKey15167( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound167 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate15167( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable15167( ) ;
                     if ( AnyError == 0 )
                     {
                        zm15167( 31) ;
                     }
                     closeExtendedTableCursors15167( ) ;
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
               if ( RcdFound167 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey15167( ) ;
                     load15167( ) ;
                     beforeValidate15167( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls15167( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_167 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate15167( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable15167( ) ;
                           if ( AnyError == 0 )
                           {
                              zm15167( 31) ;
                           }
                           closeExtendedTableCursors15167( ) ;
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
            VarsToRow167( ((web.SdtPais_conceptos_horanormal_mensualizados)bcPais.getgxTv_SdtPais_Conceptos_horanormal_mensualizados().elementAt(-1+nGXsfl_167_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_15168( )
   {
      nGXsfl_168_idx = 0 ;
      while ( nGXsfl_168_idx < bcPais.getgxTv_SdtPais_Conceptos_horanormal_jornalizados().size() )
      {
         readRow15168( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound168 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_168 != 0 ) )
         {
            getKey15168( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound168 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate15168( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable15168( ) ;
                     if ( AnyError == 0 )
                     {
                        zm15168( 29) ;
                     }
                     closeExtendedTableCursors15168( ) ;
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
               if ( RcdFound168 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey15168( ) ;
                     load15168( ) ;
                     beforeValidate15168( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls15168( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_168 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate15168( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable15168( ) ;
                           if ( AnyError == 0 )
                           {
                              zm15168( 29) ;
                           }
                           closeExtendedTableCursors15168( ) ;
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
            VarsToRow168( ((web.SdtPais_conceptos_horanormal_jornalizados)bcPais.getgxTv_SdtPais_Conceptos_horanormal_jornalizados().elementAt(-1+nGXsfl_168_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_15185( )
   {
      nGXsfl_185_idx = 0 ;
      while ( nGXsfl_185_idx < ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Promedio().size() )
      {
         readRow15185( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound185 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_185 != 0 ) )
         {
            getKey15185( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound185 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate15185( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable15185( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors15185( ) ;
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
               if ( RcdFound185 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey15185( ) ;
                     load15185( ) ;
                     beforeValidate15185( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls15185( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_185 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate15185( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable15185( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors15185( ) ;
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
            VarsToRow185( ((web.SdtPais_base_calculo_promedio)((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Promedio().elementAt(-1+nGXsfl_185_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_15184( )
   {
      nGXsfl_184_idx = 0 ;
      while ( nGXsfl_184_idx < ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Actual().size() )
      {
         readRow15184( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound184 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_184 != 0 ) )
         {
            getKey15184( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound184 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate15184( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable15184( ) ;
                     if ( AnyError == 0 )
                     {
                        zm15184( 26) ;
                     }
                     closeExtendedTableCursors15184( ) ;
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
               if ( RcdFound184 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey15184( ) ;
                     load15184( ) ;
                     beforeValidate15184( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls15184( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_184 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate15184( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable15184( ) ;
                           if ( AnyError == 0 )
                           {
                              zm15184( 26) ;
                           }
                           closeExtendedTableCursors15184( ) ;
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
            VarsToRow184( ((web.SdtPais_base_calculo_actual)((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Actual().elementAt(-1+nGXsfl_184_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_15183( )
   {
      nGXsfl_183_idx = 0 ;
      while ( nGXsfl_183_idx < bcPais.getgxTv_SdtPais_Base_calculo().size() )
      {
         readRow15183( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound183 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_183 != 0 ) )
         {
            getKey15183( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound183 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate15183( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable15183( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors15183( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Save parent mode. */
                        sMode183 = Gx_mode ;
                        confirm_15184( ) ;
                        if ( AnyError == 0 )
                        {
                           confirm_15185( ) ;
                           if ( AnyError == 0 )
                           {
                              /* Restore parent mode. */
                              Gx_mode = sMode183 ;
                              IsConfirmed = (short)(1) ;
                           }
                        }
                        /* Restore parent mode. */
                        Gx_mode = sMode183 ;
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
               if ( RcdFound183 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey15183( ) ;
                     load15183( ) ;
                     beforeValidate15183( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls15183( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_183 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate15183( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable15183( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors15183( ) ;
                           if ( AnyError == 0 )
                           {
                              /* Save parent mode. */
                              sMode183 = Gx_mode ;
                              confirm_15184( ) ;
                              if ( AnyError == 0 )
                              {
                                 confirm_15185( ) ;
                                 if ( AnyError == 0 )
                                 {
                                    /* Restore parent mode. */
                                    Gx_mode = sMode183 ;
                                    IsConfirmed = (short)(1) ;
                                 }
                              }
                              /* Restore parent mode. */
                              Gx_mode = sMode183 ;
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
            VarsToRow183( ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_15196( )
   {
      nGXsfl_196_idx = 0 ;
      while ( nGXsfl_196_idx < bcPais.getgxTv_SdtPais_Preaviso().size() )
      {
         readRow15196( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound196 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_196 != 0 ) )
         {
            getKey15196( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound196 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate15196( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable15196( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors15196( ) ;
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
               if ( RcdFound196 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey15196( ) ;
                     load15196( ) ;
                     beforeValidate15196( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls15196( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_196 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate15196( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable15196( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors15196( ) ;
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
            VarsToRow196( ((web.SdtPais_preaviso)bcPais.getgxTv_SdtPais_Preaviso().elementAt(-1+nGXsfl_196_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e12152( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV9IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais_Insert", GXv_boolean3) ;
         pais_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais_Update", GXv_boolean3) ;
         pais_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais_Delete", GXv_boolean3) ;
         pais_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV29Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV29Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV30GXV1 = 1 ;
         while ( AV30GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV30GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PaiReligDefault") == 0 )
            {
               AV13Insert_PaiReligDefault = AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            AV30GXV1 = (int)(AV30GXV1+1) ;
         }
      }
   }

   public void e11152( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm1538( int GX_JID )
   {
      if ( ( GX_JID == 21 ) || ( GX_JID == 0 ) )
      {
         Z312PaiNom = A312PaiNom ;
         Z311PaiNacMostrar = A311PaiNacMostrar ;
         Z310PaiDomMostrar = A310PaiDomMostrar ;
         Z1271PaiMesHsPExt = A1271PaiMesHsPExt ;
         Z1272PaiDiaHsPExt = A1272PaiDiaHsPExt ;
         Z1402PaiFondoCese = A1402PaiFondoCese ;
         Z1405PaiMaxHorNor = A1405PaiMaxHorNor ;
         Z1521PaiPerVacDes = A1521PaiPerVacDes ;
         Z1522PaiPerVacHas = A1522PaiPerVacHas ;
         Z1814PaiFracVacAnt = A1814PaiFracVacAnt ;
         Z1363PaiPromMeses = A1363PaiPromMeses ;
         Z1590PaiPromMesTCnt = A1590PaiPromMesTCnt ;
         Z1573PaiPromJorMeses = A1573PaiPromJorMeses ;
         Z1591PaiPromJorMesTCnt = A1591PaiPromJorMesTCnt ;
         Z1625PaiGuarEdadMin = A1625PaiGuarEdadMin ;
         Z1626PaiGuarEdadMax = A1626PaiGuarEdadMax ;
         Z1736PaiExcVizzoti = A1736PaiExcVizzoti ;
         Z1737PaiVizzoti = A1737PaiVizzoti ;
         Z1764PaiMinMesesVac = A1764PaiMinMesesVac ;
         Z1765PaiInterDiasJor = A1765PaiInterDiasJor ;
         Z1793PaiTipoExpDef = A1793PaiTipoExpDef ;
         Z1252PaiReligDefault = A1252PaiReligDefault ;
      }
      if ( ( GX_JID == 22 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -21 )
      {
         Z46PaiCod = A46PaiCod ;
         Z312PaiNom = A312PaiNom ;
         Z311PaiNacMostrar = A311PaiNacMostrar ;
         Z310PaiDomMostrar = A310PaiDomMostrar ;
         Z1271PaiMesHsPExt = A1271PaiMesHsPExt ;
         Z1272PaiDiaHsPExt = A1272PaiDiaHsPExt ;
         Z1402PaiFondoCese = A1402PaiFondoCese ;
         Z1405PaiMaxHorNor = A1405PaiMaxHorNor ;
         Z1521PaiPerVacDes = A1521PaiPerVacDes ;
         Z1522PaiPerVacHas = A1522PaiPerVacHas ;
         Z1814PaiFracVacAnt = A1814PaiFracVacAnt ;
         Z1363PaiPromMeses = A1363PaiPromMeses ;
         Z1590PaiPromMesTCnt = A1590PaiPromMesTCnt ;
         Z1573PaiPromJorMeses = A1573PaiPromJorMeses ;
         Z1591PaiPromJorMesTCnt = A1591PaiPromJorMesTCnt ;
         Z1625PaiGuarEdadMin = A1625PaiGuarEdadMin ;
         Z1626PaiGuarEdadMax = A1626PaiGuarEdadMax ;
         Z1736PaiExcVizzoti = A1736PaiExcVizzoti ;
         Z1737PaiVizzoti = A1737PaiVizzoti ;
         Z1764PaiMinMesesVac = A1764PaiMinMesesVac ;
         Z1765PaiInterDiasJor = A1765PaiInterDiasJor ;
         Z1793PaiTipoExpDef = A1793PaiTipoExpDef ;
         Z1252PaiReligDefault = A1252PaiReligDefault ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load1538( )
   {
      /* Using cursor BC001531 */
      pr_default.execute(29, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(29) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A312PaiNom = BC001531_A312PaiNom[0] ;
         A311PaiNacMostrar = BC001531_A311PaiNacMostrar[0] ;
         A310PaiDomMostrar = BC001531_A310PaiDomMostrar[0] ;
         A1271PaiMesHsPExt = BC001531_A1271PaiMesHsPExt[0] ;
         A1272PaiDiaHsPExt = BC001531_A1272PaiDiaHsPExt[0] ;
         A1402PaiFondoCese = BC001531_A1402PaiFondoCese[0] ;
         A1405PaiMaxHorNor = BC001531_A1405PaiMaxHorNor[0] ;
         A1521PaiPerVacDes = BC001531_A1521PaiPerVacDes[0] ;
         A1522PaiPerVacHas = BC001531_A1522PaiPerVacHas[0] ;
         A1814PaiFracVacAnt = BC001531_A1814PaiFracVacAnt[0] ;
         A1363PaiPromMeses = BC001531_A1363PaiPromMeses[0] ;
         A1590PaiPromMesTCnt = BC001531_A1590PaiPromMesTCnt[0] ;
         A1573PaiPromJorMeses = BC001531_A1573PaiPromJorMeses[0] ;
         A1591PaiPromJorMesTCnt = BC001531_A1591PaiPromJorMesTCnt[0] ;
         A1625PaiGuarEdadMin = BC001531_A1625PaiGuarEdadMin[0] ;
         A1626PaiGuarEdadMax = BC001531_A1626PaiGuarEdadMax[0] ;
         A1736PaiExcVizzoti = BC001531_A1736PaiExcVizzoti[0] ;
         A1737PaiVizzoti = BC001531_A1737PaiVizzoti[0] ;
         A1764PaiMinMesesVac = BC001531_A1764PaiMinMesesVac[0] ;
         A1765PaiInterDiasJor = BC001531_A1765PaiInterDiasJor[0] ;
         A1793PaiTipoExpDef = BC001531_A1793PaiTipoExpDef[0] ;
         A1252PaiReligDefault = BC001531_A1252PaiReligDefault[0] ;
         n1252PaiReligDefault = BC001531_n1252PaiReligDefault[0] ;
         zm1538( -21) ;
      }
      pr_default.close(29);
      onLoadActions1538( ) ;
   }

   public void onLoadActions1538( )
   {
      AV29Pgmname = "Pais_BC" ;
   }

   public void checkExtendedTable1538( )
   {
      nIsDirty_38 = (short)(0) ;
      standaloneModal( ) ;
      AV29Pgmname = "Pais_BC" ;
      /* Using cursor BC001532 */
      pr_default.execute(30, new Object[] {Boolean.valueOf(n1252PaiReligDefault), A1252PaiReligDefault});
      if ( (pr_default.getStatus(30) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1252PaiReligDefault)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais Religion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAIRELIGDEFAULT");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(30);
      if ( ! ( ( GXutil.strcmp(A1272PaiDiaHsPExt, "Promedio") == 0 ) || ( GXutil.strcmp(A1272PaiDiaHsPExt, "diasSemanaX4") == 0 ) || ( GXutil.strcmp(A1272PaiDiaHsPExt, "diasSemanaMes") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Días habiles del mes para obtener cantidad de horas del mes para cálculo de 1 hora de trabajo para empleados de clase mensual", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1521PaiPerVacDes == 1 ) || ( A1521PaiPerVacDes == 2 ) || ( A1521PaiPerVacDes == 3 ) || ( A1521PaiPerVacDes == 4 ) || ( A1521PaiPerVacDes == 5 ) || ( A1521PaiPerVacDes == 6 ) || ( A1521PaiPerVacDes == 7 ) || ( A1521PaiPerVacDes == 8 ) || ( A1521PaiPerVacDes == 9 ) || ( A1521PaiPerVacDes == 10 ) || ( A1521PaiPerVacDes == 11 ) || ( A1521PaiPerVacDes == 12 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Periodo de vacaciones desde", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1522PaiPerVacHas == 1 ) || ( A1522PaiPerVacHas == 2 ) || ( A1522PaiPerVacHas == 3 ) || ( A1522PaiPerVacHas == 4 ) || ( A1522PaiPerVacHas == 5 ) || ( A1522PaiPerVacHas == 6 ) || ( A1522PaiPerVacHas == 7 ) || ( A1522PaiPerVacHas == 8 ) || ( A1522PaiPerVacHas == 9 ) || ( A1522PaiPerVacHas == 10 ) || ( A1522PaiPerVacHas == 11 ) || ( A1522PaiPerVacHas == 12 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Periodo de vacaciones hasta", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1590PaiPromMesTCnt, "dias") == 0 ) || ( GXutil.strcmp(A1590PaiPromMesTCnt, "meses") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "(borrar) Días/meses", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1591PaiPromJorMesTCnt, "dias") == 0 ) || ( GXutil.strcmp(A1591PaiPromJorMesTCnt, "meses") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "(borrar) Días/meses", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1793PaiTipoExpDef == 1 ) || ( A1793PaiTipoExpDef == 2 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de exposición por defecto", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors1538( )
   {
      pr_default.close(30);
   }

   public void enableDisable( )
   {
   }

   public void getKey1538( )
   {
      /* Using cursor BC001533 */
      pr_default.execute(31, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(31) != 101) )
      {
         RcdFound38 = (short)(1) ;
      }
      else
      {
         RcdFound38 = (short)(0) ;
      }
      pr_default.close(31);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC001534 */
      pr_default.execute(32, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(32) != 101) )
      {
         zm1538( 21) ;
         RcdFound38 = (short)(1) ;
         A46PaiCod = BC001534_A46PaiCod[0] ;
         A312PaiNom = BC001534_A312PaiNom[0] ;
         A311PaiNacMostrar = BC001534_A311PaiNacMostrar[0] ;
         A310PaiDomMostrar = BC001534_A310PaiDomMostrar[0] ;
         A1271PaiMesHsPExt = BC001534_A1271PaiMesHsPExt[0] ;
         A1272PaiDiaHsPExt = BC001534_A1272PaiDiaHsPExt[0] ;
         A1402PaiFondoCese = BC001534_A1402PaiFondoCese[0] ;
         A1405PaiMaxHorNor = BC001534_A1405PaiMaxHorNor[0] ;
         A1521PaiPerVacDes = BC001534_A1521PaiPerVacDes[0] ;
         A1522PaiPerVacHas = BC001534_A1522PaiPerVacHas[0] ;
         A1814PaiFracVacAnt = BC001534_A1814PaiFracVacAnt[0] ;
         A1363PaiPromMeses = BC001534_A1363PaiPromMeses[0] ;
         A1590PaiPromMesTCnt = BC001534_A1590PaiPromMesTCnt[0] ;
         A1573PaiPromJorMeses = BC001534_A1573PaiPromJorMeses[0] ;
         A1591PaiPromJorMesTCnt = BC001534_A1591PaiPromJorMesTCnt[0] ;
         A1625PaiGuarEdadMin = BC001534_A1625PaiGuarEdadMin[0] ;
         A1626PaiGuarEdadMax = BC001534_A1626PaiGuarEdadMax[0] ;
         A1736PaiExcVizzoti = BC001534_A1736PaiExcVizzoti[0] ;
         A1737PaiVizzoti = BC001534_A1737PaiVizzoti[0] ;
         A1764PaiMinMesesVac = BC001534_A1764PaiMinMesesVac[0] ;
         A1765PaiInterDiasJor = BC001534_A1765PaiInterDiasJor[0] ;
         A1793PaiTipoExpDef = BC001534_A1793PaiTipoExpDef[0] ;
         A1252PaiReligDefault = BC001534_A1252PaiReligDefault[0] ;
         n1252PaiReligDefault = BC001534_n1252PaiReligDefault[0] ;
         Z46PaiCod = A46PaiCod ;
         sMode38 = Gx_mode ;
         Gx_mode = "DSP" ;
         load1538( ) ;
         if ( AnyError == 1 )
         {
            RcdFound38 = (short)(0) ;
            initializeNonKey1538( ) ;
         }
         Gx_mode = sMode38 ;
      }
      else
      {
         RcdFound38 = (short)(0) ;
         initializeNonKey1538( ) ;
         sMode38 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode38 ;
      }
      pr_default.close(32);
   }

   public void getEqualNoModal( )
   {
      getKey1538( ) ;
      if ( RcdFound38 == 0 )
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
      confirm_150( ) ;
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

   public void checkOptimisticConcurrency1538( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001535 */
         pr_default.execute(33, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(33) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pais"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(33) == 101) || ( GXutil.strcmp(Z312PaiNom, BC001535_A312PaiNom[0]) != 0 ) || ( Z311PaiNacMostrar != BC001535_A311PaiNacMostrar[0] ) || ( Z310PaiDomMostrar != BC001535_A310PaiDomMostrar[0] ) || ( DecimalUtil.compareTo(Z1271PaiMesHsPExt, BC001535_A1271PaiMesHsPExt[0]) != 0 ) || ( GXutil.strcmp(Z1272PaiDiaHsPExt, BC001535_A1272PaiDiaHsPExt[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1402PaiFondoCese != BC001535_A1402PaiFondoCese[0] ) || ( DecimalUtil.compareTo(Z1405PaiMaxHorNor, BC001535_A1405PaiMaxHorNor[0]) != 0 ) || ( Z1521PaiPerVacDes != BC001535_A1521PaiPerVacDes[0] ) || ( Z1522PaiPerVacHas != BC001535_A1522PaiPerVacHas[0] ) || ( DecimalUtil.compareTo(Z1814PaiFracVacAnt, BC001535_A1814PaiFracVacAnt[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1363PaiPromMeses != BC001535_A1363PaiPromMeses[0] ) || ( GXutil.strcmp(Z1590PaiPromMesTCnt, BC001535_A1590PaiPromMesTCnt[0]) != 0 ) || ( Z1573PaiPromJorMeses != BC001535_A1573PaiPromJorMeses[0] ) || ( GXutil.strcmp(Z1591PaiPromJorMesTCnt, BC001535_A1591PaiPromJorMesTCnt[0]) != 0 ) || ( Z1625PaiGuarEdadMin != BC001535_A1625PaiGuarEdadMin[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1626PaiGuarEdadMax != BC001535_A1626PaiGuarEdadMax[0] ) || ( Z1736PaiExcVizzoti != BC001535_A1736PaiExcVizzoti[0] ) || ( DecimalUtil.compareTo(Z1737PaiVizzoti, BC001535_A1737PaiVizzoti[0]) != 0 ) || ( Z1764PaiMinMesesVac != BC001535_A1764PaiMinMesesVac[0] ) || ( Z1765PaiInterDiasJor != BC001535_A1765PaiInterDiasJor[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1793PaiTipoExpDef != BC001535_A1793PaiTipoExpDef[0] ) || ( GXutil.strcmp(Z1252PaiReligDefault, BC001535_A1252PaiReligDefault[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Pais"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1538( )
   {
      beforeValidate1538( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1538( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1538( 0) ;
         checkOptimisticConcurrency1538( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1538( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1538( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001536 */
                  pr_default.execute(34, new Object[] {Short.valueOf(A46PaiCod), A312PaiNom, Boolean.valueOf(A311PaiNacMostrar), Boolean.valueOf(A310PaiDomMostrar), A1271PaiMesHsPExt, A1272PaiDiaHsPExt, Boolean.valueOf(A1402PaiFondoCese), A1405PaiMaxHorNor, Byte.valueOf(A1521PaiPerVacDes), Byte.valueOf(A1522PaiPerVacHas), A1814PaiFracVacAnt, Byte.valueOf(A1363PaiPromMeses), A1590PaiPromMesTCnt, Byte.valueOf(A1573PaiPromJorMeses), A1591PaiPromJorMesTCnt, Byte.valueOf(A1625PaiGuarEdadMin), Byte.valueOf(A1626PaiGuarEdadMax), Boolean.valueOf(A1736PaiExcVizzoti), A1737PaiVizzoti, Byte.valueOf(A1764PaiMinMesesVac), Short.valueOf(A1765PaiInterDiasJor), Byte.valueOf(A1793PaiTipoExpDef), Boolean.valueOf(n1252PaiReligDefault), A1252PaiReligDefault});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
                  if ( (pr_default.getStatus(34) == 1) )
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
                        processLevel1538( ) ;
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
            load1538( ) ;
         }
         endLevel1538( ) ;
      }
      closeExtendedTableCursors1538( ) ;
   }

   public void update1538( )
   {
      beforeValidate1538( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1538( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1538( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1538( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1538( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001537 */
                  pr_default.execute(35, new Object[] {A312PaiNom, Boolean.valueOf(A311PaiNacMostrar), Boolean.valueOf(A310PaiDomMostrar), A1271PaiMesHsPExt, A1272PaiDiaHsPExt, Boolean.valueOf(A1402PaiFondoCese), A1405PaiMaxHorNor, Byte.valueOf(A1521PaiPerVacDes), Byte.valueOf(A1522PaiPerVacHas), A1814PaiFracVacAnt, Byte.valueOf(A1363PaiPromMeses), A1590PaiPromMesTCnt, Byte.valueOf(A1573PaiPromJorMeses), A1591PaiPromJorMesTCnt, Byte.valueOf(A1625PaiGuarEdadMin), Byte.valueOf(A1626PaiGuarEdadMax), Boolean.valueOf(A1736PaiExcVizzoti), A1737PaiVizzoti, Byte.valueOf(A1764PaiMinMesesVac), Short.valueOf(A1765PaiInterDiasJor), Byte.valueOf(A1793PaiTipoExpDef), Boolean.valueOf(n1252PaiReligDefault), A1252PaiReligDefault, Short.valueOf(A46PaiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
                  if ( (pr_default.getStatus(35) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pais"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1538( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1538( ) ;
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
         endLevel1538( ) ;
      }
      closeExtendedTableCursors1538( ) ;
   }

   public void deferredUpdate1538( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1538( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1538( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1538( ) ;
         afterConfirm1538( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1538( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart15240( ) ;
               while ( RcdFound240 != 0 )
               {
                  getByPrimaryKey15240( ) ;
                  delete15240( ) ;
                  scanKeyNext15240( ) ;
               }
               scanKeyEnd15240( ) ;
               scanKeyStart15196( ) ;
               while ( RcdFound196 != 0 )
               {
                  getByPrimaryKey15196( ) ;
                  delete15196( ) ;
                  scanKeyNext15196( ) ;
               }
               scanKeyEnd15196( ) ;
               scanKeyStart15169( ) ;
               while ( RcdFound169 != 0 )
               {
                  getByPrimaryKey15169( ) ;
                  delete15169( ) ;
                  scanKeyNext15169( ) ;
               }
               scanKeyEnd15169( ) ;
               scanKeyStart15168( ) ;
               while ( RcdFound168 != 0 )
               {
                  getByPrimaryKey15168( ) ;
                  delete15168( ) ;
                  scanKeyNext15168( ) ;
               }
               scanKeyEnd15168( ) ;
               scanKeyStart15167( ) ;
               while ( RcdFound167 != 0 )
               {
                  getByPrimaryKey15167( ) ;
                  delete15167( ) ;
                  scanKeyNext15167( ) ;
               }
               scanKeyEnd15167( ) ;
               scanKeyStart15164( ) ;
               while ( RcdFound164 != 0 )
               {
                  getByPrimaryKey15164( ) ;
                  delete15164( ) ;
                  scanKeyNext15164( ) ;
               }
               scanKeyEnd15164( ) ;
               scanKeyStart15155( ) ;
               while ( RcdFound155 != 0 )
               {
                  getByPrimaryKey15155( ) ;
                  delete15155( ) ;
                  scanKeyNext15155( ) ;
               }
               scanKeyEnd15155( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001538 */
                  pr_default.execute(36, new Object[] {Short.valueOf(A46PaiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
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
      sMode38 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1538( ) ;
      Gx_mode = sMode38 ;
   }

   public void onDeleteControls1538( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV29Pgmname = "Pais_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC001539 */
         pr_default.execute(37, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(37) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Tipo De Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(37);
         /* Using cursor BC001540 */
         pr_default.execute(38, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(38) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "MenuVersiones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(38);
         /* Using cursor BC001541 */
         pr_default.execute(39, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(39) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Condiciones_concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(39);
         /* Using cursor BC001542 */
         pr_default.execute(40, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(40) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(40);
         /* Using cursor BC001543 */
         pr_default.execute(41, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(41) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(41);
         /* Using cursor BC001544 */
         pr_default.execute(42, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(42) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(42);
         /* Using cursor BC001545 */
         pr_default.execute(43, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(43) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Estado", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(43);
         /* Using cursor BC001546 */
         pr_default.execute(44, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(44) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "CategoriaProvincias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(44);
         /* Using cursor BC001547 */
         pr_default.execute(45, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(45) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(45);
         /* Using cursor BC001548 */
         pr_default.execute(46, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(46) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(46);
         /* Using cursor BC001549 */
         pr_default.execute(47, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(47) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "embargabilidad", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(47);
         /* Using cursor BC001550 */
         pr_default.execute(48, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(48) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo_obligacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(48);
         /* Using cursor BC001551 */
         pr_default.execute(49, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(49) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "ART", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(49);
         /* Using cursor BC001552 */
         pr_default.execute(50, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(50) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "adicional_actividad", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(50);
         /* Using cursor BC001553 */
         pr_default.execute(51, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(51) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "User", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(51);
         /* Using cursor BC001554 */
         pr_default.execute(52, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(52) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "ActividadLaboralClasificada", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(52);
         /* Using cursor BC001555 */
         pr_default.execute(53, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(53) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Bases de cálculo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(53);
         /* Using cursor BC001556 */
         pr_default.execute(54, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(54) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Rango Etario", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(54);
         /* Using cursor BC001557 */
         pr_default.execute(55, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(55) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "horasextras_pordia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(55);
         /* Using cursor BC001558 */
         pr_default.execute(56, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(56) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Pais Origen", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(56);
         /* Using cursor BC001559 */
         pr_default.execute(57, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(57) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Pais Religion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(57);
         /* Using cursor BC001560 */
         pr_default.execute(58, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(58) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "feriado", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(58);
         /* Using cursor BC001561 */
         pr_default.execute(59, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(59) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo_feriado", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(59);
         /* Using cursor BC001562 */
         pr_default.execute(60, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(60) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Adicional", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(60);
         /* Using cursor BC001563 */
         pr_default.execute(61, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(61) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Sindicato", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(61);
         /* Using cursor BC001564 */
         pr_default.execute(62, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(62) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Convenio", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(62);
         /* Using cursor BC001565 */
         pr_default.execute(63, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(63) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "calculo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(63);
         /* Using cursor BC001566 */
         pr_default.execute(64, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(64) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Provincia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(64);
         /* Using cursor BC001567 */
         pr_default.execute(65, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(65) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")+" ("+httpContext.getMessage( "Legajo Domicilio", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(65);
         /* Using cursor BC001568 */
         pr_default.execute(66, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(66) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")+" ("+httpContext.getMessage( "Legajo Nacionalidad", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(66);
         /* Using cursor BC001569 */
         pr_default.execute(67, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(67) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(67);
      }
   }

   public void processNestedLevel15196( )
   {
      nGXsfl_196_idx = 0 ;
      while ( nGXsfl_196_idx < bcPais.getgxTv_SdtPais_Preaviso().size() )
      {
         readRow15196( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound196 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_196 != 0 ) )
         {
            standaloneNotModal15196( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert15196( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete15196( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update15196( ) ;
               }
            }
         }
         KeyVarsToRow196( ((web.SdtPais_preaviso)bcPais.getgxTv_SdtPais_Preaviso().elementAt(-1+nGXsfl_196_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_196_idx = 0 ;
         while ( nGXsfl_196_idx < bcPais.getgxTv_SdtPais_Preaviso().size() )
         {
            readRow15196( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound196 == 0 )
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
               bcPais.getgxTv_SdtPais_Preaviso().removeElement(nGXsfl_196_idx);
               nGXsfl_196_idx = (int)(nGXsfl_196_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey15196( ) ;
               VarsToRow196( ((web.SdtPais_preaviso)bcPais.getgxTv_SdtPais_Preaviso().elementAt(-1+nGXsfl_196_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll15196( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_196 = (short)(0) ;
      nIsMod_196 = (short)(0) ;
      Gxremove196 = (byte)(0) ;
   }

   public void processNestedLevel15183( )
   {
      nGXsfl_183_idx = 0 ;
      while ( nGXsfl_183_idx < bcPais.getgxTv_SdtPais_Base_calculo().size() )
      {
         readRow15183( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound183 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_183 != 0 ) )
         {
            standaloneNotModal15183( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert15183( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete15183( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update15183( ) ;
               }
            }
         }
         KeyVarsToRow183( ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_183_idx = 0 ;
         while ( nGXsfl_183_idx < bcPais.getgxTv_SdtPais_Base_calculo().size() )
         {
            readRow15183( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound183 == 0 )
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
               bcPais.getgxTv_SdtPais_Base_calculo().removeElement(nGXsfl_183_idx);
               nGXsfl_183_idx = (int)(nGXsfl_183_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey15183( ) ;
               VarsToRow183( ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll15183( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_183 = (short)(0) ;
      nIsMod_183 = (short)(0) ;
      Gxremove183 = (byte)(0) ;
   }

   public void processNestedLevel15168( )
   {
      nGXsfl_168_idx = 0 ;
      while ( nGXsfl_168_idx < bcPais.getgxTv_SdtPais_Conceptos_horanormal_jornalizados().size() )
      {
         readRow15168( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound168 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_168 != 0 ) )
         {
            standaloneNotModal15168( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert15168( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete15168( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update15168( ) ;
               }
            }
         }
         KeyVarsToRow168( ((web.SdtPais_conceptos_horanormal_jornalizados)bcPais.getgxTv_SdtPais_Conceptos_horanormal_jornalizados().elementAt(-1+nGXsfl_168_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_168_idx = 0 ;
         while ( nGXsfl_168_idx < bcPais.getgxTv_SdtPais_Conceptos_horanormal_jornalizados().size() )
         {
            readRow15168( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound168 == 0 )
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
               bcPais.getgxTv_SdtPais_Conceptos_horanormal_jornalizados().removeElement(nGXsfl_168_idx);
               nGXsfl_168_idx = (int)(nGXsfl_168_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey15168( ) ;
               VarsToRow168( ((web.SdtPais_conceptos_horanormal_jornalizados)bcPais.getgxTv_SdtPais_Conceptos_horanormal_jornalizados().elementAt(-1+nGXsfl_168_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll15168( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_168 = (short)(0) ;
      nIsMod_168 = (short)(0) ;
      Gxremove168 = (byte)(0) ;
   }

   public void processNestedLevel15167( )
   {
      nGXsfl_167_idx = 0 ;
      while ( nGXsfl_167_idx < bcPais.getgxTv_SdtPais_Conceptos_horanormal_mensualizados().size() )
      {
         readRow15167( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound167 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_167 != 0 ) )
         {
            standaloneNotModal15167( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert15167( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete15167( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update15167( ) ;
               }
            }
         }
         KeyVarsToRow167( ((web.SdtPais_conceptos_horanormal_mensualizados)bcPais.getgxTv_SdtPais_Conceptos_horanormal_mensualizados().elementAt(-1+nGXsfl_167_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_167_idx = 0 ;
         while ( nGXsfl_167_idx < bcPais.getgxTv_SdtPais_Conceptos_horanormal_mensualizados().size() )
         {
            readRow15167( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound167 == 0 )
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
               bcPais.getgxTv_SdtPais_Conceptos_horanormal_mensualizados().removeElement(nGXsfl_167_idx);
               nGXsfl_167_idx = (int)(nGXsfl_167_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey15167( ) ;
               VarsToRow167( ((web.SdtPais_conceptos_horanormal_mensualizados)bcPais.getgxTv_SdtPais_Conceptos_horanormal_mensualizados().elementAt(-1+nGXsfl_167_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll15167( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_167 = (short)(0) ;
      nIsMod_167 = (short)(0) ;
      Gxremove167 = (byte)(0) ;
   }

   public void processNestedLevel15169( )
   {
      nGXsfl_169_idx = 0 ;
      while ( nGXsfl_169_idx < bcPais.getgxTv_SdtPais_Promedio_horanormal_mensualizados().size() )
      {
         readRow15169( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound169 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_169 != 0 ) )
         {
            standaloneNotModal15169( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert15169( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete15169( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update15169( ) ;
               }
            }
         }
         KeyVarsToRow169( ((web.SdtPais_promedio_horanormal_mensualizados)bcPais.getgxTv_SdtPais_Promedio_horanormal_mensualizados().elementAt(-1+nGXsfl_169_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_169_idx = 0 ;
         while ( nGXsfl_169_idx < bcPais.getgxTv_SdtPais_Promedio_horanormal_mensualizados().size() )
         {
            readRow15169( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound169 == 0 )
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
               bcPais.getgxTv_SdtPais_Promedio_horanormal_mensualizados().removeElement(nGXsfl_169_idx);
               nGXsfl_169_idx = (int)(nGXsfl_169_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey15169( ) ;
               VarsToRow169( ((web.SdtPais_promedio_horanormal_mensualizados)bcPais.getgxTv_SdtPais_Promedio_horanormal_mensualizados().elementAt(-1+nGXsfl_169_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll15169( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_169 = (short)(0) ;
      nIsMod_169 = (short)(0) ;
      Gxremove169 = (byte)(0) ;
   }

   public void processNestedLevel15155( )
   {
      nGXsfl_155_idx = 0 ;
      while ( nGXsfl_155_idx < bcPais.getgxTv_SdtPais_Tipo_trabajo().size() )
      {
         readRow15155( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound155 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_155 != 0 ) )
         {
            standaloneNotModal15155( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert15155( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete15155( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update15155( ) ;
               }
            }
         }
         KeyVarsToRow155( ((web.SdtPais_tipo_trabajo)bcPais.getgxTv_SdtPais_Tipo_trabajo().elementAt(-1+nGXsfl_155_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_155_idx = 0 ;
         while ( nGXsfl_155_idx < bcPais.getgxTv_SdtPais_Tipo_trabajo().size() )
         {
            readRow15155( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound155 == 0 )
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
               bcPais.getgxTv_SdtPais_Tipo_trabajo().removeElement(nGXsfl_155_idx);
               nGXsfl_155_idx = (int)(nGXsfl_155_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey15155( ) ;
               VarsToRow155( ((web.SdtPais_tipo_trabajo)bcPais.getgxTv_SdtPais_Tipo_trabajo().elementAt(-1+nGXsfl_155_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll15155( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_155 = (short)(0) ;
      nIsMod_155 = (short)(0) ;
      Gxremove155 = (byte)(0) ;
   }

   public void processNestedLevel15164( )
   {
      nGXsfl_164_idx = 0 ;
      while ( nGXsfl_164_idx < bcPais.getgxTv_SdtPais_Horasextras_pordia().size() )
      {
         readRow15164( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound164 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_164 != 0 ) )
         {
            standaloneNotModal15164( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert15164( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete15164( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update15164( ) ;
               }
            }
         }
         KeyVarsToRow164( ((web.SdtPais_horasextras_pordia)bcPais.getgxTv_SdtPais_Horasextras_pordia().elementAt(-1+nGXsfl_164_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_164_idx = 0 ;
         while ( nGXsfl_164_idx < bcPais.getgxTv_SdtPais_Horasextras_pordia().size() )
         {
            readRow15164( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound164 == 0 )
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
               bcPais.getgxTv_SdtPais_Horasextras_pordia().removeElement(nGXsfl_164_idx);
               nGXsfl_164_idx = (int)(nGXsfl_164_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey15164( ) ;
               VarsToRow164( ((web.SdtPais_horasextras_pordia)bcPais.getgxTv_SdtPais_Horasextras_pordia().elementAt(-1+nGXsfl_164_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll15164( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_164 = (short)(0) ;
      nIsMod_164 = (short)(0) ;
      Gxremove164 = (byte)(0) ;
   }

   public void processNestedLevel15240( )
   {
      nGXsfl_240_idx = 0 ;
      while ( nGXsfl_240_idx < bcPais.getgxTv_SdtPais_Vacaciones().size() )
      {
         readRow15240( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound240 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_240 != 0 ) )
         {
            standaloneNotModal15240( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert15240( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete15240( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update15240( ) ;
               }
            }
         }
         KeyVarsToRow240( ((web.SdtPais_Vacaciones)bcPais.getgxTv_SdtPais_Vacaciones().elementAt(-1+nGXsfl_240_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_240_idx = 0 ;
         while ( nGXsfl_240_idx < bcPais.getgxTv_SdtPais_Vacaciones().size() )
         {
            readRow15240( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound240 == 0 )
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
               bcPais.getgxTv_SdtPais_Vacaciones().removeElement(nGXsfl_240_idx);
               nGXsfl_240_idx = (int)(nGXsfl_240_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey15240( ) ;
               VarsToRow240( ((web.SdtPais_Vacaciones)bcPais.getgxTv_SdtPais_Vacaciones().elementAt(-1+nGXsfl_240_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll15240( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_240 = (short)(0) ;
      nIsMod_240 = (short)(0) ;
      Gxremove240 = (byte)(0) ;
   }

   public void processLevel1538( )
   {
      /* Save parent mode. */
      sMode38 = Gx_mode ;
      processNestedLevel15196( ) ;
      processNestedLevel15183( ) ;
      processNestedLevel15168( ) ;
      processNestedLevel15167( ) ;
      processNestedLevel15169( ) ;
      processNestedLevel15155( ) ;
      processNestedLevel15164( ) ;
      processNestedLevel15240( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode38 ;
      /* ' Update level parameters */
   }

   public void endLevel1538( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(33);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1538( ) ;
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

   public void scanKeyStart1538( )
   {
      /* Scan By routine */
      /* Using cursor BC001570 */
      pr_default.execute(68, new Object[] {Short.valueOf(A46PaiCod)});
      RcdFound38 = (short)(0) ;
      if ( (pr_default.getStatus(68) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A46PaiCod = BC001570_A46PaiCod[0] ;
         A312PaiNom = BC001570_A312PaiNom[0] ;
         A311PaiNacMostrar = BC001570_A311PaiNacMostrar[0] ;
         A310PaiDomMostrar = BC001570_A310PaiDomMostrar[0] ;
         A1271PaiMesHsPExt = BC001570_A1271PaiMesHsPExt[0] ;
         A1272PaiDiaHsPExt = BC001570_A1272PaiDiaHsPExt[0] ;
         A1402PaiFondoCese = BC001570_A1402PaiFondoCese[0] ;
         A1405PaiMaxHorNor = BC001570_A1405PaiMaxHorNor[0] ;
         A1521PaiPerVacDes = BC001570_A1521PaiPerVacDes[0] ;
         A1522PaiPerVacHas = BC001570_A1522PaiPerVacHas[0] ;
         A1814PaiFracVacAnt = BC001570_A1814PaiFracVacAnt[0] ;
         A1363PaiPromMeses = BC001570_A1363PaiPromMeses[0] ;
         A1590PaiPromMesTCnt = BC001570_A1590PaiPromMesTCnt[0] ;
         A1573PaiPromJorMeses = BC001570_A1573PaiPromJorMeses[0] ;
         A1591PaiPromJorMesTCnt = BC001570_A1591PaiPromJorMesTCnt[0] ;
         A1625PaiGuarEdadMin = BC001570_A1625PaiGuarEdadMin[0] ;
         A1626PaiGuarEdadMax = BC001570_A1626PaiGuarEdadMax[0] ;
         A1736PaiExcVizzoti = BC001570_A1736PaiExcVizzoti[0] ;
         A1737PaiVizzoti = BC001570_A1737PaiVizzoti[0] ;
         A1764PaiMinMesesVac = BC001570_A1764PaiMinMesesVac[0] ;
         A1765PaiInterDiasJor = BC001570_A1765PaiInterDiasJor[0] ;
         A1793PaiTipoExpDef = BC001570_A1793PaiTipoExpDef[0] ;
         A1252PaiReligDefault = BC001570_A1252PaiReligDefault[0] ;
         n1252PaiReligDefault = BC001570_n1252PaiReligDefault[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1538( )
   {
      /* Scan next routine */
      pr_default.readNext(68);
      RcdFound38 = (short)(0) ;
      scanKeyLoad1538( ) ;
   }

   public void scanKeyLoad1538( )
   {
      sMode38 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(68) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A46PaiCod = BC001570_A46PaiCod[0] ;
         A312PaiNom = BC001570_A312PaiNom[0] ;
         A311PaiNacMostrar = BC001570_A311PaiNacMostrar[0] ;
         A310PaiDomMostrar = BC001570_A310PaiDomMostrar[0] ;
         A1271PaiMesHsPExt = BC001570_A1271PaiMesHsPExt[0] ;
         A1272PaiDiaHsPExt = BC001570_A1272PaiDiaHsPExt[0] ;
         A1402PaiFondoCese = BC001570_A1402PaiFondoCese[0] ;
         A1405PaiMaxHorNor = BC001570_A1405PaiMaxHorNor[0] ;
         A1521PaiPerVacDes = BC001570_A1521PaiPerVacDes[0] ;
         A1522PaiPerVacHas = BC001570_A1522PaiPerVacHas[0] ;
         A1814PaiFracVacAnt = BC001570_A1814PaiFracVacAnt[0] ;
         A1363PaiPromMeses = BC001570_A1363PaiPromMeses[0] ;
         A1590PaiPromMesTCnt = BC001570_A1590PaiPromMesTCnt[0] ;
         A1573PaiPromJorMeses = BC001570_A1573PaiPromJorMeses[0] ;
         A1591PaiPromJorMesTCnt = BC001570_A1591PaiPromJorMesTCnt[0] ;
         A1625PaiGuarEdadMin = BC001570_A1625PaiGuarEdadMin[0] ;
         A1626PaiGuarEdadMax = BC001570_A1626PaiGuarEdadMax[0] ;
         A1736PaiExcVizzoti = BC001570_A1736PaiExcVizzoti[0] ;
         A1737PaiVizzoti = BC001570_A1737PaiVizzoti[0] ;
         A1764PaiMinMesesVac = BC001570_A1764PaiMinMesesVac[0] ;
         A1765PaiInterDiasJor = BC001570_A1765PaiInterDiasJor[0] ;
         A1793PaiTipoExpDef = BC001570_A1793PaiTipoExpDef[0] ;
         A1252PaiReligDefault = BC001570_A1252PaiReligDefault[0] ;
         n1252PaiReligDefault = BC001570_n1252PaiReligDefault[0] ;
      }
      Gx_mode = sMode38 ;
   }

   public void scanKeyEnd1538( )
   {
      pr_default.close(68);
   }

   public void afterConfirm1538( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1538( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1538( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1538( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1538( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1538( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1538( )
   {
   }

   public void zm15196( int GX_JID )
   {
      if ( ( GX_JID == 23 ) || ( GX_JID == 0 ) )
      {
         Z1537PaiPreAviCant = A1537PaiPreAviCant ;
         Z1538PaiPreAviDur = A1538PaiPreAviDur ;
      }
      if ( GX_JID == -23 )
      {
         Z46PaiCod = A46PaiCod ;
         Z1535PaiAntMayCant = A1535PaiAntMayCant ;
         Z1536PaiAntMayDur = A1536PaiAntMayDur ;
         Z1537PaiPreAviCant = A1537PaiPreAviCant ;
         Z1538PaiPreAviDur = A1538PaiPreAviDur ;
      }
   }

   public void standaloneNotModal15196( )
   {
   }

   public void standaloneModal15196( )
   {
   }

   public void load15196( )
   {
      /* Using cursor BC001571 */
      pr_default.execute(69, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1535PaiAntMayCant), A1536PaiAntMayDur});
      if ( (pr_default.getStatus(69) != 101) )
      {
         RcdFound196 = (short)(1) ;
         A1537PaiPreAviCant = BC001571_A1537PaiPreAviCant[0] ;
         A1538PaiPreAviDur = BC001571_A1538PaiPreAviDur[0] ;
         zm15196( -23) ;
      }
      pr_default.close(69);
      onLoadActions15196( ) ;
   }

   public void onLoadActions15196( )
   {
   }

   public void checkExtendedTable15196( )
   {
      nIsDirty_196 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal15196( ) ;
      Gx_BScreen = (byte)(0) ;
      if ( ! ( ( GXutil.strcmp(A1536PaiAntMayDur, "años") == 0 ) || ( GXutil.strcmp(A1536PaiAntMayDur, "meses") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "años/meses", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1538PaiPreAviDur, "dias") == 0 ) || ( GXutil.strcmp(A1538PaiPreAviDur, "meses") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "dias/meses", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors15196( )
   {
   }

   public void enableDisable15196( )
   {
   }

   public void getKey15196( )
   {
      /* Using cursor BC001572 */
      pr_default.execute(70, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1535PaiAntMayCant), A1536PaiAntMayDur});
      if ( (pr_default.getStatus(70) != 101) )
      {
         RcdFound196 = (short)(1) ;
      }
      else
      {
         RcdFound196 = (short)(0) ;
      }
      pr_default.close(70);
   }

   public void getByPrimaryKey15196( )
   {
      /* Using cursor BC001573 */
      pr_default.execute(71, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1535PaiAntMayCant), A1536PaiAntMayDur});
      if ( (pr_default.getStatus(71) != 101) )
      {
         zm15196( 23) ;
         RcdFound196 = (short)(1) ;
         initializeNonKey15196( ) ;
         A1535PaiAntMayCant = BC001573_A1535PaiAntMayCant[0] ;
         A1536PaiAntMayDur = BC001573_A1536PaiAntMayDur[0] ;
         A1537PaiPreAviCant = BC001573_A1537PaiPreAviCant[0] ;
         A1538PaiPreAviDur = BC001573_A1538PaiPreAviDur[0] ;
         Z46PaiCod = A46PaiCod ;
         Z1535PaiAntMayCant = A1535PaiAntMayCant ;
         Z1536PaiAntMayDur = A1536PaiAntMayDur ;
         sMode196 = Gx_mode ;
         Gx_mode = "DSP" ;
         load15196( ) ;
         Gx_mode = sMode196 ;
      }
      else
      {
         RcdFound196 = (short)(0) ;
         initializeNonKey15196( ) ;
         sMode196 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal15196( ) ;
         Gx_mode = sMode196 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes15196( ) ;
      }
      pr_default.close(71);
   }

   public void checkOptimisticConcurrency15196( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001574 */
         pr_default.execute(72, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1535PaiAntMayCant), A1536PaiAntMayDur});
         if ( (pr_default.getStatus(72) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paispreaviso"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(72) == 101) || ( Z1537PaiPreAviCant != BC001574_A1537PaiPreAviCant[0] ) || ( GXutil.strcmp(Z1538PaiPreAviDur, BC001574_A1538PaiPreAviDur[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Paispreaviso"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert15196( )
   {
      beforeValidate15196( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15196( ) ;
      }
      if ( AnyError == 0 )
      {
         zm15196( 0) ;
         checkOptimisticConcurrency15196( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15196( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert15196( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001575 */
                  pr_default.execute(73, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1535PaiAntMayCant), A1536PaiAntMayDur, Byte.valueOf(A1537PaiPreAviCant), A1538PaiPreAviDur});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paispreaviso");
                  if ( (pr_default.getStatus(73) == 1) )
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
            load15196( ) ;
         }
         endLevel15196( ) ;
      }
      closeExtendedTableCursors15196( ) ;
   }

   public void update15196( )
   {
      beforeValidate15196( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15196( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15196( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15196( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate15196( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001576 */
                  pr_default.execute(74, new Object[] {Byte.valueOf(A1537PaiPreAviCant), A1538PaiPreAviDur, Short.valueOf(A46PaiCod), Byte.valueOf(A1535PaiAntMayCant), A1536PaiAntMayDur});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paispreaviso");
                  if ( (pr_default.getStatus(74) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paispreaviso"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate15196( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey15196( ) ;
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
         endLevel15196( ) ;
      }
      closeExtendedTableCursors15196( ) ;
   }

   public void deferredUpdate15196( )
   {
   }

   public void delete15196( )
   {
      Gx_mode = "DLT" ;
      beforeValidate15196( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15196( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls15196( ) ;
         afterConfirm15196( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete15196( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001577 */
               pr_default.execute(75, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1535PaiAntMayCant), A1536PaiAntMayDur});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Paispreaviso");
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
      sMode196 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel15196( ) ;
      Gx_mode = sMode196 ;
   }

   public void onDeleteControls15196( )
   {
      standaloneModal15196( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel15196( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(72);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart15196( )
   {
      /* Scan By routine */
      /* Using cursor BC001578 */
      pr_default.execute(76, new Object[] {Short.valueOf(A46PaiCod)});
      RcdFound196 = (short)(0) ;
      if ( (pr_default.getStatus(76) != 101) )
      {
         RcdFound196 = (short)(1) ;
         A1535PaiAntMayCant = BC001578_A1535PaiAntMayCant[0] ;
         A1536PaiAntMayDur = BC001578_A1536PaiAntMayDur[0] ;
         A1537PaiPreAviCant = BC001578_A1537PaiPreAviCant[0] ;
         A1538PaiPreAviDur = BC001578_A1538PaiPreAviDur[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext15196( )
   {
      /* Scan next routine */
      pr_default.readNext(76);
      RcdFound196 = (short)(0) ;
      scanKeyLoad15196( ) ;
   }

   public void scanKeyLoad15196( )
   {
      sMode196 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(76) != 101) )
      {
         RcdFound196 = (short)(1) ;
         A1535PaiAntMayCant = BC001578_A1535PaiAntMayCant[0] ;
         A1536PaiAntMayDur = BC001578_A1536PaiAntMayDur[0] ;
         A1537PaiPreAviCant = BC001578_A1537PaiPreAviCant[0] ;
         A1538PaiPreAviDur = BC001578_A1538PaiPreAviDur[0] ;
      }
      Gx_mode = sMode196 ;
   }

   public void scanKeyEnd15196( )
   {
      pr_default.close(76);
   }

   public void afterConfirm15196( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert15196( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate15196( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete15196( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete15196( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate15196( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes15196( )
   {
   }

   public void send_integrity_lvl_hashes15196( )
   {
   }

   public void zm15183( int GX_JID )
   {
      if ( ( GX_JID == 24 ) || ( GX_JID == 0 ) )
      {
         Z1444PaiBasePlus = A1444PaiBasePlus ;
         Z1629PaiLicDLim = A1629PaiLicDLim ;
         Z1630PaiLicDSeman = A1630PaiLicDSeman ;
         Z1631PaiLicDMes = A1631PaiLicDMes ;
         Z1632PaiLicDSemes = A1632PaiLicDSemes ;
         Z1633PaiLicDAnual = A1633PaiLicDAnual ;
         Z1634PaiLicAdju = A1634PaiLicAdju ;
         Z1635PaiLicAdjuObl = A1635PaiLicAdjuObl ;
         Z1636PaiLicNecAut = A1636PaiLicNecAut ;
         Z1637PaiLicIngMot = A1637PaiLicIngMot ;
         Z1638PaiLicMotObl = A1638PaiLicMotObl ;
         Z1451PaiBasePromCnt1 = A1451PaiBasePromCnt1 ;
         Z1452PaiBasePromCnt2 = A1452PaiBasePromCnt2 ;
         Z1453PaiBasePromTCnt = A1453PaiBasePromTCnt ;
      }
      if ( GX_JID == -24 )
      {
         Z46PaiCod = A46PaiCod ;
         Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
         Z1441PaiBaseTipo = A1441PaiBaseTipo ;
         Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
         Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
         Z1444PaiBasePlus = A1444PaiBasePlus ;
         Z1629PaiLicDLim = A1629PaiLicDLim ;
         Z1630PaiLicDSeman = A1630PaiLicDSeman ;
         Z1631PaiLicDMes = A1631PaiLicDMes ;
         Z1632PaiLicDSemes = A1632PaiLicDSemes ;
         Z1633PaiLicDAnual = A1633PaiLicDAnual ;
         Z1634PaiLicAdju = A1634PaiLicAdju ;
         Z1635PaiLicAdjuObl = A1635PaiLicAdjuObl ;
         Z1636PaiLicNecAut = A1636PaiLicNecAut ;
         Z1637PaiLicIngMot = A1637PaiLicIngMot ;
         Z1638PaiLicMotObl = A1638PaiLicMotObl ;
         Z1451PaiBasePromCnt1 = A1451PaiBasePromCnt1 ;
         Z1452PaiBasePromCnt2 = A1452PaiBasePromCnt2 ;
         Z1453PaiBasePromTCnt = A1453PaiBasePromTCnt ;
      }
   }

   public void standaloneNotModal15183( )
   {
   }

   public void standaloneModal15183( )
   {
   }

   public void load15183( )
   {
      /* Using cursor BC001579 */
      pr_default.execute(77, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
      if ( (pr_default.getStatus(77) != 101) )
      {
         RcdFound183 = (short)(1) ;
         A1444PaiBasePlus = BC001579_A1444PaiBasePlus[0] ;
         A1629PaiLicDLim = BC001579_A1629PaiLicDLim[0] ;
         A1630PaiLicDSeman = BC001579_A1630PaiLicDSeman[0] ;
         A1631PaiLicDMes = BC001579_A1631PaiLicDMes[0] ;
         A1632PaiLicDSemes = BC001579_A1632PaiLicDSemes[0] ;
         A1633PaiLicDAnual = BC001579_A1633PaiLicDAnual[0] ;
         A1634PaiLicAdju = BC001579_A1634PaiLicAdju[0] ;
         A1635PaiLicAdjuObl = BC001579_A1635PaiLicAdjuObl[0] ;
         A1636PaiLicNecAut = BC001579_A1636PaiLicNecAut[0] ;
         A1637PaiLicIngMot = BC001579_A1637PaiLicIngMot[0] ;
         A1638PaiLicMotObl = BC001579_A1638PaiLicMotObl[0] ;
         A1451PaiBasePromCnt1 = BC001579_A1451PaiBasePromCnt1[0] ;
         A1452PaiBasePromCnt2 = BC001579_A1452PaiBasePromCnt2[0] ;
         A1453PaiBasePromTCnt = BC001579_A1453PaiBasePromTCnt[0] ;
         zm15183( -24) ;
      }
      pr_default.close(77);
      onLoadActions15183( ) ;
   }

   public void onLoadActions15183( )
   {
   }

   public void checkExtendedTable15183( )
   {
      nIsDirty_183 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal15183( ) ;
      Gx_BScreen = (byte)(0) ;
      if ( ! ( ( A1440PaiBaseClaseLeg == 1 ) || ( A1440PaiBaseClaseLeg == 2 ) || ( A1440PaiBaseClaseLeg == 3 ) || ( A1440PaiBaseClaseLeg == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Clase de legajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1441PaiBaseTipo, "licencia") == 0 ) || ( GXutil.strcmp(A1441PaiBaseTipo, "feriado") == 0 ) || ( GXutil.strcmp(A1441PaiBaseTipo, "horaNormal") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1453PaiBasePromTCnt, "dias") == 0 ) || ( GXutil.strcmp(A1453PaiBasePromTCnt, "meses") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Días o Meses", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors15183( )
   {
   }

   public void enableDisable15183( )
   {
   }

   public void getKey15183( )
   {
      /* Using cursor BC001580 */
      pr_default.execute(78, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
      if ( (pr_default.getStatus(78) != 101) )
      {
         RcdFound183 = (short)(1) ;
      }
      else
      {
         RcdFound183 = (short)(0) ;
      }
      pr_default.close(78);
   }

   public void getByPrimaryKey15183( )
   {
      /* Using cursor BC001581 */
      pr_default.execute(79, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
      if ( (pr_default.getStatus(79) != 101) )
      {
         zm15183( 24) ;
         RcdFound183 = (short)(1) ;
         initializeNonKey15183( ) ;
         A1440PaiBaseClaseLeg = BC001581_A1440PaiBaseClaseLeg[0] ;
         A1441PaiBaseTipo = BC001581_A1441PaiBaseTipo[0] ;
         A1442PaiBaseCod1 = BC001581_A1442PaiBaseCod1[0] ;
         A1443PaiBaseCod2 = BC001581_A1443PaiBaseCod2[0] ;
         A1444PaiBasePlus = BC001581_A1444PaiBasePlus[0] ;
         A1629PaiLicDLim = BC001581_A1629PaiLicDLim[0] ;
         A1630PaiLicDSeman = BC001581_A1630PaiLicDSeman[0] ;
         A1631PaiLicDMes = BC001581_A1631PaiLicDMes[0] ;
         A1632PaiLicDSemes = BC001581_A1632PaiLicDSemes[0] ;
         A1633PaiLicDAnual = BC001581_A1633PaiLicDAnual[0] ;
         A1634PaiLicAdju = BC001581_A1634PaiLicAdju[0] ;
         A1635PaiLicAdjuObl = BC001581_A1635PaiLicAdjuObl[0] ;
         A1636PaiLicNecAut = BC001581_A1636PaiLicNecAut[0] ;
         A1637PaiLicIngMot = BC001581_A1637PaiLicIngMot[0] ;
         A1638PaiLicMotObl = BC001581_A1638PaiLicMotObl[0] ;
         A1451PaiBasePromCnt1 = BC001581_A1451PaiBasePromCnt1[0] ;
         A1452PaiBasePromCnt2 = BC001581_A1452PaiBasePromCnt2[0] ;
         A1453PaiBasePromTCnt = BC001581_A1453PaiBasePromTCnt[0] ;
         Z46PaiCod = A46PaiCod ;
         Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
         Z1441PaiBaseTipo = A1441PaiBaseTipo ;
         Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
         Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
         sMode183 = Gx_mode ;
         Gx_mode = "DSP" ;
         load15183( ) ;
         Gx_mode = sMode183 ;
      }
      else
      {
         RcdFound183 = (short)(0) ;
         initializeNonKey15183( ) ;
         sMode183 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal15183( ) ;
         Gx_mode = sMode183 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes15183( ) ;
      }
      pr_default.close(79);
   }

   public void checkOptimisticConcurrency15183( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001582 */
         pr_default.execute(80, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
         if ( (pr_default.getStatus(80) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paisbase_calculo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(80) == 101) || ( DecimalUtil.compareTo(Z1444PaiBasePlus, BC001582_A1444PaiBasePlus[0]) != 0 ) || ( Z1629PaiLicDLim != BC001582_A1629PaiLicDLim[0] ) || ( Z1630PaiLicDSeman != BC001582_A1630PaiLicDSeman[0] ) || ( Z1631PaiLicDMes != BC001582_A1631PaiLicDMes[0] ) || ( Z1632PaiLicDSemes != BC001582_A1632PaiLicDSemes[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1633PaiLicDAnual != BC001582_A1633PaiLicDAnual[0] ) || ( Z1634PaiLicAdju != BC001582_A1634PaiLicAdju[0] ) || ( Z1635PaiLicAdjuObl != BC001582_A1635PaiLicAdjuObl[0] ) || ( Z1636PaiLicNecAut != BC001582_A1636PaiLicNecAut[0] ) || ( Z1637PaiLicIngMot != BC001582_A1637PaiLicIngMot[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1638PaiLicMotObl != BC001582_A1638PaiLicMotObl[0] ) || ( Z1451PaiBasePromCnt1 != BC001582_A1451PaiBasePromCnt1[0] ) || ( Z1452PaiBasePromCnt2 != BC001582_A1452PaiBasePromCnt2[0] ) || ( GXutil.strcmp(Z1453PaiBasePromTCnt, BC001582_A1453PaiBasePromTCnt[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Paisbase_calculo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert15183( )
   {
      beforeValidate15183( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15183( ) ;
      }
      if ( AnyError == 0 )
      {
         zm15183( 0) ;
         checkOptimisticConcurrency15183( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15183( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert15183( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001583 */
                  pr_default.execute(81, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, A1444PaiBasePlus, Short.valueOf(A1629PaiLicDLim), Byte.valueOf(A1630PaiLicDSeman), Byte.valueOf(A1631PaiLicDMes), Short.valueOf(A1632PaiLicDSemes), Short.valueOf(A1633PaiLicDAnual), Boolean.valueOf(A1634PaiLicAdju), Boolean.valueOf(A1635PaiLicAdjuObl), Boolean.valueOf(A1636PaiLicNecAut), Boolean.valueOf(A1637PaiLicIngMot), Boolean.valueOf(A1638PaiLicMotObl), Short.valueOf(A1451PaiBasePromCnt1), Short.valueOf(A1452PaiBasePromCnt2), A1453PaiBasePromTCnt});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisbase_calculo");
                  if ( (pr_default.getStatus(81) == 1) )
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
                        processLevel15183( ) ;
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
            load15183( ) ;
         }
         endLevel15183( ) ;
      }
      closeExtendedTableCursors15183( ) ;
   }

   public void update15183( )
   {
      beforeValidate15183( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15183( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15183( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15183( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate15183( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001584 */
                  pr_default.execute(82, new Object[] {A1444PaiBasePlus, Short.valueOf(A1629PaiLicDLim), Byte.valueOf(A1630PaiLicDSeman), Byte.valueOf(A1631PaiLicDMes), Short.valueOf(A1632PaiLicDSemes), Short.valueOf(A1633PaiLicDAnual), Boolean.valueOf(A1634PaiLicAdju), Boolean.valueOf(A1635PaiLicAdjuObl), Boolean.valueOf(A1636PaiLicNecAut), Boolean.valueOf(A1637PaiLicIngMot), Boolean.valueOf(A1638PaiLicMotObl), Short.valueOf(A1451PaiBasePromCnt1), Short.valueOf(A1452PaiBasePromCnt2), A1453PaiBasePromTCnt, Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisbase_calculo");
                  if ( (pr_default.getStatus(82) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paisbase_calculo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate15183( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel15183( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey15183( ) ;
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
         endLevel15183( ) ;
      }
      closeExtendedTableCursors15183( ) ;
   }

   public void deferredUpdate15183( )
   {
   }

   public void delete15183( )
   {
      Gx_mode = "DLT" ;
      beforeValidate15183( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15183( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls15183( ) ;
         afterConfirm15183( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete15183( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart15185( ) ;
               while ( RcdFound185 != 0 )
               {
                  getByPrimaryKey15185( ) ;
                  delete15185( ) ;
                  scanKeyNext15185( ) ;
               }
               scanKeyEnd15185( ) ;
               scanKeyStart15184( ) ;
               while ( RcdFound184 != 0 )
               {
                  getByPrimaryKey15184( ) ;
                  delete15184( ) ;
                  scanKeyNext15184( ) ;
               }
               scanKeyEnd15184( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001585 */
                  pr_default.execute(83, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisbase_calculo");
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
      sMode183 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel15183( ) ;
      Gx_mode = sMode183 ;
   }

   public void onDeleteControls15183( )
   {
      standaloneModal15183( ) ;
      /* No delete mode formulas found. */
   }

   public void processNestedLevel15184( )
   {
      nGXsfl_184_idx = 0 ;
      while ( nGXsfl_184_idx < ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Actual().size() )
      {
         readRow15184( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound184 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_184 != 0 ) )
         {
            standaloneNotModal15184( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert15184( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete15184( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update15184( ) ;
               }
            }
         }
         KeyVarsToRow184( ((web.SdtPais_base_calculo_actual)((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Actual().elementAt(-1+nGXsfl_184_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_184_idx = 0 ;
         while ( nGXsfl_184_idx < ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Actual().size() )
         {
            readRow15184( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound184 == 0 )
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
               ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Actual().removeElement(nGXsfl_184_idx);
               nGXsfl_184_idx = (int)(nGXsfl_184_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey15184( ) ;
               VarsToRow184( ((web.SdtPais_base_calculo_actual)((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Actual().elementAt(-1+nGXsfl_184_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll15184( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_184 = (short)(0) ;
      nIsMod_184 = (short)(0) ;
      Gxremove184 = (byte)(0) ;
   }

   public void processNestedLevel15185( )
   {
      nGXsfl_185_idx = 0 ;
      while ( nGXsfl_185_idx < ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Promedio().size() )
      {
         readRow15185( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound185 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_185 != 0 ) )
         {
            standaloneNotModal15185( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert15185( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete15185( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update15185( ) ;
               }
            }
         }
         KeyVarsToRow185( ((web.SdtPais_base_calculo_promedio)((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Promedio().elementAt(-1+nGXsfl_185_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_185_idx = 0 ;
         while ( nGXsfl_185_idx < ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Promedio().size() )
         {
            readRow15185( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound185 == 0 )
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
               ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Promedio().removeElement(nGXsfl_185_idx);
               nGXsfl_185_idx = (int)(nGXsfl_185_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey15185( ) ;
               VarsToRow185( ((web.SdtPais_base_calculo_promedio)((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Promedio().elementAt(-1+nGXsfl_185_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll15185( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_185 = (short)(0) ;
      nIsMod_185 = (short)(0) ;
      Gxremove185 = (byte)(0) ;
   }

   public void processLevel15183( )
   {
      /* Save parent mode. */
      sMode183 = Gx_mode ;
      processNestedLevel15184( ) ;
      processNestedLevel15185( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode183 ;
      /* ' Update level parameters */
   }

   public void endLevel15183( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(80);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart15183( )
   {
      /* Scan By routine */
      /* Using cursor BC001586 */
      pr_default.execute(84, new Object[] {Short.valueOf(A46PaiCod)});
      RcdFound183 = (short)(0) ;
      if ( (pr_default.getStatus(84) != 101) )
      {
         RcdFound183 = (short)(1) ;
         A1440PaiBaseClaseLeg = BC001586_A1440PaiBaseClaseLeg[0] ;
         A1441PaiBaseTipo = BC001586_A1441PaiBaseTipo[0] ;
         A1442PaiBaseCod1 = BC001586_A1442PaiBaseCod1[0] ;
         A1443PaiBaseCod2 = BC001586_A1443PaiBaseCod2[0] ;
         A1444PaiBasePlus = BC001586_A1444PaiBasePlus[0] ;
         A1629PaiLicDLim = BC001586_A1629PaiLicDLim[0] ;
         A1630PaiLicDSeman = BC001586_A1630PaiLicDSeman[0] ;
         A1631PaiLicDMes = BC001586_A1631PaiLicDMes[0] ;
         A1632PaiLicDSemes = BC001586_A1632PaiLicDSemes[0] ;
         A1633PaiLicDAnual = BC001586_A1633PaiLicDAnual[0] ;
         A1634PaiLicAdju = BC001586_A1634PaiLicAdju[0] ;
         A1635PaiLicAdjuObl = BC001586_A1635PaiLicAdjuObl[0] ;
         A1636PaiLicNecAut = BC001586_A1636PaiLicNecAut[0] ;
         A1637PaiLicIngMot = BC001586_A1637PaiLicIngMot[0] ;
         A1638PaiLicMotObl = BC001586_A1638PaiLicMotObl[0] ;
         A1451PaiBasePromCnt1 = BC001586_A1451PaiBasePromCnt1[0] ;
         A1452PaiBasePromCnt2 = BC001586_A1452PaiBasePromCnt2[0] ;
         A1453PaiBasePromTCnt = BC001586_A1453PaiBasePromTCnt[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext15183( )
   {
      /* Scan next routine */
      pr_default.readNext(84);
      RcdFound183 = (short)(0) ;
      scanKeyLoad15183( ) ;
   }

   public void scanKeyLoad15183( )
   {
      sMode183 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(84) != 101) )
      {
         RcdFound183 = (short)(1) ;
         A1440PaiBaseClaseLeg = BC001586_A1440PaiBaseClaseLeg[0] ;
         A1441PaiBaseTipo = BC001586_A1441PaiBaseTipo[0] ;
         A1442PaiBaseCod1 = BC001586_A1442PaiBaseCod1[0] ;
         A1443PaiBaseCod2 = BC001586_A1443PaiBaseCod2[0] ;
         A1444PaiBasePlus = BC001586_A1444PaiBasePlus[0] ;
         A1629PaiLicDLim = BC001586_A1629PaiLicDLim[0] ;
         A1630PaiLicDSeman = BC001586_A1630PaiLicDSeman[0] ;
         A1631PaiLicDMes = BC001586_A1631PaiLicDMes[0] ;
         A1632PaiLicDSemes = BC001586_A1632PaiLicDSemes[0] ;
         A1633PaiLicDAnual = BC001586_A1633PaiLicDAnual[0] ;
         A1634PaiLicAdju = BC001586_A1634PaiLicAdju[0] ;
         A1635PaiLicAdjuObl = BC001586_A1635PaiLicAdjuObl[0] ;
         A1636PaiLicNecAut = BC001586_A1636PaiLicNecAut[0] ;
         A1637PaiLicIngMot = BC001586_A1637PaiLicIngMot[0] ;
         A1638PaiLicMotObl = BC001586_A1638PaiLicMotObl[0] ;
         A1451PaiBasePromCnt1 = BC001586_A1451PaiBasePromCnt1[0] ;
         A1452PaiBasePromCnt2 = BC001586_A1452PaiBasePromCnt2[0] ;
         A1453PaiBasePromTCnt = BC001586_A1453PaiBasePromTCnt[0] ;
      }
      Gx_mode = sMode183 ;
   }

   public void scanKeyEnd15183( )
   {
      pr_default.close(84);
   }

   public void afterConfirm15183( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert15183( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate15183( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete15183( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete15183( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate15183( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes15183( )
   {
   }

   public void zm15184( int GX_JID )
   {
      if ( ( GX_JID == 25 ) || ( GX_JID == 0 ) )
      {
         Z1447PaiBaseConHabitual = A1447PaiBaseConHabitual ;
      }
      if ( ( GX_JID == 26 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -25 )
      {
         Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
         Z1441PaiBaseTipo = A1441PaiBaseTipo ;
         Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
         Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
         Z1447PaiBaseConHabitual = A1447PaiBaseConHabitual ;
         Z1445PaiBaseCliCod = A1445PaiBaseCliCod ;
         Z1446PaiBaseConCodigo = A1446PaiBaseConCodigo ;
         Z46PaiCod = A46PaiCod ;
      }
   }

   public void standaloneNotModal15184( )
   {
   }

   public void standaloneModal15184( )
   {
   }

   public void load15184( )
   {
      /* Using cursor BC001587 */
      pr_default.execute(85, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, Integer.valueOf(A1445PaiBaseCliCod), A1446PaiBaseConCodigo});
      if ( (pr_default.getStatus(85) != 101) )
      {
         RcdFound184 = (short)(1) ;
         A1447PaiBaseConHabitual = BC001587_A1447PaiBaseConHabitual[0] ;
         zm15184( -25) ;
      }
      pr_default.close(85);
      onLoadActions15184( ) ;
   }

   public void onLoadActions15184( )
   {
   }

   public void checkExtendedTable15184( )
   {
      nIsDirty_184 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal15184( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC001588 */
      pr_default.execute(86, new Object[] {Integer.valueOf(A1445PaiBaseCliCod), A1446PaiBaseConCodigo});
      if ( (pr_default.getStatus(86) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais Conceptos Base", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAIBASECONCODIGO");
         AnyError = (short)(1) ;
      }
      pr_default.close(86);
   }

   public void closeExtendedTableCursors15184( )
   {
      pr_default.close(86);
   }

   public void enableDisable15184( )
   {
   }

   public void getKey15184( )
   {
      /* Using cursor BC001589 */
      pr_default.execute(87, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, Integer.valueOf(A1445PaiBaseCliCod), A1446PaiBaseConCodigo});
      if ( (pr_default.getStatus(87) != 101) )
      {
         RcdFound184 = (short)(1) ;
      }
      else
      {
         RcdFound184 = (short)(0) ;
      }
      pr_default.close(87);
   }

   public void getByPrimaryKey15184( )
   {
      /* Using cursor BC001590 */
      pr_default.execute(88, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, Integer.valueOf(A1445PaiBaseCliCod), A1446PaiBaseConCodigo});
      if ( (pr_default.getStatus(88) != 101) )
      {
         zm15184( 25) ;
         RcdFound184 = (short)(1) ;
         initializeNonKey15184( ) ;
         A1447PaiBaseConHabitual = BC001590_A1447PaiBaseConHabitual[0] ;
         A1445PaiBaseCliCod = BC001590_A1445PaiBaseCliCod[0] ;
         A1446PaiBaseConCodigo = BC001590_A1446PaiBaseConCodigo[0] ;
         Z46PaiCod = A46PaiCod ;
         Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
         Z1441PaiBaseTipo = A1441PaiBaseTipo ;
         Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
         Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
         Z1445PaiBaseCliCod = A1445PaiBaseCliCod ;
         Z1446PaiBaseConCodigo = A1446PaiBaseConCodigo ;
         sMode184 = Gx_mode ;
         Gx_mode = "DSP" ;
         load15184( ) ;
         Gx_mode = sMode184 ;
      }
      else
      {
         RcdFound184 = (short)(0) ;
         initializeNonKey15184( ) ;
         sMode184 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal15184( ) ;
         Gx_mode = sMode184 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes15184( ) ;
      }
      pr_default.close(88);
   }

   public void checkOptimisticConcurrency15184( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001591 */
         pr_default.execute(89, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, Integer.valueOf(A1445PaiBaseCliCod), A1446PaiBaseConCodigo});
         if ( (pr_default.getStatus(89) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paisbase_calculoactual"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(89) == 101) || ( Z1447PaiBaseConHabitual != BC001591_A1447PaiBaseConHabitual[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Paisbase_calculoactual"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert15184( )
   {
      beforeValidate15184( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15184( ) ;
      }
      if ( AnyError == 0 )
      {
         zm15184( 0) ;
         checkOptimisticConcurrency15184( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15184( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert15184( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001592 */
                  pr_default.execute(90, new Object[] {Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, Boolean.valueOf(A1447PaiBaseConHabitual), Integer.valueOf(A1445PaiBaseCliCod), A1446PaiBaseConCodigo, Short.valueOf(A46PaiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisbase_calculoactual");
                  if ( (pr_default.getStatus(90) == 1) )
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
            load15184( ) ;
         }
         endLevel15184( ) ;
      }
      closeExtendedTableCursors15184( ) ;
   }

   public void update15184( )
   {
      beforeValidate15184( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15184( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15184( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15184( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate15184( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001593 */
                  pr_default.execute(91, new Object[] {Boolean.valueOf(A1447PaiBaseConHabitual), Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, Integer.valueOf(A1445PaiBaseCliCod), A1446PaiBaseConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisbase_calculoactual");
                  if ( (pr_default.getStatus(91) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paisbase_calculoactual"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate15184( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey15184( ) ;
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
         endLevel15184( ) ;
      }
      closeExtendedTableCursors15184( ) ;
   }

   public void deferredUpdate15184( )
   {
   }

   public void delete15184( )
   {
      Gx_mode = "DLT" ;
      beforeValidate15184( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15184( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls15184( ) ;
         afterConfirm15184( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete15184( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001594 */
               pr_default.execute(92, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, Integer.valueOf(A1445PaiBaseCliCod), A1446PaiBaseConCodigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisbase_calculoactual");
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
      sMode184 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel15184( ) ;
      Gx_mode = sMode184 ;
   }

   public void onDeleteControls15184( )
   {
      standaloneModal15184( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel15184( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(89);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart15184( )
   {
      /* Scan By routine */
      /* Using cursor BC001595 */
      pr_default.execute(93, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
      RcdFound184 = (short)(0) ;
      if ( (pr_default.getStatus(93) != 101) )
      {
         RcdFound184 = (short)(1) ;
         A1447PaiBaseConHabitual = BC001595_A1447PaiBaseConHabitual[0] ;
         A1445PaiBaseCliCod = BC001595_A1445PaiBaseCliCod[0] ;
         A1446PaiBaseConCodigo = BC001595_A1446PaiBaseConCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext15184( )
   {
      /* Scan next routine */
      pr_default.readNext(93);
      RcdFound184 = (short)(0) ;
      scanKeyLoad15184( ) ;
   }

   public void scanKeyLoad15184( )
   {
      sMode184 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(93) != 101) )
      {
         RcdFound184 = (short)(1) ;
         A1447PaiBaseConHabitual = BC001595_A1447PaiBaseConHabitual[0] ;
         A1445PaiBaseCliCod = BC001595_A1445PaiBaseCliCod[0] ;
         A1446PaiBaseConCodigo = BC001595_A1446PaiBaseConCodigo[0] ;
      }
      Gx_mode = sMode184 ;
   }

   public void scanKeyEnd15184( )
   {
      pr_default.close(93);
   }

   public void afterConfirm15184( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert15184( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate15184( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete15184( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete15184( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate15184( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes15184( )
   {
   }

   public void send_integrity_lvl_hashes15184( )
   {
   }

   public void zm15185( int GX_JID )
   {
      if ( ( GX_JID == 27 ) || ( GX_JID == 0 ) )
      {
         Z1450PaiBasePromHab = A1450PaiBasePromHab ;
      }
      if ( GX_JID == -27 )
      {
         Z46PaiCod = A46PaiCod ;
         Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
         Z1441PaiBaseTipo = A1441PaiBaseTipo ;
         Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
         Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
         Z1448PaiBasePromCTipo = A1448PaiBasePromCTipo ;
         Z1449PaiBasePromFijVar = A1449PaiBasePromFijVar ;
         Z1450PaiBasePromHab = A1450PaiBasePromHab ;
      }
   }

   public void standaloneNotModal15185( )
   {
   }

   public void standaloneModal15185( )
   {
   }

   public void load15185( )
   {
      /* Using cursor BC001596 */
      pr_default.execute(94, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, A1448PaiBasePromCTipo, A1449PaiBasePromFijVar});
      if ( (pr_default.getStatus(94) != 101) )
      {
         RcdFound185 = (short)(1) ;
         A1450PaiBasePromHab = BC001596_A1450PaiBasePromHab[0] ;
         zm15185( -27) ;
      }
      pr_default.close(94);
      onLoadActions15185( ) ;
   }

   public void onLoadActions15185( )
   {
   }

   public void checkExtendedTable15185( )
   {
      nIsDirty_185 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal15185( ) ;
      Gx_BScreen = (byte)(0) ;
      if ( ! ( ( GXutil.strcmp(A1448PaiBasePromCTipo, "REM_ARG") == 0 ) || ( GXutil.strcmp(A1448PaiBasePromCTipo, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A1448PaiBasePromCTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A1448PaiBasePromCTipo, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de concepto", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1449PaiBasePromFijVar, "fijo") == 0 ) || ( GXutil.strcmp(A1449PaiBasePromFijVar, "variable") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Fijos/Variables", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors15185( )
   {
   }

   public void enableDisable15185( )
   {
   }

   public void getKey15185( )
   {
      /* Using cursor BC001597 */
      pr_default.execute(95, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, A1448PaiBasePromCTipo, A1449PaiBasePromFijVar});
      if ( (pr_default.getStatus(95) != 101) )
      {
         RcdFound185 = (short)(1) ;
      }
      else
      {
         RcdFound185 = (short)(0) ;
      }
      pr_default.close(95);
   }

   public void getByPrimaryKey15185( )
   {
      /* Using cursor BC001598 */
      pr_default.execute(96, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, A1448PaiBasePromCTipo, A1449PaiBasePromFijVar});
      if ( (pr_default.getStatus(96) != 101) )
      {
         zm15185( 27) ;
         RcdFound185 = (short)(1) ;
         initializeNonKey15185( ) ;
         A1448PaiBasePromCTipo = BC001598_A1448PaiBasePromCTipo[0] ;
         A1449PaiBasePromFijVar = BC001598_A1449PaiBasePromFijVar[0] ;
         A1450PaiBasePromHab = BC001598_A1450PaiBasePromHab[0] ;
         Z46PaiCod = A46PaiCod ;
         Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
         Z1441PaiBaseTipo = A1441PaiBaseTipo ;
         Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
         Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
         Z1448PaiBasePromCTipo = A1448PaiBasePromCTipo ;
         Z1449PaiBasePromFijVar = A1449PaiBasePromFijVar ;
         sMode185 = Gx_mode ;
         Gx_mode = "DSP" ;
         load15185( ) ;
         Gx_mode = sMode185 ;
      }
      else
      {
         RcdFound185 = (short)(0) ;
         initializeNonKey15185( ) ;
         sMode185 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal15185( ) ;
         Gx_mode = sMode185 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes15185( ) ;
      }
      pr_default.close(96);
   }

   public void checkOptimisticConcurrency15185( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001599 */
         pr_default.execute(97, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, A1448PaiBasePromCTipo, A1449PaiBasePromFijVar});
         if ( (pr_default.getStatus(97) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paisbase_calculopromedio"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(97) == 101) || ( Z1450PaiBasePromHab != BC001599_A1450PaiBasePromHab[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Paisbase_calculopromedio"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert15185( )
   {
      beforeValidate15185( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15185( ) ;
      }
      if ( AnyError == 0 )
      {
         zm15185( 0) ;
         checkOptimisticConcurrency15185( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15185( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert15185( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015100 */
                  pr_default.execute(98, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, A1448PaiBasePromCTipo, A1449PaiBasePromFijVar, Boolean.valueOf(A1450PaiBasePromHab)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisbase_calculopromedio");
                  if ( (pr_default.getStatus(98) == 1) )
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
            load15185( ) ;
         }
         endLevel15185( ) ;
      }
      closeExtendedTableCursors15185( ) ;
   }

   public void update15185( )
   {
      beforeValidate15185( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15185( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15185( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15185( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate15185( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015101 */
                  pr_default.execute(99, new Object[] {Boolean.valueOf(A1450PaiBasePromHab), Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, A1448PaiBasePromCTipo, A1449PaiBasePromFijVar});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisbase_calculopromedio");
                  if ( (pr_default.getStatus(99) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paisbase_calculopromedio"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate15185( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey15185( ) ;
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
         endLevel15185( ) ;
      }
      closeExtendedTableCursors15185( ) ;
   }

   public void deferredUpdate15185( )
   {
   }

   public void delete15185( )
   {
      Gx_mode = "DLT" ;
      beforeValidate15185( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15185( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls15185( ) ;
         afterConfirm15185( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete15185( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0015102 */
               pr_default.execute(100, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, A1448PaiBasePromCTipo, A1449PaiBasePromFijVar});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisbase_calculopromedio");
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
      sMode185 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel15185( ) ;
      Gx_mode = sMode185 ;
   }

   public void onDeleteControls15185( )
   {
      standaloneModal15185( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel15185( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(97);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart15185( )
   {
      /* Scan By routine */
      /* Using cursor BC0015103 */
      pr_default.execute(101, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
      RcdFound185 = (short)(0) ;
      if ( (pr_default.getStatus(101) != 101) )
      {
         RcdFound185 = (short)(1) ;
         A1448PaiBasePromCTipo = BC0015103_A1448PaiBasePromCTipo[0] ;
         A1449PaiBasePromFijVar = BC0015103_A1449PaiBasePromFijVar[0] ;
         A1450PaiBasePromHab = BC0015103_A1450PaiBasePromHab[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext15185( )
   {
      /* Scan next routine */
      pr_default.readNext(101);
      RcdFound185 = (short)(0) ;
      scanKeyLoad15185( ) ;
   }

   public void scanKeyLoad15185( )
   {
      sMode185 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(101) != 101) )
      {
         RcdFound185 = (short)(1) ;
         A1448PaiBasePromCTipo = BC0015103_A1448PaiBasePromCTipo[0] ;
         A1449PaiBasePromFijVar = BC0015103_A1449PaiBasePromFijVar[0] ;
         A1450PaiBasePromHab = BC0015103_A1450PaiBasePromHab[0] ;
      }
      Gx_mode = sMode185 ;
   }

   public void scanKeyEnd15185( )
   {
      pr_default.close(101);
   }

   public void afterConfirm15185( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert15185( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate15185( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete15185( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete15185( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate15185( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes15185( )
   {
   }

   public void send_integrity_lvl_hashes15185( )
   {
   }

   public void send_integrity_lvl_hashes15183( )
   {
   }

   public void zm15168( int GX_JID )
   {
      if ( ( GX_JID == 28 ) || ( GX_JID == 0 ) )
      {
         Z1360PaiJorHabitual = A1360PaiJorHabitual ;
      }
      if ( ( GX_JID == 29 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -28 )
      {
         Z1360PaiJorHabitual = A1360PaiJorHabitual ;
         Z1354PaiJorCliCod = A1354PaiJorCliCod ;
         Z1355PaiJorConCodigo = A1355PaiJorConCodigo ;
         Z46PaiCod = A46PaiCod ;
      }
   }

   public void standaloneNotModal15168( )
   {
   }

   public void standaloneModal15168( )
   {
   }

   public void load15168( )
   {
      /* Using cursor BC0015104 */
      pr_default.execute(102, new Object[] {Short.valueOf(A46PaiCod), Integer.valueOf(A1354PaiJorCliCod), A1355PaiJorConCodigo});
      if ( (pr_default.getStatus(102) != 101) )
      {
         RcdFound168 = (short)(1) ;
         A1360PaiJorHabitual = BC0015104_A1360PaiJorHabitual[0] ;
         zm15168( -28) ;
      }
      pr_default.close(102);
      onLoadActions15168( ) ;
   }

   public void onLoadActions15168( )
   {
   }

   public void checkExtendedTable15168( )
   {
      nIsDirty_168 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal15168( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC0015105 */
      pr_default.execute(103, new Object[] {Integer.valueOf(A1354PaiJorCliCod), A1355PaiJorConCodigo});
      if ( (pr_default.getStatus(103) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais Conceptos Jornal", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAIJORCONCODIGO");
         AnyError = (short)(1) ;
      }
      pr_default.close(103);
   }

   public void closeExtendedTableCursors15168( )
   {
      pr_default.close(103);
   }

   public void enableDisable15168( )
   {
   }

   public void getKey15168( )
   {
      /* Using cursor BC0015106 */
      pr_default.execute(104, new Object[] {Short.valueOf(A46PaiCod), Integer.valueOf(A1354PaiJorCliCod), A1355PaiJorConCodigo});
      if ( (pr_default.getStatus(104) != 101) )
      {
         RcdFound168 = (short)(1) ;
      }
      else
      {
         RcdFound168 = (short)(0) ;
      }
      pr_default.close(104);
   }

   public void getByPrimaryKey15168( )
   {
      /* Using cursor BC0015107 */
      pr_default.execute(105, new Object[] {Short.valueOf(A46PaiCod), Integer.valueOf(A1354PaiJorCliCod), A1355PaiJorConCodigo});
      if ( (pr_default.getStatus(105) != 101) )
      {
         zm15168( 28) ;
         RcdFound168 = (short)(1) ;
         initializeNonKey15168( ) ;
         A1360PaiJorHabitual = BC0015107_A1360PaiJorHabitual[0] ;
         A1354PaiJorCliCod = BC0015107_A1354PaiJorCliCod[0] ;
         A1355PaiJorConCodigo = BC0015107_A1355PaiJorConCodigo[0] ;
         Z46PaiCod = A46PaiCod ;
         Z1354PaiJorCliCod = A1354PaiJorCliCod ;
         Z1355PaiJorConCodigo = A1355PaiJorConCodigo ;
         sMode168 = Gx_mode ;
         Gx_mode = "DSP" ;
         load15168( ) ;
         Gx_mode = sMode168 ;
      }
      else
      {
         RcdFound168 = (short)(0) ;
         initializeNonKey15168( ) ;
         sMode168 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal15168( ) ;
         Gx_mode = sMode168 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes15168( ) ;
      }
      pr_default.close(105);
   }

   public void checkOptimisticConcurrency15168( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0015108 */
         pr_default.execute(106, new Object[] {Short.valueOf(A46PaiCod), Integer.valueOf(A1354PaiJorCliCod), A1355PaiJorConCodigo});
         if ( (pr_default.getStatus(106) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paisconceptos_horanormal_jornalizados"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(106) == 101) || ( Z1360PaiJorHabitual != BC0015108_A1360PaiJorHabitual[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Paisconceptos_horanormal_jornalizados"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert15168( )
   {
      beforeValidate15168( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15168( ) ;
      }
      if ( AnyError == 0 )
      {
         zm15168( 0) ;
         checkOptimisticConcurrency15168( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15168( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert15168( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015109 */
                  pr_default.execute(107, new Object[] {Boolean.valueOf(A1360PaiJorHabitual), Integer.valueOf(A1354PaiJorCliCod), A1355PaiJorConCodigo, Short.valueOf(A46PaiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisconceptos_horanormal_jornalizados");
                  if ( (pr_default.getStatus(107) == 1) )
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
            load15168( ) ;
         }
         endLevel15168( ) ;
      }
      closeExtendedTableCursors15168( ) ;
   }

   public void update15168( )
   {
      beforeValidate15168( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15168( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15168( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15168( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate15168( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015110 */
                  pr_default.execute(108, new Object[] {Boolean.valueOf(A1360PaiJorHabitual), Short.valueOf(A46PaiCod), Integer.valueOf(A1354PaiJorCliCod), A1355PaiJorConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisconceptos_horanormal_jornalizados");
                  if ( (pr_default.getStatus(108) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paisconceptos_horanormal_jornalizados"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate15168( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey15168( ) ;
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
         endLevel15168( ) ;
      }
      closeExtendedTableCursors15168( ) ;
   }

   public void deferredUpdate15168( )
   {
   }

   public void delete15168( )
   {
      Gx_mode = "DLT" ;
      beforeValidate15168( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15168( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls15168( ) ;
         afterConfirm15168( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete15168( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0015111 */
               pr_default.execute(109, new Object[] {Short.valueOf(A46PaiCod), Integer.valueOf(A1354PaiJorCliCod), A1355PaiJorConCodigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisconceptos_horanormal_jornalizados");
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
      sMode168 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel15168( ) ;
      Gx_mode = sMode168 ;
   }

   public void onDeleteControls15168( )
   {
      standaloneModal15168( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel15168( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(106);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart15168( )
   {
      /* Scan By routine */
      /* Using cursor BC0015112 */
      pr_default.execute(110, new Object[] {Short.valueOf(A46PaiCod)});
      RcdFound168 = (short)(0) ;
      if ( (pr_default.getStatus(110) != 101) )
      {
         RcdFound168 = (short)(1) ;
         A1360PaiJorHabitual = BC0015112_A1360PaiJorHabitual[0] ;
         A1354PaiJorCliCod = BC0015112_A1354PaiJorCliCod[0] ;
         A1355PaiJorConCodigo = BC0015112_A1355PaiJorConCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext15168( )
   {
      /* Scan next routine */
      pr_default.readNext(110);
      RcdFound168 = (short)(0) ;
      scanKeyLoad15168( ) ;
   }

   public void scanKeyLoad15168( )
   {
      sMode168 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(110) != 101) )
      {
         RcdFound168 = (short)(1) ;
         A1360PaiJorHabitual = BC0015112_A1360PaiJorHabitual[0] ;
         A1354PaiJorCliCod = BC0015112_A1354PaiJorCliCod[0] ;
         A1355PaiJorConCodigo = BC0015112_A1355PaiJorConCodigo[0] ;
      }
      Gx_mode = sMode168 ;
   }

   public void scanKeyEnd15168( )
   {
      pr_default.close(110);
   }

   public void afterConfirm15168( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert15168( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate15168( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete15168( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete15168( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate15168( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes15168( )
   {
   }

   public void send_integrity_lvl_hashes15168( )
   {
   }

   public void zm15167( int GX_JID )
   {
      if ( ( GX_JID == 30 ) || ( GX_JID == 0 ) )
      {
         Z1359PaiMesHabitual = A1359PaiMesHabitual ;
      }
      if ( ( GX_JID == 31 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -30 )
      {
         Z1359PaiMesHabitual = A1359PaiMesHabitual ;
         Z1356PaiMenCliCod = A1356PaiMenCliCod ;
         Z1358PaiMesConCodigo = A1358PaiMesConCodigo ;
         Z46PaiCod = A46PaiCod ;
      }
   }

   public void standaloneNotModal15167( )
   {
   }

   public void standaloneModal15167( )
   {
   }

   public void load15167( )
   {
      /* Using cursor BC0015113 */
      pr_default.execute(111, new Object[] {Short.valueOf(A46PaiCod), Integer.valueOf(A1356PaiMenCliCod), A1358PaiMesConCodigo});
      if ( (pr_default.getStatus(111) != 101) )
      {
         RcdFound167 = (short)(1) ;
         A1359PaiMesHabitual = BC0015113_A1359PaiMesHabitual[0] ;
         zm15167( -30) ;
      }
      pr_default.close(111);
      onLoadActions15167( ) ;
   }

   public void onLoadActions15167( )
   {
   }

   public void checkExtendedTable15167( )
   {
      nIsDirty_167 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal15167( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC0015114 */
      pr_default.execute(112, new Object[] {Integer.valueOf(A1356PaiMenCliCod), A1358PaiMesConCodigo});
      if ( (pr_default.getStatus(112) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais Conceptos Mensual", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAIMESCONCODIGO");
         AnyError = (short)(1) ;
      }
      pr_default.close(112);
   }

   public void closeExtendedTableCursors15167( )
   {
      pr_default.close(112);
   }

   public void enableDisable15167( )
   {
   }

   public void getKey15167( )
   {
      /* Using cursor BC0015115 */
      pr_default.execute(113, new Object[] {Short.valueOf(A46PaiCod), Integer.valueOf(A1356PaiMenCliCod), A1358PaiMesConCodigo});
      if ( (pr_default.getStatus(113) != 101) )
      {
         RcdFound167 = (short)(1) ;
      }
      else
      {
         RcdFound167 = (short)(0) ;
      }
      pr_default.close(113);
   }

   public void getByPrimaryKey15167( )
   {
      /* Using cursor BC0015116 */
      pr_default.execute(114, new Object[] {Short.valueOf(A46PaiCod), Integer.valueOf(A1356PaiMenCliCod), A1358PaiMesConCodigo});
      if ( (pr_default.getStatus(114) != 101) )
      {
         zm15167( 30) ;
         RcdFound167 = (short)(1) ;
         initializeNonKey15167( ) ;
         A1359PaiMesHabitual = BC0015116_A1359PaiMesHabitual[0] ;
         A1356PaiMenCliCod = BC0015116_A1356PaiMenCliCod[0] ;
         A1358PaiMesConCodigo = BC0015116_A1358PaiMesConCodigo[0] ;
         Z46PaiCod = A46PaiCod ;
         Z1356PaiMenCliCod = A1356PaiMenCliCod ;
         Z1358PaiMesConCodigo = A1358PaiMesConCodigo ;
         sMode167 = Gx_mode ;
         Gx_mode = "DSP" ;
         load15167( ) ;
         Gx_mode = sMode167 ;
      }
      else
      {
         RcdFound167 = (short)(0) ;
         initializeNonKey15167( ) ;
         sMode167 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal15167( ) ;
         Gx_mode = sMode167 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes15167( ) ;
      }
      pr_default.close(114);
   }

   public void checkOptimisticConcurrency15167( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0015117 */
         pr_default.execute(115, new Object[] {Short.valueOf(A46PaiCod), Integer.valueOf(A1356PaiMenCliCod), A1358PaiMesConCodigo});
         if ( (pr_default.getStatus(115) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paisconceptos_horanormal_mensualizados"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(115) == 101) || ( Z1359PaiMesHabitual != BC0015117_A1359PaiMesHabitual[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Paisconceptos_horanormal_mensualizados"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert15167( )
   {
      beforeValidate15167( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15167( ) ;
      }
      if ( AnyError == 0 )
      {
         zm15167( 0) ;
         checkOptimisticConcurrency15167( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15167( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert15167( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015118 */
                  pr_default.execute(116, new Object[] {Boolean.valueOf(A1359PaiMesHabitual), Integer.valueOf(A1356PaiMenCliCod), A1358PaiMesConCodigo, Short.valueOf(A46PaiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisconceptos_horanormal_mensualizados");
                  if ( (pr_default.getStatus(116) == 1) )
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
            load15167( ) ;
         }
         endLevel15167( ) ;
      }
      closeExtendedTableCursors15167( ) ;
   }

   public void update15167( )
   {
      beforeValidate15167( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15167( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15167( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15167( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate15167( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015119 */
                  pr_default.execute(117, new Object[] {Boolean.valueOf(A1359PaiMesHabitual), Short.valueOf(A46PaiCod), Integer.valueOf(A1356PaiMenCliCod), A1358PaiMesConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisconceptos_horanormal_mensualizados");
                  if ( (pr_default.getStatus(117) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paisconceptos_horanormal_mensualizados"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate15167( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey15167( ) ;
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
         endLevel15167( ) ;
      }
      closeExtendedTableCursors15167( ) ;
   }

   public void deferredUpdate15167( )
   {
   }

   public void delete15167( )
   {
      Gx_mode = "DLT" ;
      beforeValidate15167( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15167( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls15167( ) ;
         afterConfirm15167( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete15167( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0015120 */
               pr_default.execute(118, new Object[] {Short.valueOf(A46PaiCod), Integer.valueOf(A1356PaiMenCliCod), A1358PaiMesConCodigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisconceptos_horanormal_mensualizados");
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
      sMode167 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel15167( ) ;
      Gx_mode = sMode167 ;
   }

   public void onDeleteControls15167( )
   {
      standaloneModal15167( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel15167( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(115);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart15167( )
   {
      /* Scan By routine */
      /* Using cursor BC0015121 */
      pr_default.execute(119, new Object[] {Short.valueOf(A46PaiCod)});
      RcdFound167 = (short)(0) ;
      if ( (pr_default.getStatus(119) != 101) )
      {
         RcdFound167 = (short)(1) ;
         A1359PaiMesHabitual = BC0015121_A1359PaiMesHabitual[0] ;
         A1356PaiMenCliCod = BC0015121_A1356PaiMenCliCod[0] ;
         A1358PaiMesConCodigo = BC0015121_A1358PaiMesConCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext15167( )
   {
      /* Scan next routine */
      pr_default.readNext(119);
      RcdFound167 = (short)(0) ;
      scanKeyLoad15167( ) ;
   }

   public void scanKeyLoad15167( )
   {
      sMode167 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(119) != 101) )
      {
         RcdFound167 = (short)(1) ;
         A1359PaiMesHabitual = BC0015121_A1359PaiMesHabitual[0] ;
         A1356PaiMenCliCod = BC0015121_A1356PaiMenCliCod[0] ;
         A1358PaiMesConCodigo = BC0015121_A1358PaiMesConCodigo[0] ;
      }
      Gx_mode = sMode167 ;
   }

   public void scanKeyEnd15167( )
   {
      pr_default.close(119);
   }

   public void afterConfirm15167( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert15167( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate15167( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete15167( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete15167( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate15167( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes15167( )
   {
   }

   public void send_integrity_lvl_hashes15167( )
   {
   }

   public void zm15169( int GX_JID )
   {
      if ( ( GX_JID == 32 ) || ( GX_JID == 0 ) )
      {
         Z1362PaiPromHabitual = A1362PaiPromHabitual ;
      }
      if ( ( GX_JID == 33 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -32 )
      {
         Z46PaiCod = A46PaiCod ;
         Z1361PaiPromFijVar = A1361PaiPromFijVar ;
         Z1362PaiPromHabitual = A1362PaiPromHabitual ;
         Z37TipoConCod = A37TipoConCod ;
      }
   }

   public void standaloneNotModal15169( )
   {
   }

   public void standaloneModal15169( )
   {
   }

   public void load15169( )
   {
      /* Using cursor BC0015122 */
      pr_default.execute(120, new Object[] {Short.valueOf(A46PaiCod), A37TipoConCod, A1361PaiPromFijVar});
      if ( (pr_default.getStatus(120) != 101) )
      {
         RcdFound169 = (short)(1) ;
         A1362PaiPromHabitual = BC0015122_A1362PaiPromHabitual[0] ;
         zm15169( -32) ;
      }
      pr_default.close(120);
      onLoadActions15169( ) ;
   }

   public void onLoadActions15169( )
   {
   }

   public void checkExtendedTable15169( )
   {
      nIsDirty_169 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal15169( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC0015123 */
      pr_default.execute(121, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(121) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo De Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(121);
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "DES_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1361PaiPromFijVar, "fijo") == 0 ) || ( GXutil.strcmp(A1361PaiPromFijVar, "variable") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Fijo/Variable", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors15169( )
   {
      pr_default.close(121);
   }

   public void enableDisable15169( )
   {
   }

   public void getKey15169( )
   {
      /* Using cursor BC0015124 */
      pr_default.execute(122, new Object[] {Short.valueOf(A46PaiCod), A37TipoConCod, A1361PaiPromFijVar});
      if ( (pr_default.getStatus(122) != 101) )
      {
         RcdFound169 = (short)(1) ;
      }
      else
      {
         RcdFound169 = (short)(0) ;
      }
      pr_default.close(122);
   }

   public void getByPrimaryKey15169( )
   {
      /* Using cursor BC0015125 */
      pr_default.execute(123, new Object[] {Short.valueOf(A46PaiCod), A37TipoConCod, A1361PaiPromFijVar});
      if ( (pr_default.getStatus(123) != 101) )
      {
         zm15169( 32) ;
         RcdFound169 = (short)(1) ;
         initializeNonKey15169( ) ;
         A1361PaiPromFijVar = BC0015125_A1361PaiPromFijVar[0] ;
         A1362PaiPromHabitual = BC0015125_A1362PaiPromHabitual[0] ;
         A37TipoConCod = BC0015125_A37TipoConCod[0] ;
         Z46PaiCod = A46PaiCod ;
         Z37TipoConCod = A37TipoConCod ;
         Z1361PaiPromFijVar = A1361PaiPromFijVar ;
         sMode169 = Gx_mode ;
         Gx_mode = "DSP" ;
         load15169( ) ;
         Gx_mode = sMode169 ;
      }
      else
      {
         RcdFound169 = (short)(0) ;
         initializeNonKey15169( ) ;
         sMode169 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal15169( ) ;
         Gx_mode = sMode169 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes15169( ) ;
      }
      pr_default.close(123);
   }

   public void checkOptimisticConcurrency15169( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0015126 */
         pr_default.execute(124, new Object[] {Short.valueOf(A46PaiCod), A37TipoConCod, A1361PaiPromFijVar});
         if ( (pr_default.getStatus(124) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paispromedio_horanormal_mensualizados"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(124) == 101) || ( Z1362PaiPromHabitual != BC0015126_A1362PaiPromHabitual[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Paispromedio_horanormal_mensualizados"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert15169( )
   {
      beforeValidate15169( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15169( ) ;
      }
      if ( AnyError == 0 )
      {
         zm15169( 0) ;
         checkOptimisticConcurrency15169( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15169( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert15169( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015127 */
                  pr_default.execute(125, new Object[] {Short.valueOf(A46PaiCod), A1361PaiPromFijVar, Boolean.valueOf(A1362PaiPromHabitual), A37TipoConCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paispromedio_horanormal_mensualizados");
                  if ( (pr_default.getStatus(125) == 1) )
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
            load15169( ) ;
         }
         endLevel15169( ) ;
      }
      closeExtendedTableCursors15169( ) ;
   }

   public void update15169( )
   {
      beforeValidate15169( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15169( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15169( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15169( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate15169( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015128 */
                  pr_default.execute(126, new Object[] {Boolean.valueOf(A1362PaiPromHabitual), Short.valueOf(A46PaiCod), A37TipoConCod, A1361PaiPromFijVar});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paispromedio_horanormal_mensualizados");
                  if ( (pr_default.getStatus(126) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paispromedio_horanormal_mensualizados"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate15169( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey15169( ) ;
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
         endLevel15169( ) ;
      }
      closeExtendedTableCursors15169( ) ;
   }

   public void deferredUpdate15169( )
   {
   }

   public void delete15169( )
   {
      Gx_mode = "DLT" ;
      beforeValidate15169( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15169( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls15169( ) ;
         afterConfirm15169( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete15169( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0015129 */
               pr_default.execute(127, new Object[] {Short.valueOf(A46PaiCod), A37TipoConCod, A1361PaiPromFijVar});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Paispromedio_horanormal_mensualizados");
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
      sMode169 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel15169( ) ;
      Gx_mode = sMode169 ;
   }

   public void onDeleteControls15169( )
   {
      standaloneModal15169( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel15169( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(124);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart15169( )
   {
      /* Scan By routine */
      /* Using cursor BC0015130 */
      pr_default.execute(128, new Object[] {Short.valueOf(A46PaiCod)});
      RcdFound169 = (short)(0) ;
      if ( (pr_default.getStatus(128) != 101) )
      {
         RcdFound169 = (short)(1) ;
         A1361PaiPromFijVar = BC0015130_A1361PaiPromFijVar[0] ;
         A1362PaiPromHabitual = BC0015130_A1362PaiPromHabitual[0] ;
         A37TipoConCod = BC0015130_A37TipoConCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext15169( )
   {
      /* Scan next routine */
      pr_default.readNext(128);
      RcdFound169 = (short)(0) ;
      scanKeyLoad15169( ) ;
   }

   public void scanKeyLoad15169( )
   {
      sMode169 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(128) != 101) )
      {
         RcdFound169 = (short)(1) ;
         A1361PaiPromFijVar = BC0015130_A1361PaiPromFijVar[0] ;
         A1362PaiPromHabitual = BC0015130_A1362PaiPromHabitual[0] ;
         A37TipoConCod = BC0015130_A37TipoConCod[0] ;
      }
      Gx_mode = sMode169 ;
   }

   public void scanKeyEnd15169( )
   {
      pr_default.close(128);
   }

   public void afterConfirm15169( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert15169( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate15169( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete15169( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete15169( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate15169( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes15169( )
   {
   }

   public void send_integrity_lvl_hashes15169( )
   {
   }

   public void zm15155( int GX_JID )
   {
      if ( ( GX_JID == 34 ) || ( GX_JID == 0 ) )
      {
         Z1296PaiTipoTraHor = A1296PaiTipoTraHor ;
         Z1297PaiTipoTraIns = A1297PaiTipoTraIns ;
         Z1336PaiTipoHsDia = A1336PaiTipoHsDia ;
         Z1337PaiTipoHsSem = A1337PaiTipoHsSem ;
         Z1338PaiTipoTarifaXLim = A1338PaiTipoTarifaXLim ;
         Z1347PaiTipoTarifaRec = A1347PaiTipoTarifaRec ;
         Z1383PaiTipoHsMaxDia = A1383PaiTipoHsMaxDia ;
         Z1384PaiTipoHsMaxSem = A1384PaiTipoHsMaxSem ;
         Z1385PaiTipoHsMaxMes = A1385PaiTipoHsMaxMes ;
         Z1390PaiTipoHsMaxAnu = A1390PaiTipoHsMaxAnu ;
         Z1295PaiTipoTraNom = A1295PaiTipoTraNom ;
      }
      if ( ( GX_JID == 35 ) || ( GX_JID == 0 ) )
      {
         Z1295PaiTipoTraNom = A1293TipoTraNom ;
         Z1295PaiTipoTraNom = A1295PaiTipoTraNom ;
      }
      if ( GX_JID == -34 )
      {
         Z46PaiCod = A46PaiCod ;
         Z1296PaiTipoTraHor = A1296PaiTipoTraHor ;
         Z1297PaiTipoTraIns = A1297PaiTipoTraIns ;
         Z1336PaiTipoHsDia = A1336PaiTipoHsDia ;
         Z1337PaiTipoHsSem = A1337PaiTipoHsSem ;
         Z1338PaiTipoTarifaXLim = A1338PaiTipoTarifaXLim ;
         Z1347PaiTipoTarifaRec = A1347PaiTipoTarifaRec ;
         Z1383PaiTipoHsMaxDia = A1383PaiTipoHsMaxDia ;
         Z1384PaiTipoHsMaxSem = A1384PaiTipoHsMaxSem ;
         Z1385PaiTipoHsMaxMes = A1385PaiTipoHsMaxMes ;
         Z1390PaiTipoHsMaxAnu = A1390PaiTipoHsMaxAnu ;
         Z1294PaiTipoTraId = A1294PaiTipoTraId ;
         Z1292TipoTraId = A1292TipoTraId ;
      }
   }

   public void standaloneNotModal15155( )
   {
   }

   public void standaloneModal15155( )
   {
   }

   public void load15155( )
   {
      /* Using cursor BC0015131 */
      pr_default.execute(129, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(129) != 101) )
      {
         RcdFound155 = (short)(1) ;
         A1292TipoTraId = BC0015131_A1292TipoTraId[0] ;
         A1296PaiTipoTraHor = BC0015131_A1296PaiTipoTraHor[0] ;
         n1296PaiTipoTraHor = BC0015131_n1296PaiTipoTraHor[0] ;
         A1297PaiTipoTraIns = BC0015131_A1297PaiTipoTraIns[0] ;
         A1336PaiTipoHsDia = BC0015131_A1336PaiTipoHsDia[0] ;
         A1337PaiTipoHsSem = BC0015131_A1337PaiTipoHsSem[0] ;
         A1338PaiTipoTarifaXLim = BC0015131_A1338PaiTipoTarifaXLim[0] ;
         A1347PaiTipoTarifaRec = BC0015131_A1347PaiTipoTarifaRec[0] ;
         A1383PaiTipoHsMaxDia = BC0015131_A1383PaiTipoHsMaxDia[0] ;
         A1384PaiTipoHsMaxSem = BC0015131_A1384PaiTipoHsMaxSem[0] ;
         A1385PaiTipoHsMaxMes = BC0015131_A1385PaiTipoHsMaxMes[0] ;
         A1390PaiTipoHsMaxAnu = BC0015131_A1390PaiTipoHsMaxAnu[0] ;
         zm15155( -34) ;
      }
      pr_default.close(129);
      onLoadActions15155( ) ;
   }

   public void onLoadActions15155( )
   {
   }

   public void checkExtendedTable15155( )
   {
      nIsDirty_155 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal15155( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC0015132 */
      pr_default.execute(130, new Object[] {A1294PaiTipoTraId});
      if ( (pr_default.getStatus(130) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Trabajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
      }
      pr_default.close(130);
      if ( ! ( ( GXutil.strcmp(A1294PaiTipoTraId, "diurno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "nocturno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de Trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors15155( )
   {
      pr_default.close(130);
   }

   public void enableDisable15155( )
   {
   }

   public void getKey15155( )
   {
      /* Using cursor BC0015133 */
      pr_default.execute(131, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(131) != 101) )
      {
         RcdFound155 = (short)(1) ;
      }
      else
      {
         RcdFound155 = (short)(0) ;
      }
      pr_default.close(131);
   }

   public void getByPrimaryKey15155( )
   {
      /* Using cursor BC0015134 */
      pr_default.execute(132, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(132) != 101) )
      {
         zm15155( 34) ;
         RcdFound155 = (short)(1) ;
         initializeNonKey15155( ) ;
         A1296PaiTipoTraHor = BC0015134_A1296PaiTipoTraHor[0] ;
         n1296PaiTipoTraHor = BC0015134_n1296PaiTipoTraHor[0] ;
         A1297PaiTipoTraIns = BC0015134_A1297PaiTipoTraIns[0] ;
         A1336PaiTipoHsDia = BC0015134_A1336PaiTipoHsDia[0] ;
         A1337PaiTipoHsSem = BC0015134_A1337PaiTipoHsSem[0] ;
         A1338PaiTipoTarifaXLim = BC0015134_A1338PaiTipoTarifaXLim[0] ;
         A1347PaiTipoTarifaRec = BC0015134_A1347PaiTipoTarifaRec[0] ;
         A1383PaiTipoHsMaxDia = BC0015134_A1383PaiTipoHsMaxDia[0] ;
         A1384PaiTipoHsMaxSem = BC0015134_A1384PaiTipoHsMaxSem[0] ;
         A1385PaiTipoHsMaxMes = BC0015134_A1385PaiTipoHsMaxMes[0] ;
         A1390PaiTipoHsMaxAnu = BC0015134_A1390PaiTipoHsMaxAnu[0] ;
         A1294PaiTipoTraId = BC0015134_A1294PaiTipoTraId[0] ;
         Z46PaiCod = A46PaiCod ;
         Z1294PaiTipoTraId = A1294PaiTipoTraId ;
         sMode155 = Gx_mode ;
         Gx_mode = "DSP" ;
         load15155( ) ;
         Gx_mode = sMode155 ;
      }
      else
      {
         RcdFound155 = (short)(0) ;
         initializeNonKey15155( ) ;
         sMode155 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal15155( ) ;
         Gx_mode = sMode155 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes15155( ) ;
      }
      pr_default.close(132);
   }

   public void checkOptimisticConcurrency15155( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0015135 */
         pr_default.execute(133, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(133) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PaisTipoTrabajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(133) == 101) || ( GXutil.strcmp(Z1296PaiTipoTraHor, BC0015135_A1296PaiTipoTraHor[0]) != 0 ) || ( Z1297PaiTipoTraIns != BC0015135_A1297PaiTipoTraIns[0] ) || ( DecimalUtil.compareTo(Z1336PaiTipoHsDia, BC0015135_A1336PaiTipoHsDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1337PaiTipoHsSem, BC0015135_A1337PaiTipoHsSem[0]) != 0 ) || ( DecimalUtil.compareTo(Z1338PaiTipoTarifaXLim, BC0015135_A1338PaiTipoTarifaXLim[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1347PaiTipoTarifaRec, BC0015135_A1347PaiTipoTarifaRec[0]) != 0 ) || ( DecimalUtil.compareTo(Z1383PaiTipoHsMaxDia, BC0015135_A1383PaiTipoHsMaxDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1384PaiTipoHsMaxSem, BC0015135_A1384PaiTipoHsMaxSem[0]) != 0 ) || ( DecimalUtil.compareTo(Z1385PaiTipoHsMaxMes, BC0015135_A1385PaiTipoHsMaxMes[0]) != 0 ) || ( DecimalUtil.compareTo(Z1390PaiTipoHsMaxAnu, BC0015135_A1390PaiTipoHsMaxAnu[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"PaisTipoTrabajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert15155( )
   {
      beforeValidate15155( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15155( ) ;
      }
      if ( AnyError == 0 )
      {
         zm15155( 0) ;
         checkOptimisticConcurrency15155( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15155( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert15155( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015136 */
                  pr_default.execute(134, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n1296PaiTipoTraHor), A1296PaiTipoTraHor, Boolean.valueOf(A1297PaiTipoTraIns), A1336PaiTipoHsDia, A1337PaiTipoHsSem, A1338PaiTipoTarifaXLim, A1347PaiTipoTarifaRec, A1383PaiTipoHsMaxDia, A1384PaiTipoHsMaxSem, A1385PaiTipoHsMaxMes, A1390PaiTipoHsMaxAnu, A1294PaiTipoTraId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisTipoTrabajo");
                  if ( (pr_default.getStatus(134) == 1) )
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
            load15155( ) ;
         }
         endLevel15155( ) ;
      }
      closeExtendedTableCursors15155( ) ;
   }

   public void update15155( )
   {
      beforeValidate15155( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15155( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15155( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15155( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate15155( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015137 */
                  pr_default.execute(135, new Object[] {Boolean.valueOf(n1296PaiTipoTraHor), A1296PaiTipoTraHor, Boolean.valueOf(A1297PaiTipoTraIns), A1336PaiTipoHsDia, A1337PaiTipoHsSem, A1338PaiTipoTarifaXLim, A1347PaiTipoTarifaRec, A1383PaiTipoHsMaxDia, A1384PaiTipoHsMaxSem, A1385PaiTipoHsMaxMes, A1390PaiTipoHsMaxAnu, Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisTipoTrabajo");
                  if ( (pr_default.getStatus(135) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PaisTipoTrabajo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate15155( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey15155( ) ;
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
         endLevel15155( ) ;
      }
      closeExtendedTableCursors15155( ) ;
   }

   public void deferredUpdate15155( )
   {
   }

   public void delete15155( )
   {
      Gx_mode = "DLT" ;
      beforeValidate15155( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15155( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls15155( ) ;
         afterConfirm15155( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete15155( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0015138 */
               pr_default.execute(136, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisTipoTrabajo");
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
      sMode155 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel15155( ) ;
      Gx_mode = sMode155 ;
   }

   public void onDeleteControls15155( )
   {
      standaloneModal15155( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC0015139 */
         pr_default.execute(137, new Object[] {A1294PaiTipoTraId});
         pr_default.close(137);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC0015140 */
         pr_default.execute(138, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(138) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "convenio_tiposdetrabajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(138);
         /* Using cursor BC0015141 */
         pr_default.execute(139, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(139) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "convenio_tiposdetrabajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(139);
         /* Using cursor BC0015142 */
         pr_default.execute(140, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(140) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "horasextras_pordia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(140);
      }
   }

   public void endLevel15155( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(133);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart15155( )
   {
      /* Scan By routine */
      /* Using cursor BC0015143 */
      pr_default.execute(141, new Object[] {Short.valueOf(A46PaiCod)});
      RcdFound155 = (short)(0) ;
      if ( (pr_default.getStatus(141) != 101) )
      {
         RcdFound155 = (short)(1) ;
         A1292TipoTraId = BC0015143_A1292TipoTraId[0] ;
         A1296PaiTipoTraHor = BC0015143_A1296PaiTipoTraHor[0] ;
         n1296PaiTipoTraHor = BC0015143_n1296PaiTipoTraHor[0] ;
         A1297PaiTipoTraIns = BC0015143_A1297PaiTipoTraIns[0] ;
         A1336PaiTipoHsDia = BC0015143_A1336PaiTipoHsDia[0] ;
         A1337PaiTipoHsSem = BC0015143_A1337PaiTipoHsSem[0] ;
         A1338PaiTipoTarifaXLim = BC0015143_A1338PaiTipoTarifaXLim[0] ;
         A1347PaiTipoTarifaRec = BC0015143_A1347PaiTipoTarifaRec[0] ;
         A1383PaiTipoHsMaxDia = BC0015143_A1383PaiTipoHsMaxDia[0] ;
         A1384PaiTipoHsMaxSem = BC0015143_A1384PaiTipoHsMaxSem[0] ;
         A1385PaiTipoHsMaxMes = BC0015143_A1385PaiTipoHsMaxMes[0] ;
         A1390PaiTipoHsMaxAnu = BC0015143_A1390PaiTipoHsMaxAnu[0] ;
         A1294PaiTipoTraId = BC0015143_A1294PaiTipoTraId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext15155( )
   {
      /* Scan next routine */
      pr_default.readNext(141);
      RcdFound155 = (short)(0) ;
      scanKeyLoad15155( ) ;
   }

   public void scanKeyLoad15155( )
   {
      sMode155 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(141) != 101) )
      {
         RcdFound155 = (short)(1) ;
         A1292TipoTraId = BC0015143_A1292TipoTraId[0] ;
         A1296PaiTipoTraHor = BC0015143_A1296PaiTipoTraHor[0] ;
         n1296PaiTipoTraHor = BC0015143_n1296PaiTipoTraHor[0] ;
         A1297PaiTipoTraIns = BC0015143_A1297PaiTipoTraIns[0] ;
         A1336PaiTipoHsDia = BC0015143_A1336PaiTipoHsDia[0] ;
         A1337PaiTipoHsSem = BC0015143_A1337PaiTipoHsSem[0] ;
         A1338PaiTipoTarifaXLim = BC0015143_A1338PaiTipoTarifaXLim[0] ;
         A1347PaiTipoTarifaRec = BC0015143_A1347PaiTipoTarifaRec[0] ;
         A1383PaiTipoHsMaxDia = BC0015143_A1383PaiTipoHsMaxDia[0] ;
         A1384PaiTipoHsMaxSem = BC0015143_A1384PaiTipoHsMaxSem[0] ;
         A1385PaiTipoHsMaxMes = BC0015143_A1385PaiTipoHsMaxMes[0] ;
         A1390PaiTipoHsMaxAnu = BC0015143_A1390PaiTipoHsMaxAnu[0] ;
         A1294PaiTipoTraId = BC0015143_A1294PaiTipoTraId[0] ;
      }
      Gx_mode = sMode155 ;
   }

   public void scanKeyEnd15155( )
   {
      pr_default.close(141);
   }

   public void afterConfirm15155( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert15155( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate15155( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete15155( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete15155( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate15155( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes15155( )
   {
   }

   public void send_integrity_lvl_hashes15155( )
   {
   }

   public void zm15164( int GX_JID )
   {
      if ( ( GX_JID == 36 ) || ( GX_JID == 0 ) )
      {
         Z1333PaiHsPDiaDia = A1333PaiHsPDiaDia ;
         Z1334PaiHsPDiaDesde = A1334PaiHsPDiaDesde ;
         Z1335PaiTarifaPDia = A1335PaiTarifaPDia ;
         Z1348PaiTarifaPDRec = A1348PaiTarifaPDRec ;
         Z1331PaiHsPDiaTipTra = A1331PaiHsPDiaTipTra ;
      }
      if ( ( GX_JID == 37 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -36 )
      {
         Z1332PaiHsExSec = A1332PaiHsExSec ;
         Z1333PaiHsPDiaDia = A1333PaiHsPDiaDia ;
         Z1334PaiHsPDiaDesde = A1334PaiHsPDiaDesde ;
         Z1335PaiTarifaPDia = A1335PaiTarifaPDia ;
         Z1348PaiTarifaPDRec = A1348PaiTarifaPDRec ;
         Z46PaiCod = A46PaiCod ;
         Z1331PaiHsPDiaTipTra = A1331PaiHsPDiaTipTra ;
      }
   }

   public void standaloneNotModal15164( )
   {
   }

   public void standaloneModal15164( )
   {
   }

   public void load15164( )
   {
      /* Using cursor BC0015144 */
      pr_default.execute(142, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
      if ( (pr_default.getStatus(142) != 101) )
      {
         RcdFound164 = (short)(1) ;
         A1333PaiHsPDiaDia = BC0015144_A1333PaiHsPDiaDia[0] ;
         A1334PaiHsPDiaDesde = BC0015144_A1334PaiHsPDiaDesde[0] ;
         n1334PaiHsPDiaDesde = BC0015144_n1334PaiHsPDiaDesde[0] ;
         A1335PaiTarifaPDia = BC0015144_A1335PaiTarifaPDia[0] ;
         A1348PaiTarifaPDRec = BC0015144_A1348PaiTarifaPDRec[0] ;
         A1331PaiHsPDiaTipTra = BC0015144_A1331PaiHsPDiaTipTra[0] ;
         zm15164( -36) ;
      }
      pr_default.close(142);
      onLoadActions15164( ) ;
   }

   public void onLoadActions15164( )
   {
   }

   public void checkExtendedTable15164( )
   {
      nIsDirty_164 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal15164( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC0015145 */
      pr_default.execute(143, new Object[] {Short.valueOf(A46PaiCod), A1331PaiHsPDiaTipTra});
      if ( (pr_default.getStatus(143) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Horas Extras Pais Tipo Tra", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAIHSPDIATIPTRA");
         AnyError = (short)(1) ;
      }
      pr_default.close(143);
      if ( ! ( ( GXutil.strcmp(A1331PaiHsPDiaTipTra, "diurno") == 0 ) || ( GXutil.strcmp(A1331PaiHsPDiaTipTra, "nocturno") == 0 ) || ( GXutil.strcmp(A1331PaiHsPDiaTipTra, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1333PaiHsPDiaDia == 1 ) || ( A1333PaiHsPDiaDia == 2 ) || ( A1333PaiHsPDiaDia == 3 ) || ( A1333PaiHsPDiaDia == 4 ) || ( A1333PaiHsPDiaDia == 5 ) || ( A1333PaiHsPDiaDia == 6 ) || ( A1333PaiHsPDiaDia == 7 ) || ( A1333PaiHsPDiaDia == 8 ) || ( A1333PaiHsPDiaDia == 9 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Día", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors15164( )
   {
      pr_default.close(143);
   }

   public void enableDisable15164( )
   {
   }

   public void getKey15164( )
   {
      /* Using cursor BC0015146 */
      pr_default.execute(144, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
      if ( (pr_default.getStatus(144) != 101) )
      {
         RcdFound164 = (short)(1) ;
      }
      else
      {
         RcdFound164 = (short)(0) ;
      }
      pr_default.close(144);
   }

   public void getByPrimaryKey15164( )
   {
      /* Using cursor BC0015147 */
      pr_default.execute(145, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
      if ( (pr_default.getStatus(145) != 101) )
      {
         zm15164( 36) ;
         RcdFound164 = (short)(1) ;
         initializeNonKey15164( ) ;
         A1332PaiHsExSec = BC0015147_A1332PaiHsExSec[0] ;
         A1333PaiHsPDiaDia = BC0015147_A1333PaiHsPDiaDia[0] ;
         A1334PaiHsPDiaDesde = BC0015147_A1334PaiHsPDiaDesde[0] ;
         n1334PaiHsPDiaDesde = BC0015147_n1334PaiHsPDiaDesde[0] ;
         A1335PaiTarifaPDia = BC0015147_A1335PaiTarifaPDia[0] ;
         A1348PaiTarifaPDRec = BC0015147_A1348PaiTarifaPDRec[0] ;
         A1331PaiHsPDiaTipTra = BC0015147_A1331PaiHsPDiaTipTra[0] ;
         Z46PaiCod = A46PaiCod ;
         Z1332PaiHsExSec = A1332PaiHsExSec ;
         sMode164 = Gx_mode ;
         Gx_mode = "DSP" ;
         load15164( ) ;
         Gx_mode = sMode164 ;
      }
      else
      {
         RcdFound164 = (short)(0) ;
         initializeNonKey15164( ) ;
         sMode164 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal15164( ) ;
         Gx_mode = sMode164 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes15164( ) ;
      }
      pr_default.close(145);
   }

   public void checkOptimisticConcurrency15164( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0015148 */
         pr_default.execute(146, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
         if ( (pr_default.getStatus(146) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paishorasextras_pordia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(146) == 101) || ( Z1333PaiHsPDiaDia != BC0015148_A1333PaiHsPDiaDia[0] ) || ( GXutil.strcmp(Z1334PaiHsPDiaDesde, BC0015148_A1334PaiHsPDiaDesde[0]) != 0 ) || ( DecimalUtil.compareTo(Z1335PaiTarifaPDia, BC0015148_A1335PaiTarifaPDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1348PaiTarifaPDRec, BC0015148_A1348PaiTarifaPDRec[0]) != 0 ) || ( GXutil.strcmp(Z1331PaiHsPDiaTipTra, BC0015148_A1331PaiHsPDiaTipTra[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Paishorasextras_pordia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert15164( )
   {
      beforeValidate15164( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15164( ) ;
      }
      if ( AnyError == 0 )
      {
         zm15164( 0) ;
         checkOptimisticConcurrency15164( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15164( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert15164( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015149 */
                  pr_default.execute(147, new Object[] {Short.valueOf(A1332PaiHsExSec), Byte.valueOf(A1333PaiHsPDiaDia), Boolean.valueOf(n1334PaiHsPDiaDesde), A1334PaiHsPDiaDesde, A1335PaiTarifaPDia, A1348PaiTarifaPDRec, Short.valueOf(A46PaiCod), A1331PaiHsPDiaTipTra});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paishorasextras_pordia");
                  if ( (pr_default.getStatus(147) == 1) )
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
            load15164( ) ;
         }
         endLevel15164( ) ;
      }
      closeExtendedTableCursors15164( ) ;
   }

   public void update15164( )
   {
      beforeValidate15164( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15164( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15164( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15164( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate15164( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015150 */
                  pr_default.execute(148, new Object[] {Byte.valueOf(A1333PaiHsPDiaDia), Boolean.valueOf(n1334PaiHsPDiaDesde), A1334PaiHsPDiaDesde, A1335PaiTarifaPDia, A1348PaiTarifaPDRec, A1331PaiHsPDiaTipTra, Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paishorasextras_pordia");
                  if ( (pr_default.getStatus(148) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paishorasextras_pordia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate15164( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey15164( ) ;
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
         endLevel15164( ) ;
      }
      closeExtendedTableCursors15164( ) ;
   }

   public void deferredUpdate15164( )
   {
   }

   public void delete15164( )
   {
      Gx_mode = "DLT" ;
      beforeValidate15164( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15164( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls15164( ) ;
         afterConfirm15164( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete15164( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0015151 */
               pr_default.execute(149, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Paishorasextras_pordia");
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
      sMode164 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel15164( ) ;
      Gx_mode = sMode164 ;
   }

   public void onDeleteControls15164( )
   {
      standaloneModal15164( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel15164( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(146);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart15164( )
   {
      /* Scan By routine */
      /* Using cursor BC0015152 */
      pr_default.execute(150, new Object[] {Short.valueOf(A46PaiCod)});
      RcdFound164 = (short)(0) ;
      if ( (pr_default.getStatus(150) != 101) )
      {
         RcdFound164 = (short)(1) ;
         A1332PaiHsExSec = BC0015152_A1332PaiHsExSec[0] ;
         A1333PaiHsPDiaDia = BC0015152_A1333PaiHsPDiaDia[0] ;
         A1334PaiHsPDiaDesde = BC0015152_A1334PaiHsPDiaDesde[0] ;
         n1334PaiHsPDiaDesde = BC0015152_n1334PaiHsPDiaDesde[0] ;
         A1335PaiTarifaPDia = BC0015152_A1335PaiTarifaPDia[0] ;
         A1348PaiTarifaPDRec = BC0015152_A1348PaiTarifaPDRec[0] ;
         A1331PaiHsPDiaTipTra = BC0015152_A1331PaiHsPDiaTipTra[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext15164( )
   {
      /* Scan next routine */
      pr_default.readNext(150);
      RcdFound164 = (short)(0) ;
      scanKeyLoad15164( ) ;
   }

   public void scanKeyLoad15164( )
   {
      sMode164 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(150) != 101) )
      {
         RcdFound164 = (short)(1) ;
         A1332PaiHsExSec = BC0015152_A1332PaiHsExSec[0] ;
         A1333PaiHsPDiaDia = BC0015152_A1333PaiHsPDiaDia[0] ;
         A1334PaiHsPDiaDesde = BC0015152_A1334PaiHsPDiaDesde[0] ;
         n1334PaiHsPDiaDesde = BC0015152_n1334PaiHsPDiaDesde[0] ;
         A1335PaiTarifaPDia = BC0015152_A1335PaiTarifaPDia[0] ;
         A1348PaiTarifaPDRec = BC0015152_A1348PaiTarifaPDRec[0] ;
         A1331PaiHsPDiaTipTra = BC0015152_A1331PaiHsPDiaTipTra[0] ;
      }
      Gx_mode = sMode164 ;
   }

   public void scanKeyEnd15164( )
   {
      pr_default.close(150);
   }

   public void afterConfirm15164( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert15164( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate15164( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete15164( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete15164( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate15164( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes15164( )
   {
   }

   public void send_integrity_lvl_hashes15164( )
   {
   }

   public void zm15240( int GX_JID )
   {
      if ( ( GX_JID == 38 ) || ( GX_JID == 0 ) )
      {
         Z1767PaiVacHasAnt = A1767PaiVacHasAnt ;
         Z1768PaiVacDias = A1768PaiVacDias ;
      }
      if ( GX_JID == -38 )
      {
         Z46PaiCod = A46PaiCod ;
         Z1766PaiVacDesAnt = A1766PaiVacDesAnt ;
         Z1767PaiVacHasAnt = A1767PaiVacHasAnt ;
         Z1768PaiVacDias = A1768PaiVacDias ;
      }
   }

   public void standaloneNotModal15240( )
   {
   }

   public void standaloneModal15240( )
   {
   }

   public void load15240( )
   {
      /* Using cursor BC0015153 */
      pr_default.execute(151, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
      if ( (pr_default.getStatus(151) != 101) )
      {
         RcdFound240 = (short)(1) ;
         A1767PaiVacHasAnt = BC0015153_A1767PaiVacHasAnt[0] ;
         A1768PaiVacDias = BC0015153_A1768PaiVacDias[0] ;
         zm15240( -38) ;
      }
      pr_default.close(151);
      onLoadActions15240( ) ;
   }

   public void onLoadActions15240( )
   {
   }

   public void checkExtendedTable15240( )
   {
      nIsDirty_240 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal15240( ) ;
      Gx_BScreen = (byte)(0) ;
   }

   public void closeExtendedTableCursors15240( )
   {
   }

   public void enableDisable15240( )
   {
   }

   public void getKey15240( )
   {
      /* Using cursor BC0015154 */
      pr_default.execute(152, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
      if ( (pr_default.getStatus(152) != 101) )
      {
         RcdFound240 = (short)(1) ;
      }
      else
      {
         RcdFound240 = (short)(0) ;
      }
      pr_default.close(152);
   }

   public void getByPrimaryKey15240( )
   {
      /* Using cursor BC0015155 */
      pr_default.execute(153, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
      if ( (pr_default.getStatus(153) != 101) )
      {
         zm15240( 38) ;
         RcdFound240 = (short)(1) ;
         initializeNonKey15240( ) ;
         A1766PaiVacDesAnt = BC0015155_A1766PaiVacDesAnt[0] ;
         A1767PaiVacHasAnt = BC0015155_A1767PaiVacHasAnt[0] ;
         A1768PaiVacDias = BC0015155_A1768PaiVacDias[0] ;
         Z46PaiCod = A46PaiCod ;
         Z1766PaiVacDesAnt = A1766PaiVacDesAnt ;
         sMode240 = Gx_mode ;
         Gx_mode = "DSP" ;
         load15240( ) ;
         Gx_mode = sMode240 ;
      }
      else
      {
         RcdFound240 = (short)(0) ;
         initializeNonKey15240( ) ;
         sMode240 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal15240( ) ;
         Gx_mode = sMode240 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes15240( ) ;
      }
      pr_default.close(153);
   }

   public void checkOptimisticConcurrency15240( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0015156 */
         pr_default.execute(154, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
         if ( (pr_default.getStatus(154) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PaisVacaciones"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(154) == 101) || ( Z1767PaiVacHasAnt != BC0015156_A1767PaiVacHasAnt[0] ) || ( Z1768PaiVacDias != BC0015156_A1768PaiVacDias[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"PaisVacaciones"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert15240( )
   {
      beforeValidate15240( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15240( ) ;
      }
      if ( AnyError == 0 )
      {
         zm15240( 0) ;
         checkOptimisticConcurrency15240( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15240( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert15240( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015157 */
                  pr_default.execute(155, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt), Byte.valueOf(A1767PaiVacHasAnt), Byte.valueOf(A1768PaiVacDias)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisVacaciones");
                  if ( (pr_default.getStatus(155) == 1) )
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
            load15240( ) ;
         }
         endLevel15240( ) ;
      }
      closeExtendedTableCursors15240( ) ;
   }

   public void update15240( )
   {
      beforeValidate15240( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable15240( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15240( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm15240( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate15240( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0015158 */
                  pr_default.execute(156, new Object[] {Byte.valueOf(A1767PaiVacHasAnt), Byte.valueOf(A1768PaiVacDias), Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisVacaciones");
                  if ( (pr_default.getStatus(156) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PaisVacaciones"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate15240( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey15240( ) ;
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
         endLevel15240( ) ;
      }
      closeExtendedTableCursors15240( ) ;
   }

   public void deferredUpdate15240( )
   {
   }

   public void delete15240( )
   {
      Gx_mode = "DLT" ;
      beforeValidate15240( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency15240( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls15240( ) ;
         afterConfirm15240( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete15240( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0015159 */
               pr_default.execute(157, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisVacaciones");
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
      sMode240 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel15240( ) ;
      Gx_mode = sMode240 ;
   }

   public void onDeleteControls15240( )
   {
      standaloneModal15240( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel15240( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(154);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart15240( )
   {
      /* Scan By routine */
      /* Using cursor BC0015160 */
      pr_default.execute(158, new Object[] {Short.valueOf(A46PaiCod)});
      RcdFound240 = (short)(0) ;
      if ( (pr_default.getStatus(158) != 101) )
      {
         RcdFound240 = (short)(1) ;
         A1766PaiVacDesAnt = BC0015160_A1766PaiVacDesAnt[0] ;
         A1767PaiVacHasAnt = BC0015160_A1767PaiVacHasAnt[0] ;
         A1768PaiVacDias = BC0015160_A1768PaiVacDias[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext15240( )
   {
      /* Scan next routine */
      pr_default.readNext(158);
      RcdFound240 = (short)(0) ;
      scanKeyLoad15240( ) ;
   }

   public void scanKeyLoad15240( )
   {
      sMode240 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(158) != 101) )
      {
         RcdFound240 = (short)(1) ;
         A1766PaiVacDesAnt = BC0015160_A1766PaiVacDesAnt[0] ;
         A1767PaiVacHasAnt = BC0015160_A1767PaiVacHasAnt[0] ;
         A1768PaiVacDias = BC0015160_A1768PaiVacDias[0] ;
      }
      Gx_mode = sMode240 ;
   }

   public void scanKeyEnd15240( )
   {
      pr_default.close(158);
   }

   public void afterConfirm15240( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert15240( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate15240( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete15240( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete15240( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate15240( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes15240( )
   {
   }

   public void send_integrity_lvl_hashes15240( )
   {
   }

   public void send_integrity_lvl_hashes1538( )
   {
   }

   public void addRow1538( )
   {
      VarsToRow38( bcPais) ;
   }

   public void readRow1538( )
   {
      RowToVars38( bcPais, 1) ;
   }

   public void addRow15196( )
   {
      web.SdtPais_preaviso obj196;
      obj196 = new web.SdtPais_preaviso(remoteHandle);
      VarsToRow196( obj196) ;
      bcPais.getgxTv_SdtPais_Preaviso().add(obj196, 0);
      obj196.setgxTv_SdtPais_preaviso_Mode( "UPD" );
      obj196.setgxTv_SdtPais_preaviso_Modified( (short)(0) );
   }

   public void readRow15196( )
   {
      nGXsfl_196_idx = (int)(nGXsfl_196_idx+1) ;
      RowToVars196( ((web.SdtPais_preaviso)bcPais.getgxTv_SdtPais_Preaviso().elementAt(-1+nGXsfl_196_idx)), 1) ;
   }

   public void addRow15183( )
   {
      web.SdtPais_base_calculo obj183;
      obj183 = new web.SdtPais_base_calculo(remoteHandle);
      VarsToRow183( obj183) ;
      bcPais.getgxTv_SdtPais_Base_calculo().add(obj183, 0);
      obj183.setgxTv_SdtPais_base_calculo_Mode( "UPD" );
      obj183.setgxTv_SdtPais_base_calculo_Modified( (short)(0) );
   }

   public void readRow15183( )
   {
      nGXsfl_183_idx = (int)(nGXsfl_183_idx+1) ;
      RowToVars183( ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)), 1) ;
   }

   public void addRow15184( )
   {
      web.SdtPais_base_calculo_actual obj184;
      obj184 = new web.SdtPais_base_calculo_actual(remoteHandle);
      VarsToRow184( obj184) ;
      ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Actual().add(obj184, 0);
      obj184.setgxTv_SdtPais_base_calculo_actual_Mode( "UPD" );
      obj184.setgxTv_SdtPais_base_calculo_actual_Modified( (short)(0) );
   }

   public void readRow15184( )
   {
      nGXsfl_184_idx = (int)(nGXsfl_184_idx+1) ;
      RowToVars184( ((web.SdtPais_base_calculo_actual)((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Actual().elementAt(-1+nGXsfl_184_idx)), 1) ;
   }

   public void addRow15185( )
   {
      web.SdtPais_base_calculo_promedio obj185;
      obj185 = new web.SdtPais_base_calculo_promedio(remoteHandle);
      VarsToRow185( obj185) ;
      ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Promedio().add(obj185, 0);
      obj185.setgxTv_SdtPais_base_calculo_promedio_Mode( "UPD" );
      obj185.setgxTv_SdtPais_base_calculo_promedio_Modified( (short)(0) );
   }

   public void readRow15185( )
   {
      nGXsfl_185_idx = (int)(nGXsfl_185_idx+1) ;
      RowToVars185( ((web.SdtPais_base_calculo_promedio)((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Promedio().elementAt(-1+nGXsfl_185_idx)), 1) ;
   }

   public void addRow15168( )
   {
      web.SdtPais_conceptos_horanormal_jornalizados obj168;
      obj168 = new web.SdtPais_conceptos_horanormal_jornalizados(remoteHandle);
      VarsToRow168( obj168) ;
      bcPais.getgxTv_SdtPais_Conceptos_horanormal_jornalizados().add(obj168, 0);
      obj168.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Mode( "UPD" );
      obj168.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Modified( (short)(0) );
   }

   public void readRow15168( )
   {
      nGXsfl_168_idx = (int)(nGXsfl_168_idx+1) ;
      RowToVars168( ((web.SdtPais_conceptos_horanormal_jornalizados)bcPais.getgxTv_SdtPais_Conceptos_horanormal_jornalizados().elementAt(-1+nGXsfl_168_idx)), 1) ;
   }

   public void addRow15167( )
   {
      web.SdtPais_conceptos_horanormal_mensualizados obj167;
      obj167 = new web.SdtPais_conceptos_horanormal_mensualizados(remoteHandle);
      VarsToRow167( obj167) ;
      bcPais.getgxTv_SdtPais_Conceptos_horanormal_mensualizados().add(obj167, 0);
      obj167.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Mode( "UPD" );
      obj167.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Modified( (short)(0) );
   }

   public void readRow15167( )
   {
      nGXsfl_167_idx = (int)(nGXsfl_167_idx+1) ;
      RowToVars167( ((web.SdtPais_conceptos_horanormal_mensualizados)bcPais.getgxTv_SdtPais_Conceptos_horanormal_mensualizados().elementAt(-1+nGXsfl_167_idx)), 1) ;
   }

   public void addRow15169( )
   {
      web.SdtPais_promedio_horanormal_mensualizados obj169;
      obj169 = new web.SdtPais_promedio_horanormal_mensualizados(remoteHandle);
      VarsToRow169( obj169) ;
      bcPais.getgxTv_SdtPais_Promedio_horanormal_mensualizados().add(obj169, 0);
      obj169.setgxTv_SdtPais_promedio_horanormal_mensualizados_Mode( "UPD" );
      obj169.setgxTv_SdtPais_promedio_horanormal_mensualizados_Modified( (short)(0) );
   }

   public void readRow15169( )
   {
      nGXsfl_169_idx = (int)(nGXsfl_169_idx+1) ;
      RowToVars169( ((web.SdtPais_promedio_horanormal_mensualizados)bcPais.getgxTv_SdtPais_Promedio_horanormal_mensualizados().elementAt(-1+nGXsfl_169_idx)), 1) ;
   }

   public void addRow15155( )
   {
      web.SdtPais_tipo_trabajo obj155;
      obj155 = new web.SdtPais_tipo_trabajo(remoteHandle);
      VarsToRow155( obj155) ;
      bcPais.getgxTv_SdtPais_Tipo_trabajo().add(obj155, 0);
      obj155.setgxTv_SdtPais_tipo_trabajo_Mode( "UPD" );
      obj155.setgxTv_SdtPais_tipo_trabajo_Modified( (short)(0) );
   }

   public void readRow15155( )
   {
      nGXsfl_155_idx = (int)(nGXsfl_155_idx+1) ;
      RowToVars155( ((web.SdtPais_tipo_trabajo)bcPais.getgxTv_SdtPais_Tipo_trabajo().elementAt(-1+nGXsfl_155_idx)), 1) ;
   }

   public void addRow15164( )
   {
      web.SdtPais_horasextras_pordia obj164;
      obj164 = new web.SdtPais_horasextras_pordia(remoteHandle);
      VarsToRow164( obj164) ;
      bcPais.getgxTv_SdtPais_Horasextras_pordia().add(obj164, 0);
      obj164.setgxTv_SdtPais_horasextras_pordia_Mode( "UPD" );
      obj164.setgxTv_SdtPais_horasextras_pordia_Modified( (short)(0) );
   }

   public void readRow15164( )
   {
      nGXsfl_164_idx = (int)(nGXsfl_164_idx+1) ;
      RowToVars164( ((web.SdtPais_horasextras_pordia)bcPais.getgxTv_SdtPais_Horasextras_pordia().elementAt(-1+nGXsfl_164_idx)), 1) ;
   }

   public void addRow15240( )
   {
      web.SdtPais_Vacaciones obj240;
      obj240 = new web.SdtPais_Vacaciones(remoteHandle);
      VarsToRow240( obj240) ;
      bcPais.getgxTv_SdtPais_Vacaciones().add(obj240, 0);
      obj240.setgxTv_SdtPais_Vacaciones_Mode( "UPD" );
      obj240.setgxTv_SdtPais_Vacaciones_Modified( (short)(0) );
   }

   public void readRow15240( )
   {
      nGXsfl_240_idx = (int)(nGXsfl_240_idx+1) ;
      RowToVars240( ((web.SdtPais_Vacaciones)bcPais.getgxTv_SdtPais_Vacaciones().elementAt(-1+nGXsfl_240_idx)), 1) ;
   }

   public void initializeNonKey1538( )
   {
      A312PaiNom = "" ;
      A311PaiNacMostrar = false ;
      A310PaiDomMostrar = false ;
      A1252PaiReligDefault = "" ;
      n1252PaiReligDefault = false ;
      A1271PaiMesHsPExt = DecimalUtil.ZERO ;
      A1272PaiDiaHsPExt = "" ;
      A1402PaiFondoCese = false ;
      A1405PaiMaxHorNor = DecimalUtil.ZERO ;
      A1521PaiPerVacDes = (byte)(0) ;
      A1522PaiPerVacHas = (byte)(0) ;
      A1814PaiFracVacAnt = DecimalUtil.ZERO ;
      A1363PaiPromMeses = (byte)(0) ;
      A1590PaiPromMesTCnt = "" ;
      A1573PaiPromJorMeses = (byte)(0) ;
      A1591PaiPromJorMesTCnt = "" ;
      A1625PaiGuarEdadMin = (byte)(0) ;
      A1626PaiGuarEdadMax = (byte)(0) ;
      A1736PaiExcVizzoti = false ;
      A1737PaiVizzoti = DecimalUtil.ZERO ;
      A1764PaiMinMesesVac = (byte)(0) ;
      A1765PaiInterDiasJor = (short)(0) ;
      A1793PaiTipoExpDef = (byte)(0) ;
      Z312PaiNom = "" ;
      Z311PaiNacMostrar = false ;
      Z310PaiDomMostrar = false ;
      Z1271PaiMesHsPExt = DecimalUtil.ZERO ;
      Z1272PaiDiaHsPExt = "" ;
      Z1402PaiFondoCese = false ;
      Z1405PaiMaxHorNor = DecimalUtil.ZERO ;
      Z1521PaiPerVacDes = (byte)(0) ;
      Z1522PaiPerVacHas = (byte)(0) ;
      Z1814PaiFracVacAnt = DecimalUtil.ZERO ;
      Z1363PaiPromMeses = (byte)(0) ;
      Z1590PaiPromMesTCnt = "" ;
      Z1573PaiPromJorMeses = (byte)(0) ;
      Z1591PaiPromJorMesTCnt = "" ;
      Z1625PaiGuarEdadMin = (byte)(0) ;
      Z1626PaiGuarEdadMax = (byte)(0) ;
      Z1736PaiExcVizzoti = false ;
      Z1737PaiVizzoti = DecimalUtil.ZERO ;
      Z1764PaiMinMesesVac = (byte)(0) ;
      Z1765PaiInterDiasJor = (short)(0) ;
      Z1793PaiTipoExpDef = (byte)(0) ;
      Z1252PaiReligDefault = "" ;
   }

   public void initAll1538( )
   {
      A46PaiCod = (short)(0) ;
      initializeNonKey1538( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey15196( )
   {
      A1537PaiPreAviCant = (byte)(0) ;
      A1538PaiPreAviDur = "" ;
      Z1537PaiPreAviCant = (byte)(0) ;
      Z1538PaiPreAviDur = "" ;
   }

   public void initAll15196( )
   {
      A1535PaiAntMayCant = (byte)(0) ;
      A1536PaiAntMayDur = "" ;
      initializeNonKey15196( ) ;
   }

   public void standaloneModalInsert15196( )
   {
   }

   public void initializeNonKey15183( )
   {
      A1444PaiBasePlus = DecimalUtil.ZERO ;
      A1629PaiLicDLim = (short)(0) ;
      A1630PaiLicDSeman = (byte)(0) ;
      A1631PaiLicDMes = (byte)(0) ;
      A1632PaiLicDSemes = (short)(0) ;
      A1633PaiLicDAnual = (short)(0) ;
      A1634PaiLicAdju = false ;
      A1635PaiLicAdjuObl = false ;
      A1636PaiLicNecAut = false ;
      A1637PaiLicIngMot = false ;
      A1638PaiLicMotObl = false ;
      A1451PaiBasePromCnt1 = (short)(0) ;
      A1452PaiBasePromCnt2 = (short)(0) ;
      A1453PaiBasePromTCnt = "" ;
      Z1444PaiBasePlus = DecimalUtil.ZERO ;
      Z1629PaiLicDLim = (short)(0) ;
      Z1630PaiLicDSeman = (byte)(0) ;
      Z1631PaiLicDMes = (byte)(0) ;
      Z1632PaiLicDSemes = (short)(0) ;
      Z1633PaiLicDAnual = (short)(0) ;
      Z1634PaiLicAdju = false ;
      Z1635PaiLicAdjuObl = false ;
      Z1636PaiLicNecAut = false ;
      Z1637PaiLicIngMot = false ;
      Z1638PaiLicMotObl = false ;
      Z1451PaiBasePromCnt1 = (short)(0) ;
      Z1452PaiBasePromCnt2 = (short)(0) ;
      Z1453PaiBasePromTCnt = "" ;
   }

   public void initAll15183( )
   {
      A1440PaiBaseClaseLeg = (byte)(0) ;
      A1441PaiBaseTipo = "" ;
      A1442PaiBaseCod1 = "" ;
      A1443PaiBaseCod2 = "" ;
      initializeNonKey15183( ) ;
   }

   public void standaloneModalInsert15183( )
   {
   }

   public void initializeNonKey15184( )
   {
      A1447PaiBaseConHabitual = false ;
      Z1447PaiBaseConHabitual = false ;
   }

   public void initAll15184( )
   {
      A1445PaiBaseCliCod = 0 ;
      A1446PaiBaseConCodigo = "" ;
      initializeNonKey15184( ) ;
   }

   public void standaloneModalInsert15184( )
   {
   }

   public void initializeNonKey15185( )
   {
      A1450PaiBasePromHab = false ;
      Z1450PaiBasePromHab = false ;
   }

   public void initAll15185( )
   {
      A1448PaiBasePromCTipo = "" ;
      A1449PaiBasePromFijVar = "" ;
      initializeNonKey15185( ) ;
   }

   public void standaloneModalInsert15185( )
   {
   }

   public void initializeNonKey15168( )
   {
      A1360PaiJorHabitual = false ;
      Z1360PaiJorHabitual = false ;
   }

   public void initAll15168( )
   {
      A1354PaiJorCliCod = 0 ;
      A1355PaiJorConCodigo = "" ;
      initializeNonKey15168( ) ;
   }

   public void standaloneModalInsert15168( )
   {
   }

   public void initializeNonKey15167( )
   {
      A1359PaiMesHabitual = false ;
      Z1359PaiMesHabitual = false ;
   }

   public void initAll15167( )
   {
      A1356PaiMenCliCod = 0 ;
      A1358PaiMesConCodigo = "" ;
      initializeNonKey15167( ) ;
   }

   public void standaloneModalInsert15167( )
   {
   }

   public void initializeNonKey15169( )
   {
      A1362PaiPromHabitual = false ;
      Z1362PaiPromHabitual = false ;
   }

   public void initAll15169( )
   {
      A37TipoConCod = "" ;
      A1361PaiPromFijVar = "" ;
      initializeNonKey15169( ) ;
   }

   public void standaloneModalInsert15169( )
   {
   }

   public void initializeNonKey15155( )
   {
      A1292TipoTraId = "" ;
      A1295PaiTipoTraNom = "" ;
      A1296PaiTipoTraHor = "" ;
      n1296PaiTipoTraHor = false ;
      A1297PaiTipoTraIns = false ;
      A1336PaiTipoHsDia = DecimalUtil.ZERO ;
      A1337PaiTipoHsSem = DecimalUtil.ZERO ;
      A1338PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      A1347PaiTipoTarifaRec = DecimalUtil.ZERO ;
      A1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      A1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      A1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      A1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      Z1296PaiTipoTraHor = "" ;
      Z1297PaiTipoTraIns = false ;
      Z1336PaiTipoHsDia = DecimalUtil.ZERO ;
      Z1337PaiTipoHsSem = DecimalUtil.ZERO ;
      Z1338PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      Z1347PaiTipoTarifaRec = DecimalUtil.ZERO ;
      Z1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      Z1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      Z1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      Z1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
   }

   public void initAll15155( )
   {
      A1294PaiTipoTraId = "" ;
      initializeNonKey15155( ) ;
   }

   public void standaloneModalInsert15155( )
   {
   }

   public void initializeNonKey15164( )
   {
      A1331PaiHsPDiaTipTra = "" ;
      A1333PaiHsPDiaDia = (byte)(0) ;
      A1334PaiHsPDiaDesde = "" ;
      n1334PaiHsPDiaDesde = false ;
      A1335PaiTarifaPDia = DecimalUtil.ZERO ;
      A1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      Z1333PaiHsPDiaDia = (byte)(0) ;
      Z1334PaiHsPDiaDesde = "" ;
      Z1335PaiTarifaPDia = DecimalUtil.ZERO ;
      Z1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      Z1331PaiHsPDiaTipTra = "" ;
   }

   public void initAll15164( )
   {
      A1332PaiHsExSec = (short)(0) ;
      initializeNonKey15164( ) ;
   }

   public void standaloneModalInsert15164( )
   {
   }

   public void initializeNonKey15240( )
   {
      A1767PaiVacHasAnt = (byte)(0) ;
      A1768PaiVacDias = (byte)(0) ;
      Z1767PaiVacHasAnt = (byte)(0) ;
      Z1768PaiVacDias = (byte)(0) ;
   }

   public void initAll15240( )
   {
      A1766PaiVacDesAnt = (byte)(0) ;
      initializeNonKey15240( ) ;
   }

   public void standaloneModalInsert15240( )
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

   public void VarsToRow38( web.SdtPais obj38 )
   {
      obj38.setgxTv_SdtPais_Mode( Gx_mode );
      obj38.setgxTv_SdtPais_Painom( A312PaiNom );
      obj38.setgxTv_SdtPais_Painacmostrar( A311PaiNacMostrar );
      obj38.setgxTv_SdtPais_Paidommostrar( A310PaiDomMostrar );
      obj38.setgxTv_SdtPais_Paireligdefault( A1252PaiReligDefault );
      obj38.setgxTv_SdtPais_Paimeshspext( A1271PaiMesHsPExt );
      obj38.setgxTv_SdtPais_Paidiahspext( A1272PaiDiaHsPExt );
      obj38.setgxTv_SdtPais_Paifondocese( A1402PaiFondoCese );
      obj38.setgxTv_SdtPais_Paimaxhornor( A1405PaiMaxHorNor );
      obj38.setgxTv_SdtPais_Paipervacdes( A1521PaiPerVacDes );
      obj38.setgxTv_SdtPais_Paipervachas( A1522PaiPerVacHas );
      obj38.setgxTv_SdtPais_Paifracvacant( A1814PaiFracVacAnt );
      obj38.setgxTv_SdtPais_Paiprommeses( A1363PaiPromMeses );
      obj38.setgxTv_SdtPais_Paiprommestcnt( A1590PaiPromMesTCnt );
      obj38.setgxTv_SdtPais_Paipromjormeses( A1573PaiPromJorMeses );
      obj38.setgxTv_SdtPais_Paipromjormestcnt( A1591PaiPromJorMesTCnt );
      obj38.setgxTv_SdtPais_Paiguaredadmin( A1625PaiGuarEdadMin );
      obj38.setgxTv_SdtPais_Paiguaredadmax( A1626PaiGuarEdadMax );
      obj38.setgxTv_SdtPais_Paiexcvizzoti( A1736PaiExcVizzoti );
      obj38.setgxTv_SdtPais_Paivizzoti( A1737PaiVizzoti );
      obj38.setgxTv_SdtPais_Paiminmesesvac( A1764PaiMinMesesVac );
      obj38.setgxTv_SdtPais_Paiinterdiasjor( A1765PaiInterDiasJor );
      obj38.setgxTv_SdtPais_Paitipoexpdef( A1793PaiTipoExpDef );
      obj38.setgxTv_SdtPais_Paicod( A46PaiCod );
      obj38.setgxTv_SdtPais_Paicod_Z( Z46PaiCod );
      obj38.setgxTv_SdtPais_Painom_Z( Z312PaiNom );
      obj38.setgxTv_SdtPais_Painacmostrar_Z( Z311PaiNacMostrar );
      obj38.setgxTv_SdtPais_Paidommostrar_Z( Z310PaiDomMostrar );
      obj38.setgxTv_SdtPais_Paireligdefault_Z( Z1252PaiReligDefault );
      obj38.setgxTv_SdtPais_Paimeshspext_Z( Z1271PaiMesHsPExt );
      obj38.setgxTv_SdtPais_Paidiahspext_Z( Z1272PaiDiaHsPExt );
      obj38.setgxTv_SdtPais_Paifondocese_Z( Z1402PaiFondoCese );
      obj38.setgxTv_SdtPais_Paimaxhornor_Z( Z1405PaiMaxHorNor );
      obj38.setgxTv_SdtPais_Paipervacdes_Z( Z1521PaiPerVacDes );
      obj38.setgxTv_SdtPais_Paipervachas_Z( Z1522PaiPerVacHas );
      obj38.setgxTv_SdtPais_Paifracvacant_Z( Z1814PaiFracVacAnt );
      obj38.setgxTv_SdtPais_Paiprommeses_Z( Z1363PaiPromMeses );
      obj38.setgxTv_SdtPais_Paiprommestcnt_Z( Z1590PaiPromMesTCnt );
      obj38.setgxTv_SdtPais_Paipromjormeses_Z( Z1573PaiPromJorMeses );
      obj38.setgxTv_SdtPais_Paipromjormestcnt_Z( Z1591PaiPromJorMesTCnt );
      obj38.setgxTv_SdtPais_Paiguaredadmin_Z( Z1625PaiGuarEdadMin );
      obj38.setgxTv_SdtPais_Paiguaredadmax_Z( Z1626PaiGuarEdadMax );
      obj38.setgxTv_SdtPais_Paiexcvizzoti_Z( Z1736PaiExcVizzoti );
      obj38.setgxTv_SdtPais_Paivizzoti_Z( Z1737PaiVizzoti );
      obj38.setgxTv_SdtPais_Paiminmesesvac_Z( Z1764PaiMinMesesVac );
      obj38.setgxTv_SdtPais_Paiinterdiasjor_Z( Z1765PaiInterDiasJor );
      obj38.setgxTv_SdtPais_Paitipoexpdef_Z( Z1793PaiTipoExpDef );
      obj38.setgxTv_SdtPais_Paireligdefault_N( (byte)((byte)((n1252PaiReligDefault)?1:0)) );
      obj38.setgxTv_SdtPais_Mode( Gx_mode );
   }

   public void KeyVarsToRow38( web.SdtPais obj38 )
   {
      obj38.setgxTv_SdtPais_Paicod( A46PaiCod );
   }

   public void RowToVars38( web.SdtPais obj38 ,
                            int forceLoad )
   {
      Gx_mode = obj38.getgxTv_SdtPais_Mode() ;
      A312PaiNom = obj38.getgxTv_SdtPais_Painom() ;
      A311PaiNacMostrar = obj38.getgxTv_SdtPais_Painacmostrar() ;
      A310PaiDomMostrar = obj38.getgxTv_SdtPais_Paidommostrar() ;
      A1252PaiReligDefault = obj38.getgxTv_SdtPais_Paireligdefault() ;
      n1252PaiReligDefault = false ;
      A1271PaiMesHsPExt = obj38.getgxTv_SdtPais_Paimeshspext() ;
      A1272PaiDiaHsPExt = obj38.getgxTv_SdtPais_Paidiahspext() ;
      A1402PaiFondoCese = obj38.getgxTv_SdtPais_Paifondocese() ;
      A1405PaiMaxHorNor = obj38.getgxTv_SdtPais_Paimaxhornor() ;
      A1521PaiPerVacDes = obj38.getgxTv_SdtPais_Paipervacdes() ;
      A1522PaiPerVacHas = obj38.getgxTv_SdtPais_Paipervachas() ;
      A1814PaiFracVacAnt = obj38.getgxTv_SdtPais_Paifracvacant() ;
      A1363PaiPromMeses = obj38.getgxTv_SdtPais_Paiprommeses() ;
      A1590PaiPromMesTCnt = obj38.getgxTv_SdtPais_Paiprommestcnt() ;
      A1573PaiPromJorMeses = obj38.getgxTv_SdtPais_Paipromjormeses() ;
      A1591PaiPromJorMesTCnt = obj38.getgxTv_SdtPais_Paipromjormestcnt() ;
      A1625PaiGuarEdadMin = obj38.getgxTv_SdtPais_Paiguaredadmin() ;
      A1626PaiGuarEdadMax = obj38.getgxTv_SdtPais_Paiguaredadmax() ;
      A1736PaiExcVizzoti = obj38.getgxTv_SdtPais_Paiexcvizzoti() ;
      A1737PaiVizzoti = obj38.getgxTv_SdtPais_Paivizzoti() ;
      A1764PaiMinMesesVac = obj38.getgxTv_SdtPais_Paiminmesesvac() ;
      A1765PaiInterDiasJor = obj38.getgxTv_SdtPais_Paiinterdiasjor() ;
      A1793PaiTipoExpDef = obj38.getgxTv_SdtPais_Paitipoexpdef() ;
      A46PaiCod = obj38.getgxTv_SdtPais_Paicod() ;
      Z46PaiCod = obj38.getgxTv_SdtPais_Paicod_Z() ;
      Z312PaiNom = obj38.getgxTv_SdtPais_Painom_Z() ;
      Z311PaiNacMostrar = obj38.getgxTv_SdtPais_Painacmostrar_Z() ;
      Z310PaiDomMostrar = obj38.getgxTv_SdtPais_Paidommostrar_Z() ;
      Z1252PaiReligDefault = obj38.getgxTv_SdtPais_Paireligdefault_Z() ;
      Z1271PaiMesHsPExt = obj38.getgxTv_SdtPais_Paimeshspext_Z() ;
      Z1272PaiDiaHsPExt = obj38.getgxTv_SdtPais_Paidiahspext_Z() ;
      Z1402PaiFondoCese = obj38.getgxTv_SdtPais_Paifondocese_Z() ;
      Z1405PaiMaxHorNor = obj38.getgxTv_SdtPais_Paimaxhornor_Z() ;
      Z1521PaiPerVacDes = obj38.getgxTv_SdtPais_Paipervacdes_Z() ;
      Z1522PaiPerVacHas = obj38.getgxTv_SdtPais_Paipervachas_Z() ;
      Z1814PaiFracVacAnt = obj38.getgxTv_SdtPais_Paifracvacant_Z() ;
      Z1363PaiPromMeses = obj38.getgxTv_SdtPais_Paiprommeses_Z() ;
      Z1590PaiPromMesTCnt = obj38.getgxTv_SdtPais_Paiprommestcnt_Z() ;
      Z1573PaiPromJorMeses = obj38.getgxTv_SdtPais_Paipromjormeses_Z() ;
      Z1591PaiPromJorMesTCnt = obj38.getgxTv_SdtPais_Paipromjormestcnt_Z() ;
      Z1625PaiGuarEdadMin = obj38.getgxTv_SdtPais_Paiguaredadmin_Z() ;
      Z1626PaiGuarEdadMax = obj38.getgxTv_SdtPais_Paiguaredadmax_Z() ;
      Z1736PaiExcVizzoti = obj38.getgxTv_SdtPais_Paiexcvizzoti_Z() ;
      Z1737PaiVizzoti = obj38.getgxTv_SdtPais_Paivizzoti_Z() ;
      Z1764PaiMinMesesVac = obj38.getgxTv_SdtPais_Paiminmesesvac_Z() ;
      Z1765PaiInterDiasJor = obj38.getgxTv_SdtPais_Paiinterdiasjor_Z() ;
      Z1793PaiTipoExpDef = obj38.getgxTv_SdtPais_Paitipoexpdef_Z() ;
      n1252PaiReligDefault = (boolean)((obj38.getgxTv_SdtPais_Paireligdefault_N()==0)?false:true) ;
      Gx_mode = obj38.getgxTv_SdtPais_Mode() ;
   }

   public void VarsToRow196( web.SdtPais_preaviso obj196 )
   {
      obj196.setgxTv_SdtPais_preaviso_Mode( Gx_mode );
      obj196.setgxTv_SdtPais_preaviso_Paipreavicant( A1537PaiPreAviCant );
      obj196.setgxTv_SdtPais_preaviso_Paipreavidur( A1538PaiPreAviDur );
      obj196.setgxTv_SdtPais_preaviso_Paiantmaycant( A1535PaiAntMayCant );
      obj196.setgxTv_SdtPais_preaviso_Paiantmaydur( A1536PaiAntMayDur );
      obj196.setgxTv_SdtPais_preaviso_Paiantmaycant_Z( Z1535PaiAntMayCant );
      obj196.setgxTv_SdtPais_preaviso_Paiantmaydur_Z( Z1536PaiAntMayDur );
      obj196.setgxTv_SdtPais_preaviso_Paipreavicant_Z( Z1537PaiPreAviCant );
      obj196.setgxTv_SdtPais_preaviso_Paipreavidur_Z( Z1538PaiPreAviDur );
      obj196.setgxTv_SdtPais_preaviso_Modified( nIsMod_196 );
   }

   public void KeyVarsToRow196( web.SdtPais_preaviso obj196 )
   {
      obj196.setgxTv_SdtPais_preaviso_Paiantmaycant( A1535PaiAntMayCant );
      obj196.setgxTv_SdtPais_preaviso_Paiantmaydur( A1536PaiAntMayDur );
   }

   public void RowToVars196( web.SdtPais_preaviso obj196 ,
                             int forceLoad )
   {
      Gx_mode = obj196.getgxTv_SdtPais_preaviso_Mode() ;
      A1537PaiPreAviCant = obj196.getgxTv_SdtPais_preaviso_Paipreavicant() ;
      A1538PaiPreAviDur = obj196.getgxTv_SdtPais_preaviso_Paipreavidur() ;
      A1535PaiAntMayCant = obj196.getgxTv_SdtPais_preaviso_Paiantmaycant() ;
      A1536PaiAntMayDur = obj196.getgxTv_SdtPais_preaviso_Paiantmaydur() ;
      Z1535PaiAntMayCant = obj196.getgxTv_SdtPais_preaviso_Paiantmaycant_Z() ;
      Z1536PaiAntMayDur = obj196.getgxTv_SdtPais_preaviso_Paiantmaydur_Z() ;
      Z1537PaiPreAviCant = obj196.getgxTv_SdtPais_preaviso_Paipreavicant_Z() ;
      Z1538PaiPreAviDur = obj196.getgxTv_SdtPais_preaviso_Paipreavidur_Z() ;
      nIsMod_196 = obj196.getgxTv_SdtPais_preaviso_Modified() ;
   }

   public void VarsToRow183( web.SdtPais_base_calculo obj183 )
   {
      obj183.setgxTv_SdtPais_base_calculo_Mode( Gx_mode );
      obj183.setgxTv_SdtPais_base_calculo_Paibaseplus( A1444PaiBasePlus );
      obj183.setgxTv_SdtPais_base_calculo_Pailicdlim( A1629PaiLicDLim );
      obj183.setgxTv_SdtPais_base_calculo_Pailicdseman( A1630PaiLicDSeman );
      obj183.setgxTv_SdtPais_base_calculo_Pailicdmes( A1631PaiLicDMes );
      obj183.setgxTv_SdtPais_base_calculo_Pailicdsemes( A1632PaiLicDSemes );
      obj183.setgxTv_SdtPais_base_calculo_Pailicdanual( A1633PaiLicDAnual );
      obj183.setgxTv_SdtPais_base_calculo_Pailicadju( A1634PaiLicAdju );
      obj183.setgxTv_SdtPais_base_calculo_Pailicadjuobl( A1635PaiLicAdjuObl );
      obj183.setgxTv_SdtPais_base_calculo_Pailicnecaut( A1636PaiLicNecAut );
      obj183.setgxTv_SdtPais_base_calculo_Pailicingmot( A1637PaiLicIngMot );
      obj183.setgxTv_SdtPais_base_calculo_Pailicmotobl( A1638PaiLicMotObl );
      obj183.setgxTv_SdtPais_base_calculo_Paibasepromcnt1( A1451PaiBasePromCnt1 );
      obj183.setgxTv_SdtPais_base_calculo_Paibasepromcnt2( A1452PaiBasePromCnt2 );
      obj183.setgxTv_SdtPais_base_calculo_Paibasepromtcnt( A1453PaiBasePromTCnt );
      obj183.setgxTv_SdtPais_base_calculo_Paibaseclaseleg( A1440PaiBaseClaseLeg );
      obj183.setgxTv_SdtPais_base_calculo_Paibasetipo( A1441PaiBaseTipo );
      obj183.setgxTv_SdtPais_base_calculo_Paibasecod1( A1442PaiBaseCod1 );
      obj183.setgxTv_SdtPais_base_calculo_Paibasecod2( A1443PaiBaseCod2 );
      obj183.setgxTv_SdtPais_base_calculo_Paibaseclaseleg_Z( Z1440PaiBaseClaseLeg );
      obj183.setgxTv_SdtPais_base_calculo_Paibasetipo_Z( Z1441PaiBaseTipo );
      obj183.setgxTv_SdtPais_base_calculo_Paibasecod1_Z( Z1442PaiBaseCod1 );
      obj183.setgxTv_SdtPais_base_calculo_Paibasecod2_Z( Z1443PaiBaseCod2 );
      obj183.setgxTv_SdtPais_base_calculo_Paibaseplus_Z( Z1444PaiBasePlus );
      obj183.setgxTv_SdtPais_base_calculo_Pailicdlim_Z( Z1629PaiLicDLim );
      obj183.setgxTv_SdtPais_base_calculo_Pailicdseman_Z( Z1630PaiLicDSeman );
      obj183.setgxTv_SdtPais_base_calculo_Pailicdmes_Z( Z1631PaiLicDMes );
      obj183.setgxTv_SdtPais_base_calculo_Pailicdsemes_Z( Z1632PaiLicDSemes );
      obj183.setgxTv_SdtPais_base_calculo_Pailicdanual_Z( Z1633PaiLicDAnual );
      obj183.setgxTv_SdtPais_base_calculo_Pailicadju_Z( Z1634PaiLicAdju );
      obj183.setgxTv_SdtPais_base_calculo_Pailicadjuobl_Z( Z1635PaiLicAdjuObl );
      obj183.setgxTv_SdtPais_base_calculo_Pailicnecaut_Z( Z1636PaiLicNecAut );
      obj183.setgxTv_SdtPais_base_calculo_Pailicingmot_Z( Z1637PaiLicIngMot );
      obj183.setgxTv_SdtPais_base_calculo_Pailicmotobl_Z( Z1638PaiLicMotObl );
      obj183.setgxTv_SdtPais_base_calculo_Paibasepromcnt1_Z( Z1451PaiBasePromCnt1 );
      obj183.setgxTv_SdtPais_base_calculo_Paibasepromcnt2_Z( Z1452PaiBasePromCnt2 );
      obj183.setgxTv_SdtPais_base_calculo_Paibasepromtcnt_Z( Z1453PaiBasePromTCnt );
      obj183.setgxTv_SdtPais_base_calculo_Modified( nIsMod_183 );
   }

   public void KeyVarsToRow183( web.SdtPais_base_calculo obj183 )
   {
      obj183.setgxTv_SdtPais_base_calculo_Paibaseclaseleg( A1440PaiBaseClaseLeg );
      obj183.setgxTv_SdtPais_base_calculo_Paibasetipo( A1441PaiBaseTipo );
      obj183.setgxTv_SdtPais_base_calculo_Paibasecod1( A1442PaiBaseCod1 );
      obj183.setgxTv_SdtPais_base_calculo_Paibasecod2( A1443PaiBaseCod2 );
   }

   public void RowToVars183( web.SdtPais_base_calculo obj183 ,
                             int forceLoad )
   {
      Gx_mode = obj183.getgxTv_SdtPais_base_calculo_Mode() ;
      A1444PaiBasePlus = obj183.getgxTv_SdtPais_base_calculo_Paibaseplus() ;
      A1629PaiLicDLim = obj183.getgxTv_SdtPais_base_calculo_Pailicdlim() ;
      A1630PaiLicDSeman = obj183.getgxTv_SdtPais_base_calculo_Pailicdseman() ;
      A1631PaiLicDMes = obj183.getgxTv_SdtPais_base_calculo_Pailicdmes() ;
      A1632PaiLicDSemes = obj183.getgxTv_SdtPais_base_calculo_Pailicdsemes() ;
      A1633PaiLicDAnual = obj183.getgxTv_SdtPais_base_calculo_Pailicdanual() ;
      A1634PaiLicAdju = obj183.getgxTv_SdtPais_base_calculo_Pailicadju() ;
      A1635PaiLicAdjuObl = obj183.getgxTv_SdtPais_base_calculo_Pailicadjuobl() ;
      A1636PaiLicNecAut = obj183.getgxTv_SdtPais_base_calculo_Pailicnecaut() ;
      A1637PaiLicIngMot = obj183.getgxTv_SdtPais_base_calculo_Pailicingmot() ;
      A1638PaiLicMotObl = obj183.getgxTv_SdtPais_base_calculo_Pailicmotobl() ;
      A1451PaiBasePromCnt1 = obj183.getgxTv_SdtPais_base_calculo_Paibasepromcnt1() ;
      A1452PaiBasePromCnt2 = obj183.getgxTv_SdtPais_base_calculo_Paibasepromcnt2() ;
      A1453PaiBasePromTCnt = obj183.getgxTv_SdtPais_base_calculo_Paibasepromtcnt() ;
      A1440PaiBaseClaseLeg = obj183.getgxTv_SdtPais_base_calculo_Paibaseclaseleg() ;
      A1441PaiBaseTipo = obj183.getgxTv_SdtPais_base_calculo_Paibasetipo() ;
      A1442PaiBaseCod1 = obj183.getgxTv_SdtPais_base_calculo_Paibasecod1() ;
      A1443PaiBaseCod2 = obj183.getgxTv_SdtPais_base_calculo_Paibasecod2() ;
      Z1440PaiBaseClaseLeg = obj183.getgxTv_SdtPais_base_calculo_Paibaseclaseleg_Z() ;
      Z1441PaiBaseTipo = obj183.getgxTv_SdtPais_base_calculo_Paibasetipo_Z() ;
      Z1442PaiBaseCod1 = obj183.getgxTv_SdtPais_base_calculo_Paibasecod1_Z() ;
      Z1443PaiBaseCod2 = obj183.getgxTv_SdtPais_base_calculo_Paibasecod2_Z() ;
      Z1444PaiBasePlus = obj183.getgxTv_SdtPais_base_calculo_Paibaseplus_Z() ;
      Z1629PaiLicDLim = obj183.getgxTv_SdtPais_base_calculo_Pailicdlim_Z() ;
      Z1630PaiLicDSeman = obj183.getgxTv_SdtPais_base_calculo_Pailicdseman_Z() ;
      Z1631PaiLicDMes = obj183.getgxTv_SdtPais_base_calculo_Pailicdmes_Z() ;
      Z1632PaiLicDSemes = obj183.getgxTv_SdtPais_base_calculo_Pailicdsemes_Z() ;
      Z1633PaiLicDAnual = obj183.getgxTv_SdtPais_base_calculo_Pailicdanual_Z() ;
      Z1634PaiLicAdju = obj183.getgxTv_SdtPais_base_calculo_Pailicadju_Z() ;
      Z1635PaiLicAdjuObl = obj183.getgxTv_SdtPais_base_calculo_Pailicadjuobl_Z() ;
      Z1636PaiLicNecAut = obj183.getgxTv_SdtPais_base_calculo_Pailicnecaut_Z() ;
      Z1637PaiLicIngMot = obj183.getgxTv_SdtPais_base_calculo_Pailicingmot_Z() ;
      Z1638PaiLicMotObl = obj183.getgxTv_SdtPais_base_calculo_Pailicmotobl_Z() ;
      Z1451PaiBasePromCnt1 = obj183.getgxTv_SdtPais_base_calculo_Paibasepromcnt1_Z() ;
      Z1452PaiBasePromCnt2 = obj183.getgxTv_SdtPais_base_calculo_Paibasepromcnt2_Z() ;
      Z1453PaiBasePromTCnt = obj183.getgxTv_SdtPais_base_calculo_Paibasepromtcnt_Z() ;
      nIsMod_183 = obj183.getgxTv_SdtPais_base_calculo_Modified() ;
   }

   public void VarsToRow184( web.SdtPais_base_calculo_actual obj184 )
   {
      obj184.setgxTv_SdtPais_base_calculo_actual_Mode( Gx_mode );
      obj184.setgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual( A1447PaiBaseConHabitual );
      obj184.setgxTv_SdtPais_base_calculo_actual_Paibaseclicod( A1445PaiBaseCliCod );
      obj184.setgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo( A1446PaiBaseConCodigo );
      obj184.setgxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z( Z1445PaiBaseCliCod );
      obj184.setgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z( Z1446PaiBaseConCodigo );
      obj184.setgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z( Z1447PaiBaseConHabitual );
      obj184.setgxTv_SdtPais_base_calculo_actual_Modified( nIsMod_184 );
   }

   public void KeyVarsToRow184( web.SdtPais_base_calculo_actual obj184 )
   {
      obj184.setgxTv_SdtPais_base_calculo_actual_Paibaseclicod( A1445PaiBaseCliCod );
      obj184.setgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo( A1446PaiBaseConCodigo );
   }

   public void RowToVars184( web.SdtPais_base_calculo_actual obj184 ,
                             int forceLoad )
   {
      Gx_mode = obj184.getgxTv_SdtPais_base_calculo_actual_Mode() ;
      A1447PaiBaseConHabitual = obj184.getgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual() ;
      A1445PaiBaseCliCod = obj184.getgxTv_SdtPais_base_calculo_actual_Paibaseclicod() ;
      A1446PaiBaseConCodigo = obj184.getgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo() ;
      Z1445PaiBaseCliCod = obj184.getgxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z() ;
      Z1446PaiBaseConCodigo = obj184.getgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z() ;
      Z1447PaiBaseConHabitual = obj184.getgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z() ;
      nIsMod_184 = obj184.getgxTv_SdtPais_base_calculo_actual_Modified() ;
   }

   public void VarsToRow185( web.SdtPais_base_calculo_promedio obj185 )
   {
      obj185.setgxTv_SdtPais_base_calculo_promedio_Mode( Gx_mode );
      obj185.setgxTv_SdtPais_base_calculo_promedio_Paibasepromhab( A1450PaiBasePromHab );
      obj185.setgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo( A1448PaiBasePromCTipo );
      obj185.setgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar( A1449PaiBasePromFijVar );
      obj185.setgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z( Z1448PaiBasePromCTipo );
      obj185.setgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z( Z1449PaiBasePromFijVar );
      obj185.setgxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z( Z1450PaiBasePromHab );
      obj185.setgxTv_SdtPais_base_calculo_promedio_Modified( nIsMod_185 );
   }

   public void KeyVarsToRow185( web.SdtPais_base_calculo_promedio obj185 )
   {
      obj185.setgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo( A1448PaiBasePromCTipo );
      obj185.setgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar( A1449PaiBasePromFijVar );
   }

   public void RowToVars185( web.SdtPais_base_calculo_promedio obj185 ,
                             int forceLoad )
   {
      Gx_mode = obj185.getgxTv_SdtPais_base_calculo_promedio_Mode() ;
      A1450PaiBasePromHab = obj185.getgxTv_SdtPais_base_calculo_promedio_Paibasepromhab() ;
      A1448PaiBasePromCTipo = obj185.getgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo() ;
      A1449PaiBasePromFijVar = obj185.getgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar() ;
      Z1448PaiBasePromCTipo = obj185.getgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z() ;
      Z1449PaiBasePromFijVar = obj185.getgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z() ;
      Z1450PaiBasePromHab = obj185.getgxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z() ;
      nIsMod_185 = obj185.getgxTv_SdtPais_base_calculo_promedio_Modified() ;
   }

   public void VarsToRow168( web.SdtPais_conceptos_horanormal_jornalizados obj168 )
   {
      obj168.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Mode( Gx_mode );
      obj168.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual( A1360PaiJorHabitual );
      obj168.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod( A1354PaiJorCliCod );
      obj168.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo( A1355PaiJorConCodigo );
      obj168.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z( Z1354PaiJorCliCod );
      obj168.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z( Z1355PaiJorConCodigo );
      obj168.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z( Z1360PaiJorHabitual );
      obj168.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Modified( nIsMod_168 );
   }

   public void KeyVarsToRow168( web.SdtPais_conceptos_horanormal_jornalizados obj168 )
   {
      obj168.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod( A1354PaiJorCliCod );
      obj168.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo( A1355PaiJorConCodigo );
   }

   public void RowToVars168( web.SdtPais_conceptos_horanormal_jornalizados obj168 ,
                             int forceLoad )
   {
      Gx_mode = obj168.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Mode() ;
      A1360PaiJorHabitual = obj168.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual() ;
      A1354PaiJorCliCod = obj168.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod() ;
      A1355PaiJorConCodigo = obj168.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo() ;
      Z1354PaiJorCliCod = obj168.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z() ;
      Z1355PaiJorConCodigo = obj168.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z() ;
      Z1360PaiJorHabitual = obj168.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z() ;
      nIsMod_168 = obj168.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Modified() ;
   }

   public void VarsToRow167( web.SdtPais_conceptos_horanormal_mensualizados obj167 )
   {
      obj167.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Mode( Gx_mode );
      obj167.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual( A1359PaiMesHabitual );
      obj167.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod( A1356PaiMenCliCod );
      obj167.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo( A1358PaiMesConCodigo );
      obj167.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z( Z1356PaiMenCliCod );
      obj167.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z( Z1358PaiMesConCodigo );
      obj167.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z( Z1359PaiMesHabitual );
      obj167.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Modified( nIsMod_167 );
   }

   public void KeyVarsToRow167( web.SdtPais_conceptos_horanormal_mensualizados obj167 )
   {
      obj167.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod( A1356PaiMenCliCod );
      obj167.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo( A1358PaiMesConCodigo );
   }

   public void RowToVars167( web.SdtPais_conceptos_horanormal_mensualizados obj167 ,
                             int forceLoad )
   {
      Gx_mode = obj167.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Mode() ;
      A1359PaiMesHabitual = obj167.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual() ;
      A1356PaiMenCliCod = obj167.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod() ;
      A1358PaiMesConCodigo = obj167.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo() ;
      Z1356PaiMenCliCod = obj167.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z() ;
      Z1358PaiMesConCodigo = obj167.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z() ;
      Z1359PaiMesHabitual = obj167.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z() ;
      nIsMod_167 = obj167.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Modified() ;
   }

   public void VarsToRow169( web.SdtPais_promedio_horanormal_mensualizados obj169 )
   {
      obj169.setgxTv_SdtPais_promedio_horanormal_mensualizados_Mode( Gx_mode );
      obj169.setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual( A1362PaiPromHabitual );
      obj169.setgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod( A37TipoConCod );
      obj169.setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar( A1361PaiPromFijVar );
      obj169.setgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z( Z37TipoConCod );
      obj169.setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z( Z1361PaiPromFijVar );
      obj169.setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z( Z1362PaiPromHabitual );
      obj169.setgxTv_SdtPais_promedio_horanormal_mensualizados_Modified( nIsMod_169 );
   }

   public void KeyVarsToRow169( web.SdtPais_promedio_horanormal_mensualizados obj169 )
   {
      obj169.setgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod( A37TipoConCod );
      obj169.setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar( A1361PaiPromFijVar );
   }

   public void RowToVars169( web.SdtPais_promedio_horanormal_mensualizados obj169 ,
                             int forceLoad )
   {
      Gx_mode = obj169.getgxTv_SdtPais_promedio_horanormal_mensualizados_Mode() ;
      A1362PaiPromHabitual = obj169.getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual() ;
      A37TipoConCod = obj169.getgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod() ;
      A1361PaiPromFijVar = obj169.getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar() ;
      Z37TipoConCod = obj169.getgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z() ;
      Z1361PaiPromFijVar = obj169.getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z() ;
      Z1362PaiPromHabitual = obj169.getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z() ;
      nIsMod_169 = obj169.getgxTv_SdtPais_promedio_horanormal_mensualizados_Modified() ;
   }

   public void VarsToRow155( web.SdtPais_tipo_trabajo obj155 )
   {
      obj155.setgxTv_SdtPais_tipo_trabajo_Mode( Gx_mode );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotranom( A1295PaiTipoTraNom );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotrahor( A1296PaiTipoTraHor );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotrains( A1297PaiTipoTraIns );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipohsdia( A1336PaiTipoHsDia );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipohssem( A1337PaiTipoHsSem );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim( A1338PaiTipoTarifaXLim );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotarifarec( A1347PaiTipoTarifaRec );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia( A1383PaiTipoHsMaxDia );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem( A1384PaiTipoHsMaxSem );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes( A1385PaiTipoHsMaxMes );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu( A1390PaiTipoHsMaxAnu );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotraid( A1294PaiTipoTraId );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotraid_Z( Z1294PaiTipoTraId );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotranom_Z( Z1295PaiTipoTraNom );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z( Z1296PaiTipoTraHor );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotrains_Z( Z1297PaiTipoTraIns );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z( Z1336PaiTipoHsDia );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipohssem_Z( Z1337PaiTipoHsSem );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z( Z1338PaiTipoTarifaXLim );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z( Z1347PaiTipoTarifaRec );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z( Z1383PaiTipoHsMaxDia );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z( Z1384PaiTipoHsMaxSem );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z( Z1385PaiTipoHsMaxMes );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z( Z1390PaiTipoHsMaxAnu );
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotrahor_N( (byte)((byte)((n1296PaiTipoTraHor)?1:0)) );
      obj155.setgxTv_SdtPais_tipo_trabajo_Modified( nIsMod_155 );
   }

   public void KeyVarsToRow155( web.SdtPais_tipo_trabajo obj155 )
   {
      obj155.setgxTv_SdtPais_tipo_trabajo_Paitipotraid( A1294PaiTipoTraId );
   }

   public void RowToVars155( web.SdtPais_tipo_trabajo obj155 ,
                             int forceLoad )
   {
      Gx_mode = obj155.getgxTv_SdtPais_tipo_trabajo_Mode() ;
      A1295PaiTipoTraNom = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipotranom() ;
      A1296PaiTipoTraHor = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipotrahor() ;
      n1296PaiTipoTraHor = false ;
      A1297PaiTipoTraIns = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipotrains() ;
      A1336PaiTipoHsDia = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipohsdia() ;
      A1337PaiTipoHsSem = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipohssem() ;
      A1338PaiTipoTarifaXLim = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim() ;
      A1347PaiTipoTarifaRec = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipotarifarec() ;
      A1383PaiTipoHsMaxDia = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia() ;
      A1384PaiTipoHsMaxSem = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem() ;
      A1385PaiTipoHsMaxMes = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes() ;
      A1390PaiTipoHsMaxAnu = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu() ;
      A1294PaiTipoTraId = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipotraid() ;
      Z1294PaiTipoTraId = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipotraid_Z() ;
      Z1295PaiTipoTraNom = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipotranom_Z() ;
      Z1296PaiTipoTraHor = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z() ;
      Z1297PaiTipoTraIns = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipotrains_Z() ;
      Z1336PaiTipoHsDia = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z() ;
      Z1337PaiTipoHsSem = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipohssem_Z() ;
      Z1338PaiTipoTarifaXLim = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z() ;
      Z1347PaiTipoTarifaRec = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z() ;
      Z1383PaiTipoHsMaxDia = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z() ;
      Z1384PaiTipoHsMaxSem = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z() ;
      Z1385PaiTipoHsMaxMes = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z() ;
      Z1390PaiTipoHsMaxAnu = obj155.getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z() ;
      n1296PaiTipoTraHor = (boolean)((obj155.getgxTv_SdtPais_tipo_trabajo_Paitipotrahor_N()==0)?false:true) ;
      nIsMod_155 = obj155.getgxTv_SdtPais_tipo_trabajo_Modified() ;
   }

   public void VarsToRow164( web.SdtPais_horasextras_pordia obj164 )
   {
      obj164.setgxTv_SdtPais_horasextras_pordia_Mode( Gx_mode );
      obj164.setgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra( A1331PaiHsPDiaTipTra );
      obj164.setgxTv_SdtPais_horasextras_pordia_Paihspdiadia( A1333PaiHsPDiaDia );
      obj164.setgxTv_SdtPais_horasextras_pordia_Paihspdiadesde( A1334PaiHsPDiaDesde );
      obj164.setgxTv_SdtPais_horasextras_pordia_Paitarifapdia( A1335PaiTarifaPDia );
      obj164.setgxTv_SdtPais_horasextras_pordia_Paitarifapdrec( A1348PaiTarifaPDRec );
      obj164.setgxTv_SdtPais_horasextras_pordia_Paihsexsec( A1332PaiHsExSec );
      obj164.setgxTv_SdtPais_horasextras_pordia_Paihsexsec_Z( Z1332PaiHsExSec );
      obj164.setgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z( Z1331PaiHsPDiaTipTra );
      obj164.setgxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z( Z1333PaiHsPDiaDia );
      obj164.setgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z( Z1334PaiHsPDiaDesde );
      obj164.setgxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z( Z1335PaiTarifaPDia );
      obj164.setgxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z( Z1348PaiTarifaPDRec );
      obj164.setgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N( (byte)((byte)((n1334PaiHsPDiaDesde)?1:0)) );
      obj164.setgxTv_SdtPais_horasextras_pordia_Modified( nIsMod_164 );
   }

   public void KeyVarsToRow164( web.SdtPais_horasextras_pordia obj164 )
   {
      obj164.setgxTv_SdtPais_horasextras_pordia_Paihsexsec( A1332PaiHsExSec );
   }

   public void RowToVars164( web.SdtPais_horasextras_pordia obj164 ,
                             int forceLoad )
   {
      Gx_mode = obj164.getgxTv_SdtPais_horasextras_pordia_Mode() ;
      A1331PaiHsPDiaTipTra = obj164.getgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra() ;
      A1333PaiHsPDiaDia = obj164.getgxTv_SdtPais_horasextras_pordia_Paihspdiadia() ;
      A1334PaiHsPDiaDesde = obj164.getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde() ;
      n1334PaiHsPDiaDesde = false ;
      A1335PaiTarifaPDia = obj164.getgxTv_SdtPais_horasextras_pordia_Paitarifapdia() ;
      A1348PaiTarifaPDRec = obj164.getgxTv_SdtPais_horasextras_pordia_Paitarifapdrec() ;
      A1332PaiHsExSec = obj164.getgxTv_SdtPais_horasextras_pordia_Paihsexsec() ;
      Z1332PaiHsExSec = obj164.getgxTv_SdtPais_horasextras_pordia_Paihsexsec_Z() ;
      Z1331PaiHsPDiaTipTra = obj164.getgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z() ;
      Z1333PaiHsPDiaDia = obj164.getgxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z() ;
      Z1334PaiHsPDiaDesde = obj164.getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z() ;
      Z1335PaiTarifaPDia = obj164.getgxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z() ;
      Z1348PaiTarifaPDRec = obj164.getgxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z() ;
      n1334PaiHsPDiaDesde = (boolean)((obj164.getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N()==0)?false:true) ;
      nIsMod_164 = obj164.getgxTv_SdtPais_horasextras_pordia_Modified() ;
   }

   public void VarsToRow240( web.SdtPais_Vacaciones obj240 )
   {
      obj240.setgxTv_SdtPais_Vacaciones_Mode( Gx_mode );
      obj240.setgxTv_SdtPais_Vacaciones_Paivachasant( A1767PaiVacHasAnt );
      obj240.setgxTv_SdtPais_Vacaciones_Paivacdias( A1768PaiVacDias );
      obj240.setgxTv_SdtPais_Vacaciones_Paivacdesant( A1766PaiVacDesAnt );
      obj240.setgxTv_SdtPais_Vacaciones_Paivacdesant_Z( Z1766PaiVacDesAnt );
      obj240.setgxTv_SdtPais_Vacaciones_Paivachasant_Z( Z1767PaiVacHasAnt );
      obj240.setgxTv_SdtPais_Vacaciones_Paivacdias_Z( Z1768PaiVacDias );
      obj240.setgxTv_SdtPais_Vacaciones_Modified( nIsMod_240 );
   }

   public void KeyVarsToRow240( web.SdtPais_Vacaciones obj240 )
   {
      obj240.setgxTv_SdtPais_Vacaciones_Paivacdesant( A1766PaiVacDesAnt );
   }

   public void RowToVars240( web.SdtPais_Vacaciones obj240 ,
                             int forceLoad )
   {
      Gx_mode = obj240.getgxTv_SdtPais_Vacaciones_Mode() ;
      A1767PaiVacHasAnt = obj240.getgxTv_SdtPais_Vacaciones_Paivachasant() ;
      A1768PaiVacDias = obj240.getgxTv_SdtPais_Vacaciones_Paivacdias() ;
      A1766PaiVacDesAnt = obj240.getgxTv_SdtPais_Vacaciones_Paivacdesant() ;
      Z1766PaiVacDesAnt = obj240.getgxTv_SdtPais_Vacaciones_Paivacdesant_Z() ;
      Z1767PaiVacHasAnt = obj240.getgxTv_SdtPais_Vacaciones_Paivachasant_Z() ;
      Z1768PaiVacDias = obj240.getgxTv_SdtPais_Vacaciones_Paivacdias_Z() ;
      nIsMod_240 = obj240.getgxTv_SdtPais_Vacaciones_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1538( ) ;
      scanKeyStart1538( ) ;
      if ( RcdFound38 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z46PaiCod = A46PaiCod ;
      }
      zm1538( -21) ;
      onLoadActions1538( ) ;
      addRow1538( ) ;
      bcPais.getgxTv_SdtPais_Preaviso().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15196( ) ;
         nGXsfl_196_idx = 1 ;
         while ( RcdFound196 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1535PaiAntMayCant = A1535PaiAntMayCant ;
            Z1536PaiAntMayDur = A1536PaiAntMayDur ;
            zm15196( -23) ;
            onLoadActions15196( ) ;
            nRcdExists_196 = (short)(1) ;
            nIsMod_196 = (short)(0) ;
            addRow15196( ) ;
            nGXsfl_196_idx = (int)(nGXsfl_196_idx+1) ;
            scanKeyNext15196( ) ;
         }
         scanKeyEnd15196( ) ;
      }
      bcPais.getgxTv_SdtPais_Base_calculo().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15183( ) ;
         nGXsfl_183_idx = 1 ;
         while ( RcdFound183 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
            Z1441PaiBaseTipo = A1441PaiBaseTipo ;
            Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
            Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
            zm15183( -24) ;
            onLoadActions15183( ) ;
            nRcdExists_183 = (short)(1) ;
            nIsMod_183 = (short)(0) ;
            addRow15183( ) ;
            ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Actual().clearCollection();
            if ( RcdFound183 == 1 )
            {
               scanKeyStart15184( ) ;
               nGXsfl_184_idx = 1 ;
               while ( RcdFound184 != 0 )
               {
                  Z46PaiCod = A46PaiCod ;
                  Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
                  Z1441PaiBaseTipo = A1441PaiBaseTipo ;
                  Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
                  Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
                  Z1445PaiBaseCliCod = A1445PaiBaseCliCod ;
                  Z1446PaiBaseConCodigo = A1446PaiBaseConCodigo ;
                  zm15184( -25) ;
                  onLoadActions15184( ) ;
                  nRcdExists_184 = (short)(1) ;
                  nIsMod_184 = (short)(0) ;
                  addRow15184( ) ;
                  nGXsfl_184_idx = (int)(nGXsfl_184_idx+1) ;
                  scanKeyNext15184( ) ;
               }
               scanKeyEnd15184( ) ;
            }
            ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Promedio().clearCollection();
            if ( RcdFound183 == 1 )
            {
               scanKeyStart15185( ) ;
               nGXsfl_185_idx = 1 ;
               while ( RcdFound185 != 0 )
               {
                  Z46PaiCod = A46PaiCod ;
                  Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
                  Z1441PaiBaseTipo = A1441PaiBaseTipo ;
                  Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
                  Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
                  Z1448PaiBasePromCTipo = A1448PaiBasePromCTipo ;
                  Z1449PaiBasePromFijVar = A1449PaiBasePromFijVar ;
                  zm15185( -27) ;
                  onLoadActions15185( ) ;
                  nRcdExists_185 = (short)(1) ;
                  nIsMod_185 = (short)(0) ;
                  addRow15185( ) ;
                  nGXsfl_185_idx = (int)(nGXsfl_185_idx+1) ;
                  scanKeyNext15185( ) ;
               }
               scanKeyEnd15185( ) ;
            }
            nGXsfl_183_idx = (int)(nGXsfl_183_idx+1) ;
            scanKeyNext15183( ) ;
         }
         scanKeyEnd15183( ) ;
      }
      bcPais.getgxTv_SdtPais_Conceptos_horanormal_jornalizados().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15168( ) ;
         nGXsfl_168_idx = 1 ;
         while ( RcdFound168 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1354PaiJorCliCod = A1354PaiJorCliCod ;
            Z1355PaiJorConCodigo = A1355PaiJorConCodigo ;
            zm15168( -28) ;
            onLoadActions15168( ) ;
            nRcdExists_168 = (short)(1) ;
            nIsMod_168 = (short)(0) ;
            addRow15168( ) ;
            nGXsfl_168_idx = (int)(nGXsfl_168_idx+1) ;
            scanKeyNext15168( ) ;
         }
         scanKeyEnd15168( ) ;
      }
      bcPais.getgxTv_SdtPais_Conceptos_horanormal_mensualizados().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15167( ) ;
         nGXsfl_167_idx = 1 ;
         while ( RcdFound167 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1356PaiMenCliCod = A1356PaiMenCliCod ;
            Z1358PaiMesConCodigo = A1358PaiMesConCodigo ;
            zm15167( -30) ;
            onLoadActions15167( ) ;
            nRcdExists_167 = (short)(1) ;
            nIsMod_167 = (short)(0) ;
            addRow15167( ) ;
            nGXsfl_167_idx = (int)(nGXsfl_167_idx+1) ;
            scanKeyNext15167( ) ;
         }
         scanKeyEnd15167( ) ;
      }
      bcPais.getgxTv_SdtPais_Promedio_horanormal_mensualizados().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15169( ) ;
         nGXsfl_169_idx = 1 ;
         while ( RcdFound169 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z37TipoConCod = A37TipoConCod ;
            Z1361PaiPromFijVar = A1361PaiPromFijVar ;
            zm15169( -32) ;
            onLoadActions15169( ) ;
            nRcdExists_169 = (short)(1) ;
            nIsMod_169 = (short)(0) ;
            addRow15169( ) ;
            nGXsfl_169_idx = (int)(nGXsfl_169_idx+1) ;
            scanKeyNext15169( ) ;
         }
         scanKeyEnd15169( ) ;
      }
      bcPais.getgxTv_SdtPais_Tipo_trabajo().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15155( ) ;
         nGXsfl_155_idx = 1 ;
         while ( RcdFound155 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1294PaiTipoTraId = A1294PaiTipoTraId ;
            zm15155( -34) ;
            onLoadActions15155( ) ;
            nRcdExists_155 = (short)(1) ;
            nIsMod_155 = (short)(0) ;
            addRow15155( ) ;
            nGXsfl_155_idx = (int)(nGXsfl_155_idx+1) ;
            scanKeyNext15155( ) ;
         }
         scanKeyEnd15155( ) ;
      }
      bcPais.getgxTv_SdtPais_Horasextras_pordia().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15164( ) ;
         nGXsfl_164_idx = 1 ;
         while ( RcdFound164 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1332PaiHsExSec = A1332PaiHsExSec ;
            zm15164( -36) ;
            onLoadActions15164( ) ;
            nRcdExists_164 = (short)(1) ;
            nIsMod_164 = (short)(0) ;
            addRow15164( ) ;
            nGXsfl_164_idx = (int)(nGXsfl_164_idx+1) ;
            scanKeyNext15164( ) ;
         }
         scanKeyEnd15164( ) ;
      }
      bcPais.getgxTv_SdtPais_Vacaciones().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15240( ) ;
         nGXsfl_240_idx = 1 ;
         while ( RcdFound240 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1766PaiVacDesAnt = A1766PaiVacDesAnt ;
            zm15240( -38) ;
            onLoadActions15240( ) ;
            nRcdExists_240 = (short)(1) ;
            nIsMod_240 = (short)(0) ;
            addRow15240( ) ;
            nGXsfl_240_idx = (int)(nGXsfl_240_idx+1) ;
            scanKeyNext15240( ) ;
         }
         scanKeyEnd15240( ) ;
      }
      scanKeyEnd1538( ) ;
      if ( RcdFound38 == 0 )
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
      RowToVars38( bcPais, 0) ;
      scanKeyStart1538( ) ;
      if ( RcdFound38 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z46PaiCod = A46PaiCod ;
      }
      zm1538( -21) ;
      onLoadActions1538( ) ;
      addRow1538( ) ;
      bcPais.getgxTv_SdtPais_Preaviso().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15196( ) ;
         nGXsfl_196_idx = 1 ;
         while ( RcdFound196 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1535PaiAntMayCant = A1535PaiAntMayCant ;
            Z1536PaiAntMayDur = A1536PaiAntMayDur ;
            zm15196( -23) ;
            onLoadActions15196( ) ;
            nRcdExists_196 = (short)(1) ;
            nIsMod_196 = (short)(0) ;
            addRow15196( ) ;
            nGXsfl_196_idx = (int)(nGXsfl_196_idx+1) ;
            scanKeyNext15196( ) ;
         }
         scanKeyEnd15196( ) ;
      }
      bcPais.getgxTv_SdtPais_Base_calculo().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15183( ) ;
         nGXsfl_183_idx = 1 ;
         while ( RcdFound183 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
            Z1441PaiBaseTipo = A1441PaiBaseTipo ;
            Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
            Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
            zm15183( -24) ;
            onLoadActions15183( ) ;
            nRcdExists_183 = (short)(1) ;
            nIsMod_183 = (short)(0) ;
            addRow15183( ) ;
            ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Actual().clearCollection();
            if ( RcdFound183 == 1 )
            {
               scanKeyStart15184( ) ;
               nGXsfl_184_idx = 1 ;
               while ( RcdFound184 != 0 )
               {
                  Z46PaiCod = A46PaiCod ;
                  Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
                  Z1441PaiBaseTipo = A1441PaiBaseTipo ;
                  Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
                  Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
                  Z1445PaiBaseCliCod = A1445PaiBaseCliCod ;
                  Z1446PaiBaseConCodigo = A1446PaiBaseConCodigo ;
                  zm15184( -25) ;
                  onLoadActions15184( ) ;
                  nRcdExists_184 = (short)(1) ;
                  nIsMod_184 = (short)(0) ;
                  addRow15184( ) ;
                  nGXsfl_184_idx = (int)(nGXsfl_184_idx+1) ;
                  scanKeyNext15184( ) ;
               }
               scanKeyEnd15184( ) ;
            }
            ((web.SdtPais_base_calculo)bcPais.getgxTv_SdtPais_Base_calculo().elementAt(-1+nGXsfl_183_idx)).getgxTv_SdtPais_base_calculo_Promedio().clearCollection();
            if ( RcdFound183 == 1 )
            {
               scanKeyStart15185( ) ;
               nGXsfl_185_idx = 1 ;
               while ( RcdFound185 != 0 )
               {
                  Z46PaiCod = A46PaiCod ;
                  Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
                  Z1441PaiBaseTipo = A1441PaiBaseTipo ;
                  Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
                  Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
                  Z1448PaiBasePromCTipo = A1448PaiBasePromCTipo ;
                  Z1449PaiBasePromFijVar = A1449PaiBasePromFijVar ;
                  zm15185( -27) ;
                  onLoadActions15185( ) ;
                  nRcdExists_185 = (short)(1) ;
                  nIsMod_185 = (short)(0) ;
                  addRow15185( ) ;
                  nGXsfl_185_idx = (int)(nGXsfl_185_idx+1) ;
                  scanKeyNext15185( ) ;
               }
               scanKeyEnd15185( ) ;
            }
            nGXsfl_183_idx = (int)(nGXsfl_183_idx+1) ;
            scanKeyNext15183( ) ;
         }
         scanKeyEnd15183( ) ;
      }
      bcPais.getgxTv_SdtPais_Conceptos_horanormal_jornalizados().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15168( ) ;
         nGXsfl_168_idx = 1 ;
         while ( RcdFound168 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1354PaiJorCliCod = A1354PaiJorCliCod ;
            Z1355PaiJorConCodigo = A1355PaiJorConCodigo ;
            zm15168( -28) ;
            onLoadActions15168( ) ;
            nRcdExists_168 = (short)(1) ;
            nIsMod_168 = (short)(0) ;
            addRow15168( ) ;
            nGXsfl_168_idx = (int)(nGXsfl_168_idx+1) ;
            scanKeyNext15168( ) ;
         }
         scanKeyEnd15168( ) ;
      }
      bcPais.getgxTv_SdtPais_Conceptos_horanormal_mensualizados().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15167( ) ;
         nGXsfl_167_idx = 1 ;
         while ( RcdFound167 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1356PaiMenCliCod = A1356PaiMenCliCod ;
            Z1358PaiMesConCodigo = A1358PaiMesConCodigo ;
            zm15167( -30) ;
            onLoadActions15167( ) ;
            nRcdExists_167 = (short)(1) ;
            nIsMod_167 = (short)(0) ;
            addRow15167( ) ;
            nGXsfl_167_idx = (int)(nGXsfl_167_idx+1) ;
            scanKeyNext15167( ) ;
         }
         scanKeyEnd15167( ) ;
      }
      bcPais.getgxTv_SdtPais_Promedio_horanormal_mensualizados().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15169( ) ;
         nGXsfl_169_idx = 1 ;
         while ( RcdFound169 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z37TipoConCod = A37TipoConCod ;
            Z1361PaiPromFijVar = A1361PaiPromFijVar ;
            zm15169( -32) ;
            onLoadActions15169( ) ;
            nRcdExists_169 = (short)(1) ;
            nIsMod_169 = (short)(0) ;
            addRow15169( ) ;
            nGXsfl_169_idx = (int)(nGXsfl_169_idx+1) ;
            scanKeyNext15169( ) ;
         }
         scanKeyEnd15169( ) ;
      }
      bcPais.getgxTv_SdtPais_Tipo_trabajo().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15155( ) ;
         nGXsfl_155_idx = 1 ;
         while ( RcdFound155 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1294PaiTipoTraId = A1294PaiTipoTraId ;
            zm15155( -34) ;
            onLoadActions15155( ) ;
            nRcdExists_155 = (short)(1) ;
            nIsMod_155 = (short)(0) ;
            addRow15155( ) ;
            nGXsfl_155_idx = (int)(nGXsfl_155_idx+1) ;
            scanKeyNext15155( ) ;
         }
         scanKeyEnd15155( ) ;
      }
      bcPais.getgxTv_SdtPais_Horasextras_pordia().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15164( ) ;
         nGXsfl_164_idx = 1 ;
         while ( RcdFound164 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1332PaiHsExSec = A1332PaiHsExSec ;
            zm15164( -36) ;
            onLoadActions15164( ) ;
            nRcdExists_164 = (short)(1) ;
            nIsMod_164 = (short)(0) ;
            addRow15164( ) ;
            nGXsfl_164_idx = (int)(nGXsfl_164_idx+1) ;
            scanKeyNext15164( ) ;
         }
         scanKeyEnd15164( ) ;
      }
      bcPais.getgxTv_SdtPais_Vacaciones().clearCollection();
      if ( RcdFound38 == 1 )
      {
         scanKeyStart15240( ) ;
         nGXsfl_240_idx = 1 ;
         while ( RcdFound240 != 0 )
         {
            Z46PaiCod = A46PaiCod ;
            Z1766PaiVacDesAnt = A1766PaiVacDesAnt ;
            zm15240( -38) ;
            onLoadActions15240( ) ;
            nRcdExists_240 = (short)(1) ;
            nIsMod_240 = (short)(0) ;
            addRow15240( ) ;
            nGXsfl_240_idx = (int)(nGXsfl_240_idx+1) ;
            scanKeyNext15240( ) ;
         }
         scanKeyEnd15240( ) ;
      }
      scanKeyEnd1538( ) ;
      if ( RcdFound38 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1538( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1538( ) ;
      }
      else
      {
         if ( RcdFound38 == 1 )
         {
            if ( A46PaiCod != Z46PaiCod )
            {
               A46PaiCod = Z46PaiCod ;
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
               update1538( ) ;
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
               if ( A46PaiCod != Z46PaiCod )
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
                     insert1538( ) ;
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
                     insert1538( ) ;
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
      RowToVars38( bcPais, 1) ;
      saveImpl( ) ;
      VarsToRow38( bcPais) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars38( bcPais, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1538( ) ;
      afterTrn( ) ;
      VarsToRow38( bcPais) ;
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
         web.SdtPais auxBC = new web.SdtPais( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A46PaiCod);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcPais);
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
      RowToVars38( bcPais, 1) ;
      updateImpl( ) ;
      VarsToRow38( bcPais) ;
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
      RowToVars38( bcPais, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1538( ) ;
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
      VarsToRow38( bcPais) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars38( bcPais, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1538( ) ;
      if ( RcdFound38 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A46PaiCod != Z46PaiCod )
         {
            A46PaiCod = Z46PaiCod ;
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
         if ( A46PaiCod != Z46PaiCod )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "pais_bc");
      VarsToRow38( bcPais) ;
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
      Gx_mode = bcPais.getgxTv_SdtPais_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcPais.setgxTv_SdtPais_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtPais sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcPais )
      {
         bcPais = sdt ;
         if ( GXutil.strcmp(bcPais.getgxTv_SdtPais_Mode(), "") == 0 )
         {
            bcPais.setgxTv_SdtPais_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow38( bcPais) ;
         }
         else
         {
            RowToVars38( bcPais, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcPais.getgxTv_SdtPais_Mode(), "") == 0 )
         {
            bcPais.setgxTv_SdtPais_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars38( bcPais, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtPais getPais_BC( )
   {
      return bcPais ;
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
      sMode38 = "" ;
      sMode183 = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV29Pgmname = "" ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13Insert_PaiReligDefault = "" ;
      Z312PaiNom = "" ;
      A312PaiNom = "" ;
      Z1271PaiMesHsPExt = DecimalUtil.ZERO ;
      A1271PaiMesHsPExt = DecimalUtil.ZERO ;
      Z1272PaiDiaHsPExt = "" ;
      A1272PaiDiaHsPExt = "" ;
      Z1405PaiMaxHorNor = DecimalUtil.ZERO ;
      A1405PaiMaxHorNor = DecimalUtil.ZERO ;
      Z1814PaiFracVacAnt = DecimalUtil.ZERO ;
      A1814PaiFracVacAnt = DecimalUtil.ZERO ;
      Z1590PaiPromMesTCnt = "" ;
      A1590PaiPromMesTCnt = "" ;
      Z1591PaiPromJorMesTCnt = "" ;
      A1591PaiPromJorMesTCnt = "" ;
      Z1737PaiVizzoti = DecimalUtil.ZERO ;
      A1737PaiVizzoti = DecimalUtil.ZERO ;
      Z1252PaiReligDefault = "" ;
      A1252PaiReligDefault = "" ;
      BC001531_A46PaiCod = new short[1] ;
      BC001531_A312PaiNom = new String[] {""} ;
      BC001531_A311PaiNacMostrar = new boolean[] {false} ;
      BC001531_A310PaiDomMostrar = new boolean[] {false} ;
      BC001531_A1271PaiMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001531_A1272PaiDiaHsPExt = new String[] {""} ;
      BC001531_A1402PaiFondoCese = new boolean[] {false} ;
      BC001531_A1405PaiMaxHorNor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001531_A1521PaiPerVacDes = new byte[1] ;
      BC001531_A1522PaiPerVacHas = new byte[1] ;
      BC001531_A1814PaiFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001531_A1363PaiPromMeses = new byte[1] ;
      BC001531_A1590PaiPromMesTCnt = new String[] {""} ;
      BC001531_A1573PaiPromJorMeses = new byte[1] ;
      BC001531_A1591PaiPromJorMesTCnt = new String[] {""} ;
      BC001531_A1625PaiGuarEdadMin = new byte[1] ;
      BC001531_A1626PaiGuarEdadMax = new byte[1] ;
      BC001531_A1736PaiExcVizzoti = new boolean[] {false} ;
      BC001531_A1737PaiVizzoti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001531_A1764PaiMinMesesVac = new byte[1] ;
      BC001531_A1765PaiInterDiasJor = new short[1] ;
      BC001531_A1793PaiTipoExpDef = new byte[1] ;
      BC001531_A1252PaiReligDefault = new String[] {""} ;
      BC001531_n1252PaiReligDefault = new boolean[] {false} ;
      BC001532_A1252PaiReligDefault = new String[] {""} ;
      BC001532_n1252PaiReligDefault = new boolean[] {false} ;
      BC001533_A46PaiCod = new short[1] ;
      BC001534_A46PaiCod = new short[1] ;
      BC001534_A312PaiNom = new String[] {""} ;
      BC001534_A311PaiNacMostrar = new boolean[] {false} ;
      BC001534_A310PaiDomMostrar = new boolean[] {false} ;
      BC001534_A1271PaiMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001534_A1272PaiDiaHsPExt = new String[] {""} ;
      BC001534_A1402PaiFondoCese = new boolean[] {false} ;
      BC001534_A1405PaiMaxHorNor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001534_A1521PaiPerVacDes = new byte[1] ;
      BC001534_A1522PaiPerVacHas = new byte[1] ;
      BC001534_A1814PaiFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001534_A1363PaiPromMeses = new byte[1] ;
      BC001534_A1590PaiPromMesTCnt = new String[] {""} ;
      BC001534_A1573PaiPromJorMeses = new byte[1] ;
      BC001534_A1591PaiPromJorMesTCnt = new String[] {""} ;
      BC001534_A1625PaiGuarEdadMin = new byte[1] ;
      BC001534_A1626PaiGuarEdadMax = new byte[1] ;
      BC001534_A1736PaiExcVizzoti = new boolean[] {false} ;
      BC001534_A1737PaiVizzoti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001534_A1764PaiMinMesesVac = new byte[1] ;
      BC001534_A1765PaiInterDiasJor = new short[1] ;
      BC001534_A1793PaiTipoExpDef = new byte[1] ;
      BC001534_A1252PaiReligDefault = new String[] {""} ;
      BC001534_n1252PaiReligDefault = new boolean[] {false} ;
      BC001535_A46PaiCod = new short[1] ;
      BC001535_A312PaiNom = new String[] {""} ;
      BC001535_A311PaiNacMostrar = new boolean[] {false} ;
      BC001535_A310PaiDomMostrar = new boolean[] {false} ;
      BC001535_A1271PaiMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001535_A1272PaiDiaHsPExt = new String[] {""} ;
      BC001535_A1402PaiFondoCese = new boolean[] {false} ;
      BC001535_A1405PaiMaxHorNor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001535_A1521PaiPerVacDes = new byte[1] ;
      BC001535_A1522PaiPerVacHas = new byte[1] ;
      BC001535_A1814PaiFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001535_A1363PaiPromMeses = new byte[1] ;
      BC001535_A1590PaiPromMesTCnt = new String[] {""} ;
      BC001535_A1573PaiPromJorMeses = new byte[1] ;
      BC001535_A1591PaiPromJorMesTCnt = new String[] {""} ;
      BC001535_A1625PaiGuarEdadMin = new byte[1] ;
      BC001535_A1626PaiGuarEdadMax = new byte[1] ;
      BC001535_A1736PaiExcVizzoti = new boolean[] {false} ;
      BC001535_A1737PaiVizzoti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001535_A1764PaiMinMesesVac = new byte[1] ;
      BC001535_A1765PaiInterDiasJor = new short[1] ;
      BC001535_A1793PaiTipoExpDef = new byte[1] ;
      BC001535_A1252PaiReligDefault = new String[] {""} ;
      BC001535_n1252PaiReligDefault = new boolean[] {false} ;
      BC001539_A37TipoConCod = new String[] {""} ;
      BC001540_A1923RolId = new byte[1] ;
      BC001540_A1925PerfilId = new byte[1] ;
      BC001540_A1928MenuVerId = new long[1] ;
      BC001541_A953ConCondicion = new String[] {""} ;
      BC001542_A1748EstaCivilCod = new short[1] ;
      BC001543_A1743SexoId = new byte[1] ;
      BC001544_A3CliCod = new int[1] ;
      BC001544_A26ConCodigo = new String[] {""} ;
      BC001545_A16SitCodigo = new String[] {""} ;
      BC001546_A3CliCod = new int[1] ;
      BC001546_A1564CliPaiConve = new short[1] ;
      BC001546_A1565CliConvenio = new String[] {""} ;
      BC001546_A8CatCodigo = new String[] {""} ;
      BC001546_A2200CatPaiCod = new short[1] ;
      BC001546_A2201CatProvCod = new short[1] ;
      BC001547_A3CliCod = new int[1] ;
      BC001547_A1564CliPaiConve = new short[1] ;
      BC001547_A1565CliConvenio = new String[] {""} ;
      BC001548_A3CliCod = new int[1] ;
      BC001548_A1EmpCod = new short[1] ;
      BC001548_A1562EmpConvePai = new short[1] ;
      BC001548_A1561EmpConveCod = new String[] {""} ;
      BC001549_A1161EmbargaSec = new short[1] ;
      BC001550_A1163TipoOblSec = new short[1] ;
      BC001551_A1151ARTSec = new short[1] ;
      BC001552_A903ActComCodigo = new String[] {""} ;
      BC001552_A993ActComAdiPai = new short[1] ;
      BC001552_A994ActComAdiCod = new String[] {""} ;
      BC001553_A67SecUserId = new short[1] ;
      BC001554_A46PaiCod = new short[1] ;
      BC001554_A2217ActLabNro = new int[1] ;
      BC001555_A46PaiCod = new short[1] ;
      BC001555_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001555_A1441PaiBaseTipo = new String[] {""} ;
      BC001555_A1442PaiBaseCod1 = new String[] {""} ;
      BC001555_A1443PaiBaseCod2 = new String[] {""} ;
      BC001556_A46PaiCod = new short[1] ;
      BC001556_A1395PaiRanEtDesde = new short[1] ;
      BC001557_A46PaiCod = new short[1] ;
      BC001557_A1332PaiHsExSec = new short[1] ;
      BC001558_A46PaiCod = new short[1] ;
      BC001558_A1282PaiOrigen = new String[] {""} ;
      BC001559_A46PaiCod = new short[1] ;
      BC001559_A1253PaiReligion = new String[] {""} ;
      BC001560_A46PaiCod = new short[1] ;
      BC001560_A1223FerId = new String[] {""} ;
      BC001561_A46PaiCod = new short[1] ;
      BC001561_A1221FerTipo = new String[] {""} ;
      BC001562_A46PaiCod = new short[1] ;
      BC001562_A988AdicionalCod = new String[] {""} ;
      BC001563_A46PaiCod = new short[1] ;
      BC001563_A14SinCod = new String[] {""} ;
      BC001564_A46PaiCod = new short[1] ;
      BC001564_A9ConveCodigo = new String[] {""} ;
      BC001565_A46PaiCod = new short[1] ;
      BC001565_A74idOperando = new String[] {""} ;
      BC001566_A46PaiCod = new short[1] ;
      BC001566_A47ProvCod = new short[1] ;
      BC001567_A3CliCod = new int[1] ;
      BC001567_A1EmpCod = new short[1] ;
      BC001567_A6LegNumero = new int[1] ;
      BC001568_A3CliCod = new int[1] ;
      BC001568_A1EmpCod = new short[1] ;
      BC001568_A6LegNumero = new int[1] ;
      BC001569_A3CliCod = new int[1] ;
      BC001570_A46PaiCod = new short[1] ;
      BC001570_A312PaiNom = new String[] {""} ;
      BC001570_A311PaiNacMostrar = new boolean[] {false} ;
      BC001570_A310PaiDomMostrar = new boolean[] {false} ;
      BC001570_A1271PaiMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001570_A1272PaiDiaHsPExt = new String[] {""} ;
      BC001570_A1402PaiFondoCese = new boolean[] {false} ;
      BC001570_A1405PaiMaxHorNor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001570_A1521PaiPerVacDes = new byte[1] ;
      BC001570_A1522PaiPerVacHas = new byte[1] ;
      BC001570_A1814PaiFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001570_A1363PaiPromMeses = new byte[1] ;
      BC001570_A1590PaiPromMesTCnt = new String[] {""} ;
      BC001570_A1573PaiPromJorMeses = new byte[1] ;
      BC001570_A1591PaiPromJorMesTCnt = new String[] {""} ;
      BC001570_A1625PaiGuarEdadMin = new byte[1] ;
      BC001570_A1626PaiGuarEdadMax = new byte[1] ;
      BC001570_A1736PaiExcVizzoti = new boolean[] {false} ;
      BC001570_A1737PaiVizzoti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001570_A1764PaiMinMesesVac = new byte[1] ;
      BC001570_A1765PaiInterDiasJor = new short[1] ;
      BC001570_A1793PaiTipoExpDef = new byte[1] ;
      BC001570_A1252PaiReligDefault = new String[] {""} ;
      BC001570_n1252PaiReligDefault = new boolean[] {false} ;
      Z1538PaiPreAviDur = "" ;
      A1538PaiPreAviDur = "" ;
      Z1536PaiAntMayDur = "" ;
      A1536PaiAntMayDur = "" ;
      BC001571_A46PaiCod = new short[1] ;
      BC001571_A1535PaiAntMayCant = new byte[1] ;
      BC001571_A1536PaiAntMayDur = new String[] {""} ;
      BC001571_A1537PaiPreAviCant = new byte[1] ;
      BC001571_A1538PaiPreAviDur = new String[] {""} ;
      BC001572_A46PaiCod = new short[1] ;
      BC001572_A1535PaiAntMayCant = new byte[1] ;
      BC001572_A1536PaiAntMayDur = new String[] {""} ;
      BC001573_A46PaiCod = new short[1] ;
      BC001573_A1535PaiAntMayCant = new byte[1] ;
      BC001573_A1536PaiAntMayDur = new String[] {""} ;
      BC001573_A1537PaiPreAviCant = new byte[1] ;
      BC001573_A1538PaiPreAviDur = new String[] {""} ;
      sMode196 = "" ;
      BC001574_A46PaiCod = new short[1] ;
      BC001574_A1535PaiAntMayCant = new byte[1] ;
      BC001574_A1536PaiAntMayDur = new String[] {""} ;
      BC001574_A1537PaiPreAviCant = new byte[1] ;
      BC001574_A1538PaiPreAviDur = new String[] {""} ;
      BC001578_A46PaiCod = new short[1] ;
      BC001578_A1535PaiAntMayCant = new byte[1] ;
      BC001578_A1536PaiAntMayDur = new String[] {""} ;
      BC001578_A1537PaiPreAviCant = new byte[1] ;
      BC001578_A1538PaiPreAviDur = new String[] {""} ;
      Z1444PaiBasePlus = DecimalUtil.ZERO ;
      A1444PaiBasePlus = DecimalUtil.ZERO ;
      Z1453PaiBasePromTCnt = "" ;
      A1453PaiBasePromTCnt = "" ;
      Z1441PaiBaseTipo = "" ;
      A1441PaiBaseTipo = "" ;
      Z1442PaiBaseCod1 = "" ;
      A1442PaiBaseCod1 = "" ;
      Z1443PaiBaseCod2 = "" ;
      A1443PaiBaseCod2 = "" ;
      BC001579_A46PaiCod = new short[1] ;
      BC001579_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001579_A1441PaiBaseTipo = new String[] {""} ;
      BC001579_A1442PaiBaseCod1 = new String[] {""} ;
      BC001579_A1443PaiBaseCod2 = new String[] {""} ;
      BC001579_A1444PaiBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001579_A1629PaiLicDLim = new short[1] ;
      BC001579_A1630PaiLicDSeman = new byte[1] ;
      BC001579_A1631PaiLicDMes = new byte[1] ;
      BC001579_A1632PaiLicDSemes = new short[1] ;
      BC001579_A1633PaiLicDAnual = new short[1] ;
      BC001579_A1634PaiLicAdju = new boolean[] {false} ;
      BC001579_A1635PaiLicAdjuObl = new boolean[] {false} ;
      BC001579_A1636PaiLicNecAut = new boolean[] {false} ;
      BC001579_A1637PaiLicIngMot = new boolean[] {false} ;
      BC001579_A1638PaiLicMotObl = new boolean[] {false} ;
      BC001579_A1451PaiBasePromCnt1 = new short[1] ;
      BC001579_A1452PaiBasePromCnt2 = new short[1] ;
      BC001579_A1453PaiBasePromTCnt = new String[] {""} ;
      BC001580_A46PaiCod = new short[1] ;
      BC001580_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001580_A1441PaiBaseTipo = new String[] {""} ;
      BC001580_A1442PaiBaseCod1 = new String[] {""} ;
      BC001580_A1443PaiBaseCod2 = new String[] {""} ;
      BC001581_A46PaiCod = new short[1] ;
      BC001581_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001581_A1441PaiBaseTipo = new String[] {""} ;
      BC001581_A1442PaiBaseCod1 = new String[] {""} ;
      BC001581_A1443PaiBaseCod2 = new String[] {""} ;
      BC001581_A1444PaiBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001581_A1629PaiLicDLim = new short[1] ;
      BC001581_A1630PaiLicDSeman = new byte[1] ;
      BC001581_A1631PaiLicDMes = new byte[1] ;
      BC001581_A1632PaiLicDSemes = new short[1] ;
      BC001581_A1633PaiLicDAnual = new short[1] ;
      BC001581_A1634PaiLicAdju = new boolean[] {false} ;
      BC001581_A1635PaiLicAdjuObl = new boolean[] {false} ;
      BC001581_A1636PaiLicNecAut = new boolean[] {false} ;
      BC001581_A1637PaiLicIngMot = new boolean[] {false} ;
      BC001581_A1638PaiLicMotObl = new boolean[] {false} ;
      BC001581_A1451PaiBasePromCnt1 = new short[1] ;
      BC001581_A1452PaiBasePromCnt2 = new short[1] ;
      BC001581_A1453PaiBasePromTCnt = new String[] {""} ;
      BC001582_A46PaiCod = new short[1] ;
      BC001582_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001582_A1441PaiBaseTipo = new String[] {""} ;
      BC001582_A1442PaiBaseCod1 = new String[] {""} ;
      BC001582_A1443PaiBaseCod2 = new String[] {""} ;
      BC001582_A1444PaiBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001582_A1629PaiLicDLim = new short[1] ;
      BC001582_A1630PaiLicDSeman = new byte[1] ;
      BC001582_A1631PaiLicDMes = new byte[1] ;
      BC001582_A1632PaiLicDSemes = new short[1] ;
      BC001582_A1633PaiLicDAnual = new short[1] ;
      BC001582_A1634PaiLicAdju = new boolean[] {false} ;
      BC001582_A1635PaiLicAdjuObl = new boolean[] {false} ;
      BC001582_A1636PaiLicNecAut = new boolean[] {false} ;
      BC001582_A1637PaiLicIngMot = new boolean[] {false} ;
      BC001582_A1638PaiLicMotObl = new boolean[] {false} ;
      BC001582_A1451PaiBasePromCnt1 = new short[1] ;
      BC001582_A1452PaiBasePromCnt2 = new short[1] ;
      BC001582_A1453PaiBasePromTCnt = new String[] {""} ;
      BC001586_A46PaiCod = new short[1] ;
      BC001586_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001586_A1441PaiBaseTipo = new String[] {""} ;
      BC001586_A1442PaiBaseCod1 = new String[] {""} ;
      BC001586_A1443PaiBaseCod2 = new String[] {""} ;
      BC001586_A1444PaiBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001586_A1629PaiLicDLim = new short[1] ;
      BC001586_A1630PaiLicDSeman = new byte[1] ;
      BC001586_A1631PaiLicDMes = new byte[1] ;
      BC001586_A1632PaiLicDSemes = new short[1] ;
      BC001586_A1633PaiLicDAnual = new short[1] ;
      BC001586_A1634PaiLicAdju = new boolean[] {false} ;
      BC001586_A1635PaiLicAdjuObl = new boolean[] {false} ;
      BC001586_A1636PaiLicNecAut = new boolean[] {false} ;
      BC001586_A1637PaiLicIngMot = new boolean[] {false} ;
      BC001586_A1638PaiLicMotObl = new boolean[] {false} ;
      BC001586_A1451PaiBasePromCnt1 = new short[1] ;
      BC001586_A1452PaiBasePromCnt2 = new short[1] ;
      BC001586_A1453PaiBasePromTCnt = new String[] {""} ;
      Z1446PaiBaseConCodigo = "" ;
      A1446PaiBaseConCodigo = "" ;
      BC001587_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001587_A1441PaiBaseTipo = new String[] {""} ;
      BC001587_A1442PaiBaseCod1 = new String[] {""} ;
      BC001587_A1443PaiBaseCod2 = new String[] {""} ;
      BC001587_A1447PaiBaseConHabitual = new boolean[] {false} ;
      BC001587_A1445PaiBaseCliCod = new int[1] ;
      BC001587_A1446PaiBaseConCodigo = new String[] {""} ;
      BC001587_A46PaiCod = new short[1] ;
      BC001588_A1445PaiBaseCliCod = new int[1] ;
      BC001589_A46PaiCod = new short[1] ;
      BC001589_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001589_A1441PaiBaseTipo = new String[] {""} ;
      BC001589_A1442PaiBaseCod1 = new String[] {""} ;
      BC001589_A1443PaiBaseCod2 = new String[] {""} ;
      BC001589_A1445PaiBaseCliCod = new int[1] ;
      BC001589_A1446PaiBaseConCodigo = new String[] {""} ;
      BC001590_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001590_A1441PaiBaseTipo = new String[] {""} ;
      BC001590_A1442PaiBaseCod1 = new String[] {""} ;
      BC001590_A1443PaiBaseCod2 = new String[] {""} ;
      BC001590_A1447PaiBaseConHabitual = new boolean[] {false} ;
      BC001590_A1445PaiBaseCliCod = new int[1] ;
      BC001590_A1446PaiBaseConCodigo = new String[] {""} ;
      BC001590_A46PaiCod = new short[1] ;
      sMode184 = "" ;
      BC001591_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001591_A1441PaiBaseTipo = new String[] {""} ;
      BC001591_A1442PaiBaseCod1 = new String[] {""} ;
      BC001591_A1443PaiBaseCod2 = new String[] {""} ;
      BC001591_A1447PaiBaseConHabitual = new boolean[] {false} ;
      BC001591_A1445PaiBaseCliCod = new int[1] ;
      BC001591_A1446PaiBaseConCodigo = new String[] {""} ;
      BC001591_A46PaiCod = new short[1] ;
      BC001595_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001595_A1441PaiBaseTipo = new String[] {""} ;
      BC001595_A1442PaiBaseCod1 = new String[] {""} ;
      BC001595_A1443PaiBaseCod2 = new String[] {""} ;
      BC001595_A1447PaiBaseConHabitual = new boolean[] {false} ;
      BC001595_A1445PaiBaseCliCod = new int[1] ;
      BC001595_A1446PaiBaseConCodigo = new String[] {""} ;
      BC001595_A46PaiCod = new short[1] ;
      Z1448PaiBasePromCTipo = "" ;
      A1448PaiBasePromCTipo = "" ;
      Z1449PaiBasePromFijVar = "" ;
      A1449PaiBasePromFijVar = "" ;
      BC001596_A46PaiCod = new short[1] ;
      BC001596_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001596_A1441PaiBaseTipo = new String[] {""} ;
      BC001596_A1442PaiBaseCod1 = new String[] {""} ;
      BC001596_A1443PaiBaseCod2 = new String[] {""} ;
      BC001596_A1448PaiBasePromCTipo = new String[] {""} ;
      BC001596_A1449PaiBasePromFijVar = new String[] {""} ;
      BC001596_A1450PaiBasePromHab = new boolean[] {false} ;
      BC001597_A46PaiCod = new short[1] ;
      BC001597_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001597_A1441PaiBaseTipo = new String[] {""} ;
      BC001597_A1442PaiBaseCod1 = new String[] {""} ;
      BC001597_A1443PaiBaseCod2 = new String[] {""} ;
      BC001597_A1448PaiBasePromCTipo = new String[] {""} ;
      BC001597_A1449PaiBasePromFijVar = new String[] {""} ;
      BC001598_A46PaiCod = new short[1] ;
      BC001598_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001598_A1441PaiBaseTipo = new String[] {""} ;
      BC001598_A1442PaiBaseCod1 = new String[] {""} ;
      BC001598_A1443PaiBaseCod2 = new String[] {""} ;
      BC001598_A1448PaiBasePromCTipo = new String[] {""} ;
      BC001598_A1449PaiBasePromFijVar = new String[] {""} ;
      BC001598_A1450PaiBasePromHab = new boolean[] {false} ;
      sMode185 = "" ;
      BC001599_A46PaiCod = new short[1] ;
      BC001599_A1440PaiBaseClaseLeg = new byte[1] ;
      BC001599_A1441PaiBaseTipo = new String[] {""} ;
      BC001599_A1442PaiBaseCod1 = new String[] {""} ;
      BC001599_A1443PaiBaseCod2 = new String[] {""} ;
      BC001599_A1448PaiBasePromCTipo = new String[] {""} ;
      BC001599_A1449PaiBasePromFijVar = new String[] {""} ;
      BC001599_A1450PaiBasePromHab = new boolean[] {false} ;
      BC0015103_A46PaiCod = new short[1] ;
      BC0015103_A1440PaiBaseClaseLeg = new byte[1] ;
      BC0015103_A1441PaiBaseTipo = new String[] {""} ;
      BC0015103_A1442PaiBaseCod1 = new String[] {""} ;
      BC0015103_A1443PaiBaseCod2 = new String[] {""} ;
      BC0015103_A1448PaiBasePromCTipo = new String[] {""} ;
      BC0015103_A1449PaiBasePromFijVar = new String[] {""} ;
      BC0015103_A1450PaiBasePromHab = new boolean[] {false} ;
      Z1355PaiJorConCodigo = "" ;
      A1355PaiJorConCodigo = "" ;
      BC0015104_A1360PaiJorHabitual = new boolean[] {false} ;
      BC0015104_A1354PaiJorCliCod = new int[1] ;
      BC0015104_A1355PaiJorConCodigo = new String[] {""} ;
      BC0015104_A46PaiCod = new short[1] ;
      BC0015105_A1354PaiJorCliCod = new int[1] ;
      BC0015106_A46PaiCod = new short[1] ;
      BC0015106_A1354PaiJorCliCod = new int[1] ;
      BC0015106_A1355PaiJorConCodigo = new String[] {""} ;
      BC0015107_A1360PaiJorHabitual = new boolean[] {false} ;
      BC0015107_A1354PaiJorCliCod = new int[1] ;
      BC0015107_A1355PaiJorConCodigo = new String[] {""} ;
      BC0015107_A46PaiCod = new short[1] ;
      sMode168 = "" ;
      BC0015108_A1360PaiJorHabitual = new boolean[] {false} ;
      BC0015108_A1354PaiJorCliCod = new int[1] ;
      BC0015108_A1355PaiJorConCodigo = new String[] {""} ;
      BC0015108_A46PaiCod = new short[1] ;
      BC0015112_A1360PaiJorHabitual = new boolean[] {false} ;
      BC0015112_A1354PaiJorCliCod = new int[1] ;
      BC0015112_A1355PaiJorConCodigo = new String[] {""} ;
      BC0015112_A46PaiCod = new short[1] ;
      Z1358PaiMesConCodigo = "" ;
      A1358PaiMesConCodigo = "" ;
      BC0015113_A1359PaiMesHabitual = new boolean[] {false} ;
      BC0015113_A1356PaiMenCliCod = new int[1] ;
      BC0015113_A1358PaiMesConCodigo = new String[] {""} ;
      BC0015113_A46PaiCod = new short[1] ;
      BC0015114_A1356PaiMenCliCod = new int[1] ;
      BC0015115_A46PaiCod = new short[1] ;
      BC0015115_A1356PaiMenCliCod = new int[1] ;
      BC0015115_A1358PaiMesConCodigo = new String[] {""} ;
      BC0015116_A1359PaiMesHabitual = new boolean[] {false} ;
      BC0015116_A1356PaiMenCliCod = new int[1] ;
      BC0015116_A1358PaiMesConCodigo = new String[] {""} ;
      BC0015116_A46PaiCod = new short[1] ;
      sMode167 = "" ;
      BC0015117_A1359PaiMesHabitual = new boolean[] {false} ;
      BC0015117_A1356PaiMenCliCod = new int[1] ;
      BC0015117_A1358PaiMesConCodigo = new String[] {""} ;
      BC0015117_A46PaiCod = new short[1] ;
      BC0015121_A1359PaiMesHabitual = new boolean[] {false} ;
      BC0015121_A1356PaiMenCliCod = new int[1] ;
      BC0015121_A1358PaiMesConCodigo = new String[] {""} ;
      BC0015121_A46PaiCod = new short[1] ;
      Z1361PaiPromFijVar = "" ;
      A1361PaiPromFijVar = "" ;
      Z37TipoConCod = "" ;
      A37TipoConCod = "" ;
      BC0015122_A46PaiCod = new short[1] ;
      BC0015122_A1361PaiPromFijVar = new String[] {""} ;
      BC0015122_A1362PaiPromHabitual = new boolean[] {false} ;
      BC0015122_A37TipoConCod = new String[] {""} ;
      BC0015123_A37TipoConCod = new String[] {""} ;
      BC0015124_A46PaiCod = new short[1] ;
      BC0015124_A37TipoConCod = new String[] {""} ;
      BC0015124_A1361PaiPromFijVar = new String[] {""} ;
      BC0015125_A46PaiCod = new short[1] ;
      BC0015125_A1361PaiPromFijVar = new String[] {""} ;
      BC0015125_A1362PaiPromHabitual = new boolean[] {false} ;
      BC0015125_A37TipoConCod = new String[] {""} ;
      sMode169 = "" ;
      BC0015126_A46PaiCod = new short[1] ;
      BC0015126_A1361PaiPromFijVar = new String[] {""} ;
      BC0015126_A1362PaiPromHabitual = new boolean[] {false} ;
      BC0015126_A37TipoConCod = new String[] {""} ;
      BC0015130_A46PaiCod = new short[1] ;
      BC0015130_A1361PaiPromFijVar = new String[] {""} ;
      BC0015130_A1362PaiPromHabitual = new boolean[] {false} ;
      BC0015130_A37TipoConCod = new String[] {""} ;
      Z1296PaiTipoTraHor = "" ;
      A1296PaiTipoTraHor = "" ;
      Z1336PaiTipoHsDia = DecimalUtil.ZERO ;
      A1336PaiTipoHsDia = DecimalUtil.ZERO ;
      Z1337PaiTipoHsSem = DecimalUtil.ZERO ;
      A1337PaiTipoHsSem = DecimalUtil.ZERO ;
      Z1338PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      A1338PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      Z1347PaiTipoTarifaRec = DecimalUtil.ZERO ;
      A1347PaiTipoTarifaRec = DecimalUtil.ZERO ;
      Z1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      A1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      Z1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      A1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      Z1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      A1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      Z1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      A1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      Z1295PaiTipoTraNom = "" ;
      A1295PaiTipoTraNom = "" ;
      A1293TipoTraNom = "" ;
      Z1294PaiTipoTraId = "" ;
      A1294PaiTipoTraId = "" ;
      Z1292TipoTraId = "" ;
      A1292TipoTraId = "" ;
      BC0015131_A1292TipoTraId = new String[] {""} ;
      BC0015131_A46PaiCod = new short[1] ;
      BC0015131_A1296PaiTipoTraHor = new String[] {""} ;
      BC0015131_n1296PaiTipoTraHor = new boolean[] {false} ;
      BC0015131_A1297PaiTipoTraIns = new boolean[] {false} ;
      BC0015131_A1336PaiTipoHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015131_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015131_A1338PaiTipoTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015131_A1347PaiTipoTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015131_A1383PaiTipoHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015131_A1384PaiTipoHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015131_A1385PaiTipoHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015131_A1390PaiTipoHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015131_A1294PaiTipoTraId = new String[] {""} ;
      BC0015132_A1292TipoTraId = new String[] {""} ;
      BC0015133_A46PaiCod = new short[1] ;
      BC0015133_A1294PaiTipoTraId = new String[] {""} ;
      BC0015134_A46PaiCod = new short[1] ;
      BC0015134_A1296PaiTipoTraHor = new String[] {""} ;
      BC0015134_n1296PaiTipoTraHor = new boolean[] {false} ;
      BC0015134_A1297PaiTipoTraIns = new boolean[] {false} ;
      BC0015134_A1336PaiTipoHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015134_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015134_A1338PaiTipoTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015134_A1347PaiTipoTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015134_A1383PaiTipoHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015134_A1384PaiTipoHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015134_A1385PaiTipoHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015134_A1390PaiTipoHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015134_A1294PaiTipoTraId = new String[] {""} ;
      sMode155 = "" ;
      BC0015135_A46PaiCod = new short[1] ;
      BC0015135_A1296PaiTipoTraHor = new String[] {""} ;
      BC0015135_n1296PaiTipoTraHor = new boolean[] {false} ;
      BC0015135_A1297PaiTipoTraIns = new boolean[] {false} ;
      BC0015135_A1336PaiTipoHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015135_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015135_A1338PaiTipoTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015135_A1347PaiTipoTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015135_A1383PaiTipoHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015135_A1384PaiTipoHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015135_A1385PaiTipoHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015135_A1390PaiTipoHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015135_A1294PaiTipoTraId = new String[] {""} ;
      BC0015139_A1292TipoTraId = new String[] {""} ;
      BC0015140_A3CliCod = new int[1] ;
      BC0015140_A1564CliPaiConve = new short[1] ;
      BC0015140_A1565CliConvenio = new String[] {""} ;
      BC0015140_A1294PaiTipoTraId = new String[] {""} ;
      BC0015141_A3CliCod = new int[1] ;
      BC0015141_A1564CliPaiConve = new short[1] ;
      BC0015141_A1565CliConvenio = new String[] {""} ;
      BC0015141_A1294PaiTipoTraId = new String[] {""} ;
      BC0015142_A46PaiCod = new short[1] ;
      BC0015142_A1332PaiHsExSec = new short[1] ;
      BC0015143_A1292TipoTraId = new String[] {""} ;
      BC0015143_A46PaiCod = new short[1] ;
      BC0015143_A1296PaiTipoTraHor = new String[] {""} ;
      BC0015143_n1296PaiTipoTraHor = new boolean[] {false} ;
      BC0015143_A1297PaiTipoTraIns = new boolean[] {false} ;
      BC0015143_A1336PaiTipoHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015143_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015143_A1338PaiTipoTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015143_A1347PaiTipoTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015143_A1383PaiTipoHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015143_A1384PaiTipoHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015143_A1385PaiTipoHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015143_A1390PaiTipoHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015143_A1294PaiTipoTraId = new String[] {""} ;
      Z1334PaiHsPDiaDesde = "" ;
      A1334PaiHsPDiaDesde = "" ;
      Z1335PaiTarifaPDia = DecimalUtil.ZERO ;
      A1335PaiTarifaPDia = DecimalUtil.ZERO ;
      Z1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      A1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      Z1331PaiHsPDiaTipTra = "" ;
      A1331PaiHsPDiaTipTra = "" ;
      BC0015144_A1332PaiHsExSec = new short[1] ;
      BC0015144_A1333PaiHsPDiaDia = new byte[1] ;
      BC0015144_A1334PaiHsPDiaDesde = new String[] {""} ;
      BC0015144_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      BC0015144_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015144_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015144_A46PaiCod = new short[1] ;
      BC0015144_A1331PaiHsPDiaTipTra = new String[] {""} ;
      BC0015145_A46PaiCod = new short[1] ;
      BC0015146_A46PaiCod = new short[1] ;
      BC0015146_A1332PaiHsExSec = new short[1] ;
      BC0015147_A1332PaiHsExSec = new short[1] ;
      BC0015147_A1333PaiHsPDiaDia = new byte[1] ;
      BC0015147_A1334PaiHsPDiaDesde = new String[] {""} ;
      BC0015147_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      BC0015147_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015147_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015147_A46PaiCod = new short[1] ;
      BC0015147_A1331PaiHsPDiaTipTra = new String[] {""} ;
      sMode164 = "" ;
      BC0015148_A1332PaiHsExSec = new short[1] ;
      BC0015148_A1333PaiHsPDiaDia = new byte[1] ;
      BC0015148_A1334PaiHsPDiaDesde = new String[] {""} ;
      BC0015148_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      BC0015148_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015148_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015148_A46PaiCod = new short[1] ;
      BC0015148_A1331PaiHsPDiaTipTra = new String[] {""} ;
      BC0015152_A1332PaiHsExSec = new short[1] ;
      BC0015152_A1333PaiHsPDiaDia = new byte[1] ;
      BC0015152_A1334PaiHsPDiaDesde = new String[] {""} ;
      BC0015152_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      BC0015152_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015152_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0015152_A46PaiCod = new short[1] ;
      BC0015152_A1331PaiHsPDiaTipTra = new String[] {""} ;
      BC0015153_A46PaiCod = new short[1] ;
      BC0015153_A1766PaiVacDesAnt = new byte[1] ;
      BC0015153_A1767PaiVacHasAnt = new byte[1] ;
      BC0015153_A1768PaiVacDias = new byte[1] ;
      BC0015154_A46PaiCod = new short[1] ;
      BC0015154_A1766PaiVacDesAnt = new byte[1] ;
      BC0015155_A46PaiCod = new short[1] ;
      BC0015155_A1766PaiVacDesAnt = new byte[1] ;
      BC0015155_A1767PaiVacHasAnt = new byte[1] ;
      BC0015155_A1768PaiVacDias = new byte[1] ;
      sMode240 = "" ;
      BC0015156_A46PaiCod = new short[1] ;
      BC0015156_A1766PaiVacDesAnt = new byte[1] ;
      BC0015156_A1767PaiVacHasAnt = new byte[1] ;
      BC0015156_A1768PaiVacDias = new byte[1] ;
      BC0015160_A46PaiCod = new short[1] ;
      BC0015160_A1766PaiVacDesAnt = new byte[1] ;
      BC0015160_A1767PaiVacHasAnt = new byte[1] ;
      BC0015160_A1768PaiVacDias = new byte[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.pais_bc__default(),
         new Object[] {
             new Object[] {
            BC00152_A46PaiCod, BC00152_A1766PaiVacDesAnt, BC00152_A1767PaiVacHasAnt, BC00152_A1768PaiVacDias
            }
            , new Object[] {
            BC00153_A46PaiCod, BC00153_A1766PaiVacDesAnt, BC00153_A1767PaiVacHasAnt, BC00153_A1768PaiVacDias
            }
            , new Object[] {
            BC00154_A1332PaiHsExSec, BC00154_A1333PaiHsPDiaDia, BC00154_A1334PaiHsPDiaDesde, BC00154_n1334PaiHsPDiaDesde, BC00154_A1335PaiTarifaPDia, BC00154_A1348PaiTarifaPDRec, BC00154_A46PaiCod, BC00154_A1331PaiHsPDiaTipTra
            }
            , new Object[] {
            BC00155_A1332PaiHsExSec, BC00155_A1333PaiHsPDiaDia, BC00155_A1334PaiHsPDiaDesde, BC00155_n1334PaiHsPDiaDesde, BC00155_A1335PaiTarifaPDia, BC00155_A1348PaiTarifaPDRec, BC00155_A46PaiCod, BC00155_A1331PaiHsPDiaTipTra
            }
            , new Object[] {
            BC00156_A46PaiCod
            }
            , new Object[] {
            BC00157_A46PaiCod, BC00157_A1296PaiTipoTraHor, BC00157_n1296PaiTipoTraHor, BC00157_A1297PaiTipoTraIns, BC00157_A1336PaiTipoHsDia, BC00157_A1337PaiTipoHsSem, BC00157_A1338PaiTipoTarifaXLim, BC00157_A1347PaiTipoTarifaRec, BC00157_A1383PaiTipoHsMaxDia, BC00157_A1384PaiTipoHsMaxSem,
            BC00157_A1385PaiTipoHsMaxMes, BC00157_A1390PaiTipoHsMaxAnu, BC00157_A1294PaiTipoTraId
            }
            , new Object[] {
            BC00158_A46PaiCod, BC00158_A1296PaiTipoTraHor, BC00158_n1296PaiTipoTraHor, BC00158_A1297PaiTipoTraIns, BC00158_A1336PaiTipoHsDia, BC00158_A1337PaiTipoHsSem, BC00158_A1338PaiTipoTarifaXLim, BC00158_A1347PaiTipoTarifaRec, BC00158_A1383PaiTipoHsMaxDia, BC00158_A1384PaiTipoHsMaxSem,
            BC00158_A1385PaiTipoHsMaxMes, BC00158_A1390PaiTipoHsMaxAnu, BC00158_A1294PaiTipoTraId
            }
            , new Object[] {
            BC00159_A1292TipoTraId
            }
            , new Object[] {
            BC001510_A46PaiCod, BC001510_A1361PaiPromFijVar, BC001510_A1362PaiPromHabitual, BC001510_A37TipoConCod
            }
            , new Object[] {
            BC001511_A46PaiCod, BC001511_A1361PaiPromFijVar, BC001511_A1362PaiPromHabitual, BC001511_A37TipoConCod
            }
            , new Object[] {
            BC001512_A37TipoConCod
            }
            , new Object[] {
            BC001513_A1359PaiMesHabitual, BC001513_A1356PaiMenCliCod, BC001513_A1358PaiMesConCodigo, BC001513_A46PaiCod
            }
            , new Object[] {
            BC001514_A1359PaiMesHabitual, BC001514_A1356PaiMenCliCod, BC001514_A1358PaiMesConCodigo, BC001514_A46PaiCod
            }
            , new Object[] {
            BC001515_A1356PaiMenCliCod
            }
            , new Object[] {
            BC001516_A1360PaiJorHabitual, BC001516_A1354PaiJorCliCod, BC001516_A1355PaiJorConCodigo, BC001516_A46PaiCod
            }
            , new Object[] {
            BC001517_A1360PaiJorHabitual, BC001517_A1354PaiJorCliCod, BC001517_A1355PaiJorConCodigo, BC001517_A46PaiCod
            }
            , new Object[] {
            BC001518_A1354PaiJorCliCod
            }
            , new Object[] {
            BC001519_A46PaiCod, BC001519_A1440PaiBaseClaseLeg, BC001519_A1441PaiBaseTipo, BC001519_A1442PaiBaseCod1, BC001519_A1443PaiBaseCod2, BC001519_A1448PaiBasePromCTipo, BC001519_A1449PaiBasePromFijVar, BC001519_A1450PaiBasePromHab
            }
            , new Object[] {
            BC001520_A46PaiCod, BC001520_A1440PaiBaseClaseLeg, BC001520_A1441PaiBaseTipo, BC001520_A1442PaiBaseCod1, BC001520_A1443PaiBaseCod2, BC001520_A1448PaiBasePromCTipo, BC001520_A1449PaiBasePromFijVar, BC001520_A1450PaiBasePromHab
            }
            , new Object[] {
            BC001521_A1440PaiBaseClaseLeg, BC001521_A1441PaiBaseTipo, BC001521_A1442PaiBaseCod1, BC001521_A1443PaiBaseCod2, BC001521_A1447PaiBaseConHabitual, BC001521_A1445PaiBaseCliCod, BC001521_A1446PaiBaseConCodigo, BC001521_A46PaiCod
            }
            , new Object[] {
            BC001522_A1440PaiBaseClaseLeg, BC001522_A1441PaiBaseTipo, BC001522_A1442PaiBaseCod1, BC001522_A1443PaiBaseCod2, BC001522_A1447PaiBaseConHabitual, BC001522_A1445PaiBaseCliCod, BC001522_A1446PaiBaseConCodigo, BC001522_A46PaiCod
            }
            , new Object[] {
            BC001523_A1445PaiBaseCliCod
            }
            , new Object[] {
            BC001524_A46PaiCod, BC001524_A1440PaiBaseClaseLeg, BC001524_A1441PaiBaseTipo, BC001524_A1442PaiBaseCod1, BC001524_A1443PaiBaseCod2, BC001524_A1444PaiBasePlus, BC001524_A1629PaiLicDLim, BC001524_A1630PaiLicDSeman, BC001524_A1631PaiLicDMes, BC001524_A1632PaiLicDSemes,
            BC001524_A1633PaiLicDAnual, BC001524_A1634PaiLicAdju, BC001524_A1635PaiLicAdjuObl, BC001524_A1636PaiLicNecAut, BC001524_A1637PaiLicIngMot, BC001524_A1638PaiLicMotObl, BC001524_A1451PaiBasePromCnt1, BC001524_A1452PaiBasePromCnt2, BC001524_A1453PaiBasePromTCnt
            }
            , new Object[] {
            BC001525_A46PaiCod, BC001525_A1440PaiBaseClaseLeg, BC001525_A1441PaiBaseTipo, BC001525_A1442PaiBaseCod1, BC001525_A1443PaiBaseCod2, BC001525_A1444PaiBasePlus, BC001525_A1629PaiLicDLim, BC001525_A1630PaiLicDSeman, BC001525_A1631PaiLicDMes, BC001525_A1632PaiLicDSemes,
            BC001525_A1633PaiLicDAnual, BC001525_A1634PaiLicAdju, BC001525_A1635PaiLicAdjuObl, BC001525_A1636PaiLicNecAut, BC001525_A1637PaiLicIngMot, BC001525_A1638PaiLicMotObl, BC001525_A1451PaiBasePromCnt1, BC001525_A1452PaiBasePromCnt2, BC001525_A1453PaiBasePromTCnt
            }
            , new Object[] {
            BC001526_A46PaiCod, BC001526_A1535PaiAntMayCant, BC001526_A1536PaiAntMayDur, BC001526_A1537PaiPreAviCant, BC001526_A1538PaiPreAviDur
            }
            , new Object[] {
            BC001527_A46PaiCod, BC001527_A1535PaiAntMayCant, BC001527_A1536PaiAntMayDur, BC001527_A1537PaiPreAviCant, BC001527_A1538PaiPreAviDur
            }
            , new Object[] {
            BC001528_A46PaiCod, BC001528_A312PaiNom, BC001528_A311PaiNacMostrar, BC001528_A310PaiDomMostrar, BC001528_A1271PaiMesHsPExt, BC001528_A1272PaiDiaHsPExt, BC001528_A1402PaiFondoCese, BC001528_A1405PaiMaxHorNor, BC001528_A1521PaiPerVacDes, BC001528_A1522PaiPerVacHas,
            BC001528_A1814PaiFracVacAnt, BC001528_A1363PaiPromMeses, BC001528_A1590PaiPromMesTCnt, BC001528_A1573PaiPromJorMeses, BC001528_A1591PaiPromJorMesTCnt, BC001528_A1625PaiGuarEdadMin, BC001528_A1626PaiGuarEdadMax, BC001528_A1736PaiExcVizzoti, BC001528_A1737PaiVizzoti, BC001528_A1764PaiMinMesesVac,
            BC001528_A1765PaiInterDiasJor, BC001528_A1793PaiTipoExpDef, BC001528_A1252PaiReligDefault, BC001528_n1252PaiReligDefault
            }
            , new Object[] {
            BC001529_A46PaiCod, BC001529_A312PaiNom, BC001529_A311PaiNacMostrar, BC001529_A310PaiDomMostrar, BC001529_A1271PaiMesHsPExt, BC001529_A1272PaiDiaHsPExt, BC001529_A1402PaiFondoCese, BC001529_A1405PaiMaxHorNor, BC001529_A1521PaiPerVacDes, BC001529_A1522PaiPerVacHas,
            BC001529_A1814PaiFracVacAnt, BC001529_A1363PaiPromMeses, BC001529_A1590PaiPromMesTCnt, BC001529_A1573PaiPromJorMeses, BC001529_A1591PaiPromJorMesTCnt, BC001529_A1625PaiGuarEdadMin, BC001529_A1626PaiGuarEdadMax, BC001529_A1736PaiExcVizzoti, BC001529_A1737PaiVizzoti, BC001529_A1764PaiMinMesesVac,
            BC001529_A1765PaiInterDiasJor, BC001529_A1793PaiTipoExpDef, BC001529_A1252PaiReligDefault, BC001529_n1252PaiReligDefault
            }
            , new Object[] {
            BC001530_A1252PaiReligDefault
            }
            , new Object[] {
            BC001531_A46PaiCod, BC001531_A312PaiNom, BC001531_A311PaiNacMostrar, BC001531_A310PaiDomMostrar, BC001531_A1271PaiMesHsPExt, BC001531_A1272PaiDiaHsPExt, BC001531_A1402PaiFondoCese, BC001531_A1405PaiMaxHorNor, BC001531_A1521PaiPerVacDes, BC001531_A1522PaiPerVacHas,
            BC001531_A1814PaiFracVacAnt, BC001531_A1363PaiPromMeses, BC001531_A1590PaiPromMesTCnt, BC001531_A1573PaiPromJorMeses, BC001531_A1591PaiPromJorMesTCnt, BC001531_A1625PaiGuarEdadMin, BC001531_A1626PaiGuarEdadMax, BC001531_A1736PaiExcVizzoti, BC001531_A1737PaiVizzoti, BC001531_A1764PaiMinMesesVac,
            BC001531_A1765PaiInterDiasJor, BC001531_A1793PaiTipoExpDef, BC001531_A1252PaiReligDefault, BC001531_n1252PaiReligDefault
            }
            , new Object[] {
            BC001532_A1252PaiReligDefault
            }
            , new Object[] {
            BC001533_A46PaiCod
            }
            , new Object[] {
            BC001534_A46PaiCod, BC001534_A312PaiNom, BC001534_A311PaiNacMostrar, BC001534_A310PaiDomMostrar, BC001534_A1271PaiMesHsPExt, BC001534_A1272PaiDiaHsPExt, BC001534_A1402PaiFondoCese, BC001534_A1405PaiMaxHorNor, BC001534_A1521PaiPerVacDes, BC001534_A1522PaiPerVacHas,
            BC001534_A1814PaiFracVacAnt, BC001534_A1363PaiPromMeses, BC001534_A1590PaiPromMesTCnt, BC001534_A1573PaiPromJorMeses, BC001534_A1591PaiPromJorMesTCnt, BC001534_A1625PaiGuarEdadMin, BC001534_A1626PaiGuarEdadMax, BC001534_A1736PaiExcVizzoti, BC001534_A1737PaiVizzoti, BC001534_A1764PaiMinMesesVac,
            BC001534_A1765PaiInterDiasJor, BC001534_A1793PaiTipoExpDef, BC001534_A1252PaiReligDefault, BC001534_n1252PaiReligDefault
            }
            , new Object[] {
            BC001535_A46PaiCod, BC001535_A312PaiNom, BC001535_A311PaiNacMostrar, BC001535_A310PaiDomMostrar, BC001535_A1271PaiMesHsPExt, BC001535_A1272PaiDiaHsPExt, BC001535_A1402PaiFondoCese, BC001535_A1405PaiMaxHorNor, BC001535_A1521PaiPerVacDes, BC001535_A1522PaiPerVacHas,
            BC001535_A1814PaiFracVacAnt, BC001535_A1363PaiPromMeses, BC001535_A1590PaiPromMesTCnt, BC001535_A1573PaiPromJorMeses, BC001535_A1591PaiPromJorMesTCnt, BC001535_A1625PaiGuarEdadMin, BC001535_A1626PaiGuarEdadMax, BC001535_A1736PaiExcVizzoti, BC001535_A1737PaiVizzoti, BC001535_A1764PaiMinMesesVac,
            BC001535_A1765PaiInterDiasJor, BC001535_A1793PaiTipoExpDef, BC001535_A1252PaiReligDefault, BC001535_n1252PaiReligDefault
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001539_A37TipoConCod
            }
            , new Object[] {
            BC001540_A1923RolId, BC001540_A1925PerfilId, BC001540_A1928MenuVerId
            }
            , new Object[] {
            BC001541_A953ConCondicion
            }
            , new Object[] {
            BC001542_A1748EstaCivilCod
            }
            , new Object[] {
            BC001543_A1743SexoId
            }
            , new Object[] {
            BC001544_A3CliCod, BC001544_A26ConCodigo
            }
            , new Object[] {
            BC001545_A16SitCodigo
            }
            , new Object[] {
            BC001546_A3CliCod, BC001546_A1564CliPaiConve, BC001546_A1565CliConvenio, BC001546_A8CatCodigo, BC001546_A2200CatPaiCod, BC001546_A2201CatProvCod
            }
            , new Object[] {
            BC001547_A3CliCod, BC001547_A1564CliPaiConve, BC001547_A1565CliConvenio
            }
            , new Object[] {
            BC001548_A3CliCod, BC001548_A1EmpCod, BC001548_A1562EmpConvePai, BC001548_A1561EmpConveCod
            }
            , new Object[] {
            BC001549_A1161EmbargaSec
            }
            , new Object[] {
            BC001550_A1163TipoOblSec
            }
            , new Object[] {
            BC001551_A1151ARTSec
            }
            , new Object[] {
            BC001552_A903ActComCodigo, BC001552_A993ActComAdiPai, BC001552_A994ActComAdiCod
            }
            , new Object[] {
            BC001553_A67SecUserId
            }
            , new Object[] {
            BC001554_A46PaiCod, BC001554_A2217ActLabNro
            }
            , new Object[] {
            BC001555_A46PaiCod, BC001555_A1440PaiBaseClaseLeg, BC001555_A1441PaiBaseTipo, BC001555_A1442PaiBaseCod1, BC001555_A1443PaiBaseCod2
            }
            , new Object[] {
            BC001556_A46PaiCod, BC001556_A1395PaiRanEtDesde
            }
            , new Object[] {
            BC001557_A46PaiCod, BC001557_A1332PaiHsExSec
            }
            , new Object[] {
            BC001558_A46PaiCod, BC001558_A1282PaiOrigen
            }
            , new Object[] {
            BC001559_A46PaiCod, BC001559_A1253PaiReligion
            }
            , new Object[] {
            BC001560_A46PaiCod, BC001560_A1223FerId
            }
            , new Object[] {
            BC001561_A46PaiCod, BC001561_A1221FerTipo
            }
            , new Object[] {
            BC001562_A46PaiCod, BC001562_A988AdicionalCod
            }
            , new Object[] {
            BC001563_A46PaiCod, BC001563_A14SinCod
            }
            , new Object[] {
            BC001564_A46PaiCod, BC001564_A9ConveCodigo
            }
            , new Object[] {
            BC001565_A46PaiCod, BC001565_A74idOperando
            }
            , new Object[] {
            BC001566_A46PaiCod, BC001566_A47ProvCod
            }
            , new Object[] {
            BC001567_A3CliCod, BC001567_A1EmpCod, BC001567_A6LegNumero
            }
            , new Object[] {
            BC001568_A3CliCod, BC001568_A1EmpCod, BC001568_A6LegNumero
            }
            , new Object[] {
            BC001569_A3CliCod
            }
            , new Object[] {
            BC001570_A46PaiCod, BC001570_A312PaiNom, BC001570_A311PaiNacMostrar, BC001570_A310PaiDomMostrar, BC001570_A1271PaiMesHsPExt, BC001570_A1272PaiDiaHsPExt, BC001570_A1402PaiFondoCese, BC001570_A1405PaiMaxHorNor, BC001570_A1521PaiPerVacDes, BC001570_A1522PaiPerVacHas,
            BC001570_A1814PaiFracVacAnt, BC001570_A1363PaiPromMeses, BC001570_A1590PaiPromMesTCnt, BC001570_A1573PaiPromJorMeses, BC001570_A1591PaiPromJorMesTCnt, BC001570_A1625PaiGuarEdadMin, BC001570_A1626PaiGuarEdadMax, BC001570_A1736PaiExcVizzoti, BC001570_A1737PaiVizzoti, BC001570_A1764PaiMinMesesVac,
            BC001570_A1765PaiInterDiasJor, BC001570_A1793PaiTipoExpDef, BC001570_A1252PaiReligDefault, BC001570_n1252PaiReligDefault
            }
            , new Object[] {
            BC001571_A46PaiCod, BC001571_A1535PaiAntMayCant, BC001571_A1536PaiAntMayDur, BC001571_A1537PaiPreAviCant, BC001571_A1538PaiPreAviDur
            }
            , new Object[] {
            BC001572_A46PaiCod, BC001572_A1535PaiAntMayCant, BC001572_A1536PaiAntMayDur
            }
            , new Object[] {
            BC001573_A46PaiCod, BC001573_A1535PaiAntMayCant, BC001573_A1536PaiAntMayDur, BC001573_A1537PaiPreAviCant, BC001573_A1538PaiPreAviDur
            }
            , new Object[] {
            BC001574_A46PaiCod, BC001574_A1535PaiAntMayCant, BC001574_A1536PaiAntMayDur, BC001574_A1537PaiPreAviCant, BC001574_A1538PaiPreAviDur
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001578_A46PaiCod, BC001578_A1535PaiAntMayCant, BC001578_A1536PaiAntMayDur, BC001578_A1537PaiPreAviCant, BC001578_A1538PaiPreAviDur
            }
            , new Object[] {
            BC001579_A46PaiCod, BC001579_A1440PaiBaseClaseLeg, BC001579_A1441PaiBaseTipo, BC001579_A1442PaiBaseCod1, BC001579_A1443PaiBaseCod2, BC001579_A1444PaiBasePlus, BC001579_A1629PaiLicDLim, BC001579_A1630PaiLicDSeman, BC001579_A1631PaiLicDMes, BC001579_A1632PaiLicDSemes,
            BC001579_A1633PaiLicDAnual, BC001579_A1634PaiLicAdju, BC001579_A1635PaiLicAdjuObl, BC001579_A1636PaiLicNecAut, BC001579_A1637PaiLicIngMot, BC001579_A1638PaiLicMotObl, BC001579_A1451PaiBasePromCnt1, BC001579_A1452PaiBasePromCnt2, BC001579_A1453PaiBasePromTCnt
            }
            , new Object[] {
            BC001580_A46PaiCod, BC001580_A1440PaiBaseClaseLeg, BC001580_A1441PaiBaseTipo, BC001580_A1442PaiBaseCod1, BC001580_A1443PaiBaseCod2
            }
            , new Object[] {
            BC001581_A46PaiCod, BC001581_A1440PaiBaseClaseLeg, BC001581_A1441PaiBaseTipo, BC001581_A1442PaiBaseCod1, BC001581_A1443PaiBaseCod2, BC001581_A1444PaiBasePlus, BC001581_A1629PaiLicDLim, BC001581_A1630PaiLicDSeman, BC001581_A1631PaiLicDMes, BC001581_A1632PaiLicDSemes,
            BC001581_A1633PaiLicDAnual, BC001581_A1634PaiLicAdju, BC001581_A1635PaiLicAdjuObl, BC001581_A1636PaiLicNecAut, BC001581_A1637PaiLicIngMot, BC001581_A1638PaiLicMotObl, BC001581_A1451PaiBasePromCnt1, BC001581_A1452PaiBasePromCnt2, BC001581_A1453PaiBasePromTCnt
            }
            , new Object[] {
            BC001582_A46PaiCod, BC001582_A1440PaiBaseClaseLeg, BC001582_A1441PaiBaseTipo, BC001582_A1442PaiBaseCod1, BC001582_A1443PaiBaseCod2, BC001582_A1444PaiBasePlus, BC001582_A1629PaiLicDLim, BC001582_A1630PaiLicDSeman, BC001582_A1631PaiLicDMes, BC001582_A1632PaiLicDSemes,
            BC001582_A1633PaiLicDAnual, BC001582_A1634PaiLicAdju, BC001582_A1635PaiLicAdjuObl, BC001582_A1636PaiLicNecAut, BC001582_A1637PaiLicIngMot, BC001582_A1638PaiLicMotObl, BC001582_A1451PaiBasePromCnt1, BC001582_A1452PaiBasePromCnt2, BC001582_A1453PaiBasePromTCnt
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001586_A46PaiCod, BC001586_A1440PaiBaseClaseLeg, BC001586_A1441PaiBaseTipo, BC001586_A1442PaiBaseCod1, BC001586_A1443PaiBaseCod2, BC001586_A1444PaiBasePlus, BC001586_A1629PaiLicDLim, BC001586_A1630PaiLicDSeman, BC001586_A1631PaiLicDMes, BC001586_A1632PaiLicDSemes,
            BC001586_A1633PaiLicDAnual, BC001586_A1634PaiLicAdju, BC001586_A1635PaiLicAdjuObl, BC001586_A1636PaiLicNecAut, BC001586_A1637PaiLicIngMot, BC001586_A1638PaiLicMotObl, BC001586_A1451PaiBasePromCnt1, BC001586_A1452PaiBasePromCnt2, BC001586_A1453PaiBasePromTCnt
            }
            , new Object[] {
            BC001587_A1440PaiBaseClaseLeg, BC001587_A1441PaiBaseTipo, BC001587_A1442PaiBaseCod1, BC001587_A1443PaiBaseCod2, BC001587_A1447PaiBaseConHabitual, BC001587_A1445PaiBaseCliCod, BC001587_A1446PaiBaseConCodigo, BC001587_A46PaiCod
            }
            , new Object[] {
            BC001588_A1445PaiBaseCliCod
            }
            , new Object[] {
            BC001589_A46PaiCod, BC001589_A1440PaiBaseClaseLeg, BC001589_A1441PaiBaseTipo, BC001589_A1442PaiBaseCod1, BC001589_A1443PaiBaseCod2, BC001589_A1445PaiBaseCliCod, BC001589_A1446PaiBaseConCodigo
            }
            , new Object[] {
            BC001590_A1440PaiBaseClaseLeg, BC001590_A1441PaiBaseTipo, BC001590_A1442PaiBaseCod1, BC001590_A1443PaiBaseCod2, BC001590_A1447PaiBaseConHabitual, BC001590_A1445PaiBaseCliCod, BC001590_A1446PaiBaseConCodigo, BC001590_A46PaiCod
            }
            , new Object[] {
            BC001591_A1440PaiBaseClaseLeg, BC001591_A1441PaiBaseTipo, BC001591_A1442PaiBaseCod1, BC001591_A1443PaiBaseCod2, BC001591_A1447PaiBaseConHabitual, BC001591_A1445PaiBaseCliCod, BC001591_A1446PaiBaseConCodigo, BC001591_A46PaiCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001595_A1440PaiBaseClaseLeg, BC001595_A1441PaiBaseTipo, BC001595_A1442PaiBaseCod1, BC001595_A1443PaiBaseCod2, BC001595_A1447PaiBaseConHabitual, BC001595_A1445PaiBaseCliCod, BC001595_A1446PaiBaseConCodigo, BC001595_A46PaiCod
            }
            , new Object[] {
            BC001596_A46PaiCod, BC001596_A1440PaiBaseClaseLeg, BC001596_A1441PaiBaseTipo, BC001596_A1442PaiBaseCod1, BC001596_A1443PaiBaseCod2, BC001596_A1448PaiBasePromCTipo, BC001596_A1449PaiBasePromFijVar, BC001596_A1450PaiBasePromHab
            }
            , new Object[] {
            BC001597_A46PaiCod, BC001597_A1440PaiBaseClaseLeg, BC001597_A1441PaiBaseTipo, BC001597_A1442PaiBaseCod1, BC001597_A1443PaiBaseCod2, BC001597_A1448PaiBasePromCTipo, BC001597_A1449PaiBasePromFijVar
            }
            , new Object[] {
            BC001598_A46PaiCod, BC001598_A1440PaiBaseClaseLeg, BC001598_A1441PaiBaseTipo, BC001598_A1442PaiBaseCod1, BC001598_A1443PaiBaseCod2, BC001598_A1448PaiBasePromCTipo, BC001598_A1449PaiBasePromFijVar, BC001598_A1450PaiBasePromHab
            }
            , new Object[] {
            BC001599_A46PaiCod, BC001599_A1440PaiBaseClaseLeg, BC001599_A1441PaiBaseTipo, BC001599_A1442PaiBaseCod1, BC001599_A1443PaiBaseCod2, BC001599_A1448PaiBasePromCTipo, BC001599_A1449PaiBasePromFijVar, BC001599_A1450PaiBasePromHab
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0015103_A46PaiCod, BC0015103_A1440PaiBaseClaseLeg, BC0015103_A1441PaiBaseTipo, BC0015103_A1442PaiBaseCod1, BC0015103_A1443PaiBaseCod2, BC0015103_A1448PaiBasePromCTipo, BC0015103_A1449PaiBasePromFijVar, BC0015103_A1450PaiBasePromHab
            }
            , new Object[] {
            BC0015104_A1360PaiJorHabitual, BC0015104_A1354PaiJorCliCod, BC0015104_A1355PaiJorConCodigo, BC0015104_A46PaiCod
            }
            , new Object[] {
            BC0015105_A1354PaiJorCliCod
            }
            , new Object[] {
            BC0015106_A46PaiCod, BC0015106_A1354PaiJorCliCod, BC0015106_A1355PaiJorConCodigo
            }
            , new Object[] {
            BC0015107_A1360PaiJorHabitual, BC0015107_A1354PaiJorCliCod, BC0015107_A1355PaiJorConCodigo, BC0015107_A46PaiCod
            }
            , new Object[] {
            BC0015108_A1360PaiJorHabitual, BC0015108_A1354PaiJorCliCod, BC0015108_A1355PaiJorConCodigo, BC0015108_A46PaiCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0015112_A1360PaiJorHabitual, BC0015112_A1354PaiJorCliCod, BC0015112_A1355PaiJorConCodigo, BC0015112_A46PaiCod
            }
            , new Object[] {
            BC0015113_A1359PaiMesHabitual, BC0015113_A1356PaiMenCliCod, BC0015113_A1358PaiMesConCodigo, BC0015113_A46PaiCod
            }
            , new Object[] {
            BC0015114_A1356PaiMenCliCod
            }
            , new Object[] {
            BC0015115_A46PaiCod, BC0015115_A1356PaiMenCliCod, BC0015115_A1358PaiMesConCodigo
            }
            , new Object[] {
            BC0015116_A1359PaiMesHabitual, BC0015116_A1356PaiMenCliCod, BC0015116_A1358PaiMesConCodigo, BC0015116_A46PaiCod
            }
            , new Object[] {
            BC0015117_A1359PaiMesHabitual, BC0015117_A1356PaiMenCliCod, BC0015117_A1358PaiMesConCodigo, BC0015117_A46PaiCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0015121_A1359PaiMesHabitual, BC0015121_A1356PaiMenCliCod, BC0015121_A1358PaiMesConCodigo, BC0015121_A46PaiCod
            }
            , new Object[] {
            BC0015122_A46PaiCod, BC0015122_A1361PaiPromFijVar, BC0015122_A1362PaiPromHabitual, BC0015122_A37TipoConCod
            }
            , new Object[] {
            BC0015123_A37TipoConCod
            }
            , new Object[] {
            BC0015124_A46PaiCod, BC0015124_A37TipoConCod, BC0015124_A1361PaiPromFijVar
            }
            , new Object[] {
            BC0015125_A46PaiCod, BC0015125_A1361PaiPromFijVar, BC0015125_A1362PaiPromHabitual, BC0015125_A37TipoConCod
            }
            , new Object[] {
            BC0015126_A46PaiCod, BC0015126_A1361PaiPromFijVar, BC0015126_A1362PaiPromHabitual, BC0015126_A37TipoConCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0015130_A46PaiCod, BC0015130_A1361PaiPromFijVar, BC0015130_A1362PaiPromHabitual, BC0015130_A37TipoConCod
            }
            , new Object[] {
            BC0015131_A1292TipoTraId, BC0015131_A46PaiCod, BC0015131_A1296PaiTipoTraHor, BC0015131_n1296PaiTipoTraHor, BC0015131_A1297PaiTipoTraIns, BC0015131_A1336PaiTipoHsDia, BC0015131_A1337PaiTipoHsSem, BC0015131_A1338PaiTipoTarifaXLim, BC0015131_A1347PaiTipoTarifaRec, BC0015131_A1383PaiTipoHsMaxDia,
            BC0015131_A1384PaiTipoHsMaxSem, BC0015131_A1385PaiTipoHsMaxMes, BC0015131_A1390PaiTipoHsMaxAnu, BC0015131_A1294PaiTipoTraId
            }
            , new Object[] {
            BC0015132_A1292TipoTraId
            }
            , new Object[] {
            BC0015133_A46PaiCod, BC0015133_A1294PaiTipoTraId
            }
            , new Object[] {
            BC0015134_A46PaiCod, BC0015134_A1296PaiTipoTraHor, BC0015134_n1296PaiTipoTraHor, BC0015134_A1297PaiTipoTraIns, BC0015134_A1336PaiTipoHsDia, BC0015134_A1337PaiTipoHsSem, BC0015134_A1338PaiTipoTarifaXLim, BC0015134_A1347PaiTipoTarifaRec, BC0015134_A1383PaiTipoHsMaxDia, BC0015134_A1384PaiTipoHsMaxSem,
            BC0015134_A1385PaiTipoHsMaxMes, BC0015134_A1390PaiTipoHsMaxAnu, BC0015134_A1294PaiTipoTraId
            }
            , new Object[] {
            BC0015135_A46PaiCod, BC0015135_A1296PaiTipoTraHor, BC0015135_n1296PaiTipoTraHor, BC0015135_A1297PaiTipoTraIns, BC0015135_A1336PaiTipoHsDia, BC0015135_A1337PaiTipoHsSem, BC0015135_A1338PaiTipoTarifaXLim, BC0015135_A1347PaiTipoTarifaRec, BC0015135_A1383PaiTipoHsMaxDia, BC0015135_A1384PaiTipoHsMaxSem,
            BC0015135_A1385PaiTipoHsMaxMes, BC0015135_A1390PaiTipoHsMaxAnu, BC0015135_A1294PaiTipoTraId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0015139_A1292TipoTraId
            }
            , new Object[] {
            BC0015140_A3CliCod, BC0015140_A1564CliPaiConve, BC0015140_A1565CliConvenio, BC0015140_A1294PaiTipoTraId
            }
            , new Object[] {
            BC0015141_A3CliCod, BC0015141_A1564CliPaiConve, BC0015141_A1565CliConvenio, BC0015141_A1294PaiTipoTraId
            }
            , new Object[] {
            BC0015142_A46PaiCod, BC0015142_A1332PaiHsExSec
            }
            , new Object[] {
            BC0015143_A1292TipoTraId, BC0015143_A46PaiCod, BC0015143_A1296PaiTipoTraHor, BC0015143_n1296PaiTipoTraHor, BC0015143_A1297PaiTipoTraIns, BC0015143_A1336PaiTipoHsDia, BC0015143_A1337PaiTipoHsSem, BC0015143_A1338PaiTipoTarifaXLim, BC0015143_A1347PaiTipoTarifaRec, BC0015143_A1383PaiTipoHsMaxDia,
            BC0015143_A1384PaiTipoHsMaxSem, BC0015143_A1385PaiTipoHsMaxMes, BC0015143_A1390PaiTipoHsMaxAnu, BC0015143_A1294PaiTipoTraId
            }
            , new Object[] {
            BC0015144_A1332PaiHsExSec, BC0015144_A1333PaiHsPDiaDia, BC0015144_A1334PaiHsPDiaDesde, BC0015144_n1334PaiHsPDiaDesde, BC0015144_A1335PaiTarifaPDia, BC0015144_A1348PaiTarifaPDRec, BC0015144_A46PaiCod, BC0015144_A1331PaiHsPDiaTipTra
            }
            , new Object[] {
            BC0015145_A46PaiCod
            }
            , new Object[] {
            BC0015146_A46PaiCod, BC0015146_A1332PaiHsExSec
            }
            , new Object[] {
            BC0015147_A1332PaiHsExSec, BC0015147_A1333PaiHsPDiaDia, BC0015147_A1334PaiHsPDiaDesde, BC0015147_n1334PaiHsPDiaDesde, BC0015147_A1335PaiTarifaPDia, BC0015147_A1348PaiTarifaPDRec, BC0015147_A46PaiCod, BC0015147_A1331PaiHsPDiaTipTra
            }
            , new Object[] {
            BC0015148_A1332PaiHsExSec, BC0015148_A1333PaiHsPDiaDia, BC0015148_A1334PaiHsPDiaDesde, BC0015148_n1334PaiHsPDiaDesde, BC0015148_A1335PaiTarifaPDia, BC0015148_A1348PaiTarifaPDRec, BC0015148_A46PaiCod, BC0015148_A1331PaiHsPDiaTipTra
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0015152_A1332PaiHsExSec, BC0015152_A1333PaiHsPDiaDia, BC0015152_A1334PaiHsPDiaDesde, BC0015152_n1334PaiHsPDiaDesde, BC0015152_A1335PaiTarifaPDia, BC0015152_A1348PaiTarifaPDRec, BC0015152_A46PaiCod, BC0015152_A1331PaiHsPDiaTipTra
            }
            , new Object[] {
            BC0015153_A46PaiCod, BC0015153_A1766PaiVacDesAnt, BC0015153_A1767PaiVacHasAnt, BC0015153_A1768PaiVacDias
            }
            , new Object[] {
            BC0015154_A46PaiCod, BC0015154_A1766PaiVacDesAnt
            }
            , new Object[] {
            BC0015155_A46PaiCod, BC0015155_A1766PaiVacDesAnt, BC0015155_A1767PaiVacHasAnt, BC0015155_A1768PaiVacDias
            }
            , new Object[] {
            BC0015156_A46PaiCod, BC0015156_A1766PaiVacDesAnt, BC0015156_A1767PaiVacHasAnt, BC0015156_A1768PaiVacDias
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0015160_A46PaiCod, BC0015160_A1766PaiVacDesAnt, BC0015160_A1767PaiVacHasAnt, BC0015160_A1768PaiVacDias
            }
         }
      );
      AV29Pgmname = "Pais_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12152 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z1521PaiPerVacDes ;
   private byte A1521PaiPerVacDes ;
   private byte Z1522PaiPerVacHas ;
   private byte A1522PaiPerVacHas ;
   private byte Z1363PaiPromMeses ;
   private byte A1363PaiPromMeses ;
   private byte Z1573PaiPromJorMeses ;
   private byte A1573PaiPromJorMeses ;
   private byte Z1625PaiGuarEdadMin ;
   private byte A1625PaiGuarEdadMin ;
   private byte Z1626PaiGuarEdadMax ;
   private byte A1626PaiGuarEdadMax ;
   private byte Z1764PaiMinMesesVac ;
   private byte A1764PaiMinMesesVac ;
   private byte Z1793PaiTipoExpDef ;
   private byte A1793PaiTipoExpDef ;
   private byte Gxremove196 ;
   private byte Gxremove183 ;
   private byte Gxremove168 ;
   private byte Gxremove167 ;
   private byte Gxremove169 ;
   private byte Gxremove155 ;
   private byte Gxremove164 ;
   private byte Gxremove240 ;
   private byte Z1537PaiPreAviCant ;
   private byte A1537PaiPreAviCant ;
   private byte Z1535PaiAntMayCant ;
   private byte A1535PaiAntMayCant ;
   private byte Gx_BScreen ;
   private byte Z1630PaiLicDSeman ;
   private byte A1630PaiLicDSeman ;
   private byte Z1631PaiLicDMes ;
   private byte A1631PaiLicDMes ;
   private byte Z1440PaiBaseClaseLeg ;
   private byte A1440PaiBaseClaseLeg ;
   private byte Gxremove184 ;
   private byte Gxremove185 ;
   private byte Z1333PaiHsPDiaDia ;
   private byte A1333PaiHsPDiaDia ;
   private byte Z1767PaiVacHasAnt ;
   private byte A1767PaiVacHasAnt ;
   private byte Z1768PaiVacDias ;
   private byte A1768PaiVacDias ;
   private byte Z1766PaiVacDesAnt ;
   private byte A1766PaiVacDesAnt ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z46PaiCod ;
   private short A46PaiCod ;
   private short nIsMod_240 ;
   private short RcdFound240 ;
   private short nIsMod_164 ;
   private short RcdFound164 ;
   private short nIsMod_155 ;
   private short RcdFound155 ;
   private short nIsMod_169 ;
   private short RcdFound169 ;
   private short nIsMod_167 ;
   private short RcdFound167 ;
   private short nIsMod_168 ;
   private short RcdFound168 ;
   private short nIsMod_185 ;
   private short RcdFound185 ;
   private short nIsMod_184 ;
   private short RcdFound184 ;
   private short nIsMod_183 ;
   private short RcdFound183 ;
   private short nIsMod_196 ;
   private short RcdFound196 ;
   private short Z1765PaiInterDiasJor ;
   private short A1765PaiInterDiasJor ;
   private short RcdFound38 ;
   private short nIsDirty_38 ;
   private short nRcdExists_196 ;
   private short nRcdExists_183 ;
   private short nRcdExists_168 ;
   private short nRcdExists_167 ;
   private short nRcdExists_169 ;
   private short nRcdExists_155 ;
   private short nRcdExists_164 ;
   private short nRcdExists_240 ;
   private short nIsDirty_196 ;
   private short Z1629PaiLicDLim ;
   private short A1629PaiLicDLim ;
   private short Z1632PaiLicDSemes ;
   private short A1632PaiLicDSemes ;
   private short Z1633PaiLicDAnual ;
   private short A1633PaiLicDAnual ;
   private short Z1451PaiBasePromCnt1 ;
   private short A1451PaiBasePromCnt1 ;
   private short Z1452PaiBasePromCnt2 ;
   private short A1452PaiBasePromCnt2 ;
   private short nIsDirty_183 ;
   private short nRcdExists_184 ;
   private short nRcdExists_185 ;
   private short nIsDirty_184 ;
   private short nIsDirty_185 ;
   private short nIsDirty_168 ;
   private short nIsDirty_167 ;
   private short nIsDirty_169 ;
   private short nIsDirty_155 ;
   private short Z1332PaiHsExSec ;
   private short A1332PaiHsExSec ;
   private short nIsDirty_164 ;
   private short nIsDirty_240 ;
   private int trnEnded ;
   private int nGXsfl_240_idx=1 ;
   private int nGXsfl_164_idx=1 ;
   private int nGXsfl_155_idx=1 ;
   private int nGXsfl_169_idx=1 ;
   private int nGXsfl_167_idx=1 ;
   private int nGXsfl_168_idx=1 ;
   private int nGXsfl_185_idx=1 ;
   private int nGXsfl_183_idx=1 ;
   private int nGXsfl_184_idx=1 ;
   private int nGXsfl_196_idx=1 ;
   private int AV30GXV1 ;
   private int GX_JID ;
   private int Z1445PaiBaseCliCod ;
   private int A1445PaiBaseCliCod ;
   private int Z1354PaiJorCliCod ;
   private int A1354PaiJorCliCod ;
   private int Z1356PaiMenCliCod ;
   private int A1356PaiMenCliCod ;
   private java.math.BigDecimal Z1271PaiMesHsPExt ;
   private java.math.BigDecimal A1271PaiMesHsPExt ;
   private java.math.BigDecimal Z1405PaiMaxHorNor ;
   private java.math.BigDecimal A1405PaiMaxHorNor ;
   private java.math.BigDecimal Z1814PaiFracVacAnt ;
   private java.math.BigDecimal A1814PaiFracVacAnt ;
   private java.math.BigDecimal Z1737PaiVizzoti ;
   private java.math.BigDecimal A1737PaiVizzoti ;
   private java.math.BigDecimal Z1444PaiBasePlus ;
   private java.math.BigDecimal A1444PaiBasePlus ;
   private java.math.BigDecimal Z1336PaiTipoHsDia ;
   private java.math.BigDecimal A1336PaiTipoHsDia ;
   private java.math.BigDecimal Z1337PaiTipoHsSem ;
   private java.math.BigDecimal A1337PaiTipoHsSem ;
   private java.math.BigDecimal Z1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal Z1347PaiTipoTarifaRec ;
   private java.math.BigDecimal A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal Z1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal Z1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal Z1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal Z1390PaiTipoHsMaxAnu ;
   private java.math.BigDecimal A1390PaiTipoHsMaxAnu ;
   private java.math.BigDecimal Z1335PaiTarifaPDia ;
   private java.math.BigDecimal A1335PaiTarifaPDia ;
   private java.math.BigDecimal Z1348PaiTarifaPDRec ;
   private java.math.BigDecimal A1348PaiTarifaPDRec ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode38 ;
   private String sMode183 ;
   private String AV29Pgmname ;
   private String AV13Insert_PaiReligDefault ;
   private String Z1272PaiDiaHsPExt ;
   private String A1272PaiDiaHsPExt ;
   private String Z1590PaiPromMesTCnt ;
   private String A1590PaiPromMesTCnt ;
   private String Z1591PaiPromJorMesTCnt ;
   private String A1591PaiPromJorMesTCnt ;
   private String Z1252PaiReligDefault ;
   private String A1252PaiReligDefault ;
   private String Z1538PaiPreAviDur ;
   private String A1538PaiPreAviDur ;
   private String Z1536PaiAntMayDur ;
   private String A1536PaiAntMayDur ;
   private String sMode196 ;
   private String Z1453PaiBasePromTCnt ;
   private String A1453PaiBasePromTCnt ;
   private String Z1441PaiBaseTipo ;
   private String A1441PaiBaseTipo ;
   private String Z1442PaiBaseCod1 ;
   private String A1442PaiBaseCod1 ;
   private String Z1443PaiBaseCod2 ;
   private String A1443PaiBaseCod2 ;
   private String Z1446PaiBaseConCodigo ;
   private String A1446PaiBaseConCodigo ;
   private String sMode184 ;
   private String Z1448PaiBasePromCTipo ;
   private String A1448PaiBasePromCTipo ;
   private String Z1449PaiBasePromFijVar ;
   private String A1449PaiBasePromFijVar ;
   private String sMode185 ;
   private String Z1355PaiJorConCodigo ;
   private String A1355PaiJorConCodigo ;
   private String sMode168 ;
   private String Z1358PaiMesConCodigo ;
   private String A1358PaiMesConCodigo ;
   private String sMode167 ;
   private String Z1361PaiPromFijVar ;
   private String A1361PaiPromFijVar ;
   private String Z37TipoConCod ;
   private String A37TipoConCod ;
   private String sMode169 ;
   private String Z1296PaiTipoTraHor ;
   private String A1296PaiTipoTraHor ;
   private String Z1294PaiTipoTraId ;
   private String A1294PaiTipoTraId ;
   private String Z1292TipoTraId ;
   private String A1292TipoTraId ;
   private String sMode155 ;
   private String Z1334PaiHsPDiaDesde ;
   private String A1334PaiHsPDiaDesde ;
   private String Z1331PaiHsPDiaTipTra ;
   private String A1331PaiHsPDiaTipTra ;
   private String sMode164 ;
   private String sMode240 ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z311PaiNacMostrar ;
   private boolean A311PaiNacMostrar ;
   private boolean Z310PaiDomMostrar ;
   private boolean A310PaiDomMostrar ;
   private boolean Z1402PaiFondoCese ;
   private boolean A1402PaiFondoCese ;
   private boolean Z1736PaiExcVizzoti ;
   private boolean A1736PaiExcVizzoti ;
   private boolean n1252PaiReligDefault ;
   private boolean Gx_longc ;
   private boolean Z1634PaiLicAdju ;
   private boolean A1634PaiLicAdju ;
   private boolean Z1635PaiLicAdjuObl ;
   private boolean A1635PaiLicAdjuObl ;
   private boolean Z1636PaiLicNecAut ;
   private boolean A1636PaiLicNecAut ;
   private boolean Z1637PaiLicIngMot ;
   private boolean A1637PaiLicIngMot ;
   private boolean Z1638PaiLicMotObl ;
   private boolean A1638PaiLicMotObl ;
   private boolean Z1447PaiBaseConHabitual ;
   private boolean A1447PaiBaseConHabitual ;
   private boolean Z1450PaiBasePromHab ;
   private boolean A1450PaiBasePromHab ;
   private boolean Z1360PaiJorHabitual ;
   private boolean A1360PaiJorHabitual ;
   private boolean Z1359PaiMesHabitual ;
   private boolean A1359PaiMesHabitual ;
   private boolean Z1362PaiPromHabitual ;
   private boolean A1362PaiPromHabitual ;
   private boolean Z1297PaiTipoTraIns ;
   private boolean A1297PaiTipoTraIns ;
   private boolean n1296PaiTipoTraHor ;
   private boolean n1334PaiHsPDiaDesde ;
   private boolean mustCommit ;
   private String Z312PaiNom ;
   private String A312PaiNom ;
   private String Z1295PaiTipoTraNom ;
   private String A1295PaiTipoTraNom ;
   private String A1293TipoTraNom ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private web.SdtPais bcPais ;
   private IDataStoreProvider pr_default ;
   private short[] BC001531_A46PaiCod ;
   private String[] BC001531_A312PaiNom ;
   private boolean[] BC001531_A311PaiNacMostrar ;
   private boolean[] BC001531_A310PaiDomMostrar ;
   private java.math.BigDecimal[] BC001531_A1271PaiMesHsPExt ;
   private String[] BC001531_A1272PaiDiaHsPExt ;
   private boolean[] BC001531_A1402PaiFondoCese ;
   private java.math.BigDecimal[] BC001531_A1405PaiMaxHorNor ;
   private byte[] BC001531_A1521PaiPerVacDes ;
   private byte[] BC001531_A1522PaiPerVacHas ;
   private java.math.BigDecimal[] BC001531_A1814PaiFracVacAnt ;
   private byte[] BC001531_A1363PaiPromMeses ;
   private String[] BC001531_A1590PaiPromMesTCnt ;
   private byte[] BC001531_A1573PaiPromJorMeses ;
   private String[] BC001531_A1591PaiPromJorMesTCnt ;
   private byte[] BC001531_A1625PaiGuarEdadMin ;
   private byte[] BC001531_A1626PaiGuarEdadMax ;
   private boolean[] BC001531_A1736PaiExcVizzoti ;
   private java.math.BigDecimal[] BC001531_A1737PaiVizzoti ;
   private byte[] BC001531_A1764PaiMinMesesVac ;
   private short[] BC001531_A1765PaiInterDiasJor ;
   private byte[] BC001531_A1793PaiTipoExpDef ;
   private String[] BC001531_A1252PaiReligDefault ;
   private boolean[] BC001531_n1252PaiReligDefault ;
   private String[] BC001532_A1252PaiReligDefault ;
   private boolean[] BC001532_n1252PaiReligDefault ;
   private short[] BC001533_A46PaiCod ;
   private short[] BC001534_A46PaiCod ;
   private String[] BC001534_A312PaiNom ;
   private boolean[] BC001534_A311PaiNacMostrar ;
   private boolean[] BC001534_A310PaiDomMostrar ;
   private java.math.BigDecimal[] BC001534_A1271PaiMesHsPExt ;
   private String[] BC001534_A1272PaiDiaHsPExt ;
   private boolean[] BC001534_A1402PaiFondoCese ;
   private java.math.BigDecimal[] BC001534_A1405PaiMaxHorNor ;
   private byte[] BC001534_A1521PaiPerVacDes ;
   private byte[] BC001534_A1522PaiPerVacHas ;
   private java.math.BigDecimal[] BC001534_A1814PaiFracVacAnt ;
   private byte[] BC001534_A1363PaiPromMeses ;
   private String[] BC001534_A1590PaiPromMesTCnt ;
   private byte[] BC001534_A1573PaiPromJorMeses ;
   private String[] BC001534_A1591PaiPromJorMesTCnt ;
   private byte[] BC001534_A1625PaiGuarEdadMin ;
   private byte[] BC001534_A1626PaiGuarEdadMax ;
   private boolean[] BC001534_A1736PaiExcVizzoti ;
   private java.math.BigDecimal[] BC001534_A1737PaiVizzoti ;
   private byte[] BC001534_A1764PaiMinMesesVac ;
   private short[] BC001534_A1765PaiInterDiasJor ;
   private byte[] BC001534_A1793PaiTipoExpDef ;
   private String[] BC001534_A1252PaiReligDefault ;
   private boolean[] BC001534_n1252PaiReligDefault ;
   private short[] BC001535_A46PaiCod ;
   private String[] BC001535_A312PaiNom ;
   private boolean[] BC001535_A311PaiNacMostrar ;
   private boolean[] BC001535_A310PaiDomMostrar ;
   private java.math.BigDecimal[] BC001535_A1271PaiMesHsPExt ;
   private String[] BC001535_A1272PaiDiaHsPExt ;
   private boolean[] BC001535_A1402PaiFondoCese ;
   private java.math.BigDecimal[] BC001535_A1405PaiMaxHorNor ;
   private byte[] BC001535_A1521PaiPerVacDes ;
   private byte[] BC001535_A1522PaiPerVacHas ;
   private java.math.BigDecimal[] BC001535_A1814PaiFracVacAnt ;
   private byte[] BC001535_A1363PaiPromMeses ;
   private String[] BC001535_A1590PaiPromMesTCnt ;
   private byte[] BC001535_A1573PaiPromJorMeses ;
   private String[] BC001535_A1591PaiPromJorMesTCnt ;
   private byte[] BC001535_A1625PaiGuarEdadMin ;
   private byte[] BC001535_A1626PaiGuarEdadMax ;
   private boolean[] BC001535_A1736PaiExcVizzoti ;
   private java.math.BigDecimal[] BC001535_A1737PaiVizzoti ;
   private byte[] BC001535_A1764PaiMinMesesVac ;
   private short[] BC001535_A1765PaiInterDiasJor ;
   private byte[] BC001535_A1793PaiTipoExpDef ;
   private String[] BC001535_A1252PaiReligDefault ;
   private boolean[] BC001535_n1252PaiReligDefault ;
   private String[] BC001539_A37TipoConCod ;
   private byte[] BC001540_A1923RolId ;
   private byte[] BC001540_A1925PerfilId ;
   private long[] BC001540_A1928MenuVerId ;
   private String[] BC001541_A953ConCondicion ;
   private short[] BC001542_A1748EstaCivilCod ;
   private byte[] BC001543_A1743SexoId ;
   private int[] BC001544_A3CliCod ;
   private String[] BC001544_A26ConCodigo ;
   private String[] BC001545_A16SitCodigo ;
   private int[] BC001546_A3CliCod ;
   private short[] BC001546_A1564CliPaiConve ;
   private String[] BC001546_A1565CliConvenio ;
   private String[] BC001546_A8CatCodigo ;
   private short[] BC001546_A2200CatPaiCod ;
   private short[] BC001546_A2201CatProvCod ;
   private int[] BC001547_A3CliCod ;
   private short[] BC001547_A1564CliPaiConve ;
   private String[] BC001547_A1565CliConvenio ;
   private int[] BC001548_A3CliCod ;
   private short[] BC001548_A1EmpCod ;
   private short[] BC001548_A1562EmpConvePai ;
   private String[] BC001548_A1561EmpConveCod ;
   private short[] BC001549_A1161EmbargaSec ;
   private short[] BC001550_A1163TipoOblSec ;
   private short[] BC001551_A1151ARTSec ;
   private String[] BC001552_A903ActComCodigo ;
   private short[] BC001552_A993ActComAdiPai ;
   private String[] BC001552_A994ActComAdiCod ;
   private short[] BC001553_A67SecUserId ;
   private short[] BC001554_A46PaiCod ;
   private int[] BC001554_A2217ActLabNro ;
   private short[] BC001555_A46PaiCod ;
   private byte[] BC001555_A1440PaiBaseClaseLeg ;
   private String[] BC001555_A1441PaiBaseTipo ;
   private String[] BC001555_A1442PaiBaseCod1 ;
   private String[] BC001555_A1443PaiBaseCod2 ;
   private short[] BC001556_A46PaiCod ;
   private short[] BC001556_A1395PaiRanEtDesde ;
   private short[] BC001557_A46PaiCod ;
   private short[] BC001557_A1332PaiHsExSec ;
   private short[] BC001558_A46PaiCod ;
   private String[] BC001558_A1282PaiOrigen ;
   private short[] BC001559_A46PaiCod ;
   private String[] BC001559_A1253PaiReligion ;
   private short[] BC001560_A46PaiCod ;
   private String[] BC001560_A1223FerId ;
   private short[] BC001561_A46PaiCod ;
   private String[] BC001561_A1221FerTipo ;
   private short[] BC001562_A46PaiCod ;
   private String[] BC001562_A988AdicionalCod ;
   private short[] BC001563_A46PaiCod ;
   private String[] BC001563_A14SinCod ;
   private short[] BC001564_A46PaiCod ;
   private String[] BC001564_A9ConveCodigo ;
   private short[] BC001565_A46PaiCod ;
   private String[] BC001565_A74idOperando ;
   private short[] BC001566_A46PaiCod ;
   private short[] BC001566_A47ProvCod ;
   private int[] BC001567_A3CliCod ;
   private short[] BC001567_A1EmpCod ;
   private int[] BC001567_A6LegNumero ;
   private int[] BC001568_A3CliCod ;
   private short[] BC001568_A1EmpCod ;
   private int[] BC001568_A6LegNumero ;
   private int[] BC001569_A3CliCod ;
   private short[] BC001570_A46PaiCod ;
   private String[] BC001570_A312PaiNom ;
   private boolean[] BC001570_A311PaiNacMostrar ;
   private boolean[] BC001570_A310PaiDomMostrar ;
   private java.math.BigDecimal[] BC001570_A1271PaiMesHsPExt ;
   private String[] BC001570_A1272PaiDiaHsPExt ;
   private boolean[] BC001570_A1402PaiFondoCese ;
   private java.math.BigDecimal[] BC001570_A1405PaiMaxHorNor ;
   private byte[] BC001570_A1521PaiPerVacDes ;
   private byte[] BC001570_A1522PaiPerVacHas ;
   private java.math.BigDecimal[] BC001570_A1814PaiFracVacAnt ;
   private byte[] BC001570_A1363PaiPromMeses ;
   private String[] BC001570_A1590PaiPromMesTCnt ;
   private byte[] BC001570_A1573PaiPromJorMeses ;
   private String[] BC001570_A1591PaiPromJorMesTCnt ;
   private byte[] BC001570_A1625PaiGuarEdadMin ;
   private byte[] BC001570_A1626PaiGuarEdadMax ;
   private boolean[] BC001570_A1736PaiExcVizzoti ;
   private java.math.BigDecimal[] BC001570_A1737PaiVizzoti ;
   private byte[] BC001570_A1764PaiMinMesesVac ;
   private short[] BC001570_A1765PaiInterDiasJor ;
   private byte[] BC001570_A1793PaiTipoExpDef ;
   private String[] BC001570_A1252PaiReligDefault ;
   private boolean[] BC001570_n1252PaiReligDefault ;
   private short[] BC001571_A46PaiCod ;
   private byte[] BC001571_A1535PaiAntMayCant ;
   private String[] BC001571_A1536PaiAntMayDur ;
   private byte[] BC001571_A1537PaiPreAviCant ;
   private String[] BC001571_A1538PaiPreAviDur ;
   private short[] BC001572_A46PaiCod ;
   private byte[] BC001572_A1535PaiAntMayCant ;
   private String[] BC001572_A1536PaiAntMayDur ;
   private short[] BC001573_A46PaiCod ;
   private byte[] BC001573_A1535PaiAntMayCant ;
   private String[] BC001573_A1536PaiAntMayDur ;
   private byte[] BC001573_A1537PaiPreAviCant ;
   private String[] BC001573_A1538PaiPreAviDur ;
   private short[] BC001574_A46PaiCod ;
   private byte[] BC001574_A1535PaiAntMayCant ;
   private String[] BC001574_A1536PaiAntMayDur ;
   private byte[] BC001574_A1537PaiPreAviCant ;
   private String[] BC001574_A1538PaiPreAviDur ;
   private short[] BC001578_A46PaiCod ;
   private byte[] BC001578_A1535PaiAntMayCant ;
   private String[] BC001578_A1536PaiAntMayDur ;
   private byte[] BC001578_A1537PaiPreAviCant ;
   private String[] BC001578_A1538PaiPreAviDur ;
   private short[] BC001579_A46PaiCod ;
   private byte[] BC001579_A1440PaiBaseClaseLeg ;
   private String[] BC001579_A1441PaiBaseTipo ;
   private String[] BC001579_A1442PaiBaseCod1 ;
   private String[] BC001579_A1443PaiBaseCod2 ;
   private java.math.BigDecimal[] BC001579_A1444PaiBasePlus ;
   private short[] BC001579_A1629PaiLicDLim ;
   private byte[] BC001579_A1630PaiLicDSeman ;
   private byte[] BC001579_A1631PaiLicDMes ;
   private short[] BC001579_A1632PaiLicDSemes ;
   private short[] BC001579_A1633PaiLicDAnual ;
   private boolean[] BC001579_A1634PaiLicAdju ;
   private boolean[] BC001579_A1635PaiLicAdjuObl ;
   private boolean[] BC001579_A1636PaiLicNecAut ;
   private boolean[] BC001579_A1637PaiLicIngMot ;
   private boolean[] BC001579_A1638PaiLicMotObl ;
   private short[] BC001579_A1451PaiBasePromCnt1 ;
   private short[] BC001579_A1452PaiBasePromCnt2 ;
   private String[] BC001579_A1453PaiBasePromTCnt ;
   private short[] BC001580_A46PaiCod ;
   private byte[] BC001580_A1440PaiBaseClaseLeg ;
   private String[] BC001580_A1441PaiBaseTipo ;
   private String[] BC001580_A1442PaiBaseCod1 ;
   private String[] BC001580_A1443PaiBaseCod2 ;
   private short[] BC001581_A46PaiCod ;
   private byte[] BC001581_A1440PaiBaseClaseLeg ;
   private String[] BC001581_A1441PaiBaseTipo ;
   private String[] BC001581_A1442PaiBaseCod1 ;
   private String[] BC001581_A1443PaiBaseCod2 ;
   private java.math.BigDecimal[] BC001581_A1444PaiBasePlus ;
   private short[] BC001581_A1629PaiLicDLim ;
   private byte[] BC001581_A1630PaiLicDSeman ;
   private byte[] BC001581_A1631PaiLicDMes ;
   private short[] BC001581_A1632PaiLicDSemes ;
   private short[] BC001581_A1633PaiLicDAnual ;
   private boolean[] BC001581_A1634PaiLicAdju ;
   private boolean[] BC001581_A1635PaiLicAdjuObl ;
   private boolean[] BC001581_A1636PaiLicNecAut ;
   private boolean[] BC001581_A1637PaiLicIngMot ;
   private boolean[] BC001581_A1638PaiLicMotObl ;
   private short[] BC001581_A1451PaiBasePromCnt1 ;
   private short[] BC001581_A1452PaiBasePromCnt2 ;
   private String[] BC001581_A1453PaiBasePromTCnt ;
   private short[] BC001582_A46PaiCod ;
   private byte[] BC001582_A1440PaiBaseClaseLeg ;
   private String[] BC001582_A1441PaiBaseTipo ;
   private String[] BC001582_A1442PaiBaseCod1 ;
   private String[] BC001582_A1443PaiBaseCod2 ;
   private java.math.BigDecimal[] BC001582_A1444PaiBasePlus ;
   private short[] BC001582_A1629PaiLicDLim ;
   private byte[] BC001582_A1630PaiLicDSeman ;
   private byte[] BC001582_A1631PaiLicDMes ;
   private short[] BC001582_A1632PaiLicDSemes ;
   private short[] BC001582_A1633PaiLicDAnual ;
   private boolean[] BC001582_A1634PaiLicAdju ;
   private boolean[] BC001582_A1635PaiLicAdjuObl ;
   private boolean[] BC001582_A1636PaiLicNecAut ;
   private boolean[] BC001582_A1637PaiLicIngMot ;
   private boolean[] BC001582_A1638PaiLicMotObl ;
   private short[] BC001582_A1451PaiBasePromCnt1 ;
   private short[] BC001582_A1452PaiBasePromCnt2 ;
   private String[] BC001582_A1453PaiBasePromTCnt ;
   private short[] BC001586_A46PaiCod ;
   private byte[] BC001586_A1440PaiBaseClaseLeg ;
   private String[] BC001586_A1441PaiBaseTipo ;
   private String[] BC001586_A1442PaiBaseCod1 ;
   private String[] BC001586_A1443PaiBaseCod2 ;
   private java.math.BigDecimal[] BC001586_A1444PaiBasePlus ;
   private short[] BC001586_A1629PaiLicDLim ;
   private byte[] BC001586_A1630PaiLicDSeman ;
   private byte[] BC001586_A1631PaiLicDMes ;
   private short[] BC001586_A1632PaiLicDSemes ;
   private short[] BC001586_A1633PaiLicDAnual ;
   private boolean[] BC001586_A1634PaiLicAdju ;
   private boolean[] BC001586_A1635PaiLicAdjuObl ;
   private boolean[] BC001586_A1636PaiLicNecAut ;
   private boolean[] BC001586_A1637PaiLicIngMot ;
   private boolean[] BC001586_A1638PaiLicMotObl ;
   private short[] BC001586_A1451PaiBasePromCnt1 ;
   private short[] BC001586_A1452PaiBasePromCnt2 ;
   private String[] BC001586_A1453PaiBasePromTCnt ;
   private byte[] BC001587_A1440PaiBaseClaseLeg ;
   private String[] BC001587_A1441PaiBaseTipo ;
   private String[] BC001587_A1442PaiBaseCod1 ;
   private String[] BC001587_A1443PaiBaseCod2 ;
   private boolean[] BC001587_A1447PaiBaseConHabitual ;
   private int[] BC001587_A1445PaiBaseCliCod ;
   private String[] BC001587_A1446PaiBaseConCodigo ;
   private short[] BC001587_A46PaiCod ;
   private int[] BC001588_A1445PaiBaseCliCod ;
   private short[] BC001589_A46PaiCod ;
   private byte[] BC001589_A1440PaiBaseClaseLeg ;
   private String[] BC001589_A1441PaiBaseTipo ;
   private String[] BC001589_A1442PaiBaseCod1 ;
   private String[] BC001589_A1443PaiBaseCod2 ;
   private int[] BC001589_A1445PaiBaseCliCod ;
   private String[] BC001589_A1446PaiBaseConCodigo ;
   private byte[] BC001590_A1440PaiBaseClaseLeg ;
   private String[] BC001590_A1441PaiBaseTipo ;
   private String[] BC001590_A1442PaiBaseCod1 ;
   private String[] BC001590_A1443PaiBaseCod2 ;
   private boolean[] BC001590_A1447PaiBaseConHabitual ;
   private int[] BC001590_A1445PaiBaseCliCod ;
   private String[] BC001590_A1446PaiBaseConCodigo ;
   private short[] BC001590_A46PaiCod ;
   private byte[] BC001591_A1440PaiBaseClaseLeg ;
   private String[] BC001591_A1441PaiBaseTipo ;
   private String[] BC001591_A1442PaiBaseCod1 ;
   private String[] BC001591_A1443PaiBaseCod2 ;
   private boolean[] BC001591_A1447PaiBaseConHabitual ;
   private int[] BC001591_A1445PaiBaseCliCod ;
   private String[] BC001591_A1446PaiBaseConCodigo ;
   private short[] BC001591_A46PaiCod ;
   private byte[] BC001595_A1440PaiBaseClaseLeg ;
   private String[] BC001595_A1441PaiBaseTipo ;
   private String[] BC001595_A1442PaiBaseCod1 ;
   private String[] BC001595_A1443PaiBaseCod2 ;
   private boolean[] BC001595_A1447PaiBaseConHabitual ;
   private int[] BC001595_A1445PaiBaseCliCod ;
   private String[] BC001595_A1446PaiBaseConCodigo ;
   private short[] BC001595_A46PaiCod ;
   private short[] BC001596_A46PaiCod ;
   private byte[] BC001596_A1440PaiBaseClaseLeg ;
   private String[] BC001596_A1441PaiBaseTipo ;
   private String[] BC001596_A1442PaiBaseCod1 ;
   private String[] BC001596_A1443PaiBaseCod2 ;
   private String[] BC001596_A1448PaiBasePromCTipo ;
   private String[] BC001596_A1449PaiBasePromFijVar ;
   private boolean[] BC001596_A1450PaiBasePromHab ;
   private short[] BC001597_A46PaiCod ;
   private byte[] BC001597_A1440PaiBaseClaseLeg ;
   private String[] BC001597_A1441PaiBaseTipo ;
   private String[] BC001597_A1442PaiBaseCod1 ;
   private String[] BC001597_A1443PaiBaseCod2 ;
   private String[] BC001597_A1448PaiBasePromCTipo ;
   private String[] BC001597_A1449PaiBasePromFijVar ;
   private short[] BC001598_A46PaiCod ;
   private byte[] BC001598_A1440PaiBaseClaseLeg ;
   private String[] BC001598_A1441PaiBaseTipo ;
   private String[] BC001598_A1442PaiBaseCod1 ;
   private String[] BC001598_A1443PaiBaseCod2 ;
   private String[] BC001598_A1448PaiBasePromCTipo ;
   private String[] BC001598_A1449PaiBasePromFijVar ;
   private boolean[] BC001598_A1450PaiBasePromHab ;
   private short[] BC001599_A46PaiCod ;
   private byte[] BC001599_A1440PaiBaseClaseLeg ;
   private String[] BC001599_A1441PaiBaseTipo ;
   private String[] BC001599_A1442PaiBaseCod1 ;
   private String[] BC001599_A1443PaiBaseCod2 ;
   private String[] BC001599_A1448PaiBasePromCTipo ;
   private String[] BC001599_A1449PaiBasePromFijVar ;
   private boolean[] BC001599_A1450PaiBasePromHab ;
   private short[] BC0015103_A46PaiCod ;
   private byte[] BC0015103_A1440PaiBaseClaseLeg ;
   private String[] BC0015103_A1441PaiBaseTipo ;
   private String[] BC0015103_A1442PaiBaseCod1 ;
   private String[] BC0015103_A1443PaiBaseCod2 ;
   private String[] BC0015103_A1448PaiBasePromCTipo ;
   private String[] BC0015103_A1449PaiBasePromFijVar ;
   private boolean[] BC0015103_A1450PaiBasePromHab ;
   private boolean[] BC0015104_A1360PaiJorHabitual ;
   private int[] BC0015104_A1354PaiJorCliCod ;
   private String[] BC0015104_A1355PaiJorConCodigo ;
   private short[] BC0015104_A46PaiCod ;
   private int[] BC0015105_A1354PaiJorCliCod ;
   private short[] BC0015106_A46PaiCod ;
   private int[] BC0015106_A1354PaiJorCliCod ;
   private String[] BC0015106_A1355PaiJorConCodigo ;
   private boolean[] BC0015107_A1360PaiJorHabitual ;
   private int[] BC0015107_A1354PaiJorCliCod ;
   private String[] BC0015107_A1355PaiJorConCodigo ;
   private short[] BC0015107_A46PaiCod ;
   private boolean[] BC0015108_A1360PaiJorHabitual ;
   private int[] BC0015108_A1354PaiJorCliCod ;
   private String[] BC0015108_A1355PaiJorConCodigo ;
   private short[] BC0015108_A46PaiCod ;
   private boolean[] BC0015112_A1360PaiJorHabitual ;
   private int[] BC0015112_A1354PaiJorCliCod ;
   private String[] BC0015112_A1355PaiJorConCodigo ;
   private short[] BC0015112_A46PaiCod ;
   private boolean[] BC0015113_A1359PaiMesHabitual ;
   private int[] BC0015113_A1356PaiMenCliCod ;
   private String[] BC0015113_A1358PaiMesConCodigo ;
   private short[] BC0015113_A46PaiCod ;
   private int[] BC0015114_A1356PaiMenCliCod ;
   private short[] BC0015115_A46PaiCod ;
   private int[] BC0015115_A1356PaiMenCliCod ;
   private String[] BC0015115_A1358PaiMesConCodigo ;
   private boolean[] BC0015116_A1359PaiMesHabitual ;
   private int[] BC0015116_A1356PaiMenCliCod ;
   private String[] BC0015116_A1358PaiMesConCodigo ;
   private short[] BC0015116_A46PaiCod ;
   private boolean[] BC0015117_A1359PaiMesHabitual ;
   private int[] BC0015117_A1356PaiMenCliCod ;
   private String[] BC0015117_A1358PaiMesConCodigo ;
   private short[] BC0015117_A46PaiCod ;
   private boolean[] BC0015121_A1359PaiMesHabitual ;
   private int[] BC0015121_A1356PaiMenCliCod ;
   private String[] BC0015121_A1358PaiMesConCodigo ;
   private short[] BC0015121_A46PaiCod ;
   private short[] BC0015122_A46PaiCod ;
   private String[] BC0015122_A1361PaiPromFijVar ;
   private boolean[] BC0015122_A1362PaiPromHabitual ;
   private String[] BC0015122_A37TipoConCod ;
   private String[] BC0015123_A37TipoConCod ;
   private short[] BC0015124_A46PaiCod ;
   private String[] BC0015124_A37TipoConCod ;
   private String[] BC0015124_A1361PaiPromFijVar ;
   private short[] BC0015125_A46PaiCod ;
   private String[] BC0015125_A1361PaiPromFijVar ;
   private boolean[] BC0015125_A1362PaiPromHabitual ;
   private String[] BC0015125_A37TipoConCod ;
   private short[] BC0015126_A46PaiCod ;
   private String[] BC0015126_A1361PaiPromFijVar ;
   private boolean[] BC0015126_A1362PaiPromHabitual ;
   private String[] BC0015126_A37TipoConCod ;
   private short[] BC0015130_A46PaiCod ;
   private String[] BC0015130_A1361PaiPromFijVar ;
   private boolean[] BC0015130_A1362PaiPromHabitual ;
   private String[] BC0015130_A37TipoConCod ;
   private String[] BC0015131_A1292TipoTraId ;
   private short[] BC0015131_A46PaiCod ;
   private String[] BC0015131_A1296PaiTipoTraHor ;
   private boolean[] BC0015131_n1296PaiTipoTraHor ;
   private boolean[] BC0015131_A1297PaiTipoTraIns ;
   private java.math.BigDecimal[] BC0015131_A1336PaiTipoHsDia ;
   private java.math.BigDecimal[] BC0015131_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] BC0015131_A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal[] BC0015131_A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal[] BC0015131_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] BC0015131_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] BC0015131_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] BC0015131_A1390PaiTipoHsMaxAnu ;
   private String[] BC0015131_A1294PaiTipoTraId ;
   private String[] BC0015132_A1292TipoTraId ;
   private short[] BC0015133_A46PaiCod ;
   private String[] BC0015133_A1294PaiTipoTraId ;
   private short[] BC0015134_A46PaiCod ;
   private String[] BC0015134_A1296PaiTipoTraHor ;
   private boolean[] BC0015134_n1296PaiTipoTraHor ;
   private boolean[] BC0015134_A1297PaiTipoTraIns ;
   private java.math.BigDecimal[] BC0015134_A1336PaiTipoHsDia ;
   private java.math.BigDecimal[] BC0015134_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] BC0015134_A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal[] BC0015134_A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal[] BC0015134_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] BC0015134_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] BC0015134_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] BC0015134_A1390PaiTipoHsMaxAnu ;
   private String[] BC0015134_A1294PaiTipoTraId ;
   private short[] BC0015135_A46PaiCod ;
   private String[] BC0015135_A1296PaiTipoTraHor ;
   private boolean[] BC0015135_n1296PaiTipoTraHor ;
   private boolean[] BC0015135_A1297PaiTipoTraIns ;
   private java.math.BigDecimal[] BC0015135_A1336PaiTipoHsDia ;
   private java.math.BigDecimal[] BC0015135_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] BC0015135_A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal[] BC0015135_A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal[] BC0015135_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] BC0015135_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] BC0015135_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] BC0015135_A1390PaiTipoHsMaxAnu ;
   private String[] BC0015135_A1294PaiTipoTraId ;
   private String[] BC0015139_A1292TipoTraId ;
   private int[] BC0015140_A3CliCod ;
   private short[] BC0015140_A1564CliPaiConve ;
   private String[] BC0015140_A1565CliConvenio ;
   private String[] BC0015140_A1294PaiTipoTraId ;
   private int[] BC0015141_A3CliCod ;
   private short[] BC0015141_A1564CliPaiConve ;
   private String[] BC0015141_A1565CliConvenio ;
   private String[] BC0015141_A1294PaiTipoTraId ;
   private short[] BC0015142_A46PaiCod ;
   private short[] BC0015142_A1332PaiHsExSec ;
   private String[] BC0015143_A1292TipoTraId ;
   private short[] BC0015143_A46PaiCod ;
   private String[] BC0015143_A1296PaiTipoTraHor ;
   private boolean[] BC0015143_n1296PaiTipoTraHor ;
   private boolean[] BC0015143_A1297PaiTipoTraIns ;
   private java.math.BigDecimal[] BC0015143_A1336PaiTipoHsDia ;
   private java.math.BigDecimal[] BC0015143_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] BC0015143_A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal[] BC0015143_A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal[] BC0015143_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] BC0015143_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] BC0015143_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] BC0015143_A1390PaiTipoHsMaxAnu ;
   private String[] BC0015143_A1294PaiTipoTraId ;
   private short[] BC0015144_A1332PaiHsExSec ;
   private byte[] BC0015144_A1333PaiHsPDiaDia ;
   private String[] BC0015144_A1334PaiHsPDiaDesde ;
   private boolean[] BC0015144_n1334PaiHsPDiaDesde ;
   private java.math.BigDecimal[] BC0015144_A1335PaiTarifaPDia ;
   private java.math.BigDecimal[] BC0015144_A1348PaiTarifaPDRec ;
   private short[] BC0015144_A46PaiCod ;
   private String[] BC0015144_A1331PaiHsPDiaTipTra ;
   private short[] BC0015145_A46PaiCod ;
   private short[] BC0015146_A46PaiCod ;
   private short[] BC0015146_A1332PaiHsExSec ;
   private short[] BC0015147_A1332PaiHsExSec ;
   private byte[] BC0015147_A1333PaiHsPDiaDia ;
   private String[] BC0015147_A1334PaiHsPDiaDesde ;
   private boolean[] BC0015147_n1334PaiHsPDiaDesde ;
   private java.math.BigDecimal[] BC0015147_A1335PaiTarifaPDia ;
   private java.math.BigDecimal[] BC0015147_A1348PaiTarifaPDRec ;
   private short[] BC0015147_A46PaiCod ;
   private String[] BC0015147_A1331PaiHsPDiaTipTra ;
   private short[] BC0015148_A1332PaiHsExSec ;
   private byte[] BC0015148_A1333PaiHsPDiaDia ;
   private String[] BC0015148_A1334PaiHsPDiaDesde ;
   private boolean[] BC0015148_n1334PaiHsPDiaDesde ;
   private java.math.BigDecimal[] BC0015148_A1335PaiTarifaPDia ;
   private java.math.BigDecimal[] BC0015148_A1348PaiTarifaPDRec ;
   private short[] BC0015148_A46PaiCod ;
   private String[] BC0015148_A1331PaiHsPDiaTipTra ;
   private short[] BC0015152_A1332PaiHsExSec ;
   private byte[] BC0015152_A1333PaiHsPDiaDia ;
   private String[] BC0015152_A1334PaiHsPDiaDesde ;
   private boolean[] BC0015152_n1334PaiHsPDiaDesde ;
   private java.math.BigDecimal[] BC0015152_A1335PaiTarifaPDia ;
   private java.math.BigDecimal[] BC0015152_A1348PaiTarifaPDRec ;
   private short[] BC0015152_A46PaiCod ;
   private String[] BC0015152_A1331PaiHsPDiaTipTra ;
   private short[] BC0015153_A46PaiCod ;
   private byte[] BC0015153_A1766PaiVacDesAnt ;
   private byte[] BC0015153_A1767PaiVacHasAnt ;
   private byte[] BC0015153_A1768PaiVacDias ;
   private short[] BC0015154_A46PaiCod ;
   private byte[] BC0015154_A1766PaiVacDesAnt ;
   private short[] BC0015155_A46PaiCod ;
   private byte[] BC0015155_A1766PaiVacDesAnt ;
   private byte[] BC0015155_A1767PaiVacHasAnt ;
   private byte[] BC0015155_A1768PaiVacDias ;
   private short[] BC0015156_A46PaiCod ;
   private byte[] BC0015156_A1766PaiVacDesAnt ;
   private byte[] BC0015156_A1767PaiVacHasAnt ;
   private byte[] BC0015156_A1768PaiVacDias ;
   private short[] BC0015160_A46PaiCod ;
   private byte[] BC0015160_A1766PaiVacDesAnt ;
   private byte[] BC0015160_A1767PaiVacHasAnt ;
   private byte[] BC0015160_A1768PaiVacDias ;
   private short[] BC00152_A46PaiCod ;
   private byte[] BC00152_A1766PaiVacDesAnt ;
   private byte[] BC00152_A1767PaiVacHasAnt ;
   private byte[] BC00152_A1768PaiVacDias ;
   private short[] BC00153_A46PaiCod ;
   private byte[] BC00153_A1766PaiVacDesAnt ;
   private byte[] BC00153_A1767PaiVacHasAnt ;
   private byte[] BC00153_A1768PaiVacDias ;
   private short[] BC00154_A1332PaiHsExSec ;
   private byte[] BC00154_A1333PaiHsPDiaDia ;
   private String[] BC00154_A1334PaiHsPDiaDesde ;
   private java.math.BigDecimal[] BC00154_A1335PaiTarifaPDia ;
   private java.math.BigDecimal[] BC00154_A1348PaiTarifaPDRec ;
   private short[] BC00154_A46PaiCod ;
   private String[] BC00154_A1331PaiHsPDiaTipTra ;
   private short[] BC00155_A1332PaiHsExSec ;
   private byte[] BC00155_A1333PaiHsPDiaDia ;
   private String[] BC00155_A1334PaiHsPDiaDesde ;
   private java.math.BigDecimal[] BC00155_A1335PaiTarifaPDia ;
   private java.math.BigDecimal[] BC00155_A1348PaiTarifaPDRec ;
   private short[] BC00155_A46PaiCod ;
   private String[] BC00155_A1331PaiHsPDiaTipTra ;
   private short[] BC00156_A46PaiCod ;
   private short[] BC00157_A46PaiCod ;
   private String[] BC00157_A1296PaiTipoTraHor ;
   private boolean[] BC00157_A1297PaiTipoTraIns ;
   private java.math.BigDecimal[] BC00157_A1336PaiTipoHsDia ;
   private java.math.BigDecimal[] BC00157_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] BC00157_A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal[] BC00157_A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal[] BC00157_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] BC00157_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] BC00157_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] BC00157_A1390PaiTipoHsMaxAnu ;
   private String[] BC00157_A1294PaiTipoTraId ;
   private short[] BC00158_A46PaiCod ;
   private String[] BC00158_A1296PaiTipoTraHor ;
   private boolean[] BC00158_A1297PaiTipoTraIns ;
   private java.math.BigDecimal[] BC00158_A1336PaiTipoHsDia ;
   private java.math.BigDecimal[] BC00158_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] BC00158_A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal[] BC00158_A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal[] BC00158_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] BC00158_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] BC00158_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] BC00158_A1390PaiTipoHsMaxAnu ;
   private String[] BC00158_A1294PaiTipoTraId ;
   private String[] BC00159_A1292TipoTraId ;
   private short[] BC001510_A46PaiCod ;
   private String[] BC001510_A1361PaiPromFijVar ;
   private boolean[] BC001510_A1362PaiPromHabitual ;
   private String[] BC001510_A37TipoConCod ;
   private short[] BC001511_A46PaiCod ;
   private String[] BC001511_A1361PaiPromFijVar ;
   private boolean[] BC001511_A1362PaiPromHabitual ;
   private String[] BC001511_A37TipoConCod ;
   private String[] BC001512_A37TipoConCod ;
   private boolean[] BC001513_A1359PaiMesHabitual ;
   private int[] BC001513_A1356PaiMenCliCod ;
   private String[] BC001513_A1358PaiMesConCodigo ;
   private short[] BC001513_A46PaiCod ;
   private boolean[] BC001514_A1359PaiMesHabitual ;
   private int[] BC001514_A1356PaiMenCliCod ;
   private String[] BC001514_A1358PaiMesConCodigo ;
   private short[] BC001514_A46PaiCod ;
   private int[] BC001515_A1356PaiMenCliCod ;
   private boolean[] BC001516_A1360PaiJorHabitual ;
   private int[] BC001516_A1354PaiJorCliCod ;
   private String[] BC001516_A1355PaiJorConCodigo ;
   private short[] BC001516_A46PaiCod ;
   private boolean[] BC001517_A1360PaiJorHabitual ;
   private int[] BC001517_A1354PaiJorCliCod ;
   private String[] BC001517_A1355PaiJorConCodigo ;
   private short[] BC001517_A46PaiCod ;
   private int[] BC001518_A1354PaiJorCliCod ;
   private short[] BC001519_A46PaiCod ;
   private byte[] BC001519_A1440PaiBaseClaseLeg ;
   private String[] BC001519_A1441PaiBaseTipo ;
   private String[] BC001519_A1442PaiBaseCod1 ;
   private String[] BC001519_A1443PaiBaseCod2 ;
   private String[] BC001519_A1448PaiBasePromCTipo ;
   private String[] BC001519_A1449PaiBasePromFijVar ;
   private boolean[] BC001519_A1450PaiBasePromHab ;
   private short[] BC001520_A46PaiCod ;
   private byte[] BC001520_A1440PaiBaseClaseLeg ;
   private String[] BC001520_A1441PaiBaseTipo ;
   private String[] BC001520_A1442PaiBaseCod1 ;
   private String[] BC001520_A1443PaiBaseCod2 ;
   private String[] BC001520_A1448PaiBasePromCTipo ;
   private String[] BC001520_A1449PaiBasePromFijVar ;
   private boolean[] BC001520_A1450PaiBasePromHab ;
   private byte[] BC001521_A1440PaiBaseClaseLeg ;
   private String[] BC001521_A1441PaiBaseTipo ;
   private String[] BC001521_A1442PaiBaseCod1 ;
   private String[] BC001521_A1443PaiBaseCod2 ;
   private boolean[] BC001521_A1447PaiBaseConHabitual ;
   private int[] BC001521_A1445PaiBaseCliCod ;
   private String[] BC001521_A1446PaiBaseConCodigo ;
   private short[] BC001521_A46PaiCod ;
   private byte[] BC001522_A1440PaiBaseClaseLeg ;
   private String[] BC001522_A1441PaiBaseTipo ;
   private String[] BC001522_A1442PaiBaseCod1 ;
   private String[] BC001522_A1443PaiBaseCod2 ;
   private boolean[] BC001522_A1447PaiBaseConHabitual ;
   private int[] BC001522_A1445PaiBaseCliCod ;
   private String[] BC001522_A1446PaiBaseConCodigo ;
   private short[] BC001522_A46PaiCod ;
   private int[] BC001523_A1445PaiBaseCliCod ;
   private short[] BC001524_A46PaiCod ;
   private byte[] BC001524_A1440PaiBaseClaseLeg ;
   private String[] BC001524_A1441PaiBaseTipo ;
   private String[] BC001524_A1442PaiBaseCod1 ;
   private String[] BC001524_A1443PaiBaseCod2 ;
   private java.math.BigDecimal[] BC001524_A1444PaiBasePlus ;
   private short[] BC001524_A1629PaiLicDLim ;
   private byte[] BC001524_A1630PaiLicDSeman ;
   private byte[] BC001524_A1631PaiLicDMes ;
   private short[] BC001524_A1632PaiLicDSemes ;
   private short[] BC001524_A1633PaiLicDAnual ;
   private boolean[] BC001524_A1634PaiLicAdju ;
   private boolean[] BC001524_A1635PaiLicAdjuObl ;
   private boolean[] BC001524_A1636PaiLicNecAut ;
   private boolean[] BC001524_A1637PaiLicIngMot ;
   private boolean[] BC001524_A1638PaiLicMotObl ;
   private short[] BC001524_A1451PaiBasePromCnt1 ;
   private short[] BC001524_A1452PaiBasePromCnt2 ;
   private String[] BC001524_A1453PaiBasePromTCnt ;
   private short[] BC001525_A46PaiCod ;
   private byte[] BC001525_A1440PaiBaseClaseLeg ;
   private String[] BC001525_A1441PaiBaseTipo ;
   private String[] BC001525_A1442PaiBaseCod1 ;
   private String[] BC001525_A1443PaiBaseCod2 ;
   private java.math.BigDecimal[] BC001525_A1444PaiBasePlus ;
   private short[] BC001525_A1629PaiLicDLim ;
   private byte[] BC001525_A1630PaiLicDSeman ;
   private byte[] BC001525_A1631PaiLicDMes ;
   private short[] BC001525_A1632PaiLicDSemes ;
   private short[] BC001525_A1633PaiLicDAnual ;
   private boolean[] BC001525_A1634PaiLicAdju ;
   private boolean[] BC001525_A1635PaiLicAdjuObl ;
   private boolean[] BC001525_A1636PaiLicNecAut ;
   private boolean[] BC001525_A1637PaiLicIngMot ;
   private boolean[] BC001525_A1638PaiLicMotObl ;
   private short[] BC001525_A1451PaiBasePromCnt1 ;
   private short[] BC001525_A1452PaiBasePromCnt2 ;
   private String[] BC001525_A1453PaiBasePromTCnt ;
   private short[] BC001526_A46PaiCod ;
   private byte[] BC001526_A1535PaiAntMayCant ;
   private String[] BC001526_A1536PaiAntMayDur ;
   private byte[] BC001526_A1537PaiPreAviCant ;
   private String[] BC001526_A1538PaiPreAviDur ;
   private short[] BC001527_A46PaiCod ;
   private byte[] BC001527_A1535PaiAntMayCant ;
   private String[] BC001527_A1536PaiAntMayDur ;
   private byte[] BC001527_A1537PaiPreAviCant ;
   private String[] BC001527_A1538PaiPreAviDur ;
   private short[] BC001528_A46PaiCod ;
   private String[] BC001528_A312PaiNom ;
   private boolean[] BC001528_A311PaiNacMostrar ;
   private boolean[] BC001528_A310PaiDomMostrar ;
   private java.math.BigDecimal[] BC001528_A1271PaiMesHsPExt ;
   private String[] BC001528_A1272PaiDiaHsPExt ;
   private boolean[] BC001528_A1402PaiFondoCese ;
   private java.math.BigDecimal[] BC001528_A1405PaiMaxHorNor ;
   private byte[] BC001528_A1521PaiPerVacDes ;
   private byte[] BC001528_A1522PaiPerVacHas ;
   private java.math.BigDecimal[] BC001528_A1814PaiFracVacAnt ;
   private byte[] BC001528_A1363PaiPromMeses ;
   private String[] BC001528_A1590PaiPromMesTCnt ;
   private byte[] BC001528_A1573PaiPromJorMeses ;
   private String[] BC001528_A1591PaiPromJorMesTCnt ;
   private byte[] BC001528_A1625PaiGuarEdadMin ;
   private byte[] BC001528_A1626PaiGuarEdadMax ;
   private boolean[] BC001528_A1736PaiExcVizzoti ;
   private java.math.BigDecimal[] BC001528_A1737PaiVizzoti ;
   private byte[] BC001528_A1764PaiMinMesesVac ;
   private short[] BC001528_A1765PaiInterDiasJor ;
   private byte[] BC001528_A1793PaiTipoExpDef ;
   private String[] BC001528_A1252PaiReligDefault ;
   private short[] BC001529_A46PaiCod ;
   private String[] BC001529_A312PaiNom ;
   private boolean[] BC001529_A311PaiNacMostrar ;
   private boolean[] BC001529_A310PaiDomMostrar ;
   private java.math.BigDecimal[] BC001529_A1271PaiMesHsPExt ;
   private String[] BC001529_A1272PaiDiaHsPExt ;
   private boolean[] BC001529_A1402PaiFondoCese ;
   private java.math.BigDecimal[] BC001529_A1405PaiMaxHorNor ;
   private byte[] BC001529_A1521PaiPerVacDes ;
   private byte[] BC001529_A1522PaiPerVacHas ;
   private java.math.BigDecimal[] BC001529_A1814PaiFracVacAnt ;
   private byte[] BC001529_A1363PaiPromMeses ;
   private String[] BC001529_A1590PaiPromMesTCnt ;
   private byte[] BC001529_A1573PaiPromJorMeses ;
   private String[] BC001529_A1591PaiPromJorMesTCnt ;
   private byte[] BC001529_A1625PaiGuarEdadMin ;
   private byte[] BC001529_A1626PaiGuarEdadMax ;
   private boolean[] BC001529_A1736PaiExcVizzoti ;
   private java.math.BigDecimal[] BC001529_A1737PaiVizzoti ;
   private byte[] BC001529_A1764PaiMinMesesVac ;
   private short[] BC001529_A1765PaiInterDiasJor ;
   private byte[] BC001529_A1793PaiTipoExpDef ;
   private String[] BC001529_A1252PaiReligDefault ;
   private String[] BC001530_A1252PaiReligDefault ;
   private boolean[] BC00154_n1334PaiHsPDiaDesde ;
   private boolean[] BC00155_n1334PaiHsPDiaDesde ;
   private boolean[] BC00157_n1296PaiTipoTraHor ;
   private boolean[] BC00158_n1296PaiTipoTraHor ;
   private boolean[] BC001528_n1252PaiReligDefault ;
   private boolean[] BC001529_n1252PaiReligDefault ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class pais_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00152", "SELECT PaiCod, PaiVacDesAnt, PaiVacHasAnt, PaiVacDias FROM PaisVacaciones WHERE PaiCod = ? AND PaiVacDesAnt = ?  FOR UPDATE OF PaisVacaciones",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00153", "SELECT PaiCod, PaiVacDesAnt, PaiVacHasAnt, PaiVacDias FROM PaisVacaciones WHERE PaiCod = ? AND PaiVacDesAnt = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00154", "SELECT PaiHsExSec, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiCod, PaiHsPDiaTipTra FROM Paishorasextras_pordia WHERE PaiCod = ? AND PaiHsExSec = ?  FOR UPDATE OF Paishorasextras_pordia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00155", "SELECT PaiHsExSec, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiCod, PaiHsPDiaTipTra FROM Paishorasextras_pordia WHERE PaiCod = ? AND PaiHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00156", "SELECT PaiCod FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00157", "SELECT PaiCod, PaiTipoTraHor, PaiTipoTraIns, PaiTipoHsDia, PaiTipoHsSem, PaiTipoTarifaXLim, PaiTipoTarifaRec, PaiTipoHsMaxDia, PaiTipoHsMaxSem, PaiTipoHsMaxMes, PaiTipoHsMaxAnu, PaiTipoTraId FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ?  FOR UPDATE OF PaisTipoTrabajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00158", "SELECT PaiCod, PaiTipoTraHor, PaiTipoTraIns, PaiTipoHsDia, PaiTipoHsSem, PaiTipoTarifaXLim, PaiTipoTarifaRec, PaiTipoHsMaxDia, PaiTipoHsMaxSem, PaiTipoHsMaxMes, PaiTipoHsMaxAnu, PaiTipoTraId FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00159", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001510", "SELECT PaiCod, PaiPromFijVar, PaiPromHabitual, TipoConCod FROM Paispromedio_horanormal_mensualizados WHERE PaiCod = ? AND TipoConCod = ? AND PaiPromFijVar = ?  FOR UPDATE OF Paispromedio_horanormal_mensualizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001511", "SELECT PaiCod, PaiPromFijVar, PaiPromHabitual, TipoConCod FROM Paispromedio_horanormal_mensualizados WHERE PaiCod = ? AND TipoConCod = ? AND PaiPromFijVar = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001512", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001513", "SELECT PaiMesHabitual, PaiMenCliCod, PaiMesConCodigo, PaiCod FROM Paisconceptos_horanormal_mensualizados WHERE PaiCod = ? AND PaiMenCliCod = ? AND PaiMesConCodigo = ?  FOR UPDATE OF Paisconceptos_horanormal_mensualizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001514", "SELECT PaiMesHabitual, PaiMenCliCod, PaiMesConCodigo, PaiCod FROM Paisconceptos_horanormal_mensualizados WHERE PaiCod = ? AND PaiMenCliCod = ? AND PaiMesConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001515", "SELECT CliCod AS PaiMenCliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001516", "SELECT PaiJorHabitual, PaiJorCliCod, PaiJorConCodigo, PaiCod FROM Paisconceptos_horanormal_jornalizados WHERE PaiCod = ? AND PaiJorCliCod = ? AND PaiJorConCodigo = ?  FOR UPDATE OF Paisconceptos_horanormal_jornalizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001517", "SELECT PaiJorHabitual, PaiJorCliCod, PaiJorConCodigo, PaiCod FROM Paisconceptos_horanormal_jornalizados WHERE PaiCod = ? AND PaiJorCliCod = ? AND PaiJorConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001518", "SELECT CliCod AS PaiJorCliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001519", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePromCTipo, PaiBasePromFijVar, PaiBasePromHab FROM Paisbase_calculopromedio WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBasePromCTipo = ? AND PaiBasePromFijVar = ?  FOR UPDATE OF Paisbase_calculopromedio",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001520", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePromCTipo, PaiBasePromFijVar, PaiBasePromHab FROM Paisbase_calculopromedio WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBasePromCTipo = ? AND PaiBasePromFijVar = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001521", "SELECT PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseConHabitual, PaiBaseCliCod, PaiBaseConCodigo, PaiCod FROM Paisbase_calculoactual WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBaseCliCod = ? AND PaiBaseConCodigo = ?  FOR UPDATE OF Paisbase_calculoactual",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001522", "SELECT PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseConHabitual, PaiBaseCliCod, PaiBaseConCodigo, PaiCod FROM Paisbase_calculoactual WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBaseCliCod = ? AND PaiBaseConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001523", "SELECT CliCod AS PaiBaseCliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001524", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePlus, PaiLicDLim, PaiLicDSeman, PaiLicDMes, PaiLicDSemes, PaiLicDAnual, PaiLicAdju, PaiLicAdjuObl, PaiLicNecAut, PaiLicIngMot, PaiLicMotObl, PaiBasePromCnt1, PaiBasePromCnt2, PaiBasePromTCnt FROM Paisbase_calculo WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ?  FOR UPDATE OF Paisbase_calculo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001525", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePlus, PaiLicDLim, PaiLicDSeman, PaiLicDMes, PaiLicDSemes, PaiLicDAnual, PaiLicAdju, PaiLicAdjuObl, PaiLicNecAut, PaiLicIngMot, PaiLicMotObl, PaiBasePromCnt1, PaiBasePromCnt2, PaiBasePromTCnt FROM Paisbase_calculo WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001526", "SELECT PaiCod, PaiAntMayCant, PaiAntMayDur, PaiPreAviCant, PaiPreAviDur FROM Paispreaviso WHERE PaiCod = ? AND PaiAntMayCant = ? AND PaiAntMayDur = ?  FOR UPDATE OF Paispreaviso",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001527", "SELECT PaiCod, PaiAntMayCant, PaiAntMayDur, PaiPreAviCant, PaiPreAviDur FROM Paispreaviso WHERE PaiCod = ? AND PaiAntMayCant = ? AND PaiAntMayDur = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001528", "SELECT PaiCod, PaiNom, PaiNacMostrar, PaiDomMostrar, PaiMesHsPExt, PaiDiaHsPExt, PaiFondoCese, PaiMaxHorNor, PaiPerVacDes, PaiPerVacHas, PaiFracVacAnt, PaiPromMeses, PaiPromMesTCnt, PaiPromJorMeses, PaiPromJorMesTCnt, PaiGuarEdadMin, PaiGuarEdadMax, PaiExcVizzoti, PaiVizzoti, PaiMinMesesVac, PaiInterDiasJor, PaiTipoExpDef, PaiReligDefault FROM Pais WHERE PaiCod = ?  FOR UPDATE OF Pais",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001529", "SELECT PaiCod, PaiNom, PaiNacMostrar, PaiDomMostrar, PaiMesHsPExt, PaiDiaHsPExt, PaiFondoCese, PaiMaxHorNor, PaiPerVacDes, PaiPerVacHas, PaiFracVacAnt, PaiPromMeses, PaiPromMesTCnt, PaiPromJorMeses, PaiPromJorMesTCnt, PaiGuarEdadMin, PaiGuarEdadMax, PaiExcVizzoti, PaiVizzoti, PaiMinMesesVac, PaiInterDiasJor, PaiTipoExpDef, PaiReligDefault FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001530", "SELECT ReligId AS PaiReligDefault FROM Religion WHERE ReligId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001531", "SELECT TM1.PaiCod, TM1.PaiNom, TM1.PaiNacMostrar, TM1.PaiDomMostrar, TM1.PaiMesHsPExt, TM1.PaiDiaHsPExt, TM1.PaiFondoCese, TM1.PaiMaxHorNor, TM1.PaiPerVacDes, TM1.PaiPerVacHas, TM1.PaiFracVacAnt, TM1.PaiPromMeses, TM1.PaiPromMesTCnt, TM1.PaiPromJorMeses, TM1.PaiPromJorMesTCnt, TM1.PaiGuarEdadMin, TM1.PaiGuarEdadMax, TM1.PaiExcVizzoti, TM1.PaiVizzoti, TM1.PaiMinMesesVac, TM1.PaiInterDiasJor, TM1.PaiTipoExpDef, TM1.PaiReligDefault AS PaiReligDefault FROM Pais TM1 WHERE TM1.PaiCod = ? ORDER BY TM1.PaiCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001532", "SELECT ReligId AS PaiReligDefault FROM Religion WHERE ReligId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001533", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001534", "SELECT PaiCod, PaiNom, PaiNacMostrar, PaiDomMostrar, PaiMesHsPExt, PaiDiaHsPExt, PaiFondoCese, PaiMaxHorNor, PaiPerVacDes, PaiPerVacHas, PaiFracVacAnt, PaiPromMeses, PaiPromMesTCnt, PaiPromJorMeses, PaiPromJorMesTCnt, PaiGuarEdadMin, PaiGuarEdadMax, PaiExcVizzoti, PaiVizzoti, PaiMinMesesVac, PaiInterDiasJor, PaiTipoExpDef, PaiReligDefault FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001535", "SELECT PaiCod, PaiNom, PaiNacMostrar, PaiDomMostrar, PaiMesHsPExt, PaiDiaHsPExt, PaiFondoCese, PaiMaxHorNor, PaiPerVacDes, PaiPerVacHas, PaiFracVacAnt, PaiPromMeses, PaiPromMesTCnt, PaiPromJorMeses, PaiPromJorMesTCnt, PaiGuarEdadMin, PaiGuarEdadMax, PaiExcVizzoti, PaiVizzoti, PaiMinMesesVac, PaiInterDiasJor, PaiTipoExpDef, PaiReligDefault FROM Pais WHERE PaiCod = ?  FOR UPDATE OF Pais",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001536", "SAVEPOINT gxupdate;INSERT INTO Pais(PaiCod, PaiNom, PaiNacMostrar, PaiDomMostrar, PaiMesHsPExt, PaiDiaHsPExt, PaiFondoCese, PaiMaxHorNor, PaiPerVacDes, PaiPerVacHas, PaiFracVacAnt, PaiPromMeses, PaiPromMesTCnt, PaiPromJorMeses, PaiPromJorMesTCnt, PaiGuarEdadMin, PaiGuarEdadMax, PaiExcVizzoti, PaiVizzoti, PaiMinMesesVac, PaiInterDiasJor, PaiTipoExpDef, PaiReligDefault) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001537", "SAVEPOINT gxupdate;UPDATE Pais SET PaiNom=?, PaiNacMostrar=?, PaiDomMostrar=?, PaiMesHsPExt=?, PaiDiaHsPExt=?, PaiFondoCese=?, PaiMaxHorNor=?, PaiPerVacDes=?, PaiPerVacHas=?, PaiFracVacAnt=?, PaiPromMeses=?, PaiPromMesTCnt=?, PaiPromJorMeses=?, PaiPromJorMesTCnt=?, PaiGuarEdadMin=?, PaiGuarEdadMax=?, PaiExcVizzoti=?, PaiVizzoti=?, PaiMinMesesVac=?, PaiInterDiasJor=?, PaiTipoExpDef=?, PaiReligDefault=?  WHERE PaiCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001538", "SAVEPOINT gxupdate;DELETE FROM Pais  WHERE PaiCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001539", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConPai = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001540", "SELECT RolId, PerfilId, MenuVerId FROM MenuVersiones WHERE MenuPais = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001541", "SELECT ConCondicion FROM Condiciones_concepto WHERE CondicionPais = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001542", "SELECT EstaCivilCod FROM Estados_civiles WHERE EstaCivilPais = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001543", "SELECT SexoId FROM Sexos WHERE SexoPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001544", "SELECT CliCod, ConCodigo FROM Concepto WHERE ConceptoPais = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001545", "SELECT SitCodigo FROM Estado WHERE SitPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001546", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod FROM CategoriaProvincias WHERE CatPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001547", "SELECT CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE CliPaiConve = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001548", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE EmpConvePai = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001549", "SELECT EmbargaSec FROM embargabilidad WHERE EmbarPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001550", "SELECT TipoOblSec FROM tipo_obligacion WHERE TipoOblPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001551", "SELECT ARTSec FROM ART WHERE ARTPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001552", "SELECT ActComCodigo, ActComAdiPai, ActComAdiCod FROM adicional_actividad WHERE ActComAdiPai = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001553", "SELECT SecUserId FROM SecUser WHERE SecUserPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001554", "SELECT PaiCod, ActLabNro FROM ActividadLaboralClasificada WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001555", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2 FROM Paisbase_calculo WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001556", "SELECT PaiCod, PaiRanEtDesde FROM RangoEtario WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001557", "SELECT PaiCod, PaiHsExSec FROM Paishorasextras_pordia WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001558", "SELECT PaiCod, PaiOrigen FROM PaisOrigen WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001559", "SELECT PaiCod, PaiReligion FROM PaisReligion WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001560", "SELECT PaiCod, FerId FROM feriado WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001561", "SELECT PaiCod, FerTipo FROM tipo_feriado WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001562", "SELECT PaiCod, AdicionalCod FROM Adicional WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001563", "SELECT PaiCod, SinCod FROM Sindicato WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001564", "SELECT PaiCod, ConveCodigo FROM Convenio WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001565", "SELECT PaiCod, idOperando FROM calculo WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001566", "SELECT PaiCod, ProvCod FROM Provincia WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001567", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE LegPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001568", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE LegNacionCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001569", "SELECT CliCod FROM Cliente WHERE CliPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001570", "SELECT TM1.PaiCod, TM1.PaiNom, TM1.PaiNacMostrar, TM1.PaiDomMostrar, TM1.PaiMesHsPExt, TM1.PaiDiaHsPExt, TM1.PaiFondoCese, TM1.PaiMaxHorNor, TM1.PaiPerVacDes, TM1.PaiPerVacHas, TM1.PaiFracVacAnt, TM1.PaiPromMeses, TM1.PaiPromMesTCnt, TM1.PaiPromJorMeses, TM1.PaiPromJorMesTCnt, TM1.PaiGuarEdadMin, TM1.PaiGuarEdadMax, TM1.PaiExcVizzoti, TM1.PaiVizzoti, TM1.PaiMinMesesVac, TM1.PaiInterDiasJor, TM1.PaiTipoExpDef, TM1.PaiReligDefault AS PaiReligDefault FROM Pais TM1 WHERE TM1.PaiCod = ? ORDER BY TM1.PaiCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001571", "SELECT PaiCod, PaiAntMayCant, PaiAntMayDur, PaiPreAviCant, PaiPreAviDur FROM Paispreaviso WHERE PaiCod = ? and PaiAntMayCant = ? and PaiAntMayDur = ( ?) ORDER BY PaiCod, PaiAntMayCant, PaiAntMayDur ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001572", "SELECT PaiCod, PaiAntMayCant, PaiAntMayDur FROM Paispreaviso WHERE PaiCod = ? AND PaiAntMayCant = ? AND PaiAntMayDur = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001573", "SELECT PaiCod, PaiAntMayCant, PaiAntMayDur, PaiPreAviCant, PaiPreAviDur FROM Paispreaviso WHERE PaiCod = ? AND PaiAntMayCant = ? AND PaiAntMayDur = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001574", "SELECT PaiCod, PaiAntMayCant, PaiAntMayDur, PaiPreAviCant, PaiPreAviDur FROM Paispreaviso WHERE PaiCod = ? AND PaiAntMayCant = ? AND PaiAntMayDur = ?  FOR UPDATE OF Paispreaviso",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001575", "SAVEPOINT gxupdate;INSERT INTO Paispreaviso(PaiCod, PaiAntMayCant, PaiAntMayDur, PaiPreAviCant, PaiPreAviDur) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001576", "SAVEPOINT gxupdate;UPDATE Paispreaviso SET PaiPreAviCant=?, PaiPreAviDur=?  WHERE PaiCod = ? AND PaiAntMayCant = ? AND PaiAntMayDur = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001577", "SAVEPOINT gxupdate;DELETE FROM Paispreaviso  WHERE PaiCod = ? AND PaiAntMayCant = ? AND PaiAntMayDur = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001578", "SELECT PaiCod, PaiAntMayCant, PaiAntMayDur, PaiPreAviCant, PaiPreAviDur FROM Paispreaviso WHERE PaiCod = ? ORDER BY PaiCod, PaiAntMayCant, PaiAntMayDur ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001579", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePlus, PaiLicDLim, PaiLicDSeman, PaiLicDMes, PaiLicDSemes, PaiLicDAnual, PaiLicAdju, PaiLicAdjuObl, PaiLicNecAut, PaiLicIngMot, PaiLicMotObl, PaiBasePromCnt1, PaiBasePromCnt2, PaiBasePromTCnt FROM Paisbase_calculo WHERE PaiCod = ? and PaiBaseClaseLeg = ? and PaiBaseTipo = ( ?) and PaiBaseCod1 = ( ?) and PaiBaseCod2 = ( ?) ORDER BY PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2 ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001580", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2 FROM Paisbase_calculo WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001581", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePlus, PaiLicDLim, PaiLicDSeman, PaiLicDMes, PaiLicDSemes, PaiLicDAnual, PaiLicAdju, PaiLicAdjuObl, PaiLicNecAut, PaiLicIngMot, PaiLicMotObl, PaiBasePromCnt1, PaiBasePromCnt2, PaiBasePromTCnt FROM Paisbase_calculo WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001582", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePlus, PaiLicDLim, PaiLicDSeman, PaiLicDMes, PaiLicDSemes, PaiLicDAnual, PaiLicAdju, PaiLicAdjuObl, PaiLicNecAut, PaiLicIngMot, PaiLicMotObl, PaiBasePromCnt1, PaiBasePromCnt2, PaiBasePromTCnt FROM Paisbase_calculo WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ?  FOR UPDATE OF Paisbase_calculo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001583", "SAVEPOINT gxupdate;INSERT INTO Paisbase_calculo(PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePlus, PaiLicDLim, PaiLicDSeman, PaiLicDMes, PaiLicDSemes, PaiLicDAnual, PaiLicAdju, PaiLicAdjuObl, PaiLicNecAut, PaiLicIngMot, PaiLicMotObl, PaiBasePromCnt1, PaiBasePromCnt2, PaiBasePromTCnt, PaiBaseOldDefault, PaiBaseRelSec, PaiBaseRelRef, PaiBaseOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', 0, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001584", "SAVEPOINT gxupdate;UPDATE Paisbase_calculo SET PaiBasePlus=?, PaiLicDLim=?, PaiLicDSeman=?, PaiLicDMes=?, PaiLicDSemes=?, PaiLicDAnual=?, PaiLicAdju=?, PaiLicAdjuObl=?, PaiLicNecAut=?, PaiLicIngMot=?, PaiLicMotObl=?, PaiBasePromCnt1=?, PaiBasePromCnt2=?, PaiBasePromTCnt=?  WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001585", "SAVEPOINT gxupdate;DELETE FROM Paisbase_calculo  WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001586", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePlus, PaiLicDLim, PaiLicDSeman, PaiLicDMes, PaiLicDSemes, PaiLicDAnual, PaiLicAdju, PaiLicAdjuObl, PaiLicNecAut, PaiLicIngMot, PaiLicMotObl, PaiBasePromCnt1, PaiBasePromCnt2, PaiBasePromTCnt FROM Paisbase_calculo WHERE PaiCod = ? ORDER BY PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2 ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001587", "SELECT PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseConHabitual, PaiBaseCliCod, PaiBaseConCodigo, PaiCod FROM Paisbase_calculoactual WHERE PaiCod = ? and PaiBaseClaseLeg = ? and PaiBaseTipo = ( ?) and PaiBaseCod1 = ( ?) and PaiBaseCod2 = ( ?) and PaiBaseCliCod = ? and PaiBaseConCodigo = ( ?) ORDER BY PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseCliCod, PaiBaseConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001588", "SELECT CliCod AS PaiBaseCliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001589", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseCliCod, PaiBaseConCodigo FROM Paisbase_calculoactual WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBaseCliCod = ? AND PaiBaseConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001590", "SELECT PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseConHabitual, PaiBaseCliCod, PaiBaseConCodigo, PaiCod FROM Paisbase_calculoactual WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBaseCliCod = ? AND PaiBaseConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001591", "SELECT PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseConHabitual, PaiBaseCliCod, PaiBaseConCodigo, PaiCod FROM Paisbase_calculoactual WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBaseCliCod = ? AND PaiBaseConCodigo = ?  FOR UPDATE OF Paisbase_calculoactual",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001592", "SAVEPOINT gxupdate;INSERT INTO Paisbase_calculoactual(PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseConHabitual, PaiBaseCliCod, PaiBaseConCodigo, PaiCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001593", "SAVEPOINT gxupdate;UPDATE Paisbase_calculoactual SET PaiBaseConHabitual=?  WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBaseCliCod = ? AND PaiBaseConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001594", "SAVEPOINT gxupdate;DELETE FROM Paisbase_calculoactual  WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBaseCliCod = ? AND PaiBaseConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001595", "SELECT PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseConHabitual, PaiBaseCliCod, PaiBaseConCodigo, PaiCod FROM Paisbase_calculoactual WHERE PaiCod = ? and PaiBaseClaseLeg = ? and PaiBaseTipo = ( ?) and PaiBaseCod1 = ( ?) and PaiBaseCod2 = ( ?) ORDER BY PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseCliCod, PaiBaseConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001596", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePromCTipo, PaiBasePromFijVar, PaiBasePromHab FROM Paisbase_calculopromedio WHERE PaiCod = ? and PaiBaseClaseLeg = ? and PaiBaseTipo = ( ?) and PaiBaseCod1 = ( ?) and PaiBaseCod2 = ( ?) and PaiBasePromCTipo = ( ?) and PaiBasePromFijVar = ( ?) ORDER BY PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePromCTipo, PaiBasePromFijVar ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001597", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePromCTipo, PaiBasePromFijVar FROM Paisbase_calculopromedio WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBasePromCTipo = ? AND PaiBasePromFijVar = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001598", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePromCTipo, PaiBasePromFijVar, PaiBasePromHab FROM Paisbase_calculopromedio WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBasePromCTipo = ? AND PaiBasePromFijVar = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001599", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePromCTipo, PaiBasePromFijVar, PaiBasePromHab FROM Paisbase_calculopromedio WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBasePromCTipo = ? AND PaiBasePromFijVar = ?  FOR UPDATE OF Paisbase_calculopromedio",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0015100", "SAVEPOINT gxupdate;INSERT INTO Paisbase_calculopromedio(PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePromCTipo, PaiBasePromFijVar, PaiBasePromHab) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015101", "SAVEPOINT gxupdate;UPDATE Paisbase_calculopromedio SET PaiBasePromHab=?  WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBasePromCTipo = ? AND PaiBasePromFijVar = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015102", "SAVEPOINT gxupdate;DELETE FROM Paisbase_calculopromedio  WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? AND PaiBasePromCTipo = ? AND PaiBasePromFijVar = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0015103", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePromCTipo, PaiBasePromFijVar, PaiBasePromHab FROM Paisbase_calculopromedio WHERE PaiCod = ? and PaiBaseClaseLeg = ? and PaiBaseTipo = ( ?) and PaiBaseCod1 = ( ?) and PaiBaseCod2 = ( ?) ORDER BY PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePromCTipo, PaiBasePromFijVar ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015104", "SELECT PaiJorHabitual, PaiJorCliCod, PaiJorConCodigo, PaiCod FROM Paisconceptos_horanormal_jornalizados WHERE PaiCod = ? and PaiJorCliCod = ? and PaiJorConCodigo = ( ?) ORDER BY PaiCod, PaiJorCliCod, PaiJorConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015105", "SELECT CliCod AS PaiJorCliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015106", "SELECT PaiCod, PaiJorCliCod, PaiJorConCodigo FROM Paisconceptos_horanormal_jornalizados WHERE PaiCod = ? AND PaiJorCliCod = ? AND PaiJorConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015107", "SELECT PaiJorHabitual, PaiJorCliCod, PaiJorConCodigo, PaiCod FROM Paisconceptos_horanormal_jornalizados WHERE PaiCod = ? AND PaiJorCliCod = ? AND PaiJorConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015108", "SELECT PaiJorHabitual, PaiJorCliCod, PaiJorConCodigo, PaiCod FROM Paisconceptos_horanormal_jornalizados WHERE PaiCod = ? AND PaiJorCliCod = ? AND PaiJorConCodigo = ?  FOR UPDATE OF Paisconceptos_horanormal_jornalizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0015109", "SAVEPOINT gxupdate;INSERT INTO Paisconceptos_horanormal_jornalizados(PaiJorHabitual, PaiJorCliCod, PaiJorConCodigo, PaiCod) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015110", "SAVEPOINT gxupdate;UPDATE Paisconceptos_horanormal_jornalizados SET PaiJorHabitual=?  WHERE PaiCod = ? AND PaiJorCliCod = ? AND PaiJorConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015111", "SAVEPOINT gxupdate;DELETE FROM Paisconceptos_horanormal_jornalizados  WHERE PaiCod = ? AND PaiJorCliCod = ? AND PaiJorConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0015112", "SELECT PaiJorHabitual, PaiJorCliCod, PaiJorConCodigo, PaiCod FROM Paisconceptos_horanormal_jornalizados WHERE PaiCod = ? ORDER BY PaiCod, PaiJorCliCod, PaiJorConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015113", "SELECT PaiMesHabitual, PaiMenCliCod, PaiMesConCodigo, PaiCod FROM Paisconceptos_horanormal_mensualizados WHERE PaiCod = ? and PaiMenCliCod = ? and PaiMesConCodigo = ( ?) ORDER BY PaiCod, PaiMenCliCod, PaiMesConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015114", "SELECT CliCod AS PaiMenCliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015115", "SELECT PaiCod, PaiMenCliCod, PaiMesConCodigo FROM Paisconceptos_horanormal_mensualizados WHERE PaiCod = ? AND PaiMenCliCod = ? AND PaiMesConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015116", "SELECT PaiMesHabitual, PaiMenCliCod, PaiMesConCodigo, PaiCod FROM Paisconceptos_horanormal_mensualizados WHERE PaiCod = ? AND PaiMenCliCod = ? AND PaiMesConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015117", "SELECT PaiMesHabitual, PaiMenCliCod, PaiMesConCodigo, PaiCod FROM Paisconceptos_horanormal_mensualizados WHERE PaiCod = ? AND PaiMenCliCod = ? AND PaiMesConCodigo = ?  FOR UPDATE OF Paisconceptos_horanormal_mensualizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0015118", "SAVEPOINT gxupdate;INSERT INTO Paisconceptos_horanormal_mensualizados(PaiMesHabitual, PaiMenCliCod, PaiMesConCodigo, PaiCod) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015119", "SAVEPOINT gxupdate;UPDATE Paisconceptos_horanormal_mensualizados SET PaiMesHabitual=?  WHERE PaiCod = ? AND PaiMenCliCod = ? AND PaiMesConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015120", "SAVEPOINT gxupdate;DELETE FROM Paisconceptos_horanormal_mensualizados  WHERE PaiCod = ? AND PaiMenCliCod = ? AND PaiMesConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0015121", "SELECT PaiMesHabitual, PaiMenCliCod, PaiMesConCodigo, PaiCod FROM Paisconceptos_horanormal_mensualizados WHERE PaiCod = ? ORDER BY PaiCod, PaiMenCliCod, PaiMesConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015122", "SELECT PaiCod, PaiPromFijVar, PaiPromHabitual, TipoConCod FROM Paispromedio_horanormal_mensualizados WHERE PaiCod = ? and TipoConCod = ( ?) and PaiPromFijVar = ( ?) ORDER BY PaiCod, TipoConCod, PaiPromFijVar ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015123", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015124", "SELECT PaiCod, TipoConCod, PaiPromFijVar FROM Paispromedio_horanormal_mensualizados WHERE PaiCod = ? AND TipoConCod = ? AND PaiPromFijVar = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015125", "SELECT PaiCod, PaiPromFijVar, PaiPromHabitual, TipoConCod FROM Paispromedio_horanormal_mensualizados WHERE PaiCod = ? AND TipoConCod = ? AND PaiPromFijVar = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015126", "SELECT PaiCod, PaiPromFijVar, PaiPromHabitual, TipoConCod FROM Paispromedio_horanormal_mensualizados WHERE PaiCod = ? AND TipoConCod = ? AND PaiPromFijVar = ?  FOR UPDATE OF Paispromedio_horanormal_mensualizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0015127", "SAVEPOINT gxupdate;INSERT INTO Paispromedio_horanormal_mensualizados(PaiCod, PaiPromFijVar, PaiPromHabitual, TipoConCod) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015128", "SAVEPOINT gxupdate;UPDATE Paispromedio_horanormal_mensualizados SET PaiPromHabitual=?  WHERE PaiCod = ? AND TipoConCod = ? AND PaiPromFijVar = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015129", "SAVEPOINT gxupdate;DELETE FROM Paispromedio_horanormal_mensualizados  WHERE PaiCod = ? AND TipoConCod = ? AND PaiPromFijVar = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0015130", "SELECT PaiCod, PaiPromFijVar, PaiPromHabitual, TipoConCod FROM Paispromedio_horanormal_mensualizados WHERE PaiCod = ? ORDER BY PaiCod, TipoConCod, PaiPromFijVar ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015131", "SELECT T2.TipoTraId, T1.PaiCod, T1.PaiTipoTraHor, T1.PaiTipoTraIns, T1.PaiTipoHsDia, T1.PaiTipoHsSem, T1.PaiTipoTarifaXLim, T1.PaiTipoTarifaRec, T1.PaiTipoHsMaxDia, T1.PaiTipoHsMaxSem, T1.PaiTipoHsMaxMes, T1.PaiTipoHsMaxAnu, T1.PaiTipoTraId FROM (PaisTipoTrabajo T1 INNER JOIN TipoTrabajo T2 ON T2.TipoTraId = T1.PaiTipoTraId) WHERE T1.PaiCod = ? and T1.PaiTipoTraId = ( ?) ORDER BY T1.PaiCod, T1.PaiTipoTraId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015132", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015133", "SELECT PaiCod, PaiTipoTraId FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015134", "SELECT PaiCod, PaiTipoTraHor, PaiTipoTraIns, PaiTipoHsDia, PaiTipoHsSem, PaiTipoTarifaXLim, PaiTipoTarifaRec, PaiTipoHsMaxDia, PaiTipoHsMaxSem, PaiTipoHsMaxMes, PaiTipoHsMaxAnu, PaiTipoTraId FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015135", "SELECT PaiCod, PaiTipoTraHor, PaiTipoTraIns, PaiTipoHsDia, PaiTipoHsSem, PaiTipoTarifaXLim, PaiTipoTarifaRec, PaiTipoHsMaxDia, PaiTipoHsMaxSem, PaiTipoHsMaxMes, PaiTipoHsMaxAnu, PaiTipoTraId FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ?  FOR UPDATE OF PaisTipoTrabajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0015136", "SAVEPOINT gxupdate;INSERT INTO PaisTipoTrabajo(PaiCod, PaiTipoTraHor, PaiTipoTraIns, PaiTipoHsDia, PaiTipoHsSem, PaiTipoTarifaXLim, PaiTipoTarifaRec, PaiTipoHsMaxDia, PaiTipoHsMaxSem, PaiTipoHsMaxMes, PaiTipoHsMaxAnu, PaiTipoTraId, PaiTipoTraOldDefault, PaiTipoTraRelSec, PaiTipoTraRelRef, PaiTipoTraOld, PaiTipoTraHorDes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', 0, '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015137", "SAVEPOINT gxupdate;UPDATE PaisTipoTrabajo SET PaiTipoTraHor=?, PaiTipoTraIns=?, PaiTipoHsDia=?, PaiTipoHsSem=?, PaiTipoTarifaXLim=?, PaiTipoTarifaRec=?, PaiTipoHsMaxDia=?, PaiTipoHsMaxSem=?, PaiTipoHsMaxMes=?, PaiTipoHsMaxAnu=?  WHERE PaiCod = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015138", "SAVEPOINT gxupdate;DELETE FROM PaisTipoTrabajo  WHERE PaiCod = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0015139", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015140", "SELECT CliCod, CliPaiConve, CliConvenio, PaiTipoTraId FROM convenio_tiposdetrabajo WHERE CliPaiConve = ? AND PaiTipoTraId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0015141", "SELECT CliCod, CliPaiConve, CliConvenio, PaiTipoTraId FROM convenio_tiposdetrabajo WHERE CliPaiConve = ? AND PaiTipoTraId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0015142", "SELECT PaiCod, PaiHsExSec FROM Paishorasextras_pordia WHERE PaiCod = ? AND PaiHsPDiaTipTra = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0015143", "SELECT T2.TipoTraId, T1.PaiCod, T1.PaiTipoTraHor, T1.PaiTipoTraIns, T1.PaiTipoHsDia, T1.PaiTipoHsSem, T1.PaiTipoTarifaXLim, T1.PaiTipoTarifaRec, T1.PaiTipoHsMaxDia, T1.PaiTipoHsMaxSem, T1.PaiTipoHsMaxMes, T1.PaiTipoHsMaxAnu, T1.PaiTipoTraId FROM (PaisTipoTrabajo T1 INNER JOIN TipoTrabajo T2 ON T2.TipoTraId = T1.PaiTipoTraId) WHERE T1.PaiCod = ? ORDER BY T1.PaiCod, T1.PaiTipoTraId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015144", "SELECT PaiHsExSec, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiCod, PaiHsPDiaTipTra FROM Paishorasextras_pordia WHERE PaiCod = ? and PaiHsExSec = ? ORDER BY PaiCod, PaiHsExSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015145", "SELECT PaiCod FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015146", "SELECT PaiCod, PaiHsExSec FROM Paishorasextras_pordia WHERE PaiCod = ? AND PaiHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015147", "SELECT PaiHsExSec, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiCod, PaiHsPDiaTipTra FROM Paishorasextras_pordia WHERE PaiCod = ? AND PaiHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015148", "SELECT PaiHsExSec, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiCod, PaiHsPDiaTipTra FROM Paishorasextras_pordia WHERE PaiCod = ? AND PaiHsExSec = ?  FOR UPDATE OF Paishorasextras_pordia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0015149", "SAVEPOINT gxupdate;INSERT INTO Paishorasextras_pordia(PaiHsExSec, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiCod, PaiHsPDiaTipTra, PaiExtraordOldDefault, PaiExtraordRelSec, PaiExtraordRelRef, PaiExtraordOld, PaiTarifaPDCri) VALUES(?, ?, ?, ?, ?, ?, ?, '', 0, '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015150", "SAVEPOINT gxupdate;UPDATE Paishorasextras_pordia SET PaiHsPDiaDia=?, PaiHsPDiaDesde=?, PaiTarifaPDia=?, PaiTarifaPDRec=?, PaiHsPDiaTipTra=?  WHERE PaiCod = ? AND PaiHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015151", "SAVEPOINT gxupdate;DELETE FROM Paishorasextras_pordia  WHERE PaiCod = ? AND PaiHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0015152", "SELECT PaiHsExSec, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiCod, PaiHsPDiaTipTra FROM Paishorasextras_pordia WHERE PaiCod = ? ORDER BY PaiCod, PaiHsExSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015153", "SELECT PaiCod, PaiVacDesAnt, PaiVacHasAnt, PaiVacDias FROM PaisVacaciones WHERE PaiCod = ? and PaiVacDesAnt = ? ORDER BY PaiCod, PaiVacDesAnt ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015154", "SELECT PaiCod, PaiVacDesAnt FROM PaisVacaciones WHERE PaiCod = ? AND PaiVacDesAnt = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015155", "SELECT PaiCod, PaiVacDesAnt, PaiVacHasAnt, PaiVacDias FROM PaisVacaciones WHERE PaiCod = ? AND PaiVacDesAnt = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0015156", "SELECT PaiCod, PaiVacDesAnt, PaiVacHasAnt, PaiVacDias FROM PaisVacaciones WHERE PaiCod = ? AND PaiVacDesAnt = ?  FOR UPDATE OF PaisVacaciones",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0015157", "SAVEPOINT gxupdate;INSERT INTO PaisVacaciones(PaiCod, PaiVacDesAnt, PaiVacHasAnt, PaiVacDias) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015158", "SAVEPOINT gxupdate;UPDATE PaisVacaciones SET PaiVacHasAnt=?, PaiVacDias=?  WHERE PaiCod = ? AND PaiVacDesAnt = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0015159", "SAVEPOINT gxupdate;DELETE FROM PaisVacaciones  WHERE PaiCod = ? AND PaiVacDesAnt = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0015160", "SELECT PaiCod, PaiVacDesAnt, PaiVacHasAnt, PaiVacDias FROM PaisVacaciones WHERE PaiCod = ? ORDER BY PaiCod, PaiVacDesAnt ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 5);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,1);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,1);
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 5);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,1);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,1);
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 11 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 12 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 14 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 15 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 19 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 20 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 22 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               return;
            case 23 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               return;
            case 24 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 25 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 26 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,4);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((byte[]) buf[15])[0] = rslt.getByte(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(19,4);
               ((byte[]) buf[19])[0] = rslt.getByte(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((byte[]) buf[21])[0] = rslt.getByte(22);
               ((String[]) buf[22])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               return;
            case 27 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,4);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((byte[]) buf[15])[0] = rslt.getByte(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(19,4);
               ((byte[]) buf[19])[0] = rslt.getByte(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((byte[]) buf[21])[0] = rslt.getByte(22);
               ((String[]) buf[22])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               return;
            case 28 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 29 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,4);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((byte[]) buf[15])[0] = rslt.getByte(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(19,4);
               ((byte[]) buf[19])[0] = rslt.getByte(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((byte[]) buf[21])[0] = rslt.getByte(22);
               ((String[]) buf[22])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
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
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 31 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 32 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,4);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((byte[]) buf[15])[0] = rslt.getByte(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(19,4);
               ((byte[]) buf[19])[0] = rslt.getByte(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((byte[]) buf[21])[0] = rslt.getByte(22);
               ((String[]) buf[22])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               return;
            case 33 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,4);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((byte[]) buf[15])[0] = rslt.getByte(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(19,4);
               ((byte[]) buf[19])[0] = rslt.getByte(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((byte[]) buf[21])[0] = rslt.getByte(22);
               ((String[]) buf[22])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               return;
            case 37 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 38 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 39 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 40 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 41 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 42 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 43 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 44 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 45 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 46 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 47 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 48 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 49 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 50 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 51 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 52 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 53 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 54 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 55 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 56 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 57 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 58 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 59 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 61 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 62 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 63 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 64 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 65 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 66 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 67 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 68 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,4);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((byte[]) buf[15])[0] = rslt.getByte(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(19,4);
               ((byte[]) buf[19])[0] = rslt.getByte(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((byte[]) buf[21])[0] = rslt.getByte(22);
               ((String[]) buf[22])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               return;
            case 69 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 70 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 71 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 72 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 76 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 77 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               return;
            case 78 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 79 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               return;
            case 80 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               return;
            case 84 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               return;
            case 85 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 86 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 87 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               return;
            case 88 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 89 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 93 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 94 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 95 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               return;
            case 96 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 97 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 101 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 102 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 103 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 104 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 105 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 106 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 110 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 111 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 112 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 113 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 114 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 115 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 119 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
      }
      getresults120( cursor, rslt, buf) ;
   }

   public void getresults120( int cursor ,
                              IFieldGetter rslt ,
                              Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 120 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 121 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 122 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 123 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 124 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 128 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 129 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,4);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,1);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,1);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(12,1);
               ((String[]) buf[13])[0] = rslt.getString(13, 20);
               return;
            case 130 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 131 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 132 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 5);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,1);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,1);
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               return;
            case 133 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 5);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,1);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,1);
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               return;
            case 137 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 138 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 139 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 140 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 141 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,4);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,1);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,1);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(12,1);
               ((String[]) buf[13])[0] = rslt.getString(13, 20);
               return;
            case 142 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               return;
            case 143 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 144 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 145 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               return;
            case 146 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
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
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               return;
            case 151 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               return;
            case 152 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               return;
            case 153 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               return;
            case 154 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               return;
            case 158 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
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
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 7 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 10);
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 10);
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 23 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 24 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 25 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 26 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 27 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 28 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 29 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 31 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 32 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 33 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 34 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 1);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 4);
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               stmt.setString(13, (String)parms[12], 20);
               stmt.setByte(14, ((Number) parms[13]).byteValue());
               stmt.setString(15, (String)parms[14], 20);
               stmt.setByte(16, ((Number) parms[15]).byteValue());
               stmt.setByte(17, ((Number) parms[16]).byteValue());
               stmt.setBoolean(18, ((Boolean) parms[17]).booleanValue());
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[18], 4);
               stmt.setByte(20, ((Number) parms[19]).byteValue());
               stmt.setShort(21, ((Number) parms[20]).shortValue());
               stmt.setByte(22, ((Number) parms[21]).byteValue());
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 23 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(23, (String)parms[23], 20);
               }
               return;
            case 35 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 1);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 1);
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 4);
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setString(12, (String)parms[11], 20);
               stmt.setByte(13, ((Number) parms[12]).byteValue());
               stmt.setString(14, (String)parms[13], 20);
               stmt.setByte(15, ((Number) parms[14]).byteValue());
               stmt.setByte(16, ((Number) parms[15]).byteValue());
               stmt.setBoolean(17, ((Boolean) parms[16]).booleanValue());
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[17], 4);
               stmt.setByte(19, ((Number) parms[18]).byteValue());
               stmt.setShort(20, ((Number) parms[19]).shortValue());
               stmt.setByte(21, ((Number) parms[20]).byteValue());
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 22 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(22, (String)parms[22], 20);
               }
               stmt.setShort(23, ((Number) parms[23]).shortValue());
               return;
            case 36 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 37 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 38 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 39 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 40 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 41 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 42 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 43 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 44 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 45 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 46 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 47 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 48 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 49 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 50 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 51 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 52 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 53 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 54 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 55 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 56 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 57 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 58 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 59 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 61 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 62 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 63 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 64 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 65 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 66 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 67 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 68 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 69 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 70 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 71 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 72 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 73 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 74 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 75 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 76 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 77 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 78 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 79 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 80 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 81 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setBoolean(12, ((Boolean) parms[11]).booleanValue());
               stmt.setBoolean(13, ((Boolean) parms[12]).booleanValue());
               stmt.setBoolean(14, ((Boolean) parms[13]).booleanValue());
               stmt.setBoolean(15, ((Boolean) parms[14]).booleanValue());
               stmt.setBoolean(16, ((Boolean) parms[15]).booleanValue());
               stmt.setShort(17, ((Number) parms[16]).shortValue());
               stmt.setShort(18, ((Number) parms[17]).shortValue());
               stmt.setString(19, (String)parms[18], 20);
               return;
            case 82 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 4);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setString(14, (String)parms[13], 20);
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               stmt.setByte(16, ((Number) parms[15]).byteValue());
               stmt.setString(17, (String)parms[16], 20);
               stmt.setString(18, (String)parms[17], 20);
               stmt.setString(19, (String)parms[18], 20);
               return;
            case 83 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 84 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 85 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 10);
               return;
            case 86 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 87 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 10);
               return;
            case 88 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 10);
               return;
            case 89 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 10);
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 10);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 91 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 10);
               return;
            case 92 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 10);
               return;
            case 93 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 94 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 95 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 96 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 97 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 98 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               return;
            case 99 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 100 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 101 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 102 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 103 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 104 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 105 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 106 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 107 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 108 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 109 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 110 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 111 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 112 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 113 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 114 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 115 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 116 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 117 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 118 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 119 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 121 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 122 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 123 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 124 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 125 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 126 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 127 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 128 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 129 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 130 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 131 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 132 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 133 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 134 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 5);
               }
               stmt.setBoolean(3, ((Boolean) parms[3]).booleanValue());
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[4], 1);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 1);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 4);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 4);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 1);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 1);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[10], 1);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[11], 1);
               stmt.setString(12, (String)parms[12], 20);
               return;
            case 135 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 5);
               }
               stmt.setBoolean(2, ((Boolean) parms[2]).booleanValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[3], 1);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[4], 1);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 4);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 4);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 1);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 1);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 1);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[10], 1);
               stmt.setShort(11, ((Number) parms[11]).shortValue());
               stmt.setString(12, (String)parms[12], 20);
               return;
            case 136 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 137 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 138 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 139 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 140 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 141 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 142 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 143 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 144 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 145 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 146 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 147 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 5);
               }
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[4], 4);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 4);
               stmt.setShort(6, ((Number) parms[6]).shortValue());
               stmt.setString(7, (String)parms[7], 20);
               return;
            case 148 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 5);
               }
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[3], 4);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[4], 4);
               stmt.setString(5, (String)parms[5], 20);
               stmt.setShort(6, ((Number) parms[6]).shortValue());
               stmt.setShort(7, ((Number) parms[7]).shortValue());
               return;
            case 149 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 151 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 152 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 153 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 154 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 155 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               return;
            case 156 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               return;
            case 157 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 158 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

