package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getprovylocdezonaafip extends GXProcedure
{
   public getprovylocdezonaafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getprovylocdezonaafip.class ), "" );
   }

   public getprovylocdezonaafip( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( short aP0 ,
                            String aP1 ,
                            short[] aP2 )
   {
      getprovylocdezonaafip.this.aP3 = new short[] {0};
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
      getprovylocdezonaafip.this.AV11PaiCod = aP0;
      getprovylocdezonaafip.this.AV8ZonCod = aP1;
      getprovylocdezonaafip.this.aP2 = aP2;
      getprovylocdezonaafip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P025U2 */
      pr_default.execute(0, new Object[] {AV8ZonCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20ZonCod = P025U2_A20ZonCod[0] ;
         A2223ZonLocEs = P025U2_A2223ZonLocEs[0] ;
         if ( A2223ZonLocEs )
         {
            GXv_int1[0] = AV9ProvCod ;
            GXv_int2[0] = AV10LocCod ;
            new web.getlocalidaddezonaafip(remoteHandle, context).execute( AV11PaiCod, A20ZonCod, GXv_int1, GXv_int2) ;
            getprovylocdezonaafip.this.AV9ProvCod = GXv_int1[0] ;
            getprovylocdezonaafip.this.AV10LocCod = GXv_int2[0] ;
         }
         else
         {
            GXv_int2[0] = AV9ProvCod ;
            new web.getprovinciadezona(remoteHandle, context).execute( AV11PaiCod, A20ZonCod, GXv_int2) ;
            getprovylocdezonaafip.this.AV9ProvCod = GXv_int2[0] ;
            AV10LocCod = (short)(0) ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getprovylocdezonaafip.this.AV9ProvCod;
      this.aP3[0] = getprovylocdezonaafip.this.AV10LocCod;
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
      P025U2_A20ZonCod = new String[] {""} ;
      P025U2_A2223ZonLocEs = new boolean[] {false} ;
      A20ZonCod = "" ;
      GXv_int1 = new short[1] ;
      GXv_int2 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getprovylocdezonaafip__default(),
         new Object[] {
             new Object[] {
            P025U2_A20ZonCod, P025U2_A2223ZonLocEs
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11PaiCod ;
   private short AV9ProvCod ;
   private short AV10LocCod ;
   private short GXv_int1[] ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private String AV8ZonCod ;
   private String scmdbuf ;
   private String A20ZonCod ;
   private boolean A2223ZonLocEs ;
   private short[] aP3 ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P025U2_A20ZonCod ;
   private boolean[] P025U2_A2223ZonLocEs ;
}

final  class getprovylocdezonaafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025U2", "SELECT ZonCod, ZonLocEs FROM Zona WHERE ZonCod = ( ?) ORDER BY ZonCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
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
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

