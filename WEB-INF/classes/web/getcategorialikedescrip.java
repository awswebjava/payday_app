package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcategorialikedescrip extends GXProcedure
{
   public getcategorialikedescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcategorialikedescrip.class ), "" );
   }

   public getcategorialikedescrip( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String aP2 ,
                              String[] aP3 )
   {
      getcategorialikedescrip.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             boolean[] aP4 )
   {
      getcategorialikedescrip.this.AV10CliCod = aP0;
      getcategorialikedescrip.this.AV12ConveCodigo = aP1;
      getcategorialikedescrip.this.AV9CatDescrip = aP2;
      getcategorialikedescrip.this.aP3 = aP3;
      getcategorialikedescrip.this.aP4 = aP4;
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
      getcategorialikedescrip.this.GXt_int1 = GXv_int2[0] ;
      AV13PaiCod = GXt_int1 ;
      GXv_int3[0] = AV14CliConveVer ;
      new web.getversiondeconvenio(remoteHandle, context).execute( AV10CliCod, AV13PaiCod, AV12ConveCodigo, GXv_int3) ;
      getcategorialikedescrip.this.AV14CliConveVer = GXv_int3[0] ;
      lV9CatDescrip = GXutil.concat( GXutil.rtrim( AV9CatDescrip), "%", "") ;
      /* Using cursor P00M52 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliConveVer), Short.valueOf(AV13PaiCod), AV12ConveCodigo, lV9CatDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A676CatDescripSinAc = P00M52_A676CatDescripSinAc[0] ;
         A1565CliConvenio = P00M52_A1565CliConvenio[0] ;
         A1564CliPaiConve = P00M52_A1564CliPaiConve[0] ;
         A3CliCod = P00M52_A3CliCod[0] ;
         A8CatCodigo = P00M52_A8CatCodigo[0] ;
         AV8CatCodigo = A8CatCodigo ;
         AV11existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getcategorialikedescrip.this.AV8CatCodigo;
      this.aP4[0] = getcategorialikedescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CatCodigo = "" ;
      GXv_int2 = new short[1] ;
      GXv_int3 = new int[1] ;
      lV9CatDescrip = "" ;
      scmdbuf = "" ;
      P00M52_A676CatDescripSinAc = new String[] {""} ;
      P00M52_A1565CliConvenio = new String[] {""} ;
      P00M52_A1564CliPaiConve = new short[1] ;
      P00M52_A3CliCod = new int[1] ;
      P00M52_A8CatCodigo = new String[] {""} ;
      A676CatDescripSinAc = "" ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcategorialikedescrip__default(),
         new Object[] {
             new Object[] {
            P00M52_A676CatDescripSinAc, P00M52_A1565CliConvenio, P00M52_A1564CliPaiConve, P00M52_A3CliCod, P00M52_A8CatCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV14CliConveVer ;
   private int GXv_int3[] ;
   private int A3CliCod ;
   private String AV12ConveCodigo ;
   private String AV8CatCodigo ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private boolean AV11existe ;
   private String AV9CatDescrip ;
   private String lV9CatDescrip ;
   private String A676CatDescripSinAc ;
   private boolean[] aP4 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P00M52_A676CatDescripSinAc ;
   private String[] P00M52_A1565CliConvenio ;
   private short[] P00M52_A1564CliPaiConve ;
   private int[] P00M52_A3CliCod ;
   private String[] P00M52_A8CatCodigo ;
}

final  class getcategorialikedescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00M52", "SELECT CatDescripSinAc, CliConvenio, CliPaiConve, CliCod, CatCodigo FROM Categoria1 WHERE (CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?)) AND (CatDescripSinAc like '%' || ?) ORDER BY CliCod, CliPaiConve, CliConvenio  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
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
               stmt.setVarchar(4, (String)parms[3], 400);
               return;
      }
   }

}

