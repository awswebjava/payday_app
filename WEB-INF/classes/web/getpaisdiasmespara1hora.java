package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpaisdiasmespara1hora extends GXProcedure
{
   public getpaisdiasmespara1hora( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpaisdiasmespara1hora.class ), "" );
   }

   public getpaisdiasmespara1hora( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             java.math.BigDecimal[] aP1 )
   {
      getpaisdiasmespara1hora.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        java.math.BigDecimal[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             java.math.BigDecimal[] aP1 ,
                             String[] aP2 )
   {
      getpaisdiasmespara1hora.this.AV8PaiCod = aP0;
      getpaisdiasmespara1hora.this.aP1 = aP1;
      getpaisdiasmespara1hora.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01CN2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P01CN2_A46PaiCod[0] ;
         A1271PaiMesHsPExt = P01CN2_A1271PaiMesHsPExt[0] ;
         A1272PaiDiaHsPExt = P01CN2_A1272PaiDiaHsPExt[0] ;
         AV10PaiMesHsPExt = A1271PaiMesHsPExt ;
         AV9PaiDiaHsPExt = A1272PaiDiaHsPExt ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpaisdiasmespara1hora.this.AV10PaiMesHsPExt;
      this.aP2[0] = getpaisdiasmespara1hora.this.AV9PaiDiaHsPExt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10PaiMesHsPExt = DecimalUtil.ZERO ;
      AV9PaiDiaHsPExt = "" ;
      scmdbuf = "" ;
      P01CN2_A46PaiCod = new short[1] ;
      P01CN2_A1271PaiMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01CN2_A1272PaiDiaHsPExt = new String[] {""} ;
      A1271PaiMesHsPExt = DecimalUtil.ZERO ;
      A1272PaiDiaHsPExt = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpaisdiasmespara1hora__default(),
         new Object[] {
             new Object[] {
            P01CN2_A46PaiCod, P01CN2_A1271PaiMesHsPExt, P01CN2_A1272PaiDiaHsPExt
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private java.math.BigDecimal AV10PaiMesHsPExt ;
   private java.math.BigDecimal A1271PaiMesHsPExt ;
   private String AV9PaiDiaHsPExt ;
   private String scmdbuf ;
   private String A1272PaiDiaHsPExt ;
   private String[] aP2 ;
   private java.math.BigDecimal[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P01CN2_A46PaiCod ;
   private java.math.BigDecimal[] P01CN2_A1271PaiMesHsPExt ;
   private String[] P01CN2_A1272PaiDiaHsPExt ;
}

final  class getpaisdiasmespara1hora__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CN2", "SELECT PaiCod, PaiMesHsPExt, PaiDiaHsPExt FROM Pais WHERE PaiCod = ? ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,1);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               return;
      }
   }

}

