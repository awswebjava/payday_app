package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getembargabilidadpordesc extends GXProcedure
{
   public getembargabilidadpordesc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getembargabilidadpordesc.class ), "" );
   }

   public getembargabilidadpordesc( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( short aP0 ,
                            String aP1 )
   {
      getembargabilidadpordesc.this.aP2 = new short[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        short[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             short[] aP2 )
   {
      getembargabilidadpordesc.this.AV8EmbarPaiCod = aP0;
      getembargabilidadpordesc.this.AV10EmbargaDescrip = aP1;
      getembargabilidadpordesc.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01AF2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8EmbarPaiCod), AV10EmbargaDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1162EmbargaDescrip = P01AF2_A1162EmbargaDescrip[0] ;
         A1160EmbarPaiCod = P01AF2_A1160EmbarPaiCod[0] ;
         A1161EmbargaSec = P01AF2_A1161EmbargaSec[0] ;
         AV9EmbargaSec = A1161EmbargaSec ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getembargabilidadpordesc.this.AV9EmbargaSec;
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
      P01AF2_A1162EmbargaDescrip = new String[] {""} ;
      P01AF2_A1160EmbarPaiCod = new short[1] ;
      P01AF2_A1161EmbargaSec = new short[1] ;
      A1162EmbargaDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getembargabilidadpordesc__default(),
         new Object[] {
             new Object[] {
            P01AF2_A1162EmbargaDescrip, P01AF2_A1160EmbarPaiCod, P01AF2_A1161EmbargaSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmbarPaiCod ;
   private short AV9EmbargaSec ;
   private short A1160EmbarPaiCod ;
   private short A1161EmbargaSec ;
   private short Gx_err ;
   private String scmdbuf ;
   private String AV10EmbargaDescrip ;
   private String A1162EmbargaDescrip ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01AF2_A1162EmbargaDescrip ;
   private short[] P01AF2_A1160EmbarPaiCod ;
   private short[] P01AF2_A1161EmbargaSec ;
}

final  class getembargabilidadpordesc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01AF2", "SELECT EmbargaDescrip, EmbarPaiCod, EmbargaSec FROM embargabilidad WHERE (EmbarPaiCod = ?) AND (EmbargaDescrip = ( ?)) ORDER BY EmbarPaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               stmt.setVarchar(2, (String)parms[1], 30);
               return;
      }
   }

}

