package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresa_bc extends GXWebPanel implements IGxSilentTrn
{
   public empresa_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresa_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresa_bc.class ));
   }

   public empresa_bc( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0F13( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0F13( ) ;
      standaloneModal( ) ;
      addRow0F13( ) ;
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
         e110F2 ();
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

   public void confirm_0F0( )
   {
      beforeValidate0F13( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0F13( ) ;
         }
         else
         {
            checkExtendedTable0F13( ) ;
            if ( AnyError == 0 )
            {
               zm0F13( 22) ;
               zm0F13( 23) ;
               zm0F13( 24) ;
               zm0F13( 25) ;
               zm0F13( 26) ;
               zm0F13( 27) ;
               zm0F13( 28) ;
               zm0F13( 29) ;
               zm0F13( 30) ;
               zm0F13( 31) ;
               zm0F13( 32) ;
               zm0F13( 33) ;
            }
            closeExtendedTableCursors0F13( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode13 = Gx_mode ;
         confirm_0F172( ) ;
         if ( AnyError == 0 )
         {
            confirm_0F171( ) ;
            if ( AnyError == 0 )
            {
               confirm_0F173( ) ;
               if ( AnyError == 0 )
               {
                  confirm_0F165( ) ;
                  if ( AnyError == 0 )
                  {
                     confirm_0F166( ) ;
                     if ( AnyError == 0 )
                     {
                        confirm_0F144( ) ;
                        if ( AnyError == 0 )
                        {
                           confirm_0F145( ) ;
                           if ( AnyError == 0 )
                           {
                              confirm_0F146( ) ;
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
         /* Restore parent mode. */
         Gx_mode = sMode13 ;
      }
   }

   public void confirm_0F146( )
   {
      nGXsfl_146_idx = 0 ;
      while ( nGXsfl_146_idx < bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_religion().size() )
      {
         readRow0F146( ) ;
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
            getKey0F146( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound146 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0F146( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0F146( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0F146( 48) ;
                     }
                     closeExtendedTableCursors0F146( ) ;
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
                     getByPrimaryKey0F146( ) ;
                     load0F146( ) ;
                     beforeValidate0F146( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0F146( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_146 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0F146( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0F146( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0F146( 48) ;
                           }
                           closeExtendedTableCursors0F146( ) ;
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
            VarsToRow146( ((web.SdtEmpresa_nolaborables_religion)bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_religion().elementAt(-1+nGXsfl_146_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0F145( )
   {
      nGXsfl_145_idx = 0 ;
      while ( nGXsfl_145_idx < bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_origen().size() )
      {
         readRow0F145( ) ;
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
            getKey0F145( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound145 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0F145( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0F145( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0F145( 46) ;
                     }
                     closeExtendedTableCursors0F145( ) ;
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
                     getByPrimaryKey0F145( ) ;
                     load0F145( ) ;
                     beforeValidate0F145( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0F145( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_145 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0F145( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0F145( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0F145( 46) ;
                           }
                           closeExtendedTableCursors0F145( ) ;
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
            VarsToRow145( ((web.SdtEmpresa_nolaborables_origen)bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_origen().elementAt(-1+nGXsfl_145_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0F144( )
   {
      nGXsfl_144_idx = 0 ;
      while ( nGXsfl_144_idx < bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_convenio().size() )
      {
         readRow0F144( ) ;
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
            getKey0F144( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound144 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0F144( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0F144( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors0F144( ) ;
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
                     getByPrimaryKey0F144( ) ;
                     load0F144( ) ;
                     beforeValidate0F144( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0F144( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_144 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0F144( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0F144( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors0F144( ) ;
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
            VarsToRow144( ((web.SdtEmpresa_nolaborables_convenio)bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_convenio().elementAt(-1+nGXsfl_144_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0F166( )
   {
      nGXsfl_166_idx = 0 ;
      while ( nGXsfl_166_idx < bcEmpresa.getgxTv_SdtEmpresa_Tipo_trabajo().size() )
      {
         readRow0F166( ) ;
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
            getKey0F166( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound166 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0F166( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0F166( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0F166( 43) ;
                     }
                     closeExtendedTableCursors0F166( ) ;
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
                     getByPrimaryKey0F166( ) ;
                     load0F166( ) ;
                     beforeValidate0F166( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0F166( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_166 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0F166( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0F166( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0F166( 43) ;
                           }
                           closeExtendedTableCursors0F166( ) ;
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
            VarsToRow166( ((web.SdtEmpresa_tipo_trabajo)bcEmpresa.getgxTv_SdtEmpresa_Tipo_trabajo().elementAt(-1+nGXsfl_166_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0F165( )
   {
      nGXsfl_165_idx = 0 ;
      while ( nGXsfl_165_idx < bcEmpresa.getgxTv_SdtEmpresa_Horasextras_pordia().size() )
      {
         readRow0F165( ) ;
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
            getKey0F165( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound165 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0F165( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0F165( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0F165( 41) ;
                     }
                     closeExtendedTableCursors0F165( ) ;
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
                     getByPrimaryKey0F165( ) ;
                     load0F165( ) ;
                     beforeValidate0F165( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0F165( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_165 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0F165( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0F165( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0F165( 41) ;
                           }
                           closeExtendedTableCursors0F165( ) ;
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
            VarsToRow165( ((web.SdtEmpresa_horasextras_pordia)bcEmpresa.getgxTv_SdtEmpresa_Horasextras_pordia().elementAt(-1+nGXsfl_165_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0F173( )
   {
      nGXsfl_173_idx = 0 ;
      while ( nGXsfl_173_idx < bcEmpresa.getgxTv_SdtEmpresa_Promedio_horanormal_mensualizados().size() )
      {
         readRow0F173( ) ;
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
            getKey0F173( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound173 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0F173( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0F173( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0F173( 39) ;
                     }
                     closeExtendedTableCursors0F173( ) ;
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
                     getByPrimaryKey0F173( ) ;
                     load0F173( ) ;
                     beforeValidate0F173( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0F173( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_173 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0F173( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0F173( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0F173( 39) ;
                           }
                           closeExtendedTableCursors0F173( ) ;
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
            VarsToRow173( ((web.SdtEmpresa_promedio_horanormal_mensualizados)bcEmpresa.getgxTv_SdtEmpresa_Promedio_horanormal_mensualizados().elementAt(-1+nGXsfl_173_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0F171( )
   {
      nGXsfl_171_idx = 0 ;
      while ( nGXsfl_171_idx < bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_mensualizados().size() )
      {
         readRow0F171( ) ;
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
            getKey0F171( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound171 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0F171( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0F171( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0F171( 37) ;
                     }
                     closeExtendedTableCursors0F171( ) ;
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
                     getByPrimaryKey0F171( ) ;
                     load0F171( ) ;
                     beforeValidate0F171( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0F171( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_171 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0F171( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0F171( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0F171( 37) ;
                           }
                           closeExtendedTableCursors0F171( ) ;
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
            VarsToRow171( ((web.SdtEmpresa_conceptos_horanormal_mensualizados)bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_mensualizados().elementAt(-1+nGXsfl_171_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0F172( )
   {
      nGXsfl_172_idx = 0 ;
      while ( nGXsfl_172_idx < bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_jornalizados().size() )
      {
         readRow0F172( ) ;
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
            getKey0F172( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound172 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0F172( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0F172( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0F172( 35) ;
                     }
                     closeExtendedTableCursors0F172( ) ;
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
                     getByPrimaryKey0F172( ) ;
                     load0F172( ) ;
                     beforeValidate0F172( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0F172( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_172 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0F172( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0F172( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0F172( 35) ;
                           }
                           closeExtendedTableCursors0F172( ) ;
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
            VarsToRow172( ((web.SdtEmpresa_conceptos_horanormal_jornalizados)bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_jornalizados().elementAt(-1+nGXsfl_172_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e120F2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV31IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV31IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_Insert", GXv_boolean3) ;
         empresa_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV31IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV31IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_Update", GXv_boolean3) ;
         empresa_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV31IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV31IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_Delete", GXv_boolean3) ;
         empresa_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV31IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV31IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV57Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV57Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV58GXV1 = 1 ;
         while ( AV58GXV1 <= AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV15TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV58GXV1));
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
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EmpZonCod") == 0 )
            {
               AV36Insert_EmpZonCod = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EmpActComercial") == 0 )
            {
               AV53Insert_EmpActComercial = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
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
               AV55Insert_EmpOsoCod = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EmpCondiCod") == 0 )
            {
               AV56Insert_EmpCondiCod = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            AV58GXV1 = (int)(AV58GXV1+1) ;
         }
      }
   }

   public void e110F2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) && ( GXutil.strcmp(A955EmpLogo, O955EmpLogo) != 0 ) || ( GXutil.strcmp(A958EmpFirma, O958EmpFirma) != 0 ) )
      {
         new web.actualizaarchivosliq(remoteHandle, context).execute( AV30CliCod, AV7EmpCod) ;
      }
      GXv_int4[0] = 0 ;
      GXv_date5[0] = AV33Date ;
      GXv_boolean3[0] = AV34CliMultiEmp ;
      GXv_char6[0] = "" ;
      new web.getdatoscliente(remoteHandle, context).execute( AV30CliCod, GXv_int4, GXv_date5, GXv_boolean3, GXv_char6) ;
      empresa_bc.this.AV33Date = GXv_date5[0] ;
      empresa_bc.this.AV34CliMultiEmp = GXv_boolean3[0] ;
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 )
      {
         AV10WebSession.setValue(httpContext.getMessage( "refrescar_empresas", ""), GXutil.trim( GXutil.str( A1EmpCod, 4, 0)));
      }
      if ( AV34CliMultiEmp )
      {
      }
      else
      {
      }
      /*  Sending Event outputs  */
   }

   public void zm0F13( int GX_JID )
   {
      if ( ( GX_JID == 21 ) || ( GX_JID == 0 ) )
      {
         Z2EmpNom = A2EmpNom ;
         Z177EmpCUIT = A177EmpCUIT ;
         Z125CatIvaCod = A125CatIvaCod ;
         Z126CatIvaDesc = A126CatIvaDesc ;
         Z178EmpDir = A178EmpDir ;
         Z180EmpTel = A180EmpTel ;
         Z176EmpCP = A176EmpCP ;
         Z532EmpReducc = A532EmpReducc ;
         Z1140EmpAntiguedad = A1140EmpAntiguedad ;
         Z1141EmpPresentismo = A1141EmpPresentismo ;
         Z1302EmpMesHsPExt = A1302EmpMesHsPExt ;
         Z1303EmpDiaHsPExt = A1303EmpDiaHsPExt ;
         Z1811EmpPerVacDes = A1811EmpPerVacDes ;
         Z1812EmpPerVacHas = A1812EmpPerVacHas ;
         Z1524EmpLiqFer = A1524EmpLiqFer ;
         Z1556EmpGuarEdadMin = A1556EmpGuarEdadMin ;
         Z1557EmpGuarEdadMax = A1557EmpGuarEdadMax ;
         Z1750EmpLiqFerJor = A1750EmpLiqFerJor ;
         Z1787EmpLiqGan = A1787EmpLiqGan ;
         Z1792EmpTipoExp = A1792EmpTipoExp ;
         Z1802EmpPromDesde = A1802EmpPromDesde ;
         Z1813EmpFracVacAnt = A1813EmpFracVacAnt ;
         Z1972EmpUltSexoIng = A1972EmpUltSexoIng ;
         Z2405EmpModTra = A2405EmpModTra ;
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
      if ( ( GX_JID == 22 ) || ( GX_JID == 0 ) )
      {
         Z312PaiNom = A312PaiNom ;
      }
      if ( ( GX_JID == 23 ) || ( GX_JID == 0 ) )
      {
         Z322ProvNom = A322ProvNom ;
      }
      if ( ( GX_JID == 24 ) || ( GX_JID == 0 ) )
      {
         Z286LocNom = A286LocNom ;
      }
      if ( ( GX_JID == 25 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 26 ) || ( GX_JID == 0 ) )
      {
         Z683ActDescripSinAc = A683ActDescripSinAc ;
         Z108ActDescrip = A108ActDescrip ;
      }
      if ( ( GX_JID == 27 ) || ( GX_JID == 0 ) )
      {
         Z530TipEmpleDefIns = A530TipEmpleDefIns ;
      }
      if ( ( GX_JID == 28 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 29 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 30 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 31 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 32 ) || ( GX_JID == 0 ) )
      {
         Z518EmpZonDescrip = A518EmpZonDescrip ;
      }
      if ( ( GX_JID == 33 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -21 )
      {
         Z1EmpCod = A1EmpCod ;
         Z2EmpNom = A2EmpNom ;
         Z177EmpCUIT = A177EmpCUIT ;
         Z125CatIvaCod = A125CatIvaCod ;
         Z126CatIvaDesc = A126CatIvaDesc ;
         Z178EmpDir = A178EmpDir ;
         Z180EmpTel = A180EmpTel ;
         Z176EmpCP = A176EmpCP ;
         Z532EmpReducc = A532EmpReducc ;
         Z955EmpLogo = A955EmpLogo ;
         Z958EmpFirma = A958EmpFirma ;
         Z1140EmpAntiguedad = A1140EmpAntiguedad ;
         Z1141EmpPresentismo = A1141EmpPresentismo ;
         Z1302EmpMesHsPExt = A1302EmpMesHsPExt ;
         Z1303EmpDiaHsPExt = A1303EmpDiaHsPExt ;
         Z1811EmpPerVacDes = A1811EmpPerVacDes ;
         Z1812EmpPerVacHas = A1812EmpPerVacHas ;
         Z1524EmpLiqFer = A1524EmpLiqFer ;
         Z1556EmpGuarEdadMin = A1556EmpGuarEdadMin ;
         Z1557EmpGuarEdadMax = A1557EmpGuarEdadMax ;
         Z1750EmpLiqFerJor = A1750EmpLiqFerJor ;
         Z1787EmpLiqGan = A1787EmpLiqGan ;
         Z1792EmpTipoExp = A1792EmpTipoExp ;
         Z1802EmpPromDesde = A1802EmpPromDesde ;
         Z1813EmpFracVacAnt = A1813EmpFracVacAnt ;
         Z1972EmpUltSexoIng = A1972EmpUltSexoIng ;
         Z2405EmpModTra = A2405EmpModTra ;
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
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int7 = A3CliCod ;
         GXv_int8[0] = GXt_int7 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
         empresa_bc.this.GXt_int7 = GXv_int8[0] ;
         A3CliCod = GXt_int7 ;
      }
   }

   public void standaloneModal( )
   {
   }

   public void load0F13( )
   {
      /* Using cursor BC000F39 */
      pr_default.execute(37, new Object[] {Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(37) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A683ActDescripSinAc = BC000F39_A683ActDescripSinAc[0] ;
         A2EmpNom = BC000F39_A2EmpNom[0] ;
         A177EmpCUIT = BC000F39_A177EmpCUIT[0] ;
         A125CatIvaCod = BC000F39_A125CatIvaCod[0] ;
         n125CatIvaCod = BC000F39_n125CatIvaCod[0] ;
         A126CatIvaDesc = BC000F39_A126CatIvaDesc[0] ;
         n126CatIvaDesc = BC000F39_n126CatIvaDesc[0] ;
         A178EmpDir = BC000F39_A178EmpDir[0] ;
         A180EmpTel = BC000F39_A180EmpTel[0] ;
         n180EmpTel = BC000F39_n180EmpTel[0] ;
         A176EmpCP = BC000F39_A176EmpCP[0] ;
         n176EmpCP = BC000F39_n176EmpCP[0] ;
         A312PaiNom = BC000F39_A312PaiNom[0] ;
         A322ProvNom = BC000F39_A322ProvNom[0] ;
         A286LocNom = BC000F39_A286LocNom[0] ;
         A108ActDescrip = BC000F39_A108ActDescrip[0] ;
         A518EmpZonDescrip = BC000F39_A518EmpZonDescrip[0] ;
         A532EmpReducc = BC000F39_A532EmpReducc[0] ;
         A530TipEmpleDefIns = BC000F39_A530TipEmpleDefIns[0] ;
         A955EmpLogo = BC000F39_A955EmpLogo[0] ;
         n955EmpLogo = BC000F39_n955EmpLogo[0] ;
         A958EmpFirma = BC000F39_A958EmpFirma[0] ;
         n958EmpFirma = BC000F39_n958EmpFirma[0] ;
         A1140EmpAntiguedad = BC000F39_A1140EmpAntiguedad[0] ;
         A1141EmpPresentismo = BC000F39_A1141EmpPresentismo[0] ;
         A1302EmpMesHsPExt = BC000F39_A1302EmpMesHsPExt[0] ;
         n1302EmpMesHsPExt = BC000F39_n1302EmpMesHsPExt[0] ;
         A1303EmpDiaHsPExt = BC000F39_A1303EmpDiaHsPExt[0] ;
         n1303EmpDiaHsPExt = BC000F39_n1303EmpDiaHsPExt[0] ;
         A1811EmpPerVacDes = BC000F39_A1811EmpPerVacDes[0] ;
         A1812EmpPerVacHas = BC000F39_A1812EmpPerVacHas[0] ;
         A1524EmpLiqFer = BC000F39_A1524EmpLiqFer[0] ;
         A1556EmpGuarEdadMin = BC000F39_A1556EmpGuarEdadMin[0] ;
         A1557EmpGuarEdadMax = BC000F39_A1557EmpGuarEdadMax[0] ;
         A1750EmpLiqFerJor = BC000F39_A1750EmpLiqFerJor[0] ;
         A1787EmpLiqGan = BC000F39_A1787EmpLiqGan[0] ;
         A1792EmpTipoExp = BC000F39_A1792EmpTipoExp[0] ;
         A1802EmpPromDesde = BC000F39_A1802EmpPromDesde[0] ;
         A1813EmpFracVacAnt = BC000F39_A1813EmpFracVacAnt[0] ;
         A1972EmpUltSexoIng = BC000F39_A1972EmpUltSexoIng[0] ;
         n1972EmpUltSexoIng = BC000F39_n1972EmpUltSexoIng[0] ;
         A2405EmpModTra = BC000F39_A2405EmpModTra[0] ;
         A957EmpLogoExt = BC000F39_A957EmpLogoExt[0] ;
         n957EmpLogoExt = BC000F39_n957EmpLogoExt[0] ;
         A955EmpLogo_Filetype = A957EmpLogoExt ;
         A960EmpFirmaExt = BC000F39_A960EmpFirmaExt[0] ;
         n960EmpFirmaExt = BC000F39_n960EmpFirmaExt[0] ;
         A958EmpFirma_Filetype = A960EmpFirmaExt ;
         A956EmpLogoNom = BC000F39_A956EmpLogoNom[0] ;
         n956EmpLogoNom = BC000F39_n956EmpLogoNom[0] ;
         A955EmpLogo_Filename = A956EmpLogoNom ;
         A959EmpFirmaNom = BC000F39_A959EmpFirmaNom[0] ;
         n959EmpFirmaNom = BC000F39_n959EmpFirmaNom[0] ;
         A958EmpFirma_Filename = A959EmpFirmaNom ;
         A46PaiCod = BC000F39_A46PaiCod[0] ;
         n46PaiCod = BC000F39_n46PaiCod[0] ;
         A47ProvCod = BC000F39_A47ProvCod[0] ;
         n47ProvCod = BC000F39_n47ProvCod[0] ;
         A48LocCod = BC000F39_A48LocCod[0] ;
         n48LocCod = BC000F39_n48LocCod[0] ;
         A43ActCodigo = BC000F39_A43ActCodigo[0] ;
         n43ActCodigo = BC000F39_n43ActCodigo[0] ;
         A45TipEmpleCod = BC000F39_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC000F39_n45TipEmpleCod[0] ;
         A1151ARTSec = BC000F39_A1151ARTSec[0] ;
         A903ActComCodigo = BC000F39_A903ActComCodigo[0] ;
         A1965EmpOsoCod = BC000F39_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC000F39_n1965EmpOsoCod[0] ;
         A1533EmpActComercial = BC000F39_A1533EmpActComercial[0] ;
         A44EmpZonCod = BC000F39_A44EmpZonCod[0] ;
         n44EmpZonCod = BC000F39_n44EmpZonCod[0] ;
         A2265EmpCondiCod = BC000F39_A2265EmpCondiCod[0] ;
         zm0F13( -21) ;
      }
      pr_default.close(37);
      onLoadActions0F13( ) ;
   }

   public void onLoadActions0F13( )
   {
      AV57Pgmname = "Empresa_BC" ;
   }

   public void checkExtendedTable0F13( )
   {
      nIsDirty_13 = (short)(0) ;
      standaloneModal( ) ;
      AV57Pgmname = "Empresa_BC" ;
      /* Using cursor BC000F40 */
      pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(38) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(38);
      /* Using cursor BC000F41 */
      pr_default.execute(39, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod});
      if ( (pr_default.getStatus(39) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1965EmpOsoCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Obra Social", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPOSOCOD");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(39);
      if ( (GXutil.strcmp("", A2EmpNom)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nombre", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( (0==A177EmpCUIT) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "CUIT", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000F42 */
      pr_default.execute(40, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(40) == 101) )
      {
         if ( ! ( (0==A46PaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
            AnyError = (short)(1) ;
         }
      }
      A312PaiNom = BC000F42_A312PaiNom[0] ;
      pr_default.close(40);
      /* Using cursor BC000F43 */
      pr_default.execute(41, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(41) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (0==A47ProvCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROVCOD");
            AnyError = (short)(1) ;
         }
      }
      A322ProvNom = BC000F43_A322ProvNom[0] ;
      pr_default.close(41);
      /* Using cursor BC000F44 */
      pr_default.execute(42, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
      if ( (pr_default.getStatus(42) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (0==A47ProvCod) || (0==A48LocCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCCOD");
            AnyError = (short)(1) ;
         }
      }
      A286LocNom = BC000F44_A286LocNom[0] ;
      pr_default.close(42);
      /* Using cursor BC000F45 */
      pr_default.execute(43, new Object[] {Boolean.valueOf(n43ActCodigo), A43ActCodigo});
      if ( (pr_default.getStatus(43) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A43ActCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Actividad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ACTCODIGO");
            AnyError = (short)(1) ;
         }
      }
      A683ActDescripSinAc = BC000F45_A683ActDescripSinAc[0] ;
      A108ActDescrip = BC000F45_A108ActDescrip[0] ;
      pr_default.close(43);
      if ( (GXutil.strcmp("", A43ActCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Actividad", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000F46 */
      pr_default.execute(44, new Object[] {Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod});
      if ( (pr_default.getStatus(44) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A45TipEmpleCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Empleador", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPEMPLECOD");
            AnyError = (short)(1) ;
         }
      }
      A530TipEmpleDefIns = BC000F46_A530TipEmpleDefIns[0] ;
      pr_default.close(44);
      if ( (GXutil.strcmp("", A45TipEmpleCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Tipo de Empleador según decreto 814/01 art. 2", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000F47 */
      pr_default.execute(45, new Object[] {Boolean.valueOf(n44EmpZonCod), A44EmpZonCod});
      if ( (pr_default.getStatus(45) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A44EmpZonCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Zona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPZONCOD");
            AnyError = (short)(1) ;
         }
      }
      A518EmpZonDescrip = BC000F47_A518EmpZonDescrip[0] ;
      pr_default.close(45);
      if ( (GXutil.strcmp("", A44EmpZonCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Zona", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000F48 */
      pr_default.execute(46, new Object[] {A1533EmpActComercial});
      if ( (pr_default.getStatus(46) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Actividad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPACTCOMERCIAL");
         AnyError = (short)(1) ;
      }
      pr_default.close(46);
      if ( ! ( ( GXutil.strcmp(A1303EmpDiaHsPExt, "Promedio") == 0 ) || ( GXutil.strcmp(A1303EmpDiaHsPExt, "diasSemanaX4") == 0 ) || ( GXutil.strcmp(A1303EmpDiaHsPExt, "diasSemanaMes") == 0 ) || (GXutil.strcmp("", A1303EmpDiaHsPExt)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Días habiles del mes para obtener cantidad de horas del mes para cálculo de 1 hora de trabajo para empleados de clase mensual", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000F49 */
      pr_default.execute(47, new Object[] {Short.valueOf(A1151ARTSec)});
      if ( (pr_default.getStatus(47) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "ART", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ARTSEC");
         AnyError = (short)(1) ;
      }
      pr_default.close(47);
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
      /* Using cursor BC000F50 */
      pr_default.execute(48, new Object[] {A903ActComCodigo});
      if ( (pr_default.getStatus(48) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "actividadcomercial", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ACTCOMCODIGO");
         AnyError = (short)(1) ;
      }
      pr_default.close(48);
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
      /* Using cursor BC000F51 */
      pr_default.execute(49, new Object[] {Short.valueOf(A2265EmpCondiCod)});
      if ( (pr_default.getStatus(49) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Condi AFIP", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCONDICOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(49);
      if ( ! ( ( GXutil.strcmp(A2405EmpModTra, "E") == 0 ) || ( GXutil.strcmp(A2405EmpModTra, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Modo de trabajo predeterminado", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0F13( )
   {
      pr_default.close(38);
      pr_default.close(39);
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
   }

   public void enableDisable( )
   {
   }

   public void getKey0F13( )
   {
      /* Using cursor BC000F52 */
      pr_default.execute(50, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(50) != 101) )
      {
         RcdFound13 = (short)(1) ;
      }
      else
      {
         RcdFound13 = (short)(0) ;
      }
      pr_default.close(50);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000F53 */
      pr_default.execute(51, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(51) != 101) )
      {
         zm0F13( 21) ;
         RcdFound13 = (short)(1) ;
         A1EmpCod = BC000F53_A1EmpCod[0] ;
         A2EmpNom = BC000F53_A2EmpNom[0] ;
         A177EmpCUIT = BC000F53_A177EmpCUIT[0] ;
         A125CatIvaCod = BC000F53_A125CatIvaCod[0] ;
         n125CatIvaCod = BC000F53_n125CatIvaCod[0] ;
         A126CatIvaDesc = BC000F53_A126CatIvaDesc[0] ;
         n126CatIvaDesc = BC000F53_n126CatIvaDesc[0] ;
         A178EmpDir = BC000F53_A178EmpDir[0] ;
         A180EmpTel = BC000F53_A180EmpTel[0] ;
         n180EmpTel = BC000F53_n180EmpTel[0] ;
         A176EmpCP = BC000F53_A176EmpCP[0] ;
         n176EmpCP = BC000F53_n176EmpCP[0] ;
         A532EmpReducc = BC000F53_A532EmpReducc[0] ;
         A955EmpLogo = BC000F53_A955EmpLogo[0] ;
         n955EmpLogo = BC000F53_n955EmpLogo[0] ;
         A958EmpFirma = BC000F53_A958EmpFirma[0] ;
         n958EmpFirma = BC000F53_n958EmpFirma[0] ;
         A1140EmpAntiguedad = BC000F53_A1140EmpAntiguedad[0] ;
         A1141EmpPresentismo = BC000F53_A1141EmpPresentismo[0] ;
         A1302EmpMesHsPExt = BC000F53_A1302EmpMesHsPExt[0] ;
         n1302EmpMesHsPExt = BC000F53_n1302EmpMesHsPExt[0] ;
         A1303EmpDiaHsPExt = BC000F53_A1303EmpDiaHsPExt[0] ;
         n1303EmpDiaHsPExt = BC000F53_n1303EmpDiaHsPExt[0] ;
         A1811EmpPerVacDes = BC000F53_A1811EmpPerVacDes[0] ;
         A1812EmpPerVacHas = BC000F53_A1812EmpPerVacHas[0] ;
         A1524EmpLiqFer = BC000F53_A1524EmpLiqFer[0] ;
         A1556EmpGuarEdadMin = BC000F53_A1556EmpGuarEdadMin[0] ;
         A1557EmpGuarEdadMax = BC000F53_A1557EmpGuarEdadMax[0] ;
         A1750EmpLiqFerJor = BC000F53_A1750EmpLiqFerJor[0] ;
         A1787EmpLiqGan = BC000F53_A1787EmpLiqGan[0] ;
         A1792EmpTipoExp = BC000F53_A1792EmpTipoExp[0] ;
         A1802EmpPromDesde = BC000F53_A1802EmpPromDesde[0] ;
         A1813EmpFracVacAnt = BC000F53_A1813EmpFracVacAnt[0] ;
         A1972EmpUltSexoIng = BC000F53_A1972EmpUltSexoIng[0] ;
         n1972EmpUltSexoIng = BC000F53_n1972EmpUltSexoIng[0] ;
         A2405EmpModTra = BC000F53_A2405EmpModTra[0] ;
         A957EmpLogoExt = BC000F53_A957EmpLogoExt[0] ;
         n957EmpLogoExt = BC000F53_n957EmpLogoExt[0] ;
         A955EmpLogo_Filetype = A957EmpLogoExt ;
         A960EmpFirmaExt = BC000F53_A960EmpFirmaExt[0] ;
         n960EmpFirmaExt = BC000F53_n960EmpFirmaExt[0] ;
         A958EmpFirma_Filetype = A960EmpFirmaExt ;
         A956EmpLogoNom = BC000F53_A956EmpLogoNom[0] ;
         n956EmpLogoNom = BC000F53_n956EmpLogoNom[0] ;
         A955EmpLogo_Filename = A956EmpLogoNom ;
         A959EmpFirmaNom = BC000F53_A959EmpFirmaNom[0] ;
         n959EmpFirmaNom = BC000F53_n959EmpFirmaNom[0] ;
         A958EmpFirma_Filename = A959EmpFirmaNom ;
         A46PaiCod = BC000F53_A46PaiCod[0] ;
         n46PaiCod = BC000F53_n46PaiCod[0] ;
         A47ProvCod = BC000F53_A47ProvCod[0] ;
         n47ProvCod = BC000F53_n47ProvCod[0] ;
         A48LocCod = BC000F53_A48LocCod[0] ;
         n48LocCod = BC000F53_n48LocCod[0] ;
         A3CliCod = BC000F53_A3CliCod[0] ;
         A43ActCodigo = BC000F53_A43ActCodigo[0] ;
         n43ActCodigo = BC000F53_n43ActCodigo[0] ;
         A45TipEmpleCod = BC000F53_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC000F53_n45TipEmpleCod[0] ;
         A1151ARTSec = BC000F53_A1151ARTSec[0] ;
         A903ActComCodigo = BC000F53_A903ActComCodigo[0] ;
         A1965EmpOsoCod = BC000F53_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC000F53_n1965EmpOsoCod[0] ;
         A1533EmpActComercial = BC000F53_A1533EmpActComercial[0] ;
         A44EmpZonCod = BC000F53_A44EmpZonCod[0] ;
         n44EmpZonCod = BC000F53_n44EmpZonCod[0] ;
         A2265EmpCondiCod = BC000F53_A2265EmpCondiCod[0] ;
         O955EmpLogo = A955EmpLogo ;
         n955EmpLogo = false ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0F13( ) ;
         if ( AnyError == 1 )
         {
            RcdFound13 = (short)(0) ;
            initializeNonKey0F13( ) ;
         }
         Gx_mode = sMode13 ;
      }
      else
      {
         RcdFound13 = (short)(0) ;
         initializeNonKey0F13( ) ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode13 ;
      }
      pr_default.close(51);
   }

   public void getEqualNoModal( )
   {
      getKey0F13( ) ;
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
      confirm_0F0( ) ;
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

   public void checkOptimisticConcurrency0F13( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000F54 */
         pr_default.execute(52, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(52) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresa"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(52) == 101) || ( GXutil.strcmp(Z2EmpNom, BC000F54_A2EmpNom[0]) != 0 ) || ( Z177EmpCUIT != BC000F54_A177EmpCUIT[0] ) || ( Z125CatIvaCod != BC000F54_A125CatIvaCod[0] ) || ( GXutil.strcmp(Z126CatIvaDesc, BC000F54_A126CatIvaDesc[0]) != 0 ) || ( GXutil.strcmp(Z178EmpDir, BC000F54_A178EmpDir[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z180EmpTel, BC000F54_A180EmpTel[0]) != 0 ) || ( GXutil.strcmp(Z176EmpCP, BC000F54_A176EmpCP[0]) != 0 ) || ( Z532EmpReducc != BC000F54_A532EmpReducc[0] ) || ( DecimalUtil.compareTo(Z1140EmpAntiguedad, BC000F54_A1140EmpAntiguedad[0]) != 0 ) || ( DecimalUtil.compareTo(Z1141EmpPresentismo, BC000F54_A1141EmpPresentismo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1302EmpMesHsPExt, BC000F54_A1302EmpMesHsPExt[0]) != 0 ) || ( GXutil.strcmp(Z1303EmpDiaHsPExt, BC000F54_A1303EmpDiaHsPExt[0]) != 0 ) || ( Z1811EmpPerVacDes != BC000F54_A1811EmpPerVacDes[0] ) || ( Z1812EmpPerVacHas != BC000F54_A1812EmpPerVacHas[0] ) || ( Z1524EmpLiqFer != BC000F54_A1524EmpLiqFer[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1556EmpGuarEdadMin != BC000F54_A1556EmpGuarEdadMin[0] ) || ( Z1557EmpGuarEdadMax != BC000F54_A1557EmpGuarEdadMax[0] ) || ( Z1750EmpLiqFerJor != BC000F54_A1750EmpLiqFerJor[0] ) || ( Z1787EmpLiqGan != BC000F54_A1787EmpLiqGan[0] ) || ( Z1792EmpTipoExp != BC000F54_A1792EmpTipoExp[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1802EmpPromDesde, BC000F54_A1802EmpPromDesde[0]) != 0 ) || ( DecimalUtil.compareTo(Z1813EmpFracVacAnt, BC000F54_A1813EmpFracVacAnt[0]) != 0 ) || ( Z1972EmpUltSexoIng != BC000F54_A1972EmpUltSexoIng[0] ) || ( GXutil.strcmp(Z2405EmpModTra, BC000F54_A2405EmpModTra[0]) != 0 ) || ( Z46PaiCod != BC000F54_A46PaiCod[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z47ProvCod != BC000F54_A47ProvCod[0] ) || ( Z48LocCod != BC000F54_A48LocCod[0] ) || ( GXutil.strcmp(Z43ActCodigo, BC000F54_A43ActCodigo[0]) != 0 ) || ( GXutil.strcmp(Z45TipEmpleCod, BC000F54_A45TipEmpleCod[0]) != 0 ) || ( Z1151ARTSec != BC000F54_A1151ARTSec[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z903ActComCodigo, BC000F54_A903ActComCodigo[0]) != 0 ) || ( GXutil.strcmp(Z1965EmpOsoCod, BC000F54_A1965EmpOsoCod[0]) != 0 ) || ( GXutil.strcmp(Z1533EmpActComercial, BC000F54_A1533EmpActComercial[0]) != 0 ) || ( GXutil.strcmp(Z44EmpZonCod, BC000F54_A44EmpZonCod[0]) != 0 ) || ( Z2265EmpCondiCod != BC000F54_A2265EmpCondiCod[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresa"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0F13( )
   {
      beforeValidate0F13( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F13( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0F13( 0) ;
         checkOptimisticConcurrency0F13( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F13( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0F13( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F55 */
                  pr_default.execute(53, new Object[] {Short.valueOf(A1EmpCod), A2EmpNom, Long.valueOf(A177EmpCUIT), Boolean.valueOf(n125CatIvaCod), Short.valueOf(A125CatIvaCod), Boolean.valueOf(n126CatIvaDesc), A126CatIvaDesc, A178EmpDir, Boolean.valueOf(n180EmpTel), A180EmpTel, Boolean.valueOf(n176EmpCP), A176EmpCP, Boolean.valueOf(A532EmpReducc), Boolean.valueOf(n955EmpLogo), A955EmpLogo, Boolean.valueOf(n958EmpFirma), A958EmpFirma, A1140EmpAntiguedad, A1141EmpPresentismo, Boolean.valueOf(n1302EmpMesHsPExt), A1302EmpMesHsPExt, Boolean.valueOf(n1303EmpDiaHsPExt), A1303EmpDiaHsPExt, Byte.valueOf(A1811EmpPerVacDes), Byte.valueOf(A1812EmpPerVacHas), Boolean.valueOf(A1524EmpLiqFer), Byte.valueOf(A1556EmpGuarEdadMin), Byte.valueOf(A1557EmpGuarEdadMax), Boolean.valueOf(A1750EmpLiqFerJor), Boolean.valueOf(A1787EmpLiqGan), Byte.valueOf(A1792EmpTipoExp), A1802EmpPromDesde, A1813EmpFracVacAnt, Boolean.valueOf(n1972EmpUltSexoIng), Byte.valueOf(A1972EmpUltSexoIng), A2405EmpModTra, Boolean.valueOf(n957EmpLogoExt), A957EmpLogoExt, Boolean.valueOf(n960EmpFirmaExt), A960EmpFirmaExt, Boolean.valueOf(n956EmpLogoNom), A956EmpLogoNom, Boolean.valueOf(n959EmpFirmaNom), A959EmpFirmaNom, Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod), Integer.valueOf(A3CliCod), Boolean.valueOf(n43ActCodigo), A43ActCodigo, Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod, Short.valueOf(A1151ARTSec), A903ActComCodigo, Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod, A1533EmpActComercial, Boolean.valueOf(n44EmpZonCod), A44EmpZonCod, Short.valueOf(A2265EmpCondiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
                  if ( (pr_default.getStatus(53) == 1) )
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
                        processLevel0F13( ) ;
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
            load0F13( ) ;
         }
         endLevel0F13( ) ;
      }
      closeExtendedTableCursors0F13( ) ;
   }

   public void update0F13( )
   {
      beforeValidate0F13( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F13( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F13( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F13( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0F13( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F56 */
                  pr_default.execute(54, new Object[] {A2EmpNom, Long.valueOf(A177EmpCUIT), Boolean.valueOf(n125CatIvaCod), Short.valueOf(A125CatIvaCod), Boolean.valueOf(n126CatIvaDesc), A126CatIvaDesc, A178EmpDir, Boolean.valueOf(n180EmpTel), A180EmpTel, Boolean.valueOf(n176EmpCP), A176EmpCP, Boolean.valueOf(A532EmpReducc), A1140EmpAntiguedad, A1141EmpPresentismo, Boolean.valueOf(n1302EmpMesHsPExt), A1302EmpMesHsPExt, Boolean.valueOf(n1303EmpDiaHsPExt), A1303EmpDiaHsPExt, Byte.valueOf(A1811EmpPerVacDes), Byte.valueOf(A1812EmpPerVacHas), Boolean.valueOf(A1524EmpLiqFer), Byte.valueOf(A1556EmpGuarEdadMin), Byte.valueOf(A1557EmpGuarEdadMax), Boolean.valueOf(A1750EmpLiqFerJor), Boolean.valueOf(A1787EmpLiqGan), Byte.valueOf(A1792EmpTipoExp), A1802EmpPromDesde, A1813EmpFracVacAnt, Boolean.valueOf(n1972EmpUltSexoIng), Byte.valueOf(A1972EmpUltSexoIng), A2405EmpModTra, Boolean.valueOf(n957EmpLogoExt), A957EmpLogoExt, Boolean.valueOf(n960EmpFirmaExt), A960EmpFirmaExt, Boolean.valueOf(n956EmpLogoNom), A956EmpLogoNom, Boolean.valueOf(n959EmpFirmaNom), A959EmpFirmaNom, Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod), Boolean.valueOf(n43ActCodigo), A43ActCodigo, Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod, Short.valueOf(A1151ARTSec), A903ActComCodigo, Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod, A1533EmpActComercial, Boolean.valueOf(n44EmpZonCod), A44EmpZonCod, Short.valueOf(A2265EmpCondiCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
                  if ( (pr_default.getStatus(54) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresa"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0F13( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0F13( ) ;
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
         endLevel0F13( ) ;
      }
      closeExtendedTableCursors0F13( ) ;
   }

   public void deferredUpdate0F13( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC000F57 */
         pr_default.execute(55, new Object[] {Boolean.valueOf(n955EmpLogo), A955EmpLogo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000F58 */
         pr_default.execute(56, new Object[] {Boolean.valueOf(n958EmpFirma), A958EmpFirma, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0F13( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F13( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0F13( ) ;
         afterConfirm0F13( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0F13( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart0F173( ) ;
               while ( RcdFound173 != 0 )
               {
                  getByPrimaryKey0F173( ) ;
                  delete0F173( ) ;
                  scanKeyNext0F173( ) ;
               }
               scanKeyEnd0F173( ) ;
               scanKeyStart0F172( ) ;
               while ( RcdFound172 != 0 )
               {
                  getByPrimaryKey0F172( ) ;
                  delete0F172( ) ;
                  scanKeyNext0F172( ) ;
               }
               scanKeyEnd0F172( ) ;
               scanKeyStart0F171( ) ;
               while ( RcdFound171 != 0 )
               {
                  getByPrimaryKey0F171( ) ;
                  delete0F171( ) ;
                  scanKeyNext0F171( ) ;
               }
               scanKeyEnd0F171( ) ;
               scanKeyStart0F165( ) ;
               while ( RcdFound165 != 0 )
               {
                  getByPrimaryKey0F165( ) ;
                  delete0F165( ) ;
                  scanKeyNext0F165( ) ;
               }
               scanKeyEnd0F165( ) ;
               scanKeyStart0F146( ) ;
               while ( RcdFound146 != 0 )
               {
                  getByPrimaryKey0F146( ) ;
                  delete0F146( ) ;
                  scanKeyNext0F146( ) ;
               }
               scanKeyEnd0F146( ) ;
               scanKeyStart0F145( ) ;
               while ( RcdFound145 != 0 )
               {
                  getByPrimaryKey0F145( ) ;
                  delete0F145( ) ;
                  scanKeyNext0F145( ) ;
               }
               scanKeyEnd0F145( ) ;
               scanKeyStart0F144( ) ;
               while ( RcdFound144 != 0 )
               {
                  getByPrimaryKey0F144( ) ;
                  delete0F144( ) ;
                  scanKeyNext0F144( ) ;
               }
               scanKeyEnd0F144( ) ;
               scanKeyStart0F166( ) ;
               while ( RcdFound166 != 0 )
               {
                  getByPrimaryKey0F166( ) ;
                  delete0F166( ) ;
                  scanKeyNext0F166( ) ;
               }
               scanKeyEnd0F166( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F59 */
                  pr_default.execute(57, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
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
      endLevel0F13( ) ;
      Gx_mode = sMode13 ;
   }

   public void onDeleteControls0F13( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV57Pgmname = "Empresa_BC" ;
         /* Using cursor BC000F60 */
         pr_default.execute(58, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
         A312PaiNom = BC000F60_A312PaiNom[0] ;
         pr_default.close(58);
         /* Using cursor BC000F61 */
         pr_default.execute(59, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
         A322ProvNom = BC000F61_A322ProvNom[0] ;
         pr_default.close(59);
         /* Using cursor BC000F62 */
         pr_default.execute(60, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
         A286LocNom = BC000F62_A286LocNom[0] ;
         pr_default.close(60);
         /* Using cursor BC000F63 */
         pr_default.execute(61, new Object[] {Boolean.valueOf(n43ActCodigo), A43ActCodigo});
         A683ActDescripSinAc = BC000F63_A683ActDescripSinAc[0] ;
         A108ActDescrip = BC000F63_A108ActDescrip[0] ;
         pr_default.close(61);
         /* Using cursor BC000F64 */
         pr_default.execute(62, new Object[] {Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod});
         A530TipEmpleDefIns = BC000F64_A530TipEmpleDefIns[0] ;
         pr_default.close(62);
         /* Using cursor BC000F65 */
         pr_default.execute(63, new Object[] {Boolean.valueOf(n44EmpZonCod), A44EmpZonCod});
         A518EmpZonDescrip = BC000F65_A518EmpZonDescrip[0] ;
         pr_default.close(63);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000F66 */
         pr_default.execute(64, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(64) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "banda_salarial", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(64);
         /* Using cursor BC000F67 */
         pr_default.execute(65, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(65) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(65);
         /* Using cursor BC000F68 */
         pr_default.execute(66, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(66) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionLotes3", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(66);
         /* Using cursor BC000F69 */
         pr_default.execute(67, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(67) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(67);
         /* Using cursor BC000F70 */
         pr_default.execute(68, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(68) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionLegajoLinkPdf", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(68);
         /* Using cursor BC000F71 */
         pr_default.execute(69, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(69) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionSucursal", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(69);
         /* Using cursor BC000F72 */
         pr_default.execute(70, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(70) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionArea", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(70);
         /* Using cursor BC000F73 */
         pr_default.execute(71, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(71) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionConvenio", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(71);
         /* Using cursor BC000F74 */
         pr_default.execute(72, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(72) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "EmpresaBancos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(72);
         /* Using cursor BC000F75 */
         pr_default.execute(73, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(73) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Periodo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(73);
         /* Using cursor BC000F76 */
         pr_default.execute(74, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(74) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LSD_reg1", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(74);
         /* Using cursor BC000F77 */
         pr_default.execute(75, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(75) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(75);
         /* Using cursor BC000F78 */
         pr_default.execute(76, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(76) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(76);
         /* Using cursor BC000F79 */
         pr_default.execute(77, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(77) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(77);
         /* Using cursor BC000F80 */
         pr_default.execute(78, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(78) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(78);
         /* Using cursor BC000F81 */
         pr_default.execute(79, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(79) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(79);
         /* Using cursor BC000F82 */
         pr_default.execute(80, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(80) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(80);
         /* Using cursor BC000F83 */
         pr_default.execute(81, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(81) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(81);
         /* Using cursor BC000F84 */
         pr_default.execute(82, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(82) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(82);
         /* Using cursor BC000F85 */
         pr_default.execute(83, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(83) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(83);
         /* Using cursor BC000F86 */
         pr_default.execute(84, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(84) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(84);
         /* Using cursor BC000F87 */
         pr_default.execute(85, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(85) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(85);
         /* Using cursor BC000F88 */
         pr_default.execute(86, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(86) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(86);
         /* Using cursor BC000F89 */
         pr_default.execute(87, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(87) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(87);
         /* Using cursor BC000F90 */
         pr_default.execute(88, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(88) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(88);
         /* Using cursor BC000F91 */
         pr_default.execute(89, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(89) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(89);
         /* Using cursor BC000F92 */
         pr_default.execute(90, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(90) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(90);
         /* Using cursor BC000F93 */
         pr_default.execute(91, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(91) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(91);
         /* Using cursor BC000F94 */
         pr_default.execute(92, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(92) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(92);
         /* Using cursor BC000F95 */
         pr_default.execute(93, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(93) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(93);
         /* Using cursor BC000F96 */
         pr_default.execute(94, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(94) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(94);
         /* Using cursor BC000F97 */
         pr_default.execute(95, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(95) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(95);
         /* Using cursor BC000F98 */
         pr_default.execute(96, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(96) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(96);
         /* Using cursor BC000F99 */
         pr_default.execute(97, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(97) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(97);
         /* Using cursor BC000F100 */
         pr_default.execute(98, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(98) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(98);
         /* Using cursor BC000F101 */
         pr_default.execute(99, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(99) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(99);
         /* Using cursor BC000F102 */
         pr_default.execute(100, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(100) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(100);
         /* Using cursor BC000F103 */
         pr_default.execute(101, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(101) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(101);
         /* Using cursor BC000F104 */
         pr_default.execute(102, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(102) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(102);
         /* Using cursor BC000F105 */
         pr_default.execute(103, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(103) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(103);
         /* Using cursor BC000F106 */
         pr_default.execute(104, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(104) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(104);
         /* Using cursor BC000F107 */
         pr_default.execute(105, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(105) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(105);
         /* Using cursor BC000F108 */
         pr_default.execute(106, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(106) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(106);
         /* Using cursor BC000F109 */
         pr_default.execute(107, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(107) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(107);
         /* Using cursor BC000F110 */
         pr_default.execute(108, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(108) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(108);
         /* Using cursor BC000F111 */
         pr_default.execute(109, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(109) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(109);
         /* Using cursor BC000F112 */
         pr_default.execute(110, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(110) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(110);
         /* Using cursor BC000F113 */
         pr_default.execute(111, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(111) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(111);
         /* Using cursor BC000F114 */
         pr_default.execute(112, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(112) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(112);
         /* Using cursor BC000F115 */
         pr_default.execute(113, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(113) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(113);
         /* Using cursor BC000F116 */
         pr_default.execute(114, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(114) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(114);
         /* Using cursor BC000F117 */
         pr_default.execute(115, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(115) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(115);
         /* Using cursor BC000F118 */
         pr_default.execute(116, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(116) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(116);
         /* Using cursor BC000F119 */
         pr_default.execute(117, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(117) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(117);
         /* Using cursor BC000F120 */
         pr_default.execute(118, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(118) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(118);
         /* Using cursor BC000F121 */
         pr_default.execute(119, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(119) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(119);
         /* Using cursor BC000F122 */
         pr_default.execute(120, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(120) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(120);
         /* Using cursor BC000F123 */
         pr_default.execute(121, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(121) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(121);
         /* Using cursor BC000F124 */
         pr_default.execute(122, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(122) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(122);
         /* Using cursor BC000F125 */
         pr_default.execute(123, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(123) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(123);
         /* Using cursor BC000F126 */
         pr_default.execute(124, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(124) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(124);
         /* Using cursor BC000F127 */
         pr_default.execute(125, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(125) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(125);
         /* Using cursor BC000F128 */
         pr_default.execute(126, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(126) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(126);
         /* Using cursor BC000F129 */
         pr_default.execute(127, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(127) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(127);
         /* Using cursor BC000F130 */
         pr_default.execute(128, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(128) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(128);
         /* Using cursor BC000F131 */
         pr_default.execute(129, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(129) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(129);
         /* Using cursor BC000F132 */
         pr_default.execute(130, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(130) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(130);
         /* Using cursor BC000F133 */
         pr_default.execute(131, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(131) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Guarderias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(131);
         /* Using cursor BC000F134 */
         pr_default.execute(132, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(132) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "base_calculo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(132);
         /* Using cursor BC000F135 */
         pr_default.execute(133, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(133) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "horasextras_pordia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(133);
         /* Using cursor BC000F136 */
         pr_default.execute(134, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(134) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Sucursal", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(134);
         /* Using cursor BC000F137 */
         pr_default.execute(135, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(135) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Formulario F1357", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(135);
         /* Using cursor BC000F138 */
         pr_default.execute(136, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(136) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "importacion_liquidaciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(136);
         /* Using cursor BC000F139 */
         pr_default.execute(137, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(137) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "importacion_legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(137);
         /* Using cursor BC000F140 */
         pr_default.execute(138, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(138) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Template Recibo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(138);
         /* Using cursor BC000F141 */
         pr_default.execute(139, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(139) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "archivo_siradig", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(139);
         /* Using cursor BC000F142 */
         pr_default.execute(140, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(140) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Asiento Cab", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(140);
         /* Using cursor BC000F143 */
         pr_default.execute(141, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(141) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cuenta Contable", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(141);
         /* Using cursor BC000F144 */
         pr_default.execute(142, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(142) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Centro De Costo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(142);
         /* Using cursor BC000F145 */
         pr_default.execute(143, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(143) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Lugar Pago", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(143);
         /* Using cursor BC000F146 */
         pr_default.execute(144, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(144) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(144);
      }
   }

   public void processNestedLevel0F172( )
   {
      nGXsfl_172_idx = 0 ;
      while ( nGXsfl_172_idx < bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_jornalizados().size() )
      {
         readRow0F172( ) ;
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
            standaloneNotModal0F172( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0F172( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0F172( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0F172( ) ;
               }
            }
         }
         KeyVarsToRow172( ((web.SdtEmpresa_conceptos_horanormal_jornalizados)bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_jornalizados().elementAt(-1+nGXsfl_172_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_172_idx = 0 ;
         while ( nGXsfl_172_idx < bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_jornalizados().size() )
         {
            readRow0F172( ) ;
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
               bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_jornalizados().removeElement(nGXsfl_172_idx);
               nGXsfl_172_idx = (int)(nGXsfl_172_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0F172( ) ;
               VarsToRow172( ((web.SdtEmpresa_conceptos_horanormal_jornalizados)bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_jornalizados().elementAt(-1+nGXsfl_172_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0F172( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_172 = (short)(0) ;
      nIsMod_172 = (short)(0) ;
      Gxremove172 = (byte)(0) ;
   }

   public void processNestedLevel0F171( )
   {
      nGXsfl_171_idx = 0 ;
      while ( nGXsfl_171_idx < bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_mensualizados().size() )
      {
         readRow0F171( ) ;
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
            standaloneNotModal0F171( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0F171( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0F171( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0F171( ) ;
               }
            }
         }
         KeyVarsToRow171( ((web.SdtEmpresa_conceptos_horanormal_mensualizados)bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_mensualizados().elementAt(-1+nGXsfl_171_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_171_idx = 0 ;
         while ( nGXsfl_171_idx < bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_mensualizados().size() )
         {
            readRow0F171( ) ;
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
               bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_mensualizados().removeElement(nGXsfl_171_idx);
               nGXsfl_171_idx = (int)(nGXsfl_171_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0F171( ) ;
               VarsToRow171( ((web.SdtEmpresa_conceptos_horanormal_mensualizados)bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_mensualizados().elementAt(-1+nGXsfl_171_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0F171( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_171 = (short)(0) ;
      nIsMod_171 = (short)(0) ;
      Gxremove171 = (byte)(0) ;
   }

   public void processNestedLevel0F173( )
   {
      nGXsfl_173_idx = 0 ;
      while ( nGXsfl_173_idx < bcEmpresa.getgxTv_SdtEmpresa_Promedio_horanormal_mensualizados().size() )
      {
         readRow0F173( ) ;
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
            standaloneNotModal0F173( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0F173( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0F173( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0F173( ) ;
               }
            }
         }
         KeyVarsToRow173( ((web.SdtEmpresa_promedio_horanormal_mensualizados)bcEmpresa.getgxTv_SdtEmpresa_Promedio_horanormal_mensualizados().elementAt(-1+nGXsfl_173_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_173_idx = 0 ;
         while ( nGXsfl_173_idx < bcEmpresa.getgxTv_SdtEmpresa_Promedio_horanormal_mensualizados().size() )
         {
            readRow0F173( ) ;
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
               bcEmpresa.getgxTv_SdtEmpresa_Promedio_horanormal_mensualizados().removeElement(nGXsfl_173_idx);
               nGXsfl_173_idx = (int)(nGXsfl_173_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0F173( ) ;
               VarsToRow173( ((web.SdtEmpresa_promedio_horanormal_mensualizados)bcEmpresa.getgxTv_SdtEmpresa_Promedio_horanormal_mensualizados().elementAt(-1+nGXsfl_173_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0F173( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_173 = (short)(0) ;
      nIsMod_173 = (short)(0) ;
      Gxremove173 = (byte)(0) ;
   }

   public void processNestedLevel0F165( )
   {
      nGXsfl_165_idx = 0 ;
      while ( nGXsfl_165_idx < bcEmpresa.getgxTv_SdtEmpresa_Horasextras_pordia().size() )
      {
         readRow0F165( ) ;
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
            standaloneNotModal0F165( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0F165( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0F165( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0F165( ) ;
               }
            }
         }
         KeyVarsToRow165( ((web.SdtEmpresa_horasextras_pordia)bcEmpresa.getgxTv_SdtEmpresa_Horasextras_pordia().elementAt(-1+nGXsfl_165_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_165_idx = 0 ;
         while ( nGXsfl_165_idx < bcEmpresa.getgxTv_SdtEmpresa_Horasextras_pordia().size() )
         {
            readRow0F165( ) ;
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
               bcEmpresa.getgxTv_SdtEmpresa_Horasextras_pordia().removeElement(nGXsfl_165_idx);
               nGXsfl_165_idx = (int)(nGXsfl_165_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0F165( ) ;
               VarsToRow165( ((web.SdtEmpresa_horasextras_pordia)bcEmpresa.getgxTv_SdtEmpresa_Horasextras_pordia().elementAt(-1+nGXsfl_165_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0F165( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_165 = (short)(0) ;
      nIsMod_165 = (short)(0) ;
      Gxremove165 = (byte)(0) ;
   }

   public void processNestedLevel0F166( )
   {
      nGXsfl_166_idx = 0 ;
      while ( nGXsfl_166_idx < bcEmpresa.getgxTv_SdtEmpresa_Tipo_trabajo().size() )
      {
         readRow0F166( ) ;
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
            standaloneNotModal0F166( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0F166( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0F166( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0F166( ) ;
               }
            }
         }
         KeyVarsToRow166( ((web.SdtEmpresa_tipo_trabajo)bcEmpresa.getgxTv_SdtEmpresa_Tipo_trabajo().elementAt(-1+nGXsfl_166_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_166_idx = 0 ;
         while ( nGXsfl_166_idx < bcEmpresa.getgxTv_SdtEmpresa_Tipo_trabajo().size() )
         {
            readRow0F166( ) ;
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
               bcEmpresa.getgxTv_SdtEmpresa_Tipo_trabajo().removeElement(nGXsfl_166_idx);
               nGXsfl_166_idx = (int)(nGXsfl_166_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0F166( ) ;
               VarsToRow166( ((web.SdtEmpresa_tipo_trabajo)bcEmpresa.getgxTv_SdtEmpresa_Tipo_trabajo().elementAt(-1+nGXsfl_166_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0F166( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_166 = (short)(0) ;
      nIsMod_166 = (short)(0) ;
      Gxremove166 = (byte)(0) ;
   }

   public void processNestedLevel0F144( )
   {
      nGXsfl_144_idx = 0 ;
      while ( nGXsfl_144_idx < bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_convenio().size() )
      {
         readRow0F144( ) ;
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
            standaloneNotModal0F144( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0F144( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0F144( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0F144( ) ;
               }
            }
         }
         KeyVarsToRow144( ((web.SdtEmpresa_nolaborables_convenio)bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_convenio().elementAt(-1+nGXsfl_144_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_144_idx = 0 ;
         while ( nGXsfl_144_idx < bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_convenio().size() )
         {
            readRow0F144( ) ;
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
               bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_convenio().removeElement(nGXsfl_144_idx);
               nGXsfl_144_idx = (int)(nGXsfl_144_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0F144( ) ;
               VarsToRow144( ((web.SdtEmpresa_nolaborables_convenio)bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_convenio().elementAt(-1+nGXsfl_144_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0F144( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_144 = (short)(0) ;
      nIsMod_144 = (short)(0) ;
      Gxremove144 = (byte)(0) ;
   }

   public void processNestedLevel0F145( )
   {
      nGXsfl_145_idx = 0 ;
      while ( nGXsfl_145_idx < bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_origen().size() )
      {
         readRow0F145( ) ;
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
            standaloneNotModal0F145( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0F145( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0F145( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0F145( ) ;
               }
            }
         }
         KeyVarsToRow145( ((web.SdtEmpresa_nolaborables_origen)bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_origen().elementAt(-1+nGXsfl_145_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_145_idx = 0 ;
         while ( nGXsfl_145_idx < bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_origen().size() )
         {
            readRow0F145( ) ;
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
               bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_origen().removeElement(nGXsfl_145_idx);
               nGXsfl_145_idx = (int)(nGXsfl_145_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0F145( ) ;
               VarsToRow145( ((web.SdtEmpresa_nolaborables_origen)bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_origen().elementAt(-1+nGXsfl_145_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0F145( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_145 = (short)(0) ;
      nIsMod_145 = (short)(0) ;
      Gxremove145 = (byte)(0) ;
   }

   public void processNestedLevel0F146( )
   {
      nGXsfl_146_idx = 0 ;
      while ( nGXsfl_146_idx < bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_religion().size() )
      {
         readRow0F146( ) ;
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
            standaloneNotModal0F146( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0F146( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0F146( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0F146( ) ;
               }
            }
         }
         KeyVarsToRow146( ((web.SdtEmpresa_nolaborables_religion)bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_religion().elementAt(-1+nGXsfl_146_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_146_idx = 0 ;
         while ( nGXsfl_146_idx < bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_religion().size() )
         {
            readRow0F146( ) ;
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
               bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_religion().removeElement(nGXsfl_146_idx);
               nGXsfl_146_idx = (int)(nGXsfl_146_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0F146( ) ;
               VarsToRow146( ((web.SdtEmpresa_nolaborables_religion)bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_religion().elementAt(-1+nGXsfl_146_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0F146( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_146 = (short)(0) ;
      nIsMod_146 = (short)(0) ;
      Gxremove146 = (byte)(0) ;
   }

   public void processLevel0F13( )
   {
      /* Save parent mode. */
      sMode13 = Gx_mode ;
      processNestedLevel0F172( ) ;
      processNestedLevel0F171( ) ;
      processNestedLevel0F173( ) ;
      processNestedLevel0F165( ) ;
      processNestedLevel0F166( ) ;
      processNestedLevel0F144( ) ;
      processNestedLevel0F145( ) ;
      processNestedLevel0F146( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode13 ;
      /* ' Update level parameters */
   }

   public void endLevel0F13( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(52);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0F13( ) ;
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

   public void scanKeyStart0F13( )
   {
      /* Scan By routine */
      /* Using cursor BC000F147 */
      pr_default.execute(145, new Object[] {Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod)});
      RcdFound13 = (short)(0) ;
      if ( (pr_default.getStatus(145) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A683ActDescripSinAc = BC000F147_A683ActDescripSinAc[0] ;
         A1EmpCod = BC000F147_A1EmpCod[0] ;
         A2EmpNom = BC000F147_A2EmpNom[0] ;
         A177EmpCUIT = BC000F147_A177EmpCUIT[0] ;
         A125CatIvaCod = BC000F147_A125CatIvaCod[0] ;
         n125CatIvaCod = BC000F147_n125CatIvaCod[0] ;
         A126CatIvaDesc = BC000F147_A126CatIvaDesc[0] ;
         n126CatIvaDesc = BC000F147_n126CatIvaDesc[0] ;
         A178EmpDir = BC000F147_A178EmpDir[0] ;
         A180EmpTel = BC000F147_A180EmpTel[0] ;
         n180EmpTel = BC000F147_n180EmpTel[0] ;
         A176EmpCP = BC000F147_A176EmpCP[0] ;
         n176EmpCP = BC000F147_n176EmpCP[0] ;
         A312PaiNom = BC000F147_A312PaiNom[0] ;
         A322ProvNom = BC000F147_A322ProvNom[0] ;
         A286LocNom = BC000F147_A286LocNom[0] ;
         A108ActDescrip = BC000F147_A108ActDescrip[0] ;
         A518EmpZonDescrip = BC000F147_A518EmpZonDescrip[0] ;
         A532EmpReducc = BC000F147_A532EmpReducc[0] ;
         A530TipEmpleDefIns = BC000F147_A530TipEmpleDefIns[0] ;
         A955EmpLogo = BC000F147_A955EmpLogo[0] ;
         n955EmpLogo = BC000F147_n955EmpLogo[0] ;
         A958EmpFirma = BC000F147_A958EmpFirma[0] ;
         n958EmpFirma = BC000F147_n958EmpFirma[0] ;
         A1140EmpAntiguedad = BC000F147_A1140EmpAntiguedad[0] ;
         A1141EmpPresentismo = BC000F147_A1141EmpPresentismo[0] ;
         A1302EmpMesHsPExt = BC000F147_A1302EmpMesHsPExt[0] ;
         n1302EmpMesHsPExt = BC000F147_n1302EmpMesHsPExt[0] ;
         A1303EmpDiaHsPExt = BC000F147_A1303EmpDiaHsPExt[0] ;
         n1303EmpDiaHsPExt = BC000F147_n1303EmpDiaHsPExt[0] ;
         A1811EmpPerVacDes = BC000F147_A1811EmpPerVacDes[0] ;
         A1812EmpPerVacHas = BC000F147_A1812EmpPerVacHas[0] ;
         A1524EmpLiqFer = BC000F147_A1524EmpLiqFer[0] ;
         A1556EmpGuarEdadMin = BC000F147_A1556EmpGuarEdadMin[0] ;
         A1557EmpGuarEdadMax = BC000F147_A1557EmpGuarEdadMax[0] ;
         A1750EmpLiqFerJor = BC000F147_A1750EmpLiqFerJor[0] ;
         A1787EmpLiqGan = BC000F147_A1787EmpLiqGan[0] ;
         A1792EmpTipoExp = BC000F147_A1792EmpTipoExp[0] ;
         A1802EmpPromDesde = BC000F147_A1802EmpPromDesde[0] ;
         A1813EmpFracVacAnt = BC000F147_A1813EmpFracVacAnt[0] ;
         A1972EmpUltSexoIng = BC000F147_A1972EmpUltSexoIng[0] ;
         n1972EmpUltSexoIng = BC000F147_n1972EmpUltSexoIng[0] ;
         A2405EmpModTra = BC000F147_A2405EmpModTra[0] ;
         A957EmpLogoExt = BC000F147_A957EmpLogoExt[0] ;
         n957EmpLogoExt = BC000F147_n957EmpLogoExt[0] ;
         A955EmpLogo_Filetype = A957EmpLogoExt ;
         A960EmpFirmaExt = BC000F147_A960EmpFirmaExt[0] ;
         n960EmpFirmaExt = BC000F147_n960EmpFirmaExt[0] ;
         A958EmpFirma_Filetype = A960EmpFirmaExt ;
         A956EmpLogoNom = BC000F147_A956EmpLogoNom[0] ;
         n956EmpLogoNom = BC000F147_n956EmpLogoNom[0] ;
         A955EmpLogo_Filename = A956EmpLogoNom ;
         A959EmpFirmaNom = BC000F147_A959EmpFirmaNom[0] ;
         n959EmpFirmaNom = BC000F147_n959EmpFirmaNom[0] ;
         A958EmpFirma_Filename = A959EmpFirmaNom ;
         A46PaiCod = BC000F147_A46PaiCod[0] ;
         n46PaiCod = BC000F147_n46PaiCod[0] ;
         A47ProvCod = BC000F147_A47ProvCod[0] ;
         n47ProvCod = BC000F147_n47ProvCod[0] ;
         A48LocCod = BC000F147_A48LocCod[0] ;
         n48LocCod = BC000F147_n48LocCod[0] ;
         A3CliCod = BC000F147_A3CliCod[0] ;
         A43ActCodigo = BC000F147_A43ActCodigo[0] ;
         n43ActCodigo = BC000F147_n43ActCodigo[0] ;
         A45TipEmpleCod = BC000F147_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC000F147_n45TipEmpleCod[0] ;
         A1151ARTSec = BC000F147_A1151ARTSec[0] ;
         A903ActComCodigo = BC000F147_A903ActComCodigo[0] ;
         A1965EmpOsoCod = BC000F147_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC000F147_n1965EmpOsoCod[0] ;
         A1533EmpActComercial = BC000F147_A1533EmpActComercial[0] ;
         A44EmpZonCod = BC000F147_A44EmpZonCod[0] ;
         n44EmpZonCod = BC000F147_n44EmpZonCod[0] ;
         A2265EmpCondiCod = BC000F147_A2265EmpCondiCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0F13( )
   {
      /* Scan next routine */
      pr_default.readNext(145);
      RcdFound13 = (short)(0) ;
      scanKeyLoad0F13( ) ;
   }

   public void scanKeyLoad0F13( )
   {
      sMode13 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(145) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A683ActDescripSinAc = BC000F147_A683ActDescripSinAc[0] ;
         A1EmpCod = BC000F147_A1EmpCod[0] ;
         A2EmpNom = BC000F147_A2EmpNom[0] ;
         A177EmpCUIT = BC000F147_A177EmpCUIT[0] ;
         A125CatIvaCod = BC000F147_A125CatIvaCod[0] ;
         n125CatIvaCod = BC000F147_n125CatIvaCod[0] ;
         A126CatIvaDesc = BC000F147_A126CatIvaDesc[0] ;
         n126CatIvaDesc = BC000F147_n126CatIvaDesc[0] ;
         A178EmpDir = BC000F147_A178EmpDir[0] ;
         A180EmpTel = BC000F147_A180EmpTel[0] ;
         n180EmpTel = BC000F147_n180EmpTel[0] ;
         A176EmpCP = BC000F147_A176EmpCP[0] ;
         n176EmpCP = BC000F147_n176EmpCP[0] ;
         A312PaiNom = BC000F147_A312PaiNom[0] ;
         A322ProvNom = BC000F147_A322ProvNom[0] ;
         A286LocNom = BC000F147_A286LocNom[0] ;
         A108ActDescrip = BC000F147_A108ActDescrip[0] ;
         A518EmpZonDescrip = BC000F147_A518EmpZonDescrip[0] ;
         A532EmpReducc = BC000F147_A532EmpReducc[0] ;
         A530TipEmpleDefIns = BC000F147_A530TipEmpleDefIns[0] ;
         A955EmpLogo = BC000F147_A955EmpLogo[0] ;
         n955EmpLogo = BC000F147_n955EmpLogo[0] ;
         A958EmpFirma = BC000F147_A958EmpFirma[0] ;
         n958EmpFirma = BC000F147_n958EmpFirma[0] ;
         A1140EmpAntiguedad = BC000F147_A1140EmpAntiguedad[0] ;
         A1141EmpPresentismo = BC000F147_A1141EmpPresentismo[0] ;
         A1302EmpMesHsPExt = BC000F147_A1302EmpMesHsPExt[0] ;
         n1302EmpMesHsPExt = BC000F147_n1302EmpMesHsPExt[0] ;
         A1303EmpDiaHsPExt = BC000F147_A1303EmpDiaHsPExt[0] ;
         n1303EmpDiaHsPExt = BC000F147_n1303EmpDiaHsPExt[0] ;
         A1811EmpPerVacDes = BC000F147_A1811EmpPerVacDes[0] ;
         A1812EmpPerVacHas = BC000F147_A1812EmpPerVacHas[0] ;
         A1524EmpLiqFer = BC000F147_A1524EmpLiqFer[0] ;
         A1556EmpGuarEdadMin = BC000F147_A1556EmpGuarEdadMin[0] ;
         A1557EmpGuarEdadMax = BC000F147_A1557EmpGuarEdadMax[0] ;
         A1750EmpLiqFerJor = BC000F147_A1750EmpLiqFerJor[0] ;
         A1787EmpLiqGan = BC000F147_A1787EmpLiqGan[0] ;
         A1792EmpTipoExp = BC000F147_A1792EmpTipoExp[0] ;
         A1802EmpPromDesde = BC000F147_A1802EmpPromDesde[0] ;
         A1813EmpFracVacAnt = BC000F147_A1813EmpFracVacAnt[0] ;
         A1972EmpUltSexoIng = BC000F147_A1972EmpUltSexoIng[0] ;
         n1972EmpUltSexoIng = BC000F147_n1972EmpUltSexoIng[0] ;
         A2405EmpModTra = BC000F147_A2405EmpModTra[0] ;
         A957EmpLogoExt = BC000F147_A957EmpLogoExt[0] ;
         n957EmpLogoExt = BC000F147_n957EmpLogoExt[0] ;
         A955EmpLogo_Filetype = A957EmpLogoExt ;
         A960EmpFirmaExt = BC000F147_A960EmpFirmaExt[0] ;
         n960EmpFirmaExt = BC000F147_n960EmpFirmaExt[0] ;
         A958EmpFirma_Filetype = A960EmpFirmaExt ;
         A956EmpLogoNom = BC000F147_A956EmpLogoNom[0] ;
         n956EmpLogoNom = BC000F147_n956EmpLogoNom[0] ;
         A955EmpLogo_Filename = A956EmpLogoNom ;
         A959EmpFirmaNom = BC000F147_A959EmpFirmaNom[0] ;
         n959EmpFirmaNom = BC000F147_n959EmpFirmaNom[0] ;
         A958EmpFirma_Filename = A959EmpFirmaNom ;
         A46PaiCod = BC000F147_A46PaiCod[0] ;
         n46PaiCod = BC000F147_n46PaiCod[0] ;
         A47ProvCod = BC000F147_A47ProvCod[0] ;
         n47ProvCod = BC000F147_n47ProvCod[0] ;
         A48LocCod = BC000F147_A48LocCod[0] ;
         n48LocCod = BC000F147_n48LocCod[0] ;
         A3CliCod = BC000F147_A3CliCod[0] ;
         A43ActCodigo = BC000F147_A43ActCodigo[0] ;
         n43ActCodigo = BC000F147_n43ActCodigo[0] ;
         A45TipEmpleCod = BC000F147_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC000F147_n45TipEmpleCod[0] ;
         A1151ARTSec = BC000F147_A1151ARTSec[0] ;
         A903ActComCodigo = BC000F147_A903ActComCodigo[0] ;
         A1965EmpOsoCod = BC000F147_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = BC000F147_n1965EmpOsoCod[0] ;
         A1533EmpActComercial = BC000F147_A1533EmpActComercial[0] ;
         A44EmpZonCod = BC000F147_A44EmpZonCod[0] ;
         n44EmpZonCod = BC000F147_n44EmpZonCod[0] ;
         A2265EmpCondiCod = BC000F147_A2265EmpCondiCod[0] ;
      }
      Gx_mode = sMode13 ;
   }

   public void scanKeyEnd0F13( )
   {
      pr_default.close(145);
   }

   public void afterConfirm0F13( )
   {
      /* After Confirm Rules */
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int9 = A1EmpCod ;
         GXv_int10[0] = GXt_int9 ;
         new web.getnextemp(remoteHandle, context).execute( A3CliCod, GXv_int10) ;
         empresa_bc.this.GXt_int9 = GXv_int10[0] ;
         A1EmpCod = GXt_int9 ;
      }
   }

   public void beforeInsert0F13( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0F13( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0F13( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0F13( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0F13( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0F13( )
   {
   }

   public void zm0F172( int GX_JID )
   {
      if ( ( GX_JID == 34 ) || ( GX_JID == 0 ) )
      {
         Z1369EmpJorHabitual = A1369EmpJorHabitual ;
      }
      if ( ( GX_JID == 35 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -34 )
      {
         Z1369EmpJorHabitual = A1369EmpJorHabitual ;
         Z3CliCod = A3CliCod ;
         Z1366EmpJorConCodigo = A1366EmpJorConCodigo ;
         Z1EmpCod = A1EmpCod ;
      }
   }

   public void standaloneNotModal0F172( )
   {
   }

   public void standaloneModal0F172( )
   {
   }

   public void load0F172( )
   {
      /* Using cursor BC000F148 */
      pr_default.execute(146, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1366EmpJorConCodigo});
      if ( (pr_default.getStatus(146) != 101) )
      {
         RcdFound172 = (short)(1) ;
         A1369EmpJorHabitual = BC000F148_A1369EmpJorHabitual[0] ;
         zm0F172( -34) ;
      }
      pr_default.close(146);
      onLoadActions0F172( ) ;
   }

   public void onLoadActions0F172( )
   {
   }

   public void checkExtendedTable0F172( )
   {
      nIsDirty_172 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0F172( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000F149 */
      pr_default.execute(147, new Object[] {Integer.valueOf(A3CliCod), A1366EmpJorConCodigo});
      if ( (pr_default.getStatus(147) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPJORCONCODIGO");
         AnyError = (short)(1) ;
      }
      pr_default.close(147);
   }

   public void closeExtendedTableCursors0F172( )
   {
      pr_default.close(147);
   }

   public void enableDisable0F172( )
   {
   }

   public void getKey0F172( )
   {
      /* Using cursor BC000F150 */
      pr_default.execute(148, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1366EmpJorConCodigo});
      if ( (pr_default.getStatus(148) != 101) )
      {
         RcdFound172 = (short)(1) ;
      }
      else
      {
         RcdFound172 = (short)(0) ;
      }
      pr_default.close(148);
   }

   public void getByPrimaryKey0F172( )
   {
      /* Using cursor BC000F151 */
      pr_default.execute(149, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1366EmpJorConCodigo});
      if ( (pr_default.getStatus(149) != 101) )
      {
         zm0F172( 34) ;
         RcdFound172 = (short)(1) ;
         initializeNonKey0F172( ) ;
         A1369EmpJorHabitual = BC000F151_A1369EmpJorHabitual[0] ;
         A1366EmpJorConCodigo = BC000F151_A1366EmpJorConCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1366EmpJorConCodigo = A1366EmpJorConCodigo ;
         sMode172 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0F172( ) ;
         Gx_mode = sMode172 ;
      }
      else
      {
         RcdFound172 = (short)(0) ;
         initializeNonKey0F172( ) ;
         sMode172 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0F172( ) ;
         Gx_mode = sMode172 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0F172( ) ;
      }
      pr_default.close(149);
   }

   public void checkOptimisticConcurrency0F172( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000F152 */
         pr_default.execute(150, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1366EmpJorConCodigo});
         if ( (pr_default.getStatus(150) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresaconceptos_horanormal_jornalizados"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(150) == 101) || ( Z1369EmpJorHabitual != BC000F152_A1369EmpJorHabitual[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresaconceptos_horanormal_jornalizados"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0F172( )
   {
      beforeValidate0F172( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F172( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0F172( 0) ;
         checkOptimisticConcurrency0F172( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F172( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0F172( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F153 */
                  pr_default.execute(151, new Object[] {Boolean.valueOf(A1369EmpJorHabitual), Integer.valueOf(A3CliCod), A1366EmpJorConCodigo, Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresaconceptos_horanormal_jornalizados");
                  if ( (pr_default.getStatus(151) == 1) )
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
            load0F172( ) ;
         }
         endLevel0F172( ) ;
      }
      closeExtendedTableCursors0F172( ) ;
   }

   public void update0F172( )
   {
      beforeValidate0F172( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F172( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F172( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F172( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0F172( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F154 */
                  pr_default.execute(152, new Object[] {Boolean.valueOf(A1369EmpJorHabitual), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1366EmpJorConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresaconceptos_horanormal_jornalizados");
                  if ( (pr_default.getStatus(152) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresaconceptos_horanormal_jornalizados"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0F172( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0F172( ) ;
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
         endLevel0F172( ) ;
      }
      closeExtendedTableCursors0F172( ) ;
   }

   public void deferredUpdate0F172( )
   {
   }

   public void delete0F172( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0F172( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F172( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0F172( ) ;
         afterConfirm0F172( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0F172( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000F155 */
               pr_default.execute(153, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1366EmpJorConCodigo});
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
      endLevel0F172( ) ;
      Gx_mode = sMode172 ;
   }

   public void onDeleteControls0F172( )
   {
      standaloneModal0F172( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0F172( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(150);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0F172( )
   {
      /* Scan By routine */
      /* Using cursor BC000F156 */
      pr_default.execute(154, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound172 = (short)(0) ;
      if ( (pr_default.getStatus(154) != 101) )
      {
         RcdFound172 = (short)(1) ;
         A1369EmpJorHabitual = BC000F156_A1369EmpJorHabitual[0] ;
         A1366EmpJorConCodigo = BC000F156_A1366EmpJorConCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0F172( )
   {
      /* Scan next routine */
      pr_default.readNext(154);
      RcdFound172 = (short)(0) ;
      scanKeyLoad0F172( ) ;
   }

   public void scanKeyLoad0F172( )
   {
      sMode172 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(154) != 101) )
      {
         RcdFound172 = (short)(1) ;
         A1369EmpJorHabitual = BC000F156_A1369EmpJorHabitual[0] ;
         A1366EmpJorConCodigo = BC000F156_A1366EmpJorConCodigo[0] ;
      }
      Gx_mode = sMode172 ;
   }

   public void scanKeyEnd0F172( )
   {
      pr_default.close(154);
   }

   public void afterConfirm0F172( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0F172( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0F172( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0F172( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0F172( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0F172( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0F172( )
   {
   }

   public void send_integrity_lvl_hashes0F172( )
   {
   }

   public void zm0F171( int GX_JID )
   {
      if ( ( GX_JID == 36 ) || ( GX_JID == 0 ) )
      {
         Z1370EmpMenHabitual = A1370EmpMenHabitual ;
      }
      if ( ( GX_JID == 37 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -36 )
      {
         Z1370EmpMenHabitual = A1370EmpMenHabitual ;
         Z3CliCod = A3CliCod ;
         Z1368EmpMenConCodigo = A1368EmpMenConCodigo ;
         Z1EmpCod = A1EmpCod ;
      }
   }

   public void standaloneNotModal0F171( )
   {
   }

   public void standaloneModal0F171( )
   {
   }

   public void load0F171( )
   {
      /* Using cursor BC000F157 */
      pr_default.execute(155, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1368EmpMenConCodigo});
      if ( (pr_default.getStatus(155) != 101) )
      {
         RcdFound171 = (short)(1) ;
         A1370EmpMenHabitual = BC000F157_A1370EmpMenHabitual[0] ;
         zm0F171( -36) ;
      }
      pr_default.close(155);
      onLoadActions0F171( ) ;
   }

   public void onLoadActions0F171( )
   {
   }

   public void checkExtendedTable0F171( )
   {
      nIsDirty_171 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0F171( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000F158 */
      pr_default.execute(156, new Object[] {Integer.valueOf(A3CliCod), A1368EmpMenConCodigo});
      if ( (pr_default.getStatus(156) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPMENCONCODIGO");
         AnyError = (short)(1) ;
      }
      pr_default.close(156);
   }

   public void closeExtendedTableCursors0F171( )
   {
      pr_default.close(156);
   }

   public void enableDisable0F171( )
   {
   }

   public void getKey0F171( )
   {
      /* Using cursor BC000F159 */
      pr_default.execute(157, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1368EmpMenConCodigo});
      if ( (pr_default.getStatus(157) != 101) )
      {
         RcdFound171 = (short)(1) ;
      }
      else
      {
         RcdFound171 = (short)(0) ;
      }
      pr_default.close(157);
   }

   public void getByPrimaryKey0F171( )
   {
      /* Using cursor BC000F160 */
      pr_default.execute(158, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1368EmpMenConCodigo});
      if ( (pr_default.getStatus(158) != 101) )
      {
         zm0F171( 36) ;
         RcdFound171 = (short)(1) ;
         initializeNonKey0F171( ) ;
         A1370EmpMenHabitual = BC000F160_A1370EmpMenHabitual[0] ;
         A1368EmpMenConCodigo = BC000F160_A1368EmpMenConCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1368EmpMenConCodigo = A1368EmpMenConCodigo ;
         sMode171 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0F171( ) ;
         Gx_mode = sMode171 ;
      }
      else
      {
         RcdFound171 = (short)(0) ;
         initializeNonKey0F171( ) ;
         sMode171 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0F171( ) ;
         Gx_mode = sMode171 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0F171( ) ;
      }
      pr_default.close(158);
   }

   public void checkOptimisticConcurrency0F171( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000F161 */
         pr_default.execute(159, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1368EmpMenConCodigo});
         if ( (pr_default.getStatus(159) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresaconceptos_horanormal_mensualizado"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(159) == 101) || ( Z1370EmpMenHabitual != BC000F161_A1370EmpMenHabitual[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresaconceptos_horanormal_mensualizado"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0F171( )
   {
      beforeValidate0F171( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F171( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0F171( 0) ;
         checkOptimisticConcurrency0F171( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F171( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0F171( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F162 */
                  pr_default.execute(160, new Object[] {Boolean.valueOf(A1370EmpMenHabitual), Integer.valueOf(A3CliCod), A1368EmpMenConCodigo, Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresaconceptos_horanormal_mensualizado");
                  if ( (pr_default.getStatus(160) == 1) )
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
            load0F171( ) ;
         }
         endLevel0F171( ) ;
      }
      closeExtendedTableCursors0F171( ) ;
   }

   public void update0F171( )
   {
      beforeValidate0F171( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F171( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F171( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F171( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0F171( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F163 */
                  pr_default.execute(161, new Object[] {Boolean.valueOf(A1370EmpMenHabitual), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1368EmpMenConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresaconceptos_horanormal_mensualizado");
                  if ( (pr_default.getStatus(161) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresaconceptos_horanormal_mensualizado"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0F171( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0F171( ) ;
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
         endLevel0F171( ) ;
      }
      closeExtendedTableCursors0F171( ) ;
   }

   public void deferredUpdate0F171( )
   {
   }

   public void delete0F171( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0F171( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F171( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0F171( ) ;
         afterConfirm0F171( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0F171( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000F164 */
               pr_default.execute(162, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1368EmpMenConCodigo});
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
      endLevel0F171( ) ;
      Gx_mode = sMode171 ;
   }

   public void onDeleteControls0F171( )
   {
      standaloneModal0F171( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0F171( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(159);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0F171( )
   {
      /* Scan By routine */
      /* Using cursor BC000F165 */
      pr_default.execute(163, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound171 = (short)(0) ;
      if ( (pr_default.getStatus(163) != 101) )
      {
         RcdFound171 = (short)(1) ;
         A1370EmpMenHabitual = BC000F165_A1370EmpMenHabitual[0] ;
         A1368EmpMenConCodigo = BC000F165_A1368EmpMenConCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0F171( )
   {
      /* Scan next routine */
      pr_default.readNext(163);
      RcdFound171 = (short)(0) ;
      scanKeyLoad0F171( ) ;
   }

   public void scanKeyLoad0F171( )
   {
      sMode171 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(163) != 101) )
      {
         RcdFound171 = (short)(1) ;
         A1370EmpMenHabitual = BC000F165_A1370EmpMenHabitual[0] ;
         A1368EmpMenConCodigo = BC000F165_A1368EmpMenConCodigo[0] ;
      }
      Gx_mode = sMode171 ;
   }

   public void scanKeyEnd0F171( )
   {
      pr_default.close(163);
   }

   public void afterConfirm0F171( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0F171( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0F171( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0F171( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0F171( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0F171( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0F171( )
   {
   }

   public void send_integrity_lvl_hashes0F171( )
   {
   }

   public void zm0F173( int GX_JID )
   {
      if ( ( GX_JID == 38 ) || ( GX_JID == 0 ) )
      {
         Z1372EmpPromHabitual = A1372EmpPromHabitual ;
      }
      if ( ( GX_JID == 39 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -38 )
      {
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1371EmpPromFijVar = A1371EmpPromFijVar ;
         Z1372EmpPromHabitual = A1372EmpPromHabitual ;
         Z37TipoConCod = A37TipoConCod ;
      }
   }

   public void standaloneNotModal0F173( )
   {
   }

   public void standaloneModal0F173( )
   {
   }

   public void load0F173( )
   {
      /* Using cursor BC000F166 */
      pr_default.execute(164, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A37TipoConCod, A1371EmpPromFijVar});
      if ( (pr_default.getStatus(164) != 101) )
      {
         RcdFound173 = (short)(1) ;
         A1372EmpPromHabitual = BC000F166_A1372EmpPromHabitual[0] ;
         zm0F173( -38) ;
      }
      pr_default.close(164);
      onLoadActions0F173( ) ;
   }

   public void onLoadActions0F173( )
   {
   }

   public void checkExtendedTable0F173( )
   {
      nIsDirty_173 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0F173( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000F167 */
      pr_default.execute(165, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(165) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo De Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(165);
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

   public void closeExtendedTableCursors0F173( )
   {
      pr_default.close(165);
   }

   public void enableDisable0F173( )
   {
   }

   public void getKey0F173( )
   {
      /* Using cursor BC000F168 */
      pr_default.execute(166, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A37TipoConCod, A1371EmpPromFijVar});
      if ( (pr_default.getStatus(166) != 101) )
      {
         RcdFound173 = (short)(1) ;
      }
      else
      {
         RcdFound173 = (short)(0) ;
      }
      pr_default.close(166);
   }

   public void getByPrimaryKey0F173( )
   {
      /* Using cursor BC000F169 */
      pr_default.execute(167, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A37TipoConCod, A1371EmpPromFijVar});
      if ( (pr_default.getStatus(167) != 101) )
      {
         zm0F173( 38) ;
         RcdFound173 = (short)(1) ;
         initializeNonKey0F173( ) ;
         A1371EmpPromFijVar = BC000F169_A1371EmpPromFijVar[0] ;
         A1372EmpPromHabitual = BC000F169_A1372EmpPromHabitual[0] ;
         A37TipoConCod = BC000F169_A37TipoConCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z37TipoConCod = A37TipoConCod ;
         Z1371EmpPromFijVar = A1371EmpPromFijVar ;
         sMode173 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0F173( ) ;
         Gx_mode = sMode173 ;
      }
      else
      {
         RcdFound173 = (short)(0) ;
         initializeNonKey0F173( ) ;
         sMode173 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0F173( ) ;
         Gx_mode = sMode173 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0F173( ) ;
      }
      pr_default.close(167);
   }

   public void checkOptimisticConcurrency0F173( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000F170 */
         pr_default.execute(168, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A37TipoConCod, A1371EmpPromFijVar});
         if ( (pr_default.getStatus(168) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresapromedio_horanormal_mensualizados"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(168) == 101) || ( Z1372EmpPromHabitual != BC000F170_A1372EmpPromHabitual[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresapromedio_horanormal_mensualizados"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0F173( )
   {
      beforeValidate0F173( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F173( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0F173( 0) ;
         checkOptimisticConcurrency0F173( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F173( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0F173( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F171 */
                  pr_default.execute(169, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1371EmpPromFijVar, Boolean.valueOf(A1372EmpPromHabitual), A37TipoConCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresapromedio_horanormal_mensualizados");
                  if ( (pr_default.getStatus(169) == 1) )
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
            load0F173( ) ;
         }
         endLevel0F173( ) ;
      }
      closeExtendedTableCursors0F173( ) ;
   }

   public void update0F173( )
   {
      beforeValidate0F173( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F173( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F173( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F173( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0F173( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F172 */
                  pr_default.execute(170, new Object[] {Boolean.valueOf(A1372EmpPromHabitual), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A37TipoConCod, A1371EmpPromFijVar});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresapromedio_horanormal_mensualizados");
                  if ( (pr_default.getStatus(170) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresapromedio_horanormal_mensualizados"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0F173( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0F173( ) ;
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
         endLevel0F173( ) ;
      }
      closeExtendedTableCursors0F173( ) ;
   }

   public void deferredUpdate0F173( )
   {
   }

   public void delete0F173( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0F173( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F173( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0F173( ) ;
         afterConfirm0F173( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0F173( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000F173 */
               pr_default.execute(171, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A37TipoConCod, A1371EmpPromFijVar});
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
      endLevel0F173( ) ;
      Gx_mode = sMode173 ;
   }

   public void onDeleteControls0F173( )
   {
      standaloneModal0F173( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0F173( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(168);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0F173( )
   {
      /* Scan By routine */
      /* Using cursor BC000F174 */
      pr_default.execute(172, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound173 = (short)(0) ;
      if ( (pr_default.getStatus(172) != 101) )
      {
         RcdFound173 = (short)(1) ;
         A1371EmpPromFijVar = BC000F174_A1371EmpPromFijVar[0] ;
         A1372EmpPromHabitual = BC000F174_A1372EmpPromHabitual[0] ;
         A37TipoConCod = BC000F174_A37TipoConCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0F173( )
   {
      /* Scan next routine */
      pr_default.readNext(172);
      RcdFound173 = (short)(0) ;
      scanKeyLoad0F173( ) ;
   }

   public void scanKeyLoad0F173( )
   {
      sMode173 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(172) != 101) )
      {
         RcdFound173 = (short)(1) ;
         A1371EmpPromFijVar = BC000F174_A1371EmpPromFijVar[0] ;
         A1372EmpPromHabitual = BC000F174_A1372EmpPromHabitual[0] ;
         A37TipoConCod = BC000F174_A37TipoConCod[0] ;
      }
      Gx_mode = sMode173 ;
   }

   public void scanKeyEnd0F173( )
   {
      pr_default.close(172);
   }

   public void afterConfirm0F173( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0F173( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0F173( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0F173( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0F173( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0F173( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0F173( )
   {
   }

   public void send_integrity_lvl_hashes0F173( )
   {
   }

   public void zm0F165( int GX_JID )
   {
      if ( ( GX_JID == 40 ) || ( GX_JID == 0 ) )
      {
         Z1341EmpHsPDiaDia = A1341EmpHsPDiaDia ;
         Z1342EmpHsPDiaDesde = A1342EmpHsPDiaDesde ;
         Z1343EmpTarifaPDia = A1343EmpTarifaPDia ;
         Z1351EmpTarfaPDRec = A1351EmpTarfaPDRec ;
         Z1339EmpHsPDiaTipTra = A1339EmpHsPDiaTipTra ;
      }
      if ( ( GX_JID == 41 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -40 )
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

   public void standaloneNotModal0F165( )
   {
   }

   public void standaloneModal0F165( )
   {
   }

   public void load0F165( )
   {
      /* Using cursor BC000F175 */
      pr_default.execute(173, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
      if ( (pr_default.getStatus(173) != 101) )
      {
         RcdFound165 = (short)(1) ;
         A1341EmpHsPDiaDia = BC000F175_A1341EmpHsPDiaDia[0] ;
         A1342EmpHsPDiaDesde = BC000F175_A1342EmpHsPDiaDesde[0] ;
         n1342EmpHsPDiaDesde = BC000F175_n1342EmpHsPDiaDesde[0] ;
         A1343EmpTarifaPDia = BC000F175_A1343EmpTarifaPDia[0] ;
         A1351EmpTarfaPDRec = BC000F175_A1351EmpTarfaPDRec[0] ;
         A1339EmpHsPDiaTipTra = BC000F175_A1339EmpHsPDiaTipTra[0] ;
         zm0F165( -40) ;
      }
      pr_default.close(173);
      onLoadActions0F165( ) ;
   }

   public void onLoadActions0F165( )
   {
   }

   public void checkExtendedTable0F165( )
   {
      nIsDirty_165 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0F165( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000F176 */
      pr_default.execute(174, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1339EmpHsPDiaTipTra});
      if ( (pr_default.getStatus(174) == 103) )
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
      pr_default.close(174);
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

   public void closeExtendedTableCursors0F165( )
   {
      pr_default.close(174);
   }

   public void enableDisable0F165( )
   {
   }

   public void getKey0F165( )
   {
      /* Using cursor BC000F177 */
      pr_default.execute(175, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
      if ( (pr_default.getStatus(175) != 101) )
      {
         RcdFound165 = (short)(1) ;
      }
      else
      {
         RcdFound165 = (short)(0) ;
      }
      pr_default.close(175);
   }

   public void getByPrimaryKey0F165( )
   {
      /* Using cursor BC000F178 */
      pr_default.execute(176, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
      if ( (pr_default.getStatus(176) != 101) )
      {
         zm0F165( 40) ;
         RcdFound165 = (short)(1) ;
         initializeNonKey0F165( ) ;
         A1340EmpHsExSec = BC000F178_A1340EmpHsExSec[0] ;
         A1341EmpHsPDiaDia = BC000F178_A1341EmpHsPDiaDia[0] ;
         A1342EmpHsPDiaDesde = BC000F178_A1342EmpHsPDiaDesde[0] ;
         n1342EmpHsPDiaDesde = BC000F178_n1342EmpHsPDiaDesde[0] ;
         A1343EmpTarifaPDia = BC000F178_A1343EmpTarifaPDia[0] ;
         A1351EmpTarfaPDRec = BC000F178_A1351EmpTarfaPDRec[0] ;
         A1339EmpHsPDiaTipTra = BC000F178_A1339EmpHsPDiaTipTra[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1340EmpHsExSec = A1340EmpHsExSec ;
         sMode165 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0F165( ) ;
         Gx_mode = sMode165 ;
      }
      else
      {
         RcdFound165 = (short)(0) ;
         initializeNonKey0F165( ) ;
         sMode165 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0F165( ) ;
         Gx_mode = sMode165 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0F165( ) ;
      }
      pr_default.close(176);
   }

   public void checkOptimisticConcurrency0F165( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000F179 */
         pr_default.execute(177, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
         if ( (pr_default.getStatus(177) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresahorasextras_pordia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(177) == 101) || ( Z1341EmpHsPDiaDia != BC000F179_A1341EmpHsPDiaDia[0] ) || ( GXutil.strcmp(Z1342EmpHsPDiaDesde, BC000F179_A1342EmpHsPDiaDesde[0]) != 0 ) || ( DecimalUtil.compareTo(Z1343EmpTarifaPDia, BC000F179_A1343EmpTarifaPDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1351EmpTarfaPDRec, BC000F179_A1351EmpTarfaPDRec[0]) != 0 ) || ( GXutil.strcmp(Z1339EmpHsPDiaTipTra, BC000F179_A1339EmpHsPDiaTipTra[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresahorasextras_pordia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0F165( )
   {
      beforeValidate0F165( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F165( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0F165( 0) ;
         checkOptimisticConcurrency0F165( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F165( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0F165( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F180 */
                  pr_default.execute(178, new Object[] {Short.valueOf(A1340EmpHsExSec), Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1339EmpHsPDiaTipTra});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
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
            load0F165( ) ;
         }
         endLevel0F165( ) ;
      }
      closeExtendedTableCursors0F165( ) ;
   }

   public void update0F165( )
   {
      beforeValidate0F165( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F165( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F165( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F165( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0F165( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F181 */
                  pr_default.execute(179, new Object[] {Byte.valueOf(A1341EmpHsPDiaDia), Boolean.valueOf(n1342EmpHsPDiaDesde), A1342EmpHsPDiaDesde, A1343EmpTarifaPDia, A1351EmpTarfaPDRec, A1339EmpHsPDiaTipTra, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresahorasextras_pordia");
                  if ( (pr_default.getStatus(179) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresahorasextras_pordia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0F165( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0F165( ) ;
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
         endLevel0F165( ) ;
      }
      closeExtendedTableCursors0F165( ) ;
   }

   public void deferredUpdate0F165( )
   {
   }

   public void delete0F165( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0F165( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F165( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0F165( ) ;
         afterConfirm0F165( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0F165( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000F182 */
               pr_default.execute(180, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1340EmpHsExSec)});
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
      endLevel0F165( ) ;
      Gx_mode = sMode165 ;
   }

   public void onDeleteControls0F165( )
   {
      standaloneModal0F165( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0F165( )
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

   public void scanKeyStart0F165( )
   {
      /* Scan By routine */
      /* Using cursor BC000F183 */
      pr_default.execute(181, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound165 = (short)(0) ;
      if ( (pr_default.getStatus(181) != 101) )
      {
         RcdFound165 = (short)(1) ;
         A1340EmpHsExSec = BC000F183_A1340EmpHsExSec[0] ;
         A1341EmpHsPDiaDia = BC000F183_A1341EmpHsPDiaDia[0] ;
         A1342EmpHsPDiaDesde = BC000F183_A1342EmpHsPDiaDesde[0] ;
         n1342EmpHsPDiaDesde = BC000F183_n1342EmpHsPDiaDesde[0] ;
         A1343EmpTarifaPDia = BC000F183_A1343EmpTarifaPDia[0] ;
         A1351EmpTarfaPDRec = BC000F183_A1351EmpTarfaPDRec[0] ;
         A1339EmpHsPDiaTipTra = BC000F183_A1339EmpHsPDiaTipTra[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0F165( )
   {
      /* Scan next routine */
      pr_default.readNext(181);
      RcdFound165 = (short)(0) ;
      scanKeyLoad0F165( ) ;
   }

   public void scanKeyLoad0F165( )
   {
      sMode165 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(181) != 101) )
      {
         RcdFound165 = (short)(1) ;
         A1340EmpHsExSec = BC000F183_A1340EmpHsExSec[0] ;
         A1341EmpHsPDiaDia = BC000F183_A1341EmpHsPDiaDia[0] ;
         A1342EmpHsPDiaDesde = BC000F183_A1342EmpHsPDiaDesde[0] ;
         n1342EmpHsPDiaDesde = BC000F183_n1342EmpHsPDiaDesde[0] ;
         A1343EmpTarifaPDia = BC000F183_A1343EmpTarifaPDia[0] ;
         A1351EmpTarfaPDRec = BC000F183_A1351EmpTarfaPDRec[0] ;
         A1339EmpHsPDiaTipTra = BC000F183_A1339EmpHsPDiaTipTra[0] ;
      }
      Gx_mode = sMode165 ;
   }

   public void scanKeyEnd0F165( )
   {
      pr_default.close(181);
   }

   public void afterConfirm0F165( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0F165( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0F165( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0F165( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0F165( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0F165( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0F165( )
   {
   }

   public void send_integrity_lvl_hashes0F165( )
   {
   }

   public void zm0F166( int GX_JID )
   {
      if ( ( GX_JID == 42 ) || ( GX_JID == 0 ) )
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
      if ( ( GX_JID == 43 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -42 )
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

   public void standaloneNotModal0F166( )
   {
   }

   public void standaloneModal0F166( )
   {
   }

   public void load0F166( )
   {
      /* Using cursor BC000F184 */
      pr_default.execute(182, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(182) != 101) )
      {
         RcdFound166 = (short)(1) ;
         A1344EmpHsDia = BC000F184_A1344EmpHsDia[0] ;
         A1345EmpHsSem = BC000F184_A1345EmpHsSem[0] ;
         A1346EmpTarifaXLim = BC000F184_A1346EmpTarifaXLim[0] ;
         A1352EmpTarifaRec = BC000F184_A1352EmpTarifaRec[0] ;
         A1386EmpHsMaxDia = BC000F184_A1386EmpHsMaxDia[0] ;
         A1387EmpHsMaxSem = BC000F184_A1387EmpHsMaxSem[0] ;
         A1388EmpHsMaxMes = BC000F184_A1388EmpHsMaxMes[0] ;
         A1389EmpHsMaxAnu = BC000F184_A1389EmpHsMaxAnu[0] ;
         zm0F166( -42) ;
      }
      pr_default.close(182);
      onLoadActions0F166( ) ;
   }

   public void onLoadActions0F166( )
   {
   }

   public void checkExtendedTable0F166( )
   {
      nIsDirty_166 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0F166( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000F185 */
      pr_default.execute(183, new Object[] {A1294PaiTipoTraId});
      if ( (pr_default.getStatus(183) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Trabajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
      }
      pr_default.close(183);
      if ( ! ( ( GXutil.strcmp(A1294PaiTipoTraId, "diurno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "nocturno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de Trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0F166( )
   {
      pr_default.close(183);
   }

   public void enableDisable0F166( )
   {
   }

   public void getKey0F166( )
   {
      /* Using cursor BC000F186 */
      pr_default.execute(184, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(184) != 101) )
      {
         RcdFound166 = (short)(1) ;
      }
      else
      {
         RcdFound166 = (short)(0) ;
      }
      pr_default.close(184);
   }

   public void getByPrimaryKey0F166( )
   {
      /* Using cursor BC000F187 */
      pr_default.execute(185, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(185) != 101) )
      {
         zm0F166( 42) ;
         RcdFound166 = (short)(1) ;
         initializeNonKey0F166( ) ;
         A1344EmpHsDia = BC000F187_A1344EmpHsDia[0] ;
         A1345EmpHsSem = BC000F187_A1345EmpHsSem[0] ;
         A1346EmpTarifaXLim = BC000F187_A1346EmpTarifaXLim[0] ;
         A1352EmpTarifaRec = BC000F187_A1352EmpTarifaRec[0] ;
         A1386EmpHsMaxDia = BC000F187_A1386EmpHsMaxDia[0] ;
         A1387EmpHsMaxSem = BC000F187_A1387EmpHsMaxSem[0] ;
         A1388EmpHsMaxMes = BC000F187_A1388EmpHsMaxMes[0] ;
         A1389EmpHsMaxAnu = BC000F187_A1389EmpHsMaxAnu[0] ;
         A1294PaiTipoTraId = BC000F187_A1294PaiTipoTraId[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1294PaiTipoTraId = A1294PaiTipoTraId ;
         sMode166 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0F166( ) ;
         Gx_mode = sMode166 ;
      }
      else
      {
         RcdFound166 = (short)(0) ;
         initializeNonKey0F166( ) ;
         sMode166 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0F166( ) ;
         Gx_mode = sMode166 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0F166( ) ;
      }
      pr_default.close(185);
   }

   public void checkOptimisticConcurrency0F166( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000F188 */
         pr_default.execute(186, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(186) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresatipo_trabajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(186) == 101) || ( DecimalUtil.compareTo(Z1344EmpHsDia, BC000F188_A1344EmpHsDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1345EmpHsSem, BC000F188_A1345EmpHsSem[0]) != 0 ) || ( DecimalUtil.compareTo(Z1346EmpTarifaXLim, BC000F188_A1346EmpTarifaXLim[0]) != 0 ) || ( DecimalUtil.compareTo(Z1352EmpTarifaRec, BC000F188_A1352EmpTarifaRec[0]) != 0 ) || ( DecimalUtil.compareTo(Z1386EmpHsMaxDia, BC000F188_A1386EmpHsMaxDia[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1387EmpHsMaxSem, BC000F188_A1387EmpHsMaxSem[0]) != 0 ) || ( DecimalUtil.compareTo(Z1388EmpHsMaxMes, BC000F188_A1388EmpHsMaxMes[0]) != 0 ) || ( DecimalUtil.compareTo(Z1389EmpHsMaxAnu, BC000F188_A1389EmpHsMaxAnu[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresatipo_trabajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0F166( )
   {
      beforeValidate0F166( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F166( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0F166( 0) ;
         checkOptimisticConcurrency0F166( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F166( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0F166( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F189 */
                  pr_default.execute(187, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1344EmpHsDia, A1345EmpHsSem, A1346EmpTarifaXLim, A1352EmpTarifaRec, A1386EmpHsMaxDia, A1387EmpHsMaxSem, A1388EmpHsMaxMes, A1389EmpHsMaxAnu, A1294PaiTipoTraId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresatipo_trabajo");
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
            load0F166( ) ;
         }
         endLevel0F166( ) ;
      }
      closeExtendedTableCursors0F166( ) ;
   }

   public void update0F166( )
   {
      beforeValidate0F166( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F166( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F166( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F166( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0F166( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F190 */
                  pr_default.execute(188, new Object[] {A1344EmpHsDia, A1345EmpHsSem, A1346EmpTarifaXLim, A1352EmpTarifaRec, A1386EmpHsMaxDia, A1387EmpHsMaxSem, A1388EmpHsMaxMes, A1389EmpHsMaxAnu, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresatipo_trabajo");
                  if ( (pr_default.getStatus(188) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresatipo_trabajo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0F166( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0F166( ) ;
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
         endLevel0F166( ) ;
      }
      closeExtendedTableCursors0F166( ) ;
   }

   public void deferredUpdate0F166( )
   {
   }

   public void delete0F166( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0F166( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F166( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0F166( ) ;
         afterConfirm0F166( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0F166( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000F191 */
               pr_default.execute(189, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
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
      endLevel0F166( ) ;
      Gx_mode = sMode166 ;
   }

   public void onDeleteControls0F166( )
   {
      standaloneModal0F166( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor BC000F192 */
         pr_default.execute(190, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(190) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "horasextras_pordia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(190);
      }
   }

   public void endLevel0F166( )
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

   public void scanKeyStart0F166( )
   {
      /* Scan By routine */
      /* Using cursor BC000F193 */
      pr_default.execute(191, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound166 = (short)(0) ;
      if ( (pr_default.getStatus(191) != 101) )
      {
         RcdFound166 = (short)(1) ;
         A1344EmpHsDia = BC000F193_A1344EmpHsDia[0] ;
         A1345EmpHsSem = BC000F193_A1345EmpHsSem[0] ;
         A1346EmpTarifaXLim = BC000F193_A1346EmpTarifaXLim[0] ;
         A1352EmpTarifaRec = BC000F193_A1352EmpTarifaRec[0] ;
         A1386EmpHsMaxDia = BC000F193_A1386EmpHsMaxDia[0] ;
         A1387EmpHsMaxSem = BC000F193_A1387EmpHsMaxSem[0] ;
         A1388EmpHsMaxMes = BC000F193_A1388EmpHsMaxMes[0] ;
         A1389EmpHsMaxAnu = BC000F193_A1389EmpHsMaxAnu[0] ;
         A1294PaiTipoTraId = BC000F193_A1294PaiTipoTraId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0F166( )
   {
      /* Scan next routine */
      pr_default.readNext(191);
      RcdFound166 = (short)(0) ;
      scanKeyLoad0F166( ) ;
   }

   public void scanKeyLoad0F166( )
   {
      sMode166 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(191) != 101) )
      {
         RcdFound166 = (short)(1) ;
         A1344EmpHsDia = BC000F193_A1344EmpHsDia[0] ;
         A1345EmpHsSem = BC000F193_A1345EmpHsSem[0] ;
         A1346EmpTarifaXLim = BC000F193_A1346EmpTarifaXLim[0] ;
         A1352EmpTarifaRec = BC000F193_A1352EmpTarifaRec[0] ;
         A1386EmpHsMaxDia = BC000F193_A1386EmpHsMaxDia[0] ;
         A1387EmpHsMaxSem = BC000F193_A1387EmpHsMaxSem[0] ;
         A1388EmpHsMaxMes = BC000F193_A1388EmpHsMaxMes[0] ;
         A1389EmpHsMaxAnu = BC000F193_A1389EmpHsMaxAnu[0] ;
         A1294PaiTipoTraId = BC000F193_A1294PaiTipoTraId[0] ;
      }
      Gx_mode = sMode166 ;
   }

   public void scanKeyEnd0F166( )
   {
      pr_default.close(191);
   }

   public void afterConfirm0F166( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0F166( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0F166( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0F166( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0F166( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0F166( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0F166( )
   {
   }

   public void send_integrity_lvl_hashes0F166( )
   {
   }

   public void zm0F144( int GX_JID )
   {
      if ( ( GX_JID == 44 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -44 )
      {
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1239EmpConvenio = A1239EmpConvenio ;
      }
   }

   public void standaloneNotModal0F144( )
   {
   }

   public void standaloneModal0F144( )
   {
   }

   public void load0F144( )
   {
      /* Using cursor BC000F194 */
      pr_default.execute(192, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1239EmpConvenio});
      if ( (pr_default.getStatus(192) != 101) )
      {
         RcdFound144 = (short)(1) ;
         zm0F144( -44) ;
      }
      pr_default.close(192);
      onLoadActions0F144( ) ;
   }

   public void onLoadActions0F144( )
   {
   }

   public void checkExtendedTable0F144( )
   {
      nIsDirty_144 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0F144( ) ;
      Gx_BScreen = (byte)(0) ;
   }

   public void closeExtendedTableCursors0F144( )
   {
   }

   public void enableDisable0F144( )
   {
   }

   public void getKey0F144( )
   {
      /* Using cursor BC000F195 */
      pr_default.execute(193, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1239EmpConvenio});
      if ( (pr_default.getStatus(193) != 101) )
      {
         RcdFound144 = (short)(1) ;
      }
      else
      {
         RcdFound144 = (short)(0) ;
      }
      pr_default.close(193);
   }

   public void getByPrimaryKey0F144( )
   {
      /* Using cursor BC000F196 */
      pr_default.execute(194, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1239EmpConvenio});
      if ( (pr_default.getStatus(194) != 101) )
      {
         zm0F144( 44) ;
         RcdFound144 = (short)(1) ;
         initializeNonKey0F144( ) ;
         A1239EmpConvenio = BC000F196_A1239EmpConvenio[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1239EmpConvenio = A1239EmpConvenio ;
         sMode144 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0F144( ) ;
         Gx_mode = sMode144 ;
      }
      else
      {
         RcdFound144 = (short)(0) ;
         initializeNonKey0F144( ) ;
         sMode144 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0F144( ) ;
         Gx_mode = sMode144 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0F144( ) ;
      }
      pr_default.close(194);
   }

   public void checkOptimisticConcurrency0F144( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000F197 */
         pr_default.execute(195, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1239EmpConvenio});
         if ( (pr_default.getStatus(195) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresanolaborables_convenio"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(195) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresanolaborables_convenio"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0F144( )
   {
      beforeValidate0F144( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F144( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0F144( 0) ;
         checkOptimisticConcurrency0F144( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F144( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0F144( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F198 */
                  pr_default.execute(196, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1239EmpConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_convenio");
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
            load0F144( ) ;
         }
         endLevel0F144( ) ;
      }
      closeExtendedTableCursors0F144( ) ;
   }

   public void update0F144( )
   {
      beforeValidate0F144( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F144( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F144( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F144( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0F144( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table Empresanolaborables_convenio */
                  deferredUpdate0F144( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0F144( ) ;
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
         endLevel0F144( ) ;
      }
      closeExtendedTableCursors0F144( ) ;
   }

   public void deferredUpdate0F144( )
   {
   }

   public void delete0F144( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0F144( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F144( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0F144( ) ;
         afterConfirm0F144( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0F144( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000F199 */
               pr_default.execute(197, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1239EmpConvenio});
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
      endLevel0F144( ) ;
      Gx_mode = sMode144 ;
   }

   public void onDeleteControls0F144( )
   {
      standaloneModal0F144( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0F144( )
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

   public void scanKeyStart0F144( )
   {
      /* Scan By routine */
      /* Using cursor BC000F200 */
      pr_default.execute(198, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound144 = (short)(0) ;
      if ( (pr_default.getStatus(198) != 101) )
      {
         RcdFound144 = (short)(1) ;
         A1239EmpConvenio = BC000F200_A1239EmpConvenio[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0F144( )
   {
      /* Scan next routine */
      pr_default.readNext(198);
      RcdFound144 = (short)(0) ;
      scanKeyLoad0F144( ) ;
   }

   public void scanKeyLoad0F144( )
   {
      sMode144 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(198) != 101) )
      {
         RcdFound144 = (short)(1) ;
         A1239EmpConvenio = BC000F200_A1239EmpConvenio[0] ;
      }
      Gx_mode = sMode144 ;
   }

   public void scanKeyEnd0F144( )
   {
      pr_default.close(198);
   }

   public void afterConfirm0F144( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0F144( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0F144( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0F144( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0F144( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0F144( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0F144( )
   {
   }

   public void send_integrity_lvl_hashes0F144( )
   {
   }

   public void zm0F145( int GX_JID )
   {
      if ( ( GX_JID == 45 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 46 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -45 )
      {
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1238EmpOrigen = A1238EmpOrigen ;
      }
   }

   public void standaloneNotModal0F145( )
   {
   }

   public void standaloneModal0F145( )
   {
   }

   public void load0F145( )
   {
      /* Using cursor BC000F201 */
      pr_default.execute(199, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
      if ( (pr_default.getStatus(199) != 101) )
      {
         RcdFound145 = (short)(1) ;
         zm0F145( -45) ;
      }
      pr_default.close(199);
      onLoadActions0F145( ) ;
   }

   public void onLoadActions0F145( )
   {
   }

   public void checkExtendedTable0F145( )
   {
      nIsDirty_145 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0F145( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000F202 */
      pr_default.execute(200, new Object[] {A1238EmpOrigen});
      if ( (pr_default.getStatus(200) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Origen", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPORIGEN");
         AnyError = (short)(1) ;
      }
      pr_default.close(200);
   }

   public void closeExtendedTableCursors0F145( )
   {
      pr_default.close(200);
   }

   public void enableDisable0F145( )
   {
   }

   public void getKey0F145( )
   {
      /* Using cursor BC000F203 */
      pr_default.execute(201, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
      if ( (pr_default.getStatus(201) != 101) )
      {
         RcdFound145 = (short)(1) ;
      }
      else
      {
         RcdFound145 = (short)(0) ;
      }
      pr_default.close(201);
   }

   public void getByPrimaryKey0F145( )
   {
      /* Using cursor BC000F204 */
      pr_default.execute(202, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
      if ( (pr_default.getStatus(202) != 101) )
      {
         zm0F145( 45) ;
         RcdFound145 = (short)(1) ;
         initializeNonKey0F145( ) ;
         A1238EmpOrigen = BC000F204_A1238EmpOrigen[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1238EmpOrigen = A1238EmpOrigen ;
         sMode145 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0F145( ) ;
         Gx_mode = sMode145 ;
      }
      else
      {
         RcdFound145 = (short)(0) ;
         initializeNonKey0F145( ) ;
         sMode145 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0F145( ) ;
         Gx_mode = sMode145 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0F145( ) ;
      }
      pr_default.close(202);
   }

   public void checkOptimisticConcurrency0F145( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000F205 */
         pr_default.execute(203, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
         if ( (pr_default.getStatus(203) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresanolaborables_origen"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(203) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresanolaborables_origen"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0F145( )
   {
      beforeValidate0F145( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F145( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0F145( 0) ;
         checkOptimisticConcurrency0F145( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F145( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0F145( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F206 */
                  pr_default.execute(204, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_origen");
                  if ( (pr_default.getStatus(204) == 1) )
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
            load0F145( ) ;
         }
         endLevel0F145( ) ;
      }
      closeExtendedTableCursors0F145( ) ;
   }

   public void update0F145( )
   {
      beforeValidate0F145( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F145( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F145( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F145( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0F145( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table Empresanolaborables_origen */
                  deferredUpdate0F145( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0F145( ) ;
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
         endLevel0F145( ) ;
      }
      closeExtendedTableCursors0F145( ) ;
   }

   public void deferredUpdate0F145( )
   {
   }

   public void delete0F145( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0F145( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F145( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0F145( ) ;
         afterConfirm0F145( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0F145( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000F207 */
               pr_default.execute(205, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
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
      endLevel0F145( ) ;
      Gx_mode = sMode145 ;
   }

   public void onDeleteControls0F145( )
   {
      standaloneModal0F145( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0F145( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(203);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0F145( )
   {
      /* Scan By routine */
      /* Using cursor BC000F208 */
      pr_default.execute(206, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound145 = (short)(0) ;
      if ( (pr_default.getStatus(206) != 101) )
      {
         RcdFound145 = (short)(1) ;
         A1238EmpOrigen = BC000F208_A1238EmpOrigen[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0F145( )
   {
      /* Scan next routine */
      pr_default.readNext(206);
      RcdFound145 = (short)(0) ;
      scanKeyLoad0F145( ) ;
   }

   public void scanKeyLoad0F145( )
   {
      sMode145 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(206) != 101) )
      {
         RcdFound145 = (short)(1) ;
         A1238EmpOrigen = BC000F208_A1238EmpOrigen[0] ;
      }
      Gx_mode = sMode145 ;
   }

   public void scanKeyEnd0F145( )
   {
      pr_default.close(206);
   }

   public void afterConfirm0F145( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0F145( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0F145( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0F145( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0F145( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0F145( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0F145( )
   {
   }

   public void send_integrity_lvl_hashes0F145( )
   {
   }

   public void zm0F146( int GX_JID )
   {
      if ( ( GX_JID == 47 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 48 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -47 )
      {
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1237EmpReligion = A1237EmpReligion ;
      }
   }

   public void standaloneNotModal0F146( )
   {
   }

   public void standaloneModal0F146( )
   {
   }

   public void load0F146( )
   {
      /* Using cursor BC000F209 */
      pr_default.execute(207, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
      if ( (pr_default.getStatus(207) != 101) )
      {
         RcdFound146 = (short)(1) ;
         zm0F146( -47) ;
      }
      pr_default.close(207);
      onLoadActions0F146( ) ;
   }

   public void onLoadActions0F146( )
   {
   }

   public void checkExtendedTable0F146( )
   {
      nIsDirty_146 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0F146( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000F210 */
      pr_default.execute(208, new Object[] {A1237EmpReligion});
      if ( (pr_default.getStatus(208) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Religion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPRELIGION");
         AnyError = (short)(1) ;
      }
      pr_default.close(208);
   }

   public void closeExtendedTableCursors0F146( )
   {
      pr_default.close(208);
   }

   public void enableDisable0F146( )
   {
   }

   public void getKey0F146( )
   {
      /* Using cursor BC000F211 */
      pr_default.execute(209, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
      if ( (pr_default.getStatus(209) != 101) )
      {
         RcdFound146 = (short)(1) ;
      }
      else
      {
         RcdFound146 = (short)(0) ;
      }
      pr_default.close(209);
   }

   public void getByPrimaryKey0F146( )
   {
      /* Using cursor BC000F212 */
      pr_default.execute(210, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
      if ( (pr_default.getStatus(210) != 101) )
      {
         zm0F146( 47) ;
         RcdFound146 = (short)(1) ;
         initializeNonKey0F146( ) ;
         A1237EmpReligion = BC000F212_A1237EmpReligion[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1237EmpReligion = A1237EmpReligion ;
         sMode146 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0F146( ) ;
         Gx_mode = sMode146 ;
      }
      else
      {
         RcdFound146 = (short)(0) ;
         initializeNonKey0F146( ) ;
         sMode146 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0F146( ) ;
         Gx_mode = sMode146 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0F146( ) ;
      }
      pr_default.close(210);
   }

   public void checkOptimisticConcurrency0F146( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000F213 */
         pr_default.execute(211, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
         if ( (pr_default.getStatus(211) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresanolaborables_religion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(211) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresanolaborables_religion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0F146( )
   {
      beforeValidate0F146( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F146( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0F146( 0) ;
         checkOptimisticConcurrency0F146( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F146( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0F146( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F214 */
                  pr_default.execute(212, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_religion");
                  if ( (pr_default.getStatus(212) == 1) )
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
            load0F146( ) ;
         }
         endLevel0F146( ) ;
      }
      closeExtendedTableCursors0F146( ) ;
   }

   public void update0F146( )
   {
      beforeValidate0F146( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F146( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F146( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F146( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0F146( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table Empresanolaborables_religion */
                  deferredUpdate0F146( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0F146( ) ;
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
         endLevel0F146( ) ;
      }
      closeExtendedTableCursors0F146( ) ;
   }

   public void deferredUpdate0F146( )
   {
   }

   public void delete0F146( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0F146( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F146( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0F146( ) ;
         afterConfirm0F146( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0F146( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000F215 */
               pr_default.execute(213, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
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
      endLevel0F146( ) ;
      Gx_mode = sMode146 ;
   }

   public void onDeleteControls0F146( )
   {
      standaloneModal0F146( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0F146( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(211);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0F146( )
   {
      /* Scan By routine */
      /* Using cursor BC000F216 */
      pr_default.execute(214, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      RcdFound146 = (short)(0) ;
      if ( (pr_default.getStatus(214) != 101) )
      {
         RcdFound146 = (short)(1) ;
         A1237EmpReligion = BC000F216_A1237EmpReligion[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0F146( )
   {
      /* Scan next routine */
      pr_default.readNext(214);
      RcdFound146 = (short)(0) ;
      scanKeyLoad0F146( ) ;
   }

   public void scanKeyLoad0F146( )
   {
      sMode146 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(214) != 101) )
      {
         RcdFound146 = (short)(1) ;
         A1237EmpReligion = BC000F216_A1237EmpReligion[0] ;
      }
      Gx_mode = sMode146 ;
   }

   public void scanKeyEnd0F146( )
   {
      pr_default.close(214);
   }

   public void afterConfirm0F146( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0F146( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0F146( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0F146( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0F146( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0F146( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0F146( )
   {
   }

   public void send_integrity_lvl_hashes0F146( )
   {
   }

   public void send_integrity_lvl_hashes0F13( )
   {
   }

   public void addRow0F13( )
   {
      VarsToRow13( bcEmpresa) ;
   }

   public void readRow0F13( )
   {
      RowToVars13( bcEmpresa, 1) ;
   }

   public void addRow0F172( )
   {
      web.SdtEmpresa_conceptos_horanormal_jornalizados obj172;
      obj172 = new web.SdtEmpresa_conceptos_horanormal_jornalizados(remoteHandle);
      VarsToRow172( obj172) ;
      bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_jornalizados().add(obj172, 0);
      obj172.setgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Mode( "UPD" );
      obj172.setgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Modified( (short)(0) );
   }

   public void readRow0F172( )
   {
      nGXsfl_172_idx = (int)(nGXsfl_172_idx+1) ;
      RowToVars172( ((web.SdtEmpresa_conceptos_horanormal_jornalizados)bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_jornalizados().elementAt(-1+nGXsfl_172_idx)), 1) ;
   }

   public void addRow0F171( )
   {
      web.SdtEmpresa_conceptos_horanormal_mensualizados obj171;
      obj171 = new web.SdtEmpresa_conceptos_horanormal_mensualizados(remoteHandle);
      VarsToRow171( obj171) ;
      bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_mensualizados().add(obj171, 0);
      obj171.setgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Mode( "UPD" );
      obj171.setgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Modified( (short)(0) );
   }

   public void readRow0F171( )
   {
      nGXsfl_171_idx = (int)(nGXsfl_171_idx+1) ;
      RowToVars171( ((web.SdtEmpresa_conceptos_horanormal_mensualizados)bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_mensualizados().elementAt(-1+nGXsfl_171_idx)), 1) ;
   }

   public void addRow0F173( )
   {
      web.SdtEmpresa_promedio_horanormal_mensualizados obj173;
      obj173 = new web.SdtEmpresa_promedio_horanormal_mensualizados(remoteHandle);
      VarsToRow173( obj173) ;
      bcEmpresa.getgxTv_SdtEmpresa_Promedio_horanormal_mensualizados().add(obj173, 0);
      obj173.setgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Mode( "UPD" );
      obj173.setgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Modified( (short)(0) );
   }

   public void readRow0F173( )
   {
      nGXsfl_173_idx = (int)(nGXsfl_173_idx+1) ;
      RowToVars173( ((web.SdtEmpresa_promedio_horanormal_mensualizados)bcEmpresa.getgxTv_SdtEmpresa_Promedio_horanormal_mensualizados().elementAt(-1+nGXsfl_173_idx)), 1) ;
   }

   public void addRow0F165( )
   {
      web.SdtEmpresa_horasextras_pordia obj165;
      obj165 = new web.SdtEmpresa_horasextras_pordia(remoteHandle);
      VarsToRow165( obj165) ;
      bcEmpresa.getgxTv_SdtEmpresa_Horasextras_pordia().add(obj165, 0);
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Mode( "UPD" );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Modified( (short)(0) );
   }

   public void readRow0F165( )
   {
      nGXsfl_165_idx = (int)(nGXsfl_165_idx+1) ;
      RowToVars165( ((web.SdtEmpresa_horasextras_pordia)bcEmpresa.getgxTv_SdtEmpresa_Horasextras_pordia().elementAt(-1+nGXsfl_165_idx)), 1) ;
   }

   public void addRow0F166( )
   {
      web.SdtEmpresa_tipo_trabajo obj166;
      obj166 = new web.SdtEmpresa_tipo_trabajo(remoteHandle);
      VarsToRow166( obj166) ;
      bcEmpresa.getgxTv_SdtEmpresa_Tipo_trabajo().add(obj166, 0);
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Mode( "UPD" );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Modified( (short)(0) );
   }

   public void readRow0F166( )
   {
      nGXsfl_166_idx = (int)(nGXsfl_166_idx+1) ;
      RowToVars166( ((web.SdtEmpresa_tipo_trabajo)bcEmpresa.getgxTv_SdtEmpresa_Tipo_trabajo().elementAt(-1+nGXsfl_166_idx)), 1) ;
   }

   public void addRow0F144( )
   {
      web.SdtEmpresa_nolaborables_convenio obj144;
      obj144 = new web.SdtEmpresa_nolaborables_convenio(remoteHandle);
      VarsToRow144( obj144) ;
      bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_convenio().add(obj144, 0);
      obj144.setgxTv_SdtEmpresa_nolaborables_convenio_Mode( "UPD" );
      obj144.setgxTv_SdtEmpresa_nolaborables_convenio_Modified( (short)(0) );
   }

   public void readRow0F144( )
   {
      nGXsfl_144_idx = (int)(nGXsfl_144_idx+1) ;
      RowToVars144( ((web.SdtEmpresa_nolaborables_convenio)bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_convenio().elementAt(-1+nGXsfl_144_idx)), 1) ;
   }

   public void addRow0F145( )
   {
      web.SdtEmpresa_nolaborables_origen obj145;
      obj145 = new web.SdtEmpresa_nolaborables_origen(remoteHandle);
      VarsToRow145( obj145) ;
      bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_origen().add(obj145, 0);
      obj145.setgxTv_SdtEmpresa_nolaborables_origen_Mode( "UPD" );
      obj145.setgxTv_SdtEmpresa_nolaborables_origen_Modified( (short)(0) );
   }

   public void readRow0F145( )
   {
      nGXsfl_145_idx = (int)(nGXsfl_145_idx+1) ;
      RowToVars145( ((web.SdtEmpresa_nolaborables_origen)bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_origen().elementAt(-1+nGXsfl_145_idx)), 1) ;
   }

   public void addRow0F146( )
   {
      web.SdtEmpresa_nolaborables_religion obj146;
      obj146 = new web.SdtEmpresa_nolaborables_religion(remoteHandle);
      VarsToRow146( obj146) ;
      bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_religion().add(obj146, 0);
      obj146.setgxTv_SdtEmpresa_nolaborables_religion_Mode( "UPD" );
      obj146.setgxTv_SdtEmpresa_nolaborables_religion_Modified( (short)(0) );
   }

   public void readRow0F146( )
   {
      nGXsfl_146_idx = (int)(nGXsfl_146_idx+1) ;
      RowToVars146( ((web.SdtEmpresa_nolaborables_religion)bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_religion().elementAt(-1+nGXsfl_146_idx)), 1) ;
   }

   public void initializeNonKey0F13( )
   {
      A683ActDescripSinAc = "" ;
      A2EmpNom = "" ;
      A177EmpCUIT = 0 ;
      A125CatIvaCod = (short)(0) ;
      n125CatIvaCod = false ;
      A126CatIvaDesc = "" ;
      n126CatIvaDesc = false ;
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
      A48LocCod = (short)(0) ;
      n48LocCod = false ;
      A286LocNom = "" ;
      A43ActCodigo = "" ;
      n43ActCodigo = false ;
      A108ActDescrip = "" ;
      A45TipEmpleCod = "" ;
      n45TipEmpleCod = false ;
      A44EmpZonCod = "" ;
      n44EmpZonCod = false ;
      A518EmpZonDescrip = "" ;
      A532EmpReducc = false ;
      A1533EmpActComercial = "" ;
      A530TipEmpleDefIns = "" ;
      A955EmpLogo = "" ;
      n955EmpLogo = false ;
      A958EmpFirma = "" ;
      n958EmpFirma = false ;
      A1140EmpAntiguedad = DecimalUtil.ZERO ;
      A1141EmpPresentismo = DecimalUtil.ZERO ;
      A1302EmpMesHsPExt = DecimalUtil.ZERO ;
      n1302EmpMesHsPExt = false ;
      A1303EmpDiaHsPExt = "" ;
      n1303EmpDiaHsPExt = false ;
      A1151ARTSec = (short)(0) ;
      A1811EmpPerVacDes = (byte)(0) ;
      A1812EmpPerVacHas = (byte)(0) ;
      A1524EmpLiqFer = false ;
      A1556EmpGuarEdadMin = (byte)(0) ;
      A1557EmpGuarEdadMax = (byte)(0) ;
      A903ActComCodigo = "" ;
      A1750EmpLiqFerJor = false ;
      A1787EmpLiqGan = false ;
      A1792EmpTipoExp = (byte)(0) ;
      A1802EmpPromDesde = "" ;
      A1813EmpFracVacAnt = DecimalUtil.ZERO ;
      A1965EmpOsoCod = "" ;
      n1965EmpOsoCod = false ;
      A1972EmpUltSexoIng = (byte)(0) ;
      n1972EmpUltSexoIng = false ;
      A2265EmpCondiCod = (short)(0) ;
      A2405EmpModTra = "" ;
      A957EmpLogoExt = "" ;
      n957EmpLogoExt = false ;
      A960EmpFirmaExt = "" ;
      n960EmpFirmaExt = false ;
      A956EmpLogoNom = "" ;
      n956EmpLogoNom = false ;
      A959EmpFirmaNom = "" ;
      n959EmpFirmaNom = false ;
      O955EmpLogo = A955EmpLogo ;
      n955EmpLogo = false ;
      Z2EmpNom = "" ;
      Z177EmpCUIT = 0 ;
      Z125CatIvaCod = (short)(0) ;
      Z126CatIvaDesc = "" ;
      Z178EmpDir = "" ;
      Z180EmpTel = "" ;
      Z176EmpCP = "" ;
      Z532EmpReducc = false ;
      Z1140EmpAntiguedad = DecimalUtil.ZERO ;
      Z1141EmpPresentismo = DecimalUtil.ZERO ;
      Z1302EmpMesHsPExt = DecimalUtil.ZERO ;
      Z1303EmpDiaHsPExt = "" ;
      Z1811EmpPerVacDes = (byte)(0) ;
      Z1812EmpPerVacHas = (byte)(0) ;
      Z1524EmpLiqFer = false ;
      Z1556EmpGuarEdadMin = (byte)(0) ;
      Z1557EmpGuarEdadMax = (byte)(0) ;
      Z1750EmpLiqFerJor = false ;
      Z1787EmpLiqGan = false ;
      Z1792EmpTipoExp = (byte)(0) ;
      Z1802EmpPromDesde = "" ;
      Z1813EmpFracVacAnt = DecimalUtil.ZERO ;
      Z1972EmpUltSexoIng = (byte)(0) ;
      Z2405EmpModTra = "" ;
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

   public void initAll0F13( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      initializeNonKey0F13( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0F172( )
   {
      A26ConCodigo = "" ;
      A1369EmpJorHabitual = false ;
      Z1369EmpJorHabitual = false ;
   }

   public void initAll0F172( )
   {
      A1366EmpJorConCodigo = "" ;
      initializeNonKey0F172( ) ;
   }

   public void standaloneModalInsert0F172( )
   {
   }

   public void initializeNonKey0F171( )
   {
      A26ConCodigo = "" ;
      A1370EmpMenHabitual = false ;
      Z1370EmpMenHabitual = false ;
   }

   public void initAll0F171( )
   {
      A1368EmpMenConCodigo = "" ;
      initializeNonKey0F171( ) ;
   }

   public void standaloneModalInsert0F171( )
   {
   }

   public void initializeNonKey0F173( )
   {
      A1372EmpPromHabitual = false ;
      Z1372EmpPromHabitual = false ;
   }

   public void initAll0F173( )
   {
      A37TipoConCod = "" ;
      A1371EmpPromFijVar = "" ;
      initializeNonKey0F173( ) ;
   }

   public void standaloneModalInsert0F173( )
   {
   }

   public void initializeNonKey0F165( )
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

   public void initAll0F165( )
   {
      A1340EmpHsExSec = (short)(0) ;
      initializeNonKey0F165( ) ;
   }

   public void standaloneModalInsert0F165( )
   {
   }

   public void initializeNonKey0F166( )
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

   public void initAll0F166( )
   {
      A1294PaiTipoTraId = "" ;
      initializeNonKey0F166( ) ;
   }

   public void standaloneModalInsert0F166( )
   {
   }

   public void initializeNonKey0F144( )
   {
   }

   public void initAll0F144( )
   {
      A1239EmpConvenio = "" ;
      initializeNonKey0F144( ) ;
   }

   public void standaloneModalInsert0F144( )
   {
   }

   public void initializeNonKey0F145( )
   {
      A1231OrigId = "" ;
   }

   public void initAll0F145( )
   {
      A1238EmpOrigen = "" ;
      initializeNonKey0F145( ) ;
   }

   public void standaloneModalInsert0F145( )
   {
   }

   public void initializeNonKey0F146( )
   {
      A1229ReligId = "" ;
   }

   public void initAll0F146( )
   {
      A1237EmpReligion = "" ;
      initializeNonKey0F146( ) ;
   }

   public void standaloneModalInsert0F146( )
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

   public void VarsToRow13( web.SdtEmpresa obj13 )
   {
      obj13.setgxTv_SdtEmpresa_Mode( Gx_mode );
      obj13.setgxTv_SdtEmpresa_Empnom( A2EmpNom );
      obj13.setgxTv_SdtEmpresa_Empcuit( A177EmpCUIT );
      obj13.setgxTv_SdtEmpresa_Cativacod( A125CatIvaCod );
      obj13.setgxTv_SdtEmpresa_Cativadesc( A126CatIvaDesc );
      obj13.setgxTv_SdtEmpresa_Empdir( A178EmpDir );
      obj13.setgxTv_SdtEmpresa_Emptel( A180EmpTel );
      obj13.setgxTv_SdtEmpresa_Empcp( A176EmpCP );
      obj13.setgxTv_SdtEmpresa_Paicod( A46PaiCod );
      obj13.setgxTv_SdtEmpresa_Painom( A312PaiNom );
      obj13.setgxTv_SdtEmpresa_Provcod( A47ProvCod );
      obj13.setgxTv_SdtEmpresa_Provnom( A322ProvNom );
      obj13.setgxTv_SdtEmpresa_Loccod( A48LocCod );
      obj13.setgxTv_SdtEmpresa_Locnom( A286LocNom );
      obj13.setgxTv_SdtEmpresa_Actcodigo( A43ActCodigo );
      obj13.setgxTv_SdtEmpresa_Actdescrip( A108ActDescrip );
      obj13.setgxTv_SdtEmpresa_Tipemplecod( A45TipEmpleCod );
      obj13.setgxTv_SdtEmpresa_Empzoncod( A44EmpZonCod );
      obj13.setgxTv_SdtEmpresa_Empzondescrip( A518EmpZonDescrip );
      obj13.setgxTv_SdtEmpresa_Empreducc( A532EmpReducc );
      obj13.setgxTv_SdtEmpresa_Empactcomercial( A1533EmpActComercial );
      obj13.setgxTv_SdtEmpresa_Tipempledefins( A530TipEmpleDefIns );
      obj13.setgxTv_SdtEmpresa_Emplogo( A955EmpLogo );
      obj13.setgxTv_SdtEmpresa_Empfirma( A958EmpFirma );
      obj13.setgxTv_SdtEmpresa_Empantiguedad( A1140EmpAntiguedad );
      obj13.setgxTv_SdtEmpresa_Emppresentismo( A1141EmpPresentismo );
      obj13.setgxTv_SdtEmpresa_Empmeshspext( A1302EmpMesHsPExt );
      obj13.setgxTv_SdtEmpresa_Empdiahspext( A1303EmpDiaHsPExt );
      obj13.setgxTv_SdtEmpresa_Artsec( A1151ARTSec );
      obj13.setgxTv_SdtEmpresa_Emppervacdes( A1811EmpPerVacDes );
      obj13.setgxTv_SdtEmpresa_Emppervachas( A1812EmpPerVacHas );
      obj13.setgxTv_SdtEmpresa_Empliqfer( A1524EmpLiqFer );
      obj13.setgxTv_SdtEmpresa_Empguaredadmin( A1556EmpGuarEdadMin );
      obj13.setgxTv_SdtEmpresa_Empguaredadmax( A1557EmpGuarEdadMax );
      obj13.setgxTv_SdtEmpresa_Actcomcodigo( A903ActComCodigo );
      obj13.setgxTv_SdtEmpresa_Empliqferjor( A1750EmpLiqFerJor );
      obj13.setgxTv_SdtEmpresa_Empliqgan( A1787EmpLiqGan );
      obj13.setgxTv_SdtEmpresa_Emptipoexp( A1792EmpTipoExp );
      obj13.setgxTv_SdtEmpresa_Emppromdesde( A1802EmpPromDesde );
      obj13.setgxTv_SdtEmpresa_Empfracvacant( A1813EmpFracVacAnt );
      obj13.setgxTv_SdtEmpresa_Emposocod( A1965EmpOsoCod );
      obj13.setgxTv_SdtEmpresa_Empultsexoing( A1972EmpUltSexoIng );
      obj13.setgxTv_SdtEmpresa_Empcondicod( A2265EmpCondiCod );
      obj13.setgxTv_SdtEmpresa_Empmodtra( A2405EmpModTra );
      obj13.setgxTv_SdtEmpresa_Emplogoext( A957EmpLogoExt );
      obj13.setgxTv_SdtEmpresa_Empfirmaext( A960EmpFirmaExt );
      obj13.setgxTv_SdtEmpresa_Emplogonom( A956EmpLogoNom );
      obj13.setgxTv_SdtEmpresa_Empfirmanom( A959EmpFirmaNom );
      obj13.setgxTv_SdtEmpresa_Clicod( A3CliCod );
      obj13.setgxTv_SdtEmpresa_Empcod( A1EmpCod );
      obj13.setgxTv_SdtEmpresa_Clicod_Z( Z3CliCod );
      obj13.setgxTv_SdtEmpresa_Empcod_Z( Z1EmpCod );
      obj13.setgxTv_SdtEmpresa_Empnom_Z( Z2EmpNom );
      obj13.setgxTv_SdtEmpresa_Empcuit_Z( Z177EmpCUIT );
      obj13.setgxTv_SdtEmpresa_Cativacod_Z( Z125CatIvaCod );
      obj13.setgxTv_SdtEmpresa_Cativadesc_Z( Z126CatIvaDesc );
      obj13.setgxTv_SdtEmpresa_Empdir_Z( Z178EmpDir );
      obj13.setgxTv_SdtEmpresa_Emptel_Z( Z180EmpTel );
      obj13.setgxTv_SdtEmpresa_Empcp_Z( Z176EmpCP );
      obj13.setgxTv_SdtEmpresa_Paicod_Z( Z46PaiCod );
      obj13.setgxTv_SdtEmpresa_Painom_Z( Z312PaiNom );
      obj13.setgxTv_SdtEmpresa_Provcod_Z( Z47ProvCod );
      obj13.setgxTv_SdtEmpresa_Provnom_Z( Z322ProvNom );
      obj13.setgxTv_SdtEmpresa_Loccod_Z( Z48LocCod );
      obj13.setgxTv_SdtEmpresa_Locnom_Z( Z286LocNom );
      obj13.setgxTv_SdtEmpresa_Actcodigo_Z( Z43ActCodigo );
      obj13.setgxTv_SdtEmpresa_Actdescrip_Z( Z108ActDescrip );
      obj13.setgxTv_SdtEmpresa_Tipemplecod_Z( Z45TipEmpleCod );
      obj13.setgxTv_SdtEmpresa_Empzoncod_Z( Z44EmpZonCod );
      obj13.setgxTv_SdtEmpresa_Empzondescrip_Z( Z518EmpZonDescrip );
      obj13.setgxTv_SdtEmpresa_Empreducc_Z( Z532EmpReducc );
      obj13.setgxTv_SdtEmpresa_Empactcomercial_Z( Z1533EmpActComercial );
      obj13.setgxTv_SdtEmpresa_Tipempledefins_Z( Z530TipEmpleDefIns );
      obj13.setgxTv_SdtEmpresa_Emplogonom_Z( Z956EmpLogoNom );
      obj13.setgxTv_SdtEmpresa_Emplogoext_Z( Z957EmpLogoExt );
      obj13.setgxTv_SdtEmpresa_Empfirmanom_Z( Z959EmpFirmaNom );
      obj13.setgxTv_SdtEmpresa_Empfirmaext_Z( Z960EmpFirmaExt );
      obj13.setgxTv_SdtEmpresa_Empantiguedad_Z( Z1140EmpAntiguedad );
      obj13.setgxTv_SdtEmpresa_Emppresentismo_Z( Z1141EmpPresentismo );
      obj13.setgxTv_SdtEmpresa_Empmeshspext_Z( Z1302EmpMesHsPExt );
      obj13.setgxTv_SdtEmpresa_Empdiahspext_Z( Z1303EmpDiaHsPExt );
      obj13.setgxTv_SdtEmpresa_Artsec_Z( Z1151ARTSec );
      obj13.setgxTv_SdtEmpresa_Emppervacdes_Z( Z1811EmpPerVacDes );
      obj13.setgxTv_SdtEmpresa_Emppervachas_Z( Z1812EmpPerVacHas );
      obj13.setgxTv_SdtEmpresa_Empliqfer_Z( Z1524EmpLiqFer );
      obj13.setgxTv_SdtEmpresa_Empguaredadmin_Z( Z1556EmpGuarEdadMin );
      obj13.setgxTv_SdtEmpresa_Empguaredadmax_Z( Z1557EmpGuarEdadMax );
      obj13.setgxTv_SdtEmpresa_Actcomcodigo_Z( Z903ActComCodigo );
      obj13.setgxTv_SdtEmpresa_Empliqferjor_Z( Z1750EmpLiqFerJor );
      obj13.setgxTv_SdtEmpresa_Empliqgan_Z( Z1787EmpLiqGan );
      obj13.setgxTv_SdtEmpresa_Emptipoexp_Z( Z1792EmpTipoExp );
      obj13.setgxTv_SdtEmpresa_Emppromdesde_Z( Z1802EmpPromDesde );
      obj13.setgxTv_SdtEmpresa_Empfracvacant_Z( Z1813EmpFracVacAnt );
      obj13.setgxTv_SdtEmpresa_Emposocod_Z( Z1965EmpOsoCod );
      obj13.setgxTv_SdtEmpresa_Empultsexoing_Z( Z1972EmpUltSexoIng );
      obj13.setgxTv_SdtEmpresa_Empcondicod_Z( Z2265EmpCondiCod );
      obj13.setgxTv_SdtEmpresa_Empmodtra_Z( Z2405EmpModTra );
      obj13.setgxTv_SdtEmpresa_Cativacod_N( (byte)((byte)((n125CatIvaCod)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Cativadesc_N( (byte)((byte)((n126CatIvaDesc)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Emptel_N( (byte)((byte)((n180EmpTel)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Empcp_N( (byte)((byte)((n176EmpCP)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Paicod_N( (byte)((byte)((n46PaiCod)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Provcod_N( (byte)((byte)((n47ProvCod)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Loccod_N( (byte)((byte)((n48LocCod)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Actcodigo_N( (byte)((byte)((n43ActCodigo)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Tipemplecod_N( (byte)((byte)((n45TipEmpleCod)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Empzoncod_N( (byte)((byte)((n44EmpZonCod)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Emplogo_N( (byte)((byte)((n955EmpLogo)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Emplogonom_N( (byte)((byte)((n956EmpLogoNom)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Emplogoext_N( (byte)((byte)((n957EmpLogoExt)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Empfirma_N( (byte)((byte)((n958EmpFirma)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Empfirmanom_N( (byte)((byte)((n959EmpFirmaNom)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Empfirmaext_N( (byte)((byte)((n960EmpFirmaExt)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Empmeshspext_N( (byte)((byte)((n1302EmpMesHsPExt)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Empdiahspext_N( (byte)((byte)((n1303EmpDiaHsPExt)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Emposocod_N( (byte)((byte)((n1965EmpOsoCod)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Empultsexoing_N( (byte)((byte)((n1972EmpUltSexoIng)?1:0)) );
      obj13.setgxTv_SdtEmpresa_Mode( Gx_mode );
   }

   public void KeyVarsToRow13( web.SdtEmpresa obj13 )
   {
      obj13.setgxTv_SdtEmpresa_Clicod( A3CliCod );
      obj13.setgxTv_SdtEmpresa_Empcod( A1EmpCod );
   }

   public void RowToVars13( web.SdtEmpresa obj13 ,
                            int forceLoad )
   {
      Gx_mode = obj13.getgxTv_SdtEmpresa_Mode() ;
      A2EmpNom = obj13.getgxTv_SdtEmpresa_Empnom() ;
      A177EmpCUIT = obj13.getgxTv_SdtEmpresa_Empcuit() ;
      A125CatIvaCod = obj13.getgxTv_SdtEmpresa_Cativacod() ;
      n125CatIvaCod = false ;
      A126CatIvaDesc = obj13.getgxTv_SdtEmpresa_Cativadesc() ;
      n126CatIvaDesc = false ;
      A178EmpDir = obj13.getgxTv_SdtEmpresa_Empdir() ;
      A180EmpTel = obj13.getgxTv_SdtEmpresa_Emptel() ;
      n180EmpTel = false ;
      A176EmpCP = obj13.getgxTv_SdtEmpresa_Empcp() ;
      n176EmpCP = false ;
      A46PaiCod = obj13.getgxTv_SdtEmpresa_Paicod() ;
      n46PaiCod = false ;
      A312PaiNom = obj13.getgxTv_SdtEmpresa_Painom() ;
      A47ProvCod = obj13.getgxTv_SdtEmpresa_Provcod() ;
      n47ProvCod = false ;
      A322ProvNom = obj13.getgxTv_SdtEmpresa_Provnom() ;
      A48LocCod = obj13.getgxTv_SdtEmpresa_Loccod() ;
      n48LocCod = false ;
      A286LocNom = obj13.getgxTv_SdtEmpresa_Locnom() ;
      A43ActCodigo = obj13.getgxTv_SdtEmpresa_Actcodigo() ;
      n43ActCodigo = false ;
      A108ActDescrip = obj13.getgxTv_SdtEmpresa_Actdescrip() ;
      A45TipEmpleCod = obj13.getgxTv_SdtEmpresa_Tipemplecod() ;
      n45TipEmpleCod = false ;
      A44EmpZonCod = obj13.getgxTv_SdtEmpresa_Empzoncod() ;
      n44EmpZonCod = false ;
      A518EmpZonDescrip = obj13.getgxTv_SdtEmpresa_Empzondescrip() ;
      A532EmpReducc = obj13.getgxTv_SdtEmpresa_Empreducc() ;
      A1533EmpActComercial = obj13.getgxTv_SdtEmpresa_Empactcomercial() ;
      A530TipEmpleDefIns = obj13.getgxTv_SdtEmpresa_Tipempledefins() ;
      A955EmpLogo = obj13.getgxTv_SdtEmpresa_Emplogo() ;
      n955EmpLogo = false ;
      A958EmpFirma = obj13.getgxTv_SdtEmpresa_Empfirma() ;
      n958EmpFirma = false ;
      A1140EmpAntiguedad = obj13.getgxTv_SdtEmpresa_Empantiguedad() ;
      A1141EmpPresentismo = obj13.getgxTv_SdtEmpresa_Emppresentismo() ;
      A1302EmpMesHsPExt = obj13.getgxTv_SdtEmpresa_Empmeshspext() ;
      n1302EmpMesHsPExt = false ;
      A1303EmpDiaHsPExt = obj13.getgxTv_SdtEmpresa_Empdiahspext() ;
      n1303EmpDiaHsPExt = false ;
      A1151ARTSec = obj13.getgxTv_SdtEmpresa_Artsec() ;
      A1811EmpPerVacDes = obj13.getgxTv_SdtEmpresa_Emppervacdes() ;
      A1812EmpPerVacHas = obj13.getgxTv_SdtEmpresa_Emppervachas() ;
      A1524EmpLiqFer = obj13.getgxTv_SdtEmpresa_Empliqfer() ;
      A1556EmpGuarEdadMin = obj13.getgxTv_SdtEmpresa_Empguaredadmin() ;
      A1557EmpGuarEdadMax = obj13.getgxTv_SdtEmpresa_Empguaredadmax() ;
      A903ActComCodigo = obj13.getgxTv_SdtEmpresa_Actcomcodigo() ;
      A1750EmpLiqFerJor = obj13.getgxTv_SdtEmpresa_Empliqferjor() ;
      A1787EmpLiqGan = obj13.getgxTv_SdtEmpresa_Empliqgan() ;
      A1792EmpTipoExp = obj13.getgxTv_SdtEmpresa_Emptipoexp() ;
      A1802EmpPromDesde = obj13.getgxTv_SdtEmpresa_Emppromdesde() ;
      A1813EmpFracVacAnt = obj13.getgxTv_SdtEmpresa_Empfracvacant() ;
      A1965EmpOsoCod = obj13.getgxTv_SdtEmpresa_Emposocod() ;
      n1965EmpOsoCod = false ;
      A1972EmpUltSexoIng = obj13.getgxTv_SdtEmpresa_Empultsexoing() ;
      n1972EmpUltSexoIng = false ;
      A2265EmpCondiCod = obj13.getgxTv_SdtEmpresa_Empcondicod() ;
      A2405EmpModTra = obj13.getgxTv_SdtEmpresa_Empmodtra() ;
      A957EmpLogoExt = ((GXutil.strcmp("", obj13.getgxTv_SdtEmpresa_Emplogoext())==0) ? com.genexus.util.GXFile.getgxFileext( A955EmpLogo) : obj13.getgxTv_SdtEmpresa_Emplogoext()) ;
      n957EmpLogoExt = false ;
      A960EmpFirmaExt = ((GXutil.strcmp("", obj13.getgxTv_SdtEmpresa_Empfirmaext())==0) ? com.genexus.util.GXFile.getgxFileext( A958EmpFirma) : obj13.getgxTv_SdtEmpresa_Empfirmaext()) ;
      n960EmpFirmaExt = false ;
      A956EmpLogoNom = ((GXutil.strcmp("", obj13.getgxTv_SdtEmpresa_Emplogonom())==0) ? com.genexus.util.GXFile.getgxFilename( A955EmpLogo) : obj13.getgxTv_SdtEmpresa_Emplogonom()) ;
      n956EmpLogoNom = false ;
      A959EmpFirmaNom = ((GXutil.strcmp("", obj13.getgxTv_SdtEmpresa_Empfirmanom())==0) ? com.genexus.util.GXFile.getgxFilename( A958EmpFirma) : obj13.getgxTv_SdtEmpresa_Empfirmanom()) ;
      n959EmpFirmaNom = false ;
      A3CliCod = obj13.getgxTv_SdtEmpresa_Clicod() ;
      A1EmpCod = obj13.getgxTv_SdtEmpresa_Empcod() ;
      Z3CliCod = obj13.getgxTv_SdtEmpresa_Clicod_Z() ;
      Z1EmpCod = obj13.getgxTv_SdtEmpresa_Empcod_Z() ;
      Z2EmpNom = obj13.getgxTv_SdtEmpresa_Empnom_Z() ;
      Z177EmpCUIT = obj13.getgxTv_SdtEmpresa_Empcuit_Z() ;
      Z125CatIvaCod = obj13.getgxTv_SdtEmpresa_Cativacod_Z() ;
      Z126CatIvaDesc = obj13.getgxTv_SdtEmpresa_Cativadesc_Z() ;
      Z178EmpDir = obj13.getgxTv_SdtEmpresa_Empdir_Z() ;
      Z180EmpTel = obj13.getgxTv_SdtEmpresa_Emptel_Z() ;
      Z176EmpCP = obj13.getgxTv_SdtEmpresa_Empcp_Z() ;
      Z46PaiCod = obj13.getgxTv_SdtEmpresa_Paicod_Z() ;
      Z312PaiNom = obj13.getgxTv_SdtEmpresa_Painom_Z() ;
      Z47ProvCod = obj13.getgxTv_SdtEmpresa_Provcod_Z() ;
      Z322ProvNom = obj13.getgxTv_SdtEmpresa_Provnom_Z() ;
      Z48LocCod = obj13.getgxTv_SdtEmpresa_Loccod_Z() ;
      Z286LocNom = obj13.getgxTv_SdtEmpresa_Locnom_Z() ;
      Z43ActCodigo = obj13.getgxTv_SdtEmpresa_Actcodigo_Z() ;
      Z108ActDescrip = obj13.getgxTv_SdtEmpresa_Actdescrip_Z() ;
      Z45TipEmpleCod = obj13.getgxTv_SdtEmpresa_Tipemplecod_Z() ;
      Z44EmpZonCod = obj13.getgxTv_SdtEmpresa_Empzoncod_Z() ;
      Z518EmpZonDescrip = obj13.getgxTv_SdtEmpresa_Empzondescrip_Z() ;
      Z532EmpReducc = obj13.getgxTv_SdtEmpresa_Empreducc_Z() ;
      Z1533EmpActComercial = obj13.getgxTv_SdtEmpresa_Empactcomercial_Z() ;
      Z530TipEmpleDefIns = obj13.getgxTv_SdtEmpresa_Tipempledefins_Z() ;
      Z956EmpLogoNom = obj13.getgxTv_SdtEmpresa_Emplogonom_Z() ;
      Z957EmpLogoExt = obj13.getgxTv_SdtEmpresa_Emplogoext_Z() ;
      Z959EmpFirmaNom = obj13.getgxTv_SdtEmpresa_Empfirmanom_Z() ;
      Z960EmpFirmaExt = obj13.getgxTv_SdtEmpresa_Empfirmaext_Z() ;
      Z1140EmpAntiguedad = obj13.getgxTv_SdtEmpresa_Empantiguedad_Z() ;
      Z1141EmpPresentismo = obj13.getgxTv_SdtEmpresa_Emppresentismo_Z() ;
      Z1302EmpMesHsPExt = obj13.getgxTv_SdtEmpresa_Empmeshspext_Z() ;
      Z1303EmpDiaHsPExt = obj13.getgxTv_SdtEmpresa_Empdiahspext_Z() ;
      Z1151ARTSec = obj13.getgxTv_SdtEmpresa_Artsec_Z() ;
      Z1811EmpPerVacDes = obj13.getgxTv_SdtEmpresa_Emppervacdes_Z() ;
      Z1812EmpPerVacHas = obj13.getgxTv_SdtEmpresa_Emppervachas_Z() ;
      Z1524EmpLiqFer = obj13.getgxTv_SdtEmpresa_Empliqfer_Z() ;
      Z1556EmpGuarEdadMin = obj13.getgxTv_SdtEmpresa_Empguaredadmin_Z() ;
      Z1557EmpGuarEdadMax = obj13.getgxTv_SdtEmpresa_Empguaredadmax_Z() ;
      Z903ActComCodigo = obj13.getgxTv_SdtEmpresa_Actcomcodigo_Z() ;
      Z1750EmpLiqFerJor = obj13.getgxTv_SdtEmpresa_Empliqferjor_Z() ;
      Z1787EmpLiqGan = obj13.getgxTv_SdtEmpresa_Empliqgan_Z() ;
      Z1792EmpTipoExp = obj13.getgxTv_SdtEmpresa_Emptipoexp_Z() ;
      Z1802EmpPromDesde = obj13.getgxTv_SdtEmpresa_Emppromdesde_Z() ;
      Z1813EmpFracVacAnt = obj13.getgxTv_SdtEmpresa_Empfracvacant_Z() ;
      Z1965EmpOsoCod = obj13.getgxTv_SdtEmpresa_Emposocod_Z() ;
      Z1972EmpUltSexoIng = obj13.getgxTv_SdtEmpresa_Empultsexoing_Z() ;
      Z2265EmpCondiCod = obj13.getgxTv_SdtEmpresa_Empcondicod_Z() ;
      Z2405EmpModTra = obj13.getgxTv_SdtEmpresa_Empmodtra_Z() ;
      n125CatIvaCod = (boolean)((obj13.getgxTv_SdtEmpresa_Cativacod_N()==0)?false:true) ;
      n126CatIvaDesc = (boolean)((obj13.getgxTv_SdtEmpresa_Cativadesc_N()==0)?false:true) ;
      n180EmpTel = (boolean)((obj13.getgxTv_SdtEmpresa_Emptel_N()==0)?false:true) ;
      n176EmpCP = (boolean)((obj13.getgxTv_SdtEmpresa_Empcp_N()==0)?false:true) ;
      n46PaiCod = (boolean)((obj13.getgxTv_SdtEmpresa_Paicod_N()==0)?false:true) ;
      n47ProvCod = (boolean)((obj13.getgxTv_SdtEmpresa_Provcod_N()==0)?false:true) ;
      n48LocCod = (boolean)((obj13.getgxTv_SdtEmpresa_Loccod_N()==0)?false:true) ;
      n43ActCodigo = (boolean)((obj13.getgxTv_SdtEmpresa_Actcodigo_N()==0)?false:true) ;
      n45TipEmpleCod = (boolean)((obj13.getgxTv_SdtEmpresa_Tipemplecod_N()==0)?false:true) ;
      n44EmpZonCod = (boolean)((obj13.getgxTv_SdtEmpresa_Empzoncod_N()==0)?false:true) ;
      n955EmpLogo = (boolean)((obj13.getgxTv_SdtEmpresa_Emplogo_N()==0)?false:true) ;
      n956EmpLogoNom = (boolean)((obj13.getgxTv_SdtEmpresa_Emplogonom_N()==0)?false:true) ;
      n957EmpLogoExt = (boolean)((obj13.getgxTv_SdtEmpresa_Emplogoext_N()==0)?false:true) ;
      n958EmpFirma = (boolean)((obj13.getgxTv_SdtEmpresa_Empfirma_N()==0)?false:true) ;
      n959EmpFirmaNom = (boolean)((obj13.getgxTv_SdtEmpresa_Empfirmanom_N()==0)?false:true) ;
      n960EmpFirmaExt = (boolean)((obj13.getgxTv_SdtEmpresa_Empfirmaext_N()==0)?false:true) ;
      n1302EmpMesHsPExt = (boolean)((obj13.getgxTv_SdtEmpresa_Empmeshspext_N()==0)?false:true) ;
      n1303EmpDiaHsPExt = (boolean)((obj13.getgxTv_SdtEmpresa_Empdiahspext_N()==0)?false:true) ;
      n1965EmpOsoCod = (boolean)((obj13.getgxTv_SdtEmpresa_Emposocod_N()==0)?false:true) ;
      n1972EmpUltSexoIng = (boolean)((obj13.getgxTv_SdtEmpresa_Empultsexoing_N()==0)?false:true) ;
      Gx_mode = obj13.getgxTv_SdtEmpresa_Mode() ;
   }

   public void VarsToRow172( web.SdtEmpresa_conceptos_horanormal_jornalizados obj172 )
   {
      obj172.setgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Mode( Gx_mode );
      obj172.setgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorhabitual( A1369EmpJorHabitual );
      obj172.setgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorconcodigo( A1366EmpJorConCodigo );
      obj172.setgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorconcodigo_Z( Z1366EmpJorConCodigo );
      obj172.setgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorhabitual_Z( Z1369EmpJorHabitual );
      obj172.setgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Modified( nIsMod_172 );
   }

   public void KeyVarsToRow172( web.SdtEmpresa_conceptos_horanormal_jornalizados obj172 )
   {
      obj172.setgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorconcodigo( A1366EmpJorConCodigo );
   }

   public void RowToVars172( web.SdtEmpresa_conceptos_horanormal_jornalizados obj172 ,
                             int forceLoad )
   {
      Gx_mode = obj172.getgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Mode() ;
      A1369EmpJorHabitual = obj172.getgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorhabitual() ;
      A1366EmpJorConCodigo = obj172.getgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorconcodigo() ;
      Z1366EmpJorConCodigo = obj172.getgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorconcodigo_Z() ;
      Z1369EmpJorHabitual = obj172.getgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Empjorhabitual_Z() ;
      nIsMod_172 = obj172.getgxTv_SdtEmpresa_conceptos_horanormal_jornalizados_Modified() ;
   }

   public void VarsToRow171( web.SdtEmpresa_conceptos_horanormal_mensualizados obj171 )
   {
      obj171.setgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Mode( Gx_mode );
      obj171.setgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenhabitual( A1370EmpMenHabitual );
      obj171.setgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenconcodigo( A1368EmpMenConCodigo );
      obj171.setgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenconcodigo_Z( Z1368EmpMenConCodigo );
      obj171.setgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenhabitual_Z( Z1370EmpMenHabitual );
      obj171.setgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Modified( nIsMod_171 );
   }

   public void KeyVarsToRow171( web.SdtEmpresa_conceptos_horanormal_mensualizados obj171 )
   {
      obj171.setgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenconcodigo( A1368EmpMenConCodigo );
   }

   public void RowToVars171( web.SdtEmpresa_conceptos_horanormal_mensualizados obj171 ,
                             int forceLoad )
   {
      Gx_mode = obj171.getgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Mode() ;
      A1370EmpMenHabitual = obj171.getgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenhabitual() ;
      A1368EmpMenConCodigo = obj171.getgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenconcodigo() ;
      Z1368EmpMenConCodigo = obj171.getgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenconcodigo_Z() ;
      Z1370EmpMenHabitual = obj171.getgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Empmenhabitual_Z() ;
      nIsMod_171 = obj171.getgxTv_SdtEmpresa_conceptos_horanormal_mensualizados_Modified() ;
   }

   public void VarsToRow173( web.SdtEmpresa_promedio_horanormal_mensualizados obj173 )
   {
      obj173.setgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Mode( Gx_mode );
      obj173.setgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Emppromhabitual( A1372EmpPromHabitual );
      obj173.setgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Tipoconcod( A37TipoConCod );
      obj173.setgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Emppromfijvar( A1371EmpPromFijVar );
      obj173.setgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Tipoconcod_Z( Z37TipoConCod );
      obj173.setgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Emppromfijvar_Z( Z1371EmpPromFijVar );
      obj173.setgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Emppromhabitual_Z( Z1372EmpPromHabitual );
      obj173.setgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Modified( nIsMod_173 );
   }

   public void KeyVarsToRow173( web.SdtEmpresa_promedio_horanormal_mensualizados obj173 )
   {
      obj173.setgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Tipoconcod( A37TipoConCod );
      obj173.setgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Emppromfijvar( A1371EmpPromFijVar );
   }

   public void RowToVars173( web.SdtEmpresa_promedio_horanormal_mensualizados obj173 ,
                             int forceLoad )
   {
      Gx_mode = obj173.getgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Mode() ;
      A1372EmpPromHabitual = obj173.getgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Emppromhabitual() ;
      A37TipoConCod = obj173.getgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Tipoconcod() ;
      A1371EmpPromFijVar = obj173.getgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Emppromfijvar() ;
      Z37TipoConCod = obj173.getgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Tipoconcod_Z() ;
      Z1371EmpPromFijVar = obj173.getgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Emppromfijvar_Z() ;
      Z1372EmpPromHabitual = obj173.getgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Emppromhabitual_Z() ;
      nIsMod_173 = obj173.getgxTv_SdtEmpresa_promedio_horanormal_mensualizados_Modified() ;
   }

   public void VarsToRow165( web.SdtEmpresa_horasextras_pordia obj165 )
   {
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Mode( Gx_mode );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra( A1339EmpHsPDiaTipTra );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia( A1341EmpHsPDiaDia );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde( A1342EmpHsPDiaDesde );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia( A1343EmpTarifaPDia );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec( A1351EmpTarfaPDRec );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec( A1340EmpHsExSec );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z( Z1340EmpHsExSec );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z( Z1339EmpHsPDiaTipTra );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z( Z1341EmpHsPDiaDia );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z( Z1342EmpHsPDiaDesde );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z( Z1343EmpTarifaPDia );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z( Z1351EmpTarfaPDRec );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N( (byte)((byte)((n1342EmpHsPDiaDesde)?1:0)) );
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Modified( nIsMod_165 );
   }

   public void KeyVarsToRow165( web.SdtEmpresa_horasextras_pordia obj165 )
   {
      obj165.setgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec( A1340EmpHsExSec );
   }

   public void RowToVars165( web.SdtEmpresa_horasextras_pordia obj165 ,
                             int forceLoad )
   {
      Gx_mode = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Mode() ;
      A1339EmpHsPDiaTipTra = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra() ;
      A1341EmpHsPDiaDia = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia() ;
      A1342EmpHsPDiaDesde = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde() ;
      n1342EmpHsPDiaDesde = false ;
      A1343EmpTarifaPDia = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia() ;
      A1351EmpTarfaPDRec = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec() ;
      A1340EmpHsExSec = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec() ;
      Z1340EmpHsExSec = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z() ;
      Z1339EmpHsPDiaTipTra = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z() ;
      Z1341EmpHsPDiaDia = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z() ;
      Z1342EmpHsPDiaDesde = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z() ;
      Z1343EmpTarifaPDia = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z() ;
      Z1351EmpTarfaPDRec = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z() ;
      n1342EmpHsPDiaDesde = (boolean)((obj165.getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N()==0)?false:true) ;
      nIsMod_165 = obj165.getgxTv_SdtEmpresa_horasextras_pordia_Modified() ;
   }

   public void VarsToRow166( web.SdtEmpresa_tipo_trabajo obj166 )
   {
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Mode( Gx_mode );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emphsdia( A1344EmpHsDia );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emphssem( A1345EmpHsSem );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim( A1346EmpTarifaXLim );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec( A1352EmpTarifaRec );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia( A1386EmpHsMaxDia );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem( A1387EmpHsMaxSem );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes( A1388EmpHsMaxMes );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu( A1389EmpHsMaxAnu );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid( A1294PaiTipoTraId );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z( Z1294PaiTipoTraId );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z( Z1344EmpHsDia );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z( Z1345EmpHsSem );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z( Z1346EmpTarifaXLim );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z( Z1352EmpTarifaRec );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z( Z1386EmpHsMaxDia );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z( Z1387EmpHsMaxSem );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z( Z1388EmpHsMaxMes );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z( Z1389EmpHsMaxAnu );
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Modified( nIsMod_166 );
   }

   public void KeyVarsToRow166( web.SdtEmpresa_tipo_trabajo obj166 )
   {
      obj166.setgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid( A1294PaiTipoTraId );
   }

   public void RowToVars166( web.SdtEmpresa_tipo_trabajo obj166 ,
                             int forceLoad )
   {
      Gx_mode = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Mode() ;
      A1344EmpHsDia = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emphsdia() ;
      A1345EmpHsSem = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emphssem() ;
      A1346EmpTarifaXLim = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim() ;
      A1352EmpTarifaRec = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec() ;
      A1386EmpHsMaxDia = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia() ;
      A1387EmpHsMaxSem = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem() ;
      A1388EmpHsMaxMes = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes() ;
      A1389EmpHsMaxAnu = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu() ;
      A1294PaiTipoTraId = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid() ;
      Z1294PaiTipoTraId = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z() ;
      Z1344EmpHsDia = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z() ;
      Z1345EmpHsSem = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z() ;
      Z1346EmpTarifaXLim = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z() ;
      Z1352EmpTarifaRec = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z() ;
      Z1386EmpHsMaxDia = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z() ;
      Z1387EmpHsMaxSem = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z() ;
      Z1388EmpHsMaxMes = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z() ;
      Z1389EmpHsMaxAnu = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z() ;
      nIsMod_166 = obj166.getgxTv_SdtEmpresa_tipo_trabajo_Modified() ;
   }

   public void VarsToRow144( web.SdtEmpresa_nolaborables_convenio obj144 )
   {
      obj144.setgxTv_SdtEmpresa_nolaborables_convenio_Mode( Gx_mode );
      obj144.setgxTv_SdtEmpresa_nolaborables_convenio_Empconvenio( A1239EmpConvenio );
      obj144.setgxTv_SdtEmpresa_nolaborables_convenio_Empconvenio_Z( Z1239EmpConvenio );
      obj144.setgxTv_SdtEmpresa_nolaborables_convenio_Modified( nIsMod_144 );
   }

   public void KeyVarsToRow144( web.SdtEmpresa_nolaborables_convenio obj144 )
   {
      obj144.setgxTv_SdtEmpresa_nolaborables_convenio_Empconvenio( A1239EmpConvenio );
   }

   public void RowToVars144( web.SdtEmpresa_nolaborables_convenio obj144 ,
                             int forceLoad )
   {
      Gx_mode = obj144.getgxTv_SdtEmpresa_nolaborables_convenio_Mode() ;
      A1239EmpConvenio = obj144.getgxTv_SdtEmpresa_nolaborables_convenio_Empconvenio() ;
      Z1239EmpConvenio = obj144.getgxTv_SdtEmpresa_nolaborables_convenio_Empconvenio_Z() ;
      nIsMod_144 = obj144.getgxTv_SdtEmpresa_nolaborables_convenio_Modified() ;
   }

   public void VarsToRow145( web.SdtEmpresa_nolaborables_origen obj145 )
   {
      obj145.setgxTv_SdtEmpresa_nolaborables_origen_Mode( Gx_mode );
      obj145.setgxTv_SdtEmpresa_nolaborables_origen_Emporigen( A1238EmpOrigen );
      obj145.setgxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z( Z1238EmpOrigen );
      obj145.setgxTv_SdtEmpresa_nolaborables_origen_Modified( nIsMod_145 );
   }

   public void KeyVarsToRow145( web.SdtEmpresa_nolaborables_origen obj145 )
   {
      obj145.setgxTv_SdtEmpresa_nolaborables_origen_Emporigen( A1238EmpOrigen );
   }

   public void RowToVars145( web.SdtEmpresa_nolaborables_origen obj145 ,
                             int forceLoad )
   {
      Gx_mode = obj145.getgxTv_SdtEmpresa_nolaborables_origen_Mode() ;
      A1238EmpOrigen = obj145.getgxTv_SdtEmpresa_nolaborables_origen_Emporigen() ;
      Z1238EmpOrigen = obj145.getgxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z() ;
      nIsMod_145 = obj145.getgxTv_SdtEmpresa_nolaborables_origen_Modified() ;
   }

   public void VarsToRow146( web.SdtEmpresa_nolaborables_religion obj146 )
   {
      obj146.setgxTv_SdtEmpresa_nolaborables_religion_Mode( Gx_mode );
      obj146.setgxTv_SdtEmpresa_nolaborables_religion_Empreligion( A1237EmpReligion );
      obj146.setgxTv_SdtEmpresa_nolaborables_religion_Empreligion_Z( Z1237EmpReligion );
      obj146.setgxTv_SdtEmpresa_nolaborables_religion_Modified( nIsMod_146 );
   }

   public void KeyVarsToRow146( web.SdtEmpresa_nolaborables_religion obj146 )
   {
      obj146.setgxTv_SdtEmpresa_nolaborables_religion_Empreligion( A1237EmpReligion );
   }

   public void RowToVars146( web.SdtEmpresa_nolaborables_religion obj146 ,
                             int forceLoad )
   {
      Gx_mode = obj146.getgxTv_SdtEmpresa_nolaborables_religion_Mode() ;
      A1237EmpReligion = obj146.getgxTv_SdtEmpresa_nolaborables_religion_Empreligion() ;
      Z1237EmpReligion = obj146.getgxTv_SdtEmpresa_nolaborables_religion_Empreligion_Z() ;
      nIsMod_146 = obj146.getgxTv_SdtEmpresa_nolaborables_religion_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0F13( ) ;
      scanKeyStart0F13( ) ;
      if ( RcdFound13 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000F217 */
         pr_default.execute(215, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(215) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(215);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         O955EmpLogo = A955EmpLogo ;
         n955EmpLogo = false ;
      }
      zm0F13( -21) ;
      onLoadActions0F13( ) ;
      addRow0F13( ) ;
      bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_jornalizados().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F172( ) ;
         nGXsfl_172_idx = 1 ;
         while ( RcdFound172 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1366EmpJorConCodigo = A1366EmpJorConCodigo ;
            zm0F172( -34) ;
            onLoadActions0F172( ) ;
            nRcdExists_172 = (short)(1) ;
            nIsMod_172 = (short)(0) ;
            addRow0F172( ) ;
            nGXsfl_172_idx = (int)(nGXsfl_172_idx+1) ;
            scanKeyNext0F172( ) ;
         }
         scanKeyEnd0F172( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_mensualizados().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F171( ) ;
         nGXsfl_171_idx = 1 ;
         while ( RcdFound171 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1368EmpMenConCodigo = A1368EmpMenConCodigo ;
            zm0F171( -36) ;
            onLoadActions0F171( ) ;
            nRcdExists_171 = (short)(1) ;
            nIsMod_171 = (short)(0) ;
            addRow0F171( ) ;
            nGXsfl_171_idx = (int)(nGXsfl_171_idx+1) ;
            scanKeyNext0F171( ) ;
         }
         scanKeyEnd0F171( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Promedio_horanormal_mensualizados().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F173( ) ;
         nGXsfl_173_idx = 1 ;
         while ( RcdFound173 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z37TipoConCod = A37TipoConCod ;
            Z1371EmpPromFijVar = A1371EmpPromFijVar ;
            zm0F173( -38) ;
            onLoadActions0F173( ) ;
            nRcdExists_173 = (short)(1) ;
            nIsMod_173 = (short)(0) ;
            addRow0F173( ) ;
            nGXsfl_173_idx = (int)(nGXsfl_173_idx+1) ;
            scanKeyNext0F173( ) ;
         }
         scanKeyEnd0F173( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Horasextras_pordia().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F165( ) ;
         nGXsfl_165_idx = 1 ;
         while ( RcdFound165 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1340EmpHsExSec = A1340EmpHsExSec ;
            zm0F165( -40) ;
            onLoadActions0F165( ) ;
            nRcdExists_165 = (short)(1) ;
            nIsMod_165 = (short)(0) ;
            addRow0F165( ) ;
            nGXsfl_165_idx = (int)(nGXsfl_165_idx+1) ;
            scanKeyNext0F165( ) ;
         }
         scanKeyEnd0F165( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Tipo_trabajo().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F166( ) ;
         nGXsfl_166_idx = 1 ;
         while ( RcdFound166 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1294PaiTipoTraId = A1294PaiTipoTraId ;
            zm0F166( -42) ;
            onLoadActions0F166( ) ;
            nRcdExists_166 = (short)(1) ;
            nIsMod_166 = (short)(0) ;
            addRow0F166( ) ;
            nGXsfl_166_idx = (int)(nGXsfl_166_idx+1) ;
            scanKeyNext0F166( ) ;
         }
         scanKeyEnd0F166( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_convenio().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F144( ) ;
         nGXsfl_144_idx = 1 ;
         while ( RcdFound144 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1239EmpConvenio = A1239EmpConvenio ;
            zm0F144( -44) ;
            onLoadActions0F144( ) ;
            nRcdExists_144 = (short)(1) ;
            nIsMod_144 = (short)(0) ;
            addRow0F144( ) ;
            nGXsfl_144_idx = (int)(nGXsfl_144_idx+1) ;
            scanKeyNext0F144( ) ;
         }
         scanKeyEnd0F144( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_origen().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F145( ) ;
         nGXsfl_145_idx = 1 ;
         while ( RcdFound145 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1238EmpOrigen = A1238EmpOrigen ;
            zm0F145( -45) ;
            onLoadActions0F145( ) ;
            nRcdExists_145 = (short)(1) ;
            nIsMod_145 = (short)(0) ;
            addRow0F145( ) ;
            nGXsfl_145_idx = (int)(nGXsfl_145_idx+1) ;
            scanKeyNext0F145( ) ;
         }
         scanKeyEnd0F145( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_religion().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F146( ) ;
         nGXsfl_146_idx = 1 ;
         while ( RcdFound146 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1237EmpReligion = A1237EmpReligion ;
            zm0F146( -47) ;
            onLoadActions0F146( ) ;
            nRcdExists_146 = (short)(1) ;
            nIsMod_146 = (short)(0) ;
            addRow0F146( ) ;
            nGXsfl_146_idx = (int)(nGXsfl_146_idx+1) ;
            scanKeyNext0F146( ) ;
         }
         scanKeyEnd0F146( ) ;
      }
      scanKeyEnd0F13( ) ;
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
      RowToVars13( bcEmpresa, 0) ;
      scanKeyStart0F13( ) ;
      if ( RcdFound13 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000F218 */
         pr_default.execute(216, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(216) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(216);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         O955EmpLogo = A955EmpLogo ;
         n955EmpLogo = false ;
      }
      zm0F13( -21) ;
      onLoadActions0F13( ) ;
      addRow0F13( ) ;
      bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_jornalizados().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F172( ) ;
         nGXsfl_172_idx = 1 ;
         while ( RcdFound172 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1366EmpJorConCodigo = A1366EmpJorConCodigo ;
            zm0F172( -34) ;
            onLoadActions0F172( ) ;
            nRcdExists_172 = (short)(1) ;
            nIsMod_172 = (short)(0) ;
            addRow0F172( ) ;
            nGXsfl_172_idx = (int)(nGXsfl_172_idx+1) ;
            scanKeyNext0F172( ) ;
         }
         scanKeyEnd0F172( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Conceptos_horanormal_mensualizados().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F171( ) ;
         nGXsfl_171_idx = 1 ;
         while ( RcdFound171 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1368EmpMenConCodigo = A1368EmpMenConCodigo ;
            zm0F171( -36) ;
            onLoadActions0F171( ) ;
            nRcdExists_171 = (short)(1) ;
            nIsMod_171 = (short)(0) ;
            addRow0F171( ) ;
            nGXsfl_171_idx = (int)(nGXsfl_171_idx+1) ;
            scanKeyNext0F171( ) ;
         }
         scanKeyEnd0F171( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Promedio_horanormal_mensualizados().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F173( ) ;
         nGXsfl_173_idx = 1 ;
         while ( RcdFound173 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z37TipoConCod = A37TipoConCod ;
            Z1371EmpPromFijVar = A1371EmpPromFijVar ;
            zm0F173( -38) ;
            onLoadActions0F173( ) ;
            nRcdExists_173 = (short)(1) ;
            nIsMod_173 = (short)(0) ;
            addRow0F173( ) ;
            nGXsfl_173_idx = (int)(nGXsfl_173_idx+1) ;
            scanKeyNext0F173( ) ;
         }
         scanKeyEnd0F173( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Horasextras_pordia().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F165( ) ;
         nGXsfl_165_idx = 1 ;
         while ( RcdFound165 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1340EmpHsExSec = A1340EmpHsExSec ;
            zm0F165( -40) ;
            onLoadActions0F165( ) ;
            nRcdExists_165 = (short)(1) ;
            nIsMod_165 = (short)(0) ;
            addRow0F165( ) ;
            nGXsfl_165_idx = (int)(nGXsfl_165_idx+1) ;
            scanKeyNext0F165( ) ;
         }
         scanKeyEnd0F165( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Tipo_trabajo().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F166( ) ;
         nGXsfl_166_idx = 1 ;
         while ( RcdFound166 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1294PaiTipoTraId = A1294PaiTipoTraId ;
            zm0F166( -42) ;
            onLoadActions0F166( ) ;
            nRcdExists_166 = (short)(1) ;
            nIsMod_166 = (short)(0) ;
            addRow0F166( ) ;
            nGXsfl_166_idx = (int)(nGXsfl_166_idx+1) ;
            scanKeyNext0F166( ) ;
         }
         scanKeyEnd0F166( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_convenio().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F144( ) ;
         nGXsfl_144_idx = 1 ;
         while ( RcdFound144 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1239EmpConvenio = A1239EmpConvenio ;
            zm0F144( -44) ;
            onLoadActions0F144( ) ;
            nRcdExists_144 = (short)(1) ;
            nIsMod_144 = (short)(0) ;
            addRow0F144( ) ;
            nGXsfl_144_idx = (int)(nGXsfl_144_idx+1) ;
            scanKeyNext0F144( ) ;
         }
         scanKeyEnd0F144( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_origen().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F145( ) ;
         nGXsfl_145_idx = 1 ;
         while ( RcdFound145 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1238EmpOrigen = A1238EmpOrigen ;
            zm0F145( -45) ;
            onLoadActions0F145( ) ;
            nRcdExists_145 = (short)(1) ;
            nIsMod_145 = (short)(0) ;
            addRow0F145( ) ;
            nGXsfl_145_idx = (int)(nGXsfl_145_idx+1) ;
            scanKeyNext0F145( ) ;
         }
         scanKeyEnd0F145( ) ;
      }
      bcEmpresa.getgxTv_SdtEmpresa_Nolaborables_religion().clearCollection();
      if ( RcdFound13 == 1 )
      {
         scanKeyStart0F146( ) ;
         nGXsfl_146_idx = 1 ;
         while ( RcdFound146 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1237EmpReligion = A1237EmpReligion ;
            zm0F146( -47) ;
            onLoadActions0F146( ) ;
            nRcdExists_146 = (short)(1) ;
            nIsMod_146 = (short)(0) ;
            addRow0F146( ) ;
            nGXsfl_146_idx = (int)(nGXsfl_146_idx+1) ;
            scanKeyNext0F146( ) ;
         }
         scanKeyEnd0F146( ) ;
      }
      scanKeyEnd0F13( ) ;
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
      getKey0F13( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0F13( ) ;
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
               update0F13( ) ;
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
                     insert0F13( ) ;
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
                     insert0F13( ) ;
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
      RowToVars13( bcEmpresa, 1) ;
      saveImpl( ) ;
      VarsToRow13( bcEmpresa) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars13( bcEmpresa, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0F13( ) ;
      afterTrn( ) ;
      VarsToRow13( bcEmpresa) ;
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
         web.SdtEmpresa auxBC = new web.SdtEmpresa( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcEmpresa);
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
      RowToVars13( bcEmpresa, 1) ;
      updateImpl( ) ;
      VarsToRow13( bcEmpresa) ;
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
      RowToVars13( bcEmpresa, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0F13( ) ;
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
      VarsToRow13( bcEmpresa) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars13( bcEmpresa, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0F13( ) ;
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "empresa_bc");
      VarsToRow13( bcEmpresa) ;
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
      Gx_mode = bcEmpresa.getgxTv_SdtEmpresa_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcEmpresa.setgxTv_SdtEmpresa_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtEmpresa sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcEmpresa )
      {
         bcEmpresa = sdt ;
         if ( GXutil.strcmp(bcEmpresa.getgxTv_SdtEmpresa_Mode(), "") == 0 )
         {
            bcEmpresa.setgxTv_SdtEmpresa_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow13( bcEmpresa) ;
         }
         else
         {
            RowToVars13( bcEmpresa, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcEmpresa.getgxTv_SdtEmpresa_Mode(), "") == 0 )
         {
            bcEmpresa.setgxTv_SdtEmpresa_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars13( bcEmpresa, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtEmpresa getEmpresa_BC( )
   {
      return bcEmpresa ;
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
      AV57Pgmname = "" ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV15TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14Insert_ActCodigo = "" ;
      AV40Insert_TipEmpleCod = "" ;
      AV36Insert_EmpZonCod = "" ;
      AV53Insert_EmpActComercial = "" ;
      AV43Insert_ActComCodigo = "" ;
      AV55Insert_EmpOsoCod = "" ;
      A955EmpLogo = "" ;
      O955EmpLogo = "" ;
      A958EmpFirma = "" ;
      O958EmpFirma = "" ;
      GXv_int4 = new long[1] ;
      AV33Date = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      GXv_boolean3 = new boolean[1] ;
      GXv_char6 = new String[1] ;
      Z2EmpNom = "" ;
      A2EmpNom = "" ;
      Z126CatIvaDesc = "" ;
      A126CatIvaDesc = "" ;
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
      Z958EmpFirma = "" ;
      Z957EmpLogoExt = "" ;
      A957EmpLogoExt = "" ;
      Z960EmpFirmaExt = "" ;
      A960EmpFirmaExt = "" ;
      Z956EmpLogoNom = "" ;
      A956EmpLogoNom = "" ;
      Z959EmpFirmaNom = "" ;
      A959EmpFirmaNom = "" ;
      GXv_int8 = new int[1] ;
      BC000F39_A683ActDescripSinAc = new String[] {""} ;
      BC000F39_A1EmpCod = new short[1] ;
      BC000F39_A2EmpNom = new String[] {""} ;
      BC000F39_A177EmpCUIT = new long[1] ;
      BC000F39_A125CatIvaCod = new short[1] ;
      BC000F39_n125CatIvaCod = new boolean[] {false} ;
      BC000F39_A126CatIvaDesc = new String[] {""} ;
      BC000F39_n126CatIvaDesc = new boolean[] {false} ;
      BC000F39_A178EmpDir = new String[] {""} ;
      BC000F39_A180EmpTel = new String[] {""} ;
      BC000F39_n180EmpTel = new boolean[] {false} ;
      BC000F39_A176EmpCP = new String[] {""} ;
      BC000F39_n176EmpCP = new boolean[] {false} ;
      BC000F39_A312PaiNom = new String[] {""} ;
      BC000F39_A322ProvNom = new String[] {""} ;
      BC000F39_A286LocNom = new String[] {""} ;
      BC000F39_A108ActDescrip = new String[] {""} ;
      BC000F39_A518EmpZonDescrip = new String[] {""} ;
      BC000F39_A532EmpReducc = new boolean[] {false} ;
      BC000F39_A530TipEmpleDefIns = new String[] {""} ;
      BC000F39_A955EmpLogo = new String[] {""} ;
      BC000F39_n955EmpLogo = new boolean[] {false} ;
      BC000F39_A958EmpFirma = new String[] {""} ;
      BC000F39_n958EmpFirma = new boolean[] {false} ;
      BC000F39_A1140EmpAntiguedad = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F39_A1141EmpPresentismo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F39_A1302EmpMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F39_n1302EmpMesHsPExt = new boolean[] {false} ;
      BC000F39_A1303EmpDiaHsPExt = new String[] {""} ;
      BC000F39_n1303EmpDiaHsPExt = new boolean[] {false} ;
      BC000F39_A1811EmpPerVacDes = new byte[1] ;
      BC000F39_A1812EmpPerVacHas = new byte[1] ;
      BC000F39_A1524EmpLiqFer = new boolean[] {false} ;
      BC000F39_A1556EmpGuarEdadMin = new byte[1] ;
      BC000F39_A1557EmpGuarEdadMax = new byte[1] ;
      BC000F39_A1750EmpLiqFerJor = new boolean[] {false} ;
      BC000F39_A1787EmpLiqGan = new boolean[] {false} ;
      BC000F39_A1792EmpTipoExp = new byte[1] ;
      BC000F39_A1802EmpPromDesde = new String[] {""} ;
      BC000F39_A1813EmpFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F39_A1972EmpUltSexoIng = new byte[1] ;
      BC000F39_n1972EmpUltSexoIng = new boolean[] {false} ;
      BC000F39_A2405EmpModTra = new String[] {""} ;
      BC000F39_A957EmpLogoExt = new String[] {""} ;
      BC000F39_n957EmpLogoExt = new boolean[] {false} ;
      BC000F39_A960EmpFirmaExt = new String[] {""} ;
      BC000F39_n960EmpFirmaExt = new boolean[] {false} ;
      BC000F39_A956EmpLogoNom = new String[] {""} ;
      BC000F39_n956EmpLogoNom = new boolean[] {false} ;
      BC000F39_A959EmpFirmaNom = new String[] {""} ;
      BC000F39_n959EmpFirmaNom = new boolean[] {false} ;
      BC000F39_A46PaiCod = new short[1] ;
      BC000F39_n46PaiCod = new boolean[] {false} ;
      BC000F39_A47ProvCod = new short[1] ;
      BC000F39_n47ProvCod = new boolean[] {false} ;
      BC000F39_A48LocCod = new short[1] ;
      BC000F39_n48LocCod = new boolean[] {false} ;
      BC000F39_A3CliCod = new int[1] ;
      BC000F39_A43ActCodigo = new String[] {""} ;
      BC000F39_n43ActCodigo = new boolean[] {false} ;
      BC000F39_A45TipEmpleCod = new String[] {""} ;
      BC000F39_n45TipEmpleCod = new boolean[] {false} ;
      BC000F39_A1151ARTSec = new short[1] ;
      BC000F39_A903ActComCodigo = new String[] {""} ;
      BC000F39_A1965EmpOsoCod = new String[] {""} ;
      BC000F39_n1965EmpOsoCod = new boolean[] {false} ;
      BC000F39_A1533EmpActComercial = new String[] {""} ;
      BC000F39_A44EmpZonCod = new String[] {""} ;
      BC000F39_n44EmpZonCod = new boolean[] {false} ;
      BC000F39_A2265EmpCondiCod = new short[1] ;
      A955EmpLogo_Filetype = "" ;
      A958EmpFirma_Filetype = "" ;
      A955EmpLogo_Filename = "" ;
      A958EmpFirma_Filename = "" ;
      BC000F40_A3CliCod = new int[1] ;
      BC000F41_A3CliCod = new int[1] ;
      BC000F42_A312PaiNom = new String[] {""} ;
      BC000F43_A322ProvNom = new String[] {""} ;
      BC000F44_A286LocNom = new String[] {""} ;
      BC000F45_A683ActDescripSinAc = new String[] {""} ;
      BC000F45_A108ActDescrip = new String[] {""} ;
      BC000F46_A530TipEmpleDefIns = new String[] {""} ;
      BC000F47_A518EmpZonDescrip = new String[] {""} ;
      BC000F48_A1533EmpActComercial = new String[] {""} ;
      BC000F49_A1151ARTSec = new short[1] ;
      BC000F50_A903ActComCodigo = new String[] {""} ;
      BC000F51_A2265EmpCondiCod = new short[1] ;
      BC000F52_A3CliCod = new int[1] ;
      BC000F52_A1EmpCod = new short[1] ;
      BC000F53_A1EmpCod = new short[1] ;
      BC000F53_A2EmpNom = new String[] {""} ;
      BC000F53_A177EmpCUIT = new long[1] ;
      BC000F53_A125CatIvaCod = new short[1] ;
      BC000F53_n125CatIvaCod = new boolean[] {false} ;
      BC000F53_A126CatIvaDesc = new String[] {""} ;
      BC000F53_n126CatIvaDesc = new boolean[] {false} ;
      BC000F53_A178EmpDir = new String[] {""} ;
      BC000F53_A180EmpTel = new String[] {""} ;
      BC000F53_n180EmpTel = new boolean[] {false} ;
      BC000F53_A176EmpCP = new String[] {""} ;
      BC000F53_n176EmpCP = new boolean[] {false} ;
      BC000F53_A532EmpReducc = new boolean[] {false} ;
      BC000F53_A955EmpLogo = new String[] {""} ;
      BC000F53_n955EmpLogo = new boolean[] {false} ;
      BC000F53_A958EmpFirma = new String[] {""} ;
      BC000F53_n958EmpFirma = new boolean[] {false} ;
      BC000F53_A1140EmpAntiguedad = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F53_A1141EmpPresentismo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F53_A1302EmpMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F53_n1302EmpMesHsPExt = new boolean[] {false} ;
      BC000F53_A1303EmpDiaHsPExt = new String[] {""} ;
      BC000F53_n1303EmpDiaHsPExt = new boolean[] {false} ;
      BC000F53_A1811EmpPerVacDes = new byte[1] ;
      BC000F53_A1812EmpPerVacHas = new byte[1] ;
      BC000F53_A1524EmpLiqFer = new boolean[] {false} ;
      BC000F53_A1556EmpGuarEdadMin = new byte[1] ;
      BC000F53_A1557EmpGuarEdadMax = new byte[1] ;
      BC000F53_A1750EmpLiqFerJor = new boolean[] {false} ;
      BC000F53_A1787EmpLiqGan = new boolean[] {false} ;
      BC000F53_A1792EmpTipoExp = new byte[1] ;
      BC000F53_A1802EmpPromDesde = new String[] {""} ;
      BC000F53_A1813EmpFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F53_A1972EmpUltSexoIng = new byte[1] ;
      BC000F53_n1972EmpUltSexoIng = new boolean[] {false} ;
      BC000F53_A2405EmpModTra = new String[] {""} ;
      BC000F53_A957EmpLogoExt = new String[] {""} ;
      BC000F53_n957EmpLogoExt = new boolean[] {false} ;
      BC000F53_A960EmpFirmaExt = new String[] {""} ;
      BC000F53_n960EmpFirmaExt = new boolean[] {false} ;
      BC000F53_A956EmpLogoNom = new String[] {""} ;
      BC000F53_n956EmpLogoNom = new boolean[] {false} ;
      BC000F53_A959EmpFirmaNom = new String[] {""} ;
      BC000F53_n959EmpFirmaNom = new boolean[] {false} ;
      BC000F53_A46PaiCod = new short[1] ;
      BC000F53_n46PaiCod = new boolean[] {false} ;
      BC000F53_A47ProvCod = new short[1] ;
      BC000F53_n47ProvCod = new boolean[] {false} ;
      BC000F53_A48LocCod = new short[1] ;
      BC000F53_n48LocCod = new boolean[] {false} ;
      BC000F53_A3CliCod = new int[1] ;
      BC000F53_A43ActCodigo = new String[] {""} ;
      BC000F53_n43ActCodigo = new boolean[] {false} ;
      BC000F53_A45TipEmpleCod = new String[] {""} ;
      BC000F53_n45TipEmpleCod = new boolean[] {false} ;
      BC000F53_A1151ARTSec = new short[1] ;
      BC000F53_A903ActComCodigo = new String[] {""} ;
      BC000F53_A1965EmpOsoCod = new String[] {""} ;
      BC000F53_n1965EmpOsoCod = new boolean[] {false} ;
      BC000F53_A1533EmpActComercial = new String[] {""} ;
      BC000F53_A44EmpZonCod = new String[] {""} ;
      BC000F53_n44EmpZonCod = new boolean[] {false} ;
      BC000F53_A2265EmpCondiCod = new short[1] ;
      BC000F54_A1EmpCod = new short[1] ;
      BC000F54_A2EmpNom = new String[] {""} ;
      BC000F54_A177EmpCUIT = new long[1] ;
      BC000F54_A125CatIvaCod = new short[1] ;
      BC000F54_n125CatIvaCod = new boolean[] {false} ;
      BC000F54_A126CatIvaDesc = new String[] {""} ;
      BC000F54_n126CatIvaDesc = new boolean[] {false} ;
      BC000F54_A178EmpDir = new String[] {""} ;
      BC000F54_A180EmpTel = new String[] {""} ;
      BC000F54_n180EmpTel = new boolean[] {false} ;
      BC000F54_A176EmpCP = new String[] {""} ;
      BC000F54_n176EmpCP = new boolean[] {false} ;
      BC000F54_A532EmpReducc = new boolean[] {false} ;
      BC000F54_A955EmpLogo = new String[] {""} ;
      BC000F54_n955EmpLogo = new boolean[] {false} ;
      BC000F54_A958EmpFirma = new String[] {""} ;
      BC000F54_n958EmpFirma = new boolean[] {false} ;
      BC000F54_A1140EmpAntiguedad = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F54_A1141EmpPresentismo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F54_A1302EmpMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F54_n1302EmpMesHsPExt = new boolean[] {false} ;
      BC000F54_A1303EmpDiaHsPExt = new String[] {""} ;
      BC000F54_n1303EmpDiaHsPExt = new boolean[] {false} ;
      BC000F54_A1811EmpPerVacDes = new byte[1] ;
      BC000F54_A1812EmpPerVacHas = new byte[1] ;
      BC000F54_A1524EmpLiqFer = new boolean[] {false} ;
      BC000F54_A1556EmpGuarEdadMin = new byte[1] ;
      BC000F54_A1557EmpGuarEdadMax = new byte[1] ;
      BC000F54_A1750EmpLiqFerJor = new boolean[] {false} ;
      BC000F54_A1787EmpLiqGan = new boolean[] {false} ;
      BC000F54_A1792EmpTipoExp = new byte[1] ;
      BC000F54_A1802EmpPromDesde = new String[] {""} ;
      BC000F54_A1813EmpFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F54_A1972EmpUltSexoIng = new byte[1] ;
      BC000F54_n1972EmpUltSexoIng = new boolean[] {false} ;
      BC000F54_A2405EmpModTra = new String[] {""} ;
      BC000F54_A957EmpLogoExt = new String[] {""} ;
      BC000F54_n957EmpLogoExt = new boolean[] {false} ;
      BC000F54_A960EmpFirmaExt = new String[] {""} ;
      BC000F54_n960EmpFirmaExt = new boolean[] {false} ;
      BC000F54_A956EmpLogoNom = new String[] {""} ;
      BC000F54_n956EmpLogoNom = new boolean[] {false} ;
      BC000F54_A959EmpFirmaNom = new String[] {""} ;
      BC000F54_n959EmpFirmaNom = new boolean[] {false} ;
      BC000F54_A46PaiCod = new short[1] ;
      BC000F54_n46PaiCod = new boolean[] {false} ;
      BC000F54_A47ProvCod = new short[1] ;
      BC000F54_n47ProvCod = new boolean[] {false} ;
      BC000F54_A48LocCod = new short[1] ;
      BC000F54_n48LocCod = new boolean[] {false} ;
      BC000F54_A3CliCod = new int[1] ;
      BC000F54_A43ActCodigo = new String[] {""} ;
      BC000F54_n43ActCodigo = new boolean[] {false} ;
      BC000F54_A45TipEmpleCod = new String[] {""} ;
      BC000F54_n45TipEmpleCod = new boolean[] {false} ;
      BC000F54_A1151ARTSec = new short[1] ;
      BC000F54_A903ActComCodigo = new String[] {""} ;
      BC000F54_A1965EmpOsoCod = new String[] {""} ;
      BC000F54_n1965EmpOsoCod = new boolean[] {false} ;
      BC000F54_A1533EmpActComercial = new String[] {""} ;
      BC000F54_A44EmpZonCod = new String[] {""} ;
      BC000F54_n44EmpZonCod = new boolean[] {false} ;
      BC000F54_A2265EmpCondiCod = new short[1] ;
      BC000F60_A312PaiNom = new String[] {""} ;
      BC000F61_A322ProvNom = new String[] {""} ;
      BC000F62_A286LocNom = new String[] {""} ;
      BC000F63_A683ActDescripSinAc = new String[] {""} ;
      BC000F63_A108ActDescrip = new String[] {""} ;
      BC000F64_A530TipEmpleDefIns = new String[] {""} ;
      BC000F65_A518EmpZonDescrip = new String[] {""} ;
      BC000F66_A3CliCod = new int[1] ;
      BC000F66_A1EmpCod = new short[1] ;
      BC000F66_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000F67_A3CliCod = new int[1] ;
      BC000F67_A1EmpCod = new short[1] ;
      BC000F67_A2380ColaUUID = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000F68_A3CliCod = new int[1] ;
      BC000F68_A1EmpCod = new short[1] ;
      BC000F68_A2371LiqBatchLiqNro = new int[1] ;
      BC000F68_A2372LiqBatchCod = new String[] {""} ;
      BC000F68_A2373LiqBatchSeccion = new String[] {""} ;
      BC000F69_A3CliCod = new int[1] ;
      BC000F69_A1EmpCod = new short[1] ;
      BC000F69_A2370LiqLoteLiqNro = new int[1] ;
      BC000F69_A2269LiqLote = new String[] {""} ;
      BC000F70_A3CliCod = new int[1] ;
      BC000F70_A1EmpCod = new short[1] ;
      BC000F70_A31LiqNro = new int[1] ;
      BC000F70_A2285LinkLegNumero = new int[1] ;
      BC000F70_A2277LegLinkTiporec = new String[] {""} ;
      BC000F71_A3CliCod = new int[1] ;
      BC000F71_A1EmpCod = new short[1] ;
      BC000F71_A31LiqNro = new int[1] ;
      BC000F71_A2183LiqSuc = new String[] {""} ;
      BC000F72_A3CliCod = new int[1] ;
      BC000F72_A1EmpCod = new short[1] ;
      BC000F72_A31LiqNro = new int[1] ;
      BC000F72_A2145LiqArea = new String[] {""} ;
      BC000F73_A3CliCod = new int[1] ;
      BC000F73_A1EmpCod = new short[1] ;
      BC000F73_A31LiqNro = new int[1] ;
      BC000F73_A2142LiqPaiConve = new short[1] ;
      BC000F73_A2143LiqConvenio = new String[] {""} ;
      BC000F74_A3CliCod = new int[1] ;
      BC000F74_A1EmpCod = new short[1] ;
      BC000F74_A1966EmpBanCod = new String[] {""} ;
      BC000F75_A3CliCod = new int[1] ;
      BC000F75_A1EmpCod = new short[1] ;
      BC000F75_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      BC000F76_A3CliCod = new int[1] ;
      BC000F76_A1EmpCod = new short[1] ;
      BC000F76_A1649LSDSec = new int[1] ;
      BC000F77_A3CliCod = new int[1] ;
      BC000F77_A1EmpCod = new short[1] ;
      BC000F77_A1562EmpConvePai = new short[1] ;
      BC000F77_A1561EmpConveCod = new String[] {""} ;
      BC000F78_A3CliCod = new int[1] ;
      BC000F78_A1EmpCod = new short[1] ;
      BC000F78_A1562EmpConvePai = new short[1] ;
      BC000F78_A1561EmpConveCod = new String[] {""} ;
      BC000F79_A3CliCod = new int[1] ;
      BC000F79_A1EmpCod = new short[1] ;
      BC000F79_A1562EmpConvePai = new short[1] ;
      BC000F79_A1561EmpConveCod = new String[] {""} ;
      BC000F80_A3CliCod = new int[1] ;
      BC000F80_A1EmpCod = new short[1] ;
      BC000F80_A1562EmpConvePai = new short[1] ;
      BC000F80_A1561EmpConveCod = new String[] {""} ;
      BC000F81_A3CliCod = new int[1] ;
      BC000F81_A1EmpCod = new short[1] ;
      BC000F81_A1562EmpConvePai = new short[1] ;
      BC000F81_A1561EmpConveCod = new String[] {""} ;
      BC000F82_A3CliCod = new int[1] ;
      BC000F82_A1EmpCod = new short[1] ;
      BC000F82_A1562EmpConvePai = new short[1] ;
      BC000F82_A1561EmpConveCod = new String[] {""} ;
      BC000F83_A3CliCod = new int[1] ;
      BC000F83_A1EmpCod = new short[1] ;
      BC000F83_A1562EmpConvePai = new short[1] ;
      BC000F83_A1561EmpConveCod = new String[] {""} ;
      BC000F84_A3CliCod = new int[1] ;
      BC000F84_A1EmpCod = new short[1] ;
      BC000F84_A1562EmpConvePai = new short[1] ;
      BC000F84_A1561EmpConveCod = new String[] {""} ;
      BC000F85_A3CliCod = new int[1] ;
      BC000F85_A1EmpCod = new short[1] ;
      BC000F85_A1562EmpConvePai = new short[1] ;
      BC000F85_A1561EmpConveCod = new String[] {""} ;
      BC000F86_A3CliCod = new int[1] ;
      BC000F86_A1EmpCod = new short[1] ;
      BC000F86_A1562EmpConvePai = new short[1] ;
      BC000F86_A1561EmpConveCod = new String[] {""} ;
      BC000F87_A3CliCod = new int[1] ;
      BC000F87_A1EmpCod = new short[1] ;
      BC000F87_A1562EmpConvePai = new short[1] ;
      BC000F87_A1561EmpConveCod = new String[] {""} ;
      BC000F88_A3CliCod = new int[1] ;
      BC000F88_A1EmpCod = new short[1] ;
      BC000F88_A1562EmpConvePai = new short[1] ;
      BC000F88_A1561EmpConveCod = new String[] {""} ;
      BC000F89_A3CliCod = new int[1] ;
      BC000F89_A1EmpCod = new short[1] ;
      BC000F89_A1562EmpConvePai = new short[1] ;
      BC000F89_A1561EmpConveCod = new String[] {""} ;
      BC000F90_A3CliCod = new int[1] ;
      BC000F90_A1EmpCod = new short[1] ;
      BC000F90_A1562EmpConvePai = new short[1] ;
      BC000F90_A1561EmpConveCod = new String[] {""} ;
      BC000F91_A3CliCod = new int[1] ;
      BC000F91_A1EmpCod = new short[1] ;
      BC000F91_A1562EmpConvePai = new short[1] ;
      BC000F91_A1561EmpConveCod = new String[] {""} ;
      BC000F92_A3CliCod = new int[1] ;
      BC000F92_A1EmpCod = new short[1] ;
      BC000F92_A1562EmpConvePai = new short[1] ;
      BC000F92_A1561EmpConveCod = new String[] {""} ;
      BC000F93_A3CliCod = new int[1] ;
      BC000F93_A1EmpCod = new short[1] ;
      BC000F93_A1562EmpConvePai = new short[1] ;
      BC000F93_A1561EmpConveCod = new String[] {""} ;
      BC000F94_A3CliCod = new int[1] ;
      BC000F94_A1EmpCod = new short[1] ;
      BC000F94_A1562EmpConvePai = new short[1] ;
      BC000F94_A1561EmpConveCod = new String[] {""} ;
      BC000F95_A3CliCod = new int[1] ;
      BC000F95_A1EmpCod = new short[1] ;
      BC000F95_A1562EmpConvePai = new short[1] ;
      BC000F95_A1561EmpConveCod = new String[] {""} ;
      BC000F96_A3CliCod = new int[1] ;
      BC000F96_A1EmpCod = new short[1] ;
      BC000F96_A1562EmpConvePai = new short[1] ;
      BC000F96_A1561EmpConveCod = new String[] {""} ;
      BC000F97_A3CliCod = new int[1] ;
      BC000F97_A1EmpCod = new short[1] ;
      BC000F97_A1562EmpConvePai = new short[1] ;
      BC000F97_A1561EmpConveCod = new String[] {""} ;
      BC000F98_A3CliCod = new int[1] ;
      BC000F98_A1EmpCod = new short[1] ;
      BC000F98_A1562EmpConvePai = new short[1] ;
      BC000F98_A1561EmpConveCod = new String[] {""} ;
      BC000F99_A3CliCod = new int[1] ;
      BC000F99_A1EmpCod = new short[1] ;
      BC000F99_A1562EmpConvePai = new short[1] ;
      BC000F99_A1561EmpConveCod = new String[] {""} ;
      BC000F100_A3CliCod = new int[1] ;
      BC000F100_A1EmpCod = new short[1] ;
      BC000F100_A1562EmpConvePai = new short[1] ;
      BC000F100_A1561EmpConveCod = new String[] {""} ;
      BC000F101_A3CliCod = new int[1] ;
      BC000F101_A1EmpCod = new short[1] ;
      BC000F101_A1562EmpConvePai = new short[1] ;
      BC000F101_A1561EmpConveCod = new String[] {""} ;
      BC000F102_A3CliCod = new int[1] ;
      BC000F102_A1EmpCod = new short[1] ;
      BC000F102_A1562EmpConvePai = new short[1] ;
      BC000F102_A1561EmpConveCod = new String[] {""} ;
      BC000F103_A3CliCod = new int[1] ;
      BC000F103_A1EmpCod = new short[1] ;
      BC000F103_A1562EmpConvePai = new short[1] ;
      BC000F103_A1561EmpConveCod = new String[] {""} ;
      BC000F104_A3CliCod = new int[1] ;
      BC000F104_A1EmpCod = new short[1] ;
      BC000F104_A1562EmpConvePai = new short[1] ;
      BC000F104_A1561EmpConveCod = new String[] {""} ;
      BC000F105_A3CliCod = new int[1] ;
      BC000F105_A1EmpCod = new short[1] ;
      BC000F105_A1562EmpConvePai = new short[1] ;
      BC000F105_A1561EmpConveCod = new String[] {""} ;
      BC000F106_A3CliCod = new int[1] ;
      BC000F106_A1EmpCod = new short[1] ;
      BC000F106_A1562EmpConvePai = new short[1] ;
      BC000F106_A1561EmpConveCod = new String[] {""} ;
      BC000F107_A3CliCod = new int[1] ;
      BC000F107_A1EmpCod = new short[1] ;
      BC000F107_A1562EmpConvePai = new short[1] ;
      BC000F107_A1561EmpConveCod = new String[] {""} ;
      BC000F108_A3CliCod = new int[1] ;
      BC000F108_A1EmpCod = new short[1] ;
      BC000F108_A1562EmpConvePai = new short[1] ;
      BC000F108_A1561EmpConveCod = new String[] {""} ;
      BC000F109_A3CliCod = new int[1] ;
      BC000F109_A1EmpCod = new short[1] ;
      BC000F109_A1562EmpConvePai = new short[1] ;
      BC000F109_A1561EmpConveCod = new String[] {""} ;
      BC000F110_A3CliCod = new int[1] ;
      BC000F110_A1EmpCod = new short[1] ;
      BC000F110_A1562EmpConvePai = new short[1] ;
      BC000F110_A1561EmpConveCod = new String[] {""} ;
      BC000F111_A3CliCod = new int[1] ;
      BC000F111_A1EmpCod = new short[1] ;
      BC000F111_A1562EmpConvePai = new short[1] ;
      BC000F111_A1561EmpConveCod = new String[] {""} ;
      BC000F112_A3CliCod = new int[1] ;
      BC000F112_A1EmpCod = new short[1] ;
      BC000F112_A1562EmpConvePai = new short[1] ;
      BC000F112_A1561EmpConveCod = new String[] {""} ;
      BC000F113_A3CliCod = new int[1] ;
      BC000F113_A1EmpCod = new short[1] ;
      BC000F113_A1562EmpConvePai = new short[1] ;
      BC000F113_A1561EmpConveCod = new String[] {""} ;
      BC000F114_A3CliCod = new int[1] ;
      BC000F114_A1EmpCod = new short[1] ;
      BC000F114_A1562EmpConvePai = new short[1] ;
      BC000F114_A1561EmpConveCod = new String[] {""} ;
      BC000F115_A3CliCod = new int[1] ;
      BC000F115_A1EmpCod = new short[1] ;
      BC000F115_A1562EmpConvePai = new short[1] ;
      BC000F115_A1561EmpConveCod = new String[] {""} ;
      BC000F116_A3CliCod = new int[1] ;
      BC000F116_A1EmpCod = new short[1] ;
      BC000F116_A1562EmpConvePai = new short[1] ;
      BC000F116_A1561EmpConveCod = new String[] {""} ;
      BC000F117_A3CliCod = new int[1] ;
      BC000F117_A1EmpCod = new short[1] ;
      BC000F117_A1562EmpConvePai = new short[1] ;
      BC000F117_A1561EmpConveCod = new String[] {""} ;
      BC000F118_A3CliCod = new int[1] ;
      BC000F118_A1EmpCod = new short[1] ;
      BC000F118_A1562EmpConvePai = new short[1] ;
      BC000F118_A1561EmpConveCod = new String[] {""} ;
      BC000F119_A3CliCod = new int[1] ;
      BC000F119_A1EmpCod = new short[1] ;
      BC000F119_A1562EmpConvePai = new short[1] ;
      BC000F119_A1561EmpConveCod = new String[] {""} ;
      BC000F120_A3CliCod = new int[1] ;
      BC000F120_A1EmpCod = new short[1] ;
      BC000F120_A1562EmpConvePai = new short[1] ;
      BC000F120_A1561EmpConveCod = new String[] {""} ;
      BC000F121_A3CliCod = new int[1] ;
      BC000F121_A1EmpCod = new short[1] ;
      BC000F121_A1562EmpConvePai = new short[1] ;
      BC000F121_A1561EmpConveCod = new String[] {""} ;
      BC000F122_A3CliCod = new int[1] ;
      BC000F122_A1EmpCod = new short[1] ;
      BC000F122_A1562EmpConvePai = new short[1] ;
      BC000F122_A1561EmpConveCod = new String[] {""} ;
      BC000F123_A3CliCod = new int[1] ;
      BC000F123_A1EmpCod = new short[1] ;
      BC000F123_A1562EmpConvePai = new short[1] ;
      BC000F123_A1561EmpConveCod = new String[] {""} ;
      BC000F124_A3CliCod = new int[1] ;
      BC000F124_A1EmpCod = new short[1] ;
      BC000F124_A1562EmpConvePai = new short[1] ;
      BC000F124_A1561EmpConveCod = new String[] {""} ;
      BC000F125_A3CliCod = new int[1] ;
      BC000F125_A1EmpCod = new short[1] ;
      BC000F125_A1562EmpConvePai = new short[1] ;
      BC000F125_A1561EmpConveCod = new String[] {""} ;
      BC000F126_A3CliCod = new int[1] ;
      BC000F126_A1EmpCod = new short[1] ;
      BC000F126_A1562EmpConvePai = new short[1] ;
      BC000F126_A1561EmpConveCod = new String[] {""} ;
      BC000F127_A3CliCod = new int[1] ;
      BC000F127_A1EmpCod = new short[1] ;
      BC000F127_A1562EmpConvePai = new short[1] ;
      BC000F127_A1561EmpConveCod = new String[] {""} ;
      BC000F128_A3CliCod = new int[1] ;
      BC000F128_A1EmpCod = new short[1] ;
      BC000F128_A1562EmpConvePai = new short[1] ;
      BC000F128_A1561EmpConveCod = new String[] {""} ;
      BC000F129_A3CliCod = new int[1] ;
      BC000F129_A1EmpCod = new short[1] ;
      BC000F129_A1562EmpConvePai = new short[1] ;
      BC000F129_A1561EmpConveCod = new String[] {""} ;
      BC000F130_A3CliCod = new int[1] ;
      BC000F130_A1EmpCod = new short[1] ;
      BC000F130_A1562EmpConvePai = new short[1] ;
      BC000F130_A1561EmpConveCod = new String[] {""} ;
      BC000F131_A3CliCod = new int[1] ;
      BC000F131_A1EmpCod = new short[1] ;
      BC000F131_A1562EmpConvePai = new short[1] ;
      BC000F131_A1561EmpConveCod = new String[] {""} ;
      BC000F132_A3CliCod = new int[1] ;
      BC000F132_A1EmpCod = new short[1] ;
      BC000F132_A1562EmpConvePai = new short[1] ;
      BC000F132_A1561EmpConveCod = new String[] {""} ;
      BC000F133_A3CliCod = new int[1] ;
      BC000F133_A1EmpCod = new short[1] ;
      BC000F133_A1547GuarCod = new short[1] ;
      BC000F134_A3CliCod = new int[1] ;
      BC000F134_A1EmpCod = new short[1] ;
      BC000F134_A1427EmpBaseClaseLeg = new byte[1] ;
      BC000F134_A1429EmpBaseTipo = new String[] {""} ;
      BC000F134_A1430EmpBaseCod1 = new String[] {""} ;
      BC000F134_A1431EmpBaseCod2 = new String[] {""} ;
      BC000F135_A3CliCod = new int[1] ;
      BC000F135_A1EmpCod = new short[1] ;
      BC000F135_A1340EmpHsExSec = new short[1] ;
      BC000F136_A3CliCod = new int[1] ;
      BC000F136_A1EmpCod = new short[1] ;
      BC000F136_A1243SucCodigo = new String[] {""} ;
      BC000F137_A3CliCod = new int[1] ;
      BC000F137_A1EmpCod = new short[1] ;
      BC000F137_A784F1357CTipoPre = new byte[1] ;
      BC000F137_A777F1357CPer = new String[] {""} ;
      BC000F137_A778F1357CSec = new byte[1] ;
      BC000F138_A3CliCod = new int[1] ;
      BC000F138_A1EmpCod = new short[1] ;
      BC000F138_A88ImpLiqSec = new short[1] ;
      BC000F139_A3CliCod = new int[1] ;
      BC000F139_A1EmpCod = new short[1] ;
      BC000F139_A87MigrLegNumero = new int[1] ;
      BC000F140_A3CliCod = new int[1] ;
      BC000F140_A1EmpCod = new short[1] ;
      BC000F140_A86TempRecSec = new short[1] ;
      BC000F141_A3CliCod = new int[1] ;
      BC000F141_A1EmpCod = new short[1] ;
      BC000F141_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC000F142_A3CliCod = new int[1] ;
      BC000F142_A1EmpCod = new short[1] ;
      BC000F142_A79AsientoCNum = new int[1] ;
      BC000F143_A3CliCod = new int[1] ;
      BC000F143_A1EmpCod = new short[1] ;
      BC000F143_A78CuenCodigo = new String[] {""} ;
      BC000F144_A3CliCod = new int[1] ;
      BC000F144_A1EmpCod = new short[1] ;
      BC000F144_A77CenCodigo = new short[1] ;
      BC000F145_A3CliCod = new int[1] ;
      BC000F145_A1EmpCod = new short[1] ;
      BC000F145_A31LiqNro = new int[1] ;
      BC000F145_A10LpgCodigo = new String[] {""} ;
      BC000F146_A3CliCod = new int[1] ;
      BC000F146_A1EmpCod = new short[1] ;
      BC000F146_A6LegNumero = new int[1] ;
      BC000F147_A683ActDescripSinAc = new String[] {""} ;
      BC000F147_A1EmpCod = new short[1] ;
      BC000F147_A2EmpNom = new String[] {""} ;
      BC000F147_A177EmpCUIT = new long[1] ;
      BC000F147_A125CatIvaCod = new short[1] ;
      BC000F147_n125CatIvaCod = new boolean[] {false} ;
      BC000F147_A126CatIvaDesc = new String[] {""} ;
      BC000F147_n126CatIvaDesc = new boolean[] {false} ;
      BC000F147_A178EmpDir = new String[] {""} ;
      BC000F147_A180EmpTel = new String[] {""} ;
      BC000F147_n180EmpTel = new boolean[] {false} ;
      BC000F147_A176EmpCP = new String[] {""} ;
      BC000F147_n176EmpCP = new boolean[] {false} ;
      BC000F147_A312PaiNom = new String[] {""} ;
      BC000F147_A322ProvNom = new String[] {""} ;
      BC000F147_A286LocNom = new String[] {""} ;
      BC000F147_A108ActDescrip = new String[] {""} ;
      BC000F147_A518EmpZonDescrip = new String[] {""} ;
      BC000F147_A532EmpReducc = new boolean[] {false} ;
      BC000F147_A530TipEmpleDefIns = new String[] {""} ;
      BC000F147_A955EmpLogo = new String[] {""} ;
      BC000F147_n955EmpLogo = new boolean[] {false} ;
      BC000F147_A958EmpFirma = new String[] {""} ;
      BC000F147_n958EmpFirma = new boolean[] {false} ;
      BC000F147_A1140EmpAntiguedad = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F147_A1141EmpPresentismo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F147_A1302EmpMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F147_n1302EmpMesHsPExt = new boolean[] {false} ;
      BC000F147_A1303EmpDiaHsPExt = new String[] {""} ;
      BC000F147_n1303EmpDiaHsPExt = new boolean[] {false} ;
      BC000F147_A1811EmpPerVacDes = new byte[1] ;
      BC000F147_A1812EmpPerVacHas = new byte[1] ;
      BC000F147_A1524EmpLiqFer = new boolean[] {false} ;
      BC000F147_A1556EmpGuarEdadMin = new byte[1] ;
      BC000F147_A1557EmpGuarEdadMax = new byte[1] ;
      BC000F147_A1750EmpLiqFerJor = new boolean[] {false} ;
      BC000F147_A1787EmpLiqGan = new boolean[] {false} ;
      BC000F147_A1792EmpTipoExp = new byte[1] ;
      BC000F147_A1802EmpPromDesde = new String[] {""} ;
      BC000F147_A1813EmpFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F147_A1972EmpUltSexoIng = new byte[1] ;
      BC000F147_n1972EmpUltSexoIng = new boolean[] {false} ;
      BC000F147_A2405EmpModTra = new String[] {""} ;
      BC000F147_A957EmpLogoExt = new String[] {""} ;
      BC000F147_n957EmpLogoExt = new boolean[] {false} ;
      BC000F147_A960EmpFirmaExt = new String[] {""} ;
      BC000F147_n960EmpFirmaExt = new boolean[] {false} ;
      BC000F147_A956EmpLogoNom = new String[] {""} ;
      BC000F147_n956EmpLogoNom = new boolean[] {false} ;
      BC000F147_A959EmpFirmaNom = new String[] {""} ;
      BC000F147_n959EmpFirmaNom = new boolean[] {false} ;
      BC000F147_A46PaiCod = new short[1] ;
      BC000F147_n46PaiCod = new boolean[] {false} ;
      BC000F147_A47ProvCod = new short[1] ;
      BC000F147_n47ProvCod = new boolean[] {false} ;
      BC000F147_A48LocCod = new short[1] ;
      BC000F147_n48LocCod = new boolean[] {false} ;
      BC000F147_A3CliCod = new int[1] ;
      BC000F147_A43ActCodigo = new String[] {""} ;
      BC000F147_n43ActCodigo = new boolean[] {false} ;
      BC000F147_A45TipEmpleCod = new String[] {""} ;
      BC000F147_n45TipEmpleCod = new boolean[] {false} ;
      BC000F147_A1151ARTSec = new short[1] ;
      BC000F147_A903ActComCodigo = new String[] {""} ;
      BC000F147_A1965EmpOsoCod = new String[] {""} ;
      BC000F147_n1965EmpOsoCod = new boolean[] {false} ;
      BC000F147_A1533EmpActComercial = new String[] {""} ;
      BC000F147_A44EmpZonCod = new String[] {""} ;
      BC000F147_n44EmpZonCod = new boolean[] {false} ;
      BC000F147_A2265EmpCondiCod = new short[1] ;
      GXv_int10 = new short[1] ;
      Z1366EmpJorConCodigo = "" ;
      A1366EmpJorConCodigo = "" ;
      BC000F148_A1369EmpJorHabitual = new boolean[] {false} ;
      BC000F148_A3CliCod = new int[1] ;
      BC000F148_A1366EmpJorConCodigo = new String[] {""} ;
      BC000F148_A1EmpCod = new short[1] ;
      BC000F149_A26ConCodigo = new String[] {""} ;
      BC000F150_A3CliCod = new int[1] ;
      BC000F150_A1EmpCod = new short[1] ;
      BC000F150_A1366EmpJorConCodigo = new String[] {""} ;
      BC000F151_A1369EmpJorHabitual = new boolean[] {false} ;
      BC000F151_A3CliCod = new int[1] ;
      BC000F151_A1366EmpJorConCodigo = new String[] {""} ;
      BC000F151_A1EmpCod = new short[1] ;
      sMode172 = "" ;
      BC000F152_A1369EmpJorHabitual = new boolean[] {false} ;
      BC000F152_A3CliCod = new int[1] ;
      BC000F152_A1366EmpJorConCodigo = new String[] {""} ;
      BC000F152_A1EmpCod = new short[1] ;
      BC000F156_A1369EmpJorHabitual = new boolean[] {false} ;
      BC000F156_A3CliCod = new int[1] ;
      BC000F156_A1366EmpJorConCodigo = new String[] {""} ;
      BC000F156_A1EmpCod = new short[1] ;
      Z1368EmpMenConCodigo = "" ;
      A1368EmpMenConCodigo = "" ;
      BC000F157_A1370EmpMenHabitual = new boolean[] {false} ;
      BC000F157_A3CliCod = new int[1] ;
      BC000F157_A1368EmpMenConCodigo = new String[] {""} ;
      BC000F157_A1EmpCod = new short[1] ;
      BC000F158_A26ConCodigo = new String[] {""} ;
      BC000F159_A3CliCod = new int[1] ;
      BC000F159_A1EmpCod = new short[1] ;
      BC000F159_A1368EmpMenConCodigo = new String[] {""} ;
      BC000F160_A1370EmpMenHabitual = new boolean[] {false} ;
      BC000F160_A3CliCod = new int[1] ;
      BC000F160_A1368EmpMenConCodigo = new String[] {""} ;
      BC000F160_A1EmpCod = new short[1] ;
      sMode171 = "" ;
      BC000F161_A1370EmpMenHabitual = new boolean[] {false} ;
      BC000F161_A3CliCod = new int[1] ;
      BC000F161_A1368EmpMenConCodigo = new String[] {""} ;
      BC000F161_A1EmpCod = new short[1] ;
      BC000F165_A1370EmpMenHabitual = new boolean[] {false} ;
      BC000F165_A3CliCod = new int[1] ;
      BC000F165_A1368EmpMenConCodigo = new String[] {""} ;
      BC000F165_A1EmpCod = new short[1] ;
      Z1371EmpPromFijVar = "" ;
      A1371EmpPromFijVar = "" ;
      Z37TipoConCod = "" ;
      A37TipoConCod = "" ;
      BC000F166_A3CliCod = new int[1] ;
      BC000F166_A1EmpCod = new short[1] ;
      BC000F166_A1371EmpPromFijVar = new String[] {""} ;
      BC000F166_A1372EmpPromHabitual = new boolean[] {false} ;
      BC000F166_A37TipoConCod = new String[] {""} ;
      BC000F167_A37TipoConCod = new String[] {""} ;
      BC000F168_A3CliCod = new int[1] ;
      BC000F168_A1EmpCod = new short[1] ;
      BC000F168_A37TipoConCod = new String[] {""} ;
      BC000F168_A1371EmpPromFijVar = new String[] {""} ;
      BC000F169_A3CliCod = new int[1] ;
      BC000F169_A1EmpCod = new short[1] ;
      BC000F169_A1371EmpPromFijVar = new String[] {""} ;
      BC000F169_A1372EmpPromHabitual = new boolean[] {false} ;
      BC000F169_A37TipoConCod = new String[] {""} ;
      sMode173 = "" ;
      BC000F170_A3CliCod = new int[1] ;
      BC000F170_A1EmpCod = new short[1] ;
      BC000F170_A1371EmpPromFijVar = new String[] {""} ;
      BC000F170_A1372EmpPromHabitual = new boolean[] {false} ;
      BC000F170_A37TipoConCod = new String[] {""} ;
      BC000F174_A3CliCod = new int[1] ;
      BC000F174_A1EmpCod = new short[1] ;
      BC000F174_A1371EmpPromFijVar = new String[] {""} ;
      BC000F174_A1372EmpPromHabitual = new boolean[] {false} ;
      BC000F174_A37TipoConCod = new String[] {""} ;
      Z1342EmpHsPDiaDesde = "" ;
      A1342EmpHsPDiaDesde = "" ;
      Z1343EmpTarifaPDia = DecimalUtil.ZERO ;
      A1343EmpTarifaPDia = DecimalUtil.ZERO ;
      Z1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      A1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      Z1339EmpHsPDiaTipTra = "" ;
      A1339EmpHsPDiaTipTra = "" ;
      BC000F175_A1340EmpHsExSec = new short[1] ;
      BC000F175_A1341EmpHsPDiaDia = new byte[1] ;
      BC000F175_A1342EmpHsPDiaDesde = new String[] {""} ;
      BC000F175_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      BC000F175_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F175_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F175_A3CliCod = new int[1] ;
      BC000F175_A1EmpCod = new short[1] ;
      BC000F175_A1339EmpHsPDiaTipTra = new String[] {""} ;
      BC000F176_A1294PaiTipoTraId = new String[] {""} ;
      BC000F177_A3CliCod = new int[1] ;
      BC000F177_A1EmpCod = new short[1] ;
      BC000F177_A1340EmpHsExSec = new short[1] ;
      BC000F178_A1340EmpHsExSec = new short[1] ;
      BC000F178_A1341EmpHsPDiaDia = new byte[1] ;
      BC000F178_A1342EmpHsPDiaDesde = new String[] {""} ;
      BC000F178_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      BC000F178_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F178_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F178_A3CliCod = new int[1] ;
      BC000F178_A1EmpCod = new short[1] ;
      BC000F178_A1339EmpHsPDiaTipTra = new String[] {""} ;
      sMode165 = "" ;
      BC000F179_A1340EmpHsExSec = new short[1] ;
      BC000F179_A1341EmpHsPDiaDia = new byte[1] ;
      BC000F179_A1342EmpHsPDiaDesde = new String[] {""} ;
      BC000F179_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      BC000F179_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F179_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F179_A3CliCod = new int[1] ;
      BC000F179_A1EmpCod = new short[1] ;
      BC000F179_A1339EmpHsPDiaTipTra = new String[] {""} ;
      BC000F183_A1340EmpHsExSec = new short[1] ;
      BC000F183_A1341EmpHsPDiaDia = new byte[1] ;
      BC000F183_A1342EmpHsPDiaDesde = new String[] {""} ;
      BC000F183_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      BC000F183_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F183_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F183_A3CliCod = new int[1] ;
      BC000F183_A1EmpCod = new short[1] ;
      BC000F183_A1339EmpHsPDiaTipTra = new String[] {""} ;
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
      BC000F184_A3CliCod = new int[1] ;
      BC000F184_A1EmpCod = new short[1] ;
      BC000F184_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F184_A1345EmpHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F184_A1346EmpTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F184_A1352EmpTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F184_A1386EmpHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F184_A1387EmpHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F184_A1388EmpHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F184_A1389EmpHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F184_A1294PaiTipoTraId = new String[] {""} ;
      BC000F185_A1292TipoTraId = new String[] {""} ;
      BC000F186_A3CliCod = new int[1] ;
      BC000F186_A1EmpCod = new short[1] ;
      BC000F186_A1294PaiTipoTraId = new String[] {""} ;
      BC000F187_A3CliCod = new int[1] ;
      BC000F187_A1EmpCod = new short[1] ;
      BC000F187_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F187_A1345EmpHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F187_A1346EmpTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F187_A1352EmpTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F187_A1386EmpHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F187_A1387EmpHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F187_A1388EmpHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F187_A1389EmpHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F187_A1294PaiTipoTraId = new String[] {""} ;
      sMode166 = "" ;
      BC000F188_A3CliCod = new int[1] ;
      BC000F188_A1EmpCod = new short[1] ;
      BC000F188_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F188_A1345EmpHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F188_A1346EmpTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F188_A1352EmpTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F188_A1386EmpHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F188_A1387EmpHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F188_A1388EmpHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F188_A1389EmpHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F188_A1294PaiTipoTraId = new String[] {""} ;
      BC000F192_A3CliCod = new int[1] ;
      BC000F192_A1EmpCod = new short[1] ;
      BC000F192_A1340EmpHsExSec = new short[1] ;
      BC000F193_A3CliCod = new int[1] ;
      BC000F193_A1EmpCod = new short[1] ;
      BC000F193_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F193_A1345EmpHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F193_A1346EmpTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F193_A1352EmpTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F193_A1386EmpHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F193_A1387EmpHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F193_A1388EmpHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F193_A1389EmpHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000F193_A1294PaiTipoTraId = new String[] {""} ;
      Z1239EmpConvenio = "" ;
      A1239EmpConvenio = "" ;
      BC000F194_A3CliCod = new int[1] ;
      BC000F194_A1EmpCod = new short[1] ;
      BC000F194_A1239EmpConvenio = new String[] {""} ;
      BC000F195_A3CliCod = new int[1] ;
      BC000F195_A1EmpCod = new short[1] ;
      BC000F195_A1239EmpConvenio = new String[] {""} ;
      BC000F196_A3CliCod = new int[1] ;
      BC000F196_A1EmpCod = new short[1] ;
      BC000F196_A1239EmpConvenio = new String[] {""} ;
      sMode144 = "" ;
      BC000F197_A3CliCod = new int[1] ;
      BC000F197_A1EmpCod = new short[1] ;
      BC000F197_A1239EmpConvenio = new String[] {""} ;
      BC000F200_A3CliCod = new int[1] ;
      BC000F200_A1EmpCod = new short[1] ;
      BC000F200_A1239EmpConvenio = new String[] {""} ;
      Z1238EmpOrigen = "" ;
      A1238EmpOrigen = "" ;
      BC000F201_A3CliCod = new int[1] ;
      BC000F201_A1EmpCod = new short[1] ;
      BC000F201_A1238EmpOrigen = new String[] {""} ;
      BC000F202_A1231OrigId = new String[] {""} ;
      BC000F203_A3CliCod = new int[1] ;
      BC000F203_A1EmpCod = new short[1] ;
      BC000F203_A1238EmpOrigen = new String[] {""} ;
      BC000F204_A3CliCod = new int[1] ;
      BC000F204_A1EmpCod = new short[1] ;
      BC000F204_A1238EmpOrigen = new String[] {""} ;
      sMode145 = "" ;
      BC000F205_A3CliCod = new int[1] ;
      BC000F205_A1EmpCod = new short[1] ;
      BC000F205_A1238EmpOrigen = new String[] {""} ;
      BC000F208_A3CliCod = new int[1] ;
      BC000F208_A1EmpCod = new short[1] ;
      BC000F208_A1238EmpOrigen = new String[] {""} ;
      Z1237EmpReligion = "" ;
      A1237EmpReligion = "" ;
      BC000F209_A3CliCod = new int[1] ;
      BC000F209_A1EmpCod = new short[1] ;
      BC000F209_A1237EmpReligion = new String[] {""} ;
      BC000F210_A1229ReligId = new String[] {""} ;
      BC000F211_A3CliCod = new int[1] ;
      BC000F211_A1EmpCod = new short[1] ;
      BC000F211_A1237EmpReligion = new String[] {""} ;
      BC000F212_A3CliCod = new int[1] ;
      BC000F212_A1EmpCod = new short[1] ;
      BC000F212_A1237EmpReligion = new String[] {""} ;
      sMode146 = "" ;
      BC000F213_A3CliCod = new int[1] ;
      BC000F213_A1EmpCod = new short[1] ;
      BC000F213_A1237EmpReligion = new String[] {""} ;
      BC000F216_A3CliCod = new int[1] ;
      BC000F216_A1EmpCod = new short[1] ;
      BC000F216_A1237EmpReligion = new String[] {""} ;
      A26ConCodigo = "" ;
      A1292TipoTraId = "" ;
      A1231OrigId = "" ;
      A1229ReligId = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000F217_A3CliCod = new int[1] ;
      BC000F218_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresa_bc__default(),
         new Object[] {
             new Object[] {
            BC000F2_A3CliCod, BC000F2_A1EmpCod, BC000F2_A1237EmpReligion
            }
            , new Object[] {
            BC000F3_A3CliCod, BC000F3_A1EmpCod, BC000F3_A1237EmpReligion
            }
            , new Object[] {
            BC000F4_A1229ReligId
            }
            , new Object[] {
            BC000F5_A3CliCod, BC000F5_A1EmpCod, BC000F5_A1238EmpOrigen
            }
            , new Object[] {
            BC000F6_A3CliCod, BC000F6_A1EmpCod, BC000F6_A1238EmpOrigen
            }
            , new Object[] {
            BC000F7_A1231OrigId
            }
            , new Object[] {
            BC000F8_A3CliCod, BC000F8_A1EmpCod, BC000F8_A1239EmpConvenio
            }
            , new Object[] {
            BC000F9_A3CliCod, BC000F9_A1EmpCod, BC000F9_A1239EmpConvenio
            }
            , new Object[] {
            BC000F10_A3CliCod, BC000F10_A1EmpCod, BC000F10_A1344EmpHsDia, BC000F10_A1345EmpHsSem, BC000F10_A1346EmpTarifaXLim, BC000F10_A1352EmpTarifaRec, BC000F10_A1386EmpHsMaxDia, BC000F10_A1387EmpHsMaxSem, BC000F10_A1388EmpHsMaxMes, BC000F10_A1389EmpHsMaxAnu,
            BC000F10_A1294PaiTipoTraId
            }
            , new Object[] {
            BC000F11_A3CliCod, BC000F11_A1EmpCod, BC000F11_A1344EmpHsDia, BC000F11_A1345EmpHsSem, BC000F11_A1346EmpTarifaXLim, BC000F11_A1352EmpTarifaRec, BC000F11_A1386EmpHsMaxDia, BC000F11_A1387EmpHsMaxSem, BC000F11_A1388EmpHsMaxMes, BC000F11_A1389EmpHsMaxAnu,
            BC000F11_A1294PaiTipoTraId
            }
            , new Object[] {
            BC000F12_A1292TipoTraId
            }
            , new Object[] {
            BC000F13_A1340EmpHsExSec, BC000F13_A1341EmpHsPDiaDia, BC000F13_A1342EmpHsPDiaDesde, BC000F13_n1342EmpHsPDiaDesde, BC000F13_A1343EmpTarifaPDia, BC000F13_A1351EmpTarfaPDRec, BC000F13_A3CliCod, BC000F13_A1EmpCod, BC000F13_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            BC000F14_A1340EmpHsExSec, BC000F14_A1341EmpHsPDiaDia, BC000F14_A1342EmpHsPDiaDesde, BC000F14_n1342EmpHsPDiaDesde, BC000F14_A1343EmpTarifaPDia, BC000F14_A1351EmpTarfaPDRec, BC000F14_A3CliCod, BC000F14_A1EmpCod, BC000F14_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            BC000F15_A3CliCod, BC000F15_A1EmpCod, BC000F15_A1344EmpHsDia, BC000F15_A1345EmpHsSem, BC000F15_A1346EmpTarifaXLim, BC000F15_A1352EmpTarifaRec, BC000F15_A1386EmpHsMaxDia, BC000F15_A1387EmpHsMaxSem, BC000F15_A1388EmpHsMaxMes, BC000F15_A1389EmpHsMaxAnu,
            BC000F15_A1294PaiTipoTraId
            }
            , new Object[] {
            BC000F16_A3CliCod, BC000F16_A1EmpCod, BC000F16_A1371EmpPromFijVar, BC000F16_A1372EmpPromHabitual, BC000F16_A37TipoConCod
            }
            , new Object[] {
            BC000F17_A3CliCod, BC000F17_A1EmpCod, BC000F17_A1371EmpPromFijVar, BC000F17_A1372EmpPromHabitual, BC000F17_A37TipoConCod
            }
            , new Object[] {
            BC000F18_A37TipoConCod
            }
            , new Object[] {
            BC000F19_A1370EmpMenHabitual, BC000F19_A3CliCod, BC000F19_A1368EmpMenConCodigo, BC000F19_A1EmpCod
            }
            , new Object[] {
            BC000F20_A1370EmpMenHabitual, BC000F20_A3CliCod, BC000F20_A1368EmpMenConCodigo, BC000F20_A1EmpCod
            }
            , new Object[] {
            BC000F21_A26ConCodigo
            }
            , new Object[] {
            BC000F22_A1369EmpJorHabitual, BC000F22_A3CliCod, BC000F22_A1366EmpJorConCodigo, BC000F22_A1EmpCod
            }
            , new Object[] {
            BC000F23_A1369EmpJorHabitual, BC000F23_A3CliCod, BC000F23_A1366EmpJorConCodigo, BC000F23_A1EmpCod
            }
            , new Object[] {
            BC000F24_A26ConCodigo
            }
            , new Object[] {
            BC000F25_A1EmpCod, BC000F25_A2EmpNom, BC000F25_A177EmpCUIT, BC000F25_A125CatIvaCod, BC000F25_n125CatIvaCod, BC000F25_A126CatIvaDesc, BC000F25_n126CatIvaDesc, BC000F25_A178EmpDir, BC000F25_A180EmpTel, BC000F25_n180EmpTel,
            BC000F25_A176EmpCP, BC000F25_n176EmpCP, BC000F25_A532EmpReducc, BC000F25_A955EmpLogo, BC000F25_n955EmpLogo, BC000F25_A958EmpFirma, BC000F25_n958EmpFirma, BC000F25_A1140EmpAntiguedad, BC000F25_A1141EmpPresentismo, BC000F25_A1302EmpMesHsPExt,
            BC000F25_n1302EmpMesHsPExt, BC000F25_A1303EmpDiaHsPExt, BC000F25_n1303EmpDiaHsPExt, BC000F25_A1811EmpPerVacDes, BC000F25_A1812EmpPerVacHas, BC000F25_A1524EmpLiqFer, BC000F25_A1556EmpGuarEdadMin, BC000F25_A1557EmpGuarEdadMax, BC000F25_A1750EmpLiqFerJor, BC000F25_A1787EmpLiqGan,
            BC000F25_A1792EmpTipoExp, BC000F25_A1802EmpPromDesde, BC000F25_A1813EmpFracVacAnt, BC000F25_A1972EmpUltSexoIng, BC000F25_n1972EmpUltSexoIng, BC000F25_A2405EmpModTra, BC000F25_A957EmpLogoExt, BC000F25_n957EmpLogoExt, BC000F25_A960EmpFirmaExt, BC000F25_n960EmpFirmaExt,
            BC000F25_A956EmpLogoNom, BC000F25_n956EmpLogoNom, BC000F25_A959EmpFirmaNom, BC000F25_n959EmpFirmaNom, BC000F25_A46PaiCod, BC000F25_n46PaiCod, BC000F25_A47ProvCod, BC000F25_n47ProvCod, BC000F25_A48LocCod, BC000F25_n48LocCod,
            BC000F25_A3CliCod, BC000F25_A43ActCodigo, BC000F25_n43ActCodigo, BC000F25_A45TipEmpleCod, BC000F25_n45TipEmpleCod, BC000F25_A1151ARTSec, BC000F25_A903ActComCodigo, BC000F25_A1965EmpOsoCod, BC000F25_n1965EmpOsoCod, BC000F25_A1533EmpActComercial,
            BC000F25_A44EmpZonCod, BC000F25_n44EmpZonCod, BC000F25_A2265EmpCondiCod
            }
            , new Object[] {
            BC000F26_A1EmpCod, BC000F26_A2EmpNom, BC000F26_A177EmpCUIT, BC000F26_A125CatIvaCod, BC000F26_n125CatIvaCod, BC000F26_A126CatIvaDesc, BC000F26_n126CatIvaDesc, BC000F26_A178EmpDir, BC000F26_A180EmpTel, BC000F26_n180EmpTel,
            BC000F26_A176EmpCP, BC000F26_n176EmpCP, BC000F26_A532EmpReducc, BC000F26_A955EmpLogo, BC000F26_n955EmpLogo, BC000F26_A958EmpFirma, BC000F26_n958EmpFirma, BC000F26_A1140EmpAntiguedad, BC000F26_A1141EmpPresentismo, BC000F26_A1302EmpMesHsPExt,
            BC000F26_n1302EmpMesHsPExt, BC000F26_A1303EmpDiaHsPExt, BC000F26_n1303EmpDiaHsPExt, BC000F26_A1811EmpPerVacDes, BC000F26_A1812EmpPerVacHas, BC000F26_A1524EmpLiqFer, BC000F26_A1556EmpGuarEdadMin, BC000F26_A1557EmpGuarEdadMax, BC000F26_A1750EmpLiqFerJor, BC000F26_A1787EmpLiqGan,
            BC000F26_A1792EmpTipoExp, BC000F26_A1802EmpPromDesde, BC000F26_A1813EmpFracVacAnt, BC000F26_A1972EmpUltSexoIng, BC000F26_n1972EmpUltSexoIng, BC000F26_A2405EmpModTra, BC000F26_A957EmpLogoExt, BC000F26_n957EmpLogoExt, BC000F26_A960EmpFirmaExt, BC000F26_n960EmpFirmaExt,
            BC000F26_A956EmpLogoNom, BC000F26_n956EmpLogoNom, BC000F26_A959EmpFirmaNom, BC000F26_n959EmpFirmaNom, BC000F26_A46PaiCod, BC000F26_n46PaiCod, BC000F26_A47ProvCod, BC000F26_n47ProvCod, BC000F26_A48LocCod, BC000F26_n48LocCod,
            BC000F26_A3CliCod, BC000F26_A43ActCodigo, BC000F26_n43ActCodigo, BC000F26_A45TipEmpleCod, BC000F26_n45TipEmpleCod, BC000F26_A1151ARTSec, BC000F26_A903ActComCodigo, BC000F26_A1965EmpOsoCod, BC000F26_n1965EmpOsoCod, BC000F26_A1533EmpActComercial,
            BC000F26_A44EmpZonCod, BC000F26_n44EmpZonCod, BC000F26_A2265EmpCondiCod
            }
            , new Object[] {
            BC000F27_A312PaiNom
            }
            , new Object[] {
            BC000F28_A322ProvNom
            }
            , new Object[] {
            BC000F29_A286LocNom
            }
            , new Object[] {
            BC000F30_A3CliCod
            }
            , new Object[] {
            BC000F31_A683ActDescripSinAc, BC000F31_A108ActDescrip
            }
            , new Object[] {
            BC000F32_A530TipEmpleDefIns
            }
            , new Object[] {
            BC000F33_A1151ARTSec
            }
            , new Object[] {
            BC000F34_A903ActComCodigo
            }
            , new Object[] {
            BC000F35_A3CliCod
            }
            , new Object[] {
            BC000F36_A1533EmpActComercial
            }
            , new Object[] {
            BC000F37_A518EmpZonDescrip
            }
            , new Object[] {
            BC000F38_A2265EmpCondiCod
            }
            , new Object[] {
            BC000F39_A683ActDescripSinAc, BC000F39_A1EmpCod, BC000F39_A2EmpNom, BC000F39_A177EmpCUIT, BC000F39_A125CatIvaCod, BC000F39_n125CatIvaCod, BC000F39_A126CatIvaDesc, BC000F39_n126CatIvaDesc, BC000F39_A178EmpDir, BC000F39_A180EmpTel,
            BC000F39_n180EmpTel, BC000F39_A176EmpCP, BC000F39_n176EmpCP, BC000F39_A312PaiNom, BC000F39_A322ProvNom, BC000F39_A286LocNom, BC000F39_A108ActDescrip, BC000F39_A518EmpZonDescrip, BC000F39_A532EmpReducc, BC000F39_A530TipEmpleDefIns,
            BC000F39_A955EmpLogo, BC000F39_n955EmpLogo, BC000F39_A958EmpFirma, BC000F39_n958EmpFirma, BC000F39_A1140EmpAntiguedad, BC000F39_A1141EmpPresentismo, BC000F39_A1302EmpMesHsPExt, BC000F39_n1302EmpMesHsPExt, BC000F39_A1303EmpDiaHsPExt, BC000F39_n1303EmpDiaHsPExt,
            BC000F39_A1811EmpPerVacDes, BC000F39_A1812EmpPerVacHas, BC000F39_A1524EmpLiqFer, BC000F39_A1556EmpGuarEdadMin, BC000F39_A1557EmpGuarEdadMax, BC000F39_A1750EmpLiqFerJor, BC000F39_A1787EmpLiqGan, BC000F39_A1792EmpTipoExp, BC000F39_A1802EmpPromDesde, BC000F39_A1813EmpFracVacAnt,
            BC000F39_A1972EmpUltSexoIng, BC000F39_n1972EmpUltSexoIng, BC000F39_A2405EmpModTra, BC000F39_A957EmpLogoExt, BC000F39_n957EmpLogoExt, BC000F39_A960EmpFirmaExt, BC000F39_n960EmpFirmaExt, BC000F39_A956EmpLogoNom, BC000F39_n956EmpLogoNom, BC000F39_A959EmpFirmaNom,
            BC000F39_n959EmpFirmaNom, BC000F39_A46PaiCod, BC000F39_n46PaiCod, BC000F39_A47ProvCod, BC000F39_n47ProvCod, BC000F39_A48LocCod, BC000F39_n48LocCod, BC000F39_A3CliCod, BC000F39_A43ActCodigo, BC000F39_n43ActCodigo,
            BC000F39_A45TipEmpleCod, BC000F39_n45TipEmpleCod, BC000F39_A1151ARTSec, BC000F39_A903ActComCodigo, BC000F39_A1965EmpOsoCod, BC000F39_n1965EmpOsoCod, BC000F39_A1533EmpActComercial, BC000F39_A44EmpZonCod, BC000F39_n44EmpZonCod, BC000F39_A2265EmpCondiCod
            }
            , new Object[] {
            BC000F40_A3CliCod
            }
            , new Object[] {
            BC000F41_A3CliCod
            }
            , new Object[] {
            BC000F42_A312PaiNom
            }
            , new Object[] {
            BC000F43_A322ProvNom
            }
            , new Object[] {
            BC000F44_A286LocNom
            }
            , new Object[] {
            BC000F45_A683ActDescripSinAc, BC000F45_A108ActDescrip
            }
            , new Object[] {
            BC000F46_A530TipEmpleDefIns
            }
            , new Object[] {
            BC000F47_A518EmpZonDescrip
            }
            , new Object[] {
            BC000F48_A1533EmpActComercial
            }
            , new Object[] {
            BC000F49_A1151ARTSec
            }
            , new Object[] {
            BC000F50_A903ActComCodigo
            }
            , new Object[] {
            BC000F51_A2265EmpCondiCod
            }
            , new Object[] {
            BC000F52_A3CliCod, BC000F52_A1EmpCod
            }
            , new Object[] {
            BC000F53_A1EmpCod, BC000F53_A2EmpNom, BC000F53_A177EmpCUIT, BC000F53_A125CatIvaCod, BC000F53_n125CatIvaCod, BC000F53_A126CatIvaDesc, BC000F53_n126CatIvaDesc, BC000F53_A178EmpDir, BC000F53_A180EmpTel, BC000F53_n180EmpTel,
            BC000F53_A176EmpCP, BC000F53_n176EmpCP, BC000F53_A532EmpReducc, BC000F53_A955EmpLogo, BC000F53_n955EmpLogo, BC000F53_A958EmpFirma, BC000F53_n958EmpFirma, BC000F53_A1140EmpAntiguedad, BC000F53_A1141EmpPresentismo, BC000F53_A1302EmpMesHsPExt,
            BC000F53_n1302EmpMesHsPExt, BC000F53_A1303EmpDiaHsPExt, BC000F53_n1303EmpDiaHsPExt, BC000F53_A1811EmpPerVacDes, BC000F53_A1812EmpPerVacHas, BC000F53_A1524EmpLiqFer, BC000F53_A1556EmpGuarEdadMin, BC000F53_A1557EmpGuarEdadMax, BC000F53_A1750EmpLiqFerJor, BC000F53_A1787EmpLiqGan,
            BC000F53_A1792EmpTipoExp, BC000F53_A1802EmpPromDesde, BC000F53_A1813EmpFracVacAnt, BC000F53_A1972EmpUltSexoIng, BC000F53_n1972EmpUltSexoIng, BC000F53_A2405EmpModTra, BC000F53_A957EmpLogoExt, BC000F53_n957EmpLogoExt, BC000F53_A960EmpFirmaExt, BC000F53_n960EmpFirmaExt,
            BC000F53_A956EmpLogoNom, BC000F53_n956EmpLogoNom, BC000F53_A959EmpFirmaNom, BC000F53_n959EmpFirmaNom, BC000F53_A46PaiCod, BC000F53_n46PaiCod, BC000F53_A47ProvCod, BC000F53_n47ProvCod, BC000F53_A48LocCod, BC000F53_n48LocCod,
            BC000F53_A3CliCod, BC000F53_A43ActCodigo, BC000F53_n43ActCodigo, BC000F53_A45TipEmpleCod, BC000F53_n45TipEmpleCod, BC000F53_A1151ARTSec, BC000F53_A903ActComCodigo, BC000F53_A1965EmpOsoCod, BC000F53_n1965EmpOsoCod, BC000F53_A1533EmpActComercial,
            BC000F53_A44EmpZonCod, BC000F53_n44EmpZonCod, BC000F53_A2265EmpCondiCod
            }
            , new Object[] {
            BC000F54_A1EmpCod, BC000F54_A2EmpNom, BC000F54_A177EmpCUIT, BC000F54_A125CatIvaCod, BC000F54_n125CatIvaCod, BC000F54_A126CatIvaDesc, BC000F54_n126CatIvaDesc, BC000F54_A178EmpDir, BC000F54_A180EmpTel, BC000F54_n180EmpTel,
            BC000F54_A176EmpCP, BC000F54_n176EmpCP, BC000F54_A532EmpReducc, BC000F54_A955EmpLogo, BC000F54_n955EmpLogo, BC000F54_A958EmpFirma, BC000F54_n958EmpFirma, BC000F54_A1140EmpAntiguedad, BC000F54_A1141EmpPresentismo, BC000F54_A1302EmpMesHsPExt,
            BC000F54_n1302EmpMesHsPExt, BC000F54_A1303EmpDiaHsPExt, BC000F54_n1303EmpDiaHsPExt, BC000F54_A1811EmpPerVacDes, BC000F54_A1812EmpPerVacHas, BC000F54_A1524EmpLiqFer, BC000F54_A1556EmpGuarEdadMin, BC000F54_A1557EmpGuarEdadMax, BC000F54_A1750EmpLiqFerJor, BC000F54_A1787EmpLiqGan,
            BC000F54_A1792EmpTipoExp, BC000F54_A1802EmpPromDesde, BC000F54_A1813EmpFracVacAnt, BC000F54_A1972EmpUltSexoIng, BC000F54_n1972EmpUltSexoIng, BC000F54_A2405EmpModTra, BC000F54_A957EmpLogoExt, BC000F54_n957EmpLogoExt, BC000F54_A960EmpFirmaExt, BC000F54_n960EmpFirmaExt,
            BC000F54_A956EmpLogoNom, BC000F54_n956EmpLogoNom, BC000F54_A959EmpFirmaNom, BC000F54_n959EmpFirmaNom, BC000F54_A46PaiCod, BC000F54_n46PaiCod, BC000F54_A47ProvCod, BC000F54_n47ProvCod, BC000F54_A48LocCod, BC000F54_n48LocCod,
            BC000F54_A3CliCod, BC000F54_A43ActCodigo, BC000F54_n43ActCodigo, BC000F54_A45TipEmpleCod, BC000F54_n45TipEmpleCod, BC000F54_A1151ARTSec, BC000F54_A903ActComCodigo, BC000F54_A1965EmpOsoCod, BC000F54_n1965EmpOsoCod, BC000F54_A1533EmpActComercial,
            BC000F54_A44EmpZonCod, BC000F54_n44EmpZonCod, BC000F54_A2265EmpCondiCod
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
            BC000F60_A312PaiNom
            }
            , new Object[] {
            BC000F61_A322ProvNom
            }
            , new Object[] {
            BC000F62_A286LocNom
            }
            , new Object[] {
            BC000F63_A683ActDescripSinAc, BC000F63_A108ActDescrip
            }
            , new Object[] {
            BC000F64_A530TipEmpleDefIns
            }
            , new Object[] {
            BC000F65_A518EmpZonDescrip
            }
            , new Object[] {
            BC000F66_A3CliCod, BC000F66_A1EmpCod, BC000F66_A2418BanSalCod
            }
            , new Object[] {
            BC000F67_A3CliCod, BC000F67_A1EmpCod, BC000F67_A2380ColaUUID
            }
            , new Object[] {
            BC000F68_A3CliCod, BC000F68_A1EmpCod, BC000F68_A2371LiqBatchLiqNro, BC000F68_A2372LiqBatchCod, BC000F68_A2373LiqBatchSeccion
            }
            , new Object[] {
            BC000F69_A3CliCod, BC000F69_A1EmpCod, BC000F69_A2370LiqLoteLiqNro, BC000F69_A2269LiqLote
            }
            , new Object[] {
            BC000F70_A3CliCod, BC000F70_A1EmpCod, BC000F70_A31LiqNro, BC000F70_A2285LinkLegNumero, BC000F70_A2277LegLinkTiporec
            }
            , new Object[] {
            BC000F71_A3CliCod, BC000F71_A1EmpCod, BC000F71_A31LiqNro, BC000F71_A2183LiqSuc
            }
            , new Object[] {
            BC000F72_A3CliCod, BC000F72_A1EmpCod, BC000F72_A31LiqNro, BC000F72_A2145LiqArea
            }
            , new Object[] {
            BC000F73_A3CliCod, BC000F73_A1EmpCod, BC000F73_A31LiqNro, BC000F73_A2142LiqPaiConve, BC000F73_A2143LiqConvenio
            }
            , new Object[] {
            BC000F74_A3CliCod, BC000F74_A1EmpCod, BC000F74_A1966EmpBanCod
            }
            , new Object[] {
            BC000F75_A3CliCod, BC000F75_A1EmpCod, BC000F75_A1729PeriodoLiq
            }
            , new Object[] {
            BC000F76_A3CliCod, BC000F76_A1EmpCod, BC000F76_A1649LSDSec
            }
            , new Object[] {
            BC000F77_A3CliCod, BC000F77_A1EmpCod, BC000F77_A1562EmpConvePai, BC000F77_A1561EmpConveCod
            }
            , new Object[] {
            BC000F78_A3CliCod, BC000F78_A1EmpCod, BC000F78_A1562EmpConvePai, BC000F78_A1561EmpConveCod
            }
            , new Object[] {
            BC000F79_A3CliCod, BC000F79_A1EmpCod, BC000F79_A1562EmpConvePai, BC000F79_A1561EmpConveCod
            }
            , new Object[] {
            BC000F80_A3CliCod, BC000F80_A1EmpCod, BC000F80_A1562EmpConvePai, BC000F80_A1561EmpConveCod
            }
            , new Object[] {
            BC000F81_A3CliCod, BC000F81_A1EmpCod, BC000F81_A1562EmpConvePai, BC000F81_A1561EmpConveCod
            }
            , new Object[] {
            BC000F82_A3CliCod, BC000F82_A1EmpCod, BC000F82_A1562EmpConvePai, BC000F82_A1561EmpConveCod
            }
            , new Object[] {
            BC000F83_A3CliCod, BC000F83_A1EmpCod, BC000F83_A1562EmpConvePai, BC000F83_A1561EmpConveCod
            }
            , new Object[] {
            BC000F84_A3CliCod, BC000F84_A1EmpCod, BC000F84_A1562EmpConvePai, BC000F84_A1561EmpConveCod
            }
            , new Object[] {
            BC000F85_A3CliCod, BC000F85_A1EmpCod, BC000F85_A1562EmpConvePai, BC000F85_A1561EmpConveCod
            }
            , new Object[] {
            BC000F86_A3CliCod, BC000F86_A1EmpCod, BC000F86_A1562EmpConvePai, BC000F86_A1561EmpConveCod
            }
            , new Object[] {
            BC000F87_A3CliCod, BC000F87_A1EmpCod, BC000F87_A1562EmpConvePai, BC000F87_A1561EmpConveCod
            }
            , new Object[] {
            BC000F88_A3CliCod, BC000F88_A1EmpCod, BC000F88_A1562EmpConvePai, BC000F88_A1561EmpConveCod
            }
            , new Object[] {
            BC000F89_A3CliCod, BC000F89_A1EmpCod, BC000F89_A1562EmpConvePai, BC000F89_A1561EmpConveCod
            }
            , new Object[] {
            BC000F90_A3CliCod, BC000F90_A1EmpCod, BC000F90_A1562EmpConvePai, BC000F90_A1561EmpConveCod
            }
            , new Object[] {
            BC000F91_A3CliCod, BC000F91_A1EmpCod, BC000F91_A1562EmpConvePai, BC000F91_A1561EmpConveCod
            }
            , new Object[] {
            BC000F92_A3CliCod, BC000F92_A1EmpCod, BC000F92_A1562EmpConvePai, BC000F92_A1561EmpConveCod
            }
            , new Object[] {
            BC000F93_A3CliCod, BC000F93_A1EmpCod, BC000F93_A1562EmpConvePai, BC000F93_A1561EmpConveCod
            }
            , new Object[] {
            BC000F94_A3CliCod, BC000F94_A1EmpCod, BC000F94_A1562EmpConvePai, BC000F94_A1561EmpConveCod
            }
            , new Object[] {
            BC000F95_A3CliCod, BC000F95_A1EmpCod, BC000F95_A1562EmpConvePai, BC000F95_A1561EmpConveCod
            }
            , new Object[] {
            BC000F96_A3CliCod, BC000F96_A1EmpCod, BC000F96_A1562EmpConvePai, BC000F96_A1561EmpConveCod
            }
            , new Object[] {
            BC000F97_A3CliCod, BC000F97_A1EmpCod, BC000F97_A1562EmpConvePai, BC000F97_A1561EmpConveCod
            }
            , new Object[] {
            BC000F98_A3CliCod, BC000F98_A1EmpCod, BC000F98_A1562EmpConvePai, BC000F98_A1561EmpConveCod
            }
            , new Object[] {
            BC000F99_A3CliCod, BC000F99_A1EmpCod, BC000F99_A1562EmpConvePai, BC000F99_A1561EmpConveCod
            }
            , new Object[] {
            BC000F100_A3CliCod, BC000F100_A1EmpCod, BC000F100_A1562EmpConvePai, BC000F100_A1561EmpConveCod
            }
            , new Object[] {
            BC000F101_A3CliCod, BC000F101_A1EmpCod, BC000F101_A1562EmpConvePai, BC000F101_A1561EmpConveCod
            }
            , new Object[] {
            BC000F102_A3CliCod, BC000F102_A1EmpCod, BC000F102_A1562EmpConvePai, BC000F102_A1561EmpConveCod
            }
            , new Object[] {
            BC000F103_A3CliCod, BC000F103_A1EmpCod, BC000F103_A1562EmpConvePai, BC000F103_A1561EmpConveCod
            }
            , new Object[] {
            BC000F104_A3CliCod, BC000F104_A1EmpCod, BC000F104_A1562EmpConvePai, BC000F104_A1561EmpConveCod
            }
            , new Object[] {
            BC000F105_A3CliCod, BC000F105_A1EmpCod, BC000F105_A1562EmpConvePai, BC000F105_A1561EmpConveCod
            }
            , new Object[] {
            BC000F106_A3CliCod, BC000F106_A1EmpCod, BC000F106_A1562EmpConvePai, BC000F106_A1561EmpConveCod
            }
            , new Object[] {
            BC000F107_A3CliCod, BC000F107_A1EmpCod, BC000F107_A1562EmpConvePai, BC000F107_A1561EmpConveCod
            }
            , new Object[] {
            BC000F108_A3CliCod, BC000F108_A1EmpCod, BC000F108_A1562EmpConvePai, BC000F108_A1561EmpConveCod
            }
            , new Object[] {
            BC000F109_A3CliCod, BC000F109_A1EmpCod, BC000F109_A1562EmpConvePai, BC000F109_A1561EmpConveCod
            }
            , new Object[] {
            BC000F110_A3CliCod, BC000F110_A1EmpCod, BC000F110_A1562EmpConvePai, BC000F110_A1561EmpConveCod
            }
            , new Object[] {
            BC000F111_A3CliCod, BC000F111_A1EmpCod, BC000F111_A1562EmpConvePai, BC000F111_A1561EmpConveCod
            }
            , new Object[] {
            BC000F112_A3CliCod, BC000F112_A1EmpCod, BC000F112_A1562EmpConvePai, BC000F112_A1561EmpConveCod
            }
            , new Object[] {
            BC000F113_A3CliCod, BC000F113_A1EmpCod, BC000F113_A1562EmpConvePai, BC000F113_A1561EmpConveCod
            }
            , new Object[] {
            BC000F114_A3CliCod, BC000F114_A1EmpCod, BC000F114_A1562EmpConvePai, BC000F114_A1561EmpConveCod
            }
            , new Object[] {
            BC000F115_A3CliCod, BC000F115_A1EmpCod, BC000F115_A1562EmpConvePai, BC000F115_A1561EmpConveCod
            }
            , new Object[] {
            BC000F116_A3CliCod, BC000F116_A1EmpCod, BC000F116_A1562EmpConvePai, BC000F116_A1561EmpConveCod
            }
            , new Object[] {
            BC000F117_A3CliCod, BC000F117_A1EmpCod, BC000F117_A1562EmpConvePai, BC000F117_A1561EmpConveCod
            }
            , new Object[] {
            BC000F118_A3CliCod, BC000F118_A1EmpCod, BC000F118_A1562EmpConvePai, BC000F118_A1561EmpConveCod
            }
            , new Object[] {
            BC000F119_A3CliCod, BC000F119_A1EmpCod, BC000F119_A1562EmpConvePai, BC000F119_A1561EmpConveCod
            }
            , new Object[] {
            BC000F120_A3CliCod, BC000F120_A1EmpCod, BC000F120_A1562EmpConvePai, BC000F120_A1561EmpConveCod
            }
            , new Object[] {
            BC000F121_A3CliCod, BC000F121_A1EmpCod, BC000F121_A1562EmpConvePai, BC000F121_A1561EmpConveCod
            }
            , new Object[] {
            BC000F122_A3CliCod, BC000F122_A1EmpCod, BC000F122_A1562EmpConvePai, BC000F122_A1561EmpConveCod
            }
            , new Object[] {
            BC000F123_A3CliCod, BC000F123_A1EmpCod, BC000F123_A1562EmpConvePai, BC000F123_A1561EmpConveCod
            }
            , new Object[] {
            BC000F124_A3CliCod, BC000F124_A1EmpCod, BC000F124_A1562EmpConvePai, BC000F124_A1561EmpConveCod
            }
            , new Object[] {
            BC000F125_A3CliCod, BC000F125_A1EmpCod, BC000F125_A1562EmpConvePai, BC000F125_A1561EmpConveCod
            }
            , new Object[] {
            BC000F126_A3CliCod, BC000F126_A1EmpCod, BC000F126_A1562EmpConvePai, BC000F126_A1561EmpConveCod
            }
            , new Object[] {
            BC000F127_A3CliCod, BC000F127_A1EmpCod, BC000F127_A1562EmpConvePai, BC000F127_A1561EmpConveCod
            }
            , new Object[] {
            BC000F128_A3CliCod, BC000F128_A1EmpCod, BC000F128_A1562EmpConvePai, BC000F128_A1561EmpConveCod
            }
            , new Object[] {
            BC000F129_A3CliCod, BC000F129_A1EmpCod, BC000F129_A1562EmpConvePai, BC000F129_A1561EmpConveCod
            }
            , new Object[] {
            BC000F130_A3CliCod, BC000F130_A1EmpCod, BC000F130_A1562EmpConvePai, BC000F130_A1561EmpConveCod
            }
            , new Object[] {
            BC000F131_A3CliCod, BC000F131_A1EmpCod, BC000F131_A1562EmpConvePai, BC000F131_A1561EmpConveCod
            }
            , new Object[] {
            BC000F132_A3CliCod, BC000F132_A1EmpCod, BC000F132_A1562EmpConvePai, BC000F132_A1561EmpConveCod
            }
            , new Object[] {
            BC000F133_A3CliCod, BC000F133_A1EmpCod, BC000F133_A1547GuarCod
            }
            , new Object[] {
            BC000F134_A3CliCod, BC000F134_A1EmpCod, BC000F134_A1427EmpBaseClaseLeg, BC000F134_A1429EmpBaseTipo, BC000F134_A1430EmpBaseCod1, BC000F134_A1431EmpBaseCod2
            }
            , new Object[] {
            BC000F135_A3CliCod, BC000F135_A1EmpCod, BC000F135_A1340EmpHsExSec
            }
            , new Object[] {
            BC000F136_A3CliCod, BC000F136_A1EmpCod, BC000F136_A1243SucCodigo
            }
            , new Object[] {
            BC000F137_A3CliCod, BC000F137_A1EmpCod, BC000F137_A784F1357CTipoPre, BC000F137_A777F1357CPer, BC000F137_A778F1357CSec
            }
            , new Object[] {
            BC000F138_A3CliCod, BC000F138_A1EmpCod, BC000F138_A88ImpLiqSec
            }
            , new Object[] {
            BC000F139_A3CliCod, BC000F139_A1EmpCod, BC000F139_A87MigrLegNumero
            }
            , new Object[] {
            BC000F140_A3CliCod, BC000F140_A1EmpCod, BC000F140_A86TempRecSec
            }
            , new Object[] {
            BC000F141_A3CliCod, BC000F141_A1EmpCod, BC000F141_A85ArchSiradigFec
            }
            , new Object[] {
            BC000F142_A3CliCod, BC000F142_A1EmpCod, BC000F142_A79AsientoCNum
            }
            , new Object[] {
            BC000F143_A3CliCod, BC000F143_A1EmpCod, BC000F143_A78CuenCodigo
            }
            , new Object[] {
            BC000F144_A3CliCod, BC000F144_A1EmpCod, BC000F144_A77CenCodigo
            }
            , new Object[] {
            BC000F145_A3CliCod, BC000F145_A1EmpCod, BC000F145_A31LiqNro, BC000F145_A10LpgCodigo
            }
            , new Object[] {
            BC000F146_A3CliCod, BC000F146_A1EmpCod, BC000F146_A6LegNumero
            }
            , new Object[] {
            BC000F147_A683ActDescripSinAc, BC000F147_A1EmpCod, BC000F147_A2EmpNom, BC000F147_A177EmpCUIT, BC000F147_A125CatIvaCod, BC000F147_n125CatIvaCod, BC000F147_A126CatIvaDesc, BC000F147_n126CatIvaDesc, BC000F147_A178EmpDir, BC000F147_A180EmpTel,
            BC000F147_n180EmpTel, BC000F147_A176EmpCP, BC000F147_n176EmpCP, BC000F147_A312PaiNom, BC000F147_A322ProvNom, BC000F147_A286LocNom, BC000F147_A108ActDescrip, BC000F147_A518EmpZonDescrip, BC000F147_A532EmpReducc, BC000F147_A530TipEmpleDefIns,
            BC000F147_A955EmpLogo, BC000F147_n955EmpLogo, BC000F147_A958EmpFirma, BC000F147_n958EmpFirma, BC000F147_A1140EmpAntiguedad, BC000F147_A1141EmpPresentismo, BC000F147_A1302EmpMesHsPExt, BC000F147_n1302EmpMesHsPExt, BC000F147_A1303EmpDiaHsPExt, BC000F147_n1303EmpDiaHsPExt,
            BC000F147_A1811EmpPerVacDes, BC000F147_A1812EmpPerVacHas, BC000F147_A1524EmpLiqFer, BC000F147_A1556EmpGuarEdadMin, BC000F147_A1557EmpGuarEdadMax, BC000F147_A1750EmpLiqFerJor, BC000F147_A1787EmpLiqGan, BC000F147_A1792EmpTipoExp, BC000F147_A1802EmpPromDesde, BC000F147_A1813EmpFracVacAnt,
            BC000F147_A1972EmpUltSexoIng, BC000F147_n1972EmpUltSexoIng, BC000F147_A2405EmpModTra, BC000F147_A957EmpLogoExt, BC000F147_n957EmpLogoExt, BC000F147_A960EmpFirmaExt, BC000F147_n960EmpFirmaExt, BC000F147_A956EmpLogoNom, BC000F147_n956EmpLogoNom, BC000F147_A959EmpFirmaNom,
            BC000F147_n959EmpFirmaNom, BC000F147_A46PaiCod, BC000F147_n46PaiCod, BC000F147_A47ProvCod, BC000F147_n47ProvCod, BC000F147_A48LocCod, BC000F147_n48LocCod, BC000F147_A3CliCod, BC000F147_A43ActCodigo, BC000F147_n43ActCodigo,
            BC000F147_A45TipEmpleCod, BC000F147_n45TipEmpleCod, BC000F147_A1151ARTSec, BC000F147_A903ActComCodigo, BC000F147_A1965EmpOsoCod, BC000F147_n1965EmpOsoCod, BC000F147_A1533EmpActComercial, BC000F147_A44EmpZonCod, BC000F147_n44EmpZonCod, BC000F147_A2265EmpCondiCod
            }
            , new Object[] {
            BC000F148_A1369EmpJorHabitual, BC000F148_A3CliCod, BC000F148_A1366EmpJorConCodigo, BC000F148_A1EmpCod
            }
            , new Object[] {
            BC000F149_A26ConCodigo
            }
            , new Object[] {
            BC000F150_A3CliCod, BC000F150_A1EmpCod, BC000F150_A1366EmpJorConCodigo
            }
            , new Object[] {
            BC000F151_A1369EmpJorHabitual, BC000F151_A3CliCod, BC000F151_A1366EmpJorConCodigo, BC000F151_A1EmpCod
            }
            , new Object[] {
            BC000F152_A1369EmpJorHabitual, BC000F152_A3CliCod, BC000F152_A1366EmpJorConCodigo, BC000F152_A1EmpCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000F156_A1369EmpJorHabitual, BC000F156_A3CliCod, BC000F156_A1366EmpJorConCodigo, BC000F156_A1EmpCod
            }
            , new Object[] {
            BC000F157_A1370EmpMenHabitual, BC000F157_A3CliCod, BC000F157_A1368EmpMenConCodigo, BC000F157_A1EmpCod
            }
            , new Object[] {
            BC000F158_A26ConCodigo
            }
            , new Object[] {
            BC000F159_A3CliCod, BC000F159_A1EmpCod, BC000F159_A1368EmpMenConCodigo
            }
            , new Object[] {
            BC000F160_A1370EmpMenHabitual, BC000F160_A3CliCod, BC000F160_A1368EmpMenConCodigo, BC000F160_A1EmpCod
            }
            , new Object[] {
            BC000F161_A1370EmpMenHabitual, BC000F161_A3CliCod, BC000F161_A1368EmpMenConCodigo, BC000F161_A1EmpCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000F165_A1370EmpMenHabitual, BC000F165_A3CliCod, BC000F165_A1368EmpMenConCodigo, BC000F165_A1EmpCod
            }
            , new Object[] {
            BC000F166_A3CliCod, BC000F166_A1EmpCod, BC000F166_A1371EmpPromFijVar, BC000F166_A1372EmpPromHabitual, BC000F166_A37TipoConCod
            }
            , new Object[] {
            BC000F167_A37TipoConCod
            }
            , new Object[] {
            BC000F168_A3CliCod, BC000F168_A1EmpCod, BC000F168_A37TipoConCod, BC000F168_A1371EmpPromFijVar
            }
            , new Object[] {
            BC000F169_A3CliCod, BC000F169_A1EmpCod, BC000F169_A1371EmpPromFijVar, BC000F169_A1372EmpPromHabitual, BC000F169_A37TipoConCod
            }
            , new Object[] {
            BC000F170_A3CliCod, BC000F170_A1EmpCod, BC000F170_A1371EmpPromFijVar, BC000F170_A1372EmpPromHabitual, BC000F170_A37TipoConCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000F174_A3CliCod, BC000F174_A1EmpCod, BC000F174_A1371EmpPromFijVar, BC000F174_A1372EmpPromHabitual, BC000F174_A37TipoConCod
            }
            , new Object[] {
            BC000F175_A1340EmpHsExSec, BC000F175_A1341EmpHsPDiaDia, BC000F175_A1342EmpHsPDiaDesde, BC000F175_n1342EmpHsPDiaDesde, BC000F175_A1343EmpTarifaPDia, BC000F175_A1351EmpTarfaPDRec, BC000F175_A3CliCod, BC000F175_A1EmpCod, BC000F175_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            BC000F176_A1294PaiTipoTraId
            }
            , new Object[] {
            BC000F177_A3CliCod, BC000F177_A1EmpCod, BC000F177_A1340EmpHsExSec
            }
            , new Object[] {
            BC000F178_A1340EmpHsExSec, BC000F178_A1341EmpHsPDiaDia, BC000F178_A1342EmpHsPDiaDesde, BC000F178_n1342EmpHsPDiaDesde, BC000F178_A1343EmpTarifaPDia, BC000F178_A1351EmpTarfaPDRec, BC000F178_A3CliCod, BC000F178_A1EmpCod, BC000F178_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            BC000F179_A1340EmpHsExSec, BC000F179_A1341EmpHsPDiaDia, BC000F179_A1342EmpHsPDiaDesde, BC000F179_n1342EmpHsPDiaDesde, BC000F179_A1343EmpTarifaPDia, BC000F179_A1351EmpTarfaPDRec, BC000F179_A3CliCod, BC000F179_A1EmpCod, BC000F179_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000F183_A1340EmpHsExSec, BC000F183_A1341EmpHsPDiaDia, BC000F183_A1342EmpHsPDiaDesde, BC000F183_n1342EmpHsPDiaDesde, BC000F183_A1343EmpTarifaPDia, BC000F183_A1351EmpTarfaPDRec, BC000F183_A3CliCod, BC000F183_A1EmpCod, BC000F183_A1339EmpHsPDiaTipTra
            }
            , new Object[] {
            BC000F184_A3CliCod, BC000F184_A1EmpCod, BC000F184_A1344EmpHsDia, BC000F184_A1345EmpHsSem, BC000F184_A1346EmpTarifaXLim, BC000F184_A1352EmpTarifaRec, BC000F184_A1386EmpHsMaxDia, BC000F184_A1387EmpHsMaxSem, BC000F184_A1388EmpHsMaxMes, BC000F184_A1389EmpHsMaxAnu,
            BC000F184_A1294PaiTipoTraId
            }
            , new Object[] {
            BC000F185_A1292TipoTraId
            }
            , new Object[] {
            BC000F186_A3CliCod, BC000F186_A1EmpCod, BC000F186_A1294PaiTipoTraId
            }
            , new Object[] {
            BC000F187_A3CliCod, BC000F187_A1EmpCod, BC000F187_A1344EmpHsDia, BC000F187_A1345EmpHsSem, BC000F187_A1346EmpTarifaXLim, BC000F187_A1352EmpTarifaRec, BC000F187_A1386EmpHsMaxDia, BC000F187_A1387EmpHsMaxSem, BC000F187_A1388EmpHsMaxMes, BC000F187_A1389EmpHsMaxAnu,
            BC000F187_A1294PaiTipoTraId
            }
            , new Object[] {
            BC000F188_A3CliCod, BC000F188_A1EmpCod, BC000F188_A1344EmpHsDia, BC000F188_A1345EmpHsSem, BC000F188_A1346EmpTarifaXLim, BC000F188_A1352EmpTarifaRec, BC000F188_A1386EmpHsMaxDia, BC000F188_A1387EmpHsMaxSem, BC000F188_A1388EmpHsMaxMes, BC000F188_A1389EmpHsMaxAnu,
            BC000F188_A1294PaiTipoTraId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000F192_A3CliCod, BC000F192_A1EmpCod, BC000F192_A1340EmpHsExSec
            }
            , new Object[] {
            BC000F193_A3CliCod, BC000F193_A1EmpCod, BC000F193_A1344EmpHsDia, BC000F193_A1345EmpHsSem, BC000F193_A1346EmpTarifaXLim, BC000F193_A1352EmpTarifaRec, BC000F193_A1386EmpHsMaxDia, BC000F193_A1387EmpHsMaxSem, BC000F193_A1388EmpHsMaxMes, BC000F193_A1389EmpHsMaxAnu,
            BC000F193_A1294PaiTipoTraId
            }
            , new Object[] {
            BC000F194_A3CliCod, BC000F194_A1EmpCod, BC000F194_A1239EmpConvenio
            }
            , new Object[] {
            BC000F195_A3CliCod, BC000F195_A1EmpCod, BC000F195_A1239EmpConvenio
            }
            , new Object[] {
            BC000F196_A3CliCod, BC000F196_A1EmpCod, BC000F196_A1239EmpConvenio
            }
            , new Object[] {
            BC000F197_A3CliCod, BC000F197_A1EmpCod, BC000F197_A1239EmpConvenio
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000F200_A3CliCod, BC000F200_A1EmpCod, BC000F200_A1239EmpConvenio
            }
            , new Object[] {
            BC000F201_A3CliCod, BC000F201_A1EmpCod, BC000F201_A1238EmpOrigen
            }
            , new Object[] {
            BC000F202_A1231OrigId
            }
            , new Object[] {
            BC000F203_A3CliCod, BC000F203_A1EmpCod, BC000F203_A1238EmpOrigen
            }
            , new Object[] {
            BC000F204_A3CliCod, BC000F204_A1EmpCod, BC000F204_A1238EmpOrigen
            }
            , new Object[] {
            BC000F205_A3CliCod, BC000F205_A1EmpCod, BC000F205_A1238EmpOrigen
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000F208_A3CliCod, BC000F208_A1EmpCod, BC000F208_A1238EmpOrigen
            }
            , new Object[] {
            BC000F209_A3CliCod, BC000F209_A1EmpCod, BC000F209_A1237EmpReligion
            }
            , new Object[] {
            BC000F210_A1229ReligId
            }
            , new Object[] {
            BC000F211_A3CliCod, BC000F211_A1EmpCod, BC000F211_A1237EmpReligion
            }
            , new Object[] {
            BC000F212_A3CliCod, BC000F212_A1EmpCod, BC000F212_A1237EmpReligion
            }
            , new Object[] {
            BC000F213_A3CliCod, BC000F213_A1EmpCod, BC000F213_A1237EmpReligion
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000F216_A3CliCod, BC000F216_A1EmpCod, BC000F216_A1237EmpReligion
            }
            , new Object[] {
            BC000F217_A3CliCod
            }
            , new Object[] {
            BC000F218_A3CliCod
            }
         }
      );
      AV57Pgmname = "Empresa_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120F2 ();
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
   private byte Z1972EmpUltSexoIng ;
   private byte A1972EmpUltSexoIng ;
   private byte Gxremove172 ;
   private byte Gxremove171 ;
   private byte Gxremove173 ;
   private byte Gxremove165 ;
   private byte Gxremove166 ;
   private byte Gxremove144 ;
   private byte Gxremove145 ;
   private byte Gxremove146 ;
   private byte Gx_BScreen ;
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
   private short nIsMod_173 ;
   private short RcdFound173 ;
   private short nIsMod_171 ;
   private short RcdFound171 ;
   private short nIsMod_172 ;
   private short RcdFound172 ;
   private short AV11Insert_PaiCod ;
   private short AV12Insert_ProvCod ;
   private short AV13Insert_LocCod ;
   private short AV46Insert_ARTSec ;
   private short AV56Insert_EmpCondiCod ;
   private short AV7EmpCod ;
   private short Z125CatIvaCod ;
   private short A125CatIvaCod ;
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
   private short nRcdExists_172 ;
   private short nRcdExists_171 ;
   private short nRcdExists_173 ;
   private short nRcdExists_165 ;
   private short nRcdExists_166 ;
   private short nRcdExists_144 ;
   private short nRcdExists_145 ;
   private short nRcdExists_146 ;
   private short GXt_int9 ;
   private short GXv_int10[] ;
   private short nIsDirty_172 ;
   private short nIsDirty_171 ;
   private short nIsDirty_173 ;
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
   private int nGXsfl_173_idx=1 ;
   private int nGXsfl_171_idx=1 ;
   private int nGXsfl_172_idx=1 ;
   private int AV58GXV1 ;
   private int AV30CliCod ;
   private int GX_JID ;
   private int GXt_int7 ;
   private int GXv_int8[] ;
   private long GXv_int4[] ;
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
   private String AV57Pgmname ;
   private String AV14Insert_ActCodigo ;
   private String AV40Insert_TipEmpleCod ;
   private String AV36Insert_EmpZonCod ;
   private String AV53Insert_EmpActComercial ;
   private String AV43Insert_ActComCodigo ;
   private String AV55Insert_EmpOsoCod ;
   private String GXv_char6[] ;
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
   private String Z1366EmpJorConCodigo ;
   private String A1366EmpJorConCodigo ;
   private String sMode172 ;
   private String Z1368EmpMenConCodigo ;
   private String A1368EmpMenConCodigo ;
   private String sMode171 ;
   private String Z1371EmpPromFijVar ;
   private String A1371EmpPromFijVar ;
   private String Z37TipoConCod ;
   private String A37TipoConCod ;
   private String sMode173 ;
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
   private java.util.Date AV33Date ;
   private java.util.Date GXv_date5[] ;
   private boolean returnInSub ;
   private boolean AV31IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean AV34CliMultiEmp ;
   private boolean GXv_boolean3[] ;
   private boolean Z532EmpReducc ;
   private boolean A532EmpReducc ;
   private boolean Z1524EmpLiqFer ;
   private boolean A1524EmpLiqFer ;
   private boolean Z1750EmpLiqFerJor ;
   private boolean A1750EmpLiqFerJor ;
   private boolean Z1787EmpLiqGan ;
   private boolean A1787EmpLiqGan ;
   private boolean n125CatIvaCod ;
   private boolean n126CatIvaDesc ;
   private boolean n180EmpTel ;
   private boolean n176EmpCP ;
   private boolean n955EmpLogo ;
   private boolean n958EmpFirma ;
   private boolean n1302EmpMesHsPExt ;
   private boolean n1303EmpDiaHsPExt ;
   private boolean n1972EmpUltSexoIng ;
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
   private boolean Z1369EmpJorHabitual ;
   private boolean A1369EmpJorHabitual ;
   private boolean Z1370EmpMenHabitual ;
   private boolean A1370EmpMenHabitual ;
   private boolean Z1372EmpPromHabitual ;
   private boolean A1372EmpPromHabitual ;
   private boolean n1342EmpHsPDiaDesde ;
   private boolean mustCommit ;
   private String A955EmpLogo ;
   private String O955EmpLogo ;
   private String A958EmpFirma ;
   private String O958EmpFirma ;
   private String Z955EmpLogo ;
   private String Z958EmpFirma ;
   private String Z2EmpNom ;
   private String A2EmpNom ;
   private String Z126CatIvaDesc ;
   private String A126CatIvaDesc ;
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
   private web.SdtEmpresa bcEmpresa ;
   private IDataStoreProvider pr_default ;
   private String[] BC000F39_A683ActDescripSinAc ;
   private short[] BC000F39_A1EmpCod ;
   private String[] BC000F39_A2EmpNom ;
   private long[] BC000F39_A177EmpCUIT ;
   private short[] BC000F39_A125CatIvaCod ;
   private boolean[] BC000F39_n125CatIvaCod ;
   private String[] BC000F39_A126CatIvaDesc ;
   private boolean[] BC000F39_n126CatIvaDesc ;
   private String[] BC000F39_A178EmpDir ;
   private String[] BC000F39_A180EmpTel ;
   private boolean[] BC000F39_n180EmpTel ;
   private String[] BC000F39_A176EmpCP ;
   private boolean[] BC000F39_n176EmpCP ;
   private String[] BC000F39_A312PaiNom ;
   private String[] BC000F39_A322ProvNom ;
   private String[] BC000F39_A286LocNom ;
   private String[] BC000F39_A108ActDescrip ;
   private String[] BC000F39_A518EmpZonDescrip ;
   private boolean[] BC000F39_A532EmpReducc ;
   private String[] BC000F39_A530TipEmpleDefIns ;
   private String[] BC000F39_A955EmpLogo ;
   private boolean[] BC000F39_n955EmpLogo ;
   private String[] BC000F39_A958EmpFirma ;
   private boolean[] BC000F39_n958EmpFirma ;
   private java.math.BigDecimal[] BC000F39_A1140EmpAntiguedad ;
   private java.math.BigDecimal[] BC000F39_A1141EmpPresentismo ;
   private java.math.BigDecimal[] BC000F39_A1302EmpMesHsPExt ;
   private boolean[] BC000F39_n1302EmpMesHsPExt ;
   private String[] BC000F39_A1303EmpDiaHsPExt ;
   private boolean[] BC000F39_n1303EmpDiaHsPExt ;
   private byte[] BC000F39_A1811EmpPerVacDes ;
   private byte[] BC000F39_A1812EmpPerVacHas ;
   private boolean[] BC000F39_A1524EmpLiqFer ;
   private byte[] BC000F39_A1556EmpGuarEdadMin ;
   private byte[] BC000F39_A1557EmpGuarEdadMax ;
   private boolean[] BC000F39_A1750EmpLiqFerJor ;
   private boolean[] BC000F39_A1787EmpLiqGan ;
   private byte[] BC000F39_A1792EmpTipoExp ;
   private String[] BC000F39_A1802EmpPromDesde ;
   private java.math.BigDecimal[] BC000F39_A1813EmpFracVacAnt ;
   private byte[] BC000F39_A1972EmpUltSexoIng ;
   private boolean[] BC000F39_n1972EmpUltSexoIng ;
   private String[] BC000F39_A2405EmpModTra ;
   private String[] BC000F39_A957EmpLogoExt ;
   private boolean[] BC000F39_n957EmpLogoExt ;
   private String[] BC000F39_A960EmpFirmaExt ;
   private boolean[] BC000F39_n960EmpFirmaExt ;
   private String[] BC000F39_A956EmpLogoNom ;
   private boolean[] BC000F39_n956EmpLogoNom ;
   private String[] BC000F39_A959EmpFirmaNom ;
   private boolean[] BC000F39_n959EmpFirmaNom ;
   private short[] BC000F39_A46PaiCod ;
   private boolean[] BC000F39_n46PaiCod ;
   private short[] BC000F39_A47ProvCod ;
   private boolean[] BC000F39_n47ProvCod ;
   private short[] BC000F39_A48LocCod ;
   private boolean[] BC000F39_n48LocCod ;
   private int[] BC000F39_A3CliCod ;
   private String[] BC000F39_A43ActCodigo ;
   private boolean[] BC000F39_n43ActCodigo ;
   private String[] BC000F39_A45TipEmpleCod ;
   private boolean[] BC000F39_n45TipEmpleCod ;
   private short[] BC000F39_A1151ARTSec ;
   private String[] BC000F39_A903ActComCodigo ;
   private String[] BC000F39_A1965EmpOsoCod ;
   private boolean[] BC000F39_n1965EmpOsoCod ;
   private String[] BC000F39_A1533EmpActComercial ;
   private String[] BC000F39_A44EmpZonCod ;
   private boolean[] BC000F39_n44EmpZonCod ;
   private short[] BC000F39_A2265EmpCondiCod ;
   private int[] BC000F40_A3CliCod ;
   private int[] BC000F41_A3CliCod ;
   private String[] BC000F42_A312PaiNom ;
   private String[] BC000F43_A322ProvNom ;
   private String[] BC000F44_A286LocNom ;
   private String[] BC000F45_A683ActDescripSinAc ;
   private String[] BC000F45_A108ActDescrip ;
   private String[] BC000F46_A530TipEmpleDefIns ;
   private String[] BC000F47_A518EmpZonDescrip ;
   private String[] BC000F48_A1533EmpActComercial ;
   private short[] BC000F49_A1151ARTSec ;
   private String[] BC000F50_A903ActComCodigo ;
   private short[] BC000F51_A2265EmpCondiCod ;
   private int[] BC000F52_A3CliCod ;
   private short[] BC000F52_A1EmpCod ;
   private short[] BC000F53_A1EmpCod ;
   private String[] BC000F53_A2EmpNom ;
   private long[] BC000F53_A177EmpCUIT ;
   private short[] BC000F53_A125CatIvaCod ;
   private boolean[] BC000F53_n125CatIvaCod ;
   private String[] BC000F53_A126CatIvaDesc ;
   private boolean[] BC000F53_n126CatIvaDesc ;
   private String[] BC000F53_A178EmpDir ;
   private String[] BC000F53_A180EmpTel ;
   private boolean[] BC000F53_n180EmpTel ;
   private String[] BC000F53_A176EmpCP ;
   private boolean[] BC000F53_n176EmpCP ;
   private boolean[] BC000F53_A532EmpReducc ;
   private String[] BC000F53_A955EmpLogo ;
   private boolean[] BC000F53_n955EmpLogo ;
   private String[] BC000F53_A958EmpFirma ;
   private boolean[] BC000F53_n958EmpFirma ;
   private java.math.BigDecimal[] BC000F53_A1140EmpAntiguedad ;
   private java.math.BigDecimal[] BC000F53_A1141EmpPresentismo ;
   private java.math.BigDecimal[] BC000F53_A1302EmpMesHsPExt ;
   private boolean[] BC000F53_n1302EmpMesHsPExt ;
   private String[] BC000F53_A1303EmpDiaHsPExt ;
   private boolean[] BC000F53_n1303EmpDiaHsPExt ;
   private byte[] BC000F53_A1811EmpPerVacDes ;
   private byte[] BC000F53_A1812EmpPerVacHas ;
   private boolean[] BC000F53_A1524EmpLiqFer ;
   private byte[] BC000F53_A1556EmpGuarEdadMin ;
   private byte[] BC000F53_A1557EmpGuarEdadMax ;
   private boolean[] BC000F53_A1750EmpLiqFerJor ;
   private boolean[] BC000F53_A1787EmpLiqGan ;
   private byte[] BC000F53_A1792EmpTipoExp ;
   private String[] BC000F53_A1802EmpPromDesde ;
   private java.math.BigDecimal[] BC000F53_A1813EmpFracVacAnt ;
   private byte[] BC000F53_A1972EmpUltSexoIng ;
   private boolean[] BC000F53_n1972EmpUltSexoIng ;
   private String[] BC000F53_A2405EmpModTra ;
   private String[] BC000F53_A957EmpLogoExt ;
   private boolean[] BC000F53_n957EmpLogoExt ;
   private String[] BC000F53_A960EmpFirmaExt ;
   private boolean[] BC000F53_n960EmpFirmaExt ;
   private String[] BC000F53_A956EmpLogoNom ;
   private boolean[] BC000F53_n956EmpLogoNom ;
   private String[] BC000F53_A959EmpFirmaNom ;
   private boolean[] BC000F53_n959EmpFirmaNom ;
   private short[] BC000F53_A46PaiCod ;
   private boolean[] BC000F53_n46PaiCod ;
   private short[] BC000F53_A47ProvCod ;
   private boolean[] BC000F53_n47ProvCod ;
   private short[] BC000F53_A48LocCod ;
   private boolean[] BC000F53_n48LocCod ;
   private int[] BC000F53_A3CliCod ;
   private String[] BC000F53_A43ActCodigo ;
   private boolean[] BC000F53_n43ActCodigo ;
   private String[] BC000F53_A45TipEmpleCod ;
   private boolean[] BC000F53_n45TipEmpleCod ;
   private short[] BC000F53_A1151ARTSec ;
   private String[] BC000F53_A903ActComCodigo ;
   private String[] BC000F53_A1965EmpOsoCod ;
   private boolean[] BC000F53_n1965EmpOsoCod ;
   private String[] BC000F53_A1533EmpActComercial ;
   private String[] BC000F53_A44EmpZonCod ;
   private boolean[] BC000F53_n44EmpZonCod ;
   private short[] BC000F53_A2265EmpCondiCod ;
   private short[] BC000F54_A1EmpCod ;
   private String[] BC000F54_A2EmpNom ;
   private long[] BC000F54_A177EmpCUIT ;
   private short[] BC000F54_A125CatIvaCod ;
   private boolean[] BC000F54_n125CatIvaCod ;
   private String[] BC000F54_A126CatIvaDesc ;
   private boolean[] BC000F54_n126CatIvaDesc ;
   private String[] BC000F54_A178EmpDir ;
   private String[] BC000F54_A180EmpTel ;
   private boolean[] BC000F54_n180EmpTel ;
   private String[] BC000F54_A176EmpCP ;
   private boolean[] BC000F54_n176EmpCP ;
   private boolean[] BC000F54_A532EmpReducc ;
   private String[] BC000F54_A955EmpLogo ;
   private boolean[] BC000F54_n955EmpLogo ;
   private String[] BC000F54_A958EmpFirma ;
   private boolean[] BC000F54_n958EmpFirma ;
   private java.math.BigDecimal[] BC000F54_A1140EmpAntiguedad ;
   private java.math.BigDecimal[] BC000F54_A1141EmpPresentismo ;
   private java.math.BigDecimal[] BC000F54_A1302EmpMesHsPExt ;
   private boolean[] BC000F54_n1302EmpMesHsPExt ;
   private String[] BC000F54_A1303EmpDiaHsPExt ;
   private boolean[] BC000F54_n1303EmpDiaHsPExt ;
   private byte[] BC000F54_A1811EmpPerVacDes ;
   private byte[] BC000F54_A1812EmpPerVacHas ;
   private boolean[] BC000F54_A1524EmpLiqFer ;
   private byte[] BC000F54_A1556EmpGuarEdadMin ;
   private byte[] BC000F54_A1557EmpGuarEdadMax ;
   private boolean[] BC000F54_A1750EmpLiqFerJor ;
   private boolean[] BC000F54_A1787EmpLiqGan ;
   private byte[] BC000F54_A1792EmpTipoExp ;
   private String[] BC000F54_A1802EmpPromDesde ;
   private java.math.BigDecimal[] BC000F54_A1813EmpFracVacAnt ;
   private byte[] BC000F54_A1972EmpUltSexoIng ;
   private boolean[] BC000F54_n1972EmpUltSexoIng ;
   private String[] BC000F54_A2405EmpModTra ;
   private String[] BC000F54_A957EmpLogoExt ;
   private boolean[] BC000F54_n957EmpLogoExt ;
   private String[] BC000F54_A960EmpFirmaExt ;
   private boolean[] BC000F54_n960EmpFirmaExt ;
   private String[] BC000F54_A956EmpLogoNom ;
   private boolean[] BC000F54_n956EmpLogoNom ;
   private String[] BC000F54_A959EmpFirmaNom ;
   private boolean[] BC000F54_n959EmpFirmaNom ;
   private short[] BC000F54_A46PaiCod ;
   private boolean[] BC000F54_n46PaiCod ;
   private short[] BC000F54_A47ProvCod ;
   private boolean[] BC000F54_n47ProvCod ;
   private short[] BC000F54_A48LocCod ;
   private boolean[] BC000F54_n48LocCod ;
   private int[] BC000F54_A3CliCod ;
   private String[] BC000F54_A43ActCodigo ;
   private boolean[] BC000F54_n43ActCodigo ;
   private String[] BC000F54_A45TipEmpleCod ;
   private boolean[] BC000F54_n45TipEmpleCod ;
   private short[] BC000F54_A1151ARTSec ;
   private String[] BC000F54_A903ActComCodigo ;
   private String[] BC000F54_A1965EmpOsoCod ;
   private boolean[] BC000F54_n1965EmpOsoCod ;
   private String[] BC000F54_A1533EmpActComercial ;
   private String[] BC000F54_A44EmpZonCod ;
   private boolean[] BC000F54_n44EmpZonCod ;
   private short[] BC000F54_A2265EmpCondiCod ;
   private String[] BC000F60_A312PaiNom ;
   private String[] BC000F61_A322ProvNom ;
   private String[] BC000F62_A286LocNom ;
   private String[] BC000F63_A683ActDescripSinAc ;
   private String[] BC000F63_A108ActDescrip ;
   private String[] BC000F64_A530TipEmpleDefIns ;
   private String[] BC000F65_A518EmpZonDescrip ;
   private int[] BC000F66_A3CliCod ;
   private short[] BC000F66_A1EmpCod ;
   private java.util.UUID[] BC000F66_A2418BanSalCod ;
   private int[] BC000F67_A3CliCod ;
   private short[] BC000F67_A1EmpCod ;
   private java.util.UUID[] BC000F67_A2380ColaUUID ;
   private int[] BC000F68_A3CliCod ;
   private short[] BC000F68_A1EmpCod ;
   private int[] BC000F68_A2371LiqBatchLiqNro ;
   private String[] BC000F68_A2372LiqBatchCod ;
   private String[] BC000F68_A2373LiqBatchSeccion ;
   private int[] BC000F69_A3CliCod ;
   private short[] BC000F69_A1EmpCod ;
   private int[] BC000F69_A2370LiqLoteLiqNro ;
   private String[] BC000F69_A2269LiqLote ;
   private int[] BC000F70_A3CliCod ;
   private short[] BC000F70_A1EmpCod ;
   private int[] BC000F70_A31LiqNro ;
   private int[] BC000F70_A2285LinkLegNumero ;
   private String[] BC000F70_A2277LegLinkTiporec ;
   private int[] BC000F71_A3CliCod ;
   private short[] BC000F71_A1EmpCod ;
   private int[] BC000F71_A31LiqNro ;
   private String[] BC000F71_A2183LiqSuc ;
   private int[] BC000F72_A3CliCod ;
   private short[] BC000F72_A1EmpCod ;
   private int[] BC000F72_A31LiqNro ;
   private String[] BC000F72_A2145LiqArea ;
   private int[] BC000F73_A3CliCod ;
   private short[] BC000F73_A1EmpCod ;
   private int[] BC000F73_A31LiqNro ;
   private short[] BC000F73_A2142LiqPaiConve ;
   private String[] BC000F73_A2143LiqConvenio ;
   private int[] BC000F74_A3CliCod ;
   private short[] BC000F74_A1EmpCod ;
   private String[] BC000F74_A1966EmpBanCod ;
   private int[] BC000F75_A3CliCod ;
   private short[] BC000F75_A1EmpCod ;
   private java.util.Date[] BC000F75_A1729PeriodoLiq ;
   private int[] BC000F76_A3CliCod ;
   private short[] BC000F76_A1EmpCod ;
   private int[] BC000F76_A1649LSDSec ;
   private int[] BC000F77_A3CliCod ;
   private short[] BC000F77_A1EmpCod ;
   private short[] BC000F77_A1562EmpConvePai ;
   private String[] BC000F77_A1561EmpConveCod ;
   private int[] BC000F78_A3CliCod ;
   private short[] BC000F78_A1EmpCod ;
   private short[] BC000F78_A1562EmpConvePai ;
   private String[] BC000F78_A1561EmpConveCod ;
   private int[] BC000F79_A3CliCod ;
   private short[] BC000F79_A1EmpCod ;
   private short[] BC000F79_A1562EmpConvePai ;
   private String[] BC000F79_A1561EmpConveCod ;
   private int[] BC000F80_A3CliCod ;
   private short[] BC000F80_A1EmpCod ;
   private short[] BC000F80_A1562EmpConvePai ;
   private String[] BC000F80_A1561EmpConveCod ;
   private int[] BC000F81_A3CliCod ;
   private short[] BC000F81_A1EmpCod ;
   private short[] BC000F81_A1562EmpConvePai ;
   private String[] BC000F81_A1561EmpConveCod ;
   private int[] BC000F82_A3CliCod ;
   private short[] BC000F82_A1EmpCod ;
   private short[] BC000F82_A1562EmpConvePai ;
   private String[] BC000F82_A1561EmpConveCod ;
   private int[] BC000F83_A3CliCod ;
   private short[] BC000F83_A1EmpCod ;
   private short[] BC000F83_A1562EmpConvePai ;
   private String[] BC000F83_A1561EmpConveCod ;
   private int[] BC000F84_A3CliCod ;
   private short[] BC000F84_A1EmpCod ;
   private short[] BC000F84_A1562EmpConvePai ;
   private String[] BC000F84_A1561EmpConveCod ;
   private int[] BC000F85_A3CliCod ;
   private short[] BC000F85_A1EmpCod ;
   private short[] BC000F85_A1562EmpConvePai ;
   private String[] BC000F85_A1561EmpConveCod ;
   private int[] BC000F86_A3CliCod ;
   private short[] BC000F86_A1EmpCod ;
   private short[] BC000F86_A1562EmpConvePai ;
   private String[] BC000F86_A1561EmpConveCod ;
   private int[] BC000F87_A3CliCod ;
   private short[] BC000F87_A1EmpCod ;
   private short[] BC000F87_A1562EmpConvePai ;
   private String[] BC000F87_A1561EmpConveCod ;
   private int[] BC000F88_A3CliCod ;
   private short[] BC000F88_A1EmpCod ;
   private short[] BC000F88_A1562EmpConvePai ;
   private String[] BC000F88_A1561EmpConveCod ;
   private int[] BC000F89_A3CliCod ;
   private short[] BC000F89_A1EmpCod ;
   private short[] BC000F89_A1562EmpConvePai ;
   private String[] BC000F89_A1561EmpConveCod ;
   private int[] BC000F90_A3CliCod ;
   private short[] BC000F90_A1EmpCod ;
   private short[] BC000F90_A1562EmpConvePai ;
   private String[] BC000F90_A1561EmpConveCod ;
   private int[] BC000F91_A3CliCod ;
   private short[] BC000F91_A1EmpCod ;
   private short[] BC000F91_A1562EmpConvePai ;
   private String[] BC000F91_A1561EmpConveCod ;
   private int[] BC000F92_A3CliCod ;
   private short[] BC000F92_A1EmpCod ;
   private short[] BC000F92_A1562EmpConvePai ;
   private String[] BC000F92_A1561EmpConveCod ;
   private int[] BC000F93_A3CliCod ;
   private short[] BC000F93_A1EmpCod ;
   private short[] BC000F93_A1562EmpConvePai ;
   private String[] BC000F93_A1561EmpConveCod ;
   private int[] BC000F94_A3CliCod ;
   private short[] BC000F94_A1EmpCod ;
   private short[] BC000F94_A1562EmpConvePai ;
   private String[] BC000F94_A1561EmpConveCod ;
   private int[] BC000F95_A3CliCod ;
   private short[] BC000F95_A1EmpCod ;
   private short[] BC000F95_A1562EmpConvePai ;
   private String[] BC000F95_A1561EmpConveCod ;
   private int[] BC000F96_A3CliCod ;
   private short[] BC000F96_A1EmpCod ;
   private short[] BC000F96_A1562EmpConvePai ;
   private String[] BC000F96_A1561EmpConveCod ;
   private int[] BC000F97_A3CliCod ;
   private short[] BC000F97_A1EmpCod ;
   private short[] BC000F97_A1562EmpConvePai ;
   private String[] BC000F97_A1561EmpConveCod ;
   private int[] BC000F98_A3CliCod ;
   private short[] BC000F98_A1EmpCod ;
   private short[] BC000F98_A1562EmpConvePai ;
   private String[] BC000F98_A1561EmpConveCod ;
   private int[] BC000F99_A3CliCod ;
   private short[] BC000F99_A1EmpCod ;
   private short[] BC000F99_A1562EmpConvePai ;
   private String[] BC000F99_A1561EmpConveCod ;
   private int[] BC000F100_A3CliCod ;
   private short[] BC000F100_A1EmpCod ;
   private short[] BC000F100_A1562EmpConvePai ;
   private String[] BC000F100_A1561EmpConveCod ;
   private int[] BC000F101_A3CliCod ;
   private short[] BC000F101_A1EmpCod ;
   private short[] BC000F101_A1562EmpConvePai ;
   private String[] BC000F101_A1561EmpConveCod ;
   private int[] BC000F102_A3CliCod ;
   private short[] BC000F102_A1EmpCod ;
   private short[] BC000F102_A1562EmpConvePai ;
   private String[] BC000F102_A1561EmpConveCod ;
   private int[] BC000F103_A3CliCod ;
   private short[] BC000F103_A1EmpCod ;
   private short[] BC000F103_A1562EmpConvePai ;
   private String[] BC000F103_A1561EmpConveCod ;
   private int[] BC000F104_A3CliCod ;
   private short[] BC000F104_A1EmpCod ;
   private short[] BC000F104_A1562EmpConvePai ;
   private String[] BC000F104_A1561EmpConveCod ;
   private int[] BC000F105_A3CliCod ;
   private short[] BC000F105_A1EmpCod ;
   private short[] BC000F105_A1562EmpConvePai ;
   private String[] BC000F105_A1561EmpConveCod ;
   private int[] BC000F106_A3CliCod ;
   private short[] BC000F106_A1EmpCod ;
   private short[] BC000F106_A1562EmpConvePai ;
   private String[] BC000F106_A1561EmpConveCod ;
   private int[] BC000F107_A3CliCod ;
   private short[] BC000F107_A1EmpCod ;
   private short[] BC000F107_A1562EmpConvePai ;
   private String[] BC000F107_A1561EmpConveCod ;
   private int[] BC000F108_A3CliCod ;
   private short[] BC000F108_A1EmpCod ;
   private short[] BC000F108_A1562EmpConvePai ;
   private String[] BC000F108_A1561EmpConveCod ;
   private int[] BC000F109_A3CliCod ;
   private short[] BC000F109_A1EmpCod ;
   private short[] BC000F109_A1562EmpConvePai ;
   private String[] BC000F109_A1561EmpConveCod ;
   private int[] BC000F110_A3CliCod ;
   private short[] BC000F110_A1EmpCod ;
   private short[] BC000F110_A1562EmpConvePai ;
   private String[] BC000F110_A1561EmpConveCod ;
   private int[] BC000F111_A3CliCod ;
   private short[] BC000F111_A1EmpCod ;
   private short[] BC000F111_A1562EmpConvePai ;
   private String[] BC000F111_A1561EmpConveCod ;
   private int[] BC000F112_A3CliCod ;
   private short[] BC000F112_A1EmpCod ;
   private short[] BC000F112_A1562EmpConvePai ;
   private String[] BC000F112_A1561EmpConveCod ;
   private int[] BC000F113_A3CliCod ;
   private short[] BC000F113_A1EmpCod ;
   private short[] BC000F113_A1562EmpConvePai ;
   private String[] BC000F113_A1561EmpConveCod ;
   private int[] BC000F114_A3CliCod ;
   private short[] BC000F114_A1EmpCod ;
   private short[] BC000F114_A1562EmpConvePai ;
   private String[] BC000F114_A1561EmpConveCod ;
   private int[] BC000F115_A3CliCod ;
   private short[] BC000F115_A1EmpCod ;
   private short[] BC000F115_A1562EmpConvePai ;
   private String[] BC000F115_A1561EmpConveCod ;
   private int[] BC000F116_A3CliCod ;
   private short[] BC000F116_A1EmpCod ;
   private short[] BC000F116_A1562EmpConvePai ;
   private String[] BC000F116_A1561EmpConveCod ;
   private int[] BC000F117_A3CliCod ;
   private short[] BC000F117_A1EmpCod ;
   private short[] BC000F117_A1562EmpConvePai ;
   private String[] BC000F117_A1561EmpConveCod ;
   private int[] BC000F118_A3CliCod ;
   private short[] BC000F118_A1EmpCod ;
   private short[] BC000F118_A1562EmpConvePai ;
   private String[] BC000F118_A1561EmpConveCod ;
   private int[] BC000F119_A3CliCod ;
   private short[] BC000F119_A1EmpCod ;
   private short[] BC000F119_A1562EmpConvePai ;
   private String[] BC000F119_A1561EmpConveCod ;
   private int[] BC000F120_A3CliCod ;
   private short[] BC000F120_A1EmpCod ;
   private short[] BC000F120_A1562EmpConvePai ;
   private String[] BC000F120_A1561EmpConveCod ;
   private int[] BC000F121_A3CliCod ;
   private short[] BC000F121_A1EmpCod ;
   private short[] BC000F121_A1562EmpConvePai ;
   private String[] BC000F121_A1561EmpConveCod ;
   private int[] BC000F122_A3CliCod ;
   private short[] BC000F122_A1EmpCod ;
   private short[] BC000F122_A1562EmpConvePai ;
   private String[] BC000F122_A1561EmpConveCod ;
   private int[] BC000F123_A3CliCod ;
   private short[] BC000F123_A1EmpCod ;
   private short[] BC000F123_A1562EmpConvePai ;
   private String[] BC000F123_A1561EmpConveCod ;
   private int[] BC000F124_A3CliCod ;
   private short[] BC000F124_A1EmpCod ;
   private short[] BC000F124_A1562EmpConvePai ;
   private String[] BC000F124_A1561EmpConveCod ;
   private int[] BC000F125_A3CliCod ;
   private short[] BC000F125_A1EmpCod ;
   private short[] BC000F125_A1562EmpConvePai ;
   private String[] BC000F125_A1561EmpConveCod ;
   private int[] BC000F126_A3CliCod ;
   private short[] BC000F126_A1EmpCod ;
   private short[] BC000F126_A1562EmpConvePai ;
   private String[] BC000F126_A1561EmpConveCod ;
   private int[] BC000F127_A3CliCod ;
   private short[] BC000F127_A1EmpCod ;
   private short[] BC000F127_A1562EmpConvePai ;
   private String[] BC000F127_A1561EmpConveCod ;
   private int[] BC000F128_A3CliCod ;
   private short[] BC000F128_A1EmpCod ;
   private short[] BC000F128_A1562EmpConvePai ;
   private String[] BC000F128_A1561EmpConveCod ;
   private int[] BC000F129_A3CliCod ;
   private short[] BC000F129_A1EmpCod ;
   private short[] BC000F129_A1562EmpConvePai ;
   private String[] BC000F129_A1561EmpConveCod ;
   private int[] BC000F130_A3CliCod ;
   private short[] BC000F130_A1EmpCod ;
   private short[] BC000F130_A1562EmpConvePai ;
   private String[] BC000F130_A1561EmpConveCod ;
   private int[] BC000F131_A3CliCod ;
   private short[] BC000F131_A1EmpCod ;
   private short[] BC000F131_A1562EmpConvePai ;
   private String[] BC000F131_A1561EmpConveCod ;
   private int[] BC000F132_A3CliCod ;
   private short[] BC000F132_A1EmpCod ;
   private short[] BC000F132_A1562EmpConvePai ;
   private String[] BC000F132_A1561EmpConveCod ;
   private int[] BC000F133_A3CliCod ;
   private short[] BC000F133_A1EmpCod ;
   private short[] BC000F133_A1547GuarCod ;
   private int[] BC000F134_A3CliCod ;
   private short[] BC000F134_A1EmpCod ;
   private byte[] BC000F134_A1427EmpBaseClaseLeg ;
   private String[] BC000F134_A1429EmpBaseTipo ;
   private String[] BC000F134_A1430EmpBaseCod1 ;
   private String[] BC000F134_A1431EmpBaseCod2 ;
   private int[] BC000F135_A3CliCod ;
   private short[] BC000F135_A1EmpCod ;
   private short[] BC000F135_A1340EmpHsExSec ;
   private int[] BC000F136_A3CliCod ;
   private short[] BC000F136_A1EmpCod ;
   private String[] BC000F136_A1243SucCodigo ;
   private int[] BC000F137_A3CliCod ;
   private short[] BC000F137_A1EmpCod ;
   private byte[] BC000F137_A784F1357CTipoPre ;
   private String[] BC000F137_A777F1357CPer ;
   private byte[] BC000F137_A778F1357CSec ;
   private int[] BC000F138_A3CliCod ;
   private short[] BC000F138_A1EmpCod ;
   private short[] BC000F138_A88ImpLiqSec ;
   private int[] BC000F139_A3CliCod ;
   private short[] BC000F139_A1EmpCod ;
   private int[] BC000F139_A87MigrLegNumero ;
   private int[] BC000F140_A3CliCod ;
   private short[] BC000F140_A1EmpCod ;
   private short[] BC000F140_A86TempRecSec ;
   private int[] BC000F141_A3CliCod ;
   private short[] BC000F141_A1EmpCod ;
   private java.util.Date[] BC000F141_A85ArchSiradigFec ;
   private int[] BC000F142_A3CliCod ;
   private short[] BC000F142_A1EmpCod ;
   private int[] BC000F142_A79AsientoCNum ;
   private int[] BC000F143_A3CliCod ;
   private short[] BC000F143_A1EmpCod ;
   private String[] BC000F143_A78CuenCodigo ;
   private int[] BC000F144_A3CliCod ;
   private short[] BC000F144_A1EmpCod ;
   private short[] BC000F144_A77CenCodigo ;
   private int[] BC000F145_A3CliCod ;
   private short[] BC000F145_A1EmpCod ;
   private int[] BC000F145_A31LiqNro ;
   private String[] BC000F145_A10LpgCodigo ;
   private int[] BC000F146_A3CliCod ;
   private short[] BC000F146_A1EmpCod ;
   private int[] BC000F146_A6LegNumero ;
   private String[] BC000F147_A683ActDescripSinAc ;
   private short[] BC000F147_A1EmpCod ;
   private String[] BC000F147_A2EmpNom ;
   private long[] BC000F147_A177EmpCUIT ;
   private short[] BC000F147_A125CatIvaCod ;
   private boolean[] BC000F147_n125CatIvaCod ;
   private String[] BC000F147_A126CatIvaDesc ;
   private boolean[] BC000F147_n126CatIvaDesc ;
   private String[] BC000F147_A178EmpDir ;
   private String[] BC000F147_A180EmpTel ;
   private boolean[] BC000F147_n180EmpTel ;
   private String[] BC000F147_A176EmpCP ;
   private boolean[] BC000F147_n176EmpCP ;
   private String[] BC000F147_A312PaiNom ;
   private String[] BC000F147_A322ProvNom ;
   private String[] BC000F147_A286LocNom ;
   private String[] BC000F147_A108ActDescrip ;
   private String[] BC000F147_A518EmpZonDescrip ;
   private boolean[] BC000F147_A532EmpReducc ;
   private String[] BC000F147_A530TipEmpleDefIns ;
   private String[] BC000F147_A955EmpLogo ;
   private boolean[] BC000F147_n955EmpLogo ;
   private String[] BC000F147_A958EmpFirma ;
   private boolean[] BC000F147_n958EmpFirma ;
   private java.math.BigDecimal[] BC000F147_A1140EmpAntiguedad ;
   private java.math.BigDecimal[] BC000F147_A1141EmpPresentismo ;
   private java.math.BigDecimal[] BC000F147_A1302EmpMesHsPExt ;
   private boolean[] BC000F147_n1302EmpMesHsPExt ;
   private String[] BC000F147_A1303EmpDiaHsPExt ;
   private boolean[] BC000F147_n1303EmpDiaHsPExt ;
   private byte[] BC000F147_A1811EmpPerVacDes ;
   private byte[] BC000F147_A1812EmpPerVacHas ;
   private boolean[] BC000F147_A1524EmpLiqFer ;
   private byte[] BC000F147_A1556EmpGuarEdadMin ;
   private byte[] BC000F147_A1557EmpGuarEdadMax ;
   private boolean[] BC000F147_A1750EmpLiqFerJor ;
   private boolean[] BC000F147_A1787EmpLiqGan ;
   private byte[] BC000F147_A1792EmpTipoExp ;
   private String[] BC000F147_A1802EmpPromDesde ;
   private java.math.BigDecimal[] BC000F147_A1813EmpFracVacAnt ;
   private byte[] BC000F147_A1972EmpUltSexoIng ;
   private boolean[] BC000F147_n1972EmpUltSexoIng ;
   private String[] BC000F147_A2405EmpModTra ;
   private String[] BC000F147_A957EmpLogoExt ;
   private boolean[] BC000F147_n957EmpLogoExt ;
   private String[] BC000F147_A960EmpFirmaExt ;
   private boolean[] BC000F147_n960EmpFirmaExt ;
   private String[] BC000F147_A956EmpLogoNom ;
   private boolean[] BC000F147_n956EmpLogoNom ;
   private String[] BC000F147_A959EmpFirmaNom ;
   private boolean[] BC000F147_n959EmpFirmaNom ;
   private short[] BC000F147_A46PaiCod ;
   private boolean[] BC000F147_n46PaiCod ;
   private short[] BC000F147_A47ProvCod ;
   private boolean[] BC000F147_n47ProvCod ;
   private short[] BC000F147_A48LocCod ;
   private boolean[] BC000F147_n48LocCod ;
   private int[] BC000F147_A3CliCod ;
   private String[] BC000F147_A43ActCodigo ;
   private boolean[] BC000F147_n43ActCodigo ;
   private String[] BC000F147_A45TipEmpleCod ;
   private boolean[] BC000F147_n45TipEmpleCod ;
   private short[] BC000F147_A1151ARTSec ;
   private String[] BC000F147_A903ActComCodigo ;
   private String[] BC000F147_A1965EmpOsoCod ;
   private boolean[] BC000F147_n1965EmpOsoCod ;
   private String[] BC000F147_A1533EmpActComercial ;
   private String[] BC000F147_A44EmpZonCod ;
   private boolean[] BC000F147_n44EmpZonCod ;
   private short[] BC000F147_A2265EmpCondiCod ;
   private boolean[] BC000F148_A1369EmpJorHabitual ;
   private int[] BC000F148_A3CliCod ;
   private String[] BC000F148_A1366EmpJorConCodigo ;
   private short[] BC000F148_A1EmpCod ;
   private String[] BC000F149_A26ConCodigo ;
   private int[] BC000F150_A3CliCod ;
   private short[] BC000F150_A1EmpCod ;
   private String[] BC000F150_A1366EmpJorConCodigo ;
   private boolean[] BC000F151_A1369EmpJorHabitual ;
   private int[] BC000F151_A3CliCod ;
   private String[] BC000F151_A1366EmpJorConCodigo ;
   private short[] BC000F151_A1EmpCod ;
   private boolean[] BC000F152_A1369EmpJorHabitual ;
   private int[] BC000F152_A3CliCod ;
   private String[] BC000F152_A1366EmpJorConCodigo ;
   private short[] BC000F152_A1EmpCod ;
   private boolean[] BC000F156_A1369EmpJorHabitual ;
   private int[] BC000F156_A3CliCod ;
   private String[] BC000F156_A1366EmpJorConCodigo ;
   private short[] BC000F156_A1EmpCod ;
   private boolean[] BC000F157_A1370EmpMenHabitual ;
   private int[] BC000F157_A3CliCod ;
   private String[] BC000F157_A1368EmpMenConCodigo ;
   private short[] BC000F157_A1EmpCod ;
   private String[] BC000F158_A26ConCodigo ;
   private int[] BC000F159_A3CliCod ;
   private short[] BC000F159_A1EmpCod ;
   private String[] BC000F159_A1368EmpMenConCodigo ;
   private boolean[] BC000F160_A1370EmpMenHabitual ;
   private int[] BC000F160_A3CliCod ;
   private String[] BC000F160_A1368EmpMenConCodigo ;
   private short[] BC000F160_A1EmpCod ;
   private boolean[] BC000F161_A1370EmpMenHabitual ;
   private int[] BC000F161_A3CliCod ;
   private String[] BC000F161_A1368EmpMenConCodigo ;
   private short[] BC000F161_A1EmpCod ;
   private boolean[] BC000F165_A1370EmpMenHabitual ;
   private int[] BC000F165_A3CliCod ;
   private String[] BC000F165_A1368EmpMenConCodigo ;
   private short[] BC000F165_A1EmpCod ;
   private int[] BC000F166_A3CliCod ;
   private short[] BC000F166_A1EmpCod ;
   private String[] BC000F166_A1371EmpPromFijVar ;
   private boolean[] BC000F166_A1372EmpPromHabitual ;
   private String[] BC000F166_A37TipoConCod ;
   private String[] BC000F167_A37TipoConCod ;
   private int[] BC000F168_A3CliCod ;
   private short[] BC000F168_A1EmpCod ;
   private String[] BC000F168_A37TipoConCod ;
   private String[] BC000F168_A1371EmpPromFijVar ;
   private int[] BC000F169_A3CliCod ;
   private short[] BC000F169_A1EmpCod ;
   private String[] BC000F169_A1371EmpPromFijVar ;
   private boolean[] BC000F169_A1372EmpPromHabitual ;
   private String[] BC000F169_A37TipoConCod ;
   private int[] BC000F170_A3CliCod ;
   private short[] BC000F170_A1EmpCod ;
   private String[] BC000F170_A1371EmpPromFijVar ;
   private boolean[] BC000F170_A1372EmpPromHabitual ;
   private String[] BC000F170_A37TipoConCod ;
   private int[] BC000F174_A3CliCod ;
   private short[] BC000F174_A1EmpCod ;
   private String[] BC000F174_A1371EmpPromFijVar ;
   private boolean[] BC000F174_A1372EmpPromHabitual ;
   private String[] BC000F174_A37TipoConCod ;
   private short[] BC000F175_A1340EmpHsExSec ;
   private byte[] BC000F175_A1341EmpHsPDiaDia ;
   private String[] BC000F175_A1342EmpHsPDiaDesde ;
   private boolean[] BC000F175_n1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] BC000F175_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] BC000F175_A1351EmpTarfaPDRec ;
   private int[] BC000F175_A3CliCod ;
   private short[] BC000F175_A1EmpCod ;
   private String[] BC000F175_A1339EmpHsPDiaTipTra ;
   private String[] BC000F176_A1294PaiTipoTraId ;
   private int[] BC000F177_A3CliCod ;
   private short[] BC000F177_A1EmpCod ;
   private short[] BC000F177_A1340EmpHsExSec ;
   private short[] BC000F178_A1340EmpHsExSec ;
   private byte[] BC000F178_A1341EmpHsPDiaDia ;
   private String[] BC000F178_A1342EmpHsPDiaDesde ;
   private boolean[] BC000F178_n1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] BC000F178_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] BC000F178_A1351EmpTarfaPDRec ;
   private int[] BC000F178_A3CliCod ;
   private short[] BC000F178_A1EmpCod ;
   private String[] BC000F178_A1339EmpHsPDiaTipTra ;
   private short[] BC000F179_A1340EmpHsExSec ;
   private byte[] BC000F179_A1341EmpHsPDiaDia ;
   private String[] BC000F179_A1342EmpHsPDiaDesde ;
   private boolean[] BC000F179_n1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] BC000F179_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] BC000F179_A1351EmpTarfaPDRec ;
   private int[] BC000F179_A3CliCod ;
   private short[] BC000F179_A1EmpCod ;
   private String[] BC000F179_A1339EmpHsPDiaTipTra ;
   private short[] BC000F183_A1340EmpHsExSec ;
   private byte[] BC000F183_A1341EmpHsPDiaDia ;
   private String[] BC000F183_A1342EmpHsPDiaDesde ;
   private boolean[] BC000F183_n1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] BC000F183_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] BC000F183_A1351EmpTarfaPDRec ;
   private int[] BC000F183_A3CliCod ;
   private short[] BC000F183_A1EmpCod ;
   private String[] BC000F183_A1339EmpHsPDiaTipTra ;
   private int[] BC000F184_A3CliCod ;
   private short[] BC000F184_A1EmpCod ;
   private java.math.BigDecimal[] BC000F184_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC000F184_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC000F184_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC000F184_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC000F184_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC000F184_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC000F184_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC000F184_A1389EmpHsMaxAnu ;
   private String[] BC000F184_A1294PaiTipoTraId ;
   private String[] BC000F185_A1292TipoTraId ;
   private int[] BC000F186_A3CliCod ;
   private short[] BC000F186_A1EmpCod ;
   private String[] BC000F186_A1294PaiTipoTraId ;
   private int[] BC000F187_A3CliCod ;
   private short[] BC000F187_A1EmpCod ;
   private java.math.BigDecimal[] BC000F187_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC000F187_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC000F187_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC000F187_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC000F187_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC000F187_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC000F187_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC000F187_A1389EmpHsMaxAnu ;
   private String[] BC000F187_A1294PaiTipoTraId ;
   private int[] BC000F188_A3CliCod ;
   private short[] BC000F188_A1EmpCod ;
   private java.math.BigDecimal[] BC000F188_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC000F188_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC000F188_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC000F188_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC000F188_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC000F188_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC000F188_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC000F188_A1389EmpHsMaxAnu ;
   private String[] BC000F188_A1294PaiTipoTraId ;
   private int[] BC000F192_A3CliCod ;
   private short[] BC000F192_A1EmpCod ;
   private short[] BC000F192_A1340EmpHsExSec ;
   private int[] BC000F193_A3CliCod ;
   private short[] BC000F193_A1EmpCod ;
   private java.math.BigDecimal[] BC000F193_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC000F193_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC000F193_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC000F193_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC000F193_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC000F193_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC000F193_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC000F193_A1389EmpHsMaxAnu ;
   private String[] BC000F193_A1294PaiTipoTraId ;
   private int[] BC000F194_A3CliCod ;
   private short[] BC000F194_A1EmpCod ;
   private String[] BC000F194_A1239EmpConvenio ;
   private int[] BC000F195_A3CliCod ;
   private short[] BC000F195_A1EmpCod ;
   private String[] BC000F195_A1239EmpConvenio ;
   private int[] BC000F196_A3CliCod ;
   private short[] BC000F196_A1EmpCod ;
   private String[] BC000F196_A1239EmpConvenio ;
   private int[] BC000F197_A3CliCod ;
   private short[] BC000F197_A1EmpCod ;
   private String[] BC000F197_A1239EmpConvenio ;
   private int[] BC000F200_A3CliCod ;
   private short[] BC000F200_A1EmpCod ;
   private String[] BC000F200_A1239EmpConvenio ;
   private int[] BC000F201_A3CliCod ;
   private short[] BC000F201_A1EmpCod ;
   private String[] BC000F201_A1238EmpOrigen ;
   private String[] BC000F202_A1231OrigId ;
   private int[] BC000F203_A3CliCod ;
   private short[] BC000F203_A1EmpCod ;
   private String[] BC000F203_A1238EmpOrigen ;
   private int[] BC000F204_A3CliCod ;
   private short[] BC000F204_A1EmpCod ;
   private String[] BC000F204_A1238EmpOrigen ;
   private int[] BC000F205_A3CliCod ;
   private short[] BC000F205_A1EmpCod ;
   private String[] BC000F205_A1238EmpOrigen ;
   private int[] BC000F208_A3CliCod ;
   private short[] BC000F208_A1EmpCod ;
   private String[] BC000F208_A1238EmpOrigen ;
   private int[] BC000F209_A3CliCod ;
   private short[] BC000F209_A1EmpCod ;
   private String[] BC000F209_A1237EmpReligion ;
   private String[] BC000F210_A1229ReligId ;
   private int[] BC000F211_A3CliCod ;
   private short[] BC000F211_A1EmpCod ;
   private String[] BC000F211_A1237EmpReligion ;
   private int[] BC000F212_A3CliCod ;
   private short[] BC000F212_A1EmpCod ;
   private String[] BC000F212_A1237EmpReligion ;
   private int[] BC000F213_A3CliCod ;
   private short[] BC000F213_A1EmpCod ;
   private String[] BC000F213_A1237EmpReligion ;
   private int[] BC000F216_A3CliCod ;
   private short[] BC000F216_A1EmpCod ;
   private String[] BC000F216_A1237EmpReligion ;
   private int[] BC000F217_A3CliCod ;
   private int[] BC000F218_A3CliCod ;
   private int[] BC000F2_A3CliCod ;
   private short[] BC000F2_A1EmpCod ;
   private String[] BC000F2_A1237EmpReligion ;
   private int[] BC000F3_A3CliCod ;
   private short[] BC000F3_A1EmpCod ;
   private String[] BC000F3_A1237EmpReligion ;
   private String[] BC000F4_A1229ReligId ;
   private int[] BC000F5_A3CliCod ;
   private short[] BC000F5_A1EmpCod ;
   private String[] BC000F5_A1238EmpOrigen ;
   private int[] BC000F6_A3CliCod ;
   private short[] BC000F6_A1EmpCod ;
   private String[] BC000F6_A1238EmpOrigen ;
   private String[] BC000F7_A1231OrigId ;
   private int[] BC000F8_A3CliCod ;
   private short[] BC000F8_A1EmpCod ;
   private String[] BC000F8_A1239EmpConvenio ;
   private int[] BC000F9_A3CliCod ;
   private short[] BC000F9_A1EmpCod ;
   private String[] BC000F9_A1239EmpConvenio ;
   private int[] BC000F10_A3CliCod ;
   private short[] BC000F10_A1EmpCod ;
   private java.math.BigDecimal[] BC000F10_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC000F10_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC000F10_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC000F10_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC000F10_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC000F10_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC000F10_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC000F10_A1389EmpHsMaxAnu ;
   private String[] BC000F10_A1294PaiTipoTraId ;
   private int[] BC000F11_A3CliCod ;
   private short[] BC000F11_A1EmpCod ;
   private java.math.BigDecimal[] BC000F11_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC000F11_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC000F11_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC000F11_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC000F11_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC000F11_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC000F11_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC000F11_A1389EmpHsMaxAnu ;
   private String[] BC000F11_A1294PaiTipoTraId ;
   private String[] BC000F12_A1292TipoTraId ;
   private short[] BC000F13_A1340EmpHsExSec ;
   private byte[] BC000F13_A1341EmpHsPDiaDia ;
   private String[] BC000F13_A1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] BC000F13_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] BC000F13_A1351EmpTarfaPDRec ;
   private int[] BC000F13_A3CliCod ;
   private short[] BC000F13_A1EmpCod ;
   private String[] BC000F13_A1339EmpHsPDiaTipTra ;
   private short[] BC000F14_A1340EmpHsExSec ;
   private byte[] BC000F14_A1341EmpHsPDiaDia ;
   private String[] BC000F14_A1342EmpHsPDiaDesde ;
   private java.math.BigDecimal[] BC000F14_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] BC000F14_A1351EmpTarfaPDRec ;
   private int[] BC000F14_A3CliCod ;
   private short[] BC000F14_A1EmpCod ;
   private String[] BC000F14_A1339EmpHsPDiaTipTra ;
   private int[] BC000F15_A3CliCod ;
   private short[] BC000F15_A1EmpCod ;
   private java.math.BigDecimal[] BC000F15_A1344EmpHsDia ;
   private java.math.BigDecimal[] BC000F15_A1345EmpHsSem ;
   private java.math.BigDecimal[] BC000F15_A1346EmpTarifaXLim ;
   private java.math.BigDecimal[] BC000F15_A1352EmpTarifaRec ;
   private java.math.BigDecimal[] BC000F15_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] BC000F15_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] BC000F15_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] BC000F15_A1389EmpHsMaxAnu ;
   private String[] BC000F15_A1294PaiTipoTraId ;
   private int[] BC000F16_A3CliCod ;
   private short[] BC000F16_A1EmpCod ;
   private String[] BC000F16_A1371EmpPromFijVar ;
   private boolean[] BC000F16_A1372EmpPromHabitual ;
   private String[] BC000F16_A37TipoConCod ;
   private int[] BC000F17_A3CliCod ;
   private short[] BC000F17_A1EmpCod ;
   private String[] BC000F17_A1371EmpPromFijVar ;
   private boolean[] BC000F17_A1372EmpPromHabitual ;
   private String[] BC000F17_A37TipoConCod ;
   private String[] BC000F18_A37TipoConCod ;
   private boolean[] BC000F19_A1370EmpMenHabitual ;
   private int[] BC000F19_A3CliCod ;
   private String[] BC000F19_A1368EmpMenConCodigo ;
   private short[] BC000F19_A1EmpCod ;
   private boolean[] BC000F20_A1370EmpMenHabitual ;
   private int[] BC000F20_A3CliCod ;
   private String[] BC000F20_A1368EmpMenConCodigo ;
   private short[] BC000F20_A1EmpCod ;
   private String[] BC000F21_A26ConCodigo ;
   private boolean[] BC000F22_A1369EmpJorHabitual ;
   private int[] BC000F22_A3CliCod ;
   private String[] BC000F22_A1366EmpJorConCodigo ;
   private short[] BC000F22_A1EmpCod ;
   private boolean[] BC000F23_A1369EmpJorHabitual ;
   private int[] BC000F23_A3CliCod ;
   private String[] BC000F23_A1366EmpJorConCodigo ;
   private short[] BC000F23_A1EmpCod ;
   private String[] BC000F24_A26ConCodigo ;
   private short[] BC000F25_A1EmpCod ;
   private String[] BC000F25_A2EmpNom ;
   private long[] BC000F25_A177EmpCUIT ;
   private short[] BC000F25_A125CatIvaCod ;
   private String[] BC000F25_A126CatIvaDesc ;
   private String[] BC000F25_A178EmpDir ;
   private String[] BC000F25_A180EmpTel ;
   private String[] BC000F25_A176EmpCP ;
   private boolean[] BC000F25_A532EmpReducc ;
   private String[] BC000F25_A955EmpLogo ;
   private String[] BC000F25_A958EmpFirma ;
   private java.math.BigDecimal[] BC000F25_A1140EmpAntiguedad ;
   private java.math.BigDecimal[] BC000F25_A1141EmpPresentismo ;
   private java.math.BigDecimal[] BC000F25_A1302EmpMesHsPExt ;
   private String[] BC000F25_A1303EmpDiaHsPExt ;
   private byte[] BC000F25_A1811EmpPerVacDes ;
   private byte[] BC000F25_A1812EmpPerVacHas ;
   private boolean[] BC000F25_A1524EmpLiqFer ;
   private byte[] BC000F25_A1556EmpGuarEdadMin ;
   private byte[] BC000F25_A1557EmpGuarEdadMax ;
   private boolean[] BC000F25_A1750EmpLiqFerJor ;
   private boolean[] BC000F25_A1787EmpLiqGan ;
   private byte[] BC000F25_A1792EmpTipoExp ;
   private String[] BC000F25_A1802EmpPromDesde ;
   private java.math.BigDecimal[] BC000F25_A1813EmpFracVacAnt ;
   private byte[] BC000F25_A1972EmpUltSexoIng ;
   private String[] BC000F25_A2405EmpModTra ;
   private String[] BC000F25_A957EmpLogoExt ;
   private String[] BC000F25_A960EmpFirmaExt ;
   private String[] BC000F25_A956EmpLogoNom ;
   private String[] BC000F25_A959EmpFirmaNom ;
   private short[] BC000F25_A46PaiCod ;
   private short[] BC000F25_A47ProvCod ;
   private short[] BC000F25_A48LocCod ;
   private int[] BC000F25_A3CliCod ;
   private String[] BC000F25_A43ActCodigo ;
   private String[] BC000F25_A45TipEmpleCod ;
   private short[] BC000F25_A1151ARTSec ;
   private String[] BC000F25_A903ActComCodigo ;
   private String[] BC000F25_A1965EmpOsoCod ;
   private String[] BC000F25_A1533EmpActComercial ;
   private String[] BC000F25_A44EmpZonCod ;
   private short[] BC000F25_A2265EmpCondiCod ;
   private short[] BC000F26_A1EmpCod ;
   private String[] BC000F26_A2EmpNom ;
   private long[] BC000F26_A177EmpCUIT ;
   private short[] BC000F26_A125CatIvaCod ;
   private String[] BC000F26_A126CatIvaDesc ;
   private String[] BC000F26_A178EmpDir ;
   private String[] BC000F26_A180EmpTel ;
   private String[] BC000F26_A176EmpCP ;
   private boolean[] BC000F26_A532EmpReducc ;
   private String[] BC000F26_A955EmpLogo ;
   private String[] BC000F26_A958EmpFirma ;
   private java.math.BigDecimal[] BC000F26_A1140EmpAntiguedad ;
   private java.math.BigDecimal[] BC000F26_A1141EmpPresentismo ;
   private java.math.BigDecimal[] BC000F26_A1302EmpMesHsPExt ;
   private String[] BC000F26_A1303EmpDiaHsPExt ;
   private byte[] BC000F26_A1811EmpPerVacDes ;
   private byte[] BC000F26_A1812EmpPerVacHas ;
   private boolean[] BC000F26_A1524EmpLiqFer ;
   private byte[] BC000F26_A1556EmpGuarEdadMin ;
   private byte[] BC000F26_A1557EmpGuarEdadMax ;
   private boolean[] BC000F26_A1750EmpLiqFerJor ;
   private boolean[] BC000F26_A1787EmpLiqGan ;
   private byte[] BC000F26_A1792EmpTipoExp ;
   private String[] BC000F26_A1802EmpPromDesde ;
   private java.math.BigDecimal[] BC000F26_A1813EmpFracVacAnt ;
   private byte[] BC000F26_A1972EmpUltSexoIng ;
   private String[] BC000F26_A2405EmpModTra ;
   private String[] BC000F26_A957EmpLogoExt ;
   private String[] BC000F26_A960EmpFirmaExt ;
   private String[] BC000F26_A956EmpLogoNom ;
   private String[] BC000F26_A959EmpFirmaNom ;
   private short[] BC000F26_A46PaiCod ;
   private short[] BC000F26_A47ProvCod ;
   private short[] BC000F26_A48LocCod ;
   private int[] BC000F26_A3CliCod ;
   private String[] BC000F26_A43ActCodigo ;
   private String[] BC000F26_A45TipEmpleCod ;
   private short[] BC000F26_A1151ARTSec ;
   private String[] BC000F26_A903ActComCodigo ;
   private String[] BC000F26_A1965EmpOsoCod ;
   private String[] BC000F26_A1533EmpActComercial ;
   private String[] BC000F26_A44EmpZonCod ;
   private short[] BC000F26_A2265EmpCondiCod ;
   private String[] BC000F27_A312PaiNom ;
   private String[] BC000F28_A322ProvNom ;
   private String[] BC000F29_A286LocNom ;
   private int[] BC000F30_A3CliCod ;
   private String[] BC000F31_A683ActDescripSinAc ;
   private String[] BC000F31_A108ActDescrip ;
   private String[] BC000F32_A530TipEmpleDefIns ;
   private short[] BC000F33_A1151ARTSec ;
   private String[] BC000F34_A903ActComCodigo ;
   private int[] BC000F35_A3CliCod ;
   private String[] BC000F36_A1533EmpActComercial ;
   private String[] BC000F37_A518EmpZonDescrip ;
   private short[] BC000F38_A2265EmpCondiCod ;
   private boolean[] BC000F13_n1342EmpHsPDiaDesde ;
   private boolean[] BC000F14_n1342EmpHsPDiaDesde ;
   private boolean[] BC000F25_n125CatIvaCod ;
   private boolean[] BC000F25_n126CatIvaDesc ;
   private boolean[] BC000F25_n180EmpTel ;
   private boolean[] BC000F25_n176EmpCP ;
   private boolean[] BC000F25_n955EmpLogo ;
   private boolean[] BC000F25_n958EmpFirma ;
   private boolean[] BC000F25_n1302EmpMesHsPExt ;
   private boolean[] BC000F25_n1303EmpDiaHsPExt ;
   private boolean[] BC000F25_n1972EmpUltSexoIng ;
   private boolean[] BC000F25_n957EmpLogoExt ;
   private boolean[] BC000F25_n960EmpFirmaExt ;
   private boolean[] BC000F25_n956EmpLogoNom ;
   private boolean[] BC000F25_n959EmpFirmaNom ;
   private boolean[] BC000F25_n46PaiCod ;
   private boolean[] BC000F25_n47ProvCod ;
   private boolean[] BC000F25_n48LocCod ;
   private boolean[] BC000F25_n43ActCodigo ;
   private boolean[] BC000F25_n45TipEmpleCod ;
   private boolean[] BC000F25_n1965EmpOsoCod ;
   private boolean[] BC000F25_n44EmpZonCod ;
   private boolean[] BC000F26_n125CatIvaCod ;
   private boolean[] BC000F26_n126CatIvaDesc ;
   private boolean[] BC000F26_n180EmpTel ;
   private boolean[] BC000F26_n176EmpCP ;
   private boolean[] BC000F26_n955EmpLogo ;
   private boolean[] BC000F26_n958EmpFirma ;
   private boolean[] BC000F26_n1302EmpMesHsPExt ;
   private boolean[] BC000F26_n1303EmpDiaHsPExt ;
   private boolean[] BC000F26_n1972EmpUltSexoIng ;
   private boolean[] BC000F26_n957EmpLogoExt ;
   private boolean[] BC000F26_n960EmpFirmaExt ;
   private boolean[] BC000F26_n956EmpLogoNom ;
   private boolean[] BC000F26_n959EmpFirmaNom ;
   private boolean[] BC000F26_n46PaiCod ;
   private boolean[] BC000F26_n47ProvCod ;
   private boolean[] BC000F26_n48LocCod ;
   private boolean[] BC000F26_n43ActCodigo ;
   private boolean[] BC000F26_n45TipEmpleCod ;
   private boolean[] BC000F26_n1965EmpOsoCod ;
   private boolean[] BC000F26_n44EmpZonCod ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV15TrnContextAtt ;
}

final  class empresa_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000F2", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ?  FOR UPDATE OF Empresanolaborables_religion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F3", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F4", "SELECT ReligId FROM Religion WHERE ReligId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F5", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ?  FOR UPDATE OF Empresanolaborables_origen",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F6", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F7", "SELECT OrigId FROM Origen WHERE OrigId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F8", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? AND EmpCod = ? AND EmpConvenio = ?  FOR UPDATE OF Empresanolaborables_convenio",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F9", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? AND EmpCod = ? AND EmpConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F10", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?  FOR UPDATE OF Empresatipo_trabajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F11", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F12", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F13", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ?  FOR UPDATE OF Empresahorasextras_pordia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F14", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F15", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?  FOR UPDATE OF Empresatipo_trabajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F16", "SELECT CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ?  FOR UPDATE OF Empresapromedio_horanormal_mensualizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F17", "SELECT CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F18", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F19", "SELECT EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ?  FOR UPDATE OF Empresaconceptos_horanormal_mensualizado",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F20", "SELECT EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F21", "SELECT ConCodigo FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F22", "SELECT EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ?  FOR UPDATE OF Empresaconceptos_horanormal_jornalizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F23", "SELECT EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F24", "SELECT ConCodigo FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F25", "SELECT EmpCod, EmpNom, EmpCUIT, CatIvaCod, CatIvaDesc, EmpDir, EmpTel, EmpCP, EmpReducc, EmpLogo, EmpFirma, EmpAntiguedad, EmpPresentismo, EmpMesHsPExt, EmpDiaHsPExt, EmpPerVacDes, EmpPerVacHas, EmpLiqFer, EmpGuarEdadMin, EmpGuarEdadMax, EmpLiqFerJor, EmpLiqGan, EmpTipoExp, EmpPromDesde, EmpFracVacAnt, EmpUltSexoIng, EmpModTra, EmpLogoExt, EmpFirmaExt, EmpLogoNom, EmpFirmaNom, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, ARTSec, ActComCodigo, EmpOsoCod, EmpActComercial, EmpZonCod, EmpCondiCod FROM Empresa WHERE CliCod = ? AND EmpCod = ?  FOR UPDATE OF Empresa",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F26", "SELECT EmpCod, EmpNom, EmpCUIT, CatIvaCod, CatIvaDesc, EmpDir, EmpTel, EmpCP, EmpReducc, EmpLogo, EmpFirma, EmpAntiguedad, EmpPresentismo, EmpMesHsPExt, EmpDiaHsPExt, EmpPerVacDes, EmpPerVacHas, EmpLiqFer, EmpGuarEdadMin, EmpGuarEdadMax, EmpLiqFerJor, EmpLiqGan, EmpTipoExp, EmpPromDesde, EmpFracVacAnt, EmpUltSexoIng, EmpModTra, EmpLogoExt, EmpFirmaExt, EmpLogoNom, EmpFirmaNom, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, ARTSec, ActComCodigo, EmpOsoCod, EmpActComercial, EmpZonCod, EmpCondiCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F27", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F28", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F29", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F30", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F31", "SELECT ActDescripSinAc, ActDescrip FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F32", "SELECT TipEmpleDefIns FROM TipoEmpleador WHERE TipEmpleCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F33", "SELECT ARTSec FROM ART WHERE ARTSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F34", "SELECT ActComCodigo FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F35", "SELECT CliCod FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F36", "SELECT ActComCodigo AS EmpActComercial FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F37", "SELECT ZonDescrip AS EmpZonDescrip FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F38", "SELECT CondiCodigo AS EmpCondiCod FROM CondicionAFIP WHERE CondiCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F39", "SELECT T5.ActDescripSinAc, TM1.EmpCod, TM1.EmpNom, TM1.EmpCUIT, TM1.CatIvaCod, TM1.CatIvaDesc, TM1.EmpDir, TM1.EmpTel, TM1.EmpCP, T2.PaiNom, T3.ProvNom, T4.LocNom, T5.ActDescrip, T7.ZonDescrip AS EmpZonDescrip, TM1.EmpReducc, T6.TipEmpleDefIns, TM1.EmpLogo, TM1.EmpFirma, TM1.EmpAntiguedad, TM1.EmpPresentismo, TM1.EmpMesHsPExt, TM1.EmpDiaHsPExt, TM1.EmpPerVacDes, TM1.EmpPerVacHas, TM1.EmpLiqFer, TM1.EmpGuarEdadMin, TM1.EmpGuarEdadMax, TM1.EmpLiqFerJor, TM1.EmpLiqGan, TM1.EmpTipoExp, TM1.EmpPromDesde, TM1.EmpFracVacAnt, TM1.EmpUltSexoIng, TM1.EmpModTra, TM1.EmpLogoExt, TM1.EmpFirmaExt, TM1.EmpLogoNom, TM1.EmpFirmaNom, TM1.PaiCod, TM1.ProvCod, TM1.LocCod, TM1.CliCod, TM1.ActCodigo, TM1.TipEmpleCod, TM1.ARTSec, TM1.ActComCodigo, TM1.EmpOsoCod AS EmpOsoCod, TM1.EmpActComercial AS EmpActComercial, TM1.EmpZonCod AS EmpZonCod, TM1.EmpCondiCod AS EmpCondiCod FROM ((((((Empresa TM1 LEFT JOIN Pais T2 ON T2.PaiCod = TM1.PaiCod) LEFT JOIN Provincia T3 ON T3.PaiCod = TM1.PaiCod AND T3.ProvCod = TM1.ProvCod) LEFT JOIN Localidad T4 ON T4.PaiCod = TM1.PaiCod AND T4.ProvCod = TM1.ProvCod AND T4.LocCod = TM1.LocCod) LEFT JOIN Actividad T5 ON T5.ActCodigo = TM1.ActCodigo) LEFT JOIN TipoEmpleador T6 ON T6.TipEmpleCod = TM1.TipEmpleCod) LEFT JOIN Zona T7 ON T7.ZonCod = TM1.EmpZonCod) WHERE TM1.EmpCod = ? and TM1.CliCod = ? ORDER BY TM1.CliCod, TM1.EmpCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F40", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F41", "SELECT CliCod FROM ObraSocial WHERE CliCod = ? AND OsoCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F42", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F43", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F44", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F45", "SELECT ActDescripSinAc, ActDescrip FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F46", "SELECT TipEmpleDefIns FROM TipoEmpleador WHERE TipEmpleCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F47", "SELECT ZonDescrip AS EmpZonDescrip FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F48", "SELECT ActComCodigo AS EmpActComercial FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F49", "SELECT ARTSec FROM ART WHERE ARTSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F50", "SELECT ActComCodigo FROM actividadcomercial WHERE ActComCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F51", "SELECT CondiCodigo AS EmpCondiCod FROM CondicionAFIP WHERE CondiCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F52", "SELECT CliCod, EmpCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F53", "SELECT EmpCod, EmpNom, EmpCUIT, CatIvaCod, CatIvaDesc, EmpDir, EmpTel, EmpCP, EmpReducc, EmpLogo, EmpFirma, EmpAntiguedad, EmpPresentismo, EmpMesHsPExt, EmpDiaHsPExt, EmpPerVacDes, EmpPerVacHas, EmpLiqFer, EmpGuarEdadMin, EmpGuarEdadMax, EmpLiqFerJor, EmpLiqGan, EmpTipoExp, EmpPromDesde, EmpFracVacAnt, EmpUltSexoIng, EmpModTra, EmpLogoExt, EmpFirmaExt, EmpLogoNom, EmpFirmaNom, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, ARTSec, ActComCodigo, EmpOsoCod, EmpActComercial, EmpZonCod, EmpCondiCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F54", "SELECT EmpCod, EmpNom, EmpCUIT, CatIvaCod, CatIvaDesc, EmpDir, EmpTel, EmpCP, EmpReducc, EmpLogo, EmpFirma, EmpAntiguedad, EmpPresentismo, EmpMesHsPExt, EmpDiaHsPExt, EmpPerVacDes, EmpPerVacHas, EmpLiqFer, EmpGuarEdadMin, EmpGuarEdadMax, EmpLiqFerJor, EmpLiqGan, EmpTipoExp, EmpPromDesde, EmpFracVacAnt, EmpUltSexoIng, EmpModTra, EmpLogoExt, EmpFirmaExt, EmpLogoNom, EmpFirmaNom, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, ARTSec, ActComCodigo, EmpOsoCod, EmpActComercial, EmpZonCod, EmpCondiCod FROM Empresa WHERE CliCod = ? AND EmpCod = ?  FOR UPDATE OF Empresa",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000F55", "SAVEPOINT gxupdate;INSERT INTO Empresa(EmpCod, EmpNom, EmpCUIT, CatIvaCod, CatIvaDesc, EmpDir, EmpTel, EmpCP, EmpReducc, EmpLogo, EmpFirma, EmpAntiguedad, EmpPresentismo, EmpMesHsPExt, EmpDiaHsPExt, EmpPerVacDes, EmpPerVacHas, EmpLiqFer, EmpGuarEdadMin, EmpGuarEdadMax, EmpLiqFerJor, EmpLiqGan, EmpTipoExp, EmpPromDesde, EmpFracVacAnt, EmpUltSexoIng, EmpModTra, EmpLogoExt, EmpFirmaExt, EmpLogoNom, EmpFirmaNom, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, ARTSec, ActComCodigo, EmpOsoCod, EmpActComercial, EmpZonCod, EmpCondiCod, EmpVacExpLim, EmpVacExpTie, EmpVacDisMax, EmpModEmpl, EmpModAuto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE, 0, 0, FALSE, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F56", "SAVEPOINT gxupdate;UPDATE Empresa SET EmpNom=?, EmpCUIT=?, CatIvaCod=?, CatIvaDesc=?, EmpDir=?, EmpTel=?, EmpCP=?, EmpReducc=?, EmpAntiguedad=?, EmpPresentismo=?, EmpMesHsPExt=?, EmpDiaHsPExt=?, EmpPerVacDes=?, EmpPerVacHas=?, EmpLiqFer=?, EmpGuarEdadMin=?, EmpGuarEdadMax=?, EmpLiqFerJor=?, EmpLiqGan=?, EmpTipoExp=?, EmpPromDesde=?, EmpFracVacAnt=?, EmpUltSexoIng=?, EmpModTra=?, EmpLogoExt=?, EmpFirmaExt=?, EmpLogoNom=?, EmpFirmaNom=?, PaiCod=?, ProvCod=?, LocCod=?, ActCodigo=?, TipEmpleCod=?, ARTSec=?, ActComCodigo=?, EmpOsoCod=?, EmpActComercial=?, EmpZonCod=?, EmpCondiCod=?  WHERE CliCod = ? AND EmpCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F57", "SAVEPOINT gxupdate;UPDATE Empresa SET EmpLogo=?  WHERE CliCod = ? AND EmpCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F58", "SAVEPOINT gxupdate;UPDATE Empresa SET EmpFirma=?  WHERE CliCod = ? AND EmpCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F59", "SAVEPOINT gxupdate;DELETE FROM Empresa  WHERE CliCod = ? AND EmpCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000F60", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F61", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F62", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F63", "SELECT ActDescripSinAc, ActDescrip FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F64", "SELECT TipEmpleDefIns FROM TipoEmpleador WHERE TipEmpleCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F65", "SELECT ZonDescrip AS EmpZonDescrip FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F66", "SELECT CliCod, EmpCod, BanSalCod FROM banda_salarial WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F67", "SELECT CliCod, EmpCod, ColaUUID FROM Cola WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F68", "SELECT CliCod, EmpCod, LiqBatchLiqNro, LiqBatchCod, LiqBatchSeccion FROM LiquidacionLotes3 WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F69", "SELECT CliCod, EmpCod, LiqLoteLiqNro, LiqLote FROM LiquidacionLotes2 WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F70", "SELECT CliCod, EmpCod, LiqNro, LinkLegNumero, LegLinkTiporec FROM LiquidacionLegajoLinkPdf WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F71", "SELECT CliCod, EmpCod, LiqNro, LiqSuc FROM LiquidacionSucursal WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F72", "SELECT CliCod, EmpCod, LiqNro, LiqArea FROM LiquidacionArea WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F73", "SELECT CliCod, EmpCod, LiqNro, LiqPaiConve, LiqConvenio FROM LiquidacionConvenio WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F74", "SELECT CliCod, EmpCod, EmpBanCod FROM EmpresaBancos WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F75", "SELECT CliCod, EmpCod, PeriodoLiq FROM Periodo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F76", "SELECT CliCod, EmpCod, LSDSec FROM LSD_reg1 WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F77", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE EmpConveVer = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F78", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F79", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F80", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F81", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F82", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F83", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F84", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F85", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F86", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F87", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F88", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F89", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F90", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F91", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F92", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F93", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F94", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F95", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F96", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F97", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F98", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F99", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F100", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F101", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F102", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F103", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F104", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F105", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F106", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F107", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F108", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F109", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F110", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F111", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F112", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F113", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F114", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F115", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F116", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F117", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F118", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F119", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F120", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F121", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F122", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F123", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F124", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F125", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F126", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F127", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F128", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F129", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F130", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F131", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F132", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F133", "SELECT CliCod, EmpCod, GuarCod FROM EmpresaGuarderias WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F134", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F135", "SELECT CliCod, EmpCod, EmpHsExSec FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F136", "SELECT CliCod, EmpCod, SucCodigo FROM Sucursal WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F137", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357Cab WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F138", "SELECT CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F139", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F140", "SELECT CliCod, EmpCod, TempRecSec FROM TemplateRecibo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F141", "SELECT CliCod, EmpCod, ArchSiradigFec FROM archivo_siradig WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F142", "SELECT CliCod, EmpCod, AsientoCNum FROM AsientoCab WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F143", "SELECT CliCod, EmpCod, CuenCodigo FROM CuentaContable WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F144", "SELECT CliCod, EmpCod, CenCodigo FROM CentroDeCosto WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F145", "SELECT CliCod, EmpCod, LiqNro, LpgCodigo FROM LiquidacionLugarPago WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F146", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F147", "SELECT T5.ActDescripSinAc, TM1.EmpCod, TM1.EmpNom, TM1.EmpCUIT, TM1.CatIvaCod, TM1.CatIvaDesc, TM1.EmpDir, TM1.EmpTel, TM1.EmpCP, T2.PaiNom, T3.ProvNom, T4.LocNom, T5.ActDescrip, T7.ZonDescrip AS EmpZonDescrip, TM1.EmpReducc, T6.TipEmpleDefIns, TM1.EmpLogo, TM1.EmpFirma, TM1.EmpAntiguedad, TM1.EmpPresentismo, TM1.EmpMesHsPExt, TM1.EmpDiaHsPExt, TM1.EmpPerVacDes, TM1.EmpPerVacHas, TM1.EmpLiqFer, TM1.EmpGuarEdadMin, TM1.EmpGuarEdadMax, TM1.EmpLiqFerJor, TM1.EmpLiqGan, TM1.EmpTipoExp, TM1.EmpPromDesde, TM1.EmpFracVacAnt, TM1.EmpUltSexoIng, TM1.EmpModTra, TM1.EmpLogoExt, TM1.EmpFirmaExt, TM1.EmpLogoNom, TM1.EmpFirmaNom, TM1.PaiCod, TM1.ProvCod, TM1.LocCod, TM1.CliCod, TM1.ActCodigo, TM1.TipEmpleCod, TM1.ARTSec, TM1.ActComCodigo, TM1.EmpOsoCod AS EmpOsoCod, TM1.EmpActComercial AS EmpActComercial, TM1.EmpZonCod AS EmpZonCod, TM1.EmpCondiCod AS EmpCondiCod FROM ((((((Empresa TM1 LEFT JOIN Pais T2 ON T2.PaiCod = TM1.PaiCod) LEFT JOIN Provincia T3 ON T3.PaiCod = TM1.PaiCod AND T3.ProvCod = TM1.ProvCod) LEFT JOIN Localidad T4 ON T4.PaiCod = TM1.PaiCod AND T4.ProvCod = TM1.ProvCod AND T4.LocCod = TM1.LocCod) LEFT JOIN Actividad T5 ON T5.ActCodigo = TM1.ActCodigo) LEFT JOIN TipoEmpleador T6 ON T6.TipEmpleCod = TM1.TipEmpleCod) LEFT JOIN Zona T7 ON T7.ZonCod = TM1.EmpZonCod) WHERE TM1.EmpCod = ? and TM1.CliCod = ? ORDER BY TM1.CliCod, TM1.EmpCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F148", "SELECT EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? and EmpCod = ? and EmpJorConCodigo = ( ?) ORDER BY CliCod, EmpCod, EmpJorConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F149", "SELECT ConCodigo FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F150", "SELECT CliCod, EmpCod, EmpJorConCodigo FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F151", "SELECT EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F152", "SELECT EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ?  FOR UPDATE OF Empresaconceptos_horanormal_jornalizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000F153", "SAVEPOINT gxupdate;INSERT INTO Empresaconceptos_horanormal_jornalizados(EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F154", "SAVEPOINT gxupdate;UPDATE Empresaconceptos_horanormal_jornalizados SET EmpJorHabitual=?  WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F155", "SAVEPOINT gxupdate;DELETE FROM Empresaconceptos_horanormal_jornalizados  WHERE CliCod = ? AND EmpCod = ? AND EmpJorConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000F156", "SELECT EmpJorHabitual, CliCod, EmpJorConCodigo, EmpCod FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpJorConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F157", "SELECT EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? and EmpCod = ? and EmpMenConCodigo = ( ?) ORDER BY CliCod, EmpCod, EmpMenConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F158", "SELECT ConCodigo FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F159", "SELECT CliCod, EmpCod, EmpMenConCodigo FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F160", "SELECT EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F161", "SELECT EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ?  FOR UPDATE OF Empresaconceptos_horanormal_mensualizado",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000F162", "SAVEPOINT gxupdate;INSERT INTO Empresaconceptos_horanormal_mensualizado(EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F163", "SAVEPOINT gxupdate;UPDATE Empresaconceptos_horanormal_mensualizado SET EmpMenHabitual=?  WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F164", "SAVEPOINT gxupdate;DELETE FROM Empresaconceptos_horanormal_mensualizado  WHERE CliCod = ? AND EmpCod = ? AND EmpMenConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000F165", "SELECT EmpMenHabitual, CliCod, EmpMenConCodigo, EmpCod FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpMenConCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F166", "SELECT CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? and EmpCod = ? and TipoConCod = ( ?) and EmpPromFijVar = ( ?) ORDER BY CliCod, EmpCod, TipoConCod, EmpPromFijVar ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F167", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F168", "SELECT CliCod, EmpCod, TipoConCod, EmpPromFijVar FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F169", "SELECT CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F170", "SELECT CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ?  FOR UPDATE OF Empresapromedio_horanormal_mensualizados",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000F171", "SAVEPOINT gxupdate;INSERT INTO Empresapromedio_horanormal_mensualizados(CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F172", "SAVEPOINT gxupdate;UPDATE Empresapromedio_horanormal_mensualizados SET EmpPromHabitual=?  WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F173", "SAVEPOINT gxupdate;DELETE FROM Empresapromedio_horanormal_mensualizados  WHERE CliCod = ? AND EmpCod = ? AND TipoConCod = ? AND EmpPromFijVar = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000F174", "SELECT CliCod, EmpCod, EmpPromFijVar, EmpPromHabitual, TipoConCod FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, TipoConCod, EmpPromFijVar ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F175", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? and EmpCod = ? and EmpHsExSec = ? ORDER BY CliCod, EmpCod, EmpHsExSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F176", "SELECT PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?  FOR UPDATE OF Empresatipo_trabajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F177", "SELECT CliCod, EmpCod, EmpHsExSec FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F178", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F179", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ?  FOR UPDATE OF Empresahorasextras_pordia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000F180", "SAVEPOINT gxupdate;INSERT INTO Empresahorasextras_pordia(EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra, EmpHsPDiaRelSec, EmpTarifaPDCri) VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F181", "SAVEPOINT gxupdate;UPDATE Empresahorasextras_pordia SET EmpHsPDiaDia=?, EmpHsPDiaDesde=?, EmpTarifaPDia=?, EmpTarfaPDRec=?, EmpHsPDiaTipTra=?  WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F182", "SAVEPOINT gxupdate;DELETE FROM Empresahorasextras_pordia  WHERE CliCod = ? AND EmpCod = ? AND EmpHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000F183", "SELECT EmpHsExSec, EmpHsPDiaDia, EmpHsPDiaDesde, EmpTarifaPDia, EmpTarfaPDRec, CliCod, EmpCod, EmpHsPDiaTipTra FROM Empresahorasextras_pordia WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpHsExSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F184", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? and EmpCod = ? and PaiTipoTraId = ( ?) ORDER BY CliCod, EmpCod, PaiTipoTraId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F185", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F186", "SELECT CliCod, EmpCod, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F187", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F188", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?  FOR UPDATE OF Empresatipo_trabajo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000F189", "SAVEPOINT gxupdate;INSERT INTO Empresatipo_trabajo(CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId, EmpHsRelSec, EmpHsHorDes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F190", "SAVEPOINT gxupdate;UPDATE Empresatipo_trabajo SET EmpHsDia=?, EmpHsSem=?, EmpTarifaXLim=?, EmpTarifaRec=?, EmpHsMaxDia=?, EmpHsMaxSem=?, EmpHsMaxMes=?, EmpHsMaxAnu=?  WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F191", "SAVEPOINT gxupdate;DELETE FROM Empresatipo_trabajo  WHERE CliCod = ? AND EmpCod = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000F192", "SELECT CliCod, EmpCod, EmpHsExSec FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ? AND EmpHsPDiaTipTra = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000F193", "SELECT CliCod, EmpCod, EmpHsDia, EmpHsSem, EmpTarifaXLim, EmpTarifaRec, EmpHsMaxDia, EmpHsMaxSem, EmpHsMaxMes, EmpHsMaxAnu, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, PaiTipoTraId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F194", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? and EmpCod = ? and EmpConvenio = ( ?) ORDER BY CliCod, EmpCod, EmpConvenio ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F195", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? AND EmpCod = ? AND EmpConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F196", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? AND EmpCod = ? AND EmpConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F197", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? AND EmpCod = ? AND EmpConvenio = ?  FOR UPDATE OF Empresanolaborables_convenio",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000F198", "SAVEPOINT gxupdate;INSERT INTO Empresanolaborables_convenio(CliCod, EmpCod, EmpConvenio) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F199", "SAVEPOINT gxupdate;DELETE FROM Empresanolaborables_convenio  WHERE CliCod = ? AND EmpCod = ? AND EmpConvenio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000F200", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpConvenio ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F201", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? and EmpCod = ? and EmpOrigen = ( ?) ORDER BY CliCod, EmpCod, EmpOrigen ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F202", "SELECT OrigId FROM Origen WHERE OrigId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F203", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F204", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F205", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ?  FOR UPDATE OF Empresanolaborables_origen",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000F206", "SAVEPOINT gxupdate;INSERT INTO Empresanolaborables_origen(CliCod, EmpCod, EmpOrigen) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F207", "SAVEPOINT gxupdate;DELETE FROM Empresanolaborables_origen  WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000F208", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpOrigen ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F209", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? and EmpCod = ? and EmpReligion = ( ?) ORDER BY CliCod, EmpCod, EmpReligion ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F210", "SELECT ReligId FROM Religion WHERE ReligId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F211", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F212", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F213", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ?  FOR UPDATE OF Empresanolaborables_religion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000F214", "SAVEPOINT gxupdate;INSERT INTO Empresanolaborables_religion(CliCod, EmpCod, EmpReligion) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000F215", "SAVEPOINT gxupdate;DELETE FROM Empresanolaborables_religion  WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000F216", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpReligion ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F217", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F218", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 17 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 18 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               return;
            case 20 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 21 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 22 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               return;
            case 23 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((boolean[]) buf[12])[0] = rslt.getBoolean(9);
               ((String[]) buf[13])[0] = rslt.getBLOBFile(10, rslt.getString(28, 20), rslt.getVarchar(30));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getBLOBFile(11, rslt.getString(29, 20), rslt.getVarchar(31));
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(12,4);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(13,4);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(14,1);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((byte[]) buf[23])[0] = rslt.getByte(16);
               ((byte[]) buf[24])[0] = rslt.getByte(17);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(18);
               ((byte[]) buf[26])[0] = rslt.getByte(19);
               ((byte[]) buf[27])[0] = rslt.getByte(20);
               ((boolean[]) buf[28])[0] = rslt.getBoolean(21);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(22);
               ((byte[]) buf[30])[0] = rslt.getByte(23);
               ((String[]) buf[31])[0] = rslt.getString(24, 20);
               ((java.math.BigDecimal[]) buf[32])[0] = rslt.getBigDecimal(25,4);
               ((byte[]) buf[33])[0] = rslt.getByte(26);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((String[]) buf[35])[0] = rslt.getString(27, 1);
               ((String[]) buf[36])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getString(29, 20);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((String[]) buf[40])[0] = rslt.getVarchar(30);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((String[]) buf[42])[0] = rslt.getVarchar(31);
               ((boolean[]) buf[43])[0] = rslt.wasNull();
               ((short[]) buf[44])[0] = rslt.getShort(32);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((short[]) buf[46])[0] = rslt.getShort(33);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((short[]) buf[48])[0] = rslt.getShort(34);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((int[]) buf[50])[0] = rslt.getInt(35);
               ((String[]) buf[51])[0] = rslt.getString(36, 8);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((String[]) buf[53])[0] = rslt.getString(37, 4);
               ((boolean[]) buf[54])[0] = rslt.wasNull();
               ((short[]) buf[55])[0] = rslt.getShort(38);
               ((String[]) buf[56])[0] = rslt.getString(39, 20);
               ((String[]) buf[57])[0] = rslt.getString(40, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((String[]) buf[59])[0] = rslt.getString(41, 20);
               ((String[]) buf[60])[0] = rslt.getString(42, 20);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((short[]) buf[62])[0] = rslt.getShort(43);
               return;
            case 24 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((boolean[]) buf[12])[0] = rslt.getBoolean(9);
               ((String[]) buf[13])[0] = rslt.getBLOBFile(10, rslt.getString(28, 20), rslt.getVarchar(30));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getBLOBFile(11, rslt.getString(29, 20), rslt.getVarchar(31));
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(12,4);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(13,4);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(14,1);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((byte[]) buf[23])[0] = rslt.getByte(16);
               ((byte[]) buf[24])[0] = rslt.getByte(17);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(18);
               ((byte[]) buf[26])[0] = rslt.getByte(19);
               ((byte[]) buf[27])[0] = rslt.getByte(20);
               ((boolean[]) buf[28])[0] = rslt.getBoolean(21);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(22);
               ((byte[]) buf[30])[0] = rslt.getByte(23);
               ((String[]) buf[31])[0] = rslt.getString(24, 20);
               ((java.math.BigDecimal[]) buf[32])[0] = rslt.getBigDecimal(25,4);
               ((byte[]) buf[33])[0] = rslt.getByte(26);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((String[]) buf[35])[0] = rslt.getString(27, 1);
               ((String[]) buf[36])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getString(29, 20);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((String[]) buf[40])[0] = rslt.getVarchar(30);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((String[]) buf[42])[0] = rslt.getVarchar(31);
               ((boolean[]) buf[43])[0] = rslt.wasNull();
               ((short[]) buf[44])[0] = rslt.getShort(32);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((short[]) buf[46])[0] = rslt.getShort(33);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((short[]) buf[48])[0] = rslt.getShort(34);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((int[]) buf[50])[0] = rslt.getInt(35);
               ((String[]) buf[51])[0] = rslt.getString(36, 8);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((String[]) buf[53])[0] = rslt.getString(37, 4);
               ((boolean[]) buf[54])[0] = rslt.wasNull();
               ((short[]) buf[55])[0] = rslt.getShort(38);
               ((String[]) buf[56])[0] = rslt.getString(39, 20);
               ((String[]) buf[57])[0] = rslt.getString(40, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((String[]) buf[59])[0] = rslt.getString(41, 20);
               ((String[]) buf[60])[0] = rslt.getString(42, 20);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((short[]) buf[62])[0] = rslt.getShort(43);
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 26 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 29 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               return;
            case 31 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 32 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 34 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 35 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 36 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 37 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(10);
               ((String[]) buf[14])[0] = rslt.getVarchar(11);
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((String[]) buf[16])[0] = rslt.getVarchar(13);
               ((String[]) buf[17])[0] = rslt.getVarchar(14);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(15);
               ((String[]) buf[19])[0] = rslt.getString(16, 1);
               ((String[]) buf[20])[0] = rslt.getBLOBFile(17, rslt.getString(35, 20), rslt.getVarchar(37));
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getBLOBFile(18, rslt.getString(36, 20), rslt.getVarchar(38));
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(19,4);
               ((java.math.BigDecimal[]) buf[25])[0] = rslt.getBigDecimal(20,4);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(21,1);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getString(22, 20);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((byte[]) buf[30])[0] = rslt.getByte(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((boolean[]) buf[32])[0] = rslt.getBoolean(25);
               ((byte[]) buf[33])[0] = rslt.getByte(26);
               ((byte[]) buf[34])[0] = rslt.getByte(27);
               ((boolean[]) buf[35])[0] = rslt.getBoolean(28);
               ((boolean[]) buf[36])[0] = rslt.getBoolean(29);
               ((byte[]) buf[37])[0] = rslt.getByte(30);
               ((String[]) buf[38])[0] = rslt.getString(31, 20);
               ((java.math.BigDecimal[]) buf[39])[0] = rslt.getBigDecimal(32,4);
               ((byte[]) buf[40])[0] = rslt.getByte(33);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((String[]) buf[42])[0] = rslt.getString(34, 1);
               ((String[]) buf[43])[0] = rslt.getString(35, 20);
               ((boolean[]) buf[44])[0] = rslt.wasNull();
               ((String[]) buf[45])[0] = rslt.getString(36, 20);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((String[]) buf[47])[0] = rslt.getVarchar(37);
               ((boolean[]) buf[48])[0] = rslt.wasNull();
               ((String[]) buf[49])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((short[]) buf[51])[0] = rslt.getShort(39);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((short[]) buf[53])[0] = rslt.getShort(40);
               ((boolean[]) buf[54])[0] = rslt.wasNull();
               ((short[]) buf[55])[0] = rslt.getShort(41);
               ((boolean[]) buf[56])[0] = rslt.wasNull();
               ((int[]) buf[57])[0] = rslt.getInt(42);
               ((String[]) buf[58])[0] = rslt.getString(43, 8);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((String[]) buf[60])[0] = rslt.getString(44, 4);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((short[]) buf[62])[0] = rslt.getShort(45);
               ((String[]) buf[63])[0] = rslt.getString(46, 20);
               ((String[]) buf[64])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[65])[0] = rslt.wasNull();
               ((String[]) buf[66])[0] = rslt.getString(48, 20);
               ((String[]) buf[67])[0] = rslt.getString(49, 20);
               ((boolean[]) buf[68])[0] = rslt.wasNull();
               ((short[]) buf[69])[0] = rslt.getShort(50);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 39 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 40 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 41 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 42 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 43 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 44 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               return;
            case 45 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 46 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 47 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 48 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 49 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 50 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 51 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((boolean[]) buf[12])[0] = rslt.getBoolean(9);
               ((String[]) buf[13])[0] = rslt.getBLOBFile(10, rslt.getString(28, 20), rslt.getVarchar(30));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getBLOBFile(11, rslt.getString(29, 20), rslt.getVarchar(31));
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(12,4);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(13,4);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(14,1);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((byte[]) buf[23])[0] = rslt.getByte(16);
               ((byte[]) buf[24])[0] = rslt.getByte(17);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(18);
               ((byte[]) buf[26])[0] = rslt.getByte(19);
               ((byte[]) buf[27])[0] = rslt.getByte(20);
               ((boolean[]) buf[28])[0] = rslt.getBoolean(21);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(22);
               ((byte[]) buf[30])[0] = rslt.getByte(23);
               ((String[]) buf[31])[0] = rslt.getString(24, 20);
               ((java.math.BigDecimal[]) buf[32])[0] = rslt.getBigDecimal(25,4);
               ((byte[]) buf[33])[0] = rslt.getByte(26);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((String[]) buf[35])[0] = rslt.getString(27, 1);
               ((String[]) buf[36])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getString(29, 20);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((String[]) buf[40])[0] = rslt.getVarchar(30);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((String[]) buf[42])[0] = rslt.getVarchar(31);
               ((boolean[]) buf[43])[0] = rslt.wasNull();
               ((short[]) buf[44])[0] = rslt.getShort(32);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((short[]) buf[46])[0] = rslt.getShort(33);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((short[]) buf[48])[0] = rslt.getShort(34);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((int[]) buf[50])[0] = rslt.getInt(35);
               ((String[]) buf[51])[0] = rslt.getString(36, 8);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((String[]) buf[53])[0] = rslt.getString(37, 4);
               ((boolean[]) buf[54])[0] = rslt.wasNull();
               ((short[]) buf[55])[0] = rslt.getShort(38);
               ((String[]) buf[56])[0] = rslt.getString(39, 20);
               ((String[]) buf[57])[0] = rslt.getString(40, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((String[]) buf[59])[0] = rslt.getString(41, 20);
               ((String[]) buf[60])[0] = rslt.getString(42, 20);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((short[]) buf[62])[0] = rslt.getShort(43);
               return;
            case 52 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((boolean[]) buf[12])[0] = rslt.getBoolean(9);
               ((String[]) buf[13])[0] = rslt.getBLOBFile(10, rslt.getString(28, 20), rslt.getVarchar(30));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getBLOBFile(11, rslt.getString(29, 20), rslt.getVarchar(31));
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(12,4);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(13,4);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(14,1);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((byte[]) buf[23])[0] = rslt.getByte(16);
               ((byte[]) buf[24])[0] = rslt.getByte(17);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(18);
               ((byte[]) buf[26])[0] = rslt.getByte(19);
               ((byte[]) buf[27])[0] = rslt.getByte(20);
               ((boolean[]) buf[28])[0] = rslt.getBoolean(21);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(22);
               ((byte[]) buf[30])[0] = rslt.getByte(23);
               ((String[]) buf[31])[0] = rslt.getString(24, 20);
               ((java.math.BigDecimal[]) buf[32])[0] = rslt.getBigDecimal(25,4);
               ((byte[]) buf[33])[0] = rslt.getByte(26);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((String[]) buf[35])[0] = rslt.getString(27, 1);
               ((String[]) buf[36])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getString(29, 20);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((String[]) buf[40])[0] = rslt.getVarchar(30);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((String[]) buf[42])[0] = rslt.getVarchar(31);
               ((boolean[]) buf[43])[0] = rslt.wasNull();
               ((short[]) buf[44])[0] = rslt.getShort(32);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((short[]) buf[46])[0] = rslt.getShort(33);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((short[]) buf[48])[0] = rslt.getShort(34);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((int[]) buf[50])[0] = rslt.getInt(35);
               ((String[]) buf[51])[0] = rslt.getString(36, 8);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((String[]) buf[53])[0] = rslt.getString(37, 4);
               ((boolean[]) buf[54])[0] = rslt.wasNull();
               ((short[]) buf[55])[0] = rslt.getShort(38);
               ((String[]) buf[56])[0] = rslt.getString(39, 20);
               ((String[]) buf[57])[0] = rslt.getString(40, 20);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((String[]) buf[59])[0] = rslt.getString(41, 20);
               ((String[]) buf[60])[0] = rslt.getString(42, 20);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((short[]) buf[62])[0] = rslt.getShort(43);
               return;
            case 58 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               return;
            case 61 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 62 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               return;
            case 63 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 64 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
               return;
            case 65 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
               return;
            case 66 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 67 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 68 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 69 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 70 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 71 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 72 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               return;
            case 73 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 74 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 75 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 76 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
               return;
            case 132 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 133 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 134 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 135 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 136 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 137 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 138 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 139 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               return;
            case 140 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 141 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 142 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 143 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 144 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 145 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(10);
               ((String[]) buf[14])[0] = rslt.getVarchar(11);
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((String[]) buf[16])[0] = rslt.getVarchar(13);
               ((String[]) buf[17])[0] = rslt.getVarchar(14);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(15);
               ((String[]) buf[19])[0] = rslt.getString(16, 1);
               ((String[]) buf[20])[0] = rslt.getBLOBFile(17, rslt.getString(35, 20), rslt.getVarchar(37));
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getBLOBFile(18, rslt.getString(36, 20), rslt.getVarchar(38));
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(19,4);
               ((java.math.BigDecimal[]) buf[25])[0] = rslt.getBigDecimal(20,4);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(21,1);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getString(22, 20);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((byte[]) buf[30])[0] = rslt.getByte(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((boolean[]) buf[32])[0] = rslt.getBoolean(25);
               ((byte[]) buf[33])[0] = rslt.getByte(26);
               ((byte[]) buf[34])[0] = rslt.getByte(27);
               ((boolean[]) buf[35])[0] = rslt.getBoolean(28);
               ((boolean[]) buf[36])[0] = rslt.getBoolean(29);
               ((byte[]) buf[37])[0] = rslt.getByte(30);
               ((String[]) buf[38])[0] = rslt.getString(31, 20);
               ((java.math.BigDecimal[]) buf[39])[0] = rslt.getBigDecimal(32,4);
               ((byte[]) buf[40])[0] = rslt.getByte(33);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((String[]) buf[42])[0] = rslt.getString(34, 1);
               ((String[]) buf[43])[0] = rslt.getString(35, 20);
               ((boolean[]) buf[44])[0] = rslt.wasNull();
               ((String[]) buf[45])[0] = rslt.getString(36, 20);
               ((boolean[]) buf[46])[0] = rslt.wasNull();
               ((String[]) buf[47])[0] = rslt.getVarchar(37);
               ((boolean[]) buf[48])[0] = rslt.wasNull();
               ((String[]) buf[49])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((short[]) buf[51])[0] = rslt.getShort(39);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((short[]) buf[53])[0] = rslt.getShort(40);
               ((boolean[]) buf[54])[0] = rslt.wasNull();
               ((short[]) buf[55])[0] = rslt.getShort(41);
               ((boolean[]) buf[56])[0] = rslt.wasNull();
               ((int[]) buf[57])[0] = rslt.getInt(42);
               ((String[]) buf[58])[0] = rslt.getString(43, 8);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((String[]) buf[60])[0] = rslt.getString(44, 4);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((short[]) buf[62])[0] = rslt.getShort(45);
               ((String[]) buf[63])[0] = rslt.getString(46, 20);
               ((String[]) buf[64])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[65])[0] = rslt.wasNull();
               ((String[]) buf[66])[0] = rslt.getString(48, 20);
               ((String[]) buf[67])[0] = rslt.getString(49, 20);
               ((boolean[]) buf[68])[0] = rslt.wasNull();
               ((short[]) buf[69])[0] = rslt.getShort(50);
               return;
            case 146 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 147 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               return;
            case 148 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 149 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
            case 154 :
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
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               return;
            case 157 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 158 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 159 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 163 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 164 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 165 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 166 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 167 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 168 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 172 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 173 :
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
            case 174 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 175 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 176 :
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
            case 177 :
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
            case 181 :
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
            case 182 :
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
            case 183 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 184 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 185 :
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
            case 186 :
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
            case 190 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 193 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 194 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 195 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 198 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 199 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 200 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
            case 206 :
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
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 209 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
            case 214 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 215 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 216 :
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 16 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 25 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 26 :
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
            case 27 :
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
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 29 :
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
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 31 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 32 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 33 :
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
            case 34 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 35 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 36 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 37 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 39 :
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
            case 40 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 41 :
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
            case 42 :
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
            case 43 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 44 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 45 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 46 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 47 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 48 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 49 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 50 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 51 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 52 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 53 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(4, ((Number) parms[4]).shortValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[6], 30);
               }
               stmt.setVarchar(6, (String)parms[7], 40, false);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(7, (String)parms[9], 30);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[11], 20);
               }
               stmt.setBoolean(9, ((Boolean) parms[12]).booleanValue());
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(10, (String)parms[14]);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(11, (String)parms[16]);
               }
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[17], 4);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[18], 4);
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(14, (java.math.BigDecimal)parms[20], 1);
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[22], 20);
               }
               stmt.setByte(16, ((Number) parms[23]).byteValue());
               stmt.setByte(17, ((Number) parms[24]).byteValue());
               stmt.setBoolean(18, ((Boolean) parms[25]).booleanValue());
               stmt.setByte(19, ((Number) parms[26]).byteValue());
               stmt.setByte(20, ((Number) parms[27]).byteValue());
               stmt.setBoolean(21, ((Boolean) parms[28]).booleanValue());
               stmt.setBoolean(22, ((Boolean) parms[29]).booleanValue());
               stmt.setByte(23, ((Number) parms[30]).byteValue());
               stmt.setString(24, (String)parms[31], 20);
               stmt.setBigDecimal(25, (java.math.BigDecimal)parms[32], 4);
               if ( ((Boolean) parms[33]).booleanValue() )
               {
                  stmt.setNull( 26 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(26, ((Number) parms[34]).byteValue());
               }
               stmt.setString(27, (String)parms[35], 1);
               if ( ((Boolean) parms[36]).booleanValue() )
               {
                  stmt.setNull( 28 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(28, (String)parms[37], 20);
               }
               if ( ((Boolean) parms[38]).booleanValue() )
               {
                  stmt.setNull( 29 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(29, (String)parms[39], 20);
               }
               if ( ((Boolean) parms[40]).booleanValue() )
               {
                  stmt.setNull( 30 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(30, (String)parms[41], 400);
               }
               if ( ((Boolean) parms[42]).booleanValue() )
               {
                  stmt.setNull( 31 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(31, (String)parms[43], 400);
               }
               if ( ((Boolean) parms[44]).booleanValue() )
               {
                  stmt.setNull( 32 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(32, ((Number) parms[45]).shortValue());
               }
               if ( ((Boolean) parms[46]).booleanValue() )
               {
                  stmt.setNull( 33 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(33, ((Number) parms[47]).shortValue());
               }
               if ( ((Boolean) parms[48]).booleanValue() )
               {
                  stmt.setNull( 34 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(34, ((Number) parms[49]).shortValue());
               }
               stmt.setInt(35, ((Number) parms[50]).intValue());
               if ( ((Boolean) parms[51]).booleanValue() )
               {
                  stmt.setNull( 36 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(36, (String)parms[52], 8);
               }
               if ( ((Boolean) parms[53]).booleanValue() )
               {
                  stmt.setNull( 37 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(37, (String)parms[54], 4);
               }
               stmt.setShort(38, ((Number) parms[55]).shortValue());
               stmt.setString(39, (String)parms[56], 20);
               if ( ((Boolean) parms[57]).booleanValue() )
               {
                  stmt.setNull( 40 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(40, (String)parms[58], 20);
               }
               stmt.setString(41, (String)parms[59], 20);
               if ( ((Boolean) parms[60]).booleanValue() )
               {
                  stmt.setNull( 42 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(42, (String)parms[61], 20);
               }
               stmt.setShort(43, ((Number) parms[62]).shortValue());
               return;
            case 54 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(4, (String)parms[5], 30);
               }
               stmt.setVarchar(5, (String)parms[6], 40, false);
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(6, (String)parms[8], 30);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[10], 20);
               }
               stmt.setBoolean(8, ((Boolean) parms[11]).booleanValue());
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[12], 4);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[13], 4);
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(11, (java.math.BigDecimal)parms[15], 1);
               }
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(12, (String)parms[17], 20);
               }
               stmt.setByte(13, ((Number) parms[18]).byteValue());
               stmt.setByte(14, ((Number) parms[19]).byteValue());
               stmt.setBoolean(15, ((Boolean) parms[20]).booleanValue());
               stmt.setByte(16, ((Number) parms[21]).byteValue());
               stmt.setByte(17, ((Number) parms[22]).byteValue());
               stmt.setBoolean(18, ((Boolean) parms[23]).booleanValue());
               stmt.setBoolean(19, ((Boolean) parms[24]).booleanValue());
               stmt.setByte(20, ((Number) parms[25]).byteValue());
               stmt.setString(21, (String)parms[26], 20);
               stmt.setBigDecimal(22, (java.math.BigDecimal)parms[27], 4);
               if ( ((Boolean) parms[28]).booleanValue() )
               {
                  stmt.setNull( 23 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(23, ((Number) parms[29]).byteValue());
               }
               stmt.setString(24, (String)parms[30], 1);
               if ( ((Boolean) parms[31]).booleanValue() )
               {
                  stmt.setNull( 25 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(25, (String)parms[32], 20);
               }
               if ( ((Boolean) parms[33]).booleanValue() )
               {
                  stmt.setNull( 26 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(26, (String)parms[34], 20);
               }
               if ( ((Boolean) parms[35]).booleanValue() )
               {
                  stmt.setNull( 27 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(27, (String)parms[36], 400);
               }
               if ( ((Boolean) parms[37]).booleanValue() )
               {
                  stmt.setNull( 28 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(28, (String)parms[38], 400);
               }
               if ( ((Boolean) parms[39]).booleanValue() )
               {
                  stmt.setNull( 29 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(29, ((Number) parms[40]).shortValue());
               }
               if ( ((Boolean) parms[41]).booleanValue() )
               {
                  stmt.setNull( 30 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(30, ((Number) parms[42]).shortValue());
               }
               if ( ((Boolean) parms[43]).booleanValue() )
               {
                  stmt.setNull( 31 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(31, ((Number) parms[44]).shortValue());
               }
               if ( ((Boolean) parms[45]).booleanValue() )
               {
                  stmt.setNull( 32 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(32, (String)parms[46], 8);
               }
               if ( ((Boolean) parms[47]).booleanValue() )
               {
                  stmt.setNull( 33 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(33, (String)parms[48], 4);
               }
               stmt.setShort(34, ((Number) parms[49]).shortValue());
               stmt.setString(35, (String)parms[50], 20);
               if ( ((Boolean) parms[51]).booleanValue() )
               {
                  stmt.setNull( 36 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(36, (String)parms[52], 20);
               }
               stmt.setString(37, (String)parms[53], 20);
               if ( ((Boolean) parms[54]).booleanValue() )
               {
                  stmt.setNull( 38 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(38, (String)parms[55], 20);
               }
               stmt.setShort(39, ((Number) parms[56]).shortValue());
               stmt.setInt(40, ((Number) parms[57]).intValue());
               stmt.setShort(41, ((Number) parms[58]).shortValue());
               return;
            case 55 :
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
            case 56 :
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
            case 57 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
               return;
            case 59 :
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
            case 61 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 62 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 63 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 64 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 65 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 146 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 147 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 148 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
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
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 152 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 153 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 154 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 155 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 156 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 157 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
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
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 161 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 162 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 163 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 164 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 165 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 166 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
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
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 170 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 171 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 172 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 173 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 174 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 175 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 176 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 177 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 178 :
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
            case 179 :
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 181 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 182 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 183 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 184 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 185 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 186 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 187 :
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
            case 188 :
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
            case 189 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 190 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 191 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 192 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 197 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 198 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 199 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 200 :
               stmt.setString(1, (String)parms[0], 20);
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
               return;
            case 207 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 208 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 209 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
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
               return;
            case 215 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 216 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

