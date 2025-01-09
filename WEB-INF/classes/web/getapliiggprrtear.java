package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getapliiggprrtear extends GXProcedure
{
   public getapliiggprrtear( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getapliiggprrtear.class ), "" );
   }

   public getapliiggprrtear( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 )
   {
      getapliiggprrtear.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String[] aP2 )
   {
      getapliiggprrtear.this.AV10CliCod = aP0;
      getapliiggprrtear.this.AV8AplIIGG = aP1;
      getapliiggprrtear.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))+httpContext.getMessage( " &AplIIGG ", "")+GXutil.trim( GXutil.str( AV8AplIIGG, 4, 0))) ;
      AV14GXLvl2 = (byte)(0) ;
      /* Using cursor P01742 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8AplIIGG)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1112AplIIGG = P01742_A1112AplIIGG[0] ;
         A3CliCod = P01742_A3CliCod[0] ;
         A1121AplIIGGPrrtear = P01742_A1121AplIIGGPrrtear[0] ;
         AV14GXLvl2 = (byte)(1) ;
         AV9AplIIGGPrrtear = A1121AplIIGGPrrtear ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "encuentra ", "")+A1121AplIIGGPrrtear) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV14GXLvl2 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "none", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "&AplIIGGPrrtear ", "")+GXutil.trim( AV9AplIIGGPrrtear)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getapliiggprrtear.this.AV9AplIIGGPrrtear;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9AplIIGGPrrtear = "" ;
      AV13Pgmname = "" ;
      scmdbuf = "" ;
      P01742_A1112AplIIGG = new short[1] ;
      P01742_A3CliCod = new int[1] ;
      P01742_A1121AplIIGGPrrtear = new String[] {""} ;
      A1121AplIIGGPrrtear = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getapliiggprrtear__default(),
         new Object[] {
             new Object[] {
            P01742_A1112AplIIGG, P01742_A3CliCod, P01742_A1121AplIIGGPrrtear
            }
         }
      );
      AV13Pgmname = "getAplIIGGPrrtear" ;
      /* GeneXus formulas. */
      AV13Pgmname = "getAplIIGGPrrtear" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14GXLvl2 ;
   private short AV8AplIIGG ;
   private short A1112AplIIGG ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV9AplIIGGPrrtear ;
   private String AV13Pgmname ;
   private String scmdbuf ;
   private String A1121AplIIGGPrrtear ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P01742_A1112AplIIGG ;
   private int[] P01742_A3CliCod ;
   private String[] P01742_A1121AplIIGGPrrtear ;
}

final  class getapliiggprrtear__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01742", "SELECT AplIIGG, CliCod, AplIIGGPrrtear FROM tipo_aplicacion_ganancias WHERE CliCod = ? and AplIIGG = ? ORDER BY CliCod, AplIIGG ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

