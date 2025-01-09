package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateobrassociales extends GXProcedure
{
   public updateobrassociales( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateobrassociales.class ), "" );
   }

   public updateobrassociales( int remoteHandle ,
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
      updateobrassociales.this.AV10ClientePadre = aP0;
      updateobrassociales.this.AV9CliCod = aP1;
      updateobrassociales.this.AV12CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV26padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV10ClientePadre), AV12CliRelSec, GXv_dtime1) ;
      updateobrassociales.this.AV26padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&ClientePadre ", "")+GXutil.trim( GXutil.str( AV10ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV12CliRelSec, 6, 0))) ;
      AV31GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV12CliRelSec) ,
                                           Integer.valueOf(A1981OsoRelSec) ,
                                           Integer.valueOf(A1982OsoRelSecCli) ,
                                           Long.valueOf(AV10ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01X62 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV10ClientePadre), Long.valueOf(AV10ClientePadre), Integer.valueOf(AV12CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1981OsoRelSec = P01X62_A1981OsoRelSec[0] ;
         A1982OsoRelSecCli = P01X62_A1982OsoRelSecCli[0] ;
         A3CliCod = P01X62_A3CliCod[0] ;
         A5OsoCod = P01X62_A5OsoCod[0] ;
         A307OsoDescrip = P01X62_A307OsoDescrip[0] ;
         A392OsoSigla = P01X62_A392OsoSigla[0] ;
         A308OsoHabilitada = P01X62_A308OsoHabilitada[0] ;
         A306OsoC3992 = P01X62_A306OsoC3992[0] ;
         n306OsoC3992 = P01X62_n306OsoC3992[0] ;
         A555OsoSiglaYDesc = P01X62_A555OsoSiglaYDesc[0] ;
         A681OsoDescripSinAc = P01X62_A681OsoDescripSinAc[0] ;
         A893OsoAporteAdic = P01X62_A893OsoAporteAdic[0] ;
         A2160OsoActCom = P01X62_A2160OsoActCom[0] ;
         n2160OsoActCom = P01X62_n2160OsoActCom[0] ;
         AV31GXLvl4 = (byte)(1) ;
         AV20OsoCod = A5OsoCod ;
         AV21OsoDescrip = A307OsoDescrip ;
         AV24OsoSigla = A392OsoSigla ;
         AV23OsoHabilitada = A308OsoHabilitada ;
         AV19OsoC3992 = A306OsoC3992 ;
         AV25OsoSiglaYDesc = A555OsoSiglaYDesc ;
         AV22OsoDescripSinAc = A681OsoDescripSinAc ;
         AV18OsoAporteAdic = A893OsoAporteAdic ;
         AV27OsoActCom = A2160OsoActCom ;
         /* Execute user subroutine: 'HIJO' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV31GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "none1", "")) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, "4") ;
      AV32GXLvl28 = (byte)(0) ;
      /* Using cursor P01X63 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod), AV20OsoCod});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1983OsoPadre = P01X63_A1983OsoPadre[0] ;
         A3CliCod = P01X63_A3CliCod[0] ;
         A1981OsoRelSec = P01X63_A1981OsoRelSec[0] ;
         A307OsoDescrip = P01X63_A307OsoDescrip[0] ;
         A392OsoSigla = P01X63_A392OsoSigla[0] ;
         A308OsoHabilitada = P01X63_A308OsoHabilitada[0] ;
         A306OsoC3992 = P01X63_A306OsoC3992[0] ;
         n306OsoC3992 = P01X63_n306OsoC3992[0] ;
         A555OsoSiglaYDesc = P01X63_A555OsoSiglaYDesc[0] ;
         A681OsoDescripSinAc = P01X63_A681OsoDescripSinAc[0] ;
         A893OsoAporteAdic = P01X63_A893OsoAporteAdic[0] ;
         A2160OsoActCom = P01X63_A2160OsoActCom[0] ;
         n2160OsoActCom = P01X63_n2160OsoActCom[0] ;
         A1982OsoRelSecCli = P01X63_A1982OsoRelSecCli[0] ;
         A5OsoCod = P01X63_A5OsoCod[0] ;
         AV32GXLvl28 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, "5") ;
         if ( ! (0==AV12CliRelSec) )
         {
            GXv_dtime1[0] = AV15hijoReleaseDateTime ;
            new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1981OsoRelSec, GXv_dtime1) ;
            updateobrassociales.this.AV15hijoReleaseDateTime = GXv_dtime1[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, "6") ;
            if ( AV26padreReleaseDateTime.after( AV15hijoReleaseDateTime ) )
            {
               A307OsoDescrip = AV21OsoDescrip ;
               A392OsoSigla = AV24OsoSigla ;
               A308OsoHabilitada = AV23OsoHabilitada ;
               A306OsoC3992 = AV19OsoC3992 ;
               n306OsoC3992 = false ;
               A555OsoSiglaYDesc = AV25OsoSiglaYDesc ;
               A681OsoDescripSinAc = AV22OsoDescripSinAc ;
               A893OsoAporteAdic = AV18OsoAporteAdic ;
               if ( ! (GXutil.strcmp("", AV27OsoActCom)==0) )
               {
                  A2160OsoActCom = AV27OsoActCom ;
                  n2160OsoActCom = false ;
               }
               else
               {
                  A2160OsoActCom = "" ;
                  n2160OsoActCom = false ;
                  n2160OsoActCom = true ;
               }
               A1981OsoRelSec = AV12CliRelSec ;
               A1982OsoRelSecCli = (int)(AV10ClientePadre) ;
            }
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P01X64 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A1981OsoRelSec), A307OsoDescrip, A392OsoSigla, Boolean.valueOf(A308OsoHabilitada), Boolean.valueOf(n306OsoC3992), A306OsoC3992, A555OsoSiglaYDesc, A681OsoDescripSinAc, A893OsoAporteAdic, Boolean.valueOf(n2160OsoActCom), A2160OsoActCom, Integer.valueOf(A1982OsoRelSecCli), Integer.valueOf(A3CliCod), A5OsoCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ObraSocial");
         if (true) break;
         /* Using cursor P01X65 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A1981OsoRelSec), A307OsoDescrip, A392OsoSigla, Boolean.valueOf(A308OsoHabilitada), Boolean.valueOf(n306OsoC3992), A306OsoC3992, A555OsoSiglaYDesc, A681OsoDescripSinAc, A893OsoAporteAdic, Boolean.valueOf(n2160OsoActCom), A2160OsoActCom, Integer.valueOf(A1982OsoRelSecCli), Integer.valueOf(A3CliCod), A5OsoCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ObraSocial");
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV32GXLvl28 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "new", "")) ;
         /* Execute user subroutine: 'GET NUEVO ID' */
         S121 ();
         if (returnInSub) return;
         new web.newobrasocial(remoteHandle, context).execute( AV9CliCod, AV19OsoC3992, AV21OsoDescrip, AV24OsoSigla, AV23OsoHabilitada, AV19OsoC3992, AV25OsoSiglaYDesc, AV18OsoAporteAdic, AV27OsoActCom) ;
      }
   }

   public void S121( )
   {
      /* 'GET NUEVO ID' Routine */
      returnInSub = false ;
      AV8auxOsoCod = AV20OsoCod ;
      AV16i = (short)(1) ;
      while ( true )
      {
         gxexitloop = false ;
         if ( gxexitloop )
         {
            break;
         }
         AV33GXLvl68 = (byte)(0) ;
         /* Using cursor P01X66 */
         pr_default.execute(4, new Object[] {Integer.valueOf(AV9CliCod), AV8auxOsoCod});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A5OsoCod = P01X66_A5OsoCod[0] ;
            A3CliCod = P01X66_A3CliCod[0] ;
            AV33GXLvl68 = (byte)(1) ;
            AV16i = (short)(AV16i+2) ;
            AV8auxOsoCod = GXutil.trim( AV20OsoCod) + "_" + GXutil.trim( GXutil.str( AV16i, 4, 0)) ;
            if ( GXutil.len( GXutil.trim( AV8auxOsoCod)) > 20 )
            {
               GXt_char2 = AV8auxOsoCod ;
               GXv_char3[0] = GXt_char2 ;
               new web.codigoaleatorio(remoteHandle, context).execute( (short)(20), GXv_char3) ;
               updateobrassociales.this.GXt_char2 = GXv_char3[0] ;
               AV8auxOsoCod = GXt_char2 ;
            }
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(4);
         if ( AV33GXLvl68 == 0 )
         {
            AV17nuevoOsoCod = AV8auxOsoCod ;
         }
         if ( ! (GXutil.strcmp("", AV17nuevoOsoCod)==0) )
         {
            if (true) break;
         }
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateobrassociales");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV30Pgmname = "" ;
      scmdbuf = "" ;
      P01X62_A1981OsoRelSec = new int[1] ;
      P01X62_A1982OsoRelSecCli = new int[1] ;
      P01X62_A3CliCod = new int[1] ;
      P01X62_A5OsoCod = new String[] {""} ;
      P01X62_A307OsoDescrip = new String[] {""} ;
      P01X62_A392OsoSigla = new String[] {""} ;
      P01X62_A308OsoHabilitada = new boolean[] {false} ;
      P01X62_A306OsoC3992 = new String[] {""} ;
      P01X62_n306OsoC3992 = new boolean[] {false} ;
      P01X62_A555OsoSiglaYDesc = new String[] {""} ;
      P01X62_A681OsoDescripSinAc = new String[] {""} ;
      P01X62_A893OsoAporteAdic = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01X62_A2160OsoActCom = new String[] {""} ;
      P01X62_n2160OsoActCom = new boolean[] {false} ;
      A5OsoCod = "" ;
      A307OsoDescrip = "" ;
      A392OsoSigla = "" ;
      A306OsoC3992 = "" ;
      A555OsoSiglaYDesc = "" ;
      A681OsoDescripSinAc = "" ;
      A893OsoAporteAdic = DecimalUtil.ZERO ;
      A2160OsoActCom = "" ;
      AV20OsoCod = "" ;
      AV21OsoDescrip = "" ;
      AV24OsoSigla = "" ;
      AV19OsoC3992 = "" ;
      AV25OsoSiglaYDesc = "" ;
      AV22OsoDescripSinAc = "" ;
      AV18OsoAporteAdic = DecimalUtil.ZERO ;
      AV27OsoActCom = "" ;
      P01X63_A1983OsoPadre = new String[] {""} ;
      P01X63_A3CliCod = new int[1] ;
      P01X63_A1981OsoRelSec = new int[1] ;
      P01X63_A307OsoDescrip = new String[] {""} ;
      P01X63_A392OsoSigla = new String[] {""} ;
      P01X63_A308OsoHabilitada = new boolean[] {false} ;
      P01X63_A306OsoC3992 = new String[] {""} ;
      P01X63_n306OsoC3992 = new boolean[] {false} ;
      P01X63_A555OsoSiglaYDesc = new String[] {""} ;
      P01X63_A681OsoDescripSinAc = new String[] {""} ;
      P01X63_A893OsoAporteAdic = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01X63_A2160OsoActCom = new String[] {""} ;
      P01X63_n2160OsoActCom = new boolean[] {false} ;
      P01X63_A1982OsoRelSecCli = new int[1] ;
      P01X63_A5OsoCod = new String[] {""} ;
      A1983OsoPadre = "" ;
      AV15hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      AV8auxOsoCod = "" ;
      P01X66_A5OsoCod = new String[] {""} ;
      P01X66_A3CliCod = new int[1] ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      AV17nuevoOsoCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateobrassociales__default(),
         new Object[] {
             new Object[] {
            P01X62_A1981OsoRelSec, P01X62_A1982OsoRelSecCli, P01X62_A3CliCod, P01X62_A5OsoCod, P01X62_A307OsoDescrip, P01X62_A392OsoSigla, P01X62_A308OsoHabilitada, P01X62_A306OsoC3992, P01X62_n306OsoC3992, P01X62_A555OsoSiglaYDesc,
            P01X62_A681OsoDescripSinAc, P01X62_A893OsoAporteAdic, P01X62_A2160OsoActCom, P01X62_n2160OsoActCom
            }
            , new Object[] {
            P01X63_A1983OsoPadre, P01X63_A3CliCod, P01X63_A1981OsoRelSec, P01X63_A307OsoDescrip, P01X63_A392OsoSigla, P01X63_A308OsoHabilitada, P01X63_A306OsoC3992, P01X63_n306OsoC3992, P01X63_A555OsoSiglaYDesc, P01X63_A681OsoDescripSinAc,
            P01X63_A893OsoAporteAdic, P01X63_A2160OsoActCom, P01X63_n2160OsoActCom, P01X63_A1982OsoRelSecCli, P01X63_A5OsoCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P01X66_A5OsoCod, P01X66_A3CliCod
            }
         }
      );
      AV30Pgmname = "updateObrasSociales" ;
      /* GeneXus formulas. */
      AV30Pgmname = "updateObrasSociales" ;
      Gx_err = (short)(0) ;
   }

   private byte AV31GXLvl4 ;
   private byte AV32GXLvl28 ;
   private byte AV33GXLvl68 ;
   private short AV16i ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV12CliRelSec ;
   private int A1981OsoRelSec ;
   private int A1982OsoRelSecCli ;
   private int A3CliCod ;
   private long AV10ClientePadre ;
   private java.math.BigDecimal A893OsoAporteAdic ;
   private java.math.BigDecimal AV18OsoAporteAdic ;
   private String AV30Pgmname ;
   private String scmdbuf ;
   private String A5OsoCod ;
   private String A392OsoSigla ;
   private String A306OsoC3992 ;
   private String A2160OsoActCom ;
   private String AV20OsoCod ;
   private String AV24OsoSigla ;
   private String AV19OsoC3992 ;
   private String AV27OsoActCom ;
   private String A1983OsoPadre ;
   private String AV8auxOsoCod ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String AV17nuevoOsoCod ;
   private java.util.Date AV26padreReleaseDateTime ;
   private java.util.Date AV15hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private boolean A308OsoHabilitada ;
   private boolean n306OsoC3992 ;
   private boolean n2160OsoActCom ;
   private boolean AV23OsoHabilitada ;
   private boolean returnInSub ;
   private boolean gxexitloop ;
   private String A307OsoDescrip ;
   private String A555OsoSiglaYDesc ;
   private String A681OsoDescripSinAc ;
   private String AV21OsoDescrip ;
   private String AV25OsoSiglaYDesc ;
   private String AV22OsoDescripSinAc ;
   private IDataStoreProvider pr_default ;
   private int[] P01X62_A1981OsoRelSec ;
   private int[] P01X62_A1982OsoRelSecCli ;
   private int[] P01X62_A3CliCod ;
   private String[] P01X62_A5OsoCod ;
   private String[] P01X62_A307OsoDescrip ;
   private String[] P01X62_A392OsoSigla ;
   private boolean[] P01X62_A308OsoHabilitada ;
   private String[] P01X62_A306OsoC3992 ;
   private boolean[] P01X62_n306OsoC3992 ;
   private String[] P01X62_A555OsoSiglaYDesc ;
   private String[] P01X62_A681OsoDescripSinAc ;
   private java.math.BigDecimal[] P01X62_A893OsoAporteAdic ;
   private String[] P01X62_A2160OsoActCom ;
   private boolean[] P01X62_n2160OsoActCom ;
   private String[] P01X63_A1983OsoPadre ;
   private int[] P01X63_A3CliCod ;
   private int[] P01X63_A1981OsoRelSec ;
   private String[] P01X63_A307OsoDescrip ;
   private String[] P01X63_A392OsoSigla ;
   private boolean[] P01X63_A308OsoHabilitada ;
   private String[] P01X63_A306OsoC3992 ;
   private boolean[] P01X63_n306OsoC3992 ;
   private String[] P01X63_A555OsoSiglaYDesc ;
   private String[] P01X63_A681OsoDescripSinAc ;
   private java.math.BigDecimal[] P01X63_A893OsoAporteAdic ;
   private String[] P01X63_A2160OsoActCom ;
   private boolean[] P01X63_n2160OsoActCom ;
   private int[] P01X63_A1982OsoRelSecCli ;
   private String[] P01X63_A5OsoCod ;
   private String[] P01X66_A5OsoCod ;
   private int[] P01X66_A3CliCod ;
}

