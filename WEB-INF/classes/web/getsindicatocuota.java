package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsindicatocuota extends GXProcedure
{
   public getsindicatocuota( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsindicatocuota.class ), "" );
   }

   public getsindicatocuota( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              java.math.BigDecimal[] aP2 )
   {
      getsindicatocuota.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.math.BigDecimal[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.math.BigDecimal[] aP2 ,
                             boolean[] aP3 )
   {
      getsindicatocuota.this.AV10CliCod = aP0;
      getsindicatocuota.this.AV9SinCod = aP1;
      getsindicatocuota.this.aP2 = aP2;
      getsindicatocuota.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV12PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV10CliCod, GXv_int2) ;
      getsindicatocuota.this.GXt_int1 = GXv_int2[0] ;
      AV12PaiCod = GXt_int1 ;
      /* Using cursor P010W2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV12PaiCod), AV9SinCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A14SinCod = P010W2_A14SinCod[0] ;
         A46PaiCod = P010W2_A46PaiCod[0] ;
         A930SinCuotaAli = P010W2_A930SinCuotaAli[0] ;
         AV13SinCuotaAli = A930SinCuotaAli ;
         AV11existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getsindicatocuota.this.AV13SinCuotaAli;
      this.aP3[0] = getsindicatocuota.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13SinCuotaAli = DecimalUtil.ZERO ;
      GXv_int2 = new short[1] ;
      scmdbuf = "" ;
      P010W2_A14SinCod = new String[] {""} ;
      P010W2_A46PaiCod = new short[1] ;
      P010W2_A930SinCuotaAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A14SinCod = "" ;
      A930SinCuotaAli = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsindicatocuota__default(),
         new Object[] {
             new Object[] {
            P010W2_A14SinCod, P010W2_A46PaiCod, P010W2_A930SinCuotaAli
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private java.math.BigDecimal AV13SinCuotaAli ;
   private java.math.BigDecimal A930SinCuotaAli ;
   private String AV9SinCod ;
   private String scmdbuf ;
   private String A14SinCod ;
   private boolean AV11existe ;
   private boolean[] aP3 ;
   private java.math.BigDecimal[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P010W2_A14SinCod ;
   private short[] P010W2_A46PaiCod ;
   private java.math.BigDecimal[] P010W2_A930SinCuotaAli ;
}

final  class getsindicatocuota__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P010W2", "SELECT SinCod, PaiCod, SinCuotaAli FROM Sindicato WHERE PaiCod = ? and SinCod = ( ?) ORDER BY PaiCod, SinCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

