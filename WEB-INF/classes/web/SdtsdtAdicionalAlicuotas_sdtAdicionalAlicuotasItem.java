package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem extends GxUserType
{
   public SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem( )
   {
      this(  new ModelContext(SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem.class));
   }

   public SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem( ModelContext context )
   {
      super( context, "SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem");
   }

   public SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem( int remoteHandle ,
                                                              ModelContext context )
   {
      super( remoteHandle, context, "SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem");
   }

   public SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem( StructSdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPaiConve") )
            {
               gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdicod") )
            {
               gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcCod") )
            {
               gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcFor") )
            {
               gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcDes") )
            {
               gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOpcAli") )
            {
               gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "sdtAdicionalAlicuotas.sdtAdicionalAlicuotasItem" ;
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
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConvenio", gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdicod", gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiOpcCod", GXutil.trim( GXutil.str( gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiOpcFor", gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiOpcDes", gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiOpcAli", GXutil.trim( GXutil.strNoRound( gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali, 6, 4)));
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
      AddObjectProperty("CliPaiConve", gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve, false, false);
      AddObjectProperty("CliConvenio", gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio, false, false);
      AddObjectProperty("ConveAdicod", gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod, false, false);
      AddObjectProperty("ConveAdiOpcCod", gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod, false, false);
      AddObjectProperty("ConveAdiOpcFor", gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor, false, false);
      AddObjectProperty("ConveAdiOpcDes", gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes, false, false);
      AddObjectProperty("ConveAdiOpcAli", gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali, false, false);
   }

   public short getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve ;
   }

   public void setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve( short value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve = value ;
   }

   public String getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio ;
   }

   public void setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio( String value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio = value ;
   }

   public String getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod ;
   }

   public void setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod( String value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod = value ;
   }

   public short getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod ;
   }

   public void setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod( short value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod = value ;
   }

   public String getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor ;
   }

   public void setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor( String value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor = value ;
   }

   public String getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes ;
   }

   public void setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes( String value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes = value ;
   }

   public java.math.BigDecimal getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali ;
   }

   public void setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali( java.math.BigDecimal value )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N = (byte)(1) ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio = "" ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod = "" ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor = "" ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes = "" ;
      gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N ;
   }

   public web.SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem Clone( )
   {
      return (web.SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem struct )
   {
      setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve(struct.getClipaiconve());
      setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio(struct.getCliconvenio());
      setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod(struct.getConveadicod());
      setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod(struct.getConveadiopccod());
      setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor(struct.getConveadiopcfor());
      setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes(struct.getConveadiopcdes());
      setgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali(struct.getConveadiopcali());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem getStruct( )
   {
      web.StructSdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem struct = new web.StructSdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem ();
      struct.setClipaiconve(getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve());
      struct.setCliconvenio(getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio());
      struct.setConveadicod(getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod());
      struct.setConveadiopccod(getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod());
      struct.setConveadiopcfor(getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor());
      struct.setConveadiopcdes(getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes());
      struct.setConveadiopcali(getgxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali());
      return struct ;
   }

   protected byte gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_N ;
   protected short gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Clipaiconve ;
   protected short gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopccod ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcali ;
   protected String gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Cliconvenio ;
   protected String gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadicod ;
   protected String gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcfor ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtsdtAdicionalAlicuotas_sdtAdicionalAlicuotasItem_Conveadiopcdes ;
}

