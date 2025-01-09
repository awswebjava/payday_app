package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateconveniohsextpordia extends GXProcedure
{
   public updateconveniohsextpordia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateconveniohsextpordia.class ), "" );
   }

   public updateconveniohsextpordia( int remoteHandle ,
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
      updateconveniohsextpordia.this.AV12ClientePadre = aP0;
      updateconveniohsextpordia.this.AV10CliCod = aP1;
      updateconveniohsextpordia.this.AV17CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV33padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV12ClientePadre), AV17CliRelSec, GXv_dtime1) ;
      updateconveniohsextpordia.this.AV33padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "&ClientePadre ", "")+GXutil.trim( GXutil.str( AV12ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV17CliRelSec, 6, 0))) ;
      AV40GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV17CliRelSec) ,
                                           Integer.valueOf(A2066ConveHsPDiaRelSec) ,
                                           Long.valueOf(AV12ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01WS2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV12ClientePadre), Integer.valueOf(AV17CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2066ConveHsPDiaRelSec = P01WS2_A2066ConveHsPDiaRelSec[0] ;
         A3CliCod = P01WS2_A3CliCod[0] ;
         A1564CliPaiConve = P01WS2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01WS2_A1565CliConvenio[0] ;
         A1327ConveHsExSec = P01WS2_A1327ConveHsExSec[0] ;
         A1326ConvHsPDiaTipTra = P01WS2_A1326ConvHsPDiaTipTra[0] ;
         A1328ConveHsPDiaDia = P01WS2_A1328ConveHsPDiaDia[0] ;
         A1329ConveHsPDiaDesde = P01WS2_A1329ConveHsPDiaDesde[0] ;
         n1329ConveHsPDiaDesde = P01WS2_n1329ConveHsPDiaDesde[0] ;
         A1330ConveTarifaPDia = P01WS2_A1330ConveTarifaPDia[0] ;
         A1350ConveTarifaPDRec = P01WS2_A1350ConveTarifaPDRec[0] ;
         A2432ConveTarifaPDCri = P01WS2_A2432ConveTarifaPDCri[0] ;
         A2068ConveHsPDiaOld = P01WS2_A2068ConveHsPDiaOld[0] ;
         AV40GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV35clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV10CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updateconveniohsextpordia.this.AV35clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV35clienteConvenioTiene )
         {
            AV31importar = false ;
            AV32liberacionPendiente = false ;
            if ( ! (0==AV17CliRelSec) )
            {
               AV31importar = true ;
            }
            else
            {
               if ( (0==A2066ConveHsPDiaRelSec) )
               {
                  AV31importar = true ;
               }
               else
               {
                  GXv_dtime1[0] = AV16CliRelease ;
                  GXv_boolean2[0] = AV15CliReHabilitado ;
                  new web.getreleasedtyhabilitado(remoteHandle, context).execute( A3CliCod, A2066ConveHsPDiaRelSec, GXv_dtime1, GXv_boolean2) ;
                  updateconveniohsextpordia.this.AV16CliRelease = GXv_dtime1[0] ;
                  updateconveniohsextpordia.this.AV15CliReHabilitado = GXv_boolean2[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "&CliReHabilitado ", "")+GXutil.trim( GXutil.booltostr( AV15CliReHabilitado))+httpContext.getMessage( " &CliRelease ", "")+GXutil.trim( localUtil.ttoc( AV16CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
                  if ( ( AV15CliReHabilitado ) && (( AV16CliRelease.before( GXutil.serverNow( context, remoteHandle, pr_default) ) ) || ( GXutil.dateCompare(AV16CliRelease, GXutil.serverNow( context, remoteHandle, pr_default)) )) )
                  {
                     AV31importar = true ;
                  }
                  else
                  {
                     GXv_boolean2[0] = AV8alguienYaActualizo ;
                     new web.alguienyaactualizoliberacion(remoteHandle, context).execute( A3CliCod, A2066ConveHsPDiaRelSec, GXv_boolean2) ;
                     updateconveniohsextpordia.this.AV8alguienYaActualizo = GXv_boolean2[0] ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "&alguienYaActualizo ", "")+GXutil.trim( GXutil.booltostr( AV8alguienYaActualizo))) ;
                     if ( AV8alguienYaActualizo )
                     {
                        AV31importar = true ;
                     }
                     else
                     {
                        AV32liberacionPendiente = true ;
                     }
                  }
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "&importar ", "")+GXutil.trim( GXutil.booltostr( AV31importar))+httpContext.getMessage( " &liberacionpendiente ", "")+GXutil.trim( GXutil.booltostr( AV32liberacionPendiente))) ;
            if ( AV31importar )
            {
               AV14CliPaiConve = A1564CliPaiConve ;
               AV11CliConvenio = A1565CliConvenio ;
               AV18ConveHsExSec = A1327ConveHsExSec ;
               AV25ConvHsPDiaTipTra = A1326ConvHsPDiaTipTra ;
               AV20ConveHsPDiaDia = A1328ConveHsPDiaDia ;
               AV19ConveHsPDiaDesde = A1329ConveHsPDiaDesde ;
               AV22ConveTarifaPDia = A1330ConveTarifaPDia ;
               AV23ConveTarifaPDRec = A1350ConveTarifaPDRec ;
               AV36ConveTarifaPDCri = A2432ConveTarifaPDCri ;
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
               new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "vengo", "")) ;
               if ( AV32liberacionPendiente )
               {
                  if ( ! (GXutil.strcmp("", A2068ConveHsPDiaOld)==0) )
                  {
                     AV21Convenio_horasextras_porDia_old.fromJSonString(GXutil.trim( A2068ConveHsPDiaOld), null);
                     AV14CliPaiConve = A1564CliPaiConve ;
                     AV11CliConvenio = A1565CliConvenio ;
                     AV18ConveHsExSec = A1327ConveHsExSec ;
                     AV25ConvHsPDiaTipTra = AV21Convenio_horasextras_porDia_old.getgxTv_SdtConvenio_horasextras_porDia_old_Convhspdiatiptra() ;
                     AV20ConveHsPDiaDia = AV21Convenio_horasextras_porDia_old.getgxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadia() ;
                     AV19ConveHsPDiaDesde = AV21Convenio_horasextras_porDia_old.getgxTv_SdtConvenio_horasextras_porDia_old_Convehspdiadesde() ;
                     AV22ConveTarifaPDia = AV21Convenio_horasextras_porDia_old.getgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdia() ;
                     AV23ConveTarifaPDRec = AV21Convenio_horasextras_porDia_old.getgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdrec() ;
                     AV36ConveTarifaPDCri = AV21Convenio_horasextras_porDia_old.getgxTv_SdtConvenio_horasextras_porDia_old_Convetarifapdcri() ;
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
      if ( AV40GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "none1", "")) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, "4") ;
      AV41GXLvl82 = (byte)(0) ;
      /* Using cursor P01WS3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV14CliPaiConve), AV11CliConvenio, Short.valueOf(AV18ConveHsExSec)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1327ConveHsExSec = P01WS3_A1327ConveHsExSec[0] ;
         A1565CliConvenio = P01WS3_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01WS3_A1564CliPaiConve[0] ;
         A3CliCod = P01WS3_A3CliCod[0] ;
         A2066ConveHsPDiaRelSec = P01WS3_A2066ConveHsPDiaRelSec[0] ;
         A1326ConvHsPDiaTipTra = P01WS3_A1326ConvHsPDiaTipTra[0] ;
         A1328ConveHsPDiaDia = P01WS3_A1328ConveHsPDiaDia[0] ;
         A1329ConveHsPDiaDesde = P01WS3_A1329ConveHsPDiaDesde[0] ;
         n1329ConveHsPDiaDesde = P01WS3_n1329ConveHsPDiaDesde[0] ;
         A1330ConveTarifaPDia = P01WS3_A1330ConveTarifaPDia[0] ;
         A1350ConveTarifaPDRec = P01WS3_A1350ConveTarifaPDRec[0] ;
         A2432ConveTarifaPDCri = P01WS3_A2432ConveTarifaPDCri[0] ;
         AV41GXLvl82 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, "5") ;
         if ( ! (0==AV17CliRelSec) )
         {
            GXv_dtime1[0] = AV29hijoReleaseDateTime ;
            new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A2066ConveHsPDiaRelSec, GXv_dtime1) ;
            updateconveniohsextpordia.this.AV29hijoReleaseDateTime = GXv_dtime1[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, "6") ;
            if ( AV33padreReleaseDateTime.after( AV29hijoReleaseDateTime ) )
            {
               A1326ConvHsPDiaTipTra = AV25ConvHsPDiaTipTra ;
               A1328ConveHsPDiaDia = AV20ConveHsPDiaDia ;
               A1329ConveHsPDiaDesde = AV19ConveHsPDiaDesde ;
               n1329ConveHsPDiaDesde = false ;
               A1330ConveTarifaPDia = AV22ConveTarifaPDia ;
               A1350ConveTarifaPDRec = AV23ConveTarifaPDRec ;
               A2432ConveTarifaPDCri = AV36ConveTarifaPDCri ;
               A2066ConveHsPDiaRelSec = AV34ConveHsPDiaRelSec ;
            }
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P01WS4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A2066ConveHsPDiaRelSec), A1326ConvHsPDiaTipTra, Byte.valueOf(A1328ConveHsPDiaDia), Boolean.valueOf(n1329ConveHsPDiaDesde), A1329ConveHsPDiaDesde, A1330ConveTarifaPDia, A1350ConveTarifaPDRec, A2432ConveTarifaPDCri, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Short.valueOf(A1327ConveHsExSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio_horasextras_porDia");
         if (true) break;
         /* Using cursor P01WS5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A2066ConveHsPDiaRelSec), A1326ConvHsPDiaTipTra, Byte.valueOf(A1328ConveHsPDiaDia), Boolean.valueOf(n1329ConveHsPDiaDesde), A1329ConveHsPDiaDesde, A1330ConveTarifaPDia, A1350ConveTarifaPDRec, A2432ConveTarifaPDCri, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Short.valueOf(A1327ConveHsExSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio_horasextras_porDia");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      if ( AV41GXLvl82 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "new &liberacionPendiente ", "")+GXutil.trim( GXutil.booltostr( AV32liberacionPendiente))) ;
         new web.newconveniohsextpordia(remoteHandle, context).execute( AV10CliCod, AV14CliPaiConve, AV11CliConvenio, AV18ConveHsExSec, AV25ConvHsPDiaTipTra, AV20ConveHsPDiaDia, AV19ConveHsPDiaDesde, AV22ConveTarifaPDia, AV23ConveTarifaPDRec, AV36ConveTarifaPDCri, AV17CliRelSec) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateconveniohsextpordia");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV33padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV39Pgmname = "" ;
      scmdbuf = "" ;
      P01WS2_A2066ConveHsPDiaRelSec = new int[1] ;
      P01WS2_A3CliCod = new int[1] ;
      P01WS2_A1564CliPaiConve = new short[1] ;
      P01WS2_A1565CliConvenio = new String[] {""} ;
      P01WS2_A1327ConveHsExSec = new short[1] ;
      P01WS2_A1326ConvHsPDiaTipTra = new String[] {""} ;
      P01WS2_A1328ConveHsPDiaDia = new byte[1] ;
      P01WS2_A1329ConveHsPDiaDesde = new String[] {""} ;
      P01WS2_n1329ConveHsPDiaDesde = new boolean[] {false} ;
      P01WS2_A1330ConveTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WS2_A1350ConveTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WS2_A2432ConveTarifaPDCri = new String[] {""} ;
      P01WS2_A2068ConveHsPDiaOld = new String[] {""} ;
      A1565CliConvenio = "" ;
      A1326ConvHsPDiaTipTra = "" ;
      A1329ConveHsPDiaDesde = "" ;
      A1330ConveTarifaPDia = DecimalUtil.ZERO ;
      A1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      A2432ConveTarifaPDCri = "" ;
      A2068ConveHsPDiaOld = "" ;
      AV16CliRelease = GXutil.resetTime( GXutil.nullDate() );
      GXv_boolean2 = new boolean[1] ;
      AV11CliConvenio = "" ;
      AV25ConvHsPDiaTipTra = "" ;
      AV19ConveHsPDiaDesde = "" ;
      AV22ConveTarifaPDia = DecimalUtil.ZERO ;
      AV23ConveTarifaPDRec = DecimalUtil.ZERO ;
      AV36ConveTarifaPDCri = "" ;
      AV21Convenio_horasextras_porDia_old = new web.SdtConvenio_horasextras_porDia_old(remoteHandle, context);
      P01WS3_A1327ConveHsExSec = new short[1] ;
      P01WS3_A1565CliConvenio = new String[] {""} ;
      P01WS3_A1564CliPaiConve = new short[1] ;
      P01WS3_A3CliCod = new int[1] ;
      P01WS3_A2066ConveHsPDiaRelSec = new int[1] ;
      P01WS3_A1326ConvHsPDiaTipTra = new String[] {""} ;
      P01WS3_A1328ConveHsPDiaDia = new byte[1] ;
      P01WS3_A1329ConveHsPDiaDesde = new String[] {""} ;
      P01WS3_n1329ConveHsPDiaDesde = new boolean[] {false} ;
      P01WS3_A1330ConveTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WS3_A1350ConveTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01WS3_A2432ConveTarifaPDCri = new String[] {""} ;
      AV29hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateconveniohsextpordia__default(),
         new Object[] {
             new Object[] {
            P01WS2_A2066ConveHsPDiaRelSec, P01WS2_A3CliCod, P01WS2_A1564CliPaiConve, P01WS2_A1565CliConvenio, P01WS2_A1327ConveHsExSec, P01WS2_A1326ConvHsPDiaTipTra, P01WS2_A1328ConveHsPDiaDia, P01WS2_A1329ConveHsPDiaDesde, P01WS2_n1329ConveHsPDiaDesde, P01WS2_A1330ConveTarifaPDia,
            P01WS2_A1350ConveTarifaPDRec, P01WS2_A2432ConveTarifaPDCri, P01WS2_A2068ConveHsPDiaOld
            }
            , new Object[] {
            P01WS3_A1327ConveHsExSec, P01WS3_A1565CliConvenio, P01WS3_A1564CliPaiConve, P01WS3_A3CliCod, P01WS3_A2066ConveHsPDiaRelSec, P01WS3_A1326ConvHsPDiaTipTra, P01WS3_A1328ConveHsPDiaDia, P01WS3_A1329ConveHsPDiaDesde, P01WS3_n1329ConveHsPDiaDesde, P01WS3_A1330ConveTarifaPDia,
            P01WS3_A1350ConveTarifaPDRec, P01WS3_A2432ConveTarifaPDCri
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV39Pgmname = "updateConvenioHsExtPorDia" ;
      /* GeneXus formulas. */
      AV39Pgmname = "updateConvenioHsExtPorDia" ;
      Gx_err = (short)(0) ;
   }

   private byte AV40GXLvl4 ;
   private byte A1328ConveHsPDiaDia ;
   private byte AV20ConveHsPDiaDia ;
   private byte AV41GXLvl82 ;
   private short A1564CliPaiConve ;
   private short A1327ConveHsExSec ;
   private short AV14CliPaiConve ;
   private short AV18ConveHsExSec ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV17CliRelSec ;
   private int A2066ConveHsPDiaRelSec ;
   private int A3CliCod ;
   private int AV34ConveHsPDiaRelSec ;
   private long AV12ClientePadre ;
   private java.math.BigDecimal A1330ConveTarifaPDia ;
   private java.math.BigDecimal A1350ConveTarifaPDRec ;
   private java.math.BigDecimal AV22ConveTarifaPDia ;
   private java.math.BigDecimal AV23ConveTarifaPDRec ;
   private String AV39Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A1326ConvHsPDiaTipTra ;
   private String A1329ConveHsPDiaDesde ;
   private String A2432ConveTarifaPDCri ;
   private String AV11CliConvenio ;
   private String AV25ConvHsPDiaTipTra ;
   private String AV19ConveHsPDiaDesde ;
   private String AV36ConveTarifaPDCri ;
   private java.util.Date AV33padreReleaseDateTime ;
   private java.util.Date AV16CliRelease ;
   private java.util.Date AV29hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private boolean n1329ConveHsPDiaDesde ;
   private boolean AV35clienteConvenioTiene ;
   private boolean AV31importar ;
   private boolean AV32liberacionPendiente ;
   private boolean AV15CliReHabilitado ;
   private boolean AV8alguienYaActualizo ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String A2068ConveHsPDiaOld ;
   private IDataStoreProvider pr_default ;
   private int[] P01WS2_A2066ConveHsPDiaRelSec ;
   private int[] P01WS2_A3CliCod ;
   private short[] P01WS2_A1564CliPaiConve ;
   private String[] P01WS2_A1565CliConvenio ;
   private short[] P01WS2_A1327ConveHsExSec ;
   private String[] P01WS2_A1326ConvHsPDiaTipTra ;
   private byte[] P01WS2_A1328ConveHsPDiaDia ;
   private String[] P01WS2_A1329ConveHsPDiaDesde ;
   private boolean[] P01WS2_n1329ConveHsPDiaDesde ;
   private java.math.BigDecimal[] P01WS2_A1330ConveTarifaPDia ;
   private java.math.BigDecimal[] P01WS2_A1350ConveTarifaPDRec ;
   private String[] P01WS2_A2432ConveTarifaPDCri ;
   private String[] P01WS2_A2068ConveHsPDiaOld ;
   private short[] P01WS3_A1327ConveHsExSec ;
   private String[] P01WS3_A1565CliConvenio ;
   private short[] P01WS3_A1564CliPaiConve ;
   private int[] P01WS3_A3CliCod ;
   private int[] P01WS3_A2066ConveHsPDiaRelSec ;
   private String[] P01WS3_A1326ConvHsPDiaTipTra ;
   private byte[] P01WS3_A1328ConveHsPDiaDia ;
   private String[] P01WS3_A1329ConveHsPDiaDesde ;
   private boolean[] P01WS3_n1329ConveHsPDiaDesde ;
   private java.math.BigDecimal[] P01WS3_A1330ConveTarifaPDia ;
   private java.math.BigDecimal[] P01WS3_A1350ConveTarifaPDRec ;
   private String[] P01WS3_A2432ConveTarifaPDCri ;
   private web.SdtConvenio_horasextras_porDia_old AV21Convenio_horasextras_porDia_old ;
}

