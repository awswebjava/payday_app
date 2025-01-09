package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTOperandosFormula extends GxUserType
{
   public SdtSDTOperandosFormula( )
   {
      this(  new ModelContext(SdtSDTOperandosFormula.class));
   }

   public SdtSDTOperandosFormula( ModelContext context )
   {
      super( context, "SdtSDTOperandosFormula");
   }

   public SdtSDTOperandosFormula( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTOperandosFormula");
   }

   public SdtSDTOperandosFormula( StructSdtSDTOperandosFormula struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "OperandoOriginal") )
            {
               gxTv_SdtSDTOperandosFormula_Operandooriginal = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OperandoCambiado") )
            {
               gxTv_SdtSDTOperandosFormula_Operandocambiado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "queEs") )
            {
               gxTv_SdtSDTOperandosFormula_Quees = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "i") )
            {
               gxTv_SdtSDTOperandosFormula_I = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "length") )
            {
               gxTv_SdtSDTOperandosFormula_Length = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Descripcion") )
            {
               gxTv_SdtSDTOperandosFormula_Descripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OperandoCambiado2") )
            {
               gxTv_SdtSDTOperandosFormula_Operandocambiado2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Nombre") )
            {
               gxTv_SdtSDTOperandosFormula_Nombre = oReader.getValue() ;
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
         sName = "SDTOperandosFormula" ;
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
      oWriter.writeElement("OperandoOriginal", gxTv_SdtSDTOperandosFormula_Operandooriginal);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OperandoCambiado", gxTv_SdtSDTOperandosFormula_Operandocambiado);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("queEs", gxTv_SdtSDTOperandosFormula_Quees);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("i", GXutil.trim( GXutil.str( gxTv_SdtSDTOperandosFormula_I, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("length", GXutil.trim( GXutil.str( gxTv_SdtSDTOperandosFormula_Length, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Descripcion", gxTv_SdtSDTOperandosFormula_Descripcion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OperandoCambiado2", gxTv_SdtSDTOperandosFormula_Operandocambiado2);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Nombre", gxTv_SdtSDTOperandosFormula_Nombre);
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
      AddObjectProperty("OperandoOriginal", gxTv_SdtSDTOperandosFormula_Operandooriginal, false, false);
      AddObjectProperty("OperandoCambiado", gxTv_SdtSDTOperandosFormula_Operandocambiado, false, false);
      AddObjectProperty("queEs", gxTv_SdtSDTOperandosFormula_Quees, false, false);
      AddObjectProperty("i", gxTv_SdtSDTOperandosFormula_I, false, false);
      AddObjectProperty("length", gxTv_SdtSDTOperandosFormula_Length, false, false);
      AddObjectProperty("Descripcion", gxTv_SdtSDTOperandosFormula_Descripcion, false, false);
      AddObjectProperty("OperandoCambiado2", gxTv_SdtSDTOperandosFormula_Operandocambiado2, false, false);
      AddObjectProperty("Nombre", gxTv_SdtSDTOperandosFormula_Nombre, false, false);
   }

   public String getgxTv_SdtSDTOperandosFormula_Operandooriginal( )
   {
      return gxTv_SdtSDTOperandosFormula_Operandooriginal ;
   }

   public void setgxTv_SdtSDTOperandosFormula_Operandooriginal( String value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Operandooriginal = value ;
   }

   public String getgxTv_SdtSDTOperandosFormula_Operandocambiado( )
   {
      return gxTv_SdtSDTOperandosFormula_Operandocambiado ;
   }

   public void setgxTv_SdtSDTOperandosFormula_Operandocambiado( String value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Operandocambiado = value ;
   }

   public String getgxTv_SdtSDTOperandosFormula_Quees( )
   {
      return gxTv_SdtSDTOperandosFormula_Quees ;
   }

   public void setgxTv_SdtSDTOperandosFormula_Quees( String value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Quees = value ;
   }

   public short getgxTv_SdtSDTOperandosFormula_I( )
   {
      return gxTv_SdtSDTOperandosFormula_I ;
   }

   public void setgxTv_SdtSDTOperandosFormula_I( short value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_I = value ;
   }

   public short getgxTv_SdtSDTOperandosFormula_Length( )
   {
      return gxTv_SdtSDTOperandosFormula_Length ;
   }

   public void setgxTv_SdtSDTOperandosFormula_Length( short value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Length = value ;
   }

   public String getgxTv_SdtSDTOperandosFormula_Descripcion( )
   {
      return gxTv_SdtSDTOperandosFormula_Descripcion ;
   }

   public void setgxTv_SdtSDTOperandosFormula_Descripcion( String value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Descripcion = value ;
   }

   public String getgxTv_SdtSDTOperandosFormula_Operandocambiado2( )
   {
      return gxTv_SdtSDTOperandosFormula_Operandocambiado2 ;
   }

   public void setgxTv_SdtSDTOperandosFormula_Operandocambiado2( String value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Operandocambiado2 = value ;
   }

   public String getgxTv_SdtSDTOperandosFormula_Nombre( )
   {
      return gxTv_SdtSDTOperandosFormula_Nombre ;
   }

   public void setgxTv_SdtSDTOperandosFormula_Nombre( String value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Nombre = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTOperandosFormula_Operandooriginal = "" ;
      gxTv_SdtSDTOperandosFormula_N = (byte)(1) ;
      gxTv_SdtSDTOperandosFormula_Operandocambiado = "" ;
      gxTv_SdtSDTOperandosFormula_Quees = "" ;
      gxTv_SdtSDTOperandosFormula_Descripcion = "" ;
      gxTv_SdtSDTOperandosFormula_Operandocambiado2 = "" ;
      gxTv_SdtSDTOperandosFormula_Nombre = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTOperandosFormula_N ;
   }

   public web.SdtSDTOperandosFormula Clone( )
   {
      return (web.SdtSDTOperandosFormula)(clone()) ;
   }

   public void setStruct( web.StructSdtSDTOperandosFormula struct )
   {
      setgxTv_SdtSDTOperandosFormula_Operandooriginal(struct.getOperandooriginal());
      setgxTv_SdtSDTOperandosFormula_Operandocambiado(struct.getOperandocambiado());
      setgxTv_SdtSDTOperandosFormula_Quees(struct.getQuees());
      setgxTv_SdtSDTOperandosFormula_I(struct.getI());
      setgxTv_SdtSDTOperandosFormula_Length(struct.getLength());
      setgxTv_SdtSDTOperandosFormula_Descripcion(struct.getDescripcion());
      setgxTv_SdtSDTOperandosFormula_Operandocambiado2(struct.getOperandocambiado2());
      setgxTv_SdtSDTOperandosFormula_Nombre(struct.getNombre());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtSDTOperandosFormula getStruct( )
   {
      web.StructSdtSDTOperandosFormula struct = new web.StructSdtSDTOperandosFormula ();
      struct.setOperandooriginal(getgxTv_SdtSDTOperandosFormula_Operandooriginal());
      struct.setOperandocambiado(getgxTv_SdtSDTOperandosFormula_Operandocambiado());
      struct.setQuees(getgxTv_SdtSDTOperandosFormula_Quees());
      struct.setI(getgxTv_SdtSDTOperandosFormula_I());
      struct.setLength(getgxTv_SdtSDTOperandosFormula_Length());
      struct.setDescripcion(getgxTv_SdtSDTOperandosFormula_Descripcion());
      struct.setOperandocambiado2(getgxTv_SdtSDTOperandosFormula_Operandocambiado2());
      struct.setNombre(getgxTv_SdtSDTOperandosFormula_Nombre());
      return struct ;
   }

   protected byte gxTv_SdtSDTOperandosFormula_N ;
   protected short gxTv_SdtSDTOperandosFormula_I ;
   protected short gxTv_SdtSDTOperandosFormula_Length ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtSDTOperandosFormula_Quees ;
   protected String gxTv_SdtSDTOperandosFormula_Nombre ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTOperandosFormula_Operandooriginal ;
   protected String gxTv_SdtSDTOperandosFormula_Operandocambiado ;
   protected String gxTv_SdtSDTOperandosFormula_Descripcion ;
   protected String gxTv_SdtSDTOperandosFormula_Operandocambiado2 ;
}

