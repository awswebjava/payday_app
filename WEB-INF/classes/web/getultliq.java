package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getultliq extends GXProcedure
{
   public getultliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getultliq.class ), "" );
   }

   public getultliq( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( short aP0 ,
                          int aP1 )
   {
      getultliq.this.aP2 = new int[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        int[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             int[] aP2 )
   {
      getultliq.this.AV9EmpCod = aP0;
      getultliq.this.AV10LegNumero = aP1;
      getultliq.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV12CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      getultliq.this.GXt_int1 = GXv_int2[0] ;
      AV12CliCod = GXt_int1 ;
      /* Using cursor P00A12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00A12_A3CliCod[0] ;
         A1EmpCod = P00A12_A1EmpCod[0] ;
         A31LiqNro = P00A12_A31LiqNro[0] ;
         if ( ! (0==AV10LegNumero) )
         {
            /* Using cursor P00A13 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(AV10LegNumero)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A6LegNumero = P00A13_A6LegNumero[0] ;
               A3CliCod = P00A13_A3CliCod[0] ;
               AV11ok = true ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         else
         {
            AV11ok = true ;
         }
         if ( AV11ok )
         {
            AV8LiqNro = A31LiqNro ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getultliq.this.AV8LiqNro;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new int[1] ;
      scmdbuf = "" ;
      P00A12_A3CliCod = new int[1] ;
      P00A12_A1EmpCod = new short[1] ;
      P00A12_A31LiqNro = new int[1] ;
      P00A13_A1EmpCod = new short[1] ;
      P00A13_A31LiqNro = new int[1] ;
      P00A13_A6LegNumero = new int[1] ;
      P00A13_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getultliq__default(),
         new Object[] {
             new Object[] {
            P00A12_A3CliCod, P00A12_A1EmpCod, P00A12_A31LiqNro
            }
            , new Object[] {
            P00A13_A1EmpCod, P00A13_A31LiqNro, P00A13_A6LegNumero, P00A13_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10LegNumero ;
   private int AV8LiqNro ;
   private int AV12CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private String scmdbuf ;
   private boolean AV11ok ;
   private int[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P00A12_A3CliCod ;
   private short[] P00A12_A1EmpCod ;
   private int[] P00A12_A31LiqNro ;
   private short[] P00A13_A1EmpCod ;
   private int[] P00A13_A31LiqNro ;
   private int[] P00A13_A6LegNumero ;
   private int[] P00A13_A3CliCod ;
}

final  class getultliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00A12", "SELECT CliCod, EmpCod, LiqNro FROM Liquidacion WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, LiqNro DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00A13", "SELECT EmpCod, LiqNro, LegNumero, CliCod FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

