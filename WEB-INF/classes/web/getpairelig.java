package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpairelig extends GXProcedure
{
   public getpairelig( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpairelig.class ), "" );
   }

   public getpairelig( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 )
   {
      getpairelig.this.aP1 = new String[] {""};
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
      getpairelig.this.AV8PaiCod = aP0;
      getpairelig.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01BR2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P01BR2_A46PaiCod[0] ;
         A1252PaiReligDefault = P01BR2_A1252PaiReligDefault[0] ;
         n1252PaiReligDefault = P01BR2_n1252PaiReligDefault[0] ;
         AV9PaiReligDefault = A1252PaiReligDefault ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpairelig.this.AV9PaiReligDefault;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9PaiReligDefault = "" ;
      scmdbuf = "" ;
      P01BR2_A46PaiCod = new short[1] ;
      P01BR2_A1252PaiReligDefault = new String[] {""} ;
      P01BR2_n1252PaiReligDefault = new boolean[] {false} ;
      A1252PaiReligDefault = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpairelig__default(),
         new Object[] {
             new Object[] {
            P01BR2_A46PaiCod, P01BR2_A1252PaiReligDefault, P01BR2_n1252PaiReligDefault
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String AV9PaiReligDefault ;
   private String scmdbuf ;
   private String A1252PaiReligDefault ;
   private boolean n1252PaiReligDefault ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P01BR2_A46PaiCod ;
   private String[] P01BR2_A1252PaiReligDefault ;
   private boolean[] P01BR2_n1252PaiReligDefault ;
}

final  class getpairelig__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BR2", "SELECT PaiCod, PaiReligDefault FROM Pais WHERE PaiCod = ? ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
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

