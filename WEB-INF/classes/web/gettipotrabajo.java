package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipotrabajo extends GXProcedure
{
   public gettipotrabajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipotrabajo.class ), "" );
   }

   public gettipotrabajo( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      gettipotrabajo.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      gettipotrabajo.this.AV11PaiCod = aP0;
      gettipotrabajo.this.AV10PaiTipoTraId = aP1;
      gettipotrabajo.this.aP2 = aP2;
      gettipotrabajo.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8existe = false ;
      /* Using cursor P021H2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV11PaiCod), AV10PaiTipoTraId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1292TipoTraId = P021H2_A1292TipoTraId[0] ;
         A1293TipoTraNom = P021H2_A1293TipoTraNom[0] ;
         A1294PaiTipoTraId = P021H2_A1294PaiTipoTraId[0] ;
         A46PaiCod = P021H2_A46PaiCod[0] ;
         AV9PaiTipoTraNom = A1295PaiTipoTraNom ;
         AV8existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = gettipotrabajo.this.AV9PaiTipoTraNom;
      this.aP3[0] = gettipotrabajo.this.AV8existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9PaiTipoTraNom = "" ;
      scmdbuf = "" ;
      P021H2_A1292TipoTraId = new String[] {""} ;
      P021H2_A1293TipoTraNom = new String[] {""} ;
      P021H2_A1294PaiTipoTraId = new String[] {""} ;
      P021H2_A46PaiCod = new short[1] ;
      A1292TipoTraId = "" ;
      A1293TipoTraNom = "" ;
      A1294PaiTipoTraId = "" ;
      A1295PaiTipoTraNom = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettipotrabajo__default(),
         new Object[] {
             new Object[] {
            P021H2_A1292TipoTraId, P021H2_A1293TipoTraNom, P021H2_A1294PaiTipoTraId, P021H2_A46PaiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String AV10PaiTipoTraId ;
   private String scmdbuf ;
   private String A1292TipoTraId ;
   private String A1294PaiTipoTraId ;
   private boolean AV8existe ;
   private String AV9PaiTipoTraNom ;
   private String A1293TipoTraNom ;
   private String A1295PaiTipoTraNom ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P021H2_A1292TipoTraId ;
   private String[] P021H2_A1293TipoTraNom ;
   private String[] P021H2_A1294PaiTipoTraId ;
   private short[] P021H2_A46PaiCod ;
}

final  class gettipotrabajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P021H2", "SELECT T2.TipoTraId, T2.TipoTraNom, T1.PaiTipoTraId, T1.PaiCod FROM (PaisTipoTrabajo T1 INNER JOIN TipoTrabajo T2 ON T2.TipoTraId = T1.PaiTipoTraId) WHERE T1.PaiCod = ? and T1.PaiTipoTraId = ( ?) ORDER BY T1.PaiCod, T1.PaiTipoTraId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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

