package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clienteconvenio_particularidades_bc extends GXWebPanel implements IGxSilentTrn
{
   public clienteconvenio_particularidades_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public clienteconvenio_particularidades_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clienteconvenio_particularidades_bc.class ));
   }

   public clienteconvenio_particularidades_bc( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow4M204( ) ;
      standaloneNotModal( ) ;
      initializeNonKey4M204( ) ;
      standaloneModal( ) ;
      addRow4M204( ) ;
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
         e114M2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z1575CliConveVig = A1575CliConveVig ;
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

   public void confirm_4M0( )
   {
      beforeValidate4M204( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4M204( ) ;
         }
         else
         {
            checkExtendedTable4M204( ) ;
            if ( AnyError == 0 )
            {
               zm4M204( 6) ;
            }
            closeExtendedTableCursors4M204( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode204 = Gx_mode ;
         confirm_4M239( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode204 ;
            IsConfirmed = (short)(1) ;
         }
         /* Restore parent mode. */
         Gx_mode = sMode204 ;
      }
   }

   public void confirm_4M239( )
   {
      nGXsfl_239_idx = 0 ;
      while ( nGXsfl_239_idx < bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().size() )
      {
         readRow4M239( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound239 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_239 != 0 ) )
         {
            getKey4M239( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound239 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate4M239( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable4M239( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors4M239( ) ;
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
               if ( RcdFound239 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey4M239( ) ;
                     load4M239( ) ;
                     beforeValidate4M239( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls4M239( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_239 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate4M239( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable4M239( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors4M239( ) ;
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
            VarsToRow239( ((web.SdtClienteConvenio_Particularidades_Vacaciones)bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+nGXsfl_239_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e124M2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      AV12IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteConvenio_Particularidades_Insert", GXv_boolean3) ;
         clienteconvenio_particularidades_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteConvenio_Particularidades_Update", GXv_boolean3) ;
         clienteconvenio_particularidades_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteConvenio_Particularidades_Delete", GXv_boolean3) ;
         clienteconvenio_particularidades_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV25Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
   }

   public void e114M2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
   }

   public void zm4M204( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z905ConveDefault = A905ConveDefault ;
         Z1043ConveInterDiasJor = A1043ConveInterDiasJor ;
         Z1044ConveDiasAcuVac = A1044ConveDiasAcuVac ;
         Z1046ConveMinMesesVac = A1046ConveMinMesesVac ;
         Z1269ConveMesHsPExt = A1269ConveMesHsPExt ;
         Z1270ConveDiaHsPExt = A1270ConveDiaHsPExt ;
         Z1401ConveFondoCese = A1401ConveFondoCese ;
         Z1627ConveGuarEdadMin = A1627ConveGuarEdadMin ;
         Z1628ConveGuarEdadMax = A1628ConveGuarEdadMax ;
         Z1897ConveRelSec = A1897ConveRelSec ;
         Z2036ConveRelRef = A2036ConveRelRef ;
      }
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -5 )
      {
         Z1575CliConveVig = A1575CliConveVig ;
         Z905ConveDefault = A905ConveDefault ;
         Z1043ConveInterDiasJor = A1043ConveInterDiasJor ;
         Z1044ConveDiasAcuVac = A1044ConveDiasAcuVac ;
         Z1046ConveMinMesesVac = A1046ConveMinMesesVac ;
         Z1269ConveMesHsPExt = A1269ConveMesHsPExt ;
         Z1270ConveDiaHsPExt = A1270ConveDiaHsPExt ;
         Z1401ConveFondoCese = A1401ConveFondoCese ;
         Z1627ConveGuarEdadMin = A1627ConveGuarEdadMin ;
         Z1628ConveGuarEdadMax = A1628ConveGuarEdadMax ;
         Z1897ConveRelSec = A1897ConveRelSec ;
         Z2036ConveRelRef = A2036ConveRelRef ;
         Z2037ConvePartOld = A2037ConvePartOld ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int4 = A3CliCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
         clienteconvenio_particularidades_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
   }

   public void standaloneModal( )
   {
   }

   public void load4M204( )
   {
      /* Using cursor BC004M7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound204 = (short)(1) ;
         A905ConveDefault = BC004M7_A905ConveDefault[0] ;
         A1043ConveInterDiasJor = BC004M7_A1043ConveInterDiasJor[0] ;
         A1044ConveDiasAcuVac = BC004M7_A1044ConveDiasAcuVac[0] ;
         A1046ConveMinMesesVac = BC004M7_A1046ConveMinMesesVac[0] ;
         A1269ConveMesHsPExt = BC004M7_A1269ConveMesHsPExt[0] ;
         A1270ConveDiaHsPExt = BC004M7_A1270ConveDiaHsPExt[0] ;
         n1270ConveDiaHsPExt = BC004M7_n1270ConveDiaHsPExt[0] ;
         A1401ConveFondoCese = BC004M7_A1401ConveFondoCese[0] ;
         A1627ConveGuarEdadMin = BC004M7_A1627ConveGuarEdadMin[0] ;
         n1627ConveGuarEdadMin = BC004M7_n1627ConveGuarEdadMin[0] ;
         A1628ConveGuarEdadMax = BC004M7_A1628ConveGuarEdadMax[0] ;
         n1628ConveGuarEdadMax = BC004M7_n1628ConveGuarEdadMax[0] ;
         A1897ConveRelSec = BC004M7_A1897ConveRelSec[0] ;
         A2036ConveRelRef = BC004M7_A2036ConveRelRef[0] ;
         A2037ConvePartOld = BC004M7_A2037ConvePartOld[0] ;
         zm4M204( -5) ;
      }
      pr_default.close(5);
      onLoadActions4M204( ) ;
   }

   public void onLoadActions4M204( )
   {
      AV25Pgmname = "ClienteConvenio_Particularidades_BC" ;
   }

   public void checkExtendedTable4M204( )
   {
      nIsDirty_204 = (short)(0) ;
      standaloneModal( ) ;
      AV25Pgmname = "ClienteConvenio_Particularidades_BC" ;
      /* Using cursor BC004M8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
      if ( ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(O1575CliConveVig)) ) || ( DecimalUtil.compareTo(A1269ConveMesHsPExt, O1269ConveMesHsPExt) != 0 ) || ( GXutil.strcmp(A1270ConveDiaHsPExt, O1270ConveDiaHsPExt) != 0 ) || ( A1401ConveFondoCese != O1401ConveFondoCese ) || ( A1628ConveGuarEdadMax != O1628ConveGuarEdadMax ) || ( A1627ConveGuarEdadMin != O1627ConveGuarEdadMin ) ) && (0==A1897ConveRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1270ConveDiaHsPExt, "Promedio") == 0 ) || ( GXutil.strcmp(A1270ConveDiaHsPExt, "diasSemanaX4") == 0 ) || ( GXutil.strcmp(A1270ConveDiaHsPExt, "diasSemanaMes") == 0 ) || (GXutil.strcmp("", A1270ConveDiaHsPExt)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Algoritmo para cantidad de días del mes para cálculo de 1 hora de trabajo para mensualizados", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors4M204( )
   {
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey4M204( )
   {
      /* Using cursor BC004M9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound204 = (short)(1) ;
      }
      else
      {
         RcdFound204 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC004M10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm4M204( 5) ;
         RcdFound204 = (short)(1) ;
         A1575CliConveVig = BC004M10_A1575CliConveVig[0] ;
         A905ConveDefault = BC004M10_A905ConveDefault[0] ;
         A1043ConveInterDiasJor = BC004M10_A1043ConveInterDiasJor[0] ;
         A1044ConveDiasAcuVac = BC004M10_A1044ConveDiasAcuVac[0] ;
         A1046ConveMinMesesVac = BC004M10_A1046ConveMinMesesVac[0] ;
         A1269ConveMesHsPExt = BC004M10_A1269ConveMesHsPExt[0] ;
         A1270ConveDiaHsPExt = BC004M10_A1270ConveDiaHsPExt[0] ;
         n1270ConveDiaHsPExt = BC004M10_n1270ConveDiaHsPExt[0] ;
         A1401ConveFondoCese = BC004M10_A1401ConveFondoCese[0] ;
         A1627ConveGuarEdadMin = BC004M10_A1627ConveGuarEdadMin[0] ;
         n1627ConveGuarEdadMin = BC004M10_n1627ConveGuarEdadMin[0] ;
         A1628ConveGuarEdadMax = BC004M10_A1628ConveGuarEdadMax[0] ;
         n1628ConveGuarEdadMax = BC004M10_n1628ConveGuarEdadMax[0] ;
         A1897ConveRelSec = BC004M10_A1897ConveRelSec[0] ;
         A2036ConveRelRef = BC004M10_A2036ConveRelRef[0] ;
         A2037ConvePartOld = BC004M10_A2037ConvePartOld[0] ;
         A3CliCod = BC004M10_A3CliCod[0] ;
         A1564CliPaiConve = BC004M10_A1564CliPaiConve[0] ;
         A1565CliConvenio = BC004M10_A1565CliConvenio[0] ;
         O1565CliConvenio = A1565CliConvenio ;
         O1575CliConveVig = A1575CliConveVig ;
         O1269ConveMesHsPExt = A1269ConveMesHsPExt ;
         O1270ConveDiaHsPExt = A1270ConveDiaHsPExt ;
         n1270ConveDiaHsPExt = false ;
         O1401ConveFondoCese = A1401ConveFondoCese ;
         O1628ConveGuarEdadMax = A1628ConveGuarEdadMax ;
         n1628ConveGuarEdadMax = false ;
         O1627ConveGuarEdadMin = A1627ConveGuarEdadMin ;
         n1627ConveGuarEdadMin = false ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1575CliConveVig = A1575CliConveVig ;
         sMode204 = Gx_mode ;
         Gx_mode = "DSP" ;
         load4M204( ) ;
         if ( AnyError == 1 )
         {
            RcdFound204 = (short)(0) ;
            initializeNonKey4M204( ) ;
         }
         Gx_mode = sMode204 ;
      }
      else
      {
         RcdFound204 = (short)(0) ;
         initializeNonKey4M204( ) ;
         sMode204 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode204 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey4M204( ) ;
      if ( RcdFound204 == 0 )
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
      confirm_4M0( ) ;
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

   public void checkOptimisticConcurrency4M204( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC004M11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ClienteConvenio_Particularidades"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(9) == 101) || ( Z905ConveDefault != BC004M11_A905ConveDefault[0] ) || ( Z1043ConveInterDiasJor != BC004M11_A1043ConveInterDiasJor[0] ) || ( Z1044ConveDiasAcuVac != BC004M11_A1044ConveDiasAcuVac[0] ) || ( Z1046ConveMinMesesVac != BC004M11_A1046ConveMinMesesVac[0] ) || ( DecimalUtil.compareTo(Z1269ConveMesHsPExt, BC004M11_A1269ConveMesHsPExt[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1270ConveDiaHsPExt, BC004M11_A1270ConveDiaHsPExt[0]) != 0 ) || ( Z1401ConveFondoCese != BC004M11_A1401ConveFondoCese[0] ) || ( Z1627ConveGuarEdadMin != BC004M11_A1627ConveGuarEdadMin[0] ) || ( Z1628ConveGuarEdadMax != BC004M11_A1628ConveGuarEdadMax[0] ) || ( Z1897ConveRelSec != BC004M11_A1897ConveRelSec[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2036ConveRelRef, BC004M11_A2036ConveRelRef[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ClienteConvenio_Particularidades"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4M204( )
   {
      beforeValidate4M204( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4M204( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4M204( 0) ;
         checkOptimisticConcurrency4M204( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4M204( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4M204( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC004M12 */
                  pr_default.execute(10, new Object[] {A1575CliConveVig, Boolean.valueOf(A905ConveDefault), Short.valueOf(A1043ConveInterDiasJor), Byte.valueOf(A1044ConveDiasAcuVac), Byte.valueOf(A1046ConveMinMesesVac), A1269ConveMesHsPExt, Boolean.valueOf(n1270ConveDiaHsPExt), A1270ConveDiaHsPExt, Boolean.valueOf(A1401ConveFondoCese), Boolean.valueOf(n1627ConveGuarEdadMin), Byte.valueOf(A1627ConveGuarEdadMin), Boolean.valueOf(n1628ConveGuarEdadMax), Byte.valueOf(A1628ConveGuarEdadMax), Integer.valueOf(A1897ConveRelSec), A2036ConveRelRef, A2037ConvePartOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_Particularidades");
                  if ( (pr_default.getStatus(10) == 1) )
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
                        processLevel4M204( ) ;
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
            load4M204( ) ;
         }
         endLevel4M204( ) ;
      }
      closeExtendedTableCursors4M204( ) ;
   }

   public void update4M204( )
   {
      beforeValidate4M204( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4M204( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4M204( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4M204( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4M204( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC004M13 */
                  pr_default.execute(11, new Object[] {Boolean.valueOf(A905ConveDefault), Short.valueOf(A1043ConveInterDiasJor), Byte.valueOf(A1044ConveDiasAcuVac), Byte.valueOf(A1046ConveMinMesesVac), A1269ConveMesHsPExt, Boolean.valueOf(n1270ConveDiaHsPExt), A1270ConveDiaHsPExt, Boolean.valueOf(A1401ConveFondoCese), Boolean.valueOf(n1627ConveGuarEdadMin), Byte.valueOf(A1627ConveGuarEdadMin), Boolean.valueOf(n1628ConveGuarEdadMax), Byte.valueOf(A1628ConveGuarEdadMax), Integer.valueOf(A1897ConveRelSec), A2036ConveRelRef, A2037ConvePartOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_Particularidades");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ClienteConvenio_Particularidades"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4M204( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel4M204( ) ;
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
         endLevel4M204( ) ;
      }
      closeExtendedTableCursors4M204( ) ;
   }

   public void deferredUpdate4M204( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate4M204( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4M204( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4M204( ) ;
         afterConfirm4M204( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4M204( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart4M239( ) ;
               while ( RcdFound239 != 0 )
               {
                  getByPrimaryKey4M239( ) ;
                  delete4M239( ) ;
                  scanKeyNext4M239( ) ;
               }
               scanKeyEnd4M239( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC004M14 */
                  pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_Particularidades");
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
      sMode204 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel4M204( ) ;
      Gx_mode = sMode204 ;
   }

   public void onDeleteControls4M204( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV25Pgmname = "ClienteConvenio_Particularidades_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC004M15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void processNestedLevel4M239( )
   {
      nGXsfl_239_idx = 0 ;
      while ( nGXsfl_239_idx < bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().size() )
      {
         readRow4M239( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound239 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_239 != 0 ) )
         {
            standaloneNotModal4M239( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert4M239( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete4M239( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update4M239( ) ;
               }
            }
         }
         KeyVarsToRow239( ((web.SdtClienteConvenio_Particularidades_Vacaciones)bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+nGXsfl_239_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_239_idx = 0 ;
         while ( nGXsfl_239_idx < bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().size() )
         {
            readRow4M239( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound239 == 0 )
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
               bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().removeElement(nGXsfl_239_idx);
               nGXsfl_239_idx = (int)(nGXsfl_239_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey4M239( ) ;
               VarsToRow239( ((web.SdtClienteConvenio_Particularidades_Vacaciones)bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+nGXsfl_239_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll4M239( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_239 = (short)(0) ;
      nIsMod_239 = (short)(0) ;
      Gxremove239 = (byte)(0) ;
   }

   public void processLevel4M204( )
   {
      /* Save parent mode. */
      sMode204 = Gx_mode ;
      processNestedLevel4M239( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode204 ;
      /* ' Update level parameters */
   }

   public void endLevel4M204( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4M204( ) ;
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

   public void scanKeyStart4M204( )
   {
      /* Scan By routine */
      /* Using cursor BC004M16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      RcdFound204 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound204 = (short)(1) ;
         A1575CliConveVig = BC004M16_A1575CliConveVig[0] ;
         A905ConveDefault = BC004M16_A905ConveDefault[0] ;
         A1043ConveInterDiasJor = BC004M16_A1043ConveInterDiasJor[0] ;
         A1044ConveDiasAcuVac = BC004M16_A1044ConveDiasAcuVac[0] ;
         A1046ConveMinMesesVac = BC004M16_A1046ConveMinMesesVac[0] ;
         A1269ConveMesHsPExt = BC004M16_A1269ConveMesHsPExt[0] ;
         A1270ConveDiaHsPExt = BC004M16_A1270ConveDiaHsPExt[0] ;
         n1270ConveDiaHsPExt = BC004M16_n1270ConveDiaHsPExt[0] ;
         A1401ConveFondoCese = BC004M16_A1401ConveFondoCese[0] ;
         A1627ConveGuarEdadMin = BC004M16_A1627ConveGuarEdadMin[0] ;
         n1627ConveGuarEdadMin = BC004M16_n1627ConveGuarEdadMin[0] ;
         A1628ConveGuarEdadMax = BC004M16_A1628ConveGuarEdadMax[0] ;
         n1628ConveGuarEdadMax = BC004M16_n1628ConveGuarEdadMax[0] ;
         A1897ConveRelSec = BC004M16_A1897ConveRelSec[0] ;
         A2036ConveRelRef = BC004M16_A2036ConveRelRef[0] ;
         A2037ConvePartOld = BC004M16_A2037ConvePartOld[0] ;
         A3CliCod = BC004M16_A3CliCod[0] ;
         A1564CliPaiConve = BC004M16_A1564CliPaiConve[0] ;
         A1565CliConvenio = BC004M16_A1565CliConvenio[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext4M204( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound204 = (short)(0) ;
      scanKeyLoad4M204( ) ;
   }

   public void scanKeyLoad4M204( )
   {
      sMode204 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound204 = (short)(1) ;
         A1575CliConveVig = BC004M16_A1575CliConveVig[0] ;
         A905ConveDefault = BC004M16_A905ConveDefault[0] ;
         A1043ConveInterDiasJor = BC004M16_A1043ConveInterDiasJor[0] ;
         A1044ConveDiasAcuVac = BC004M16_A1044ConveDiasAcuVac[0] ;
         A1046ConveMinMesesVac = BC004M16_A1046ConveMinMesesVac[0] ;
         A1269ConveMesHsPExt = BC004M16_A1269ConveMesHsPExt[0] ;
         A1270ConveDiaHsPExt = BC004M16_A1270ConveDiaHsPExt[0] ;
         n1270ConveDiaHsPExt = BC004M16_n1270ConveDiaHsPExt[0] ;
         A1401ConveFondoCese = BC004M16_A1401ConveFondoCese[0] ;
         A1627ConveGuarEdadMin = BC004M16_A1627ConveGuarEdadMin[0] ;
         n1627ConveGuarEdadMin = BC004M16_n1627ConveGuarEdadMin[0] ;
         A1628ConveGuarEdadMax = BC004M16_A1628ConveGuarEdadMax[0] ;
         n1628ConveGuarEdadMax = BC004M16_n1628ConveGuarEdadMax[0] ;
         A1897ConveRelSec = BC004M16_A1897ConveRelSec[0] ;
         A2036ConveRelRef = BC004M16_A2036ConveRelRef[0] ;
         A2037ConvePartOld = BC004M16_A2037ConvePartOld[0] ;
         A3CliCod = BC004M16_A3CliCod[0] ;
         A1564CliPaiConve = BC004M16_A1564CliPaiConve[0] ;
         A1565CliConvenio = BC004M16_A1565CliConvenio[0] ;
      }
      Gx_mode = sMode204 ;
   }

   public void scanKeyEnd4M204( )
   {
      pr_default.close(14);
   }

   public void afterConfirm4M204( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert4M204( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4M204( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4M204( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4M204( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4M204( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4M204( )
   {
   }

   public void zm4M239( int GX_JID )
   {
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         Z1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
         Z1763CliConveVacDias = A1763CliConveVacDias ;
         Z1902ConveVacRelSec = A1902ConveVacRelSec ;
         Z2038ConveVacRelRef = A2038ConveVacRelRef ;
      }
      if ( GX_JID == -7 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1575CliConveVig = A1575CliConveVig ;
         Z1761CliConveVacDesAnt = A1761CliConveVacDesAnt ;
         Z1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
         Z1763CliConveVacDias = A1763CliConveVacDias ;
         Z1902ConveVacRelSec = A1902ConveVacRelSec ;
         Z2038ConveVacRelRef = A2038ConveVacRelRef ;
         Z2039ConveVacOld = A2039ConveVacOld ;
         Z1564CliPaiConve = A1564CliPaiConve ;
      }
   }

   public void standaloneNotModal4M239( )
   {
   }

   public void standaloneModal4M239( )
   {
   }

   public void load4M239( )
   {
      /* Using cursor BC004M17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound239 = (short)(1) ;
         A1762CliConveVacHasAnt = BC004M17_A1762CliConveVacHasAnt[0] ;
         A1763CliConveVacDias = BC004M17_A1763CliConveVacDias[0] ;
         A1902ConveVacRelSec = BC004M17_A1902ConveVacRelSec[0] ;
         A2038ConveVacRelRef = BC004M17_A2038ConveVacRelRef[0] ;
         A2039ConveVacOld = BC004M17_A2039ConveVacOld[0] ;
         zm4M239( -7) ;
      }
      pr_default.close(15);
      onLoadActions4M239( ) ;
   }

   public void onLoadActions4M239( )
   {
   }

   public void checkExtendedTable4M239( )
   {
      nIsDirty_239 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal4M239( ) ;
      Gx_BScreen = (byte)(0) ;
      if ( ( ( A1761CliConveVacDesAnt != O1761CliConveVacDesAnt ) || ( A1762CliConveVacHasAnt != O1762CliConveVacHasAnt ) || ( A1763CliConveVacDias != O1763CliConveVacDias ) ) && (0==A1902ConveVacRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors4M239( )
   {
   }

   public void enableDisable4M239( )
   {
   }

   public void getKey4M239( )
   {
      /* Using cursor BC004M18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound239 = (short)(1) ;
      }
      else
      {
         RcdFound239 = (short)(0) ;
      }
      pr_default.close(16);
   }

   public void getByPrimaryKey4M239( )
   {
      /* Using cursor BC004M19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         zm4M239( 7) ;
         RcdFound239 = (short)(1) ;
         initializeNonKey4M239( ) ;
         A1761CliConveVacDesAnt = BC004M19_A1761CliConveVacDesAnt[0] ;
         A1762CliConveVacHasAnt = BC004M19_A1762CliConveVacHasAnt[0] ;
         A1763CliConveVacDias = BC004M19_A1763CliConveVacDias[0] ;
         A1902ConveVacRelSec = BC004M19_A1902ConveVacRelSec[0] ;
         A2038ConveVacRelRef = BC004M19_A2038ConveVacRelRef[0] ;
         A2039ConveVacOld = BC004M19_A2039ConveVacOld[0] ;
         O1761CliConveVacDesAnt = A1761CliConveVacDesAnt ;
         O1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
         O1763CliConveVacDias = A1763CliConveVacDias ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1575CliConveVig = A1575CliConveVig ;
         Z1761CliConveVacDesAnt = A1761CliConveVacDesAnt ;
         sMode239 = Gx_mode ;
         Gx_mode = "DSP" ;
         load4M239( ) ;
         Gx_mode = sMode239 ;
      }
      else
      {
         RcdFound239 = (short)(0) ;
         initializeNonKey4M239( ) ;
         sMode239 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal4M239( ) ;
         Gx_mode = sMode239 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes4M239( ) ;
      }
      pr_default.close(17);
   }

   public void checkOptimisticConcurrency4M239( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC004M20 */
         pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
         if ( (pr_default.getStatus(18) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ClienteConvenio_ParticularidadesVacacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(18) == 101) || ( Z1762CliConveVacHasAnt != BC004M20_A1762CliConveVacHasAnt[0] ) || ( Z1763CliConveVacDias != BC004M20_A1763CliConveVacDias[0] ) || ( Z1902ConveVacRelSec != BC004M20_A1902ConveVacRelSec[0] ) || ( GXutil.strcmp(Z2038ConveVacRelRef, BC004M20_A2038ConveVacRelRef[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ClienteConvenio_ParticularidadesVacacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4M239( )
   {
      beforeValidate4M239( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4M239( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4M239( 0) ;
         checkOptimisticConcurrency4M239( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4M239( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4M239( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC004M21 */
                  pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt), Byte.valueOf(A1762CliConveVacHasAnt), Byte.valueOf(A1763CliConveVacDias), Integer.valueOf(A1902ConveVacRelSec), A2038ConveVacRelRef, A2039ConveVacOld, Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_ParticularidadesVacacion");
                  if ( (pr_default.getStatus(19) == 1) )
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
            load4M239( ) ;
         }
         endLevel4M239( ) ;
      }
      closeExtendedTableCursors4M239( ) ;
   }

   public void update4M239( )
   {
      beforeValidate4M239( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4M239( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4M239( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4M239( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4M239( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC004M22 */
                  pr_default.execute(20, new Object[] {Byte.valueOf(A1762CliConveVacHasAnt), Byte.valueOf(A1763CliConveVacDias), Integer.valueOf(A1902ConveVacRelSec), A2038ConveVacRelRef, A2039ConveVacOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_ParticularidadesVacacion");
                  if ( (pr_default.getStatus(20) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ClienteConvenio_ParticularidadesVacacion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4M239( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey4M239( ) ;
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
         endLevel4M239( ) ;
      }
      closeExtendedTableCursors4M239( ) ;
   }

   public void deferredUpdate4M239( )
   {
   }

   public void delete4M239( )
   {
      Gx_mode = "DLT" ;
      beforeValidate4M239( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4M239( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4M239( ) ;
         afterConfirm4M239( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4M239( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC004M23 */
               pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_ParticularidadesVacacion");
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
      sMode239 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel4M239( ) ;
      Gx_mode = sMode239 ;
   }

   public void onDeleteControls4M239( )
   {
      standaloneModal4M239( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel4M239( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(18);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart4M239( )
   {
      /* Scan By routine */
      /* Using cursor BC004M24 */
      pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      RcdFound239 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound239 = (short)(1) ;
         A1761CliConveVacDesAnt = BC004M24_A1761CliConveVacDesAnt[0] ;
         A1762CliConveVacHasAnt = BC004M24_A1762CliConveVacHasAnt[0] ;
         A1763CliConveVacDias = BC004M24_A1763CliConveVacDias[0] ;
         A1902ConveVacRelSec = BC004M24_A1902ConveVacRelSec[0] ;
         A2038ConveVacRelRef = BC004M24_A2038ConveVacRelRef[0] ;
         A2039ConveVacOld = BC004M24_A2039ConveVacOld[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext4M239( )
   {
      /* Scan next routine */
      pr_default.readNext(22);
      RcdFound239 = (short)(0) ;
      scanKeyLoad4M239( ) ;
   }

   public void scanKeyLoad4M239( )
   {
      sMode239 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound239 = (short)(1) ;
         A1761CliConveVacDesAnt = BC004M24_A1761CliConveVacDesAnt[0] ;
         A1762CliConveVacHasAnt = BC004M24_A1762CliConveVacHasAnt[0] ;
         A1763CliConveVacDias = BC004M24_A1763CliConveVacDias[0] ;
         A1902ConveVacRelSec = BC004M24_A1902ConveVacRelSec[0] ;
         A2038ConveVacRelRef = BC004M24_A2038ConveVacRelRef[0] ;
         A2039ConveVacOld = BC004M24_A2039ConveVacOld[0] ;
      }
      Gx_mode = sMode239 ;
   }

   public void scanKeyEnd4M239( )
   {
      pr_default.close(22);
   }

   public void afterConfirm4M239( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert4M239( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4M239( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4M239( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4M239( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4M239( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4M239( )
   {
   }

   public void send_integrity_lvl_hashes4M239( )
   {
   }

   public void send_integrity_lvl_hashes4M204( )
   {
   }

   public void addRow4M204( )
   {
      VarsToRow204( bcClienteConvenio_Particularidades) ;
   }

   public void readRow4M204( )
   {
      RowToVars204( bcClienteConvenio_Particularidades, 1) ;
   }

   public void addRow4M239( )
   {
      web.SdtClienteConvenio_Particularidades_Vacaciones obj239;
      obj239 = new web.SdtClienteConvenio_Particularidades_Vacaciones(remoteHandle);
      VarsToRow239( obj239) ;
      bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().add(obj239, 0);
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode( "UPD" );
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified( (short)(0) );
   }

   public void readRow4M239( )
   {
      nGXsfl_239_idx = (int)(nGXsfl_239_idx+1) ;
      RowToVars239( ((web.SdtClienteConvenio_Particularidades_Vacaciones)bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+nGXsfl_239_idx)), 1) ;
   }

   public void initializeNonKey4M204( )
   {
      A905ConveDefault = false ;
      A1043ConveInterDiasJor = (short)(0) ;
      A1044ConveDiasAcuVac = (byte)(0) ;
      A1046ConveMinMesesVac = (byte)(0) ;
      A1269ConveMesHsPExt = DecimalUtil.ZERO ;
      A1270ConveDiaHsPExt = "" ;
      n1270ConveDiaHsPExt = false ;
      A1401ConveFondoCese = false ;
      A1627ConveGuarEdadMin = (byte)(0) ;
      n1627ConveGuarEdadMin = false ;
      A1628ConveGuarEdadMax = (byte)(0) ;
      n1628ConveGuarEdadMax = false ;
      A1897ConveRelSec = 0 ;
      A2036ConveRelRef = "" ;
      A2037ConvePartOld = "" ;
      O1269ConveMesHsPExt = A1269ConveMesHsPExt ;
      O1270ConveDiaHsPExt = A1270ConveDiaHsPExt ;
      n1270ConveDiaHsPExt = false ;
      O1401ConveFondoCese = A1401ConveFondoCese ;
      O1628ConveGuarEdadMax = A1628ConveGuarEdadMax ;
      n1628ConveGuarEdadMax = false ;
      O1627ConveGuarEdadMin = A1627ConveGuarEdadMin ;
      n1627ConveGuarEdadMin = false ;
      Z905ConveDefault = false ;
      Z1043ConveInterDiasJor = (short)(0) ;
      Z1044ConveDiasAcuVac = (byte)(0) ;
      Z1046ConveMinMesesVac = (byte)(0) ;
      Z1269ConveMesHsPExt = DecimalUtil.ZERO ;
      Z1270ConveDiaHsPExt = "" ;
      Z1401ConveFondoCese = false ;
      Z1627ConveGuarEdadMin = (byte)(0) ;
      Z1628ConveGuarEdadMax = (byte)(0) ;
      Z1897ConveRelSec = 0 ;
      Z2036ConveRelRef = "" ;
   }

   public void initAll4M204( )
   {
      A3CliCod = 0 ;
      A1564CliPaiConve = (short)(0) ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      initializeNonKey4M204( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey4M239( )
   {
      A1762CliConveVacHasAnt = (byte)(0) ;
      A1763CliConveVacDias = (byte)(0) ;
      A1902ConveVacRelSec = 0 ;
      A2038ConveVacRelRef = "" ;
      A2039ConveVacOld = "" ;
      O1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
      O1763CliConveVacDias = A1763CliConveVacDias ;
      Z1762CliConveVacHasAnt = (byte)(0) ;
      Z1763CliConveVacDias = (byte)(0) ;
      Z1902ConveVacRelSec = 0 ;
      Z2038ConveVacRelRef = "" ;
   }

   public void initAll4M239( )
   {
      A1761CliConveVacDesAnt = (byte)(0) ;
      initializeNonKey4M239( ) ;
   }

   public void standaloneModalInsert4M239( )
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

   public void VarsToRow204( web.SdtClienteConvenio_Particularidades obj204 )
   {
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Mode( Gx_mode );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Convedefault( A905ConveDefault );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor( A1043ConveInterDiasJor );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac( A1044ConveDiasAcuVac );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac( A1046ConveMinMesesVac );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Convemeshspext( A1269ConveMesHsPExt );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Convediahspext( A1270ConveDiaHsPExt );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Convefondocese( A1401ConveFondoCese );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin( A1627ConveGuarEdadMin );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax( A1628ConveGuarEdadMax );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Converelsec( A1897ConveRelSec );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Converelref( A2036ConveRelRef );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Convepartold( A2037ConvePartOld );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Clicod( A3CliCod );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve( A1564CliPaiConve );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio( A1565CliConvenio );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig( A1575CliConveVig );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Clicod_Z( Z3CliCod );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z( Z1564CliPaiConve );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z( Z1565CliConvenio );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z( Z1575CliConveVig );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Convedefault_Z( Z905ConveDefault );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z( Z1043ConveInterDiasJor );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z( Z1044ConveDiasAcuVac );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z( Z1046ConveMinMesesVac );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z( Z1269ConveMesHsPExt );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z( Z1270ConveDiaHsPExt );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z( Z1401ConveFondoCese );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z( Z1627ConveGuarEdadMin );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z( Z1628ConveGuarEdadMax );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Converelsec_Z( Z1897ConveRelSec );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Converelref_Z( Z2036ConveRelRef );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Convediahspext_N( (byte)((byte)((n1270ConveDiaHsPExt)?1:0)) );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N( (byte)((byte)((n1627ConveGuarEdadMin)?1:0)) );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N( (byte)((byte)((n1628ConveGuarEdadMax)?1:0)) );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Mode( Gx_mode );
   }

   public void KeyVarsToRow204( web.SdtClienteConvenio_Particularidades obj204 )
   {
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Clicod( A3CliCod );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve( A1564CliPaiConve );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio( A1565CliConvenio );
      obj204.setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig( A1575CliConveVig );
   }

   public void RowToVars204( web.SdtClienteConvenio_Particularidades obj204 ,
                             int forceLoad )
   {
      Gx_mode = obj204.getgxTv_SdtClienteConvenio_Particularidades_Mode() ;
      A905ConveDefault = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convedefault() ;
      A1043ConveInterDiasJor = obj204.getgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor() ;
      A1044ConveDiasAcuVac = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac() ;
      A1046ConveMinMesesVac = obj204.getgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac() ;
      A1269ConveMesHsPExt = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convemeshspext() ;
      A1270ConveDiaHsPExt = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convediahspext() ;
      n1270ConveDiaHsPExt = false ;
      A1401ConveFondoCese = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese() ;
      A1627ConveGuarEdadMin = obj204.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin() ;
      n1627ConveGuarEdadMin = false ;
      A1628ConveGuarEdadMax = obj204.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax() ;
      n1628ConveGuarEdadMax = false ;
      A1897ConveRelSec = obj204.getgxTv_SdtClienteConvenio_Particularidades_Converelsec() ;
      A2036ConveRelRef = obj204.getgxTv_SdtClienteConvenio_Particularidades_Converelref() ;
      A2037ConvePartOld = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convepartold() ;
      A3CliCod = obj204.getgxTv_SdtClienteConvenio_Particularidades_Clicod() ;
      A1564CliPaiConve = obj204.getgxTv_SdtClienteConvenio_Particularidades_Clipaiconve() ;
      A1565CliConvenio = obj204.getgxTv_SdtClienteConvenio_Particularidades_Cliconvenio() ;
      A1575CliConveVig = obj204.getgxTv_SdtClienteConvenio_Particularidades_Cliconvevig() ;
      Z3CliCod = obj204.getgxTv_SdtClienteConvenio_Particularidades_Clicod_Z() ;
      Z1564CliPaiConve = obj204.getgxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z() ;
      Z1565CliConvenio = obj204.getgxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z() ;
      O1565CliConvenio = obj204.getgxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z() ;
      Z1575CliConveVig = obj204.getgxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z() ;
      O1575CliConveVig = obj204.getgxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z() ;
      Z905ConveDefault = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convedefault_Z() ;
      Z1043ConveInterDiasJor = obj204.getgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z() ;
      Z1044ConveDiasAcuVac = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z() ;
      Z1046ConveMinMesesVac = obj204.getgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z() ;
      Z1269ConveMesHsPExt = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z() ;
      O1269ConveMesHsPExt = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z() ;
      Z1270ConveDiaHsPExt = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z() ;
      O1270ConveDiaHsPExt = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z() ;
      Z1401ConveFondoCese = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z() ;
      O1401ConveFondoCese = obj204.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z() ;
      Z1627ConveGuarEdadMin = obj204.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z() ;
      O1627ConveGuarEdadMin = obj204.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z() ;
      Z1628ConveGuarEdadMax = obj204.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z() ;
      O1628ConveGuarEdadMax = obj204.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z() ;
      Z1897ConveRelSec = obj204.getgxTv_SdtClienteConvenio_Particularidades_Converelsec_Z() ;
      Z2036ConveRelRef = obj204.getgxTv_SdtClienteConvenio_Particularidades_Converelref_Z() ;
      n1270ConveDiaHsPExt = (boolean)((obj204.getgxTv_SdtClienteConvenio_Particularidades_Convediahspext_N()==0)?false:true) ;
      n1627ConveGuarEdadMin = (boolean)((obj204.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N()==0)?false:true) ;
      n1628ConveGuarEdadMax = (boolean)((obj204.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N()==0)?false:true) ;
      Gx_mode = obj204.getgxTv_SdtClienteConvenio_Particularidades_Mode() ;
   }

   public void VarsToRow239( web.SdtClienteConvenio_Particularidades_Vacaciones obj239 )
   {
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode( Gx_mode );
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant( A1762CliConveVacHasAnt );
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias( A1763CliConveVacDias );
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec( A1902ConveVacRelSec );
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref( A2038ConveVacRelRef );
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold( A2039ConveVacOld );
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant( A1761CliConveVacDesAnt );
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z( Z1761CliConveVacDesAnt );
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z( Z1762CliConveVacHasAnt );
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z( Z1763CliConveVacDias );
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z( Z1902ConveVacRelSec );
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z( Z2038ConveVacRelRef );
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified( nIsMod_239 );
   }

   public void KeyVarsToRow239( web.SdtClienteConvenio_Particularidades_Vacaciones obj239 )
   {
      obj239.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant( A1761CliConveVacDesAnt );
   }

   public void RowToVars239( web.SdtClienteConvenio_Particularidades_Vacaciones obj239 ,
                             int forceLoad )
   {
      Gx_mode = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode() ;
      A1762CliConveVacHasAnt = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant() ;
      A1763CliConveVacDias = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias() ;
      A1902ConveVacRelSec = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec() ;
      A2038ConveVacRelRef = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref() ;
      A2039ConveVacOld = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacold() ;
      A1761CliConveVacDesAnt = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant() ;
      Z1761CliConveVacDesAnt = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z() ;
      O1761CliConveVacDesAnt = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant_Z() ;
      Z1762CliConveVacHasAnt = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z() ;
      O1762CliConveVacHasAnt = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant_Z() ;
      Z1763CliConveVacDias = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z() ;
      O1763CliConveVacDias = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias_Z() ;
      Z1902ConveVacRelSec = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec_Z() ;
      Z2038ConveVacRelRef = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelref_Z() ;
      nIsMod_239 = obj239.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1564CliPaiConve = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A1565CliConvenio = (String)getParm(obj,2) ;
      A1575CliConveVig = (java.util.Date)getParm(obj,3) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey4M204( ) ;
      scanKeyStart4M204( ) ;
      if ( RcdFound204 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC004M25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(23) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1575CliConveVig = A1575CliConveVig ;
         O1565CliConvenio = A1565CliConvenio ;
         O1575CliConveVig = A1575CliConveVig ;
         O1269ConveMesHsPExt = A1269ConveMesHsPExt ;
         O1270ConveDiaHsPExt = A1270ConveDiaHsPExt ;
         n1270ConveDiaHsPExt = false ;
         O1401ConveFondoCese = A1401ConveFondoCese ;
         O1628ConveGuarEdadMax = A1628ConveGuarEdadMax ;
         n1628ConveGuarEdadMax = false ;
         O1627ConveGuarEdadMin = A1627ConveGuarEdadMin ;
         n1627ConveGuarEdadMin = false ;
      }
      zm4M204( -5) ;
      onLoadActions4M204( ) ;
      addRow4M204( ) ;
      bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().clearCollection();
      if ( RcdFound204 == 1 )
      {
         scanKeyStart4M239( ) ;
         nGXsfl_239_idx = 1 ;
         while ( RcdFound239 != 0 )
         {
            O1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
            O1763CliConveVacDias = A1763CliConveVacDias ;
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z1575CliConveVig = A1575CliConveVig ;
            Z1761CliConveVacDesAnt = A1761CliConveVacDesAnt ;
            zm4M239( -7) ;
            onLoadActions4M239( ) ;
            nRcdExists_239 = (short)(1) ;
            nIsMod_239 = (short)(0) ;
            Z1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
            Z1763CliConveVacDias = A1763CliConveVacDias ;
            addRow4M239( ) ;
            nGXsfl_239_idx = (int)(nGXsfl_239_idx+1) ;
            scanKeyNext4M239( ) ;
         }
         scanKeyEnd4M239( ) ;
      }
      scanKeyEnd4M204( ) ;
      if ( RcdFound204 == 0 )
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
      RowToVars204( bcClienteConvenio_Particularidades, 0) ;
      scanKeyStart4M204( ) ;
      if ( RcdFound204 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC004M26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(24) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
            AnyError = (short)(1) ;
         }
         pr_default.close(24);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1575CliConveVig = A1575CliConveVig ;
         O1565CliConvenio = A1565CliConvenio ;
         O1575CliConveVig = A1575CliConveVig ;
         O1269ConveMesHsPExt = A1269ConveMesHsPExt ;
         O1270ConveDiaHsPExt = A1270ConveDiaHsPExt ;
         n1270ConveDiaHsPExt = false ;
         O1401ConveFondoCese = A1401ConveFondoCese ;
         O1628ConveGuarEdadMax = A1628ConveGuarEdadMax ;
         n1628ConveGuarEdadMax = false ;
         O1627ConveGuarEdadMin = A1627ConveGuarEdadMin ;
         n1627ConveGuarEdadMin = false ;
      }
      zm4M204( -5) ;
      onLoadActions4M204( ) ;
      addRow4M204( ) ;
      bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().clearCollection();
      if ( RcdFound204 == 1 )
      {
         scanKeyStart4M239( ) ;
         nGXsfl_239_idx = 1 ;
         while ( RcdFound239 != 0 )
         {
            O1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
            O1763CliConveVacDias = A1763CliConveVacDias ;
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z1575CliConveVig = A1575CliConveVig ;
            Z1761CliConveVacDesAnt = A1761CliConveVacDesAnt ;
            zm4M239( -7) ;
            onLoadActions4M239( ) ;
            nRcdExists_239 = (short)(1) ;
            nIsMod_239 = (short)(0) ;
            Z1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
            Z1763CliConveVacDias = A1763CliConveVacDias ;
            addRow4M239( ) ;
            nGXsfl_239_idx = (int)(nGXsfl_239_idx+1) ;
            scanKeyNext4M239( ) ;
         }
         scanKeyEnd4M239( ) ;
      }
      scanKeyEnd4M204( ) ;
      if ( RcdFound204 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4M204( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert4M204( ) ;
      }
      else
      {
         if ( RcdFound204 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) )
            {
               A3CliCod = Z3CliCod ;
               A1564CliPaiConve = Z1564CliPaiConve ;
               A1565CliConvenio = Z1565CliConvenio ;
               A1575CliConveVig = Z1575CliConveVig ;
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
               update4M204( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) )
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
                     insert4M204( ) ;
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
                     insert4M204( ) ;
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
      RowToVars204( bcClienteConvenio_Particularidades, 1) ;
      saveImpl( ) ;
      VarsToRow204( bcClienteConvenio_Particularidades) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars204( bcClienteConvenio_Particularidades, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert4M204( ) ;
      afterTrn( ) ;
      VarsToRow204( bcClienteConvenio_Particularidades) ;
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
         web.SdtClienteConvenio_Particularidades auxBC = new web.SdtClienteConvenio_Particularidades( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1575CliConveVig);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcClienteConvenio_Particularidades);
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
      RowToVars204( bcClienteConvenio_Particularidades, 1) ;
      updateImpl( ) ;
      VarsToRow204( bcClienteConvenio_Particularidades) ;
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
      RowToVars204( bcClienteConvenio_Particularidades, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert4M204( ) ;
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
      VarsToRow204( bcClienteConvenio_Particularidades) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars204( bcClienteConvenio_Particularidades, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey4M204( ) ;
      if ( RcdFound204 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) )
         {
            A3CliCod = Z3CliCod ;
            A1564CliPaiConve = Z1564CliPaiConve ;
            A1565CliConvenio = Z1565CliConvenio ;
            A1575CliConveVig = Z1575CliConveVig ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "clienteconvenio_particularidades_bc");
      VarsToRow204( bcClienteConvenio_Particularidades) ;
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
      Gx_mode = bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtClienteConvenio_Particularidades sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcClienteConvenio_Particularidades )
      {
         bcClienteConvenio_Particularidades = sdt ;
         if ( GXutil.strcmp(bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Mode(), "") == 0 )
         {
            bcClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow204( bcClienteConvenio_Particularidades) ;
         }
         else
         {
            RowToVars204( bcClienteConvenio_Particularidades, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Mode(), "") == 0 )
         {
            bcClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars204( bcClienteConvenio_Particularidades, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtClienteConvenio_Particularidades getClienteConvenio_Particularidades_BC( )
   {
      return bcClienteConvenio_Particularidades ;
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
      Z1565CliConvenio = "" ;
      A1565CliConvenio = "" ;
      Z1575CliConveVig = GXutil.nullDate() ;
      A1575CliConveVig = GXutil.nullDate() ;
      sMode204 = "" ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV25Pgmname = "" ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      Z1269ConveMesHsPExt = DecimalUtil.ZERO ;
      A1269ConveMesHsPExt = DecimalUtil.ZERO ;
      Z1270ConveDiaHsPExt = "" ;
      A1270ConveDiaHsPExt = "" ;
      Z2036ConveRelRef = "" ;
      A2036ConveRelRef = "" ;
      Z2037ConvePartOld = "" ;
      A2037ConvePartOld = "" ;
      GXv_int5 = new int[1] ;
      BC004M7_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC004M7_A905ConveDefault = new boolean[] {false} ;
      BC004M7_A1043ConveInterDiasJor = new short[1] ;
      BC004M7_A1044ConveDiasAcuVac = new byte[1] ;
      BC004M7_A1046ConveMinMesesVac = new byte[1] ;
      BC004M7_A1269ConveMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004M7_A1270ConveDiaHsPExt = new String[] {""} ;
      BC004M7_n1270ConveDiaHsPExt = new boolean[] {false} ;
      BC004M7_A1401ConveFondoCese = new boolean[] {false} ;
      BC004M7_A1627ConveGuarEdadMin = new byte[1] ;
      BC004M7_n1627ConveGuarEdadMin = new boolean[] {false} ;
      BC004M7_A1628ConveGuarEdadMax = new byte[1] ;
      BC004M7_n1628ConveGuarEdadMax = new boolean[] {false} ;
      BC004M7_A1897ConveRelSec = new int[1] ;
      BC004M7_A2036ConveRelRef = new String[] {""} ;
      BC004M7_A2037ConvePartOld = new String[] {""} ;
      BC004M7_A3CliCod = new int[1] ;
      BC004M7_A1564CliPaiConve = new short[1] ;
      BC004M7_A1565CliConvenio = new String[] {""} ;
      BC004M8_A3CliCod = new int[1] ;
      O1565CliConvenio = "" ;
      O1575CliConveVig = GXutil.nullDate() ;
      O1269ConveMesHsPExt = DecimalUtil.ZERO ;
      O1270ConveDiaHsPExt = "" ;
      BC004M9_A3CliCod = new int[1] ;
      BC004M9_A1564CliPaiConve = new short[1] ;
      BC004M9_A1565CliConvenio = new String[] {""} ;
      BC004M9_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC004M10_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC004M10_A905ConveDefault = new boolean[] {false} ;
      BC004M10_A1043ConveInterDiasJor = new short[1] ;
      BC004M10_A1044ConveDiasAcuVac = new byte[1] ;
      BC004M10_A1046ConveMinMesesVac = new byte[1] ;
      BC004M10_A1269ConveMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004M10_A1270ConveDiaHsPExt = new String[] {""} ;
      BC004M10_n1270ConveDiaHsPExt = new boolean[] {false} ;
      BC004M10_A1401ConveFondoCese = new boolean[] {false} ;
      BC004M10_A1627ConveGuarEdadMin = new byte[1] ;
      BC004M10_n1627ConveGuarEdadMin = new boolean[] {false} ;
      BC004M10_A1628ConveGuarEdadMax = new byte[1] ;
      BC004M10_n1628ConveGuarEdadMax = new boolean[] {false} ;
      BC004M10_A1897ConveRelSec = new int[1] ;
      BC004M10_A2036ConveRelRef = new String[] {""} ;
      BC004M10_A2037ConvePartOld = new String[] {""} ;
      BC004M10_A3CliCod = new int[1] ;
      BC004M10_A1564CliPaiConve = new short[1] ;
      BC004M10_A1565CliConvenio = new String[] {""} ;
      BC004M11_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC004M11_A905ConveDefault = new boolean[] {false} ;
      BC004M11_A1043ConveInterDiasJor = new short[1] ;
      BC004M11_A1044ConveDiasAcuVac = new byte[1] ;
      BC004M11_A1046ConveMinMesesVac = new byte[1] ;
      BC004M11_A1269ConveMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004M11_A1270ConveDiaHsPExt = new String[] {""} ;
      BC004M11_n1270ConveDiaHsPExt = new boolean[] {false} ;
      BC004M11_A1401ConveFondoCese = new boolean[] {false} ;
      BC004M11_A1627ConveGuarEdadMin = new byte[1] ;
      BC004M11_n1627ConveGuarEdadMin = new boolean[] {false} ;
      BC004M11_A1628ConveGuarEdadMax = new byte[1] ;
      BC004M11_n1628ConveGuarEdadMax = new boolean[] {false} ;
      BC004M11_A1897ConveRelSec = new int[1] ;
      BC004M11_A2036ConveRelRef = new String[] {""} ;
      BC004M11_A2037ConvePartOld = new String[] {""} ;
      BC004M11_A3CliCod = new int[1] ;
      BC004M11_A1564CliPaiConve = new short[1] ;
      BC004M11_A1565CliConvenio = new String[] {""} ;
      BC004M15_A3CliCod = new int[1] ;
      BC004M15_A1564CliPaiConve = new short[1] ;
      BC004M15_A1565CliConvenio = new String[] {""} ;
      BC004M15_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC004M15_A2147CliConveFondoSec = new short[1] ;
      BC004M16_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC004M16_A905ConveDefault = new boolean[] {false} ;
      BC004M16_A1043ConveInterDiasJor = new short[1] ;
      BC004M16_A1044ConveDiasAcuVac = new byte[1] ;
      BC004M16_A1046ConveMinMesesVac = new byte[1] ;
      BC004M16_A1269ConveMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004M16_A1270ConveDiaHsPExt = new String[] {""} ;
      BC004M16_n1270ConveDiaHsPExt = new boolean[] {false} ;
      BC004M16_A1401ConveFondoCese = new boolean[] {false} ;
      BC004M16_A1627ConveGuarEdadMin = new byte[1] ;
      BC004M16_n1627ConveGuarEdadMin = new boolean[] {false} ;
      BC004M16_A1628ConveGuarEdadMax = new byte[1] ;
      BC004M16_n1628ConveGuarEdadMax = new boolean[] {false} ;
      BC004M16_A1897ConveRelSec = new int[1] ;
      BC004M16_A2036ConveRelRef = new String[] {""} ;
      BC004M16_A2037ConvePartOld = new String[] {""} ;
      BC004M16_A3CliCod = new int[1] ;
      BC004M16_A1564CliPaiConve = new short[1] ;
      BC004M16_A1565CliConvenio = new String[] {""} ;
      Z2038ConveVacRelRef = "" ;
      A2038ConveVacRelRef = "" ;
      Z2039ConveVacOld = "" ;
      A2039ConveVacOld = "" ;
      BC004M17_A3CliCod = new int[1] ;
      BC004M17_A1565CliConvenio = new String[] {""} ;
      BC004M17_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC004M17_A1761CliConveVacDesAnt = new byte[1] ;
      BC004M17_A1762CliConveVacHasAnt = new byte[1] ;
      BC004M17_A1763CliConveVacDias = new byte[1] ;
      BC004M17_A1902ConveVacRelSec = new int[1] ;
      BC004M17_A2038ConveVacRelRef = new String[] {""} ;
      BC004M17_A2039ConveVacOld = new String[] {""} ;
      BC004M17_A1564CliPaiConve = new short[1] ;
      BC004M18_A3CliCod = new int[1] ;
      BC004M18_A1564CliPaiConve = new short[1] ;
      BC004M18_A1565CliConvenio = new String[] {""} ;
      BC004M18_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC004M18_A1761CliConveVacDesAnt = new byte[1] ;
      BC004M19_A3CliCod = new int[1] ;
      BC004M19_A1565CliConvenio = new String[] {""} ;
      BC004M19_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC004M19_A1761CliConveVacDesAnt = new byte[1] ;
      BC004M19_A1762CliConveVacHasAnt = new byte[1] ;
      BC004M19_A1763CliConveVacDias = new byte[1] ;
      BC004M19_A1902ConveVacRelSec = new int[1] ;
      BC004M19_A2038ConveVacRelRef = new String[] {""} ;
      BC004M19_A2039ConveVacOld = new String[] {""} ;
      BC004M19_A1564CliPaiConve = new short[1] ;
      sMode239 = "" ;
      BC004M20_A3CliCod = new int[1] ;
      BC004M20_A1565CliConvenio = new String[] {""} ;
      BC004M20_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC004M20_A1761CliConveVacDesAnt = new byte[1] ;
      BC004M20_A1762CliConveVacHasAnt = new byte[1] ;
      BC004M20_A1763CliConveVacDias = new byte[1] ;
      BC004M20_A1902ConveVacRelSec = new int[1] ;
      BC004M20_A2038ConveVacRelRef = new String[] {""} ;
      BC004M20_A2039ConveVacOld = new String[] {""} ;
      BC004M20_A1564CliPaiConve = new short[1] ;
      BC004M24_A3CliCod = new int[1] ;
      BC004M24_A1565CliConvenio = new String[] {""} ;
      BC004M24_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC004M24_A1761CliConveVacDesAnt = new byte[1] ;
      BC004M24_A1762CliConveVacHasAnt = new byte[1] ;
      BC004M24_A1763CliConveVacDias = new byte[1] ;
      BC004M24_A1902ConveVacRelSec = new int[1] ;
      BC004M24_A2038ConveVacRelRef = new String[] {""} ;
      BC004M24_A2039ConveVacOld = new String[] {""} ;
      BC004M24_A1564CliPaiConve = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC004M25_A3CliCod = new int[1] ;
      BC004M26_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clienteconvenio_particularidades_bc__default(),
         new Object[] {
             new Object[] {
            BC004M2_A3CliCod, BC004M2_A1565CliConvenio, BC004M2_A1575CliConveVig, BC004M2_A1761CliConveVacDesAnt, BC004M2_A1762CliConveVacHasAnt, BC004M2_A1763CliConveVacDias, BC004M2_A1902ConveVacRelSec, BC004M2_A2038ConveVacRelRef, BC004M2_A2039ConveVacOld, BC004M2_A1564CliPaiConve
            }
            , new Object[] {
            BC004M3_A3CliCod, BC004M3_A1565CliConvenio, BC004M3_A1575CliConveVig, BC004M3_A1761CliConveVacDesAnt, BC004M3_A1762CliConveVacHasAnt, BC004M3_A1763CliConveVacDias, BC004M3_A1902ConveVacRelSec, BC004M3_A2038ConveVacRelRef, BC004M3_A2039ConveVacOld, BC004M3_A1564CliPaiConve
            }
            , new Object[] {
            BC004M4_A1575CliConveVig, BC004M4_A905ConveDefault, BC004M4_A1043ConveInterDiasJor, BC004M4_A1044ConveDiasAcuVac, BC004M4_A1046ConveMinMesesVac, BC004M4_A1269ConveMesHsPExt, BC004M4_A1270ConveDiaHsPExt, BC004M4_n1270ConveDiaHsPExt, BC004M4_A1401ConveFondoCese, BC004M4_A1627ConveGuarEdadMin,
            BC004M4_n1627ConveGuarEdadMin, BC004M4_A1628ConveGuarEdadMax, BC004M4_n1628ConveGuarEdadMax, BC004M4_A1897ConveRelSec, BC004M4_A2036ConveRelRef, BC004M4_A2037ConvePartOld, BC004M4_A3CliCod, BC004M4_A1564CliPaiConve, BC004M4_A1565CliConvenio
            }
            , new Object[] {
            BC004M5_A1575CliConveVig, BC004M5_A905ConveDefault, BC004M5_A1043ConveInterDiasJor, BC004M5_A1044ConveDiasAcuVac, BC004M5_A1046ConveMinMesesVac, BC004M5_A1269ConveMesHsPExt, BC004M5_A1270ConveDiaHsPExt, BC004M5_n1270ConveDiaHsPExt, BC004M5_A1401ConveFondoCese, BC004M5_A1627ConveGuarEdadMin,
            BC004M5_n1627ConveGuarEdadMin, BC004M5_A1628ConveGuarEdadMax, BC004M5_n1628ConveGuarEdadMax, BC004M5_A1897ConveRelSec, BC004M5_A2036ConveRelRef, BC004M5_A2037ConvePartOld, BC004M5_A3CliCod, BC004M5_A1564CliPaiConve, BC004M5_A1565CliConvenio
            }
            , new Object[] {
            BC004M6_A3CliCod
            }
            , new Object[] {
            BC004M7_A1575CliConveVig, BC004M7_A905ConveDefault, BC004M7_A1043ConveInterDiasJor, BC004M7_A1044ConveDiasAcuVac, BC004M7_A1046ConveMinMesesVac, BC004M7_A1269ConveMesHsPExt, BC004M7_A1270ConveDiaHsPExt, BC004M7_n1270ConveDiaHsPExt, BC004M7_A1401ConveFondoCese, BC004M7_A1627ConveGuarEdadMin,
            BC004M7_n1627ConveGuarEdadMin, BC004M7_A1628ConveGuarEdadMax, BC004M7_n1628ConveGuarEdadMax, BC004M7_A1897ConveRelSec, BC004M7_A2036ConveRelRef, BC004M7_A2037ConvePartOld, BC004M7_A3CliCod, BC004M7_A1564CliPaiConve, BC004M7_A1565CliConvenio
            }
            , new Object[] {
            BC004M8_A3CliCod
            }
            , new Object[] {
            BC004M9_A3CliCod, BC004M9_A1564CliPaiConve, BC004M9_A1565CliConvenio, BC004M9_A1575CliConveVig
            }
            , new Object[] {
            BC004M10_A1575CliConveVig, BC004M10_A905ConveDefault, BC004M10_A1043ConveInterDiasJor, BC004M10_A1044ConveDiasAcuVac, BC004M10_A1046ConveMinMesesVac, BC004M10_A1269ConveMesHsPExt, BC004M10_A1270ConveDiaHsPExt, BC004M10_n1270ConveDiaHsPExt, BC004M10_A1401ConveFondoCese, BC004M10_A1627ConveGuarEdadMin,
            BC004M10_n1627ConveGuarEdadMin, BC004M10_A1628ConveGuarEdadMax, BC004M10_n1628ConveGuarEdadMax, BC004M10_A1897ConveRelSec, BC004M10_A2036ConveRelRef, BC004M10_A2037ConvePartOld, BC004M10_A3CliCod, BC004M10_A1564CliPaiConve, BC004M10_A1565CliConvenio
            }
            , new Object[] {
            BC004M11_A1575CliConveVig, BC004M11_A905ConveDefault, BC004M11_A1043ConveInterDiasJor, BC004M11_A1044ConveDiasAcuVac, BC004M11_A1046ConveMinMesesVac, BC004M11_A1269ConveMesHsPExt, BC004M11_A1270ConveDiaHsPExt, BC004M11_n1270ConveDiaHsPExt, BC004M11_A1401ConveFondoCese, BC004M11_A1627ConveGuarEdadMin,
            BC004M11_n1627ConveGuarEdadMin, BC004M11_A1628ConveGuarEdadMax, BC004M11_n1628ConveGuarEdadMax, BC004M11_A1897ConveRelSec, BC004M11_A2036ConveRelRef, BC004M11_A2037ConvePartOld, BC004M11_A3CliCod, BC004M11_A1564CliPaiConve, BC004M11_A1565CliConvenio
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC004M15_A3CliCod, BC004M15_A1564CliPaiConve, BC004M15_A1565CliConvenio, BC004M15_A1575CliConveVig, BC004M15_A2147CliConveFondoSec
            }
            , new Object[] {
            BC004M16_A1575CliConveVig, BC004M16_A905ConveDefault, BC004M16_A1043ConveInterDiasJor, BC004M16_A1044ConveDiasAcuVac, BC004M16_A1046ConveMinMesesVac, BC004M16_A1269ConveMesHsPExt, BC004M16_A1270ConveDiaHsPExt, BC004M16_n1270ConveDiaHsPExt, BC004M16_A1401ConveFondoCese, BC004M16_A1627ConveGuarEdadMin,
            BC004M16_n1627ConveGuarEdadMin, BC004M16_A1628ConveGuarEdadMax, BC004M16_n1628ConveGuarEdadMax, BC004M16_A1897ConveRelSec, BC004M16_A2036ConveRelRef, BC004M16_A2037ConvePartOld, BC004M16_A3CliCod, BC004M16_A1564CliPaiConve, BC004M16_A1565CliConvenio
            }
            , new Object[] {
            BC004M17_A3CliCod, BC004M17_A1565CliConvenio, BC004M17_A1575CliConveVig, BC004M17_A1761CliConveVacDesAnt, BC004M17_A1762CliConveVacHasAnt, BC004M17_A1763CliConveVacDias, BC004M17_A1902ConveVacRelSec, BC004M17_A2038ConveVacRelRef, BC004M17_A2039ConveVacOld, BC004M17_A1564CliPaiConve
            }
            , new Object[] {
            BC004M18_A3CliCod, BC004M18_A1564CliPaiConve, BC004M18_A1565CliConvenio, BC004M18_A1575CliConveVig, BC004M18_A1761CliConveVacDesAnt
            }
            , new Object[] {
            BC004M19_A3CliCod, BC004M19_A1565CliConvenio, BC004M19_A1575CliConveVig, BC004M19_A1761CliConveVacDesAnt, BC004M19_A1762CliConveVacHasAnt, BC004M19_A1763CliConveVacDias, BC004M19_A1902ConveVacRelSec, BC004M19_A2038ConveVacRelRef, BC004M19_A2039ConveVacOld, BC004M19_A1564CliPaiConve
            }
            , new Object[] {
            BC004M20_A3CliCod, BC004M20_A1565CliConvenio, BC004M20_A1575CliConveVig, BC004M20_A1761CliConveVacDesAnt, BC004M20_A1762CliConveVacHasAnt, BC004M20_A1763CliConveVacDias, BC004M20_A1902ConveVacRelSec, BC004M20_A2038ConveVacRelRef, BC004M20_A2039ConveVacOld, BC004M20_A1564CliPaiConve
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC004M24_A3CliCod, BC004M24_A1565CliConvenio, BC004M24_A1575CliConveVig, BC004M24_A1761CliConveVacDesAnt, BC004M24_A1762CliConveVacHasAnt, BC004M24_A1763CliConveVacDias, BC004M24_A1902ConveVacRelSec, BC004M24_A2038ConveVacRelRef, BC004M24_A2039ConveVacOld, BC004M24_A1564CliPaiConve
            }
            , new Object[] {
            BC004M25_A3CliCod
            }
            , new Object[] {
            BC004M26_A3CliCod
            }
         }
      );
      AV25Pgmname = "ClienteConvenio_Particularidades_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e124M2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z1044ConveDiasAcuVac ;
   private byte A1044ConveDiasAcuVac ;
   private byte Z1046ConveMinMesesVac ;
   private byte A1046ConveMinMesesVac ;
   private byte Z1627ConveGuarEdadMin ;
   private byte A1627ConveGuarEdadMin ;
   private byte Z1628ConveGuarEdadMax ;
   private byte A1628ConveGuarEdadMax ;
   private byte O1628ConveGuarEdadMax ;
   private byte O1627ConveGuarEdadMin ;
   private byte Gxremove239 ;
   private byte Z1762CliConveVacHasAnt ;
   private byte A1762CliConveVacHasAnt ;
   private byte Z1763CliConveVacDias ;
   private byte A1763CliConveVacDias ;
   private byte Z1761CliConveVacDesAnt ;
   private byte A1761CliConveVacDesAnt ;
   private byte Gx_BScreen ;
   private byte O1761CliConveVacDesAnt ;
   private byte O1762CliConveVacHasAnt ;
   private byte O1763CliConveVacDias ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1564CliPaiConve ;
   private short A1564CliPaiConve ;
   private short nIsMod_239 ;
   private short RcdFound239 ;
   private short Z1043ConveInterDiasJor ;
   private short A1043ConveInterDiasJor ;
   private short RcdFound204 ;
   private short nIsDirty_204 ;
   private short nRcdExists_239 ;
   private short nIsDirty_239 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int nGXsfl_239_idx=1 ;
   private int GX_JID ;
   private int Z1897ConveRelSec ;
   private int A1897ConveRelSec ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private int Z1902ConveVacRelSec ;
   private int A1902ConveVacRelSec ;
   private java.math.BigDecimal Z1269ConveMesHsPExt ;
   private java.math.BigDecimal A1269ConveMesHsPExt ;
   private java.math.BigDecimal O1269ConveMesHsPExt ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z1565CliConvenio ;
   private String A1565CliConvenio ;
   private String sMode204 ;
   private String AV25Pgmname ;
   private String Z1270ConveDiaHsPExt ;
   private String A1270ConveDiaHsPExt ;
   private String O1565CliConvenio ;
   private String O1270ConveDiaHsPExt ;
   private String sMode239 ;
   private java.util.Date Z1575CliConveVig ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date O1575CliConveVig ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z905ConveDefault ;
   private boolean A905ConveDefault ;
   private boolean Z1401ConveFondoCese ;
   private boolean A1401ConveFondoCese ;
   private boolean n1270ConveDiaHsPExt ;
   private boolean n1627ConveGuarEdadMin ;
   private boolean n1628ConveGuarEdadMax ;
   private boolean O1401ConveFondoCese ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z2037ConvePartOld ;
   private String A2037ConvePartOld ;
   private String Z2039ConveVacOld ;
   private String A2039ConveVacOld ;
   private String Z2036ConveRelRef ;
   private String A2036ConveRelRef ;
   private String Z2038ConveVacRelRef ;
   private String A2038ConveVacRelRef ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private web.SdtClienteConvenio_Particularidades bcClienteConvenio_Particularidades ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] BC004M7_A1575CliConveVig ;
   private boolean[] BC004M7_A905ConveDefault ;
   private short[] BC004M7_A1043ConveInterDiasJor ;
   private byte[] BC004M7_A1044ConveDiasAcuVac ;
   private byte[] BC004M7_A1046ConveMinMesesVac ;
   private java.math.BigDecimal[] BC004M7_A1269ConveMesHsPExt ;
   private String[] BC004M7_A1270ConveDiaHsPExt ;
   private boolean[] BC004M7_n1270ConveDiaHsPExt ;
   private boolean[] BC004M7_A1401ConveFondoCese ;
   private byte[] BC004M7_A1627ConveGuarEdadMin ;
   private boolean[] BC004M7_n1627ConveGuarEdadMin ;
   private byte[] BC004M7_A1628ConveGuarEdadMax ;
   private boolean[] BC004M7_n1628ConveGuarEdadMax ;
   private int[] BC004M7_A1897ConveRelSec ;
   private String[] BC004M7_A2036ConveRelRef ;
   private String[] BC004M7_A2037ConvePartOld ;
   private int[] BC004M7_A3CliCod ;
   private short[] BC004M7_A1564CliPaiConve ;
   private String[] BC004M7_A1565CliConvenio ;
   private int[] BC004M8_A3CliCod ;
   private int[] BC004M9_A3CliCod ;
   private short[] BC004M9_A1564CliPaiConve ;
   private String[] BC004M9_A1565CliConvenio ;
   private java.util.Date[] BC004M9_A1575CliConveVig ;
   private java.util.Date[] BC004M10_A1575CliConveVig ;
   private boolean[] BC004M10_A905ConveDefault ;
   private short[] BC004M10_A1043ConveInterDiasJor ;
   private byte[] BC004M10_A1044ConveDiasAcuVac ;
   private byte[] BC004M10_A1046ConveMinMesesVac ;
   private java.math.BigDecimal[] BC004M10_A1269ConveMesHsPExt ;
   private String[] BC004M10_A1270ConveDiaHsPExt ;
   private boolean[] BC004M10_n1270ConveDiaHsPExt ;
   private boolean[] BC004M10_A1401ConveFondoCese ;
   private byte[] BC004M10_A1627ConveGuarEdadMin ;
   private boolean[] BC004M10_n1627ConveGuarEdadMin ;
   private byte[] BC004M10_A1628ConveGuarEdadMax ;
   private boolean[] BC004M10_n1628ConveGuarEdadMax ;
   private int[] BC004M10_A1897ConveRelSec ;
   private String[] BC004M10_A2036ConveRelRef ;
   private String[] BC004M10_A2037ConvePartOld ;
   private int[] BC004M10_A3CliCod ;
   private short[] BC004M10_A1564CliPaiConve ;
   private String[] BC004M10_A1565CliConvenio ;
   private java.util.Date[] BC004M11_A1575CliConveVig ;
   private boolean[] BC004M11_A905ConveDefault ;
   private short[] BC004M11_A1043ConveInterDiasJor ;
   private byte[] BC004M11_A1044ConveDiasAcuVac ;
   private byte[] BC004M11_A1046ConveMinMesesVac ;
   private java.math.BigDecimal[] BC004M11_A1269ConveMesHsPExt ;
   private String[] BC004M11_A1270ConveDiaHsPExt ;
   private boolean[] BC004M11_n1270ConveDiaHsPExt ;
   private boolean[] BC004M11_A1401ConveFondoCese ;
   private byte[] BC004M11_A1627ConveGuarEdadMin ;
   private boolean[] BC004M11_n1627ConveGuarEdadMin ;
   private byte[] BC004M11_A1628ConveGuarEdadMax ;
   private boolean[] BC004M11_n1628ConveGuarEdadMax ;
   private int[] BC004M11_A1897ConveRelSec ;
   private String[] BC004M11_A2036ConveRelRef ;
   private String[] BC004M11_A2037ConvePartOld ;
   private int[] BC004M11_A3CliCod ;
   private short[] BC004M11_A1564CliPaiConve ;
   private String[] BC004M11_A1565CliConvenio ;
   private int[] BC004M15_A3CliCod ;
   private short[] BC004M15_A1564CliPaiConve ;
   private String[] BC004M15_A1565CliConvenio ;
   private java.util.Date[] BC004M15_A1575CliConveVig ;
   private short[] BC004M15_A2147CliConveFondoSec ;
   private java.util.Date[] BC004M16_A1575CliConveVig ;
   private boolean[] BC004M16_A905ConveDefault ;
   private short[] BC004M16_A1043ConveInterDiasJor ;
   private byte[] BC004M16_A1044ConveDiasAcuVac ;
   private byte[] BC004M16_A1046ConveMinMesesVac ;
   private java.math.BigDecimal[] BC004M16_A1269ConveMesHsPExt ;
   private String[] BC004M16_A1270ConveDiaHsPExt ;
   private boolean[] BC004M16_n1270ConveDiaHsPExt ;
   private boolean[] BC004M16_A1401ConveFondoCese ;
   private byte[] BC004M16_A1627ConveGuarEdadMin ;
   private boolean[] BC004M16_n1627ConveGuarEdadMin ;
   private byte[] BC004M16_A1628ConveGuarEdadMax ;
   private boolean[] BC004M16_n1628ConveGuarEdadMax ;
   private int[] BC004M16_A1897ConveRelSec ;
   private String[] BC004M16_A2036ConveRelRef ;
   private String[] BC004M16_A2037ConvePartOld ;
   private int[] BC004M16_A3CliCod ;
   private short[] BC004M16_A1564CliPaiConve ;
   private String[] BC004M16_A1565CliConvenio ;
   private int[] BC004M17_A3CliCod ;
   private String[] BC004M17_A1565CliConvenio ;
   private java.util.Date[] BC004M17_A1575CliConveVig ;
   private byte[] BC004M17_A1761CliConveVacDesAnt ;
   private byte[] BC004M17_A1762CliConveVacHasAnt ;
   private byte[] BC004M17_A1763CliConveVacDias ;
   private int[] BC004M17_A1902ConveVacRelSec ;
   private String[] BC004M17_A2038ConveVacRelRef ;
   private String[] BC004M17_A2039ConveVacOld ;
   private short[] BC004M17_A1564CliPaiConve ;
   private int[] BC004M18_A3CliCod ;
   private short[] BC004M18_A1564CliPaiConve ;
   private String[] BC004M18_A1565CliConvenio ;
   private java.util.Date[] BC004M18_A1575CliConveVig ;
   private byte[] BC004M18_A1761CliConveVacDesAnt ;
   private int[] BC004M19_A3CliCod ;
   private String[] BC004M19_A1565CliConvenio ;
   private java.util.Date[] BC004M19_A1575CliConveVig ;
   private byte[] BC004M19_A1761CliConveVacDesAnt ;
   private byte[] BC004M19_A1762CliConveVacHasAnt ;
   private byte[] BC004M19_A1763CliConveVacDias ;
   private int[] BC004M19_A1902ConveVacRelSec ;
   private String[] BC004M19_A2038ConveVacRelRef ;
   private String[] BC004M19_A2039ConveVacOld ;
   private short[] BC004M19_A1564CliPaiConve ;
   private int[] BC004M20_A3CliCod ;
   private String[] BC004M20_A1565CliConvenio ;
   private java.util.Date[] BC004M20_A1575CliConveVig ;
   private byte[] BC004M20_A1761CliConveVacDesAnt ;
   private byte[] BC004M20_A1762CliConveVacHasAnt ;
   private byte[] BC004M20_A1763CliConveVacDias ;
   private int[] BC004M20_A1902ConveVacRelSec ;
   private String[] BC004M20_A2038ConveVacRelRef ;
   private String[] BC004M20_A2039ConveVacOld ;
   private short[] BC004M20_A1564CliPaiConve ;
   private int[] BC004M24_A3CliCod ;
   private String[] BC004M24_A1565CliConvenio ;
   private java.util.Date[] BC004M24_A1575CliConveVig ;
   private byte[] BC004M24_A1761CliConveVacDesAnt ;
   private byte[] BC004M24_A1762CliConveVacHasAnt ;
   private byte[] BC004M24_A1763CliConveVacDias ;
   private int[] BC004M24_A1902ConveVacRelSec ;
   private String[] BC004M24_A2038ConveVacRelRef ;
   private String[] BC004M24_A2039ConveVacOld ;
   private short[] BC004M24_A1564CliPaiConve ;
   private int[] BC004M25_A3CliCod ;
   private int[] BC004M26_A3CliCod ;
   private int[] BC004M2_A3CliCod ;
   private String[] BC004M2_A1565CliConvenio ;
   private java.util.Date[] BC004M2_A1575CliConveVig ;
   private byte[] BC004M2_A1761CliConveVacDesAnt ;
   private byte[] BC004M2_A1762CliConveVacHasAnt ;
   private byte[] BC004M2_A1763CliConveVacDias ;
   private int[] BC004M2_A1902ConveVacRelSec ;
   private String[] BC004M2_A2038ConveVacRelRef ;
   private String[] BC004M2_A2039ConveVacOld ;
   private short[] BC004M2_A1564CliPaiConve ;
   private int[] BC004M3_A3CliCod ;
   private String[] BC004M3_A1565CliConvenio ;
   private java.util.Date[] BC004M3_A1575CliConveVig ;
   private byte[] BC004M3_A1761CliConveVacDesAnt ;
   private byte[] BC004M3_A1762CliConveVacHasAnt ;
   private byte[] BC004M3_A1763CliConveVacDias ;
   private int[] BC004M3_A1902ConveVacRelSec ;
   private String[] BC004M3_A2038ConveVacRelRef ;
   private String[] BC004M3_A2039ConveVacOld ;
   private short[] BC004M3_A1564CliPaiConve ;
   private java.util.Date[] BC004M4_A1575CliConveVig ;
   private boolean[] BC004M4_A905ConveDefault ;
   private short[] BC004M4_A1043ConveInterDiasJor ;
   private byte[] BC004M4_A1044ConveDiasAcuVac ;
   private byte[] BC004M4_A1046ConveMinMesesVac ;
   private java.math.BigDecimal[] BC004M4_A1269ConveMesHsPExt ;
   private String[] BC004M4_A1270ConveDiaHsPExt ;
   private boolean[] BC004M4_A1401ConveFondoCese ;
   private byte[] BC004M4_A1627ConveGuarEdadMin ;
   private byte[] BC004M4_A1628ConveGuarEdadMax ;
   private int[] BC004M4_A1897ConveRelSec ;
   private String[] BC004M4_A2036ConveRelRef ;
   private String[] BC004M4_A2037ConvePartOld ;
   private int[] BC004M4_A3CliCod ;
   private short[] BC004M4_A1564CliPaiConve ;
   private String[] BC004M4_A1565CliConvenio ;
   private java.util.Date[] BC004M5_A1575CliConveVig ;
   private boolean[] BC004M5_A905ConveDefault ;
   private short[] BC004M5_A1043ConveInterDiasJor ;
   private byte[] BC004M5_A1044ConveDiasAcuVac ;
   private byte[] BC004M5_A1046ConveMinMesesVac ;
   private java.math.BigDecimal[] BC004M5_A1269ConveMesHsPExt ;
   private String[] BC004M5_A1270ConveDiaHsPExt ;
   private boolean[] BC004M5_A1401ConveFondoCese ;
   private byte[] BC004M5_A1627ConveGuarEdadMin ;
   private byte[] BC004M5_A1628ConveGuarEdadMax ;
   private int[] BC004M5_A1897ConveRelSec ;
   private String[] BC004M5_A2036ConveRelRef ;
   private String[] BC004M5_A2037ConvePartOld ;
   private int[] BC004M5_A3CliCod ;
   private short[] BC004M5_A1564CliPaiConve ;
   private String[] BC004M5_A1565CliConvenio ;
   private int[] BC004M6_A3CliCod ;
   private boolean[] BC004M4_n1270ConveDiaHsPExt ;
   private boolean[] BC004M4_n1627ConveGuarEdadMin ;
   private boolean[] BC004M4_n1628ConveGuarEdadMax ;
   private boolean[] BC004M5_n1270ConveDiaHsPExt ;
   private boolean[] BC004M5_n1627ConveGuarEdadMin ;
   private boolean[] BC004M5_n1628ConveGuarEdadMax ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
}

final  class clienteconvenio_particularidades_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC004M2", "SELECT CliCod, CliConvenio, CliConveVig, CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliPaiConve FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ?  FOR UPDATE OF ClienteConvenio_ParticularidadesVacacion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M3", "SELECT CliCod, CliConvenio, CliConveVig, CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliPaiConve FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M4", "SELECT CliConveVig, ConveDefault, ConveInterDiasJor, ConveDiasAcuVac, ConveMinMesesVac, ConveMesHsPExt, ConveDiaHsPExt, ConveFondoCese, ConveGuarEdadMin, ConveGuarEdadMax, ConveRelSec, ConveRelRef, ConvePartOld, CliCod, CliPaiConve, CliConvenio FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ?  FOR UPDATE OF ClienteConvenio_Particularidades",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M5", "SELECT CliConveVig, ConveDefault, ConveInterDiasJor, ConveDiasAcuVac, ConveMinMesesVac, ConveMesHsPExt, ConveDiaHsPExt, ConveFondoCese, ConveGuarEdadMin, ConveGuarEdadMax, ConveRelSec, ConveRelRef, ConvePartOld, CliCod, CliPaiConve, CliConvenio FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M6", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M7", "SELECT TM1.CliConveVig, TM1.ConveDefault, TM1.ConveInterDiasJor, TM1.ConveDiasAcuVac, TM1.ConveMinMesesVac, TM1.ConveMesHsPExt, TM1.ConveDiaHsPExt, TM1.ConveFondoCese, TM1.ConveGuarEdadMin, TM1.ConveGuarEdadMax, TM1.ConveRelSec, TM1.ConveRelRef, TM1.ConvePartOld, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio FROM ClienteConvenio_Particularidades TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.CliConveVig = ? ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CliConveVig ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M8", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M9", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M10", "SELECT CliConveVig, ConveDefault, ConveInterDiasJor, ConveDiasAcuVac, ConveMinMesesVac, ConveMesHsPExt, ConveDiaHsPExt, ConveFondoCese, ConveGuarEdadMin, ConveGuarEdadMax, ConveRelSec, ConveRelRef, ConvePartOld, CliCod, CliPaiConve, CliConvenio FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M11", "SELECT CliConveVig, ConveDefault, ConveInterDiasJor, ConveDiasAcuVac, ConveMinMesesVac, ConveMesHsPExt, ConveDiaHsPExt, ConveFondoCese, ConveGuarEdadMin, ConveGuarEdadMax, ConveRelSec, ConveRelRef, ConvePartOld, CliCod, CliPaiConve, CliConvenio FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ?  FOR UPDATE OF ClienteConvenio_Particularidades",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC004M12", "SAVEPOINT gxupdate;INSERT INTO ClienteConvenio_Particularidades(CliConveVig, ConveDefault, ConveInterDiasJor, ConveDiasAcuVac, ConveMinMesesVac, ConveMesHsPExt, ConveDiaHsPExt, ConveFondoCese, ConveGuarEdadMin, ConveGuarEdadMax, ConveRelSec, ConveRelRef, ConvePartOld, CliCod, CliPaiConve, CliConvenio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC004M13", "SAVEPOINT gxupdate;UPDATE ClienteConvenio_Particularidades SET ConveDefault=?, ConveInterDiasJor=?, ConveDiasAcuVac=?, ConveMinMesesVac=?, ConveMesHsPExt=?, ConveDiaHsPExt=?, ConveFondoCese=?, ConveGuarEdadMin=?, ConveGuarEdadMax=?, ConveRelSec=?, ConveRelRef=?, ConvePartOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC004M14", "SAVEPOINT gxupdate;DELETE FROM ClienteConvenio_Particularidades  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC004M15", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec FROM Clientecct_fondocese WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC004M16", "SELECT TM1.CliConveVig, TM1.ConveDefault, TM1.ConveInterDiasJor, TM1.ConveDiasAcuVac, TM1.ConveMinMesesVac, TM1.ConveMesHsPExt, TM1.ConveDiaHsPExt, TM1.ConveFondoCese, TM1.ConveGuarEdadMin, TM1.ConveGuarEdadMax, TM1.ConveRelSec, TM1.ConveRelRef, TM1.ConvePartOld, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio FROM ClienteConvenio_Particularidades TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.CliConveVig = ? ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CliConveVig ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M17", "SELECT CliCod, CliConvenio, CliConveVig, CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliPaiConve FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig = ? and CliConveVacDesAnt = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M18", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M19", "SELECT CliCod, CliConvenio, CliConveVig, CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliPaiConve FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M20", "SELECT CliCod, CliConvenio, CliConveVig, CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliPaiConve FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ?  FOR UPDATE OF ClienteConvenio_ParticularidadesVacacion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC004M21", "SAVEPOINT gxupdate;INSERT INTO ClienteConvenio_ParticularidadesVacacion(CliCod, CliConvenio, CliConveVig, CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliPaiConve) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC004M22", "SAVEPOINT gxupdate;UPDATE ClienteConvenio_ParticularidadesVacacion SET CliConveVacHasAnt=?, CliConveVacDias=?, ConveVacRelSec=?, ConveVacRelRef=?, ConveVacOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC004M23", "SAVEPOINT gxupdate;DELETE FROM ClienteConvenio_ParticularidadesVacacion  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC004M24", "SELECT CliCod, CliConvenio, CliConveVig, CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliPaiConve FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M25", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004M26", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 2 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(8);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(13);
               ((int[]) buf[16])[0] = rslt.getInt(14);
               ((short[]) buf[17])[0] = rslt.getShort(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(8);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(13);
               ((int[]) buf[16])[0] = rslt.getInt(14);
               ((short[]) buf[17])[0] = rslt.getShort(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(8);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(13);
               ((int[]) buf[16])[0] = rslt.getInt(14);
               ((short[]) buf[17])[0] = rslt.getShort(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 8 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(8);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(13);
               ((int[]) buf[16])[0] = rslt.getInt(14);
               ((short[]) buf[17])[0] = rslt.getShort(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               return;
            case 9 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(8);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(13);
               ((int[]) buf[16])[0] = rslt.getInt(14);
               ((short[]) buf[17])[0] = rslt.getShort(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 14 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(8);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(13);
               ((int[]) buf[16])[0] = rslt.getInt(14);
               ((short[]) buf[17])[0] = rslt.getShort(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 24 :
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 10 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 1);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[7], 20);
               }
               stmt.setBoolean(8, ((Boolean) parms[8]).booleanValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(9, ((Number) parms[10]).byteValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(10, ((Number) parms[12]).byteValue());
               }
               stmt.setInt(11, ((Number) parms[13]).intValue());
               stmt.setVarchar(12, (String)parms[14], 40, false);
               stmt.setNLongVarchar(13, (String)parms[15], false);
               stmt.setInt(14, ((Number) parms[16]).intValue());
               stmt.setShort(15, ((Number) parms[17]).shortValue());
               stmt.setString(16, (String)parms[18], 20);
               return;
            case 11 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 1);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
               }
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(8, ((Number) parms[9]).byteValue());
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(9, ((Number) parms[11]).byteValue());
               }
               stmt.setInt(10, ((Number) parms[12]).intValue());
               stmt.setVarchar(11, (String)parms[13], 40, false);
               stmt.setNLongVarchar(12, (String)parms[14], false);
               stmt.setInt(13, ((Number) parms[15]).intValue());
               stmt.setShort(14, ((Number) parms[16]).shortValue());
               stmt.setString(15, (String)parms[17], 20);
               stmt.setDate(16, (java.util.Date)parms[18]);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 20 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setNLongVarchar(5, (String)parms[4], false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               stmt.setDate(9, (java.util.Date)parms[8]);
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

