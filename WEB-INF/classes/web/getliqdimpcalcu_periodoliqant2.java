package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdimpcalcu_periodoliqant2 extends GXProcedure
{
   public getliqdimpcalcu_periodoliqant2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdimpcalcu_periodoliqant2.class ), "" );
   }

   public getliqdimpcalcu_periodoliqant2( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              java.util.Date aP4 ,
                              String aP5 )
   {
      getliqdimpcalcu_periodoliqant2.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean[] aP6 )
   {
      getliqdimpcalcu_periodoliqant2.this.AV13CliCod = aP0;
      getliqdimpcalcu_periodoliqant2.this.AV8EmpCod = aP1;
      getliqdimpcalcu_periodoliqant2.this.AV9LiqNro = aP2;
      getliqdimpcalcu_periodoliqant2.this.AV10LegNumero = aP3;
      getliqdimpcalcu_periodoliqant2.this.AV18LiqPeriodo = aP4;
      getliqdimpcalcu_periodoliqant2.this.AV11ConCodigo = aP5;
      getliqdimpcalcu_periodoliqant2.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02812 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV11ConCodigo, AV18LiqPeriodo, Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02812_A31LiqNro[0] ;
         A397DLiqPeriodo = P02812_A397DLiqPeriodo[0] ;
         A394DConCodigo = P02812_A394DConCodigo[0] ;
         A6LegNumero = P02812_A6LegNumero[0] ;
         A1EmpCod = P02812_A1EmpCod[0] ;
         A3CliCod = P02812_A3CliCod[0] ;
         A81LiqDSecuencial = P02812_A81LiqDSecuencial[0] ;
         AV14existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getliqdimpcalcu_periodoliqant2.this.AV14existe;
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
      P02812_A31LiqNro = new int[1] ;
      P02812_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P02812_A394DConCodigo = new String[] {""} ;
      P02812_A6LegNumero = new int[1] ;
      P02812_A1EmpCod = new short[1] ;
      P02812_A3CliCod = new int[1] ;
      P02812_A81LiqDSecuencial = new int[1] ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A394DConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdimpcalcu_periodoliqant2__default(),
         new Object[] {
             new Object[] {
            P02812_A31LiqNro, P02812_A397DLiqPeriodo, P02812_A394DConCodigo, P02812_A6LegNumero, P02812_A1EmpCod, P02812_A3CliCod, P02812_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV9LiqNro ;
   private int AV10LegNumero ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private String AV11ConCodigo ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private java.util.Date AV18LiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean AV14existe ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P02812_A31LiqNro ;
   private java.util.Date[] P02812_A397DLiqPeriodo ;
   private String[] P02812_A394DConCodigo ;
   private int[] P02812_A6LegNumero ;
   private short[] P02812_A1EmpCod ;
   private int[] P02812_A3CliCod ;
   private int[] P02812_A81LiqDSecuencial ;
}

final  class getliqdimpcalcu_periodoliqant2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02812", "SELECT LiqNro, DLiqPeriodo, DConCodigo, LegNumero, EmpCod, CliCod, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and DConCodigo = ( ?) and DLiqPeriodo = ?) AND (LiqNro < ?) ORDER BY CliCod, EmpCod, LegNumero, DConCodigo, DLiqPeriodo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
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
               stmt.setString(4, (String)parms[3], 10);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
      }
   }

}

