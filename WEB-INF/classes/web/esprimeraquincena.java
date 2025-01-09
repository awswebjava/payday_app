package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esprimeraquincena extends GXProcedure
{
   public esprimeraquincena( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esprimeraquincena.class ), "" );
   }

   public esprimeraquincena( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           java.util.Date aP4 ,
                           byte aP5 )
   {
      esprimeraquincena.this.aP6 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        byte aP5 ,
                        byte[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             byte aP5 ,
                             byte[] aP6 )
   {
      esprimeraquincena.this.AV10CliCod = aP0;
      esprimeraquincena.this.AV11EmpCod = aP1;
      esprimeraquincena.this.AV15LiqNro = aP2;
      esprimeraquincena.this.AV12LegNumero = aP3;
      esprimeraquincena.this.AV13LiqPeriodo = aP4;
      esprimeraquincena.this.AV8LegClase = aP5;
      esprimeraquincena.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV8LegClase == 2 )
      {
         GXt_char1 = AV9mensualTLiqCod ;
         GXt_char2 = AV9mensualTLiqCod ;
         GXv_char3[0] = GXt_char2 ;
         new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
         esprimeraquincena.this.GXt_char2 = GXv_char3[0] ;
         GXv_char4[0] = GXt_char1 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
         esprimeraquincena.this.GXt_char1 = GXv_char4[0] ;
         AV9mensualTLiqCod = GXt_char1 ;
         AV18GXLvl3 = (byte)(0) ;
         /* Using cursor P018Z2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV12LegNumero), AV9mensualTLiqCod, AV13LiqPeriodo});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A32TLiqCod = P018Z2_A32TLiqCod[0] ;
            n32TLiqCod = P018Z2_n32TLiqCod[0] ;
            A283LiqPeriodo = P018Z2_A283LiqPeriodo[0] ;
            A6LegNumero = P018Z2_A6LegNumero[0] ;
            A1EmpCod = P018Z2_A1EmpCod[0] ;
            A3CliCod = P018Z2_A3CliCod[0] ;
            A31LiqNro = P018Z2_A31LiqNro[0] ;
            AV18GXLvl3 = (byte)(1) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV18GXLvl3 == 0 )
         {
            AV14esPrimeraQuincena = (byte)(1) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = esprimeraquincena.this.AV14esPrimeraQuincena;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9mensualTLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      scmdbuf = "" ;
      P018Z2_A32TLiqCod = new String[] {""} ;
      P018Z2_n32TLiqCod = new boolean[] {false} ;
      P018Z2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P018Z2_A6LegNumero = new int[1] ;
      P018Z2_A1EmpCod = new short[1] ;
      P018Z2_A3CliCod = new int[1] ;
      P018Z2_A31LiqNro = new int[1] ;
      A32TLiqCod = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.esprimeraquincena__default(),
         new Object[] {
             new Object[] {
            P018Z2_A32TLiqCod, P018Z2_n32TLiqCod, P018Z2_A283LiqPeriodo, P018Z2_A6LegNumero, P018Z2_A1EmpCod, P018Z2_A3CliCod, P018Z2_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8LegClase ;
   private byte AV14esPrimeraQuincena ;
   private byte AV18GXLvl3 ;
   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV15LiqNro ;
   private int AV12LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String AV9mensualTLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private java.util.Date AV13LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean n32TLiqCod ;
   private byte[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P018Z2_A32TLiqCod ;
   private boolean[] P018Z2_n32TLiqCod ;
   private java.util.Date[] P018Z2_A283LiqPeriodo ;
   private int[] P018Z2_A6LegNumero ;
   private short[] P018Z2_A1EmpCod ;
   private int[] P018Z2_A3CliCod ;
   private int[] P018Z2_A31LiqNro ;
}

final  class esprimeraquincena__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018Z2", "SELECT TLiqCod, LiqPeriodo, LegNumero, EmpCod, CliCod, LiqNro FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and TLiqCod = ( ?) and LiqPeriodo = ? ORDER BY CliCod, EmpCod, LegNumero, TLiqCod, LiqPeriodo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
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
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}

