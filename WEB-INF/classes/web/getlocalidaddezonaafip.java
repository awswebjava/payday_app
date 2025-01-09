package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlocalidaddezonaafip extends GXProcedure
{
   public getlocalidaddezonaafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlocalidaddezonaafip.class ), "" );
   }

   public getlocalidaddezonaafip( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( short aP0 ,
                            String aP1 ,
                            short[] aP2 )
   {
      getlocalidaddezonaafip.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        short[] aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             short[] aP2 ,
                             short[] aP3 )
   {
      getlocalidaddezonaafip.this.AV10PaiCod = aP0;
      getlocalidaddezonaafip.this.AV8LocaZona = aP1;
      getlocalidaddezonaafip.this.aP2 = aP2;
      getlocalidaddezonaafip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P028M2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV10PaiCod), AV8LocaZona});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2207LocaZona = P028M2_A2207LocaZona[0] ;
         n2207LocaZona = P028M2_n2207LocaZona[0] ;
         A46PaiCod = P028M2_A46PaiCod[0] ;
         A47ProvCod = P028M2_A47ProvCod[0] ;
         A48LocCod = P028M2_A48LocCod[0] ;
         AV9ProvCod = A47ProvCod ;
         AV11LocCod = A48LocCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getlocalidaddezonaafip.this.AV9ProvCod;
      this.aP3[0] = getlocalidaddezonaafip.this.AV11LocCod;
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
      P028M2_A2207LocaZona = new String[] {""} ;
      P028M2_n2207LocaZona = new boolean[] {false} ;
      P028M2_A46PaiCod = new short[1] ;
      P028M2_A47ProvCod = new short[1] ;
      P028M2_A48LocCod = new short[1] ;
      A2207LocaZona = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlocalidaddezonaafip__default(),
         new Object[] {
             new Object[] {
            P028M2_A2207LocaZona, P028M2_n2207LocaZona, P028M2_A46PaiCod, P028M2_A47ProvCod, P028M2_A48LocCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10PaiCod ;
   private short AV9ProvCod ;
   private short AV11LocCod ;
   private short A46PaiCod ;
   private short A47ProvCod ;
   private short A48LocCod ;
   private short Gx_err ;
   private String AV8LocaZona ;
   private String scmdbuf ;
   private String A2207LocaZona ;
   private boolean n2207LocaZona ;
   private short[] aP3 ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P028M2_A2207LocaZona ;
   private boolean[] P028M2_n2207LocaZona ;
   private short[] P028M2_A46PaiCod ;
   private short[] P028M2_A47ProvCod ;
   private short[] P028M2_A48LocCod ;
}

final  class getlocalidaddezonaafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P028M2", "SELECT LocaZona, PaiCod, ProvCod, LocCod FROM Localidad WHERE (PaiCod = ?) AND (LocaZona = ( ?)) ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
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

