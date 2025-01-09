package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class haylegliqdet extends GXProcedure
{
   public haylegliqdet( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( haylegliqdet.class ), "" );
   }

   public haylegliqdet( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          int aP2 ,
                          String aP3 ,
                          String aP4 ,
                          boolean[] aP5 )
   {
      haylegliqdet.this.aP6 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        boolean[] aP5 ,
                        int[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             boolean[] aP5 ,
                             int[] aP6 )
   {
      haylegliqdet.this.AV13CliCod = aP0;
      haylegliqdet.this.AV12EmpCod = aP1;
      haylegliqdet.this.AV11LegNumero = aP2;
      haylegliqdet.this.AV8DConCodigo = aP3;
      haylegliqdet.this.AV10DLiqPerSinDia = aP4;
      haylegliqdet.this.aP5 = aP5;
      haylegliqdet.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00OG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LegNumero), AV8DConCodigo, AV10DLiqPerSinDia});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A513LiqPerSinDia = P00OG2_A513LiqPerSinDia[0] ;
         A394DConCodigo = P00OG2_A394DConCodigo[0] ;
         A6LegNumero = P00OG2_A6LegNumero[0] ;
         A1EmpCod = P00OG2_A1EmpCod[0] ;
         A3CliCod = P00OG2_A3CliCod[0] ;
         A31LiqNro = P00OG2_A31LiqNro[0] ;
         A81LiqDSecuencial = P00OG2_A81LiqDSecuencial[0] ;
         A513LiqPerSinDia = P00OG2_A513LiqPerSinDia[0] ;
         AV15LiqNro = A31LiqNro ;
         AV14hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = haylegliqdet.this.AV14hay;
      this.aP6[0] = haylegliqdet.this.AV15LiqNro;
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
      P00OG2_A513LiqPerSinDia = new String[] {""} ;
      P00OG2_A394DConCodigo = new String[] {""} ;
      P00OG2_A6LegNumero = new int[1] ;
      P00OG2_A1EmpCod = new short[1] ;
      P00OG2_A3CliCod = new int[1] ;
      P00OG2_A31LiqNro = new int[1] ;
      P00OG2_A81LiqDSecuencial = new int[1] ;
      A513LiqPerSinDia = "" ;
      A394DConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.haylegliqdet__default(),
         new Object[] {
             new Object[] {
            P00OG2_A513LiqPerSinDia, P00OG2_A394DConCodigo, P00OG2_A6LegNumero, P00OG2_A1EmpCod, P00OG2_A3CliCod, P00OG2_A31LiqNro, P00OG2_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV11LegNumero ;
   private int AV15LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private String AV8DConCodigo ;
   private String AV10DLiqPerSinDia ;
   private String scmdbuf ;
   private String A513LiqPerSinDia ;
   private String A394DConCodigo ;
   private boolean AV14hay ;
   private int[] aP6 ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P00OG2_A513LiqPerSinDia ;
   private String[] P00OG2_A394DConCodigo ;
   private int[] P00OG2_A6LegNumero ;
   private short[] P00OG2_A1EmpCod ;
   private int[] P00OG2_A3CliCod ;
   private int[] P00OG2_A31LiqNro ;
   private int[] P00OG2_A81LiqDSecuencial ;
}

final  class haylegliqdet__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00OG2", "SELECT T2.LiqPerSinDia, T1.DConCodigo, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqNro, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.DConCodigo = ( ?)) AND (T2.LiqPerSinDia = ( ?)) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setString(5, (String)parms[4], 20);
               return;
      }
   }

}

