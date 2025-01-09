package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newliccc_aprobacion extends GXProcedure
{
   public newliccc_aprobacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newliccc_aprobacion.class ), "" );
   }

   public newliccc_aprobacion( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            String aP3 ,
                            short aP4 ,
                            java.util.Date aP5 ,
                            short aP6 ,
                            String aP7 ,
                            int aP8 ,
                            boolean[] aP9 )
   {
      newliccc_aprobacion.this.aP10 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 ,
                        java.util.Date aP5 ,
                        short aP6 ,
                        String aP7 ,
                        int aP8 ,
                        boolean[] aP9 ,
                        short[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             java.util.Date aP5 ,
                             short aP6 ,
                             String aP7 ,
                             int aP8 ,
                             boolean[] aP9 ,
                             short[] aP10 )
   {
      newliccc_aprobacion.this.AV14CliCod = aP0;
      newliccc_aprobacion.this.AV13EmpCod = aP1;
      newliccc_aprobacion.this.AV12LegNumero = aP2;
      newliccc_aprobacion.this.AV11LegCuenLicTpo = aP3;
      newliccc_aprobacion.this.AV10LegCuenAnio = aP4;
      newliccc_aprobacion.this.AV9LegCuLAprLicFch = aP5;
      newliccc_aprobacion.this.AV8LegCuLAprLicCnt = aP6;
      newliccc_aprobacion.this.AV18LegCuLAprLicOri = aP7;
      newliccc_aprobacion.this.AV20LegCuLAprLiqNro = aP8;
      newliccc_aprobacion.this.aP9 = aP9;
      newliccc_aprobacion.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV23GXLvl1 = (byte)(0) ;
      /* Using cursor P02BP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV12LegNumero), AV11LegCuenLicTpo, Short.valueOf(AV10LegCuenAnio), AV9LegCuLAprLicFch});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2324LegCuLAprLicFch = P02BP2_A2324LegCuLAprLicFch[0] ;
         A2266LegCuenAnio = P02BP2_A2266LegCuenAnio[0] ;
         A2243LegCuenLicTpo = P02BP2_A2243LegCuenLicTpo[0] ;
         A6LegNumero = P02BP2_A6LegNumero[0] ;
         A1EmpCod = P02BP2_A1EmpCod[0] ;
         A3CliCod = P02BP2_A3CliCod[0] ;
         AV23GXLvl1 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV23GXLvl1 == 0 )
      {
         /*
            INSERT RECORD ON TABLE legajo_cuenta_licenciasaprobaciones

         */
         A3CliCod = AV14CliCod ;
         A1EmpCod = AV13EmpCod ;
         A6LegNumero = AV12LegNumero ;
         A2243LegCuenLicTpo = AV11LegCuenLicTpo ;
         A2266LegCuenAnio = AV10LegCuenAnio ;
         A2324LegCuLAprLicFch = AV9LegCuLAprLicFch ;
         A2325LegCuLAprLicCnt = AV8LegCuLAprLicCnt ;
         A2326LegCuLAprLicOri = AV18LegCuLAprLicOri ;
         if ( ! (0==AV20LegCuLAprLiqNro) )
         {
            A2341LegCuLAprLiqNro = AV20LegCuLAprLiqNro ;
            n2341LegCuLAprLiqNro = false ;
         }
         else
         {
            A2341LegCuLAprLiqNro = 0 ;
            n2341LegCuLAprLiqNro = false ;
            n2341LegCuLAprLiqNro = true ;
         }
         /* Using cursor P02BP3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), A2324LegCuLAprLicFch, Short.valueOf(A2325LegCuLAprLicCnt), A2326LegCuLAprLicOri, Boolean.valueOf(n2341LegCuLAprLiqNro), Integer.valueOf(A2341LegCuLAprLiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasaprobaciones");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         GXv_boolean1[0] = AV19corrigio ;
         GXv_int2[0] = AV16LegCuenDiasCorres ;
         new web.liccccorrigeaprobporini(remoteHandle, context).execute( AV14CliCod, AV13EmpCod, AV12LegNumero, AV11LegCuenLicTpo, AV10LegCuenAnio, GXv_boolean1, GXv_int2) ;
         newliccc_aprobacion.this.AV19corrigio = GXv_boolean1[0] ;
         newliccc_aprobacion.this.AV16LegCuenDiasCorres = GXv_int2[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = newliccc_aprobacion.this.AV19corrigio;
      this.aP10[0] = newliccc_aprobacion.this.AV16LegCuenDiasCorres;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P02BP2_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      P02BP2_A2266LegCuenAnio = new short[1] ;
      P02BP2_A2243LegCuenLicTpo = new String[] {""} ;
      P02BP2_A6LegNumero = new int[1] ;
      P02BP2_A1EmpCod = new short[1] ;
      P02BP2_A3CliCod = new int[1] ;
      A2324LegCuLAprLicFch = GXutil.nullDate() ;
      A2243LegCuenLicTpo = "" ;
      A2326LegCuLAprLicOri = "" ;
      Gx_emsg = "" ;
      GXv_boolean1 = new boolean[1] ;
      GXv_int2 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newliccc_aprobacion__default(),
         new Object[] {
             new Object[] {
            P02BP2_A2324LegCuLAprLicFch, P02BP2_A2266LegCuenAnio, P02BP2_A2243LegCuenLicTpo, P02BP2_A6LegNumero, P02BP2_A1EmpCod, P02BP2_A3CliCod
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV23GXLvl1 ;
   private short AV13EmpCod ;
   private short AV10LegCuenAnio ;
   private short AV8LegCuLAprLicCnt ;
   private short AV16LegCuenDiasCorres ;
   private short A2266LegCuenAnio ;
   private short A1EmpCod ;
   private short A2325LegCuLAprLicCnt ;
   private short Gx_err ;
   private short GXv_int2[] ;
   private int AV14CliCod ;
   private int AV12LegNumero ;
   private int AV20LegCuLAprLiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int GX_INS288 ;
   private int A2341LegCuLAprLiqNro ;
   private String AV11LegCuenLicTpo ;
   private String AV18LegCuLAprLicOri ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private String A2326LegCuLAprLicOri ;
   private String Gx_emsg ;
   private java.util.Date AV9LegCuLAprLicFch ;
   private java.util.Date A2324LegCuLAprLicFch ;
   private boolean AV19corrigio ;
   private boolean n2341LegCuLAprLiqNro ;
   private boolean GXv_boolean1[] ;
   private short[] aP10 ;
   private boolean[] aP9 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P02BP2_A2324LegCuLAprLicFch ;
   private short[] P02BP2_A2266LegCuenAnio ;
   private String[] P02BP2_A2243LegCuenLicTpo ;
   private int[] P02BP2_A6LegNumero ;
   private short[] P02BP2_A1EmpCod ;
   private int[] P02BP2_A3CliCod ;
}

final  class newliccc_aprobacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BP2", "SELECT LegCuLAprLicFch, LegCuenAnio, LegCuenLicTpo, LegNumero, EmpCod, CliCod FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? and LegCuLAprLicFch = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02BP3", "SAVEPOINT gxupdate;INSERT INTO legajo_cuenta_licenciasaprobaciones(CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch, LegCuLAprLicCnt, LegCuLAprLicOri, LegCuLAprLiqNro) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(9, ((Number) parms[9]).intValue());
               }
               return;
      }
   }

}

