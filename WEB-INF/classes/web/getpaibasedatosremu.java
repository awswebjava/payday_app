package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpaibasedatosremu extends GXProcedure
{
   public getpaibasedatosremu( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpaibasedatosremu.class ), "" );
   }

   public getpaibasedatosremu( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              String aP1 ,
                              String aP2 ,
                              String aP3 ,
                              String aP4 ,
                              java.math.BigDecimal[] aP5 ,
                              short[] aP6 ,
                              short[] aP7 ,
                              String[] aP8 )
   {
      getpaibasedatosremu.this.aP9 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        short[] aP6 ,
                        short[] aP7 ,
                        String[] aP8 ,
                        boolean[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             short[] aP6 ,
                             short[] aP7 ,
                             String[] aP8 ,
                             boolean[] aP9 )
   {
      getpaibasedatosremu.this.AV17PaiCod = aP0;
      getpaibasedatosremu.this.AV18tipo_tarifa = aP1;
      getpaibasedatosremu.this.AV15tipo_base = aP2;
      getpaibasedatosremu.this.AV14PaiBaseCod1 = aP3;
      getpaibasedatosremu.this.AV13PaiBaseCod2 = aP4;
      getpaibasedatosremu.this.aP5 = aP5;
      getpaibasedatosremu.this.aP6 = aP6;
      getpaibasedatosremu.this.aP7 = aP7;
      getpaibasedatosremu.this.aP8 = aP8;
      getpaibasedatosremu.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV18tipo_tarifa, "H") == 0 )
      {
         AV16ClaseLeg = (byte)(2) ;
      }
      else
      {
         AV16ClaseLeg = (byte)(1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "1 &PaiCod ", "")+GXutil.trim( GXutil.str( AV17PaiCod, 4, 0))+httpContext.getMessage( " &ClaseLeg ", "")+GXutil.trim( GXutil.str( AV16ClaseLeg, 1, 0))+httpContext.getMessage( " &PaiBaseCod1 ", "")+GXutil.trim( AV14PaiBaseCod1)+httpContext.getMessage( " &PaiBaseCod2 ", "")+GXutil.trim( AV13PaiBaseCod2)) ;
      AV22GXLvl8 = (byte)(0) ;
      /* Using cursor P01GO2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV17PaiCod), Byte.valueOf(AV16ClaseLeg), AV15tipo_base, AV14PaiBaseCod1, AV13PaiBaseCod2});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1443PaiBaseCod2 = P01GO2_A1443PaiBaseCod2[0] ;
         A1442PaiBaseCod1 = P01GO2_A1442PaiBaseCod1[0] ;
         A1441PaiBaseTipo = P01GO2_A1441PaiBaseTipo[0] ;
         A1440PaiBaseClaseLeg = P01GO2_A1440PaiBaseClaseLeg[0] ;
         A46PaiCod = P01GO2_A46PaiCod[0] ;
         A1444PaiBasePlus = P01GO2_A1444PaiBasePlus[0] ;
         A1451PaiBasePromCnt1 = P01GO2_A1451PaiBasePromCnt1[0] ;
         A1452PaiBasePromCnt2 = P01GO2_A1452PaiBasePromCnt2[0] ;
         A1453PaiBasePromTCnt = P01GO2_A1453PaiBasePromTCnt[0] ;
         AV22GXLvl8 = (byte)(1) ;
         AV8PaiBasePlus = A1444PaiBasePlus ;
         AV9PaiBasePromCnt1 = A1451PaiBasePromCnt1 ;
         AV11PaiBasePromCnt2 = A1452PaiBasePromCnt2 ;
         AV10PaiBasePromTCnt = A1453PaiBasePromTCnt ;
         AV12hay = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV22GXLvl8 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "none", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&PaiBasePlus ", "")+GXutil.trim( GXutil.str( AV8PaiBasePlus, 6, 4))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getpaibasedatosremu.this.AV8PaiBasePlus;
      this.aP6[0] = getpaibasedatosremu.this.AV9PaiBasePromCnt1;
      this.aP7[0] = getpaibasedatosremu.this.AV11PaiBasePromCnt2;
      this.aP8[0] = getpaibasedatosremu.this.AV10PaiBasePromTCnt;
      this.aP9[0] = getpaibasedatosremu.this.AV12hay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8PaiBasePlus = DecimalUtil.ZERO ;
      AV10PaiBasePromTCnt = "" ;
      AV21Pgmname = "" ;
      scmdbuf = "" ;
      P01GO2_A1443PaiBaseCod2 = new String[] {""} ;
      P01GO2_A1442PaiBaseCod1 = new String[] {""} ;
      P01GO2_A1441PaiBaseTipo = new String[] {""} ;
      P01GO2_A1440PaiBaseClaseLeg = new byte[1] ;
      P01GO2_A46PaiCod = new short[1] ;
      P01GO2_A1444PaiBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01GO2_A1451PaiBasePromCnt1 = new short[1] ;
      P01GO2_A1452PaiBasePromCnt2 = new short[1] ;
      P01GO2_A1453PaiBasePromTCnt = new String[] {""} ;
      A1443PaiBaseCod2 = "" ;
      A1442PaiBaseCod1 = "" ;
      A1441PaiBaseTipo = "" ;
      A1444PaiBasePlus = DecimalUtil.ZERO ;
      A1453PaiBasePromTCnt = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpaibasedatosremu__default(),
         new Object[] {
             new Object[] {
            P01GO2_A1443PaiBaseCod2, P01GO2_A1442PaiBaseCod1, P01GO2_A1441PaiBaseTipo, P01GO2_A1440PaiBaseClaseLeg, P01GO2_A46PaiCod, P01GO2_A1444PaiBasePlus, P01GO2_A1451PaiBasePromCnt1, P01GO2_A1452PaiBasePromCnt2, P01GO2_A1453PaiBasePromTCnt
            }
         }
      );
      AV21Pgmname = "getPaiBaseDatosRemu" ;
      /* GeneXus formulas. */
      AV21Pgmname = "getPaiBaseDatosRemu" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16ClaseLeg ;
   private byte AV22GXLvl8 ;
   private byte A1440PaiBaseClaseLeg ;
   private short AV17PaiCod ;
   private short AV9PaiBasePromCnt1 ;
   private short AV11PaiBasePromCnt2 ;
   private short A46PaiCod ;
   private short A1451PaiBasePromCnt1 ;
   private short A1452PaiBasePromCnt2 ;
   private short Gx_err ;
   private java.math.BigDecimal AV8PaiBasePlus ;
   private java.math.BigDecimal A1444PaiBasePlus ;
   private String AV18tipo_tarifa ;
   private String AV15tipo_base ;
   private String AV14PaiBaseCod1 ;
   private String AV13PaiBaseCod2 ;
   private String AV10PaiBasePromTCnt ;
   private String AV21Pgmname ;
   private String scmdbuf ;
   private String A1443PaiBaseCod2 ;
   private String A1442PaiBaseCod1 ;
   private String A1441PaiBaseTipo ;
   private String A1453PaiBasePromTCnt ;
   private boolean AV12hay ;
   private boolean[] aP9 ;
   private java.math.BigDecimal[] aP5 ;
   private short[] aP6 ;
   private short[] aP7 ;
   private String[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P01GO2_A1443PaiBaseCod2 ;
   private String[] P01GO2_A1442PaiBaseCod1 ;
   private String[] P01GO2_A1441PaiBaseTipo ;
   private byte[] P01GO2_A1440PaiBaseClaseLeg ;
   private short[] P01GO2_A46PaiCod ;
   private java.math.BigDecimal[] P01GO2_A1444PaiBasePlus ;
   private short[] P01GO2_A1451PaiBasePromCnt1 ;
   private short[] P01GO2_A1452PaiBasePromCnt2 ;
   private String[] P01GO2_A1453PaiBasePromTCnt ;
}

final  class getpaibasedatosremu__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01GO2", "SELECT PaiBaseCod2, PaiBaseCod1, PaiBaseTipo, PaiBaseClaseLeg, PaiCod, PaiBasePlus, PaiBasePromCnt1, PaiBasePromCnt2, PaiBasePromTCnt FROM Paisbase_calculo WHERE PaiCod = ? and PaiBaseClaseLeg = ? and PaiBaseTipo = ( ?) and PaiBaseCod1 = ( ?) and PaiBaseCod2 = ( ?) ORDER BY PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
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

