package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconveniosactividadempresa extends GXProcedure
{
   public getconveniosactividadempresa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconveniosactividadempresa.class ), "" );
   }

   public getconveniosactividadempresa( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 short aP1 )
   {
      getconveniosactividadempresa.this.aP2 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        GXSimpleCollection<String>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             GXSimpleCollection<String>[] aP2 )
   {
      getconveniosactividadempresa.this.AV10CliCod = aP0;
      getconveniosactividadempresa.this.AV11EmpCod = aP1;
      getconveniosactividadempresa.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_objcol_char1[0] = AV9SinCod ;
      new web.getsindicatosactividadempresa(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, GXv_objcol_char1) ;
      AV9SinCod = GXv_objcol_char1[0] ;
      GXt_int2 = AV13PaiCod ;
      GXv_int3[0] = GXt_int2 ;
      new web.clientegetpais(remoteHandle, context).execute( AV10CliCod, GXv_int3) ;
      getconveniosactividadempresa.this.GXt_int2 = GXv_int3[0] ;
      AV13PaiCod = GXt_int2 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&PaiCod ", "")+GXutil.trim( GXutil.str( AV13PaiCod, 4, 0))+httpContext.getMessage( " clicod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))+httpContext.getMessage( " sincod ", "")+AV9SinCod.toJSonString(false)+httpContext.getMessage( " emp ", "")+GXutil.trim( GXutil.str( AV11EmpCod, 4, 0))) ;
      AV17GXLvl5 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A935ConveSinCod ,
                                           AV9SinCod ,
                                           Short.valueOf(AV13PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00YD2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV13PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A935ConveSinCod = P00YD2_A935ConveSinCod[0] ;
         n935ConveSinCod = P00YD2_n935ConveSinCod[0] ;
         A46PaiCod = P00YD2_A46PaiCod[0] ;
         A9ConveCodigo = P00YD2_A9ConveCodigo[0] ;
         AV17GXLvl5 = (byte)(1) ;
         AV12ConveCodigo.add(A9ConveCodigo, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV17GXLvl5 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconveniosactividadempresa.this.AV12ConveCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12ConveCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV9SinCod = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char1 = new GXSimpleCollection[1] ;
      GXv_int3 = new short[1] ;
      AV16Pgmname = "" ;
      scmdbuf = "" ;
      A935ConveSinCod = "" ;
      P00YD2_A935ConveSinCod = new String[] {""} ;
      P00YD2_n935ConveSinCod = new boolean[] {false} ;
      P00YD2_A46PaiCod = new short[1] ;
      P00YD2_A9ConveCodigo = new String[] {""} ;
      A9ConveCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconveniosactividadempresa__default(),
         new Object[] {
             new Object[] {
            P00YD2_A935ConveSinCod, P00YD2_n935ConveSinCod, P00YD2_A46PaiCod, P00YD2_A9ConveCodigo
            }
         }
      );
      AV16Pgmname = "getConveniosActividadEmpresa" ;
      /* GeneXus formulas. */
      AV16Pgmname = "getConveniosActividadEmpresa" ;
      Gx_err = (short)(0) ;
   }

   private byte AV17GXLvl5 ;
   private short AV11EmpCod ;
   private short AV13PaiCod ;
   private short GXt_int2 ;
   private short GXv_int3[] ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private String AV16Pgmname ;
   private String scmdbuf ;
   private String A935ConveSinCod ;
   private String A9ConveCodigo ;
   private boolean n935ConveSinCod ;
   private GXSimpleCollection<String>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00YD2_A935ConveSinCod ;
   private boolean[] P00YD2_n935ConveSinCod ;
   private short[] P00YD2_A46PaiCod ;
   private String[] P00YD2_A9ConveCodigo ;
   private GXSimpleCollection<String> AV12ConveCodigo ;
   private GXSimpleCollection<String> AV9SinCod ;
   private GXSimpleCollection<String> GXv_objcol_char1[] ;
}

final  class getconveniosactividadempresa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00YD2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A935ConveSinCod ,
                                          GXSimpleCollection<String> AV9SinCod ,
                                          short AV13PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT ConveSinCod, PaiCod, ConveCodigo FROM Convenio" ;
      addWhere(sWhereString, "(PaiCod = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV9SinCod, "ConveSinCod IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P00YD2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00YD2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[1]).shortValue());
               }
               return;
      }
   }

}

