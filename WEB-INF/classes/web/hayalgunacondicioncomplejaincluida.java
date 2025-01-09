package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayalgunacondicioncomplejaincluida extends GXProcedure
{
   public hayalgunacondicioncomplejaincluida( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayalgunacondicioncomplejaincluida.class ), "" );
   }

   public hayalgunacondicioncomplejaincluida( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             GXSimpleCollection<String> aP1 ,
                             boolean[] aP2 )
   {
      hayalgunacondicioncomplejaincluida.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( short aP0 ,
                        GXSimpleCollection<String> aP1 ,
                        boolean[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             GXSimpleCollection<String> aP1 ,
                             boolean[] aP2 ,
                             String[] aP3 )
   {
      hayalgunacondicioncomplejaincluida.this.AV8paicod = aP0;
      hayalgunacondicioncomplejaincluida.this.AV11excluirConCondicion = aP1;
      hayalgunacondicioncomplejaincluida.this.aP2 = aP2;
      hayalgunacondicioncomplejaincluida.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01SA2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8paicod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1779CondLiqBasica = P01SA2_A1779CondLiqBasica[0] ;
         A1757CondicionPais = P01SA2_A1757CondicionPais[0] ;
         A953ConCondicion = P01SA2_A953ConCondicion[0] ;
         A1758CondicionDescrip = P01SA2_A1758CondicionDescrip[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "RECORRE COND ", "")+GXutil.trim( A953ConCondicion)) ;
         AV9encuentra = false ;
         AV10e = (short)(1) ;
         while ( AV10e <= AV11excluirConCondicion.size() )
         {
            if ( GXutil.strcmp(GXutil.trim( A953ConCondicion), GXutil.trim( (String)AV11excluirConCondicion.elementAt(-1+AV10e))) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "ENCUENTRA ConCondicion ", "")+GXutil.trim( A953ConCondicion)) ;
               AV9encuentra = true ;
               if (true) break;
            }
            AV10e = (short)(AV10e+1) ;
         }
         if ( ! AV9encuentra )
         {
            AV12hayAlgunaCondicionComplejaIncluida = true ;
            AV13CondicionDescrip = A1758CondicionDescrip ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = hayalgunacondicioncomplejaincluida.this.AV12hayAlgunaCondicionComplejaIncluida;
      this.aP3[0] = hayalgunacondicioncomplejaincluida.this.AV13CondicionDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13CondicionDescrip = "" ;
      scmdbuf = "" ;
      P01SA2_A1779CondLiqBasica = new boolean[] {false} ;
      P01SA2_A1757CondicionPais = new short[1] ;
      P01SA2_A953ConCondicion = new String[] {""} ;
      P01SA2_A1758CondicionDescrip = new String[] {""} ;
      A953ConCondicion = "" ;
      A1758CondicionDescrip = "" ;
      AV17Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayalgunacondicioncomplejaincluida__default(),
         new Object[] {
             new Object[] {
            P01SA2_A1779CondLiqBasica, P01SA2_A1757CondicionPais, P01SA2_A953ConCondicion, P01SA2_A1758CondicionDescrip
            }
         }
      );
      AV17Pgmname = "hayAlgunaCondicionComplejaIncluida" ;
      /* GeneXus formulas. */
      AV17Pgmname = "hayAlgunaCondicionComplejaIncluida" ;
      Gx_err = (short)(0) ;
   }

   private short AV8paicod ;
   private short A1757CondicionPais ;
   private short AV10e ;
   private short Gx_err ;
   private String scmdbuf ;
   private String A953ConCondicion ;
   private String AV17Pgmname ;
   private boolean AV12hayAlgunaCondicionComplejaIncluida ;
   private boolean A1779CondLiqBasica ;
   private boolean AV9encuentra ;
   private String AV13CondicionDescrip ;
   private String A1758CondicionDescrip ;
   private String[] aP3 ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01SA2_A1779CondLiqBasica ;
   private short[] P01SA2_A1757CondicionPais ;
   private String[] P01SA2_A953ConCondicion ;
   private String[] P01SA2_A1758CondicionDescrip ;
   private GXSimpleCollection<String> AV11excluirConCondicion ;
}

final  class hayalgunacondicioncomplejaincluida__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01SA2", "SELECT CondLiqBasica, CondicionPais, ConCondicion, CondicionDescrip FROM Condiciones_concepto WHERE (CondicionPais = ?) AND (CondLiqBasica = FALSE) ORDER BY CondicionPais ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               return;
      }
   }

}

