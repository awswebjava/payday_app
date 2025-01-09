package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateconveniotiposdetrabajo extends GXProcedure
{
   public updateconveniotiposdetrabajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateconveniotiposdetrabajo.class ), "" );
   }

   public updateconveniotiposdetrabajo( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( long aP0 ,
                        int aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( long aP0 ,
                             int aP1 ,
                             int aP2 )
   {
      updateconveniotiposdetrabajo.this.AV13ClientePadre = aP0;
      updateconveniotiposdetrabajo.this.AV11CliCod = aP1;
      updateconveniotiposdetrabajo.this.AV18CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV45padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV13ClientePadre), AV18CliRelSec, GXv_dtime1) ;
      updateconveniotiposdetrabajo.this.AV45padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "&ClientePadre ", "")+GXutil.trim( GXutil.str( AV13ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV18CliRelSec, 6, 0))) ;
      AV50GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV18CliRelSec) ,
                                           Integer.valueOf(A2063ConveHsRelSec) ,
                                           Long.valueOf(AV13ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01WR2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV13ClientePadre), Integer.valueOf(AV18CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2063ConveHsRelSec = P01WR2_A2063ConveHsRelSec[0] ;
         A3CliCod = P01WR2_A3CliCod[0] ;
         A1564CliPaiConve = P01WR2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01WR2_A1565CliConvenio[0] ;
         A1294PaiTipoTraId = P01WR2_A1294PaiTipoTraId[0] ;
         A1323ConveHsDia = P01WR2_A1323ConveHsDia[0] ;
         A1324ConveHsSem = P01WR2_A1324ConveHsSem[0] ;
         A1325ConveTarifaXLim = P01WR2_A1325ConveTarifaXLim[0] ;
         A1349ConveTarifaRec = P01WR2_A1349ConveTarifaRec[0] ;
         A1391ConveHsMaxDia = P01WR2_A1391ConveHsMaxDia[0] ;
         A1392ConveHsMaxSem = P01WR2_A1392ConveHsMaxSem[0] ;
         A1393ConveHsMaxMes = P01WR2_A1393ConveHsMaxMes[0] ;
         A1394ConveHsMaxAnu = P01WR2_A1394ConveHsMaxAnu[0] ;
         A2065ConveHsOld = P01WR2_A2065ConveHsOld[0] ;
         AV50GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV46clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV11CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updateconveniotiposdetrabajo.this.AV46clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV46clienteConvenioTiene )
         {
            AV43importar = false ;
            AV44liberacionPendiente = false ;
            if ( ! (0==AV18CliRelSec) )
            {
               AV43importar = true ;
            }
            else
            {
               if ( (0==A2063ConveHsRelSec) )
               {
                  AV43importar = true ;
               }
               else
               {
                  GXv_dtime1[0] = AV17CliRelease ;
                  GXv_boolean2[0] = AV16CliReHabilitado ;
                  new web.getreleasedtyhabilitado(remoteHandle, context).execute( A3CliCod, A2063ConveHsRelSec, GXv_dtime1, GXv_boolean2) ;
                  updateconveniotiposdetrabajo.this.AV17CliRelease = GXv_dtime1[0] ;
                  updateconveniotiposdetrabajo.this.AV16CliReHabilitado = GXv_boolean2[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "&CliReHabilitado ", "")+GXutil.trim( GXutil.booltostr( AV16CliReHabilitado))+httpContext.getMessage( " &CliRelease ", "")+GXutil.trim( localUtil.ttoc( AV17CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
                  if ( ( AV16CliReHabilitado ) && (( AV17CliRelease.before( GXutil.serverNow( context, remoteHandle, pr_default) ) ) || ( GXutil.dateCompare(AV17CliRelease, GXutil.serverNow( context, remoteHandle, pr_default)) )) )
                  {
                     AV43importar = true ;
                  }
                  else
                  {
                     GXv_boolean2[0] = AV9alguienYaActualizo ;
                     new web.alguienyaactualizoliberacion(remoteHandle, context).execute( A3CliCod, A2063ConveHsRelSec, GXv_boolean2) ;
                     updateconveniotiposdetrabajo.this.AV9alguienYaActualizo = GXv_boolean2[0] ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "&alguienYaActualizo ", "")+GXutil.trim( GXutil.booltostr( AV9alguienYaActualizo))) ;
                     if ( AV9alguienYaActualizo )
                     {
                        AV43importar = true ;
                     }
                     else
                     {
                        AV44liberacionPendiente = true ;
                     }
                  }
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "&importar ", "")+GXutil.trim( GXutil.booltostr( AV43importar))+httpContext.getMessage( " &liberacionpendiente ", "")+GXutil.trim( GXutil.booltostr( AV44liberacionPendiente))) ;
            if ( AV43importar )
            {
               AV15CliPaiConve = A1564CliPaiConve ;
               AV12CliConvenio = A1565CliConvenio ;
               AV8PaiTipoTraId = A1294PaiTipoTraId ;
               AV19ConveHsDia = A1323ConveHsDia ;
               AV24ConveHsSem = A1324ConveHsSem ;
               AV37ConveTarifaXLim = A1325ConveTarifaXLim ;
               AV36ConveTarifaRec = A1349ConveTarifaRec ;
               AV21ConveHsMaxDia = A1391ConveHsMaxDia ;
               AV23ConveHsMaxSem = A1392ConveHsMaxSem ;
               AV22ConveHsMaxMes = A1393ConveHsMaxMes ;
               AV20ConveHsMaxAnu = A1394ConveHsMaxAnu ;
               /* Execute user subroutine: 'HIJO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "vengo", "")) ;
               if ( AV44liberacionPendiente )
               {
                  if ( ! (GXutil.strcmp("", A2065ConveHsOld)==0) )
                  {
                     AV35convenio_tiposdetrabajo_old.fromJSonString(GXutil.trim( A2065ConveHsOld), null);
                     AV15CliPaiConve = A1564CliPaiConve ;
                     AV12CliConvenio = A1565CliConvenio ;
                     AV8PaiTipoTraId = A1294PaiTipoTraId ;
                     AV19ConveHsDia = AV35convenio_tiposdetrabajo_old.getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsdia() ;
                     AV24ConveHsSem = AV35convenio_tiposdetrabajo_old.getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehssem() ;
                     AV37ConveTarifaXLim = AV35convenio_tiposdetrabajo_old.getgxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifaxlim() ;
                     AV36ConveTarifaRec = AV35convenio_tiposdetrabajo_old.getgxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifarec() ;
                     AV21ConveHsMaxDia = AV35convenio_tiposdetrabajo_old.getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxdia() ;
                     AV23ConveHsMaxSem = AV35convenio_tiposdetrabajo_old.getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxsem() ;
                     AV22ConveHsMaxMes = AV35convenio_tiposdetrabajo_old.getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxmes() ;
                     AV20ConveHsMaxAnu = AV35convenio_tiposdetrabajo_old.getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxanu() ;
                     /* Execute user subroutine: 'HIJO' */
                     S111 ();
                     if ( returnInSub )
                     {
                        pr_default.close(0);
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                  }
               }
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV50GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "none1", "")) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, "4") ;
      AV51GXLvl88 = (byte)(0) ;
      /* Using cursor P01WR3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV15CliPaiConve), AV12CliConvenio, AV8PaiTipoTraId});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1294PaiTipoTraId = P01WR3_A1294PaiTipoTraId[0] ;
         A1565CliConvenio = P01WR3_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01WR3_A1564CliPaiConve[0] ;
         A3CliCod = P01WR3_A3CliCod[0] ;
         A2063ConveHsRelSec = P01WR3_A2063ConveHsRelSec[0] ;
         A1323ConveHsDia = P01WR3_A1323ConveHsDia[0] ;
         A1324ConveHsSem = P01WR3_A1324ConveHsSem[0] ;
         A1325ConveTarifaXLim = P01WR3_A1325ConveTarifaXLim[0] ;
         A1349ConveTarifaRec = P01WR3_A1349ConveTarifaRec[0] ;
         A1391ConveHsMaxDia = P01WR3_A1391ConveHsMaxDia[0] ;
         A1392ConveHsMaxSem = P01WR3_A1392ConveHsMaxSem[0] ;
         A1393ConveHsMaxMes = P01WR3_A1393ConveHsMaxMes[0] ;
         A1394ConveHsMaxAnu = P01WR3_A1394ConveHsMaxAnu[0] ;
         AV51GXLvl88 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, "5") ;
         if ( ! (0==AV18CliRelSec) )
         {
            GXv_dtime1[0] = AV41hijoReleaseDateTime ;
            new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A2063ConveHsRelSec, GXv_dtime1) ;
            updateconveniotiposdetrabajo.this.AV41hijoReleaseDateTime = GXv_dtime1[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, "6") ;
            if ( AV45padreReleaseDateTime.after( AV41hijoReleaseDateTime ) )
            {
               A1323ConveHsDia = AV19ConveHsDia ;
               A1324ConveHsSem = AV24ConveHsSem ;
               A1325ConveTarifaXLim = AV37ConveTarifaXLim ;
               A1349ConveTarifaRec = AV36ConveTarifaRec ;
               A1391ConveHsMaxDia = AV21ConveHsMaxDia ;
               A1392ConveHsMaxSem = AV23ConveHsMaxSem ;
               A1393ConveHsMaxMes = AV22ConveHsMaxMes ;
               A1394ConveHsMaxAnu = AV20ConveHsMaxAnu ;
               A2063ConveHsRelSec = AV18CliRelSec ;
            }
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P01WR4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A2063ConveHsRelSec), A1323ConveHsDia, A1324ConveHsSem, A1325ConveTarifaXLim, A1349ConveTarifaRec, A1391ConveHsMaxDia, A1392ConveHsMaxSem, A1393ConveHsMaxMes, A1394ConveHsMaxAnu, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1294PaiTipoTraId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_tiposdetrabajo");
         if (true) break;
         /* Using cursor P01WR5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A2063ConveHsRelSec), A1323ConveHsDia, A1324ConveHsSem, A1325ConveTarifaXLim, A1349ConveTarifaRec, A1391ConveHsMaxDia, A1392ConveHsMaxSem, A1393ConveHsMaxMes, A1394ConveHsMaxAnu, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1294PaiTipoTraId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_tiposdetrabajo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      if ( AV51GXLvl88 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "new &liberacionPendiente ", "")+GXutil.trim( GXutil.booltostr( AV44liberacionPendiente))) ;
         new web.new_conveniotiposdetrabajo(remoteHandle, context).execute( AV11CliCod, AV15CliPaiConve, AV12CliConvenio, AV8PaiTipoTraId, AV19ConveHsDia, AV24ConveHsSem, AV37ConveTarifaXLim, AV36ConveTarifaRec, AV21ConveHsMaxDia, AV23ConveHsMaxSem, AV22ConveHsMaxMes, AV20ConveHsMaxAnu, (short)(AV18CliRelSec)) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateconveniotiposdetrabajo");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV45padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV49Pgmname = "" ;
      scmdbuf = "" ;
      P01WR2_A2063ConveHsRelSec = new int[1] ;
      P01WR2_A3CliCod = new int[1] ;
      P01WR2_A1564CliPaiConve = new short[1] ;
      P01WR2_A1565CliConvenio = new String[] {""} ;
      P01WR2_A1294PaiTipoTraId = new String[] {""} ;
      P01WR2_A1323ConveHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR2_A1324ConveHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR2_A1325ConveTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR2_A1349ConveTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR2_A1391ConveHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR2_A1392ConveHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR2_A1393ConveHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR2_A1394ConveHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR2_A2065ConveHsOld = new String[] {""} ;
      A1565CliConvenio = "" ;
      A1294PaiTipoTraId = "" ;
      A1323ConveHsDia = DecimalUtil.ZERO ;
      A1324ConveHsSem = DecimalUtil.ZERO ;
      A1325ConveTarifaXLim = DecimalUtil.ZERO ;
      A1349ConveTarifaRec = DecimalUtil.ZERO ;
      A1391ConveHsMaxDia = DecimalUtil.ZERO ;
      A1392ConveHsMaxSem = DecimalUtil.ZERO ;
      A1393ConveHsMaxMes = DecimalUtil.ZERO ;
      A1394ConveHsMaxAnu = DecimalUtil.ZERO ;
      A2065ConveHsOld = "" ;
      AV17CliRelease = GXutil.resetTime( GXutil.nullDate() );
      GXv_boolean2 = new boolean[1] ;
      AV12CliConvenio = "" ;
      AV8PaiTipoTraId = "" ;
      AV19ConveHsDia = DecimalUtil.ZERO ;
      AV24ConveHsSem = DecimalUtil.ZERO ;
      AV37ConveTarifaXLim = DecimalUtil.ZERO ;
      AV36ConveTarifaRec = DecimalUtil.ZERO ;
      AV21ConveHsMaxDia = DecimalUtil.ZERO ;
      AV23ConveHsMaxSem = DecimalUtil.ZERO ;
      AV22ConveHsMaxMes = DecimalUtil.ZERO ;
      AV20ConveHsMaxAnu = DecimalUtil.ZERO ;
      AV35convenio_tiposdetrabajo_old = new web.Sdtconvenio_tiposdetrabajo_old(remoteHandle, context);
      P01WR3_A1294PaiTipoTraId = new String[] {""} ;
      P01WR3_A1565CliConvenio = new String[] {""} ;
      P01WR3_A1564CliPaiConve = new short[1] ;
      P01WR3_A3CliCod = new int[1] ;
      P01WR3_A2063ConveHsRelSec = new int[1] ;
      P01WR3_A1323ConveHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR3_A1324ConveHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR3_A1325ConveTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR3_A1349ConveTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR3_A1391ConveHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR3_A1392ConveHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR3_A1393ConveHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WR3_A1394ConveHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV41hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateconveniotiposdetrabajo__default(),
         new Object[] {
             new Object[] {
            P01WR2_A2063ConveHsRelSec, P01WR2_A3CliCod, P01WR2_A1564CliPaiConve, P01WR2_A1565CliConvenio, P01WR2_A1294PaiTipoTraId, P01WR2_A1323ConveHsDia, P01WR2_A1324ConveHsSem, P01WR2_A1325ConveTarifaXLim, P01WR2_A1349ConveTarifaRec, P01WR2_A1391ConveHsMaxDia,
            P01WR2_A1392ConveHsMaxSem, P01WR2_A1393ConveHsMaxMes, P01WR2_A1394ConveHsMaxAnu, P01WR2_A2065ConveHsOld
            }
            , new Object[] {
            P01WR3_A1294PaiTipoTraId, P01WR3_A1565CliConvenio, P01WR3_A1564CliPaiConve, P01WR3_A3CliCod, P01WR3_A2063ConveHsRelSec, P01WR3_A1323ConveHsDia, P01WR3_A1324ConveHsSem, P01WR3_A1325ConveTarifaXLim, P01WR3_A1349ConveTarifaRec, P01WR3_A1391ConveHsMaxDia,
            P01WR3_A1392ConveHsMaxSem, P01WR3_A1393ConveHsMaxMes, P01WR3_A1394ConveHsMaxAnu
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV49Pgmname = "updateConvenioTiposDeTrabajo" ;
      /* GeneXus formulas. */
      AV49Pgmname = "updateConvenioTiposDeTrabajo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV50GXLvl4 ;
   private byte AV51GXLvl88 ;
   private short A1564CliPaiConve ;
   private short AV15CliPaiConve ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV18CliRelSec ;
   private int A2063ConveHsRelSec ;
   private int A3CliCod ;
   private long AV13ClientePadre ;
   private java.math.BigDecimal A1323ConveHsDia ;
   private java.math.BigDecimal A1324ConveHsSem ;
   private java.math.BigDecimal A1325ConveTarifaXLim ;
   private java.math.BigDecimal A1349ConveTarifaRec ;
   private java.math.BigDecimal A1391ConveHsMaxDia ;
   private java.math.BigDecimal A1392ConveHsMaxSem ;
   private java.math.BigDecimal A1393ConveHsMaxMes ;
   private java.math.BigDecimal A1394ConveHsMaxAnu ;
   private java.math.BigDecimal AV19ConveHsDia ;
   private java.math.BigDecimal AV24ConveHsSem ;
   private java.math.BigDecimal AV37ConveTarifaXLim ;
   private java.math.BigDecimal AV36ConveTarifaRec ;
   private java.math.BigDecimal AV21ConveHsMaxDia ;
   private java.math.BigDecimal AV23ConveHsMaxSem ;
   private java.math.BigDecimal AV22ConveHsMaxMes ;
   private java.math.BigDecimal AV20ConveHsMaxAnu ;
   private String AV49Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A1294PaiTipoTraId ;
   private String AV12CliConvenio ;
   private String AV8PaiTipoTraId ;
   private java.util.Date AV45padreReleaseDateTime ;
   private java.util.Date AV17CliRelease ;
   private java.util.Date AV41hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private boolean AV46clienteConvenioTiene ;
   private boolean AV43importar ;
   private boolean AV44liberacionPendiente ;
   private boolean AV16CliReHabilitado ;
   private boolean AV9alguienYaActualizo ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String A2065ConveHsOld ;
   private IDataStoreProvider pr_default ;
   private int[] P01WR2_A2063ConveHsRelSec ;
   private int[] P01WR2_A3CliCod ;
   private short[] P01WR2_A1564CliPaiConve ;
   private String[] P01WR2_A1565CliConvenio ;
   private String[] P01WR2_A1294PaiTipoTraId ;
   private java.math.BigDecimal[] P01WR2_A1323ConveHsDia ;
   private java.math.BigDecimal[] P01WR2_A1324ConveHsSem ;
   private java.math.BigDecimal[] P01WR2_A1325ConveTarifaXLim ;
   private java.math.BigDecimal[] P01WR2_A1349ConveTarifaRec ;
   private java.math.BigDecimal[] P01WR2_A1391ConveHsMaxDia ;
   private java.math.BigDecimal[] P01WR2_A1392ConveHsMaxSem ;
   private java.math.BigDecimal[] P01WR2_A1393ConveHsMaxMes ;
   private java.math.BigDecimal[] P01WR2_A1394ConveHsMaxAnu ;
   private String[] P01WR2_A2065ConveHsOld ;
   private String[] P01WR3_A1294PaiTipoTraId ;
   private String[] P01WR3_A1565CliConvenio ;
   private short[] P01WR3_A1564CliPaiConve ;
   private int[] P01WR3_A3CliCod ;
   private int[] P01WR3_A2063ConveHsRelSec ;
   private java.math.BigDecimal[] P01WR3_A1323ConveHsDia ;
   private java.math.BigDecimal[] P01WR3_A1324ConveHsSem ;
   private java.math.BigDecimal[] P01WR3_A1325ConveTarifaXLim ;
   private java.math.BigDecimal[] P01WR3_A1349ConveTarifaRec ;
   private java.math.BigDecimal[] P01WR3_A1391ConveHsMaxDia ;
   private java.math.BigDecimal[] P01WR3_A1392ConveHsMaxSem ;
   private java.math.BigDecimal[] P01WR3_A1393ConveHsMaxMes ;
   private java.math.BigDecimal[] P01WR3_A1394ConveHsMaxAnu ;
   private web.Sdtconvenio_tiposdetrabajo_old AV35convenio_tiposdetrabajo_old ;
}

final  class updateconveniotiposdetrabajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01WR2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV18CliRelSec ,
                                          int A2063ConveHsRelSec ,
                                          long AV13ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT ConveHsRelSec, CliCod, CliPaiConve, CliConvenio, PaiTipoTraId, ConveHsDia, ConveHsSem, ConveTarifaXLim, ConveTarifaRec, ConveHsMaxDia, ConveHsMaxSem, ConveHsMaxMes," ;
      scmdbuf += " ConveHsMaxAnu, ConveHsOld FROM convenio_tiposdetrabajo" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV18CliRelSec) )
      {
         addWhere(sWhereString, "(ConveHsRelSec = ?)");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01WR2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01WR2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01WR3", "SELECT PaiTipoTraId, CliConvenio, CliPaiConve, CliCod, ConveHsRelSec, ConveHsDia, ConveHsSem, ConveTarifaXLim, ConveTarifaRec, ConveHsMaxDia, ConveHsMaxSem, ConveHsMaxMes, ConveHsMaxAnu FROM convenio_tiposdetrabajo WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and PaiTipoTraId = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, PaiTipoTraId  LIMIT 1 FOR UPDATE OF convenio_tiposdetrabajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01WR4", "SAVEPOINT gxupdate;UPDATE convenio_tiposdetrabajo SET ConveHsRelSec=?, ConveHsDia=?, ConveHsSem=?, ConveTarifaXLim=?, ConveTarifaRec=?, ConveHsMaxDia=?, ConveHsMaxSem=?, ConveHsMaxMes=?, ConveHsMaxAnu=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01WR5", "SAVEPOINT gxupdate;UPDATE convenio_tiposdetrabajo SET ConveHsRelSec=?, ConveHsDia=?, ConveHsSem=?, ConveTarifaXLim=?, ConveTarifaRec=?, ConveHsMaxDia=?, ConveHsMaxSem=?, ConveHsMaxMes=?, ConveHsMaxAnu=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,4);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,1);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,1);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,1);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(14);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,4);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,1);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,1);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[2]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 1);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 1);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 1);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 1);
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setString(12, (String)parms[11], 20);
               stmt.setString(13, (String)parms[12], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 1);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 1);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 1);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 1);
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setString(12, (String)parms[11], 20);
               stmt.setString(13, (String)parms[12], 20);
               return;
      }
   }

}

