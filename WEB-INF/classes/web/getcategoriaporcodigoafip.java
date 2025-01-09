package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcategoriaporcodigoafip extends GXProcedure
{
   public getcategoriaporcodigoafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcategoriaporcodigoafip.class ), "" );
   }

   public getcategoriaporcodigoafip( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 ,
                              String aP2 ,
                              String aP3 ,
                              String aP4 ,
                              String[] aP5 ,
                              String[] aP6 )
   {
      getcategoriaporcodigoafip.this.aP7 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        boolean[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             boolean[] aP7 )
   {
      getcategoriaporcodigoafip.this.AV10CliCod = aP0;
      getcategoriaporcodigoafip.this.AV14CliConveVer = aP1;
      getcategoriaporcodigoafip.this.AV12ConveCodigo = aP2;
      getcategoriaporcodigoafip.this.AV15CatAfipCod = aP3;
      getcategoriaporcodigoafip.this.AV19ZonCod = aP4;
      getcategoriaporcodigoafip.this.aP5 = aP5;
      getcategoriaporcodigoafip.this.aP6 = aP6;
      getcategoriaporcodigoafip.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV13PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV10CliCod, GXv_int2) ;
      getcategoriaporcodigoafip.this.GXt_int1 = GXv_int2[0] ;
      AV13PaiCod = GXt_int1 ;
      GXv_int2[0] = AV17CatProvCod ;
      new web.getprovinciadezona(remoteHandle, context).execute( AV13PaiCod, AV19ZonCod, GXv_int2) ;
      getcategoriaporcodigoafip.this.AV17CatProvCod = GXv_int2[0] ;
      if ( ! (0==AV17CatProvCod) )
      {
         /* Using cursor P025M2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliConveVer), Short.valueOf(AV13PaiCod), AV12ConveCodigo, AV15CatAfipCod});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A8CatCodigo = P025M2_A8CatCodigo[0] ;
            A1565CliConvenio = P025M2_A1565CliConvenio[0] ;
            A1564CliPaiConve = P025M2_A1564CliPaiConve[0] ;
            A3CliCod = P025M2_A3CliCod[0] ;
            A2198CatAfipCod = P025M2_A2198CatAfipCod[0] ;
            n2198CatAfipCod = P025M2_n2198CatAfipCod[0] ;
            A123CatDescrip = P025M2_A123CatDescrip[0] ;
            AV9CatDescrip = A123CatDescrip ;
            AV8CatCodigo = A8CatCodigo ;
            /* Using cursor P025M3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(AV13PaiCod), Short.valueOf(AV17CatProvCod)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A2201CatProvCod = P025M3_A2201CatProvCod[0] ;
               A2200CatPaiCod = P025M3_A2200CatPaiCod[0] ;
               AV11existe = true ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
            if ( AV11existe )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&PaiCod: ", "")+GXutil.trim( GXutil.str( AV13PaiCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&ZonCod: ", "")+GXutil.trim( AV19ZonCod)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&CatProvCod: ", "")+GXutil.trim( GXutil.str( AV17CatProvCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&CliConveVer: ", "")+GXutil.trim( GXutil.str( AV14CliConveVer, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&ConveCodigo: ", "")+GXutil.trim( AV12ConveCodigo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&CatAfipCod: ", "")+GXutil.trim( AV15CatAfipCod)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&CatDescrip: ", "")+GXutil.trim( AV9CatDescrip)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&CatCodigo: ", "")+GXutil.trim( AV8CatCodigo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&CatProvCod: ", "")+GXutil.trim( GXutil.str( AV17CatProvCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&existe: ", "")+GXutil.trim( GXutil.booltostr( AV11existe))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getcategoriaporcodigoafip.this.AV9CatDescrip;
      this.aP6[0] = getcategoriaporcodigoafip.this.AV8CatCodigo;
      this.aP7[0] = getcategoriaporcodigoafip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9CatDescrip = "" ;
      AV8CatCodigo = "" ;
      GXv_int2 = new short[1] ;
      scmdbuf = "" ;
      P025M2_A8CatCodigo = new String[] {""} ;
      P025M2_A1565CliConvenio = new String[] {""} ;
      P025M2_A1564CliPaiConve = new short[1] ;
      P025M2_A3CliCod = new int[1] ;
      P025M2_A2198CatAfipCod = new String[] {""} ;
      P025M2_n2198CatAfipCod = new boolean[] {false} ;
      P025M2_A123CatDescrip = new String[] {""} ;
      A8CatCodigo = "" ;
      A1565CliConvenio = "" ;
      A2198CatAfipCod = "" ;
      A123CatDescrip = "" ;
      P025M3_A3CliCod = new int[1] ;
      P025M3_A1564CliPaiConve = new short[1] ;
      P025M3_A1565CliConvenio = new String[] {""} ;
      P025M3_A8CatCodigo = new String[] {""} ;
      P025M3_A2201CatProvCod = new short[1] ;
      P025M3_A2200CatPaiCod = new short[1] ;
      AV25Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcategoriaporcodigoafip__default(),
         new Object[] {
             new Object[] {
            P025M2_A8CatCodigo, P025M2_A1565CliConvenio, P025M2_A1564CliPaiConve, P025M2_A3CliCod, P025M2_A2198CatAfipCod, P025M2_n2198CatAfipCod, P025M2_A123CatDescrip
            }
            , new Object[] {
            P025M3_A3CliCod, P025M3_A1564CliPaiConve, P025M3_A1565CliConvenio, P025M3_A8CatCodigo, P025M3_A2201CatProvCod, P025M3_A2200CatPaiCod
            }
         }
      );
      AV25Pgmname = "getCategoriaPorCodigoAfip" ;
      /* GeneXus formulas. */
      AV25Pgmname = "getCategoriaPorCodigoAfip" ;
      Gx_err = (short)(0) ;
   }

   private short AV13PaiCod ;
   private short GXt_int1 ;
   private short AV17CatProvCod ;
   private short GXv_int2[] ;
   private short A1564CliPaiConve ;
   private short A2201CatProvCod ;
   private short A2200CatPaiCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV14CliConveVer ;
   private int A3CliCod ;
   private String AV12ConveCodigo ;
   private String AV15CatAfipCod ;
   private String AV19ZonCod ;
   private String AV8CatCodigo ;
   private String scmdbuf ;
   private String A8CatCodigo ;
   private String A1565CliConvenio ;
   private String A2198CatAfipCod ;
   private String AV25Pgmname ;
   private boolean AV11existe ;
   private boolean n2198CatAfipCod ;
   private String AV9CatDescrip ;
   private String A123CatDescrip ;
   private boolean[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P025M2_A8CatCodigo ;
   private String[] P025M2_A1565CliConvenio ;
   private short[] P025M2_A1564CliPaiConve ;
   private int[] P025M2_A3CliCod ;
   private String[] P025M2_A2198CatAfipCod ;
   private boolean[] P025M2_n2198CatAfipCod ;
   private String[] P025M2_A123CatDescrip ;
   private int[] P025M3_A3CliCod ;
   private short[] P025M3_A1564CliPaiConve ;
   private String[] P025M3_A1565CliConvenio ;
   private String[] P025M3_A8CatCodigo ;
   private short[] P025M3_A2201CatProvCod ;
   private short[] P025M3_A2200CatPaiCod ;
}

final  class getcategoriaporcodigoafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025M2", "SELECT CatCodigo, CliConvenio, CliPaiConve, CliCod, CatAfipCod, CatDescrip FROM Categoria1 WHERE (CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?)) AND (CatAfipCod = ( ?)) ORDER BY CliCod, CliPaiConve, CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P025M3", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatProvCod, CatPaiCod FROM CategoriaProvincias WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatPaiCod = ? and CatProvCod = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 6);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 6);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
      }
   }

}

