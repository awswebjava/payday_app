package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayliqlegdet extends GXProcedure
{
   public hayliqlegdet( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayliqlegdet.class ), "" );
   }

   public hayliqlegdet( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              String aP4 )
   {
      hayliqlegdet.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             boolean[] aP5 )
   {
      hayliqlegdet.this.AV13CliCod = aP0;
      hayliqlegdet.this.AV12EmpCod = aP1;
      hayliqlegdet.this.AV11LiqNro = aP2;
      hayliqlegdet.this.AV10LegNumero = aP3;
      hayliqlegdet.this.AV8ConCodigo = aP4;
      hayliqlegdet.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02EE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LiqNro), Integer.valueOf(AV10LegNumero), AV8ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A394DConCodigo = P02EE2_A394DConCodigo[0] ;
         A6LegNumero = P02EE2_A6LegNumero[0] ;
         A31LiqNro = P02EE2_A31LiqNro[0] ;
         A1EmpCod = P02EE2_A1EmpCod[0] ;
         A3CliCod = P02EE2_A3CliCod[0] ;
         A81LiqDSecuencial = P02EE2_A81LiqDSecuencial[0] ;
         AV9hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = hayliqlegdet.this.AV9hay;
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
      P02EE2_A394DConCodigo = new String[] {""} ;
      P02EE2_A6LegNumero = new int[1] ;
      P02EE2_A31LiqNro = new int[1] ;
      P02EE2_A1EmpCod = new short[1] ;
      P02EE2_A3CliCod = new int[1] ;
      P02EE2_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayliqlegdet__default(),
         new Object[] {
             new Object[] {
            P02EE2_A394DConCodigo, P02EE2_A6LegNumero, P02EE2_A31LiqNro, P02EE2_A1EmpCod, P02EE2_A3CliCod, P02EE2_A81LiqDSecuencial
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
   private int AV11LiqNro ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private String AV8ConCodigo ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private boolean AV9hay ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P02EE2_A394DConCodigo ;
   private int[] P02EE2_A6LegNumero ;
   private int[] P02EE2_A31LiqNro ;
   private short[] P02EE2_A1EmpCod ;
   private int[] P02EE2_A3CliCod ;
   private int[] P02EE2_A81LiqDSecuencial ;
}

final  class hayliqlegdet__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02EE2", "SELECT DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DConCodigo = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
      }
   }

}

