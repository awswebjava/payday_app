package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class categoriasdeconvenio extends GXProcedure
{
   public categoriasdeconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( categoriasdeconvenio.class ), "" );
   }

   public categoriasdeconvenio( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_categorias_sdt_categoriasItem> executeUdp( int aP0 ,
                                                                                 int aP1 ,
                                                                                 String aP2 ,
                                                                                 byte aP3 ,
                                                                                 short aP4 )
   {
      categoriasdeconvenio.this.aP5 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_categorias_sdt_categoriasItem>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        String aP2 ,
                        byte aP3 ,
                        short aP4 ,
                        GXBaseCollection<web.Sdtsdt_categorias_sdt_categoriasItem>[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             short aP4 ,
                             GXBaseCollection<web.Sdtsdt_categorias_sdt_categoriasItem>[] aP5 )
   {
      categoriasdeconvenio.this.AV12CliCod = aP0;
      categoriasdeconvenio.this.AV13CliConveVer = aP1;
      categoriasdeconvenio.this.AV8ConveCodigo = aP2;
      categoriasdeconvenio.this.AV16CatClase = aP3;
      categoriasdeconvenio.this.AV17ProvCod = aP4;
      categoriasdeconvenio.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV11PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV12CliCod, GXv_int2) ;
      categoriasdeconvenio.this.GXt_int1 = GXv_int2[0] ;
      AV11PaiCod = GXt_int1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "convecodigo ", "")+AV8ConveCodigo+httpContext.getMessage( " provcod ", "")+GXutil.trim( GXutil.str( AV17ProvCod, 4, 0))) ;
      AV22GXLvl3 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Byte.valueOf(AV16CatClase) ,
                                           Byte.valueOf(A1838CatClase) ,
                                           A1565CliConvenio ,
                                           AV8ConveCodigo ,
                                           Integer.valueOf(AV12CliCod) ,
                                           Short.valueOf(AV11PaiCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00YK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV11PaiCod), AV8ConveCodigo, Byte.valueOf(AV16CatClase)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00YK2_A3CliCod[0] ;
         A1564CliPaiConve = P00YK2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P00YK2_A1565CliConvenio[0] ;
         A1838CatClase = P00YK2_A1838CatClase[0] ;
         A2429CliConveEsquemaEs = P00YK2_A2429CliConveEsquemaEs[0] ;
         A8CatCodigo = P00YK2_A8CatCodigo[0] ;
         A123CatDescrip = P00YK2_A123CatDescrip[0] ;
         A2429CliConveEsquemaEs = P00YK2_A2429CliConveEsquemaEs[0] ;
         AV22GXLvl3 = (byte)(1) ;
         if ( A2429CliConveEsquemaEs )
         {
            AV18pertenece = true ;
         }
         else
         {
            if ( (0==AV17ProvCod) )
            {
               AV18pertenece = true ;
            }
            else
            {
               GXv_boolean3[0] = AV18pertenece ;
               new web.categoriaperteneceaprov(remoteHandle, context).execute( AV13CliConveVer, AV11PaiCod, AV8ConveCodigo, A8CatCodigo, AV17ProvCod, GXv_boolean3) ;
               categoriasdeconvenio.this.AV18pertenece = GXv_boolean3[0] ;
            }
         }
         if ( AV18pertenece )
         {
            AV10itemCat = (web.Sdtsdt_categorias_sdt_categoriasItem)new web.Sdtsdt_categorias_sdt_categoriasItem(remoteHandle, context);
            AV10itemCat.setgxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo( A8CatCodigo );
            AV10itemCat.setgxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip( A123CatDescrip );
            AV9sdt_categorias.add(AV10itemCat, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV22GXLvl3 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "convecodigo ", "")+GXutil.trim( AV8ConveCodigo)+httpContext.getMessage( " nono", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&CliConveVer: ", "")+GXutil.trim( GXutil.str( AV13CliConveVer, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&PaiCod: ", "")+GXutil.trim( GXutil.str( AV11PaiCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&ConveCodigo: ", "")+GXutil.trim( AV8ConveCodigo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&CatClase: ", "")+GXutil.trim( GXutil.str( AV16CatClase, 1, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&&ProvCod: ", "")+GXutil.trim( GXutil.str( AV17ProvCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&sdt_categorias: ", "")+GXutil.trim( GXutil.str( AV9sdt_categorias.size(), 9, 0))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = categoriasdeconvenio.this.AV9sdt_categorias;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9sdt_categorias = new GXBaseCollection<web.Sdtsdt_categorias_sdt_categoriasItem>(web.Sdtsdt_categorias_sdt_categoriasItem.class, "sdt_categoriasItem", "PayDay", remoteHandle);
      GXv_int2 = new short[1] ;
      AV21Pgmname = "" ;
      scmdbuf = "" ;
      A1565CliConvenio = "" ;
      P00YK2_A3CliCod = new int[1] ;
      P00YK2_A1564CliPaiConve = new short[1] ;
      P00YK2_A1565CliConvenio = new String[] {""} ;
      P00YK2_A1838CatClase = new byte[1] ;
      P00YK2_A2429CliConveEsquemaEs = new boolean[] {false} ;
      P00YK2_A8CatCodigo = new String[] {""} ;
      P00YK2_A123CatDescrip = new String[] {""} ;
      A8CatCodigo = "" ;
      A123CatDescrip = "" ;
      GXv_boolean3 = new boolean[1] ;
      AV10itemCat = new web.Sdtsdt_categorias_sdt_categoriasItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.categoriasdeconvenio__default(),
         new Object[] {
             new Object[] {
            P00YK2_A3CliCod, P00YK2_A1564CliPaiConve, P00YK2_A1565CliConvenio, P00YK2_A1838CatClase, P00YK2_A2429CliConveEsquemaEs, P00YK2_A8CatCodigo, P00YK2_A123CatDescrip
            }
         }
      );
      AV21Pgmname = "categoriasDeConvenio" ;
      /* GeneXus formulas. */
      AV21Pgmname = "categoriasDeConvenio" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16CatClase ;
   private byte AV22GXLvl3 ;
   private byte A1838CatClase ;
   private short AV17ProvCod ;
   private short AV11PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV13CliConveVer ;
   private int A3CliCod ;
   private String AV8ConveCodigo ;
   private String AV21Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private boolean A2429CliConveEsquemaEs ;
   private boolean AV18pertenece ;
   private boolean GXv_boolean3[] ;
   private String A123CatDescrip ;
   private GXBaseCollection<web.Sdtsdt_categorias_sdt_categoriasItem>[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P00YK2_A3CliCod ;
   private short[] P00YK2_A1564CliPaiConve ;
   private String[] P00YK2_A1565CliConvenio ;
   private byte[] P00YK2_A1838CatClase ;
   private boolean[] P00YK2_A2429CliConveEsquemaEs ;
   private String[] P00YK2_A8CatCodigo ;
   private String[] P00YK2_A123CatDescrip ;
   private GXBaseCollection<web.Sdtsdt_categorias_sdt_categoriasItem> AV9sdt_categorias ;
   private web.Sdtsdt_categorias_sdt_categoriasItem AV10itemCat ;
}

final  class categoriasdeconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00YK2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte AV16CatClase ,
                                          byte A1838CatClase ,
                                          String A1565CliConvenio ,
                                          String AV8ConveCodigo ,
                                          int AV12CliCod ,
                                          short AV11PaiCod ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[4];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.CatClase, T2.CliConveEsquemaEs, T1.CatCodigo, T1.CatDescrip FROM (Categoria1 T1 INNER JOIN ClienteConvenios" ;
      scmdbuf += " T2 ON T2.CliCod = T1.CliCod AND T2.CliPaiConve = T1.CliPaiConve AND T2.CliConvenio = T1.CliConvenio)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.CliPaiConve = ?)");
      addWhere(sWhereString, "(T1.CliConvenio = ( ?))");
      if ( ! (0==AV16CatClase) )
      {
         addWhere(sWhereString, "(T1.CatClase = ?)");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.CliPaiConve" ;
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
                  return conditional_P00YK2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , ((Number) dynConstraints[1]).byteValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00YK2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[7]).byteValue());
               }
               return;
      }
   }

}

