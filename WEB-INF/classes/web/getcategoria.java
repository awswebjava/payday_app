package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcategoria extends GXProcedure
{
   public getcategoria( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcategoria.class ), "" );
   }

   public getcategoria( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 ,
                              String aP2 ,
                              String aP3 ,
                              String[] aP4 )
   {
      getcategoria.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 )
   {
      getcategoria.this.AV10CliCod = aP0;
      getcategoria.this.AV14CliConveVer = aP1;
      getcategoria.this.AV12ConveCodigo = aP2;
      getcategoria.this.AV8CatCodigo = aP3;
      getcategoria.this.aP4 = aP4;
      getcategoria.this.aP5 = aP5;
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
      getcategoria.this.GXt_int1 = GXv_int2[0] ;
      AV13PaiCod = GXt_int1 ;
      /* Using cursor P009W2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliConveVer), Short.valueOf(AV13PaiCod), AV12ConveCodigo, AV8CatCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A8CatCodigo = P009W2_A8CatCodigo[0] ;
         A1565CliConvenio = P009W2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P009W2_A1564CliPaiConve[0] ;
         A3CliCod = P009W2_A3CliCod[0] ;
         A123CatDescrip = P009W2_A123CatDescrip[0] ;
         AV9CatDescrip = A123CatDescrip ;
         AV11existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getcategoria.this.AV9CatDescrip;
      this.aP5[0] = getcategoria.this.AV11existe;
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
      GXv_int2 = new short[1] ;
      scmdbuf = "" ;
      P009W2_A8CatCodigo = new String[] {""} ;
      P009W2_A1565CliConvenio = new String[] {""} ;
      P009W2_A1564CliPaiConve = new short[1] ;
      P009W2_A3CliCod = new int[1] ;
      P009W2_A123CatDescrip = new String[] {""} ;
      A8CatCodigo = "" ;
      A1565CliConvenio = "" ;
      A123CatDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcategoria__default(),
         new Object[] {
             new Object[] {
            P009W2_A8CatCodigo, P009W2_A1565CliConvenio, P009W2_A1564CliPaiConve, P009W2_A3CliCod, P009W2_A123CatDescrip
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
   private int A3CliCod ;
   private String AV12ConveCodigo ;
   private String AV8CatCodigo ;
   private String scmdbuf ;
   private String A8CatCodigo ;
   private String A1565CliConvenio ;
   private boolean AV11existe ;
   private String AV9CatDescrip ;
   private String A123CatDescrip ;
   private boolean[] aP5 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P009W2_A8CatCodigo ;
   private String[] P009W2_A1565CliConvenio ;
   private short[] P009W2_A1564CliPaiConve ;
   private int[] P009W2_A3CliCod ;
   private String[] P009W2_A123CatDescrip ;
}

final  class getcategoria__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P009W2", "SELECT CatCodigo, CliConvenio, CliPaiConve, CliCod, CatDescrip FROM Categoria1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
               stmt.setString(4, (String)parms[3], 40);
               return;
      }
   }

}

