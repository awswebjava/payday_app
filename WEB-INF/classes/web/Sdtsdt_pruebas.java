package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_pruebas extends GxUserType
{
   public Sdtsdt_pruebas( )
   {
      this(  new ModelContext(Sdtsdt_pruebas.class));
   }

   public Sdtsdt_pruebas( ModelContext context )
   {
      super( context, "Sdtsdt_pruebas");
   }

   public Sdtsdt_pruebas( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_pruebas");
   }

   public Sdtsdt_pruebas( StructSdtsdt_pruebas struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "nombre") )
            {
               gxTv_Sdtsdt_pruebas_Nombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Descripcion") )
            {
               gxTv_Sdtsdt_pruebas_Descripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "nro") )
            {
               gxTv_Sdtsdt_pruebas_Nro = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TestLegNumero1") )
            {
               gxTv_Sdtsdt_pruebas_Testlegnumero1 = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TestLegNumero2") )
            {
               gxTv_Sdtsdt_pruebas_Testlegnumero2 = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TestNro2") )
            {
               gxTv_Sdtsdt_pruebas_Testnro2 = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TestProbarTodos") )
            {
               gxTv_Sdtsdt_pruebas_Testprobartodos = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TestBono") )
            {
               gxTv_Sdtsdt_pruebas_Testbono = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "iigg") )
            {
               gxTv_Sdtsdt_pruebas_Iigg = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "sdt_pruebas" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("nombre", gxTv_Sdtsdt_pruebas_Nombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Descripcion", gxTv_Sdtsdt_pruebas_Descripcion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("nro", GXutil.trim( GXutil.str( gxTv_Sdtsdt_pruebas_Nro, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TestLegNumero1", GXutil.trim( GXutil.str( gxTv_Sdtsdt_pruebas_Testlegnumero1, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TestLegNumero2", GXutil.trim( GXutil.str( gxTv_Sdtsdt_pruebas_Testlegnumero2, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TestNro2", GXutil.trim( GXutil.str( gxTv_Sdtsdt_pruebas_Testnro2, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TestProbarTodos", GXutil.booltostr( gxTv_Sdtsdt_pruebas_Testprobartodos));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TestBono", GXutil.booltostr( gxTv_Sdtsdt_pruebas_Testbono));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("iigg", GXutil.booltostr( gxTv_Sdtsdt_pruebas_Iigg));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("nombre", gxTv_Sdtsdt_pruebas_Nombre, false, false);
      AddObjectProperty("Descripcion", gxTv_Sdtsdt_pruebas_Descripcion, false, false);
      AddObjectProperty("nro", gxTv_Sdtsdt_pruebas_Nro, false, false);
      AddObjectProperty("TestLegNumero1", gxTv_Sdtsdt_pruebas_Testlegnumero1, false, false);
      AddObjectProperty("TestLegNumero2", gxTv_Sdtsdt_pruebas_Testlegnumero2, false, false);
      AddObjectProperty("TestNro2", gxTv_Sdtsdt_pruebas_Testnro2, false, false);
      AddObjectProperty("TestProbarTodos", gxTv_Sdtsdt_pruebas_Testprobartodos, false, false);
      AddObjectProperty("TestBono", gxTv_Sdtsdt_pruebas_Testbono, false, false);
      AddObjectProperty("iigg", gxTv_Sdtsdt_pruebas_Iigg, false, false);
   }

   public String getgxTv_Sdtsdt_pruebas_Nombre( )
   {
      return gxTv_Sdtsdt_pruebas_Nombre ;
   }

   public void setgxTv_Sdtsdt_pruebas_Nombre( String value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Nombre = value ;
   }

   public String getgxTv_Sdtsdt_pruebas_Descripcion( )
   {
      return gxTv_Sdtsdt_pruebas_Descripcion ;
   }

   public void setgxTv_Sdtsdt_pruebas_Descripcion( String value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Descripcion = value ;
   }

   public short getgxTv_Sdtsdt_pruebas_Nro( )
   {
      return gxTv_Sdtsdt_pruebas_Nro ;
   }

   public void setgxTv_Sdtsdt_pruebas_Nro( short value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Nro = value ;
   }

   public int getgxTv_Sdtsdt_pruebas_Testlegnumero1( )
   {
      return gxTv_Sdtsdt_pruebas_Testlegnumero1 ;
   }

   public void setgxTv_Sdtsdt_pruebas_Testlegnumero1( int value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Testlegnumero1 = value ;
   }

   public int getgxTv_Sdtsdt_pruebas_Testlegnumero2( )
   {
      return gxTv_Sdtsdt_pruebas_Testlegnumero2 ;
   }

   public void setgxTv_Sdtsdt_pruebas_Testlegnumero2( int value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Testlegnumero2 = value ;
   }

   public short getgxTv_Sdtsdt_pruebas_Testnro2( )
   {
      return gxTv_Sdtsdt_pruebas_Testnro2 ;
   }

   public void setgxTv_Sdtsdt_pruebas_Testnro2( short value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Testnro2 = value ;
   }

   public boolean getgxTv_Sdtsdt_pruebas_Testprobartodos( )
   {
      return gxTv_Sdtsdt_pruebas_Testprobartodos ;
   }

   public void setgxTv_Sdtsdt_pruebas_Testprobartodos( boolean value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Testprobartodos = value ;
   }

   public boolean getgxTv_Sdtsdt_pruebas_Testbono( )
   {
      return gxTv_Sdtsdt_pruebas_Testbono ;
   }

   public void setgxTv_Sdtsdt_pruebas_Testbono( boolean value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Testbono = value ;
   }

   public boolean getgxTv_Sdtsdt_pruebas_Iigg( )
   {
      return gxTv_Sdtsdt_pruebas_Iigg ;
   }

   public void setgxTv_Sdtsdt_pruebas_Iigg( boolean value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Iigg = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_pruebas_Nombre = "" ;
      gxTv_Sdtsdt_pruebas_N = (byte)(1) ;
      gxTv_Sdtsdt_pruebas_Descripcion = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_pruebas_N ;
   }

   public web.Sdtsdt_pruebas Clone( )
   {
      return (web.Sdtsdt_pruebas)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_pruebas struct )
   {
      setgxTv_Sdtsdt_pruebas_Nombre(struct.getNombre());
      setgxTv_Sdtsdt_pruebas_Descripcion(struct.getDescripcion());
      setgxTv_Sdtsdt_pruebas_Nro(struct.getNro());
      setgxTv_Sdtsdt_pruebas_Testlegnumero1(struct.getTestlegnumero1());
      setgxTv_Sdtsdt_pruebas_Testlegnumero2(struct.getTestlegnumero2());
      setgxTv_Sdtsdt_pruebas_Testnro2(struct.getTestnro2());
      setgxTv_Sdtsdt_pruebas_Testprobartodos(struct.getTestprobartodos());
      setgxTv_Sdtsdt_pruebas_Testbono(struct.getTestbono());
      setgxTv_Sdtsdt_pruebas_Iigg(struct.getIigg());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_pruebas getStruct( )
   {
      web.StructSdtsdt_pruebas struct = new web.StructSdtsdt_pruebas ();
      struct.setNombre(getgxTv_Sdtsdt_pruebas_Nombre());
      struct.setDescripcion(getgxTv_Sdtsdt_pruebas_Descripcion());
      struct.setNro(getgxTv_Sdtsdt_pruebas_Nro());
      struct.setTestlegnumero1(getgxTv_Sdtsdt_pruebas_Testlegnumero1());
      struct.setTestlegnumero2(getgxTv_Sdtsdt_pruebas_Testlegnumero2());
      struct.setTestnro2(getgxTv_Sdtsdt_pruebas_Testnro2());
      struct.setTestprobartodos(getgxTv_Sdtsdt_pruebas_Testprobartodos());
      struct.setTestbono(getgxTv_Sdtsdt_pruebas_Testbono());
      struct.setIigg(getgxTv_Sdtsdt_pruebas_Iigg());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_pruebas_N ;
   protected short gxTv_Sdtsdt_pruebas_Nro ;
   protected short gxTv_Sdtsdt_pruebas_Testnro2 ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtsdt_pruebas_Testlegnumero1 ;
   protected int gxTv_Sdtsdt_pruebas_Testlegnumero2 ;
   protected String gxTv_Sdtsdt_pruebas_Nombre ;
   protected String sTagName ;
   protected boolean gxTv_Sdtsdt_pruebas_Testprobartodos ;
   protected boolean gxTv_Sdtsdt_pruebas_Testbono ;
   protected boolean gxTv_Sdtsdt_pruebas_Iigg ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_pruebas_Descripcion ;
}

