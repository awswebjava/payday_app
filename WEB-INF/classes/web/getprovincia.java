package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getprovincia extends GXProcedure
{
   public getprovincia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getprovincia.class ), "" );
   }

   public getprovincia( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             short aP1 )
   {
      getprovincia.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        short aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             short aP1 ,
                             String[] aP2 )
   {
      getprovincia.this.AV10PaiCod = aP0;
      getprovincia.this.AV8ProvCod = aP1;
      getprovincia.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV11CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      getprovincia.this.GXt_int1 = GXv_int2[0] ;
      AV11CliCod = GXt_int1 ;
      /* Using cursor P00A92 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV10PaiCod), Short.valueOf(AV8ProvCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A47ProvCod = P00A92_A47ProvCod[0] ;
         A46PaiCod = P00A92_A46PaiCod[0] ;
         A322ProvNom = P00A92_A322ProvNom[0] ;
         AV9ProvNom = GXutil.trim( A322ProvNom) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getprovincia.this.AV9ProvNom;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ProvNom = "" ;
      GXv_int2 = new int[1] ;
      scmdbuf = "" ;
      P00A92_A47ProvCod = new short[1] ;
      P00A92_A46PaiCod = new short[1] ;
      P00A92_A322ProvNom = new String[] {""} ;
      A322ProvNom = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getprovincia__default(),
         new Object[] {
             new Object[] {
            P00A92_A47ProvCod, P00A92_A46PaiCod, P00A92_A322ProvNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10PaiCod ;
   private short AV8ProvCod ;
   private short A47ProvCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private String scmdbuf ;
   private String AV9ProvNom ;
   private String A322ProvNom ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P00A92_A47ProvCod ;
   private short[] P00A92_A46PaiCod ;
   private String[] P00A92_A322ProvNom ;
}

final  class getprovincia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00A92", "SELECT ProvCod, PaiCod, ProvNom FROM Provincia WHERE PaiCod = ? and ProvCod = ? ORDER BY PaiCod, ProvCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

