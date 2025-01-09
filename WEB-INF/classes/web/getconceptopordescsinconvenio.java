package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptopordescsinconvenio extends GXProcedure
{
   public getconceptopordescsinconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptopordescsinconvenio.class ), "" );
   }

   public getconceptopordescsinconvenio( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      getconceptopordescsinconvenio.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      getconceptopordescsinconvenio.this.AV8CliCod = aP0;
      getconceptopordescsinconvenio.this.AV9ConDescrip = aP1;
      getconceptopordescsinconvenio.this.AV11conveConFormula = aP2;
      getconceptopordescsinconvenio.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV11conveConFormula ,
                                           A148ConFormula ,
                                           A41ConDescrip ,
                                           AV9ConDescrip ,
                                           A1645ConceptoConveCodigo ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV11conveConFormula = GXutil.concat( GXutil.rtrim( AV11conveConFormula), "%", "") ;
      /* Using cursor P01P52 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConDescrip, lV11conveConFormula});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A148ConFormula = P01P52_A148ConFormula[0] ;
         n148ConFormula = P01P52_n148ConFormula[0] ;
         A1645ConceptoConveCodigo = P01P52_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P01P52_n1645ConceptoConveCodigo[0] ;
         A41ConDescrip = P01P52_A41ConDescrip[0] ;
         A3CliCod = P01P52_A3CliCod[0] ;
         A26ConCodigo = P01P52_A26ConCodigo[0] ;
         AV10ConCodigo = A26ConCodigo ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getconceptopordescsinconvenio.this.AV10ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConCodigo = "" ;
      scmdbuf = "" ;
      lV11conveConFormula = "" ;
      A148ConFormula = "" ;
      A41ConDescrip = "" ;
      A1645ConceptoConveCodigo = "" ;
      P01P52_A148ConFormula = new String[] {""} ;
      P01P52_n148ConFormula = new boolean[] {false} ;
      P01P52_A1645ConceptoConveCodigo = new String[] {""} ;
      P01P52_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P01P52_A41ConDescrip = new String[] {""} ;
      P01P52_A3CliCod = new int[1] ;
      P01P52_A26ConCodigo = new String[] {""} ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptopordescsinconvenio__default(),
         new Object[] {
             new Object[] {
            P01P52_A148ConFormula, P01P52_n148ConFormula, P01P52_A1645ConceptoConveCodigo, P01P52_n1645ConceptoConveCodigo, P01P52_A41ConDescrip, P01P52_A3CliCod, P01P52_A26ConCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV10ConCodigo ;
   private String scmdbuf ;
   private String A1645ConceptoConveCodigo ;
   private String A26ConCodigo ;
   private boolean n148ConFormula ;
   private boolean n1645ConceptoConveCodigo ;
   private String AV11conveConFormula ;
   private String lV11conveConFormula ;
   private String A148ConFormula ;
   private String AV9ConDescrip ;
   private String A41ConDescrip ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01P52_A148ConFormula ;
   private boolean[] P01P52_n148ConFormula ;
   private String[] P01P52_A1645ConceptoConveCodigo ;
   private boolean[] P01P52_n1645ConceptoConveCodigo ;
   private String[] P01P52_A41ConDescrip ;
   private int[] P01P52_A3CliCod ;
   private String[] P01P52_A26ConCodigo ;
}

final  class getconceptopordescsinconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01P52( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV11conveConFormula ,
                                          String A148ConFormula ,
                                          String A41ConDescrip ,
                                          String AV9ConDescrip ,
                                          String A1645ConceptoConveCodigo ,
                                          int AV8CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[3];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT ConFormula, ConceptoConveCodigo, ConDescrip, CliCod, ConCodigo FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(LOWER(RTRIM(LTRIM(ConDescrip))) = ( LOWER(RTRIM(LTRIM(?)))))");
      addWhere(sWhereString, "((char_length(trim(trailing ' ' from ConceptoConveCodigo))=0) or ConceptoConveCodigo IS NULL)");
      if ( ! (GXutil.strcmp("", AV11conveConFormula)==0) )
      {
         addWhere(sWhereString, "(LOWER(ConFormula) like '%' || LOWER(RTRIM(LTRIM(?))))");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01P52(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01P52", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLongVarchar(sIdx, (String)parms[5]);
               }
               return;
      }
   }

}

