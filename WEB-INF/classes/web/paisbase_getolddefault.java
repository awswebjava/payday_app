package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paisbase_getolddefault extends GXProcedure
{
   public paisbase_getolddefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisbase_getolddefault.class ), "" );
   }

   public paisbase_getolddefault( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public web.SdtPaisbase_old executeUdp( short aP0 ,
                                          byte aP1 ,
                                          String aP2 ,
                                          String aP3 ,
                                          String aP4 )
   {
      paisbase_getolddefault.this.aP5 = new web.SdtPaisbase_old[] {new web.SdtPaisbase_old()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( short aP0 ,
                        byte aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        web.SdtPaisbase_old[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( short aP0 ,
                             byte aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             web.SdtPaisbase_old[] aP5 )
   {
      paisbase_getolddefault.this.AV9PaiCod = aP0;
      paisbase_getolddefault.this.AV10PaiBaseClaseLeg = aP1;
      paisbase_getolddefault.this.AV11PaiBaseTipo = aP2;
      paisbase_getolddefault.this.AV12PaiBaseCod1 = aP3;
      paisbase_getolddefault.this.AV13PaiBaseCod2 = aP4;
      paisbase_getolddefault.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01X32 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9PaiCod), Byte.valueOf(AV10PaiBaseClaseLeg), AV11PaiBaseTipo, AV12PaiBaseCod1, AV13PaiBaseCod2});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1443PaiBaseCod2 = P01X32_A1443PaiBaseCod2[0] ;
         A1442PaiBaseCod1 = P01X32_A1442PaiBaseCod1[0] ;
         A1441PaiBaseTipo = P01X32_A1441PaiBaseTipo[0] ;
         A1440PaiBaseClaseLeg = P01X32_A1440PaiBaseClaseLeg[0] ;
         A46PaiCod = P01X32_A46PaiCod[0] ;
         A1975PaiBaseOldDefault = P01X32_A1975PaiBaseOldDefault[0] ;
         AV8Paisbase_old.fromJSonString(A1975PaiBaseOldDefault, null);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = paisbase_getolddefault.this.AV8Paisbase_old;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Paisbase_old = new web.SdtPaisbase_old(remoteHandle, context);
      scmdbuf = "" ;
      P01X32_A1443PaiBaseCod2 = new String[] {""} ;
      P01X32_A1442PaiBaseCod1 = new String[] {""} ;
      P01X32_A1441PaiBaseTipo = new String[] {""} ;
      P01X32_A1440PaiBaseClaseLeg = new byte[1] ;
      P01X32_A46PaiCod = new short[1] ;
      P01X32_A1975PaiBaseOldDefault = new String[] {""} ;
      A1443PaiBaseCod2 = "" ;
      A1442PaiBaseCod1 = "" ;
      A1441PaiBaseTipo = "" ;
      A1975PaiBaseOldDefault = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisbase_getolddefault__default(),
         new Object[] {
             new Object[] {
            P01X32_A1443PaiBaseCod2, P01X32_A1442PaiBaseCod1, P01X32_A1441PaiBaseTipo, P01X32_A1440PaiBaseClaseLeg, P01X32_A46PaiCod, P01X32_A1975PaiBaseOldDefault
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10PaiBaseClaseLeg ;
   private byte A1440PaiBaseClaseLeg ;
   private short AV9PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String AV11PaiBaseTipo ;
   private String AV12PaiBaseCod1 ;
   private String AV13PaiBaseCod2 ;
   private String scmdbuf ;
   private String A1443PaiBaseCod2 ;
   private String A1442PaiBaseCod1 ;
   private String A1441PaiBaseTipo ;
   private String A1975PaiBaseOldDefault ;
   private web.SdtPaisbase_old[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P01X32_A1443PaiBaseCod2 ;
   private String[] P01X32_A1442PaiBaseCod1 ;
   private String[] P01X32_A1441PaiBaseTipo ;
   private byte[] P01X32_A1440PaiBaseClaseLeg ;
   private short[] P01X32_A46PaiCod ;
   private String[] P01X32_A1975PaiBaseOldDefault ;
   private web.SdtPaisbase_old AV8Paisbase_old ;
}

final  class paisbase_getolddefault__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01X32", "SELECT PaiBaseCod2, PaiBaseCod1, PaiBaseTipo, PaiBaseClaseLeg, PaiCod, PaiBaseOldDefault FROM Paisbase_calculo WHERE PaiCod = ? and PaiBaseClaseLeg = ? and PaiBaseTipo = ( ?) and PaiBaseCod1 = ( ?) and PaiBaseCod2 = ( ?) ORDER BY PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
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
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
      }
   }

}