final  class updateobrassociales__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01X62( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV12CliRelSec ,
                                          int A1981OsoRelSec ,
                                          int A1982OsoRelSecCli ,
                                          long AV10ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[3];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT OsoRelSec, OsoRelSecCli, CliCod, OsoCod, OsoDescrip, OsoSigla, OsoHabilitada, OsoC3992, OsoSiglaYDesc, OsoDescripSinAc, OsoAporteAdic, OsoActCom FROM ObraSocial" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(OsoRelSecCli = ?)");
      if ( ! (0==AV12CliRelSec) )
      {
         addWhere(sWhereString, "(OsoRelSec = ?)");
      }
      else
      {
         GXv_int4[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
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
                  return conditional_P01X62(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).longValue() , ((Number) dynConstraints[4]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01X62", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01X63", "SELECT OsoPadre, CliCod, OsoRelSec, OsoDescrip, OsoSigla, OsoHabilitada, OsoC3992, OsoSiglaYDesc, OsoDescripSinAc, OsoAporteAdic, OsoActCom, OsoRelSecCli, OsoCod FROM ObraSocial WHERE (CliCod = ?) AND (OsoPadre = ( ?)) ORDER BY CliCod  LIMIT 1 FOR UPDATE OF ObraSocial",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01X64", "SAVEPOINT gxupdate;UPDATE ObraSocial SET OsoRelSec=?, OsoDescrip=?, OsoSigla=?, OsoHabilitada=?, OsoC3992=?, OsoSiglaYDesc=?, OsoDescripSinAc=?, OsoAporteAdic=?, OsoActCom=?, OsoRelSecCli=?  WHERE CliCod = ? AND OsoCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01X65", "SAVEPOINT gxupdate;UPDATE ObraSocial SET OsoRelSec=?, OsoDescrip=?, OsoSigla=?, OsoHabilitada=?, OsoC3992=?, OsoSiglaYDesc=?, OsoDescripSinAc=?, OsoAporteAdic=?, OsoActCom=?, OsoRelSecCli=?  WHERE CliCod = ? AND OsoCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01X66", "SELECT OsoCod, CliCod FROM ObraSocial WHERE CliCod = ? and OsoCod = ( ?) ORDER BY CliCod, OsoCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getVarchar(10);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,2);
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((String[]) buf[11])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
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
                  stmt.setLong(sIdx, ((Number) parms[3]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[4]).longValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 20);
               }
               stmt.setVarchar(6, (String)parms[6], 400, false);
               stmt.setVarchar(7, (String)parms[7], 400, false);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 2);
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[10], 20);
               }
               stmt.setInt(10, ((Number) parms[11]).intValue());
               stmt.setInt(11, ((Number) parms[12]).intValue());
               stmt.setString(12, (String)parms[13], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 20);
               }
               stmt.setVarchar(6, (String)parms[6], 400, false);
               stmt.setVarchar(7, (String)parms[7], 400, false);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 2);
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[10], 20);
               }
               stmt.setInt(10, ((Number) parms[11]).intValue());
               stmt.setInt(11, ((Number) parms[12]).intValue());
               stmt.setString(12, (String)parms[13], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

