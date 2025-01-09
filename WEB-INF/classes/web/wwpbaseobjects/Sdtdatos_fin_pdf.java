package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtdatos_fin_pdf extends GxUserType
{
   public Sdtdatos_fin_pdf( )
   {
      this(  new ModelContext(Sdtdatos_fin_pdf.class));
   }

   public Sdtdatos_fin_pdf( ModelContext context )
   {
      super( context, "Sdtdatos_fin_pdf");
   }

   public Sdtdatos_fin_pdf( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "Sdtdatos_fin_pdf");
   }

   public Sdtdatos_fin_pdf( StructSdtdatos_fin_pdf struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_Sdtdatos_fin_pdf_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtdatos_fin_pdf_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNro") )
            {
               gxTv_Sdtdatos_fin_pdf_Liqnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLote") )
            {
               gxTv_Sdtdatos_fin_pdf_Liqlote = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "tpoRecibo") )
            {
               gxTv_Sdtdatos_fin_pdf_Tporecibo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "error") )
            {
               gxTv_Sdtdatos_fin_pdf_Error = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "daemonUUID") )
            {
               gxTv_Sdtdatos_fin_pdf_Daemonuuid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               if ( gxTv_Sdtdatos_fin_pdf_Legnumero == null )
               {
                  gxTv_Sdtdatos_fin_pdf_Legnumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtdatos_fin_pdf_Legnumero.readxmlcollection(oReader, "LegNumero", "Item") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
               {
                  GXSoapError = oReader.read() ;
               }
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
         sName = "datos_fin_pdf" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtdatos_fin_pdf_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtdatos_fin_pdf_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqNro", GXutil.trim( GXutil.str( gxTv_Sdtdatos_fin_pdf_Liqnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLote", gxTv_Sdtdatos_fin_pdf_Liqlote);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("tpoRecibo", gxTv_Sdtdatos_fin_pdf_Tporecibo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("error", gxTv_Sdtdatos_fin_pdf_Error);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("daemonUUID", gxTv_Sdtdatos_fin_pdf_Daemonuuid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_Sdtdatos_fin_pdf_Legnumero != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_Sdtdatos_fin_pdf_Legnumero.writexmlcollection(oWriter, "LegNumero", sNameSpace1, "Item", sNameSpace1);
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
      AddObjectProperty("CliCod", gxTv_Sdtdatos_fin_pdf_Clicod, false, false);
      AddObjectProperty("EmpCod", gxTv_Sdtdatos_fin_pdf_Empcod, false, false);
      AddObjectProperty("LiqNro", gxTv_Sdtdatos_fin_pdf_Liqnro, false, false);
      AddObjectProperty("LiqLote", gxTv_Sdtdatos_fin_pdf_Liqlote, false, false);
      AddObjectProperty("tpoRecibo", gxTv_Sdtdatos_fin_pdf_Tporecibo, false, false);
      AddObjectProperty("error", gxTv_Sdtdatos_fin_pdf_Error, false, false);
      AddObjectProperty("daemonUUID", gxTv_Sdtdatos_fin_pdf_Daemonuuid, false, false);
      if ( gxTv_Sdtdatos_fin_pdf_Legnumero != null )
      {
         AddObjectProperty("LegNumero", gxTv_Sdtdatos_fin_pdf_Legnumero, false, false);
      }
   }

   public int getgxTv_Sdtdatos_fin_pdf_Clicod( )
   {
      return gxTv_Sdtdatos_fin_pdf_Clicod ;
   }

   public void setgxTv_Sdtdatos_fin_pdf_Clicod( int value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Clicod = value ;
   }

   public short getgxTv_Sdtdatos_fin_pdf_Empcod( )
   {
      return gxTv_Sdtdatos_fin_pdf_Empcod ;
   }

   public void setgxTv_Sdtdatos_fin_pdf_Empcod( short value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Empcod = value ;
   }

   public int getgxTv_Sdtdatos_fin_pdf_Liqnro( )
   {
      return gxTv_Sdtdatos_fin_pdf_Liqnro ;
   }

   public void setgxTv_Sdtdatos_fin_pdf_Liqnro( int value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Liqnro = value ;
   }

   public String getgxTv_Sdtdatos_fin_pdf_Liqlote( )
   {
      return gxTv_Sdtdatos_fin_pdf_Liqlote ;
   }

   public void setgxTv_Sdtdatos_fin_pdf_Liqlote( String value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Liqlote = value ;
   }

   public String getgxTv_Sdtdatos_fin_pdf_Tporecibo( )
   {
      return gxTv_Sdtdatos_fin_pdf_Tporecibo ;
   }

   public void setgxTv_Sdtdatos_fin_pdf_Tporecibo( String value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Tporecibo = value ;
   }

   public String getgxTv_Sdtdatos_fin_pdf_Error( )
   {
      return gxTv_Sdtdatos_fin_pdf_Error ;
   }

   public void setgxTv_Sdtdatos_fin_pdf_Error( String value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Error = value ;
   }

   public String getgxTv_Sdtdatos_fin_pdf_Daemonuuid( )
   {
      return gxTv_Sdtdatos_fin_pdf_Daemonuuid ;
   }

   public void setgxTv_Sdtdatos_fin_pdf_Daemonuuid( String value )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Daemonuuid = value ;
   }

   public GXSimpleCollection<Integer> getgxTv_Sdtdatos_fin_pdf_Legnumero( )
   {
      if ( gxTv_Sdtdatos_fin_pdf_Legnumero == null )
      {
         gxTv_Sdtdatos_fin_pdf_Legnumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      }
      gxTv_Sdtdatos_fin_pdf_Legnumero_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      return gxTv_Sdtdatos_fin_pdf_Legnumero ;
   }

   public void setgxTv_Sdtdatos_fin_pdf_Legnumero( GXSimpleCollection<Integer> value )
   {
      gxTv_Sdtdatos_fin_pdf_Legnumero_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_N = (byte)(0) ;
      gxTv_Sdtdatos_fin_pdf_Legnumero = value ;
   }

   public void setgxTv_Sdtdatos_fin_pdf_Legnumero_SetNull( )
   {
      gxTv_Sdtdatos_fin_pdf_Legnumero_N = (byte)(1) ;
      gxTv_Sdtdatos_fin_pdf_Legnumero = null ;
   }

   public boolean getgxTv_Sdtdatos_fin_pdf_Legnumero_IsNull( )
   {
      if ( gxTv_Sdtdatos_fin_pdf_Legnumero == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtdatos_fin_pdf_Legnumero_N( )
   {
      return gxTv_Sdtdatos_fin_pdf_Legnumero_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtdatos_fin_pdf_N = (byte)(1) ;
      gxTv_Sdtdatos_fin_pdf_Liqlote = "" ;
      gxTv_Sdtdatos_fin_pdf_Tporecibo = "" ;
      gxTv_Sdtdatos_fin_pdf_Error = "" ;
      gxTv_Sdtdatos_fin_pdf_Daemonuuid = "" ;
      gxTv_Sdtdatos_fin_pdf_Legnumero_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtdatos_fin_pdf_N ;
   }

   public web.wwpbaseobjects.Sdtdatos_fin_pdf Clone( )
   {
      return (web.wwpbaseobjects.Sdtdatos_fin_pdf)(clone()) ;
   }

   public void setStruct( web.wwpbaseobjects.StructSdtdatos_fin_pdf struct )
   {
      setgxTv_Sdtdatos_fin_pdf_Clicod(struct.getClicod());
      setgxTv_Sdtdatos_fin_pdf_Empcod(struct.getEmpcod());
      setgxTv_Sdtdatos_fin_pdf_Liqnro(struct.getLiqnro());
      setgxTv_Sdtdatos_fin_pdf_Liqlote(struct.getLiqlote());
      setgxTv_Sdtdatos_fin_pdf_Tporecibo(struct.getTporecibo());
      setgxTv_Sdtdatos_fin_pdf_Error(struct.getError());
      setgxTv_Sdtdatos_fin_pdf_Daemonuuid(struct.getDaemonuuid());
      setgxTv_Sdtdatos_fin_pdf_Legnumero(new GXSimpleCollection<Integer>(Integer.class, "internal", "", struct.getLegnumero()));
   }

   @SuppressWarnings("unchecked")
   public web.wwpbaseobjects.StructSdtdatos_fin_pdf getStruct( )
   {
      web.wwpbaseobjects.StructSdtdatos_fin_pdf struct = new web.wwpbaseobjects.StructSdtdatos_fin_pdf ();
      struct.setClicod(getgxTv_Sdtdatos_fin_pdf_Clicod());
      struct.setEmpcod(getgxTv_Sdtdatos_fin_pdf_Empcod());
      struct.setLiqnro(getgxTv_Sdtdatos_fin_pdf_Liqnro());
      struct.setLiqlote(getgxTv_Sdtdatos_fin_pdf_Liqlote());
      struct.setTporecibo(getgxTv_Sdtdatos_fin_pdf_Tporecibo());
      struct.setError(getgxTv_Sdtdatos_fin_pdf_Error());
      struct.setDaemonuuid(getgxTv_Sdtdatos_fin_pdf_Daemonuuid());
      struct.setLegnumero(getgxTv_Sdtdatos_fin_pdf_Legnumero().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtdatos_fin_pdf_N ;
   protected byte gxTv_Sdtdatos_fin_pdf_Legnumero_N ;
   protected short gxTv_Sdtdatos_fin_pdf_Empcod ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtdatos_fin_pdf_Clicod ;
   protected int gxTv_Sdtdatos_fin_pdf_Liqnro ;
   protected String gxTv_Sdtdatos_fin_pdf_Tporecibo ;
   protected String gxTv_Sdtdatos_fin_pdf_Daemonuuid ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtdatos_fin_pdf_Liqlote ;
   protected String gxTv_Sdtdatos_fin_pdf_Error ;
   protected GXSimpleCollection<Integer> gxTv_Sdtdatos_fin_pdf_Legnumero=null ;
}

