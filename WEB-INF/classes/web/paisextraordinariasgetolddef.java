package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paisextraordinariasgetolddef extends GXProcedure
{
   public paisextraordinariasgetolddef( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisextraordinariasgetolddef.class ), "" );
   }

   public paisextraordinariasgetolddef( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public web.SdtPaisExtraOrdinarias_old executeUdp( short aP0 ,
                                                     short aP1 )
   {
      paisextraordinariasgetolddef.this.aP2 = new web.SdtPaisExtraOrdinarias_old[] {new web.SdtPaisExtraOrdinarias_old()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        short aP1 ,
                        web.SdtPaisExtraOrdinarias_old[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             short aP1 ,
                             web.SdtPaisExtraOrdinarias_old[] aP2 )
   {
      paisextraordinariasgetolddef.this.AV9PaiCod = aP0;
      paisextraordinariasgetolddef.this.AV10PaiHsExSec = aP1;
      paisextraordinariasgetolddef.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01X52 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9PaiCod), Short.valueOf(AV10PaiHsExSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1332PaiHsExSec = P01X52_A1332PaiHsExSec[0] ;
         A46PaiCod = P01X52_A46PaiCod[0] ;
         A1977PaiExtraordOldDefault = P01X52_A1977PaiExtraordOldDefault[0] ;
         AV8PaisExtraOrdinarias_old.fromJSonString(A1977PaiExtraordOldDefault, null);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = paisextraordinariasgetolddef.this.AV8PaisExtraOrdinarias_old;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8PaisExtraOrdinarias_old = new web.SdtPaisExtraOrdinarias_old(remoteHandle, context);
      scmdbuf = "" ;
      P01X52_A1332PaiHsExSec = new short[1] ;
      P01X52_A46PaiCod = new short[1] ;
      P01X52_A1977PaiExtraordOldDefault = new String[] {""} ;
      A1977PaiExtraordOldDefault = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisextraordinariasgetolddef__default(),
         new Object[] {
             new Object[] {
            P01X52_A1332PaiHsExSec, P01X52_A46PaiCod, P01X52_A1977PaiExtraordOldDefault
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9PaiCod ;
   private short AV10PaiHsExSec ;
   private short A1332PaiHsExSec ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String scmdbuf ;
   private String A1977PaiExtraordOldDefault ;
   private web.SdtPaisExtraOrdinarias_old[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P01X52_A1332PaiHsExSec ;
   private short[] P01X52_A46PaiCod ;
   private String[] P01X52_A1977PaiExtraordOldDefault ;
   private web.SdtPaisExtraOrdinarias_old AV8PaisExtraOrdinarias_old ;
}

final  class paisextraordinariasgetolddef__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01X52", "SELECT PaiHsExSec, PaiCod, PaiExtraordOldDefault FROM Paishorasextras_pordia WHERE PaiCod = ? and PaiHsExSec = ? ORDER BY PaiCod, PaiHsExSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
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

