package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdatoslegparaliq extends GXProcedure
{
   public getdatoslegparaliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdatoslegparaliq.class ), "" );
   }

   public getdatoslegparaliq( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 ,
                             byte[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      getdatoslegparaliq.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 ,
                        byte[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 ,
                             byte[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      getdatoslegparaliq.this.AV12CliCod = aP0;
      getdatoslegparaliq.this.AV13empcod = aP1;
      getdatoslegparaliq.this.AV16LiqNro = aP2;
      getdatoslegparaliq.this.AV8LegNumero = aP3;
      getdatoslegparaliq.this.aP4 = aP4;
      getdatoslegparaliq.this.aP5 = aP5;
      getdatoslegparaliq.this.aP6 = aP6;
      getdatoslegparaliq.this.aP7 = aP7;
      getdatoslegparaliq.this.aP8 = aP8;
      getdatoslegparaliq.this.aP9 = aP9;
      getdatoslegparaliq.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01D12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV13empcod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01D12_A6LegNumero[0] ;
         A1EmpCod = P01D12_A1EmpCod[0] ;
         A3CliCod = P01D12_A3CliCod[0] ;
         A877LegAgenReten = P01D12_A877LegAgenReten[0] ;
         A235LegClase = P01D12_A235LegClase[0] ;
         A1804LegTitulo = P01D12_A1804LegTitulo[0] ;
         A2404LegModTra = P01D12_A2404LegModTra[0] ;
         AV10LegAgenReten = A877LegAgenReten ;
         if ( AV10LegAgenReten )
         {
            GXv_boolean1[0] = AV10LegAgenReten ;
            new web.getempresaliquidaganancias(remoteHandle, context).execute( AV12CliCod, AV13empcod, GXv_boolean1) ;
            getdatoslegparaliq.this.AV10LegAgenReten = GXv_boolean1[0] ;
         }
         AV9LegClase = A235LegClase ;
         AV14LegTitulo = A1804LegTitulo ;
         AV17LegModTra = A2404LegModTra ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      GXv_char2[0] = AV15LegCatCodigo ;
      GXv_char3[0] = AV11ConveCodigo ;
      new web.obtcategorialegajo(remoteHandle, context).execute( AV12CliCod, AV13empcod, AV16LiqNro, AV8LegNumero, GXv_char2, GXv_char3) ;
      getdatoslegparaliq.this.AV15LegCatCodigo = GXv_char2[0] ;
      getdatoslegparaliq.this.AV11ConveCodigo = GXv_char3[0] ;
      GXv_char3[0] = AV19tipo_tarifa ;
      new web.gettipodetarifa(remoteHandle, context).execute( AV12CliCod, AV13empcod, AV16LiqNro, AV8LegNumero, (short)(0), AV11ConveCodigo, AV15LegCatCodigo, GXv_char3) ;
      getdatoslegparaliq.this.AV19tipo_tarifa = GXv_char3[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getdatoslegparaliq.this.AV11ConveCodigo;
      this.aP5[0] = getdatoslegparaliq.this.AV10LegAgenReten;
      this.aP6[0] = getdatoslegparaliq.this.AV9LegClase;
      this.aP7[0] = getdatoslegparaliq.this.AV17LegModTra;
      this.aP8[0] = getdatoslegparaliq.this.AV14LegTitulo;
      this.aP9[0] = getdatoslegparaliq.this.AV15LegCatCodigo;
      this.aP10[0] = getdatoslegparaliq.this.AV19tipo_tarifa;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11ConveCodigo = "" ;
      AV17LegModTra = "" ;
      AV14LegTitulo = "" ;
      AV15LegCatCodigo = "" ;
      AV19tipo_tarifa = "" ;
      scmdbuf = "" ;
      P01D12_A6LegNumero = new int[1] ;
      P01D12_A1EmpCod = new short[1] ;
      P01D12_A3CliCod = new int[1] ;
      P01D12_A877LegAgenReten = new boolean[] {false} ;
      P01D12_A235LegClase = new byte[1] ;
      P01D12_A1804LegTitulo = new String[] {""} ;
      P01D12_A2404LegModTra = new String[] {""} ;
      A1804LegTitulo = "" ;
      A2404LegModTra = "" ;
      GXv_boolean1 = new boolean[1] ;
      GXv_char2 = new String[1] ;
      GXv_char3 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdatoslegparaliq__default(),
         new Object[] {
             new Object[] {
            P01D12_A6LegNumero, P01D12_A1EmpCod, P01D12_A3CliCod, P01D12_A877LegAgenReten, P01D12_A235LegClase, P01D12_A1804LegTitulo, P01D12_A2404LegModTra
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9LegClase ;
   private byte A235LegClase ;
   private short AV13empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV16LiqNro ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV11ConveCodigo ;
   private String AV17LegModTra ;
   private String AV14LegTitulo ;
   private String AV15LegCatCodigo ;
   private String AV19tipo_tarifa ;
   private String scmdbuf ;
   private String A1804LegTitulo ;
   private String A2404LegModTra ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private boolean AV10LegAgenReten ;
   private boolean A877LegAgenReten ;
   private boolean GXv_boolean1[] ;
   private String[] aP10 ;
   private String[] aP4 ;
   private boolean[] aP5 ;
   private byte[] aP6 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private int[] P01D12_A6LegNumero ;
   private short[] P01D12_A1EmpCod ;
   private int[] P01D12_A3CliCod ;
   private boolean[] P01D12_A877LegAgenReten ;
   private byte[] P01D12_A235LegClase ;
   private String[] P01D12_A1804LegTitulo ;
   private String[] P01D12_A2404LegModTra ;
}

final  class getdatoslegparaliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01D12", "SELECT LegNumero, EmpCod, CliCod, LegAgenReten, LegClase, LegTitulo, LegModTra FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
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
               return;
      }
   }

}

