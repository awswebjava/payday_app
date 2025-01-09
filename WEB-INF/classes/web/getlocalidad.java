package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlocalidad extends GXProcedure
{
   public getlocalidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlocalidad.class ), "" );
   }

   public getlocalidad( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             short aP1 ,
                             short aP2 )
   {
      getlocalidad.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( short aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String[] aP3 )
   {
      getlocalidad.this.AV8PaiCod = aP0;
      getlocalidad.this.AV9ProvCod = aP1;
      getlocalidad.this.AV10LocCod = aP2;
      getlocalidad.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV12CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      getlocalidad.this.GXt_int1 = GXv_int2[0] ;
      AV12CliCod = GXt_int1 ;
      /* Using cursor P00AJ2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod), Short.valueOf(AV9ProvCod), Short.valueOf(AV10LocCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A48LocCod = P00AJ2_A48LocCod[0] ;
         A47ProvCod = P00AJ2_A47ProvCod[0] ;
         A46PaiCod = P00AJ2_A46PaiCod[0] ;
         A286LocNom = P00AJ2_A286LocNom[0] ;
         AV11LocNom = A286LocNom ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlocalidad.this.AV11LocNom;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11LocNom = "" ;
      GXv_int2 = new int[1] ;
      scmdbuf = "" ;
      P00AJ2_A48LocCod = new short[1] ;
      P00AJ2_A47ProvCod = new short[1] ;
      P00AJ2_A46PaiCod = new short[1] ;
      P00AJ2_A286LocNom = new String[] {""} ;
      A286LocNom = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlocalidad__default(),
         new Object[] {
             new Object[] {
            P00AJ2_A48LocCod, P00AJ2_A47ProvCod, P00AJ2_A46PaiCod, P00AJ2_A286LocNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8PaiCod ;
   private short AV9ProvCod ;
   private short AV10LocCod ;
   private short A48LocCod ;
   private short A47ProvCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private String scmdbuf ;
   private String AV11LocNom ;
   private String A286LocNom ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private short[] P00AJ2_A48LocCod ;
   private short[] P00AJ2_A47ProvCod ;
   private short[] P00AJ2_A46PaiCod ;
   private String[] P00AJ2_A286LocNom ;
}

final  class getlocalidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AJ2", "SELECT LocCod, ProvCod, PaiCod, LocNom FROM Localidad WHERE PaiCod = ? and ProvCod = ? and LocCod = ? ORDER BY PaiCod, ProvCod, LocCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

