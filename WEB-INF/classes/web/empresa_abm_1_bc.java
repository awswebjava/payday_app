package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresa_abm_1_bc extends GXWebPanel implements IGxSilentTrn
{
   public empresa_abm_1_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresa_abm_1_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresa_abm_1_bc.class ));
   }

   public empresa_abm_1_bc( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow4513( ) ;
      standaloneNotModal( ) ;
      initializeNonKey4513( ) ;
      standaloneModal( ) ;
      addRow4513( ) ;
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
         e11452 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
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

   public void confirm_450( )
   {
      beforeValidate4513( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4513( ) ;
         }
         else
         {
            checkExtendedTable4513( ) ;
            if ( AnyError == 0 )
            {
               zm4513( 17) ;
               zm4513( 18) ;
               zm4513( 19) ;
               zm4513( 20) ;
               zm4513( 21) ;
               zm4513( 22) ;
               zm4513( 23) ;
               zm4513( 24) ;
               zm4513( 25) ;
               zm4513( 26) ;
               zm4513( 27) ;
               zm4513( 28) ;
            }
            closeExtendedTableCursors4513( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode13 = Gx_mode ;
         confirm_45171( ) ;
         if ( AnyError == 0 )
         {
            confirm_45172( ) ;
            if ( AnyError == 0 )
            {
               confirm_45173( ) ;
               if ( AnyError == 0 )
               {
                  confirm_45191( ) ;
                  if ( AnyError == 0 )
                  {
                     confirm_45165( ) ;
                     if ( AnyError == 0 )
                     {
                        confirm_45166( ) ;
                        if ( AnyError == 0 )
                        {
                           confirm_45144( ) ;
                           if ( AnyError == 0 )
                           {
                              confirm_45145( ) ;
                              if ( AnyError == 0 )
                              {
                                 confirm_45146( ) ;
                                 if ( AnyError == 0 )
                                 {
                                    /* Restore parent mode. */
                                    Gx_mode = sMode13 ;
                                    IsConfirmed = (short)(1) ;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
         /* Restore parent mode. */
         Gx_mode = sMode13 ;
      }
   }

   public void confirm_45146( )
   {
      nGXsfl_146_idx = 0 ;
      while ( nGXsfl_146_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_religion().size() )
      {
         readRow45146( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound146 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_146 != 0 ) )
         {
            getKey45146( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound146 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate45146( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable45146( ) ;
                     if ( AnyError == 0 )
                     {
                        zm45146( 44) ;
                     }
                     closeExtendedTableCursors45146( ) ;
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
               if ( RcdFound146 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey45146( ) ;
                     load45146( ) ;
                     beforeValidate45146( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls45146( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_146 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate45146( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable45146( ) ;
                           if ( AnyError == 0 )
                           {
                              zm45146( 44) ;
                           }
                           closeExtendedTableCursors45146( ) ;
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
            VarsToRow146( ((web.SdtEmpresa_abm_1_nolaborables_religion)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_religion().elementAt(-1+nGXsfl_146_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_45145( )
   {
      nGXsfl_145_idx = 0 ;
      while ( nGXsfl_145_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_origen().size() )
      {
         readRow45145( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound145 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_145 != 0 ) )
         {
            getKey45145( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound145 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate45145( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable45145( ) ;
                     if ( AnyError == 0 )
                     {
                        zm45145( 42) ;
                     }
                     closeExtendedTableCursors45145( ) ;
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
               if ( RcdFound145 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey45145( ) ;
                     load45145( ) ;
                     beforeValidate45145( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls45145( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_145 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate45145( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable45145( ) ;
                           if ( AnyError == 0 )
                           {
                              zm45145( 42) ;
                           }
                           closeExtendedTableCursors45145( ) ;
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
            VarsToRow145( ((web.SdtEmpresa_abm_1_nolaborables_origen)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_origen().elementAt(-1+nGXsfl_145_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_45144( )
   {
      nGXsfl_144_idx = 0 ;
      while ( nGXsfl_144_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio().size() )
      {
         readRow45144( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound144 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_144 != 0 ) )
         {
            getKey45144( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound144 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate45144( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable45144( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors45144( ) ;
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
               if ( RcdFound144 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey45144( ) ;
                     load45144( ) ;
                     beforeValidate45144( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls45144( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_144 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate45144( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable45144( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors45144( ) ;
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
            VarsToRow144( ((web.SdtEmpresa_abm_1_nolaborables_convenio)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio().elementAt(-1+nGXsfl_144_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_45166( )
   {
      nGXsfl_166_idx = 0 ;
      while ( nGXsfl_166_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipo_trabajo().size() )
      {
         readRow45166( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound166 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_166 != 0 ) )
         {
            getKey45166( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound166 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate45166( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable45166( ) ;
                     if ( AnyError == 0 )
                     {
                        zm45166( 39) ;
                     }
                     closeExtendedTableCursors45166( ) ;
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
               if ( RcdFound166 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey45166( ) ;
                     load45166( ) ;
                     beforeValidate45166( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls45166( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_166 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate45166( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable45166( ) ;
                           if ( AnyError == 0 )
                           {
                              zm45166( 39) ;
                           }
                           closeExtendedTableCursors45166( ) ;
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
            VarsToRow166( ((web.SdtEmpresa_abm_1_tipo_trabajo)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipo_trabajo().elementAt(-1+nGXsfl_166_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_45165( )
   {
      nGXsfl_165_idx = 0 ;
      while ( nGXsfl_165_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Horasextras_pordia().size() )
      {
         readRow45165( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound165 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_165 != 0 ) )
         {
            getKey45165( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound165 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate45165( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable45165( ) ;
                     if ( AnyError == 0 )
                     {
                        zm45165( 37) ;
                     }
                     closeExtendedTableCursors45165( ) ;
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
               if ( RcdFound165 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey45165( ) ;
                     load45165( ) ;
                     beforeValidate45165( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls45165( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_165 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate45165( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable45165( ) ;
                           if ( AnyError == 0 )
                           {
                              zm45165( 37) ;
                           }
                           closeExtendedTableCursors45165( ) ;
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
            VarsToRow165( ((web.SdtEmpresa_abm_1_horasextras_pordia)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Horasextras_pordia().elementAt(-1+nGXsfl_165_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_45191( )
   {
      nGXsfl_191_idx = 0 ;
      while ( nGXsfl_191_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Base_calculo().size() )
      {
         readRow45191( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound191 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_191 != 0 ) )
         {
            getKey45191( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound191 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate45191( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable45191( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors45191( ) ;
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
               if ( RcdFound191 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey45191( ) ;
                     load45191( ) ;
                     beforeValidate45191( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls45191( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_191 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate45191( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable45191( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors45191( ) ;
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
            VarsToRow191( ((web.SdtEmpresa_abm_1_base_calculo)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Base_calculo().elementAt(-1+nGXsfl_191_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_45173( )
   {
      nGXsfl_173_idx = 0 ;
      while ( nGXsfl_173_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados().size() )
      {
         readRow45173( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound173 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_173 != 0 ) )
         {
            getKey45173( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound173 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate45173( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable45173( ) ;
                     if ( AnyError == 0 )
                     {
                        zm45173( 34) ;
                     }
                     closeExtendedTableCursors45173( ) ;
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
               if ( RcdFound173 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey45173( ) ;
                     load45173( ) ;
                     beforeValidate45173( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls45173( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_173 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate45173( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable45173( ) ;
                           if ( AnyError == 0 )
                           {
                              zm45173( 34) ;
                           }
                           closeExtendedTableCursors45173( ) ;
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
            VarsToRow173( ((web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados().elementAt(-1+nGXsfl_173_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_45172( )
   {
      nGXsfl_172_idx = 0 ;
      while ( nGXsfl_172_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados().size() )
      {
         readRow45172( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound172 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_172 != 0 ) )
         {
            getKey45172( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound172 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate45172( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable45172( ) ;
                     if ( AnyError == 0 )
                     {
                        zm45172( 32) ;
                     }
                     closeExtendedTableCursors45172( ) ;
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
               if ( RcdFound172 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey45172( ) ;
                     load45172( ) ;
                     beforeValidate45172( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls45172( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_172 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate45172( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable45172( ) ;
                           if ( AnyError == 0 )
                           {
                              zm45172( 32) ;
                           }
                           closeExtendedTableCursors45172( ) ;
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
            VarsToRow172( ((web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados().elementAt(-1+nGXsfl_172_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_45171( )
   {
      nGXsfl_171_idx = 0 ;
      while ( nGXsfl_171_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados().size() )
      {
         readRow45171( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound171 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_171 != 0 ) )
         {
            getKey45171( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound171 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate45171( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable45171( ) ;
                     if ( AnyError == 0 )
                     {
                        zm45171( 30) ;
                     }
                     closeExtendedTableCursors45171( ) ;
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
               if ( RcdFound171 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey45171( ) ;
                     load45171( ) ;
                     beforeValidate45171( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls45171( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_171 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate45171( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable45171( ) ;
                           if ( AnyError == 0 )
                           {
                              zm45171( 30) ;
                           }
                           closeExtendedTableCursors45171( ) ;
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
            VarsToRow171( ((web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados().elementAt(-1+nGXsfl_171_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e12452( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV31IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV31IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_abm_1_Insert", GXv_boolean3) ;
         empresa_abm_1_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV31IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV31IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_abm_1_Update", GXv_boolean3) ;
         empresa_abm_1_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV31IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV31IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_abm_1_Delete", GXv_boolean3) ;
         empresa_abm_1_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV31IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV31IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV71Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV71Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV72GXV1 = 1 ;
         while ( AV72GXV1 <= AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV15TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV72GXV1));
            if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PaiCod") == 0 )
            {
               AV11Insert_PaiCod = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ProvCod") == 0 )
            {
               AV12Insert_ProvCod = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LocCod") == 0 )
            {
               AV13Insert_LocCod = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ActCodigo") == 0 )
            {
               AV14Insert_ActCodigo = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TipEmpleCod") == 0 )
            {
               AV40Insert_TipEmpleCod = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EmpActComercial") == 0 )
            {
               AV64Insert_EmpActComercial = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EmpZonCod") == 0 )
            {
               AV36Insert_EmpZonCod = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ARTSec") == 0 )
            {
               AV46Insert_ARTSec = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ActComCodigo") == 0 )
            {
               AV43Insert_ActComCodigo = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EmpOsoCod") == 0 )
            {
               AV69Insert_EmpOsoCod = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EmpCondiCod") == 0 )
            {
               AV70Insert_EmpCondiCod = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            AV72GXV1 = (int)(AV72GXV1+1) ;
         }
      }
   }

   public void e11452( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm4513( int GX_JID )
   {
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
         Z2EmpNom = A2EmpNom ;
         Z177EmpCUIT = A177EmpCUIT ;
         Z178EmpDir = A178EmpDir ;
         Z180EmpTel = A180EmpTel ;
         Z176EmpCP = A176EmpCP ;
         Z1811EmpPerVacDes = A1811EmpPerVacDes ;
         Z1812EmpPerVacHas = A1812EmpPerVacHas ;
         Z532EmpReducc = A532EmpReducc ;
         Z1140EmpAntiguedad = A1140EmpAntiguedad ;
         Z1141EmpPresentismo = A1141EmpPresentismo ;
         Z1302EmpMesHsPExt = A1302EmpMesHsPExt ;
         Z1524EmpLiqFer = A1524EmpLiqFer ;
         Z1750EmpLiqFerJor = A1750EmpLiqFerJor ;
         Z1303EmpDiaHsPExt = A1303EmpDiaHsPExt ;
         Z1556EmpGuarEdadMin = A1556EmpGuarEdadMin ;
         Z1557EmpGuarEdadMax = A1557EmpGuarEdadMax ;
         Z1787EmpLiqGan = A1787EmpLiqGan ;
         Z1792EmpTipoExp = A1792EmpTipoExp ;
         Z1802EmpPromDesde = A1802EmpPromDesde ;
         Z1813EmpFracVacAnt = A1813EmpFracVacAnt ;
         Z2259EmpVacExpLim = A2259EmpVacExpLim ;
         Z2260EmpVacExpTie = A2260EmpVacExpTie ;
         Z2261EmpVacDisMax = A2261EmpVacDisMax ;
         Z2405EmpModTra = A2405EmpModTra ;
         Z2406EmpModEmpl = A2406EmpModEmpl ;
         Z2407EmpModAuto = A2407EmpModAuto ;
         Z46PaiCod = A46PaiCod ;
         Z47ProvCod = A47ProvCod ;
         Z48LocCod = A48LocCod ;
         Z43ActCodigo = A43ActCodigo ;
         Z45TipEmpleCod = A45TipEmpleCod ;
         Z1151ARTSec = A1151ARTSec ;
         Z903ActComCodigo = A903ActComCodigo ;
         Z1965EmpOsoCod = A1965EmpOsoCod ;
         Z1533EmpActComercial = A1533EmpActComercial ;
         Z44EmpZonCod = A44EmpZonCod ;
         Z2265EmpCondiCod = A2265EmpCondiCod ;
      }
      if ( ( GX_JID == 17 ) || ( GX_JID == 0 ) )
      {
         Z312PaiNom = A312PaiNom ;
      }
      if ( ( GX_JID == 18 ) || ( GX_JID == 0 ) )
      {
         Z322ProvNom = A322ProvNom ;
      }
      if ( ( GX_JID == 19 ) || ( GX_JID == 0 ) )
      {
         Z286LocNom = A286LocNom ;
      }
      if ( ( GX_JID == 20 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 21 ) || ( GX_JID == 0 ) )
      {
         Z683ActDescripSinAc = A683ActDescripSinAc ;
         Z108ActDescrip = A108ActDescrip ;
      }
      if ( ( GX_JID == 22 ) || ( GX_JID == 0 ) )
      {
         Z530TipEmpleDefIns = A530TipEmpleDefIns ;
      }
      if ( ( GX_JID == 23 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 24 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 25 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 26 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 27 ) || ( GX_JID == 0 ) )
      {
         Z518EmpZonDescrip = A518EmpZonDescrip ;
      }
      if ( ( GX_JID == 28 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -16 )
      {
         Z1EmpCod = A1EmpCod ;
         Z2EmpNom = A2EmpNom ;
         Z177EmpCUIT = A177EmpCUIT ;
         Z178EmpDir = A178EmpDir ;
         Z180EmpTel = A180EmpTel ;
         Z176EmpCP = A176EmpCP ;
         Z1811EmpPerVacDes = A1811EmpPerVacDes ;
         Z1812EmpPerVacHas = A1812EmpPerVacHas ;
         Z532EmpReducc = A532EmpReducc ;
         Z955EmpLogo = A955EmpLogo ;
         Z958EmpFirma = A958EmpFirma ;
         Z1140EmpAntiguedad = A1140EmpAntiguedad ;
         Z1141EmpPresentismo = A1141EmpPresentismo ;
         Z1302EmpMesHsPExt = A1302EmpMesHsPExt ;
         Z1524EmpLiqFer = A1524EmpLiqFer ;
         Z1750EmpLiqFerJor = A1750EmpLiqFerJor ;
         Z1303EmpDiaHsPExt = A1303EmpDiaHsPExt ;
         Z1556EmpGuarEdadMin = A1556EmpGuarEdadMin ;
         Z1557EmpGuarEdadMax = A1557EmpGuarEdadMax ;
         Z1787EmpLiqGan = A1787EmpLiqGan ;
         Z1792EmpTipoExp = A1792EmpTipoExp ;
         Z1802EmpPromDesde = A1802EmpPromDesde ;
         Z1813EmpFracVacAnt = A1813EmpFracVacAnt ;
         Z2259EmpVacExpLim = A2259EmpVacExpLim ;
         Z2260EmpVacExpTie = A2260EmpVacExpTie ;
         Z2261EmpVacDisMax = A2261EmpVacDisMax ;
         Z2405EmpModTra = A2405EmpModTra ;
         Z2406EmpModEmpl = A2406EmpModEmpl ;
         Z2407EmpModAuto = A2407EmpModAuto ;
         Z957EmpLogoExt = A957EmpLogoExt ;
         Z960EmpFirmaExt = A960EmpFirmaExt ;
         Z956EmpLogoNom = A956EmpLogoNom ;
         Z959EmpFirmaNom = A959EmpFirmaNom ;
         Z46PaiCod = A46PaiCod ;
         Z47ProvCod = A47ProvCod ;
         Z48LocCod = A48LocCod ;
         Z3CliCod = A3CliCod ;
         Z43ActCodigo = A43ActCodigo ;
         Z45TipEmpleCod = A45TipEmpleCod ;
         Z1151ARTSec = A1151ARTSec ;
         Z903ActComCodigo = A903ActComCodigo ;
         Z1965EmpOsoCod = A1965EmpOsoCod ;
         Z1533EmpActComercial = A1533EmpActComercial ;
         Z44EmpZonCod = A44EmpZonCod ;
         Z2265EmpCondiCod = A2265EmpCondiCod ;
         Z312PaiNom = A312PaiNom ;
         Z322ProvNom = A322ProvNom ;
         Z286LocNom = A286LocNom ;
         Z683ActDescripSinAc = A683ActDescripSinAc ;
         Z108ActDescrip = A108ActDescrip ;
         Z530TipEmpleDefIns = A530TipEmpleDefIns ;
         Z518EmpZonDescrip = A518EmpZonDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load4513( )
   {
      /* Using cursor BC004541 */
      pr_default.execute(39, new Object[] {Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(39) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A683ActDescripSinAc = BC004541_A683ActDescripSinAc[0] ;
         A2EmpNom = BC004541_A2EmpNom[0] ;
         A177EmpCUIT = BC004541_A177EmpCUIT[0] ;
         A178EmpDir = BC004541_A178EmpDir[0] ;
         A180EmpTel = BC004541_A180EmpTel[0] ;
         n180EmpTel = BC004541_n180EmpTel[0] ;
         A176EmpCP = BC004541_A176EmpCP[0] ;
         n176EmpCP = BC004541_n176EmpCP[0] ;
         A312PaiNom = BC004541_A312PaiNom[0] ;
         A322ProvNom = BC004541_A322ProvNom[0] ;
         A1811EmpPerVacDes = BC004541_A1811EmpPerVacDes[0] ;
         A1812EmpPerVacHas = BC004541_A1812EmpPerVacHas[0] ;
         A286LocNom = BC004541_A286LocNom[0] ;
         A108ActDescrip = BC004541_A108ActDescrip[0] ;
         A518EmpZonDescrip = BC004541_A518EmpZonDescrip[0] ;
         A532EmpReducc = BC004541_A532EmpReducc[0] ;
         A530TipEmpleDefIns = BC004541_A530TipEmpleDefIns[0] ;
         A955EmpLogo = BC004541_A955EmpLogo[0] ;
         n955EmpLogo = BC004541_n955EmpLogo[0] ;
         A958EmpFirma = BC004541_A958EmpFirma[0] ;
         n958EmpFirma = BC004541_n958EmpFirma[0] ;
         A1140EmpAntiguedad = BC004541_A1140EmpAntiguedad[0] ;
         A1141EmpPresentismo = BC004541_A1141EmpPresentismo[0] ;
         A1302EmpMesHsPExt = BC004541_A1302EmpMesHsPExt[0] ;
         n1302EmpMesHsPExt = BC004541_n1302EmpMesHsPExt[0] ;
         A1524EmpLiqFer = BC004541_A1524EmpLiqFer[0] ;
         A1750EmpLiqFerJor = BC004541_A1750EmpLiqFerJor[0] ;
         A1303EmpDiaHsPExt = BC004541_A1303EmpDiaHsPExt[0] ;
         n1303EmpDiaHsPExt = BC004541_n1303EmpDiaHsPExt[0] ;
         A1556EmpGuarEdadMin = BC004541_A1556EmpGuarEdadMin[0] ;
         A1557EmpGuarEdadMax = BC004541_A1557EmpGuarEdadMax[0] ;
         A1787EmpLiqGan = BC004541_A1787EmpLiqGan[0] ;
         A1792EmpTipoExp = BC004541_A1792EmpTipoExp[0] ;
         A1802EmpPromDesde = BC004541_A1802EmpPromDesde[0] ;
         A1813EmpFracVacAnt = BC004541_A1813EmpFracVacAnt[0] ;
         A2259EmpVacExpLim = BC004541_A2259EmpVacExpLim[0] ;
         A2260EmpVacExpTie = BC004541_A2260EmpVacExpTie[0] ;
         A2261EmpVacDisMax = BC004541_A2261EmpVacDisMax[0] ;
         A2405EmpModTra = BC004541_A2405EmpModTra[0] ;
         A2406EmpModEmpl = BC004541_A2406EmpModEmpl[0] ;
         A2407EmpModAuto = BC004541_A2407EmpModAuto[0] ;
         A957EmpLogoExt = BC004541_A957EmpLogoExt[0] ;
         n957EmpLogoExt = BC004541_n957EmpLogoExt[0] ;
         A955EmpLogo_Filetype = A957EmpLogoExt ;
         A960EmpFirmaExt = BC004541_A960EmpFirmaExt[0] ;
         n960EmpFirmaExt = BC004541_n960EmpFirmaExt[0] ;
         A958EmpFirma_Filetype = A960EmpFirmaExt ;
         A956EmpLogoNom = BC004541_A956EmpLogoNom[0] ;
         n956EmpLogoNom = BC004541_n956EmpLogoNom[0] ;
         A955EmpLogo_Filename = A956EmpLogoNom ;
         A959EmpFirmaNom = BC004541_A959EmpFirmaNom[0] ;
         n959EmpFirmaNom = BC004541_n959EmpFirmaNom[0] ;
         A958EmpFirma_Filename = A959EmpFirmaNom ;
         A46PaiCod = BC004541_A46PaiCod[0] ;
         n46PaiCod = BC004541_n46PaiCod[0] ;
         A47ProvCod = BC004541_A47ProvCod[0] ;
         n47ProvCod = BC004541_n47ProvCod[0] ;
         A48LocCod = BC004541_A48LocCod[0] ;
         n48LocCod = BC004541_n48LocCod[0] ;
         A43ActCodigo = BC004541_A43ActCodigo[0] ;
         n43ActCodigo = BC004541_n43ActCodigo[0] ;
         A45TipEmpleCod = BC004541_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC004541_n45TipEmpleCod[0] ;
         A1151ARTSec = BC004541_A1151ARTSec[0] ;
         A903ActComCodigo = BC004541_A903ActComCodigo[0] ;
         A1965EmpOsoCod = BC004541_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC004541_n1965EmpOsoCod[0] ;
         A1533EmpActComercial = BC004541_A1533EmpActComercial[0] ;
         A44EmpZonCod = BC004541_A44EmpZonCod[0] ;
         n44EmpZonCod = BC004541_n44EmpZonCod[0] ;
         A2265EmpCondiCod = BC004541_A2265EmpCondiCod[0] ;
         zm4513( -16) ;
      }
      pr_default.close(39);
      onLoadActions4513( ) ;
   }

   public void onLoadActions4513( )
   {
      AV71Pgmname = "Empresa_abm_1_BC" ;
   }

   public void checkExtendedTable4513( )
   {
      nIsDirty_13 = (short)(0) ;
      standaloneModal( ) ;
      AV71Pgmname = "Empresa_abm_1_BC" ;
      /* Using cursor BC004542 */
      pr_default.execute(40, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(40) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(40);
      /* Using cursor BC004543 */
      pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod});
      if ( (pr_default.getStatus(41) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1965EmpOsoCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Obra Social", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPOSOCOD");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(41);
      /* Using cursor BC004544 */
      pr_default.execute(42, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(42) == 101) )
      {
         if ( ! ( (0==A46PaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
            AnyError = (short)(1) ;
         }
      }
      A312PaiNom = BC004544_A312PaiNom[0] ;
      pr_default.close(42);
      /* Using cursor BC004545 */
      pr_default.execute(43, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(43) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (0==A47ProvCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROVCOD");
            AnyError = (short)(1) ;
         }
      }
      A322ProvNom = BC004545_A322ProvNom[0] ;
      pr_default.close(43);
      /* Using cursor BC004546 */
      pr_default.execute(44, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
      if ( (pr_default.getStatus(44) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (0==A47ProvCod) || (0==A48LocCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCCOD");
            AnyError = (short)(1) ;
         }
      }
      A286LocNom = BC004546_A286LocNom[0] ;
      pr_default.close(44);
      if ( ! ( ( A1811EmpPerVacDes == 1 ) || ( A1811EmpPerVacDes == 2 ) || ( A1811EmpPerVacDes == 3 ) || ( A1811EmpPerVacDes == 4 ) || ( A1811EmpPerVacDes == 5 ) || ( A1811EmpPerVacDes == 6 ) || ( A1811EmpPerVacDes == 7 ) || ( A1811EmpPerVacDes == 8 ) || ( A1811EmpPerVacDes == 9 ) || ( A1811EmpPerVacDes == 10 ) || ( A1811EmpPerVacDes == 11 ) || ( A1811EmpPerVacDes == 12 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Periodo de vacaciones desde", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1812EmpPerVacHas == 1 ) || ( A1812EmpPerVacHas == 2 ) || ( A1812EmpPerVacHas == 3 ) || ( A1812EmpPerVacHas == 4 ) || ( A1812EmpPerVacHas == 5 ) || ( A1812EmpPerVacHas == 6 ) || ( A1812EmpPerVacHas == 7 ) || ( A1812EmpPerVacHas == 8 ) || ( A1812EmpPerVacHas == 9 ) || ( A1812EmpPerVacHas == 10 ) || ( A1812EmpPerVacHas == 11 ) || ( A1812EmpPerVacHas == 12 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Periodo de vacaciones hasta", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC004547 */
      pr_default.execute(45, new Object[] {Boolean.valueOf(n43ActCodigo), A43ActCodigo});
      if ( (pr_default.getStatus(45) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A43ActCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Actividad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ACTCODIGO");
            AnyError = (short)(1) ;
         }
      }
      A683ActDescripSinAc = BC004547_A683ActDescripSinAc[0] ;
      A108ActDescrip = BC004547_A108ActDescrip[0] ;
      pr_default.close(45);
      /* Using cursor BC004548 */
      pr_default.execute(46, new Object[] {Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod});
      if ( (pr_default.getStatus(46) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A45TipEmpleCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Empleador", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPEMPLECOD");
            AnyError = (short)(1) ;
         }
      }
      A530TipEmpleDefIns = BC004548_A530TipEmpleDefIns[0] ;
      pr_default.close(46);
      /* Using cursor BC004549 */
      pr_default.execute(47, new Object[] {A1533EmpActComercial});
      if ( (pr_default.getStatus(47) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Actividad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPACTCOMERCIAL");
         AnyError = (short)(1) ;
      }
      pr_default.close(47);
      /* Using cursor BC004550 */
      pr_default.execute(48, new Object[] {Boolean.valueOf(n44EmpZonCod), A44EmpZonCod});
      if ( (pr_default.getStatus(48) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A44EmpZonCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Zona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPZONCOD");
            AnyError = (short)(1) ;
         }
      }
      A518EmpZonDescrip = BC004550_A518EmpZonDescrip[0] ;
      pr_default.close(48);
      if ( ! ( ( GXutil.strcmp(A1303EmpDiaHsPExt, "Promedio") == 0 ) || ( GXutil.strcmp(A1303EmpDiaHsPExt, "diasSemanaX4") == 0 ) || ( GXutil.strcmp(A1303EmpDiaHsPExt, "diasSemanaMes") == 0 ) || (GXutil.strcmp("", A1303EmpDiaHsPExt)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Días habiles del mes para obtener cantidad de horas del mes para cálculo de 1 hora de trabajo para empleados de clase mensual", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC004551 */
      pr_default.execute(49, new Object[] {Short.valueOf(A1151ARTSec)});
      if ( (pr_default.getStatus(49) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "ART", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ARTSEC");
         AnyError = (short)(1) ;
      }
      pr_default.close(49);
      if ( ! ( ( A1792EmpTipoExp == 1 ) || ( A1792EmpTipoExp == 2 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de exposición para clase mensual", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1802EmpPromDesde, "actual") == 0 ) || ( GXutil.strcmp(A1802EmpPromDesde, "anterior") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Calcular promedio de remuneraciones anteriores variables desde", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC004552 */
      pr_default.execute(50, new Object[] {A903ActComCodigo});
      if ( (pr_default.getStatus(50) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "actividadcomercial", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ACTCOMCODIGO");
         AnyError = (short)(1) ;
      }
      pr_default.close(50);
      /* Using cursor BC004553 */
      pr_default.execute(51, new Object[] {Short.valueOf(A2265EmpCondiCod)});
      if ( (pr_default.getStatus(51) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Condi AFIP", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCONDICOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(51);
      if ( ! ( ( GXutil.strcmp(A2405EmpModTra, "E") == 0 ) || ( GXutil.strcmp(A2405EmpModTra, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Modo de trabajo predeterminado", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors4513( )
   {
      pr_default.close(40);
      pr_default.close(41);
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
   }

   public void enableDisable( )
   {
   }

   public void getKey4513( )
   {
      /* Using cursor BC004554 */
      pr_default.execute(52, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(52) != 101) )
      {
         RcdFound13 = (short)(1) ;
      }
      else
      {
         RcdFound13 = (short)(0) ;
      }
      pr_default.close(52);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC004555 */
      pr_default.execute(53, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(53) != 101) )
      {
         zm4513( 16) ;
         RcdFound13 = (short)(1) ;
         A1EmpCod = BC004555_A1EmpCod[0] ;
         A2EmpNom = BC004555_A2EmpNom[0] ;
         A177EmpCUIT = BC004555_A177EmpCUIT[0] ;
         A178EmpDir = BC004555_A178EmpDir[0] ;
         A180EmpTel = BC004555_A180EmpTel[0] ;
         n180EmpTel = BC004555_n180EmpTel[0] ;
         A176EmpCP = BC004555_A176EmpCP[0] ;
         n176EmpCP = BC004555_n176EmpCP[0] ;
         A1811EmpPerVacDes = BC004555_A1811EmpPerVacDes[0] ;
         A1812EmpPerVacHas = BC004555_A1812EmpPerVacHas[0] ;
         A532EmpReducc = BC004555_A532EmpReducc[0] ;
         A955EmpLogo = BC004555_A955EmpLogo[0] ;
         n955EmpLogo = BC004555_n955EmpLogo[0] ;
         A958EmpFirma = BC004555_A958EmpFirma[0] ;
         n958EmpFirma = BC004555_n958EmpFirma[0] ;
         A1140EmpAntiguedad = BC004555_A1140EmpAntiguedad[0] ;
         A1141EmpPresentismo = BC004555_A1141EmpPresentismo[0] ;
         A1302EmpMesHsPExt = BC004555_A1302EmpMesHsPExt[0] ;
         n1302EmpMesHsPExt = BC004555_n1302EmpMesHsPExt[0] ;
         A1524EmpLiqFer = BC004555_A1524EmpLiqFer[0] ;
         A1750EmpLiqFerJor = BC004555_A1750EmpLiqFerJor[0] ;
         A1303EmpDiaHsPExt = BC004555_A1303EmpDiaHsPExt[0] ;
         n1303EmpDiaHsPExt = BC004555_n1303EmpDiaHsPExt[0] ;
         A1556EmpGuarEdadMin = BC004555_A1556EmpGuarEdadMin[0] ;
         A1557EmpGuarEdadMax = BC004555_A1557EmpGuarEdadMax[0] ;
         A1787EmpLiqGan = BC004555_A1787EmpLiqGan[0] ;
         A1792EmpTipoExp = BC004555_A1792EmpTipoExp[0] ;
         A1802EmpPromDesde = BC004555_A1802EmpPromDesde[0] ;
         A1813EmpFracVacAnt = BC004555_A1813EmpFracVacAnt[0] ;
         A2259EmpVacExpLim = BC004555_A2259EmpVacExpLim[0] ;
         A2260EmpVacExpTie = BC004555_A2260EmpVacExpTie[0] ;
         A2261EmpVacDisMax = BC004555_A2261EmpVacDisMax[0] ;
         A2405EmpModTra = BC004555_A2405EmpModTra[0] ;
         A2406EmpModEmpl = BC004555_A2406EmpModEmpl[0] ;
         A2407EmpModAuto = BC004555_A2407EmpModAuto[0] ;
         A957EmpLogoExt = BC004555_A957EmpLogoExt[0] ;
         n957EmpLogoExt = BC004555_n957EmpLogoExt[0] ;
         A955EmpLogo_Filetype = A957EmpLogoExt ;
         A960EmpFirmaExt = BC004555_A960EmpFirmaExt[0] ;
         n960EmpFirmaExt = BC004555_n960EmpFirmaExt[0] ;
         A958EmpFirma_Filetype = A960EmpFirmaExt ;
         A956EmpLogoNom = BC004555_A956EmpLogoNom[0] ;
         n956EmpLogoNom = BC004555_n956EmpLogoNom[0] ;
         A955EmpLogo_Filename = A956EmpLogoNom ;
         A959EmpFirmaNom = BC004555_A959EmpFirmaNom[0] ;
         n959EmpFirmaNom = BC004555_n959EmpFirmaNom[0] ;
         A958EmpFirma_Filename = A959EmpFirmaNom ;
         A46PaiCod = BC004555_A46PaiCod[0] ;
         n46PaiCod = BC004555_n46PaiCod[0] ;
         A47ProvCod = BC004555_A47ProvCod[0] ;
         n47ProvCod = BC004555_n47ProvCod[0] ;
         A48LocCod = BC004555_A48LocCod[0] ;
         n48LocCod = BC004555_n48LocCod[0] ;
         A3CliCod = BC004555_A3CliCod[0] ;
         A43ActCodigo = BC004555_A43ActCodigo[0] ;
         n43ActCodigo = BC004555_n43ActCodigo[0] ;
         A45TipEmpleCod = BC004555_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC004555_n45TipEmpleCod[0] ;
         A1151ARTSec = BC004555_A1151ARTSec[0] ;
         A903ActComCodigo = BC004555_A903ActComCodigo[0] ;
         A1965EmpOsoCod = BC004555_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC004555_n1965EmpOsoCod[0] ;
         A1533EmpActComercial = BC004555_A1533EmpActComercial[0] ;
         A44EmpZonCod = BC004555_A44EmpZonCod[0] ;
         n44EmpZonCod = BC004555_n44EmpZonCod[0] ;
         A2265EmpCondiCod = BC004555_A2265EmpCondiCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load4513( ) ;
         if ( AnyError == 1 )
         {
            RcdFound13 = (short)(0) ;
            initializeNonKey4513( ) ;
         }
         Gx_mode = sMode13 ;
      }
      else
      {
         RcdFound13 = (short)(0) ;
         initializeNonKey4513( ) ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode13 ;
      }
      pr_default.close(53);
   }

   public void getEqualNoModal( )
   {
      getKey4513( ) ;
      if ( RcdFound13 == 0 )
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
      confirm_450( ) ;
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

   public void checkOptimisticConcurrency4513( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC004556 */
         pr_default.execute(54, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(54) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresa"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(54) == 101) || ( GXutil.strcmp(Z2EmpNom, BC004556_A2EmpNom[0]) != 0 ) || ( Z177EmpCUIT != BC004556_A177EmpCUIT[0] ) || ( GXutil.strcmp(Z178EmpDir, BC004556_A178EmpDir[0]) != 0 ) || ( GXutil.strcmp(Z180EmpTel, BC004556_A180EmpTel[0]) != 0 ) || ( GXutil.strcmp(Z176EmpCP, BC004556_A176EmpCP[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1811EmpPerVacDes != BC004556_A1811EmpPerVacDes[0] ) || ( Z1812EmpPerVacHas != BC004556_A1812EmpPerVacHas[0] ) || ( Z532EmpReducc != BC004556_A532EmpReducc[0] ) || ( DecimalUtil.compareTo(Z1140EmpAntiguedad, BC004556_A1140EmpAntiguedad[0]) != 0 ) || ( DecimalUtil.compareTo(Z1141EmpPresentismo, BC004556_A1141EmpPresentismo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1302EmpMesHsPExt, BC004556_A1302EmpMesHsPExt[0]) != 0 ) || ( Z1524EmpLiqFer != BC004556_A1524EmpLiqFer[0] ) || ( Z1750EmpLiqFerJor != BC004556_A1750EmpLiqFerJor[0] ) || ( GXutil.strcmp(Z1303EmpDiaHsPExt, BC004556_A1303EmpDiaHsPExt[0]) != 0 ) || ( Z1556EmpGuarEdadMin != BC004556_A1556EmpGuarEdadMin[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1557EmpGuarEdadMax != BC004556_A1557EmpGuarEdadMax[0] ) || ( Z1787EmpLiqGan != BC004556_A1787EmpLiqGan[0] ) || ( Z1792EmpTipoExp != BC004556_A1792EmpTipoExp[0] ) || ( GXutil.strcmp(Z1802EmpPromDesde, BC004556_A1802EmpPromDesde[0]) != 0 ) || ( DecimalUtil.compareTo(Z1813EmpFracVacAnt, BC004556_A1813EmpFracVacAnt[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2259EmpVacExpLim != BC004556_A2259EmpVacExpLim[0] ) || ( Z2260EmpVacExpTie != BC004556_A2260EmpVacExpTie[0] ) || ( Z2261EmpVacDisMax != BC004556_A2261EmpVacDisMax[0] ) || ( GXutil.strcmp(Z2405EmpModTra, BC004556_A2405EmpModTra[0]) != 0 ) || ( Z2406EmpModEmpl != BC004556_A2406EmpModEmpl[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2407EmpModAuto != BC004556_A2407EmpModAuto[0] ) || ( Z46PaiCod != BC004556_A46PaiCod[0] ) || ( Z47ProvCod != BC004556_A47ProvCod[0] ) || ( Z48LocCod != BC004556_A48LocCod[0] ) || ( GXutil.strcmp(Z43ActCodigo, BC004556_A43ActCodigo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z45TipEmpleCod, BC004556_A45TipEmpleCod[0]) != 0 ) || ( Z1151ARTSec != BC004556_A1151ARTSec[0] ) || ( GXutil.strcmp(Z903ActComCodigo, BC004556_A903ActComCodigo[0]) != 0 ) || ( GXutil.strcmp(Z1965EmpOsoCod, BC004556_A1965EmpOsoCod[0]) != 0 ) || ( GXutil.strcmp(Z1533EmpActComercial, BC004556_A1533EmpActComercial[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z44EmpZonCod, BC004556_A44EmpZonCod[0]) != 0 ) || ( Z2265EmpCondiCod != BC004556_A2265EmpCondiCod[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresa"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4513( )
   {
      beforeValidate4513( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4513( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4513( 0) ;
         checkOptimisticConcurrency4513( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4513( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4513( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC004557 */
                  pr_default.execute(55, new Object[] {Short.valueOf(A1EmpCod), A2EmpNom, Long.valueOf(A177EmpCUIT), A178EmpDir, Boolean.valueOf(n180EmpTel), A180EmpTel, Boolean.valueOf(n176EmpCP), A176EmpCP, Byte.valueOf(A1811EmpPerVacDes), Byte.valueOf(A1812EmpPerVacHas), Boolean.valueOf(A532EmpReducc), Boolean.valueOf(n955EmpLogo), A955EmpLogo, Boolean.valueOf(n958EmpFirma), A958EmpFirma, A1140EmpAntiguedad, A1141EmpPresentismo, Boolean.valueOf(n1302EmpMesHsPExt), A1302EmpMesHsPExt, Boolean.valueOf(A1524EmpLiqFer), Boolean.valueOf(A1750EmpLiqFerJor), Boolean.valueOf(n1303EmpDiaHsPExt), A1303EmpDiaHsPExt, Byte.valueOf(A1556EmpGuarEdadMin), Byte.valueOf(A1557EmpGuarEdadMax), Boolean.valueOf(A1787EmpLiqGan), Byte.valueOf(A1792EmpTipoExp), A1802EmpPromDesde, A1813EmpFracVacAnt, Boolean.valueOf(A2259EmpVacExpLim), Byte.valueOf(A2260EmpVacExpTie), Integer.valueOf(A2261EmpVacDisMax), A2405EmpModTra, Boolean.valueOf(A2406EmpModEmpl), Boolean.valueOf(A2407EmpModAuto), Boolean.valueOf(n957EmpLogoExt), A957EmpLogoExt, Boolean.valueOf(n960EmpFirmaExt), A960EmpFirmaExt, Boolean.valueOf(n956EmpLogoNom), A956EmpLogoNom, Boolean.valueOf(n959EmpFirmaNom), A959EmpFirmaNom, Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod), Integer.valueOf(A3CliCod), Boolean.valueOf(n43ActCodigo), A43ActCodigo, Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod, Short.valueOf(A1151ARTSec), A903ActComCodigo, Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod, A1533EmpActComercial, Boolean.valueOf(n44EmpZonCod), A44EmpZonCod, Short.valueOf(A2265EmpCondiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
                  if ( (pr_default.getStatus(55) == 1) )
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
                        processLevel4513( ) ;
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
            load4513( ) ;
         }
         endLevel4513( ) ;
      }
      closeExtendedTableCursors4513( ) ;
   }

   public void update4513( )
   {
      beforeValidate4513( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4513( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4513( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4513( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4513( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC004558 */
                  pr_default.execute(56, new Object[] {A2EmpNom, Long.valueOf(A177EmpCUIT), A178EmpDir, Boolean.valueOf(n180EmpTel), A180EmpTel, Boolean.valueOf(n176EmpCP), A176EmpCP, Byte.valueOf(A1811EmpPerVacDes), Byte.valueOf(A1812EmpPerVacHas), Boolean.valueOf(A532EmpReducc), A1140EmpAntiguedad, A1141EmpPresentismo, Boolean.valueOf(n1302EmpMesHsPExt), A1302EmpMesHsPExt, Boolean.valueOf(A1524EmpLiqFer), Boolean.valueOf(A1750EmpLiqFerJor), Boolean.valueOf(n1303EmpDiaHsPExt), A1303EmpDiaHsPExt, Byte.valueOf(A1556EmpGuarEdadMin), Byte.valueOf(A1557EmpGuarEdadMax), Boolean.valueOf(A1787EmpLiqGan), Byte.valueOf(A1792EmpTipoExp), A1802EmpPromDesde, A1813EmpFracVacAnt, Boolean.valueOf(A2259EmpVacExpLim), Byte.valueOf(A2260EmpVacExpTie), Integer.valueOf(A2261EmpVacDisMax), A2405EmpModTra, Boolean.valueOf(A2406EmpModEmpl), Boolean.valueOf(A2407EmpModAuto), Boolean.valueOf(n957EmpLogoExt), A957EmpLogoExt, Boolean.valueOf(n960EmpFirmaExt), A960EmpFirmaExt, Boolean.valueOf(n956EmpLogoNom), A956EmpLogoNom, Boolean.valueOf(n959EmpFirmaNom), A959EmpFirmaNom, Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod), Boolean.valueOf(n43ActCodigo), A43ActCodigo, Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod, Short.valueOf(A1151ARTSec), A903ActComCodigo, Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod, A1533EmpActComercial, Boolean.valueOf(n44EmpZonCod), A44EmpZonCod, Short.valueOf(A2265EmpCondiCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
                  if ( (pr_default.getStatus(56) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresa"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4513( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel4513( ) ;
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
         endLevel4513( ) ;
      }
      closeExtendedTableCursors4513( ) ;
   }

   public void deferredUpdate4513( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC004559 */
         pr_default.execute(57, new Object[] {Boolean.valueOf(n955EmpLogo), A955EmpLogo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC004560 */
         pr_default.execute(58, new Object[] {Boolean.valueOf(n958EmpFirma), A958EmpFirma, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate4513( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4513( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4513( ) ;
         afterConfirm4513( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4513( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart45191( ) ;
               while ( RcdFound191 != 0 )
               {
                  getByPrimaryKey45191( ) ;
                  delete45191( ) ;
                  scanKeyNext45191( ) ;
               }
               scanKeyEnd45191( ) ;
               scanKeyStart45173( ) ;
               while ( RcdFound173 != 0 )
               {
                  getByPrimaryKey45173( ) ;
                  delete45173( ) ;
                  scanKeyNext45173( ) ;
               }
               scanKeyEnd45173( ) ;
               scanKeyStart45172( ) ;
               while ( RcdFound172 != 0 )
               {
                  getByPrimaryKey45172( ) ;
                  delete45172( ) ;
                  scanKeyNext45172( ) ;
               }
               scanKeyEnd45172( ) ;
               scanKeyStart45171( ) ;
               while ( RcdFound171 != 0 )
               {
                  getByPrimaryKey45171( ) ;
                  delete45171( ) ;
                  scanKeyNext45171( ) ;
               }
               scanKeyEnd45171( ) ;
               scanKeyStart45165( ) ;
               while ( RcdFound165 != 0 )
               {
                  getByPrimaryKey45165( ) ;
                  delete45165( ) ;
                  scanKeyNext45165( ) ;
               }
               scanKeyEnd45165( ) ;
               scanKeyStart45146( ) ;
               while ( RcdFound146 != 0 )
               {
                  getByPrimaryKey45146( ) ;
                  delete45146( ) ;
                  scanKeyNext45146( ) ;
               }
               scanKeyEnd45146( ) ;
               scanKeyStart45145( ) ;
               while ( RcdFound145 != 0 )
               {
                  getByPrimaryKey45145( ) ;
                  delete45145( ) ;
                  scanKeyNext45145( ) ;
               }
               scanKeyEnd45145( ) ;
               scanKeyStart45144( ) ;
               while ( RcdFound144 != 0 )
               {
                  getByPrimaryKey45144( ) ;
                  delete45144( ) ;
                  scanKeyNext45144( ) ;
               }
               scanKeyEnd45144( ) ;
               scanKeyStart45166( ) ;
               while ( RcdFound166 != 0 )
               {
                  getByPrimaryKey45166( ) ;
                  delete45166( ) ;
                  scanKeyNext45166( ) ;
               }
               scanKeyEnd45166( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC004561 */
                  pr_default.execute(59, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
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
      sMode13 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel4513( ) ;
      Gx_mode = sMode13 ;
   }

   public void onDeleteControls4513( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV71Pgmname = "Empresa_abm_1_BC" ;
         /* Using cursor BC004562 */
         pr_default.execute(60, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
         A312PaiNom = BC004562_A312PaiNom[0] ;
         pr_default.close(60);
         /* Using cursor BC004563 */
         pr_default.execute(61, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
         A322ProvNom = BC004563_A322ProvNom[0] ;
         pr_default.close(61);
         /* Using cursor BC004564 */
         pr_default.execute(62, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
         A286LocNom = BC004564_A286LocNom[0] ;
         pr_default.close(62);
         /* Using cursor BC004565 */
         pr_default.execute(63, new Object[] {Boolean.valueOf(n43ActCodigo), A43ActCodigo});
         A683ActDescripSinAc = BC004565_A683ActDescripSinAc[0] ;
         A108ActDescrip = BC004565_A108ActDescrip[0] ;
         pr_default.close(63);
         /* Using cursor BC004566 */
         pr_default.execute(64, new Object[] {Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod});
         A530TipEmpleDefIns = BC004566_A530TipEmpleDefIns[0] ;
         pr_default.close(64);
         /* Using cursor BC004567 */
         pr_default.execute(65, new Object[] {Boolean.valueOf(n44EmpZonCod), A44EmpZonCod});
         A518EmpZonDescrip = BC004567_A518EmpZonDescrip[0] ;
         pr_default.close(65);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC004568 */
         pr_default.execute(66, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(66) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "banda_salarial", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(66);
         /* Using cursor BC004569 */
         pr_default.execute(67, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(67) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(67);
         /* Using cursor BC004570 */
         pr_default.execute(68, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(68) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionLotes3", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(68);
         /* Using cursor BC004571 */
         pr_default.execute(69, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(69) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(69);
         /* Using cursor BC004572 */
         pr_default.execute(70, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(70) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionLegajoLinkPdf", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(70);
         /* Using cursor BC004573 */
         pr_default.execute(71, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(71) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionSucursal", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(71);
         /* Using cursor BC004574 */
         pr_default.execute(72, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(72) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionArea", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(72);
         /* Using cursor BC004575 */
         pr_default.execute(73, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(73) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionConvenio", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(73);
         /* Using cursor BC004576 */
         pr_default.execute(74, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(74) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "EmpresaBancos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(74);
         /* Using cursor BC004577 */
         pr_default.execute(75, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(75) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Periodo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(75);
         /* Using cursor BC004578 */
         pr_default.execute(76, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(76) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LSD_reg1", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(76);
         /* Using cursor BC004579 */
         pr_default.execute(77, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(77) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(77);
         /* Using cursor BC004580 */
         pr_default.execute(78, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(78) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(78);
         /* Using cursor BC004581 */
         pr_default.execute(79, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(79) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(79);
         /* Using cursor BC004582 */
         pr_default.execute(80, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(80) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(80);
         /* Using cursor BC004583 */
         pr_default.execute(81, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(81) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(81);
         /* Using cursor BC004584 */
         pr_default.execute(82, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(82) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(82);
         /* Using cursor BC004585 */
         pr_default.execute(83, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(83) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(83);
         /* Using cursor BC004586 */
         pr_default.execute(84, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(84) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(84);
         /* Using cursor BC004587 */
         pr_default.execute(85, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(85) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(85);
         /* Using cursor BC004588 */
         pr_default.execute(86, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(86) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(86);
         /* Using cursor BC004589 */
         pr_default.execute(87, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(87) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(87);
         /* Using cursor BC004590 */
         pr_default.execute(88, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(88) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(88);
         /* Using cursor BC004591 */
         pr_default.execute(89, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(89) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(89);
         /* Using cursor BC004592 */
         pr_default.execute(90, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(90) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(90);
         /* Using cursor BC004593 */
         pr_default.execute(91, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(91) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(91);
         /* Using cursor BC004594 */
         pr_default.execute(92, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(92) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(92);
         /* Using cursor BC004595 */
         pr_default.execute(93, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(93) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(93);
         /* Using cursor BC004596 */
         pr_default.execute(94, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(94) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(94);
         /* Using cursor BC004597 */
         pr_default.execute(95, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(95) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(95);
         /* Using cursor BC004598 */
         pr_default.execute(96, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(96) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(96);
         /* Using cursor BC004599 */
         pr_default.execute(97, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(97) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(97);
         /* Using cursor BC0045100 */
         pr_default.execute(98, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(98) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(98);
         /* Using cursor BC0045101 */
         pr_default.execute(99, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(99) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(99);
         /* Using cursor BC0045102 */
         pr_default.execute(100, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(100) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(100);
         /* Using cursor BC0045103 */
         pr_default.execute(101, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(101) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(101);
         /* Using cursor BC0045104 */
         pr_default.execute(102, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(102) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(102);
         /* Using cursor BC0045105 */
         pr_default.execute(103, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(103) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(103);
         /* Using cursor BC0045106 */
         pr_default.execute(104, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(104) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(104);
         /* Using cursor BC0045107 */
         pr_default.execute(105, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(105) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(105);
         /* Using cursor BC0045108 */
         pr_default.execute(106, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(106) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(106);
         /* Using cursor BC0045109 */
         pr_default.execute(107, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(107) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(107);
         /* Using cursor BC0045110 */
         pr_default.execute(108, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(108) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(108);
         /* Using cursor BC0045111 */
         pr_default.execute(109, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(109) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(109);
         /* Using cursor BC0045112 */
         pr_default.execute(110, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(110) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(110);
         /* Using cursor BC0045113 */
         pr_default.execute(111, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(111) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(111);
         /* Using cursor BC0045114 */
         pr_default.execute(112, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(112) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(112);
         /* Using cursor BC0045115 */
         pr_default.execute(113, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(113) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(113);
         /* Using cursor BC0045116 */
         pr_default.execute(114, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(114) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(114);
         /* Using cursor BC0045117 */
         pr_default.execute(115, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(115) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(115);
         /* Using cursor BC0045118 */
         pr_default.execute(116, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(116) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(116);
         /* Using cursor BC0045119 */
         pr_default.execute(117, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(117) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(117);
         /* Using cursor BC0045120 */
         pr_default.execute(118, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(118) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(118);
         /* Using cursor BC0045121 */
         pr_default.execute(119, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(119) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(119);
         /* Using cursor BC0045122 */
         pr_default.execute(120, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(120) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(120);
         /* Using cursor BC0045123 */
         pr_default.execute(121, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(121) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(121);
         /* Using cursor BC0045124 */
         pr_default.execute(122, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(122) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(122);
         /* Using cursor BC0045125 */
         pr_default.execute(123, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(123) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(123);
         /* Using cursor BC0045126 */
         pr_default.execute(124, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(124) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(124);
         /* Using cursor BC0045127 */
         pr_default.execute(125, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(125) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(125);
         /* Using cursor BC0045128 */
         pr_default.execute(126, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(126) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(126);
         /* Using cursor BC0045129 */
         pr_default.execute(127, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(127) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(127);
         /* Using cursor BC0045130 */
         pr_default.execute(128, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(128) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(128);
         /* Using cursor BC0045131 */
         pr_default.execute(129, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(129) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(129);
         /* Using cursor BC0045132 */
         pr_default.execute(130, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(130) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(130);
         /* Using cursor BC0045133 */
         pr_default.execute(131, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(131) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(131);
         /* Using cursor BC0045134 */
         pr_default.execute(132, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(132) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(132);
         /* Using cursor BC0045135 */
         pr_default.execute(133, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(133) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Guarderias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(133);
         /* Using cursor BC0045136 */
         pr_default.execute(134, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(134) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "horasextras_pordia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(134);
         /* Using cursor BC0045137 */
         pr_default.execute(135, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(135) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Sucursal", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(135);
         /* Using cursor BC0045138 */
         pr_default.execute(136, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(136) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Formulario F1357", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(136);
         /* Using cursor BC0045139 */
         pr_default.execute(137, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(137) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "importacion_liquidaciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(137);
         /* Using cursor BC0045140 */
         pr_default.execute(138, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(138) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "importacion_legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(138);
         /* Using cursor BC0045141 */
         pr_default.execute(139, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(139) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Template Recibo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(139);
         /* Using cursor BC0045142 */
         pr_default.execute(140, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(140) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "archivo_siradig", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(140);
         /* Using cursor BC0045143 */
         pr_default.execute(141, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(141) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Asiento Cab", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(141);
         /* Using cursor BC0045144 */
         pr_default.execute(142, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(142) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cuenta Contable", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(142);
         /* Using cursor BC0045145 */
         pr_default.execute(143, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(143) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Centro De Costo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(143);
         /* Using cursor BC0045146 */
         pr_default.execute(144, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(144) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Lugar Pago", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(144);
         /* Using cursor BC0045147 */
         pr_default.execute(145, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(145) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(145);
      }
   }

   public void processNestedLevel45171( )
   {
      nGXsfl_171_idx = 0 ;
      while ( nGXsfl_171_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados().size() )
      {
         readRow45171( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound171 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_171 != 0 ) )
         {
            standaloneNotModal45171( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert45171( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete45171( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update45171( ) ;
               }
            }
         }
         KeyVarsToRow171( ((web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados().elementAt(-1+nGXsfl_171_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_171_idx = 0 ;
         while ( nGXsfl_171_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados().size() )
         {
            readRow45171( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound171 == 0 )
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
               bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados().removeElement(nGXsfl_171_idx);
               nGXsfl_171_idx = (int)(nGXsfl_171_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey45171( ) ;
               VarsToRow171( ((web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados().elementAt(-1+nGXsfl_171_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll45171( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_171 = (short)(0) ;
      nIsMod_171 = (short)(0) ;
      Gxremove171 = (byte)(0) ;
   }

   public void processNestedLevel45172( )
   {
      nGXsfl_172_idx = 0 ;
      while ( nGXsfl_172_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados().size() )
      {
         readRow45172( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound172 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_172 != 0 ) )
         {
            standaloneNotModal45172( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert45172( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete45172( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update45172( ) ;
               }
            }
         }
         KeyVarsToRow172( ((web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados().elementAt(-1+nGXsfl_172_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_172_idx = 0 ;
         while ( nGXsfl_172_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados().size() )
         {
            readRow45172( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound172 == 0 )
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
               bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados().removeElement(nGXsfl_172_idx);
               nGXsfl_172_idx = (int)(nGXsfl_172_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey45172( ) ;
               VarsToRow172( ((web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados().elementAt(-1+nGXsfl_172_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll45172( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_172 = (short)(0) ;
      nIsMod_172 = (short)(0) ;
      Gxremove172 = (byte)(0) ;
   }

   public void processNestedLevel45173( )
   {
      nGXsfl_173_idx = 0 ;
      while ( nGXsfl_173_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados().size() )
      {
         readRow45173( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound173 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_173 != 0 ) )
         {
            standaloneNotModal45173( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert45173( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete45173( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update45173( ) ;
               }
            }
         }
         KeyVarsToRow173( ((web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados().elementAt(-1+nGXsfl_173_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_173_idx = 0 ;
         while ( nGXsfl_173_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados().size() )
         {
            readRow45173( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound173 == 0 )
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
               bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados().removeElement(nGXsfl_173_idx);
               nGXsfl_173_idx = (int)(nGXsfl_173_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey45173( ) ;
               VarsToRow173( ((web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados().elementAt(-1+nGXsfl_173_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll45173( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_173 = (short)(0) ;
      nIsMod_173 = (short)(0) ;
      Gxremove173 = (byte)(0) ;
   }

   public void processNestedLevel45191( )
   {
      nGXsfl_191_idx = 0 ;
      while ( nGXsfl_191_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Base_calculo().size() )
      {
         readRow45191( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound191 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_191 != 0 ) )
         {
            standaloneNotModal45191( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert45191( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete45191( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update45191( ) ;
               }
            }
         }
         KeyVarsToRow191( ((web.SdtEmpresa_abm_1_base_calculo)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Base_calculo().elementAt(-1+nGXsfl_191_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_191_idx = 0 ;
         while ( nGXsfl_191_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Base_calculo().size() )
         {
            readRow45191( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound191 == 0 )
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
               bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Base_calculo().removeElement(nGXsfl_191_idx);
               nGXsfl_191_idx = (int)(nGXsfl_191_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey45191( ) ;
               VarsToRow191( ((web.SdtEmpresa_abm_1_base_calculo)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Base_calculo().elementAt(-1+nGXsfl_191_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll45191( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_191 = (short)(0) ;
      nIsMod_191 = (short)(0) ;
      Gxremove191 = (byte)(0) ;
   }

   public void processNestedLevel45165( )
   {
      nGXsfl_165_idx = 0 ;
      while ( nGXsfl_165_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Horasextras_pordia().size() )
      {
         readRow45165( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound165 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_165 != 0 ) )
         {
            standaloneNotModal45165( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert45165( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete45165( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update45165( ) ;
               }
            }
         }
         KeyVarsToRow165( ((web.SdtEmpresa_abm_1_horasextras_pordia)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Horasextras_pordia().elementAt(-1+nGXsfl_165_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_165_idx = 0 ;
         while ( nGXsfl_165_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Horasextras_pordia().size() )
         {
            readRow45165( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound165 == 0 )
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
               bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Horasextras_pordia().removeElement(nGXsfl_165_idx);
               nGXsfl_165_idx = (int)(nGXsfl_165_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey45165( ) ;
               VarsToRow165( ((web.SdtEmpresa_abm_1_horasextras_pordia)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Horasextras_pordia().elementAt(-1+nGXsfl_165_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll45165( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_165 = (short)(0) ;
      nIsMod_165 = (short)(0) ;
      Gxremove165 = (byte)(0) ;
   }

   public void processNestedLevel45166( )
   {
      nGXsfl_166_idx = 0 ;
      while ( nGXsfl_166_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipo_trabajo().size() )
      {
         readRow45166( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound166 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_166 != 0 ) )
         {
            standaloneNotModal45166( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert45166( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete45166( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update45166( ) ;
               }
            }
         }
         KeyVarsToRow166( ((web.SdtEmpresa_abm_1_tipo_trabajo)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipo_trabajo().elementAt(-1+nGXsfl_166_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_166_idx = 0 ;
         while ( nGXsfl_166_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipo_trabajo().size() )
         {
            readRow45166( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound166 == 0 )
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
               bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipo_trabajo().removeElement(nGXsfl_166_idx);
               nGXsfl_166_idx = (int)(nGXsfl_166_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey45166( ) ;
               VarsToRow166( ((web.SdtEmpresa_abm_1_tipo_trabajo)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipo_trabajo().elementAt(-1+nGXsfl_166_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll45166( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_166 = (short)(0) ;
      nIsMod_166 = (short)(0) ;
      Gxremove166 = (byte)(0) ;
   }

   public void processNestedLevel45144( )
   {
      nGXsfl_144_idx = 0 ;
      while ( nGXsfl_144_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio().size() )
      {
         readRow45144( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound144 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_144 != 0 ) )
         {
            standaloneNotModal45144( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert45144( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete45144( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update45144( ) ;
               }
            }
         }
         KeyVarsToRow144( ((web.SdtEmpresa_abm_1_nolaborables_convenio)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio().elementAt(-1+nGXsfl_144_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_144_idx = 0 ;
         while ( nGXsfl_144_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio().size() )
         {
            readRow45144( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound144 == 0 )
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
               bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio().removeElement(nGXsfl_144_idx);
               nGXsfl_144_idx = (int)(nGXsfl_144_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey45144( ) ;
               VarsToRow144( ((web.SdtEmpresa_abm_1_nolaborables_convenio)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio().elementAt(-1+nGXsfl_144_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll45144( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_144 = (short)(0) ;
      nIsMod_144 = (short)(0) ;
      Gxremove144 = (byte)(0) ;
   }

   public void processNestedLevel45145( )
   {
      nGXsfl_145_idx = 0 ;
      while ( nGXsfl_145_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_origen().size() )
      {
         readRow45145( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound145 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_145 != 0 ) )
         {
            standaloneNotModal45145( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert45145( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete45145( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update45145( ) ;
               }
            }
         }
         KeyVarsToRow145( ((web.SdtEmpresa_abm_1_nolaborables_origen)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_origen().elementAt(-1+nGXsfl_145_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_145_idx = 0 ;
         while ( nGXsfl_145_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_origen().size() )
         {
            readRow45145( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound145 == 0 )
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
               bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_origen().removeElement(nGXsfl_145_idx);
               nGXsfl_145_idx = (int)(nGXsfl_145_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey45145( ) ;
               VarsToRow145( ((web.SdtEmpresa_abm_1_nolaborables_origen)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_origen().elementAt(-1+nGXsfl_145_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll45145( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_145 = (short)(0) ;
      nIsMod_145 = (short)(0) ;
      Gxremove145 = (byte)(0) ;
   }

   public void processNestedLevel45146( )
   {
      nGXsfl_146_idx = 0 ;
      while ( nGXsfl_146_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_religion().size() )
      {
         readRow45146( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound146 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_146 != 0 ) )
         {
            standaloneNotModal45146( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert45146( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete45146( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update45146( ) ;
               }
            }
         }
         KeyVarsToRow146( ((web.SdtEmpresa_abm_1_nolaborables_religion)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_religion().elementAt(-1+nGXsfl_146_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_146_idx = 0 ;
         while ( nGXsfl_146_idx < bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_religion().size() )
         {
            readRow45146( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound146 == 0 )
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
               bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_religion().removeElement(nGXsfl_146_idx);
               nGXsfl_146_idx = (int)(nGXsfl_146_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey45146( ) ;
               VarsToRow146( ((web.SdtEmpresa_abm_1_nolaborables_religion)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_religion().elementAt(-1+nGXsfl_146_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll45146( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_146 = (short)(0) ;
      nIsMod_146 = (short)(0) ;
      Gxremove146 = (byte)(0) ;
   }

   public void processLevel4513( )
   {
      /* Save parent mode. */
      sMode13 = Gx_mode ;
      processNestedLevel45171( ) ;
      processNestedLevel45172( ) ;
      processNestedLevel45173( ) ;
      processNestedLevel45191( ) ;
      processNestedLevel45165( ) ;
      processNestedLevel45166( ) ;
      processNestedLevel45144( ) ;
      processNestedLevel45145( ) ;
      processNestedLevel45146( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode13 ;
      /* ' Update level parameters */
   }

   public void endLevel4513( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(54);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4513( ) ;
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

   public void scanKeyStart4513( )
   {
      /* Scan By routine */
      /* Using cursor BC0045148 */
      pr_default.execute(146, new Object[] {Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod)});
      RcdFound13 = (short)(0) ;
      if ( (pr_default.getStatus(146) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A683ActDescripSinAc = BC0045148_A683ActDescripSinAc[0] ;
         A1EmpCod = BC0045148_A1EmpCod[0] ;
         A2EmpNom = BC0045148_A2EmpNom[0] ;
         A177EmpCUIT = BC0045148_A177EmpCUIT[0] ;
         A178EmpDir = BC0045148_A178EmpDir[0] ;
         A180EmpTel = BC0045148_A180EmpTel[0] ;
         n180EmpTel = BC0045148_n180EmpTel[0] ;
         A176EmpCP = BC0045148_A176EmpCP[0] ;
         n176EmpCP = BC0045148_n176EmpCP[0] ;
         A312PaiNom = BC0045148_A312PaiNom[0] ;
         A322ProvNom = BC0045148_A322ProvNom[0] ;
         A1811EmpPerVacDes = BC0045148_A1811EmpPerVacDes[0] ;
         A1812EmpPerVacHas = BC0045148_A1812EmpPerVacHas[0] ;
         A286LocNom = BC0045148_A286LocNom[0] ;
         A108ActDescrip = BC0045148_A108ActDescrip[0] ;
         A518EmpZonDescrip = BC0045148_A518EmpZonDescrip[0] ;
         A532EmpReducc = BC0045148_A532EmpReducc[0] ;
         A530TipEmpleDefIns = BC0045148_A530TipEmpleDefIns[0] ;
         A955EmpLogo = BC0045148_A955EmpLogo[0] ;
         n955EmpLogo = BC0045148_n955EmpLogo[0] ;
         A958EmpFirma = BC0045148_A958EmpFirma[0] ;
         n958EmpFirma = BC0045148_n958EmpFirma[0] ;
         A1140EmpAntiguedad = BC0045148_A1140EmpAntiguedad[0] ;
         A1141EmpPresentismo = BC0045148_A1141EmpPresentismo[0] ;
         A1302EmpMesHsPExt = BC0045148_A1302EmpMesHsPExt[0] ;
         n1302EmpMesHsPExt = BC0045148_n1302EmpMesHsPExt[0] ;
         A1524EmpLiqFer = BC0045148_A1524EmpLiqFer[0] ;
         A1750EmpLiqFerJor = BC0045148_A1750EmpLiqFerJor[0] ;
         A1303EmpDiaHsPExt = BC0045148_A1303EmpDiaHsPExt[0] ;
         n1303EmpDiaHsPExt = BC0045148_n1303EmpDiaHsPExt[0] ;
         A1556EmpGuarEdadMin = BC0045148_A1556EmpGuarEdadMin[0] ;
         A1557EmpGuarEdadMax = BC0045148_A1557EmpGuarEdadMax[0] ;
         A1787EmpLiqGan = BC0045148_A1787EmpLiqGan[0] ;
         A1792EmpTipoExp = BC0045148_A1792EmpTipoExp[0] ;
         A1802EmpPromDesde = BC0045148_A1802EmpPromDesde[0] ;
         A1813EmpFracVacAnt = BC0045148_A1813EmpFracVacAnt[0] ;
         A2259EmpVacExpLim = BC0045148_A2259EmpVacExpLim[0] ;
         A2260EmpVacExpTie = BC0045148_A2260EmpVacExpTie[0] ;
         A2261EmpVacDisMax = BC0045148_A2261EmpVacDisMax[0] ;
         A2405EmpModTra = BC0045148_A2405EmpModTra[0] ;
         A2406EmpModEmpl = BC0045148_A2406EmpModEmpl[0] ;
         A2407EmpModAuto = BC0045148_A2407EmpModAuto[0] ;
         A957EmpLogoExt = BC0045148_A957EmpLogoExt[0] ;
         n957EmpLogoExt = BC0045148_n957EmpLogoExt[0] ;
         A955EmpLogo_Filetype = A957EmpLogoExt ;
         A960EmpFirmaExt = BC0045148_A960EmpFirmaExt[0] ;
         n960EmpFirmaExt = BC0045148_n960EmpFirmaExt[0] ;
         A958EmpFirma_Filetype = A960EmpFirmaExt ;
         A956EmpLogoNom = BC0045148_A956EmpLogoNom[0] ;
         n956EmpLogoNom = BC0045148_n956EmpLogoNom[0] ;
         A955EmpLogo_Filename = A956EmpLogoNom ;
         A959EmpFirmaNom = BC0045148_A959EmpFirmaNom[0] ;
         n959EmpFirmaNom = BC0045148_n959EmpFirmaNom[0] ;
         A958EmpFirma_Filename = A959EmpFirmaNom ;
         A46PaiCod = BC0045148_A46PaiCod[0] ;
         n46PaiCod = BC0045148_n46PaiCod[0] ;
         A47ProvCod = BC0045148_A47ProvCod[0] ;
         n47ProvCod = BC0045148_n47ProvCod[0] ;
         A48LocCod = BC0045148_A48LocCod[0] ;
         n48LocCod = BC0045148_n48LocCod[0] ;
         A3CliCod = BC0045148_A3CliCod[0] ;
         A43ActCodigo = BC0045148_A43ActCodigo[0] ;
         n43ActCodigo = BC0045148_n43ActCodigo[0] ;
         A45TipEmpleCod = BC0045148_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC0045148_n45TipEmpleCod[0] ;
         A1151ARTSec = BC0045148_A1151ARTSec[0] ;
         A903ActComCodigo = BC0045148_A903ActComCodigo[0] ;
         A1965EmpOsoCod = BC0045148_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC0045148_n1965EmpOsoCod[0] ;
         A1533EmpActComercial = BC0045148_A1533EmpActComercial[0] ;
         A44EmpZonCod = BC0045148_A44EmpZonCod[0] ;
         n44EmpZonCod = BC0045148_n44EmpZonCod[0] ;
         A2265EmpCondiCod = BC0045148_A2265EmpCondiCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext4513( )
   {
      /* Scan next routine */
      pr_default.readNext(146);
      RcdFound13 = (short)(0) ;
      scanKeyLoad4513( ) ;
   }

   public void scanKeyLoad4513( )
   {
      sMode13 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(146) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A683ActDescripSinAc = BC0045148_A683ActDescripSinAc[0] ;
         A1EmpCod = BC0045148_A1EmpCod[0] ;
         A2EmpNom = BC0045148_A2EmpNom[0] ;
         A177EmpCUIT = BC0045148_A177EmpCUIT[0] ;
         A178EmpDir = BC0045148_A178EmpDir[0] ;
         A180EmpTel = BC0045148_A180EmpTel[0] ;
         n180EmpTel = BC0045148_n180EmpTel[0] ;
         A176EmpCP = BC0045148_A176EmpCP[0] ;
         n176EmpCP = BC0045148_n176EmpCP[0] ;
         A312PaiNom = BC0045148_A312PaiNom[0] ;
         A322ProvNom = BC0045148_A322ProvNom[0] ;
         A1811EmpPerVacDes = BC0045148_A1811EmpPerVacDes[0] ;
         A1812EmpPerVacHas = BC0045148_A1812EmpPerVacHas[0] ;
         A286LocNom = BC0045148_A286LocNom[0] ;
         A108ActDescrip = BC0045148_A108ActDescrip[0] ;
         A518EmpZonDescrip = BC0045148_A518EmpZonDescrip[0] ;
         A532EmpReducc = BC0045148_A532EmpReducc[0] ;
         A530TipEmpleDefIns = BC0045148_A530TipEmpleDefIns[0] ;
         A955EmpLogo = BC0045148_A955EmpLogo[0] ;
         n955EmpLogo = BC0045148_n955EmpLogo[0] ;
         A958EmpFirma = BC0045148_A958EmpFirma[0] ;
         n958EmpFirma = BC0045148_n958EmpFirma[0] ;
         A1140EmpAntiguedad = BC0045148_A1140EmpAntiguedad[0] ;
         A1141EmpPresentismo = BC0045148_A1141EmpPresentismo[0] ;
         A1302EmpMesHsPExt = BC0045148_A1302EmpMesHsPExt[0] ;
         n1302EmpMesHsPExt = BC0045148_n1302EmpMesHsPExt[0] ;
         A1524EmpLiqFer = BC0045148_A1524EmpLiqFer[0] ;
         A1750EmpLiqFerJor = BC0045148_A1750EmpLiqFerJor[0] ;
         A1303EmpDiaHsPExt = BC0045148_A1303EmpDiaHsPExt[0] ;
         n1303EmpDiaHsPExt = BC0045148_n1303EmpDiaHsPExt[0] ;
         A1556EmpGuarEdadMin = BC0045148_A1556EmpGuarEdadMin[0] ;
         A1557EmpGuarEdadMax = BC0045148_A1557EmpGuarEdadMax[0] ;
         A1787EmpLiqGan = BC0045148_A1787EmpLiqGan[0] ;
         A1792EmpTipoExp = BC0045148_A1792EmpTipoExp[0] ;
         A1802EmpPromDesde = BC0045148_A1802EmpPromDesde[0] ;
         A1813EmpFracVacAnt = BC0045148_A1813EmpFracVacAnt[0] ;
         A2259EmpVacExpLim = BC0045148_A2259EmpVacExpLim[0] ;
         A2260EmpVacExpTie = BC0045148_A2260EmpVacExpTie[0] ;
         A2261EmpVacDisMax = BC0045148_A2261EmpVacDisMax[0] ;
         A2405EmpModTra = BC0045148_A2405EmpModTra[0] ;
         A2406EmpModEmpl = BC0045148_A2406EmpModEmpl[0] ;
         A2407EmpModAuto = BC0045148_A2407EmpModAuto[0] ;
         A957EmpLogoExt = BC0045148_A957EmpLogoExt[0] ;
         n957EmpLogoExt = BC0045148_n957EmpLogoExt[0] ;
         A955EmpLogo_Filetype = A957EmpLogoExt ;
         A960EmpFirmaExt = BC0045148_A960EmpFirmaExt[0] ;
         n960EmpFirmaExt = BC0045148_n960EmpFirmaExt[0] ;
         A958EmpFirma_Filetype = A960EmpFirmaExt ;
         A956EmpLogoNom = BC0045148_A956EmpLogoNom[0] ;
         n956EmpLogoNom = BC0045148_n956EmpLogoNom[0] ;
         A955EmpLogo_Filename = A956EmpLogoNom ;
         A959EmpFirmaNom = BC0045148_A959EmpFirmaNom[0] ;
         n959EmpFirmaNom = BC0045148_n959EmpFirmaNom[0] ;
         A958EmpFirma_Filename = A959EmpFirmaNom ;
         A46PaiCod = BC0045148_A46PaiCod[0] ;
         n46PaiCod = BC0045148_n46PaiCod[0] ;
         A47ProvCod = BC0045148_A47ProvCod[0] ;
         n47ProvCod = BC0045148_n47ProvCod[0] ;
         A48LocCod = BC0045148_A48LocCod[0] ;
         n48LocCod = BC0045148_n48LocCod[0] ;
         A3CliCod = BC0045148_A3CliCod[0] ;
         A43ActCodigo = BC0045148_A43ActCodigo[0] ;
         n43ActCodigo = BC0045148_n43ActCodigo[0] ;
         A45TipEmpleCod = BC0045148_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC0045148_n45TipEmpleCod[0] ;
         A1151ARTSec = BC0045148_A1151ARTSec[0] ;
         A903ActComCodigo = BC0045148_A903ActComCodigo[0] ;
         A1965EmpOsoCod = BC0045148_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC0045148_n1965EmpOsoCod[0] ;
         A1533EmpActComercial = BC0045148_A1533EmpActComercial[0] ;
         A44EmpZonCod = BC0045148_A44EmpZonCod[0] ;
         n44EmpZonCod = BC0045148_n44EmpZonCod[0] ;
         A2265EmpCondiCod = BC0045148_A2265EmpCondiCod[0] ;
      }
      Gx_mode = sMode13 ;
   }

   public void scanKeyEnd4513( )
   {
      pr_default.close(146);
   }

   public void afterConfirm4513( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert4513( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4513( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4513( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4513( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4513( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4513( )
   {
   }

   public void zm45171( int GX_JID )
   {
      if ( ( GX_JID == 29 ) || ( GX_JID == 0 ) )
      {
         Z1370EmpMenHabitual = A1370EmpMenHabitual ;
      }
      if ( ( GX_JID == 30 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -29 )
      {
         Z1370EmpMenHabitual = A1370EmpMenHabitual ;
         Z3CliCod = A3CliCod ;
         Z1368EmpMenConCodigo = A1368EmpMenConCodigo ;
         Z1EmpCod = A1EmpCod ;
      }
   }

   public void standaloneNotModal45171( )
   {
   }

   public void standaloneModal45171( )
   {
   }

   public void load45171( )
   {
      /* Using cursor BC0045149 */
      pr_default.execute(147, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1368EmpMenConCodigo});
      if ( (pr_default.getStatus(147) != 101) )
      {
         RcdFound171 = (short)(1) ;
         A1370EmpMenHabitual = BC0045149_A1370EmpMenHabitual[0] ;
         zm45171( -29) ;
      }
      pr_default.close(147);
      onLoadActions45171( ) ;
   }

   public void onLoadActions45171( )
   {
   }

   public void checkExtendedTable45171( )
   {
      nIsDirty_171 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal45171( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC0045150 */
      pr_default.execute(148, new Object[] {Integer.valueOf(A3CliCod), A1368EmpMenConCodigo});
      if ( (pr_default.getStatus(148) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPMENCONCODIGO");
         AnyError = (short)(1) ;
      }
      pr_default.close(148);
   }

   public void closeExtendedTableCursors45171( )
   {
      pr_default.close(148);
   }

   public void enableDisable45171( )
   {
   }

   public void getKey45171( )
   {
      /* Using cursor BC0045151 */
      pr_default.execute(149, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1368EmpMenConCodigo});
      if ( (pr_default.getStatus(149) != 101) )
      {
         RcdFound171 = (short)(1) ;
      }
      else
      {
         RcdFound171 = (short)(0) ;
      }
      pr_default.close(149);
   }

   public void getByPrimaryKey45171( )
   {
      /* Using cursor BC0045152 */
      pr_default.execute(150, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1368EmpMenConCodigo});
      if ( (pr_default.getStatus(150) != 101) )
      {
         zm45171( 29) ;
         RcdFound171 = (short)(1) ;
         initializeNonKey45171( ) ;
         A1370EmpMenHabitual = BC0045152_A1370EmpMenHabitual[0] ;
         A1368EmpMenConCodigo = BC0045152_A1368EmpMenConCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1368EmpMenConCodigo = A1368EmpMenConCodigo ;
         sMode171 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45171( ) ;
         load45171( ) ;
         Gx_mode = sMode171 ;
      }
      else
      {
         RcdFound171 = (short)(0) ;
         initializeNonKey45171( ) ;
         sMode171 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45171( ) ;
         Gx_mode = sMode171 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes45171( ) ;
      }
      pr_default.close(150);
   }

   public void checkOptimisticConcurrency45171( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0045153 */
         pr_default.execute(151, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1368EmpMenConCodigo});
         if ( (pr_default.getStatus(151) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresaconceptos_horanormal_mensualizado"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(151) == 101) || ( Z1370EmpMenHabitual != BC0045153_A1370EmpMenHabitual[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresaconceptos_horanormal_mensualizado"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert45171( )
   {
      beforeValidate45171( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45171( ) ;
      }
      if ( AnyError == 0 )
      {
         zm45171( 0) ;
         checkOptimisticConcurrency45171( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45171( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert45171( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045154 */
                  pr_default.execute(152, new Object[] {Boolean.valueOf(A1370EmpMenHabitual), Integer.valueOf(A3CliCod), A1368EmpMenConCodigo, Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresaconceptos_horanormal_mensualizado");
                  if ( (pr_default.getStatus(152) == 1) )
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
            load45171( ) ;
         }
         endLevel45171( ) ;
      }
      closeExtendedTableCursors45171( ) ;
   }

   public void update45171( )
   {
      beforeValidate45171( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45171( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45171( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45171( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate45171( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045155 */
                  pr_default.execute(153, new Object[] {Boolean.valueOf(A1370EmpMenHabitual), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1368EmpMenConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresaconceptos_horanormal_mensualizado");
                  if ( (pr_default.getStatus(153) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresaconceptos_horanormal_mensualizado"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate45171( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey45171( ) ;
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
         endLevel45171( ) ;
      }
      closeExtendedTableCursors45171( ) ;
   }

   public void deferredUpdate45171( )
   {
   }

   public void delete45171( )
   {
      Gx_mode = "DLT" ;
      beforeValidate45171( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45171( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls45171( ) ;
         afterConfirm45171( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete45171( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0045156 */
               pr_default.execute(154, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1368EmpMenConCodigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresaconceptos_horanormal_mensualizado");
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
      sMode171 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel45171( ) ;
      Gx_mode = sMode171 ;
   }

   public void onDeleteControls45171( )
   {
      standaloneModal45171( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel45171( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(151);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart45171( )
   {
      /* Scan By routine */
      /* Using cursor BC0045157 */
      pr_default.execute(155, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound171 = (short)(0) ;
      if ( (pr_default.getStatus(155) != 101) )
      {
         RcdFound171 = (short)(1) ;
         A1370EmpMenHabitual = BC0045157_A1370EmpMenHabitual[0] ;
         A1368EmpMenConCodigo = BC0045157_A1368EmpMenConCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext45171( )
   {
      /* Scan next routine */
      pr_default.readNext(155);
      RcdFound171 = (short)(0) ;
      scanKeyLoad45171( ) ;
   }

   public void scanKeyLoad45171( )
   {
      sMode171 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(155) != 101) )
      {
         RcdFound171 = (short)(1) ;
         A1370EmpMenHabitual = BC0045157_A1370EmpMenHabitual[0] ;
         A1368EmpMenConCodigo = BC0045157_A1368EmpMenConCodigo[0] ;
      }
      Gx_mode = sMode171 ;
   }

   public void scanKeyEnd45171( )
   {
      pr_default.close(155);
   }

   public void afterConfirm45171( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert45171( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate45171( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete45171( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete45171( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate45171( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes45171( )
   {
   }

   public void send_integrity_lvl_hashes45171( )
   {
   }

   public void zm45172( int GX_JID )
   {
      if ( ( GX_JID == 31 ) || ( GX_JID == 0 ) )
      {
         Z1369EmpJorHabitual = A1369EmpJorHabitual ;
      }
      if ( ( GX_JID == 32 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -31 )
      {
         Z1369EmpJorHabitual = A1369EmpJorHabitual ;
         Z3CliCod = A3CliCod ;
         Z1366EmpJorConCodigo = A1366EmpJorConCodigo ;
         Z1EmpCod = A1EmpCod ;
      }
   }

   public void standaloneNotModal45172( )
   {
   }

   public void standaloneModal45172( )
   {
   }

   public void load45172( )
   {
      /* Using cursor BC0045158 */
      pr_default.execute(156, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1366EmpJorConCodigo});
      if ( (pr_default.getStatus(156) != 101) )
      {
         RcdFound172 = (short)(1) ;
         A1369EmpJorHabitual = BC0045158_A1369EmpJorHabitual[0] ;
         zm45172( -31) ;
      }
      pr_default.close(156);
      onLoadActions45172( ) ;
   }

   public void onLoadActions45172( )
   {
   }

   public void checkExtendedTable45172( )
   {
      nIsDirty_172 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal45172( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC0045159 */
      pr_default.execute(157, new Object[] {Integer.valueOf(A3CliCod), A1366EmpJorConCodigo});
      if ( (pr_default.getStatus(157) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPJORCONCODIGO");
         AnyError = (short)(1) ;
      }
      pr_default.close(157);
   }

   public void closeExtendedTableCursors45172( )
   {
      pr_default.close(157);
   }

   public void enableDisable45172( )
   {
   }

   public void getKey45172( )
   {
      /* Using cursor BC0045160 */
      pr_default.execute(158, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1366EmpJorConCodigo});
      if ( (pr_default.getStatus(158) != 101) )
      {
         RcdFound172 = (short)(1) ;
      }
      else
      {
         RcdFound172 = (short)(0) ;
      }
      pr_default.close(158);
   }

   public void getByPrimaryKey45172( )
   {
      /* Using cursor BC0045161 */
      pr_default.execute(159, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1366EmpJorConCodigo});
      if ( (pr_default.getStatus(159) != 101) )
      {
         zm45172( 31) ;
         RcdFound172 = (short)(1) ;
         initializeNonKey45172( ) ;
         A1369EmpJorHabitual = BC0045161_A1369EmpJorHabitual[0] ;
         A1366EmpJorConCodigo = BC0045161_A1366EmpJorConCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1366EmpJorConCodigo = A1366EmpJorConCodigo ;
         sMode172 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45172( ) ;
         load45172( ) ;
         Gx_mode = sMode172 ;
      }
      else
      {
         RcdFound172 = (short)(0) ;
         initializeNonKey45172( ) ;
         sMode172 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45172( ) ;
         Gx_mode = sMode172 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes45172( ) ;
      }
      pr_default.close(159);
   }

   public void checkOptimisticConcurrency45172( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0045162 */
         pr_default.execute(160, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1366EmpJorConCodigo});
         if ( (pr_default.getStatus(160) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresaconceptos_horanormal_jornalizados"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(160) == 101) || ( Z1369EmpJorHabitual != BC0045162_A1369EmpJorHabitual[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresaconceptos_horanormal_jornalizados"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert45172( )
   {
      beforeValidate45172( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45172( ) ;
      }
      if ( AnyError == 0 )
      {
         zm45172( 0) ;
         checkOptimisticConcurrency45172( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45172( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert45172( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045163 */
                  pr_default.execute(161, new Object[] {Boolean.valueOf(A1369EmpJorHabitual), Integer.valueOf(A3CliCod), A1366EmpJorConCodigo, Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresaconceptos_horanormal_jornalizados");
                  if ( (pr_default.getStatus(161) == 1) )
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
            load45172( ) ;
         }
         endLevel45172( ) ;
      }
      closeExtendedTableCursors45172( ) ;
   }

   public void update45172( )
   {
      beforeValidate45172( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45172( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45172( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45172( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate45172( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045164 */
                  pr_default.execute(162, new Object[] {Boolean.valueOf(A1369EmpJorHabitual), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1366EmpJorConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresaconceptos_horanormal_jornalizados");
                  if ( (pr_default.getStatus(162) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresaconceptos_horanormal_jornalizados"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate45172( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey45172( ) ;
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
         endLevel45172( ) ;
      }
      closeExtendedTableCursors45172( ) ;
   }

   public void deferredUpdate45172( )
   {
   }

   public void delete45172( )
   {
      Gx_mode = "DLT" ;
      beforeValidate45172( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45172( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls45172( ) ;
         afterConfirm45172( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete45172( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0045165 */
               pr_default.execute(163, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1366EmpJorConCodigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresaconceptos_horanormal_jornalizados");
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
      sMode172 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel45172( ) ;
      Gx_mode = sMode172 ;
   }

   public void onDeleteControls45172( )
   {
      standaloneModal45172( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel45172( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(160);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart45172( )
   {
      /* Scan By routine */
      /* Using cursor BC0045166 */
      pr_default.execute(164, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound172 = (short)(0) ;
      if ( (pr_default.getStatus(164) != 101) )
      {
         RcdFound172 = (short)(1) ;
         A1369EmpJorHabitual = BC0045166_A1369EmpJorHabitual[0] ;
         A1366EmpJorConCodigo = BC0045166_A1366EmpJorConCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext45172( )
   {
      /* Scan next routine */
      pr_default.readNext(164);
      RcdFound172 = (short)(0) ;
      scanKeyLoad45172( ) ;
   }

   public void scanKeyLoad45172( )
   {
      sMode172 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(164) != 101) )
      {
         RcdFound172 = (short)(1) ;
         A1369EmpJorHabitual = BC0045166_A1369EmpJorHabitual[0] ;
         A1366EmpJorConCodigo = BC0045166_A1366EmpJorConCodigo[0] ;
      }
      Gx_mode = sMode172 ;
   }

   public void scanKeyEnd45172( )
   {
      pr_default.close(164);
   }

   public void afterConfirm45172( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert45172( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate45172( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete45172( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete45172( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate45172( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes45172( )
   {
   }

   public void send_integrity_lvl_hashes45172( )
   {
   }

   public void zm45173( int GX_JID )
   {
      if ( ( GX_JID == 33 ) || ( GX_JID == 0 ) )
      {
         Z1372EmpPromHabitual = A1372EmpPromHabitual ;
      }
      if ( ( GX_JID == 34 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -33 )
      {
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1371EmpPromFijVar = A1371EmpPromFijVar ;
         Z1372EmpPromHabitual = A1372EmpPromHabitual ;
         Z37TipoConCod = A37TipoConCod ;
      }
   }

   public void standaloneNotModal45173( )
   {
   }

   public void standaloneModal45173( )
   {
   }

   public void load45173( )
   {
      /* Using cursor BC0045167 */
      pr_default.execute(165, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A37TipoConCod, A1371EmpPromFijVar});
      if ( (pr_default.getStatus(165) != 101) )
      {
         RcdFound173 = (short)(1) ;
         A1372EmpPromHabitual = BC0045167_A1372EmpPromHabitual[0] ;
         zm45173( -33) ;
      }
      pr_default.close(165);
      onLoadActions45173( ) ;
   }

   public void onLoadActions45173( )
   {
   }

   public void checkExtendedTable45173( )
   {
      nIsDirty_173 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal45173( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC0045168 */
      pr_default.execute(166, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(166) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo De Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(166);
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "DES_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1371EmpPromFijVar, "fijo") == 0 ) || ( GXutil.strcmp(A1371EmpPromFijVar, "variable") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Fijo/Variable", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors45173( )
   {
      pr_default.close(166);
   }

   public void enableDisable45173( )
   {
   }

   public void getKey45173( )
   {
      /* Using cursor BC0045169 */
      pr_default.execute(167, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A37TipoConCod, A1371EmpPromFijVar});
      if ( (pr_default.getStatus(167) != 101) )
      {
         RcdFound173 = (short)(1) ;
      }
      else
      {
         RcdFound173 = (short)(0) ;
      }
      pr_default.close(167);
   }

   public void getByPrimaryKey45173( )
   {
      /* Using cursor BC0045170 */
      pr_default.execute(168, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A37TipoConCod, A1371EmpPromFijVar});
      if ( (pr_default.getStatus(168) != 101) )
      {
         zm45173( 33) ;
         RcdFound173 = (short)(1) ;
         initializeNonKey45173( ) ;
         A1371EmpPromFijVar = BC0045170_A1371EmpPromFijVar[0] ;
         A1372EmpPromHabitual = BC0045170_A1372EmpPromHabitual[0] ;
         A37TipoConCod = BC0045170_A37TipoConCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z37TipoConCod = A37TipoConCod ;
         Z1371EmpPromFijVar = A1371EmpPromFijVar ;
         sMode173 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45173( ) ;
         load45173( ) ;
         Gx_mode = sMode173 ;
      }
      else
      {
         RcdFound173 = (short)(0) ;
         initializeNonKey45173( ) ;
         sMode173 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45173( ) ;
         Gx_mode = sMode173 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes45173( ) ;
      }
      pr_default.close(168);
   }

   public void checkOptimisticConcurrency45173( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0045171 */
         pr_default.execute(169, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A37TipoConCod, A1371EmpPromFijVar});
         if ( (pr_default.getStatus(169) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresapromedio_horanormal_mensualizados"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(169) == 101) || ( Z1372EmpPromHabitual != BC0045171_A1372EmpPromHabitual[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresapromedio_horanormal_mensualizados"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert45173( )
   {
      beforeValidate45173( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45173( ) ;
      }
      if ( AnyError == 0 )
      {
         zm45173( 0) ;
         checkOptimisticConcurrency45173( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45173( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert45173( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045172 */
                  pr_default.execute(170, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1371EmpPromFijVar, Boolean.valueOf(A1372EmpPromHabitual), A37TipoConCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresapromedio_horanormal_mensualizados");
                  if ( (pr_default.getStatus(170) == 1) )
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
            load45173( ) ;
         }
         endLevel45173( ) ;
      }
      closeExtendedTableCursors45173( ) ;
   }

   public void update45173( )
   {
      beforeValidate45173( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45173( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45173( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45173( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate45173( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045173 */
                  pr_default.execute(171, new Object[] {Boolean.valueOf(A1372EmpPromHabitual), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A37TipoConCod, A1371EmpPromFijVar});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresapromedio_horanormal_mensualizados");
                  if ( (pr_default.getStatus(171) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresapromedio_horanormal_mensualizados"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate45173( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey45173( ) ;
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
         endLevel45173( ) ;
      }
      closeExtendedTableCursors45173( ) ;
   }

   public void deferredUpdate45173( )
   {
   }

   public void delete45173( )
   {
      Gx_mode = "DLT" ;
      beforeValidate45173( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45173( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls45173( ) ;
         afterConfirm45173( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete45173( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0045174 */
               pr_default.execute(172, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A37TipoConCod, A1371EmpPromFijVar});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresapromedio_horanormal_mensualizados");
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
      sMode173 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel45173( ) ;
      Gx_mode = sMode173 ;
   }

   public void onDeleteControls45173( )
   {
      standaloneModal45173( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel45173( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(169);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart45173( )
   {
      /* Scan By routine */
      /* Using cursor BC0045175 */
      pr_default.execute(173, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound173 = (short)(0) ;
      if ( (pr_default.getStatus(173) != 101) )
      {
         RcdFound173 = (short)(1) ;
         A1371EmpPromFijVar = BC0045175_A1371EmpPromFijVar[0] ;
         A1372EmpPromHabitual = BC0045175_A1372EmpPromHabitual[0] ;
         A37TipoConCod = BC0045175_A37TipoConCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext45173( )
   {
      /* Scan next routine */
      pr_default.readNext(173);
      RcdFound173 = (short)(0) ;
      scanKeyLoad45173( ) ;
   }

   public void scanKeyLoad45173( )
   {
      sMode173 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(173) != 101) )
      {
         RcdFound173 = (short)(1) ;
         A1371EmpPromFijVar = BC0045175_A1371EmpPromFijVar[0] ;
         A1372EmpPromHabitual = BC0045175_A1372EmpPromHabitual[0] ;
         A37TipoConCod = BC0045175_A37TipoConCod[0] ;
      }
      Gx_mode = sMode173 ;
   }

   public void scanKeyEnd45173( )
   {
      pr_default.close(173);
   }

   public void afterConfirm45173( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert45173( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate45173( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete45173( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete45173( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate45173( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes45173( )
   {
   }

   public void send_integrity_lvl_hashes45173( )
   {
   }

   public void zm45191( int GX_JID )
   {
      if ( ( GX_JID == 35 ) || ( GX_JID == 0 ) )
      {
         Z1432EmpBasePlus = A1432EmpBasePlus ;
      }
      if ( GX_JID == -35 )
      {
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1427EmpBaseClaseLeg = A1427EmpBaseClaseLeg ;
         Z1429EmpBaseTipo = A1429EmpBaseTipo ;
         Z1430EmpBaseCod1 = A1430EmpBaseCod1 ;
         Z1431EmpBaseCod2 = A1431EmpBaseCod2 ;
         Z1432EmpBasePlus = A1432EmpBasePlus ;
      }
   }

   public void standaloneNotModal45191( )
   {
   }

   public void standaloneModal45191( )
   {
   }

   public void load45191( )
   {
      /* Using cursor BC0045176 */
      pr_default.execute(174, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
      if ( (pr_default.getStatus(174) != 101) )
      {
         RcdFound191 = (short)(1) ;
         A1432EmpBasePlus = BC0045176_A1432EmpBasePlus[0] ;
         zm45191( -35) ;
      }
      pr_default.close(174);
      onLoadActions45191( ) ;
   }

   public void onLoadActions45191( )
   {
   }

   public void checkExtendedTable45191( )
   {
      nIsDirty_191 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal45191( ) ;
      Gx_BScreen = (byte)(0) ;
      if ( ! ( ( A1427EmpBaseClaseLeg == 1 ) || ( A1427EmpBaseClaseLeg == 2 ) || ( A1427EmpBaseClaseLeg == 3 ) || ( A1427EmpBaseClaseLeg == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Clase de legajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1429EmpBaseTipo, "licencia") == 0 ) || ( GXutil.strcmp(A1429EmpBaseTipo, "feriado") == 0 ) || ( GXutil.strcmp(A1429EmpBaseTipo, "horaNormal") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors45191( )
   {
   }

   public void enableDisable45191( )
   {
   }

   public void getKey45191( )
   {
      /* Using cursor BC0045177 */
      pr_default.execute(175, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
      if ( (pr_default.getStatus(175) != 101) )
      {
         RcdFound191 = (short)(1) ;
      }
      else
      {
         RcdFound191 = (short)(0) ;
      }
      pr_default.close(175);
   }

   public void getByPrimaryKey45191( )
   {
      /* Using cursor BC0045178 */
      pr_default.execute(176, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
      if ( (pr_default.getStatus(176) != 101) )
      {
         zm45191( 35) ;
         RcdFound191 = (short)(1) ;
         initializeNonKey45191( ) ;
         A1427EmpBaseClaseLeg = BC0045178_A1427EmpBaseClaseLeg[0] ;
         A1429EmpBaseTipo = BC0045178_A1429EmpBaseTipo[0] ;
         A1430EmpBaseCod1 = BC0045178_A1430EmpBaseCod1[0] ;
         A1431EmpBaseCod2 = BC0045178_A1431EmpBaseCod2[0] ;
         A1432EmpBasePlus = BC0045178_A1432EmpBasePlus[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1427EmpBaseClaseLeg = A1427EmpBaseClaseLeg ;
         Z1429EmpBaseTipo = A1429EmpBaseTipo ;
         Z1430EmpBaseCod1 = A1430EmpBaseCod1 ;
         Z1431EmpBaseCod2 = A1431EmpBaseCod2 ;
         sMode191 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45191( ) ;
         load45191( ) ;
         Gx_mode = sMode191 ;
      }
      else
      {
         RcdFound191 = (short)(0) ;
         initializeNonKey45191( ) ;
         sMode191 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45191( ) ;
         Gx_mode = sMode191 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes45191( ) ;
      }
      pr_default.close(176);
   }

   public void checkOptimisticConcurrency45191( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0045179 */
         pr_default.execute(177, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
         if ( (pr_default.getStatus(177) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresabase_calculo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(177) == 101) || ( DecimalUtil.compareTo(Z1432EmpBasePlus, BC0045179_A1432EmpBasePlus[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresabase_calculo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert45191( )
   {
      beforeValidate45191( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45191( ) ;
      }
      if ( AnyError == 0 )
      {
         zm45191( 0) ;
         checkOptimisticConcurrency45191( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45191( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert45191( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045180 */
                  pr_default.execute(178, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, A1432EmpBasePlus});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresabase_calculo");
                  if ( (pr_default.getStatus(178) == 1) )
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
            load45191( ) ;
         }
         endLevel45191( ) ;
      }
      closeExtendedTableCursors45191( ) ;
   }

   public void update45191( )
   {
      beforeValidate45191( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45191( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45191( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45191( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate45191( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045181 */
                  pr_default.execute(179, new Object[] {A1432EmpBasePlus, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresabase_calculo");
                  if ( (pr_default.getStatus(179) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresabase_calculo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate45191( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey45191( ) ;
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
         endLevel45191( ) ;
      }
      closeExtendedTableCursors45191( ) ;
   }

   public void deferredUpdate45191( )
   {
   }

   public void delete45191( )
   {
      Gx_mode = "DLT" ;
      beforeValidate45191( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45191( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls45191( ) ;
         afterConfirm45191( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete45191( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0045182 */
               pr_default.execute(180, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresabase_calculo");
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
      sMode191 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel45191( ) ;
      Gx_mode = sMode191 ;
   }

   public void onDeleteControls45191( )
   {
      standaloneModal45191( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel45191( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(177);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart45191( )
   {
      /* Scan By routine */
      /* Using cursor BC0045183 */
      pr_default.execute(181, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound191 = (short)(0) ;
      if ( (pr_default.getStatus(181) != 101) )
      {
         RcdFound191 = (short)(1) ;
         A1427EmpBaseClaseLeg = BC0045183_A1427EmpBaseClaseLeg[0] ;
         A1429EmpBaseTipo = BC0045183_A1429EmpBaseTipo[0] ;
         A1430EmpBaseCod1 = BC0045183_A1430EmpBaseCod1[0] ;
         A1431EmpBaseCod2 = BC0045183_A1431EmpBaseCod2[0] ;
         A1432EmpBasePlus = BC0045183_A1432EmpBasePlus[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext45191( )
   {
      /* Scan next routine */
      pr_default.readNext(181);
      RcdFound191 = (short)(0) ;
      scanKeyLoad45191( ) ;
   }

   public void scanKeyLoad45191( )
   {
      sMode191 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(181) != 101) )
      {
         RcdFound191 = (short)(1) ;
         A1427EmpBaseClaseLeg = BC0045183_A1427EmpBaseClaseLeg[0] ;
         A1429EmpBaseTipo = BC0045183_A1429EmpBaseTipo[0] ;
         A1430EmpBaseCod1 = BC0045183_A1430EmpBaseCod1[0] ;
         A1431EmpBaseCod2 = BC0045183_A1431EmpBaseCod2[0] ;
         A1432EmpBasePlus = BC0045183_A1432EmpBasePlus[0] ;
      }
      Gx_mode = sMode191 ;
   }

   public void scanKeyEnd45191( )
   {
      pr_default.close(181);
   }

   public void afterConfirm45191( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert45191( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate45191( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete45191( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete45191( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate45191( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes45191( )
   {
   }

   public void send_integrity_lvl_hashes45191( )
   {
   }

   public void zm45165( int GX_JID )
   {
      if ( ( GX_JID == 36 ) || ( GX_JID == 0 ) )
      {
         Z1341EmpHsPDiaDia = A1341EmpHsPDiaDia ;
         Z1342EmpHsPDiaDesde = A1342EmpHsPDiaDesde ;
         Z1343EmpTarifaPDia = A1343EmpTarifaPDia ;
         Z1351EmpTarfaPDRec = A1351EmpTarfaPDRec ;
         Z1339EmpHsPDiaTipTra = A1339EmpHsPDiaTipTra ;
      }
      if ( ( GX_JID == 37 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -36 )
      {
         Z1340EmpHsExSec = A1340EmpHsExSec ;
         Z1341EmpHsPDiaDia = A1341EmpHsPDiaDia ;
         Z1342EmpHsPDiaDesde = A1342EmpHsPDiaDesde ;
         Z1343EmpTarifaPDia = A1343EmpTarifaPDia ;
         Z1351EmpTarfaPDRec = A1351EmpTarfaPDRec ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1339EmpHsPDiaTipTra = A1339EmpHsPDiaTipTra ;
      }
   }

   public void standaloneNotModal45165( )
   {
   }

   public void standaloneModal45165( )
   {
   }

   public void load45165( )
   {
      /* Using cursor BC0045184 */
      pr_default.execute(182, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
      if ( (pr_default.getStatus(182) != 101) )
      {
         RcdFound165 = (short)(1) ;
         A1341EmpHsPDiaDia = BC0045184_A1341EmpHsPDiaDia[0] ;
         A1342EmpHsPDiaDesde = BC0045184_A1342EmpHsPDiaDesde[0] ;
         n1342EmpHsPDiaDesde = BC0045184_n1342EmpHsPDiaDesde[0] ;
         A1343EmpTarifaPDia = BC0045184_A1343EmpTarifaPDia[0] ;
         A1351EmpTarfaPDRec = BC0045184_A1351EmpTarfaPDRec[0] ;
         A1339EmpHsPDiaTipTra = BC0045184_A1339EmpHsPDiaTipTra[0] ;
         zm45165( -36) ;
      }
      pr_default.close(182);
      onLoadActions45165( ) ;
   }

   public void onLoadActions45165( )
   {
   }

   public void checkExtendedTable45165( )
   {
      nIsDirty_165 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal45165( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC0045185 */
      pr_default.execute(183, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1339EmpHsPDiaTipTra});
      if ( (pr_default.getStatus(183) == 103) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"horasextras_por Limite"}), "RecordIsLocked", 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      if ( (pr_default.getStatus(9) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "horasextras_por Limite", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPHSPDIATIPTRA");
         AnyError = (short)(1) ;
      }
      pr_default.close(183);
      if ( ! ( ( GXutil.strcmp(A1339EmpHsPDiaTipTra, "diurno") == 0 ) || ( GXutil.strcmp(A1339EmpHsPDiaTipTra, "nocturno") == 0 ) || ( GXutil.strcmp(A1339EmpHsPDiaTipTra, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1341EmpHsPDiaDia == 1 ) || ( A1341EmpHsPDiaDia == 2 ) || ( A1341EmpHsPDiaDia == 3 ) || ( A1341EmpHsPDiaDia == 4 ) || ( A1341EmpHsPDiaDia == 5 ) || ( A1341EmpHsPDiaDia == 6 ) || ( A1341EmpHsPDiaDia == 7 ) || ( A1341EmpHsPDiaDia == 8 ) || ( A1341EmpHsPDiaDia == 9 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Día", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors45165( )
   {
      pr_default.close(183);
   }

   public void enableDisable45165( )
   {
   }

   public void getKey45165( )
   {
      /* Using cursor BC0045186 */
      pr_default.execute(184, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
      if ( (pr_default.getStatus(184) != 101) )
      {
         RcdFound165 = (short)(1) ;
      }
      else
      {
         RcdFound165 = (short)(0) ;
      }
      pr_default.close(184);
   }

   public void getByPrimaryKey45165( )
   {
      /* Using cursor BC0045187 */
      pr_default.execute(185, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
      if ( (pr_default.getStatus(185) != 101) )
      {
         zm45165( 36) ;
         RcdFound165 = (short)(1) ;
         initializeNonKey45165( ) ;
         A1340EmpHsExSec = BC0045187_A1340EmpHsExSec[0] ;
         A1341EmpHsPDiaDia = BC0045187_A1341EmpHsPDiaDia[0] ;
         A1342EmpHsPDiaDesde = BC0045187_A1342EmpHsPDiaDesde[0] ;
         n1342EmpHsPDiaDesde = BC0045187_n1342EmpHsPDiaDesde[0] ;
         A1343EmpTarifaPDia = BC0045187_A1343EmpTarifaPDia[0] ;
         A1351EmpTarfaPDRec = BC0045187_A1351EmpTarfaPDRec[0] ;
         A1339EmpHsPDiaTipTra = BC0045187_A1339EmpHsPDiaTipTra[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1340EmpHsExSec = A1340EmpHsExSec ;
         sMode165 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45165( ) ;
         load45165( ) ;
         Gx_mode = sMode165 ;
      }
      else
      {
         RcdFound165 = (short)(0) ;
         initializeNonKey45165( ) ;
         sMode165 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45165( ) ;
         Gx_mode = sMode165 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes45165( ) ;
      }
      pr_default.close(185);
   }

   public void checkOptimisticConcurrency45165( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0045188 */
         pr_default.execute(186, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
         if ( (pr_default.getStatus(186) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresahorasextras_pordia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(186) == 101) || ( Z1341EmpHsPDiaDia != BC0045188_A1341EmpHsPDiaDia[0] ) || ( GXutil.strcmp(Z1342EmpHsPDiaDesde, BC0045188_A1342EmpHsPDiaDesde[0]) != 0 ) || ( DecimalUtil.compareTo(Z1343EmpTarifaPDia, BC0045188_A1343EmpTarifaPDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1351EmpTarfaPDRec, BC0045188_A1351EmpTarfaPDRec[0]) != 0 ) || ( GXutil.strcmp(Z1339EmpHsPDiaTipTra, BC0045188_A1339EmpHsPDiaTipTra[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresahorasextras_pordia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert45165( )
   {
      beforeValidate45165( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45165( ) ;
      }
      if ( AnyError == 0 )
      {
         zm45165( 0) ;
         checkOptimisticConcurrency45165( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45165( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert45165( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045189 */
                  pr_default.execute(187, new Object[] {Short.valueOf(A1340EmpHsExSec), Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1339EmpHsPDiaTipTra});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
                  if ( (pr_default.getStatus(187) == 1) )
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
            load45165( ) ;
         }
         endLevel45165( ) ;
      }
      closeExtendedTableCursors45165( ) ;
   }

   public void update45165( )
   {
      beforeValidate45165( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45165( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45165( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45165( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate45165( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045190 */
                  pr_default.execute(188, new Object[] {Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, A1339EmpHsPDiaTipTra, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
                  if ( (pr_default.getStatus(188) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresahorasextras_pordia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate45165( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey45165( ) ;
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
         endLevel45165( ) ;
      }
      closeExtendedTableCursors45165( ) ;
   }

   public void deferredUpdate45165( )
   {
   }

   public void delete45165( )
   {
      Gx_mode = "DLT" ;
      beforeValidate45165( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45165( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls45165( ) ;
         afterConfirm45165( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete45165( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0045191 */
               pr_default.execute(189, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
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
      sMode165 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel45165( ) ;
      Gx_mode = sMode165 ;
   }

   public void onDeleteControls45165( )
   {
      standaloneModal45165( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel45165( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(186);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart45165( )
   {
      /* Scan By routine */
      /* Using cursor BC0045192 */
      pr_default.execute(190, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound165 = (short)(0) ;
      if ( (pr_default.getStatus(190) != 101) )
      {
         RcdFound165 = (short)(1) ;
         A1340EmpHsExSec = BC0045192_A1340EmpHsExSec[0] ;
         A1341EmpHsPDiaDia = BC0045192_A1341EmpHsPDiaDia[0] ;
         A1342EmpHsPDiaDesde = BC0045192_A1342EmpHsPDiaDesde[0] ;
         n1342EmpHsPDiaDesde = BC0045192_n1342EmpHsPDiaDesde[0] ;
         A1343EmpTarifaPDia = BC0045192_A1343EmpTarifaPDia[0] ;
         A1351EmpTarfaPDRec = BC0045192_A1351EmpTarfaPDRec[0] ;
         A1339EmpHsPDiaTipTra = BC0045192_A1339EmpHsPDiaTipTra[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext45165( )
   {
      /* Scan next routine */
      pr_default.readNext(190);
      RcdFound165 = (short)(0) ;
      scanKeyLoad45165( ) ;
   }

   public void scanKeyLoad45165( )
   {
      sMode165 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(190) != 101) )
      {
         RcdFound165 = (short)(1) ;
         A1340EmpHsExSec = BC0045192_A1340EmpHsExSec[0] ;
         A1341EmpHsPDiaDia = BC0045192_A1341EmpHsPDiaDia[0] ;
         A1342EmpHsPDiaDesde = BC0045192_A1342EmpHsPDiaDesde[0] ;
         n1342EmpHsPDiaDesde = BC0045192_n1342EmpHsPDiaDesde[0] ;
         A1343EmpTarifaPDia = BC0045192_A1343EmpTarifaPDia[0] ;
         A1351EmpTarfaPDRec = BC0045192_A1351EmpTarfaPDRec[0] ;
         A1339EmpHsPDiaTipTra = BC0045192_A1339EmpHsPDiaTipTra[0] ;
      }
      Gx_mode = sMode165 ;
   }

   public void scanKeyEnd45165( )
   {
      pr_default.close(190);
   }

   public void afterConfirm45165( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert45165( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate45165( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete45165( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete45165( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate45165( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes45165( )
   {
   }

   public void send_integrity_lvl_hashes45165( )
   {
   }

   public void zm45166( int GX_JID )
   {
      if ( ( GX_JID == 38 ) || ( GX_JID == 0 ) )
      {
         Z1344EmpHsDia = A1344EmpHsDia ;
         Z1345EmpHsSem = A1345EmpHsSem ;
         Z1346EmpTarifaXLim = A1346EmpTarifaXLim ;
         Z1352EmpTarifaRec = A1352EmpTarifaRec ;
         Z1386EmpHsMaxDia = A1386EmpHsMaxDia ;
         Z1387EmpHsMaxSem = A1387EmpHsMaxSem ;
         Z1388EmpHsMaxMes = A1388EmpHsMaxMes ;
         Z1389EmpHsMaxAnu = A1389EmpHsMaxAnu ;
      }
      if ( ( GX_JID == 39 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -38 )
      {
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1344EmpHsDia = A1344EmpHsDia ;
         Z1345EmpHsSem = A1345EmpHsSem ;
         Z1346EmpTarifaXLim = A1346EmpTarifaXLim ;
         Z1352EmpTarifaRec = A1352EmpTarifaRec ;
         Z1386EmpHsMaxDia = A1386EmpHsMaxDia ;
         Z1387EmpHsMaxSem = A1387EmpHsMaxSem ;
         Z1388EmpHsMaxMes = A1388EmpHsMaxMes ;
         Z1389EmpHsMaxAnu = A1389EmpHsMaxAnu ;
         Z1294PaiTipoTraId = A1294PaiTipoTraId ;
      }
   }

   public void standaloneNotModal45166( )
   {
   }

   public void standaloneModal45166( )
   {
   }

   public void load45166( )
   {
      /* Using cursor BC0045193 */
      pr_default.execute(191, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(191) != 101) )
      {
         RcdFound166 = (short)(1) ;
         A1344EmpHsDia = BC0045193_A1344EmpHsDia[0] ;
         A1345EmpHsSem = BC0045193_A1345EmpHsSem[0] ;
         A1346EmpTarifaXLim = BC0045193_A1346EmpTarifaXLim[0] ;
         A1352EmpTarifaRec = BC0045193_A1352EmpTarifaRec[0] ;
         A1386EmpHsMaxDia = BC0045193_A1386EmpHsMaxDia[0] ;
         A1387EmpHsMaxSem = BC0045193_A1387EmpHsMaxSem[0] ;
         A1388EmpHsMaxMes = BC0045193_A1388EmpHsMaxMes[0] ;
         A1389EmpHsMaxAnu = BC0045193_A1389EmpHsMaxAnu[0] ;
         zm45166( -38) ;
      }
      pr_default.close(191);
      onLoadActions45166( ) ;
   }

   public void onLoadActions45166( )
   {
   }

   public void checkExtendedTable45166( )
   {
      nIsDirty_166 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal45166( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC0045194 */
      pr_default.execute(192, new Object[] {A1294PaiTipoTraId});
      if ( (pr_default.getStatus(192) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Trabajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
      }
      pr_default.close(192);
      if ( ! ( ( GXutil.strcmp(A1294PaiTipoTraId, "diurno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "nocturno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de Trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors45166( )
   {
      pr_default.close(192);
   }

   public void enableDisable45166( )
   {
   }

   public void getKey45166( )
   {
      /* Using cursor BC0045195 */
      pr_default.execute(193, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(193) != 101) )
      {
         RcdFound166 = (short)(1) ;
      }
      else
      {
         RcdFound166 = (short)(0) ;
      }
      pr_default.close(193);
   }

   public void getByPrimaryKey45166( )
   {
      /* Using cursor BC0045196 */
      pr_default.execute(194, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(194) != 101) )
      {
         zm45166( 38) ;
         RcdFound166 = (short)(1) ;
         initializeNonKey45166( ) ;
         A1344EmpHsDia = BC0045196_A1344EmpHsDia[0] ;
         A1345EmpHsSem = BC0045196_A1345EmpHsSem[0] ;
         A1346EmpTarifaXLim = BC0045196_A1346EmpTarifaXLim[0] ;
         A1352EmpTarifaRec = BC0045196_A1352EmpTarifaRec[0] ;
         A1386EmpHsMaxDia = BC0045196_A1386EmpHsMaxDia[0] ;
         A1387EmpHsMaxSem = BC0045196_A1387EmpHsMaxSem[0] ;
         A1388EmpHsMaxMes = BC0045196_A1388EmpHsMaxMes[0] ;
         A1389EmpHsMaxAnu = BC0045196_A1389EmpHsMaxAnu[0] ;
         A1294PaiTipoTraId = BC0045196_A1294PaiTipoTraId[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1294PaiTipoTraId = A1294PaiTipoTraId ;
         sMode166 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45166( ) ;
         load45166( ) ;
         Gx_mode = sMode166 ;
      }
      else
      {
         RcdFound166 = (short)(0) ;
         initializeNonKey45166( ) ;
         sMode166 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45166( ) ;
         Gx_mode = sMode166 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes45166( ) ;
      }
      pr_default.close(194);
   }

   public void checkOptimisticConcurrency45166( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0045197 */
         pr_default.execute(195, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(195) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresatipo_trabajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(195) == 101) || ( DecimalUtil.compareTo(Z1344EmpHsDia, BC0045197_A1344EmpHsDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1345EmpHsSem, BC0045197_A1345EmpHsSem[0]) != 0 ) || ( DecimalUtil.compareTo(Z1346EmpTarifaXLim, BC0045197_A1346EmpTarifaXLim[0]) != 0 ) || ( DecimalUtil.compareTo(Z1352EmpTarifaRec, BC0045197_A1352EmpTarifaRec[0]) != 0 ) || ( DecimalUtil.compareTo(Z1386EmpHsMaxDia, BC0045197_A1386EmpHsMaxDia[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1387EmpHsMaxSem, BC0045197_A1387EmpHsMaxSem[0]) != 0 ) || ( DecimalUtil.compareTo(Z1388EmpHsMaxMes, BC0045197_A1388EmpHsMaxMes[0]) != 0 ) || ( DecimalUtil.compareTo(Z1389EmpHsMaxAnu, BC0045197_A1389EmpHsMaxAnu[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresatipo_trabajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert45166( )
   {
      beforeValidate45166( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45166( ) ;
      }
      if ( AnyError == 0 )
      {
         zm45166( 0) ;
         checkOptimisticConcurrency45166( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45166( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert45166( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045198 */
                  pr_default.execute(196, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1344EmpHsDia, A1345EmpHsSem, A1346EmpTarifaXLim, A1352EmpTarifaRec, A1386EmpHsMaxDia, A1387EmpHsMaxSem, A1388EmpHsMaxMes, A1389EmpHsMaxAnu, A1294PaiTipoTraId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresatipo_trabajo");
                  if ( (pr_default.getStatus(196) == 1) )
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
            load45166( ) ;
         }
         endLevel45166( ) ;
      }
      closeExtendedTableCursors45166( ) ;
   }

   public void update45166( )
   {
      beforeValidate45166( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45166( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45166( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45166( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate45166( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045199 */
                  pr_default.execute(197, new Object[] {A1344EmpHsDia, A1345EmpHsSem, A1346EmpTarifaXLim, A1352EmpTarifaRec, A1386EmpHsMaxDia, A1387EmpHsMaxSem, A1388EmpHsMaxMes, A1389EmpHsMaxAnu, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresatipo_trabajo");
                  if ( (pr_default.getStatus(197) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresatipo_trabajo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate45166( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey45166( ) ;
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
         endLevel45166( ) ;
      }
      closeExtendedTableCursors45166( ) ;
   }

   public void deferredUpdate45166( )
   {
   }

   public void delete45166( )
   {
      Gx_mode = "DLT" ;
      beforeValidate45166( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45166( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls45166( ) ;
         afterConfirm45166( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete45166( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0045200 */
               pr_default.execute(198, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresatipo_trabajo");
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
      sMode166 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel45166( ) ;
      Gx_mode = sMode166 ;
   }

   public void onDeleteControls45166( )
   {
      standaloneModal45166( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor BC0045201 */
         pr_default.execute(199, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(199) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "horasextras_pordia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(199);
      }
   }

   public void endLevel45166( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(195);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart45166( )
   {
      /* Scan By routine */
      /* Using cursor BC0045202 */
      pr_default.execute(200, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound166 = (short)(0) ;
      if ( (pr_default.getStatus(200) != 101) )
      {
         RcdFound166 = (short)(1) ;
         A1344EmpHsDia = BC0045202_A1344EmpHsDia[0] ;
         A1345EmpHsSem = BC0045202_A1345EmpHsSem[0] ;
         A1346EmpTarifaXLim = BC0045202_A1346EmpTarifaXLim[0] ;
         A1352EmpTarifaRec = BC0045202_A1352EmpTarifaRec[0] ;
         A1386EmpHsMaxDia = BC0045202_A1386EmpHsMaxDia[0] ;
         A1387EmpHsMaxSem = BC0045202_A1387EmpHsMaxSem[0] ;
         A1388EmpHsMaxMes = BC0045202_A1388EmpHsMaxMes[0] ;
         A1389EmpHsMaxAnu = BC0045202_A1389EmpHsMaxAnu[0] ;
         A1294PaiTipoTraId = BC0045202_A1294PaiTipoTraId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext45166( )
   {
      /* Scan next routine */
      pr_default.readNext(200);
      RcdFound166 = (short)(0) ;
      scanKeyLoad45166( ) ;
   }

   public void scanKeyLoad45166( )
   {
      sMode166 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(200) != 101) )
      {
         RcdFound166 = (short)(1) ;
         A1344EmpHsDia = BC0045202_A1344EmpHsDia[0] ;
         A1345EmpHsSem = BC0045202_A1345EmpHsSem[0] ;
         A1346EmpTarifaXLim = BC0045202_A1346EmpTarifaXLim[0] ;
         A1352EmpTarifaRec = BC0045202_A1352EmpTarifaRec[0] ;
         A1386EmpHsMaxDia = BC0045202_A1386EmpHsMaxDia[0] ;
         A1387EmpHsMaxSem = BC0045202_A1387EmpHsMaxSem[0] ;
         A1388EmpHsMaxMes = BC0045202_A1388EmpHsMaxMes[0] ;
         A1389EmpHsMaxAnu = BC0045202_A1389EmpHsMaxAnu[0] ;
         A1294PaiTipoTraId = BC0045202_A1294PaiTipoTraId[0] ;
      }
      Gx_mode = sMode166 ;
   }

   public void scanKeyEnd45166( )
   {
      pr_default.close(200);
   }

   public void afterConfirm45166( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert45166( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate45166( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete45166( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete45166( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate45166( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes45166( )
   {
   }

   public void send_integrity_lvl_hashes45166( )
   {
   }

   public void zm45144( int GX_JID )
   {
      if ( ( GX_JID == 40 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -40 )
      {
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1239EmpConvenio = A1239EmpConvenio ;
      }
   }

   public void standaloneNotModal45144( )
   {
   }

   public void standaloneModal45144( )
   {
   }

   public void load45144( )
   {
      /* Using cursor BC0045203 */
      pr_default.execute(201, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1239EmpConvenio});
      if ( (pr_default.getStatus(201) != 101) )
      {
         RcdFound144 = (short)(1) ;
         zm45144( -40) ;
      }
      pr_default.close(201);
      onLoadActions45144( ) ;
   }

   public void onLoadActions45144( )
   {
   }

   public void checkExtendedTable45144( )
   {
      nIsDirty_144 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal45144( ) ;
      Gx_BScreen = (byte)(0) ;
   }

   public void closeExtendedTableCursors45144( )
   {
   }

   public void enableDisable45144( )
   {
   }

   public void getKey45144( )
   {
      /* Using cursor BC0045204 */
      pr_default.execute(202, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1239EmpConvenio});
      if ( (pr_default.getStatus(202) != 101) )
      {
         RcdFound144 = (short)(1) ;
      }
      else
      {
         RcdFound144 = (short)(0) ;
      }
      pr_default.close(202);
   }

   public void getByPrimaryKey45144( )
   {
      /* Using cursor BC0045205 */
      pr_default.execute(203, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1239EmpConvenio});
      if ( (pr_default.getStatus(203) != 101) )
      {
         zm45144( 40) ;
         RcdFound144 = (short)(1) ;
         initializeNonKey45144( ) ;
         A1239EmpConvenio = BC0045205_A1239EmpConvenio[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1239EmpConvenio = A1239EmpConvenio ;
         sMode144 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45144( ) ;
         load45144( ) ;
         Gx_mode = sMode144 ;
      }
      else
      {
         RcdFound144 = (short)(0) ;
         initializeNonKey45144( ) ;
         sMode144 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45144( ) ;
         Gx_mode = sMode144 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes45144( ) ;
      }
      pr_default.close(203);
   }

   public void checkOptimisticConcurrency45144( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0045206 */
         pr_default.execute(204, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1239EmpConvenio});
         if ( (pr_default.getStatus(204) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresanolaborables_convenio"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(204) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresanolaborables_convenio"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert45144( )
   {
      beforeValidate45144( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45144( ) ;
      }
      if ( AnyError == 0 )
      {
         zm45144( 0) ;
         checkOptimisticConcurrency45144( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45144( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert45144( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045207 */
                  pr_default.execute(205, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1239EmpConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_convenio");
                  if ( (pr_default.getStatus(205) == 1) )
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
            load45144( ) ;
         }
         endLevel45144( ) ;
      }
      closeExtendedTableCursors45144( ) ;
   }

   public void update45144( )
   {
      beforeValidate45144( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45144( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45144( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45144( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate45144( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table Empresanolaborables_convenio */
                  deferredUpdate45144( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey45144( ) ;
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
         endLevel45144( ) ;
      }
      closeExtendedTableCursors45144( ) ;
   }

   public void deferredUpdate45144( )
   {
   }

   public void delete45144( )
   {
      Gx_mode = "DLT" ;
      beforeValidate45144( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45144( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls45144( ) ;
         afterConfirm45144( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete45144( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0045208 */
               pr_default.execute(206, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1239EmpConvenio});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_convenio");
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
      sMode144 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel45144( ) ;
      Gx_mode = sMode144 ;
   }

   public void onDeleteControls45144( )
   {
      standaloneModal45144( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel45144( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(204);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart45144( )
   {
      /* Scan By routine */
      /* Using cursor BC0045209 */
      pr_default.execute(207, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound144 = (short)(0) ;
      if ( (pr_default.getStatus(207) != 101) )
      {
         RcdFound144 = (short)(1) ;
         A1239EmpConvenio = BC0045209_A1239EmpConvenio[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext45144( )
   {
      /* Scan next routine */
      pr_default.readNext(207);
      RcdFound144 = (short)(0) ;
      scanKeyLoad45144( ) ;
   }

   public void scanKeyLoad45144( )
   {
      sMode144 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(207) != 101) )
      {
         RcdFound144 = (short)(1) ;
         A1239EmpConvenio = BC0045209_A1239EmpConvenio[0] ;
      }
      Gx_mode = sMode144 ;
   }

   public void scanKeyEnd45144( )
   {
      pr_default.close(207);
   }

   public void afterConfirm45144( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert45144( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate45144( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete45144( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete45144( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate45144( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes45144( )
   {
   }

   public void send_integrity_lvl_hashes45144( )
   {
   }

   public void zm45145( int GX_JID )
   {
      if ( ( GX_JID == 41 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 42 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -41 )
      {
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1238EmpOrigen = A1238EmpOrigen ;
      }
   }

   public void standaloneNotModal45145( )
   {
   }

   public void standaloneModal45145( )
   {
   }

   public void load45145( )
   {
      /* Using cursor BC0045210 */
      pr_default.execute(208, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
      if ( (pr_default.getStatus(208) != 101) )
      {
         RcdFound145 = (short)(1) ;
         zm45145( -41) ;
      }
      pr_default.close(208);
      onLoadActions45145( ) ;
   }

   public void onLoadActions45145( )
   {
   }

   public void checkExtendedTable45145( )
   {
      nIsDirty_145 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal45145( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC0045211 */
      pr_default.execute(209, new Object[] {A1238EmpOrigen});
      if ( (pr_default.getStatus(209) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Origen", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPORIGEN");
         AnyError = (short)(1) ;
      }
      pr_default.close(209);
   }

   public void closeExtendedTableCursors45145( )
   {
      pr_default.close(209);
   }

   public void enableDisable45145( )
   {
   }

   public void getKey45145( )
   {
      /* Using cursor BC0045212 */
      pr_default.execute(210, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
      if ( (pr_default.getStatus(210) != 101) )
      {
         RcdFound145 = (short)(1) ;
      }
      else
      {
         RcdFound145 = (short)(0) ;
      }
      pr_default.close(210);
   }

   public void getByPrimaryKey45145( )
   {
      /* Using cursor BC0045213 */
      pr_default.execute(211, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
      if ( (pr_default.getStatus(211) != 101) )
      {
         zm45145( 41) ;
         RcdFound145 = (short)(1) ;
         initializeNonKey45145( ) ;
         A1238EmpOrigen = BC0045213_A1238EmpOrigen[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1238EmpOrigen = A1238EmpOrigen ;
         sMode145 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45145( ) ;
         load45145( ) ;
         Gx_mode = sMode145 ;
      }
      else
      {
         RcdFound145 = (short)(0) ;
         initializeNonKey45145( ) ;
         sMode145 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45145( ) ;
         Gx_mode = sMode145 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes45145( ) ;
      }
      pr_default.close(211);
   }

   public void checkOptimisticConcurrency45145( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0045214 */
         pr_default.execute(212, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
         if ( (pr_default.getStatus(212) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresanolaborables_origen"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(212) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresanolaborables_origen"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert45145( )
   {
      beforeValidate45145( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45145( ) ;
      }
      if ( AnyError == 0 )
      {
         zm45145( 0) ;
         checkOptimisticConcurrency45145( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45145( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert45145( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045215 */
                  pr_default.execute(213, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_origen");
                  if ( (pr_default.getStatus(213) == 1) )
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
            load45145( ) ;
         }
         endLevel45145( ) ;
      }
      closeExtendedTableCursors45145( ) ;
   }

   public void update45145( )
   {
      beforeValidate45145( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45145( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45145( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45145( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate45145( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table Empresanolaborables_origen */
                  deferredUpdate45145( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey45145( ) ;
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
         endLevel45145( ) ;
      }
      closeExtendedTableCursors45145( ) ;
   }

   public void deferredUpdate45145( )
   {
   }

   public void delete45145( )
   {
      Gx_mode = "DLT" ;
      beforeValidate45145( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45145( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls45145( ) ;
         afterConfirm45145( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete45145( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0045216 */
               pr_default.execute(214, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_origen");
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
      sMode145 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel45145( ) ;
      Gx_mode = sMode145 ;
   }

   public void onDeleteControls45145( )
   {
      standaloneModal45145( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel45145( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(212);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart45145( )
   {
      /* Scan By routine */
      /* Using cursor BC0045217 */
      pr_default.execute(215, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound145 = (short)(0) ;
      if ( (pr_default.getStatus(215) != 101) )
      {
         RcdFound145 = (short)(1) ;
         A1238EmpOrigen = BC0045217_A1238EmpOrigen[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext45145( )
   {
      /* Scan next routine */
      pr_default.readNext(215);
      RcdFound145 = (short)(0) ;
      scanKeyLoad45145( ) ;
   }

   public void scanKeyLoad45145( )
   {
      sMode145 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(215) != 101) )
      {
         RcdFound145 = (short)(1) ;
         A1238EmpOrigen = BC0045217_A1238EmpOrigen[0] ;
      }
      Gx_mode = sMode145 ;
   }

   public void scanKeyEnd45145( )
   {
      pr_default.close(215);
   }

   public void afterConfirm45145( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert45145( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate45145( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete45145( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete45145( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate45145( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes45145( )
   {
   }

   public void send_integrity_lvl_hashes45145( )
   {
   }

   public void zm45146( int GX_JID )
   {
      if ( ( GX_JID == 43 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 44 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -43 )
      {
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1237EmpReligion = A1237EmpReligion ;
      }
   }

   public void standaloneNotModal45146( )
   {
   }

   public void standaloneModal45146( )
   {
   }

   public void load45146( )
   {
      /* Using cursor BC0045218 */
      pr_default.execute(216, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
      if ( (pr_default.getStatus(216) != 101) )
      {
         RcdFound146 = (short)(1) ;
         zm45146( -43) ;
      }
      pr_default.close(216);
      onLoadActions45146( ) ;
   }

   public void onLoadActions45146( )
   {
   }

   public void checkExtendedTable45146( )
   {
      nIsDirty_146 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal45146( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC0045219 */
      pr_default.execute(217, new Object[] {A1237EmpReligion});
      if ( (pr_default.getStatus(217) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Religion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPRELIGION");
         AnyError = (short)(1) ;
      }
      pr_default.close(217);
   }

   public void closeExtendedTableCursors45146( )
   {
      pr_default.close(217);
   }

   public void enableDisable45146( )
   {
   }

   public void getKey45146( )
   {
      /* Using cursor BC0045220 */
      pr_default.execute(218, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
      if ( (pr_default.getStatus(218) != 101) )
      {
         RcdFound146 = (short)(1) ;
      }
      else
      {
         RcdFound146 = (short)(0) ;
      }
      pr_default.close(218);
   }

   public void getByPrimaryKey45146( )
   {
      /* Using cursor BC0045221 */
      pr_default.execute(219, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
      if ( (pr_default.getStatus(219) != 101) )
      {
         zm45146( 43) ;
         RcdFound146 = (short)(1) ;
         initializeNonKey45146( ) ;
         A1237EmpReligion = BC0045221_A1237EmpReligion[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1237EmpReligion = A1237EmpReligion ;
         sMode146 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45146( ) ;
         load45146( ) ;
         Gx_mode = sMode146 ;
      }
      else
      {
         RcdFound146 = (short)(0) ;
         initializeNonKey45146( ) ;
         sMode146 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal45146( ) ;
         Gx_mode = sMode146 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes45146( ) ;
      }
      pr_default.close(219);
   }

   public void checkOptimisticConcurrency45146( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC0045222 */
         pr_default.execute(220, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
         if ( (pr_default.getStatus(220) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresanolaborables_religion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(220) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresanolaborables_religion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert45146( )
   {
      beforeValidate45146( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45146( ) ;
      }
      if ( AnyError == 0 )
      {
         zm45146( 0) ;
         checkOptimisticConcurrency45146( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45146( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert45146( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC0045223 */
                  pr_default.execute(221, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_religion");
                  if ( (pr_default.getStatus(221) == 1) )
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
            load45146( ) ;
         }
         endLevel45146( ) ;
      }
      closeExtendedTableCursors45146( ) ;
   }

   public void update45146( )
   {
      beforeValidate45146( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable45146( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45146( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm45146( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate45146( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table Empresanolaborables_religion */
                  deferredUpdate45146( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey45146( ) ;
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
         endLevel45146( ) ;
      }
      closeExtendedTableCursors45146( ) ;
   }

   public void deferredUpdate45146( )
   {
   }

   public void delete45146( )
   {
      Gx_mode = "DLT" ;
      beforeValidate45146( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency45146( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls45146( ) ;
         afterConfirm45146( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete45146( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC0045224 */
               pr_default.execute(222, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_religion");
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
      sMode146 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel45146( ) ;
      Gx_mode = sMode146 ;
   }

   public void onDeleteControls45146( )
   {
      standaloneModal45146( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel45146( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(220);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart45146( )
   {
      /* Scan By routine */
      /* Using cursor BC0045225 */
      pr_default.execute(223, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound146 = (short)(0) ;
      if ( (pr_default.getStatus(223) != 101) )
      {
         RcdFound146 = (short)(1) ;
         A1237EmpReligion = BC0045225_A1237EmpReligion[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext45146( )
   {
      /* Scan next routine */
      pr_default.readNext(223);
      RcdFound146 = (short)(0) ;
      scanKeyLoad45146( ) ;
   }

   public void scanKeyLoad45146( )
   {
      sMode146 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(223) != 101) )
      {
         RcdFound146 = (short)(1) ;
         A1237EmpReligion = BC0045225_A1237EmpReligion[0] ;
      }
      Gx_mode = sMode146 ;
   }

   public void scanKeyEnd45146( )
   {
      pr_default.close(223);
   }

   public void afterConfirm45146( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert45146( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate45146( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete45146( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete45146( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate45146( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes45146( )
   {
   }

   public void send_integrity_lvl_hashes45146( )
   {
   }

   public void send_integrity_lvl_hashes4513( )
   {
   }

   public void addRow4513( )
   {
      VarsToRow13( bcEmpresa_abm_1) ;
   }

   public void readRow4513( )
   {
      RowToVars13( bcEmpresa_abm_1, 1) ;
   }

   public void addRow45171( )
   {
      web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados obj171;
      obj171 = new web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados(remoteHandle);
      VarsToRow171( obj171) ;
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados().add(obj171, 0);
      obj171.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode( "UPD" );
      obj171.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified( (short)(0) );
   }

   public void readRow45171( )
   {
      nGXsfl_171_idx = (int)(nGXsfl_171_idx+1) ;
      RowToVars171( ((web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados().elementAt(-1+nGXsfl_171_idx)), 1) ;
   }

   public void addRow45172( )
   {
      web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados obj172;
      obj172 = new web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados(remoteHandle);
      VarsToRow172( obj172) ;
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados().add(obj172, 0);
      obj172.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode( "UPD" );
      obj172.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified( (short)(0) );
   }

   public void readRow45172( )
   {
      nGXsfl_172_idx = (int)(nGXsfl_172_idx+1) ;
      RowToVars172( ((web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados().elementAt(-1+nGXsfl_172_idx)), 1) ;
   }

   public void addRow45173( )
   {
      web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados obj173;
      obj173 = new web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados(remoteHandle);
      VarsToRow173( obj173) ;
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados().add(obj173, 0);
      obj173.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode( "UPD" );
      obj173.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified( (short)(0) );
   }

   public void readRow45173( )
   {
      nGXsfl_173_idx = (int)(nGXsfl_173_idx+1) ;
      RowToVars173( ((web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados().elementAt(-1+nGXsfl_173_idx)), 1) ;
   }

   public void addRow45191( )
   {
      web.SdtEmpresa_abm_1_base_calculo obj191;
      obj191 = new web.SdtEmpresa_abm_1_base_calculo(remoteHandle);
      VarsToRow191( obj191) ;
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Base_calculo().add(obj191, 0);
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Mode( "UPD" );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Modified( (short)(0) );
   }

   public void readRow45191( )
   {
      nGXsfl_191_idx = (int)(nGXsfl_191_idx+1) ;
      RowToVars191( ((web.SdtEmpresa_abm_1_base_calculo)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Base_calculo().elementAt(-1+nGXsfl_191_idx)), 1) ;
   }

   public void addRow45165( )
   {
      web.SdtEmpresa_abm_1_horasextras_pordia obj165;
      obj165 = new web.SdtEmpresa_abm_1_horasextras_pordia(remoteHandle);
      VarsToRow165( obj165) ;
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Horasextras_pordia().add(obj165, 0);
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Mode( "UPD" );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Modified( (short)(0) );
   }

   public void readRow45165( )
   {
      nGXsfl_165_idx = (int)(nGXsfl_165_idx+1) ;
      RowToVars165( ((web.SdtEmpresa_abm_1_horasextras_pordia)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Horasextras_pordia().elementAt(-1+nGXsfl_165_idx)), 1) ;
   }

   public void addRow45166( )
   {
      web.SdtEmpresa_abm_1_tipo_trabajo obj166;
      obj166 = new web.SdtEmpresa_abm_1_tipo_trabajo(remoteHandle);
      VarsToRow166( obj166) ;
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipo_trabajo().add(obj166, 0);
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Mode( "UPD" );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Modified( (short)(0) );
   }

   public void readRow45166( )
   {
      nGXsfl_166_idx = (int)(nGXsfl_166_idx+1) ;
      RowToVars166( ((web.SdtEmpresa_abm_1_tipo_trabajo)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipo_trabajo().elementAt(-1+nGXsfl_166_idx)), 1) ;
   }

   public void addRow45144( )
   {
      web.SdtEmpresa_abm_1_nolaborables_convenio obj144;
      obj144 = new web.SdtEmpresa_abm_1_nolaborables_convenio(remoteHandle);
      VarsToRow144( obj144) ;
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio().add(obj144, 0);
      obj144.setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode( "UPD" );
      obj144.setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified( (short)(0) );
   }

   public void readRow45144( )
   {
      nGXsfl_144_idx = (int)(nGXsfl_144_idx+1) ;
      RowToVars144( ((web.SdtEmpresa_abm_1_nolaborables_convenio)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio().elementAt(-1+nGXsfl_144_idx)), 1) ;
   }

   public void addRow45145( )
   {
      web.SdtEmpresa_abm_1_nolaborables_origen obj145;
      obj145 = new web.SdtEmpresa_abm_1_nolaborables_origen(remoteHandle);
      VarsToRow145( obj145) ;
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_origen().add(obj145, 0);
      obj145.setgxTv_SdtEmpresa_abm_1_nolaborables_origen_Mode( "UPD" );
      obj145.setgxTv_SdtEmpresa_abm_1_nolaborables_origen_Modified( (short)(0) );
   }

   public void readRow45145( )
   {
      nGXsfl_145_idx = (int)(nGXsfl_145_idx+1) ;
      RowToVars145( ((web.SdtEmpresa_abm_1_nolaborables_origen)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_origen().elementAt(-1+nGXsfl_145_idx)), 1) ;
   }

   public void addRow45146( )
   {
      web.SdtEmpresa_abm_1_nolaborables_religion obj146;
      obj146 = new web.SdtEmpresa_abm_1_nolaborables_religion(remoteHandle);
      VarsToRow146( obj146) ;
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_religion().add(obj146, 0);
      obj146.setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode( "UPD" );
      obj146.setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified( (short)(0) );
   }

   public void readRow45146( )
   {
      nGXsfl_146_idx = (int)(nGXsfl_146_idx+1) ;
      RowToVars146( ((web.SdtEmpresa_abm_1_nolaborables_religion)bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_religion().elementAt(-1+nGXsfl_146_idx)), 1) ;
   }

   public void initializeNonKey4513( )
   {
      A683ActDescripSinAc = "" ;
      A2EmpNom = "" ;
      A177EmpCUIT = 0 ;
      A178EmpDir = "" ;
      A180EmpTel = "" ;
      n180EmpTel = false ;
      A176EmpCP = "" ;
      n176EmpCP = false ;
      A46PaiCod = (short)(0) ;
      n46PaiCod = false ;
      A312PaiNom = "" ;
      A47ProvCod = (short)(0) ;
      n47ProvCod = false ;
      A322ProvNom = "" ;
      A1811EmpPerVacDes = (byte)(0) ;
      A1812EmpPerVacHas = (byte)(0) ;
      A48LocCod = (short)(0) ;
      n48LocCod = false ;
      A286LocNom = "" ;
      A43ActCodigo = "" ;
      n43ActCodigo = false ;
      A108ActDescrip = "" ;
      A45TipEmpleCod = "" ;
      n45TipEmpleCod = false ;
      A1533EmpActComercial = "" ;
      A44EmpZonCod = "" ;
      n44EmpZonCod = false ;
      A518EmpZonDescrip = "" ;
      A532EmpReducc = false ;
      A530TipEmpleDefIns = "" ;
      A955EmpLogo = "" ;
      n955EmpLogo = false ;
      A958EmpFirma = "" ;
      n958EmpFirma = false ;
      A1140EmpAntiguedad = DecimalUtil.ZERO ;
      A1141EmpPresentismo = DecimalUtil.ZERO ;
      A1302EmpMesHsPExt = DecimalUtil.ZERO ;
      n1302EmpMesHsPExt = false ;
      A1524EmpLiqFer = false ;
      A1750EmpLiqFerJor = false ;
      A1303EmpDiaHsPExt = "" ;
      n1303EmpDiaHsPExt = false ;
      A1151ARTSec = (short)(0) ;
      A1556EmpGuarEdadMin = (byte)(0) ;
      A1557EmpGuarEdadMax = (byte)(0) ;
      A1787EmpLiqGan = false ;
      A1792EmpTipoExp = (byte)(0) ;
      A1802EmpPromDesde = "" ;
      A1813EmpFracVacAnt = DecimalUtil.ZERO ;
      A2259EmpVacExpLim = false ;
      A2260EmpVacExpTie = (byte)(0) ;
      A2261EmpVacDisMax = 0 ;
      A903ActComCodigo = "" ;
      A1965EmpOsoCod = "" ;
      n1965EmpOsoCod = false ;
      A2265EmpCondiCod = (short)(0) ;
      A2405EmpModTra = "" ;
      A2406EmpModEmpl = false ;
      A2407EmpModAuto = false ;
      A957EmpLogoExt = "" ;
      n957EmpLogoExt = false ;
      A960EmpFirmaExt = "" ;
      n960EmpFirmaExt = false ;
      A956EmpLogoNom = "" ;
      n956EmpLogoNom = false ;
      A959EmpFirmaNom = "" ;
      n959EmpFirmaNom = false ;
      Z2EmpNom = "" ;
      Z177EmpCUIT = 0 ;
      Z178EmpDir = "" ;
      Z180EmpTel = "" ;
      Z176EmpCP = "" ;
      Z1811EmpPerVacDes = (byte)(0) ;
      Z1812EmpPerVacHas = (byte)(0) ;
      Z532EmpReducc = false ;
      Z1140EmpAntiguedad = DecimalUtil.ZERO ;
      Z1141EmpPresentismo = DecimalUtil.ZERO ;
      Z1302EmpMesHsPExt = DecimalUtil.ZERO ;
      Z1524EmpLiqFer = false ;
      Z1750EmpLiqFerJor = false ;
      Z1303EmpDiaHsPExt = "" ;
      Z1556EmpGuarEdadMin = (byte)(0) ;
      Z1557EmpGuarEdadMax = (byte)(0) ;
      Z1787EmpLiqGan = false ;
      Z1792EmpTipoExp = (byte)(0) ;
      Z1802EmpPromDesde = "" ;
      Z1813EmpFracVacAnt = DecimalUtil.ZERO ;
      Z2259EmpVacExpLim = false ;
      Z2260EmpVacExpTie = (byte)(0) ;
      Z2261EmpVacDisMax = 0 ;
      Z2405EmpModTra = "" ;
      Z2406EmpModEmpl = false ;
      Z2407EmpModAuto = false ;
      Z46PaiCod = (short)(0) ;
      Z47ProvCod = (short)(0) ;
      Z48LocCod = (short)(0) ;
      Z43ActCodigo = "" ;
      Z45TipEmpleCod = "" ;
      Z1151ARTSec = (short)(0) ;
      Z903ActComCodigo = "" ;
      Z1965EmpOsoCod = "" ;
      Z1533EmpActComercial = "" ;
      Z44EmpZonCod = "" ;
      Z2265EmpCondiCod = (short)(0) ;
   }

   public void initAll4513( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      initializeNonKey4513( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey45171( )
   {
      A26ConCodigo = "" ;
      A1370EmpMenHabitual = false ;
      Z1370EmpMenHabitual = false ;
   }

   public void initAll45171( )
   {
      A1368EmpMenConCodigo = "" ;
      initializeNonKey45171( ) ;
   }

   public void standaloneModalInsert45171( )
   {
   }

   public void initializeNonKey45172( )
   {
      A26ConCodigo = "" ;
      A1369EmpJorHabitual = false ;
      Z1369EmpJorHabitual = false ;
   }

   public void initAll45172( )
   {
      A1366EmpJorConCodigo = "" ;
      initializeNonKey45172( ) ;
   }

   public void standaloneModalInsert45172( )
   {
   }

   public void initializeNonKey45173( )
   {
      A1372EmpPromHabitual = false ;
      Z1372EmpPromHabitual = false ;
   }

   public void initAll45173( )
   {
      A37TipoConCod = "" ;
      A1371EmpPromFijVar = "" ;
      initializeNonKey45173( ) ;
   }

   public void standaloneModalInsert45173( )
   {
   }

   public void initializeNonKey45191( )
   {
      A1432EmpBasePlus = DecimalUtil.ZERO ;
      Z1432EmpBasePlus = DecimalUtil.ZERO ;
   }

   public void initAll45191( )
   {
      A1427EmpBaseClaseLeg = (byte)(0) ;
      A1429EmpBaseTipo = "" ;
      A1430EmpBaseCod1 = "" ;
      A1431EmpBaseCod2 = "" ;
      initializeNonKey45191( ) ;
   }

   public void standaloneModalInsert45191( )
   {
   }

   public void initializeNonKey45165( )
   {
      A1294PaiTipoTraId = "" ;
      A1339EmpHsPDiaTipTra = "" ;
      A1341EmpHsPDiaDia = (byte)(0) ;
      A1342EmpHsPDiaDesde = "" ;
      n1342EmpHsPDiaDesde = false ;
      A1343EmpTarifaPDia = DecimalUtil.ZERO ;
      A1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      Z1341EmpHsPDiaDia = (byte)(0) ;
      Z1342EmpHsPDiaDesde = "" ;
      Z1343EmpTarifaPDia = DecimalUtil.ZERO ;
      Z1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      Z1339EmpHsPDiaTipTra = "" ;
   }

   public void initAll45165( )
   {
      A1340EmpHsExSec = (short)(0) ;
      initializeNonKey45165( ) ;
   }

   public void standaloneModalInsert45165( )
   {
   }

   public void initializeNonKey45166( )
   {
      A1292TipoTraId = "" ;
      A1344EmpHsDia = DecimalUtil.ZERO ;
      A1345EmpHsSem = DecimalUtil.ZERO ;
      A1346EmpTarifaXLim = DecimalUtil.ZERO ;
      A1352EmpTarifaRec = DecimalUtil.ZERO ;
      A1386EmpHsMaxDia = DecimalUtil.ZERO ;
      A1387EmpHsMaxSem = DecimalUtil.ZERO ;
      A1388EmpHsMaxMes = DecimalUtil.ZERO ;
      A1389EmpHsMaxAnu = DecimalUtil.ZERO ;
      Z1344EmpHsDia = DecimalUtil.ZERO ;
      Z1345EmpHsSem = DecimalUtil.ZERO ;
      Z1346EmpTarifaXLim = DecimalUtil.ZERO ;
      Z1352EmpTarifaRec = DecimalUtil.ZERO ;
      Z1386EmpHsMaxDia = DecimalUtil.ZERO ;
      Z1387EmpHsMaxSem = DecimalUtil.ZERO ;
      Z1388EmpHsMaxMes = DecimalUtil.ZERO ;
      Z1389EmpHsMaxAnu = DecimalUtil.ZERO ;
   }

   public void initAll45166( )
   {
      A1294PaiTipoTraId = "" ;
      initializeNonKey45166( ) ;
   }

   public void standaloneModalInsert45166( )
   {
   }

   public void initializeNonKey45144( )
   {
   }

   public void initAll45144( )
   {
      A1239EmpConvenio = "" ;
      initializeNonKey45144( ) ;
   }

   public void standaloneModalInsert45144( )
   {
   }

   public void initializeNonKey45145( )
   {
      A1231OrigId = "" ;
   }

   public void initAll45145( )
   {
      A1238EmpOrigen = "" ;
      initializeNonKey45145( ) ;
   }

   public void standaloneModalInsert45145( )
   {
   }

   public void initializeNonKey45146( )
   {
      A1229ReligId = "" ;
   }

   public void initAll45146( )
   {
      A1237EmpReligion = "" ;
      initializeNonKey45146( ) ;
   }

   public void standaloneModalInsert45146( )
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

   public void VarsToRow13( web.SdtEmpresa_abm_1 obj13 )
   {
      obj13.setgxTv_SdtEmpresa_abm_1_Mode( Gx_mode );
      obj13.setgxTv_SdtEmpresa_abm_1_Empnom( A2EmpNom );
      obj13.setgxTv_SdtEmpresa_abm_1_Empcuit( A177EmpCUIT );
      obj13.setgxTv_SdtEmpresa_abm_1_Empdir( A178EmpDir );
      obj13.setgxTv_SdtEmpresa_abm_1_Emptel( A180EmpTel );
      obj13.setgxTv_SdtEmpresa_abm_1_Empcp( A176EmpCP );
      obj13.setgxTv_SdtEmpresa_abm_1_Paicod( A46PaiCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Painom( A312PaiNom );
      obj13.setgxTv_SdtEmpresa_abm_1_Provcod( A47ProvCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Provnom( A322ProvNom );
      obj13.setgxTv_SdtEmpresa_abm_1_Emppervacdes( A1811EmpPerVacDes );
      obj13.setgxTv_SdtEmpresa_abm_1_Emppervachas( A1812EmpPerVacHas );
      obj13.setgxTv_SdtEmpresa_abm_1_Loccod( A48LocCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Locnom( A286LocNom );
      obj13.setgxTv_SdtEmpresa_abm_1_Actcodigo( A43ActCodigo );
      obj13.setgxTv_SdtEmpresa_abm_1_Actdescrip( A108ActDescrip );
      obj13.setgxTv_SdtEmpresa_abm_1_Tipemplecod( A45TipEmpleCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Empactcomercial( A1533EmpActComercial );
      obj13.setgxTv_SdtEmpresa_abm_1_Empzoncod( A44EmpZonCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Empzondescrip( A518EmpZonDescrip );
      obj13.setgxTv_SdtEmpresa_abm_1_Empreducc( A532EmpReducc );
      obj13.setgxTv_SdtEmpresa_abm_1_Tipempledefins( A530TipEmpleDefIns );
      obj13.setgxTv_SdtEmpresa_abm_1_Emplogo( A955EmpLogo );
      obj13.setgxTv_SdtEmpresa_abm_1_Empfirma( A958EmpFirma );
      obj13.setgxTv_SdtEmpresa_abm_1_Empantiguedad( A1140EmpAntiguedad );
      obj13.setgxTv_SdtEmpresa_abm_1_Emppresentismo( A1141EmpPresentismo );
      obj13.setgxTv_SdtEmpresa_abm_1_Empmeshspext( A1302EmpMesHsPExt );
      obj13.setgxTv_SdtEmpresa_abm_1_Empliqfer( A1524EmpLiqFer );
      obj13.setgxTv_SdtEmpresa_abm_1_Empliqferjor( A1750EmpLiqFerJor );
      obj13.setgxTv_SdtEmpresa_abm_1_Empdiahspext( A1303EmpDiaHsPExt );
      obj13.setgxTv_SdtEmpresa_abm_1_Artsec( A1151ARTSec );
      obj13.setgxTv_SdtEmpresa_abm_1_Empguaredadmin( A1556EmpGuarEdadMin );
      obj13.setgxTv_SdtEmpresa_abm_1_Empguaredadmax( A1557EmpGuarEdadMax );
      obj13.setgxTv_SdtEmpresa_abm_1_Empliqgan( A1787EmpLiqGan );
      obj13.setgxTv_SdtEmpresa_abm_1_Emptipoexp( A1792EmpTipoExp );
      obj13.setgxTv_SdtEmpresa_abm_1_Emppromdesde( A1802EmpPromDesde );
      obj13.setgxTv_SdtEmpresa_abm_1_Empfracvacant( A1813EmpFracVacAnt );
      obj13.setgxTv_SdtEmpresa_abm_1_Empvacexplim( A2259EmpVacExpLim );
      obj13.setgxTv_SdtEmpresa_abm_1_Empvacexptie( A2260EmpVacExpTie );
      obj13.setgxTv_SdtEmpresa_abm_1_Empvacdismax( A2261EmpVacDisMax );
      obj13.setgxTv_SdtEmpresa_abm_1_Actcomcodigo( A903ActComCodigo );
      obj13.setgxTv_SdtEmpresa_abm_1_Emposocod( A1965EmpOsoCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Empcondicod( A2265EmpCondiCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Empmodtra( A2405EmpModTra );
      obj13.setgxTv_SdtEmpresa_abm_1_Empmodempl( A2406EmpModEmpl );
      obj13.setgxTv_SdtEmpresa_abm_1_Empmodauto( A2407EmpModAuto );
      obj13.setgxTv_SdtEmpresa_abm_1_Emplogoext( A957EmpLogoExt );
      obj13.setgxTv_SdtEmpresa_abm_1_Empfirmaext( A960EmpFirmaExt );
      obj13.setgxTv_SdtEmpresa_abm_1_Emplogonom( A956EmpLogoNom );
      obj13.setgxTv_SdtEmpresa_abm_1_Empfirmanom( A959EmpFirmaNom );
      obj13.setgxTv_SdtEmpresa_abm_1_Clicod( A3CliCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Empcod( A1EmpCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Clicod_Z( Z3CliCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Empcod_Z( Z1EmpCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Empnom_Z( Z2EmpNom );
      obj13.setgxTv_SdtEmpresa_abm_1_Empcuit_Z( Z177EmpCUIT );
      obj13.setgxTv_SdtEmpresa_abm_1_Empdir_Z( Z178EmpDir );
      obj13.setgxTv_SdtEmpresa_abm_1_Emptel_Z( Z180EmpTel );
      obj13.setgxTv_SdtEmpresa_abm_1_Empcp_Z( Z176EmpCP );
      obj13.setgxTv_SdtEmpresa_abm_1_Paicod_Z( Z46PaiCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Painom_Z( Z312PaiNom );
      obj13.setgxTv_SdtEmpresa_abm_1_Provcod_Z( Z47ProvCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Provnom_Z( Z322ProvNom );
      obj13.setgxTv_SdtEmpresa_abm_1_Emppervacdes_Z( Z1811EmpPerVacDes );
      obj13.setgxTv_SdtEmpresa_abm_1_Emppervachas_Z( Z1812EmpPerVacHas );
      obj13.setgxTv_SdtEmpresa_abm_1_Loccod_Z( Z48LocCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Locnom_Z( Z286LocNom );
      obj13.setgxTv_SdtEmpresa_abm_1_Actcodigo_Z( Z43ActCodigo );
      obj13.setgxTv_SdtEmpresa_abm_1_Actdescrip_Z( Z108ActDescrip );
      obj13.setgxTv_SdtEmpresa_abm_1_Tipemplecod_Z( Z45TipEmpleCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Empactcomercial_Z( Z1533EmpActComercial );
      obj13.setgxTv_SdtEmpresa_abm_1_Empzoncod_Z( Z44EmpZonCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Empzondescrip_Z( Z518EmpZonDescrip );
      obj13.setgxTv_SdtEmpresa_abm_1_Empreducc_Z( Z532EmpReducc );
      obj13.setgxTv_SdtEmpresa_abm_1_Tipempledefins_Z( Z530TipEmpleDefIns );
      obj13.setgxTv_SdtEmpresa_abm_1_Emplogonom_Z( Z956EmpLogoNom );
      obj13.setgxTv_SdtEmpresa_abm_1_Emplogoext_Z( Z957EmpLogoExt );
      obj13.setgxTv_SdtEmpresa_abm_1_Empfirmanom_Z( Z959EmpFirmaNom );
      obj13.setgxTv_SdtEmpresa_abm_1_Empfirmaext_Z( Z960EmpFirmaExt );
      obj13.setgxTv_SdtEmpresa_abm_1_Empantiguedad_Z( Z1140EmpAntiguedad );
      obj13.setgxTv_SdtEmpresa_abm_1_Emppresentismo_Z( Z1141EmpPresentismo );
      obj13.setgxTv_SdtEmpresa_abm_1_Empmeshspext_Z( Z1302EmpMesHsPExt );
      obj13.setgxTv_SdtEmpresa_abm_1_Empliqfer_Z( Z1524EmpLiqFer );
      obj13.setgxTv_SdtEmpresa_abm_1_Empliqferjor_Z( Z1750EmpLiqFerJor );
      obj13.setgxTv_SdtEmpresa_abm_1_Empdiahspext_Z( Z1303EmpDiaHsPExt );
      obj13.setgxTv_SdtEmpresa_abm_1_Artsec_Z( Z1151ARTSec );
      obj13.setgxTv_SdtEmpresa_abm_1_Empguaredadmin_Z( Z1556EmpGuarEdadMin );
      obj13.setgxTv_SdtEmpresa_abm_1_Empguaredadmax_Z( Z1557EmpGuarEdadMax );
      obj13.setgxTv_SdtEmpresa_abm_1_Empliqgan_Z( Z1787EmpLiqGan );
      obj13.setgxTv_SdtEmpresa_abm_1_Emptipoexp_Z( Z1792EmpTipoExp );
      obj13.setgxTv_SdtEmpresa_abm_1_Emppromdesde_Z( Z1802EmpPromDesde );
      obj13.setgxTv_SdtEmpresa_abm_1_Empfracvacant_Z( Z1813EmpFracVacAnt );
      obj13.setgxTv_SdtEmpresa_abm_1_Empvacexplim_Z( Z2259EmpVacExpLim );
      obj13.setgxTv_SdtEmpresa_abm_1_Empvacexptie_Z( Z2260EmpVacExpTie );
      obj13.setgxTv_SdtEmpresa_abm_1_Empvacdismax_Z( Z2261EmpVacDisMax );
      obj13.setgxTv_SdtEmpresa_abm_1_Actcomcodigo_Z( Z903ActComCodigo );
      obj13.setgxTv_SdtEmpresa_abm_1_Emposocod_Z( Z1965EmpOsoCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Empcondicod_Z( Z2265EmpCondiCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Empmodtra_Z( Z2405EmpModTra );
      obj13.setgxTv_SdtEmpresa_abm_1_Empmodempl_Z( Z2406EmpModEmpl );
      obj13.setgxTv_SdtEmpresa_abm_1_Empmodauto_Z( Z2407EmpModAuto );
      obj13.setgxTv_SdtEmpresa_abm_1_Emptel_N( (byte)((byte)((n180EmpTel)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Empcp_N( (byte)((byte)((n176EmpCP)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Paicod_N( (byte)((byte)((n46PaiCod)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Provcod_N( (byte)((byte)((n47ProvCod)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Loccod_N( (byte)((byte)((n48LocCod)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Actcodigo_N( (byte)((byte)((n43ActCodigo)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Tipemplecod_N( (byte)((byte)((n45TipEmpleCod)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Empzoncod_N( (byte)((byte)((n44EmpZonCod)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Emplogo_N( (byte)((byte)((n955EmpLogo)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Emplogonom_N( (byte)((byte)((n956EmpLogoNom)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Emplogoext_N( (byte)((byte)((n957EmpLogoExt)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Empfirma_N( (byte)((byte)((n958EmpFirma)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Empfirmanom_N( (byte)((byte)((n959EmpFirmaNom)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Empfirmaext_N( (byte)((byte)((n960EmpFirmaExt)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Empmeshspext_N( (byte)((byte)((n1302EmpMesHsPExt)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Empdiahspext_N( (byte)((byte)((n1303EmpDiaHsPExt)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Emposocod_N( (byte)((byte)((n1965EmpOsoCod)?1:0)) );
      obj13.setgxTv_SdtEmpresa_abm_1_Mode( Gx_mode );
   }

   public void KeyVarsToRow13( web.SdtEmpresa_abm_1 obj13 )
   {
      obj13.setgxTv_SdtEmpresa_abm_1_Clicod( A3CliCod );
      obj13.setgxTv_SdtEmpresa_abm_1_Empcod( A1EmpCod );
   }

   public void RowToVars13( web.SdtEmpresa_abm_1 obj13 ,
                            int forceLoad )
   {
      Gx_mode = obj13.getgxTv_SdtEmpresa_abm_1_Mode() ;
      A2EmpNom = obj13.getgxTv_SdtEmpresa_abm_1_Empnom() ;
      A177EmpCUIT = obj13.getgxTv_SdtEmpresa_abm_1_Empcuit() ;
      A178EmpDir = obj13.getgxTv_SdtEmpresa_abm_1_Empdir() ;
      A180EmpTel = obj13.getgxTv_SdtEmpresa_abm_1_Emptel() ;
      n180EmpTel = false ;
      A176EmpCP = obj13.getgxTv_SdtEmpresa_abm_1_Empcp() ;
      n176EmpCP = false ;
      A46PaiCod = obj13.getgxTv_SdtEmpresa_abm_1_Paicod() ;
      n46PaiCod = false ;
      A312PaiNom = obj13.getgxTv_SdtEmpresa_abm_1_Painom() ;
      A47ProvCod = obj13.getgxTv_SdtEmpresa_abm_1_Provcod() ;
      n47ProvCod = false ;
      A322ProvNom = obj13.getgxTv_SdtEmpresa_abm_1_Provnom() ;
      A1811EmpPerVacDes = obj13.getgxTv_SdtEmpresa_abm_1_Emppervacdes() ;
      A1812EmpPerVacHas = obj13.getgxTv_SdtEmpresa_abm_1_Emppervachas() ;
      A48LocCod = obj13.getgxTv_SdtEmpresa_abm_1_Loccod() ;
      n48LocCod = false ;
      A286LocNom = obj13.getgxTv_SdtEmpresa_abm_1_Locnom() ;
      A43ActCodigo = obj13.getgxTv_SdtEmpresa_abm_1_Actcodigo() ;
      n43ActCodigo = false ;
      A108ActDescrip = obj13.getgxTv_SdtEmpresa_abm_1_Actdescrip() ;
      A45TipEmpleCod = obj13.getgxTv_SdtEmpresa_abm_1_Tipemplecod() ;
      n45TipEmpleCod = false ;
      A1533EmpActComercial = obj13.getgxTv_SdtEmpresa_abm_1_Empactcomercial() ;
      A44EmpZonCod = obj13.getgxTv_SdtEmpresa_abm_1_Empzoncod() ;
      n44EmpZonCod = false ;
      A518EmpZonDescrip = obj13.getgxTv_SdtEmpresa_abm_1_Empzondescrip() ;
      A532EmpReducc = obj13.getgxTv_SdtEmpresa_abm_1_Empreducc() ;
      A530TipEmpleDefIns = obj13.getgxTv_SdtEmpresa_abm_1_Tipempledefins() ;
      A955EmpLogo = obj13.getgxTv_SdtEmpresa_abm_1_Emplogo() ;
      n955EmpLogo = false ;
      A958EmpFirma = obj13.getgxTv_SdtEmpresa_abm_1_Empfirma() ;
      n958EmpFirma = false ;
      A1140EmpAntiguedad = obj13.getgxTv_SdtEmpresa_abm_1_Empantiguedad() ;
      A1141EmpPresentismo = obj13.getgxTv_SdtEmpresa_abm_1_Emppresentismo() ;
      A1302EmpMesHsPExt = obj13.getgxTv_SdtEmpresa_abm_1_Empmeshspext() ;
      n1302EmpMesHsPExt = false ;
      A1524EmpLiqFer = obj13.getgxTv_SdtEmpresa_abm_1_Empliqfer() ;
      A1750EmpLiqFerJor = obj13.getgxTv_SdtEmpresa_abm_1_Empliqferjor() ;
      A1303EmpDiaHsPExt = obj13.getgxTv_SdtEmpresa_abm_1_Empdiahspext() ;
      n1303EmpDiaHsPExt = false ;
      A1151ARTSec = obj13.getgxTv_SdtEmpresa_abm_1_Artsec() ;
      A1556EmpGuarEdadMin = obj13.getgxTv_SdtEmpresa_abm_1_Empguaredadmin() ;
      A1557EmpGuarEdadMax = obj13.getgxTv_SdtEmpresa_abm_1_Empguaredadmax() ;
      A1787EmpLiqGan = obj13.getgxTv_SdtEmpresa_abm_1_Empliqgan() ;
      A1792EmpTipoExp = obj13.getgxTv_SdtEmpresa_abm_1_Emptipoexp() ;
      A1802EmpPromDesde = obj13.getgxTv_SdtEmpresa_abm_1_Emppromdesde() ;
      A1813EmpFracVacAnt = obj13.getgxTv_SdtEmpresa_abm_1_Empfracvacant() ;
      A2259EmpVacExpLim = obj13.getgxTv_SdtEmpresa_abm_1_Empvacexplim() ;
      A2260EmpVacExpTie = obj13.getgxTv_SdtEmpresa_abm_1_Empvacexptie() ;
      A2261EmpVacDisMax = obj13.getgxTv_SdtEmpresa_abm_1_Empvacdismax() ;
      A903ActComCodigo = obj13.getgxTv_SdtEmpresa_abm_1_Actcomcodigo() ;
      A1965EmpOsoCod = obj13.getgxTv_SdtEmpresa_abm_1_Emposocod() ;
      n1965EmpOsoCod = false ;
      A2265EmpCondiCod = obj13.getgxTv_SdtEmpresa_abm_1_Empcondicod() ;
      A2405EmpModTra = obj13.getgxTv_SdtEmpresa_abm_1_Empmodtra() ;
      A2406EmpModEmpl = obj13.getgxTv_SdtEmpresa_abm_1_Empmodempl() ;
      A2407EmpModAuto = obj13.getgxTv_SdtEmpresa_abm_1_Empmodauto() ;
      A957EmpLogoExt = ((GXutil.strcmp("", obj13.getgxTv_SdtEmpresa_abm_1_Emplogoext())==0) ? com.genexus.util.GXFile.getgxFileext( A955EmpLogo) : obj13.getgxTv_SdtEmpresa_abm_1_Emplogoext()) ;
      n957EmpLogoExt = false ;
      A960EmpFirmaExt = ((GXutil.strcmp("", obj13.getgxTv_SdtEmpresa_abm_1_Empfirmaext())==0) ? com.genexus.util.GXFile.getgxFileext( A958EmpFirma) : obj13.getgxTv_SdtEmpresa_abm_1_Empfirmaext()) ;
      n960EmpFirmaExt = false ;
      A956EmpLogoNom = ((GXutil.strcmp("", obj13.getgxTv_SdtEmpresa_abm_1_Emplogonom())==0) ? com.genexus.util.GXFile.getgxFilename( A955EmpLogo) : obj13.getgxTv_SdtEmpresa_abm_1_Emplogonom()) ;
      n956EmpLogoNom = false ;
      A959EmpFirmaNom = ((GXutil.strcmp("", obj13.getgxTv_SdtEmpresa_abm_1_Empfirmanom())==0) ? com.genexus.util.GXFile.getgxFilename( A958EmpFirma) : obj13.getgxTv_SdtEmpresa_abm_1_Empfirmanom()) ;
      n959EmpFirmaNom = false ;
      A3CliCod = obj13.getgxTv_SdtEmpresa_abm_1_Clicod() ;
      A1EmpCod = obj13.getgxTv_SdtEmpresa_abm_1_Empcod() ;
      Z3CliCod = obj13.getgxTv_SdtEmpresa_abm_1_Clicod_Z() ;
      Z1EmpCod = obj13.getgxTv_SdtEmpresa_abm_1_Empcod_Z() ;
      Z2EmpNom = obj13.getgxTv_SdtEmpresa_abm_1_Empnom_Z() ;
      Z177EmpCUIT = obj13.getgxTv_SdtEmpresa_abm_1_Empcuit_Z() ;
      Z178EmpDir = obj13.getgxTv_SdtEmpresa_abm_1_Empdir_Z() ;
      Z180EmpTel = obj13.getgxTv_SdtEmpresa_abm_1_Emptel_Z() ;
      Z176EmpCP = obj13.getgxTv_SdtEmpresa_abm_1_Empcp_Z() ;
      Z46PaiCod = obj13.getgxTv_SdtEmpresa_abm_1_Paicod_Z() ;
      Z312PaiNom = obj13.getgxTv_SdtEmpresa_abm_1_Painom_Z() ;
      Z47ProvCod = obj13.getgxTv_SdtEmpresa_abm_1_Provcod_Z() ;
      Z322ProvNom = obj13.getgxTv_SdtEmpresa_abm_1_Provnom_Z() ;
      Z1811EmpPerVacDes = obj13.getgxTv_SdtEmpresa_abm_1_Emppervacdes_Z() ;
      Z1812EmpPerVacHas = obj13.getgxTv_SdtEmpresa_abm_1_Emppervachas_Z() ;
      Z48LocCod = obj13.getgxTv_SdtEmpresa_abm_1_Loccod_Z() ;
      Z286LocNom = obj13.getgxTv_SdtEmpresa_abm_1_Locnom_Z() ;
      Z43ActCodigo = obj13.getgxTv_SdtEmpresa_abm_1_Actcodigo_Z() ;
      Z108ActDescrip = obj13.getgxTv_SdtEmpresa_abm_1_Actdescrip_Z() ;
      Z45TipEmpleCod = obj13.getgxTv_SdtEmpresa_abm_1_Tipemplecod_Z() ;
      Z1533EmpActComercial = obj13.getgxTv_SdtEmpresa_abm_1_Empactcomercial_Z() ;
      Z44EmpZonCod = obj13.getgxTv_SdtEmpresa_abm_1_Empzoncod_Z() ;
      Z518EmpZonDescrip = obj13.getgxTv_SdtEmpresa_abm_1_Empzondescrip_Z() ;
      Z532EmpReducc = obj13.getgxTv_SdtEmpresa_abm_1_Empreducc_Z() ;
      Z530TipEmpleDefIns = obj13.getgxTv_SdtEmpresa_abm_1_Tipempledefins_Z() ;
      Z956EmpLogoNom = obj13.getgxTv_SdtEmpresa_abm_1_Emplogonom_Z() ;
      Z957EmpLogoExt = obj13.getgxTv_SdtEmpresa_abm_1_Emplogoext_Z() ;
      Z959EmpFirmaNom = obj13.getgxTv_SdtEmpresa_abm_1_Empfirmanom_Z() ;
      Z960EmpFirmaExt = obj13.getgxTv_SdtEmpresa_abm_1_Empfirmaext_Z() ;
      Z1140EmpAntiguedad = obj13.getgxTv_SdtEmpresa_abm_1_Empantiguedad_Z() ;
      Z1141EmpPresentismo = obj13.getgxTv_SdtEmpresa_abm_1_Emppresentismo_Z() ;
      Z1302EmpMesHsPExt = obj13.getgxTv_SdtEmpresa_abm_1_Empmeshspext_Z() ;
      Z1524EmpLiqFer = obj13.getgxTv_SdtEmpresa_abm_1_Empliqfer_Z() ;
      Z1750EmpLiqFerJor = obj13.getgxTv_SdtEmpresa_abm_1_Empliqferjor_Z() ;
      Z1303EmpDiaHsPExt = obj13.getgxTv_SdtEmpresa_abm_1_Empdiahspext_Z() ;
      Z1151ARTSec = obj13.getgxTv_SdtEmpresa_abm_1_Artsec_Z() ;
      Z1556EmpGuarEdadMin = obj13.getgxTv_SdtEmpresa_abm_1_Empguaredadmin_Z() ;
      Z1557EmpGuarEdadMax = obj13.getgxTv_SdtEmpresa_abm_1_Empguaredadmax_Z() ;
      Z1787EmpLiqGan = obj13.getgxTv_SdtEmpresa_abm_1_Empliqgan_Z() ;
      Z1792EmpTipoExp = obj13.getgxTv_SdtEmpresa_abm_1_Emptipoexp_Z() ;
      Z1802EmpPromDesde = obj13.getgxTv_SdtEmpresa_abm_1_Emppromdesde_Z() ;
      Z1813EmpFracVacAnt = obj13.getgxTv_SdtEmpresa_abm_1_Empfracvacant_Z() ;
      Z2259EmpVacExpLim = obj13.getgxTv_SdtEmpresa_abm_1_Empvacexplim_Z() ;
      Z2260EmpVacExpTie = obj13.getgxTv_SdtEmpresa_abm_1_Empvacexptie_Z() ;
      Z2261EmpVacDisMax = obj13.getgxTv_SdtEmpresa_abm_1_Empvacdismax_Z() ;
      Z903ActComCodigo = obj13.getgxTv_SdtEmpresa_abm_1_Actcomcodigo_Z() ;
      Z1965EmpOsoCod = obj13.getgxTv_SdtEmpresa_abm_1_Emposocod_Z() ;
      Z2265EmpCondiCod = obj13.getgxTv_SdtEmpresa_abm_1_Empcondicod_Z() ;
      Z2405EmpModTra = obj13.getgxTv_SdtEmpresa_abm_1_Empmodtra_Z() ;
      Z2406EmpModEmpl = obj13.getgxTv_SdtEmpresa_abm_1_Empmodempl_Z() ;
      Z2407EmpModAuto = obj13.getgxTv_SdtEmpresa_abm_1_Empmodauto_Z() ;
      n180EmpTel = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Emptel_N()==0)?false:true) ;
      n176EmpCP = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Empcp_N()==0)?false:true) ;
      n46PaiCod = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Paicod_N()==0)?false:true) ;
      n47ProvCod = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Provcod_N()==0)?false:true) ;
      n48LocCod = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Loccod_N()==0)?false:true) ;
      n43ActCodigo = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Actcodigo_N()==0)?false:true) ;
      n45TipEmpleCod = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Tipemplecod_N()==0)?false:true) ;
      n44EmpZonCod = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Empzoncod_N()==0)?false:true) ;
      n955EmpLogo = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Emplogo_N()==0)?false:true) ;
      n956EmpLogoNom = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Emplogonom_N()==0)?false:true) ;
      n957EmpLogoExt = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Emplogoext_N()==0)?false:true) ;
      n958EmpFirma = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Empfirma_N()==0)?false:true) ;
      n959EmpFirmaNom = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Empfirmanom_N()==0)?false:true) ;
      n960EmpFirmaExt = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Empfirmaext_N()==0)?false:true) ;
      n1302EmpMesHsPExt = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Empmeshspext_N()==0)?false:true) ;
      n1303EmpDiaHsPExt = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Empdiahspext_N()==0)?false:true) ;
      n1965EmpOsoCod = (boolean)((obj13.getgxTv_SdtEmpresa_abm_1_Emposocod_N()==0)?false:true) ;
      Gx_mode = obj13.getgxTv_SdtEmpresa_abm_1_Mode() ;
   }

   public void VarsToRow171( web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados obj171 )
   {
      obj171.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode( Gx_mode );
      obj171.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual( A1370EmpMenHabitual );
      obj171.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo( A1368EmpMenConCodigo );
      obj171.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z( Z1368EmpMenConCodigo );
      obj171.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z( Z1370EmpMenHabitual );
      obj171.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified( nIsMod_171 );
   }

   public void KeyVarsToRow171( web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados obj171 )
   {
      obj171.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo( A1368EmpMenConCodigo );
   }

   public void RowToVars171( web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados obj171 ,
                             int forceLoad )
   {
      Gx_mode = obj171.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode() ;
      A1370EmpMenHabitual = obj171.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual() ;
      A1368EmpMenConCodigo = obj171.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo() ;
      Z1368EmpMenConCodigo = obj171.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z() ;
      Z1370EmpMenHabitual = obj171.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z() ;
      nIsMod_171 = obj171.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified() ;
   }

   public void VarsToRow172( web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados obj172 )
   {
      obj172.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode( Gx_mode );
      obj172.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual( A1369EmpJorHabitual );
      obj172.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo( A1366EmpJorConCodigo );
      obj172.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z( Z1366EmpJorConCodigo );
      obj172.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z( Z1369EmpJorHabitual );
      obj172.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified( nIsMod_172 );
   }

   public void KeyVarsToRow172( web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados obj172 )
   {
      obj172.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo( A1366EmpJorConCodigo );
   }

   public void RowToVars172( web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados obj172 ,
                             int forceLoad )
   {
      Gx_mode = obj172.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode() ;
      A1369EmpJorHabitual = obj172.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual() ;
      A1366EmpJorConCodigo = obj172.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo() ;
      Z1366EmpJorConCodigo = obj172.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z() ;
      Z1369EmpJorHabitual = obj172.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z() ;
      nIsMod_172 = obj172.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified() ;
   }

   public void VarsToRow173( web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados obj173 )
   {
      obj173.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode( Gx_mode );
      obj173.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual( A1372EmpPromHabitual );
      obj173.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod( A37TipoConCod );
      obj173.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar( A1371EmpPromFijVar );
      obj173.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z( Z37TipoConCod );
      obj173.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z( Z1371EmpPromFijVar );
      obj173.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z( Z1372EmpPromHabitual );
      obj173.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified( nIsMod_173 );
   }

   public void KeyVarsToRow173( web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados obj173 )
   {
      obj173.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod( A37TipoConCod );
      obj173.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar( A1371EmpPromFijVar );
   }

   public void RowToVars173( web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados obj173 ,
                             int forceLoad )
   {
      Gx_mode = obj173.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode() ;
      A1372EmpPromHabitual = obj173.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual() ;
      A37TipoConCod = obj173.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod() ;
      A1371EmpPromFijVar = obj173.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar() ;
      Z37TipoConCod = obj173.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z() ;
      Z1371EmpPromFijVar = obj173.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z() ;
      Z1372EmpPromHabitual = obj173.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z() ;
      nIsMod_173 = obj173.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified() ;
   }

   public void VarsToRow191( web.SdtEmpresa_abm_1_base_calculo obj191 )
   {
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Mode( Gx_mode );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus( A1432EmpBasePlus );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg( A1427EmpBaseClaseLeg );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo( A1429EmpBaseTipo );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1( A1430EmpBaseCod1 );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2( A1431EmpBaseCod2 );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z( Z1427EmpBaseClaseLeg );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z( Z1429EmpBaseTipo );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z( Z1430EmpBaseCod1 );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z( Z1431EmpBaseCod2 );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z( Z1432EmpBasePlus );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Modified( nIsMod_191 );
   }

   public void KeyVarsToRow191( web.SdtEmpresa_abm_1_base_calculo obj191 )
   {
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg( A1427EmpBaseClaseLeg );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo( A1429EmpBaseTipo );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1( A1430EmpBaseCod1 );
      obj191.setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2( A1431EmpBaseCod2 );
   }

   public void RowToVars191( web.SdtEmpresa_abm_1_base_calculo obj191 ,
                             int forceLoad )
   {
      Gx_mode = obj191.getgxTv_SdtEmpresa_abm_1_base_calculo_Mode() ;
      A1432EmpBasePlus = obj191.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus() ;
      A1427EmpBaseClaseLeg = obj191.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg() ;
      A1429EmpBaseTipo = obj191.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo() ;
      A1430EmpBaseCod1 = obj191.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1() ;
      A1431EmpBaseCod2 = obj191.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2() ;
      Z1427EmpBaseClaseLeg = obj191.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z() ;
      Z1429EmpBaseTipo = obj191.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z() ;
      Z1430EmpBaseCod1 = obj191.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z() ;
      Z1431EmpBaseCod2 = obj191.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z() ;
      Z1432EmpBasePlus = obj191.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z() ;
      nIsMod_191 = obj191.getgxTv_SdtEmpresa_abm_1_base_calculo_Modified() ;
   }

   public void VarsToRow165( web.SdtEmpresa_abm_1_horasextras_pordia obj165 )
   {
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Mode( Gx_mode );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiatiptra( A1339EmpHsPDiaTipTra );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiadia( A1341EmpHsPDiaDia );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiadesde( A1342EmpHsPDiaDesde );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emptarifapdia( A1343EmpTarifaPDia );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emptarfapdrec( A1351EmpTarfaPDRec );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphsexsec( A1340EmpHsExSec );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphsexsec_Z( Z1340EmpHsExSec );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiatiptra_Z( Z1339EmpHsPDiaTipTra );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiadia_Z( Z1341EmpHsPDiaDia );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiadesde_Z( Z1342EmpHsPDiaDesde );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emptarifapdia_Z( Z1343EmpTarifaPDia );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emptarfapdrec_Z( Z1351EmpTarfaPDRec );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiadesde_N( (byte)((byte)((n1342EmpHsPDiaDesde)?1:0)) );
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Modified( nIsMod_165 );
   }

   public void KeyVarsToRow165( web.SdtEmpresa_abm_1_horasextras_pordia obj165 )
   {
      obj165.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphsexsec( A1340EmpHsExSec );
   }

   public void RowToVars165( web.SdtEmpresa_abm_1_horasextras_pordia obj165 ,
                             int forceLoad )
   {
      Gx_mode = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Mode() ;
      A1339EmpHsPDiaTipTra = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiatiptra() ;
      A1341EmpHsPDiaDia = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiadia() ;
      A1342EmpHsPDiaDesde = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiadesde() ;
      n1342EmpHsPDiaDesde = false ;
      A1343EmpTarifaPDia = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emptarifapdia() ;
      A1351EmpTarfaPDRec = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emptarfapdrec() ;
      A1340EmpHsExSec = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphsexsec() ;
      Z1340EmpHsExSec = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphsexsec_Z() ;
      Z1339EmpHsPDiaTipTra = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiatiptra_Z() ;
      Z1341EmpHsPDiaDia = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiadia_Z() ;
      Z1342EmpHsPDiaDesde = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiadesde_Z() ;
      Z1343EmpTarifaPDia = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emptarifapdia_Z() ;
      Z1351EmpTarfaPDRec = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emptarfapdrec_Z() ;
      n1342EmpHsPDiaDesde = (boolean)((obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphspdiadesde_N()==0)?false:true) ;
      nIsMod_165 = obj165.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Modified() ;
   }

   public void VarsToRow166( web.SdtEmpresa_abm_1_tipo_trabajo obj166 )
   {
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Mode( Gx_mode );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsdia( A1344EmpHsDia );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphssem( A1345EmpHsSem );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emptarifaxlim( A1346EmpTarifaXLim );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emptarifarec( A1352EmpTarifaRec );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxdia( A1386EmpHsMaxDia );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxsem( A1387EmpHsMaxSem );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxmes( A1388EmpHsMaxMes );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxanu( A1389EmpHsMaxAnu );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Paitipotraid( A1294PaiTipoTraId );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Paitipotraid_Z( Z1294PaiTipoTraId );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsdia_Z( Z1344EmpHsDia );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphssem_Z( Z1345EmpHsSem );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emptarifaxlim_Z( Z1346EmpTarifaXLim );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emptarifarec_Z( Z1352EmpTarifaRec );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxdia_Z( Z1386EmpHsMaxDia );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxsem_Z( Z1387EmpHsMaxSem );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxmes_Z( Z1388EmpHsMaxMes );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxanu_Z( Z1389EmpHsMaxAnu );
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Modified( nIsMod_166 );
   }

   public void KeyVarsToRow166( web.SdtEmpresa_abm_1_tipo_trabajo obj166 )
   {
      obj166.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Paitipotraid( A1294PaiTipoTraId );
   }

   public void RowToVars166( web.SdtEmpresa_abm_1_tipo_trabajo obj166 ,
                             int forceLoad )
   {
      Gx_mode = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Mode() ;
      A1344EmpHsDia = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsdia() ;
      A1345EmpHsSem = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphssem() ;
      A1346EmpTarifaXLim = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emptarifaxlim() ;
      A1352EmpTarifaRec = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emptarifarec() ;
      A1386EmpHsMaxDia = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxdia() ;
      A1387EmpHsMaxSem = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxsem() ;
      A1388EmpHsMaxMes = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxmes() ;
      A1389EmpHsMaxAnu = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxanu() ;
      A1294PaiTipoTraId = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Paitipotraid() ;
      Z1294PaiTipoTraId = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Paitipotraid_Z() ;
      Z1344EmpHsDia = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsdia_Z() ;
      Z1345EmpHsSem = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphssem_Z() ;
      Z1346EmpTarifaXLim = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emptarifaxlim_Z() ;
      Z1352EmpTarifaRec = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emptarifarec_Z() ;
      Z1386EmpHsMaxDia = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxdia_Z() ;
      Z1387EmpHsMaxSem = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxsem_Z() ;
      Z1388EmpHsMaxMes = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxmes_Z() ;
      Z1389EmpHsMaxAnu = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Emphsmaxanu_Z() ;
      nIsMod_166 = obj166.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Modified() ;
   }

   public void VarsToRow144( web.SdtEmpresa_abm_1_nolaborables_convenio obj144 )
   {
      obj144.setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode( Gx_mode );
      obj144.setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio( A1239EmpConvenio );
      obj144.setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z( Z1239EmpConvenio );
      obj144.setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified( nIsMod_144 );
   }

   public void KeyVarsToRow144( web.SdtEmpresa_abm_1_nolaborables_convenio obj144 )
   {
      obj144.setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio( A1239EmpConvenio );
   }

   public void RowToVars144( web.SdtEmpresa_abm_1_nolaborables_convenio obj144 ,
                             int forceLoad )
   {
      Gx_mode = obj144.getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode() ;
      A1239EmpConvenio = obj144.getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio() ;
      Z1239EmpConvenio = obj144.getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z() ;
      nIsMod_144 = obj144.getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified() ;
   }

   public void VarsToRow145( web.SdtEmpresa_abm_1_nolaborables_origen obj145 )
   {
      obj145.setgxTv_SdtEmpresa_abm_1_nolaborables_origen_Mode( Gx_mode );
      obj145.setgxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen( A1238EmpOrigen );
      obj145.setgxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen_Z( Z1238EmpOrigen );
      obj145.setgxTv_SdtEmpresa_abm_1_nolaborables_origen_Modified( nIsMod_145 );
   }

   public void KeyVarsToRow145( web.SdtEmpresa_abm_1_nolaborables_origen obj145 )
   {
      obj145.setgxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen( A1238EmpOrigen );
   }

   public void RowToVars145( web.SdtEmpresa_abm_1_nolaborables_origen obj145 ,
                             int forceLoad )
   {
      Gx_mode = obj145.getgxTv_SdtEmpresa_abm_1_nolaborables_origen_Mode() ;
      A1238EmpOrigen = obj145.getgxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen() ;
      Z1238EmpOrigen = obj145.getgxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen_Z() ;
      nIsMod_145 = obj145.getgxTv_SdtEmpresa_abm_1_nolaborables_origen_Modified() ;
   }

   public void VarsToRow146( web.SdtEmpresa_abm_1_nolaborables_religion obj146 )
   {
      obj146.setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode( Gx_mode );
      obj146.setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion( A1237EmpReligion );
      obj146.setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z( Z1237EmpReligion );
      obj146.setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified( nIsMod_146 );
   }

   public void KeyVarsToRow146( web.SdtEmpresa_abm_1_nolaborables_religion obj146 )
   {
      obj146.setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion( A1237EmpReligion );
   }

   public void RowToVars146( web.SdtEmpresa_abm_1_nolaborables_religion obj146 ,
                             int forceLoad )
   {
      Gx_mode = obj146.getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode() ;
      A1237EmpReligion = obj146.getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion() ;
      Z1237EmpReligion = obj146.getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z() ;
      nIsMod_146 = obj146.getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey4513( ) ;
      scanKeyStart4513( ) ;
      if ( RcdFound13 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC0045226 */
         pr_default.execute(224, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(224) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(224);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
      }
      zm4513( -16) ;
      onLoadActions4513( ) ;
      addRow4513( ) ;
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45171( ) ;
         nGXsfl_171_idx = 1 ;
         while ( RcdFound171 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1368EmpMenConCodigo = A1368EmpMenConCodigo ;
            zm45171( -29) ;
            onLoadActions45171( ) ;
            nRcdExists_171 = (short)(1) ;
            nIsMod_171 = (short)(0) ;
            addRow45171( ) ;
            nGXsfl_171_idx = (int)(nGXsfl_171_idx+1) ;
            scanKeyNext45171( ) ;
         }
         scanKeyEnd45171( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45172( ) ;
         nGXsfl_172_idx = 1 ;
         while ( RcdFound172 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1366EmpJorConCodigo = A1366EmpJorConCodigo ;
            zm45172( -31) ;
            onLoadActions45172( ) ;
            nRcdExists_172 = (short)(1) ;
            nIsMod_172 = (short)(0) ;
            addRow45172( ) ;
            nGXsfl_172_idx = (int)(nGXsfl_172_idx+1) ;
            scanKeyNext45172( ) ;
         }
         scanKeyEnd45172( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45173( ) ;
         nGXsfl_173_idx = 1 ;
         while ( RcdFound173 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z37TipoConCod = A37TipoConCod ;
            Z1371EmpPromFijVar = A1371EmpPromFijVar ;
            zm45173( -33) ;
            onLoadActions45173( ) ;
            nRcdExists_173 = (short)(1) ;
            nIsMod_173 = (short)(0) ;
            addRow45173( ) ;
            nGXsfl_173_idx = (int)(nGXsfl_173_idx+1) ;
            scanKeyNext45173( ) ;
         }
         scanKeyEnd45173( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Base_calculo().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45191( ) ;
         nGXsfl_191_idx = 1 ;
         while ( RcdFound191 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1427EmpBaseClaseLeg = A1427EmpBaseClaseLeg ;
            Z1429EmpBaseTipo = A1429EmpBaseTipo ;
            Z1430EmpBaseCod1 = A1430EmpBaseCod1 ;
            Z1431EmpBaseCod2 = A1431EmpBaseCod2 ;
            zm45191( -35) ;
            onLoadActions45191( ) ;
            nRcdExists_191 = (short)(1) ;
            nIsMod_191 = (short)(0) ;
            addRow45191( ) ;
            nGXsfl_191_idx = (int)(nGXsfl_191_idx+1) ;
            scanKeyNext45191( ) ;
         }
         scanKeyEnd45191( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Horasextras_pordia().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45165( ) ;
         nGXsfl_165_idx = 1 ;
         while ( RcdFound165 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1340EmpHsExSec = A1340EmpHsExSec ;
            zm45165( -36) ;
            onLoadActions45165( ) ;
            nRcdExists_165 = (short)(1) ;
            nIsMod_165 = (short)(0) ;
            addRow45165( ) ;
            nGXsfl_165_idx = (int)(nGXsfl_165_idx+1) ;
            scanKeyNext45165( ) ;
         }
         scanKeyEnd45165( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipo_trabajo().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45166( ) ;
         nGXsfl_166_idx = 1 ;
         while ( RcdFound166 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1294PaiTipoTraId = A1294PaiTipoTraId ;
            zm45166( -38) ;
            onLoadActions45166( ) ;
            nRcdExists_166 = (short)(1) ;
            nIsMod_166 = (short)(0) ;
            addRow45166( ) ;
            nGXsfl_166_idx = (int)(nGXsfl_166_idx+1) ;
            scanKeyNext45166( ) ;
         }
         scanKeyEnd45166( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45144( ) ;
         nGXsfl_144_idx = 1 ;
         while ( RcdFound144 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1239EmpConvenio = A1239EmpConvenio ;
            zm45144( -40) ;
            onLoadActions45144( ) ;
            nRcdExists_144 = (short)(1) ;
            nIsMod_144 = (short)(0) ;
            addRow45144( ) ;
            nGXsfl_144_idx = (int)(nGXsfl_144_idx+1) ;
            scanKeyNext45144( ) ;
         }
         scanKeyEnd45144( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_origen().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45145( ) ;
         nGXsfl_145_idx = 1 ;
         while ( RcdFound145 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1238EmpOrigen = A1238EmpOrigen ;
            zm45145( -41) ;
            onLoadActions45145( ) ;
            nRcdExists_145 = (short)(1) ;
            nIsMod_145 = (short)(0) ;
            addRow45145( ) ;
            nGXsfl_145_idx = (int)(nGXsfl_145_idx+1) ;
            scanKeyNext45145( ) ;
         }
         scanKeyEnd45145( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_religion().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45146( ) ;
         nGXsfl_146_idx = 1 ;
         while ( RcdFound146 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1237EmpReligion = A1237EmpReligion ;
            zm45146( -43) ;
            onLoadActions45146( ) ;
            nRcdExists_146 = (short)(1) ;
            nIsMod_146 = (short)(0) ;
            addRow45146( ) ;
            nGXsfl_146_idx = (int)(nGXsfl_146_idx+1) ;
            scanKeyNext45146( ) ;
         }
         scanKeyEnd45146( ) ;
      }
      scanKeyEnd4513( ) ;
      if ( RcdFound13 == 0 )
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
      RowToVars13( bcEmpresa_abm_1, 0) ;
      scanKeyStart4513( ) ;
      if ( RcdFound13 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC0045227 */
         pr_default.execute(225, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(225) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(225);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
      }
      zm4513( -16) ;
      onLoadActions4513( ) ;
      addRow4513( ) ;
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45171( ) ;
         nGXsfl_171_idx = 1 ;
         while ( RcdFound171 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1368EmpMenConCodigo = A1368EmpMenConCodigo ;
            zm45171( -29) ;
            onLoadActions45171( ) ;
            nRcdExists_171 = (short)(1) ;
            nIsMod_171 = (short)(0) ;
            addRow45171( ) ;
            nGXsfl_171_idx = (int)(nGXsfl_171_idx+1) ;
            scanKeyNext45171( ) ;
         }
         scanKeyEnd45171( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45172( ) ;
         nGXsfl_172_idx = 1 ;
         while ( RcdFound172 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1366EmpJorConCodigo = A1366EmpJorConCodigo ;
            zm45172( -31) ;
            onLoadActions45172( ) ;
            nRcdExists_172 = (short)(1) ;
            nIsMod_172 = (short)(0) ;
            addRow45172( ) ;
            nGXsfl_172_idx = (int)(nGXsfl_172_idx+1) ;
            scanKeyNext45172( ) ;
         }
         scanKeyEnd45172( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45173( ) ;
         nGXsfl_173_idx = 1 ;
         while ( RcdFound173 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z37TipoConCod = A37TipoConCod ;
            Z1371EmpPromFijVar = A1371EmpPromFijVar ;
            zm45173( -33) ;
            onLoadActions45173( ) ;
            nRcdExists_173 = (short)(1) ;
            nIsMod_173 = (short)(0) ;
            addRow45173( ) ;
            nGXsfl_173_idx = (int)(nGXsfl_173_idx+1) ;
            scanKeyNext45173( ) ;
         }
         scanKeyEnd45173( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Base_calculo().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45191( ) ;
         nGXsfl_191_idx = 1 ;
         while ( RcdFound191 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1427EmpBaseClaseLeg = A1427EmpBaseClaseLeg ;
            Z1429EmpBaseTipo = A1429EmpBaseTipo ;
            Z1430EmpBaseCod1 = A1430EmpBaseCod1 ;
            Z1431EmpBaseCod2 = A1431EmpBaseCod2 ;
            zm45191( -35) ;
            onLoadActions45191( ) ;
            nRcdExists_191 = (short)(1) ;
            nIsMod_191 = (short)(0) ;
            addRow45191( ) ;
            nGXsfl_191_idx = (int)(nGXsfl_191_idx+1) ;
            scanKeyNext45191( ) ;
         }
         scanKeyEnd45191( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Horasextras_pordia().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45165( ) ;
         nGXsfl_165_idx = 1 ;
         while ( RcdFound165 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1340EmpHsExSec = A1340EmpHsExSec ;
            zm45165( -36) ;
            onLoadActions45165( ) ;
            nRcdExists_165 = (short)(1) ;
            nIsMod_165 = (short)(0) ;
            addRow45165( ) ;
            nGXsfl_165_idx = (int)(nGXsfl_165_idx+1) ;
            scanKeyNext45165( ) ;
         }
         scanKeyEnd45165( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipo_trabajo().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45166( ) ;
         nGXsfl_166_idx = 1 ;
         while ( RcdFound166 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1294PaiTipoTraId = A1294PaiTipoTraId ;
            zm45166( -38) ;
            onLoadActions45166( ) ;
            nRcdExists_166 = (short)(1) ;
            nIsMod_166 = (short)(0) ;
            addRow45166( ) ;
            nGXsfl_166_idx = (int)(nGXsfl_166_idx+1) ;
            scanKeyNext45166( ) ;
         }
         scanKeyEnd45166( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45144( ) ;
         nGXsfl_144_idx = 1 ;
         while ( RcdFound144 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1239EmpConvenio = A1239EmpConvenio ;
            zm45144( -40) ;
            onLoadActions45144( ) ;
            nRcdExists_144 = (short)(1) ;
            nIsMod_144 = (short)(0) ;
            addRow45144( ) ;
            nGXsfl_144_idx = (int)(nGXsfl_144_idx+1) ;
            scanKeyNext45144( ) ;
         }
         scanKeyEnd45144( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_origen().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45145( ) ;
         nGXsfl_145_idx = 1 ;
         while ( RcdFound145 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1238EmpOrigen = A1238EmpOrigen ;
            zm45145( -41) ;
            onLoadActions45145( ) ;
            nRcdExists_145 = (short)(1) ;
            nIsMod_145 = (short)(0) ;
            addRow45145( ) ;
            nGXsfl_145_idx = (int)(nGXsfl_145_idx+1) ;
            scanKeyNext45145( ) ;
         }
         scanKeyEnd45145( ) ;
      }
      bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Nolaborables_religion().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart45146( ) ;
         nGXsfl_146_idx = 1 ;
         while ( RcdFound146 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1237EmpReligion = A1237EmpReligion ;
            zm45146( -43) ;
            onLoadActions45146( ) ;
            nRcdExists_146 = (short)(1) ;
            nIsMod_146 = (short)(0) ;
            addRow45146( ) ;
            nGXsfl_146_idx = (int)(nGXsfl_146_idx+1) ;
            scanKeyNext45146( ) ;
         }
         scanKeyEnd45146( ) ;
      }
      scanKeyEnd4513( ) ;
      if ( RcdFound13 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4513( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert4513( ) ;
      }
      else
      {
         if ( RcdFound13 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
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
               update4513( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) )
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
                     insert4513( ) ;
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
                     insert4513( ) ;
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
      RowToVars13( bcEmpresa_abm_1, 1) ;
      saveImpl( ) ;
      VarsToRow13( bcEmpresa_abm_1) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars13( bcEmpresa_abm_1, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert4513( ) ;
      afterTrn( ) ;
      VarsToRow13( bcEmpresa_abm_1) ;
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
         web.SdtEmpresa_abm_1 auxBC = new web.SdtEmpresa_abm_1( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcEmpresa_abm_1);
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
      RowToVars13( bcEmpresa_abm_1, 1) ;
      updateImpl( ) ;
      VarsToRow13( bcEmpresa_abm_1) ;
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
      RowToVars13( bcEmpresa_abm_1, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert4513( ) ;
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
      VarsToRow13( bcEmpresa_abm_1) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars13( bcEmpresa_abm_1, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey4513( ) ;
      if ( RcdFound13 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "empresa_abm_1_bc");
      VarsToRow13( bcEmpresa_abm_1) ;
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
      Gx_mode = bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcEmpresa_abm_1.setgxTv_SdtEmpresa_abm_1_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtEmpresa_abm_1 sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcEmpresa_abm_1 )
      {
         bcEmpresa_abm_1 = sdt ;
         if ( GXutil.strcmp(bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Mode(), "") == 0 )
         {
            bcEmpresa_abm_1.setgxTv_SdtEmpresa_abm_1_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow13( bcEmpresa_abm_1) ;
         }
         else
         {
            RowToVars13( bcEmpresa_abm_1, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcEmpresa_abm_1.getgxTv_SdtEmpresa_abm_1_Mode(), "") == 0 )
         {
            bcEmpresa_abm_1.setgxTv_SdtEmpresa_abm_1_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars13( bcEmpresa_abm_1, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtEmpresa_abm_1 getEmpresa_abm_1_BC( )
   {
      return bcEmpresa_abm_1 ;
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
      sMode13 = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV71Pgmname = "" ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV15TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14Insert_ActCodigo = "" ;
      AV40Insert_TipEmpleCod = "" ;
      AV64Insert_EmpActComercial = "" ;
      AV36Insert_EmpZonCod = "" ;
      AV43Insert_ActComCodigo = "" ;
      AV69Insert_EmpOsoCod = "" ;
      Z2EmpNom = "" ;
      A2EmpNom = "" ;
      Z178EmpDir = "" ;
      A178EmpDir = "" ;
      Z180EmpTel = "" ;
      A180EmpTel = "" ;
      Z176EmpCP = "" ;
      A176EmpCP = "" ;
      Z1140EmpAntiguedad = DecimalUtil.ZERO ;
      A1140EmpAntiguedad = DecimalUtil.ZERO ;
      Z1141EmpPresentismo = DecimalUtil.ZERO ;
      A1141EmpPresentismo = DecimalUtil.ZERO ;
      Z1302EmpMesHsPExt = DecimalUtil.ZERO ;
      A1302EmpMesHsPExt = DecimalUtil.ZERO ;
      Z1303EmpDiaHsPExt = "" ;
      A1303EmpDiaHsPExt = "" ;
      Z1802EmpPromDesde = "" ;
      A1802EmpPromDesde = "" ;
      Z1813EmpFracVacAnt = DecimalUtil.ZERO ;
      A1813EmpFracVacAnt = DecimalUtil.ZERO ;
      Z2405EmpModTra = "" ;
      A2405EmpModTra = "" ;
      Z43ActCodigo = "" ;
      A43ActCodigo = "" ;
      Z45TipEmpleCod = "" ;
      A45TipEmpleCod = "" ;
      Z903ActComCodigo = "" ;
      A903ActComCodigo = "" ;
      Z1965EmpOsoCod = "" ;
      A1965EmpOsoCod = "" ;
      Z1533EmpActComercial = "" ;
      A1533EmpActComercial = "" ;
      Z44EmpZonCod = "" ;
      A44EmpZonCod = "" ;
      Z312PaiNom = "" ;
      A312PaiNom = "" ;
      Z322ProvNom = "" ;
      A322ProvNom = "" ;
      Z286LocNom = "" ;
      A286LocNom = "" ;
      Z683ActDescripSinAc = "" ;
      A683ActDescripSinAc = "" ;
      Z108ActDescrip = "" ;
      A108ActDescrip = "" ;
      Z530TipEmpleDefIns = "" ;
      A530TipEmpleDefIns = "" ;
      Z518EmpZonDescrip = "" ;
      A518EmpZonDescrip = "" ;
      Z955EmpLogo = "" ;
      A955EmpLogo = "" ;
      Z958EmpFirma = "" ;
      A958EmpFirma = "" ;
      Z957EmpLogoExt = "" ;
      A957EmpLogoExt = "" ;
      Z960EmpFirmaExt = "" ;
      A960EmpFirmaExt = "" ;
      Z956EmpLogoNom = "" ;
      A956EmpLogoNom = "" ;
      Z959EmpFirmaNom = "" ;
      A959EmpFirmaNom = "" ;
      BC004541_A683ActDescripSinAc = new String[] {""} ;
      BC004541_A1EmpCod = new short[1] ;
      BC004541_A2EmpNom = new String[] {""} ;
      BC004541_A177EmpCUIT = new long[1] ;
      BC004541_A178EmpDir = new String[] {""} ;
      BC004541_A180EmpTel = new String[] {""} ;
      BC004541_n180EmpTel = new boolean[] {false} ;
      BC004541_A176EmpCP = new String[] {""} ;
      BC004541_n176EmpCP = new boolean[] {false} ;
      BC004541_A312PaiNom = new String[] {""} ;
      BC004541_A322ProvNom = new String[] {""} ;
      BC004541_A1811EmpPerVacDes = new byte[1] ;
      BC004541_A1812EmpPerVacHas = new byte[1] ;
      BC004541_A286LocNom = new String[] {""} ;
      BC004541_A108ActDescrip = new String[] {""} ;
      BC004541_A518EmpZonDescrip = new String[] {""} ;
      BC004541_A532EmpReducc = new boolean[] {false} ;
      BC004541_A530TipEmpleDefIns = new String[] {""} ;
      BC004541_A955EmpLogo = new String[] {""} ;
      BC004541_n955EmpLogo = new boolean[] {false} ;
      BC004541_A958EmpFirma = new String[] {""} ;
      BC004541_n958EmpFirma = new boolean[] {false} ;
      BC004541_A1140EmpAntiguedad = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004541_A1141EmpPresentismo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004541_A1302EmpMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004541_n1302EmpMesHsPExt = new boolean[] {false} ;
      BC004541_A1524EmpLiqFer = new boolean[] {false} ;
      BC004541_A1750EmpLiqFerJor = new boolean[] {false} ;
      BC004541_A1303EmpDiaHsPExt = new String[] {""} ;
      BC004541_n1303EmpDiaHsPExt = new boolean[] {false} ;
      BC004541_A1556EmpGuarEdadMin = new byte[1] ;
      BC004541_A1557EmpGuarEdadMax = new byte[1] ;
      BC004541_A1787EmpLiqGan = new boolean[] {false} ;
      BC004541_A1792EmpTipoExp = new byte[1] ;
      BC004541_A1802EmpPromDesde = new String[] {""} ;
      BC004541_A1813EmpFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004541_A2259EmpVacExpLim = new boolean[] {false} ;
      BC004541_A2260EmpVacExpTie = new byte[1] ;
      BC004541_A2261EmpVacDisMax = new int[1] ;
      BC004541_A2405EmpModTra = new String[] {""} ;
      BC004541_A2406EmpModEmpl = new boolean[] {false} ;
      BC004541_A2407EmpModAuto = new boolean[] {false} ;
      BC004541_A957EmpLogoExt = new String[] {""} ;
      BC004541_n957EmpLogoExt = new boolean[] {false} ;
      BC004541_A960EmpFirmaExt = new String[] {""} ;
      BC004541_n960EmpFirmaExt = new boolean[] {false} ;
      BC004541_A956EmpLogoNom = new String[] {""} ;
      BC004541_n956EmpLogoNom = new boolean[] {false} ;
      BC004541_A959EmpFirmaNom = new String[] {""} ;
      BC004541_n959EmpFirmaNom = new boolean[] {false} ;
      BC004541_A46PaiCod = new short[1] ;
      BC004541_n46PaiCod = new boolean[] {false} ;
      BC004541_A47ProvCod = new short[1] ;
      BC004541_n47ProvCod = new boolean[] {false} ;
      BC004541_A48LocCod = new short[1] ;
      BC004541_n48LocCod = new boolean[] {false} ;
      BC004541_A3CliCod = new int[1] ;
      BC004541_A43ActCodigo = new String[] {""} ;
      BC004541_n43ActCodigo = new boolean[] {false} ;
      BC004541_A45TipEmpleCod = new String[] {""} ;
      BC004541_n45TipEmpleCod = new boolean[] {false} ;
      BC004541_A1151ARTSec = new short[1] ;
      BC004541_A903ActComCodigo = new String[] {""} ;
      BC004541_A1965EmpOsoCod = new String[] {""} ;
      BC004541_n1965EmpOsoCod = new boolean[] {false} ;
      BC004541_A1533EmpActComercial = new String[] {""} ;
      BC004541_A44EmpZonCod = new String[] {""} ;
      BC004541_n44EmpZonCod = new boolean[] {false} ;
      BC004541_A2265EmpCondiCod = new short[1] ;
      A955EmpLogo_Filetype = "" ;
      A958EmpFirma_Filetype = "" ;
      A955EmpLogo_Filename = "" ;
      A958EmpFirma_Filename = "" ;
      BC004542_A3CliCod = new int[1] ;
      BC004543_A3CliCod = new int[1] ;
      BC004544_A312PaiNom = new String[] {""} ;
      BC004545_A322ProvNom = new String[] {""} ;
      BC004546_A286LocNom = new String[] {""} ;
      BC004547_A683ActDescripSinAc = new String[] {""} ;
      BC004547_A108ActDescrip = new String[] {""} ;
      BC004548_A530TipEmpleDefIns = new String[] {""} ;
      BC004549_A1533EmpActComercial = new String[] {""} ;
      BC004550_A518EmpZonDescrip = new String[] {""} ;
      BC004551_A1151ARTSec = new short[1] ;
      BC004552_A903ActComCodigo = new String[] {""} ;
      BC004553_A2265EmpCondiCod = new short[1] ;
      BC004554_A3CliCod = new int[1] ;
      BC004554_A1EmpCod = new short[1] ;
      BC004555_A1EmpCod = new short[1] ;
      BC004555_A2EmpNom = new String[] {""} ;
      BC004555_A177EmpCUIT = new long[1] ;
      BC004555_A178EmpDir = new String[] {""} ;
      BC004555_A180EmpTel = new String[] {""} ;
      BC004555_n180EmpTel = new boolean[] {false} ;
      BC004555_A176EmpCP = new String[] {""} ;
      BC004555_n176EmpCP = new boolean[] {false} ;
      BC004555_A1811EmpPerVacDes = new byte[1] ;
      BC004555_A1812EmpPerVacHas = new byte[1] ;
      BC004555_A532EmpReducc = new boolean[] {false} ;
      BC004555_A955EmpLogo = new String[] {""} ;
      BC004555_n955EmpLogo = new boolean[] {false} ;
      BC004555_A958EmpFirma = new String[] {""} ;
      BC004555_n958EmpFirma = new boolean[] {false} ;
      BC004555_A1140EmpAntiguedad = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004555_A1141EmpPresentismo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004555_A1302EmpMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004555_n1302EmpMesHsPExt = new boolean[] {false} ;
      BC004555_A1524EmpLiqFer = new boolean[] {false} ;
      BC004555_A1750EmpLiqFerJor = new boolean[] {false} ;
      BC004555_A1303EmpDiaHsPExt = new String[] {""} ;
      BC004555_n1303EmpDiaHsPExt = new boolean[] {false} ;
      BC004555_A1556EmpGuarEdadMin = new byte[1] ;
      BC004555_A1557EmpGuarEdadMax = new byte[1] ;
      BC004555_A1787EmpLiqGan = new boolean[] {false} ;
      BC004555_A1792EmpTipoExp = new byte[1] ;
      BC004555_A1802EmpPromDesde = new String[] {""} ;
      BC004555_A1813EmpFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004555_A2259EmpVacExpLim = new boolean[] {false} ;
      BC004555_A2260EmpVacExpTie = new byte[1] ;
      BC004555_A2261EmpVacDisMax = new int[1] ;
      BC004555_A2405EmpModTra = new String[] {""} ;
      BC004555_A2406EmpModEmpl = new boolean[] {false} ;
      BC004555_A2407EmpModAuto = new boolean[] {false} ;
      BC004555_A957EmpLogoExt = new String[] {""} ;
      BC004555_n957EmpLogoExt = new boolean[] {false} ;
      BC004555_A960EmpFirmaExt = new String[] {""} ;
      BC004555_n960EmpFirmaExt = new boolean[] {false} ;
      BC004555_A956EmpLogoNom = new String[] {""} ;
      BC004555_n956EmpLogoNom = new boolean[] {false} ;
      BC004555_A959EmpFirmaNom = new String[] {""} ;
      BC004555_n959EmpFirmaNom = new boolean[] {false} ;
      BC004555_A46PaiCod = new short[1] ;
      BC004555_n46PaiCod = new boolean[] {false} ;
      BC004555_A47ProvCod = new short[1] ;
      BC004555_n47ProvCod = new boolean[] {false} ;
      BC004555_A48LocCod = new short[1] ;
      BC004555_n48LocCod = new boolean[] {false} ;
      BC004555_A3CliCod = new int[1] ;
      BC004555_A43ActCodigo = new String[] {""} ;
      BC004555_n43ActCodigo = new boolean[] {false} ;
      BC004555_A45TipEmpleCod = new String[] {""} ;
      BC004555_n45TipEmpleCod = new boolean[] {false} ;
      BC004555_A1151ARTSec = new short[1] ;
      BC004555_A903ActComCodigo = new String[] {""} ;
      BC004555_A1965EmpOsoCod = new String[] {""} ;
      BC004555_n1965EmpOsoCod = new boolean[] {false} ;
      BC004555_A1533EmpActComercial = new String[] {""} ;
      BC004555_A44EmpZonCod = new String[] {""} ;
      BC004555_n44EmpZonCod = new boolean[] {false} ;
      BC004555_A2265EmpCondiCod = new short[1] ;
      BC004556_A1EmpCod = new short[1] ;
      BC004556_A2EmpNom = new String[] {""} ;
      BC004556_A177EmpCUIT = new long[1] ;
      BC004556_A178EmpDir = new String[] {""} ;
      BC004556_A180EmpTel = new String[] {""} ;
      BC004556_n180EmpTel = new boolean[] {false} ;
      BC004556_A176EmpCP = new String[] {""} ;
      BC004556_n176EmpCP = new boolean[] {false} ;
      BC004556_A1811EmpPerVacDes = new byte[1] ;
      BC004556_A1812EmpPerVacHas = new byte[1] ;
      BC004556_A532EmpReducc = new boolean[] {false} ;
      BC004556_A955EmpLogo = new String[] {""} ;
      BC004556_n955EmpLogo = new boolean[] {false} ;
      BC004556_A958EmpFirma = new String[] {""} ;
      BC004556_n958EmpFirma = new boolean[] {false} ;
      BC004556_A1140EmpAntiguedad = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004556_A1141EmpPresentismo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004556_A1302EmpMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004556_n1302EmpMesHsPExt = new boolean[] {false} ;
      BC004556_A1524EmpLiqFer = new boolean[] {false} ;
      BC004556_A1750EmpLiqFerJor = new boolean[] {false} ;
      BC004556_A1303EmpDiaHsPExt = new String[] {""} ;
      BC004556_n1303EmpDiaHsPExt = new boolean[] {false} ;
      BC004556_A1556EmpGuarEdadMin = new byte[1] ;
      BC004556_A1557EmpGuarEdadMax = new byte[1] ;
      BC004556_A1787EmpLiqGan = new boolean[] {false} ;
      BC004556_A1792EmpTipoExp = new byte[1] ;
      BC004556_A1802EmpPromDesde = new String[] {""} ;
      BC004556_A1813EmpFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004556_A2259EmpVacExpLim = new boolean[] {false} ;
      BC004556_A2260EmpVacExpTie = new byte[1] ;
      BC004556_A2261EmpVacDisMax = new int[1] ;
      BC004556_A2405EmpModTra = new String[] {""} ;
      BC004556_A2406EmpModEmpl = new boolean[] {false} ;
      BC004556_A2407EmpModAuto = new boolean[] {false} ;
      BC004556_A957EmpLogoExt = new String[] {""} ;
      BC004556_n957EmpLogoExt = new boolean[] {false} ;
      BC004556_A960EmpFirmaExt = new String[] {""} ;
      BC004556_n960EmpFirmaExt = new boolean[] {false} ;
      BC004556_A956EmpLogoNom = new String[] {""} ;
      BC004556_n956EmpLogoNom = new boolean[] {false} ;
      BC004556_A959EmpFirmaNom = new String[] {""} ;
      BC004556_n959EmpFirmaNom = new boolean[] {false} ;
      BC004556_A46PaiCod = new short[1] ;
      BC004556_n46PaiCod = new boolean[] {false} ;
      BC004556_A47ProvCod = new short[1] ;
      BC004556_n47ProvCod = new boolean[] {false} ;
      BC004556_A48LocCod = new short[1] ;
      BC004556_n48LocCod = new boolean[] {false} ;
      BC004556_A3CliCod = new int[1] ;
      BC004556_A43ActCodigo = new String[] {""} ;
      BC004556_n43ActCodigo = new boolean[] {false} ;
      BC004556_A45TipEmpleCod = new String[] {""} ;
      BC004556_n45TipEmpleCod = new boolean[] {false} ;
      BC004556_A1151ARTSec = new short[1] ;
      BC004556_A903ActComCodigo = new String[] {""} ;
      BC004556_A1965EmpOsoCod = new String[] {""} ;
      BC004556_n1965EmpOsoCod = new boolean[] {false} ;
      BC004556_A1533EmpActComercial = new String[] {""} ;
      BC004556_A44EmpZonCod = new String[] {""} ;
      BC004556_n44EmpZonCod = new boolean[] {false} ;
      BC004556_A2265EmpCondiCod = new short[1] ;
      BC004562_A312PaiNom = new String[] {""} ;
      BC004563_A322ProvNom = new String[] {""} ;
      BC004564_A286LocNom = new String[] {""} ;
      BC004565_A683ActDescripSinAc = new String[] {""} ;
      BC004565_A108ActDescrip = new String[] {""} ;
      BC004566_A530TipEmpleDefIns = new String[] {""} ;
      BC004567_A518EmpZonDescrip = new String[] {""} ;
      BC004568_A3CliCod = new int[1] ;
      BC004568_A1EmpCod = new short[1] ;
      BC004568_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC004569_A3CliCod = new int[1] ;
      BC004569_A1EmpCod = new short[1] ;
      BC004569_A2380ColaUUID = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC004570_A3CliCod = new int[1] ;
      BC004570_A1EmpCod = new short[1] ;
      BC004570_A2371LiqBatchLiqNro = new int[1] ;
      BC004570_A2372LiqBatchCod = new String[] {""} ;
      BC004570_A2373LiqBatchSeccion = new String[] {""} ;
      BC004571_A3CliCod = new int[1] ;
      BC004571_A1EmpCod = new short[1] ;
      BC004571_A2370LiqLoteLiqNro = new int[1] ;
      BC004571_A2269LiqLote = new String[] {""} ;
      BC004572_A3CliCod = new int[1] ;
      BC004572_A1EmpCod = new short[1] ;
      BC004572_A31LiqNro = new int[1] ;
      BC004572_A2285LinkLegNumero = new int[1] ;
      BC004572_A2277LegLinkTiporec = new String[] {""} ;
      BC004573_A3CliCod = new int[1] ;
      BC004573_A1EmpCod = new short[1] ;
      BC004573_A31LiqNro = new int[1] ;
      BC004573_A2183LiqSuc = new String[] {""} ;
      BC004574_A3CliCod = new int[1] ;
      BC004574_A1EmpCod = new short[1] ;
      BC004574_A31LiqNro = new int[1] ;
      BC004574_A2145LiqArea = new String[] {""} ;
      BC004575_A3CliCod = new int[1] ;
      BC004575_A1EmpCod = new short[1] ;
      BC004575_A31LiqNro = new int[1] ;
      BC004575_A2142LiqPaiConve = new short[1] ;
      BC004575_A2143LiqConvenio = new String[] {""} ;
      BC004576_A3CliCod = new int[1] ;
      BC004576_A1EmpCod = new short[1] ;
      BC004576_A1966EmpBanCod = new String[] {""} ;
      BC004577_A3CliCod = new int[1] ;
      BC004577_A1EmpCod = new short[1] ;
      BC004577_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      BC004578_A3CliCod = new int[1] ;
      BC004578_A1EmpCod = new short[1] ;
      BC004578_A1649LSDSec = new int[1] ;
      BC004579_A3CliCod = new int[1] ;
      BC004579_A1EmpCod = new short[1] ;
      BC004579_A1562EmpConvePai = new short[1] ;
      BC004579_A1561EmpConveCod = new String[] {""} ;
      BC004580_A3CliCod = new int[1] ;
      BC004580_A1EmpCod = new short[1] ;
      BC004580_A1562EmpConvePai = new short[1] ;
      BC004580_A1561EmpConveCod = new String[] {""} ;
      BC004581_A3CliCod = new int[1] ;
      BC004581_A1EmpCod = new short[1] ;
      BC004581_A1562EmpConvePai = new short[1] ;
      BC004581_A1561EmpConveCod = new String[] {""} ;
      BC004582_A3CliCod = new int[1] ;
      BC004582_A1EmpCod = new short[1] ;
      BC004582_A1562EmpConvePai = new short[1] ;
      BC004582_A1561EmpConveCod = new String[] {""} ;
      BC004583_A3CliCod = new int[1] ;
      BC004583_A1EmpCod = new short[1] ;
      BC004583_A1562EmpConvePai = new short[1] ;
      BC004583_A1561EmpConveCod = new String[] {""} ;
      BC004584_A3CliCod = new int[1] ;
      BC004584_A1EmpCod = new short[1] ;
      BC004584_A1562EmpConvePai = new short[1] ;
      BC004584_A1561EmpConveCod = new String[] {""} ;
      BC004585_A3CliCod = new int[1] ;
      BC004585_A1EmpCod = new short[1] ;
      BC004585_A1562EmpConvePai = new short[1] ;
      BC004585_A1561EmpConveCod = new String[] {""} ;
      BC004586_A3CliCod = new int[1] ;
      BC004586_A1EmpCod = new short[1] ;
      BC004586_A1562EmpConvePai = new short[1] ;
      BC004586_A1561EmpConveCod = new String[] {""} ;
      BC004587_A3CliCod = new int[1] ;
      BC004587_A1EmpCod = new short[1] ;
      BC004587_A1562EmpConvePai = new short[1] ;
      BC004587_A1561EmpConveCod = new String[] {""} ;
      BC004588_A3CliCod = new int[1] ;
      BC004588_A1EmpCod = new short[1] ;
      BC004588_A1562EmpConvePai = new short[1] ;
      BC004588_A1561EmpConveCod = new String[] {""} ;
      BC004589_A3CliCod = new int[1] ;
      BC004589_A1EmpCod = new short[1] ;
      BC004589_A1562EmpConvePai = new short[1] ;
      BC004589_A1561EmpConveCod = new String[] {""} ;
      BC004590_A3CliCod = new int[1] ;
      BC004590_A1EmpCod = new short[1] ;
      BC004590_A1562EmpConvePai = new short[1] ;
      BC004590_A1561EmpConveCod = new String[] {""} ;
      BC004591_A3CliCod = new int[1] ;
      BC004591_A1EmpCod = new short[1] ;
      BC004591_A1562EmpConvePai = new short[1] ;
      BC004591_A1561EmpConveCod = new String[] {""} ;
      BC004592_A3CliCod = new int[1] ;
      BC004592_A1EmpCod = new short[1] ;
      BC004592_A1562EmpConvePai = new short[1] ;
      BC004592_A1561EmpConveCod = new String[] {""} ;
      BC004593_A3CliCod = new int[1] ;
      BC004593_A1EmpCod = new short[1] ;
      BC004593_A1562EmpConvePai = new short[1] ;
      BC004593_A1561EmpConveCod = new String[] {""} ;
      BC004594_A3CliCod = new int[1] ;
      BC004594_A1EmpCod = new short[1] ;
      BC004594_A1562EmpConvePai = new short[1] ;
      BC004594_A1561EmpConveCod = new String[] {""} ;
      BC004595_A3CliCod = new int[1] ;
      BC004595_A1EmpCod = new short[1] ;
      BC004595_A1562EmpConvePai = new short[1] ;
      BC004595_A1561EmpConveCod = new String[] {""} ;
      BC004596_A3CliCod = new int[1] ;
      BC004596_A1EmpCod = new short[1] ;
      BC004596_A1562EmpConvePai = new short[1] ;
      BC004596_A1561EmpConveCod = new String[] {""} ;
      BC004597_A3CliCod = new int[1] ;
      BC004597_A1EmpCod = new short[1] ;
      BC004597_A1562EmpConvePai = new short[1] ;
      BC004597_A1561EmpConveCod = new String[] {""} ;
      BC004598_A3CliCod = new int[1] ;
      BC004598_A1EmpCod = new short[1] ;
      BC004598_A1562EmpConvePai = new short[1] ;
      BC004598_A1561EmpConveCod = new String[] {""} ;
      BC004599_A3CliCod = new int[1] ;
      BC004599_A1EmpCod = new short[1] ;
      BC004599_A1562EmpConvePai = new short[1] ;
      BC004599_A1561EmpConveCod = new String[] {""} ;
      BC0045100_A3CliCod = new int[1] ;
      BC0045100_A1EmpCod = new short[1] ;
      BC0045100_A1562EmpConvePai = new short[1] ;
      BC0045100_A1561EmpConveCod = new String[] {""} ;
      BC0045101_A3CliCod = new int[1] ;
      BC0045101_A1EmpCod = new short[1] ;
      BC0045101_A1562EmpConvePai = new short[1] ;
      BC0045101_A1561EmpConveCod = new String[] {""} ;
      BC0045102_A3CliCod = new int[1] ;
      BC0045102_A1EmpCod = new short[1] ;
      BC0045102_A1562EmpConvePai = new short[1] ;
      BC0045102_A1561EmpConveCod = new String[] {""} ;
      BC0045103_A3CliCod = new int[1] ;
      BC0045103_A1EmpCod = new short[1] ;
      BC0045103_A1562EmpConvePai = new short[1] ;
      BC0045103_A1561EmpConveCod = new String[] {""} ;
      BC0045104_A3CliCod = new int[1] ;
      BC0045104_A1EmpCod = new short[1] ;
      BC0045104_A1562EmpConvePai = new short[1] ;
      BC0045104_A1561EmpConveCod = new String[] {""} ;
      BC0045105_A3CliCod = new int[1] ;
      BC0045105_A1EmpCod = new short[1] ;
      BC0045105_A1562EmpConvePai = new short[1] ;
      BC0045105_A1561EmpConveCod = new String[] {""} ;
      BC0045106_A3CliCod = new int[1] ;
      BC0045106_A1EmpCod = new short[1] ;
      BC0045106_A1562EmpConvePai = new short[1] ;
      BC0045106_A1561EmpConveCod = new String[] {""} ;
      BC0045107_A3CliCod = new int[1] ;
      BC0045107_A1EmpCod = new short[1] ;
      BC0045107_A1562EmpConvePai = new short[1] ;
      BC0045107_A1561EmpConveCod = new String[] {""} ;
      BC0045108_A3CliCod = new int[1] ;
      BC0045108_A1EmpCod = new short[1] ;
      BC0045108_A1562EmpConvePai = new short[1] ;
      BC0045108_A1561EmpConveCod = new String[] {""} ;
      BC0045109_A3CliCod = new int[1] ;
      BC0045109_A1EmpCod = new short[1] ;
      BC0045109_A1562EmpConvePai = new short[1] ;
      BC0045109_A1561EmpConveCod = new String[] {""} ;
      BC0045110_A3CliCod = new int[1] ;
      BC0045110_A1EmpCod = new short[1] ;
      BC0045110_A1562EmpConvePai = new short[1] ;
      BC0045110_A1561EmpConveCod = new String[] {""} ;
      BC0045111_A3CliCod = new int[1] ;
      BC0045111_A1EmpCod = new short[1] ;
      BC0045111_A1562EmpConvePai = new short[1] ;
      BC0045111_A1561EmpConveCod = new String[] {""} ;
      BC0045112_A3CliCod = new int[1] ;
      BC0045112_A1EmpCod = new short[1] ;
      BC0045112_A1562EmpConvePai = new short[1] ;
      BC0045112_A1561EmpConveCod = new String[] {""} ;
      BC0045113_A3CliCod = new int[1] ;
      BC0045113_A1EmpCod = new short[1] ;
      BC0045113_A1562EmpConvePai = new short[1] ;
      BC0045113_A1561EmpConveCod = new String[] {""} ;
      BC0045114_A3CliCod = new int[1] ;
      BC0045114_A1EmpCod = new short[1] ;
      BC0045114_A1562EmpConvePai = new short[1] ;
      BC0045114_A1561EmpConveCod = new String[] {""} ;
      BC0045115_A3CliCod = new int[1] ;
      BC0045115_A1EmpCod = new short[1] ;
      BC0045115_A1562EmpConvePai = new short[1] ;
      BC0045115_A1561EmpConveCod = new String[] {""} ;
      BC0045116_A3CliCod = new int[1] ;
      BC0045116_A1EmpCod = new short[1] ;
      BC0045116_A1562EmpConvePai = new short[1] ;
      BC0045116_A1561EmpConveCod = new String[] {""} ;
      BC0045117_A3CliCod = new int[1] ;
      BC0045117_A1EmpCod = new short[1] ;
      BC0045117_A1562EmpConvePai = new short[1] ;
      BC0045117_A1561EmpConveCod = new String[] {""} ;
      BC0045118_A3CliCod = new int[1] ;
      BC0045118_A1EmpCod = new short[1] ;
      BC0045118_A1562EmpConvePai = new short[1] ;
      BC0045118_A1561EmpConveCod = new String[] {""} ;
      BC0045119_A3CliCod = new int[1] ;
      BC0045119_A1EmpCod = new short[1] ;
      BC0045119_A1562EmpConvePai = new short[1] ;
      BC0045119_A1561EmpConveCod = new String[] {""} ;
      BC0045120_A3CliCod = new int[1] ;
      BC0045120_A1EmpCod = new short[1] ;
      BC0045120_A1562EmpConvePai = new short[1] ;
      BC0045120_A1561EmpConveCod = new String[] {""} ;
      BC0045121_A3CliCod = new int[1] ;
      BC0045121_A1EmpCod = new short[1] ;
      BC0045121_A1562EmpConvePai = new short[1] ;
      BC0045121_A1561EmpConveCod = new String[] {""} ;
      BC0045122_A3CliCod = new int[1] ;
      BC0045122_A1EmpCod = new short[1] ;
      BC0045122_A1562EmpConvePai = new short[1] ;
      BC0045122_A1561EmpConveCod = new String[] {""} ;
      BC0045123_A3CliCod = new int[1] ;
      BC0045123_A1EmpCod = new short[1] ;
      BC0045123_A1562EmpConvePai = new short[1] ;
      BC0045123_A1561EmpConveCod = new String[] {""} ;
      BC0045124_A3CliCod = new int[1] ;
      BC0045124_A1EmpCod = new short[1] ;
      BC0045124_A1562EmpConvePai = new short[1] ;
      BC0045124_A1561EmpConveCod = new String[] {""} ;
      BC0045125_A3CliCod = new int[1] ;
      BC0045125_A1EmpCod = new short[1] ;
      BC0045125_A1562EmpConvePai = new short[1] ;
      BC0045125_A1561EmpConveCod = new String[] {""} ;
      BC0045126_A3CliCod = new int[1] ;
      BC0045126_A1EmpCod = new short[1] ;
      BC0045126_A1562EmpConvePai = new short[1] ;
      BC0045126_A1561EmpConveCod = new String[] {""} ;
      BC0045127_A3CliCod = new int[1] ;
      BC0045127_A1EmpCod = new short[1] ;
      BC0045127_A1562EmpConvePai = new short[1] ;
      BC0045127_A1561EmpConveCod = new String[] {""} ;
      BC0045128_A3CliCod = new int[1] ;
      BC0045128_A1EmpCod = new short[1] ;
      BC0045128_A1562EmpConvePai = new short[1] ;
      BC0045128_A1561EmpConveCod = new String[] {""} ;
      BC0045129_A3CliCod = new int[1] ;
      BC0045129_A1EmpCod = new short[1] ;
      BC0045129_A1562EmpConvePai = new short[1] ;
      BC0045129_A1561EmpConveCod = new String[] {""} ;
      BC0045130_A3CliCod = new int[1] ;
      BC0045130_A1EmpCod = new short[1] ;
      BC0045130_A1562EmpConvePai = new short[1] ;
      BC0045130_A1561EmpConveCod = new String[] {""} ;
      BC0045131_A3CliCod = new int[1] ;
      BC0045131_A1EmpCod = new short[1] ;
      BC0045131_A1562EmpConvePai = new short[1] ;
      BC0045131_A1561EmpConveCod = new String[] {""} ;
      BC0045132_A3CliCod = new int[1] ;
      BC0045132_A1EmpCod = new short[1] ;
      BC0045132_A1562EmpConvePai = new short[1] ;
      BC0045132_A1561EmpConveCod = new String[] {""} ;
      BC0045133_A3CliCod = new int[1] ;
      BC0045133_A1EmpCod = new short[1] ;
      BC0045133_A1562EmpConvePai = new short[1] ;
      BC0045133_A1561EmpConveCod = new String[] {""} ;
      BC0045134_A3CliCod = new int[1] ;
      BC0045134_A1EmpCod = new short[1] ;
      BC0045134_A1562EmpConvePai = new short[1] ;
      BC0045134_A1561EmpConveCod = new String[] {""} ;
      BC0045135_A3CliCod = new int[1] ;
      BC0045135_A1EmpCod = new short[1] ;
      BC0045135_A1547GuarCod = new short[1] ;
      BC0045136_A3CliCod = new int[1] ;
      BC0045136_A1EmpCod = new short[1] ;
      BC0045136_A1340EmpHsExSec = new short[1] ;
      BC0045137_A3CliCod = new int[1] ;
      BC0045137_A1EmpCod = new short[1] ;
      BC0045137_A1243SucCodigo = new String[] {""} ;
      BC0045138_A3CliCod = new int[1] ;
      BC0045138_A1EmpCod = new short[1] ;
      BC0045138_A784F1357CTipoPre = new byte[1] ;
      BC0045138_A777F1357CPer = new String[] {""} ;
      BC0045138_A778F1357CSec = new byte[1] ;
      BC0045139_A3CliCod = new int[1] ;
      BC0045139_A1EmpCod = new short[1] ;
      BC0045139_A88ImpLiqSec = new short[1] ;
      BC0045140_A3CliCod = new int[1] ;
      BC0045140_A1EmpCod = new short[1] ;
      BC0045140_A87MigrLegNumero = new int[1] ;
      BC0045141_A3CliCod = new int[1] ;
      BC0045141_A1EmpCod = new short[1] ;
      BC0045141_A86TempRecSec = new short[1] ;
      BC0045142_A3CliCod = new int[1] ;
      BC0045142_A1EmpCod = new short[1] ;
      BC0045142_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC0045143_A3CliCod = new int[1] ;
      BC0045143_A1EmpCod = new short[1] ;
      BC0045143_A79AsientoCNum = new int[1] ;
      BC0045144_A3CliCod = new int[1] ;
      BC0045144_A1EmpCod = new short[1] ;
      BC0045144_A78CuenCodigo = new String[] {""} ;
      BC0045145_A3CliCod = new int[1] ;
      BC0045145_A1EmpCod = new short[1] ;
      BC0045145_A77CenCodigo = new short[1] ;
      BC0045146_A3CliCod = new int[1] ;
      BC0045146_A1EmpCod = new short[1] ;
      BC0045146_A31LiqNro = new int[1] ;
      BC0045146_A10LpgCodigo = new String[] {""} ;
      BC0045147_A3CliCod = new int[1] ;
      BC0045147_A1EmpCod = new short[1] ;
      BC0045147_A6LegNumero = new int[1] ;
      BC0045148_A683ActDescripSinAc = new String[] {""} ;
      BC0045148_A1EmpCod = new short[1] ;
      BC0045148_A2EmpNom = new String[] {""} ;
      BC0045148_A177EmpCUIT = new long[1] ;
      BC0045148_A178EmpDir = new String[] {""} ;
      BC0045148_A180EmpTel = new String[] {""} ;
      BC0045148_n180EmpTel = new boolean[] {false} ;
      BC0045148_A176EmpCP = new String[] {""} ;
      BC0045148_n176EmpCP = new boolean[] {false} ;
      BC0045148_A312PaiNom = new String[] {""} ;
      BC0045148_A322ProvNom = new String[] {""} ;
      BC0045148_A1811EmpPerVacDes = new byte[1] ;
      BC0045148_A1812EmpPerVacHas = new byte[1] ;
      BC0045148_A286LocNom = new String[] {""} ;
      BC0045148_A108ActDescrip = new String[] {""} ;
      BC0045148_A518EmpZonDescrip = new String[] {""} ;
      BC0045148_A532EmpReducc = new boolean[] {false} ;
      BC0045148_A530TipEmpleDefIns = new String[] {""} ;
      BC0045148_A955EmpLogo = new String[] {""} ;
      BC0045148_n955EmpLogo = new boolean[] {false} ;
      BC0045148_A958EmpFirma = new String[] {""} ;
      BC0045148_n958EmpFirma = new boolean[] {false} ;
      BC0045148_A1140EmpAntiguedad = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045148_A1141EmpPresentismo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045148_A1302EmpMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045148_n1302EmpMesHsPExt = new boolean[] {false} ;
      BC0045148_A1524EmpLiqFer = new boolean[] {false} ;
      BC0045148_A1750EmpLiqFerJor = new boolean[] {false} ;
      BC0045148_A1303EmpDiaHsPExt = new String[] {""} ;
      BC0045148_n1303EmpDiaHsPExt = new boolean[] {false} ;
      BC0045148_A1556EmpGuarEdadMin = new byte[1] ;
      BC0045148_A1557EmpGuarEdadMax = new byte[1] ;
      BC0045148_A1787EmpLiqGan = new boolean[] {false} ;
      BC0045148_A1792EmpTipoExp = new byte[1] ;
      BC0045148_A1802EmpPromDesde = new String[] {""} ;
      BC0045148_A1813EmpFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045148_A2259EmpVacExpLim = new boolean[] {false} ;
      BC0045148_A2260EmpVacExpTie = new byte[1] ;
      BC0045148_A2261EmpVacDisMax = new int[1] ;
      BC0045148_A2405EmpModTra = new String[] {""} ;
      BC0045148_A2406EmpModEmpl = new boolean[] {false} ;
      BC0045148_A2407EmpModAuto = new boolean[] {false} ;
      BC0045148_A957EmpLogoExt = new String[] {""} ;
      BC0045148_n957EmpLogoExt = new boolean[] {false} ;
      BC0045148_A960EmpFirmaExt = new String[] {""} ;
      BC0045148_n960EmpFirmaExt = new boolean[] {false} ;
      BC0045148_A956EmpLogoNom = new String[] {""} ;
      BC0045148_n956EmpLogoNom = new boolean[] {false} ;
      BC0045148_A959EmpFirmaNom = new String[] {""} ;
      BC0045148_n959EmpFirmaNom = new boolean[] {false} ;
      BC0045148_A46PaiCod = new short[1] ;
      BC0045148_n46PaiCod = new boolean[] {false} ;
      BC0045148_A47ProvCod = new short[1] ;
      BC0045148_n47ProvCod = new boolean[] {false} ;
      BC0045148_A48LocCod = new short[1] ;
      BC0045148_n48LocCod = new boolean[] {false} ;
      BC0045148_A3CliCod = new int[1] ;
      BC0045148_A43ActCodigo = new String[] {""} ;
      BC0045148_n43ActCodigo = new boolean[] {false} ;
      BC0045148_A45TipEmpleCod = new String[] {""} ;
      BC0045148_n45TipEmpleCod = new boolean[] {false} ;
      BC0045148_A1151ARTSec = new short[1] ;
      BC0045148_A903ActComCodigo = new String[] {""} ;
      BC0045148_A1965EmpOsoCod = new String[] {""} ;
      BC0045148_n1965EmpOsoCod = new boolean[] {false} ;
      BC0045148_A1533EmpActComercial = new String[] {""} ;
      BC0045148_A44EmpZonCod = new String[] {""} ;
      BC0045148_n44EmpZonCod = new boolean[] {false} ;
      BC0045148_A2265EmpCondiCod = new short[1] ;
      Z1368EmpMenConCodigo = "" ;
      A1368EmpMenConCodigo = "" ;
      BC0045149_A1370EmpMenHabitual = new boolean[] {false} ;
      BC0045149_A3CliCod = new int[1] ;
      BC0045149_A1368EmpMenConCodigo = new String[] {""} ;
      BC0045149_A1EmpCod = new short[1] ;
      BC0045150_A26ConCodigo = new String[] {""} ;
      BC0045151_A3CliCod = new int[1] ;
      BC0045151_A1EmpCod = new short[1] ;
      BC0045151_A1368EmpMenConCodigo = new String[] {""} ;
      BC0045152_A1370EmpMenHabitual = new boolean[] {false} ;
      BC0045152_A3CliCod = new int[1] ;
      BC0045152_A1368EmpMenConCodigo = new String[] {""} ;
      BC0045152_A1EmpCod = new short[1] ;
      sMode171 = "" ;
      BC0045153_A1370EmpMenHabitual = new boolean[] {false} ;
      BC0045153_A3CliCod = new int[1] ;
      BC0045153_A1368EmpMenConCodigo = new String[] {""} ;
      BC0045153_A1EmpCod = new short[1] ;
      BC0045157_A1370EmpMenHabitual = new boolean[] {false} ;
      BC0045157_A3CliCod = new int[1] ;
      BC0045157_A1368EmpMenConCodigo = new String[] {""} ;
      BC0045157_A1EmpCod = new short[1] ;
      Z1366EmpJorConCodigo = "" ;
      A1366EmpJorConCodigo = "" ;
      BC0045158_A1369EmpJorHabitual = new boolean[] {false} ;
      BC0045158_A3CliCod = new int[1] ;
      BC0045158_A1366EmpJorConCodigo = new String[] {""} ;
      BC0045158_A1EmpCod = new short[1] ;
      BC0045159_A26ConCodigo = new String[] {""} ;
      BC0045160_A3CliCod = new int[1] ;
      BC0045160_A1EmpCod = new short[1] ;
      BC0045160_A1366EmpJorConCodigo = new String[] {""} ;
      BC0045161_A1369EmpJorHabitual = new boolean[] {false} ;
      BC0045161_A3CliCod = new int[1] ;
      BC0045161_A1366EmpJorConCodigo = new String[] {""} ;
      BC0045161_A1EmpCod = new short[1] ;
      sMode172 = "" ;
      BC0045162_A1369EmpJorHabitual = new boolean[] {false} ;
      BC0045162_A3CliCod = new int[1] ;
      BC0045162_A1366EmpJorConCodigo = new String[] {""} ;
      BC0045162_A1EmpCod = new short[1] ;
      BC0045166_A1369EmpJorHabitual = new boolean[] {false} ;
      BC0045166_A3CliCod = new int[1] ;
      BC0045166_A1366EmpJorConCodigo = new String[] {""} ;
      BC0045166_A1EmpCod = new short[1] ;
      Z1371EmpPromFijVar = "" ;
      A1371EmpPromFijVar = "" ;
      Z37TipoConCod = "" ;
      A37TipoConCod = "" ;
      BC0045167_A3CliCod = new int[1] ;
      BC0045167_A1EmpCod = new short[1] ;
      BC0045167_A1371EmpPromFijVar = new String[] {""} ;
      BC0045167_A1372EmpPromHabitual = new boolean[] {false} ;
      BC0045167_A37TipoConCod = new String[] {""} ;
      BC0045168_A37TipoConCod = new String[] {""} ;
      BC0045169_A3CliCod = new int[1] ;
      BC0045169_A1EmpCod = new short[1] ;
      BC0045169_A37TipoConCod = new String[] {""} ;
      BC0045169_A1371EmpPromFijVar = new String[] {""} ;
      BC0045170_A3CliCod = new int[1] ;
      BC0045170_A1EmpCod = new short[1] ;
      BC0045170_A1371EmpPromFijVar = new String[] {""} ;
      BC0045170_A1372EmpPromHabitual = new boolean[] {false} ;
      BC0045170_A37TipoConCod = new String[] {""} ;
      sMode173 = "" ;
      BC0045171_A3CliCod = new int[1] ;
      BC0045171_A1EmpCod = new short[1] ;
      BC0045171_A1371EmpPromFijVar = new String[] {""} ;
      BC0045171_A1372EmpPromHabitual = new boolean[] {false} ;
      BC0045171_A37TipoConCod = new String[] {""} ;
      BC0045175_A3CliCod = new int[1] ;
      BC0045175_A1EmpCod = new short[1] ;
      BC0045175_A1371EmpPromFijVar = new String[] {""} ;
      BC0045175_A1372EmpPromHabitual = new boolean[] {false} ;
      BC0045175_A37TipoConCod = new String[] {""} ;
      Z1432EmpBasePlus = DecimalUtil.ZERO ;
      A1432EmpBasePlus = DecimalUtil.ZERO ;
      Z1429EmpBaseTipo = "" ;
      A1429EmpBaseTipo = "" ;
      Z1430EmpBaseCod1 = "" ;
      A1430EmpBaseCod1 = "" ;
      Z1431EmpBaseCod2 = "" ;
      A1431EmpBaseCod2 = "" ;
      BC0045176_A3CliCod = new int[1] ;
      BC0045176_A1EmpCod = new short[1] ;
      BC0045176_A1427EmpBaseClaseLeg = new byte[1] ;
      BC0045176_A1429EmpBaseTipo = new String[] {""} ;
      BC0045176_A1430EmpBaseCod1 = new String[] {""} ;
      BC0045176_A1431EmpBaseCod2 = new String[] {""} ;
      BC0045176_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045177_A3CliCod = new int[1] ;
      BC0045177_A1EmpCod = new short[1] ;
      BC0045177_A1427EmpBaseClaseLeg = new byte[1] ;
      BC0045177_A1429EmpBaseTipo = new String[] {""} ;
      BC0045177_A1430EmpBaseCod1 = new String[] {""} ;
      BC0045177_A1431EmpBaseCod2 = new String[] {""} ;
      BC0045178_A3CliCod = new int[1] ;
      BC0045178_A1EmpCod = new short[1] ;
      BC0045178_A1427EmpBaseClaseLeg = new byte[1] ;
      BC0045178_A1429EmpBaseTipo = new String[] {""} ;
      BC0045178_A1430EmpBaseCod1 = new String[] {""} ;
      BC0045178_A1431EmpBaseCod2 = new String[] {""} ;
      BC0045178_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      sMode191 = "" ;
      BC0045179_A3CliCod = new int[1] ;
      BC0045179_A1EmpCod = new short[1] ;
      BC0045179_A1427EmpBaseClaseLeg = new byte[1] ;
      BC0045179_A1429EmpBaseTipo = new String[] {""} ;
      BC0045179_A1430EmpBaseCod1 = new String[] {""} ;
      BC0045179_A1431EmpBaseCod2 = new String[] {""} ;
      BC0045179_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045183_A3CliCod = new int[1] ;
      BC0045183_A1EmpCod = new short[1] ;
      BC0045183_A1427EmpBaseClaseLeg = new byte[1] ;
      BC0045183_A1429EmpBaseTipo = new String[] {""} ;
      BC0045183_A1430EmpBaseCod1 = new String[] {""} ;
      BC0045183_A1431EmpBaseCod2 = new String[] {""} ;
      BC0045183_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      Z1342EmpHsPDiaDesde = "" ;
      A1342EmpHsPDiaDesde = "" ;
      Z1343EmpTarifaPDia = DecimalUtil.ZERO ;
      A1343EmpTarifaPDia = DecimalUtil.ZERO ;
      Z1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      A1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      Z1339EmpHsPDiaTipTra = "" ;
      A1339EmpHsPDiaTipTra = "" ;
      BC0045184_A1340EmpHsExSec = new short[1] ;
      BC0045184_A1341EmpHsPDiaDia = new byte[1] ;
      BC0045184_A1342EmpHsPDiaDesde = new String[] {""} ;
      BC0045184_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      BC0045184_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045184_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045184_A3CliCod = new int[1] ;
      BC0045184_A1EmpCod = new short[1] ;
      BC0045184_A1339EmpHsPDiaTipTra = new String[] {""} ;
      BC0045185_A1294PaiTipoTraId = new String[] {""} ;
      BC0045186_A3CliCod = new int[1] ;
      BC0045186_A1EmpCod = new short[1] ;
      BC0045186_A1340EmpHsExSec = new short[1] ;
      BC0045187_A1340EmpHsExSec = new short[1] ;
      BC0045187_A1341EmpHsPDiaDia = new byte[1] ;
      BC0045187_A1342EmpHsPDiaDesde = new String[] {""} ;
      BC0045187_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      BC0045187_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045187_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045187_A3CliCod = new int[1] ;
      BC0045187_A1EmpCod = new short[1] ;
      BC0045187_A1339EmpHsPDiaTipTra = new String[] {""} ;
      sMode165 = "" ;
      BC0045188_A1340EmpHsExSec = new short[1] ;
      BC0045188_A1341EmpHsPDiaDia = new byte[1] ;
      BC0045188_A1342EmpHsPDiaDesde = new String[] {""} ;
      BC0045188_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      BC0045188_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045188_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045188_A3CliCod = new int[1] ;
      BC0045188_A1EmpCod = new short[1] ;
      BC0045188_A1339EmpHsPDiaTipTra = new String[] {""} ;
      BC0045192_A1340EmpHsExSec = new short[1] ;
      BC0045192_A1341EmpHsPDiaDia = new byte[1] ;
      BC0045192_A1342EmpHsPDiaDesde = new String[] {""} ;
      BC0045192_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      BC0045192_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045192_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045192_A3CliCod = new int[1] ;
      BC0045192_A1EmpCod = new short[1] ;
      BC0045192_A1339EmpHsPDiaTipTra = new String[] {""} ;
      Z1344EmpHsDia = DecimalUtil.ZERO ;
      A1344EmpHsDia = DecimalUtil.ZERO ;
      Z1345EmpHsSem = DecimalUtil.ZERO ;
      A1345EmpHsSem = DecimalUtil.ZERO ;
      Z1346EmpTarifaXLim = DecimalUtil.ZERO ;
      A1346EmpTarifaXLim = DecimalUtil.ZERO ;
      Z1352EmpTarifaRec = DecimalUtil.ZERO ;
      A1352EmpTarifaRec = DecimalUtil.ZERO ;
      Z1386EmpHsMaxDia = DecimalUtil.ZERO ;
      A1386EmpHsMaxDia = DecimalUtil.ZERO ;
      Z1387EmpHsMaxSem = DecimalUtil.ZERO ;
      A1387EmpHsMaxSem = DecimalUtil.ZERO ;
      Z1388EmpHsMaxMes = DecimalUtil.ZERO ;
      A1388EmpHsMaxMes = DecimalUtil.ZERO ;
      Z1389EmpHsMaxAnu = DecimalUtil.ZERO ;
      A1389EmpHsMaxAnu = DecimalUtil.ZERO ;
      Z1294PaiTipoTraId = "" ;
      A1294PaiTipoTraId = "" ;
      BC0045193_A3CliCod = new int[1] ;
      BC0045193_A1EmpCod = new short[1] ;
      BC0045193_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045193_A1345EmpHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045193_A1346EmpTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045193_A1352EmpTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045193_A1386EmpHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045193_A1387EmpHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045193_A1388EmpHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045193_A1389EmpHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045193_A1294PaiTipoTraId = new String[] {""} ;
      BC0045194_A1292TipoTraId = new String[] {""} ;
      BC0045195_A3CliCod = new int[1] ;
      BC0045195_A1EmpCod = new short[1] ;
      BC0045195_A1294PaiTipoTraId = new String[] {""} ;
      BC0045196_A3CliCod = new int[1] ;
      BC0045196_A1EmpCod = new short[1] ;
      BC0045196_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045196_A1345EmpHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045196_A1346EmpTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045196_A1352EmpTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045196_A1386EmpHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045196_A1387EmpHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045196_A1388EmpHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045196_A1389EmpHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045196_A1294PaiTipoTraId = new String[] {""} ;
      sMode166 = "" ;
      BC0045197_A3CliCod = new int[1] ;
      BC0045197_A1EmpCod = new short[1] ;
      BC0045197_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045197_A1345EmpHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045197_A1346EmpTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045197_A1352EmpTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045197_A1386EmpHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045197_A1387EmpHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045197_A1388EmpHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045197_A1389EmpHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045197_A1294PaiTipoTraId = new String[] {""} ;
      BC0045201_A3CliCod = new int[1] ;
      BC0045201_A1EmpCod = new short[1] ;
      BC0045201_A1340EmpHsExSec = new short[1] ;
      BC0045202_A3CliCod = new int[1] ;
      BC0045202_A1EmpCod = new short[1] ;
      BC0045202_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045202_A1345EmpHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045202_A1346EmpTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045202_A1352EmpTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045202_A1386EmpHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045202_A1387EmpHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045202_A1388EmpHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045202_A1389EmpHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC0045202_A1294PaiTipoTraId = new String[] {""} ;
      Z1239EmpConvenio = "" ;
      A1239EmpConvenio = "" ;
      BC0045203_A3CliCod = new int[1] ;
      BC0045203_A1EmpCod = new short[1] ;
      BC0045203_A1239EmpConvenio = new String[] {""} ;
      BC0045204_A3CliCod = new int[1] ;
      BC0045204_A1EmpCod = new short[1] ;
      BC0045204_A1239EmpConvenio = new String[] {""} ;
      BC0045205_A3CliCod = new int[1] ;
      BC0045205_A1EmpCod = new short[1] ;
      BC0045205_A1239EmpConvenio = new String[] {""} ;
      sMode144 = "" ;
      BC0045206_A3CliCod = new int[1] ;
      BC0045206_A1EmpCod = new short[1] ;
      BC0045206_A1239EmpConvenio = new String[] {""} ;
      BC0045209_A3CliCod = new int[1] ;
      BC0045209_A1EmpCod = new short[1] ;
      BC0045209_A1239EmpConvenio = new String[] {""} ;
      Z1238EmpOrigen = "" ;
      A1238EmpOrigen = "" ;
      BC0045210_A3CliCod = new int[1] ;
      BC0045210_A1EmpCod = new short[1] ;
      BC0045210_A1238EmpOrigen = new String[] {""} ;
      BC0045211_A1231OrigId = new String[] {""} ;
      BC0045212_A3CliCod = new int[1] ;
      BC0045212_A1EmpCod = new short[1] ;
      BC0045212_A1238EmpOrigen = new String[] {""} ;
      BC0045213_A3CliCod = new int[1] ;
      BC0045213_A1EmpCod = new short[1] ;
      BC0045213_A1238EmpOrigen = new String[] {""} ;
      sMode145 = "" ;
      BC0045214_A3CliCod = new int[1] ;
      BC0045214_A1EmpCod = new short[1] ;
      BC0045214_A1238EmpOrigen = new String[] {""} ;
      BC0045217_A3CliCod = new int[1] ;
      BC0045217_A1EmpCod = new short[1] ;
      BC0045217_A1238EmpOrigen = new String[] {""} ;
      Z1237EmpReligion = "" ;
      A1237EmpReligion = "" ;
      BC0045218_A3CliCod = new int[1] ;
      BC0045218_A1EmpCod = new short[1] ;
      BC0045218_A1237EmpReligion = new String[] {""} ;
      BC0045219_A1229ReligId = new String[] {""} ;
      BC0045220_A3CliCod = new int[1] ;
      BC0045220_A1EmpCod = new short[1] ;
      BC0045220_A1237EmpReligion = new String[] {""} ;
      BC0045221_A3CliCod = new int[1] ;
      BC0045221_A1EmpCod = new short[1] ;
      BC0045221_A1237EmpReligion = new String[] {""} ;
      sMode146 = "" ;
      BC0045222_A3CliCod = new int[1] ;
      BC0045222_A1EmpCod = new short[1] ;
      BC0045222_A1237EmpReligion = new String[] {""} ;
      BC0045225_A3CliCod = new int[1] ;
      BC0045225_A1EmpCod = new short[1] ;
      BC0045225_A1237EmpReligion = new String[] {""} ;
      A26ConCodigo = "" ;
      A1292TipoTraId = "" ;
      A1231OrigId = "" ;
      A1229ReligId = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC0045226_A3CliCod = new int[1] ;
      BC0045227_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresa_abm_1_bc__default(),
         new Object[] {
             new Object[] {
            BC00452_A3CliCod, BC00452_A1EmpCod, BC00452_A1237EmpReligion
            }
            , new Object[] {
            BC00453_A3CliCod, BC00453_A1EmpCod, BC00453_A1237EmpReligion
            }
            , new Object[] {
            BC00454_A1229ReligId
            }
            , new Object[] {
            BC00455_A3CliCod, BC00455_A1EmpCod, BC00455_A1238EmpOrigen
            }
            , new Object[] {
            BC00456_A3CliCod, BC00456_A1EmpCod, BC00456_A1238EmpOrigen
            }
            , new Object[] {
            BC00457_A1231OrigId
            }
            , new Object[] {
            BC00458_A3CliCod, BC00458_A1EmpCod, BC00458_A1239EmpConvenio
            }
            , new Object[] {
            BC00459_A3CliCod, BC00459_A1EmpCod, BC00459_A1239EmpConvenio
            }
            , new Object[] {
            BC004510_A3CliCod, BC004510_A1EmpCod, BC004510_A1344EmpHsDia, BC004510_A1345EmpHsSem, BC004510_A1346EmpTarifaXLim, BC004510_A1352EmpTarifaRec, BC004510_A1386EmpHsMaxDia, BC004510_A1387EmpHsMaxSem, BC004510_A1388EmpHsMaxMes, BC004510_A1389EmpHsMaxAnu,
            BC004510_A1294PaiTipoTraId
            }
            , new Object[] {
            BC004511_A3CliCod, BC004511_A1EmpCod, BC004511_A1344EmpHsDia, BC004511_A1345EmpHsSem, BC004511_A1346EmpTarifaXLim, BC004511_A1352EmpTarifaRec, BC004511_A1386EmpHsMaxDia, BC004511_A1387EmpHsMaxSem, BC004511_A1388EmpHsMaxMes, BC004511_A1389EmpHsMaxAnu,
            BC004511_A1294PaiTipoTraId
            }
            , new Object[] {
            BC004512_A1292TipoTraId
            }
            , new Object[] {
            BC004513_A1340EmpHsExSec, BC004513_A1341EmpHsPDiaDia, BC004513_A1342EmpHsPDiaDesde, BC004513_n1342EmpHsPDiaDesde, BC004513_A1343EmpTarifaPDia, BC004513_A1351EmpTarfaPDRec, BC004513_A3CliCod, BC004513_A1EmpCod, BC004513_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            BC004514_A1340EmpHsExSec, BC004514_A1341EmpHsPDiaDia, BC004514_A1342EmpHsPDiaDesde, BC004514_n1342EmpHsPDiaDesde, BC004514_A1343EmpTarifaPDia, BC004514_A1351EmpTarfaPDRec, BC004514_A3CliCod, BC004514_A1EmpCod, BC004514_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            BC004515_A3CliCod, BC004515_A1EmpCod, BC004515_A1344EmpHsDia, BC004515_A1345EmpHsSem, BC004515_A1346EmpTarifaXLim, BC004515_A1352EmpTarifaRec, BC004515_A1386EmpHsMaxDia, BC004515_A1387EmpHsMaxSem, BC004515_A1388EmpHsMaxMes, BC004515_A1389EmpHsMaxAnu,
            BC004515_A1294PaiTipoTraId
            }
            , new Object[] {
            BC004516_A3CliCod, BC004516_A1EmpCod, BC004516_A1427EmpBaseClaseLeg, BC004516_A1429EmpBaseTipo, BC004516_A1430EmpBaseCod1, BC004516_A1431EmpBaseCod2, BC004516_A1432EmpBasePlus
            }
            , new Object[] {
            BC004517_A3CliCod, BC004517_A1EmpCod, BC004517_A1427EmpBaseClaseLeg, BC004517_A1429EmpBaseTipo, BC004517_A1430EmpBaseCod1, BC004517_A1431EmpBaseCod2, BC004517_A1432EmpBasePlus
            }
            , new Object[] {
            BC004518_A3CliCod, BC004518_A1EmpCod, BC004518_A1371EmpPromFijVar, BC004518_A1372EmpPromHabitual, BC004518_A37TipoConCod
            }
            , new Object[] {
            BC004519_A3CliCod, BC004519_A1EmpCod, BC004519_A1371EmpPromFijVar, BC004519_A1372EmpPromHabitual, BC004519_A37TipoConCod
            }
            , new Object[] {
            BC004520_A37TipoConCod
            }
            , new Object[] {
            BC004521_A1369EmpJorHabitual, BC004521_A3CliCod, BC004521_A1366EmpJorConCodigo, BC004521_A1EmpCod
            }
            , new Object[] {
            BC004522_A1369EmpJorHabitual, BC004522_A3CliCod, BC004522_A1366EmpJorConCodigo, BC004522_A1EmpCod
            }
            , new Object[] {
            BC004523_A26ConCodigo
            }
            , new Object[] {
            BC004524_A1370EmpMenHabitual, BC004524_A3CliCod, BC004524_A1368EmpMenConCodigo, BC004524_A1EmpCod
            }
            , new Object[] {
            BC004525_A1370EmpMenHabitual, BC004525_A3CliCod, BC004525_A1368EmpMenConCodigo, BC004525_A1EmpCod
            }
            , new Object[] {
            BC004526_A26ConCodigo
            }
            , new Object[] {
            BC004527_A1EmpCod, BC004527_A2EmpNom, BC004527_A177EmpCUIT, BC004527_A178EmpDir, BC004527_A180EmpTel, BC004527_n180EmpTel, BC004527_A176EmpCP, BC004527_n176EmpCP, BC004527_A1811EmpPerVacDes, BC004527_A1812EmpPerVacHas,
            BC004527_A532EmpReducc, BC004527_A955EmpLogo, BC004527_n955EmpLogo, BC004527_A958EmpFirma, BC004527_n958EmpFirma, BC004527_A1140EmpAntiguedad, BC004527_A1141EmpPresentismo, BC004527_A1302EmpMesHsPExt, BC004527_n1302EmpMesHsPExt, BC004527_A1524EmpLiqFer,
            BC004527_A1750EmpLiqFerJor, BC004527_A1303EmpDiaHsPExt, BC004527_n1303EmpDiaHsPExt, BC004527_A1556EmpGuarEdadMin, BC004527_A1557EmpGuarEdadMax, BC004527_A1787EmpLiqGan, BC004527_A1792EmpTipoExp, BC004527_A1802EmpPromDesde, BC004527_A1813EmpFracVacAnt, BC004527_A2259EmpVacExpLim,
            BC004527_A2260EmpVacExpTie, BC004527_A2261EmpVacDisMax, BC004527_A2405EmpModTra, BC004527_A2406EmpModEmpl, BC004527_A2407EmpModAuto, BC004527_A957EmpLogoExt, BC004527_n957EmpLogoExt, BC004527_A960EmpFirmaExt, BC004527_n960EmpFirmaExt, BC004527_A956EmpLogoNom,
            BC004527_n956EmpLogoNom, BC004527_A959EmpFirmaNom, BC004527_n959EmpFirmaNom, BC004527_A46PaiCod, BC004527_n46PaiCod, BC004527_A47ProvCod, BC004527_n47ProvCod, BC004527_A48LocCod, BC004527_n48LocCod, BC004527_A3CliCod,
            BC004527_A43ActCodigo, BC004527_n43ActCodigo, BC004527_A45TipEmpleCod, BC004527_n45TipEmpleCod, BC004527_A1151ARTSec, BC004527_A903ActComCodigo, BC004527_A1965EmpOsoCod, BC004527_n1965EmpOsoCod, BC004527_A1533EmpActComercial, BC004527_A44EmpZonCod,
            BC004527_n44EmpZonCod, BC004527_A2265EmpCondiCod
            }
            , new Object[] {
            BC004528_A1EmpCod, BC004528_A2EmpNom, BC004528_A177EmpCUIT, BC004528_A178EmpDir, BC004528_A180EmpTel, BC004528_n180EmpTel, BC004528_A176EmpCP, BC004528_n176EmpCP, BC004528_A1811EmpPerVacDes, BC004528_A1812EmpPerVacHas,
            BC004528_A532EmpReducc, BC004528_A955EmpLogo, BC004528_n955EmpLogo, BC004528_A958EmpFirma, BC004528_n958EmpFirma, BC004528_A1140EmpAntiguedad, BC004528_A1141EmpPresentismo, BC004528_A1302EmpMesHsPExt, BC004528_n1302EmpMesHsPExt, BC004528_A1524EmpLiqFer,
            BC004528_A1750EmpLiqFerJor, BC004528_A1303EmpDiaHsPExt, BC004528_n1303EmpDiaHsPExt, BC004528_A1556EmpGuarEdadMin, BC004528_A1557EmpGuarEdadMax, BC004528_A1787EmpLiqGan, BC004528_A1792EmpTipoExp, BC004528_A1802EmpPromDesde, BC004528_A1813EmpFracVacAnt, BC004528_A2259EmpVacExpLim,
            BC004528_A2260EmpVacExpTie, BC004528_A2261EmpVacDisMax, BC004528_A2405EmpModTra, BC004528_A2406EmpModEmpl, BC004528_A2407EmpModAuto, BC004528_A957EmpLogoExt, BC004528_n957EmpLogoExt, BC004528_A960EmpFirmaExt, BC004528_n960EmpFirmaExt, BC004528_A956EmpLogoNom,
            BC004528_n956EmpLogoNom, BC004528_A959EmpFirmaNom, BC004528_n959EmpFirmaNom, BC004528_A46PaiCod, BC004528_n46PaiCod, BC004528_A47ProvCod, BC004528_n47ProvCod, BC004528_A48LocCod, BC004528_n48LocCod, BC004528_A3CliCod,
            BC004528_A43ActCodigo, BC004528_n43ActCodigo, BC004528_A45TipEmpleCod, BC004528_n45TipEmpleCod, BC004528_A1151ARTSec, BC004528_A903ActComCodigo, BC004528_A1965EmpOsoCod, BC004528_n1965EmpOsoCod, BC004528_A1533EmpActComercial, BC004528_A44EmpZonCod,
            BC004528_n44EmpZonCod, BC004528_A2265EmpCondiCod
            }
            , new Object[] {
            BC004529_A312PaiNom
            }
            , new Object[] {
            BC004530_A322ProvNom
            }
            , new Object[] {
            BC004531_A286LocNom
            }
            , new Object[] {
            BC004532_A3CliCod
            }
            , new Object[] {
            BC004533_A683ActDescripSinAc, BC004533_A108ActDescrip
            }
            , new Object[] {
            BC004534_A530TipEmpleDefIns
            }
            , new Object[] {
            BC004535_A1151ARTSec
            }
            , new Object[] {
            BC004536_A903ActComCodigo
            }
            , new Object[] {
            BC004537_A3CliCod
            }
            , new Object[] {
            BC004538_A1533EmpActComercial
            }
            , new Object[] {
            BC004539_A518EmpZonDescrip
            }
            , new Object[] {
            BC004540_A2265EmpCondiCod
            }
            , new Object[] {
            BC004541_A683ActDescripSinAc, BC004541_A1EmpCod, BC004541_A2EmpNom, BC004541_A177EmpCUIT, BC004541_A178EmpDir, BC004541_A180EmpTel, BC004541_n180EmpTel, BC004541_A176EmpCP, BC004541_n176EmpCP, BC004541_A312PaiNom,
            BC004541_A322ProvNom, BC004541_A1811EmpPerVacDes, BC004541_A1812EmpPerVacHas, BC004541_A286LocNom, BC004541_A108ActDescrip, BC004541_A518EmpZonDescrip, BC004541_A532EmpReducc, BC004541_A530TipEmpleDefIns, BC004541_A955EmpLogo, BC004541_n955EmpLogo,
            BC004541_A958EmpFirma, BC004541_n958EmpFirma, BC004541_A1140EmpAntiguedad, BC004541_A1141EmpPresentismo, BC004541_A1302EmpMesHsPExt, BC004541_n1302EmpMesHsPExt, BC004541_A1524EmpLiqFer, BC004541_A1750EmpLiqFerJor, BC004541_A1303EmpDiaHsPExt, BC004541_n1303EmpDiaHsPExt,
            BC004541_A1556EmpGuarEdadMin, BC004541_A1557EmpGuarEdadMax, BC004541_A1787EmpLiqGan, BC004541_A1792EmpTipoExp, BC004541_A1802EmpPromDesde, BC004541_A1813EmpFracVacAnt, BC004541_A2259EmpVacExpLim, BC004541_A2260EmpVacExpTie, BC004541_A2261EmpVacDisMax, BC004541_A2405EmpModTra,
            BC004541_A2406EmpModEmpl, BC004541_A2407EmpModAuto, BC004541_A957EmpLogoExt, BC004541_n957EmpLogoExt, BC004541_A960EmpFirmaExt, BC004541_n960EmpFirmaExt, BC004541_A956EmpLogoNom, BC004541_n956EmpLogoNom, BC004541_A959EmpFirmaNom, BC004541_n959EmpFirmaNom,
            BC004541_A46PaiCod, BC004541_n46PaiCod, BC004541_A47ProvCod, BC004541_n47ProvCod, BC004541_A48LocCod, BC004541_n48LocCod, BC004541_A3CliCod, BC004541_A43ActCodigo, BC004541_n43ActCodigo, BC004541_A45TipEmpleCod,
            BC004541_n45TipEmpleCod, BC004541_A1151ARTSec, BC004541_A903ActComCodigo, BC004541_A1965EmpOsoCod, BC004541_n1965EmpOsoCod, BC004541_A1533EmpActComercial, BC004541_A44EmpZonCod, BC004541_n44EmpZonCod, BC004541_A2265EmpCondiCod
            }
            , new Object[] {
            BC004542_A3CliCod
            }
            , new Object[] {
            BC004543_A3CliCod
            }
            , new Object[] {
            BC004544_A312PaiNom
            }
            , new Object[] {
            BC004545_A322ProvNom
            }
            , new Object[] {
            BC004546_A286LocNom
            }
            , new Object[] {
            BC004547_A683ActDescripSinAc, BC004547_A108ActDescrip
            }
            , new Object[] {
            BC004548_A530TipEmpleDefIns
            }
            , new Object[] {
            BC004549_A1533EmpActComercial
            }
            , new Object[] {
            BC004550_A518EmpZonDescrip
            }
            , new Object[] {
            BC004551_A1151ARTSec
            }
            , new Object[] {
            BC004552_A903ActComCodigo
            }
            , new Object[] {
            BC004553_A2265EmpCondiCod
            }
            , new Object[] {
            BC004554_A3CliCod, BC004554_A1EmpCod
            }
            , new Object[] {
            BC004555_A1EmpCod, BC004555_A2EmpNom, BC004555_A177EmpCUIT, BC004555_A178EmpDir, BC004555_A180EmpTel, BC004555_n180EmpTel, BC004555_A176EmpCP, BC004555_n176EmpCP, BC004555_A1811EmpPerVacDes, BC004555_A1812EmpPerVacHas,
            BC004555_A532EmpReducc, BC004555_A955EmpLogo, BC004555_n955EmpLogo, BC004555_A958EmpFirma, BC004555_n958EmpFirma, BC004555_A1140EmpAntiguedad, BC004555_A1141EmpPresentismo, BC004555_A1302EmpMesHsPExt, BC004555_n1302EmpMesHsPExt, BC004555_A1524EmpLiqFer,
            BC004555_A1750EmpLiqFerJor, BC004555_A1303EmpDiaHsPExt, BC004555_n1303EmpDiaHsPExt, BC004555_A1556EmpGuarEdadMin, BC004555_A1557EmpGuarEdadMax, BC004555_A1787EmpLiqGan, BC004555_A1792EmpTipoExp, BC004555_A1802EmpPromDesde, BC004555_A1813EmpFracVacAnt, BC004555_A2259EmpVacExpLim,
            BC004555_A2260EmpVacExpTie, BC004555_A2261EmpVacDisMax, BC004555_A2405EmpModTra, BC004555_A2406EmpModEmpl, BC004555_A2407EmpModAuto, BC004555_A957EmpLogoExt, BC004555_n957EmpLogoExt, BC004555_A960EmpFirmaExt, BC004555_n960EmpFirmaExt, BC004555_A956EmpLogoNom,
            BC004555_n956EmpLogoNom, BC004555_A959EmpFirmaNom, BC004555_n959EmpFirmaNom, BC004555_A46PaiCod, BC004555_n46PaiCod, BC004555_A47ProvCod, BC004555_n47ProvCod, BC004555_A48LocCod, BC004555_n48LocCod, BC004555_A3CliCod,
            BC004555_A43ActCodigo, BC004555_n43ActCodigo, BC004555_A45TipEmpleCod, BC004555_n45TipEmpleCod, BC004555_A1151ARTSec, BC004555_A903ActComCodigo, BC004555_A1965EmpOsoCod, BC004555_n1965EmpOsoCod, BC004555_A1533EmpActComercial, BC004555_A44EmpZonCod,
            BC004555_n44EmpZonCod, BC004555_A2265EmpCondiCod
            }
            , new Object[] {
            BC004556_A1EmpCod, BC004556_A2EmpNom, BC004556_A177EmpCUIT, BC004556_A178EmpDir, BC004556_A180EmpTel, BC004556_n180EmpTel, BC004556_A176EmpCP, BC004556_n176EmpCP, BC004556_A1811EmpPerVacDes, BC004556_A1812EmpPerVacHas,
            BC004556_A532EmpReducc, BC004556_A955EmpLogo, BC004556_n955EmpLogo, BC004556_A958EmpFirma, BC004556_n958EmpFirma, BC004556_A1140EmpAntiguedad, BC004556_A1141EmpPresentismo, BC004556_A1302EmpMesHsPExt, BC004556_n1302EmpMesHsPExt, BC004556_A1524EmpLiqFer,
            BC004556_A1750EmpLiqFerJor, BC004556_A1303EmpDiaHsPExt, BC004556_n1303EmpDiaHsPExt, BC004556_A1556EmpGuarEdadMin, BC004556_A1557EmpGuarEdadMax, BC004556_A1787EmpLiqGan, BC004556_A1792EmpTipoExp, BC004556_A1802EmpPromDesde, BC004556_A1813EmpFracVacAnt, BC004556_A2259EmpVacExpLim,
            BC004556_A2260EmpVacExpTie, BC004556_A2261EmpVacDisMax, BC004556_A2405EmpModTra, BC004556_A2406EmpModEmpl, BC004556_A2407EmpModAuto, BC004556_A957EmpLogoExt, BC004556_n957EmpLogoExt, BC004556_A960EmpFirmaExt, BC004556_n960EmpFirmaExt, BC004556_A956EmpLogoNom,
            BC004556_n956EmpLogoNom, BC004556_A959EmpFirmaNom, BC004556_n959EmpFirmaNom, BC004556_A46PaiCod, BC004556_n46PaiCod, BC004556_A47ProvCod, BC004556_n47ProvCod, BC004556_A48LocCod, BC004556_n48LocCod, BC004556_A3CliCod,
            BC004556_A43ActCodigo, BC004556_n43ActCodigo, BC004556_A45TipEmpleCod, BC004556_n45TipEmpleCod, BC004556_A1151ARTSec, BC004556_A903ActComCodigo, BC004556_A1965EmpOsoCod, BC004556_n1965EmpOsoCod, BC004556_A1533EmpActComercial, BC004556_A44EmpZonCod,
            BC004556_n44EmpZonCod, BC004556_A2265EmpCondiCod
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
            }
            , new Object[] {
            BC004562_A312PaiNom
            }
            , new Object[] {
            BC004563_A322ProvNom
            }
            , new Object[] {
            BC004564_A286LocNom
            }
            , new Object[] {
            BC004565_A683ActDescripSinAc, BC004565_A108ActDescrip
            }
            , new Object[] {
            BC004566_A530TipEmpleDefIns
            }
            , new Object[] {
            BC004567_A518EmpZonDescrip
            }
            , new Object[] {
            BC004568_A3CliCod, BC004568_A1EmpCod, BC004568_A2418BanSalCod
            }
            , new Object[] {
            BC004569_A3CliCod, BC004569_A1EmpCod, BC004569_A2380ColaUUID
            }
            , new Object[] {
            BC004570_A3CliCod, BC004570_A1EmpCod, BC004570_A2371LiqBatchLiqNro, BC004570_A2372LiqBatchCod, BC004570_A2373LiqBatchSeccion
            }
            , new Object[] {
            BC004571_A3CliCod, BC004571_A1EmpCod, BC004571_A2370LiqLoteLiqNro, BC004571_A2269LiqLote
            }
            , new Object[] {
            BC004572_A3CliCod, BC004572_A1EmpCod, BC004572_A31LiqNro, BC004572_A2285LinkLegNumero, BC004572_A2277LegLinkTiporec
            }
            , new Object[] {
            BC004573_A3CliCod, BC004573_A1EmpCod, BC004573_A31LiqNro, BC004573_A2183LiqSuc
            }
            , new Object[] {
            BC004574_A3CliCod, BC004574_A1EmpCod, BC004574_A31LiqNro, BC004574_A2145LiqArea
            }
            , new Object[] {
            BC004575_A3CliCod, BC004575_A1EmpCod, BC004575_A31LiqNro, BC004575_A2142LiqPaiConve, BC004575_A2143LiqConvenio
            }
            , new Object[] {
            BC004576_A3CliCod, BC004576_A1EmpCod, BC004576_A1966EmpBanCod
            }
            , new Object[] {
            BC004577_A3CliCod, BC004577_A1EmpCod, BC004577_A1729PeriodoLiq
            }
            , new Object[] {
            BC004578_A3CliCod, BC004578_A1EmpCod, BC004578_A1649LSDSec
            }
            , new Object[] {
            BC004579_A3CliCod, BC004579_A1EmpCod, BC004579_A1562EmpConvePai, BC004579_A1561EmpConveCod
            }
            , new Object[] {
            BC004580_A3CliCod, BC004580_A1EmpCod, BC004580_A1562EmpConvePai, BC004580_A1561EmpConveCod
            }
            , new Object[] {
            BC004581_A3CliCod, BC004581_A1EmpCod, BC004581_A1562EmpConvePai, BC004581_A1561EmpConveCod
            }
            , new Object[] {
            BC004582_A3CliCod, BC004582_A1EmpCod, BC004582_A1562EmpConvePai, BC004582_A1561EmpConveCod
            }
            , new Object[] {
            BC004583_A3CliCod, BC004583_A1EmpCod, BC004583_A1562EmpConvePai, BC004583_A1561EmpConveCod
            }
            , new Object[] {
            BC004584_A3CliCod, BC004584_A1EmpCod, BC004584_A1562EmpConvePai, BC004584_A1561EmpConveCod
            }
            , new Object[] {
            BC004585_A3CliCod, BC004585_A1EmpCod, BC004585_A1562EmpConvePai, BC004585_A1561EmpConveCod
            }
            , new Object[] {
            BC004586_A3CliCod, BC004586_A1EmpCod, BC004586_A1562EmpConvePai, BC004586_A1561EmpConveCod
            }
            , new Object[] {
            BC004587_A3CliCod, BC004587_A1EmpCod, BC004587_A1562EmpConvePai, BC004587_A1561EmpConveCod
            }
            , new Object[] {
            BC004588_A3CliCod, BC004588_A1EmpCod, BC004588_A1562EmpConvePai, BC004588_A1561EmpConveCod
            }
            , new Object[] {
            BC004589_A3CliCod, BC004589_A1EmpCod, BC004589_A1562EmpConvePai, BC004589_A1561EmpConveCod
            }
            , new Object[] {
            BC004590_A3CliCod, BC004590_A1EmpCod, BC004590_A1562EmpConvePai, BC004590_A1561EmpConveCod
            }
            , new Object[] {
            BC004591_A3CliCod, BC004591_A1EmpCod, BC004591_A1562EmpConvePai, BC004591_A1561EmpConveCod
            }
            , new Object[] {
            BC004592_A3CliCod, BC004592_A1EmpCod, BC004592_A1562EmpConvePai, BC004592_A1561EmpConveCod
            }
            , new Object[] {
            BC004593_A3CliCod, BC004593_A1EmpCod, BC004593_A1562EmpConvePai, BC004593_A1561EmpConveCod
            }
            , new Object[] {
            BC004594_A3CliCod, BC004594_A1EmpCod, BC004594_A1562EmpConvePai, BC004594_A1561EmpConveCod
            }
            , new Object[] {
            BC004595_A3CliCod, BC004595_A1EmpCod, BC004595_A1562EmpConvePai, BC004595_A1561EmpConveCod
            }
            , new Object[] {
            BC004596_A3CliCod, BC004596_A1EmpCod, BC004596_A1562EmpConvePai, BC004596_A1561EmpConveCod
            }
            , new Object[] {
            BC004597_A3CliCod, BC004597_A1EmpCod, BC004597_A1562EmpConvePai, BC004597_A1561EmpConveCod
            }
            , new Object[] {
            BC004598_A3CliCod, BC004598_A1EmpCod, BC004598_A1562EmpConvePai, BC004598_A1561EmpConveCod
            }
            , new Object[] {
            BC004599_A3CliCod, BC004599_A1EmpCod, BC004599_A1562EmpConvePai, BC004599_A1561EmpConveCod
            }
            , new Object[] {
            BC0045100_A3CliCod, BC0045100_A1EmpCod, BC0045100_A1562EmpConvePai, BC0045100_A1561EmpConveCod
            }
            , new Object[] {
            BC0045101_A3CliCod, BC0045101_A1EmpCod, BC0045101_A1562EmpConvePai, BC0045101_A1561EmpConveCod
            }
            , new Object[] {
            BC0045102_A3CliCod, BC0045102_A1EmpCod, BC0045102_A1562EmpConvePai, BC0045102_A1561EmpConveCod
            }
            , new Object[] {
            BC0045103_A3CliCod, BC0045103_A1EmpCod, BC0045103_A1562EmpConvePai, BC0045103_A1561EmpConveCod
            }
            , new Object[] {
            BC0045104_A3CliCod, BC0045104_A1EmpCod, BC0045104_A1562EmpConvePai, BC0045104_A1561EmpConveCod
            }
            , new Object[] {
            BC0045105_A3CliCod, BC0045105_A1EmpCod, BC0045105_A1562EmpConvePai, BC0045105_A1561EmpConveCod
            }
            , new Object[] {
            BC0045106_A3CliCod, BC0045106_A1EmpCod, BC0045106_A1562EmpConvePai, BC0045106_A1561EmpConveCod
            }
            , new Object[] {
            BC0045107_A3CliCod, BC0045107_A1EmpCod, BC0045107_A1562EmpConvePai, BC0045107_A1561EmpConveCod
            }
            , new Object[] {
            BC0045108_A3CliCod, BC0045108_A1EmpCod, BC0045108_A1562EmpConvePai, BC0045108_A1561EmpConveCod
            }
            , new Object[] {
            BC0045109_A3CliCod, BC0045109_A1EmpCod, BC0045109_A1562EmpConvePai, BC0045109_A1561EmpConveCod
            }
            , new Object[] {
            BC0045110_A3CliCod, BC0045110_A1EmpCod, BC0045110_A1562EmpConvePai, BC0045110_A1561EmpConveCod
            }
            , new Object[] {
            BC0045111_A3CliCod, BC0045111_A1EmpCod, BC0045111_A1562EmpConvePai, BC0045111_A1561EmpConveCod
            }
            , new Object[] {
            BC0045112_A3CliCod, BC0045112_A1EmpCod, BC0045112_A1562EmpConvePai, BC0045112_A1561EmpConveCod
            }
            , new Object[] {
            BC0045113_A3CliCod, BC0045113_A1EmpCod, BC0045113_A1562EmpConvePai, BC0045113_A1561EmpConveCod
            }
            , new Object[] {
            BC0045114_A3CliCod, BC0045114_A1EmpCod, BC0045114_A1562EmpConvePai, BC0045114_A1561EmpConveCod
            }
            , new Object[] {
            BC0045115_A3CliCod, BC0045115_A1EmpCod, BC0045115_A1562EmpConvePai, BC0045115_A1561EmpConveCod
            }
            , new Object[] {
            BC0045116_A3CliCod, BC0045116_A1EmpCod, BC0045116_A1562EmpConvePai, BC0045116_A1561EmpConveCod
            }
            , new Object[] {
            BC0045117_A3CliCod, BC0045117_A1EmpCod, BC0045117_A1562EmpConvePai, BC0045117_A1561EmpConveCod
            }
            , new Object[] {
            BC0045118_A3CliCod, BC0045118_A1EmpCod, BC0045118_A1562EmpConvePai, BC0045118_A1561EmpConveCod
            }
            , new Object[] {
            BC0045119_A3CliCod, BC0045119_A1EmpCod, BC0045119_A1562EmpConvePai, BC0045119_A1561EmpConveCod
            }
            , new Object[] {
            BC0045120_A3CliCod, BC0045120_A1EmpCod, BC0045120_A1562EmpConvePai, BC0045120_A1561EmpConveCod
            }
            , new Object[] {
            BC0045121_A3CliCod, BC0045121_A1EmpCod, BC0045121_A1562EmpConvePai, BC0045121_A1561EmpConveCod
            }
            , new Object[] {
            BC0045122_A3CliCod, BC0045122_A1EmpCod, BC0045122_A1562EmpConvePai, BC0045122_A1561EmpConveCod
            }
            , new Object[] {
            BC0045123_A3CliCod, BC0045123_A1EmpCod, BC0045123_A1562EmpConvePai, BC0045123_A1561EmpConveCod
            }
            , new Object[] {
            BC0045124_A3CliCod, BC0045124_A1EmpCod, BC0045124_A1562EmpConvePai, BC0045124_A1561EmpConveCod
            }
            , new Object[] {
            BC0045125_A3CliCod, BC0045125_A1EmpCod, BC0045125_A1562EmpConvePai, BC0045125_A1561EmpConveCod
            }
            , new Object[] {
            BC0045126_A3CliCod, BC0045126_A1EmpCod, BC0045126_A1562EmpConvePai, BC0045126_A1561EmpConveCod
            }
            , new Object[] {
            BC0045127_A3CliCod, BC0045127_A1EmpCod, BC0045127_A1562EmpConvePai, BC0045127_A1561EmpConveCod
            }
            , new Object[] {
            BC0045128_A3CliCod, BC0045128_A1EmpCod, BC0045128_A1562EmpConvePai, BC0045128_A1561EmpConveCod
            }
            , new Object[] {
            BC0045129_A3CliCod, BC0045129_A1EmpCod, BC0045129_A1562EmpConvePai, BC0045129_A1561EmpConveCod
            }
            , new Object[] {
            BC0045130_A3CliCod, BC0045130_A1EmpCod, BC0045130_A1562EmpConvePai, BC0045130_A1561EmpConveCod
            }
            , new Object[] {
            BC0045131_A3CliCod, BC0045131_A1EmpCod, BC0045131_A1562EmpConvePai, BC0045131_A1561EmpConveCod
            }
            , new Object[] {
            BC0045132_A3CliCod, BC0045132_A1EmpCod, BC0045132_A1562EmpConvePai, BC0045132_A1561EmpConveCod
            }
            , new Object[] {
            BC0045133_A3CliCod, BC0045133_A1EmpCod, BC0045133_A1562EmpConvePai, BC0045133_A1561EmpConveCod
            }
            , new Object[] {
            BC0045134_A3CliCod, BC0045134_A1EmpCod, BC0045134_A1562EmpConvePai, BC0045134_A1561EmpConveCod
            }
            , new Object[] {
            BC0045135_A3CliCod, BC0045135_A1EmpCod, BC0045135_A1547GuarCod
            }
            , new Object[] {
            BC0045136_A3CliCod, BC0045136_A1EmpCod, BC0045136_A1340EmpHsExSec
            }
            , new Object[] {
            BC0045137_A3CliCod, BC0045137_A1EmpCod, BC0045137_A1243SucCodigo
            }
            , new Object[] {
            BC0045138_A3CliCod, BC0045138_A1EmpCod, BC0045138_A784F1357CTipoPre, BC0045138_A777F1357CPer, BC0045138_A778F1357CSec
            }
            , new Object[] {
            BC0045139_A3CliCod, BC0045139_A1EmpCod, BC0045139_A88ImpLiqSec
            }
            , new Object[] {
            BC0045140_A3CliCod, BC0045140_A1EmpCod, BC0045140_A87MigrLegNumero
            }
            , new Object[] {
            BC0045141_A3CliCod, BC0045141_A1EmpCod, BC0045141_A86TempRecSec
            }
            , new Object[] {
            BC0045142_A3CliCod, BC0045142_A1EmpCod, BC0045142_A85ArchSiradigFec
            }
            , new Object[] {
            BC0045143_A3CliCod, BC0045143_A1EmpCod, BC0045143_A79AsientoCNum
            }
            , new Object[] {
            BC0045144_A3CliCod, BC0045144_A1EmpCod, BC0045144_A78CuenCodigo
            }
            , new Object[] {
            BC0045145_A3CliCod, BC0045145_A1EmpCod, BC0045145_A77CenCodigo
            }
            , new Object[] {
            BC0045146_A3CliCod, BC0045146_A1EmpCod, BC0045146_A31LiqNro, BC0045146_A10LpgCodigo
            }
            , new Object[] {
            BC0045147_A3CliCod, BC0045147_A1EmpCod, BC0045147_A6LegNumero
            }
            , new Object[] {
            BC0045148_A683ActDescripSinAc, BC0045148_A1EmpCod, BC0045148_A2EmpNom, BC0045148_A177EmpCUIT, BC0045148_A178EmpDir, BC0045148_A180EmpTel, BC0045148_n180EmpTel, BC0045148_A176EmpCP, BC0045148_n176EmpCP, BC0045148_A312PaiNom,
            BC0045148_A322ProvNom, BC0045148_A1811EmpPerVacDes, BC0045148_A1812EmpPerVacHas, BC0045148_A286LocNom, BC0045148_A108ActDescrip, BC0045148_A518EmpZonDescrip, BC0045148_A532EmpReducc, BC0045148_A530TipEmpleDefIns, BC0045148_A955EmpLogo, BC0045148_n955EmpLogo,
            BC0045148_A958EmpFirma, BC0045148_n958EmpFirma, BC0045148_A1140EmpAntiguedad, BC0045148_A1141EmpPresentismo, BC0045148_A1302EmpMesHsPExt, BC0045148_n1302EmpMesHsPExt, BC0045148_A1524EmpLiqFer, BC0045148_A1750EmpLiqFerJor, BC0045148_A1303EmpDiaHsPExt, BC0045148_n1303EmpDiaHsPExt,
            BC0045148_A1556EmpGuarEdadMin, BC0045148_A1557EmpGuarEdadMax, BC0045148_A1787EmpLiqGan, BC0045148_A1792EmpTipoExp, BC0045148_A1802EmpPromDesde, BC0045148_A1813EmpFracVacAnt, BC0045148_A2259EmpVacExpLim, BC0045148_A2260EmpVacExpTie, BC0045148_A2261EmpVacDisMax, BC0045148_A2405EmpModTra,
            BC0045148_A2406EmpModEmpl, BC0045148_A2407EmpModAuto, BC0045148_A957EmpLogoExt, BC0045148_n957EmpLogoExt, BC0045148_A960EmpFirmaExt, BC0045148_n960EmpFirmaExt, BC0045148_A956EmpLogoNom, BC0045148_n956EmpLogoNom, BC0045148_A959EmpFirmaNom, BC0045148_n959EmpFirmaNom,
            BC0045148_A46PaiCod, BC0045148_n46PaiCod, BC0045148_A47ProvCod, BC0045148_n47ProvCod, BC0045148_A48LocCod, BC0045148_n48LocCod, BC0045148_A3CliCod, BC0045148_A43ActCodigo, BC0045148_n43ActCodigo, BC0045148_A45TipEmpleCod,
            BC0045148_n45TipEmpleCod, BC0045148_A1151ARTSec, BC0045148_A903ActComCodigo, BC0045148_A1965EmpOsoCod, BC0045148_n1965EmpOsoCod, BC0045148_A1533EmpActComercial, BC0045148_A44EmpZonCod, BC0045148_n44EmpZonCod, BC0045148_A2265EmpCondiCod
            }
            , new Object[] {
            BC0045149_A1370EmpMenHabitual, BC0045149_A3CliCod, BC0045149_A1368EmpMenConCodigo, BC0045149_A1EmpCod
            }
            , new Object[] {
            BC0045150_A26ConCodigo
            }
            , new Object[] {
            BC0045151_A3CliCod, BC0045151_A1EmpCod, BC0045151_A1368EmpMenConCodigo
            }
            , new Object[] {
            BC0045152_A1370EmpMenHabitual, BC0045152_A3CliCod, BC0045152_A1368EmpMenConCodigo, BC0045152_A1EmpCod
            }
            , new Object[] {
            BC0045153_A1370EmpMenHabitual, BC0045153_A3CliCod, BC0045153_A1368EmpMenConCodigo, BC0045153_A1EmpCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0045157_A1370EmpMenHabitual, BC0045157_A3CliCod, BC0045157_A1368EmpMenConCodigo, BC0045157_A1EmpCod
            }
            , new Object[] {
            BC0045158_A1369EmpJorHabitual, BC0045158_A3CliCod, BC0045158_A1366EmpJorConCodigo, BC0045158_A1EmpCod
            }
            , new Object[] {
            BC0045159_A26ConCodigo
            }
            , new Object[] {
            BC0045160_A3CliCod, BC0045160_A1EmpCod, BC0045160_A1366EmpJorConCodigo
            }
            , new Object[] {
            BC0045161_A1369EmpJorHabitual, BC0045161_A3CliCod, BC0045161_A1366EmpJorConCodigo, BC0045161_A1EmpCod
            }
            , new Object[] {
            BC0045162_A1369EmpJorHabitual, BC0045162_A3CliCod, BC0045162_A1366EmpJorConCodigo, BC0045162_A1EmpCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0045166_A1369EmpJorHabitual, BC0045166_A3CliCod, BC0045166_A1366EmpJorConCodigo, BC0045166_A1EmpCod
            }
            , new Object[] {
            BC0045167_A3CliCod, BC0045167_A1EmpCod, BC0045167_A1371EmpPromFijVar, BC0045167_A1372EmpPromHabitual, BC0045167_A37TipoConCod
            }
            , new Object[] {
            BC0045168_A37TipoConCod
            }
            , new Object[] {
            BC0045169_A3CliCod, BC0045169_A1EmpCod, BC0045169_A37TipoConCod, BC0045169_A1371EmpPromFijVar
            }
            , new Object[] {
            BC0045170_A3CliCod, BC0045170_A1EmpCod, BC0045170_A1371EmpPromFijVar, BC0045170_A1372EmpPromHabitual, BC0045170_A37TipoConCod
            }
            , new Object[] {
            BC0045171_A3CliCod, BC0045171_A1EmpCod, BC0045171_A1371EmpPromFijVar, BC0045171_A1372EmpPromHabitual, BC0045171_A37TipoConCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0045175_A3CliCod, BC0045175_A1EmpCod, BC0045175_A1371EmpPromFijVar, BC0045175_A1372EmpPromHabitual, BC0045175_A37TipoConCod
            }
            , new Object[] {
            BC0045176_A3CliCod, BC0045176_A1EmpCod, BC0045176_A1427EmpBaseClaseLeg, BC0045176_A1429EmpBaseTipo, BC0045176_A1430EmpBaseCod1, BC0045176_A1431EmpBaseCod2, BC0045176_A1432EmpBasePlus
            }
            , new Object[] {
            BC0045177_A3CliCod, BC0045177_A1EmpCod, BC0045177_A1427EmpBaseClaseLeg, BC0045177_A1429EmpBaseTipo, BC0045177_A1430EmpBaseCod1, BC0045177_A1431EmpBaseCod2
            }
            , new Object[] {
            BC0045178_A3CliCod, BC0045178_A1EmpCod, BC0045178_A1427EmpBaseClaseLeg, BC0045178_A1429EmpBaseTipo, BC0045178_A1430EmpBaseCod1, BC0045178_A1431EmpBaseCod2, BC0045178_A1432EmpBasePlus
            }
            , new Object[] {
            BC0045179_A3CliCod, BC0045179_A1EmpCod, BC0045179_A1427EmpBaseClaseLeg, BC0045179_A1429EmpBaseTipo, BC0045179_A1430EmpBaseCod1, BC0045179_A1431EmpBaseCod2, BC0045179_A1432EmpBasePlus
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0045183_A3CliCod, BC0045183_A1EmpCod, BC0045183_A1427EmpBaseClaseLeg, BC0045183_A1429EmpBaseTipo, BC0045183_A1430EmpBaseCod1, BC0045183_A1431EmpBaseCod2, BC0045183_A1432EmpBasePlus
            }
            , new Object[] {
            BC0045184_A1340EmpHsExSec, BC0045184_A1341EmpHsPDiaDia, BC0045184_A1342EmpHsPDiaDesde, BC0045184_n1342EmpHsPDiaDesde, BC0045184_A1343EmpTarifaPDia, BC0045184_A1351EmpTarfaPDRec, BC0045184_A3CliCod, BC0045184_A1EmpCod, BC0045184_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            BC0045185_A1294PaiTipoTraId
            }
            , new Object[] {
            BC0045186_A3CliCod, BC0045186_A1EmpCod, BC0045186_A1340EmpHsExSec
            }
            , new Object[] {
            BC0045187_A1340EmpHsExSec, BC0045187_A1341EmpHsPDiaDia, BC0045187_A1342EmpHsPDiaDesde, BC0045187_n1342EmpHsPDiaDesde, BC0045187_A1343EmpTarifaPDia, BC0045187_A1351EmpTarfaPDRec, BC0045187_A3CliCod, BC0045187_A1EmpCod, BC0045187_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            BC0045188_A1340EmpHsExSec, BC0045188_A1341EmpHsPDiaDia, BC0045188_A1342EmpHsPDiaDesde, BC0045188_n1342EmpHsPDiaDesde, BC0045188_A1343EmpTarifaPDia, BC0045188_A1351EmpTarfaPDRec, BC0045188_A3CliCod, BC0045188_A1EmpCod, BC0045188_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0045192_A1340EmpHsExSec, BC0045192_A1341EmpHsPDiaDia, BC0045192_A1342EmpHsPDiaDesde, BC0045192_n1342EmpHsPDiaDesde, BC0045192_A1343EmpTarifaPDia, BC0045192_A1351EmpTarfaPDRec, BC0045192_A3CliCod, BC0045192_A1EmpCod, BC0045192_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            BC0045193_A3CliCod, BC0045193_A1EmpCod, BC0045193_A1344EmpHsDia, BC0045193_A1345EmpHsSem, BC0045193_A1346EmpTarifaXLim, BC0045193_A1352EmpTarifaRec, BC0045193_A1386EmpHsMaxDia, BC0045193_A1387EmpHsMaxSem, BC0045193_A1388EmpHsMaxMes, BC0045193_A1389EmpHsMaxAnu,
            BC0045193_A1294PaiTipoTraId
            }
            , new Object[] {
            BC0045194_A1292TipoTraId
            }
            , new Object[] {
            BC0045195_A3CliCod, BC0045195_A1EmpCod, BC0045195_A1294PaiTipoTraId
            }
            , new Object[] {
            BC0045196_A3CliCod, BC0045196_A1EmpCod, BC0045196_A1344EmpHsDia, BC0045196_A1345EmpHsSem, BC0045196_A1346EmpTarifaXLim, BC0045196_A1352EmpTarifaRec, BC0045196_A1386EmpHsMaxDia, BC0045196_A1387EmpHsMaxSem, BC0045196_A1388EmpHsMaxMes, BC0045196_A1389EmpHsMaxAnu,
            BC0045196_A1294PaiTipoTraId
            }
            , new Object[] {
            BC0045197_A3CliCod, BC0045197_A1EmpCod, BC0045197_A1344EmpHsDia, BC0045197_A1345EmpHsSem, BC0045197_A1346EmpTarifaXLim, BC0045197_A1352EmpTarifaRec, BC0045197_A1386EmpHsMaxDia, BC0045197_A1387EmpHsMaxSem, BC0045197_A1388EmpHsMaxMes, BC0045197_A1389EmpHsMaxAnu,
            BC0045197_A1294PaiTipoTraId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0045201_A3CliCod, BC0045201_A1EmpCod, BC0045201_A1340EmpHsExSec
            }
            , new Object[] {
            BC0045202_A3CliCod, BC0045202_A1EmpCod, BC0045202_A1344EmpHsDia, BC0045202_A1345EmpHsSem, BC0045202_A1346EmpTarifaXLim, BC0045202_A1352EmpTarifaRec, BC0045202_A1386EmpHsMaxDia, BC0045202_A1387EmpHsMaxSem, BC0045202_A1388EmpHsMaxMes, BC0045202_A1389EmpHsMaxAnu,
            BC0045202_A1294PaiTipoTraId
            }
            , new Object[] {
            BC0045203_A3CliCod, BC0045203_A1EmpCod, BC0045203_A1239EmpConvenio
            }
            , new Object[] {
            BC0045204_A3CliCod, BC0045204_A1EmpCod, BC0045204_A1239EmpConvenio
            }
            , new Object[] {
            BC0045205_A3CliCod, BC0045205_A1EmpCod, BC0045205_A1239EmpConvenio
            }
            , new Object[] {
            BC0045206_A3CliCod, BC0045206_A1EmpCod, BC0045206_A1239EmpConvenio
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0045209_A3CliCod, BC0045209_A1EmpCod, BC0045209_A1239EmpConvenio
            }
            , new Object[] {
            BC0045210_A3CliCod, BC0045210_A1EmpCod, BC0045210_A1238EmpOrigen
            }
            , new Object[] {
            BC0045211_A1231OrigId
            }
            , new Object[] {
            BC0045212_A3CliCod, BC0045212_A1EmpCod, BC0045212_A1238EmpOrigen
            }
            , new Object[] {
            BC0045213_A3CliCod, BC0045213_A1EmpCod, BC0045213_A1238EmpOrigen
            }
            , new Object[] {
            BC0045214_A3CliCod, BC0045214_A1EmpCod, BC0045214_A1238EmpOrigen
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0045217_A3CliCod, BC0045217_A1EmpCod, BC0045217_A1238EmpOrigen
            }
            , new Object[] {
            BC0045218_A3CliCod, BC0045218_A1EmpCod, BC0045218_A1237EmpReligion
            }
            , new Object[] {
            BC0045219_A1229ReligId
            }
            , new Object[] {
            BC0045220_A3CliCod, BC0045220_A1EmpCod, BC0045220_A1237EmpReligion
            }
            , new Object[] {
            BC0045221_A3CliCod, BC0045221_A1EmpCod, BC0045221_A1237EmpReligion
            }
            , new Object[] {
            BC0045222_A3CliCod, BC0045222_A1EmpCod, BC0045222_A1237EmpReligion
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC0045225_A3CliCod, BC0045225_A1EmpCod, BC0045225_A1237EmpReligion
            }
            , new Object[] {
            BC0045226_A3CliCod
            }
            , new Object[] {
            BC0045227_A3CliCod
            }
         }
      );
      AV71Pgmname = "Empresa_abm_1_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12452 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z1811EmpPerVacDes ;
   private byte A1811EmpPerVacDes ;
   private byte Z1812EmpPerVacHas ;
   private byte A1812EmpPerVacHas ;
   private byte Z1556EmpGuarEdadMin ;
   private byte A1556EmpGuarEdadMin ;
   private byte Z1557EmpGuarEdadMax ;
   private byte A1557EmpGuarEdadMax ;
   private byte Z1792EmpTipoExp ;
   private byte A1792EmpTipoExp ;
   private byte Z2260EmpVacExpTie ;
   private byte A2260EmpVacExpTie ;
   private byte Gxremove171 ;
   private byte Gxremove172 ;
   private byte Gxremove173 ;
   private byte Gxremove191 ;
   private byte Gxremove165 ;
   private byte Gxremove166 ;
   private byte Gxremove144 ;
   private byte Gxremove145 ;
   private byte Gxremove146 ;
   private byte Gx_BScreen ;
   private byte Z1427EmpBaseClaseLeg ;
   private byte A1427EmpBaseClaseLeg ;
   private byte Z1341EmpHsPDiaDia ;
   private byte A1341EmpHsPDiaDia ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short nIsMod_146 ;
   private short RcdFound146 ;
   private short nIsMod_145 ;
   private short RcdFound145 ;
   private short nIsMod_144 ;
   private short RcdFound144 ;
   private short nIsMod_166 ;
   private short RcdFound166 ;
   private short nIsMod_165 ;
   private short RcdFound165 ;
   private short nIsMod_191 ;
   private short RcdFound191 ;
   private short nIsMod_173 ;
   private short RcdFound173 ;
   private short nIsMod_172 ;
   private short RcdFound172 ;
   private short nIsMod_171 ;
   private short RcdFound171 ;
   private short AV11Insert_PaiCod ;
   private short AV12Insert_ProvCod ;
   private short AV13Insert_LocCod ;
   private short AV46Insert_ARTSec ;
   private short AV70Insert_EmpCondiCod ;
   private short Z46PaiCod ;
   private short A46PaiCod ;
   private short Z47ProvCod ;
   private short A47ProvCod ;
   private short Z48LocCod ;
   private short A48LocCod ;
   private short Z1151ARTSec ;
   private short A1151ARTSec ;
   private short Z2265EmpCondiCod ;
   private short A2265EmpCondiCod ;
   private short RcdFound13 ;
   private short nIsDirty_13 ;
   private short nRcdExists_171 ;
   private short nRcdExists_172 ;
   private short nRcdExists_173 ;
   private short nRcdExists_191 ;
   private short nRcdExists_165 ;
   private short nRcdExists_166 ;
   private short nRcdExists_144 ;
   private short nRcdExists_145 ;
   private short nRcdExists_146 ;
   private short nIsDirty_171 ;
   private short nIsDirty_172 ;
   private short nIsDirty_173 ;
   private short nIsDirty_191 ;
   private short Z1340EmpHsExSec ;
   private short A1340EmpHsExSec ;
   private short nIsDirty_165 ;
   private short nIsDirty_166 ;
   private short nIsDirty_144 ;
   private short nIsDirty_145 ;
   private short nIsDirty_146 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int nGXsfl_146_idx=1 ;
   private int nGXsfl_145_idx=1 ;
   private int nGXsfl_144_idx=1 ;
   private int nGXsfl_166_idx=1 ;
   private int nGXsfl_165_idx=1 ;
   private int nGXsfl_191_idx=1 ;
   private int nGXsfl_173_idx=1 ;
   private int nGXsfl_172_idx=1 ;
   private int nGXsfl_171_idx=1 ;
   private int AV72GXV1 ;
   private int GX_JID ;
   private int Z2261EmpVacDisMax ;
   private int A2261EmpVacDisMax ;
   private long Z177EmpCUIT ;
   private long A177EmpCUIT ;
   private java.math.BigDecimal Z1140EmpAntiguedad ;
   private java.math.BigDecimal A1140EmpAntiguedad ;
   private java.math.BigDecimal Z1141EmpPresentismo ;
   private java.math.BigDecimal A1141EmpPresentismo ;
   private java.math.BigDecimal Z1302EmpMesHsPExt ;
   private java.math.BigDecimal A1302EmpMesHsPExt ;
   private java.math.BigDecimal Z1813EmpFracVacAnt ;
   private java.math.BigDecimal A1813EmpFracVacAnt ;
   private java.math.BigDecimal Z1432EmpBasePlus ;
   private java.math.BigDecimal A1432EmpBasePlus ;
   private java.math.BigDecimal Z1343EmpTarifaPDia ;
   private java.math.BigDecimal A1343EmpTarifaPDia ;
   private java.math.BigDecimal Z1351EmpTarfaPDRec ;
   private java.math.BigDecimal A1351EmpTarfaPDRec ;
   private java.math.BigDecimal Z1344EmpHsDia ;
   private java.math.BigDecimal A1344EmpHsDia ;
   private java.math.BigDecimal Z1345EmpHsSem ;
   private java.math.BigDecimal A1345EmpHsSem ;
   private java.math.BigDecimal Z1346EmpTarifaXLim ;
   private java.math.BigDecimal A1346EmpTarifaXLim ;
   private java.math.BigDecimal Z1352EmpTarifaRec ;
   private java.math.BigDecimal A1352EmpTarifaRec ;
   private java.math.BigDecimal Z1386EmpHsMaxDia ;
   private java.math.BigDecimal A1386EmpHsMaxDia ;
   private java.math.BigDecimal Z1387EmpHsMaxSem ;
   private java.math.BigDecimal A1387EmpHsMaxSem ;
   private java.math.BigDecimal Z1388EmpHsMaxMes ;
   private java.math.BigDecimal A1388EmpHsMaxMes ;
   private java.math.BigDecimal Z1389EmpHsMaxAnu ;
   private java.math.BigDecimal A1389EmpHsMaxAnu ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode13 ;
   private String AV71Pgmname ;
   private String AV14Insert_ActCodigo ;
   private String AV40Insert_TipEmpleCod ;
   private String AV64Insert_EmpActComercial ;
   private String AV36Insert_EmpZonCod ;
   private String AV43Insert_ActComCodigo ;
   private String AV69Insert_EmpOsoCod ;
   private String Z176EmpCP ;
   private String A176EmpCP ;
   private String Z1303EmpDiaHsPExt ;
   private String A1303EmpDiaHsPExt ;
   private String Z1802EmpPromDesde ;
   private String A1802EmpPromDesde ;
   private String Z2405EmpModTra ;
   private String A2405EmpModTra ;
   private String Z43ActCodigo ;
   private String A43ActCodigo ;
   private String Z45TipEmpleCod ;
   private String A45TipEmpleCod ;
   private String Z903ActComCodigo ;
   private String A903ActComCodigo ;
   private String Z1965EmpOsoCod ;
   private String A1965EmpOsoCod ;
   private String Z1533EmpActComercial ;
   private String A1533EmpActComercial ;
   private String Z44EmpZonCod ;
   private String A44EmpZonCod ;
   private String Z530TipEmpleDefIns ;
   private String A530TipEmpleDefIns ;
   private String Z957EmpLogoExt ;
   private String A957EmpLogoExt ;
   private String Z960EmpFirmaExt ;
   private String A960EmpFirmaExt ;
   private String A955EmpLogo_Filetype ;
   private String A958EmpFirma_Filetype ;
   private String A955EmpLogo_Filename ;
   private String A958EmpFirma_Filename ;
   private String Z1368EmpMenConCodigo ;
   private String A1368EmpMenConCodigo ;
   private String sMode171 ;
   private String Z1366EmpJorConCodigo ;
   private String A1366EmpJorConCodigo ;
   private String sMode172 ;
   private String Z1371EmpPromFijVar ;
   private String A1371EmpPromFijVar ;
   private String Z37TipoConCod ;
   private String A37TipoConCod ;
   private String sMode173 ;
   private String Z1429EmpBaseTipo ;
   private String A1429EmpBaseTipo ;
   private String Z1430EmpBaseCod1 ;
   private String A1430EmpBaseCod1 ;
   private String Z1431EmpBaseCod2 ;
   private String A1431EmpBaseCod2 ;
   private String sMode191 ;
   private String Z1342EmpHsPDiaDesde ;
   private String A1342EmpHsPDiaDesde ;
   private String Z1339EmpHsPDiaTipTra ;
   private String A1339EmpHsPDiaTipTra ;
   private String sMode165 ;
   private String Z1294PaiTipoTraId ;
   private String A1294PaiTipoTraId ;
   private String sMode166 ;
   private String Z1239EmpConvenio ;
   private String A1239EmpConvenio ;
   private String sMode144 ;
   private String Z1238EmpOrigen ;
   private String A1238EmpOrigen ;
   private String sMode145 ;
   private String Z1237EmpReligion ;
   private String A1237EmpReligion ;
   private String sMode146 ;
   private String A26ConCodigo ;
   private String A1292TipoTraId ;
   private String A1231OrigId ;
   private String A1229ReligId ;
   private boolean returnInSub ;
   private boolean AV31IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z532EmpReducc ;
   private boolean A532EmpReducc ;
   private boolean Z1524EmpLiqFer ;
   private boolean A1524EmpLiqFer ;
   private boolean Z1750EmpLiqFerJor ;
   private boolean A1750EmpLiqFerJor ;
   private boolean Z1787EmpLiqGan ;
   private boolean A1787EmpLiqGan ;
   private boolean Z2259EmpVacExpLim ;
   private boolean A2259EmpVacExpLim ;
   private boolean Z2406EmpModEmpl ;
   private boolean A2406EmpModEmpl ;
   private boolean Z2407EmpModAuto ;
   private boolean A2407EmpModAuto ;
   private boolean n180EmpTel ;
   private boolean n176EmpCP ;
   private boolean n955EmpLogo ;
   private boolean n958EmpFirma ;
   private boolean n1302EmpMesHsPExt ;
   private boolean n1303EmpDiaHsPExt ;
   private boolean n957EmpLogoExt ;
   private boolean n960EmpFirmaExt ;
   private boolean n956EmpLogoNom ;
   private boolean n959EmpFirmaNom ;
   private boolean n46PaiCod ;
   private boolean n47ProvCod ;
   private boolean n48LocCod ;
   private boolean n43ActCodigo ;
   private boolean n45TipEmpleCod ;
   private boolean n1965EmpOsoCod ;
   private boolean n44EmpZonCod ;
   private boolean Gx_longc ;
   private boolean Z1370EmpMenHabitual ;
   private boolean A1370EmpMenHabitual ;
   private boolean Z1369EmpJorHabitual ;
   private boolean A1369EmpJorHabitual ;
   private boolean Z1372EmpPromHabitual ;
   private boolean A1372EmpPromHabitual ;
   private boolean n1342EmpHsPDiaDesde ;
   private boolean mustCommit ;
   private String Z955EmpLogo ;
   private String A955EmpLogo ;
   private String Z958EmpFirma ;
   private String A958EmpFirma ;
   private String Z2EmpNom ;
   private String A2EmpNom ;
   private String Z178EmpDir ;
   private String A178EmpDir ;
   private String Z180EmpTel ;
   private String A180EmpTel ;
   private String Z312PaiNom ;
   private String A312PaiNom ;
   private String Z322ProvNom ;
   private String A322ProvNom ;
   private String Z286LocNom ;
   private String A286LocNom ;
   private String Z683ActDescripSinAc ;
   private String A683ActDescripSinAc ;
   private String Z108ActDescrip ;
   private String A108ActDescrip ;
   private String Z518EmpZonDescrip ;
   private String A518EmpZonDescrip ;
   private String Z956EmpLogoNom ;
   private String A956EmpLogoNom ;
   private String Z959EmpFirmaNom ;
   private String A959EmpFirmaNom ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private web.SdtEmpresa_abm_1 bcEmpresa_abm_1 ;
   private IDataStoreProvider pr_default ;
   private String[] BC004541_A683ActDescripSinAc ;
   private short[] BC004541_A1EmpCod ;
   private String[] BC004541_A2EmpNom ;
   private long[] BC004541_A177EmpCUIT ;
   private String[] BC004541_A178EmpDir ;
   private String[] BC004541_A180EmpTel ;
   private boolean[] BC004541_n180EmpTel ;
   private String[] BC004541_A176EmpCP ;
   private boolean[] BC004541_n176EmpCP ;
   private String[] BC004541_A312PaiNom ;
   private String[] BC004541_A322ProvNom ;
   private byte[] BC004541_A1811EmpPerVacDes ;
   private byte[] BC004541_A1812EmpPerVacHas ;
   private String[] BC004541_A286LocNom ;
   private String[] BC004541_A108ActDescrip ;
   private String[] BC004541_A518EmpZonDescrip ;
   private boolean[] BC004541_A532EmpReducc ;
   private String[] BC004541_A530TipEmpleDefIns ;
   private String[] BC004541_A955EmpLogo ;
   private boolean[] BC004541_n955EmpLogo ;
   private String[] BC004541_A958EmpFirma ;
   private boolean[] BC004541_n958EmpFirma ;
   private java.math.BigDecimal[] BC004541_A1140EmpAntiguedad ;
   private java.math.BigDecimal[] BC004541_A1141EmpPresentismo ;
   private java.math.BigDecimal[] BC004541_A1302EmpMesHsPExt ;
   private boolean[] BC004541_n1302EmpMesHsPExt ;
   private boolean[] BC004541_A1524EmpLiqFer ;
   private boolean[] BC004541_A1750EmpLiqFerJor ;
   private String[] BC004541_A1303EmpDiaHsPExt ;
   private boolean[] BC004541_n1303EmpDiaHsPExt ;
   private byte[] BC004541_A1556EmpGuarEdadMin ;
   private byte[] BC004541_A1557EmpGuarEdadMax ;
   private boolean[] BC004541_A1787EmpLiqGan ;
   private byte[] BC004541_A1792EmpTipoExp ;
   private String[] BC004541_A1802EmpPromDesde ;
   private java.math.BigDecimal[] BC004541_A1813EmpFracVacAnt ;
   private boolean[] BC004541_A2259EmpVacExpLim ;
   private byte[] BC004541_A2260EmpVacExpTie ;
   private int[] BC004541_A2261EmpVacDisMax ;
   private String[] BC004541_A2405EmpModTra ;
   private boolean[] BC004541_A2406EmpModEmpl ;
   private boolean[] BC004541_A2407EmpModAuto ;
   private String[] BC004541_A957EmpLogoExt ;
   private boolean[] BC004541_n957EmpLogoExt ;
   private String[] BC004541_A960EmpFirmaExt ;
   private boolean[] BC004541_n960EmpFirmaExt ;
   private String[] BC004541_A956EmpLogoNom ;
   private boolean[] BC004541_n956EmpLogoNom ;
   private String[] BC004541_A959EmpFirmaNom ;
   private boolean[] BC004541_n959EmpFirmaNom ;
   private short[] BC004541_A46PaiCod ;
   private boolean[] BC004541_n46PaiCod ;
   private short[] BC004541_A47ProvCod ;
   private boolean[] BC004541_n47ProvCod ;
   private short[] BC004541_A48LocCod ;
   private boolean[] BC004541_n48LocCod ;
   private int[] BC004541_A3CliCod ;
   private String[] BC004541_A43ActCodigo ;
   private boolean[] BC004541_n43ActCodigo ;
   private String[] BC004541_A45TipEmpleCod ;
   private boolean[] BC004541_n45TipEmpleCod ;
   private short[] BC004541_A1151ARTSec ;
   private String[] BC004541_A903ActComCodigo ;
   private String[] BC004541_A1965EmpOsoCod ;
   private boolean[] BC004541_n1965EmpOsoCod ;
   private String[] BC004541_A1533EmpActComercial ;
   private String[] BC004541_A44EmpZonCod ;
   private boolean[] BC004541_n44EmpZonCod ;
   private short[] BC004541_A2265EmpCondiCod ;
   private int[] BC004542_A3CliCod ;
   private int[] BC004543_A3CliCod ;
   private String[] BC004544_A312PaiNom ;
   private String[] BC004545_A322ProvNom ;
   private String[] BC004546_A286LocNom ;
   private String[] BC004547_A683ActDescripSinAc ;
   private String[] BC004547_A108ActDescrip ;
   private String[] BC004548_A530TipEmpleDefIns ;
   private String[] BC004549_A1533EmpActComercial ;
   private String[] BC004550_A518EmpZonDescrip ;
   private short[] BC004551_A1151ARTSec ;
   private String[] BC004552_A903ActComCodigo ;
   private short[] BC004553_A2265EmpCondiCod ;
   private int[] BC004554_A3CliCod ;
   private short[] BC004554_A1EmpCod ;
   private short[] BC004555_A1EmpCod ;
   private String[] BC004555_A2EmpNom ;
   private long[] BC004555_A177EmpCUIT ;
   private String[] BC004555_A178EmpDir ;
   private String[] BC004555_A180EmpTel ;
   private boolean[] BC004555_n180EmpTel ;
   private String[] BC004555_A176EmpCP ;
   private boolean[] BC004555_n176EmpCP ;
   private byte[] BC004555_A1811EmpPerVacDes ;
   private byte[] BC004555_A1812EmpPerVacHas ;
   private boolean[] BC004555_A532EmpReducc ;
   private String[] BC004555_A955EmpLogo ;
   private boolean[] BC004555_n955EmpLogo ;
   private String[] BC004555_A958EmpFirma ;
   private boolean[] BC004555_n958EmpFirma ;
   private java.math.BigDecimal[] BC004555_A1140EmpAntiguedad ;
   private java.math.BigDecimal[] BC004555_A1141EmpPresentismo ;
   private java.math.BigDecimal[] BC004555_A1302EmpMesHsPExt ;
   private boolean[] BC004555_n1302EmpMesHsPExt ;
   private boolean[] BC004555_A1524EmpLiqFer ;
   private boolean[] BC004555_A1750EmpLiqFerJor ;
   private String[] BC004555_A1303EmpDiaHsPExt ;
   private boolean[] BC004555_n1303EmpDiaHsPExt ;
   private byte[] BC004555_A1556EmpGuarEdadMin ;
   private byte[] BC004555_A1557EmpGuarEdadMax ;
   private boolean[] BC004555_A1787EmpLiqGan ;
   private byte[] BC004555_A1792EmpTipoExp ;
   private String[] BC004555_A1802EmpPromDesde ;
   private java.math.BigDecimal[] BC004555_A1813EmpFracVacAnt ;
   private boolean[] BC004555_A2259EmpVacExpLim ;
   private byte[] BC004555_A2260EmpVacExpTie ;
   private int[] BC004555_A2261EmpVacDisMax ;
   private String[] BC004555_A2405EmpModTra ;
   private boolean[] BC004555_A2406EmpModEmpl ;
   private boolean[] BC004555_A2407EmpModAuto ;
   private String[] BC004555_A957EmpLogoExt ;
   private boolean[] BC004555_n957EmpLogoExt ;
   private String[] BC004555_A960EmpFirmaExt ;
   private boolean[] BC004555_n960EmpFirmaExt ;
   private String[] BC004555_A956EmpLogoNom ;
   private boolean[] BC004555_n956EmpLogoNom ;
   private String[] BC004555_A959EmpFirmaNom ;
   private boolean[] BC004555_n959EmpFirmaNom ;
   private short[] BC004555_A46PaiCod ;
   private boolean[] BC004555_n46PaiCod ;
   private short[] BC004555_A47ProvCod ;
   private boolean[] BC004555_n47ProvCod ;
   private short[] BC004555_A48LocCod ;
   private boolean[] BC004555_n48LocCod ;
   private int[] BC004555_A3CliCod ;
   private String[] BC004555_A43ActCodigo ;
   private boolean[] BC004555_n43ActCodigo ;
   private String[] BC004555_A45TipEmpleCod ;
   private boolean[] BC004555_n45TipEmpleCod ;
   private short[] BC004555_A1151ARTSec ;
   private String[] BC004555_A903ActComCodigo ;
   private String[] BC004555_A1965EmpOsoCod ;
   private boolean[] BC004555_n1965EmpOsoCod ;
   private String[] BC004555_A1533EmpActComercial ;
   private String[] BC004555_A44EmpZonCod ;
   private boolean[] BC004555_n44EmpZonCod ;
   private short[] BC004555_A2265EmpCondiCod ;
   private short[] BC004556_A1EmpCod ;
   private String[] BC004556_A2EmpNom ;
   private long[] BC004556_A177EmpCUIT ;
   private String[] BC004556_A178EmpDir ;
   private String[] BC004556_A180EmpTel ;
   private boolean[] BC004556_n180EmpTel ;
   private String[] BC004556_A176EmpCP ;
   private boolean[] BC004556_n176EmpCP ;
   private byte[] BC004556_A1811EmpPerVacDes ;
   private byte[] BC004556_A1812EmpPerVacHas ;
   private boolean[] BC004556_A532EmpReducc ;
   private String[] BC004556_A955EmpLogo ;
   private boolean[] BC004556_n955EmpLogo ;
   private String[] BC004556_A958EmpFirma ;
   private boolean[] BC004556_n958EmpFirma ;
   private java.math.BigDecimal[] BC004556_A1140EmpAntiguedad ;
   private java.math.BigDecimal[] BC004556_A1141EmpPresentismo ;
   private java.math.BigDecimal[] BC004556_A1302EmpMesHsPExt ;
   private boolean[] BC004556_n1302EmpMesHsPExt ;
   private boolean[] BC004556_A1524EmpLiqFer ;
   private boolean[] BC004556_A1750EmpLiqFerJor ;
   private String[] BC004556_A1303EmpDiaHsPExt ;
   private boolean[] BC004556_n1303EmpDiaHsPExt ;
   private byte[] BC004556_A1556EmpGuarEdadMin ;
   private byte[] BC004556_A1557EmpGuarEdadMax ;
   private boolean[] BC004556_A1787EmpLiqGan ;
   private byte[] BC004556_A1792EmpTipoExp ;
   private String[] BC004556_A1802EmpPromDesde ;
   private java.math.BigDecimal[] BC004556_A1813EmpFracVacAnt ;
   private boolean[] BC004556_A2259EmpVacExpLim ;
   private byte[] BC004556_A2260EmpVacExpTie ;
   private int[] BC004556_A2261EmpVacDisMax ;
   private String[] BC004556_A2405EmpModTra ;
   private boolean[] BC004556_A2406EmpModEmpl ;
   private boolean[] BC004556_A2407EmpModAuto ;
   private String[] BC004556_A957EmpLogoExt ;
   private boolean[] BC004556_n957EmpLogoExt ;
   private String[] BC004556_A960EmpFirmaExt ;
   private boolean[] BC004556_n960EmpFirmaExt ;
   private String[] BC004556_A956EmpLogoNom ;
   private boolean[] BC004556_n956EmpLogoNom ;
   private String[] BC004556_A959EmpFirmaNom ;
   private boolean[] BC004556_n959EmpFirmaNom ;
   private short[] BC004556_A46PaiCod ;
   private boolean[] BC004556_n46PaiCod ;
   private short[] BC004556_A47ProvCod ;
   private boolean[] BC004556_n47ProvCod ;
   private short[] BC004556_A48LocCod ;
   private boolean[] BC004556_n48LocCod ;
   private int[] BC004556_A3CliCod ;
   private String[] BC004556_A43ActCodigo ;
   private boolean[] BC004556_n43ActCodigo ;
   private String[] BC004556_A45TipEmpleCod ;
   private boolean[] BC004556_n45TipEmpleCod ;
   private short[] BC004556_A1151ARTSec ;
   private String[] BC004556_A903ActComCodigo ;
   private String[] BC004556_A1965EmpOsoCod ;
   private boolean[] BC004556_n1965EmpOsoCod ;
   private String[] BC004556_A1533EmpActComercial ;
   private String[] BC004556_A44EmpZonCod ;
   private boolean[] BC004556_n44EmpZonCod ;
   private short[] BC004556_A2265EmpCondiCod ;
   private String[] BC004562_A312PaiNom ;
   private String[] BC004563_A322ProvNom ;
   private String[] BC004564_A286LocNom ;
   private String[] BC004565_A683ActDescripSinAc ;
   private String[] BC004565_A108ActDescrip ;
   private String[] BC004566_A530TipEmpleDefIns ;
   private String[] BC004567_A518EmpZonDescrip ;
   private int[] BC004568_A3CliCod ;
   private short[] BC004568_A1EmpCod ;
   private java.util.UUID[] BC004568_A2418BanSalCod ;
   private int[] BC004569_A3CliCod ;
   private short[] BC004569_A1EmpCod ;
   private java.util.UUID[] BC004569_A2380ColaUUID ;
   private int[] BC004570_A3CliCod ;
   private short[] BC004570_A1EmpCod ;
   private int[] BC004570_A2371LiqBatchLiqNro ;
   private String[] BC004570_A2372LiqBatchCod ;
   private String[] BC004570_A2373LiqBatchSeccion ;
   private int[] BC004571_A3CliCod ;
   private short[] BC004571_A1EmpCod ;
   private int[] BC004571_A2370LiqLoteLiqNro ;
   private String[] BC004571_A2269LiqLote ;
   private int[] BC004572_A3CliCod ;
   private short[] BC004572_A1EmpCod ;
   private int[] BC004572_A31LiqNro ;
   private int[] BC004572_A2285LinkLegNumero ;
   private String[] BC004572_A2277LegLinkTiporec ;
   private int[] BC004573_A3CliCod ;
   private short[] BC004573_A1EmpCod ;
   private int[] BC004573_A31LiqNro ;
   private String[] BC004573_A2183LiqSuc ;
   private int[] BC004574_A3CliCod ;
   private short[] BC004574_A1EmpCod ;
   private int[] BC004574_A31LiqNro ;
   private String[] BC004574_A2145LiqArea ;
   private int[] BC004575_A3CliCod ;
   private short[] BC004575_A1EmpCod ;
   private int[] BC004575_A31LiqNro ;
   private short[] BC004575_A2142LiqPaiConve ;
   private String[] BC004575_A2143LiqConvenio ;
   private int[] BC004576_A3CliCod ;
   private short[] BC004576_A1EmpCod ;
   private String[] BC004576_A1966EmpBanCod ;
   private int[] BC004577_A3CliCod ;
   private short[] BC004577_A1EmpCod ;
   private java.util.Date[] BC004577_A1729PeriodoLiq ;
   private int[] BC004578_A3CliCod ;
   private short[] BC004578_A1EmpCod ;
   private int[] BC004578_A1649LSDSec ;
   private int[] BC004579_A3CliCod ;
   private short[] BC004579_A1EmpCod ;
   private short[] BC004579_A1562EmpConvePai ;
   private String[] BC004579_A1561EmpConveCod ;
   private int[] BC004580_A3CliCod ;
   private short[] BC004580_A1EmpCod ;
   private short[] BC004580_A1562EmpConvePai ;
   private String[] BC004580_A1561EmpConveCod ;
   private int[] BC004581_A3CliCod ;
   private short[] BC004581_A1EmpCod ;
   private short[] BC004581_A1562EmpConvePai ;
   private String[] BC004581_A1561EmpConveCod ;
   private int[] BC004582_A3CliCod ;
   private short[] BC004582_A1EmpCod ;
   private short[] BC004582_A1562EmpConvePai ;
   private String[] BC004582_A1561EmpConveCod ;
   private int[] BC004583_A3CliCod ;
   private short[] BC004583_A1EmpCod ;
   private short[] BC004583_A1562EmpConvePai ;
   private String[] BC004583_A1561EmpConveCod ;
   private int[] BC004584_A3CliCod ;
   private short[] BC004584_A1EmpCod ;
   private short[] BC004584_A1562EmpConvePai ;
   private String[] BC004584_A1561EmpConveCod ;
   private int[] BC004585_A3CliCod ;
   private short[] BC004585_A1EmpCod ;
   private short[] BC004585_A1562EmpConvePai ;
   private String[] BC004585_A1561EmpConveCod ;
   private int[] BC004586_A3CliCod ;
   private short[] BC004586_A1EmpCod ;
   private short[] BC004586_A1562EmpConvePai ;
   private String[] BC004586_A1561EmpConveCod ;
   private int[] BC004587_A3CliCod ;
   private short[] BC004587_A1EmpCod ;
   private short[] BC004587_A1562EmpConvePai ;
   private String[] BC004587_A1561EmpConveCod ;
   private int[] BC004588_A3CliCod ;
   private short[] BC004588_A1EmpCod ;
   private short[] BC004588_A1562EmpConvePai ;
   private String[] BC004588_A1561EmpConveCod ;
   private int[] BC004589_A3CliCod ;
   private short[] BC004589_A1EmpCod ;
   private short[] BC004589_A1562EmpConvePai ;
   private String[] BC004589_A1561EmpConveCod ;
   private int[] BC004590_A3CliCod ;
   private short[] BC004590_A1EmpCod ;
   private short[] BC004590_A1562EmpConvePai ;
   private String[] BC004590_A1561EmpConveCod ;
   private int[] BC004591_A3CliCod ;
   private short[] BC004591_A1EmpCod ;
   private short[] BC004591_A1562EmpConvePai ;
   private String[] BC004591_A1561EmpConveCod ;
   private int[] BC004592_A3CliCod ;
   private short[] BC004592_A1EmpCod ;
   private short[] BC004592_A1562EmpConvePai ;
   private String[] BC004592_A1561EmpConveCod ;
   private int[] BC004593_A3CliCod ;
   private short[] BC004593_A1EmpCod ;
   private short[] BC004593_A1562EmpConvePai ;
   private String[] BC004593_A1561EmpConveCod ;
   private int[] BC004594_A3CliCod ;
   private short[] BC004594_A1EmpCod ;
   private short[] BC004594_A1562EmpConvePai ;
   private String[] BC004594_A1561EmpConveCod ;
   private int[] BC004595_A3CliCod ;
   private short[] BC004595_A1EmpCod ;
   private short[] BC004595_A1562EmpConvePai ;
   private String[] BC004595_A1561EmpConveCod ;
   private int[] BC004596_A3CliCod ;
   private short[] BC004596_A1EmpCod ;
   private short[] BC004596_A1562EmpConvePai ;
   private String[] BC004596_A1561EmpConveCod ;
   private int[] BC004597_A3CliCod ;
   private short[] BC004597_A1EmpCod ;
   private short[] BC004597_A1562EmpConvePai ;
   private String[] BC004597_A1561EmpConveCod ;
   private int[] BC004598_A3CliCod ;
   private short[] BC004598_A1EmpCod ;
   private short[] BC004598_A1562EmpConvePai ;
   private String[] BC004598_A1561EmpConveCod ;
   private int[] BC004599_A3CliCod ;
   private short[] BC004599_A1EmpCod ;
   private short[] BC004599_A1562EmpConvePai ;
   private String[] BC004599_A1561EmpConveCod ;
   private int[] BC0045100_A3CliCod ;
   private short[] BC0045100_A1EmpCod ;
   private short[] BC0045100_A1562EmpConvePai ;
   private String[] BC0045100_A1561EmpConveCod ;
   private int[] BC0045101_A3CliCod ;
   private short[] BC0045101_A1EmpCod ;
   private short[] BC0045101_A1562EmpConvePai ;
   private String[] BC0045101_A1561EmpConveCod ;
   private int[] BC0045102_A3CliCod ;
   private short[] BC0045102_A1EmpCod ;
   private short[] BC0045102_A1562EmpConvePai ;
   private String[] BC0045102_A1561EmpConveCod ;
   private int[] BC0045103_A3CliCod ;
   private short[] BC0045103_A1EmpCod ;
   private short[] BC0045103_A1562EmpConvePai ;
   private String[] BC0045103_A1561EmpConveCod ;
   private int[] BC0045104_A3CliCod ;
   private short[] BC0045104_A1EmpCod ;
   private short[] BC0045104_A1562EmpConvePai ;
   private String[] BC0045104_A1561EmpConveCod ;
   private int[] BC0045105_A3CliCod ;
   private short[] BC0045105_A1EmpCod ;
   private short[] BC0045105_A1562EmpConvePai ;
   private String[] BC0045105_A1561EmpConveCod ;
   private int[] BC0045106_A3CliCod ;
   private short[] BC0045106_A1EmpCod ;
   private short[] BC0045106_A1562EmpConvePai ;
   private String[] BC0045106_A1561EmpConveCod ;
   private int[] BC0045107_A3CliCod ;
   private short[] BC0045107_A1EmpCod ;
   private short[] BC0045107_A1562EmpConvePai ;
   private String[] BC0045107_A1561EmpConveCod ;
   private int[] BC0045108_A3CliCod ;
   private short[] BC0045108_A1EmpCod ;
   private short[] BC0045108_A1562EmpConvePai ;
   private String[] BC0045108_A1561EmpConveCod ;
   private int[] BC0045109_A3CliCod ;
   private short[] BC0045109_A1EmpCod ;
   private short[] BC0045109_A1562EmpConvePai ;
   private String[] BC0045109_A1561EmpConveCod ;
   private int[] BC0045110_A3CliCod ;
   private short[] BC0045110_A1EmpCod ;
   private short[] BC0045110_A1562EmpConvePai ;
   private String[] BC0045110_A1561EmpConveCod ;
   private int[] BC0045111_A3CliCod ;
   private short[] BC0045111_A1EmpCod ;
   private short[] BC0045111_A1562EmpConvePai ;
   private String[] BC0045111_A1561EmpConveCod ;
   private int[] BC0045112_A3CliCod ;
   private short[] BC0045112_A1EmpCod ;
   private short[] BC0045112_A1562EmpConvePai ;
   private String[] BC0045112_A1561EmpConveCod ;
   private int[] BC0045113_A3CliCod ;
   private short[] BC0045113_A1EmpCod ;
   private short[] BC0045113_A1562EmpConvePai ;
   private String[] BC0045113_A1561EmpConveCod ;
   private int[] BC0045114_A3CliCod ;
   private short[] BC0045114_A1EmpCod ;
   private short[] BC0045114_A1562EmpConvePai ;
   private String[] BC0045114_A1561EmpConveCod ;
   private int[] BC0045115_A3CliCod ;
   private short[] BC0045115_A1EmpCod ;
   private short[] BC0045115_A1562EmpConvePai ;
   private String[] BC0045115_A1561EmpConveCod ;
   private int[] BC0045116_A3CliCod ;
   private short[] BC0045116_A1EmpCod ;
   private short[] BC0045116_A1562EmpConvePai ;
   private String[] BC0045116_A1561EmpConveCod ;
   private int[] BC0045117_A3CliCod ;
   private short[] BC0045117_A1EmpCod ;
   private short[] BC0045117_A1562EmpConvePai ;
   private String[] BC0045117_A1561EmpConveCod ;
   private int[] BC0045118_A3CliCod ;
   private short[] BC0045118_A1EmpCod ;
   private short[] BC0045118_A1562EmpConvePai ;
   private String[] BC0045118_A1561EmpConveCod ;
   private int[] BC0045119_A3CliCod ;
   private short[] BC0045119_A1EmpCod ;
   private short[] BC0045119_A1562EmpConvePai ;
   private String[] BC0045119_A1561EmpConveCod ;
   private int[] BC0045120_A3CliCod ;
   private short[] BC0045120_A1EmpCod ;
   private short[] BC0045120_A1562EmpConvePai ;
   private String[] BC0045120_A1561EmpConveCod ;
   private int[] BC0045121_A3CliCod ;
   private short[] BC0045121_A1EmpCod ;
   private short[] BC0045121_A1562EmpConvePai ;
   private String[] BC0045121_A1561EmpConveCod ;
   private int[] BC0045122_A3CliCod ;
   private short[] BC0045122_A1EmpCod ;
   private short[] BC0045122_A1562EmpConvePai ;
   private String[] BC0045122_A1561EmpConveCod ;
   private int[] BC0045123_A3CliCod ;
   private short[] BC0045123_A1EmpCod ;
   private short[] BC0045123_A1562EmpConvePai ;
   private String[] BC0045123_A1561EmpConveCod ;
   private int[] BC0045124_A3CliCod ;
   private short[] BC0045124_A1EmpCod ;
   private short[] BC0045124_A1562EmpConvePai ;
   private String[] BC0045124_A1561EmpConveCod ;
   private int[] BC0045125_A3CliCod ;
   private short[] BC0045125_A1EmpCod ;
   private short[] BC0045125_A1562EmpConvePai ;
   private String[] BC0045125_A1561EmpConveCod ;
   private int[] BC0045126_A3CliCod ;
   private short[] BC0045126_A1EmpCod ;
   private short[] BC0045126_A1562EmpConvePai ;
   private String[] BC0045126_A1561EmpConveCod ;
   private int[] BC0045127_A3CliCod ;
   private short[] BC0045127_A1EmpCod ;
   private short[] BC0045127_A1562EmpConvePai ;
   private String[] BC0045127_A1561EmpConveCod ;
   private int[] BC0045128_A3CliCod ;
   private short[] BC0045128_A1EmpCod ;
   private short[] BC0045128_A1562EmpConvePai ;
   private String[] BC0045128_A1561EmpConveCod ;
   private int[] BC0045129_A3CliCod ;
   private short[] BC0045129_A1EmpCod ;
   private short[] BC0045129_A1562EmpConvePai ;
   private String[] BC0045129_A1561EmpConveCod ;
   private int[] BC0045130_A3CliCod ;
   private short[] BC0045130_A1EmpCod ;
   private short[] BC0045130_A1562EmpConvePai ;
   private String[] BC0045130_A1561EmpConveCod ;
   private int[] BC0045131_A3CliCod ;
   private short[] BC0045131_A1EmpCod ;
   private short[] BC0045131_A1562EmpConvePai ;
   private String[] BC0045131_A1561EmpConveCod ;
   private int[] BC0045132_A3CliCod ;
   private short[] BC0045132_A1EmpCod ;
   private short[] BC0045132_A1562EmpConvePai ;
   private String[] BC0045132_A1561EmpConveCod ;
   private int[] BC0045133_A3CliCod ;
   private short[] BC0045133_A1EmpCod ;
   private short[] BC0045133_A1562EmpConvePai ;
   private String[] BC0045133_A1561EmpConveCod ;
   private int[] BC0045134_A3CliCod ;
   private short[] BC0045134_A1EmpCod ;
   private short[] BC0045134_A1562EmpConvePai ;
   private String[] BC0045134_A1561EmpConveCod ;
   private int[] BC0045135_A3CliCod ;
   private short[] BC0045135_A1EmpCod ;
   private short[] BC0045135_A1547GuarCod ;
   private int[] BC0045136_A3CliCod ;
   private short[] BC0045136_A1EmpCod ;
   private short[] BC0045136_A1340EmpHsExSec ;
   private int[] BC0045137_A3CliCod ;
   private short[] BC0045137_A1EmpCod ;
   private String[] BC0045137_A1243SucCodigo ;
   private int[] BC0045138_A3CliCod ;
   private short[] BC0045138_A1EmpCod ;
   private byte[] BC0045138_A784F1357CTipoPre ;
   private String[] BC0045138_A777F1357CPer ;
   private byte[] BC0045138_A778F1357CSec ;
   private int[] BC0045139_A3CliCod ;
   private short[] BC0045139_A1EmpCod ;
   private short[] BC0045139_A88ImpLiqSec ;
   private int[] BC0045140_A3CliCod ;
   private short[] BC0045140_A1EmpCod ;
   private int[] BC0045140_A87MigrLegNumero ;
   private int[] BC0045141_A3CliCod ;
   private short[] BC0045141_A1EmpCod ;
   private short[] BC0045141_A86TempRecSec ;
   private int[] BC0045142_A3CliCod ;
   private short[] BC0045142_A1EmpCod ;
   private java.util.Date[] BC0045142_A85ArchSiradigFec ;
   private int[] BC0045143_A3CliCod ;
   private short[] BC0045143_A1EmpCod ;
   private int[] BC0045143_A79AsientoCNum ;
   private int[] BC0045144_A3CliCod ;
   private short[] BC0045144_A1EmpCod ;
   private String[] BC0045144_A78CuenCodigo ;
   private int[] BC0045145_A3CliCod ;
   private short[] BC0045145_A1EmpCod ;
   private short[] BC0045145_A77CenCodigo ;
   private int[] BC0045146_A3CliCod ;
   private short[] BC0045146_A1EmpCod ;
   private int[] BC0045146_A31LiqNro ;
   private String[] BC0045146_A10LpgCodigo ;
   private int[] BC0045147_A3CliCod ;
   private short[] BC0045147_A1EmpCod ;
   private int[] BC0045147_A6LegNumero ;
   private String[] BC0045148_A683ActDescripSinAc ;
   private short[] BC0045148_A1EmpCod ;
   private String[] BC0045148_A2EmpNom ;
   private long[] BC0045148_A177EmpCUIT ;
   private String[] BC0045148_A178EmpDir ;
   private String[] BC0045148_A180EmpTel ;
   private boolean[] BC0045148_n180EmpTel ;
   private String[] BC0045148_A176EmpCP ;
   private boolean[] BC0045148_n176EmpCP ;
   private String[] BC0045148_A312PaiNom ;
   private String[] BC0045148_A322ProvNom ;
   private byte[] BC0045148_A1811EmpPerVacDes ;
   private byte[] BC0045148_A1812EmpPerVacHas ;
   private String[] BC0045148_A286LocNom ;
   private String[] BC0045148_A108ActDescrip ;
   private String[] BC0045148_A518EmpZonDescrip ;
   private boolean[] BC0045148_A532EmpReducc ;
   private String[] BC0045148_A530TipEmpleDefIns ;
   private String[] BC0045148_A955EmpLogo ;
   private boolean[] BC0045148_n955EmpLogo ;
   private String[] BC0045148_A958EmpFirma ;
   private boolean[] BC0045148_n958EmpFirma ;
   private java.math.BigDecimal[] BC0045148_A1140EmpAntiguedad ;
   private java.math.BigDecimal[] BC0045148_A1141EmpPresentismo ;
   private java.math.BigDecimal[] BC0045148_A1302EmpMesHsPExt ;
   private boolean[] BC0045148_n1302EmpMesHsPExt ;
   private boolean[] BC0045148_A1524EmpLiqFer ;
   private boolean[] BC0045148_A1750EmpLiqFerJor ;
   private String[] BC0045148_A1303EmpDiaHsPExt ;
   private boolean[] BC0045148_n1303EmpDiaHsPExt ;
   private byte[] BC0045148_A1556EmpGuarEdadMin ;
   private byte[] BC0045148_A1557EmpGuarEdadMax ;
   private boolean[] BC0045148_A1787EmpLiqGan ;
   private byte[] BC0045148_A1792EmpTipoExp ;
   private String[] BC0045148_A1802EmpPromDesde ;
   private java.math.BigDecimal[] BC0045148_A1813EmpFracVacAnt ;
   private boolean[] BC0045148_A2259EmpVacExpLim ;
   private byte[] BC0045148_A2260EmpVacExpTie ;
   private int[] BC0045148_A2261EmpVacDisMax ;
   private String[] BC0045148_A2405EmpModTra ;
   private boolean[] BC0045148_A2406EmpModEmpl ;
   private boolean[] BC0045148_A2407EmpModAuto ;
   private String[] BC0045148_A957EmpLogoExt ;
   private boolean[] BC0045148_n957EmpLogoExt ;
   private String[] BC0045148_A960EmpFirmaExt ;
   private boolean[] BC0045148_n960EmpFirmaExt ;
   private String[] BC0045148_A956EmpLogoNom ;
   private boolean[] BC0045148_n956EmpLogoNom ;
   private String[] BC0045148_A959EmpFirmaNom ;
   private boolean[] BC0045148_n959EmpFirmaNom ;
   private short[] BC0045148_A46PaiCod ;
   private boolean[] BC0045148_n46PaiCod ;
   private short[] BC0045148_A47ProvCod ;
   private boolean[] BC0045148_n47ProvCod ;
   private short[] BC0045148_A48LocCod ;
   private boolean[] BC0045148_n48LocCod ;
   private int[] BC0045148_A3CliCod ;
   private String[] BC0045148_A43ActCodigo ;
   private boolean[] BC0045148_n43ActCodigo ;
   private String[] BC0045148_A45TipEmpleCod ;
   private boolean[] BC0045148_n45TipEmpleCod ;
   private short[] BC0045148_A1151ARTSec ;
   private String[] BC0045148_A903ActComCodigo ;
   private String[] BC0045148_A1965EmpOsoCod ;
   private boolean[] BC0045148_n1965EmpOsoCod ;
   private String[] BC0045148_A1533EmpActComercial ;
   private String[] BC0045148_A44EmpZonCod ;
   private boolean[] BC0045148_n44EmpZonCod ;
   private short[] BC0045148_A2265EmpCondiCod ;
   private boolean[] BC0045149_A1370EmpMenHabitual ;
   private int[] BC0045149_A3CliCod ;
   private String[] BC0045149_A1368EmpMenConCodigo ;
   private short[] BC0045149_A1EmpCod ;
   private String[] BC0045150_A26ConCodigo ;
   private int[] BC0045151_A3CliCod ;
   private short[] BC0045151_A1EmpCod ;
   private String[] BC0045151_A1368EmpMenConCodigo ;
   private boolean[] BC0045152_A1370EmpMenHabitual ;
   private int[] BC0045152_A3CliCod ;
   private String[] BC0045152_A1368EmpMenConCodigo ;
   private short[] BC0045152_A1EmpCod ;
   private boolean[] BC0045153_A1370EmpMenHabitual ;
   private int[] BC0045153_A3CliCod ;
   private String[] BC0045153_A1368EmpMenConCodigo ;
   private short[] BC0045153_A1EmpCod ;
   private boolean[] BC0045157_A1370EmpMenHabitual ;
   private int[] BC0045157_A3CliCod ;
   private String[] BC0045157_A1368EmpMenConCodigo ;
   private short[] BC0045157_A1EmpCod ;
   private boolean[] BC0045158_A1369EmpJorHabitual ;
   private int[] BC0045158_A3CliCod ;
   private String[] BC0045158_A1366EmpJorConCodigo ;
   private short[] BC0045158_A1EmpCod ;
   private String[] BC0045159_A26ConCodigo ;
   private int[] BC0045160_A3CliCod ;
   private short[] BC0045160_A1EmpCod ;
   private String[] BC0045160_A1366EmpJorConCodigo ;
   private boolean[] BC0045161_A1369EmpJorHabitual ;
   private int[] BC0045161_A3CliCod ;
   private String[] BC0045161_A1366EmpJorConCodigo ;
   private short[] BC0045161_A1EmpCod ;
   private boolean[] BC0045162_A1369EmpJorHabitual ;
   private int[] BC0045162_A3CliCod ;
   private String[] BC0045162_A1366EmpJorConCodigo ;
   private short[] BC0045162_A1EmpCod ;
   private boolean[] BC0045166_A1369EmpJorHabitual ;
   private int[] BC0045166_A3CliCod ;
   private String[] BC0045166_A1366EmpJorConCodigo ;
   private short[] BC0045166_A1EmpCod ;
   private int[] BC0045167_A3CliCod ;
   private short[] BC0045167_A1EmpCod ;
   private String[] BC0045167_A1371EmpPromFijVar ;
   private boolean[] BC0045167_A1372EmpPromHabitual ;
   private String[] BC0045167_A37TipoConCod ;
   private String[] BC0045168_A37TipoConCod ;
   private int[] BC0045169_A3CliCod ;
   private short[] BC0045169_A1EmpCod ;
   private String[] BC0045169_A37TipoConCod ;
   private String[] BC0045169_A1371EmpPromFijVar ;
   private int[] BC0045170_A3CliCod ;
   private short[] BC0045170_A1EmpCod ;
   private String[] BC0045170_A1371EmpPromFijVar ;
   private boolean[] BC0045170_A1372EmpPromHabitual ;
   private String[] BC0045170_A37TipoConCod ;
   private int[] BC0045171_A3CliCod ;
   private short[] BC0045171_A1EmpCod ;
   private String[] BC0045171_A1371EmpPromFijVar ;
   private boolean[] BC0045171_A1372EmpPromHabitual ;
   private String[] BC0045171_A37TipoConCod ;
   private int[] BC0045175_A3CliCod ;
   private short[] BC0045175_A1EmpCod ;
   private String[] BC0045175_A1371EmpPromFijVar ;
   private boolean[] BC0045175_A1372EmpPromHabitual ;
   private String[] BC0045175_A37TipoConCod ;
   private int[] BC0045176_A3CliCod ;
   private short[] BC0045176_A1EmpCod ;
   private byte[] BC0045176_A1427EmpBaseClaseLeg ;
   private String[] BC0045176_A1429EmpBaseTipo ;
   private String[] BC0045176_A1430EmpBaseCod1 ;
   private String[] BC0045176_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] BC0045176_A1432EmpBasePlus ;
   private int[] BC0045177_A3CliCod ;
   private short[] BC0045177_A1EmpCod ;
   private byte[] BC0045177_A1427EmpBaseClaseLeg ;
   private String[] BC0045177_A1429EmpBaseTipo ;
   private String[] BC0045177_A1430EmpBaseCod1 ;
   private String[] BC0045177_A1431EmpBaseCod2 ;
   private int[] BC0045178_A3CliCod ;
   private short[] BC0045178_A1EmpCod ;
   private byte[] BC0045178_A1427EmpBaseClaseLeg ;
   private String[] BC0045178_A1429EmpBaseTipo ;
   private String[] BC0045178_A1430EmpBaseCod1 ;
   private String[] BC0045178_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] BC0045178_A1432EmpBasePlus ;
   private int[] BC0045179_A3CliCod ;
   private short[] BC0045179_A1EmpCod ;
   private byte[] BC0045179_A1427EmpBaseClaseLeg ;
   private String[] BC0045179_A1429EmpBaseTipo ;
   private String[] BC0045179_A1430EmpBaseCod1 ;
   private String[] BC0045179_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] BC0045179_A1432EmpBasePlus ;
   private int[] BC0045183_A3CliCod ;
   private short[] BC0045183_A1EmpCod ;
   private byte[] BC0045183_A1427EmpBaseClaseLeg ;
   private String[] BC0045183_A1429EmpBaseTipo ;
   private String[] BC0045183_A1430EmpBaseCod1 ;
   private String[] BC0045183_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] BC0045183_A1432EmpBasePlus ;
   private short[] BC0045184_A1340EmpHsExSec ;
   private byte[] BC0045184_A1341EmpHsPDiaDia ;
   private String[] BC0045184_A1342EmpHsPDiaDesde ;
   private boolean[] BC0045184_n1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] BC0045184_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] BC0045184_A1351EmpTarfaPDRec ;
   private int[] BC0045184_A3CliCod ;
   private short[] BC0045184_A1EmpCod ;
   private String[] BC0045184_A1339EmpHsPDiaTipTra ;
   private String[] BC0045185_A1294PaiTipoTraId ;
   private int[] BC0045186_A3CliCod ;
   private short[] BC0045186_A1EmpCod ;
   private short[] BC0045186_A1340EmpHsExSec ;
   private short[] BC0045187_A1340EmpHsExSec ;
   private byte[] BC0045187_A1341EmpHsPDiaDia ;
   private String[] BC0045187_A1342EmpHsPDiaDesde ;
   private boolean[] BC0045187_n1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] BC0045187_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] BC0045187_A1351EmpTarfaPDRec ;
   private int[] BC0045187_A3CliCod ;
   private short[] BC0045187_A1EmpCod ;
   private String[] BC0045187_A1339EmpHsPDiaTipTra ;
   private short[] BC0045188_A1340EmpHsExSec ;
   private byte[] BC0045188_A1341EmpHsPDiaDia ;
   private String[] BC0045188_A1342EmpHsPDiaDesde ;
   private boolean[] BC0045188_n1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] BC0045188_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] BC0045188_A1351EmpTarfaPDRec ;
   private int[] BC0045188_A3CliCod ;
   private short[] BC0045188_A1EmpCod ;
   private String[] BC0045188_A1339EmpHsPDiaTipTra ;
   private short[] BC0045192_A1340EmpHsExSec ;
   private byte[] BC0045192_A1341EmpHsPDiaDia ;
   private String[] BC0045192_A1342EmpHsPDiaDesde ;
   private boolean[] BC0045192_n1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] BC0045192_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] BC0045192_A1351EmpTarfaPDRec ;
   private int[] BC0045192_A3CliCod ;
   private short[] BC0045192_A1EmpCod ;
   private String[] BC0045192_A1339EmpHsPDiaTipTra ;
   private int[] BC0045193_A3CliCod ;
   private short[] BC0045193_A1EmpCod ;
   private java.math.BigDecimal[] BC0045193_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC0045193_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC0045193_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC0045193_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC0045193_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC0045193_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC0045193_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC0045193_A1389EmpHsMaxAnu ;
   private String[] BC0045193_A1294PaiTipoTraId ;
   private String[] BC0045194_A1292TipoTraId ;
   private int[] BC0045195_A3CliCod ;
   private short[] BC0045195_A1EmpCod ;
   private String[] BC0045195_A1294PaiTipoTraId ;
   private int[] BC0045196_A3CliCod ;
   private short[] BC0045196_A1EmpCod ;
   private java.math.BigDecimal[] BC0045196_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC0045196_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC0045196_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC0045196_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC0045196_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC0045196_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC0045196_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC0045196_A1389EmpHsMaxAnu ;
   private String[] BC0045196_A1294PaiTipoTraId ;
   private int[] BC0045197_A3CliCod ;
   private short[] BC0045197_A1EmpCod ;
   private java.math.BigDecimal[] BC0045197_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC0045197_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC0045197_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC0045197_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC0045197_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC0045197_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC0045197_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC0045197_A1389EmpHsMaxAnu ;
   private String[] BC0045197_A1294PaiTipoTraId ;
   private int[] BC0045201_A3CliCod ;
   private short[] BC0045201_A1EmpCod ;
   private short[] BC0045201_A1340EmpHsExSec ;
   private int[] BC0045202_A3CliCod ;
   private short[] BC0045202_A1EmpCod ;
   private java.math.BigDecimal[] BC0045202_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC0045202_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC0045202_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC0045202_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC0045202_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC0045202_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC0045202_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC0045202_A1389EmpHsMaxAnu ;
   private String[] BC0045202_A1294PaiTipoTraId ;
   private int[] BC0045203_A3CliCod ;
   private short[] BC0045203_A1EmpCod ;
   private String[] BC0045203_A1239EmpConvenio ;
   private int[] BC0045204_A3CliCod ;
   private short[] BC0045204_A1EmpCod ;
   private String[] BC0045204_A1239EmpConvenio ;
   private int[] BC0045205_A3CliCod ;
   private short[] BC0045205_A1EmpCod ;
   private String[] BC0045205_A1239EmpConvenio ;
   private int[] BC0045206_A3CliCod ;
   private short[] BC0045206_A1EmpCod ;
   private String[] BC0045206_A1239EmpConvenio ;
   private int[] BC0045209_A3CliCod ;
   private short[] BC0045209_A1EmpCod ;
   private String[] BC0045209_A1239EmpConvenio ;
   private int[] BC0045210_A3CliCod ;
   private short[] BC0045210_A1EmpCod ;
   private String[] BC0045210_A1238EmpOrigen ;
   private String[] BC0045211_A1231OrigId ;
   private int[] BC0045212_A3CliCod ;
   private short[] BC0045212_A1EmpCod ;
   private String[] BC0045212_A1238EmpOrigen ;
   private int[] BC0045213_A3CliCod ;
   private short[] BC0045213_A1EmpCod ;
   private String[] BC0045213_A1238EmpOrigen ;
   private int[] BC0045214_A3CliCod ;
   private short[] BC0045214_A1EmpCod ;
   private String[] BC0045214_A1238EmpOrigen ;
   private int[] BC0045217_A3CliCod ;
   private short[] BC0045217_A1EmpCod ;
   private String[] BC0045217_A1238EmpOrigen ;
   private int[] BC0045218_A3CliCod ;
   private short[] BC0045218_A1EmpCod ;
   private String[] BC0045218_A1237EmpReligion ;
   private String[] BC0045219_A1229ReligId ;
   private int[] BC0045220_A3CliCod ;
   private short[] BC0045220_A1EmpCod ;
   private String[] BC0045220_A1237EmpReligion ;
   private int[] BC0045221_A3CliCod ;
   private short[] BC0045221_A1EmpCod ;
   private String[] BC0045221_A1237EmpReligion ;
   private int[] BC0045222_A3CliCod ;
   private short[] BC0045222_A1EmpCod ;
   private String[] BC0045222_A1237EmpReligion ;
   private int[] BC0045225_A3CliCod ;
   private short[] BC0045225_A1EmpCod ;
   private String[] BC0045225_A1237EmpReligion ;
   private int[] BC0045226_A3CliCod ;
   private int[] BC0045227_A3CliCod ;
   private int[] BC00452_A3CliCod ;
   private short[] BC00452_A1EmpCod ;
   private String[] BC00452_A1237EmpReligion ;
   private int[] BC00453_A3CliCod ;
   private short[] BC00453_A1EmpCod ;
   private String[] BC00453_A1237EmpReligion ;
   private String[] BC00454_A1229ReligId ;
   private int[] BC00455_A3CliCod ;
   private short[] BC00455_A1EmpCod ;
   private String[] BC00455_A1238EmpOrigen ;
   private int[] BC00456_A3CliCod ;
   private short[] BC00456_A1EmpCod ;
   private String[] BC00456_A1238EmpOrigen ;
   private String[] BC00457_A1231OrigId ;
   private int[] BC00458_A3CliCod ;
   private short[] BC00458_A1EmpCod ;
   private String[] BC00458_A1239EmpConvenio ;
   private int[] BC00459_A3CliCod ;
   private short[] BC00459_A1EmpCod ;
   private String[] BC00459_A1239EmpConvenio ;
   private int[] BC004510_A3CliCod ;
   private short[] BC004510_A1EmpCod ;
   private java.math.BigDecimal[] BC004510_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC004510_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC004510_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC004510_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC004510_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC004510_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC004510_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC004510_A1389EmpHsMaxAnu ;
   private String[] BC004510_A1294PaiTipoTraId ;
   private int[] BC004511_A3CliCod ;
   private short[] BC004511_A1EmpCod ;
   private java.math.BigDecimal[] BC004511_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC004511_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC004511_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC004511_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC004511_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC004511_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC004511_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC004511_A1389EmpHsMaxAnu ;
   private String[] BC004511_A1294PaiTipoTraId ;
   private String[] BC004512_A1292TipoTraId ;
   private short[] BC004513_A1340EmpHsExSec ;
   private byte[] BC004513_A1341EmpHsPDiaDia ;
   private String[] BC004513_A1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] BC004513_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] BC004513_A1351EmpTarfaPDRec ;
   private int[] BC004513_A3CliCod ;
   private short[] BC004513_A1EmpCod ;
   private String[] BC004513_A1339EmpHsPDiaTipTra ;
   private short[] BC004514_A1340EmpHsExSec ;
   private byte[] BC004514_A1341EmpHsPDiaDia ;
   private String[] BC004514_A1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] BC004514_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] BC004514_A1351EmpTarfaPDRec ;
   private int[] BC004514_A3CliCod ;
   private short[] BC004514_A1EmpCod ;
   private String[] BC004514_A1339EmpHsPDiaTipTra ;
   private int[] BC004515_A3CliCod ;
   private short[] BC004515_A1EmpCod ;
   private java.math.BigDecimal[] BC004515_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC004515_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC004515_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC004515_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC004515_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC004515_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC004515_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC004515_A1389EmpHsMaxAnu ;
   private String[] BC004515_A1294PaiTipoTraId ;
   private int[] BC004516_A3CliCod ;
   private short[] BC004516_A1EmpCod ;
   private byte[] BC004516_A1427EmpBaseClaseLeg ;
   private String[] BC004516_A1429EmpBaseTipo ;
   private String[] BC004516_A1430EmpBaseCod1 ;
   private String[] BC004516_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] BC004516_A1432EmpBasePlus ;
   private int[] BC004517_A3CliCod ;
   private short[] BC004517_A1EmpCod ;
   private byte[] BC004517_A1427EmpBaseClaseLeg ;
   private String[] BC004517_A1429EmpBaseTipo ;
   private String[] BC004517_A1430EmpBaseCod1 ;
   private String[] BC004517_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] BC004517_A1432EmpBasePlus ;
   private int[] BC004518_A3CliCod ;
   private short[] BC004518_A1EmpCod ;
   private String[] BC004518_A1371EmpPromFijVar ;
   private boolean[] BC004518_A1372EmpPromHabitual ;
   private String[] BC004518_A37TipoConCod ;
   private int[] BC004519_A3CliCod ;
   private short[] BC004519_A1EmpCod ;
   private String[] BC004519_A1371EmpPromFijVar ;
   private boolean[] BC004519_A1372EmpPromHabitual ;
   private String[] BC004519_A37TipoConCod ;
   private String[] BC004520_A37TipoConCod ;
   private boolean[] BC004521_A1369EmpJorHabitual ;
   private int[] BC004521_A3CliCod ;
   private String[] BC004521_A1366EmpJorConCodigo ;
   private short[] BC004521_A1EmpCod ;
   private boolean[] BC004522_A1369EmpJorHabitual ;
   private int[] BC004522_A3CliCod ;
   private String[] BC004522_A1366EmpJorConCodigo ;
   private short[] BC004522_A1EmpCod ;
   private String[] BC004523_A26ConCodigo ;
   private boolean[] BC004524_A1370EmpMenHabitual ;
   private int[] BC004524_A3CliCod ;
   private String[] BC004524_A1368EmpMenConCodigo ;
   private short[] BC004524_A1EmpCod ;
   private boolean[] BC004525_A1370EmpMenHabitual ;
   private int[] BC004525_A3CliCod ;
   private String[] BC004525_A1368EmpMenConCodigo ;
   private short[] BC004525_A1EmpCod ;
   private String[] BC004526_A26ConCodigo ;
   private short[] BC004527_A1EmpCod ;
   private String[] BC004527_A2EmpNom ;
   private long[] BC004527_A177EmpCUIT ;
   private String[] BC004527_A178EmpDir ;
   private String[] BC004527_A180EmpTel ;
   private String[] BC004527_A176EmpCP ;
   private byte[] BC004527_A1811EmpPerVacDes ;
   private byte[] BC004527_A1812EmpPerVacHas ;
   private boolean[] BC004527_A532EmpReducc ;
   private String[] BC004527_A955EmpLogo ;
   private String[] BC004527_A958EmpFirma ;
   private java.math.BigDecimal[] BC004527_A1140EmpAntiguedad ;
   private java.math.BigDecimal[] BC004527_A1141EmpPresentismo ;
   private java.math.BigDecimal[] BC004527_A1302EmpMesHsPExt ;
   private boolean[] BC004527_A1524EmpLiqFer ;
   private boolean[] BC004527_A1750EmpLiqFerJor ;
   private String[] BC004527_A1303EmpDiaHsPExt ;
   private byte[] BC004527_A1556EmpGuarEdadMin ;
   private byte[] BC004527_A1557EmpGuarEdadMax ;
   private boolean[] BC004527_A1787EmpLiqGan ;
   private byte[] BC004527_A1792EmpTipoExp ;
   private String[] BC004527_A1802EmpPromDesde ;
   private java.math.BigDecimal[] BC004527_A1813EmpFracVacAnt ;
   private boolean[] BC004527_A2259EmpVacExpLim ;
   private byte[] BC004527_A2260EmpVacExpTie ;
   private int[] BC004527_A2261EmpVacDisMax ;
   private String[] BC004527_A2405EmpModTra ;
   private boolean[] BC004527_A2406EmpModEmpl ;
   private boolean[] BC004527_A2407EmpModAuto ;
   private String[] BC004527_A957EmpLogoExt ;
   private String[] BC004527_A960EmpFirmaExt ;
   private String[] BC004527_A956EmpLogoNom ;
   private String[] BC004527_A959EmpFirmaNom ;
   private short[] BC004527_A46PaiCod ;
   private short[] BC004527_A47ProvCod ;
   private short[] BC004527_A48LocCod ;
   private int[] BC004527_A3CliCod ;
   private String[] BC004527_A43ActCodigo ;
   private String[] BC004527_A45TipEmpleCod ;
   private short[] BC004527_A1151ARTSec ;
   private String[] BC004527_A903ActComCodigo ;
   private String[] BC004527_A1965EmpOsoCod ;
   private String[] BC004527_A1533EmpActComercial ;
   private String[] BC004527_A44EmpZonCod ;
   private short[] BC004527_A2265EmpCondiCod ;
   private short[] BC004528_A1EmpCod ;
   private String[] BC004528_A2EmpNom ;
   private long[] BC004528_A177EmpCUIT ;
   private String[] BC004528_A178EmpDir ;
   private String[] BC004528_A180EmpTel ;
   private String[] BC004528_A176EmpCP ;
   private byte[] BC004528_A1811EmpPerVacDes ;
   private byte[] BC004528_A1812EmpPerVacHas ;
   private boolean[] BC004528_A532EmpReducc ;
   private String[] BC004528_A955EmpLogo ;
   private String[] BC004528_A958EmpFirma ;
   private java.math.BigDecimal[] BC004528_A1140EmpAntiguedad ;
   private java.math.BigDecimal[] BC004528_A1141EmpPresentismo ;
   private java.math.BigDecimal[] BC004528_A1302EmpMesHsPExt ;
   private boolean[] BC004528_A1524EmpLiqFer ;
   private boolean[] BC004528_A1750EmpLiqFerJor ;
   private String[] BC004528_A1303EmpDiaHsPExt ;
   private byte[] BC004528_A1556EmpGuarEdadMin ;
   private byte[] BC004528_A1557EmpGuarEdadMax ;
   private boolean[] BC004528_A1787EmpLiqGan ;
   private byte[] BC004528_A1792EmpTipoExp ;
   private String[] BC004528_A1802EmpPromDesde ;
   private java.math.BigDecimal[] BC004528_A1813EmpFracVacAnt ;
   private boolean[] BC004528_A2259EmpVacExpLim ;
   private byte[] BC004528_A2260EmpVacExpTie ;
   private int[] BC004528_A2261EmpVacDisMax ;
   private String[] BC004528_A2405EmpModTra ;
   private boolean[] BC004528_A2406EmpModEmpl ;
   private boolean[] BC004528_A2407EmpModAuto ;
   private String[] BC004528_A957EmpLogoExt ;
   private String[] BC004528_A960EmpFirmaExt ;
   private String[] BC004528_A956EmpLogoNom ;
   private String[] BC004528_A959EmpFirmaNom ;
   private short[] BC004528_A46PaiCod ;
   private short[] BC004528_A47ProvCod ;
   private short[] BC004528_A48LocCod ;
   private int[] BC004528_A3CliCod ;
   private String[] BC004528_A43ActCodigo ;
   private String[] BC004528_A45TipEmpleCod ;
   private short[] BC004528_A1151ARTSec ;
   private String[] BC004528_A903ActComCodigo ;
   private String[] BC004528_A1965EmpOsoCod ;
   private String[] BC004528_A1533EmpActComercial ;
   private String[] BC004528_A44EmpZonCod ;
   private short[] BC004528_A2265EmpCondiCod ;
   private String[] BC004529_A312PaiNom ;
   private String[] BC004530_A322ProvNom ;
   private String[] BC004531_A286LocNom ;
   private int[] BC004532_A3CliCod ;
   private String[] BC004533_A683ActDescripSinAc ;
   private String[] BC004533_A108ActDescrip ;
   private String[] BC004534_A530TipEmpleDefIns ;
   private short[] BC004535_A1151ARTSec ;
   private String[] BC004536_A903ActComCodigo ;
   private int[] BC004537_A3CliCod ;
   private String[] BC004538_A1533EmpActComercial ;
   private String[] BC004539_A518EmpZonDescrip ;
   private short[] BC004540_A2265EmpCondiCod ;
   private boolean[] BC004513_n1342EmpHsPDiaDesde ;
   private boolean[] BC004514_n1342EmpHsPDiaDesde ;
   private boolean[] BC004527_n180EmpTel ;
   private boolean[] BC004527_n176EmpCP ;
   private boolean[] BC004527_n955EmpLogo ;
   private boolean[] BC004527_n958EmpFirma ;
   private boolean[] BC004527_n1302EmpMesHsPExt ;
   private boolean[] BC004527_n1303EmpDiaHsPExt ;
   private boolean[] BC004527_n957EmpLogoExt ;
   private boolean[] BC004527_n960EmpFirmaExt ;
   private boolean[] BC004527_n956EmpLogoNom ;
   private boolean[] BC004527_n959EmpFirmaNom ;
   private boolean[] BC004527_n46PaiCod ;
   private boolean[] BC004527_n47ProvCod ;
   private boolean[] BC004527_n48LocCod ;
   private boolean[] BC004527_n43ActCodigo ;
   private boolean[] BC004527_n45TipEmpleCod ;
   private boolean[] BC004527_n1965EmpOsoCod ;
   private boolean[] BC004527_n44EmpZonCod ;
   private boolean[] BC004528_n180EmpTel ;
   private boolean[] BC004528_n176EmpCP ;
   private boolean[] BC004528_n955EmpLogo ;
   private boolean[] BC004528_n958EmpFirma ;
   private boolean[] BC004528_n1302EmpMesHsPExt ;
   private boolean[] BC004528_n1303EmpDiaHsPExt ;
   private boolean[] BC004528_n957EmpLogoExt ;
   private boolean[] BC004528_n960EmpFirmaExt ;
   private boolean[] BC004528_n956EmpLogoNom ;
   private boolean[] BC004528_n959EmpFirmaNom ;
   private boolean[] BC004528_n46PaiCod ;
   private boolean[] BC004528_n47ProvCod ;
   private boolean[] BC004528_n48LocCod ;
   private boolean[] BC004528_n43ActCodigo ;
   private boolean[] BC004528_n45TipEmpleCod ;
   private boolean[] BC004528_n1965EmpOsoCod ;
   private boolean[] BC004528_n44EmpZonCod ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV15TrnContextAtt ;
}

final  class empresa_abm_1_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00452", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ?  FOR UPDATE OF Empresanolaborables_religion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00453", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00454", "SELECT ReligId FROM Religion WHERE ReligId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00455", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ?  FOR UPDATE OF Empresanolaborables_origen",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00456", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00457", "SELECT OrigId FROM Origen WHERE OrigId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00458", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? AND EmpCod = ? AND EmpConvenio = ?  FOR UPDATE OF Empresanolaborables_convenio",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00459", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? AND EmpCod = ? AND EmpConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004510", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?  FOR UPDATE OF Empresatipo_trabajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004511", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004512", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004513", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ?  FOR UPDATE OF Empresahorasextras_pordia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004514", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004515", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?  FOR UPDATE OF Empresatipo_trabajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004516", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ?  FOR UPDATE OF Empresabase_calculo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004517", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004518", "SELECT CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ?  FOR UPDATE OF Empresapromedio_horanormal_mensualizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004519", "SELECT CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004520", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004521", "SELECT EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ?  FOR UPDATE OF Empresaconceptos_horanormal_jornalizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004522", "SELECT EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004523", "SELECT ConCodigo FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004524", "SELECT EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ?  FOR UPDATE OF Empresaconceptos_horanormal_mensualizado",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004525", "SELECT EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004526", "SELECT ConCodigo FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004527", "SELECT EmpCod, EmpNom, EmpCUIT, EmpDir, EmpTel, EmpCP, EmpPerVacDes, EmpPerVacHas, EmpReducc, EmpLogo, EmpFirma, EmpAntiguedad, EmpPresentismo, EmpMesHsPExt, EmpLiqFer, EmpLiqFerJor, EmpDiaHsPExt, EmpGuarEdadMin, EmpGuarEdadMax, EmpLiqGan, EmpTipoExp, EmpPromDesde, EmpFracVacAnt, EmpVacExpLim, EmpVacExpTie, EmpVacDisMax, EmpModTra, EmpModEmpl, EmpModAuto, EmpLogoExt, EmpFirmaExt, EmpLogoNom, EmpFirmaNom, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, ARTSec, ActComCodigo, EmpOsoCod, EmpActComercial, EmpZonCod, EmpCondiCod FROM Empresa WHERE CliCod = ? AND EmpCod = ?  FOR UPDATE OF Empresa",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004528", "SELECT EmpCod, EmpNom, EmpCUIT, EmpDir, EmpTel, EmpCP, EmpPerVacDes, EmpPerVacHas, EmpReducc, EmpLogo, EmpFirma, EmpAntiguedad, EmpPresentismo, EmpMesHsPExt, EmpLiqFer, EmpLiqFerJor, EmpDiaHsPExt, EmpGuarEdadMin, EmpGuarEdadMax, EmpLiqGan, EmpTipoExp, EmpPromDesde, EmpFracVacAnt, EmpVacExpLim, EmpVacExpTie, EmpVacDisMax, EmpModTra, EmpModEmpl, EmpModAuto, EmpLogoExt, EmpFirmaExt, EmpLogoNom, EmpFirmaNom, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, ARTSec, ActComCodigo, EmpOsoCod, EmpActComercial, EmpZonCod, EmpCondiCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004529", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004530", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004531", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004532", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004533", "SELECT ActDescripSinAc, ActDescrip FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004534", "SELECT TipEmpleDefIns FROM TipoEmpleador WHERE TipEmpleCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004535", "SELECT ARTSec FROM ART WHERE ARTSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004536", "SELECT ActComCodigo FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004537", "SELECT CliCod FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004538", "SELECT ActComCodigo AS EmpActComercial FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004539", "SELECT ZonDescrip AS EmpZonDescrip FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004540", "SELECT CondiCodigo AS EmpCondiCod FROM CondicionAFIP WHERE CondiCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004541", "SELECT T5.ActDescripSinAc, TM1.EmpCod, TM1.EmpNom, TM1.EmpCUIT, TM1.EmpDir, TM1.EmpTel, TM1.EmpCP, T2.PaiNom, T3.ProvNom, TM1.EmpPerVacDes, TM1.EmpPerVacHas, T4.LocNom, T5.ActDescrip, T7.ZonDescrip AS EmpZonDescrip, TM1.EmpReducc, T6.TipEmpleDefIns, TM1.EmpLogo, TM1.EmpFirma, TM1.EmpAntiguedad, TM1.EmpPresentismo, TM1.EmpMesHsPExt, TM1.EmpLiqFer, TM1.EmpLiqFerJor, TM1.EmpDiaHsPExt, TM1.EmpGuarEdadMin, TM1.EmpGuarEdadMax, TM1.EmpLiqGan, TM1.EmpTipoExp, TM1.EmpPromDesde, TM1.EmpFracVacAnt, TM1.EmpVacExpLim, TM1.EmpVacExpTie, TM1.EmpVacDisMax, TM1.EmpModTra, TM1.EmpModEmpl, TM1.EmpModAuto, TM1.EmpLogoExt, TM1.EmpFirmaExt, TM1.EmpLogoNom, TM1.EmpFirmaNom, TM1.PaiCod, TM1.ProvCod, TM1.LocCod, TM1.CliCod, TM1.ActCodigo, TM1.TipEmpleCod, TM1.ARTSec, TM1.ActComCodigo, TM1.EmpOsoCod AS EmpOsoCod, TM1.EmpActComercial AS EmpActComercial, TM1.EmpZonCod AS EmpZonCod, TM1.EmpCondiCod AS EmpCondiCod FROM ((((((Empresa TM1 LEFT JOIN Pais T2 ON T2.PaiCod = TM1.PaiCod) LEFT JOIN Provincia T3 ON T3.PaiCod = TM1.PaiCod AND T3.ProvCod = TM1.ProvCod) LEFT JOIN Localidad T4 ON T4.PaiCod = TM1.PaiCod AND T4.ProvCod = TM1.ProvCod AND T4.LocCod = TM1.LocCod) LEFT JOIN Actividad T5 ON T5.ActCodigo = TM1.ActCodigo) LEFT JOIN TipoEmpleador T6 ON T6.TipEmpleCod = TM1.TipEmpleCod) LEFT JOIN Zona T7 ON T7.ZonCod = TM1.EmpZonCod) WHERE TM1.EmpCod = ? and TM1.CliCod = ? ORDER BY TM1.CliCod, TM1.EmpCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004542", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004543", "SELECT CliCod FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004544", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004545", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004546", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004547", "SELECT ActDescripSinAc, ActDescrip FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004548", "SELECT TipEmpleDefIns FROM TipoEmpleador WHERE TipEmpleCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004549", "SELECT ActComCodigo AS EmpActComercial FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004550", "SELECT ZonDescrip AS EmpZonDescrip FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004551", "SELECT ARTSec FROM ART WHERE ARTSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004552", "SELECT ActComCodigo FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004553", "SELECT CondiCodigo AS EmpCondiCod FROM CondicionAFIP WHERE CondiCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004554", "SELECT CliCod, EmpCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004555", "SELECT EmpCod, EmpNom, EmpCUIT, EmpDir, EmpTel, EmpCP, EmpPerVacDes, EmpPerVacHas, EmpReducc, EmpLogo, EmpFirma, EmpAntiguedad, EmpPresentismo, EmpMesHsPExt, EmpLiqFer, EmpLiqFerJor, EmpDiaHsPExt, EmpGuarEdadMin, EmpGuarEdadMax, EmpLiqGan, EmpTipoExp, EmpPromDesde, EmpFracVacAnt, EmpVacExpLim, EmpVacExpTie, EmpVacDisMax, EmpModTra, EmpModEmpl, EmpModAuto, EmpLogoExt, EmpFirmaExt, EmpLogoNom, EmpFirmaNom, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, ARTSec, ActComCodigo, EmpOsoCod, EmpActComercial, EmpZonCod, EmpCondiCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004556", "SELECT EmpCod, EmpNom, EmpCUIT, EmpDir, EmpTel, EmpCP, EmpPerVacDes, EmpPerVacHas, EmpReducc, EmpLogo, EmpFirma, EmpAntiguedad, EmpPresentismo, EmpMesHsPExt, EmpLiqFer, EmpLiqFerJor, EmpDiaHsPExt, EmpGuarEdadMin, EmpGuarEdadMax, EmpLiqGan, EmpTipoExp, EmpPromDesde, EmpFracVacAnt, EmpVacExpLim, EmpVacExpTie, EmpVacDisMax, EmpModTra, EmpModEmpl, EmpModAuto, EmpLogoExt, EmpFirmaExt, EmpLogoNom, EmpFirmaNom, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, ARTSec, ActComCodigo, EmpOsoCod, EmpActComercial, EmpZonCod, EmpCondiCod FROM Empresa WHERE CliCod = ? AND EmpCod = ?  FOR UPDATE OF Empresa",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC004557", "SAVEPOINT gxupdate;INSERT INTO Empresa(EmpCod, EmpNom, EmpCUIT, EmpDir, EmpTel, EmpCP, EmpPerVacDes, EmpPerVacHas, EmpReducc, EmpLogo, EmpFirma, EmpAntiguedad, EmpPresentismo, EmpMesHsPExt, EmpLiqFer, EmpLiqFerJor, EmpDiaHsPExt, EmpGuarEdadMin, EmpGuarEdadMax, EmpLiqGan, EmpTipoExp, EmpPromDesde, EmpFracVacAnt, EmpVacExpLim, EmpVacExpTie, EmpVacDisMax, EmpModTra, EmpModEmpl, EmpModAuto, EmpLogoExt, EmpFirmaExt, EmpLogoNom, EmpFirmaNom, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, ARTSec, ActComCodigo, EmpOsoCod, EmpActComercial, EmpZonCod, EmpCondiCod, CatIvaCod, CatIvaDesc, EmpUltSexoIng) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC004558", "SAVEPOINT gxupdate;UPDATE Empresa SET EmpNom=?, EmpCUIT=?, EmpDir=?, EmpTel=?, EmpCP=?, EmpPerVacDes=?, EmpPerVacHas=?, EmpReducc=?, EmpAntiguedad=?, EmpPresentismo=?, EmpMesHsPExt=?, EmpLiqFer=?, EmpLiqFerJor=?, EmpDiaHsPExt=?, EmpGuarEdadMin=?, EmpGuarEdadMax=?, EmpLiqGan=?, EmpTipoExp=?, EmpPromDesde=?, EmpFracVacAnt=?, EmpVacExpLim=?, EmpVacExpTie=?, EmpVacDisMax=?, EmpModTra=?, EmpModEmpl=?, EmpModAuto=?, EmpLogoExt=?, EmpFirmaExt=?, EmpLogoNom=?, EmpFirmaNom=?, PaiCod=?, ProvCod=?, LocCod=?, ActCodigo=?, TipEmpleCod=?, ARTSec=?, ActComCodigo=?, EmpOsoCod=?, EmpActComercial=?, EmpZonCod=?, EmpCondiCod=?  WHERE CliCod = ? AND EmpCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC004559", "SAVEPOINT gxupdate;UPDATE Empresa SET EmpLogo=?  WHERE CliCod = ? AND EmpCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC004560", "SAVEPOINT gxupdate;UPDATE Empresa SET EmpFirma=?  WHERE CliCod = ? AND EmpCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC004561", "SAVEPOINT gxupdate;DELETE FROM Empresa  WHERE CliCod = ? AND EmpCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC004562", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004563", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004564", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004565", "SELECT ActDescripSinAc, ActDescrip FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004566", "SELECT TipEmpleDefIns FROM TipoEmpleador WHERE TipEmpleCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004567", "SELECT ZonDescrip AS EmpZonDescrip FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004568", "SELECT CliCod, EmpCod, BanSalCod FROM banda_salarial WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004569", "SELECT CliCod, EmpCod, ColaUUID FROM Cola WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004570", "SELECT CliCod, EmpCod, LiqBatchLiqNro, LiqBatchCod, LiqBatchSeccion FROM LiquidacionLotes3 WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004571", "SELECT CliCod, EmpCod, LiqLoteLiqNro, LiqLote FROM LiquidacionLotes2 WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004572", "SELECT CliCod, EmpCod, LiqNro, LinkLegNumero, LegLinkTiporec FROM LiquidacionLegajoLinkPdf WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004573", "SELECT CliCod, EmpCod, LiqNro, LiqSuc FROM LiquidacionSucursal WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004574", "SELECT CliCod, EmpCod, LiqNro, LiqArea FROM LiquidacionArea WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004575", "SELECT CliCod, EmpCod, LiqNro, LiqPaiConve, LiqConvenio FROM LiquidacionConvenio WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004576", "SELECT CliCod, EmpCod, EmpBanCod FROM EmpresaBancos WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004577", "SELECT CliCod, EmpCod, PeriodoLiq FROM Periodo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004578", "SELECT CliCod, EmpCod, LSDSec FROM LSD_reg1 WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004579", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE EmpConveVer = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004580", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004581", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004582", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004583", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004584", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004585", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004586", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004587", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004588", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004589", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004590", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004591", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004592", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004593", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004594", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004595", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004596", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004597", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004598", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004599", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045100", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045101", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045102", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045103", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045104", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045105", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045106", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045107", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045108", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045109", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045110", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045111", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045112", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045113", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045114", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045115", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045116", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045117", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045118", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045119", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045120", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045121", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045122", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045123", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045124", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045125", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045126", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045127", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045128", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045129", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045130", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045131", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045132", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045133", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045134", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045135", "SELECT CliCod, EmpCod, GuarCod FROM EmpresaGuarderias WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045136", "SELECT CliCod, EmpCod, EmpHsExSec FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045137", "SELECT CliCod, EmpCod, SucCodigo FROM Sucursal WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045138", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357Cab WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045139", "SELECT CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045140", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045141", "SELECT CliCod, EmpCod, TempRecSec FROM TemplateRecibo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045142", "SELECT CliCod, EmpCod, ArchSiradigFec FROM archivo_siradig WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045143", "SELECT CliCod, EmpCod, AsientoCNum FROM AsientoCab WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045144", "SELECT CliCod, EmpCod, CuenCodigo FROM CuentaContable WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045145", "SELECT CliCod, EmpCod, CenCodigo FROM CentroDeCosto WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045146", "SELECT CliCod, EmpCod, LiqNro, LpgCodigo FROM LiquidacionLugarPago WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045147", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045148", "SELECT T5.ActDescripSinAc, TM1.EmpCod, TM1.EmpNom, TM1.EmpCUIT, TM1.EmpDir, TM1.EmpTel, TM1.EmpCP, T2.PaiNom, T3.ProvNom, TM1.EmpPerVacDes, TM1.EmpPerVacHas, T4.LocNom, T5.ActDescrip, T7.ZonDescrip AS EmpZonDescrip, TM1.EmpReducc, T6.TipEmpleDefIns, TM1.EmpLogo, TM1.EmpFirma, TM1.EmpAntiguedad, TM1.EmpPresentismo, TM1.EmpMesHsPExt, TM1.EmpLiqFer, TM1.EmpLiqFerJor, TM1.EmpDiaHsPExt, TM1.EmpGuarEdadMin, TM1.EmpGuarEdadMax, TM1.EmpLiqGan, TM1.EmpTipoExp, TM1.EmpPromDesde, TM1.EmpFracVacAnt, TM1.EmpVacExpLim, TM1.EmpVacExpTie, TM1.EmpVacDisMax, TM1.EmpModTra, TM1.EmpModEmpl, TM1.EmpModAuto, TM1.EmpLogoExt, TM1.EmpFirmaExt, TM1.EmpLogoNom, TM1.EmpFirmaNom, TM1.PaiCod, TM1.ProvCod, TM1.LocCod, TM1.CliCod, TM1.ActCodigo, TM1.TipEmpleCod, TM1.ARTSec, TM1.ActComCodigo, TM1.EmpOsoCod AS EmpOsoCod, TM1.EmpActComercial AS EmpActComercial, TM1.EmpZonCod AS EmpZonCod, TM1.EmpCondiCod AS EmpCondiCod FROM ((((((Empresa TM1 LEFT JOIN Pais T2 ON T2.PaiCod = TM1.PaiCod) LEFT JOIN Provincia T3 ON T3.PaiCod = TM1.PaiCod AND T3.ProvCod = TM1.ProvCod) LEFT JOIN Localidad T4 ON T4.PaiCod = TM1.PaiCod AND T4.ProvCod = TM1.ProvCod AND T4.LocCod = TM1.LocCod) LEFT JOIN Actividad T5 ON T5.ActCodigo = TM1.ActCodigo) LEFT JOIN TipoEmpleador T6 ON T6.TipEmpleCod = TM1.TipEmpleCod) LEFT JOIN Zona T7 ON T7.ZonCod = TM1.EmpZonCod) WHERE TM1.EmpCod = ? and TM1.CliCod = ? ORDER BY TM1.CliCod, TM1.EmpCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045149", "SELECT EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? and EmpCod = ? and EmpMenConCodigo = ( ?) ORDER BY CliCod, EmpCod, EmpMenConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045150", "SELECT ConCodigo FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045151", "SELECT CliCod, EmpCod, EmpMenConCodigo FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045152", "SELECT EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045153", "SELECT EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ?  FOR UPDATE OF Empresaconceptos_horanormal_mensualizado",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0045154", "SAVEPOINT gxupdate;INSERT INTO Empresaconceptos_horanormal_mensualizado(EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045155", "SAVEPOINT gxupdate;UPDATE Empresaconceptos_horanormal_mensualizado SET EmpMenHabitual=?  WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045156", "SAVEPOINT gxupdate;DELETE FROM Empresaconceptos_horanormal_mensualizado  WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0045157", "SELECT EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpMenConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045158", "SELECT EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? and EmpCod = ? and EmpJorConCodigo = ( ?) ORDER BY CliCod, EmpCod, EmpJorConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045159", "SELECT ConCodigo FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045160", "SELECT CliCod, EmpCod, EmpJorConCodigo FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045161", "SELECT EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045162", "SELECT EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ?  FOR UPDATE OF Empresaconceptos_horanormal_jornalizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0045163", "SAVEPOINT gxupdate;INSERT INTO Empresaconceptos_horanormal_jornalizados(EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045164", "SAVEPOINT gxupdate;UPDATE Empresaconceptos_horanormal_jornalizados SET EmpJorHabitual=?  WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045165", "SAVEPOINT gxupdate;DELETE FROM Empresaconceptos_horanormal_jornalizados  WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0045166", "SELECT EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpJorConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045167", "SELECT CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? and EmpCod = ? and TipoConCod = ( ?) and EmpPromFijVar = ( ?) ORDER BY CliCod, EmpCod, TipoConCod, EmpPromFijVar ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045168", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045169", "SELECT CliCod, EmpCod, TipoConCod, EmpPromFijVar FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045170", "SELECT CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045171", "SELECT CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ?  FOR UPDATE OF Empresapromedio_horanormal_mensualizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0045172", "SAVEPOINT gxupdate;INSERT INTO Empresapromedio_horanormal_mensualizados(CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045173", "SAVEPOINT gxupdate;UPDATE Empresapromedio_horanormal_mensualizados SET EmpPromHabitual=?  WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045174", "SAVEPOINT gxupdate;DELETE FROM Empresapromedio_horanormal_mensualizados  WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0045175", "SELECT CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, TipoConCod, EmpPromFijVar ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045176", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus FROM Empresabase_calculo WHERE CliCod = ? and EmpCod = ? and EmpBaseClaseLeg = ? and EmpBaseTipo = ( ?) and EmpBaseCod1 = ( ?) and EmpBaseCod2 = ( ?) ORDER BY CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045177", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045178", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045179", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ?  FOR UPDATE OF Empresabase_calculo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0045180", "SAVEPOINT gxupdate;INSERT INTO Empresabase_calculo(CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus, EmpLicDLim, EmpLicDSeman, EmpLicDMes, EmpLicDSemes, EmpLicDAnual, EmpLicAdju, EmpLicAdjuObl, EmpLicNecAut, EmpLicIngMot, EmpLicMotObl, EmpLicDMin, EmpBaseOrd, EmpBasePromCnt1, EmpBasePromCnt2, EmpBasePromTCnt, EmpBaseRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0, FALSE, FALSE, FALSE, FALSE, FALSE, 0, 0, 0, 0, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045181", "SAVEPOINT gxupdate;UPDATE Empresabase_calculo SET EmpBasePlus=?  WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045182", "SAVEPOINT gxupdate;DELETE FROM Empresabase_calculo  WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0045183", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus FROM Empresabase_calculo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045184", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? and EmpCod = ? and EmpHsExSec = ? ORDER BY CliCod, EmpCod, EmpHsExSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045185", "SELECT PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?  FOR UPDATE OF Empresatipo_trabajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045186", "SELECT CliCod, EmpCod, EmpHsExSec FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045187", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045188", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ?  FOR UPDATE OF Empresahorasextras_pordia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0045189", "SAVEPOINT gxupdate;INSERT INTO Empresahorasextras_pordia(EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra, EmpHsPDiaRelSec, EmpTarifaPDCri) VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045190", "SAVEPOINT gxupdate;UPDATE Empresahorasextras_pordia SET EmpHsPDiaDia=?, EmpHsPDiaDesde=?, EmpTarifaPDia=?, EmpTarfaPDRec=?, EmpHsPDiaTipTra=?  WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045191", "SAVEPOINT gxupdate;DELETE FROM Empresahorasextras_pordia  WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0045192", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpHsExSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045193", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? and EmpCod = ? and PaiTipoTraId = ( ?) ORDER BY CliCod, EmpCod, PaiTipoTraId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045194", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045195", "SELECT CliCod, EmpCod, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045196", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045197", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?  FOR UPDATE OF Empresatipo_trabajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0045198", "SAVEPOINT gxupdate;INSERT INTO Empresatipo_trabajo(CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId, EmpHsRelSec, EmpHsHorDes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045199", "SAVEPOINT gxupdate;UPDATE Empresatipo_trabajo SET EmpHsDia=?, EmpHsSem=?, EmpTarifaXLim=?, EmpTarifaRec=?, EmpHsMaxDia=?, EmpHsMaxSem=?, EmpHsMaxMes=?, EmpHsMaxAnu=?  WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045200", "SAVEPOINT gxupdate;DELETE FROM Empresatipo_trabajo  WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0045201", "SELECT CliCod, EmpCod, EmpHsExSec FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsPDiaTipTra = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC0045202", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, PaiTipoTraId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045203", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? and EmpCod = ? and EmpConvenio = ( ?) ORDER BY CliCod, EmpCod, EmpConvenio ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045204", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? AND EmpCod = ? AND EmpConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045205", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? AND EmpCod = ? AND EmpConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045206", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? AND EmpCod = ? AND EmpConvenio = ?  FOR UPDATE OF Empresanolaborables_convenio",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0045207", "SAVEPOINT gxupdate;INSERT INTO Empresanolaborables_convenio(CliCod, EmpCod, EmpConvenio) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045208", "SAVEPOINT gxupdate;DELETE FROM Empresanolaborables_convenio  WHERE CliCod = ? AND EmpCod = ? AND EmpConvenio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0045209", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpConvenio ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045210", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? and EmpCod = ? and EmpOrigen = ( ?) ORDER BY CliCod, EmpCod, EmpOrigen ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045211", "SELECT OrigId FROM Origen WHERE OrigId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045212", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045213", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045214", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ?  FOR UPDATE OF Empresanolaborables_origen",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0045215", "SAVEPOINT gxupdate;INSERT INTO Empresanolaborables_origen(CliCod, EmpCod, EmpOrigen) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045216", "SAVEPOINT gxupdate;DELETE FROM Empresanolaborables_origen  WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0045217", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpOrigen ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045218", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? and EmpCod = ? and EmpReligion = ( ?) ORDER BY CliCod, EmpCod, EmpReligion ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045219", "SELECT ReligId FROM Religion WHERE ReligId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045220", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045221", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045222", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ?  FOR UPDATE OF Empresanolaborables_religion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC0045223", "SAVEPOINT gxupdate;INSERT INTO Empresanolaborables_religion(CliCod, EmpCod, EmpReligion) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC0045224", "SAVEPOINT gxupdate;DELETE FROM Empresanolaborables_religion  WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC0045225", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpReligion ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045226", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC0045227", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 19 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 20 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               return;
            case 22 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 23 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               return;
            case 25 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(7);
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(9);
               ((String[]) buf[11])[0] = rslt.getBLOBFile(10, rslt.getString(30, 20), rslt.getVarchar(32));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getBLOBFile(11, rslt.getString(31, 20), rslt.getVarchar(33));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,4);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(13,4);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(14,1);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[20])[0] = rslt.getBoolean(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((byte[]) buf[23])[0] = rslt.getByte(18);
               ((byte[]) buf[24])[0] = rslt.getByte(19);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(20);
               ((byte[]) buf[26])[0] = rslt.getByte(21);
               ((String[]) buf[27])[0] = rslt.getString(22, 20);
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(23,4);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(24);
               ((byte[]) buf[30])[0] = rslt.getByte(25);
               ((int[]) buf[31])[0] = rslt.getInt(26);
               ((String[]) buf[32])[0] = rslt.getString(27, 1);
               ((boolean[]) buf[33])[0] = rslt.getBoolean(28);
               ((boolean[]) buf[34])[0] = rslt.getBoolean(29);
               ((String[]) buf[35])[0] = rslt.getString(30, 20);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((String[]) buf[37])[0] = rslt.getString(31, 20);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
               ((String[]) buf[39])[0] = rslt.getVarchar(32);
               ((boolean[]) buf[40])[0] = rslt.wasNull();
               ((String[]) buf[41])[0] = rslt.getVarchar(33);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((short[]) buf[43])[0] = rslt.getShort(34);
               ((boolean[]) buf[44])[0] = rslt.wasNull();
               ((short[]) buf[45])[0] = rslt.getShort(35);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((short[]) buf[47])[0] = rslt.getShort(36);
               ((boolean[]) buf[48])[0] = rslt.wasNull();
               ((int[]) buf[49])[0] = rslt.getInt(37);
               ((String[]) buf[50])[0] = rslt.getString(38, 8);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((String[]) buf[52])[0] = rslt.getString(39, 4);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((short[]) buf[54])[0] = rslt.getShort(40);
               ((String[]) buf[55])[0] = rslt.getString(41, 20);
               ((String[]) buf[56])[0] = rslt.getString(42, 20);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((String[]) buf[58])[0] = rslt.getString(43, 20);
               ((String[]) buf[59])[0] = rslt.getString(44, 20);
               ((boolean[]) buf[60])[0] = rslt.wasNull();
               ((short[]) buf[61])[0] = rslt.getShort(45);
               return;
            case 26 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(7);
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(9);
               ((String[]) buf[11])[0] = rslt.getBLOBFile(10, rslt.getString(30, 20), rslt.getVarchar(32));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getBLOBFile(11, rslt.getString(31, 20), rslt.getVarchar(33));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,4);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(13,4);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(14,1);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[20])[0] = rslt.getBoolean(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((byte[]) buf[23])[0] = rslt.getByte(18);
               ((byte[]) buf[24])[0] = rslt.getByte(19);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(20);
               ((byte[]) buf[26])[0] = rslt.getByte(21);
               ((String[]) buf[27])[0] = rslt.getString(22, 20);
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(23,4);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(24);
               ((byte[]) buf[30])[0] = rslt.getByte(25);
               ((int[]) buf[31])[0] = rslt.getInt(26);
               ((String[]) buf[32])[0] = rslt.getString(27, 1);
               ((boolean[]) buf[33])[0] = rslt.getBoolean(28);
               ((boolean[]) buf[34])[0] = rslt.getBoolean(29);
               ((String[]) buf[35])[0] = rslt.getString(30, 20);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((String[]) buf[37])[0] = rslt.getString(31, 20);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
               ((String[]) buf[39])[0] = rslt.getVarchar(32);
               ((boolean[]) buf[40])[0] = rslt.wasNull();
               ((String[]) buf[41])[0] = rslt.getVarchar(33);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((short[]) buf[43])[0] = rslt.getShort(34);
               ((boolean[]) buf[44])[0] = rslt.wasNull();
               ((short[]) buf[45])[0] = rslt.getShort(35);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((short[]) buf[47])[0] = rslt.getShort(36);
               ((boolean[]) buf[48])[0] = rslt.wasNull();
               ((int[]) buf[49])[0] = rslt.getInt(37);
               ((String[]) buf[50])[0] = rslt.getString(38, 8);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((String[]) buf[52])[0] = rslt.getString(39, 4);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((short[]) buf[54])[0] = rslt.getShort(40);
               ((String[]) buf[55])[0] = rslt.getString(41, 20);
               ((String[]) buf[56])[0] = rslt.getString(42, 20);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((String[]) buf[58])[0] = rslt.getString(43, 20);
               ((String[]) buf[59])[0] = rslt.getString(44, 20);
               ((boolean[]) buf[60])[0] = rslt.wasNull();
               ((short[]) buf[61])[0] = rslt.getShort(45);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 28 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 29 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 31 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 32 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               return;
            case 33 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 34 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 36 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 37 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 38 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 39 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((byte[]) buf[12])[0] = rslt.getByte(11);
               ((String[]) buf[13])[0] = rslt.getVarchar(12);
               ((String[]) buf[14])[0] = rslt.getVarchar(13);
               ((String[]) buf[15])[0] = rslt.getVarchar(14);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(15);
               ((String[]) buf[17])[0] = rslt.getString(16, 1);
               ((String[]) buf[18])[0] = rslt.getBLOBFile(17, rslt.getString(37, 20), rslt.getVarchar(39));
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getBLOBFile(18, rslt.getString(38, 20), rslt.getVarchar(40));
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(19,4);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(20,4);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(21,1);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((boolean[]) buf[26])[0] = rslt.getBoolean(22);
               ((boolean[]) buf[27])[0] = rslt.getBoolean(23);
               ((String[]) buf[28])[0] = rslt.getString(24, 20);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((byte[]) buf[30])[0] = rslt.getByte(25);
               ((byte[]) buf[31])[0] = rslt.getByte(26);
               ((boolean[]) buf[32])[0] = rslt.getBoolean(27);
               ((byte[]) buf[33])[0] = rslt.getByte(28);
               ((String[]) buf[34])[0] = rslt.getString(29, 20);
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(30,4);
               ((boolean[]) buf[36])[0] = rslt.getBoolean(31);
               ((byte[]) buf[37])[0] = rslt.getByte(32);
               ((int[]) buf[38])[0] = rslt.getInt(33);
               ((String[]) buf[39])[0] = rslt.getString(34, 1);
               ((boolean[]) buf[40])[0] = rslt.getBoolean(35);
               ((boolean[]) buf[41])[0] = rslt.getBoolean(36);
               ((String[]) buf[42])[0] = rslt.getString(37, 20);
               ((boolean[]) buf[43])[0] = rslt.wasNull();
               ((String[]) buf[44])[0] = rslt.getString(38, 20);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((String[]) buf[46])[0] = rslt.getVarchar(39);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((String[]) buf[48])[0] = rslt.getVarchar(40);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((short[]) buf[50])[0] = rslt.getShort(41);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((short[]) buf[52])[0] = rslt.getShort(42);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((short[]) buf[54])[0] = rslt.getShort(43);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((int[]) buf[56])[0] = rslt.getInt(44);
               ((String[]) buf[57])[0] = rslt.getString(45, 8);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((String[]) buf[59])[0] = rslt.getString(46, 4);
               ((boolean[]) buf[60])[0] = rslt.wasNull();
               ((short[]) buf[61])[0] = rslt.getShort(47);
               ((String[]) buf[62])[0] = rslt.getString(48, 20);
               ((String[]) buf[63])[0] = rslt.getString(49, 20);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((String[]) buf[65])[0] = rslt.getString(50, 20);
               ((String[]) buf[66])[0] = rslt.getString(51, 20);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((short[]) buf[68])[0] = rslt.getShort(52);
               return;
            case 40 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 41 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 42 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 43 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 44 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 45 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 46 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               return;
            case 47 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 48 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 49 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 50 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 51 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 52 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 53 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(7);
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(9);
               ((String[]) buf[11])[0] = rslt.getBLOBFile(10, rslt.getString(30, 20), rslt.getVarchar(32));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getBLOBFile(11, rslt.getString(31, 20), rslt.getVarchar(33));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,4);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(13,4);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(14,1);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[20])[0] = rslt.getBoolean(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((byte[]) buf[23])[0] = rslt.getByte(18);
               ((byte[]) buf[24])[0] = rslt.getByte(19);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(20);
               ((byte[]) buf[26])[0] = rslt.getByte(21);
               ((String[]) buf[27])[0] = rslt.getString(22, 20);
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(23,4);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(24);
               ((byte[]) buf[30])[0] = rslt.getByte(25);
               ((int[]) buf[31])[0] = rslt.getInt(26);
               ((String[]) buf[32])[0] = rslt.getString(27, 1);
               ((boolean[]) buf[33])[0] = rslt.getBoolean(28);
               ((boolean[]) buf[34])[0] = rslt.getBoolean(29);
               ((String[]) buf[35])[0] = rslt.getString(30, 20);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((String[]) buf[37])[0] = rslt.getString(31, 20);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
               ((String[]) buf[39])[0] = rslt.getVarchar(32);
               ((boolean[]) buf[40])[0] = rslt.wasNull();
               ((String[]) buf[41])[0] = rslt.getVarchar(33);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((short[]) buf[43])[0] = rslt.getShort(34);
               ((boolean[]) buf[44])[0] = rslt.wasNull();
               ((short[]) buf[45])[0] = rslt.getShort(35);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((short[]) buf[47])[0] = rslt.getShort(36);
               ((boolean[]) buf[48])[0] = rslt.wasNull();
               ((int[]) buf[49])[0] = rslt.getInt(37);
               ((String[]) buf[50])[0] = rslt.getString(38, 8);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((String[]) buf[52])[0] = rslt.getString(39, 4);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((short[]) buf[54])[0] = rslt.getShort(40);
               ((String[]) buf[55])[0] = rslt.getString(41, 20);
               ((String[]) buf[56])[0] = rslt.getString(42, 20);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((String[]) buf[58])[0] = rslt.getString(43, 20);
               ((String[]) buf[59])[0] = rslt.getString(44, 20);
               ((boolean[]) buf[60])[0] = rslt.wasNull();
               ((short[]) buf[61])[0] = rslt.getShort(45);
               return;
            case 54 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(7);
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(9);
               ((String[]) buf[11])[0] = rslt.getBLOBFile(10, rslt.getString(30, 20), rslt.getVarchar(32));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getBLOBFile(11, rslt.getString(31, 20), rslt.getVarchar(33));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,4);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(13,4);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(14,1);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[20])[0] = rslt.getBoolean(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((byte[]) buf[23])[0] = rslt.getByte(18);
               ((byte[]) buf[24])[0] = rslt.getByte(19);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(20);
               ((byte[]) buf[26])[0] = rslt.getByte(21);
               ((String[]) buf[27])[0] = rslt.getString(22, 20);
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(23,4);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(24);
               ((byte[]) buf[30])[0] = rslt.getByte(25);
               ((int[]) buf[31])[0] = rslt.getInt(26);
               ((String[]) buf[32])[0] = rslt.getString(27, 1);
               ((boolean[]) buf[33])[0] = rslt.getBoolean(28);
               ((boolean[]) buf[34])[0] = rslt.getBoolean(29);
               ((String[]) buf[35])[0] = rslt.getString(30, 20);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((String[]) buf[37])[0] = rslt.getString(31, 20);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
               ((String[]) buf[39])[0] = rslt.getVarchar(32);
               ((boolean[]) buf[40])[0] = rslt.wasNull();
               ((String[]) buf[41])[0] = rslt.getVarchar(33);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((short[]) buf[43])[0] = rslt.getShort(34);
               ((boolean[]) buf[44])[0] = rslt.wasNull();
               ((short[]) buf[45])[0] = rslt.getShort(35);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((short[]) buf[47])[0] = rslt.getShort(36);
               ((boolean[]) buf[48])[0] = rslt.wasNull();
               ((int[]) buf[49])[0] = rslt.getInt(37);
               ((String[]) buf[50])[0] = rslt.getString(38, 8);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((String[]) buf[52])[0] = rslt.getString(39, 4);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((short[]) buf[54])[0] = rslt.getShort(40);
               ((String[]) buf[55])[0] = rslt.getString(41, 20);
               ((String[]) buf[56])[0] = rslt.getString(42, 20);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((String[]) buf[58])[0] = rslt.getString(43, 20);
               ((String[]) buf[59])[0] = rslt.getString(44, 20);
               ((boolean[]) buf[60])[0] = rslt.wasNull();
               ((short[]) buf[61])[0] = rslt.getShort(45);
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
               return;
            case 61 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 62 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 63 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 64 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               return;
            case 65 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 66 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
               return;
            case 67 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
               return;
            case 68 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 69 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 70 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 71 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 72 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 73 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 74 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               return;
            case 75 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 76 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 77 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 78 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 79 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 80 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 81 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 82 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 83 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 84 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 85 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 86 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 87 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 88 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 89 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 91 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 92 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 93 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 94 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 95 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 96 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 97 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 98 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 99 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 100 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 101 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 102 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 103 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 104 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 105 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 106 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 107 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 108 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 109 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 110 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 111 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 112 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 113 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 114 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 115 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 116 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 117 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 118 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 119 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 121 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 122 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 123 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 124 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 125 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 126 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 127 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 128 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 129 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 130 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 131 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 132 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 133 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 134 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 135 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 136 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 137 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 138 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 139 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 140 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               return;
            case 141 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 142 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 143 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 144 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 145 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 146 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((byte[]) buf[12])[0] = rslt.getByte(11);
               ((String[]) buf[13])[0] = rslt.getVarchar(12);
               ((String[]) buf[14])[0] = rslt.getVarchar(13);
               ((String[]) buf[15])[0] = rslt.getVarchar(14);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(15);
               ((String[]) buf[17])[0] = rslt.getString(16, 1);
               ((String[]) buf[18])[0] = rslt.getBLOBFile(17, rslt.getString(37, 20), rslt.getVarchar(39));
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getBLOBFile(18, rslt.getString(38, 20), rslt.getVarchar(40));
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(19,4);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(20,4);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(21,1);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((boolean[]) buf[26])[0] = rslt.getBoolean(22);
               ((boolean[]) buf[27])[0] = rslt.getBoolean(23);
               ((String[]) buf[28])[0] = rslt.getString(24, 20);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((byte[]) buf[30])[0] = rslt.getByte(25);
               ((byte[]) buf[31])[0] = rslt.getByte(26);
               ((boolean[]) buf[32])[0] = rslt.getBoolean(27);
               ((byte[]) buf[33])[0] = rslt.getByte(28);
               ((String[]) buf[34])[0] = rslt.getString(29, 20);
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(30,4);
               ((boolean[]) buf[36])[0] = rslt.getBoolean(31);
               ((byte[]) buf[37])[0] = rslt.getByte(32);
               ((int[]) buf[38])[0] = rslt.getInt(33);
               ((String[]) buf[39])[0] = rslt.getString(34, 1);
               ((boolean[]) buf[40])[0] = rslt.getBoolean(35);
               ((boolean[]) buf[41])[0] = rslt.getBoolean(36);
               ((String[]) buf[42])[0] = rslt.getString(37, 20);
               ((boolean[]) buf[43])[0] = rslt.wasNull();
               ((String[]) buf[44])[0] = rslt.getString(38, 20);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((String[]) buf[46])[0] = rslt.getVarchar(39);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((String[]) buf[48])[0] = rslt.getVarchar(40);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((short[]) buf[50])[0] = rslt.getShort(41);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((short[]) buf[52])[0] = rslt.getShort(42);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((short[]) buf[54])[0] = rslt.getShort(43);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((int[]) buf[56])[0] = rslt.getInt(44);
               ((String[]) buf[57])[0] = rslt.getString(45, 8);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((String[]) buf[59])[0] = rslt.getString(46, 4);
               ((boolean[]) buf[60])[0] = rslt.wasNull();
               ((short[]) buf[61])[0] = rslt.getShort(47);
               ((String[]) buf[62])[0] = rslt.getString(48, 20);
               ((String[]) buf[63])[0] = rslt.getString(49, 20);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((String[]) buf[65])[0] = rslt.getString(50, 20);
               ((String[]) buf[66])[0] = rslt.getString(51, 20);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((short[]) buf[68])[0] = rslt.getShort(52);
               return;
            case 147 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 148 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               return;
            case 149 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
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
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 151 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 155 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 156 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 157 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               return;
            case 158 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 159 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 160 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 164 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 165 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 166 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 167 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 168 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 169 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 173 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 174 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               return;
            case 175 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 176 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               return;
            case 177 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               return;
            case 181 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               return;
            case 182 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               return;
            case 183 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 184 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 185 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               return;
            case 186 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               return;
            case 190 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               return;
            case 191 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               return;
            case 192 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 193 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 194 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               return;
            case 195 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               return;
            case 199 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 200 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               return;
            case 201 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 202 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 203 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 204 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 207 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 208 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 209 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
      }
      getresults210( cursor, rslt, buf) ;
   }

   public void getresults210( int cursor ,
                              IFieldGetter rslt ,
                              Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 210 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 211 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 212 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 215 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 216 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 217 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 218 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 219 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 220 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 223 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 224 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 225 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 18 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
            case 29 :
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 31 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 32 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 33 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 34 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 35 :
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
            case 36 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 37 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 38 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 39 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 41 :
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
            case 42 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 43 :
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
            case 44 :
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
            case 45 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 46 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 47 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 48 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 49 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 50 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 51 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 52 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 53 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 54 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 55 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[5], 30);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[7], 20);
               }
               stmt.setByte(7, ((Number) parms[8]).byteValue());
               stmt.setByte(8, ((Number) parms[9]).byteValue());
               stmt.setBoolean(9, ((Boolean) parms[10]).booleanValue());
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(10, (String)parms[12]);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(11, (String)parms[14]);
               }
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[15], 4);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[16], 4);
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(14, (java.math.BigDecimal)parms[18], 1);
               }
               stmt.setBoolean(15, ((Boolean) parms[19]).booleanValue());
               stmt.setBoolean(16, ((Boolean) parms[20]).booleanValue());
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(17, (String)parms[22], 20);
               }
               stmt.setByte(18, ((Number) parms[23]).byteValue());
               stmt.setByte(19, ((Number) parms[24]).byteValue());
               stmt.setBoolean(20, ((Boolean) parms[25]).booleanValue());
               stmt.setByte(21, ((Number) parms[26]).byteValue());
               stmt.setString(22, (String)parms[27], 20);
               stmt.setBigDecimal(23, (java.math.BigDecimal)parms[28], 4);
               stmt.setBoolean(24, ((Boolean) parms[29]).booleanValue());
               stmt.setByte(25, ((Number) parms[30]).byteValue());
               stmt.setInt(26, ((Number) parms[31]).intValue());
               stmt.setString(27, (String)parms[32], 1);
               stmt.setBoolean(28, ((Boolean) parms[33]).booleanValue());
               stmt.setBoolean(29, ((Boolean) parms[34]).booleanValue());
               if ( ((Boolean) parms[35]).booleanValue() )
               {
                  stmt.setNull( 30 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(30, (String)parms[36], 20);
               }
               if ( ((Boolean) parms[37]).booleanValue() )
               {
                  stmt.setNull( 31 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(31, (String)parms[38], 20);
               }
               if ( ((Boolean) parms[39]).booleanValue() )
               {
                  stmt.setNull( 32 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(32, (String)parms[40], 400);
               }
               if ( ((Boolean) parms[41]).booleanValue() )
               {
                  stmt.setNull( 33 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(33, (String)parms[42], 400);
               }
               if ( ((Boolean) parms[43]).booleanValue() )
               {
                  stmt.setNull( 34 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(34, ((Number) parms[44]).shortValue());
               }
               if ( ((Boolean) parms[45]).booleanValue() )
               {
                  stmt.setNull( 35 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(35, ((Number) parms[46]).shortValue());
               }
               if ( ((Boolean) parms[47]).booleanValue() )
               {
                  stmt.setNull( 36 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(36, ((Number) parms[48]).shortValue());
               }
               stmt.setInt(37, ((Number) parms[49]).intValue());
               if ( ((Boolean) parms[50]).booleanValue() )
               {
                  stmt.setNull( 38 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(38, (String)parms[51], 8);
               }
               if ( ((Boolean) parms[52]).booleanValue() )
               {
                  stmt.setNull( 39 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(39, (String)parms[53], 4);
               }
               stmt.setShort(40, ((Number) parms[54]).shortValue());
               stmt.setString(41, (String)parms[55], 20);
               if ( ((Boolean) parms[56]).booleanValue() )
               {
                  stmt.setNull( 42 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(42, (String)parms[57], 20);
               }
               stmt.setString(43, (String)parms[58], 20);
               if ( ((Boolean) parms[59]).booleanValue() )
               {
                  stmt.setNull( 44 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(44, (String)parms[60], 20);
               }
               stmt.setShort(45, ((Number) parms[61]).shortValue());
               return;
            case 56 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setVarchar(3, (String)parms[2], 40, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(4, (String)parms[4], 30);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[6], 20);
               }
               stmt.setByte(6, ((Number) parms[7]).byteValue());
               stmt.setByte(7, ((Number) parms[8]).byteValue());
               stmt.setBoolean(8, ((Boolean) parms[9]).booleanValue());
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[10], 4);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[11], 4);
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(11, (java.math.BigDecimal)parms[13], 1);
               }
               stmt.setBoolean(12, ((Boolean) parms[14]).booleanValue());
               stmt.setBoolean(13, ((Boolean) parms[15]).booleanValue());
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[17], 20);
               }
               stmt.setByte(15, ((Number) parms[18]).byteValue());
               stmt.setByte(16, ((Number) parms[19]).byteValue());
               stmt.setBoolean(17, ((Boolean) parms[20]).booleanValue());
               stmt.setByte(18, ((Number) parms[21]).byteValue());
               stmt.setString(19, (String)parms[22], 20);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[23], 4);
               stmt.setBoolean(21, ((Boolean) parms[24]).booleanValue());
               stmt.setByte(22, ((Number) parms[25]).byteValue());
               stmt.setInt(23, ((Number) parms[26]).intValue());
               stmt.setString(24, (String)parms[27], 1);
               stmt.setBoolean(25, ((Boolean) parms[28]).booleanValue());
               stmt.setBoolean(26, ((Boolean) parms[29]).booleanValue());
               if ( ((Boolean) parms[30]).booleanValue() )
               {
                  stmt.setNull( 27 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(27, (String)parms[31], 20);
               }
               if ( ((Boolean) parms[32]).booleanValue() )
               {
                  stmt.setNull( 28 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(28, (String)parms[33], 20);
               }
               if ( ((Boolean) parms[34]).booleanValue() )
               {
                  stmt.setNull( 29 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(29, (String)parms[35], 400);
               }
               if ( ((Boolean) parms[36]).booleanValue() )
               {
                  stmt.setNull( 30 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(30, (String)parms[37], 400);
               }
               if ( ((Boolean) parms[38]).booleanValue() )
               {
                  stmt.setNull( 31 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(31, ((Number) parms[39]).shortValue());
               }
               if ( ((Boolean) parms[40]).booleanValue() )
               {
                  stmt.setNull( 32 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(32, ((Number) parms[41]).shortValue());
               }
               if ( ((Boolean) parms[42]).booleanValue() )
               {
                  stmt.setNull( 33 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(33, ((Number) parms[43]).shortValue());
               }
               if ( ((Boolean) parms[44]).booleanValue() )
               {
                  stmt.setNull( 34 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(34, (String)parms[45], 8);
               }
               if ( ((Boolean) parms[46]).booleanValue() )
               {
                  stmt.setNull( 35 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(35, (String)parms[47], 4);
               }
               stmt.setShort(36, ((Number) parms[48]).shortValue());
               stmt.setString(37, (String)parms[49], 20);
               if ( ((Boolean) parms[50]).booleanValue() )
               {
                  stmt.setNull( 38 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(38, (String)parms[51], 20);
               }
               stmt.setString(39, (String)parms[52], 20);
               if ( ((Boolean) parms[53]).booleanValue() )
               {
                  stmt.setNull( 40 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(40, (String)parms[54], 20);
               }
               stmt.setShort(41, ((Number) parms[55]).shortValue());
               stmt.setInt(42, ((Number) parms[56]).intValue());
               stmt.setShort(43, ((Number) parms[57]).shortValue());
               return;
            case 57 :
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
               return;
            case 58 :
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
               return;
            case 59 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 61 :
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
            case 62 :
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
            case 63 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 64 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 65 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 66 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 67 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 68 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 69 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 70 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 71 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 72 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 73 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 74 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 75 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 76 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 77 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 78 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 79 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 80 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 81 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 82 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 83 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 84 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 85 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 86 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 87 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 88 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 89 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
               return;
            case 91 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 92 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 93 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 94 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 95 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 96 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 97 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 98 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 99 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 100 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 101 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 102 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 103 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 104 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 105 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 106 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 107 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 108 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 109 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 110 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 111 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 112 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 113 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 114 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 115 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 116 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 117 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 118 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 119 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
               return;
            case 121 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 122 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 123 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 124 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 125 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 126 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 127 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 128 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 129 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 130 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 131 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 132 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 133 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 134 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 135 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 136 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 137 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 138 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 139 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 140 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 141 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 142 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 143 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 144 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 145 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 146 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 147 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 148 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 149 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
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
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 151 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 152 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 153 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 154 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 155 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 156 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 157 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 158 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 159 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 160 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 161 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 162 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 163 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 164 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 165 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 166 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 167 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 168 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 169 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 170 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 171 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 172 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 173 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 174 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 175 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 176 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 177 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 178 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 4);
               return;
            case 179 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 4);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
      }
      setparameters180( cursor, stmt, parms) ;
   }

   public void setparameters180( int cursor ,
                                 IFieldSetter stmt ,
                                 Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 180 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 181 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 182 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 183 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 184 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 185 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 186 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 187 :
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
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setShort(7, ((Number) parms[7]).shortValue());
               stmt.setString(8, (String)parms[8], 20);
               return;
            case 188 :
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
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setShort(7, ((Number) parms[7]).shortValue());
               stmt.setShort(8, ((Number) parms[8]).shortValue());
               return;
            case 189 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 190 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 191 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 192 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 193 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 194 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 195 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 196 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 1);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 1);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 1);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 1);
               stmt.setString(11, (String)parms[10], 20);
               return;
            case 197 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 1);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 1);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 1);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 1);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setString(11, (String)parms[10], 20);
               return;
            case 198 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 199 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 200 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 201 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 202 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 203 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 204 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 205 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 206 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 207 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 208 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 209 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
      setparameters210( cursor, stmt, parms) ;
   }

   public void setparameters210( int cursor ,
                                 IFieldSetter stmt ,
                                 Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 210 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 211 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 212 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 213 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 214 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 215 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 216 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 217 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 218 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 219 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 220 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 221 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 222 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 223 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 224 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 225 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