final  class updateconveniohsextpordia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01WS2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV17CliRelSec ,
                                          int A2066ConveHsPDiaRelSec ,
                                          long AV12ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT ConveHsPDiaRelSec, CliCod, CliPaiConve, CliConvenio, ConveHsExSec, ConvHsPDiaTipTra, ConveHsPDiaDia, ConveHsPDiaDesde, ConveTarifaPDia, ConveTarifaPDRec," ;
      scmdbuf += " ConveTarifaPDCri, ConveHsPDiaOld FROM Convenio_horasextras_porDia" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV17CliRelSec) )
      {
         addWhere(sWhereString, "(ConveHsPDiaRelSec = ?)");
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
                  return conditional_P01WS2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01WS2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01WS3", "SELECT ConveHsExSec, CliConvenio, CliPaiConve, CliCod, ConveHsPDiaRelSec, ConvHsPDiaTipTra, ConveHsPDiaDia, ConveHsPDiaDesde, ConveTarifaPDia, ConveTarifaPDRec, ConveTarifaPDCri FROM Convenio_horasextras_porDia WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveHsExSec = ? ORDER BY CliCod, CliPaiConve, CliConvenio, ConveHsExSec  LIMIT 1 FOR UPDATE OF Convenio_horasextras_porDia",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01WS4", "SAVEPOINT gxupdate;UPDATE Convenio_horasextras_porDia SET ConveHsPDiaRelSec=?, ConvHsPDiaTipTra=?, ConveHsPDiaDia=?, ConveHsPDiaDesde=?, ConveTarifaPDia=?, ConveTarifaPDRec=?, ConveTarifaPDCri=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01WS5", "SAVEPOINT gxupdate;UPDATE Convenio_horasextras_porDia SET ConveHsPDiaRelSec=?, ConvHsPDiaTipTra=?, ConveHsPDiaDia=?, ConveHsPDiaDesde=?, ConveTarifaPDia=?, ConveTarifaPDRec=?, ConveTarifaPDCri=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,4);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,4);
               ((String[]) buf[11])[0] = rslt.getString(11, 20);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(12);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,4);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,4);
               ((String[]) buf[11])[0] = rslt.getString(11, 20);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[4], 5);
               }
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 4);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 4);
               stmt.setString(7, (String)parms[7], 20);
               stmt.setInt(8, ((Number) parms[8]).intValue());
               stmt.setShort(9, ((Number) parms[9]).shortValue());
               stmt.setString(10, (String)parms[10], 20);
               stmt.setShort(11, ((Number) parms[11]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[4], 5);
               }
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 4);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 4);
               stmt.setString(7, (String)parms[7], 20);
               stmt.setInt(8, ((Number) parms[8]).intValue());
               stmt.setShort(9, ((Number) parms[9]).shortValue());
               stmt.setString(10, (String)parms[10], 20);
               stmt.setShort(11, ((Number) parms[11]).shortValue());
               return;
      }
   }

}

