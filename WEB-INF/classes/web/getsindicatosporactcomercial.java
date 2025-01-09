package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsindicatosporactcomercial extends GXProcedure
{
   public getsindicatosporactcomercial( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsindicatosporactcomercial.class ), "" );
   }

   public getsindicatosporactcomercial( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( short aP0 ,
                                                 String aP1 )
   {
      getsindicatosporactcomercial.this.aP2 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        GXSimpleCollection<String>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             GXSimpleCollection<String>[] aP2 )
   {
      getsindicatosporactcomercial.this.AV10PaiCod = aP0;
      getsindicatosporactcomercial.this.AV9ActComCodigo = aP1;
      getsindicatosporactcomercial.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02LF2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV10PaiCod), AV9ActComCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A903ActComCodigo = P02LF2_A903ActComCodigo[0] ;
         A46PaiCod = P02LF2_A46PaiCod[0] ;
         A14SinCod = P02LF2_A14SinCod[0] ;
         AV8SinCod.add(GXutil.trim( A14SinCod), 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getsindicatosporactcomercial.this.AV8SinCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SinCod = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      P02LF2_A903ActComCodigo = new String[] {""} ;
      P02LF2_A46PaiCod = new short[1] ;
      P02LF2_A14SinCod = new String[] {""} ;
      A903ActComCodigo = "" ;
      A14SinCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsindicatosporactcomercial__default(),
         new Object[] {
             new Object[] {
            P02LF2_A903ActComCodigo, P02LF2_A46PaiCod, P02LF2_A14SinCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String AV9ActComCodigo ;
   private String scmdbuf ;
   private String A903ActComCodigo ;
   private String A14SinCod ;
   private GXSimpleCollection<String>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P02LF2_A903ActComCodigo ;
   private short[] P02LF2_A46PaiCod ;
   private String[] P02LF2_A14SinCod ;
   private GXSimpleCollection<String> AV8SinCod ;
}

final  class getsindicatosporactcomercial__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LF2", "SELECT ActComCodigo, PaiCod, SinCod FROM Sindicato WHERE (PaiCod = ?) AND (ActComCodigo = ( ?)) ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

