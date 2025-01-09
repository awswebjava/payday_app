package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class existedetalleliquidacion2 extends GXProcedure
{
   public existedetalleliquidacion2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( existedetalleliquidacion2.class ), "" );
   }

   public existedetalleliquidacion2( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           String aP4 ,
                           boolean[] aP5 )
   {
      existedetalleliquidacion2.this.aP6 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        boolean[] aP5 ,
                        byte[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             boolean[] aP5 ,
                             byte[] aP6 )
   {
      existedetalleliquidacion2.this.AV13CliCod = aP0;
      existedetalleliquidacion2.this.AV12EmpCod = aP1;
      existedetalleliquidacion2.this.AV11LiqNro = aP2;
      existedetalleliquidacion2.this.AV10LegNumero = aP3;
      existedetalleliquidacion2.this.AV9ConCodigo = aP4;
      existedetalleliquidacion2.this.aP5 = aP5;
      existedetalleliquidacion2.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01FC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LiqNro), Integer.valueOf(AV10LegNumero), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A394DConCodigo = P01FC2_A394DConCodigo[0] ;
         A6LegNumero = P01FC2_A6LegNumero[0] ;
         A31LiqNro = P01FC2_A31LiqNro[0] ;
         A1EmpCod = P01FC2_A1EmpCod[0] ;
         A3CliCod = P01FC2_A3CliCod[0] ;
         A507LiqDCalculado = P01FC2_A507LiqDCalculado[0] ;
         A81LiqDSecuencial = P01FC2_A81LiqDSecuencial[0] ;
         AV8existe = true ;
         AV14LiqDCalculado = A507LiqDCalculado ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = existedetalleliquidacion2.this.AV8existe;
      this.aP6[0] = existedetalleliquidacion2.this.AV14LiqDCalculado;
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
      P01FC2_A394DConCodigo = new String[] {""} ;
      P01FC2_A6LegNumero = new int[1] ;
      P01FC2_A31LiqNro = new int[1] ;
      P01FC2_A1EmpCod = new short[1] ;
      P01FC2_A3CliCod = new int[1] ;
      P01FC2_A507LiqDCalculado = new byte[1] ;
      P01FC2_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.existedetalleliquidacion2__default(),
         new Object[] {
             new Object[] {
            P01FC2_A394DConCodigo, P01FC2_A6LegNumero, P01FC2_A31LiqNro, P01FC2_A1EmpCod, P01FC2_A3CliCod, P01FC2_A507LiqDCalculado, P01FC2_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14LiqDCalculado ;
   private byte A507LiqDCalculado ;
   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV11LiqNro ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private boolean AV8existe ;
   private byte[] aP6 ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P01FC2_A394DConCodigo ;
   private int[] P01FC2_A6LegNumero ;
   private int[] P01FC2_A31LiqNro ;
   private short[] P01FC2_A1EmpCod ;
   private int[] P01FC2_A3CliCod ;
   private byte[] P01FC2_A507LiqDCalculado ;
   private int[] P01FC2_A81LiqDSecuencial ;
}

final  class existedetalleliquidacion2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01FC2", "SELECT DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDCalculado, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DConCodigo = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
      }
   }

}

