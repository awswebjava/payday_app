package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsindicatodeconvenio extends GXProcedure
{
   public getsindicatodeconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsindicatodeconvenio.class ), "" );
   }

   public getsindicatodeconvenio( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             String aP1 )
   {
      getsindicatodeconvenio.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getsindicatodeconvenio.this.AV9PaiCod = aP0;
      getsindicatodeconvenio.this.AV10ConveCodigo = aP1;
      getsindicatodeconvenio.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P025F2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9PaiCod), AV10ConveCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A9ConveCodigo = P025F2_A9ConveCodigo[0] ;
         A46PaiCod = P025F2_A46PaiCod[0] ;
         A935ConveSinCod = P025F2_A935ConveSinCod[0] ;
         n935ConveSinCod = P025F2_n935ConveSinCod[0] ;
         AV8ConveSinCod = A935ConveSinCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getsindicatodeconvenio.this.AV8ConveSinCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ConveSinCod = "" ;
      scmdbuf = "" ;
      P025F2_A9ConveCodigo = new String[] {""} ;
      P025F2_A46PaiCod = new short[1] ;
      P025F2_A935ConveSinCod = new String[] {""} ;
      P025F2_n935ConveSinCod = new boolean[] {false} ;
      A9ConveCodigo = "" ;
      A935ConveSinCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsindicatodeconvenio__default(),
         new Object[] {
             new Object[] {
            P025F2_A9ConveCodigo, P025F2_A46PaiCod, P025F2_A935ConveSinCod, P025F2_n935ConveSinCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String AV10ConveCodigo ;
   private String AV8ConveSinCod ;
   private String scmdbuf ;
   private String A9ConveCodigo ;
   private String A935ConveSinCod ;
   private boolean n935ConveSinCod ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P025F2_A9ConveCodigo ;
   private short[] P025F2_A46PaiCod ;
   private String[] P025F2_A935ConveSinCod ;
   private boolean[] P025F2_n935ConveSinCod ;
}

final  class getsindicatodeconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025F2", "SELECT ConveCodigo, PaiCod, ConveSinCod FROM Convenio WHERE PaiCod = ? and ConveCodigo = ( ?) ORDER BY PaiCod, ConveCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
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

