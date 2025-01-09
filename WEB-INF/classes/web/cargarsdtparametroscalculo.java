package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cargarsdtparametroscalculo extends GXProcedure
{
   public cargarsdtparametroscalculo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cargarsdtparametroscalculo.class ), "" );
   }

   public cargarsdtparametroscalculo( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> executeUdp( short aP0 ,
                                                                                   String aP1 )
   {
      cargarsdtparametroscalculo.this.aP2 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP2 )
   {
      cargarsdtparametroscalculo.this.AV9PaiCod = aP0;
      cargarsdtparametroscalculo.this.AV8idOperando = aP1;
      cargarsdtparametroscalculo.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02042 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9PaiCod), AV8idOperando});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A74idOperando = P02042_A74idOperando[0] ;
         A46PaiCod = P02042_A46PaiCod[0] ;
         A2098CalParId = P02042_A2098CalParId[0] ;
         A2099CalParCampo = P02042_A2099CalParCampo[0] ;
         A2111CalParValLista = P02042_A2111CalParValLista[0] ;
         A2104CalParGrp = P02042_A2104CalParGrp[0] ;
         A2105CalParGrpDep = P02042_A2105CalParGrpDep[0] ;
         A2106CalParObl = P02042_A2106CalParObl[0] ;
         A2107CalParDef = P02042_A2107CalParDef[0] ;
         A2110CalParNombre = P02042_A2110CalParNombre[0] ;
         AV11itemCalParVal = (web.Sdtcal_par_valores_cal_par_valoresItem)new web.Sdtcal_par_valores_cal_par_valoresItem(remoteHandle, context);
         AV11itemCalParVal.setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid( A2098CalParId );
         AV11itemCalParVal.setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo( A2099CalParCampo );
         AV11itemCalParVal.setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista( A2111CalParValLista );
         AV11itemCalParVal.setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp( A2104CalParGrp );
         AV11itemCalParVal.setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep( A2105CalParGrpDep );
         AV11itemCalParVal.setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl( A2106CalParObl );
         AV11itemCalParVal.setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef( A2107CalParDef );
         AV11itemCalParVal.setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre( A2110CalParNombre );
         AV10cal_par_valores.add(AV11itemCalParVal, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = cargarsdtparametroscalculo.this.AV10cal_par_valores;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10cal_par_valores = new GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>(web.Sdtcal_par_valores_cal_par_valoresItem.class, "cal_par_valoresItem", "PayDay", remoteHandle);
      scmdbuf = "" ;
      P02042_A74idOperando = new String[] {""} ;
      P02042_A46PaiCod = new short[1] ;
      P02042_A2098CalParId = new String[] {""} ;
      P02042_A2099CalParCampo = new String[] {""} ;
      P02042_A2111CalParValLista = new String[] {""} ;
      P02042_A2104CalParGrp = new byte[1] ;
      P02042_A2105CalParGrpDep = new byte[1] ;
      P02042_A2106CalParObl = new boolean[] {false} ;
      P02042_A2107CalParDef = new String[] {""} ;
      P02042_A2110CalParNombre = new String[] {""} ;
      A74idOperando = "" ;
      A2098CalParId = "" ;
      A2099CalParCampo = "" ;
      A2111CalParValLista = "" ;
      A2107CalParDef = "" ;
      A2110CalParNombre = "" ;
      AV11itemCalParVal = new web.Sdtcal_par_valores_cal_par_valoresItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cargarsdtparametroscalculo__default(),
         new Object[] {
             new Object[] {
            P02042_A74idOperando, P02042_A46PaiCod, P02042_A2098CalParId, P02042_A2099CalParCampo, P02042_A2111CalParValLista, P02042_A2104CalParGrp, P02042_A2105CalParGrpDep, P02042_A2106CalParObl, P02042_A2107CalParDef, P02042_A2110CalParNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A2104CalParGrp ;
   private byte A2105CalParGrpDep ;
   private short AV9PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String AV8idOperando ;
   private String scmdbuf ;
   private String A74idOperando ;
   private String A2098CalParId ;
   private String A2107CalParDef ;
   private boolean A2106CalParObl ;
   private String A2099CalParCampo ;
   private String A2111CalParValLista ;
   private String A2110CalParNombre ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P02042_A74idOperando ;
   private short[] P02042_A46PaiCod ;
   private String[] P02042_A2098CalParId ;
   private String[] P02042_A2099CalParCampo ;
   private String[] P02042_A2111CalParValLista ;
   private byte[] P02042_A2104CalParGrp ;
   private byte[] P02042_A2105CalParGrpDep ;
   private boolean[] P02042_A2106CalParObl ;
   private String[] P02042_A2107CalParDef ;
   private String[] P02042_A2110CalParNombre ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> AV10cal_par_valores ;
   private web.Sdtcal_par_valores_cal_par_valoresItem AV11itemCalParVal ;
}

final  class cargarsdtparametroscalculo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02042", "SELECT idOperando, PaiCod, CalParId, CalParCampo, CalParValLista, CalParGrp, CalParGrpDep, CalParObl, CalParDef, CalParNombre FROM Calculo_parametros WHERE PaiCod = ? and idOperando = ( ?) ORDER BY PaiCod, idOperando ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
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
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

