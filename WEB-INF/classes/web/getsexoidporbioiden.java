package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsexoidporbioiden extends GXProcedure
{
   public getsexoidporbioiden( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsexoidporbioiden.class ), "" );
   }

   public getsexoidporbioiden( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              String aP1 ,
                              String aP2 ,
                              byte[] aP3 )
   {
      getsexoidporbioiden.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        String aP2 ,
                        byte[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte[] aP3 ,
                             boolean[] aP4 )
   {
      getsexoidporbioiden.this.AV10PaiCod = aP0;
      getsexoidporbioiden.this.AV11SexoBiologico = aP1;
      getsexoidporbioiden.this.AV12SexoIdentidad = aP2;
      getsexoidporbioiden.this.aP3 = aP3;
      getsexoidporbioiden.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01Z12 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV10PaiCod), AV11SexoBiologico, AV12SexoIdentidad});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1746SexoIdentidad = P01Z12_A1746SexoIdentidad[0] ;
         A1745SexoBiologico = P01Z12_A1745SexoBiologico[0] ;
         n1745SexoBiologico = P01Z12_n1745SexoBiologico[0] ;
         A1742SexoPaiCod = P01Z12_A1742SexoPaiCod[0] ;
         A1743SexoId = P01Z12_A1743SexoId[0] ;
         AV8SexoId = A1743SexoId ;
         AV9hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getsexoidporbioiden.this.AV8SexoId;
      this.aP4[0] = getsexoidporbioiden.this.AV9hay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P01Z12_A1746SexoIdentidad = new String[] {""} ;
      P01Z12_A1745SexoBiologico = new String[] {""} ;
      P01Z12_n1745SexoBiologico = new boolean[] {false} ;
      P01Z12_A1742SexoPaiCod = new short[1] ;
      P01Z12_A1743SexoId = new byte[1] ;
      A1746SexoIdentidad = "" ;
      A1745SexoBiologico = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsexoidporbioiden__default(),
         new Object[] {
             new Object[] {
            P01Z12_A1746SexoIdentidad, P01Z12_A1745SexoBiologico, P01Z12_n1745SexoBiologico, P01Z12_A1742SexoPaiCod, P01Z12_A1743SexoId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8SexoId ;
   private byte A1743SexoId ;
   private short AV10PaiCod ;
   private short A1742SexoPaiCod ;
   private short Gx_err ;
   private String AV11SexoBiologico ;
   private String AV12SexoIdentidad ;
   private String scmdbuf ;
   private String A1746SexoIdentidad ;
   private String A1745SexoBiologico ;
   private boolean AV9hay ;
   private boolean n1745SexoBiologico ;
   private boolean[] aP4 ;
   private byte[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01Z12_A1746SexoIdentidad ;
   private String[] P01Z12_A1745SexoBiologico ;
   private boolean[] P01Z12_n1745SexoBiologico ;
   private short[] P01Z12_A1742SexoPaiCod ;
   private byte[] P01Z12_A1743SexoId ;
}

final  class getsexoidporbioiden__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01Z12", "SELECT SexoIdentidad, SexoBiologico, SexoPaiCod, SexoId FROM Sexos WHERE (SexoPaiCod = ?) AND (SexoBiologico = ( ?)) AND (SexoIdentidad = ( ?)) ORDER BY SexoPaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((byte[]) buf[4])[0] = rslt.getByte(4);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

