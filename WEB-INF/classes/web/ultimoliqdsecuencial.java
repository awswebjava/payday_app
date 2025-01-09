package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ultimoliqdsecuencial extends GXProcedure
{
   public ultimoliqdsecuencial( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ultimoliqdsecuencial.class ), "" );
   }

   public ultimoliqdsecuencial( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          int aP2 ,
                          int aP3 )
   {
      ultimoliqdsecuencial.this.aP4 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int[] aP4 )
   {
      ultimoliqdsecuencial.this.AV8CliCod = aP0;
      ultimoliqdsecuencial.this.AV11EmpCod = aP1;
      ultimoliqdsecuencial.this.AV10LiqNro = aP2;
      ultimoliqdsecuencial.this.AV9LegNumero = aP3;
      ultimoliqdsecuencial.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01D32 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV10LiqNro), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01D32_A3CliCod[0] ;
         A1EmpCod = P01D32_A1EmpCod[0] ;
         A31LiqNro = P01D32_A31LiqNro[0] ;
         A6LegNumero = P01D32_A6LegNumero[0] ;
         A81LiqDSecuencial = P01D32_A81LiqDSecuencial[0] ;
         AV12LiqDSecuencial = A81LiqDSecuencial ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = ultimoliqdsecuencial.this.AV12LiqDSecuencial;
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
      P01D32_A3CliCod = new int[1] ;
      P01D32_A1EmpCod = new short[1] ;
      P01D32_A31LiqNro = new int[1] ;
      P01D32_A6LegNumero = new int[1] ;
      P01D32_A81LiqDSecuencial = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ultimoliqdsecuencial__default(),
         new Object[] {
             new Object[] {
            P01D32_A3CliCod, P01D32_A1EmpCod, P01D32_A31LiqNro, P01D32_A6LegNumero, P01D32_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int AV9LegNumero ;
   private int AV12LiqDSecuencial ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private String scmdbuf ;
   private int[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01D32_A3CliCod ;
   private short[] P01D32_A1EmpCod ;
   private int[] P01D32_A31LiqNro ;
   private int[] P01D32_A6LegNumero ;
   private int[] P01D32_A81LiqDSecuencial ;
}

final  class ultimoliqdsecuencial__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01D32", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

