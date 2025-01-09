package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconvenioycategorialegajo extends GXProcedure
{
   public getconvenioycategorialegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconvenioycategorialegajo.class ), "" );
   }

   public getconvenioycategorialegajo( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             short[] aP4 ,
                             String[] aP5 )
   {
      getconvenioycategorialegajo.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        short[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             short[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      getconvenioycategorialegajo.this.AV11CliCod = aP0;
      getconvenioycategorialegajo.this.AV12EmpCod = aP1;
      getconvenioycategorialegajo.this.AV14LiqNro = aP2;
      getconvenioycategorialegajo.this.AV8LegNumero = aP3;
      getconvenioycategorialegajo.this.aP4 = aP4;
      getconvenioycategorialegajo.this.aP5 = aP5;
      getconvenioycategorialegajo.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P018E2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P018E2_A6LegNumero[0] ;
         A1EmpCod = P018E2_A1EmpCod[0] ;
         A3CliCod = P018E2_A3CliCod[0] ;
         A22LegPaiCod = P018E2_A22LegPaiCod[0] ;
         n22LegPaiCod = P018E2_n22LegPaiCod[0] ;
         AV9LegPaiCod = A22LegPaiCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      GXv_char1[0] = AV10LegCatCodigo ;
      GXv_char2[0] = AV13LegConveCodigo ;
      new web.obtcategorialegajo(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV14LiqNro, AV8LegNumero, GXv_char1, GXv_char2) ;
      getconvenioycategorialegajo.this.AV10LegCatCodigo = GXv_char1[0] ;
      getconvenioycategorialegajo.this.AV13LegConveCodigo = GXv_char2[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getconvenioycategorialegajo.this.AV9LegPaiCod;
      this.aP5[0] = getconvenioycategorialegajo.this.AV13LegConveCodigo;
      this.aP6[0] = getconvenioycategorialegajo.this.AV10LegCatCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13LegConveCodigo = "" ;
      AV10LegCatCodigo = "" ;
      scmdbuf = "" ;
      P018E2_A6LegNumero = new int[1] ;
      P018E2_A1EmpCod = new short[1] ;
      P018E2_A3CliCod = new int[1] ;
      P018E2_A22LegPaiCod = new short[1] ;
      P018E2_n22LegPaiCod = new boolean[] {false} ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconvenioycategorialegajo__default(),
         new Object[] {
             new Object[] {
            P018E2_A6LegNumero, P018E2_A1EmpCod, P018E2_A3CliCod, P018E2_A22LegPaiCod, P018E2_n22LegPaiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV9LegPaiCod ;
   private short A1EmpCod ;
   private short A22LegPaiCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV14LiqNro ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV13LegConveCodigo ;
   private String AV10LegCatCodigo ;
   private String scmdbuf ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private boolean n22LegPaiCod ;
   private String[] aP6 ;
   private short[] aP4 ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P018E2_A6LegNumero ;
   private short[] P018E2_A1EmpCod ;
   private int[] P018E2_A3CliCod ;
   private short[] P018E2_A22LegPaiCod ;
   private boolean[] P018E2_n22LegPaiCod ;
}

final  class getconvenioycategorialegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018E2", "SELECT LegNumero, EmpCod, CliCod, LegPaiCod FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
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

