package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpais extends GXProcedure
{
   public getpais( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpais.class ), "" );
   }

   public getpais( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 )
   {
      getpais.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             String[] aP1 )
   {
      getpais.this.AV8Paicod = aP0;
      getpais.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00AA2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8Paicod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P00AA2_A46PaiCod[0] ;
         A312PaiNom = P00AA2_A312PaiNom[0] ;
         AV9PaiNom = GXutil.trim( A312PaiNom) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpais.this.AV9PaiNom;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9PaiNom = "" ;
      scmdbuf = "" ;
      P00AA2_A46PaiCod = new short[1] ;
      P00AA2_A312PaiNom = new String[] {""} ;
      A312PaiNom = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpais__default(),
         new Object[] {
             new Object[] {
            P00AA2_A46PaiCod, P00AA2_A312PaiNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8Paicod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String scmdbuf ;
   private String AV9PaiNom ;
   private String A312PaiNom ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P00AA2_A46PaiCod ;
   private String[] P00AA2_A312PaiNom ;
}

final  class getpais__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AA2", "SELECT PaiCod, PaiNom FROM Pais WHERE PaiCod = ? ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
               return;
      }
   }

}

