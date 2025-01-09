package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_escalaSalarial_sdt_escalaSalarialItem extends GxUserType
{
   public Sdtsdt_escalaSalarial_sdt_escalaSalarialItem( )
   {
      this(  new ModelContext(Sdtsdt_escalaSalarial_sdt_escalaSalarialItem.class));
   }

   public Sdtsdt_escalaSalarial_sdt_escalaSalarialItem( ModelContext context )
   {
      super( context, "Sdtsdt_escalaSalarial_sdt_escalaSalarialItem");
   }

   public Sdtsdt_escalaSalarial_sdt_escalaSalarialItem( int remoteHandle ,
                                                        ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_escalaSalarial_sdt_escalaSalarialItem");
   }

   public Sdtsdt_escalaSalarial_sdt_escalaSalarialItem( StructSdtsdt_escalaSalarial_sdt_escalaSalarialItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatCodigo") )
            {
               gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatVigencia") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia = GXutil.nullDate() ;
                  gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia_N = (byte)(0) ;
                  gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPaiConve") )
            {
               gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscBasico") )
            {
               gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscAdicional") )
            {
               gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "sdt_escalaSalarial.sdt_escalaSalarialItem" ;
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
      oWriter.writeElement("CliConvenio", gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatCodigo", gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia)) && ( gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia_N == 1 ) )
      {
         oWriter.writeElement("CatVigencia", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("CatVigencia", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EscBasico", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EscAdicional", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional, 14, 2)));
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
      AddObjectProperty("CliConvenio", gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio, false, false);
      AddObjectProperty("CatCodigo", gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("CatVigencia", sDateCnv, false, false);
      AddObjectProperty("CliPaiConve", gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve, false, false);
      AddObjectProperty("EscBasico", gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico, false, false);
      AddObjectProperty("EscAdicional", gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional, false, false);
   }

   public String getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio( )
   {
      return gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio ;
   }

   public void setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio( String value )
   {
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio = value ;
   }

   public String getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo( )
   {
      return gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo ;
   }

   public void setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo( String value )
   {
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia( )
   {
      return gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia ;
   }

   public void setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia( java.util.Date value )
   {
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia = value ;
   }

   public short getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve( )
   {
      return gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve ;
   }

   public void setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve( short value )
   {
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico( )
   {
      return gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico ;
   }

   public void setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional( )
   {
      return gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional ;
   }

   public void setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio = "" ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N = (byte)(1) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo = "" ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia = GXutil.nullDate() ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia_N = (byte)(1) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico = DecimalUtil.ZERO ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional = DecimalUtil.ZERO ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N ;
   }

   public web.Sdtsdt_escalaSalarial_sdt_escalaSalarialItem Clone( )
   {
      return (web.Sdtsdt_escalaSalarial_sdt_escalaSalarialItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_escalaSalarial_sdt_escalaSalarialItem struct )
   {
      setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio(struct.getCliconvenio());
      setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo(struct.getCatcodigo());
      if ( struct.gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia_N == 0 )
      {
         setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia(struct.getCatvigencia());
      }
      setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve(struct.getClipaiconve());
      setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico(struct.getEscbasico());
      setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional(struct.getEscadicional());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_escalaSalarial_sdt_escalaSalarialItem getStruct( )
   {
      web.StructSdtsdt_escalaSalarial_sdt_escalaSalarialItem struct = new web.StructSdtsdt_escalaSalarial_sdt_escalaSalarialItem ();
      struct.setCliconvenio(getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio());
      struct.setCatcodigo(getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo());
      if ( gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia_N == 0 )
      {
         struct.setCatvigencia(getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia());
      }
      struct.setClipaiconve(getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve());
      struct.setEscbasico(getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico());
      struct.setEscadicional(getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N ;
   protected byte gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia_N ;
   protected short gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico ;
   protected java.math.BigDecimal gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional ;
   protected String gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio ;
   protected String gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia ;
   protected boolean readElement ;
   protected boolean formatError ;
}

