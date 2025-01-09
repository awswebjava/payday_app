package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getestadocivillikedescrip extends GXProcedure
{
   public getestadocivillikedescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getestadocivillikedescrip.class ), "" );
   }

   public getestadocivillikedescrip( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( short aP0 ,
                            String aP1 )
   {
      getestadocivillikedescrip.this.aP2 = new short[] {0};
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
      getestadocivillikedescrip.this.AV8EstaCivilPais = aP0;
      getestadocivillikedescrip.this.AV9EstaCivilDescrip = aP1;
      getestadocivillikedescrip.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      lV9EstaCivilDescrip = GXutil.concat( GXutil.rtrim( AV9EstaCivilDescrip), "%", "") ;
      /* Using cursor P01YZ2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8EstaCivilPais), lV9EstaCivilDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1749EstaCivilDescrip = P01YZ2_A1749EstaCivilDescrip[0] ;
         A1747EstaCivilPais = P01YZ2_A1747EstaCivilPais[0] ;
         A1748EstaCivilCod = P01YZ2_A1748EstaCivilCod[0] ;
         AV10EstaCivilCod = A1748EstaCivilCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&EstaCivilPais: ", "")+GXutil.trim( GXutil.str( AV8EstaCivilPais, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&EstaCivilDescrip: ", "")+GXutil.trim( AV9EstaCivilDescrip)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&EstaCivilCod: ", "")+GXutil.trim( GXutil.str( AV10EstaCivilCod, 4, 0))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getestadocivillikedescrip.this.AV10EstaCivilCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      lV9EstaCivilDescrip = "" ;
      scmdbuf = "" ;
      P01YZ2_A1749EstaCivilDescrip = new String[] {""} ;
      P01YZ2_A1747EstaCivilPais = new short[1] ;
      P01YZ2_A1748EstaCivilCod = new short[1] ;
      A1749EstaCivilDescrip = "" ;
      AV14Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getestadocivillikedescrip__default(),
         new Object[] {
             new Object[] {
            P01YZ2_A1749EstaCivilDescrip, P01YZ2_A1747EstaCivilPais, P01YZ2_A1748EstaCivilCod
            }
         }
      );
      AV14Pgmname = "getEstadoCivilLikeDescrip" ;
      /* GeneXus formulas. */
      AV14Pgmname = "getEstadoCivilLikeDescrip" ;
      Gx_err = (short)(0) ;
   }

   private short AV8EstaCivilPais ;
   private short AV10EstaCivilCod ;
   private short A1747EstaCivilPais ;
   private short A1748EstaCivilCod ;
   private short Gx_err ;
   private String scmdbuf ;
   private String AV14Pgmname ;
   private String AV9EstaCivilDescrip ;
   private String lV9EstaCivilDescrip ;
   private String A1749EstaCivilDescrip ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01YZ2_A1749EstaCivilDescrip ;
   private short[] P01YZ2_A1747EstaCivilPais ;
   private short[] P01YZ2_A1748EstaCivilCod ;
}

final  class getestadocivillikedescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01YZ2", "SELECT EstaCivilDescrip, EstaCivilPais, EstaCivilCod FROM Estados_civiles WHERE (EstaCivilPais = ?) AND (UPPER(EstaCivilDescrip) like '%' || UPPER(?)) ORDER BY EstaCivilPais  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

